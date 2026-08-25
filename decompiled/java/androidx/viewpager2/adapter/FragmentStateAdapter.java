package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.AbstractC0404g0;
import androidx.fragment.app.AbstractC0410j0;
import androidx.fragment.app.AbstractComponentCallbacksC0427s;
import androidx.fragment.app.C0391a;
import androidx.fragment.app.C0422p0;
import androidx.fragment.app.C0439z;
import androidx.fragment.app.Fragment$SavedState;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.EnumC0537n;
import androidx.lifecycle.EnumC0539o;
import androidx.lifecycle.InterfaceC0551u;
import androidx.lifecycle.InterfaceC0555w;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1164m0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import p007a7.C0069f;
import p055ea.AbstractC2460q;
import p138n0.AbstractC3155s0;
import p160p.C3337a;
import p160p.C3342f;
import p160p.C3345i;

public abstract class FragmentStateAdapter extends AbstractC1158k0 implements StatefulAdapter {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    FragmentEventDispatcher mFragmentEventDispatcher;
    final AbstractC0410j0 mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final C3345i mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final C3345i mItemIdToViewHolder;
    final AbstractC0541p mLifecycle;
    private final C3345i mSavedStates;

    public static abstract class DataSetChangeObserver extends AbstractC1164m0 {
        @Override
        public abstract void onChanged();

        @Override
        public final void onItemRangeChanged(int i6, int i10) {
            onChanged();
        }

        @Override
        public final void onItemRangeInserted(int i6, int i10) {
            onChanged();
        }

        @Override
        public final void onItemRangeMoved(int i6, int i10, int i11) {
            onChanged();
        }

        @Override
        public final void onItemRangeRemoved(int i6, int i10) {
            onChanged();
        }

        private DataSetChangeObserver() {
        }

        @Override
        public final void onItemRangeChanged(int i6, int i10, Object obj) {
            onChanged();
        }
    }

    public @interface ExperimentalFragmentStateAdapterApi {
    }

    public static class FragmentEventDispatcher {
        private List<FragmentTransactionCallback> mCallbacks = new CopyOnWriteArrayList();

