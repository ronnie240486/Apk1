package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.media3.common.C0565C;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p101j7.C2782c;
import p138n0.AbstractC3155s0;
import p148o0.C3232g;
import p148o0.C3233h;
import p160p.C3347k;
import p217u1.AbstractC3889a;

public abstract class AbstractC1197x0 {
    boolean mAutoMeasure;
    C1134d mChildHelper;
    private int mHeight;
    private int mHeightMode;
    C1129b2 mHorizontalBoundCheck;
    private final InterfaceC1125a2 mHorizontalBoundCheckCallback;
    boolean mIsAttachedToWindow;
    private boolean mItemPrefetchEnabled;
    private boolean mMeasurementCacheEnabled;
    int mPrefetchMaxCountObserved;
    boolean mPrefetchMaxObservedInInitialPrefetch;
    RecyclerView mRecyclerView;
    boolean mRequestedSimpleAnimations;
    AbstractC1159k1 mSmoothScroller;
    C1129b2 mVerticalBoundCheck;
    private final InterfaceC1125a2 mVerticalBoundCheckCallback;
    private int mWidth;
    private int mWidthMode;

    public AbstractC1197x0() {
        C1188u0 c1188u0 = new C1188u0(this);
        this.mHorizontalBoundCheckCallback = c1188u0;
        C1191v0 c1191v0 = new C1191v0(this);
        this.mVerticalBoundCheckCallback = c1191v0;
        this.mHorizontalBoundCheck = new C1129b2(c1188u0);
        this.mVerticalBoundCheck = new C1129b2(c1191v0);
        this.mRequestedSimpleAnimations = false;
        this.mIsAttachedToWindow = false;
        this.mAutoMeasure = false;
        this.mMeasurementCacheEnabled = true;
        this.mItemPrefetchEnabled = true;
    }

