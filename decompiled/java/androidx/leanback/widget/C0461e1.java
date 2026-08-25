package androidx.leanback.widget;

import p103j9.AbstractC2796i;
import p160p.C3343g;
import p160p.C3344h;

public final class C0461e1 extends AbstractC0488p {

    public C3343g f2327j;

    public int f2328k;

    public Object f2329l;

    public int f2330m;

    @Override
    public final boolean mo1412b(int i6, boolean z7) {
        Object[] objArr = this.f2377a;
        if (this.f2378b.m1469c() == 0) {
            return false;
        }
        if (!z7 && m1450c(i6)) {
            return false;
        }
        try {
            if (m1427o(i6, z7)) {
                return true;
            }
            return m1429q(i6, z7);
        } finally {
            objArr[0] = null;
            this.f2329l = null;
        }
    }

    @Override
    public final int mo1414f(int i6, boolean z7, int[] iArr) {
        int i10;
        int iM1470d = this.f2378b.m1470d(i6);
        C0458d1 c0458d1Mo1417k = mo1417k(i6);
        int i11 = c0458d1Mo1417k.f2374a;
        if (this.f2379c) {
            i10 = i11;
            int i12 = i10;
            int i13 = 1;
            int i14 = iM1470d;
            for (int i15 = i6 + 1; i13 < this.f2381e && i15 <= this.f2383g; i15++) {
                C0458d1 c0458d1Mo1417k2 = mo1417k(i15);
                i14 += c0458d1Mo1417k2.f2325b;
                int i16 = c0458d1Mo1417k2.f2374a;
                if (i16 != i12) {
                    i13++;
                    if (!z7 ? i14 >= iM1470d : i14 <= iM1470d) {
                        i12 = i16;
                    } else {
                        iM1470d = i14;
                        i6 = i15;
                        i10 = i16;
                        i12 = i10;
                    }
                }
            }
        } else {
            int i17 = 1;
            int i18 = i11;
            C0458d1 c0458d1Mo1417k3 = c0458d1Mo1417k;
            int i19 = iM1470d;
            iM1470d = this.f2378b.m1471e(i6) + iM1470d;
            i10 = i18;
            for (int i20 = i6 - 1; i17 < this.f2381e && i20 >= this.f2382f; i20--) {
                i19 -= c0458d1Mo1417k3.f2325b;
                c0458d1Mo1417k3 = mo1417k(i20);
                int i21 = c0458d1Mo1417k3.f2374a;
                if (i21 != i18) {
                    i17++;
                    int iM1471e = this.f2378b.m1471e(i20) + i19;
                    if (!z7 ? iM1471e >= iM1470d : iM1471e <= iM1470d) {
                        i18 = i21;
                    } else {
                        iM1470d = iM1471e;
                        i6 = i20;
                        i10 = i21;
                        i18 = i10;
                    }
                }
            }
        }
        if (iArr != null) {
            iArr[0] = i10;
            iArr[1] = i6;
        }
        return iM1470d;
    }

