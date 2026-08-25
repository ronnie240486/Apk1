package p225v;

import java.util.ArrayList;
import java.util.HashMap;
import p055ea.AbstractC2460q;
import p215u.AbstractC3885h;
import p215u.C3880c;
import p215u.C3882e;
import p215u.C3886i;

public final class C3962i extends C3958e {

    public float f13451g0 = -1.0f;

    public int f13452h0 = -1;

    public int f13453i0 = -1;

    public C3956c f13454j0 = this.f13381z;

    public int f13455k0 = 0;

    public C3962i() {
        this.f13331H.clear();
        this.f13331H.add(this.f13454j0);
        int length = this.f13330G.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f13330G[i6] = this.f13454j0;
        }
    }

    @Override
    public final void mo7895B(C3882e c3882e) {
        if (this.f13334K == null) {
            return;
        }
        C3956c c3956c = this.f13454j0;
        c3882e.getClass();
        int iM7765m = C3882e.m7765m(c3956c);
        if (this.f13455k0 == 1) {
            this.f13339P = iM7765m;
            this.f13340Q = 0;
            m7915w(this.f13334K.m7902j());
            m7918z(0);
            return;
        }
        this.f13339P = 0;
        this.f13340Q = iM7765m;
        m7918z(this.f13334K.m7905m());
        m7915w(0);
    }

    public final void m7934C(int i6) {
        if (this.f13455k0 == i6) {
            return;
        }
        this.f13455k0 = i6;
        ArrayList arrayList = this.f13331H;
        arrayList.clear();
        if (this.f13455k0 == 1) {
            this.f13454j0 = this.f13380y;
        } else {
            this.f13454j0 = this.f13381z;
        }
        arrayList.add(this.f13454j0);
        C3956c[] c3956cArr = this.f13330G;
        int length = c3956cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            c3956cArr[i10] = this.f13454j0;
        }
    }

    @Override
    public final void mo7882a(C3882e c3882e) {
        C3959f c3959f = (C3959f) this.f13334K;
        if (c3959f == null) {
            return;
        }
        C3956c c3956cMo7900h = c3959f.mo7900h(2);
        C3956c c3956cMo7900h2 = c3959f.mo7900h(4);
        C3958e c3958e = this.f13334K;
        EnumC3957d enumC3957d = EnumC3957d.f13320b;
        boolean z7 = c3958e != null && c3958e.f13333J[0] == enumC3957d;
        if (this.f13455k0 == 0) {
            c3956cMo7900h = c3959f.mo7900h(3);
            c3956cMo7900h2 = c3959f.mo7900h(5);
            C3958e c3958e2 = this.f13334K;
            z7 = c3958e2 != null && c3958e2.f13333J[1] == enumC3957d;
        }
        if (this.f13452h0 != -1) {
            C3886i c3886iM7775j = c3882e.m7775j(this.f13454j0);
            c3882e.m7770e(c3886iM7775j, c3882e.m7775j(c3956cMo7900h), this.f13452h0, 8);
            if (z7) {
                c3882e.m7771f(c3882e.m7775j(c3956cMo7900h2), c3886iM7775j, 0, 5);
                return;
            }
            return;
        }
        if (this.f13453i0 != -1) {
            C3886i c3886iM7775j2 = c3882e.m7775j(this.f13454j0);
            C3886i c3886iM7775j3 = c3882e.m7775j(c3956cMo7900h2);
            c3882e.m7770e(c3886iM7775j2, c3886iM7775j3, -this.f13453i0, 8);
            if (z7) {
                c3882e.m7771f(c3886iM7775j2, c3882e.m7775j(c3956cMo7900h), 0, 5);
                c3882e.m7771f(c3886iM7775j3, c3886iM7775j2, 0, 5);
                return;
            }
            return;
        }
        if (this.f13451g0 != -1.0f) {
            C3886i c3886iM7775j4 = c3882e.m7775j(this.f13454j0);
            C3886i c3886iM7775j5 = c3882e.m7775j(c3956cMo7900h2);
            float f = this.f13451g0;
            C3880c c3880cM7776k = c3882e.m7776k();
            c3880cM7776k.f13027d.mo7753h(c3886iM7775j4, -1.0f);
            c3880cM7776k.f13027d.mo7753h(c3886iM7775j5, f);
            c3882e.m7768c(c3880cM7776k);
        }
    }

    @Override
    public final boolean mo7883b() {
        return true;
    }

    @Override
    public final void mo7884f(C3958e c3958e, HashMap map) {
        super.mo7884f(c3958e, map);
        C3962i c3962i = (C3962i) c3958e;
        this.f13451g0 = c3962i.f13451g0;
        this.f13452h0 = c3962i.f13452h0;
        this.f13453i0 = c3962i.f13453i0;
        m7934C(c3962i.f13455k0);
    }

    @Override
    public final C3956c mo7900h(int i6) {
        switch (AbstractC3885h.m7785a(i6)) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case 3:
                if (this.f13455k0 == 1) {
                    return this.f13454j0;
                }
                break;
            case 2:
            case 4:
                if (this.f13455k0 == 0) {
                    return this.f13454j0;
                }
                break;
        }
        throw new AssertionError(AbstractC2460q.m5502p(i6));
    }
}