    public static boolean m3008b(int i6, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (i11 > 0 && i6 != i11) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i6;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i6;
        }
        return true;
    }

    public static int chooseSize(int i6, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? Math.max(i10, i11) : size;
        }
        return Math.min(size, Math.max(i10, i11));
    }

    @Deprecated
    public static int getChildMeasureSpec(int i6, int i10, int i11, boolean z7) {
        int i12 = i6 - i10;
        int i13 = 0;
        int iMax = Math.max(0, i12);
        if (z7) {
            if (i11 >= 0) {
                i13 = 1073741824;
            } else {
                i11 = 0;
            }
        } else if (i11 >= 0) {
            i13 = 1073741824;
        } else {
            if (i11 == -1) {
                i13 = 1073741824;
            } else if (i11 == -2) {
                i13 = Integer.MIN_VALUE;
            } else {
                i11 = 0;
            }
            i11 = iMax;
        }
        return View.MeasureSpec.makeMeasureSpec(i11, i13);
    }

    public static RecyclerView$LayoutManager$Properties getProperties(Context context, AttributeSet attributeSet, int i6, int i10) {
        RecyclerView$LayoutManager$Properties recyclerView$LayoutManager$Properties = new RecyclerView$LayoutManager$Properties();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3889a.f13075a, i6, i10);
        recyclerView$LayoutManager$Properties.f3461a = typedArrayObtainStyledAttributes.getInt(0, 1);
        recyclerView$LayoutManager$Properties.f3462b = typedArrayObtainStyledAttributes.getInt(10, 1);
        recyclerView$LayoutManager$Properties.f3463c = typedArrayObtainStyledAttributes.getBoolean(9, false);
        recyclerView$LayoutManager$Properties.f3464d = typedArrayObtainStyledAttributes.getBoolean(11, false);
        typedArrayObtainStyledAttributes.recycle();
        return recyclerView$LayoutManager$Properties;
    }

    public final void m3009a(View view, int i6, boolean z7) {
        AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (z7 || childViewHolderInt.isRemoved()) {
            C3347k c3347k = this.mRecyclerView.mViewInfoStore.f3557a;
            C1133c2 c1133c2M2908a = (C1133c2) c3347k.get(childViewHolderInt);
            if (c1133c2M2908a == null) {
                c1133c2M2908a = C1133c2.m2908a();
                c3347k.put(childViewHolderInt, c1133c2M2908a);
            }
            c1133c2M2908a.f3530a |= 1;
        } else {
            this.mRecyclerView.mViewInfoStore.m2940c(childViewHolderInt);
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            this.mChildHelper.m2910b(view, i6, view.getLayoutParams(), false);
        } else if (view.getParent() == this.mRecyclerView) {
            int iM2918j = this.mChildHelper.m2918j(view);
            if (i6 == -1) {
                i6 = this.mChildHelper.m2913e();
            }
            if (iM2918j == -1) {
                StringBuilder sb = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                sb.append(this.mRecyclerView.indexOfChild(view));
                throw new IllegalStateException(AbstractC0004e.m22p(this.mRecyclerView, sb));
            }
            if (iM2918j != i6) {
                this.mRecyclerView.mLayout.moveView(iM2918j, i6);
            }
        } else {
            this.mChildHelper.m2909a(view, i6, false);
            layoutParams.f3467c = true;
            AbstractC1159k1 abstractC1159k1 = this.mSmoothScroller;
            if (abstractC1159k1 != null && abstractC1159k1.isRunning()) {
                this.mSmoothScroller.onChildAttachedToWindow(view);
            }
        }
        if (layoutParams.f3468d) {
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d("RecyclerView", "consuming pending invalidate on child " + layoutParams.f3465a);
            }
            childViewHolderInt.itemView.invalidate();
            layoutParams.f3468d = false;
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void addDisappearingView(View view) {
        addDisappearingView(view, -1);
    }

    @SuppressLint({"UnknownNullness"})
    public void addView(View view) {
        addView(view, -1);
    }

    public void assertInLayoutOrScroll(String str) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.assertInLayoutOrScroll(str);
        }
    }

    public void assertNotInLayoutOrScroll(String str) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.assertNotInLayoutOrScroll(str);
        }
    }

    public void attachView(View view, int i6, RecyclerView.LayoutParams layoutParams) {
        AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt.isRemoved()) {
            C3347k c3347k = this.mRecyclerView.mViewInfoStore.f3557a;
            C1133c2 c1133c2M2908a = (C1133c2) c3347k.get(childViewHolderInt);
            if (c1133c2M2908a == null) {
                c1133c2M2908a = C1133c2.m2908a();
                c3347k.put(childViewHolderInt, c1133c2M2908a);
            }
            c1133c2M2908a.f3530a |= 1;
        } else {
            this.mRecyclerView.mViewInfoStore.m2940c(childViewHolderInt);
        }
        this.mChildHelper.m2910b(view, i6, layoutParams, childViewHolderInt.isRemoved());
    }

    public final void m3010c(C1140e1 c1140e1, int i6, View view) {
        AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt.shouldIgnore()) {
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d("RecyclerView", "ignoring view " + childViewHolderInt);
                return;
            }
            return;
        }
        if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
            removeViewAt(i6);
            c1140e1.m2933j(childViewHolderInt);
        } else {
            detachViewAt(i6);
            c1140e1.m2934k(view);
            this.mRecyclerView.mViewInfoStore.m2940c(childViewHolderInt);
        }
    }

    public void calculateItemDecorationsForChild(View view, Rect rect) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.getItemDecorInsetsForChild(view));
        }
    }

    public abstract boolean canScrollHorizontally();

    public abstract boolean canScrollVertically();

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams != null;
    }

    public abstract void collectAdjacentPrefetchPositions(int i6, int i10, C1162l1 c1162l1, InterfaceC1194w0 interfaceC1194w0);

    public int computeHorizontalScrollExtent(C1162l1 c1162l1) {
        return 0;
    }

    public int computeHorizontalScrollOffset(C1162l1 c1162l1) {
        return 0;
    }

    public int computeHorizontalScrollRange(C1162l1 c1162l1) {
        return 0;
    }

    public int computeVerticalScrollExtent(C1162l1 c1162l1) {
        return 0;
    }

    public int computeVerticalScrollOffset(C1162l1 c1162l1) {
        return 0;
    }

    public int computeVerticalScrollRange(C1162l1 c1162l1) {
        return 0;
    }

    public void detachAndScrapAttachedViews(C1140e1 c1140e1) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            m3010c(c1140e1, childCount, getChildAt(childCount));
        }
    }

    public void detachAndScrapView(View view, C1140e1 c1140e1) {
        m3010c(c1140e1, this.mChildHelper.m2918j(view), view);
    }

    public void detachAndScrapViewAt(int i6, C1140e1 c1140e1) {
        m3010c(c1140e1, i6, getChildAt(i6));
    }

    public void detachView(View view) {
        int iM2918j = this.mChildHelper.m2918j(view);
        if (iM2918j >= 0) {
            this.mChildHelper.m2911c(iM2918j);
        }
    }

    public void detachViewAt(int i6) {
        getChildAt(i6);
        this.mChildHelper.m2911c(i6);
    }

    public void dispatchAttachedToWindow(RecyclerView recyclerView) {
        this.mIsAttachedToWindow = true;
        onAttachedToWindow(recyclerView);
    }

    public void dispatchDetachedFromWindow(RecyclerView recyclerView, C1140e1 c1140e1) {
        this.mIsAttachedToWindow = false;
        onDetachedFromWindow(recyclerView, c1140e1);
    }

    @SuppressLint({"UnknownNullness"})
    public void endAnimation(View view) {
        AbstractC1182s0 abstractC1182s0 = this.mRecyclerView.mItemAnimator;
        if (abstractC1182s0 != null) {
            abstractC1182s0.mo2954d(RecyclerView.getChildViewHolderInt(view));
        }
    }

    public View findContainingItemView(View view) {
        View viewFindContainingItemView;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.f3535c.contains(viewFindContainingItemView)) {
            return null;
        }
        return viewFindContainingItemView;
    }

    public View findViewByPosition(int i6) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
            if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i6 && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.f3621g || !childViewHolderInt.isRemoved())) {
                return childAt;
            }
        }
        return null;
    }

    public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();

    @SuppressLint({"UnknownNullness"})
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof RecyclerView.LayoutParams) {
            return new RecyclerView.LayoutParams((RecyclerView.LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new RecyclerView.LayoutParams(layoutParams);
    }

    public int getBaseline() {
        return -1;
    }

    public int getBottomDecorationHeight(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).f3466b.bottom;
    }

    public View getChildAt(int i6) {
        C1134d c1134d = this.mChildHelper;
        if (c1134d != null) {
            return c1134d.m2912d(i6);
        }
        return null;
    }

    public int getChildCount() {
        C1134d c1134d = this.mChildHelper;
        if (c1134d != null) {
            return c1134d.m2913e();
        }
        return 0;
    }

    public boolean getClipToPadding() {
        RecyclerView recyclerView = this.mRecyclerView;
        return recyclerView != null && recyclerView.mClipToPadding;
    }

    public int getColumnCountForAccessibility(C1140e1 c1140e1, C1162l1 c1162l1) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
            return 1;
        }
        return this.mRecyclerView.mAdapter.getItemCount();
    }

    public int getDecoratedBottom(View view) {
        return getBottomDecorationHeight(view) + view.getBottom();
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public int getDecoratedLeft(View view) {
        return view.getLeft() - getLeftDecorationWidth(view);
    }

    public int getDecoratedMeasuredHeight(View view) {
        Rect rect = ((RecyclerView.LayoutParams) view.getLayoutParams()).f3466b;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public int getDecoratedMeasuredWidth(View view) {
        Rect rect = ((RecyclerView.LayoutParams) view.getLayoutParams()).f3466b;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public int getDecoratedRight(View view) {
        return getRightDecorationWidth(view) + view.getRight();
    }

    public int getDecoratedTop(View view) {
        return view.getTop() - getTopDecorationHeight(view);
    }

    public View getFocusedChild() {
        View focusedChild;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.f3535c.contains(focusedChild)) {
            return null;
        }
        return focusedChild;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getHeightMode() {
        return this.mHeightMode;
    }

    public int getItemCount() {
        RecyclerView recyclerView = this.mRecyclerView;
        AbstractC1158k0 adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    public int getItemViewType(View view) {
        return RecyclerView.getChildViewHolderInt(view).getItemViewType();
    }

    public int getLayoutDirection() {
        return this.mRecyclerView.getLayoutDirection();
    }

    public int getLeftDecorationWidth(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).f3466b.left;
    }

    public int getMinimumHeight() {
        RecyclerView recyclerView = this.mRecyclerView;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        return recyclerView.getMinimumHeight();
    }

    public int getMinimumWidth() {
        RecyclerView recyclerView = this.mRecyclerView;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        return recyclerView.getMinimumWidth();
    }

    public int getPaddingBottom() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public int getPaddingEnd() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return 0;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        return recyclerView.getPaddingEnd();
    }

    public int getPaddingLeft() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public int getPaddingRight() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public int getPaddingStart() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return 0;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        return recyclerView.getPaddingStart();
    }

    public int getPaddingTop() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int getPosition(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).f3465a.getLayoutPosition();
    }

    public int getRightDecorationWidth(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).f3466b.right;
    }

    public int getRowCountForAccessibility(C1140e1 c1140e1, C1162l1 c1162l1) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
            return 1;
        }
        return this.mRecyclerView.mAdapter.getItemCount();
    }

    public int getSelectionModeForAccessibility(C1140e1 c1140e1, C1162l1 c1162l1) {
        return 0;
    }

    public int getTopDecorationHeight(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).f3466b.top;
    }

    public void getTransformedBoundingBox(View view, boolean z7, Rect rect) {
        Matrix matrix;
        if (z7) {
            Rect rect2 = ((RecyclerView.LayoutParams) view.getLayoutParams()).f3466b;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        } else {
            rect.set(0, 0, view.getWidth(), view.getHeight());
        }
        if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.mRecyclerView.mTempRectF;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getWidthMode() {
        return this.mWidthMode;
    }

    public boolean hasFlexibleChildInBothOrientations() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            ViewGroup.LayoutParams layoutParams = getChildAt(i6).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFocus() {
        RecyclerView recyclerView = this.mRecyclerView;
        return recyclerView != null && recyclerView.hasFocus();
    }

    public void ignoreView(View view) {
        ViewParent parent = view.getParent();
        RecyclerView recyclerView = this.mRecyclerView;
        if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
            throw new IllegalArgumentException(AbstractC0004e.m22p(this.mRecyclerView, new StringBuilder("View should be fully attached to be ignored")));
        }
        AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.addFlags(128);
        this.mRecyclerView.mViewInfoStore.m2941d(childViewHolderInt);
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttachedToWindow;
    }

    public boolean isAutoMeasureEnabled() {
        return this.mAutoMeasure;
    }

    public boolean isFocused() {
        RecyclerView recyclerView = this.mRecyclerView;
        return recyclerView != null && recyclerView.isFocused();
    }

    public final boolean isItemPrefetchEnabled() {
        return this.mItemPrefetchEnabled;
    }

    public boolean isLayoutHierarchical(C1140e1 c1140e1, C1162l1 c1162l1) {
        return false;
    }

    public boolean isLayoutReversed() {
        return false;
    }

    public boolean isMeasurementCacheEnabled() {
        return this.mMeasurementCacheEnabled;
    }

    public boolean isSmoothScrolling() {
        AbstractC1159k1 abstractC1159k1 = this.mSmoothScroller;
        return abstractC1159k1 != null && abstractC1159k1.isRunning();
    }

    public boolean isViewPartiallyVisible(View view, boolean z7, boolean z10) {
        boolean z11 = this.mHorizontalBoundCheck.m2898b(view) && this.mVerticalBoundCheck.m2898b(view);
        return z7 ? z11 : !z11;
    }

    public void layoutDecorated(View view, int i6, int i10, int i11, int i12) {
        Rect rect = ((RecyclerView.LayoutParams) view.getLayoutParams()).f3466b;
        view.layout(i6 + rect.left, i10 + rect.top, i11 - rect.right, i12 - rect.bottom);
    }

    public void layoutDecoratedWithMargins(View view, int i6, int i10, int i11, int i12) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f3466b;
        view.layout(i6 + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i10 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i11 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i12 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    public void measureChild(View view, int i6, int i10) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
        int i11 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i6;
        int i12 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i10;
        int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + i11, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
        int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + i12, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
        if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
            view.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    public void measureChildWithMargins(View view, int i6, int i10) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
        int i11 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i6;
        int i12 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i10;
        int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i11, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
        int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i12, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
        if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
            view.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    public void moveView(int i6, int i10) {
        View childAt = getChildAt(i6);
        if (childAt != null) {
            detachViewAt(i6);
            attachView(childAt, i10);
        } else {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i6 + this.mRecyclerView.toString());
        }
    }

    public void offsetChildrenHorizontal(int i6) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.offsetChildrenHorizontal(i6);
        }
    }

    public void offsetChildrenVertical(int i6) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.offsetChildrenVertical(i6);
        }
    }

    public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i6, int i10) {
        return false;
    }

    @Deprecated
    public void onDetachedFromWindow(RecyclerView recyclerView) {
    }

    public View onFocusSearchFailed(View view, int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.mRecyclerView;
        onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(C3233h c3233h) {
        RecyclerView recyclerView = this.mRecyclerView;
        onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, c3233h);
    }

    public void onInitializeAccessibilityNodeInfoForItem(View view, C3233h c3233h) {
        AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt == null || childViewHolderInt.isRemoved()) {
            return;
        }
        C1134d c1134d = this.mChildHelper;
        if (c1134d.f3535c.contains(childViewHolderInt.itemView)) {
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, c3233h);
    }

    public View onInterceptFocusSearch(View view, int i6) {
        return null;
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i6, int i10) {
    }

    public abstract void onLayoutChildren(C1140e1 c1140e1, C1162l1 c1162l1);

    public abstract void onLayoutCompleted(C1162l1 c1162l1);

    public void onMeasure(C1140e1 c1140e1, C1162l1 c1162l1, int i6, int i10) {
        this.mRecyclerView.defaultOnMeasure(i6, i10);
    }

    @Deprecated
    public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
        return isSmoothScrolling() || recyclerView.isComputingLayout();
    }

    public abstract void onRestoreInstanceState(Parcelable parcelable);

    public abstract Parcelable onSaveInstanceState();

    public void onSmoothScrollerStopped(AbstractC1159k1 abstractC1159k1) {
        if (this.mSmoothScroller == abstractC1159k1) {
            this.mSmoothScroller = null;
        }
    }

    public boolean performAccessibilityAction(int i6, Bundle bundle) {
        RecyclerView recyclerView = this.mRecyclerView;
        return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i6, bundle);
    }

    public boolean performAccessibilityActionForItem(C1140e1 c1140e1, C1162l1 c1162l1, View view, int i6, Bundle bundle) {
        return false;
    }

    public void postOnAnimation(Runnable runnable) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            recyclerView.postOnAnimation(runnable);
        }
    }

    public void removeAllViews() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            this.mChildHelper.m2919k(childCount);
        }
    }

    public void removeAndRecycleAllViews(C1140e1 c1140e1) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                removeAndRecycleViewAt(childCount, c1140e1);
            }
        }
    }

    public void removeAndRecycleScrapInt(C1140e1 c1140e1) {
        ArrayList arrayList;
        int size = c1140e1.f3549a.size();
        int i6 = size - 1;
        while (true) {
            arrayList = c1140e1.f3549a;
            if (i6 < 0) {
                break;
            }
            View view = ((AbstractC1174p1) arrayList.get(i6)).itemView;
            AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.setIsRecyclable(false);
                if (childViewHolderInt.isTmpDetached()) {
                    this.mRecyclerView.removeDetachedView(view, false);
                }
                AbstractC1182s0 abstractC1182s0 = this.mRecyclerView.mItemAnimator;
                if (abstractC1182s0 != null) {
                    abstractC1182s0.mo2954d(childViewHolderInt);
                }
                childViewHolderInt.setIsRecyclable(true);
                AbstractC1174p1 childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                childViewHolderInt2.mScrapContainer = null;
                childViewHolderInt2.mInChangeScrap = false;
                childViewHolderInt2.clearReturnedFromScrapFlag();
                c1140e1.m2933j(childViewHolderInt2);
            }
            i6--;
        }
        arrayList.clear();
        ArrayList arrayList2 = c1140e1.f3550b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.mRecyclerView.invalidate();
        }
    }

    public void removeAndRecycleView(View view, C1140e1 c1140e1) {
        removeView(view);
        c1140e1.m2932i(view);
    }

    public void removeAndRecycleViewAt(int i6, C1140e1 c1140e1) {
        View childAt = getChildAt(i6);
        removeViewAt(i6);
        c1140e1.m2932i(childAt);
    }

    public boolean removeCallbacks(Runnable runnable) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.removeCallbacks(runnable);
        }
        return false;
    }

    public void removeDetachedView(View view) {
        this.mRecyclerView.removeDetachedView(view, false);
    }

    @SuppressLint({"UnknownNullness"})
    public void removeView(View view) {
        C1134d c1134d = this.mChildHelper;
        C1152i0 c1152i0 = c1134d.f3533a;
        int i6 = c1134d.f3536d;
        if (i6 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i6 == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            c1134d.f3536d = 1;
            c1134d.f3537e = view;
            int iIndexOfChild = ((RecyclerView) c1152i0.f3584a).indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (c1134d.f3534b.m2905g(iIndexOfChild)) {
                    c1134d.m2920l(view);
                }
                c1152i0.m2949c(iIndexOfChild);
            }
        } finally {
            c1134d.f3536d = 0;
            c1134d.f3537e = null;
        }
    }

    public void removeViewAt(int i6) {
        if (getChildAt(i6) != null) {
            this.mChildHelper.m2919k(i6);
        }
    }

    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z7, boolean z10) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int iWidth = rect.width() + left;
        int iHeight = rect.height() + top;
        int i6 = left - paddingLeft;
        int iMin = Math.min(0, i6);
        int i10 = top - paddingTop;
        int iMin2 = Math.min(0, i10);
        int i11 = iWidth - width;
        int iMax = Math.max(0, i11);
        int iMax2 = Math.max(0, iHeight - height);
        if (getLayoutDirection() != 1) {
            if (iMin == 0) {
                iMin = Math.min(i6, iMax);
            }
            iMax = iMin;
        } else if (iMax == 0) {
            iMax = Math.max(iMin, i11);
        }
        if (iMin2 == 0) {
            iMin2 = Math.min(i10, iMax2);
        }
        int[] iArr = {iMax, iMin2};
        int i12 = iArr[0];
        int i13 = iArr[1];
        if (z10) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild != null) {
                int paddingLeft2 = getPaddingLeft();
                int paddingTop2 = getPaddingTop();
                int width2 = getWidth() - getPaddingRight();
                int height2 = getHeight() - getPaddingBottom();
                Rect rect2 = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(focusedChild, rect2);
                if (rect2.left - i12 < width2 && rect2.right - i12 > paddingLeft2 && rect2.top - i13 < height2 && rect2.bottom - i13 > paddingTop2) {
                    if (i12 == 0) {
                    }
                    if (z7) {
                        recyclerView.scrollBy(i12, i13);
                    } else {
                        recyclerView.smoothScrollBy(i12, i13);
                    }
                    return true;
                }
            }
        } else if (i12 == 0 || i13 != 0) {
            if (z7) {
                recyclerView.scrollBy(i12, i13);
            } else {
                recyclerView.smoothScrollBy(i12, i13);
            }
            return true;
        }
        return false;
    }

    public void requestLayout() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public void requestSimpleAnimationsInNextLayout() {
        this.mRequestedSimpleAnimations = true;
    }

    public abstract int scrollHorizontallyBy(int i6, C1140e1 c1140e1, C1162l1 c1162l1);

    public abstract void scrollToPosition(int i6);

    public abstract int scrollVerticallyBy(int i6, C1140e1 c1140e1, C1162l1 c1162l1);

    @Deprecated
    public void setAutoMeasureEnabled(boolean z7) {
        this.mAutoMeasure = z7;
    }

    public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
        setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public final void setItemPrefetchEnabled(boolean z7) {
        if (z7 != this.mItemPrefetchEnabled) {
            this.mItemPrefetchEnabled = z7;
            this.mPrefetchMaxCountObserved = 0;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.mRecycler.m2937n();
            }
        }
    }

    public void setMeasureSpecs(int i6, int i10) {
        this.mWidth = View.MeasureSpec.getSize(i6);
        int mode = View.MeasureSpec.getMode(i6);
        this.mWidthMode = mode;
        if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
            this.mWidth = 0;
        }
        this.mHeight = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i10);
        this.mHeightMode = mode2;
        if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
            return;
        }
        this.mHeight = 0;
    }

    public void setMeasuredDimension(Rect rect, int i6, int i10) {
        setMeasuredDimension(chooseSize(i6, getPaddingRight() + getPaddingLeft() + rect.width(), getMinimumWidth()), chooseSize(i10, getPaddingBottom() + getPaddingTop() + rect.height(), getMinimumHeight()));
    }

    public void setMeasuredDimensionFromChildren(int i6, int i10) {
        int childCount = getChildCount();
        if (childCount == 0) {
            this.mRecyclerView.defaultOnMeasure(i6, i10);
            return;
        }
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MIN_VALUE;
        int i13 = Integer.MAX_VALUE;
        int i14 = Integer.MAX_VALUE;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(childAt, rect);
            int i16 = rect.left;
            if (i16 < i13) {
                i13 = i16;
            }
            int i17 = rect.right;
            if (i17 > i11) {
                i11 = i17;
            }
            int i18 = rect.top;
            if (i18 < i14) {
                i14 = i18;
            }
            int i19 = rect.bottom;
            if (i19 > i12) {
                i12 = i19;
            }
        }
        this.mRecyclerView.mTempRect.set(i13, i14, i11, i12);
        setMeasuredDimension(this.mRecyclerView.mTempRect, i6, i10);
    }

    public void setMeasurementCacheEnabled(boolean z7) {
        this.mMeasurementCacheEnabled = z7;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.mRecyclerView = null;
            this.mChildHelper = null;
            this.mWidth = 0;
            this.mHeight = 0;
        } else {
            this.mRecyclerView = recyclerView;
            this.mChildHelper = recyclerView.mChildHelper;
            this.mWidth = recyclerView.getWidth();
            this.mHeight = recyclerView.getHeight();
        }
        this.mWidthMode = 1073741824;
        this.mHeightMode = 1073741824;
    }

    public boolean shouldMeasureChild(View view, int i6, int i10, RecyclerView.LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && m3008b(view.getWidth(), i6, ((ViewGroup.MarginLayoutParams) layoutParams).width) && m3008b(view.getHeight(), i10, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    public boolean shouldMeasureTwice() {
        return false;
    }

    public boolean shouldReMeasureChild(View view, int i6, int i10, RecyclerView.LayoutParams layoutParams) {
        return (this.mMeasurementCacheEnabled && m3008b(view.getMeasuredWidth(), i6, ((ViewGroup.MarginLayoutParams) layoutParams).width) && m3008b(view.getMeasuredHeight(), i10, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    public abstract void smoothScrollToPosition(RecyclerView recyclerView, C1162l1 c1162l1, int i6);

    @SuppressLint({"UnknownNullness"})
    public void startSmoothScroll(AbstractC1159k1 abstractC1159k1) {
        AbstractC1159k1 abstractC1159k2 = this.mSmoothScroller;
        if (abstractC1159k2 != null && abstractC1159k1 != abstractC1159k2 && abstractC1159k2.isRunning()) {
            this.mSmoothScroller.stop();
        }
        this.mSmoothScroller = abstractC1159k1;
        abstractC1159k1.start(this.mRecyclerView, this);
    }

    public void stopIgnoringView(View view) {
        AbstractC1174p1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.stopIgnoring();
        childViewHolderInt.resetInternal();
        childViewHolderInt.addFlags(4);
    }

    public void stopSmoothScroller() {
        AbstractC1159k1 abstractC1159k1 = this.mSmoothScroller;
        if (abstractC1159k1 != null) {
            abstractC1159k1.stop();
        }
    }

    public abstract boolean supportsPredictiveItemAnimations();

    @SuppressLint({"UnknownNullness"})
    public void addDisappearingView(View view, int i6) {
        m3009a(view, i6, true);
    }

    @SuppressLint({"UnknownNullness"})
    public void addView(View view, int i6) {
        m3009a(view, i6, false);
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, C1140e1 c1140e1) {
        onDetachedFromWindow(recyclerView);
    }

    public void onInitializeAccessibilityEvent(C1140e1 c1140e1, C1162l1 c1162l1, AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || accessibilityEvent == null) {
            return;
        }
        boolean z7 = true;
        if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
            z7 = false;
        }
        accessibilityEvent.setScrollable(z7);
        AbstractC1158k0 abstractC1158k0 = this.mRecyclerView.mAdapter;
        if (abstractC1158k0 != null) {
            accessibilityEvent.setItemCount(abstractC1158k0.getItemCount());
        }
    }

    public void onInitializeAccessibilityNodeInfo(C1140e1 c1140e1, C1162l1 c1162l1, C3233h c3233h) {
        if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
            c3233h.m6540a(8192);
            c3233h.m6552n(true);
            c3233h.m6546h(C0565C.BUFFER_FLAG_NOT_DEPENDED_ON, true);
        }
        if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
            c3233h.m6540a(4096);
            c3233h.m6552n(true);
            c3233h.m6546h(C0565C.BUFFER_FLAG_NOT_DEPENDED_ON, true);
        }
        c3233h.m6548j(C2782c.m5751x(getRowCountForAccessibility(c1140e1, c1162l1), getColumnCountForAccessibility(c1140e1, c1162l1), getSelectionModeForAccessibility(c1140e1, c1162l1), isLayoutHierarchical(c1140e1, c1162l1)));
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i6, int i10, Object obj) {
        onItemsUpdated(recyclerView, i6, i10);
    }

    public boolean onRequestChildFocus(RecyclerView recyclerView, C1162l1 c1162l1, View view, View view2) {
        return onRequestChildFocus(recyclerView, view, view2);
    }

    public boolean performAccessibilityAction(C1140e1 c1140e1, C1162l1 c1162l1, int i6, Bundle bundle) {
        int paddingTop;
        int paddingLeft;
        float f;
        if (this.mRecyclerView == null) {
            return false;
        }
        int height = getHeight();
        int width = getWidth();
        Rect rect = new Rect();
        if (this.mRecyclerView.getMatrix().isIdentity() && this.mRecyclerView.getGlobalVisibleRect(rect)) {
            height = rect.height();
            width = rect.width();
        }
        if (i6 != 4096) {
            if (i6 != 8192) {
                paddingTop = 0;
            } else {
                paddingTop = this.mRecyclerView.canScrollVertically(-1) ? -((height - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    paddingLeft = -((width - getPaddingLeft()) - getPaddingRight());
                }
            }
        } else {
            paddingTop = this.mRecyclerView.canScrollVertically(1) ? (height - getPaddingTop()) - getPaddingBottom() : 0;
            paddingLeft = this.mRecyclerView.canScrollHorizontally(1) ? (width - getPaddingLeft()) - getPaddingRight() : 0;
        }
        if (paddingTop == 0 && paddingLeft == 0) {
            return false;
        }
        if (bundle != null) {
            f = bundle.getFloat("androidx.core.view.accessibility.action.ARGUMENT_SCROLL_AMOUNT_FLOAT", 1.0f);
            if (f < 0.0f) {
                if (!RecyclerView.sDebugAssertionsEnabled) {
                    return false;
                }
                throw new IllegalArgumentException("attempting to use ACTION_ARGUMENT_SCROLL_AMOUNT_FLOAT with a negative value (" + f + ")");
            }
        } else {
            f = 1.0f;
        }
        if (Float.compare(f, Float.POSITIVE_INFINITY) != 0) {
            if (Float.compare(1.0f, f) != 0 && Float.compare(0.0f, f) != 0) {
                paddingLeft = (int) (paddingLeft * f);
                paddingTop = (int) (paddingTop * f);
            }
            this.mRecyclerView.smoothScrollBy(paddingLeft, paddingTop, null, Integer.MIN_VALUE, true);
            return true;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        AbstractC1158k0 abstractC1158k0 = recyclerView.mAdapter;
        if (abstractC1158k0 == null) {
            return false;
        }
        if (i6 == 4096) {
            recyclerView.smoothScrollToPosition(abstractC1158k0.getItemCount() - 1);
        } else if (i6 == 8192) {
            recyclerView.smoothScrollToPosition(0);
        }
        return true;
    }

    public boolean performAccessibilityActionForItem(View view, int i6, Bundle bundle) {
        RecyclerView recyclerView = this.mRecyclerView;
        return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i6, bundle);
    }

    public static int getChildMeasureSpec(int i6, int i10, int i11, int i12, boolean z7) {
        int iMax = Math.max(0, i6 - i11);
        if (z7) {
            if (i12 >= 0) {
                i10 = 1073741824;
            } else if (i12 != -1 || (i10 != Integer.MIN_VALUE && (i10 == 0 || i10 != 1073741824))) {
                i10 = 0;
                i12 = 0;
            } else {
                i12 = iMax;
            }
        } else if (i12 >= 0) {
            i10 = 1073741824;
        } else {
            if (i12 != -1) {
                if (i12 == -2) {
                    i10 = (i10 == Integer.MIN_VALUE || i10 == 1073741824) ? Integer.MIN_VALUE : 0;
                } else {
                    i10 = 0;
                    i12 = 0;
                }
            }
            i12 = iMax;
        }
        return View.MeasureSpec.makeMeasureSpec(i12, i10);
    }

    @SuppressLint({"UnknownNullness"})
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new RecyclerView.LayoutParams(context, attributeSet);
    }

    public void onInitializeAccessibilityNodeInfoForItem(C1140e1 c1140e1, C1162l1 c1162l1, View view, C3233h c3233h) {
        c3233h.m6549k(C3232g.m6538a(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false));
    }

    public void setMeasuredDimension(int i6, int i10) {
        this.mRecyclerView.setMeasuredDimension(i6, i10);
    }

    public void attachView(View view, int i6) {
        attachView(view, i6, (RecyclerView.LayoutParams) view.getLayoutParams());
    }

    public void attachView(View view) {
        attachView(view, -1);
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
    }

    public void onItemsChanged(RecyclerView recyclerView) {
    }

    public void onScrollStateChanged(int i6) {
    }

    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z7) {
        return requestChildRectangleOnScreen(recyclerView, view, rect, z7, false);
    }

    public void collectInitialPrefetchPositions(int i6, InterfaceC1194w0 interfaceC1194w0) {
    }

    public void onAdapterChanged(AbstractC1158k0 abstractC1158k0, AbstractC1158k0 abstractC1158k1) {
    }

    public void onItemsAdded(RecyclerView recyclerView, int i6, int i10) {
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i6, int i10) {
    }

    public void onItemsMoved(RecyclerView recyclerView, int i6, int i10, int i11) {
    }
}
