package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.media3.common.C0565C;
import androidx.recyclerview.widget.AbstractC1182s0;
import androidx.recyclerview.widget.AbstractC1197x0;
import androidx.recyclerview.widget.C1157k;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import p000a.AbstractC0004e;

public abstract class AbstractC0474j extends RecyclerView {

    public GridLayoutManager f2345a;

    public boolean f2346b;

    public boolean f2347c;

    public AbstractC1182s0 f2348d;

    public int f2349e;

    public int f2350f;

    public AbstractC0474j(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2346b = true;
        this.f2347c = true;
        this.f2349e = 4;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this);
        this.f2345a = gridLayoutManager;
        setLayoutManager(gridLayoutManager);
        setPreserveFocusAfterLayout(false);
        setDescendantFocusability(262144);
        setHasFixedSize(true);
        setChildrenDrawingOrderEnabled(true);
        setWillNotDraw(true);
        setOverScrollMode(2);
        ((C1157k) getItemAnimator()).f3600g = false;
        super.addRecyclerListener(new C0456d(this));
    }

    public final void m1440b(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0483m0.f2368a);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(4, false);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(3, false);
        GridLayoutManager gridLayoutManager = this.f2345a;
        gridLayoutManager.f2119n = (z7 ? 2048 : 0) | (gridLayoutManager.f2119n & (-6145)) | (z10 ? 4096 : 0);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(6, true);
        boolean z12 = typedArrayObtainStyledAttributes.getBoolean(5, true);
        GridLayoutManager gridLayoutManager2 = this.f2345a;
        gridLayoutManager2.f2119n = (z11 ? 8192 : 0) | (gridLayoutManager2.f2119n & (-24577)) | (z12 ? 16384 : 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0));
        if (gridLayoutManager2.f2109d == 1) {
            gridLayoutManager2.f2089A = dimensionPixelSize;
            gridLayoutManager2.f2090B = dimensionPixelSize;
        } else {
            gridLayoutManager2.f2089A = dimensionPixelSize;
            gridLayoutManager2.f2091C = dimensionPixelSize;
        }
        GridLayoutManager gridLayoutManager3 = this.f2345a;
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, typedArrayObtainStyledAttributes.getDimensionPixelSize(7, 0));
        if (gridLayoutManager3.f2109d == 0) {
            gridLayoutManager3.f2131z = dimensionPixelSize2;
            gridLayoutManager3.f2090B = dimensionPixelSize2;
        } else {
            gridLayoutManager3.f2131z = dimensionPixelSize2;
            gridLayoutManager3.f2091C = dimensionPixelSize2;
        }
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            setGravity(typedArrayObtainStyledAttributes.getInt(0, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override
    public final boolean dispatchGenericFocusedEvent(MotionEvent motionEvent) {
        return super.dispatchGenericFocusedEvent(motionEvent);
    }

    @Override
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override
    public final View focusSearch(int i6) {
        if (isFocused()) {
            GridLayoutManager gridLayoutManager = this.f2345a;
            View viewFindViewByPosition = gridLayoutManager.findViewByPosition(gridLayoutManager.f2121p);
            if (viewFindViewByPosition != null) {
                return focusSearch(viewFindViewByPosition, i6);
            }
        }
        return super.focusSearch(i6);
    }

    @Override
    public final int getChildDrawingOrder(int i6, int i10) {
        int iIndexOfChild;
        GridLayoutManager gridLayoutManager = this.f2345a;
        View viewFindViewByPosition = gridLayoutManager.findViewByPosition(gridLayoutManager.f2121p);
        if (viewFindViewByPosition != null && i10 >= (iIndexOfChild = indexOfChild(viewFindViewByPosition))) {
            return i10 < i6 + (-1) ? AbstractC0004e.m13g(iIndexOfChild, i6, 1, i10) : iIndexOfChild;
        }
        return i10;
    }

    public int getExtraLayoutSpace() {
        return this.f2345a.f2100L;
    }

    public int getFocusScrollStrategy() {
        return this.f2345a.f2096H;
    }

    @Deprecated
    public int getHorizontalMargin() {
        return this.f2345a.f2131z;
    }

    public int getHorizontalSpacing() {
        return this.f2345a.f2131z;
    }

    public int getInitialPrefetchItemCount() {
        return this.f2349e;
    }

    public int getItemAlignmentOffset() {
        return ((C0508z) this.f2345a.f2098J.f56d).f2453b;
    }

    public float getItemAlignmentOffsetPercent() {
        return ((C0508z) this.f2345a.f2098J.f56d).f2454c;
    }

    public int getItemAlignmentViewId() {
        return ((C0508z) this.f2345a.f2098J.f56d).f2452a;
    }

    public InterfaceC0468h getOnUnhandledKeyListener() {
        return null;
    }

    public final int getSaveChildrenLimitNumber() {
        return this.f2345a.f2102N.f2352b;
    }

    public final int getSaveChildrenPolicy() {
        return this.f2345a.f2102N.f2351a;
    }

    public int getSelectedPosition() {
        return this.f2345a.f2121p;
    }

    public int getSelectedSubPosition() {
        this.f2345a.getClass();
        return 0;
    }

    public InterfaceC0471i getSmoothScrollByBehavior() {
        return null;
    }

    public final int getSmoothScrollMaxPendingMoves() {
        return this.f2345a.f2107b;
    }

    public final float getSmoothScrollSpeedFactor() {
        return this.f2345a.f2106a;
    }

    @Deprecated
    public int getVerticalMargin() {
        return this.f2345a.f2089A;
    }

    public int getVerticalSpacing() {
        return this.f2345a.f2089A;
    }

    public int getWindowAlignment() {
        return ((C0479k1) this.f2345a.f2097I.f46d).f2359f;
    }

    public int getWindowAlignmentOffset() {
        return ((C0479k1) this.f2345a.f2097I.f46d).f2360g;
    }

    public float getWindowAlignmentOffsetPercent() {
        return ((C0479k1) this.f2345a.f2097I.f46d).f2361h;
    }

    @Override
    public final boolean hasOverlappingRendering() {
        return this.f2347c;
    }

    @Override
    public final void onFocusChanged(boolean z7, int i6, Rect rect) {
        super.onFocusChanged(z7, i6, rect);
        GridLayoutManager gridLayoutManager = this.f2345a;
        if (!z7) {
            gridLayoutManager.getClass();
            return;
        }
        int i10 = gridLayoutManager.f2121p;
        while (true) {
            View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i10);
            if (viewFindViewByPosition == null) {
                return;
            }
            if (viewFindViewByPosition.getVisibility() == 0 && viewFindViewByPosition.hasFocusable()) {
                viewFindViewByPosition.requestFocus();
                return;
            }
            i10++;
        }
    }

    @Override
    public final boolean onRequestFocusInDescendants(int i6, Rect rect) {
        int i10;
        int i11;
        int i12;
        boolean z7 = true;
        if ((this.f2350f & 1) == 1) {
            return false;
        }
        GridLayoutManager gridLayoutManager = this.f2345a;
        int i13 = gridLayoutManager.f2096H;
        if (i13 != 1 && i13 != 2) {
            View viewFindViewByPosition = gridLayoutManager.findViewByPosition(gridLayoutManager.f2121p);
            if (viewFindViewByPosition != null) {
                return viewFindViewByPosition.requestFocus(i6, rect);
            }
            return false;
        }
        int childCount = gridLayoutManager.getChildCount();
        if ((i6 & 2) != 0) {
            i11 = childCount;
            i10 = 0;
            i12 = 1;
        } else {
            i10 = childCount - 1;
            i11 = -1;
            i12 = -1;
        }
        C0479k1 c0479k1 = (C0479k1) gridLayoutManager.f2097I.f46d;
        int i14 = c0479k1.f2363j;
        int i15 = ((c0479k1.f2362i - i14) - c0479k1.f2364k) + i14;
        while (i10 != i11) {
            View childAt = gridLayoutManager.getChildAt(i10);
            if (childAt.getVisibility() == 0 && gridLayoutManager.f2110e.mo2886e(childAt) >= i14 && gridLayoutManager.f2110e.mo2883b(childAt) <= i15 && childAt.requestFocus(i6, rect)) {
                return z7;
            }
            i10 += i12;
        }
        z7 = false;
        return z7;
    }

    @Override
    public final void onRtlPropertiesChanged(int i6) {
        int i10;
        GridLayoutManager gridLayoutManager = this.f2345a;
        if (gridLayoutManager != null) {
            if (gridLayoutManager.f2109d == 0) {
                if (i6 == 1) {
                    i10 = 262144;
                } else {
                    i10 = 0;
                }
            } else if (i6 == 1) {
                i10 = 524288;
            } else {
                i10 = 0;
            }
            int i11 = gridLayoutManager.f2119n;
            if ((786432 & i11) == i10) {
                return;
            }
            gridLayoutManager.f2119n = i10 | (i11 & (-786433)) | 256;
            ((C0479k1) gridLayoutManager.f2097I.f45c).f2365l = i6 == 1;
        }
    }

    @Override
    public final void removeView(View view) {
        boolean z7 = view.hasFocus() && isFocusable();
        if (z7) {
            this.f2350f = 1 | this.f2350f;
            requestFocus();
        }
        super.removeView(view);
        if (z7) {
            this.f2350f ^= -2;
        }
    }

    @Override
    public final void removeViewAt(int i6) {
        boolean zHasFocus = getChildAt(i6).hasFocus();
        if (zHasFocus) {
            this.f2350f |= 1;
            requestFocus();
        }
        super.removeViewAt(i6);
        if (zHasFocus) {
            this.f2350f ^= -2;
        }
    }

    @Override
    public final void scrollToPosition(int i6) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        if ((gridLayoutManager.f2119n & 64) != 0) {
            gridLayoutManager.m1358J(i6, false);
        } else {
            super.scrollToPosition(i6);
        }
    }

    public void setAnimateChildLayout(boolean z7) {
        if (this.f2346b != z7) {
            this.f2346b = z7;
            if (z7) {
                super.setItemAnimator(this.f2348d);
            } else {
                this.f2348d = getItemAnimator();
                super.setItemAnimator(null);
            }
        }
    }

    public void setChildrenVisibility(int i6) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        gridLayoutManager.f2125t = i6;
        if (i6 != -1) {
            int childCount = gridLayoutManager.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                gridLayoutManager.getChildAt(i10).setVisibility(gridLayoutManager.f2125t);
            }
        }
    }

    public void setExtraLayoutSpace(int i6) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        int i10 = gridLayoutManager.f2100L;
        if (i10 == i6) {
            return;
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("ExtraLayoutSpace must >= 0");
        }
        gridLayoutManager.f2100L = i6;
        gridLayoutManager.requestLayout();
    }

    public void setFocusDrawingOrderEnabled(boolean z7) {
        super.setChildrenDrawingOrderEnabled(z7);
    }

    public void setFocusScrollStrategy(int i6) {
        if (i6 != 0 && i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException("Invalid scrollStrategy");
        }
        this.f2345a.f2096H = i6;
        requestLayout();
    }

    public final void setFocusSearchDisabled(boolean z7) {
        setDescendantFocusability(z7 ? 393216 : 262144);
        GridLayoutManager gridLayoutManager = this.f2345a;
        gridLayoutManager.f2119n = (z7 ? 32768 : 0) | (gridLayoutManager.f2119n & (-32769));
    }

    public void setGravity(int i6) {
        this.f2345a.f2092D = i6;
        requestLayout();
    }

    public void setHasOverlappingRendering(boolean z7) {
        this.f2347c = z7;
    }

    @Deprecated
    public void setHorizontalMargin(int i6) {
        setHorizontalSpacing(i6);
    }

    public void setHorizontalSpacing(int i6) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        if (gridLayoutManager.f2109d == 0) {
            gridLayoutManager.f2131z = i6;
            gridLayoutManager.f2090B = i6;
        } else {
            gridLayoutManager.f2131z = i6;
            gridLayoutManager.f2091C = i6;
        }
        requestLayout();
    }

    public void setInitialPrefetchItemCount(int i6) {
        this.f2349e = i6;
    }

    public void setItemAlignmentOffset(int i6) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        ((C0508z) gridLayoutManager.f2098J.f56d).f2453b = i6;
        gridLayoutManager.m1359K();
        requestLayout();
    }

    public void setItemAlignmentOffsetPercent(float f) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        C0508z c0508z = (C0508z) gridLayoutManager.f2098J.f56d;
        c0508z.getClass();
        if ((f < 0.0f || f > 100.0f) && f != -1.0f) {
            throw new IllegalArgumentException();
        }
        c0508z.f2454c = f;
        gridLayoutManager.m1359K();
        requestLayout();
    }

    public void setItemAlignmentOffsetWithPadding(boolean z7) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        ((C0508z) gridLayoutManager.f2098J.f56d).f2455d = z7;
        gridLayoutManager.m1359K();
        requestLayout();
    }

    public void setItemAlignmentViewId(int i6) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        ((C0508z) gridLayoutManager.f2098J.f56d).f2452a = i6;
        gridLayoutManager.m1359K();
    }

    @Deprecated
    public void setItemMargin(int i6) {
        setItemSpacing(i6);
    }

    public void setItemSpacing(int i6) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        gridLayoutManager.f2131z = i6;
        gridLayoutManager.f2089A = i6;
        gridLayoutManager.f2091C = i6;
        gridLayoutManager.f2090B = i6;
        requestLayout();
    }

    public void setLayoutEnabled(boolean z7) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        int i6 = gridLayoutManager.f2119n;
        if (((i6 & 512) != 0) != z7) {
            gridLayoutManager.f2119n = (i6 & (-513)) | (z7 ? 512 : 0);
            gridLayoutManager.requestLayout();
        }
    }

    @Override
    public void setLayoutManager(AbstractC1197x0 abstractC1197x0) {
        if (abstractC1197x0 != null) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) abstractC1197x0;
            this.f2345a = gridLayoutManager;
            gridLayoutManager.f2108c = this;
            gridLayoutManager.f2095G = null;
            super.setLayoutManager(abstractC1197x0);
            return;
        }
        super.setLayoutManager(null);
        GridLayoutManager gridLayoutManager2 = this.f2345a;
        if (gridLayoutManager2 != null) {
            gridLayoutManager2.f2108c = null;
            gridLayoutManager2.f2095G = null;
        }
        this.f2345a = null;
    }

    public void setOnChildLaidOutListener(InterfaceC0463f0 interfaceC0463f0) {
        this.f2345a.getClass();
    }

    @SuppressLint({"ReferencesDeprecated"})
    public void setOnChildSelectedListener(InterfaceC0466g0 interfaceC0466g0) {
        this.f2345a.getClass();
    }

    public void setOnChildViewHolderSelectedListener(AbstractC0469h0 abstractC0469h0) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        if (abstractC0469h0 == null) {
            gridLayoutManager.f2120o = null;
            return;
        }
        ArrayList arrayList = gridLayoutManager.f2120o;
        if (arrayList == null) {
            gridLayoutManager.f2120o = new ArrayList();
        } else {
            arrayList.clear();
        }
        gridLayoutManager.f2120o.add(abstractC0469h0);
    }

    public void setPruneChild(boolean z7) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        int i6 = gridLayoutManager.f2119n;
        int i10 = C0565C.DEFAULT_BUFFER_SEGMENT_SIZE;
        if (((i6 & C0565C.DEFAULT_BUFFER_SEGMENT_SIZE) != 0) != z7) {
            int i11 = i6 & (-65537);
            if (!z7) {
                i10 = 0;
            }
            gridLayoutManager.f2119n = i11 | i10;
            if (z7) {
                gridLayoutManager.requestLayout();
            }
        }
    }

    public final void setSaveChildrenLimitNumber(int i6) {
        C0476j1 c0476j1 = this.f2345a.f2102N;
        c0476j1.f2352b = i6;
        c0476j1.m1441a();
    }

    public final void setSaveChildrenPolicy(int i6) {
        C0476j1 c0476j1 = this.f2345a.f2102N;
        c0476j1.f2351a = i6;
        c0476j1.m1441a();
    }

    public void setScrollEnabled(boolean z7) {
        int i6;
        GridLayoutManager gridLayoutManager = this.f2345a;
        int i10 = gridLayoutManager.f2119n;
        if (((i10 & 131072) != 0) != z7) {
            int i11 = (i10 & (-131073)) | (z7 ? 131072 : 0);
            gridLayoutManager.f2119n = i11;
            if ((i11 & 131072) == 0 || gridLayoutManager.f2096H != 0 || (i6 = gridLayoutManager.f2121p) == -1) {
                return;
            }
            gridLayoutManager.m1354F(i6, true);
        }
    }

    public void setSelectedPosition(int i6) {
        this.f2345a.m1358J(i6, false);
    }

    public void setSelectedPositionSmooth(int i6) {
        this.f2345a.m1358J(i6, true);
    }

    public final void setSmoothScrollMaxPendingMoves(int i6) {
        this.f2345a.f2107b = i6;
    }

    public final void setSmoothScrollSpeedFactor(float f) {
        this.f2345a.f2106a = f;
    }

    @Deprecated
    public void setVerticalMargin(int i6) {
        setVerticalSpacing(i6);
    }

    public void setVerticalSpacing(int i6) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        if (gridLayoutManager.f2109d == 1) {
            gridLayoutManager.f2089A = i6;
            gridLayoutManager.f2090B = i6;
        } else {
            gridLayoutManager.f2089A = i6;
            gridLayoutManager.f2091C = i6;
        }
        requestLayout();
    }

    public void setWindowAlignment(int i6) {
        ((C0479k1) this.f2345a.f2097I.f46d).f2359f = i6;
        requestLayout();
    }

    public void setWindowAlignmentOffset(int i6) {
        ((C0479k1) this.f2345a.f2097I.f46d).f2360g = i6;
        requestLayout();
    }

    public void setWindowAlignmentOffsetPercent(float f) {
        C0479k1 c0479k1 = (C0479k1) this.f2345a.f2097I.f46d;
        c0479k1.getClass();
        if ((f < 0.0f || f > 100.0f) && f != -1.0f) {
            throw new IllegalArgumentException();
        }
        c0479k1.f2361h = f;
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverHighEdge(boolean z7) {
        C0479k1 c0479k1 = (C0479k1) this.f2345a.f2097I.f46d;
        c0479k1.f2358e = z7 ? c0479k1.f2358e | 2 : c0479k1.f2358e & (-3);
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverLowEdge(boolean z7) {
        C0479k1 c0479k1 = (C0479k1) this.f2345a.f2097I.f46d;
        c0479k1.f2358e = z7 ? c0479k1.f2358e | 1 : c0479k1.f2358e & (-2);
        requestLayout();
    }

    @Override
    public final void smoothScrollBy(int i6, int i10) {
        smoothScrollBy(i6, i10, null, Integer.MIN_VALUE);
    }

    @Override
    public final void smoothScrollToPosition(int i6) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        if ((gridLayoutManager.f2119n & 64) != 0) {
            gridLayoutManager.m1358J(i6, false);
        } else {
            super.smoothScrollToPosition(i6);
        }
    }

    @Override
    public final void smoothScrollBy(int i6, int i10, Interpolator interpolator) {
        smoothScrollBy(i6, i10, interpolator, Integer.MIN_VALUE);
    }

    public void setOnKeyInterceptListener(InterfaceC0459e interfaceC0459e) {
    }

    public void setOnMotionInterceptListener(InterfaceC0462f interfaceC0462f) {
    }

    public void setOnTouchInterceptListener(InterfaceC0465g interfaceC0465g) {
    }

    public void setOnUnhandledKeyListener(InterfaceC0468h interfaceC0468h) {
    }

    public final void setSmoothScrollByBehavior(InterfaceC0471i interfaceC0471i) {
    }
}
