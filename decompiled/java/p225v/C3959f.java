package p225v;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import p001a0.C0023f;
import p187r4.C3621k;
import p215u.C3880c;
import p215u.C3882e;
import p215u.C3884g;
import p215u.C3886i;
import p236w.AbstractC4039n;
import p236w.C4027b;
import p236w.C4029d;
import p236w.C4031f;
import p236w.C4036k;
import p236w.C4038m;
import p236w.InterfaceC4028c;

public final class C3959f extends C3958e {

    public ArrayList f13382g0 = new ArrayList();

    public final C3621k f13383h0 = new C3621k(this);

    public final C4031f f13384i0;

    public InterfaceC4028c f13385j0;

    public boolean f13386k0;

    public final C3882e f13387l0;

    public int f13388m0;

    public int f13389n0;

    public int f13390o0;

    public int f13391p0;

    public C3955b[] f13392q0;

    public C3955b[] f13393r0;

    public int f13394s0;

    public boolean f13395t0;

    public boolean f13396u0;

    public C3959f() {
        C4031f c4031f = new C4031f();
        c4031f.f13656b = true;
        c4031f.f13657c = true;
        c4031f.f13659e = new ArrayList();
        new ArrayList();
        c4031f.f13660f = null;
        c4031f.f13661g = new C4027b();
        c4031f.f13662h = new ArrayList();
        c4031f.f13655a = this;
        c4031f.f13658d = this;
        this.f13384i0 = c4031f;
        this.f13385j0 = null;
        this.f13386k0 = false;
        this.f13387l0 = new C3882e();
        this.f13390o0 = 0;
        this.f13391p0 = 0;
        this.f13392q0 = new C3955b[4];
        this.f13393r0 = new C3955b[4];
        this.f13394s0 = 263;
        this.f13395t0 = false;
        this.f13396u0 = false;
    }

