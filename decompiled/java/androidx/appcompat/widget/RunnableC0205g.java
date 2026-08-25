package androidx.appcompat.widget;

import android.view.View;
import p105k.InterfaceC2836j;
import p105k.MenuC2838l;

public final class RunnableC0205g implements Runnable {

    public final C0195e f921a;

    public final C0225k f922b;

    public RunnableC0205g(C0225k c0225k, C0195e c0195e) {
        this.f922b = c0225k;
        this.f921a = c0195e;
    }

    @Override
    public final void run() {
        InterfaceC2836j interfaceC2836j;
        C0225k c0225k = this.f922b;
        MenuC2838l menuC2838l = c0225k.f9611c;
        if (menuC2838l != null && (interfaceC2836j = menuC2838l.f9691e) != null) {
            interfaceC2836j.mo97n(menuC2838l);
        }
        View view = (View) c0225k.f9616h;
        if (view != null && view.getWindowToken() != null) {
            C0195e c0195e = this.f921a;
            if (c0195e.m5855b()) {
                c0225k.f971t = c0195e;
            } else if (c0195e.f9759e != null) {
                c0195e.m5856d(0, 0, false, false);
                c0225k.f971t = c0195e;
            }
        }
        c0225k.f973v = null;
    }
}
