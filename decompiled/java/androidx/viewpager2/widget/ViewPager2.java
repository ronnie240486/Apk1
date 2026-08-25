package androidx.viewpager2.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1164m0;
import androidx.recyclerview.widget.AbstractC1182s0;
import androidx.recyclerview.widget.AbstractC1185t0;
import androidx.recyclerview.widget.AbstractC1197x0;
import androidx.recyclerview.widget.C1140e1;
import androidx.recyclerview.widget.C1143f0;
import androidx.recyclerview.widget.C1162l1;
import androidx.recyclerview.widget.InterfaceC1200y0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.C1206R;
import androidx.viewpager2.adapter.StatefulAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;
import p101j7.C2782c;
import p138n0.AbstractC3155s0;
import p148o0.AbstractC3236k;
import p148o0.C3228c;
import p148o0.C3232g;
import p148o0.C3233h;
import p148o0.InterfaceC3244s;

public final class ViewPager2 extends ViewGroup {
    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static boolean sFeatureEnhancedA11yEnabled = true;
    AccessibilityProvider mAccessibilityProvider;
    int mCurrentItem;
    private AbstractC1164m0 mCurrentItemDataSetChangeObserver;
    boolean mCurrentItemDirty;
    private CompositeOnPageChangeCallback mExternalPageChangeCallbacks;
    private FakeDrag mFakeDragger;
    LinearLayoutManager mLayoutManager;
    private int mOffscreenPageLimit;
    private CompositeOnPageChangeCallback mPageChangeEventDispatcher;
    private PageTransformerAdapter mPageTransformerAdapter;
    private C1143f0 mPagerSnapHelper;
    private Parcelable mPendingAdapterState;
    private int mPendingCurrentItem;
    RecyclerView mRecyclerView;
    private AbstractC1182s0 mSavedItemAnimator;
    private boolean mSavedItemAnimatorPresent;
    ScrollEventAdapter mScrollEventAdapter;
    private final Rect mTmpChildRect;
    private final Rect mTmpContainerRect;
    private boolean mUserInputEnabled;

    public class BasicAccessibilityProvider extends AccessibilityProvider {
        public BasicAccessibilityProvider() {
            super();
        }

        @Override
        public boolean handlesLmPerformAccessibilityAction(int i6) {
            return (i6 == 8192 || i6 == 4096) && !ViewPager2.this.isUserInputEnabled();
        }

        @Override
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        @Override
        public void onLmInitializeAccessibilityNodeInfo(C3233h c3233h) {
            if (ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            C3228c c3228c = C3228c.f10845i;
            c3233h.getClass();
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = (AccessibilityNodeInfo.AccessibilityAction) c3228c.f10856a;
            AccessibilityNodeInfo accessibilityNodeInfo = c3233h.f10862a;
            accessibilityNodeInfo.removeAction(accessibilityAction);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) C3228c.f10844h.f10856a);
            c3233h.m6552n(false);
        }