    @Override
    public final void mo7894A(boolean z7, boolean z10) {
        super.mo7894A(z7, z10);
        int size = this.f13382g0.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((C3958e) this.f13382g0.get(i6)).mo7894A(z7, z10);
        }
    }

    public final void m7919C(C3958e c3958e, int i6) {
        if (i6 == 0) {
            int i10 = this.f13390o0 + 1;
            C3955b[] c3955bArr = this.f13393r0;
            if (i10 >= c3955bArr.length) {
                this.f13393r0 = (C3955b[]) Arrays.copyOf(c3955bArr, c3955bArr.length * 2);
            }
            C3955b[] c3955bArr2 = this.f13393r0;
            int i11 = this.f13390o0;
            c3955bArr2[i11] = new C3955b(c3958e, 0, this.f13386k0);
            this.f13390o0 = i11 + 1;
            return;
        }
        if (i6 == 1) {
            int i12 = this.f13391p0 + 1;
            C3955b[] c3955bArr3 = this.f13392q0;
            if (i12 >= c3955bArr3.length) {
                this.f13392q0 = (C3955b[]) Arrays.copyOf(c3955bArr3, c3955bArr3.length * 2);
            }
            C3955b[] c3955bArr4 = this.f13392q0;
            int i13 = this.f13391p0;
            c3955bArr4[i13] = new C3955b(c3958e, 1, this.f13386k0);
            this.f13391p0 = i13 + 1;
        }
    }

    public final void m7920D(C3882e c3882e) {
        mo7882a(c3882e);
        int size = this.f13382g0.size();
        boolean z7 = false;
        for (int i6 = 0; i6 < size; i6++) {
            C3958e c3958e = (C3958e) this.f13382g0.get(i6);
            boolean[] zArr = c3958e.f13332I;
            zArr[0] = false;
            zArr[1] = false;
            if (c3958e instanceof C3954a) {
                z7 = true;
            }
        }
        if (z7) {
            for (int i10 = 0; i10 < size; i10++) {
                C3958e c3958e2 = (C3958e) this.f13382g0.get(i10);
                if (c3958e2 instanceof C3954a) {
                    C3954a c3954a = (C3954a) c3958e2;
                    for (int i11 = 0; i11 < c3954a.f13457h0; i11++) {
                        C3958e c3958e3 = c3954a.f13456g0[i11];
                        int i12 = c3954a.f13292i0;
                        if (i12 == 0 || i12 == 1) {
                            c3958e3.f13332I[0] = true;
                        } else if (i12 == 2 || i12 == 3) {
                            c3958e3.f13332I[1] = true;
                        }
                    }
                }
            }
        }
        for (int i13 = 0; i13 < size; i13++) {
            C3958e c3958e4 = (C3958e) this.f13382g0.get(i13);
            c3958e4.getClass();
            if ((c3958e4 instanceof C3961h) || (c3958e4 instanceof C3962i)) {
                c3958e4.mo7882a(c3882e);
            }
        }
        for (int i14 = 0; i14 < size; i14++) {
            C3958e c3958e5 = (C3958e) this.f13382g0.get(i14);
            boolean z10 = c3958e5 instanceof C3959f;
            EnumC3957d enumC3957d = EnumC3957d.f13320b;
            if (z10) {
                EnumC3957d[] enumC3957dArr = c3958e5.f13333J;
                EnumC3957d enumC3957d2 = enumC3957dArr[0];
                EnumC3957d enumC3957d3 = enumC3957dArr[1];
                EnumC3957d enumC3957d4 = EnumC3957d.f13319a;
                if (enumC3957d2 == enumC3957d) {
                    c3958e5.m7916x(enumC3957d4);
                }
                if (enumC3957d3 == enumC3957d) {
                    c3958e5.m7917y(enumC3957d4);
                }
                c3958e5.mo7882a(c3882e);
                if (enumC3957d2 == enumC3957d) {
                    c3958e5.m7916x(enumC3957d2);
                }
                if (enumC3957d3 == enumC3957d) {
                    c3958e5.m7917y(enumC3957d3);
                }
            } else {
                c3958e5.f13363h = -1;
                c3958e5.f13364i = -1;
                EnumC3957d enumC3957d5 = this.f13333J[0];
                EnumC3957d enumC3957d6 = EnumC3957d.f13322d;
                if (enumC3957d5 != enumC3957d && c3958e5.f13333J[0] == enumC3957d6) {
                    C3956c c3956c = c3958e5.f13380y;
                    int i15 = c3956c.f13316e;
                    int iM7905m = m7905m();
                    C3956c c3956c2 = c3958e5.f13324A;
                    int i16 = iM7905m - c3956c2.f13316e;
                    c3956c.f13318g = c3882e.m7775j(c3956c);
                    c3956c2.f13318g = c3882e.m7775j(c3956c2);
                    c3882e.m7769d(c3956c.f13318g, i15);
                    c3882e.m7769d(c3956c2.f13318g, i16);
                    c3958e5.f13363h = 2;
                    c3958e5.f13339P = i15;
                    int i17 = i16 - i15;
                    c3958e5.f13335L = i17;
                    int i18 = c3958e5.f13342S;
                    if (i17 < i18) {
                        c3958e5.f13335L = i18;
                    }
                }
                if (this.f13333J[1] != enumC3957d && c3958e5.f13333J[1] == enumC3957d6) {
                    C3956c c3956c3 = c3958e5.f13381z;
                    int i19 = c3956c3.f13316e;
                    int iM7902j = m7902j();
                    C3956c c3956c4 = c3958e5.f13325B;
                    int i20 = iM7902j - c3956c4.f13316e;
                    c3956c3.f13318g = c3882e.m7775j(c3956c3);
                    c3956c4.f13318g = c3882e.m7775j(c3956c4);
                    c3882e.m7769d(c3956c3.f13318g, i19);
                    c3882e.m7769d(c3956c4.f13318g, i20);
                    if (c3958e5.f13341R > 0 || c3958e5.f13347X == 8) {
                        C3956c c3956c5 = c3958e5.f13326C;
                        C3886i c3886iM7775j = c3882e.m7775j(c3956c5);
                        c3956c5.f13318g = c3886iM7775j;
                        c3882e.m7769d(c3886iM7775j, c3958e5.f13341R + i19);
                    }
                    c3958e5.f13364i = 2;
                    c3958e5.f13340Q = i19;
                    int i21 = i20 - i19;
                    c3958e5.f13336M = i21;
                    int i22 = c3958e5.f13343T;
                    if (i21 < i22) {
                        c3958e5.f13336M = i22;
                    }
                }
                if (!(c3958e5 instanceof C3961h) && !(c3958e5 instanceof C3962i)) {
                    c3958e5.mo7882a(c3882e);
                }
            }
        }
        if (this.f13390o0 > 0) {
            AbstractC3964k.m7936a(this, c3882e, 0);
        }
        if (this.f13391p0 > 0) {
            AbstractC3964k.m7936a(this, c3882e, 1);
        }
    }

    public final boolean m7921E(int i6, boolean z7) {
        boolean z10;
        boolean z11;
        EnumC3957d enumC3957d;
        boolean z12;
        C4031f c4031f = this.f13384i0;
        C3959f c3959f = c4031f.f13655a;
        EnumC3957d enumC3957dM7901i = c3959f.m7901i(0);
        EnumC3957d enumC3957dM7901i2 = c3959f.m7901i(1);
        int iM7906n = c3959f.m7906n();
        int iM7907o = c3959f.m7907o();
        ArrayList<AbstractC4039n> arrayList = c4031f.f13659e;
        EnumC3957d enumC3957d2 = EnumC3957d.f13319a;
        C4038m c4038m = c3959f.f13358e;
        C4036k c4036k = c3959f.f13356d;
        if (z7 && (enumC3957dM7901i == (enumC3957d = EnumC3957d.f13320b) || enumC3957dM7901i2 == enumC3957d)) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z12 = z7;
                    break;
                }
                AbstractC4039n abstractC4039n = (AbstractC4039n) it.next();
                if (abstractC4039n.f13686f == i6 && !abstractC4039n.mo8018k()) {
                    z12 = false;
                    break;
                }
            }
            if (i6 == 0) {
                if (z12 && enumC3957dM7901i == enumC3957d) {
                    c3959f.m7916x(enumC3957d2);
                    c3959f.m7918z(c4031f.m8024d(c3959f, 0));
                    c4036k.f13685e.mo8030d(c3959f.m7905m());
                }
            } else if (z12 && enumC3957dM7901i2 == enumC3957d) {
                c3959f.m7917y(enumC3957d2);
                c3959f.m7915w(c4031f.m8024d(c3959f, 1));
                c4038m.f13685e.mo8030d(c3959f.m7902j());
            }
        }
        EnumC3957d enumC3957d3 = EnumC3957d.f13322d;
        if (i6 == 0) {
            EnumC3957d enumC3957d4 = c3959f.f13333J[0];
            if (enumC3957d4 == enumC3957d2 || enumC3957d4 == enumC3957d3) {
                int iM7905m = c3959f.m7905m() + iM7906n;
                c4036k.f13689i.mo8030d(iM7905m);
                c4036k.f13685e.mo8030d(iM7905m - iM7906n);
                z10 = true;
            } else {
                z10 = false;
            }
        } else {
            EnumC3957d enumC3957d5 = c3959f.f13333J[1];
            if (enumC3957d5 == enumC3957d2 || enumC3957d5 == enumC3957d3) {
                int iM7902j = c3959f.m7902j() + iM7907o;
                c4038m.f13689i.mo8030d(iM7902j);
                c4038m.f13685e.mo8030d(iM7902j - iM7907o);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        c4031f.m8027g();
        for (AbstractC4039n abstractC4039n2 : arrayList) {
            if (abstractC4039n2.f13686f == i6 && (abstractC4039n2.f13682b != c3959f || abstractC4039n2.f13687g)) {
                abstractC4039n2.mo8015e();
            }
        }
        for (AbstractC4039n abstractC4039n3 : arrayList) {
            if (abstractC4039n3.f13686f == i6 && (z10 || abstractC4039n3.f13682b != c3959f)) {
                if (!abstractC4039n3.f13688h.f13672j || !abstractC4039n3.f13689i.f13672j || (!(abstractC4039n3 instanceof C4029d) && !abstractC4039n3.f13685e.f13672j)) {
                    z11 = false;
                    c3959f.m7916x(enumC3957dM7901i);
                    c3959f.m7917y(enumC3957dM7901i2);
                    return z11;
                }
            }
        }
        z11 = true;
        c3959f.m7916x(enumC3957dM7901i);
        c3959f.m7917y(enumC3957dM7901i2);
        return z11;
    }

    public final void m7922F() {
        boolean z7;
        boolean z10;
        boolean z11;
        ?? r10;
        int i6 = 0;
        this.f13339P = 0;
        this.f13340Q = 0;
        int iMax = Math.max(0, m7905m());
        int iMax2 = Math.max(0, m7902j());
        this.f13395t0 = false;
        this.f13396u0 = false;
        int i10 = this.f13394s0;
        boolean z12 = ((i10 & 64) == 64) || (i10 & 128) == 128;
        C3882e c3882e = this.f13387l0;
        c3882e.getClass();
        c3882e.f13036f = false;
        if (this.f13394s0 != 0 && z12) {
            c3882e.f13036f = true;
        }
        EnumC3957d[] enumC3957dArr = this.f13333J;
        EnumC3957d enumC3957d = enumC3957dArr[1];
        EnumC3957d enumC3957d2 = enumC3957dArr[0];
        ArrayList arrayList = this.f13382g0;
        EnumC3957d enumC3957d3 = EnumC3957d.f13320b;
        boolean z13 = enumC3957d2 == enumC3957d3 || enumC3957d == enumC3957d3;
        this.f13390o0 = 0;
        this.f13391p0 = 0;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            C3958e c3958e = (C3958e) this.f13382g0.get(i11);
            if (c3958e instanceof C3959f) {
                ((C3959f) c3958e).m7922F();
            }
        }
        int i12 = 0;
        boolean z14 = true;
        boolean z15 = false;
        while (z14) {
            int i13 = i12 + 1;
            try {
                c3882e.m7782r();
                this.f13390o0 = i6;
                this.f13391p0 = i6;
                m7899g(c3882e);
                for (int i14 = 0; i14 < size; i14++) {
                    ((C3958e) this.f13382g0.get(i14)).m7899g(c3882e);
                }
                m7920D(c3882e);
                try {
                    C3884g c3884g = c3882e.f13032b;
                    if (c3882e.f13036f) {
                        int i15 = 0;
                        while (true) {
                            if (i15 >= c3882e.f13039i) {
                                for (int i16 = 0; i16 < c3882e.f13039i; i16++) {
                                    C3880c c3880c = c3882e.f13035e[i16];
                                    c3880c.f13024a.f13055e = c3880c.f13025b;
                                }
                                break;
                            }
                            if (!c3882e.f13035e[i15].f13028e) {
                                c3882e.m7779o(c3884g);
                                break;
                            }
                            i15++;
                        }
                    } else {
                        c3882e.m7779o(c3884g);
                    }
                    z7 = true;
                } catch (Exception e5) {
                    e = e5;
                    z14 = true;
                    e.printStackTrace();
                    z7 = z14;
                    System.out.println("EXCEPTION : " + e);
                }
            } catch (Exception e10) {
                e = e10;
            }
            boolean[] zArr = AbstractC3964k.f13458a;
            if (z7) {
                zArr[2] = false;
                mo7895B(c3882e);
                int size2 = this.f13382g0.size();
                for (int i17 = 0; i17 < size2; i17++) {
                    ((C3958e) this.f13382g0.get(i17)).mo7895B(c3882e);
                }
            } else {
                mo7895B(c3882e);
                for (int i18 = 0; i18 < size; i18++) {
                    ((C3958e) this.f13382g0.get(i18)).mo7895B(c3882e);
                }
            }
            if (z13 && i13 < 8 && zArr[2]) {
                int i19 = 0;
                int iMax3 = 0;
                int iMax4 = 0;
                while (i19 < size) {
                    C3958e c3958e2 = (C3958e) this.f13382g0.get(i19);
                    iMax3 = Math.max(iMax3, c3958e2.m7905m() + c3958e2.f13339P);
                    iMax4 = Math.max(iMax4, c3958e2.m7902j() + c3958e2.f13340Q);
                    i19++;
                    z13 = z13;
                }
                z10 = z13;
                int iMax5 = Math.max(this.f13342S, iMax3);
                int iMax6 = Math.max(this.f13343T, iMax4);
                if (enumC3957d2 != enumC3957d3 || m7905m() >= iMax5) {
                    z11 = false;
                } else {
                    m7918z(iMax5);
                    this.f13333J[0] = enumC3957d3;
                    z11 = true;
                    z15 = true;
                }
                if (enumC3957d == enumC3957d3 && m7902j() < iMax6) {
                    m7915w(iMax6);
                    this.f13333J[1] = enumC3957d3;
                    z11 = true;
                    z15 = true;
                }
            } else {
                z10 = z13;
                z11 = false;
            }
            int iMax7 = Math.max(this.f13342S, m7905m());
            int iM7905m = m7905m();
            EnumC3957d enumC3957d4 = EnumC3957d.f13319a;
            if (iMax7 > iM7905m) {
                m7918z(iMax7);
                this.f13333J[0] = enumC3957d4;
                z11 = true;
                z15 = true;
            }
            int iMax8 = Math.max(this.f13343T, m7902j());
            if (iMax8 > m7902j()) {
                m7915w(iMax8);
                r10 = 1;
                this.f13333J[1] = enumC3957d4;
                z11 = true;
                z15 = true;
            } else {
                r10 = 1;
            }
            if (z15) {
                z14 = z11;
            } else {
                if (this.f13333J[0] == enumC3957d3 && iMax > 0 && m7905m() > iMax) {
                    this.f13395t0 = r10;
                    this.f13333J[0] = enumC3957d4;
                    m7918z(iMax);
                    z11 = true;
                    z15 = true;
                }
                if (this.f13333J[r10] != enumC3957d3 || iMax2 <= 0 || m7902j() <= iMax2) {
                    z14 = z11;
                } else {
                    this.f13396u0 = r10;
                    this.f13333J[r10] = enumC3957d4;
                    m7915w(iMax2);
                    z14 = true;
                    z15 = true;
                }
            }
            i12 = i13;
            z13 = z10;
            i6 = 0;
        }
        this.f13382g0 = arrayList;
        if (z15) {
            EnumC3957d[] enumC3957dArr2 = this.f13333J;
            enumC3957dArr2[0] = enumC3957d2;
            enumC3957dArr2[1] = enumC3957d;
        }
        mo7914v(c3882e.f13041k);
    }

    public final void m7923G() {
        EnumC3957d enumC3957d;
        EnumC3957d enumC3957d2;
        ArrayList arrayList = (ArrayList) this.f13383h0.f12170b;
        arrayList.clear();
        int size = this.f13382g0.size();
        for (int i6 = 0; i6 < size; i6++) {
            C3958e c3958e = (C3958e) this.f13382g0.get(i6);
            EnumC3957d[] enumC3957dArr = c3958e.f13333J;
            EnumC3957d enumC3957d3 = enumC3957dArr[0];
            EnumC3957d enumC3957d4 = EnumC3957d.f13321c;
            if (enumC3957d3 == enumC3957d4 || enumC3957d3 == (enumC3957d = EnumC3957d.f13322d) || (enumC3957d2 = enumC3957dArr[1]) == enumC3957d4 || enumC3957d2 == enumC3957d) {
                arrayList.add(c3958e);
            }
        }
        this.f13384i0.f13656b = true;
    }

    @Override
    public final void mo7912t() {
        this.f13387l0.m7782r();
        this.f13388m0 = 0;
        this.f13389n0 = 0;
        this.f13382g0.clear();
        super.mo7912t();
    }

    @Override
    public final void mo7914v(C0023f c0023f) {
        super.mo7914v(c0023f);
        int size = this.f13382g0.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((C3958e) this.f13382g0.get(i6)).mo7914v(c0023f);
        }
    }
}
