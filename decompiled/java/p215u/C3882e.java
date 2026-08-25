package p215u;

import java.util.ArrayList;
import java.util.Arrays;
import p001a0.C0023f;
import p128m0.C3027c;
import p225v.C3956c;

public final class C3882e {

    public static int f13029o = 1000;

    public static boolean f13030p = true;

    public final C3884g f13032b;

    public C3880c[] f13035e;

    public final C0023f f13041k;

    public C3880c f13044n;

    public int f13031a = 0;

    public int f13033c = 32;

    public int f13034d = 32;

    public boolean f13036f = false;

    public boolean[] f13037g = new boolean[32];

    public int f13038h = 1;

    public int f13039i = 0;

    public int f13040j = 32;

    public C3886i[] f13042l = new C3886i[f13029o];

    public int f13043m = 0;

    public C3882e() {
        this.f13035e = null;
        this.f13035e = new C3880c[32];
        m7781q();
        C0023f c0023f = new C0023f(10, false);
        c0023f.f44b = new C3027c();
        c0023f.f45c = new C3027c();
        c0023f.f46d = new C3027c();
        c0023f.f47e = new C3886i[32];
        this.f13041k = c0023f;
        C3884g c3884g = new C3884g(c0023f);
        c3884g.f13047f = new C3886i[128];
        c3884g.f13048g = new C3886i[128];
        c3884g.f13049h = 0;
        c3884g.f13050i = new C3883f(c3884g);
        this.f13032b = c3884g;
        if (f13030p) {
            this.f13044n = new C3881d(c0023f);
        } else {
            this.f13044n = new C3880c(c0023f);
        }
    }

    public static int m7765m(Object obj) {
        C3886i c3886i = ((C3956c) obj).f13318g;
        if (c3886i != null) {
            return (int) (c3886i.f13055e + 0.5f);
        }
        return 0;
    }

