package p116ka;

import org.bitspark.android.utils.AbstractC3329k;
import p101j7.C2782c;

public final class RunnableC2942w implements Runnable {

    public final int f10027a;

    public final ViewOnKeyListenerC2944y f10028b;

    public RunnableC2942w(ViewOnKeyListenerC2944y viewOnKeyListenerC2944y, int i6) {
        this.f10027a = i6;
        this.f10028b = viewOnKeyListenerC2944y;
    }

    @Override
    public final void run() {
        switch (this.f10027a) {
            case 0:
                AbstractC3329k.m6747c(this.f10028b.m1319h());
                break;
            default:
                AbstractC3329k.m6750f(new C2782c(6, this));
                break;
        }
    }
}
