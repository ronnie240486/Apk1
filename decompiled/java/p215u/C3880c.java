package p215u;

import androidx.media3.exoplayer.rtsp.SessionDescription;
import java.util.ArrayList;
import p001a0.C0023f;
import p055ea.AbstractC2460q;

public class C3880c {

    public InterfaceC3879b f13027d;

    public C3886i f13024a = null;

    public float f13025b = 0.0f;

    public ArrayList f13026c = new ArrayList();

    public boolean f13028e = false;

    public C3880c(C0023f c0023f) {
        this.f13027d = new C3878a(this, c0023f);
    }

    public final void m7757a(C3882e c3882e, int i6) {
        this.f13027d.mo7753h(c3882e.m7774i(i6), 1.0f);
        this.f13027d.mo7753h(c3882e.m7774i(i6), -1.0f);
    }

    public final void m7758b(C3886i c3886i, C3886i c3886i2, C3886i c3886i3, int i6) {
        boolean z7 = false;
        if (i6 != 0) {
            if (i6 < 0) {
                i6 *= -1;
                z7 = true;
            }
            this.f13025b = i6;
        }
        if (z7) {
            this.f13027d.mo7753h(c3886i, 1.0f);
            this.f13027d.mo7753h(c3886i2, -1.0f);
            this.f13027d.mo7753h(c3886i3, -1.0f);
        } else {
            this.f13027d.mo7753h(c3886i, -1.0f);
            this.f13027d.mo7753h(c3886i2, 1.0f);
            this.f13027d.mo7753h(c3886i3, 1.0f);
        }
    }

    public final void m7759c(C3886i c3886i, C3886i c3886i2, C3886i c3886i3, int i6) {
        boolean z7 = false;
        if (i6 != 0) {
            if (i6 < 0) {
                i6 *= -1;
                z7 = true;
            }
            this.f13025b = i6;
        }
        if (z7) {
            this.f13027d.mo7753h(c3886i, 1.0f);
            this.f13027d.mo7753h(c3886i2, -1.0f);
            this.f13027d.mo7753h(c3886i3, 1.0f);
        } else {
            this.f13027d.mo7753h(c3886i, -1.0f);
            this.f13027d.mo7753h(c3886i2, 1.0f);
            this.f13027d.mo7753h(c3886i3, -1.0f);
        }
    }

    public C3886i mo7760d(boolean[] zArr) {
        return m7761e(zArr, null);
    }

    public final C3886i m7761e(boolean[] zArr, C3886i c3886i) {
        int i6;
        int iMo7749d = this.f13027d.mo7749d();
        C3886i c3886i2 = null;
        float f = 0.0f;
        for (int i10 = 0; i10 < iMo7749d; i10++) {
            float fMo7746a = this.f13027d.mo7746a(i10);
            if (fMo7746a < 0.0f) {
                C3886i c3886iMo7754i = this.f13027d.mo7754i(i10);
                if ((zArr == null || !zArr[c3886iMo7754i.f13052b]) && c3886iMo7754i != c3886i && (((i6 = c3886iMo7754i.f13062l) == 3 || i6 == 4) && fMo7746a < f)) {
                    f = fMo7746a;
                    c3886i2 = c3886iMo7754i;
                }
            }
        }
        return c3886i2;
    }

    public final void m7762f(C3886i c3886i) {
        C3886i c3886i2 = this.f13024a;
        if (c3886i2 != null) {
            this.f13027d.mo7753h(c3886i2, -1.0f);
            this.f13024a = null;
        }
        float fMo7747b = this.f13027d.mo7747b(c3886i, true) * (-1.0f);
        this.f13024a = c3886i;
        if (fMo7747b == 1.0f) {
            return;
        }
        this.f13025b /= fMo7747b;
        this.f13027d.mo7755j(fMo7747b);
    }

    public final void m7763g(C3886i c3886i, boolean z7) {
        if (c3886i.f13056f) {
            float fMo7752g = this.f13027d.mo7752g(c3886i);
            this.f13025b = (c3886i.f13055e * fMo7752g) + this.f13025b;
            this.f13027d.mo7747b(c3886i, z7);
            if (z7) {
                c3886i.m7787b(this);
            }
        }
    }

    public void mo7764h(C3880c c3880c, boolean z7) {
        float fMo7748c = this.f13027d.mo7748c(c3880c, z7);
        this.f13025b = (c3880c.f13025b * fMo7748c) + this.f13025b;
        if (z7) {
            c3880c.f13024a.m7787b(this);
        }
    }

    public String toString() {
        boolean z7;
        String strM5494h = AbstractC2460q.m5494h(this.f13024a == null ? SessionDescription.SUPPORTED_SDP_VERSION : "" + this.f13024a, " = ");
        if (this.f13025b != 0.0f) {
            StringBuilder sbM5498l = AbstractC2460q.m5498l(strM5494h);
            sbM5498l.append(this.f13025b);
            strM5494h = sbM5498l.toString();
            z7 = true;
        } else {
            z7 = false;
        }
        int iMo7749d = this.f13027d.mo7749d();
        for (int i6 = 0; i6 < iMo7749d; i6++) {
            C3886i c3886iMo7754i = this.f13027d.mo7754i(i6);
            if (c3886iMo7754i != null) {
                float fMo7746a = this.f13027d.mo7746a(i6);
                if (fMo7746a != 0.0f) {
                    String string = c3886iMo7754i.toString();
                    if (z7) {
                        if (fMo7746a > 0.0f) {
                            strM5494h = AbstractC2460q.m5494h(strM5494h, " + ");
                        } else {
                            strM5494h = AbstractC2460q.m5494h(strM5494h, " - ");
                            fMo7746a *= -1.0f;
                        }
                    } else if (fMo7746a < 0.0f) {
                        strM5494h = AbstractC2460q.m5494h(strM5494h, "- ");
                        fMo7746a *= -1.0f;
                    }
                    strM5494h = fMo7746a == 1.0f ? AbstractC2460q.m5494h(strM5494h, string) : strM5494h + fMo7746a + " " + string;
                    z7 = true;
                }
            }
        }
        return !z7 ? AbstractC2460q.m5494h(strM5494h, "0.0") : strM5494h;
    }
}
