package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.C0456d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import p000a.AbstractC0004e;
import p123l5.AbstractC2973a;
import p138n0.AbstractC3155s0;
import p138n0.C3100a;
import p138n0.C3103b;

public final class C1140e1 {

    public final ArrayList f3549a;

    public ArrayList f3550b;

    public final ArrayList f3551c;

    public final List f3552d;

    public int f3553e;

    public int f3554f;

    public C1136d1 f3555g;

    public final RecyclerView f3556h;

    public C1140e1(RecyclerView recyclerView) {
        this.f3556h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f3549a = arrayList;
        this.f3550b = null;
        this.f3551c = new ArrayList();
        this.f3552d = Collections.unmodifiableList(arrayList);
        this.f3553e = 2;
        this.f3554f = 2;
    }

    public static void m2924d(ViewGroup viewGroup, boolean z7) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                m2924d((ViewGroup) childAt, true);
            }
        }
        if (z7) {
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
            } else {
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }
    }

    public final void m2925a(AbstractC1174p1 abstractC1174p1, boolean z7) {
        RecyclerView.clearNestedRecyclerViewIfNotNested(abstractC1174p1);
        View view = abstractC1174p1.itemView;
        RecyclerView recyclerView = this.f3556h;
        C1180r1 c1180r1 = recyclerView.mAccessibilityDelegate;
        if (c1180r1 != null) {
            C1177q1 c1177q1 = c1180r1.f3681e;
            AbstractC3155s0.m6347q(view, c1177q1 instanceof C1177q1 ? (C3103b) c1177q1.f3673e.remove(view) : null);
        }
        if (z7) {
            InterfaceC1144f1 interfaceC1144f1 = recyclerView.mRecyclerListener;
            if (interfaceC1144f1 != null) {
                ((C0456d) interfaceC1144f1).m1421a(abstractC1174p1);
            }
            int size = recyclerView.mRecyclerListeners.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((C0456d) recyclerView.mRecyclerListeners.get(i6)).m1421a(abstractC1174p1);
            }
            AbstractC1158k0 abstractC1158k0 = recyclerView.mAdapter;
            if (abstractC1158k0 != null) {
                abstractC1158k0.onViewRecycled(abstractC1174p1);
            }
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.m2941d(abstractC1174p1);
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d("RecyclerView", "dispatchViewRecycled: " + abstractC1174p1);
            }
        }
        abstractC1174p1.mBindingAdapter = null;
        abstractC1174p1.mOwnerRecyclerView = null;
        C1136d1 c1136d1M2927c = m2927c();
        c1136d1M2927c.getClass();
        int itemViewType = abstractC1174p1.getItemViewType();
        ArrayList arrayList = c1136d1M2927c.m2923a(itemViewType).f3525a;
        if (((C1132c1) c1136d1M2927c.f3541a.get(itemViewType)).f3526b <= arrayList.size()) {
            AbstractC2973a.m6015e(abstractC1174p1.itemView);
        } else {
            if (RecyclerView.sDebugAssertionsEnabled && arrayList.contains(abstractC1174p1)) {
                throw new IllegalArgumentException("this scrap item already exists");
            }
            abstractC1174p1.resetInternal();
            arrayList.add(abstractC1174p1);
        }
    }

    public final int m2926b(int i6) {
        RecyclerView recyclerView = this.f3556h;
        if (i6 >= 0 && i6 < recyclerView.mState.m2970b()) {
            return !recyclerView.mState.f3621g ? i6 : recyclerView.mAdapterHelper.m2876f(i6, 0);
        }
        StringBuilder sbM27u = AbstractC0004e.m27u(i6, "invalid position ", ". State item count is ");
        sbM27u.append(recyclerView.mState.m2970b());
        sbM27u.append(recyclerView.exceptionLabel());
        throw new IndexOutOfBoundsException(sbM27u.toString());
    }

    public final C1136d1 m2927c() {
        if (this.f3555g == null) {
            C1136d1 c1136d1 = new C1136d1();
            c1136d1.f3541a = new SparseArray();
            c1136d1.f3542b = 0;
            c1136d1.f3543c = Collections.newSetFromMap(new IdentityHashMap());
            this.f3555g = c1136d1;
            m2928e();
        }
        return this.f3555g;
    }

    public final void m2928e() {
        if (this.f3555g != null) {
            RecyclerView recyclerView = this.f3556h;
            if (recyclerView.mAdapter == null || !recyclerView.isAttachedToWindow()) {
                return;
            }
            C1136d1 c1136d1 = this.f3555g;
            c1136d1.f3543c.add(recyclerView.mAdapter);
        }
    }

    public final void m2929f(AbstractC1158k0 abstractC1158k0, boolean z7) {
        C1136d1 c1136d1 = this.f3555g;
        if (c1136d1 == null) {
            return;
        }
        Set set = c1136d1.f3543c;
        set.remove(abstractC1158k0);
        if (set.size() != 0 || z7) {
            return;
        }
        int i6 = 0;
        while (true) {
            SparseArray sparseArray = c1136d1.f3541a;
            if (i6 >= sparseArray.size()) {
                return;
            }
            ArrayList arrayList = ((C1132c1) sparseArray.get(sparseArray.keyAt(i6))).f3525a;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                AbstractC2973a.m6015e(((AbstractC1174p1) arrayList.get(i10)).itemView);
            }
            i6++;
        }
    }

    public final void m2930g() {
        ArrayList arrayList = this.f3551c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            m2931h(size);
        }
        arrayList.clear();
        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
            C1178r c1178r = this.f3556h.mPrefetchRegistry;
            int[] iArr = c1178r.f3676c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            c1178r.f3677d = 0;
        }
    }

    public final void m2931h(int i6) {
        if (RecyclerView.sVerboseLoggingEnabled) {
            Log.d("RecyclerView", "Recycling cached view at index " + i6);
        }
        ArrayList arrayList = this.f3551c;
        AbstractC1174p1 abstractC1174p1 = (AbstractC1174p1) arrayList.get(i6);
        if (RecyclerView.sVerboseLoggingEnabled) {
            Log.d("RecyclerView", "CachedViewHolder to be recycled: " + abstractC1174p1);
        }
        m2925a(abstractC1174p1, true);
        arrayList.remove(i6);
    }

    public final void m2932i(View view) {
        AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        boolean zIsTmpDetached = childViewHolderInt.isTmpDetached();
        RecyclerView recyclerView = this.f3556h;
        if (zIsTmpDetached) {
            recyclerView.removeDetachedView(view, false);
        }
        if (childViewHolderInt.isScrap()) {
            childViewHolderInt.unScrap();
        } else if (childViewHolderInt.wasReturnedFromScrap()) {
            childViewHolderInt.clearReturnedFromScrapFlag();
        }
        m2933j(childViewHolderInt);
        if (recyclerView.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
            return;
        }
        recyclerView.mItemAnimator.mo2954d(childViewHolderInt);
    }

    public final void m2933j(AbstractC1174p1 abstractC1174p1) {
        boolean z7;
        int i6;
        int i10;
        C1178r c1178r;
        int i11;
        int i12;
        boolean zIsScrap = abstractC1174p1.isScrap();
        boolean z10 = false;
        boolean z11 = true;
        RecyclerView recyclerView = this.f3556h;
        if (zIsScrap || abstractC1174p1.itemView.getParent() != null) {
            StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(abstractC1174p1.isScrap());
            sb.append(" isAttached:");
            sb.append(abstractC1174p1.itemView.getParent() != null);
            sb.append(recyclerView.exceptionLabel());
            throw new IllegalArgumentException(sb.toString());
        }
        if (abstractC1174p1.isTmpDetached()) {
            StringBuilder sb2 = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
            sb2.append(abstractC1174p1);
            throw new IllegalArgumentException(AbstractC0004e.m22p(recyclerView, sb2));
        }
        if (abstractC1174p1.shouldIgnore()) {
            throw new IllegalArgumentException(AbstractC0004e.m22p(recyclerView, new StringBuilder("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
        }
        boolean zDoesTransientStatePreventRecycling = abstractC1174p1.doesTransientStatePreventRecycling();
        AbstractC1158k0 abstractC1158k0 = recyclerView.mAdapter;
        boolean z12 = abstractC1158k0 != null && zDoesTransientStatePreventRecycling && abstractC1158k0.onFailedToRecycleView(abstractC1174p1);
        boolean z13 = RecyclerView.sDebugAssertionsEnabled;
        ArrayList arrayList = this.f3551c;
        if (z13 && arrayList.contains(abstractC1174p1)) {
            StringBuilder sb3 = new StringBuilder("cached view received recycle internal? ");
            sb3.append(abstractC1174p1);
            throw new IllegalArgumentException(AbstractC0004e.m22p(recyclerView, sb3));
        }
        if (z12 || abstractC1174p1.isRecyclable()) {
            if (this.f3554f <= 0 || abstractC1174p1.hasAnyOfTheFlags(526)) {
                z7 = false;
            } else {
                int size = arrayList.size();
                if (size >= this.f3554f && size > 0) {
                    m2931h(0);
                    size--;
                }
                if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0) {
                    C1178r c1178r2 = recyclerView.mPrefetchRegistry;
                    int i13 = abstractC1174p1.mPosition;
                    if (c1178r2.f3676c != null) {
                        int i14 = c1178r2.f3677d * 2;
                        int i15 = 0;
                        while (true) {
                            if (i15 >= i14) {
                                i6 = size - 1;
                                loop1: while (i6 >= 0) {
                                    i10 = ((AbstractC1174p1) arrayList.get(i6)).mPosition;
                                    c1178r = recyclerView.mPrefetchRegistry;
                                    if (c1178r.f3676c != null) {
                                        break;
                                    }
                                    i11 = c1178r.f3677d * 2;
                                    i12 = 0;
                                    while (true) {
                                        if (i12 < i11) {
                                            break loop1;
                                        } else if (c1178r.f3676c[i12] == i10) {
                                            break;
                                        } else {
                                            i12 += 2;
                                        }
                                    }
                                    i6--;
                                }
                                size = i6 + 1;
                            } else if (c1178r2.f3676c[i15] != i13) {
                                i15 += 2;
                            }
                        }
                    } else {
                        i6 = size - 1;
                        loop1: while (i6 >= 0) {
                            i10 = ((AbstractC1174p1) arrayList.get(i6)).mPosition;
                            c1178r = recyclerView.mPrefetchRegistry;
                            if (c1178r.f3676c != null) {
                                break;
                                break;
                            }
                            i11 = c1178r.f3677d * 2;
                            i12 = 0;
                            while (true) {
                                if (i12 < i11) {
                                    break loop1;
                                    break loop1;
                                } else if (c1178r.f3676c[i12] == i10) {
                                    break;
                                } else {
                                    i12 += 2;
                                }
                            }
                            i6--;
                        }
                        size = i6 + 1;
                    }
                }
                arrayList.add(size, abstractC1174p1);
                z7 = true;
            }
            if (z7) {
                z10 = z7;
            } else {
                m2925a(abstractC1174p1, true);
                z10 = z7;
            }
            recyclerView.mViewInfoStore.m2941d(abstractC1174p1);
            if (z10 && !z11 && zDoesTransientStatePreventRecycling) {
                AbstractC2973a.m6015e(abstractC1174p1.itemView);
                abstractC1174p1.mBindingAdapter = null;
                abstractC1174p1.mOwnerRecyclerView = null;
                return;
            }
            return;
        }
        if (RecyclerView.sVerboseLoggingEnabled) {
            Log.d("RecyclerView", "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + recyclerView.exceptionLabel());
        }
        z11 = false;
        recyclerView.mViewInfoStore.m2941d(abstractC1174p1);
        if (z10) {
        }
    }

    public final void m2934k(View view) {
        AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        boolean zHasAnyOfTheFlags = childViewHolderInt.hasAnyOfTheFlags(12);
        RecyclerView recyclerView = this.f3556h;
        if (!zHasAnyOfTheFlags && childViewHolderInt.isUpdated() && !recyclerView.canReuseUpdatedViewHolder(childViewHolderInt)) {
            if (this.f3550b == null) {
                this.f3550b = new ArrayList();
            }
            childViewHolderInt.setScrapContainer(this, true);
            this.f3550b.add(childViewHolderInt);
            return;
        }
        if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !recyclerView.mAdapter.hasStableIds()) {
            throw new IllegalArgumentException(AbstractC0004e.m22p(recyclerView, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }
        childViewHolderInt.setScrapContainer(this, false);
        this.f3549a.add(childViewHolderInt);
    }

    public final AbstractC1174p1 m2935l(int i6, long j10) {
        boolean z7;
        AbstractC1174p1 abstractC1174p1CreateViewHolder;
        boolean z10;
        boolean z11;
        ViewGroup.LayoutParams layoutParams;
        RecyclerView.LayoutParams layoutParams2;
        RecyclerView recyclerViewFindNestedRecyclerView;
        AbstractC1174p1 abstractC1174p1;
        AbstractC1174p1 abstractC1174p2;
        View view;
        boolean z12;
        int size;
        int iM2876f;
        RecyclerView recyclerView = this.f3556h;
        if (i6 < 0 || i6 >= recyclerView.mState.m2970b()) {
            StringBuilder sbM28v = AbstractC0004e.m28v("Invalid item position ", i6, "(", i6, "). Item count:");
            sbM28v.append(recyclerView.mState.m2970b());
            sbM28v.append(recyclerView.exceptionLabel());
            throw new IndexOutOfBoundsException(sbM28v.toString());
        }
        boolean z13 = false;
        if (recyclerView.mState.f3621g) {
            ArrayList arrayList = this.f3550b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        if (recyclerView.mAdapter.hasStableIds() && (iM2876f = recyclerView.mAdapterHelper.m2876f(i6, 0)) > 0 && iM2876f < recyclerView.mAdapter.getItemCount()) {
                            long itemId = recyclerView.mAdapter.getItemId(iM2876f);
                            int i11 = 0;
                            while (true) {
                                if (i11 >= size) {
                                    abstractC1174p1CreateViewHolder = null;
                                    break;
                                }
                                AbstractC1174p1 abstractC1174p3 = (AbstractC1174p1) this.f3550b.get(i11);
                                if (!abstractC1174p3.wasReturnedFromScrap() && abstractC1174p3.getItemId() == itemId) {
                                    abstractC1174p3.addFlags(32);
                                    abstractC1174p1CreateViewHolder = abstractC1174p3;
                                    break;
                                }
                                i11++;
                            }
                        } else {
                            abstractC1174p1CreateViewHolder = null;
                            break;
                        }
                    } else {
                        abstractC1174p1CreateViewHolder = (AbstractC1174p1) this.f3550b.get(i10);
                        if (!abstractC1174p1CreateViewHolder.wasReturnedFromScrap() && abstractC1174p1CreateViewHolder.getLayoutPosition() == i6) {
                            abstractC1174p1CreateViewHolder.addFlags(32);
                            break;
                        }
                        i10++;
                    }
                }
            } else {
                abstractC1174p1CreateViewHolder = null;
                break;
            }
            z7 = abstractC1174p1CreateViewHolder != null;
        } else {
            z7 = false;
            abstractC1174p1CreateViewHolder = null;
        }
        ArrayList arrayList2 = this.f3551c;
        ArrayList arrayList3 = this.f3549a;
        if (abstractC1174p1CreateViewHolder == null) {
            int size2 = arrayList3.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size2) {
                    ArrayList arrayList4 = recyclerView.mChildHelper.f3535c;
                    int size3 = arrayList4.size();
                    int i13 = 0;
                    while (true) {
                        if (i13 >= size3) {
                            view = null;
                            break;
                        }
                        view = (View) arrayList4.get(i13);
                        AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                        if (childViewHolderInt.getLayoutPosition() == i6 && !childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved()) {
                            break;
                        }
                        i13++;
                    }
                    if (view == null) {
                        int size4 = arrayList2.size();
                        int i14 = 0;
                        while (true) {
                            if (i14 >= size4) {
                                abstractC1174p1CreateViewHolder = null;
                                break;
                            }
                            AbstractC1174p1 abstractC1174p4 = (AbstractC1174p1) arrayList2.get(i14);
                            if (!abstractC1174p4.isInvalid() && abstractC1174p4.getLayoutPosition() == i6 && !abstractC1174p4.isAttachedToTransitionOverlay()) {
                                arrayList2.remove(i14);
                                if (RecyclerView.sVerboseLoggingEnabled) {
                                    Log.d("RecyclerView", "getScrapOrHiddenOrCachedHolderForPosition(" + i6 + ") found match in cache: " + abstractC1174p4);
                                }
                                abstractC1174p1CreateViewHolder = abstractC1174p4;
                                break;
                            }
                            i14++;
                        }
                    } else {
                        AbstractC1174p1 childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                        C1134d c1134d = recyclerView.mChildHelper;
                        int iIndexOfChild = ((RecyclerView) c1134d.f3533a.f3584a).indexOfChild(view);
                        if (iIndexOfChild < 0) {
                            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
                        }
                        C1130c c1130c = c1134d.f3534b;
                        if (!c1130c.m2903e(iIndexOfChild)) {
                            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                        }
                        c1130c.m2900b(iIndexOfChild);
                        c1134d.m2920l(view);
                        int iM2918j = recyclerView.mChildHelper.m2918j(view);
                        if (iM2918j == -1) {
                            StringBuilder sb = new StringBuilder("layout index should not be -1 after unhiding a view:");
                            sb.append(childViewHolderInt2);
                            throw new IllegalStateException(AbstractC0004e.m22p(recyclerView, sb));
                        }
                        recyclerView.mChildHelper.m2911c(iM2918j);
                        m2934k(view);
                        childViewHolderInt2.addFlags(8224);
                        abstractC1174p1CreateViewHolder = childViewHolderInt2;
                        break;
                    }
                } else {
                    AbstractC1174p1 abstractC1174p5 = (AbstractC1174p1) arrayList3.get(i12);
                    if (!abstractC1174p5.wasReturnedFromScrap() && abstractC1174p5.getLayoutPosition() == i6 && !abstractC1174p5.isInvalid() && (recyclerView.mState.f3621g || !abstractC1174p5.isRemoved())) {
                        abstractC1174p5.addFlags(32);
                        abstractC1174p1CreateViewHolder = abstractC1174p5;
                        break;
                    }
                    i12++;
                }
            }
            if (abstractC1174p1CreateViewHolder != null) {
                if (!abstractC1174p1CreateViewHolder.isRemoved()) {
                    int i15 = abstractC1174p1CreateViewHolder.mPosition;
                    if (i15 < 0 || i15 >= recyclerView.mAdapter.getItemCount()) {
                        StringBuilder sb2 = new StringBuilder("Inconsistency detected. Invalid view holder adapter position");
                        sb2.append(abstractC1174p1CreateViewHolder);
                        throw new IndexOutOfBoundsException(AbstractC0004e.m22p(recyclerView, sb2));
                    }
                    z12 = (recyclerView.mState.f3621g || recyclerView.mAdapter.getItemViewType(abstractC1174p1CreateViewHolder.mPosition) == abstractC1174p1CreateViewHolder.getItemViewType()) && (!recyclerView.mAdapter.hasStableIds() || abstractC1174p1CreateViewHolder.getItemId() == recyclerView.mAdapter.getItemId(abstractC1174p1CreateViewHolder.mPosition));
                } else {
                    if (RecyclerView.sDebugAssertionsEnabled && !recyclerView.mState.f3621g) {
                        throw new IllegalStateException(AbstractC0004e.m22p(recyclerView, new StringBuilder("should not receive a removed view unless it is pre layout")));
                    }
                    z12 = recyclerView.mState.f3621g;
                }
                if (z12) {
                    z7 = true;
                } else {
                    abstractC1174p1CreateViewHolder.addFlags(4);
                    if (abstractC1174p1CreateViewHolder.isScrap()) {
                        recyclerView.removeDetachedView(abstractC1174p1CreateViewHolder.itemView, false);
                        abstractC1174p1CreateViewHolder.unScrap();
                    } else if (abstractC1174p1CreateViewHolder.wasReturnedFromScrap()) {
                        abstractC1174p1CreateViewHolder.clearReturnedFromScrapFlag();
                    }
                    m2933j(abstractC1174p1CreateViewHolder);
                    abstractC1174p1CreateViewHolder = null;
                }
            }
        }
        if (abstractC1174p1CreateViewHolder == null) {
            int iM2876f2 = recyclerView.mAdapterHelper.m2876f(i6, 0);
            if (iM2876f2 < 0 || iM2876f2 >= recyclerView.mAdapter.getItemCount()) {
                StringBuilder sbM28v2 = AbstractC0004e.m28v("Inconsistency detected. Invalid item position ", i6, "(offset:", iM2876f2, ").state:");
                sbM28v2.append(recyclerView.mState.m2970b());
                sbM28v2.append(recyclerView.exceptionLabel());
                throw new IndexOutOfBoundsException(sbM28v2.toString());
            }
            int itemViewType = recyclerView.mAdapter.getItemViewType(iM2876f2);
            if (recyclerView.mAdapter.hasStableIds()) {
                long itemId2 = recyclerView.mAdapter.getItemId(iM2876f2);
                int size5 = arrayList3.size() - 1;
                while (true) {
                    if (size5 < 0) {
                        int size6 = arrayList2.size() - 1;
                        while (true) {
                            if (size6 >= 0) {
                                AbstractC1174p1 abstractC1174p6 = (AbstractC1174p1) arrayList2.get(size6);
                                if (abstractC1174p6.getItemId() != itemId2 || abstractC1174p6.isAttachedToTransitionOverlay()) {
                                    size6--;
                                } else {
                                    if (itemViewType == abstractC1174p6.getItemViewType()) {
                                        arrayList2.remove(size6);
                                        abstractC1174p2 = abstractC1174p6;
                                        break;
                                    }
                                    m2931h(size6);
                                }
                            }
                            abstractC1174p2 = null;
                            break;
                        }
                    }
                    abstractC1174p2 = (AbstractC1174p1) arrayList3.get(size5);
                    if (abstractC1174p2.getItemId() == itemId2 && !abstractC1174p2.wasReturnedFromScrap()) {
                        if (itemViewType == abstractC1174p2.getItemViewType()) {
                            abstractC1174p2.addFlags(32);
                            if (!abstractC1174p2.isRemoved() || recyclerView.mState.f3621g) {
                                break;
                                break;
                            }
                            abstractC1174p2.setFlags(2, 14);
                            break;
                        }
                        arrayList3.remove(size5);
                        recyclerView.removeDetachedView(abstractC1174p2.itemView, false);
                        AbstractC1174p1 childViewHolderInt3 = RecyclerView.getChildViewHolderInt(abstractC1174p2.itemView);
                        childViewHolderInt3.mScrapContainer = null;
                        childViewHolderInt3.mInChangeScrap = false;
                        childViewHolderInt3.clearReturnedFromScrapFlag();
                        m2933j(childViewHolderInt3);
                    }
                    size5--;
                }
                if (abstractC1174p2 != null) {
                    abstractC1174p2.mPosition = iM2876f2;
                    abstractC1174p1CreateViewHolder = abstractC1174p2;
                    z7 = true;
                } else {
                    abstractC1174p1CreateViewHolder = abstractC1174p2;
                }
            }
            if (abstractC1174p1CreateViewHolder == null) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline(" + i6 + ") fetching from shared pool");
                }
                C1132c1 c1132c1 = (C1132c1) m2927c().f3541a.get(itemViewType);
                if (c1132c1 == null) {
                    abstractC1174p1 = null;
                    break;
                }
                ArrayList arrayList5 = c1132c1.f3525a;
                if (!arrayList5.isEmpty()) {
                    int size7 = arrayList5.size() - 1;
                    while (true) {
                        if (size7 < 0) {
                            abstractC1174p1 = null;
                            break;
                        }
                        if (!((AbstractC1174p1) arrayList5.get(size7)).isAttachedToTransitionOverlay()) {
                            abstractC1174p1 = (AbstractC1174p1) arrayList5.remove(size7);
                            break;
                        }
                        size7--;
                    }
                } else {
                    abstractC1174p1 = null;
                    break;
                }
                if (abstractC1174p1 != null) {
                    abstractC1174p1.resetInternal();
                    if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                        View view2 = abstractC1174p1.itemView;
                        if (view2 instanceof ViewGroup) {
                            m2924d((ViewGroup) view2, false);
                        }
                    }
                }
                abstractC1174p1CreateViewHolder = abstractC1174p1;
            }
            if (abstractC1174p1CreateViewHolder == null) {
                long nanoTime = recyclerView.getNanoTime();
                if (j10 != Long.MAX_VALUE) {
                    long j11 = this.f3555g.m2923a(itemViewType).f3527c;
                    if (!(j11 == 0 || j11 + nanoTime < j10)) {
                        return null;
                    }
                }
                abstractC1174p1CreateViewHolder = recyclerView.mAdapter.createViewHolder(recyclerView, itemViewType);
                if (RecyclerView.ALLOW_THREAD_GAP_WORK && (recyclerViewFindNestedRecyclerView = RecyclerView.findNestedRecyclerView(abstractC1174p1CreateViewHolder.itemView)) != null) {
                    abstractC1174p1CreateViewHolder.mNestedRecyclerView = new WeakReference<>(recyclerViewFindNestedRecyclerView);
                }
                long nanoTime2 = recyclerView.getNanoTime() - nanoTime;
                C1132c1 c1132c1M2923a = this.f3555g.m2923a(itemViewType);
                long j12 = c1132c1M2923a.f3527c;
                if (j12 != 0) {
                    nanoTime2 = (nanoTime2 / 4) + ((j12 / 4) * 3);
                }
                c1132c1M2923a.f3527c = nanoTime2;
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline created new ViewHolder");
                }
            }
        }
        if (z7 && !recyclerView.mState.f3621g && abstractC1174p1CreateViewHolder.hasAnyOfTheFlags(8192)) {
            abstractC1174p1CreateViewHolder.setFlags(0, 8192);
            if (recyclerView.mState.f3624j) {
                AbstractC1182s0.m2989b(abstractC1174p1CreateViewHolder);
                AbstractC1182s0 abstractC1182s0 = recyclerView.mItemAnimator;
                abstractC1174p1CreateViewHolder.getUnmodifiedPayloads();
                abstractC1182s0.getClass();
                C1179r0 c1179r0 = new C1179r0();
                c1179r0.m2988a(abstractC1174p1CreateViewHolder);
                recyclerView.recordAnimationInfoIfBouncedHiddenView(abstractC1174p1CreateViewHolder, c1179r0);
            }
        }
        if (!recyclerView.mState.f3621g || !abstractC1174p1CreateViewHolder.isBound()) {
            if (!abstractC1174p1CreateViewHolder.isBound() || abstractC1174p1CreateViewHolder.needsUpdate() || abstractC1174p1CreateViewHolder.isInvalid()) {
                if (RecyclerView.sDebugAssertionsEnabled && abstractC1174p1CreateViewHolder.isRemoved()) {
                    StringBuilder sb3 = new StringBuilder("Removed holder should be bound and it should come here only in pre-layout. Holder: ");
                    sb3.append(abstractC1174p1CreateViewHolder);
                    throw new IllegalStateException(AbstractC0004e.m22p(recyclerView, sb3));
                }
                int iM2876f3 = recyclerView.mAdapterHelper.m2876f(i6, 0);
                C3103b c3103b = null;
                abstractC1174p1CreateViewHolder.mBindingAdapter = null;
                abstractC1174p1CreateViewHolder.mOwnerRecyclerView = recyclerView;
                int itemViewType2 = abstractC1174p1CreateViewHolder.getItemViewType();
                long nanoTime3 = recyclerView.getNanoTime();
                if (j10 != Long.MAX_VALUE) {
                    long j13 = this.f3555g.m2923a(itemViewType2).f3528d;
                    if (j13 == 0 || j13 + nanoTime3 < j10) {
                    }
                }
                if (abstractC1174p1CreateViewHolder.isTmpDetached()) {
                    recyclerView.attachViewToParent(abstractC1174p1CreateViewHolder.itemView, recyclerView.getChildCount(), abstractC1174p1CreateViewHolder.itemView.getLayoutParams());
                    z10 = true;
                } else {
                    z10 = false;
                }
                recyclerView.mAdapter.bindViewHolder(abstractC1174p1CreateViewHolder, iM2876f3);
                if (z10) {
                    recyclerView.detachViewFromParent(abstractC1174p1CreateViewHolder.itemView);
                }
                long nanoTime4 = recyclerView.getNanoTime() - nanoTime3;
                C1132c1 c1132c1M2923a2 = this.f3555g.m2923a(abstractC1174p1CreateViewHolder.getItemViewType());
                long j14 = c1132c1M2923a2.f3528d;
                if (j14 != 0) {
                    nanoTime4 = (nanoTime4 / 4) + ((j14 / 4) * 3);
                }
                c1132c1M2923a2.f3528d = nanoTime4;
                if (recyclerView.isAccessibilityEnabled()) {
                    View view3 = abstractC1174p1CreateViewHolder.itemView;
                    if (view3.getImportantForAccessibility() == 0) {
                        view3.setImportantForAccessibility(1);
                    }
                    C1180r1 c1180r1 = recyclerView.mAccessibilityDelegate;
                    if (c1180r1 != null) {
                        C1177q1 c1177q1 = c1180r1.f3681e;
                        if (c1177q1 instanceof C1177q1) {
                            c1177q1.getClass();
                            View.AccessibilityDelegate accessibilityDelegateM6334d = AbstractC3155s0.m6334d(view3);
                            if (accessibilityDelegateM6334d != null) {
                                c3103b = accessibilityDelegateM6334d instanceof C3100a ? ((C3100a) accessibilityDelegateM6334d).f10568a : new C3103b(accessibilityDelegateM6334d);
                            }
                            if (c3103b != null && c3103b != c1177q1) {
                                c1177q1.f3673e.put(view3, c3103b);
                            }
                        }
                        AbstractC3155s0.m6347q(view3, c1177q1);
                    }
                }
                if (recyclerView.mState.f3621g) {
                    abstractC1174p1CreateViewHolder.mPreLayoutPosition = i6;
                }
                z11 = true;
            }
            layoutParams = abstractC1174p1CreateViewHolder.itemView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams2 = (RecyclerView.LayoutParams) recyclerView.generateDefaultLayoutParams();
                abstractC1174p1CreateViewHolder.itemView.setLayoutParams(layoutParams2);
            } else if (recyclerView.checkLayoutParams(layoutParams)) {
                layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            } else {
                layoutParams2 = (RecyclerView.LayoutParams) recyclerView.generateLayoutParams(layoutParams);
                abstractC1174p1CreateViewHolder.itemView.setLayoutParams(layoutParams2);
            }
            layoutParams2.f3465a = abstractC1174p1CreateViewHolder;
            if (z7 && z11) {
                z13 = true;
            }
            layoutParams2.f3468d = z13;
            return abstractC1174p1CreateViewHolder;
        }
        abstractC1174p1CreateViewHolder.mPreLayoutPosition = i6;
        z11 = false;
        layoutParams = abstractC1174p1CreateViewHolder.itemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams2 = (RecyclerView.LayoutParams) recyclerView.generateDefaultLayoutParams();
            abstractC1174p1CreateViewHolder.itemView.setLayoutParams(layoutParams2);
        } else if (recyclerView.checkLayoutParams(layoutParams)) {
            layoutParams2 = (RecyclerView.LayoutParams) recyclerView.generateLayoutParams(layoutParams);
            abstractC1174p1CreateViewHolder.itemView.setLayoutParams(layoutParams2);
        } else {
            layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        }
        layoutParams2.f3465a = abstractC1174p1CreateViewHolder;
        if (z7) {
            z13 = true;
        }
        layoutParams2.f3468d = z13;
        return abstractC1174p1CreateViewHolder;
    }

    public final void m2936m(AbstractC1174p1 abstractC1174p1) {
        if (abstractC1174p1.mInChangeScrap) {
            this.f3550b.remove(abstractC1174p1);
        } else {
            this.f3549a.remove(abstractC1174p1);
        }
        abstractC1174p1.mScrapContainer = null;
        abstractC1174p1.mInChangeScrap = false;
        abstractC1174p1.clearReturnedFromScrapFlag();
    }

    public final void m2937n() {
        AbstractC1197x0 abstractC1197x0 = this.f3556h.mLayout;
        this.f3554f = this.f3553e + (abstractC1197x0 != null ? abstractC1197x0.mPrefetchMaxCountObserved : 0);
        ArrayList arrayList = this.f3551c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f3554f; size--) {
            m2931h(size);
        }
    }
}