    @Override
    public final int mo1415h(int i6, boolean z7, int[] iArr) {
        int iM1471e;
        int iM1470d = this.f2378b.m1470d(i6);
        C0458d1 c0458d1Mo1417k = mo1417k(i6);
        int i10 = c0458d1Mo1417k.f2374a;
        if (this.f2379c) {
            int i11 = 1;
            iM1471e = iM1470d - this.f2378b.m1471e(i6);
            int i12 = i10;
            for (int i13 = i6 - 1; i11 < this.f2381e && i13 >= this.f2382f; i13--) {
                iM1470d -= c0458d1Mo1417k.f2325b;
                c0458d1Mo1417k = mo1417k(i13);
                int i14 = c0458d1Mo1417k.f2374a;
                if (i14 != i12) {
                    i11++;
                    int iM1471e2 = iM1470d - this.f2378b.m1471e(i13);
                    if (!z7 ? iM1471e2 >= iM1471e : iM1471e2 <= iM1471e) {
                        i12 = i14;
                    } else {
                        iM1471e = iM1471e2;
                        i6 = i13;
                        i10 = i14;
                        i12 = i10;
                    }
                }
            }
        } else {
            int i15 = i10;
            int i16 = i15;
            int i17 = 1;
            int i18 = iM1470d;
            for (int i19 = i6 + 1; i17 < this.f2381e && i19 <= this.f2383g; i19++) {
                C0458d1 c0458d1Mo1417k2 = mo1417k(i19);
                i18 += c0458d1Mo1417k2.f2325b;
                int i20 = c0458d1Mo1417k2.f2374a;
                if (i20 != i16) {
                    i17++;
                    if (!z7 ? i18 >= iM1470d : i18 <= iM1470d) {
                        i16 = i20;
                    } else {
                        iM1470d = i18;
                        i6 = i19;
                        i15 = i20;
                        i16 = i15;
                    }
                }
            }
            iM1471e = iM1470d;
            i10 = i15;
        }
        if (iArr != null) {
            iArr[0] = i10;
            iArr[1] = i6;
        }
        return iM1471e;
    }

    @Override
    public final C3344h[] mo1416j(int i6, int i10) {
        for (int i11 = 0; i11 < this.f2381e; i11++) {
            C3344h c3344h = this.f2384h[i11];
            c3344h.f11324c = c3344h.f11323b;
        }
        if (i6 >= 0) {
            while (i6 <= i10) {
                C3344h c3344h2 = this.f2384h[mo1417k(i6).f2374a];
                if (c3344h2.m6793c() <= 0) {
                    c3344h2.m6791a(i6);
                    c3344h2.m6791a(i6);
                } else {
                    int i12 = c3344h2.f11323b;
                    int i13 = c3344h2.f11324c;
                    if (i12 == i13) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    int[] iArr = c3344h2.f11322a;
                    int i14 = c3344h2.f11325d;
                    if (iArr[(i13 - 1) & i14] != i6 - 1) {
                        c3344h2.m6791a(i6);
                        c3344h2.m6791a(i6);
                    } else {
                        if (i12 == i13) {
                            throw new ArrayIndexOutOfBoundsException();
                        }
                        int i15 = (i13 - 1) & i14;
                        int i16 = iArr[i15];
                        c3344h2.f11324c = i15;
                        c3344h2.m6791a(i6);
                    }
                }
                i6++;
            }
        }
        return this.f2384h;
    }

    @Override
    public final void mo1426l(int i6) {
        super.mo1426l(i6);
        int iM1431s = (m1431s() - i6) + 1;
        C3343g c3343g = this.f2327j;
        c3343g.m6788d(iM1431s);
        if (c3343g.m6790f() == 0) {
            this.f2328k = -1;
        }
    }

    @Override
    public final boolean mo1418m(int i6, boolean z7) {
        Object[] objArr = this.f2377a;
        if (this.f2378b.m1469c() == 0) {
            return false;
        }
        if (!z7 && m1451d(i6)) {
            return false;
        }
        try {
            if (m1435w(i6, z7)) {
                return true;
            }
            return m1437y(i6, z7);
        } finally {
            objArr[0] = null;
            this.f2329l = null;
        }
    }

