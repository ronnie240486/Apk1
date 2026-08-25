package androidx.leanback.widget;

import android.graphics.Rect;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import com.google.android.gms.cast.framework.internal.featurehighlight.C1498f;

public final class C0490q implements InterfaceC0503w0 {

    public final Object f2429a;

    public C0490q(Object obj) {
        this.f2429a = obj;
    }

    public void m1467a(Object obj, int i6, int i10, int i11, int i12) {
        int i13;
        int i14;
        C0498u c0498u;
        int i15;
        View view = (View) obj;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) this.f2429a;
        if (i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE) {
            if (gridLayoutManager.f2095G.f2379c) {
                C0479k1 c0479k1 = (C0479k1) gridLayoutManager.f2097I.f46d;
                i12 = c0479k1.f2362i - c0479k1.f2364k;
            } else {
                i12 = ((C0479k1) gridLayoutManager.f2097I.f46d).f2363j;
            }
        }
        if (gridLayoutManager.f2095G.f2379c) {
            i13 = i12 - i10;
            i14 = i12;
        } else {
            i14 = i10 + i12;
            i13 = i12;
        }
        int iM1373m = (gridLayoutManager.m1373m(i11) + ((C0479k1) gridLayoutManager.f2097I.f47e).f2363j) - gridLayoutManager.f2126u;
        C0476j1 c0476j1 = gridLayoutManager.f2102N;
        if (((C1498f) c0476j1.f2353c) != null) {
            SparseArray<Parcelable> sparseArray = (SparseArray) ((C1498f) c0476j1.f2353c).m3615e(Integer.toString(i6));
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
            }
        }
        ((GridLayoutManager) this.f2429a).m1380t(view, i11, i13, i14, iM1373m);
        if (!gridLayoutManager.f2112g.f3621g) {
            gridLayoutManager.m1363O();
        }
        if ((gridLayoutManager.f2119n & 3) != 1 && (c0498u = gridLayoutManager.f2123r) != null) {
            boolean z7 = c0498u.f2444c;
            GridLayoutManager gridLayoutManager2 = c0498u.f2446e;
            if (z7 && (i15 = c0498u.f2445d) != 0) {
                c0498u.f2445d = gridLayoutManager2.m1386z(i15, true);
            }
            int i16 = c0498u.f2445d;
            if (i16 == 0 || ((i16 > 0 && gridLayoutManager2.m1378r()) || (c0498u.f2445d < 0 && gridLayoutManager2.m1377q()))) {
                c0498u.setTargetPosition(gridLayoutManager2.f2121p);
                c0498u.stop();
            }
        }
        gridLayoutManager.getClass();
    }

    public int m1468b(int i6, boolean z7, Object[] objArr, boolean z10) {
        int i10;
        View viewFindViewByPosition;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) this.f2429a;
        View viewM1376p = gridLayoutManager.m1376p(i6 - gridLayoutManager.f2113h);
        if (!((C0496t) viewM1376p.getLayoutParams()).f3465a.isRemoved()) {
            if (z10) {
                if (z7) {
                    gridLayoutManager.addDisappearingView(viewM1376p);
                } else {
                    gridLayoutManager.addDisappearingView(viewM1376p, 0);
                }
            } else if (z7) {
                gridLayoutManager.addView(viewM1376p);
            } else {
                gridLayoutManager.addView(viewM1376p, 0);
            }
            int i11 = gridLayoutManager.f2125t;
            if (i11 != -1) {
                viewM1376p.setVisibility(i11);
            }
            C0498u c0498u = gridLayoutManager.f2123r;
            if (c0498u != null && !c0498u.f2444c && (i10 = c0498u.f2445d) != 0) {
                GridLayoutManager gridLayoutManager2 = c0498u.f2446e;
                int i12 = i10 > 0 ? gridLayoutManager2.f2121p + gridLayoutManager2.f2093E : gridLayoutManager2.f2121p - gridLayoutManager2.f2093E;
                View view = null;
                while (c0498u.f2445d != 0 && (viewFindViewByPosition = c0498u.findViewByPosition(i12)) != null) {
                    gridLayoutManager2.getClass();
                    if (viewFindViewByPosition.getVisibility() == 0 && (!gridLayoutManager2.hasFocus() || viewFindViewByPosition.hasFocusable())) {
                        gridLayoutManager2.f2121p = i12;
                        int i13 = c0498u.f2445d;
                        if (i13 > 0) {
                            c0498u.f2445d = i13 - 1;
                        } else {
                            c0498u.f2445d = i13 + 1;
                        }
                        view = viewFindViewByPosition;
                    }
                    i12 = c0498u.f2445d > 0 ? i12 + gridLayoutManager2.f2093E : i12 - gridLayoutManager2.f2093E;
                }
                if (view != null && gridLayoutManager2.hasFocus()) {
                    gridLayoutManager2.f2119n |= 32;
                    view.requestFocus();
                    gridLayoutManager2.f2119n &= -33;
                }
            }
            if (viewM1376p.findFocus() != null) {
                ((C0496t) viewM1376p.getLayoutParams()).getClass();
            }
            int i14 = gridLayoutManager.f2119n;
            if ((i14 & 3) != 1) {
                if (i6 == gridLayoutManager.f2121p && gridLayoutManager.f2123r == null) {
                    gridLayoutManager.m1366e();
                }
            } else if ((i14 & 4) == 0) {
                int i15 = i14 & 16;
                if (i15 == 0 && i6 == gridLayoutManager.f2121p) {
                    gridLayoutManager.m1366e();
                } else if (i15 != 0 && i6 >= gridLayoutManager.f2121p && viewM1376p.hasFocusable()) {
                    gridLayoutManager.f2121p = i6;
                    gridLayoutManager.f2119n &= -17;
                    gridLayoutManager.m1366e();
                }
            }
            gridLayoutManager.m1382v(viewM1376p);
        }
        objArr[0] = viewM1376p;
        return gridLayoutManager.f2109d == 0 ? gridLayoutManager.m1370j(viewM1376p) : gridLayoutManager.m1369i(viewM1376p);
    }

    public int m1469c() {
        GridLayoutManager gridLayoutManager = (GridLayoutManager) this.f2429a;
        return gridLayoutManager.f2112g.m2970b() + gridLayoutManager.f2113h;
    }

    public int m1470d(int i6) {
        GridLayoutManager gridLayoutManager = (GridLayoutManager) this.f2429a;
        View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i6 - gridLayoutManager.f2113h);
        return (gridLayoutManager.f2119n & 262144) != 0 ? gridLayoutManager.f2110e.mo2883b(viewFindViewByPosition) : gridLayoutManager.f2110e.mo2886e(viewFindViewByPosition);
    }

    public int m1471e(int i6) {
        GridLayoutManager gridLayoutManager = (GridLayoutManager) this.f2429a;
        View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i6 - gridLayoutManager.f2113h);
        Rect rect = GridLayoutManager.f2087R;
        gridLayoutManager.getDecoratedBoundsWithMargins(viewFindViewByPosition, rect);
        return gridLayoutManager.f2109d == 0 ? rect.width() : rect.height();
    }

    public void m1472f(int i6) {
        GridLayoutManager gridLayoutManager = (GridLayoutManager) this.f2429a;
        View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i6 - gridLayoutManager.f2113h);
        if ((gridLayoutManager.f2119n & 3) == 1) {
            gridLayoutManager.detachAndScrapView(viewFindViewByPosition, gridLayoutManager.f2118m);
        } else {
            gridLayoutManager.removeAndRecycleView(viewFindViewByPosition, gridLayoutManager.f2118m);
        }
    }
}
