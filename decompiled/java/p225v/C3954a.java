package p225v;

import java.util.HashMap;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p215u.C3880c;
import p215u.C3882e;
import p215u.C3886i;

public final class C3954a extends C3963j {

    public int f13292i0 = 0;

    public boolean f13293j0 = true;

    public int f13294k0 = 0;

    @Override
    public final void mo7882a(C3882e c3882e) {
        boolean z7;
        int i6;
        C3956c[] c3956cArr = this.f13330G;
        C3956c c3956c = this.f13380y;
        c3956cArr[0] = c3956c;
        C3956c c3956c2 = this.f13381z;
        int i10 = 2;
        c3956cArr[2] = c3956c2;
        C3956c c3956c3 = this.f13324A;
        c3956cArr[1] = c3956c3;
        C3956c c3956c4 = this.f13325B;
        c3956cArr[3] = c3956c4;
        for (C3956c c3956c5 : c3956cArr) {
            c3956c5.f13318g = c3882e.m7775j(c3956c5);
        }
        int i11 = this.f13292i0;
        if (i11 < 0 || i11 >= 4) {
            return;
        }
        C3956c c3956c6 = c3956cArr[i11];
        int i12 = 0;
        while (true) {
            if (i12 >= this.f13457h0) {
                z7 = false;
                break;
            }
            C3958e c3958e = this.f13456g0[i12];
            if (this.f13293j0 || c3958e.mo7883b()) {
                int i13 = this.f13292i0;
                EnumC3957d enumC3957d = EnumC3957d.f13321c;
                if (((i13 == 0 || i13 == 1) && c3958e.f13333J[0] == enumC3957d && c3958e.f13380y.f13315d != null && c3958e.f13324A.f13315d != null) || ((i13 == 2 || i13 == 3) && c3958e.f13333J[1] == enumC3957d && c3958e.f13381z.f13315d != null && c3958e.f13325B.f13315d != null)) {
                    z7 = true;
                    break;
                }
            }
            i12++;
        }
        boolean z10 = c3956c.m7889e() || c3956c3.m7889e();
        boolean z11 = c3956c2.m7889e() || c3956c4.m7889e();
        int i14 = (z7 || !(((i6 = this.f13292i0) == 0 && z10) || ((i6 == 2 && z11) || ((i6 == 1 && z10) || (i6 == 3 && z11))))) ? 4 : 5;
        int i15 = 0;
        while (i15 < this.f13457h0) {
            C3958e c3958e2 = this.f13456g0[i15];
            if (this.f13293j0 || c3958e2.mo7883b()) {
                C3886i c3886iM7775j = c3882e.m7775j(c3958e2.f13330G[this.f13292i0]);
                int i16 = this.f13292i0;
                C3956c c3956c7 = c3958e2.f13330G[i16];
                c3956c7.f13318g = c3886iM7775j;
                C3956c c3956c8 = c3956c7.f13315d;
                int i17 = (c3956c8 == null || c3956c8.f13313b != this) ? 0 : c3956c7.f13316e;
                if (i16 == 0 || i16 == i10) {
                    C3886i c3886i = c3956c6.f13318g;
                    int i18 = this.f13294k0 - i17;
                    C3880c c3880cM7776k = c3882e.m7776k();
                    C3886i c3886iM7777l = c3882e.m7777l();
                    c3886iM7777l.f13054d = 0;
                    c3880cM7776k.m7759c(c3886i, c3886iM7775j, c3886iM7777l, i18);
                    c3882e.m7768c(c3880cM7776k);
                } else {
                    C3886i c3886i2 = c3956c6.f13318g;
                    int i19 = this.f13294k0 + i17;
                    C3880c c3880cM7776k2 = c3882e.m7776k();
                    C3886i c3886iM7777l2 = c3882e.m7777l();
                    c3886iM7777l2.f13054d = 0;
                    c3880cM7776k2.m7758b(c3886i2, c3886iM7775j, c3886iM7777l2, i19);
                    c3882e.m7768c(c3880cM7776k2);
                }
                c3882e.m7770e(c3956c6.f13318g, c3886iM7775j, this.f13294k0 + i17, i14);
            }
            i15++;
            i10 = 2;
        }
        int i20 = this.f13292i0;
        if (i20 == 0) {
            c3882e.m7770e(c3956c3.f13318g, c3956c.f13318g, 0, 8);
            c3882e.m7770e(c3956c.f13318g, this.f13334K.f13324A.f13318g, 0, 4);
            c3882e.m7770e(c3956c.f13318g, this.f13334K.f13380y.f13318g, 0, 0);
            return;
        }
        if (i20 == 1) {
            c3882e.m7770e(c3956c.f13318g, c3956c3.f13318g, 0, 8);
            c3882e.m7770e(c3956c.f13318g, this.f13334K.f13380y.f13318g, 0, 4);
            c3882e.m7770e(c3956c.f13318g, this.f13334K.f13324A.f13318g, 0, 0);
        } else if (i20 == 2) {
            c3882e.m7770e(c3956c4.f13318g, c3956c2.f13318g, 0, 8);
            c3882e.m7770e(c3956c2.f13318g, this.f13334K.f13325B.f13318g, 0, 4);
            c3882e.m7770e(c3956c2.f13318g, this.f13334K.f13381z.f13318g, 0, 0);
        } else if (i20 == 3) {
            c3882e.m7770e(c3956c2.f13318g, c3956c4.f13318g, 0, 8);
            c3882e.m7770e(c3956c2.f13318g, this.f13334K.f13381z.f13318g, 0, 4);
            c3882e.m7770e(c3956c2.f13318g, this.f13334K.f13325B.f13318g, 0, 0);
        }
    }

    @Override
    public final boolean mo7883b() {
        return true;
    }

    @Override
    public final void mo7884f(C3958e c3958e, HashMap map) {
        super.mo7884f(c3958e, map);
        C3954a c3954a = (C3954a) c3958e;
        this.f13292i0 = c3954a.f13292i0;
        this.f13293j0 = c3954a.f13293j0;
        this.f13294k0 = c3954a.f13294k0;
    }

    @Override
    public final String toString() {
        String strM26t = AbstractC0004e.m26t(new StringBuilder("[Barrier] "), this.f13348Y, " {");
        for (int i6 = 0; i6 < this.f13457h0; i6++) {
            C3958e c3958e = this.f13456g0[i6];
            if (i6 > 0) {
                strM26t = AbstractC2460q.m5494h(strM26t, ", ");
            }
            StringBuilder sbM5498l = AbstractC2460q.m5498l(strM26t);
            sbM5498l.append(c3958e.f13348Y);
            strM26t = sbM5498l.toString();
        }
        return AbstractC2460q.m5494h(strM26t, "}");
    }
}
