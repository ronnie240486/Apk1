package p138n0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;
import p056f0.C2480c;

public final class C3153r1 {

    public static final C3153r1 f10640b;

    public final C3144o1 f10641a;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f10640b = C3141n1.f10625q;
        } else {
            f10640b = C3144o1.f10631b;
        }
    }

    public C3153r1(WindowInsets windowInsets) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30) {
            this.f10641a = new C3141n1(this, windowInsets);
            return;
        }
        if (i6 >= 29) {
            this.f10641a = new C3138m1(this, windowInsets);
        } else if (i6 >= 28) {
            this.f10641a = new C3135l1(this, windowInsets);
        } else {
            this.f10641a = new C3132k1(this, windowInsets);
        }
    }

    public static C2480c m6323e(C2480c c2480c, int i6, int i10, int i11, int i12) {
        int iMax = Math.max(0, c2480c.f8681a - i6);
        int iMax2 = Math.max(0, c2480c.f8682b - i10);
        int iMax3 = Math.max(0, c2480c.f8683c - i11);
        int iMax4 = Math.max(0, c2480c.f8684d - i12);
        return (iMax == i6 && iMax2 == i10 && iMax3 == i11 && iMax4 == i12) ? c2480c : C2480c.m5515a(iMax, iMax2, iMax3, iMax4);
    }

    public static C3153r1 m6324h(WindowInsets windowInsets, View view) {
        windowInsets.getClass();
        C3153r1 c3153r1 = new C3153r1(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            C3153r1 c3153r1M6189a = Build.VERSION.SDK_INT >= 23 ? AbstractC3122h0.m6189a(view) : AbstractC3119g0.m6171j(view);
            C3144o1 c3144o1 = c3153r1.f10641a;
            c3144o1.mo6234r(c3153r1M6189a);
            c3144o1.mo6226d(view.getRootView());
        }
        return c3153r1;
    }

    public final int m6325a() {
        return this.f10641a.mo6229k().f8684d;
    }

    public final int m6326b() {
        return this.f10641a.mo6229k().f8681a;
    }

    public final int m6327c() {
        return this.f10641a.mo6229k().f8683c;
    }

    public final int m6328d() {
        return this.f10641a.mo6229k().f8682b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3153r1)) {
            return false;
        }
        return Objects.equals(this.f10641a, ((C3153r1) obj).f10641a);
    }

    public final C3153r1 m6329f(int i6, int i10, int i11, int i12) {
        AbstractC3126i1 c3120g1;
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 30) {
            c3120g1 = new C3123h1(this);
        } else {
            c3120g1 = i13 >= 29 ? new C3120g1(this) : new C3114e1(this);
        }
        c3120g1.mo6134d(C2480c.m5515a(i6, i10, i11, i12));
        return c3120g1.mo6132b();
    }

    public final WindowInsets m6330g() {
        C3144o1 c3144o1 = this.f10641a;
        if (c3144o1 instanceof C3129j1) {
            return ((C3129j1) c3144o1).f10615c;
        }
        return null;
    }

    public final int hashCode() {
        C3144o1 c3144o1 = this.f10641a;
        if (c3144o1 == null) {
            return 0;
        }
        return c3144o1.hashCode();
    }

    public C3153r1(C3153r1 c3153r1) {
        if (c3153r1 != null) {
            C3144o1 c3144o1 = c3153r1.f10641a;
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 30 && (c3144o1 instanceof C3141n1)) {
                this.f10641a = new C3141n1(this, (C3141n1) c3144o1);
            } else if (i6 >= 29 && (c3144o1 instanceof C3138m1)) {
                this.f10641a = new C3138m1(this, (C3138m1) c3144o1);
            } else if (i6 >= 28 && (c3144o1 instanceof C3135l1)) {
                this.f10641a = new C3135l1(this, (C3135l1) c3144o1);
            } else if (c3144o1 instanceof C3132k1) {
                this.f10641a = new C3132k1(this, (C3132k1) c3144o1);
            } else if (c3144o1 instanceof C3129j1) {
                this.f10641a = new C3129j1(this, (C3129j1) c3144o1);
            } else {
                this.f10641a = new C3144o1(this);
            }
            c3144o1.mo6227e(this);
            return;
        }
        this.f10641a = new C3144o1(this);
    }
}
