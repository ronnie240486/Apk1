package androidx.leanback.widget;

import androidx.recyclerview.widget.C1178r;
import p160p.C3344h;

public final class C0452b1 extends AbstractC0488p {

    public final C0486o f2314j = new C0486o(0);

    public C0452b1() {
        m1454n(1);
    }

    @Override
    public final boolean mo1412b(int i6, boolean z7) {
        int iMin;
        int iM1471e;
        if (this.f2378b.m1469c() == 0) {
            return false;
        }
        if (!z7 && m1450c(i6)) {
            return false;
        }
        int i10 = this.f2383g;
        if (i10 >= 0) {
            iMin = i10 + 1;
        } else {
            int i11 = this.f2385i;
            iMin = i11 != -1 ? Math.min(i11, this.f2378b.m1469c() - 1) : 0;
        }
        boolean z10 = false;
        while (iMin < this.f2378b.m1469c()) {
            C0490q c0490q = this.f2378b;
            Object[] objArr = this.f2377a;
            int iM1468b = c0490q.m1468b(iMin, true, objArr, false);
            if (this.f2382f < 0 || this.f2383g < 0) {
                iM1471e = this.f2379c ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                this.f2382f = iMin;
                this.f2383g = iMin;
            } else {
                if (this.f2379c) {
                    int i12 = iMin - 1;
                    iM1471e = (this.f2378b.m1470d(i12) - this.f2378b.m1471e(i12)) - this.f2380d;
                } else {
                    int i13 = iMin - 1;
                    iM1471e = this.f2380d + this.f2378b.m1471e(i13) + this.f2378b.m1470d(i13);
                }
                this.f2383g = iMin;
            }
            this.f2378b.m1467a(objArr[0], iMin, iM1468b, 0, iM1471e);
            if (z7 || m1450c(i6)) {
                return true;
            }
            iMin++;
            z10 = true;
        }
        return z10;
    }

    @Override
    public final void mo1413e(int i6, int i10, C1178r c1178r) {
        int iM1419o;
        int iM1470d;
        if (!this.f2379c ? i10 < 0 : i10 > 0) {
            if (this.f2383g == this.f2378b.m1469c() - 1) {
                return;
            }
            int i11 = this.f2383g;
            if (i11 >= 0) {
                iM1419o = i11 + 1;
            } else {
                int i12 = this.f2385i;
                iM1419o = i12 != -1 ? Math.min(i12, this.f2378b.m1469c() - 1) : 0;
            }
            int iM1471e = this.f2378b.m1471e(this.f2383g) + this.f2380d;
            int iM1470d2 = this.f2378b.m1470d(this.f2383g);
            if (this.f2379c) {
                iM1471e = -iM1471e;
            }
            iM1470d = iM1471e + iM1470d2;
        } else {
            if (this.f2382f == 0) {
                return;
            }
            iM1419o = m1419o();
            iM1470d = this.f2378b.m1470d(this.f2382f) + (this.f2379c ? this.f2380d : -this.f2380d);
        }
        c1178r.m2986a(iM1419o, Math.abs(iM1470d - i6));
    }

    @Override
    public final int mo1414f(int i6, boolean z7, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i6;
        }
        if (this.f2379c) {
            return this.f2378b.m1470d(i6);
        }
        return this.f2378b.m1471e(i6) + this.f2378b.m1470d(i6);
    }

    @Override
    public final int mo1415h(int i6, boolean z7, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i6;
        }
        return this.f2379c ? this.f2378b.m1470d(i6) - this.f2378b.m1471e(i6) : this.f2378b.m1470d(i6);
    }

    @Override
    public final C3344h[] mo1416j(int i6, int i10) {
        C3344h c3344h = this.f2384h[0];
        c3344h.f11324c = c3344h.f11323b;
        c3344h.m6791a(i6);
        this.f2384h[0].m6791a(i10);
        return this.f2384h;
    }

    @Override
    public final C0486o mo1417k(int i6) {
        return this.f2314j;
    }

    @Override
    public final boolean mo1418m(int i6, boolean z7) {
        int iM1470d;
        if (this.f2378b.m1469c() == 0) {
            return false;
        }
        if (!z7 && m1451d(i6)) {
            return false;
        }
        int i10 = ((GridLayoutManager) this.f2378b.f2429a).f2113h;
        boolean z10 = false;
        for (int iM1419o = m1419o(); iM1419o >= i10; iM1419o--) {
            C0490q c0490q = this.f2378b;
            Object[] objArr = this.f2377a;
            int iM1468b = c0490q.m1468b(iM1419o, false, objArr, false);
            if (this.f2382f < 0 || this.f2383g < 0) {
                iM1470d = this.f2379c ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                this.f2382f = iM1419o;
                this.f2383g = iM1419o;
            } else {
                iM1470d = this.f2379c ? this.f2378b.m1470d(iM1419o + 1) + this.f2380d + iM1468b : (this.f2378b.m1470d(iM1419o + 1) - this.f2380d) - iM1468b;
                this.f2382f = iM1419o;
            }
            this.f2378b.m1467a(objArr[0], iM1419o, iM1468b, 0, iM1470d);
            z10 = true;
            if (z7 || m1451d(i6)) {
                break;
            }
        }
        return z10;
    }

    public final int m1419o() {
        int i6 = this.f2382f;
        if (i6 >= 0) {
            return i6 - 1;
        }
        int i10 = this.f2385i;
        return i10 != -1 ? Math.min(i10, this.f2378b.m1469c() - 1) : this.f2378b.m1469c() - 1;
    }
}
