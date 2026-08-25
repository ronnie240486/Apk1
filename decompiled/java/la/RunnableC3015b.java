package la;

import org.bitspark.android.utils.AbstractC3329k;
import p101j7.C2782c;

public final class RunnableC3015b implements Runnable {

    public final int f10306a;

    public final ViewOnClickListenerC3017d f10307b;

    public RunnableC3015b(ViewOnClickListenerC3017d viewOnClickListenerC3017d, int i6) {
        this.f10306a = i6;
        this.f10307b = viewOnClickListenerC3017d;
    }

    @Override
    public final void run() {
        switch (this.f10306a) {
            case 0:
                AbstractC3329k.m6747c(this.f10307b.m1319h());
                break;
            default:
                AbstractC3329k.m6750f(new C2782c(10, this));
                break;
        }
    }
}
