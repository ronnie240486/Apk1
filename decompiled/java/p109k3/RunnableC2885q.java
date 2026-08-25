package p109k3;

import com.google.android.gms.internal.cast.C1668r0;
import p048e2.C2368c;
import p186r3.AbstractC3610n;

public final class RunnableC2885q implements Runnable {

    public final int f9817a;

    public final boolean f9818b;

    public final Object f9819c;

    public RunnableC2885q(int i6, Object obj, boolean z7) {
        this.f9817a = i6;
        this.f9819c = obj;
        this.f9818b = z7;
    }

    @Override
    public final void run() {
        switch (this.f9817a) {
            case 0:
                C1668r0 c1668r0 = (C1668r0) this.f9819c;
                c1668r0.getClass();
                AbstractC3610n.m7233a();
                C2368c c2368c = (C2368c) c1668r0.f5575b;
                boolean z7 = c2368c.f8286a;
                boolean z10 = this.f9818b;
                c2368c.f8286a = z10;
                if (z7 != z10) {
                    ((C2882n) c2368c.f8287b).mo3567a(z10);
                }
                break;
            default:
                ((C2887s) this.f9819c).f9824b.mo3567a(this.f9818b);
                break;
        }
    }
}
