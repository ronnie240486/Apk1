package p225v;

import androidx.constraintlayout.widget.C0306b;
import java.util.ArrayList;
import java.util.HashMap;
import p215u.C3882e;
import p236w.C4027b;
import p236w.InterfaceC4028c;

public final class C3961h extends C3963j {

    public C3958e[] f13431Q0;

    public int f13433i0 = 0;

    public int f13434j0 = 0;

    public int f13435k0 = 0;

    public int f13436l0 = 0;

    public int f13437m0 = 0;

    public int f13438n0 = 0;

    public boolean f13439o0 = false;

    public int f13440p0 = 0;

    public int f13441q0 = 0;

    public final C4027b f13442r0 = new C4027b();

    public InterfaceC4028c f13443s0 = null;

    public int f13444t0 = -1;

    public int f13445u0 = -1;

    public int f13446v0 = -1;

    public int f13447w0 = -1;

    public int f13448x0 = -1;

    public int f13449y0 = -1;

    public float f13450z0 = 0.5f;

    public float f13415A0 = 0.5f;

    public float f13416B0 = 0.5f;

    public float f13417C0 = 0.5f;

    public float f13418D0 = 0.5f;

    public float f13419E0 = 0.5f;

    public int f13420F0 = 0;

    public int f13421G0 = 0;

    public int f13422H0 = 2;

    public int f13423I0 = 2;

    public int f13424J0 = 0;

    public int f13425K0 = -1;

    public int f13426L0 = 0;

    public final ArrayList f13427M0 = new ArrayList();

    public C3958e[] f13428N0 = null;

    public C3958e[] f13429O0 = null;

    public int[] f13430P0 = null;

    public int f13432R0 = 0;

    @Override
    public final void mo7930D() {
        for (int i6 = 0; i6 < this.f13457h0; i6++) {
            C3958e c3958e = this.f13456g0[i6];
        }
    }

    public final int m7931E(C3958e c3958e, int i6) {
        if (c3958e == null) {
            return 0;
        }
        if (c3958e.f13333J[1] == EnumC3957d.f13321c) {
            int i10 = c3958e.f13366k;
            if (i10 == 0) {
                return 0;
            }
            if (i10 == 2) {
                int i11 = (int) (c3958e.f13373r * i6);
                if (i11 != c3958e.m7902j()) {
                    m7933G(c3958e, c3958e.f13333J[0], c3958e.m7905m(), EnumC3957d.f13319a, i11);
                }
                return i11;
            }
            if (i10 == 1) {
                return c3958e.m7902j();
            }
            if (i10 == 3) {
                return (int) ((c3958e.m7905m() * c3958e.f13337N) + 0.5f);
            }
        }
        return c3958e.m7902j();
    }

    public final int m7932F(C3958e c3958e, int i6) {
        if (c3958e == null) {
            return 0;
        }
        if (c3958e.f13333J[0] == EnumC3957d.f13321c) {
            int i10 = c3958e.f13365j;
            if (i10 == 0) {
                return 0;
            }
            if (i10 == 2) {
                int i11 = (int) (c3958e.f13370o * i6);
                if (i11 != c3958e.m7905m()) {
                    m7933G(c3958e, EnumC3957d.f13319a, i11, c3958e.f13333J[1], c3958e.m7902j());
                }
                return i11;
            }
            if (i10 == 1) {
                return c3958e.m7905m();
            }
            if (i10 == 3) {
                return (int) ((c3958e.m7902j() * c3958e.f13337N) + 0.5f);
            }
        }
        return c3958e.m7905m();
    }

    public final void m7933G(C3958e c3958e, EnumC3957d enumC3957d, int i6, EnumC3957d enumC3957d2, int i10) {
        InterfaceC4028c interfaceC4028c;
        C3958e c3958e2;
        while (true) {
            interfaceC4028c = this.f13443s0;
            if (interfaceC4028c != null || (c3958e2 = this.f13334K) == null) {
                break;
            } else {
                this.f13443s0 = ((C3959f) c3958e2).f13385j0;
            }
        }
        C4027b c4027b = this.f13442r0;
        c4027b.f13643a = enumC3957d;
        c4027b.f13644b = enumC3957d2;
        c4027b.f13645c = i6;
        c4027b.f13646d = i10;
        ((C0306b) interfaceC4028c).m886a(c3958e, c4027b);
        c3958e.m7918z(c4027b.f13647e);
        c3958e.m7915w(c4027b.f13648f);
        c3958e.f13378w = c4027b.f13650h;
        int i11 = c4027b.f13649g;
        c3958e.f13341R = i11;
        c3958e.f13378w = i11 > 0;
    }

