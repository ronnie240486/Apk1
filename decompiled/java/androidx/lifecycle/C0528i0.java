package androidx.lifecycle;

import android.os.Handler;
import p000a.RunnableC0001b;
import p001a0.C0019b;
import p103j9.AbstractC2796i;

public final class C0528i0 implements InterfaceC0555w {

    public static final C0528i0 f2486i = new C0528i0();

    public int f2487a;

    public int f2488b;

    public Handler f2491e;

    public boolean f2489c = true;

    public boolean f2490d = true;

    public final C0559y f2492f = new C0559y(this);

    public final RunnableC0001b f2493g = new RunnableC0001b(4, this);

    public final C0019b f2494h = new C0019b(8, this);

    public final void m1495b() {
        int i6 = this.f2488b + 1;
        this.f2488b = i6;
        if (i6 == 1) {
            if (this.f2489c) {
                this.f2492f.m1521f(EnumC0537n.ON_RESUME);
                this.f2489c = false;
            } else {
                Handler handler = this.f2491e;
                AbstractC2796i.m5782c(handler);
                handler.removeCallbacks(this.f2493g);
            }
        }
    }

    @Override
    public final AbstractC0541p mo360f() {
        return this.f2492f;
    }
}