    public final boolean m1427o(int i6, boolean z7) {
        int i10;
        int iM1470d;
        int i11;
        C3343g c3343g = this.f2327j;
        if (c3343g.m6790f() == 0) {
            return false;
        }
        int iM1469c = this.f2378b.m1469c();
        int i12 = this.f2383g;
        if (i12 >= 0) {
            i10 = i12 + 1;
            iM1470d = this.f2378b.m1470d(i12);
        } else {
            int i13 = this.f2385i;
            i10 = i13 != -1 ? i13 : 0;
            if (i10 > m1431s() + 1 || i10 < this.f2328k) {
                c3343g.m6789e(c3343g.m6790f());
                return false;
            }
            if (i10 > m1431s()) {
                return false;
            }
            iM1470d = Integer.MAX_VALUE;
        }
        int iM1431s = m1431s();
        int i14 = i10;
        while (i14 < iM1469c && i14 <= iM1431s) {
            C0458d1 c0458d1Mo1417k = mo1417k(i14);
            if (iM1470d != Integer.MAX_VALUE) {
                iM1470d += c0458d1Mo1417k.f2325b;
            }
            int i15 = c0458d1Mo1417k.f2374a;
            C0490q c0490q = this.f2378b;
            Object[] objArr = this.f2377a;
            int iM1468b = c0490q.m1468b(i14, true, objArr, false);
            if (iM1468b != c0458d1Mo1417k.f2326c) {
                c0458d1Mo1417k.f2326c = iM1468b;
                c3343g.m6788d(iM1431s - i14);
                i11 = i14;
            } else {
                i11 = iM1431s;
            }
            this.f2383g = i14;
            if (this.f2382f < 0) {
                this.f2382f = i14;
            }
            this.f2378b.m1467a(objArr[0], i14, iM1468b, i15, iM1470d);
            if (!z7 && m1450c(i6)) {
                return true;
            }
            if (iM1470d == Integer.MAX_VALUE) {
                iM1470d = this.f2378b.m1470d(i14);
            }
            if (i15 == this.f2381e - 1 && z7) {
                return true;
            }
            i14++;
            iM1431s = i11;
        }
        return false;
    }

    public final int m1428p(int i6, int i10, int i11) {
        int iM1470d;
        int i12 = this.f2383g;
        if (i12 >= 0 && (i12 != m1431s() || this.f2383g != i6 - 1)) {
            throw new IllegalStateException();
        }
        int i13 = this.f2383g;
        C3343g c3343g = this.f2327j;
        if (i13 >= 0) {
            iM1470d = i11 - this.f2378b.m1470d(i13);
        } else if (c3343g.m6790f() <= 0 || i6 != m1431s() + 1) {
            iM1470d = 0;
        } else {
            int iM1431s = m1431s();
            while (true) {
                if (iM1431s < this.f2328k) {
                    iM1431s = m1431s();
                    break;
                }
                if (mo1417k(iM1431s).f2374a == i10) {
                    break;
                }
                iM1431s--;
            }
            iM1470d = this.f2379c ? (-mo1417k(iM1431s).f2326c) - this.f2380d : mo1417k(iM1431s).f2326c + this.f2380d;
            for (int i14 = iM1431s + 1; i14 <= m1431s(); i14++) {
                iM1470d -= mo1417k(i14).f2325b;
            }
        }
        C0458d1 c0458d1 = new C0458d1(i10, iM1470d);
        Object[] objArr = c3343g.f11321d;
        int i15 = c3343g.f11319b;
        objArr[i15] = c0458d1;
        int i16 = c3343g.f11320c & (i15 + 1);
        c3343g.f11319b = i16;
        if (i16 == c3343g.f11318a) {
            c3343g.m6786b();
        }
        Object obj = this.f2329l;
        if (obj != null) {
            c0458d1.f2326c = this.f2330m;
            this.f2329l = null;
        } else {
            C0490q c0490q = this.f2378b;
            Object[] objArr2 = this.f2377a;
            c0458d1.f2326c = c0490q.m1468b(i6, true, objArr2, false);
            obj = objArr2[0];
        }
        Object obj2 = obj;
        if (c3343g.m6790f() == 1) {
            this.f2383g = i6;
            this.f2382f = i6;
            this.f2328k = i6;
        } else {
            int i17 = this.f2383g;
            if (i17 < 0) {
                this.f2383g = i6;
                this.f2382f = i6;
            } else {
                this.f2383g = i17 + 1;
            }
        }
        this.f2378b.m1467a(obj2, i6, c0458d1.f2326c, i10, i11);
        return c0458d1.f2326c;
    }

