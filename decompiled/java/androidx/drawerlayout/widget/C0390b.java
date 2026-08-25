package androidx.drawerlayout.widget;

import android.view.View;
import java.util.ArrayList;
import p000a.AbstractC0004e;
import p173q1.RunnableC3431n1;
import p187r4.AbstractC3612b;
import p226v0.C3968d;

public final class C0390b extends AbstractC3612b {

    public final int f1746c;

    public C3968d f1747d;

    public final RunnableC3431n1 f1748e = new RunnableC3431n1(8, this);

    public final DrawerLayout f1749f;

    public C0390b(DrawerLayout drawerLayout, int i6) {
        this.f1749f = drawerLayout;
        this.f1746c = i6;
    }

    @Override
    public final void mo1178D(int i6, int i10) {
        int i11 = i6 & 1;
        DrawerLayout drawerLayout = this.f1749f;
        View viewM1168d = i11 == 1 ? drawerLayout.m1168d(3) : drawerLayout.m1168d(5);
        if (viewM1168d == null || drawerLayout.m1171g(viewM1168d) != 0) {
            return;
        }
        this.f1747d.m7947b(i10, viewM1168d);
    }

    @Override
    public final void mo1179E() {
        this.f1749f.postDelayed(this.f1748e, 160L);
    }

    @Override
    public final void mo208F(int i6, View view) {
        ((DrawerLayout.LayoutParams) view.getLayoutParams()).f1739c = false;
        int i10 = this.f1746c == 3 ? 5 : 3;
        DrawerLayout drawerLayout = this.f1749f;
        View viewM1168d = drawerLayout.m1168d(i10);
        if (viewM1168d != null) {
            drawerLayout.m1166b(viewM1168d);
        }
    }

    @Override
    public final void mo209G(int i6) {
        int i10;
        int size;
        int size2;
        View rootView;
        int size3;
        View view = this.f1747d.f13497t;
        DrawerLayout drawerLayout = this.f1749f;
        int i11 = drawerLayout.f1717g.f13478a;
        int i12 = drawerLayout.f1718h.f13478a;
        if (i11 == 1 || i12 == 1) {
            i10 = 1;
        } else {
            i10 = 2;
            if (i11 != 2 && i12 != 2) {
                i10 = 0;
            }
        }
        if (view != null && i6 == 0) {
            float f = ((DrawerLayout.LayoutParams) view.getLayoutParams()).f1738b;
            if (f == 0.0f) {
                DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) view.getLayoutParams();
                if ((layoutParams.f1740d & 1) == 1) {
                    layoutParams.f1740d = 0;
                    ArrayList arrayList = drawerLayout.f1729s;
                    if (arrayList != null && (size3 = arrayList.size() - 1) >= 0) {
                        throw AbstractC0004e.m17k(size3, drawerLayout.f1729s);
                    }
                    drawerLayout.m1177q(view, false);
                    drawerLayout.m1176p(view);
                    if (drawerLayout.hasWindowFocus() && (rootView = drawerLayout.getRootView()) != null) {
                        rootView.sendAccessibilityEvent(32);
                    }
                }
            } else if (f == 1.0f) {
                DrawerLayout.LayoutParams layoutParams2 = (DrawerLayout.LayoutParams) view.getLayoutParams();
                if ((layoutParams2.f1740d & 1) == 0) {
                    layoutParams2.f1740d = 1;
                    ArrayList arrayList2 = drawerLayout.f1729s;
                    if (arrayList2 != null && (size2 = arrayList2.size() - 1) >= 0) {
                        throw AbstractC0004e.m17k(size2, drawerLayout.f1729s);
                    }
                    drawerLayout.m1177q(view, true);
                    drawerLayout.m1176p(view);
                    if (drawerLayout.hasWindowFocus()) {
                        drawerLayout.sendAccessibilityEvent(32);
                    }
                }
            }
        }
        if (i10 != drawerLayout.f1721k) {
            drawerLayout.f1721k = i10;
            ArrayList arrayList3 = drawerLayout.f1729s;
            if (arrayList3 != null && (size = arrayList3.size() - 1) >= 0) {
                throw AbstractC0004e.m17k(size, drawerLayout.f1729s);
            }
        }
    }

    @Override
    public final void mo210H(View view, int i6, int i10) {
        int width = view.getWidth();
        DrawerLayout drawerLayout = this.f1749f;
        float width2 = (drawerLayout.m1165a(3, view) ? i6 + width : drawerLayout.getWidth() - i6) / width;
        drawerLayout.m1175o(view, width2);
        view.setVisibility(width2 == 0.0f ? 4 : 0);
        drawerLayout.invalidate();
    }

    @Override
    public final void mo211I(View view, float f, float f3) {
        int i6;
        DrawerLayout drawerLayout = this.f1749f;
        drawerLayout.getClass();
        float f4 = ((DrawerLayout.LayoutParams) view.getLayoutParams()).f1738b;
        int width = view.getWidth();
        if (drawerLayout.m1165a(3, view)) {
            i6 = (f > 0.0f || (f == 0.0f && f4 > 0.5f)) ? 0 : -width;
        } else {
            int width2 = drawerLayout.getWidth();
            if (f < 0.0f || (f == 0.0f && f4 > 0.5f)) {
                width2 -= width;
            }
            i6 = width2;
        }
        this.f1747d.m7962q(i6, view.getTop());
        drawerLayout.invalidate();
    }

    @Override
    public final boolean mo212O(int i6, View view) {
        DrawerLayout drawerLayout = this.f1749f;
        drawerLayout.getClass();
        return DrawerLayout.m1164l(view) && drawerLayout.m1165a(this.f1746c, view) && drawerLayout.m1171g(view) == 0;
    }

    @Override
    public final int mo213d(int i6, View view) {
        DrawerLayout drawerLayout = this.f1749f;
        if (drawerLayout.m1165a(3, view)) {
            return Math.max(-view.getWidth(), Math.min(i6, 0));
        }
        int width = drawerLayout.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i6, width));
    }

    @Override
    public final int mo214e(int i6, View view) {
        return view.getTop();
    }

    @Override
    public final int mo215x(View view) {
        this.f1749f.getClass();
        if (DrawerLayout.m1164l(view)) {
            return view.getWidth();
        }
        return 0;
    }
}
