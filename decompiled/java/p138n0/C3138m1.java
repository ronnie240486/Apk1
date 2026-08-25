package p138n0;

import android.view.WindowInsets;
import p056f0.C2480c;

public class C3138m1 extends C3135l1 {

    public C2480c f10622n;

    public C2480c f10623o;

    public C2480c f10624p;

    public C3138m1(C3153r1 c3153r1, WindowInsets windowInsets) {
        super(c3153r1, windowInsets);
        this.f10622n = null;
        this.f10623o = null;
        this.f10624p = null;
    }

    @Override
    public C2480c mo6272h() {
        if (this.f10623o == null) {
            this.f10623o = C2480c.m5516b(this.f10615c.getMandatorySystemGestureInsets());
        }
        return this.f10623o;
    }

    @Override
    public C2480c mo6273j() {
        if (this.f10622n == null) {
            this.f10622n = C2480c.m5516b(this.f10615c.getSystemGestureInsets());
        }
        return this.f10622n;
    }

    @Override
    public C2480c mo6274l() {
        if (this.f10624p == null) {
            this.f10624p = C2480c.m5516b(this.f10615c.getTappableElementInsets());
        }
        return this.f10624p;
    }

    @Override
    public C3153r1 mo6230m(int i6, int i10, int i11, int i12) {
        return C3153r1.m6324h(this.f10615c.inset(i6, i10, i11, i12), null);
    }

    public C3138m1(C3153r1 c3153r1, C3138m1 c3138m1) {
        super(c3153r1, c3138m1);
        this.f10622n = null;
        this.f10623o = null;
        this.f10624p = null;
    }

    @Override
    public void mo6240s(C2480c c2480c) {
    }
}
