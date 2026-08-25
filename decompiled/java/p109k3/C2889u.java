package p109k3;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import p151o3.InterfaceC3254h;
import p186r3.AbstractC3610n;

public final class C2889u implements InterfaceC2877i {

    public final Set f9834a = Collections.newSetFromMap(new WeakHashMap());

    @Override
    public final void mo3559c() {
        Iterator it = AbstractC3610n.m7237e(this.f9834a).iterator();
        while (it.hasNext()) {
            ((InterfaceC3254h) it.next()).mo3559c();
        }
    }

    @Override
    public final void mo3565i() {
        Iterator it = AbstractC3610n.m7237e(this.f9834a).iterator();
        while (it.hasNext()) {
            ((InterfaceC3254h) it.next()).mo3565i();
        }
    }

    @Override
    public final void mo3566j() {
        Iterator it = AbstractC3610n.m7237e(this.f9834a).iterator();
        while (it.hasNext()) {
            ((InterfaceC3254h) it.next()).mo3566j();
        }
    }
}
