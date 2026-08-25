package p109k3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p186r3.AbstractC3610n;

public final class C2882n implements InterfaceC2869a {

    public final C2888t f9816a;

    public C2882n(C2888t c2888t) {
        this.f9816a = c2888t;
    }

    @Override
    public final void mo3567a(boolean z7) {
        ArrayList arrayList;
        AbstractC3610n.m7233a();
        synchronized (this.f9816a) {
            arrayList = new ArrayList((HashSet) this.f9816a.f9833d);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC2869a) it.next()).mo3567a(z7);
        }
    }
}
