package androidx.appcompat.widget;

import p105k.C2840n;

public final class RunnableC0244n3 implements Runnable {

    public final int f1019a;

    public final Toolbar f1020b;

    public RunnableC0244n3(Toolbar toolbar, int i6) {
        this.f1019a = i6;
        this.f1020b = toolbar;
    }

    @Override
    public final void run() {
        switch (this.f1019a) {
            case 0:
                C0259q3 c0259q3 = this.f1020b.f819M;
                C2840n c2840n = c0259q3 == null ? null : c0259q3.f1041b;
                if (c2840n != null) {
                    c2840n.collapseActionView();
                }
                break;
            default:
                this.f1020b.m622n();
                break;
        }
    }
}
