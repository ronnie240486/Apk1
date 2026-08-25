package p116ka;

import p156o9.AbstractC3280d;

public final class RunnableC2927k implements Runnable {

    public final int f9936a;

    public final ViewOnKeyListenerC2937r f9937b;

    public RunnableC2927k(ViewOnKeyListenerC2937r viewOnKeyListenerC2937r, int i6) {
        this.f9936a = i6;
        this.f9937b = viewOnKeyListenerC2937r;
    }

    @Override
    public final void run() {
        switch (this.f9936a) {
            case 0:
                this.f9937b.f10000W.smoothScrollToPosition(0);
                break;
            case 1:
                AbstractC3280d.m6606y(this.f9937b.f10002Y.f8768e);
                break;
            case 2:
                AbstractC3280d.m6606y(this.f9937b.f10002Y.f8768e);
                break;
            default:
                ViewOnKeyListenerC2937r viewOnKeyListenerC2937r = this.f9937b;
                int iM5550a = viewOnKeyListenerC2937r.f10002Y.m5550a();
                if (iM5550a == -1) {
                    iM5550a = 0;
                }
                AbstractC3280d.m6564A(viewOnKeyListenerC2937r.f10000W, viewOnKeyListenerC2937r.f10002Y, iM5550a);
                break;
        }
    }
}
