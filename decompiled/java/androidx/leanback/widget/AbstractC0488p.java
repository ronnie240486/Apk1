package androidx.leanback.widget;

import androidx.recyclerview.widget.C1178r;
import p160p.C3344h;

public abstract class AbstractC0488p {

    public C0490q f2378b;

    public boolean f2379c;

    public int f2380d;

    public int f2381e;

    public C3344h[] f2384h;

    public final Object[] f2377a = new Object[1];

    public int f2382f = -1;

    public int f2383g = -1;

    public int f2385i = -1;

    public final boolean m1449a() {
        return mo1412b(this.f2379c ? Integer.MAX_VALUE : Integer.MIN_VALUE, true);
    }

    public abstract boolean mo1412b(int i6, boolean z7);

    public final boolean m1450c(int i6) {
        if (this.f2383g < 0) {
            return false;
        }
        if (this.f2379c) {
            if (m1453i(true, null) > i6 + this.f2380d) {
                return false;
            }
        } else if (m1452g(false, null) < i6 - this.f2380d) {
            return false;
        }
        return true;
    }

    public final boolean m1451d(int i6) {
        if (this.f2383g < 0) {
            return false;
        }
        if (this.f2379c) {
            if (m1452g(false, null) < i6 - this.f2380d) {
                return false;
            }
        } else if (m1453i(true, null) > i6 + this.f2380d) {
            return false;
        }
        return true;
    }

    public abstract int mo1414f(int i6, boolean z7, int[] iArr);

    public final int m1452g(boolean z7, int[] iArr) {
        return mo1414f(this.f2379c ? this.f2382f : this.f2383g, z7, iArr);
    }

    public abstract int mo1415h(int i6, boolean z7, int[] iArr);

    public final int m1453i(boolean z7, int[] iArr) {
        return mo1415h(this.f2379c ? this.f2383g : this.f2382f, z7, iArr);
    }

    public abstract C3344h[] mo1416j(int i6, int i10);

    public abstract C0486o mo1417k(int i6);

    public void mo1426l(int i6) {
        int i10;
        if (i6 >= 0 && (i10 = this.f2383g) >= 0) {
            if (i10 >= i6) {
                this.f2383g = i6 - 1;
            }
            if (this.f2383g < this.f2382f) {
                this.f2383g = -1;
                this.f2382f = -1;
            }
            if (this.f2382f < 0) {
                this.f2385i = i6;
            }
        }
    }

    public abstract boolean mo1418m(int i6, boolean z7);

    public final void m1454n(int i6) {
        if (i6 <= 0) {
            throw new IllegalArgumentException();
        }
        if (this.f2381e == i6) {
            return;
        }
        this.f2381e = i6;
        this.f2384h = new C3344h[i6];
        for (int i10 = 0; i10 < this.f2381e; i10++) {
            this.f2384h[i10] = new C3344h();
        }
    }

    public void mo1413e(int i6, int i10, C1178r c1178r) {
    }
}
