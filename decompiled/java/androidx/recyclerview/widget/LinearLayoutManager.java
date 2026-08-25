package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;
import p000a.AbstractC0004e;
import p148o0.C3228c;
import p148o0.C3233h;
import p187r4.AbstractC3612b;

public class LinearLayoutManager extends AbstractC1197x0 implements InterfaceC1156j1 {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final C1193w mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final C1196x mLayoutChunkResult;
    private C1199y mLayoutState;
    int mOrientation;
    AbstractC1135d0 mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1202z();

        public int f3458a;

        public int f3459b;

        public boolean f3460c;

        @Override
        public final int describeContents() {
            return 0;
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.f3458a);
            parcel.writeInt(this.f3459b);
            parcel.writeInt(this.f3460c ? 1 : 0);
        }
    }

    public LinearLayoutManager(int i6) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C1193w();
        this.mLayoutChunkResult = new C1196x();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i6);
        setReverseLayout(false);
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(C1162l1 c1162l1, int[] iArr) {
        int i6;
        int extraLayoutSpace = getExtraLayoutSpace(c1162l1);
        if (this.mLayoutState.f3735f == -1) {
            i6 = 0;
        } else {
            i6 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i6;
    }

    @Override
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public void collectAdjacentPrefetchPositions(int i6, int i10, C1162l1 c1162l1, InterfaceC1194w0 interfaceC1194w0) {
        if (this.mOrientation != 0) {
            i6 = i10;
        }
        if (getChildCount() == 0 || i6 == 0) {
            return;
        }
        ensureLayoutState();
        m2833o(i6 > 0 ? 1 : -1, Math.abs(i6), true, c1162l1);
        collectPrefetchPositionsForLayoutState(c1162l1, this.mLayoutState, interfaceC1194w0);
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public void collectInitialPrefetchPositions(int i6, InterfaceC1194w0 interfaceC1194w0) {
        boolean z7;
        int i10;
        SavedState savedState = this.mPendingSavedState;
        if (savedState == null || (i10 = savedState.f3458a) < 0) {
            m2832n();
            z7 = this.mShouldReverseLayout;
            i10 = this.mPendingScrollPosition;
            if (i10 == -1) {
                i10 = z7 ? i6 - 1 : 0;
            }
        } else {
            z7 = savedState.f3460c;
        }
        int i11 = z7 ? -1 : 1;
        for (int i12 = 0; i12 < this.mInitialPrefetchItemCount && i10 >= 0 && i10 < i6; i12++) {
            ((C1178r) interfaceC1194w0).m2986a(i10, 0);
            i10 += i11;
        }
    }

    public void collectPrefetchPositionsForLayoutState(C1162l1 c1162l1, C1199y c1199y, InterfaceC1194w0 interfaceC1194w0) {
        int i6 = c1199y.f3733d;
        if (i6 < 0 || i6 >= c1162l1.m2970b()) {
            return;
        }
        ((C1178r) interfaceC1194w0).m2986a(i6, Math.max(0, c1199y.f3736g));
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollExtent(C1162l1 c1162l1) {
        return m2822d(c1162l1);
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollOffset(C1162l1 c1162l1) {
        return m2823e(c1162l1);
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollRange(C1162l1 c1162l1) {
        return m2824f(c1162l1);
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public PointF computeScrollVectorForPosition(int i6) {
        if (getChildCount() == 0) {
            return null;
        }
        int i10 = (i6 < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        return this.mOrientation == 0 ? new PointF(i10, 0.0f) : new PointF(0.0f, i10);
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollExtent(C1162l1 c1162l1) {
        return m2822d(c1162l1);
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollOffset(C1162l1 c1162l1) {
        return m2823e(c1162l1);
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollRange(C1162l1 c1162l1) {
        return m2824f(c1162l1);
    }

    public int convertFocusDirectionToLayoutDirection(int i6) {
        if (i6 == 1) {
            return (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
        }
        if (i6 == 2) {
            return (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1;
        }
        if (i6 == 17) {
            return this.mOrientation == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i6 == 33) {
            return this.mOrientation == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i6 != 66) {
            return (i6 == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.mOrientation == 0 ? 1 : Integer.MIN_VALUE;
    }

    public C1199y createLayoutState() {
        C1199y c1199y = new C1199y();
        c1199y.f3730a = true;
        c1199y.f3737h = 0;
        c1199y.f3738i = 0;
        c1199y.f3740k = null;
        return c1199y;
    }

    public final int m2822d(C1162l1 c1162l1) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return AbstractC3612b.m7264f(c1162l1, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public final int m2823e(C1162l1 c1162l1) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return AbstractC3612b.m7265g(c1162l1, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public final int m2824f(C1162l1 c1162l1) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return AbstractC3612b.m7266h(c1162l1, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public int fill(C1140e1 c1140e1, C1199y c1199y, C1162l1 c1162l1, boolean z7) {
        int i6;
        int i10 = c1199y.f3732c;
        int i11 = c1199y.f3736g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                c1199y.f3736g = i11 + i10;
            }
            m2830l(c1140e1, c1199y);
        }
        int i12 = c1199y.f3732c + c1199y.f3737h;
        C1196x c1196x = this.mLayoutChunkResult;
        while (true) {
            if ((!c1199y.f3741l && i12 <= 0) || (i6 = c1199y.f3733d) < 0 || i6 >= c1162l1.m2970b()) {
                break;
            }
            c1196x.f3726a = 0;
            c1196x.f3727b = false;
            c1196x.f3728c = false;
            c1196x.f3729d = false;
            layoutChunk(c1140e1, c1162l1, c1199y, c1196x);
            if (!c1196x.f3727b) {
                int i13 = c1199y.f3731b;
                int i14 = c1196x.f3726a;
                c1199y.f3731b = (c1199y.f3735f * i14) + i13;
                if (!c1196x.f3728c || c1199y.f3740k != null || !c1162l1.f3621g) {
                    c1199y.f3732c -= i14;
                    i12 -= i14;
                }
                int i15 = c1199y.f3736g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + i14;
                    c1199y.f3736g = i16;
                    int i17 = c1199y.f3732c;
                    if (i17 < 0) {
                        c1199y.f3736g = i16 + i17;
                    }
                    m2830l(c1140e1, c1199y);
                }
                if (z7 && c1196x.f3729d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - c1199y.f3732c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z7, boolean z10) {
        return this.mShouldReverseLayout ? findOneVisibleChild(0, getChildCount(), z7, z10) : findOneVisibleChild(getChildCount() - 1, -1, z7, z10);
    }

    public View findFirstVisibleChildClosestToStart(boolean z7, boolean z10) {
        return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, z7, z10) : findOneVisibleChild(0, getChildCount(), z7, z10);
    }

    public int findFirstVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i6, int i10) {
        int i11;
        int i12;
        ensureLayoutState();
        if (i10 <= i6 && i10 >= i6) {
            return getChildAt(i6);
        }
        if (this.mOrientationHelper.mo2886e(getChildAt(i6)) < this.mOrientationHelper.mo2892k()) {
            i11 = 16644;
            i12 = 16388;
        } else {
            i11 = 4161;
            i12 = 4097;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.m2897a(i6, i10, i11, i12) : this.mVerticalBoundCheck.m2897a(i6, i10, i11, i12);
    }

    public View findOneVisibleChild(int i6, int i10, boolean z7, boolean z10) {
        ensureLayoutState();
        int i11 = z7 ? 24579 : 320;
        int i12 = z10 ? 320 : 0;
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.m2897a(i6, i10, i11, i12) : this.mVerticalBoundCheck.m2897a(i6, i10, i11, i12);
    }

    public View findReferenceChild(C1140e1 c1140e1, C1162l1 c1162l1, boolean z7, boolean z10) {
        int i6;
        int childCount;
        int i10;
        ensureLayoutState();
        int childCount2 = getChildCount();
        if (z10) {
            childCount = getChildCount() - 1;
            i6 = -1;
            i10 = -1;
        } else {
            i6 = childCount2;
            childCount = 0;
            i10 = 1;
        }
        int iM2970b = c1162l1.m2970b();
        int iMo2892k = this.mOrientationHelper.mo2892k();
        int iMo2888g = this.mOrientationHelper.mo2888g();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (childCount != i6) {
            View childAt = getChildAt(childCount);
            int position = getPosition(childAt);
            int iMo2886e = this.mOrientationHelper.mo2886e(childAt);
            int iMo2883b = this.mOrientationHelper.mo2883b(childAt);
            if (position >= 0 && position < iM2970b) {
                if (!((RecyclerView.LayoutParams) childAt.getLayoutParams()).f3465a.isRemoved()) {
                    boolean z11 = iMo2883b <= iMo2892k && iMo2886e < iMo2892k;
                    boolean z12 = iMo2886e >= iMo2888g && iMo2883b > iMo2888g;
                    if (!z11 && !z12) {
                        return childAt;
                    }
                    if (z7) {
                        if (z12) {
                            view2 = childAt;
                        } else if (view == null) {
                            view = childAt;
                        }
                    } else if (z11) {
                        view2 = childAt;
                    } else if (view == null) {
                        view = childAt;
                    }
                } else if (view3 == null) {
                    view3 = childAt;
                }
            }
            childCount += i10;
        }
        if (view != null) {
            return view;
        }
        return view2 != null ? view2 : view3;
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public View findViewByPosition(int i6) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i6 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i6) {
                return childAt;
            }
        }
        return super.findViewByPosition(i6);
    }

    public final int m2825g(int i6, C1140e1 c1140e1, C1162l1 c1162l1, boolean z7) {
        int iMo2888g;
        int iMo2888g2 = this.mOrientationHelper.mo2888g() - i6;
        if (iMo2888g2 <= 0) {
            return 0;
        }
        int i10 = -scrollBy(-iMo2888g2, c1140e1, c1162l1);
        int i11 = i6 + i10;
        if (!z7 || (iMo2888g = this.mOrientationHelper.mo2888g() - i11) <= 0) {
            return i10;
        }
        this.mOrientationHelper.mo2896p(iMo2888g);
        return iMo2888g + i10;
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(C1162l1 c1162l1) {
        if (c1162l1.f3615a != -1) {
            return this.mOrientationHelper.mo2893l();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public final int m2826h(int i6, C1140e1 c1140e1, C1162l1 c1162l1, boolean z7) {
        int iMo2892k;
        int iMo2892k2 = i6 - this.mOrientationHelper.mo2892k();
        if (iMo2892k2 <= 0) {
            return 0;
        }
        int i10 = -scrollBy(iMo2892k2, c1140e1, c1162l1);
        int i11 = i6 + i10;
        if (!z7 || (iMo2892k = i11 - this.mOrientationHelper.mo2892k()) <= 0) {
            return i10;
        }
        this.mOrientationHelper.mo2896p(-iMo2892k);
        return i10 - iMo2892k;
    }

    public final View m2827i() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    @Override
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    @Override
    public boolean isLayoutReversed() {
        return this.mReverseLayout;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public final View m2828j() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    public final void m2829k() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.mo2886e(childAt));
        }
        Log.d(TAG, "==============");
    }

    public final void m2830l(C1140e1 c1140e1, C1199y c1199y) {
        if (!c1199y.f3730a || c1199y.f3741l) {
            return;
        }
        int i6 = c1199y.f3736g;
        int i10 = c1199y.f3738i;
        if (c1199y.f3735f == -1) {
            int childCount = getChildCount();
            if (i6 < 0) {
                return;
            }
            int iMo2887f = (this.mOrientationHelper.mo2887f() - i6) + i10;
            if (this.mShouldReverseLayout) {
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = getChildAt(i11);
                    if (this.mOrientationHelper.mo2886e(childAt) < iMo2887f || this.mOrientationHelper.mo2895o(childAt) < iMo2887f) {
                        m2831m(c1140e1, 0, i11);
                        return;
                    }
                }
                return;
            }
            int i12 = childCount - 1;
            for (int i13 = i12; i13 >= 0; i13--) {
                View childAt2 = getChildAt(i13);
                if (this.mOrientationHelper.mo2886e(childAt2) < iMo2887f || this.mOrientationHelper.mo2895o(childAt2) < iMo2887f) {
                    m2831m(c1140e1, i12, i13);
                    return;
                }
            }
            return;
        }
        if (i6 < 0) {
            return;
        }
        int i14 = i6 - i10;
        int childCount2 = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i15 = 0; i15 < childCount2; i15++) {
                View childAt3 = getChildAt(i15);
                if (this.mOrientationHelper.mo2883b(childAt3) > i14 || this.mOrientationHelper.mo2894n(childAt3) > i14) {
                    m2831m(c1140e1, 0, i15);
                    return;
                }
            }
            return;
        }
        int i16 = childCount2 - 1;
        for (int i17 = i16; i17 >= 0; i17--) {
            View childAt4 = getChildAt(i17);
            if (this.mOrientationHelper.mo2883b(childAt4) > i14 || this.mOrientationHelper.mo2894n(childAt4) > i14) {
                m2831m(c1140e1, i16, i17);
                return;
            }
        }
    }

    public void layoutChunk(C1140e1 c1140e1, C1162l1 c1162l1, C1199y c1199y, C1196x c1196x) {
        int i6;
        int i10;
        int i11;
        int paddingLeft;
        int iMo2885d;
        View viewM3012b = c1199y.m3012b(c1140e1);
        if (viewM3012b == null) {
            c1196x.f3727b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewM3012b.getLayoutParams();
        if (c1199y.f3740k == null) {
            if (this.mShouldReverseLayout == (c1199y.f3735f == -1)) {
                addView(viewM3012b);
            } else {
                addView(viewM3012b, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (c1199y.f3735f == -1)) {
                addDisappearingView(viewM3012b);
            } else {
                addDisappearingView(viewM3012b, 0);
            }
        }
        measureChildWithMargins(viewM3012b, 0, 0);
        c1196x.f3726a = this.mOrientationHelper.mo2884c(viewM3012b);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                iMo2885d = getWidth() - getPaddingRight();
                paddingLeft = iMo2885d - this.mOrientationHelper.mo2885d(viewM3012b);
            } else {
                paddingLeft = getPaddingLeft();
                iMo2885d = this.mOrientationHelper.mo2885d(viewM3012b) + paddingLeft;
            }
            if (c1199y.f3735f == -1) {
                int i12 = c1199y.f3731b;
                i11 = i12;
                i10 = iMo2885d;
                i6 = i12 - c1196x.f3726a;
            } else {
                int i13 = c1199y.f3731b;
                i6 = i13;
                i10 = iMo2885d;
                i11 = c1196x.f3726a + i13;
            }
        } else {
            int paddingTop = getPaddingTop();
            int iMo2885d2 = this.mOrientationHelper.mo2885d(viewM3012b) + paddingTop;
            if (c1199y.f3735f == -1) {
                int i14 = c1199y.f3731b;
                i10 = i14;
                i6 = paddingTop;
                i11 = iMo2885d2;
                paddingLeft = i14 - c1196x.f3726a;
            } else {
                int i15 = c1199y.f3731b;
                i6 = paddingTop;
                i10 = c1196x.f3726a + i15;
                i11 = iMo2885d2;
                paddingLeft = i15;
            }
        }
        layoutDecoratedWithMargins(viewM3012b, paddingLeft, i6, i10, i11);
        if (layoutParams.f3465a.isRemoved() || layoutParams.f3465a.isUpdated()) {
            c1196x.f3728c = true;
        }
        c1196x.f3729d = viewM3012b.hasFocusable();
    }

    public final void m2831m(C1140e1 c1140e1, int i6, int i10) {
        if (i6 == i10) {
            return;
        }
        if (i10 <= i6) {
            while (i6 > i10) {
                removeAndRecycleViewAt(i6, c1140e1);
                i6--;
            }
        } else {
            for (int i11 = i10 - 1; i11 >= i6; i11--) {
                removeAndRecycleViewAt(i11, c1140e1);
            }
        }
    }

    public final void m2832n() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    public final void m2833o(int i6, int i10, boolean z7, C1162l1 c1162l1) {
        int iMo2892k;
        this.mLayoutState.f3741l = resolveIsInfinite();
        this.mLayoutState.f3735f = i6;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(c1162l1, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]);
        int iMax2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z10 = i6 == 1;
        C1199y c1199y = this.mLayoutState;
        int i11 = z10 ? iMax2 : iMax;
        c1199y.f3737h = i11;
        if (!z10) {
            iMax = iMax2;
        }
        c1199y.f3738i = iMax;
        if (z10) {
            c1199y.f3737h = this.mOrientationHelper.mo2889h() + i11;
            View viewM2827i = m2827i();
            C1199y c1199y2 = this.mLayoutState;
            c1199y2.f3734e = this.mShouldReverseLayout ? -1 : 1;
            int position = getPosition(viewM2827i);
            C1199y c1199y3 = this.mLayoutState;
            c1199y2.f3733d = position + c1199y3.f3734e;
            c1199y3.f3731b = this.mOrientationHelper.mo2883b(viewM2827i);
            iMo2892k = this.mOrientationHelper.mo2883b(viewM2827i) - this.mOrientationHelper.mo2888g();
        } else {
            View viewM2828j = m2828j();
            C1199y c1199y4 = this.mLayoutState;
            c1199y4.f3737h = this.mOrientationHelper.mo2892k() + c1199y4.f3737h;
            C1199y c1199y5 = this.mLayoutState;
            c1199y5.f3734e = this.mShouldReverseLayout ? 1 : -1;
            int position2 = getPosition(viewM2828j);
            C1199y c1199y6 = this.mLayoutState;
            c1199y5.f3733d = position2 + c1199y6.f3734e;
            c1199y6.f3731b = this.mOrientationHelper.mo2886e(viewM2828j);
            iMo2892k = (-this.mOrientationHelper.mo2886e(viewM2828j)) + this.mOrientationHelper.mo2892k();
        }
        C1199y c1199y7 = this.mLayoutState;
        c1199y7.f3732c = i10;
        if (z7) {
            c1199y7.f3732c = i10 - iMo2892k;
        }
        c1199y7.f3736g = iMo2892k;
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public void onDetachedFromWindow(RecyclerView recyclerView, C1140e1 c1140e1) {
        onDetachedFromWindow(recyclerView);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(c1140e1);
            c1140e1.f3549a.clear();
            c1140e1.m2930g();
        }
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public View onFocusSearchFailed(View view, int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        int iConvertFocusDirectionToLayoutDirection;
        View viewFindOnePartiallyOrCompletelyInvisibleChild;
        m2832n();
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i6)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        m2833o(iConvertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.mo2893l() * MAX_SCROLL_FACTOR), false, c1162l1);
        C1199y c1199y = this.mLayoutState;
        c1199y.f3736g = Integer.MIN_VALUE;
        c1199y.f3730a = false;
        fill(c1140e1, c1199y, c1162l1, true);
        if (iConvertFocusDirectionToLayoutDirection == -1) {
            viewFindOnePartiallyOrCompletelyInvisibleChild = this.mShouldReverseLayout ? findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1) : findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
        } else {
            viewFindOnePartiallyOrCompletelyInvisibleChild = this.mShouldReverseLayout ? findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount()) : findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
        }
        View viewM2828j = iConvertFocusDirectionToLayoutDirection == -1 ? m2828j() : m2827i();
        if (!viewM2828j.hasFocusable()) {
            return viewFindOnePartiallyOrCompletelyInvisibleChild;
        }
        if (viewFindOnePartiallyOrCompletelyInvisibleChild == null) {
            return null;
        }
        return viewM2828j;
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(C1140e1 c1140e1, C1162l1 c1162l1, C3233h c3233h) {
        super.onInitializeAccessibilityNodeInfo(c1140e1, c1162l1, c3233h);
        AbstractC1158k0 abstractC1158k0 = this.mRecyclerView.mAdapter;
        if (abstractC1158k0 == null || abstractC1158k0.getItemCount() <= 0 || Build.VERSION.SDK_INT < 23) {
            return;
        }
        c3233h.m6541b(C3228c.f10849m);
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public void onLayoutChildren(C1140e1 c1140e1, C1162l1 c1162l1) {
        int iM2970b;
        View focusedChild;
        boolean z7;
        boolean z10;
        View viewFindReferenceChild;
        int iMo2886e;
        int iMo2883b;
        int iMo2892k;
        int iMo2888g;
        boolean z11;
        boolean z12;
        RecyclerView.LayoutParams layoutParams;
        int i6;
        int i10;
        int i11;
        int i12;
        int i13;
        int iM2825g;
        int i14;
        View viewFindViewByPosition;
        int iMo2886e2;
        int iMo2888g2;
        int i15;
        int i16 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && c1162l1.m2970b() == 0) {
            removeAndRecycleAllViews(c1140e1);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && (i15 = savedState.f3458a) >= 0) {
            this.mPendingScrollPosition = i15;
        }
        ensureLayoutState();
        this.mLayoutState.f3730a = false;
        m2832n();
        View focusedChild2 = getFocusedChild();
        C1193w c1193w = this.mAnchorInfo;
        if (!c1193w.f3723e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            c1193w.m2998d();
            C1193w c1193w2 = this.mAnchorInfo;
            c1193w2.f3722d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            if (c1162l1.f3621g || (i6 = this.mPendingScrollPosition) == -1) {
                if (getChildCount() != 0) {
                    focusedChild = getFocusedChild();
                    if (focusedChild != null) {
                        layoutParams = (RecyclerView.LayoutParams) focusedChild.getLayoutParams();
                        if (!layoutParams.f3465a.isRemoved() || layoutParams.f3465a.getLayoutPosition() < 0 || layoutParams.f3465a.getLayoutPosition() >= c1162l1.m2970b()) {
                            z7 = this.mLastStackFromEnd;
                            z10 = this.mStackFromEnd;
                            if (z7 == z10 || (viewFindReferenceChild = findReferenceChild(c1140e1, c1162l1, c1193w2.f3722d, z10)) == null) {
                                c1193w2.m2995a();
                                if (this.mStackFromEnd) {
                                    iM2970b = c1162l1.m2970b() - 1;
                                } else {
                                    iM2970b = 0;
                                }
                                c1193w2.f3720b = iM2970b;
                            } else {
                                c1193w2.m2996b(getPosition(viewFindReferenceChild), viewFindReferenceChild);
                                if (!c1162l1.f3621g && supportsPredictiveItemAnimations()) {
                                    iMo2886e = this.mOrientationHelper.mo2886e(viewFindReferenceChild);
                                    iMo2883b = this.mOrientationHelper.mo2883b(viewFindReferenceChild);
                                    iMo2892k = this.mOrientationHelper.mo2892k();
                                    iMo2888g = this.mOrientationHelper.mo2888g();
                                    if (iMo2883b <= iMo2892k || iMo2886e >= iMo2892k) {
                                        z11 = false;
                                    } else {
                                        z11 = true;
                                    }
                                    if (iMo2886e >= iMo2888g || iMo2883b <= iMo2888g) {
                                        z12 = false;
                                    } else {
                                        z12 = true;
                                    }
                                    if (z11 || z12) {
                                        if (c1193w2.f3722d) {
                                            iMo2892k = iMo2888g;
                                        }
                                        c1193w2.f3721c = iMo2892k;
                                    }
                                }
                            }
                        } else {
                            c1193w2.m2997c(getPosition(focusedChild), focusedChild);
                        }
                    } else {
                        z7 = this.mLastStackFromEnd;
                        z10 = this.mStackFromEnd;
                        if (z7 == z10) {
                            c1193w2.m2995a();
                            if (this.mStackFromEnd) {
                                iM2970b = c1162l1.m2970b() - 1;
                            } else {
                                iM2970b = 0;
                            }
                            c1193w2.f3720b = iM2970b;
                        } else {
                            c1193w2.m2996b(getPosition(viewFindReferenceChild), viewFindReferenceChild);
                            if (!c1162l1.f3621g) {
                                iMo2886e = this.mOrientationHelper.mo2886e(viewFindReferenceChild);
                                iMo2883b = this.mOrientationHelper.mo2883b(viewFindReferenceChild);
                                iMo2892k = this.mOrientationHelper.mo2892k();
                                iMo2888g = this.mOrientationHelper.mo2888g();
                                if (iMo2883b <= iMo2892k) {
                                    z11 = false;
                                } else {
                                    z11 = false;
                                }
                                if (iMo2886e >= iMo2888g) {
                                    z12 = false;
                                } else {
                                    z12 = false;
                                }
                                if (z11) {
                                    if (c1193w2.f3722d) {
                                        iMo2892k = iMo2888g;
                                    }
                                    c1193w2.f3721c = iMo2892k;
                                } else {
                                    if (c1193w2.f3722d) {
                                        iMo2892k = iMo2888g;
                                    }
                                    c1193w2.f3721c = iMo2892k;
                                }
                            }
                        }
                    }
                } else {
                    c1193w2.m2995a();
                    if (this.mStackFromEnd) {
                        iM2970b = c1162l1.m2970b() - 1;
                    } else {
                        iM2970b = 0;
                    }
                    c1193w2.f3720b = iM2970b;
                }
            } else if (i6 < 0 || i6 >= c1162l1.m2970b()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                if (getChildCount() != 0) {
                    focusedChild = getFocusedChild();
                    if (focusedChild != null) {
                        layoutParams = (RecyclerView.LayoutParams) focusedChild.getLayoutParams();
                        if (layoutParams.f3465a.isRemoved()) {
                            z7 = this.mLastStackFromEnd;
                            z10 = this.mStackFromEnd;
                            if (z7 == z10) {
                                c1193w2.m2995a();
                                if (this.mStackFromEnd) {
                                    iM2970b = c1162l1.m2970b() - 1;
                                } else {
                                    iM2970b = 0;
                                }
                                c1193w2.f3720b = iM2970b;
                            } else {
                                c1193w2.m2996b(getPosition(viewFindReferenceChild), viewFindReferenceChild);
                                if (!c1162l1.f3621g) {
                                    iMo2886e = this.mOrientationHelper.mo2886e(viewFindReferenceChild);
                                    iMo2883b = this.mOrientationHelper.mo2883b(viewFindReferenceChild);
                                    iMo2892k = this.mOrientationHelper.mo2892k();
                                    iMo2888g = this.mOrientationHelper.mo2888g();
                                    if (iMo2883b <= iMo2892k) {
                                        z11 = false;
                                    } else {
                                        z11 = false;
                                    }
                                    if (iMo2886e >= iMo2888g) {
                                        z12 = false;
                                    } else {
                                        z12 = false;
                                    }
                                    if (z11) {
                                        if (c1193w2.f3722d) {
                                            iMo2892k = iMo2888g;
                                        }
                                        c1193w2.f3721c = iMo2892k;
                                    } else {
                                        if (c1193w2.f3722d) {
                                            iMo2892k = iMo2888g;
                                        }
                                        c1193w2.f3721c = iMo2892k;
                                    }
                                }
                            }
                        } else {
                            z7 = this.mLastStackFromEnd;
                            z10 = this.mStackFromEnd;
                            if (z7 == z10) {
                                c1193w2.m2995a();
                                if (this.mStackFromEnd) {
                                    iM2970b = c1162l1.m2970b() - 1;
                                } else {
                                    iM2970b = 0;
                                }
                                c1193w2.f3720b = iM2970b;
                            } else {
                                c1193w2.m2996b(getPosition(viewFindReferenceChild), viewFindReferenceChild);
                                if (!c1162l1.f3621g) {
                                    iMo2886e = this.mOrientationHelper.mo2886e(viewFindReferenceChild);
                                    iMo2883b = this.mOrientationHelper.mo2883b(viewFindReferenceChild);
                                    iMo2892k = this.mOrientationHelper.mo2892k();
                                    iMo2888g = this.mOrientationHelper.mo2888g();
                                    if (iMo2883b <= iMo2892k) {
                                        z11 = false;
                                    } else {
                                        z11 = false;
                                    }
                                    if (iMo2886e >= iMo2888g) {
                                        z12 = false;
                                    } else {
                                        z12 = false;
                                    }
                                    if (z11) {
                                        if (c1193w2.f3722d) {
                                            iMo2892k = iMo2888g;
                                        }
                                        c1193w2.f3721c = iMo2892k;
                                    } else {
                                        if (c1193w2.f3722d) {
                                            iMo2892k = iMo2888g;
                                        }
                                        c1193w2.f3721c = iMo2892k;
                                    }
                                }
                            }
                        }
                    } else {
                        z7 = this.mLastStackFromEnd;
                        z10 = this.mStackFromEnd;
                        if (z7 == z10) {
                            c1193w2.m2995a();
                            if (this.mStackFromEnd) {
                                iM2970b = c1162l1.m2970b() - 1;
                            } else {
                                iM2970b = 0;
                            }
                            c1193w2.f3720b = iM2970b;
                        } else {
                            c1193w2.m2996b(getPosition(viewFindReferenceChild), viewFindReferenceChild);
                            if (!c1162l1.f3621g) {
                                iMo2886e = this.mOrientationHelper.mo2886e(viewFindReferenceChild);
                                iMo2883b = this.mOrientationHelper.mo2883b(viewFindReferenceChild);
                                iMo2892k = this.mOrientationHelper.mo2892k();
                                iMo2888g = this.mOrientationHelper.mo2888g();
                                if (iMo2883b <= iMo2892k) {
                                    z11 = false;
                                } else {
                                    z11 = false;
                                }
                                if (iMo2886e >= iMo2888g) {
                                    z12 = false;
                                } else {
                                    z12 = false;
                                }
                                if (z11) {
                                    if (c1193w2.f3722d) {
                                        iMo2892k = iMo2888g;
                                    }
                                    c1193w2.f3721c = iMo2892k;
                                } else {
                                    if (c1193w2.f3722d) {
                                        iMo2892k = iMo2888g;
                                    }
                                    c1193w2.f3721c = iMo2892k;
                                }
                            }
                        }
                    }
                } else {
                    c1193w2.m2995a();
                    if (this.mStackFromEnd) {
                        iM2970b = c1162l1.m2970b() - 1;
                    } else {
                        iM2970b = 0;
                    }
                    c1193w2.f3720b = iM2970b;
                }
            } else {
                int i17 = this.mPendingScrollPosition;
                c1193w2.f3720b = i17;
                SavedState savedState2 = this.mPendingSavedState;
                if (savedState2 != null && savedState2.f3458a >= 0) {
                    boolean z13 = savedState2.f3460c;
                    c1193w2.f3722d = z13;
                    if (z13) {
                        c1193w2.f3721c = this.mOrientationHelper.mo2888g() - this.mPendingSavedState.f3459b;
                    } else {
                        c1193w2.f3721c = this.mOrientationHelper.mo2892k() + this.mPendingSavedState.f3459b;
                    }
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View viewFindViewByPosition2 = findViewByPosition(i17);
                    if (viewFindViewByPosition2 == null) {
                        if (getChildCount() > 0) {
                            c1193w2.f3722d = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                        }
                        c1193w2.m2995a();
                    } else if (this.mOrientationHelper.mo2884c(viewFindViewByPosition2) > this.mOrientationHelper.mo2893l()) {
                        c1193w2.m2995a();
                    } else if (this.mOrientationHelper.mo2886e(viewFindViewByPosition2) - this.mOrientationHelper.mo2892k() < 0) {
                        c1193w2.f3721c = this.mOrientationHelper.mo2892k();
                        c1193w2.f3722d = false;
                    } else if (this.mOrientationHelper.mo2888g() - this.mOrientationHelper.mo2883b(viewFindViewByPosition2) < 0) {
                        c1193w2.f3721c = this.mOrientationHelper.mo2888g();
                        c1193w2.f3722d = true;
                    } else {
                        c1193w2.f3721c = c1193w2.f3722d ? this.mOrientationHelper.m2922m() + this.mOrientationHelper.mo2883b(viewFindViewByPosition2) : this.mOrientationHelper.mo2886e(viewFindViewByPosition2);
                    }
                } else {
                    boolean z14 = this.mShouldReverseLayout;
                    c1193w2.f3722d = z14;
                    if (z14) {
                        c1193w2.f3721c = this.mOrientationHelper.mo2888g() - this.mPendingScrollPositionOffset;
                    } else {
                        c1193w2.f3721c = this.mOrientationHelper.mo2892k() + this.mPendingScrollPositionOffset;
                    }
                }
            }
            this.mAnchorInfo.f3723e = true;
        } else if (focusedChild2 != null && (this.mOrientationHelper.mo2886e(focusedChild2) >= this.mOrientationHelper.mo2888g() || this.mOrientationHelper.mo2883b(focusedChild2) <= this.mOrientationHelper.mo2892k())) {
            this.mAnchorInfo.m2997c(getPosition(focusedChild2), focusedChild2);
        }
        C1199y c1199y = this.mLayoutState;
        c1199y.f3735f = c1199y.f3739j >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(c1162l1, iArr);
        int iMo2892k2 = this.mOrientationHelper.mo2892k() + Math.max(0, this.mReusableIntPair[0]);
        int iMo2889h = this.mOrientationHelper.mo2889h() + Math.max(0, this.mReusableIntPair[1]);
        if (c1162l1.f3621g && (i14 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (viewFindViewByPosition = findViewByPosition(i14)) != null) {
            if (this.mShouldReverseLayout) {
                iMo2888g2 = this.mOrientationHelper.mo2888g() - this.mOrientationHelper.mo2883b(viewFindViewByPosition);
                iMo2886e2 = this.mPendingScrollPositionOffset;
            } else {
                iMo2886e2 = this.mOrientationHelper.mo2886e(viewFindViewByPosition) - this.mOrientationHelper.mo2892k();
                iMo2888g2 = this.mPendingScrollPositionOffset;
            }
            int i18 = iMo2888g2 - iMo2886e2;
            if (i18 > 0) {
                iMo2892k2 += i18;
            } else {
                iMo2889h -= i18;
            }
        }
        C1193w c1193w3 = this.mAnchorInfo;
        if (!c1193w3.f3722d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i16 = 1;
        }
        onAnchorReady(c1140e1, c1162l1, c1193w3, i16);
        detachAndScrapAttachedViews(c1140e1);
        this.mLayoutState.f3741l = resolveIsInfinite();
        this.mLayoutState.getClass();
        this.mLayoutState.f3738i = 0;
        C1193w c1193w4 = this.mAnchorInfo;
        if (c1193w4.f3722d) {
            m2835q(c1193w4.f3720b, c1193w4.f3721c);
            C1199y c1199y2 = this.mLayoutState;
            c1199y2.f3737h = iMo2892k2;
            fill(c1140e1, c1199y2, c1162l1, false);
            C1199y c1199y3 = this.mLayoutState;
            i11 = c1199y3.f3731b;
            int i19 = c1199y3.f3733d;
            int i20 = c1199y3.f3732c;
            if (i20 > 0) {
                iMo2889h += i20;
            }
            C1193w c1193w5 = this.mAnchorInfo;
            m2834p(c1193w5.f3720b, c1193w5.f3721c);
            C1199y c1199y4 = this.mLayoutState;
            c1199y4.f3737h = iMo2889h;
            c1199y4.f3733d += c1199y4.f3734e;
            fill(c1140e1, c1199y4, c1162l1, false);
            C1199y c1199y5 = this.mLayoutState;
            i10 = c1199y5.f3731b;
            int i21 = c1199y5.f3732c;
            if (i21 > 0) {
                m2835q(i19, i11);
                C1199y c1199y6 = this.mLayoutState;
                c1199y6.f3737h = i21;
                fill(c1140e1, c1199y6, c1162l1, false);
                i11 = this.mLayoutState.f3731b;
            }
        } else {
            m2834p(c1193w4.f3720b, c1193w4.f3721c);
            C1199y c1199y7 = this.mLayoutState;
            c1199y7.f3737h = iMo2889h;
            fill(c1140e1, c1199y7, c1162l1, false);
            C1199y c1199y8 = this.mLayoutState;
            i10 = c1199y8.f3731b;
            int i22 = c1199y8.f3733d;
            int i23 = c1199y8.f3732c;
            if (i23 > 0) {
                iMo2892k2 += i23;
            }
            C1193w c1193w6 = this.mAnchorInfo;
            m2835q(c1193w6.f3720b, c1193w6.f3721c);
            C1199y c1199y9 = this.mLayoutState;
            c1199y9.f3737h = iMo2892k2;
            c1199y9.f3733d += c1199y9.f3734e;
            fill(c1140e1, c1199y9, c1162l1, false);
            C1199y c1199y10 = this.mLayoutState;
            int i24 = c1199y10.f3731b;
            int i25 = c1199y10.f3732c;
            if (i25 > 0) {
                m2834p(i22, i10);
                C1199y c1199y11 = this.mLayoutState;
                c1199y11.f3737h = i25;
                fill(c1140e1, c1199y11, c1162l1, false);
                i10 = this.mLayoutState.f3731b;
            }
            i11 = i24;
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int iM2825g2 = m2825g(i10, c1140e1, c1162l1, true);
                i12 = i11 + iM2825g2;
                i13 = i10 + iM2825g2;
                iM2825g = m2826h(i12, c1140e1, c1162l1, false);
            } else {
                int iM2826h = m2826h(i11, c1140e1, c1162l1, true);
                i12 = i11 + iM2826h;
                i13 = i10 + iM2826h;
                iM2825g = m2825g(i13, c1140e1, c1162l1, false);
            }
            i11 = i12 + iM2825g;
            i10 = i13 + iM2825g;
        }
        if (c1162l1.f3625k && getChildCount() != 0 && !c1162l1.f3621g && supportsPredictiveItemAnimations()) {
            List list = c1140e1.f3552d;
            int size = list.size();
            int position = getPosition(getChildAt(0));
            int iMo2884c = 0;
            int iMo2884c2 = 0;
            for (int i26 = 0; i26 < size; i26++) {
                AbstractC1174p1 abstractC1174p1 = (AbstractC1174p1) list.get(i26);
                if (!abstractC1174p1.isRemoved()) {
                    if ((abstractC1174p1.getLayoutPosition() < position) != this.mShouldReverseLayout) {
                        iMo2884c += this.mOrientationHelper.mo2884c(abstractC1174p1.itemView);
                    } else {
                        iMo2884c2 += this.mOrientationHelper.mo2884c(abstractC1174p1.itemView);
                    }
                }
            }
            this.mLayoutState.f3740k = list;
            if (iMo2884c > 0) {
                m2835q(getPosition(m2828j()), i11);
                C1199y c1199y12 = this.mLayoutState;
                c1199y12.f3737h = iMo2884c;
                c1199y12.f3732c = 0;
                c1199y12.m3011a(null);
                fill(c1140e1, this.mLayoutState, c1162l1, false);
            }
            if (iMo2884c2 > 0) {
                m2834p(getPosition(m2827i()), i10);
                C1199y c1199y13 = this.mLayoutState;
                c1199y13.f3737h = iMo2884c2;
                c1199y13.f3732c = 0;
                c1199y13.m3011a(null);
                fill(c1140e1, this.mLayoutState, c1162l1, false);
            }
            this.mLayoutState.f3740k = null;
        }
        if (c1162l1.f3621g) {
            this.mAnchorInfo.m2998d();
        } else {
            AbstractC1135d0 abstractC1135d0 = this.mOrientationHelper;
            abstractC1135d0.f3539b = abstractC1135d0.mo2893l();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public void onLayoutCompleted(C1162l1 c1162l1) {
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.m2998d();
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.f3458a = -1;
            }
            requestLayout();
        }
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            SavedState savedState2 = new SavedState();
            savedState2.f3458a = savedState.f3458a;
            savedState2.f3459b = savedState.f3459b;
            savedState2.f3460c = savedState.f3460c;
            return savedState2;
        }
        SavedState savedState3 = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z7 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState3.f3460c = z7;
            if (z7) {
                View viewM2827i = m2827i();
                savedState3.f3459b = this.mOrientationHelper.mo2888g() - this.mOrientationHelper.mo2883b(viewM2827i);
                savedState3.f3458a = getPosition(viewM2827i);
            } else {
                View viewM2828j = m2828j();
                savedState3.f3458a = getPosition(viewM2828j);
                savedState3.f3459b = this.mOrientationHelper.mo2886e(viewM2828j) - this.mOrientationHelper.mo2892k();
            }
        } else {
            savedState3.f3458a = -1;
        }
        return savedState3;
    }

    public final void m2834p(int i6, int i10) {
        this.mLayoutState.f3732c = this.mOrientationHelper.mo2888g() - i10;
        C1199y c1199y = this.mLayoutState;
        c1199y.f3734e = this.mShouldReverseLayout ? -1 : 1;
        c1199y.f3733d = i6;
        c1199y.f3735f = 1;
        c1199y.f3731b = i10;
        c1199y.f3736g = Integer.MIN_VALUE;
    }

    @Override
    public boolean performAccessibilityAction(int i6, Bundle bundle) {
        int iMin;
        if (super.performAccessibilityAction(i6, bundle)) {
            return true;
        }
        if (i6 == 16908343 && bundle != null) {
            if (this.mOrientation == 1) {
                int i10 = bundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT", -1);
                if (i10 < 0) {
                    return false;
                }
                RecyclerView recyclerView = this.mRecyclerView;
                iMin = Math.min(i10, getRowCountForAccessibility(recyclerView.mRecycler, recyclerView.mState) - 1);
            } else {
                int i11 = bundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT", -1);
                if (i11 < 0) {
                    return false;
                }
                RecyclerView recyclerView2 = this.mRecyclerView;
                iMin = Math.min(i11, getColumnCountForAccessibility(recyclerView2.mRecycler, recyclerView2.mState) - 1);
            }
            if (iMin >= 0) {
                scrollToPositionWithOffset(iMin, 0);
                return true;
            }
        }
        return false;
    }

    public void prepareForDrop(View view, View view2, int i6, int i10) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        m2832n();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        byte b8 = position < position2 ? (byte) 1 : (byte) -1;
        if (this.mShouldReverseLayout) {
            if (b8 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.mo2888g() - (this.mOrientationHelper.mo2884c(view) + this.mOrientationHelper.mo2886e(view2)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.mo2888g() - this.mOrientationHelper.mo2883b(view2));
                return;
            }
        }
        if (b8 == -1) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.mo2886e(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.mo2883b(view2) - this.mOrientationHelper.mo2884c(view));
        }
    }

    public final void m2835q(int i6, int i10) {
        this.mLayoutState.f3732c = i10 - this.mOrientationHelper.mo2892k();
        C1199y c1199y = this.mLayoutState;
        c1199y.f3733d = i6;
        c1199y.f3734e = this.mShouldReverseLayout ? 1 : -1;
        c1199y.f3735f = -1;
        c1199y.f3731b = i10;
        c1199y.f3736g = Integer.MIN_VALUE;
    }

    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.mo2890i() == 0 && this.mOrientationHelper.mo2887f() == 0;
    }

    public int scrollBy(int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        if (getChildCount() == 0 || i6 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f3730a = true;
        int i10 = i6 > 0 ? 1 : -1;
        int iAbs = Math.abs(i6);
        m2833o(i10, iAbs, true, c1162l1);
        C1199y c1199y = this.mLayoutState;
        int iFill = fill(c1140e1, c1199y, c1162l1, false) + c1199y.f3736g;
        if (iFill < 0) {
            return 0;
        }
        if (iAbs > iFill) {
            i6 = i10 * iFill;
        }
        this.mOrientationHelper.mo2896p(-i6);
        this.mLayoutState.f3739j = i6;
        return i6;
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public int scrollHorizontallyBy(int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i6, c1140e1, c1162l1);
    }

    @Override
    public void scrollToPosition(int i6) {
        this.mPendingScrollPosition = i6;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.f3458a = -1;
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i6, int i10) {
        this.mPendingScrollPosition = i6;
        this.mPendingScrollPositionOffset = i10;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.f3458a = -1;
        }
        requestLayout();
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public int scrollVerticallyBy(int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i6, c1140e1, c1162l1);
    }

    public void setInitialPrefetchItemCount(int i6) {
        this.mInitialPrefetchItemCount = i6;
    }

    public void setOrientation(int i6) {
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "invalid orientation:"));
        }
        assertNotInLayoutOrScroll(null);
        if (i6 != this.mOrientation || this.mOrientationHelper == null) {
            AbstractC1135d0 abstractC1135d0M2921a = AbstractC1135d0.m2921a(this, i6);
            this.mOrientationHelper = abstractC1135d0M2921a;
            this.mAnchorInfo.f3719a = abstractC1135d0M2921a;
            this.mOrientation = i6;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z7) {
        this.mRecycleChildrenOnDetach = z7;
    }

    public void setReverseLayout(boolean z7) {
        assertNotInLayoutOrScroll(null);
        if (z7 == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z7;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z7) {
        this.mSmoothScrollbarEnabled = z7;
    }

    public void setStackFromEnd(boolean z7) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z7) {
            return;
        }
        this.mStackFromEnd = z7;
        requestLayout();
    }

    @Override
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override
    @SuppressLint({"UnknownNullness"})
    public void smoothScrollToPosition(RecyclerView recyclerView, C1162l1 c1162l1, int i6) {
        C1123a0 c1123a0 = new C1123a0(recyclerView.getContext());
        c1123a0.setTargetPosition(i6);
        startSmoothScroll(c1123a0);
    }

    @Override
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int iMo2886e = this.mOrientationHelper.mo2886e(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i6 = 1; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                int position2 = getPosition(childAt);
                int iMo2886e2 = this.mOrientationHelper.mo2886e(childAt);
                if (position2 < position) {
                    m2829k();
                    StringBuilder sb = new StringBuilder("detected invalid position. loc invalid? ");
                    sb.append(iMo2886e2 < iMo2886e);
                    throw new RuntimeException(sb.toString());
                }
                if (iMo2886e2 > iMo2886e) {
                    m2829k();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i10 = 1; i10 < getChildCount(); i10++) {
            View childAt2 = getChildAt(i10);
            int position3 = getPosition(childAt2);
            int iMo2886e3 = this.mOrientationHelper.mo2886e(childAt2);
            if (position3 < position) {
                m2829k();
                StringBuilder sb2 = new StringBuilder("detected invalid position. loc invalid? ");
                sb2.append(iMo2886e3 < iMo2886e);
                throw new RuntimeException(sb2.toString());
            }
            if (iMo2886e3 < iMo2886e) {
                m2829k();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i6, int i10) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C1193w();
        this.mLayoutChunkResult = new C1196x();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView$LayoutManager$Properties properties = AbstractC1197x0.getProperties(context, attributeSet, i6, i10);
        setOrientation(properties.f3461a);
        setReverseLayout(properties.f3463c);
        setStackFromEnd(properties.f3464d);
    }

    public void onAnchorReady(C1140e1 c1140e1, C1162l1 c1162l1, C1193w c1193w, int i6) {
    }
}
