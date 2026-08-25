package androidx.fragment.app;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.C0562z0;
import androidx.lifecycle.InterfaceC0512a1;
import p000a.InterfaceC0017r;
import p003a2.AbstractC0032a;
import p022c.InterfaceC1373b;
import p156o9.AbstractC3281e;

public final class C0433v extends AbstractC3281e implements InterfaceC0512a1, InterfaceC0017r, InterfaceC1373b, InterfaceC0416m0 {

    public final FragmentActivity f2002f;

    public final FragmentActivity f2003g;

    public final Handler f2004h;

    public final C0412k0 f2005i;

    public final FragmentActivity f2006j;

    public C0433v(FragmentActivity fragmentActivity) {
        this.f2006j = fragmentActivity;
        Handler handler = new Handler();
        this.f2005i = new C0412k0();
        this.f2002f = fragmentActivity;
        AbstractC0032a.m162p(fragmentActivity, "context == null");
        this.f2003g = fragmentActivity;
        this.f2004h = handler;
    }

    @Override
    public final View mo1265B(int i6) {
        return this.f2006j.findViewById(i6);
    }

    @Override
    public final boolean mo1266C() {
        Window window = this.f2006j.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override
    public final void mo1204b() {
        this.f2006j.getClass();
    }

    @Override
    public final C0562z0 mo359e() {
        return this.f2006j.mo359e();
    }

    @Override
    public final AbstractC0541p mo360f() {
        return this.f2006j.f1766s;
    }
}