    public final boolean m1429q(int i6, boolean z7) {
        int i10;
        int i11;
        boolean z10;
        int iM1434v;
        int i12;
        int i13;
        int iM1469c = this.f2378b.m1469c();
        int i14 = this.f2383g;
        if (i14 < 0) {
            int i15 = this.f2385i;
            i10 = i15 != -1 ? i15 : 0;
            i11 = (this.f2327j.m6790f() > 0 ? mo1417k(m1431s()).f2374a + 1 : i10) % this.f2381e;
            z10 = false;
            iM1434v = 0;
        } else {
            if (i14 < m1431s()) {
                return false;
            }
            int i16 = this.f2383g;
            i10 = i16 + 1;
            i11 = mo1417k(i16).f2374a;
            int iM1430r = m1430r(true);
            if (iM1430r < 0) {
                iM1434v = Integer.MIN_VALUE;
                for (int i17 = 0; i17 < this.f2381e; i17++) {
                    iM1434v = this.f2379c ? m1434v(i17) : m1433u(i17);
                    if (iM1434v != Integer.MIN_VALUE) {
                        break;
                    }
                }
            } else {
                iM1434v = this.f2379c ? mo1415h(iM1430r, false, null) : mo1414f(iM1430r, true, null);
            }
            if (!this.f2379c ? m1433u(i11) >= iM1434v : m1434v(i11) <= iM1434v) {
                i11++;
                if (i11 == this.f2381e) {
                    iM1434v = this.f2379c ? m1453i(false, null) : m1452g(true, null);
                    i11 = 0;
                }
            }
            z10 = true;
        }
        boolean z11 = false;
        while (true) {
            if (i11 < this.f2381e) {
                if (i10 == iM1469c || (!z7 && m1450c(i6))) {
                    break;
                }
                int iM1434v2 = this.f2379c ? m1434v(i11) : m1433u(i11);
                if (iM1434v2 != Integer.MAX_VALUE && iM1434v2 != Integer.MIN_VALUE) {
                    if (this.f2379c) {
                        i13 = this.f2380d;
                        i12 = -i13;
                    } else {
                        i12 = this.f2380d;
                    }
                    iM1434v2 += i12;
                } else if (i11 == 0) {
                    iM1434v2 = this.f2379c ? m1434v(this.f2381e - 1) : m1433u(this.f2381e - 1);
                    if (iM1434v2 != Integer.MAX_VALUE && iM1434v2 != Integer.MIN_VALUE) {
                        if (this.f2379c) {
                            i13 = this.f2380d;
                            i12 = -i13;
                        } else {
                            i12 = this.f2380d;
                        }
                        iM1434v2 += i12;
                    }
                } else {
                    iM1434v2 = this.f2379c ? m1433u(i11 - 1) : m1434v(i11 - 1);
                }
                int i18 = i10 + 1;
                int iM1428p = m1428p(i10, i11, iM1434v2);
                if (z10) {
                    while (true) {
                        if (!this.f2379c) {
                            if (iM1434v2 + iM1428p >= iM1434v) {
                                break;
                            }
                            if (i18 != iM1469c) {
                            }
                            return true;
                        }
                        if (iM1434v2 - iM1428p <= iM1434v) {
                            break;
                        }
                        if (i18 != iM1469c || (!z7 && m1450c(i6))) {
                            return true;
                        }
                        iM1434v2 += this.f2379c ? (-iM1428p) - this.f2380d : iM1428p + this.f2380d;
                        int i19 = i18 + 1;
                        int iM1428p2 = m1428p(i18, i11, iM1434v2);
                        i18 = i19;
                        iM1428p = iM1428p2;
                    }
                    i10 = i18;
                } else {
                    iM1434v = this.f2379c ? m1434v(i11) : m1433u(i11);
                    i10 = i18;
                    z10 = true;
                }
                i11++;
                z11 = true;
            } else {
                if (z7) {
                    return z11;
                }
                iM1434v = this.f2379c ? m1453i(false, null) : m1452g(true, null);
                i11 = 0;
            }
        }
        return z11;
    }