        @Override
        public boolean onLmPerformAccessibilityAction(int i6) {
            if (handlesLmPerformAccessibilityAction(i6)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override
        public CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

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

    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        public LinearLayoutManagerImpl(Context context) {
            super(1);
        }

        @Override
        public void calculateExtraLayoutSpace(C1162l1 c1162l1, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(c1162l1, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override
        public void onInitializeAccessibilityNodeInfo(C1140e1 c1140e1, C1162l1 c1162l1, C3233h c3233h) {
            super.onInitializeAccessibilityNodeInfo(c1140e1, c1162l1, c3233h);
            ViewPager2.this.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfo(c3233h);
        }

        @Override
        public void onInitializeAccessibilityNodeInfoForItem(C1140e1 c1140e1, C1162l1 c1162l1, View view, C3233h c3233h) {
            ViewPager2.this.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfoForItem(view, c3233h);
        }

        @Override
        public boolean performAccessibilityAction(C1140e1 c1140e1, C1162l1 c1162l1, int i6, Bundle bundle) {
            return ViewPager2.this.mAccessibilityProvider.handlesLmPerformAccessibilityAction(i6) ? ViewPager2.this.mAccessibilityProvider.onLmPerformAccessibilityAction(i6) : super.performAccessibilityAction(c1140e1, c1162l1, i6, bundle);
        }

        @Override
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z7, boolean z10) {
            return false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OffscreenPageLimit {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public class PageAwareAccessibilityProvider extends AccessibilityProvider {
        private final InterfaceC3244s mActionPageBackward;
        private final InterfaceC3244s mActionPageForward;
        private AbstractC1164m0 mAdapterDataObserver;

        public PageAwareAccessibilityProvider() {
            super();
            this.mActionPageForward = new InterfaceC3244s() {
                @Override
                public boolean perform(View view, AbstractC3236k abstractC3236k) {
                    PageAwareAccessibilityProvider.this.setCurrentItemFromAccessibilityCommand(((ViewPager2) view).getCurrentItem() + 1);
                    return true;
                }
            };
            this.mActionPageBackward = new InterfaceC3244s() {
                @Override
                public boolean perform(View view, AbstractC3236k abstractC3236k) {
                    PageAwareAccessibilityProvider.this.setCurrentItemFromAccessibilityCommand(((ViewPager2) view).getCurrentItem() - 1);
                    return true;
                }
            };
        }

        private void addCollectionInfo(C3233h c3233h) {
            int itemCount;
            int itemCount2;
            if (ViewPager2.this.getAdapter() != null) {
                itemCount2 = 1;
                if (ViewPager2.this.getOrientation() == 1) {
                    itemCount2 = ViewPager2.this.getAdapter().getItemCount();
                    itemCount = 1;
                } else {
                    itemCount = ViewPager2.this.getAdapter().getItemCount();
                }
            } else {
                itemCount = 0;
                itemCount2 = 0;
            }
            c3233h.m6548j(C2782c.m5751x(itemCount2, itemCount, 0, false));
        }

        private void addCollectionItemInfo(View view, C3233h c3233h) {
            c3233h.m6549k(C3232g.m6538a(ViewPager2.this.getOrientation() == 1 ? ViewPager2.this.mLayoutManager.getPosition(view) : 0, 1, ViewPager2.this.getOrientation() == 0 ? ViewPager2.this.mLayoutManager.getPosition(view) : 0, 1, false));
        }

        private void addScrollActions(C3233h c3233h) {
            int itemCount;
            AbstractC1158k0 adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            if (ViewPager2.this.mCurrentItem > 0) {
                c3233h.m6540a(8192);
            }
            if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                c3233h.m6540a(4096);
            }
            c3233h.m6552n(true);
        }

        @Override
        public boolean handlesGetAccessibilityClassName() {
            return true;
        }

        @Override
        public boolean handlesPerformAccessibilityAction(int i6, Bundle bundle) {
            return i6 == 8192 || i6 == 4096;
        }

        @Override
        public void onAttachAdapter(AbstractC1158k0 abstractC1158k0) {
            updatePageAccessibilityActions();
            if (abstractC1158k0 != null) {
                abstractC1158k0.registerAdapterDataObserver(this.mAdapterDataObserver);
            }
        }

        @Override
        public void onDetachAdapter(AbstractC1158k0 abstractC1158k0) {
            if (abstractC1158k0 != null) {
                abstractC1158k0.unregisterAdapterDataObserver(this.mAdapterDataObserver);
            }
        }

        @Override
        public String onGetAccessibilityClassName() {
            if (handlesGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override
        public void onInitialize(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            recyclerView.setImportantForAccessibility(2);
            this.mAdapterDataObserver = new DataSetChangeObserver() {
                @Override
                public void onChanged() {
                    PageAwareAccessibilityProvider.this.updatePageAccessibilityActions();
                }
            };
            if (ViewPager2.this.getImportantForAccessibility() == 0) {
                ViewPager2.this.setImportantForAccessibility(1);
            }
        }

        @Override
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            C3233h c3233h = new C3233h(accessibilityNodeInfo);
            addCollectionInfo(c3233h);
            addScrollActions(c3233h);
        }

        @Override
        public void onLmInitializeAccessibilityNodeInfoForItem(View view, C3233h c3233h) {
            addCollectionItemInfo(view, c3233h);
        }

        @Override
        public boolean onPerformAccessibilityAction(int i6, Bundle bundle) {
            if (!handlesPerformAccessibilityAction(i6, bundle)) {
                throw new IllegalStateException();
            }
            setCurrentItemFromAccessibilityCommand(i6 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override
        public void onRestorePendingState() {
            updatePageAccessibilityActions();
        }

        @Override
        public void onRvInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(onGetAccessibilityClassName());
        }

        @Override
        public void onSetLayoutDirection() {
            updatePageAccessibilityActions();
        }

        @Override
        public void onSetNewCurrentItem() {
            updatePageAccessibilityActions();
        }

        @Override
        public void onSetOrientation() {
            updatePageAccessibilityActions();
        }

        @Override
        public void onSetUserInputEnabled() {
            updatePageAccessibilityActions();
        }

        public void setCurrentItemFromAccessibilityCommand(int i6) {
            if (ViewPager2.this.isUserInputEnabled()) {
                ViewPager2.this.setCurrentItemInternal(i6, true);
            }
        }

        public void updatePageAccessibilityActions() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i6 = R.id.accessibilityActionPageLeft;
            AbstractC3155s0.m6343m(R.id.accessibilityActionPageLeft, viewPager2);
            AbstractC3155s0.m6344n(R.id.accessibilityActionPageRight, viewPager2);
            AbstractC3155s0.m6338h(0, viewPager2);
            AbstractC3155s0.m6344n(R.id.accessibilityActionPageUp, viewPager2);
            AbstractC3155s0.m6338h(0, viewPager2);
            AbstractC3155s0.m6344n(R.id.accessibilityActionPageDown, viewPager2);
            AbstractC3155s0.m6338h(0, viewPager2);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                    AbstractC3155s0.m6345o(viewPager2, new C3228c(R.id.accessibilityActionPageDown), this.mActionPageForward);
                }
                if (ViewPager2.this.mCurrentItem > 0) {
                    AbstractC3155s0.m6345o(viewPager2, new C3228c(R.id.accessibilityActionPageUp), this.mActionPageBackward);
                    return;
                }
                return;
            }
            boolean zIsRtl = ViewPager2.this.isRtl();
            int i10 = zIsRtl ? R.id.accessibilityActionPageLeft : R.id.accessibilityActionPageRight;
            if (zIsRtl) {
                i6 = R.id.accessibilityActionPageRight;
            }
            if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                AbstractC3155s0.m6345o(viewPager2, new C3228c(i10), this.mActionPageForward);
            }
            if (ViewPager2.this.mCurrentItem > 0) {
                AbstractC3155s0.m6345o(viewPager2, new C3228c(i6), this.mActionPageBackward);
            }
        }
    }

    public interface PageTransformer {
        void transformPage(View view, float f);
    }

    public class PagerSnapHelperImpl extends C1143f0 {
        public PagerSnapHelperImpl() {
        }

        @Override
        public View findSnapView(AbstractC1197x0 abstractC1197x0) {
            if (ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(abstractC1197x0);
        }
    }

    public class RecyclerViewImpl extends RecyclerView {
        public RecyclerViewImpl(Context context) {
            super(context);
        }

        @Override
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.mAccessibilityProvider.handlesRvGetAccessibilityClassName() ? ViewPager2.this.mAccessibilityProvider.onRvGetAccessibilityClassName() : super.getAccessibilityClassName();
        }

        @Override
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.mCurrentItem);
            accessibilityEvent.setToIndex(ViewPager2.this.mCurrentItem);
            ViewPager2.this.mAccessibilityProvider.onRvInitializeAccessibilityEvent(accessibilityEvent);
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    public static class SmoothScrollToPosition implements Runnable {
        private final int mPosition;
        private final RecyclerView mRecyclerView;

        public SmoothScrollToPosition(int i6, RecyclerView recyclerView) {
            this.mPosition = i6;
            this.mRecyclerView = recyclerView;
        }

        @Override
        public void run() {
            this.mRecyclerView.smoothScrollToPosition(this.mPosition);
        }
    }

    public ViewPager2(Context context) {
        super(context);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new DataSetChangeObserver() {
            @Override
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.mCurrentItemDirty = true;
                viewPager2.mScrollEventAdapter.notifyDataSetChangeHappened();
            }
        };
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(context, null);
    }

    private InterfaceC1200y0 enforceChildFillListener() {
        return new InterfaceC1200y0() {
            @Override
            public void onChildViewAttachedToWindow(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
            }
        };
    }

    private void initialize(Context context, AttributeSet attributeSet) {
        this.mAccessibilityProvider = sFeatureEnhancedA11yEnabled ? new PageAwareAccessibilityProvider() : new BasicAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.mRecyclerView = recyclerViewImpl;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        recyclerViewImpl.setId(View.generateViewId());
        this.mRecyclerView.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.mLayoutManager = linearLayoutManagerImpl;
        this.mRecyclerView.setLayoutManager(linearLayoutManagerImpl);
        this.mRecyclerView.setScrollingTouchSlop(1);
        setOrientation(context, attributeSet);
        this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRecyclerView.addOnChildAttachStateChangeListener(enforceChildFillListener());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.mScrollEventAdapter = scrollEventAdapter;
        this.mFakeDragger = new FakeDrag(this, scrollEventAdapter, this.mRecyclerView);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.mPagerSnapHelper = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.mPageChangeEventDispatcher = compositeOnPageChangeCallback;
        this.mScrollEventAdapter.setOnPageChangeCallback(compositeOnPageChangeCallback);
        OnPageChangeCallback onPageChangeCallback = new OnPageChangeCallback() {
            @Override
            public void onPageScrollStateChanged(int i6) {
                if (i6 == 0) {
                    ViewPager2.this.updateCurrentItem();
                }
            }

            @Override
            public void onPageSelected(int i6) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.mCurrentItem != i6) {
                    viewPager2.mCurrentItem = i6;
                    viewPager2.mAccessibilityProvider.onSetNewCurrentItem();
                }
            }
        };
        OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback() {
            @Override
            public void onPageSelected(int i6) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.mRecyclerView.requestFocus(2);
                }
            }
        };
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(onPageChangeCallback);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(onPageChangeCallback2);
        this.mAccessibilityProvider.onInitialize(this.mPageChangeEventDispatcher, this.mRecyclerView);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(this.mExternalPageChangeCallbacks);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.mLayoutManager);
        this.mPageTransformerAdapter = pageTransformerAdapter;
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(pageTransformerAdapter);
        RecyclerView recyclerView = this.mRecyclerView;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void registerCurrentItemDataSetTracker(AbstractC1158k0 abstractC1158k0) {
        if (abstractC1158k0 != null) {
            abstractC1158k0.registerAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    private void restorePendingState() {
        AbstractC1158k0 adapter;
        if (this.mPendingCurrentItem == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.mPendingAdapterState;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).restoreState(parcelable);
            }
            this.mPendingAdapterState = null;
        }
        int iMax = Math.max(0, Math.min(this.mPendingCurrentItem, adapter.getItemCount() - 1));
        this.mCurrentItem = iMax;
        this.mPendingCurrentItem = -1;
        this.mRecyclerView.scrollToPosition(iMax);
        this.mAccessibilityProvider.onRestorePendingState();
    }

    private void setOrientation(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1206R.styleable.ViewPager2);
        AbstractC3155s0.m6346p(this, context, C1206R.styleable.ViewPager2, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(C1206R.styleable.ViewPager2_android_orientation, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void unregisterCurrentItemDataSetTracker(AbstractC1158k0 abstractC1158k0) {
        if (abstractC1158k0 != null) {
            abstractC1158k0.unregisterAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    public void addItemDecoration(AbstractC1185t0 abstractC1185t0) {
        this.mRecyclerView.addItemDecoration(abstractC1185t0);
    }

    public boolean beginFakeDrag() {
        return this.mFakeDragger.beginFakeDrag();
    }

    @Override
    public boolean canScrollHorizontally(int i6) {
        return this.mRecyclerView.canScrollHorizontally(i6);
    }

    @Override
    public boolean canScrollVertically(int i6) {
        return this.mRecyclerView.canScrollVertically(i6);
    }

    @Override
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i6 = ((SavedState) parcelable).mRecyclerViewId;
            sparseArray.put(this.mRecyclerView.getId(), sparseArray.get(i6));
            sparseArray.remove(i6);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        restorePendingState();
    }

    public boolean endFakeDrag() {
        return this.mFakeDragger.endFakeDrag();
    }

    public boolean fakeDragBy(@SuppressLint({"SupportAnnotationUsage"}) float f) {
        return this.mFakeDragger.fakeDragBy(f);
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return this.mAccessibilityProvider.handlesGetAccessibilityClassName() ? this.mAccessibilityProvider.onGetAccessibilityClassName() : super.getAccessibilityClassName();
    }

    public AbstractC1158k0 getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    public AbstractC1185t0 getItemDecorationAt(int i6) {
        return this.mRecyclerView.getItemDecorationAt(i6);
    }

    public int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getOrientation() {
        return this.mLayoutManager.getOrientation() == 1 ? 1 : 0;
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.mRecyclerView;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.mScrollEventAdapter.getScrollState();
    }

    public void invalidateItemDecorations() {
        this.mRecyclerView.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragger.isFakeDragging();
    }

    public boolean isRtl() {
        return this.mLayoutManager.getLayoutDirection() == 1;
    }

    public boolean isUserInputEnabled() {
        return this.mUserInputEnabled;
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.mAccessibilityProvider.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    @Override
    public void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        this.mTmpContainerRect.left = getPaddingLeft();
        this.mTmpContainerRect.right = (i11 - i6) - getPaddingRight();
        this.mTmpContainerRect.top = getPaddingTop();
        this.mTmpContainerRect.bottom = (i12 - i10) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.mTmpContainerRect, this.mTmpChildRect);
        RecyclerView recyclerView = this.mRecyclerView;
        Rect rect = this.mTmpChildRect;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.mCurrentItemDirty) {
            updateCurrentItem();
        }
    }

    @Override
    public void onMeasure(int i6, int i10) {
        measureChild(this.mRecyclerView, i6, i10);
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        int measuredState = this.mRecyclerView.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + measuredHeight;
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i6, measuredState), View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i10, measuredState << 16));
    }

    @Override
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mPendingCurrentItem = savedState.mCurrentItem;
        this.mPendingAdapterState = savedState.mAdapterState;
    }

    @Override
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mRecyclerViewId = this.mRecyclerView.getId();
        int i6 = this.mPendingCurrentItem;
        if (i6 == -1) {
            i6 = this.mCurrentItem;
        }
        savedState.mCurrentItem = i6;
        Parcelable parcelable = this.mPendingAdapterState;
        if (parcelable != null) {
            savedState.mAdapterState = parcelable;
        } else {
            Object adapter = this.mRecyclerView.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.mAdapterState = ((StatefulAdapter) adapter).saveState();
            }
        }
        return savedState;
    }

    @Override
    public void onViewAdded(View view) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    @Override
    public boolean performAccessibilityAction(int i6, Bundle bundle) {
        return this.mAccessibilityProvider.handlesPerformAccessibilityAction(i6, bundle) ? this.mAccessibilityProvider.onPerformAccessibilityAction(i6, bundle) : super.performAccessibilityAction(i6, bundle);
    }

    public void registerOnPageChangeCallback(OnPageChangeCallback onPageChangeCallback) {
        this.mExternalPageChangeCallbacks.addOnPageChangeCallback(onPageChangeCallback);
    }

    public void removeItemDecoration(AbstractC1185t0 abstractC1185t0) {
        this.mRecyclerView.removeItemDecoration(abstractC1185t0);
    }

    public void removeItemDecorationAt(int i6) {
        this.mRecyclerView.removeItemDecorationAt(i6);
    }

    public void requestTransform() {
        if (this.mPageTransformerAdapter.getPageTransformer() == null) {
            return;
        }
        double relativeScrollPosition = this.mScrollEventAdapter.getRelativeScrollPosition();
        int i6 = (int) relativeScrollPosition;
        float f = (float) (relativeScrollPosition - ((double) i6));
        this.mPageTransformerAdapter.onPageScrolled(i6, f, Math.round(getPageSize() * f));
    }

    public void setAdapter(AbstractC1158k0 abstractC1158k0) {
        AbstractC1158k0 adapter = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.onDetachAdapter(adapter);
        unregisterCurrentItemDataSetTracker(adapter);
        this.mRecyclerView.setAdapter(abstractC1158k0);
        this.mCurrentItem = 0;
        restorePendingState();
        this.mAccessibilityProvider.onAttachAdapter(abstractC1158k0);
        registerCurrentItemDataSetTracker(abstractC1158k0);
    }

    public void setCurrentItem(int i6) {
        setCurrentItem(i6, true);
    }

    public void setCurrentItemInternal(int i6, boolean z7) {
        AbstractC1158k0 adapter = getAdapter();
        if (adapter == null) {
            if (this.mPendingCurrentItem != -1) {
                this.mPendingCurrentItem = Math.max(i6, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i6, 0), adapter.getItemCount() - 1);
        if (iMin == this.mCurrentItem && this.mScrollEventAdapter.isIdle()) {
            return;
        }
        int i10 = this.mCurrentItem;
        if (iMin == i10 && z7) {
            return;
        }
        double relativeScrollPosition = i10;
        this.mCurrentItem = iMin;
        this.mAccessibilityProvider.onSetNewCurrentItem();
        if (!this.mScrollEventAdapter.isIdle()) {
            relativeScrollPosition = this.mScrollEventAdapter.getRelativeScrollPosition();
        }
        this.mScrollEventAdapter.notifyProgrammaticScroll(iMin, z7);
        if (!z7) {
            this.mRecyclerView.scrollToPosition(iMin);
            return;
        }
        double d = iMin;
        if (Math.abs(d - relativeScrollPosition) <= 3.0d) {
            this.mRecyclerView.smoothScrollToPosition(iMin);
            return;
        }
        this.mRecyclerView.scrollToPosition(d > relativeScrollPosition ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.mRecyclerView;
        recyclerView.post(new SmoothScrollToPosition(iMin, recyclerView));
    }

    @Override
    public void setLayoutDirection(int i6) {
        super.setLayoutDirection(i6);
        this.mAccessibilityProvider.onSetLayoutDirection();
    }

    public void setOffscreenPageLimit(int i6) {
        if (i6 < 1 && i6 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.mOffscreenPageLimit = i6;
        this.mRecyclerView.requestLayout();
    }

    public void setPageTransformer(PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.mSavedItemAnimatorPresent) {
                this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
                this.mSavedItemAnimatorPresent = true;
            }
            this.mRecyclerView.setItemAnimator(null);
        } else if (this.mSavedItemAnimatorPresent) {
            this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
            this.mSavedItemAnimator = null;
            this.mSavedItemAnimatorPresent = false;
        }
        if (pageTransformer == this.mPageTransformerAdapter.getPageTransformer()) {
            return;
        }
        this.mPageTransformerAdapter.setPageTransformer(pageTransformer);
        requestTransform();
    }

    public void setUserInputEnabled(boolean z7) {
        this.mUserInputEnabled = z7;
        this.mAccessibilityProvider.onSetUserInputEnabled();
    }

    public void snapToPage() {
        View viewFindSnapView = this.mPagerSnapHelper.findSnapView(this.mLayoutManager);
        if (viewFindSnapView == null) {
            return;
        }
        int[] iArrCalculateDistanceToFinalSnap = this.mPagerSnapHelper.calculateDistanceToFinalSnap(this.mLayoutManager, viewFindSnapView);
        int i6 = iArrCalculateDistanceToFinalSnap[0];
        if (i6 == 0 && iArrCalculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.mRecyclerView.smoothScrollBy(i6, iArrCalculateDistanceToFinalSnap[1]);
    }

    public void unregisterOnPageChangeCallback(OnPageChangeCallback onPageChangeCallback) {
        this.mExternalPageChangeCallbacks.removeOnPageChangeCallback(onPageChangeCallback);
    }

    public void updateCurrentItem() {
        C1143f0 c1143f0 = this.mPagerSnapHelper;
        if (c1143f0 == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewFindSnapView = c1143f0.findSnapView(this.mLayoutManager);
        if (viewFindSnapView == null) {
            return;
        }
        int position = this.mLayoutManager.getPosition(viewFindSnapView);
        if (position != this.mCurrentItem && getScrollState() == 0) {
            this.mPageChangeEventDispatcher.onPageSelected(position);
        }
        this.mCurrentItemDirty = false;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            @Override
            public SavedState[] newArray(int i6) {
                return new SavedState[i6];
            }

            @Override
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return new SavedState(parcel, classLoader);
                }
                return new SavedState(parcel);
            }

            @Override
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }
        };
        Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        @SuppressLint({"ClassVerificationFailure"})
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            readValues(parcel, classLoader);
        }

        private void readValues(Parcel parcel, ClassLoader classLoader) {
            this.mRecyclerViewId = parcel.readInt();
            this.mCurrentItem = parcel.readInt();
            this.mAdapterState = parcel.readParcelable(classLoader);
        }

        @Override
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.mRecyclerViewId);
            parcel.writeInt(this.mCurrentItem);
            parcel.writeParcelable(this.mAdapterState, i6);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            readValues(parcel, null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void addItemDecoration(AbstractC1185t0 abstractC1185t0, int i6) {
        this.mRecyclerView.addItemDecoration(abstractC1185t0, i6);
    }

    public void setCurrentItem(int i6, boolean z7) {
        if (isFakeDragging()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        setCurrentItemInternal(i6, z7);
    }

    public void setOrientation(int i6) {
        this.mLayoutManager.setOrientation(i6);
        this.mAccessibilityProvider.onSetOrientation();
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new DataSetChangeObserver() {
            @Override
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.mCurrentItemDirty = true;
                viewPager2.mScrollEventAdapter.notifyDataSetChangeHappened();
            }
        };
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(context, attributeSet);
    }

    public abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        public boolean handlesGetAccessibilityClassName() {
            return false;
        }

        public boolean handlesLmPerformAccessibilityAction(int i6) {
            return false;
        }

        public boolean handlesPerformAccessibilityAction(int i6, Bundle bundle) {
            return false;
        }

        public boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        public String onGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean onLmPerformAccessibilityAction(int i6) {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean onPerformAccessibilityAction(int i6, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        public CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        public void onRestorePendingState() {
        }

        public void onSetLayoutDirection() {
        }

        public void onSetNewCurrentItem() {
        }

        public void onSetOrientation() {
        }

        public void onSetUserInputEnabled() {
        }

        public void onAttachAdapter(AbstractC1158k0 abstractC1158k0) {
        }

        public void onDetachAdapter(AbstractC1158k0 abstractC1158k0) {
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void onLmInitializeAccessibilityNodeInfo(C3233h c3233h) {
        }

        public void onRvInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        }

        public void onInitialize(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
        }

        public void onLmInitializeAccessibilityNodeInfoForItem(View view, C3233h c3233h) {
        }
    }

    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i6) {
        }

        public void onPageSelected(int i6) {
        }

        public void onPageScrolled(int i6, float f, int i10) {
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new DataSetChangeObserver() {
            @Override
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.mCurrentItemDirty = true;
                viewPager2.mScrollEventAdapter.notifyDataSetChangeHappened();
            }
        };
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(context, attributeSet);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public ViewPager2(Context context, AttributeSet attributeSet, int i6, int i10) {
        super(context, attributeSet, i6, i10);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new DataSetChangeObserver() {
            @Override
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.mCurrentItemDirty = true;
                viewPager2.mScrollEventAdapter.notifyDataSetChangeHappened();
            }
        };
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(context, attributeSet);
    }
}