    public final C3886i m7766a(int i6) {
        C3886i c3886i = (C3886i) ((C3027c) this.f13041k.f46d).mo6099a();
        if (c3886i == null) {
            c3886i = new C3886i(i6);
            c3886i.f13062l = i6;
        } else {
            c3886i.m7788c();
            c3886i.f13062l = i6;
        }
        int i10 = this.f13043m;
        int i11 = f13029o;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            f13029o = i12;
            this.f13042l = (C3886i[]) Arrays.copyOf(this.f13042l, i12);
        }
        C3886i[] c3886iArr = this.f13042l;
        int i13 = this.f13043m;
        this.f13043m = i13 + 1;
        c3886iArr[i13] = c3886i;
        return c3886i;
    }

    public final void m7767b(C3886i c3886i, C3886i c3886i2, int i6, float f, C3886i c3886i3, C3886i c3886i4, int i10, int i11) {
        C3880c c3880cM7776k = m7776k();
        if (c3886i2 == c3886i3) {
            c3880cM7776k.f13027d.mo7753h(c3886i, 1.0f);
            c3880cM7776k.f13027d.mo7753h(c3886i4, 1.0f);
            c3880cM7776k.f13027d.mo7753h(c3886i2, -2.0f);
        } else if (f == 0.5f) {
            c3880cM7776k.f13027d.mo7753h(c3886i, 1.0f);
            c3880cM7776k.f13027d.mo7753h(c3886i2, -1.0f);
            c3880cM7776k.f13027d.mo7753h(c3886i3, -1.0f);
            c3880cM7776k.f13027d.mo7753h(c3886i4, 1.0f);
            if (i6 > 0 || i10 > 0) {
                c3880cM7776k.f13025b = (-i6) + i10;
            }
        } else if (f <= 0.0f) {
            c3880cM7776k.f13027d.mo7753h(c3886i, -1.0f);
            c3880cM7776k.f13027d.mo7753h(c3886i2, 1.0f);
            c3880cM7776k.f13025b = i6;
        } else if (f >= 1.0f) {
            c3880cM7776k.f13027d.mo7753h(c3886i4, -1.0f);
            c3880cM7776k.f13027d.mo7753h(c3886i3, 1.0f);
            c3880cM7776k.f13025b = -i10;
        } else {
            float f3 = 1.0f - f;
            c3880cM7776k.f13027d.mo7753h(c3886i, f3 * 1.0f);
            c3880cM7776k.f13027d.mo7753h(c3886i2, f3 * (-1.0f));
            c3880cM7776k.f13027d.mo7753h(c3886i3, (-1.0f) * f);
            c3880cM7776k.f13027d.mo7753h(c3886i4, 1.0f * f);
            if (i6 > 0 || i10 > 0) {
                c3880cM7776k.f13025b = (i10 * f) + ((-i6) * f3);
            }
        }
        if (i11 != 8) {
            c3880cM7776k.m7757a(this, i11);
        }
        m7768c(c3880cM7776k);
    }

    public final void m7768c(C3880c c3880c) {
        boolean z7;
        boolean z10;
        C3886i c3886iM7761e;
        ArrayList<C3886i> arrayList;
        if (this.f13039i + 1 >= this.f13040j || this.f13038h + 1 >= this.f13034d) {
            m7778n();
        }
        if (c3880c.f13028e) {
            z7 = false;
        } else {
            if (this.f13035e.length != 0) {
                boolean z11 = false;
                while (!z11) {
                    int iMo7749d = c3880c.f13027d.mo7749d();
                    int i6 = 0;
                    while (true) {
                        arrayList = c3880c.f13026c;
                        if (i6 >= iMo7749d) {
                            break;
                        }
                        C3886i c3886iMo7754i = c3880c.f13027d.mo7754i(i6);
                        if (c3886iMo7754i.f13053c != -1 || c3886iMo7754i.f13056f) {
                            arrayList.add(c3886iMo7754i);
                        }
                        i6++;
                    }
                    if (arrayList.size() > 0) {
                        for (C3886i c3886i : arrayList) {
                            if (c3886i.f13056f) {
                                c3880c.m7763g(c3886i, true);
                            } else {
                                c3880c.mo7764h(this.f13035e[c3886i.f13053c], true);
                            }
                        }
                        arrayList.clear();
                    } else {
                        z11 = true;
                    }
                }
            }
            if (c3880c.f13024a == null && c3880c.f13025b == 0.0f && c3880c.f13027d.mo7749d() == 0) {
                return;
            }
            float f = c3880c.f13025b;
            if (f < 0.0f) {
                c3880c.f13025b = f * (-1.0f);
                c3880c.f13027d.mo7756k();
            }
            int iMo7749d2 = c3880c.f13027d.mo7749d();
            C3886i c3886i2 = null;
            C3886i c3886i3 = null;
            float f3 = 0.0f;
            boolean z12 = false;
            float f4 = 0.0f;
            boolean z13 = false;
            for (int i10 = 0; i10 < iMo7749d2; i10++) {
                float fMo7746a = c3880c.f13027d.mo7746a(i10);
                C3886i c3886iMo7754i2 = c3880c.f13027d.mo7754i(i10);
                if (c3886iMo7754i2.f13062l == 1) {
                    if (c3886i2 == null) {
                        if (c3886iMo7754i2.f13061k <= 1) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        c3886i2 = c3886iMo7754i2;
                        f3 = fMo7746a;
                    } else if (f3 > fMo7746a) {
                        if (c3886iMo7754i2.f13061k <= 1) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        c3886i2 = c3886iMo7754i2;
                        f3 = fMo7746a;
                    } else if (!z12 && c3886iMo7754i2.f13061k <= 1) {
                        c3886i2 = c3886iMo7754i2;
                        f3 = fMo7746a;
                        z12 = true;
                    }
                } else if (c3886i2 == null && fMo7746a < 0.0f) {
                    if (c3886i3 == null) {
                        if (c3886iMo7754i2.f13061k <= 1) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        c3886i3 = c3886iMo7754i2;
                        f4 = fMo7746a;
                    } else if (f4 > fMo7746a) {
                        if (c3886iMo7754i2.f13061k <= 1) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        c3886i3 = c3886iMo7754i2;
                        f4 = fMo7746a;
                    } else if (!z13 && c3886iMo7754i2.f13061k <= 1) {
                        c3886i3 = c3886iMo7754i2;
                        f4 = fMo7746a;
                        z13 = true;
                    }
                }
            }
            if (c3886i2 == null) {
                c3886i2 = c3886i3;
            }
            if (c3886i2 == null) {
                z10 = true;
            } else {
                c3880c.m7762f(c3886i2);
                z10 = false;
            }
            if (c3880c.f13027d.mo7749d() == 0) {
                c3880c.f13028e = true;
            }
            if (z10) {
                if (this.f13038h + 1 >= this.f13034d) {
                    m7778n();
                }
                C3886i c3886iM7766a = m7766a(3);
                int i11 = this.f13031a + 1;
                this.f13031a = i11;
                this.f13038h++;
                c3886iM7766a.f13052b = i11;
                ((C3886i[]) this.f13041k.f47e)[i11] = c3886iM7766a;
                c3880c.f13024a = c3886iM7766a;
                m7773h(c3880c);
                C3880c c3880c2 = this.f13044n;
                c3880c2.getClass();
                c3880c2.f13024a = null;
                c3880c2.f13027d.clear();
                for (int i12 = 0; i12 < c3880c.f13027d.mo7749d(); i12++) {
                    c3880c2.f13027d.mo7751f(c3880c.f13027d.mo7754i(i12), c3880c.f13027d.mo7746a(i12), true);
                }
                m7780p(this.f13044n);
                if (c3886iM7766a.f13053c == -1) {
                    if (c3880c.f13024a == c3886iM7766a && (c3886iM7761e = c3880c.m7761e(null, c3886iM7766a)) != null) {
                        c3880c.m7762f(c3886iM7761e);
                    }
                    if (!c3880c.f13028e) {
                        c3880c.f13024a.m7789d(c3880c);
                    }
                    this.f13039i--;
                }
                z7 = true;
            } else {
                z7 = false;
            }
            C3886i c3886i4 = c3880c.f13024a;
            if (c3886i4 == null) {
                return;
            }
            if (c3886i4.f13062l != 1 && c3880c.f13025b < 0.0f) {
                return;
            }
        }
        if (z7) {
            return;
        }
        m7773h(c3880c);
    }

    public final void m7769d(C3886i c3886i, int i6) {
        int i10 = c3886i.f13053c;
        if (i10 == -1) {
            c3886i.f13055e = i6;
            c3886i.f13056f = true;
            int i11 = c3886i.f13060j;
            for (int i12 = 0; i12 < i11; i12++) {
                c3886i.f13059i[i12].m7763g(c3886i, false);
            }
            c3886i.f13060j = 0;
            return;
        }
        if (i10 == -1) {
            C3880c c3880cM7776k = m7776k();
            c3880cM7776k.f13024a = c3886i;
            float f = i6;
            c3886i.f13055e = f;
            c3880cM7776k.f13025b = f;
            c3880cM7776k.f13028e = true;
            m7768c(c3880cM7776k);
            return;
        }
        C3880c c3880c = this.f13035e[i10];
        if (c3880c.f13028e) {
            c3880c.f13025b = i6;
            return;
        }
        if (c3880c.f13027d.mo7749d() == 0) {
            c3880c.f13028e = true;
            c3880c.f13025b = i6;
            return;
        }
        C3880c c3880cM7776k2 = m7776k();
        if (i6 < 0) {
            c3880cM7776k2.f13025b = i6 * (-1);
            c3880cM7776k2.f13027d.mo7753h(c3886i, 1.0f);
        } else {
            c3880cM7776k2.f13025b = i6;
            c3880cM7776k2.f13027d.mo7753h(c3886i, -1.0f);
        }
        m7768c(c3880cM7776k2);
    }

    public final void m7770e(C3886i c3886i, C3886i c3886i2, int i6, int i10) {
        boolean z7 = false;
        if (i10 == 8 && c3886i2.f13056f && c3886i.f13053c == -1) {
            c3886i.f13055e = c3886i2.f13055e + i6;
            c3886i.f13056f = true;
            int i11 = c3886i.f13060j;
            for (int i12 = 0; i12 < i11; i12++) {
                c3886i.f13059i[i12].m7763g(c3886i, false);
            }
            c3886i.f13060j = 0;
            return;
        }
        C3880c c3880cM7776k = m7776k();
        if (i6 != 0) {
            if (i6 < 0) {
                i6 *= -1;
                z7 = true;
            }
            c3880cM7776k.f13025b = i6;
        }
        if (z7) {
            c3880cM7776k.f13027d.mo7753h(c3886i, 1.0f);
            c3880cM7776k.f13027d.mo7753h(c3886i2, -1.0f);
        } else {
            c3880cM7776k.f13027d.mo7753h(c3886i, -1.0f);
            c3880cM7776k.f13027d.mo7753h(c3886i2, 1.0f);
        }
        if (i10 != 8) {
            c3880cM7776k.m7757a(this, i10);
        }
        m7768c(c3880cM7776k);
    }

    public final void m7771f(C3886i c3886i, C3886i c3886i2, int i6, int i10) {
        C3880c c3880cM7776k = m7776k();
        C3886i c3886iM7777l = m7777l();
        c3886iM7777l.f13054d = 0;
        c3880cM7776k.m7758b(c3886i, c3886i2, c3886iM7777l, i6);
        if (i10 != 8) {
            c3880cM7776k.f13027d.mo7753h(m7774i(i10), (int) (c3880cM7776k.f13027d.mo7752g(c3886iM7777l) * (-1.0f)));
        }
        m7768c(c3880cM7776k);
    }

    public final void m7772g(C3886i c3886i, C3886i c3886i2, int i6, int i10) {
        C3880c c3880cM7776k = m7776k();
        C3886i c3886iM7777l = m7777l();
        c3886iM7777l.f13054d = 0;
        c3880cM7776k.m7759c(c3886i, c3886i2, c3886iM7777l, i6);
        if (i10 != 8) {
            c3880cM7776k.f13027d.mo7753h(m7774i(i10), (int) (c3880cM7776k.f13027d.mo7752g(c3886iM7777l) * (-1.0f)));
        }
        m7768c(c3880cM7776k);
    }

    public final void m7773h(C3880c c3880c) {
        boolean z7 = f13030p;
        C0023f c0023f = this.f13041k;
        if (z7) {
            C3880c c3880c2 = this.f13035e[this.f13039i];
            if (c3880c2 != null) {
                ((C3027c) c0023f.f44b).m6100b(c3880c2);
            }
        } else {
            C3880c c3880c3 = this.f13035e[this.f13039i];
            if (c3880c3 != null) {
                ((C3027c) c0023f.f45c).m6100b(c3880c3);
            }
        }
        C3880c[] c3880cArr = this.f13035e;
        int i6 = this.f13039i;
        c3880cArr[i6] = c3880c;
        C3886i c3886i = c3880c.f13024a;
        c3886i.f13053c = i6;
        this.f13039i = i6 + 1;
        c3886i.m7789d(c3880c);
    }

    public final C3886i m7774i(int i6) {
        if (this.f13038h + 1 >= this.f13034d) {
            m7778n();
        }
        C3886i c3886iM7766a = m7766a(4);
        int i10 = this.f13031a + 1;
        this.f13031a = i10;
        this.f13038h++;
        c3886iM7766a.f13052b = i10;
        c3886iM7766a.f13054d = i6;
        ((C3886i[]) this.f13041k.f47e)[i10] = c3886iM7766a;
        C3884g c3884g = this.f13032b;
        c3884g.f13050i.f13045a = c3886iM7766a;
        float[] fArr = c3886iM7766a.f13058h;
        Arrays.fill(fArr, 0.0f);
        fArr[c3886iM7766a.f13054d] = 1.0f;
        c3884g.m7783i(c3886iM7766a);
        return c3886iM7766a;
    }

    public final C3886i m7775j(Object obj) {
        C3886i c3886i = null;
        if (obj == null) {
            return null;
        }
        if (this.f13038h + 1 >= this.f13034d) {
            m7778n();
        }
        if (obj instanceof C3956c) {
            C3956c c3956c = (C3956c) obj;
            c3886i = c3956c.f13318g;
            if (c3886i == null) {
                c3956c.m7893i();
                c3886i = c3956c.f13318g;
            }
            int i6 = c3886i.f13052b;
            C0023f c0023f = this.f13041k;
            if (i6 == -1 || i6 > this.f13031a || ((C3886i[]) c0023f.f47e)[i6] == null) {
                if (i6 != -1) {
                    c3886i.m7788c();
                }
                int i10 = this.f13031a + 1;
                this.f13031a = i10;
                this.f13038h++;
                c3886i.f13052b = i10;
                c3886i.f13062l = 1;
                ((C3886i[]) c0023f.f47e)[i10] = c3886i;
            }
        }
        return c3886i;
    }

    public final C3880c m7776k() {
        boolean z7 = f13030p;
        C0023f c0023f = this.f13041k;
        if (z7) {
            C3880c c3880c = (C3880c) ((C3027c) c0023f.f44b).mo6099a();
            if (c3880c == null) {
                return new C3881d(c0023f);
            }
            c3880c.f13024a = null;
            c3880c.f13027d.clear();
            c3880c.f13025b = 0.0f;
            c3880c.f13028e = false;
            return c3880c;
        }
        C3880c c3880c2 = (C3880c) ((C3027c) c0023f.f45c).mo6099a();
        if (c3880c2 == null) {
            return new C3880c(c0023f);
        }
        c3880c2.f13024a = null;
        c3880c2.f13027d.clear();
        c3880c2.f13025b = 0.0f;
        c3880c2.f13028e = false;
        return c3880c2;
    }

    public final C3886i m7777l() {
        if (this.f13038h + 1 >= this.f13034d) {
            m7778n();
        }
        C3886i c3886iM7766a = m7766a(3);
        int i6 = this.f13031a + 1;
        this.f13031a = i6;
        this.f13038h++;
        c3886iM7766a.f13052b = i6;
        ((C3886i[]) this.f13041k.f47e)[i6] = c3886iM7766a;
        return c3886iM7766a;
    }

    public final void m7778n() {
        int i6 = this.f13033c * 2;
        this.f13033c = i6;
        this.f13035e = (C3880c[]) Arrays.copyOf(this.f13035e, i6);
        C0023f c0023f = this.f13041k;
        c0023f.f47e = (C3886i[]) Arrays.copyOf((C3886i[]) c0023f.f47e, this.f13033c);
        int i10 = this.f13033c;
        this.f13037g = new boolean[i10];
        this.f13034d = i10;
        this.f13040j = i10;
    }

    public final void m7779o(C3884g c3884g) {
        C0023f c0023f;
        for (int i6 = 0; i6 < this.f13039i; i6++) {
            C3880c c3880c = this.f13035e[i6];
            int i10 = 1;
            if (c3880c.f13024a.f13062l != 1) {
                float f = 0.0f;
                if (c3880c.f13025b < 0.0f) {
                    boolean z7 = false;
                    int i11 = 0;
                    while (!z7) {
                        i11 += i10;
                        float f3 = Float.MAX_VALUE;
                        int i12 = 0;
                        int i13 = -1;
                        int i14 = -1;
                        int i15 = 0;
                        while (true) {
                            int i16 = this.f13039i;
                            c0023f = this.f13041k;
                            if (i12 >= i16) {
                                break;
                            }
                            C3880c c3880c2 = this.f13035e[i12];
                            if (c3880c2.f13024a.f13062l != i10 && !c3880c2.f13028e && c3880c2.f13025b < f) {
                                int i17 = 1;
                                while (i17 < this.f13038h) {
                                    C3886i c3886i = ((C3886i[]) c0023f.f47e)[i17];
                                    float fMo7752g = c3880c2.f13027d.mo7752g(c3886i);
                                    if (fMo7752g > f) {
                                        for (int i18 = 0; i18 < 9; i18++) {
                                            float f4 = c3886i.f13057g[i18] / fMo7752g;
                                            if ((f4 < f3 && i18 == i15) || i18 > i15) {
                                                i15 = i18;
                                                f3 = f4;
                                                i13 = i12;
                                                i14 = i17;
                                            }
                                        }
                                    }
                                    i17++;
                                    f = 0.0f;
                                }
                            }
                            i12++;
                            f = 0.0f;
                            i10 = 1;
                        }
                        if (i13 != -1) {
                            C3880c c3880c3 = this.f13035e[i13];
                            c3880c3.f13024a.f13053c = -1;
                            c3880c3.m7762f(((C3886i[]) c0023f.f47e)[i14]);
                            C3886i c3886i2 = c3880c3.f13024a;
                            c3886i2.f13053c = i13;
                            c3886i2.m7789d(c3880c3);
                        } else {
                            z7 = true;
                        }
                        if (i11 > this.f13038h / 2) {
                            z7 = true;
                        }
                        f = 0.0f;
                        i10 = 1;
                    }
                    break;
                }
            }
        }
        m7780p(c3884g);
        for (int i19 = 0; i19 < this.f13039i; i19++) {
            C3880c c3880c4 = this.f13035e[i19];
            c3880c4.f13024a.f13055e = c3880c4.f13025b;
        }
    }

    public final void m7780p(C3880c c3880c) {
        for (int i6 = 0; i6 < this.f13038h; i6++) {
            this.f13037g[i6] = false;
        }
        boolean z7 = false;
        int i10 = 0;
        while (!z7) {
            i10++;
            if (i10 >= this.f13038h * 2) {
                return;
            }
            C3886i c3886i = c3880c.f13024a;
            if (c3886i != null) {
                this.f13037g[c3886i.f13052b] = true;
            }
            C3886i c3886iMo7760d = c3880c.mo7760d(this.f13037g);
            if (c3886iMo7760d != null) {
                boolean[] zArr = this.f13037g;
                int i11 = c3886iMo7760d.f13052b;
                if (zArr[i11]) {
                    return;
                } else {
                    zArr[i11] = true;
                }
            }
            if (c3886iMo7760d != null) {
                float f = Float.MAX_VALUE;
                int i12 = -1;
                for (int i13 = 0; i13 < this.f13039i; i13++) {
                    C3880c c3880c2 = this.f13035e[i13];
                    if (c3880c2.f13024a.f13062l != 1 && !c3880c2.f13028e && c3880c2.f13027d.mo7750e(c3886iMo7760d)) {
                        float fMo7752g = c3880c2.f13027d.mo7752g(c3886iMo7760d);
                        if (fMo7752g < 0.0f) {
                            float f3 = (-c3880c2.f13025b) / fMo7752g;
                            if (f3 < f) {
                                i12 = i13;
                                f = f3;
                            }
                        }
                    }
                }
                if (i12 > -1) {
                    C3880c c3880c3 = this.f13035e[i12];
                    c3880c3.f13024a.f13053c = -1;
                    c3880c3.m7762f(c3886iMo7760d);
                    C3886i c3886i2 = c3880c3.f13024a;
                    c3886i2.f13053c = i12;
                    c3886i2.m7789d(c3880c3);
                }
            } else {
                z7 = true;
            }
        }
    }

    public final void m7781q() {
        boolean z7 = f13030p;
        C0023f c0023f = this.f13041k;
        int i6 = 0;
        if (z7) {
            while (true) {
                C3880c[] c3880cArr = this.f13035e;
                if (i6 >= c3880cArr.length) {
                    return;
                }
                C3880c c3880c = c3880cArr[i6];
                if (c3880c != null) {
                    ((C3027c) c0023f.f44b).m6100b(c3880c);
                }
                this.f13035e[i6] = null;
                i6++;
            }
        } else {
            while (true) {
                C3880c[] c3880cArr2 = this.f13035e;
                if (i6 >= c3880cArr2.length) {
                    return;
                }
                C3880c c3880c2 = c3880cArr2[i6];
                if (c3880c2 != null) {
                    ((C3027c) c0023f.f45c).m6100b(c3880c2);
                }
                this.f13035e[i6] = null;
                i6++;
            }
        }
    }

    public final void m7782r() {
        C0023f c0023f;
        int i6 = 0;
        while (true) {
            c0023f = this.f13041k;
            C3886i[] c3886iArr = (C3886i[]) c0023f.f47e;
            if (i6 >= c3886iArr.length) {
                break;
            }
            C3886i c3886i = c3886iArr[i6];
            if (c3886i != null) {
                c3886i.m7788c();
            }
            i6++;
        }
        C3027c c3027c = (C3027c) c0023f.f46d;
        C3886i[] c3886iArr2 = this.f13042l;
        int length = this.f13043m;
        c3027c.getClass();
        if (length > c3886iArr2.length) {
            length = c3886iArr2.length;
        }
        for (int i10 = 0; i10 < length; i10++) {
            C3886i c3886i2 = c3886iArr2[i10];
            int i11 = c3027c.f10358c;
            Object[] objArr = c3027c.f10357b;
            if (i11 < objArr.length) {
                objArr[i11] = c3886i2;
                c3027c.f10358c = i11 + 1;
            }
        }
        this.f13043m = 0;
        Arrays.fill((C3886i[]) c0023f.f47e, (Object) null);
        this.f13031a = 0;
        C3884g c3884g = this.f13032b;
        c3884g.f13049h = 0;
        c3884g.f13025b = 0.0f;
        this.f13038h = 1;
        for (int i12 = 0; i12 < this.f13039i; i12++) {
            this.f13035e[i12].getClass();
        }
        m7781q();
        this.f13039i = 0;
        if (f13030p) {
            this.f13044n = new C3881d(c0023f);
        } else {
            this.f13044n = new C3880c(c0023f);
        }
    }
}