    @Override
    public final void mo7882a(C3882e c3882e) {
        C3958e c3958e;
        super.mo7882a(c3882e);
        C3958e c3958e2 = this.f13334K;
        boolean z7 = c3958e2 != null ? ((C3959f) c3958e2).f13386k0 : false;
        int i6 = this.f13424J0;
        ArrayList arrayList = this.f13427M0;
        if (i6 != 0) {
            if (i6 == 1) {
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    ((C3960g) arrayList.get(i10)).m7925b(i10, z7, i10 == size + (-1));
                    i10++;
                }
            } else if (i6 == 2 && this.f13430P0 != null && this.f13429O0 != null && this.f13428N0 != null) {
                for (int i11 = 0; i11 < this.f13432R0; i11++) {
                    this.f13431Q0[i11].m7913u();
                }
                int[] iArr = this.f13430P0;
                int i12 = iArr[0];
                int i13 = iArr[1];
                C3958e c3958e3 = null;
                for (int i14 = 0; i14 < i12; i14++) {
                    C3958e c3958e4 = this.f13429O0[z7 ? (i12 - i14) - 1 : i14];
                    if (c3958e4 != null && c3958e4.f13347X != 8) {
                        C3956c c3956c = c3958e4.f13380y;
                        if (i14 == 0) {
                            c3958e4.m7898e(c3956c, this.f13380y, this.f13437m0);
                            c3958e4.f13349Z = this.f13444t0;
                            c3958e4.f13344U = this.f13450z0;
                        }
                        if (i14 == i12 - 1) {
                            c3958e4.m7898e(c3958e4.f13324A, this.f13324A, this.f13438n0);
                        }
                        if (i14 > 0) {
                            c3958e4.m7898e(c3956c, c3958e3.f13324A, this.f13420F0);
                            c3958e3.m7898e(c3958e3.f13324A, c3956c, 0);
                        }
                        c3958e3 = c3958e4;
                    }
                }
                for (int i15 = 0; i15 < i13; i15++) {
                    C3958e c3958e5 = this.f13428N0[i15];
                    if (c3958e5 != null && c3958e5.f13347X != 8) {
                        C3956c c3956c2 = c3958e5.f13381z;
                        if (i15 == 0) {
                            c3958e5.m7898e(c3956c2, this.f13381z, this.f13433i0);
                            c3958e5.f13351a0 = this.f13445u0;
                            c3958e5.f13345V = this.f13415A0;
                        }
                        if (i15 == i13 - 1) {
                            c3958e5.m7898e(c3958e5.f13325B, this.f13325B, this.f13434j0);
                        }
                        if (i15 > 0) {
                            c3958e5.m7898e(c3956c2, c3958e3.f13325B, this.f13421G0);
                            c3958e3.m7898e(c3958e3.f13325B, c3956c2, 0);
                        }
                        c3958e3 = c3958e5;
                    }
                }
                for (int i16 = 0; i16 < i12; i16++) {
                    for (int i17 = 0; i17 < i13; i17++) {
                        int i18 = (i17 * i12) + i16;
                        if (this.f13426L0 == 1) {
                            i18 = (i16 * i13) + i17;
                        }
                        C3958e[] c3958eArr = this.f13431Q0;
                        if (i18 < c3958eArr.length && (c3958e = c3958eArr[i18]) != null && c3958e.f13347X != 8) {
                            C3958e c3958e6 = this.f13429O0[i16];
                            C3958e c3958e7 = this.f13428N0[i17];
                            if (c3958e != c3958e6) {
                                c3958e.m7898e(c3958e.f13380y, c3958e6.f13380y, 0);
                                c3958e.m7898e(c3958e.f13324A, c3958e6.f13324A, 0);
                            }
                            if (c3958e != c3958e7) {
                                c3958e.m7898e(c3958e.f13381z, c3958e7.f13381z, 0);
                                c3958e.m7898e(c3958e.f13325B, c3958e7.f13325B, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((C3960g) arrayList.get(0)).m7925b(0, z7, true);
        }
        this.f13439o0 = false;
    }

    @Override
    public final void mo7884f(C3958e c3958e, HashMap map) {
        super.mo7884f(c3958e, map);
        C3961h c3961h = (C3961h) c3958e;
        this.f13444t0 = c3961h.f13444t0;
        this.f13445u0 = c3961h.f13445u0;
        this.f13446v0 = c3961h.f13446v0;
        this.f13447w0 = c3961h.f13447w0;
        this.f13448x0 = c3961h.f13448x0;
        this.f13449y0 = c3961h.f13449y0;
        this.f13450z0 = c3961h.f13450z0;
        this.f13415A0 = c3961h.f13415A0;
        this.f13416B0 = c3961h.f13416B0;
        this.f13417C0 = c3961h.f13417C0;
        this.f13418D0 = c3961h.f13418D0;
        this.f13419E0 = c3961h.f13419E0;
        this.f13420F0 = c3961h.f13420F0;
        this.f13421G0 = c3961h.f13421G0;
        this.f13422H0 = c3961h.f13422H0;
        this.f13423I0 = c3961h.f13423I0;
        this.f13424J0 = c3961h.f13424J0;
        this.f13425K0 = c3961h.f13425K0;
        this.f13426L0 = c3961h.f13426L0;
    }
}