    public final int m1430r(boolean z7) {
        boolean z10 = false;
        if (z7) {
            for (int i6 = this.f2383g; i6 >= this.f2382f; i6--) {
                int i10 = mo1417k(i6).f2374a;
                if (i10 == 0) {
                    z10 = true;
                } else if (z10 && i10 == this.f2381e - 1) {
                    return i6;
                }
            }
            return -1;
        }
        for (int i11 = this.f2382f; i11 <= this.f2383g; i11++) {
            int i12 = mo1417k(i11).f2374a;
            if (i12 == this.f2381e - 1) {
                z10 = true;
            } else if (z10 && i12 == 0) {
                return i11;
            }
        }
        return -1;
    }

    public final int m1431s() {
        return (this.f2327j.m6790f() + this.f2328k) - 1;
    }

    @Override
    public final C0458d1 mo1417k(int i6) {
        int i10 = i6 - this.f2328k;
        if (i10 < 0) {
            return null;
        }
        C3343g c3343g = this.f2327j;
        if (i10 >= c3343g.m6790f()) {
            return null;
        }
        if (i10 < 0) {
            c3343g.getClass();
        } else if (i10 < c3343g.m6790f()) {
            Object obj = c3343g.f11321d[c3343g.f11320c & (c3343g.f11318a + i10)];
            AbstractC2796i.m5782c(obj);
            return (C0458d1) obj;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int m1433u(int i6) {
        int i10;
        C0458d1 c0458d1Mo1417k;
        int i11 = this.f2382f;
        if (i11 < 0) {
            return Integer.MIN_VALUE;
        }
        if (this.f2379c) {
            int iM1470d = this.f2378b.m1470d(i11);
            if (mo1417k(this.f2382f).f2374a == i6) {
                return iM1470d;
            }
            int i12 = this.f2382f;
            do {
                i12++;
                if (i12 <= m1431s()) {
                    c0458d1Mo1417k = mo1417k(i12);
                    iM1470d += c0458d1Mo1417k.f2325b;
                }
            } while (c0458d1Mo1417k.f2374a != i6);
            return iM1470d;
        }
        int iM1470d2 = this.f2378b.m1470d(this.f2383g);
        C0458d1 c0458d1Mo1417k2 = mo1417k(this.f2383g);
        if (c0458d1Mo1417k2.f2374a == i6) {
            i10 = c0458d1Mo1417k2.f2326c;
        } else {
            int i13 = this.f2383g;
            do {
                i13--;
                if (i13 >= this.f2328k) {
                    iM1470d2 -= c0458d1Mo1417k2.f2325b;
                    c0458d1Mo1417k2 = mo1417k(i13);
                }
            } while (c0458d1Mo1417k2.f2374a != i6);
            i10 = c0458d1Mo1417k2.f2326c;
        }
        return iM1470d2 + i10;
        return Integer.MIN_VALUE;
    }

    public final int m1434v(int i6) {
        C0458d1 c0458d1Mo1417k;
        int i10;
        int i11 = this.f2382f;
        if (i11 < 0) {
            return Integer.MAX_VALUE;
        }
        if (!this.f2379c) {
            int iM1470d = this.f2378b.m1470d(i11);
            if (mo1417k(this.f2382f).f2374a == i6) {
                return iM1470d;
            }
            int i12 = this.f2382f;
            do {
                i12++;
                if (i12 <= m1431s()) {
                    c0458d1Mo1417k = mo1417k(i12);
                    iM1470d += c0458d1Mo1417k.f2325b;
                }
            } while (c0458d1Mo1417k.f2374a != i6);
            return iM1470d;
        }
        int iM1470d2 = this.f2378b.m1470d(this.f2383g);
        C0458d1 c0458d1Mo1417k2 = mo1417k(this.f2383g);
        if (c0458d1Mo1417k2.f2374a == i6) {
            i10 = c0458d1Mo1417k2.f2326c;
        } else {
            int i13 = this.f2383g;
            do {
                i13--;
                if (i13 >= this.f2328k) {
                    iM1470d2 -= c0458d1Mo1417k2.f2325b;
                    c0458d1Mo1417k2 = mo1417k(i13);
                }
            } while (c0458d1Mo1417k2.f2374a != i6);
            i10 = c0458d1Mo1417k2.f2326c;
        }
        return iM1470d2 - i10;
        return Integer.MAX_VALUE;
    }

    public final boolean m1435w(int i6, boolean z7) {
        int i10;
        int iM1470d;
        int i11;
        C3343g c3343g = this.f2327j;
        if (c3343g.m6790f() == 0) {
            return false;
        }
        int i12 = this.f2382f;
        if (i12 < 0) {
            int i13 = this.f2385i;
            i10 = i13 != -1 ? i13 : 0;
            if (i10 <= m1431s()) {
                int i14 = this.f2328k;
                if (i10 >= i14 - 1) {
                    if (i10 < i14) {
                        return false;
                    }
                    iM1470d = Integer.MAX_VALUE;
                    i11 = 0;
                }
            }
            c3343g.m6789e(c3343g.m6790f());
            return false;
        }
        iM1470d = this.f2378b.m1470d(i12);
        i11 = mo1417k(this.f2382f).f2325b;
        i10 = this.f2382f - 1;
        int iMax = Math.max(((GridLayoutManager) this.f2378b.f2429a).f2113h, this.f2328k);
        while (i10 >= iMax) {
            C0458d1 c0458d1Mo1417k = mo1417k(i10);
            int i15 = c0458d1Mo1417k.f2374a;
            C0490q c0490q = this.f2378b;
            Object[] objArr = this.f2377a;
            int iM1468b = c0490q.m1468b(i10, false, objArr, false);
            if (iM1468b != c0458d1Mo1417k.f2326c) {
                c3343g.m6789e((i10 + 1) - this.f2328k);
                this.f2328k = this.f2382f;
                this.f2329l = objArr[0];
                this.f2330m = iM1468b;
                return false;
            }
            this.f2382f = i10;
            if (this.f2383g < 0) {
                this.f2383g = i10;
            }
            this.f2378b.m1467a(objArr[0], i10, iM1468b, i15, iM1470d - i11);
            if (!z7 && m1451d(i6)) {
                return true;
            }
            iM1470d = this.f2378b.m1470d(i10);
            i11 = c0458d1Mo1417k.f2325b;
            if (i15 == 0 && z7) {
                return true;
            }
            i10--;
        }
        return false;
    }

    public final int m1436x(int i6, int i10, int i11) {
        int i12 = this.f2382f;
        if (i12 >= 0 && (i12 != this.f2328k || i12 != i6 + 1)) {
            throw new IllegalStateException();
        }
        int i13 = this.f2328k;
        C0458d1 c0458d1Mo1417k = i13 >= 0 ? mo1417k(i13) : null;
        int iM1470d = this.f2378b.m1470d(this.f2328k);
        C0458d1 c0458d1 = new C0458d1(i10, 0);
        C3343g c3343g = this.f2327j;
        int i14 = (c3343g.f11318a - 1) & c3343g.f11320c;
        c3343g.f11318a = i14;
        c3343g.f11321d[i14] = c0458d1;
        if (i14 == c3343g.f11319b) {
            c3343g.m6786b();
        }
        Object obj = this.f2329l;
        if (obj != null) {
            c0458d1.f2326c = this.f2330m;
            this.f2329l = null;
        } else {
            C0490q c0490q = this.f2378b;
            Object[] objArr = this.f2377a;
            c0458d1.f2326c = c0490q.m1468b(i6, false, objArr, false);
            obj = objArr[0];
        }
        Object obj2 = obj;
        this.f2382f = i6;
        this.f2328k = i6;
        if (this.f2383g < 0) {
            this.f2383g = i6;
        }
        int i15 = !this.f2379c ? i11 - c0458d1.f2326c : i11 + c0458d1.f2326c;
        if (c0458d1Mo1417k != null) {
            c0458d1Mo1417k.f2325b = iM1470d - i15;
        }
        this.f2378b.m1467a(obj2, i6, c0458d1.f2326c, i10, i15);
        return c0458d1.f2326c;
    }

    public final boolean m1437y(int i6, boolean z7) {
        int i10;
        int i11;
        boolean z10;
        int iM1433u;
        int i12;
        int i13;
        int i14 = this.f2382f;
        if (i14 < 0) {
            int i15 = this.f2385i;
            i10 = i15 != -1 ? i15 : 0;
            i11 = (this.f2327j.m6790f() > 0 ? (mo1417k(this.f2328k).f2374a + this.f2381e) - 1 : i10) % this.f2381e;
            z10 = false;
            iM1433u = 0;
        } else {
            if (i14 > this.f2328k) {
                return false;
            }
            i10 = i14 - 1;
            i11 = mo1417k(i14).f2374a;
            int iM1430r = m1430r(false);
            if (iM1430r < 0) {
                i11--;
                iM1433u = Integer.MAX_VALUE;
                for (int i16 = this.f2381e - 1; i16 >= 0; i16--) {
                    iM1433u = this.f2379c ? m1433u(i16) : m1434v(i16);
                    if (iM1433u != Integer.MAX_VALUE) {
                        break;
                    }
                }
            } else {
                iM1433u = this.f2379c ? mo1414f(iM1430r, true, null) : mo1415h(iM1430r, false, null);
            }
            if (!this.f2379c ? m1434v(i11) <= iM1433u : m1433u(i11) >= iM1433u) {
                i11--;
                if (i11 < 0) {
                    i11 = this.f2381e - 1;
                    iM1433u = this.f2379c ? m1452g(true, null) : m1453i(false, null);
                }
            }
            z10 = true;
        }
        boolean z11 = false;
        while (true) {
            if (i11 >= 0) {
                if (i10 < 0 || (!z7 && m1451d(i6))) {
                    break;
                }
                int iM1433u2 = this.f2379c ? m1433u(i11) : m1434v(i11);
                if (iM1433u2 != Integer.MAX_VALUE && iM1433u2 != Integer.MIN_VALUE) {
                    if (this.f2379c) {
                        i13 = this.f2380d;
                    } else {
                        i12 = this.f2380d;
                        i13 = -i12;
                    }
                    iM1433u2 += i13;
                } else if (i11 == this.f2381e - 1) {
                    iM1433u2 = this.f2379c ? m1433u(0) : m1434v(0);
                    if (iM1433u2 != Integer.MAX_VALUE && iM1433u2 != Integer.MIN_VALUE) {
                        if (this.f2379c) {
                            i13 = this.f2380d;
                        } else {
                            i12 = this.f2380d;
                            i13 = -i12;
                        }
                        iM1433u2 += i13;
                    }
                } else {
                    iM1433u2 = this.f2379c ? m1434v(i11 + 1) : m1433u(i11 + 1);
                }
                int i17 = i10 - 1;
                int iM1436x = m1436x(i10, i11, iM1433u2);
                if (z10) {
                    while (true) {
                        if (!this.f2379c) {
                            if (iM1433u2 - iM1436x <= iM1433u) {
                                break;
                            }
                            if (i17 >= 0) {
                            }
                            return true;
                        }
                        if (iM1433u2 + iM1436x >= iM1433u) {
                            break;
                        }
                        if (i17 >= 0 || (!z7 && m1451d(i6))) {
                            return true;
                        }
                        iM1433u2 += this.f2379c ? iM1436x + this.f2380d : (-iM1436x) - this.f2380d;
                        int i18 = i17 - 1;
                        int iM1436x2 = m1436x(i17, i11, iM1433u2);
                        i17 = i18;
                        iM1436x = iM1436x2;
                    }
                    i10 = i17;
                } else {
                    iM1433u = this.f2379c ? m1433u(i11) : m1434v(i11);
                    i10 = i17;
                    z10 = true;
                }
                i11--;
                z11 = true;
            } else {
                if (z7) {
                    return z11;
                }
                iM1433u = this.f2379c ? m1452g(true, null) : m1453i(false, null);
                i11 = this.f2381e - 1;
            }
        }
        return z11;
    }
}
