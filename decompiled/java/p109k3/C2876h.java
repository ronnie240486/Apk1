package p109k3;

import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.EnumC0537n;
import androidx.lifecycle.EnumC0539o;
import androidx.lifecycle.InterfaceC0522f0;
import androidx.lifecycle.InterfaceC0553v;
import androidx.lifecycle.InterfaceC0555w;
import java.util.HashSet;
import java.util.Iterator;
import p186r3.AbstractC3610n;

public final class C2876h implements InterfaceC2875g, InterfaceC0553v {

    public final HashSet f9808a = new HashSet();

    public final AbstractC0541p f9809b;

    public C2876h(AbstractC0541p abstractC0541p) {
        this.f9809b = abstractC0541p;
        abstractC0541p.mo1508a(this);
    }

    @Override
    public final void mo5861g(InterfaceC2877i interfaceC2877i) {
        this.f9808a.remove(interfaceC2877i);
    }

    @Override
    public final void mo5862h(InterfaceC2877i interfaceC2877i) {
        this.f9808a.add(interfaceC2877i);
        AbstractC0541p abstractC0541p = this.f9809b;
        if (abstractC0541p.mo1509b() == EnumC0539o.f2507a) {
            interfaceC2877i.mo3566j();
        } else if (abstractC0541p.mo1509b().compareTo(EnumC0539o.f2510d) >= 0) {
            interfaceC2877i.mo3565i();
        } else {
            interfaceC2877i.mo3559c();
        }
    }

    @InterfaceC0522f0(EnumC0537n.ON_DESTROY)
    public void onDestroy(InterfaceC0555w interfaceC0555w) {
        Iterator it = AbstractC3610n.m7237e(this.f9808a).iterator();
        while (it.hasNext()) {
            ((InterfaceC2877i) it.next()).mo3566j();
        }
        interfaceC0555w.mo360f().mo1510c(this);
    }

    @InterfaceC0522f0(EnumC0537n.ON_START)
    public void onStart(InterfaceC0555w interfaceC0555w) {
        Iterator it = AbstractC3610n.m7237e(this.f9808a).iterator();
        while (it.hasNext()) {
            ((InterfaceC2877i) it.next()).mo3565i();
        }
    }

    @InterfaceC0522f0(EnumC0537n.ON_STOP)
    public void onStop(InterfaceC0555w interfaceC0555w) {
        Iterator it = AbstractC3610n.m7237e(this.f9808a).iterator();
        while (it.hasNext()) {
            ((InterfaceC2877i) it.next()).mo3559c();
        }
    }
}
