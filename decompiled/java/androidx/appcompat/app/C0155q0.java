package androidx.appcompat.app;

import android.view.MenuItem;
import androidx.appcompat.widget.InterfaceC0264r3;
import p105k.InterfaceC2836j;
import p105k.MenuC2838l;

public final class C0155q0 implements InterfaceC0264r3, InterfaceC2836j {

    public final C0159s0 f424a;

    public C0155q0(C0159s0 c0159s0) {
        this.f424a = c0159s0;
    }

    @Override
    public boolean mo94j(MenuC2838l menuC2838l, MenuItem menuItem) {
        return false;
    }

    @Override
    public void mo97n(MenuC2838l menuC2838l) {
        C0159s0 c0159s0 = this.f424a;
        boolean zM624p = c0159s0.f432r.f1098a.m624p();
        WindowCallbackC0171z windowCallbackC0171z = c0159s0.f433s;
        if (zM624p) {
            windowCallbackC0171z.onPanelClosed(108, menuC2838l);
        } else if (windowCallbackC0171z.onPreparePanel(0, null, menuC2838l)) {
            windowCallbackC0171z.onMenuOpened(108, menuC2838l);
        }
    }
}
