package androidx.appcompat.widget;

import p093j.C2749j;
import p156o9.AbstractC3280d;

public final class C0279u3 extends AbstractC3280d {

    public final int f1078j;

    public boolean f1079k;

    public int f1080l;

    public final Object f1081m;

    public C0279u3(C0284v3 c0284v3, int i6) {
        this.f1078j = 0;
        this.f1081m = c0284v3;
        this.f1080l = i6;
        this.f1079k = false;
    }

    @Override
    public final void mo463a() {
        switch (this.f1078j) {
            case 0:
                if (!this.f1079k) {
                    ((C0284v3) this.f1081m).f1098a.setVisibility(this.f1080l);
                }
                break;
            default:
                int i6 = this.f1080l + 1;
                this.f1080l = i6;
                C2749j c2749j = (C2749j) this.f1081m;
                if (i6 == c2749j.f9463a.size()) {
                    AbstractC3280d abstractC3280d = c2749j.f9466d;
                    if (abstractC3280d != null) {
                        abstractC3280d.mo463a();
                    }
                    this.f1080l = 0;
                    this.f1079k = false;
                    c2749j.f9467e = false;
                }
                break;
        }
    }

    @Override
    public void mo633b() {
        switch (this.f1078j) {
            case 0:
                this.f1079k = true;
                break;
        }
    }

    @Override
    public final void mo464c() {
        switch (this.f1078j) {
            case 0:
                ((C0284v3) this.f1081m).f1098a.setVisibility(0);
                break;
            default:
                if (!this.f1079k) {
                    this.f1079k = true;
                    AbstractC3280d abstractC3280d = ((C2749j) this.f1081m).f9466d;
                    if (abstractC3280d != null) {
                        abstractC3280d.mo464c();
                    }
                    break;
                }
                break;
        }
    }

    public C0279u3(C2749j c2749j) {
        this.f1078j = 1;
        this.f1081m = c2749j;
        this.f1079k = false;
        this.f1080l = 0;
    }
}
