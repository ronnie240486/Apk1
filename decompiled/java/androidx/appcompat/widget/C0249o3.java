package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.app.C0155q0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p000a.AbstractC0004e;
import p105k.InterfaceC2836j;
import p105k.MenuC2838l;

public final class C0249o3 implements InterfaceC0240n, InterfaceC2836j {

    public final Toolbar f1025a;

    public C0249o3(Toolbar toolbar) {
        this.f1025a = toolbar;
    }

    @Override
    public boolean mo94j(MenuC2838l menuC2838l, MenuItem menuItem) {
        C0155q0 c0155q0 = this.f1025a.f821O;
        return false;
    }

    @Override
    public void mo97n(MenuC2838l menuC2838l) {
        Toolbar toolbar = this.f1025a;
        C0225k c0225k = toolbar.f827a.f580t;
        if (c0225k == null || !c0225k.m711h()) {
            Iterator it = ((CopyOnWriteArrayList) toolbar.f813G.f10226c).iterator();
            if (it.hasNext()) {
                throw AbstractC0004e.m18l(it);
            }
        }
        C0155q0 c0155q0 = toolbar.f821O;
        if (c0155q0 != null) {
            c0155q0.mo97n(menuC2838l);
        }
    }
}