        public List<FragmentTransactionCallback.OnPostEventListener> dispatchMaxLifecyclePreUpdated(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, EnumC0539o enumC0539o) {
            ArrayList arrayList = new ArrayList();
            Iterator<FragmentTransactionCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().onFragmentMaxLifecyclePreUpdated(abstractComponentCallbacksC0427s, enumC0539o));
            }
            return arrayList;
        }

        public void dispatchPostEvents(List<FragmentTransactionCallback.OnPostEventListener> list) {
            Iterator<FragmentTransactionCallback.OnPostEventListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onPost();
            }
        }

        public List<FragmentTransactionCallback.OnPostEventListener> dispatchPreAdded(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
            ArrayList arrayList = new ArrayList();
            Iterator<FragmentTransactionCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().onFragmentPreAdded(abstractComponentCallbacksC0427s));
            }
            return arrayList;
        }

        public List<FragmentTransactionCallback.OnPostEventListener> dispatchPreRemoved(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
            ArrayList arrayList = new ArrayList();
            Iterator<FragmentTransactionCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().onFragmentPreRemoved(abstractComponentCallbacksC0427s));
            }
            return arrayList;
        }

        public List<FragmentTransactionCallback.OnPostEventListener> dispatchPreSavedInstanceState(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
            ArrayList arrayList = new ArrayList();
            Iterator<FragmentTransactionCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().onFragmentPreSavedInstanceState(abstractComponentCallbacksC0427s));
            }
            return arrayList;
        }

        public void registerCallback(FragmentTransactionCallback fragmentTransactionCallback) {
            this.mCallbacks.add(fragmentTransactionCallback);
        }

        public void unregisterCallback(FragmentTransactionCallback fragmentTransactionCallback) {
            this.mCallbacks.remove(fragmentTransactionCallback);
        }
    }

    public class FragmentMaxLifecycleEnforcer {
        private AbstractC1164m0 mDataObserver;
        private InterfaceC0551u mLifecycleObserver;
        private ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId = -1;
        private ViewPager2 mViewPager;

        public FragmentMaxLifecycleEnforcer() {
        }

        private ViewPager2 inferViewPager(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        public void register(RecyclerView recyclerView) {
            this.mViewPager = inferViewPager(recyclerView);
            ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageScrollStateChanged(int i6) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }

                @Override
                public void onPageSelected(int i6) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mPageChangeCallback = onPageChangeCallback;
            this.mViewPager.registerOnPageChangeCallback(onPageChangeCallback);
            DataSetChangeObserver dataSetChangeObserver = new DataSetChangeObserver() {
                @Override
                public void onChanged() {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(true);
                }
            };
            this.mDataObserver = dataSetChangeObserver;
            FragmentStateAdapter.this.registerAdapterDataObserver(dataSetChangeObserver);
            InterfaceC0551u interfaceC0551u = new InterfaceC0551u() {
                @Override
                public void onStateChanged(InterfaceC0555w interfaceC0555w, EnumC0537n enumC0537n) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mLifecycleObserver = interfaceC0551u;
            FragmentStateAdapter.this.mLifecycle.mo1508a(interfaceC0551u);
        }

        public void unregister(RecyclerView recyclerView) {
            inferViewPager(recyclerView).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.mDataObserver);
            FragmentStateAdapter.this.mLifecycle.mo1510c(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        public void updateFragmentMaxLifecycle(boolean z7) {
            int currentItem;
            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s;
            if (FragmentStateAdapter.this.shouldDelayFragmentTransactions() || this.mViewPager.getScrollState() != 0 || FragmentStateAdapter.this.mFragments.m6803j() == 0 || FragmentStateAdapter.this.getItemCount() == 0 || (currentItem = this.mViewPager.getCurrentItem()) >= FragmentStateAdapter.this.getItemCount()) {
                return;
            }
            long itemId = FragmentStateAdapter.this.getItemId(currentItem);
            if ((itemId != this.mPrimaryItemId || z7) && (abstractComponentCallbacksC0427s = (AbstractComponentCallbacksC0427s) FragmentStateAdapter.this.mFragments.m6797d(itemId)) != null && abstractComponentCallbacksC0427s.m1326o()) {
                this.mPrimaryItemId = itemId;
                AbstractC0410j0 abstractC0410j0 = FragmentStateAdapter.this.mFragmentManager;
                abstractC0410j0.getClass();
                C0391a c0391a = new C0391a(abstractC0410j0);
                ArrayList arrayList = new ArrayList();
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = null;
                for (int i6 = 0; i6 < FragmentStateAdapter.this.mFragments.m6803j(); i6++) {
                    long jM6800g = FragmentStateAdapter.this.mFragments.m6800g(i6);
                    AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s3 = (AbstractComponentCallbacksC0427s) FragmentStateAdapter.this.mFragments.m6804k(i6);
                    if (abstractComponentCallbacksC0427s3.m1326o()) {
                        if (jM6800g != this.mPrimaryItemId) {
                            EnumC0539o enumC0539o = EnumC0539o.f2510d;
                            c0391a.m1195j(abstractComponentCallbacksC0427s3, enumC0539o);
                            arrayList.add(FragmentStateAdapter.this.mFragmentEventDispatcher.dispatchMaxLifecyclePreUpdated(abstractComponentCallbacksC0427s3, enumC0539o));
                        } else {
                            abstractComponentCallbacksC0427s2 = abstractComponentCallbacksC0427s3;
                        }
                        boolean z10 = jM6800g == this.mPrimaryItemId;
                        if (abstractComponentCallbacksC0427s3.f1948C != z10) {
                            abstractComponentCallbacksC0427s3.f1948C = z10;
                        }
                    }
                }
                if (abstractComponentCallbacksC0427s2 != null) {
                    EnumC0539o enumC0539o2 = EnumC0539o.f2511e;
                    c0391a.m1195j(abstractComponentCallbacksC0427s2, enumC0539o2);
                    arrayList.add(FragmentStateAdapter.this.mFragmentEventDispatcher.dispatchMaxLifecyclePreUpdated(abstractComponentCallbacksC0427s2, enumC0539o2));
                }
                if (c0391a.f1801a.isEmpty()) {
                    return;
                }
                if (c0391a.f1807g) {
                    throw new IllegalStateException("This transaction is already being added to the back stack");
                }
                c0391a.f1808h = false;
                c0391a.f1817q.m1260v(c0391a, false);
                Collections.reverse(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    FragmentStateAdapter.this.mFragmentEventDispatcher.dispatchPostEvents((List) it.next());
                }
            }
        }
    }

    public static abstract class FragmentTransactionCallback {
        private static final OnPostEventListener NO_OP = new OnPostEventListener() {
            @Override
            public void onPost() {
            }
        };

        public interface OnPostEventListener {
            void onPost();
        }

        public OnPostEventListener onFragmentMaxLifecyclePreUpdated(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, EnumC0539o enumC0539o) {
            return NO_OP;
        }

        public OnPostEventListener onFragmentPreAdded(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
            return NO_OP;
        }

        public OnPostEventListener onFragmentPreRemoved(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
            return NO_OP;
        }

        @ExperimentalFragmentStateAdapterApi
        public OnPostEventListener onFragmentPreSavedInstanceState(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
            return NO_OP;
        }
    }

    public FragmentStateAdapter(FragmentActivity fragmentActivity) {
        this(fragmentActivity.m1184k(), fragmentActivity.f228d);
    }

    private static String createKey(String str, long j10) {
        return str + j10;
    }

    private void ensureFragment(int i6) {
        Bundle bundle;
        long itemId = getItemId(i6);
        if (this.mFragments.m6799f(itemId) >= 0) {
            return;
        }
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sCreateFragment = createFragment(i6);
        Fragment$SavedState fragment$SavedState = (Fragment$SavedState) this.mSavedStates.m6797d(itemId);
        if (abstractComponentCallbacksC0427sCreateFragment.f1982s != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (fragment$SavedState == null || (bundle = fragment$SavedState.f1764a) == null) {
            bundle = null;
        }
        abstractComponentCallbacksC0427sCreateFragment.f1965b = bundle;
        this.mFragments.m6801h(itemId, abstractComponentCallbacksC0427sCreateFragment);
    }

    private boolean isFragmentViewBound(long j10) {
        View view;
        if (this.mItemIdToViewHolder.m6799f(j10) >= 0) {
            return true;
        }
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = (AbstractComponentCallbacksC0427s) this.mFragments.m6797d(j10);
        return (abstractComponentCallbacksC0427s == null || (view = abstractComponentCallbacksC0427s.f1951F) == null || view.getParent() == null) ? false : true;
    }

    private static boolean isValidKey(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private Long itemForViewHolder(int i6) {
        Long lValueOf = null;
        for (int i10 = 0; i10 < this.mItemIdToViewHolder.m6803j(); i10++) {
            if (((Integer) this.mItemIdToViewHolder.m6804k(i10)).intValue() == i6) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                lValueOf = Long.valueOf(this.mItemIdToViewHolder.m6800g(i10));
            }
        }
        return lValueOf;
    }

    private static long parseIdFromKey(String str, String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void removeFragment(long j10) {
        Bundle bundleM1302o;
        ViewParent parent;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = (AbstractComponentCallbacksC0427s) this.mFragments.m6797d(j10);
        if (abstractComponentCallbacksC0427s == null) {
            return;
        }
        View view = abstractComponentCallbacksC0427s.f1951F;
        if (view != null && (parent = view.getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!containsItem(j10)) {
            this.mSavedStates.m6802i(j10);
        }
        if (!abstractComponentCallbacksC0427s.m1326o()) {
            this.mFragments.m6802i(j10);
            return;
        }
        if (shouldDelayFragmentTransactions()) {
            this.mHasStaleFragments = true;
            return;
        }
        if (abstractComponentCallbacksC0427s.m1326o() && containsItem(j10)) {
            List<FragmentTransactionCallback.OnPostEventListener> listDispatchPreSavedInstanceState = this.mFragmentEventDispatcher.dispatchPreSavedInstanceState(abstractComponentCallbacksC0427s);
            AbstractC0410j0 abstractC0410j0 = this.mFragmentManager;
            abstractC0410j0.getClass();
            C0422p0 c0422p0 = (C0422p0) ((HashMap) abstractC0410j0.f1863c.f55c).get(abstractComponentCallbacksC0427s.f1969f);
            Fragment$SavedState fragment$SavedState = null;
            if (c0422p0 != null) {
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = c0422p0.f1933c;
                if (abstractComponentCallbacksC0427s2.equals(abstractComponentCallbacksC0427s)) {
                    if (abstractComponentCallbacksC0427s2.f1964a > -1 && (bundleM1302o = c0422p0.m1302o()) != null) {
                        fragment$SavedState = new Fragment$SavedState(bundleM1302o);
                    }
                    this.mFragmentEventDispatcher.dispatchPostEvents(listDispatchPreSavedInstanceState);
                    this.mSavedStates.m6801h(j10, fragment$SavedState);
                }
            }
            abstractC0410j0.m1237Y(new IllegalStateException("Fragment " + abstractComponentCallbacksC0427s + " is not currently in the FragmentManager"));
            throw null;
        }
        List<FragmentTransactionCallback.OnPostEventListener> listDispatchPreRemoved = this.mFragmentEventDispatcher.dispatchPreRemoved(abstractComponentCallbacksC0427s);
        try {
            AbstractC0410j0 abstractC0410j1 = this.mFragmentManager;
            abstractC0410j1.getClass();
            C0391a c0391a = new C0391a(abstractC0410j1);
            c0391a.m1193h(abstractComponentCallbacksC0427s);
            if (c0391a.f1807g) {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
            c0391a.f1808h = false;
            c0391a.f1817q.m1260v(c0391a, false);
            this.mFragments.m6802i(j10);
            this.mFragmentEventDispatcher.dispatchPostEvents(listDispatchPreRemoved);
        } catch (Throwable th) {
            this.mFragmentEventDispatcher.dispatchPostEvents(listDispatchPreRemoved);
            throw th;
        }
    }

    private void scheduleGracePeriodEnd() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
                fragmentStateAdapter.mIsInGracePeriod = false;
                fragmentStateAdapter.gcFragments();
            }
        };
        this.mLifecycle.mo1508a(new InterfaceC0551u() {
            @Override
            public void onStateChanged(InterfaceC0555w interfaceC0555w, EnumC0537n enumC0537n) {
                if (enumC0537n == EnumC0537n.ON_DESTROY) {
                    handler.removeCallbacks(runnable);
                    interfaceC0555w.mo360f().mo1510c(this);
                }
            }
        });
        handler.postDelayed(runnable, 10000L);
    }

    private void scheduleViewAttach(final AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, final FrameLayout frameLayout) {
        ((CopyOnWriteArrayList) this.mFragmentManager.f1871k.f196b).add(new C0439z(new AbstractC0404g0() {
            @Override
            public void onFragmentViewCreated(AbstractC0410j0 abstractC0410j0, AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2, View view, Bundle bundle) {
                if (abstractComponentCallbacksC0427s2 == abstractComponentCallbacksC0427s) {
                    C0069f c0069f = abstractC0410j0.f1871k;
                    synchronized (((CopyOnWriteArrayList) c0069f.f196b)) {
                        try {
                            int size = ((CopyOnWriteArrayList) c0069f.f196b).size();
                            for (int i6 = 0; i6 < size; i6++) {
                                if (((C0439z) ((CopyOnWriteArrayList) c0069f.f196b).get(i6)).f2023a == this) {
                                    ((CopyOnWriteArrayList) c0069f.f196b).remove(i6);
                                    break;
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    FragmentStateAdapter.this.addViewToContainer(view, frameLayout);
                }
            }
        }, false));
    }

    public void addViewToContainer(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    public boolean containsItem(long j10) {
        return j10 >= 0 && j10 < ((long) getItemCount());
    }

    public abstract AbstractComponentCallbacksC0427s createFragment(int i6);

    public void gcFragments() {
        if (!this.mHasStaleFragments || shouldDelayFragmentTransactions()) {
            return;
        }
        C3342f c3342f = new C3342f(0);
        for (int i6 = 0; i6 < this.mFragments.m6803j(); i6++) {
            long jM6800g = this.mFragments.m6800g(i6);
            if (!containsItem(jM6800g)) {
                c3342f.add(Long.valueOf(jM6800g));
                this.mItemIdToViewHolder.m6802i(jM6800g);
            }
        }
        if (!this.mIsInGracePeriod) {
            this.mHasStaleFragments = false;
            for (int i10 = 0; i10 < this.mFragments.m6803j(); i10++) {
                long jM6800g2 = this.mFragments.m6800g(i10);
                if (!isFragmentViewBound(jM6800g2)) {
                    c3342f.add(Long.valueOf(jM6800g2));
                }
            }
        }
        C3337a c3337a = new C3337a(c3342f);
        while (c3337a.hasNext()) {
            removeFragment(((Long) c3337a.next()).longValue());
        }
    }

    @Override
    public long getItemId(int i6) {
        return i6;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (this.mFragmentMaxLifecycleEnforcer != null) {
            throw new IllegalArgumentException();
        }
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.mFragmentMaxLifecycleEnforcer = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.register(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.unregister(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    @Override
    public final boolean onFailedToRecycleView(FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    public void placeFragmentInViewHolder(final FragmentViewHolder fragmentViewHolder) {
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = (AbstractComponentCallbacksC0427s) this.mFragments.m6797d(fragmentViewHolder.getItemId());
        if (abstractComponentCallbacksC0427s == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout container = fragmentViewHolder.getContainer();
        View view = abstractComponentCallbacksC0427s.f1951F;
        if (!abstractComponentCallbacksC0427s.m1326o() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (abstractComponentCallbacksC0427s.m1326o() && view == null) {
            scheduleViewAttach(abstractComponentCallbacksC0427s, container);
            return;
        }
        if (abstractComponentCallbacksC0427s.m1326o() && view.getParent() != null) {
            if (view.getParent() != container) {
                addViewToContainer(view, container);
                return;
            }
            return;
        }
        if (abstractComponentCallbacksC0427s.m1326o()) {
            addViewToContainer(view, container);
            return;
        }
        if (shouldDelayFragmentTransactions()) {
            if (this.mFragmentManager.f1854A) {
                return;
            }
            this.mLifecycle.mo1508a(new InterfaceC0551u() {
                @Override
                public void onStateChanged(InterfaceC0555w interfaceC0555w, EnumC0537n enumC0537n) {
                    if (FragmentStateAdapter.this.shouldDelayFragmentTransactions()) {
                        return;
                    }
                    interfaceC0555w.mo360f().mo1510c(this);
                    FrameLayout container2 = fragmentViewHolder.getContainer();
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    if (container2.isAttachedToWindow()) {
                        FragmentStateAdapter.this.placeFragmentInViewHolder(fragmentViewHolder);
                    }
                }
            });
            return;
        }
        scheduleViewAttach(abstractComponentCallbacksC0427s, container);
        List<FragmentTransactionCallback.OnPostEventListener> listDispatchPreAdded = this.mFragmentEventDispatcher.dispatchPreAdded(abstractComponentCallbacksC0427s);
        try {
            if (abstractComponentCallbacksC0427s.f1948C) {
                abstractComponentCallbacksC0427s.f1948C = false;
            }
            AbstractC0410j0 abstractC0410j0 = this.mFragmentManager;
            abstractC0410j0.getClass();
            C0391a c0391a = new C0391a(abstractC0410j0);
            c0391a.m1191f(0, abstractComponentCallbacksC0427s, "f" + fragmentViewHolder.getItemId(), 1);
            c0391a.m1195j(abstractComponentCallbacksC0427s, EnumC0539o.f2510d);
            if (c0391a.f1807g) {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
            c0391a.f1808h = false;
            c0391a.f1817q.m1260v(c0391a, false);
            this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
            this.mFragmentEventDispatcher.dispatchPostEvents(listDispatchPreAdded);
        } catch (Throwable th) {
            this.mFragmentEventDispatcher.dispatchPostEvents(listDispatchPreAdded);
            throw th;
        }
    }

    public void registerFragmentTransactionCallback(FragmentTransactionCallback fragmentTransactionCallback) {
        this.mFragmentEventDispatcher.registerCallback(fragmentTransactionCallback);
    }

    @Override
    public final void restoreState(Parcelable parcelable) {
        if (this.mSavedStates.m6803j() != 0 || this.mFragments.m6803j() != 0) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (isValidKey(str, KEY_PREFIX_FRAGMENT)) {
                long idFromKey = parseIdFromKey(str, KEY_PREFIX_FRAGMENT);
                AbstractC0410j0 abstractC0410j0 = this.mFragmentManager;
                abstractC0410j0.getClass();
                String string = bundle.getString(str);
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = null;
                if (string != null) {
                    AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM133l = abstractC0410j0.f1863c.m133l(string);
                    if (abstractComponentCallbacksC0427sM133l == null) {
                        abstractC0410j0.m1237Y(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
                        throw null;
                    }
                    abstractComponentCallbacksC0427s = abstractComponentCallbacksC0427sM133l;
                }
                this.mFragments.m6801h(idFromKey, abstractComponentCallbacksC0427s);
            } else {
                if (!isValidKey(str, KEY_PREFIX_STATE)) {
                    throw new IllegalArgumentException(AbstractC2460q.m5501o("Unexpected key in savedState: ", str));
                }
                long idFromKey2 = parseIdFromKey(str, KEY_PREFIX_STATE);
                Fragment$SavedState fragment$SavedState = (Fragment$SavedState) bundle.getParcelable(str);
                if (containsItem(idFromKey2)) {
                    this.mSavedStates.m6801h(idFromKey2, fragment$SavedState);
                }
            }
        }
        if (this.mFragments.m6803j() == 0) {
            return;
        }
        this.mHasStaleFragments = true;
        this.mIsInGracePeriod = true;
        gcFragments();
        scheduleGracePeriodEnd();
    }

    @Override
    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.mSavedStates.m6803j() + this.mFragments.m6803j());
        for (int i6 = 0; i6 < this.mFragments.m6803j(); i6++) {
            long jM6800g = this.mFragments.m6800g(i6);
            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = (AbstractComponentCallbacksC0427s) this.mFragments.m6797d(jM6800g);
            if (abstractComponentCallbacksC0427s != null && abstractComponentCallbacksC0427s.m1326o()) {
                String strCreateKey = createKey(KEY_PREFIX_FRAGMENT, jM6800g);
                AbstractC0410j0 abstractC0410j0 = this.mFragmentManager;
                abstractC0410j0.getClass();
                if (abstractComponentCallbacksC0427s.f1982s != abstractC0410j0) {
                    abstractC0410j0.m1237Y(new IllegalStateException("Fragment " + abstractComponentCallbacksC0427s + " is not currently in the FragmentManager"));
                    throw null;
                }
                bundle.putString(strCreateKey, abstractComponentCallbacksC0427s.f1969f);
            }
        }
        for (int i10 = 0; i10 < this.mSavedStates.m6803j(); i10++) {
            long jM6800g2 = this.mSavedStates.m6800g(i10);
            if (containsItem(jM6800g2)) {
                bundle.putParcelable(createKey(KEY_PREFIX_STATE, jM6800g2), (Parcelable) this.mSavedStates.m6797d(jM6800g2));
            }
        }
        return bundle;
    }

    @Override
    public final void setHasStableIds(boolean z7) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.m1222I();
    }

    public void unregisterFragmentTransactionCallback(FragmentTransactionCallback fragmentTransactionCallback) {
        this.mFragmentEventDispatcher.unregisterCallback(fragmentTransactionCallback);
    }

    public FragmentStateAdapter(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        this(abstractComponentCallbacksC0427s.m1320i(), abstractComponentCallbacksC0427s.f1958M);
    }

    @Override
    public final void onBindViewHolder(FragmentViewHolder fragmentViewHolder, int i6) {
        long itemId = fragmentViewHolder.getItemId();
        int id = fragmentViewHolder.getContainer().getId();
        Long lItemForViewHolder = itemForViewHolder(id);
        if (lItemForViewHolder != null && lItemForViewHolder.longValue() != itemId) {
            removeFragment(lItemForViewHolder.longValue());
            this.mItemIdToViewHolder.m6802i(lItemForViewHolder.longValue());
        }
        this.mItemIdToViewHolder.m6801h(itemId, Integer.valueOf(id));
        ensureFragment(i6);
        FrameLayout container = fragmentViewHolder.getContainer();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (container.isAttachedToWindow()) {
            placeFragmentInViewHolder(fragmentViewHolder);
        }
        gcFragments();
    }

    @Override
    public final FragmentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i6) {
        return FragmentViewHolder.create(viewGroup);
    }

    @Override
    public final void onViewAttachedToWindow(FragmentViewHolder fragmentViewHolder) {
        placeFragmentInViewHolder(fragmentViewHolder);
        gcFragments();
    }

    @Override
    public final void onViewRecycled(FragmentViewHolder fragmentViewHolder) {
        Long lItemForViewHolder = itemForViewHolder(fragmentViewHolder.getContainer().getId());
        if (lItemForViewHolder != null) {
            removeFragment(lItemForViewHolder.longValue());
            this.mItemIdToViewHolder.m6802i(lItemForViewHolder.longValue());
        }
    }

    public FragmentStateAdapter(AbstractC0410j0 abstractC0410j0, AbstractC0541p abstractC0541p) {
        this.mFragments = new C3345i();
        this.mSavedStates = new C3345i();
        this.mItemIdToViewHolder = new C3345i();
        this.mFragmentEventDispatcher = new FragmentEventDispatcher();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = abstractC0410j0;
        this.mLifecycle = abstractC0541p;
        super.setHasStableIds(true);
    }
}
