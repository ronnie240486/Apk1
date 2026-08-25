package p225v;

import java.util.Arrays;
import java.util.HashMap;

public class C3963j extends C3958e {

    public C3958e[] f13456g0 = new C3958e[4];

    public int f13457h0 = 0;

    public final void m7935C(C3958e c3958e) {
        if (c3958e == this || c3958e == null) {
            return;
        }
        int i6 = this.f13457h0 + 1;
        C3958e[] c3958eArr = this.f13456g0;
        if (i6 > c3958eArr.length) {
            this.f13456g0 = (C3958e[]) Arrays.copyOf(c3958eArr, c3958eArr.length * 2);
        }
        C3958e[] c3958eArr2 = this.f13456g0;
        int i10 = this.f13457h0;
        c3958eArr2[i10] = c3958e;
        this.f13457h0 = i10 + 1;
    }

    @Override
    public void mo7884f(C3958e c3958e, HashMap map) {
        super.mo7884f(c3958e, map);
        C3963j c3963j = (C3963j) c3958e;
        this.f13457h0 = 0;
        int i6 = c3963j.f13457h0;
        for (int i10 = 0; i10 < i6; i10++) {
            m7935C((C3958e) map.get(c3963j.f13456g0[i10]));
        }
    }

    public void mo7930D() {
    }
}
