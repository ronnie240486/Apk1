package p144n7;

import java.io.IOException;
import java.util.List;
import p125l7.AbstractC3011r;
import p125l7.C3004k;
import p125l7.InterfaceC3012s;
import p202s7.C3723a;
import p212t7.C3812a;
import p212t7.C3813b;

public final class C3207e extends AbstractC3011r {

    public AbstractC3011r f10781a;

    public final boolean f10782b;

    public final boolean f10783c;

    public final C3004k f10784d;

    public final C3723a f10785e;

    public final C3208f f10786f;

    public C3207e(C3208f c3208f, boolean z7, boolean z10, C3004k c3004k, C3723a c3723a) {
        this.f10786f = c3208f;
        this.f10782b = z7;
        this.f10783c = z10;
        this.f10784d = c3004k;
        this.f10785e = c3723a;
    }

    @Override
    public final Object mo6077a(C3812a c3812a) throws IOException {
        if (this.f10782b) {
            c3812a.m7617z();
            return null;
        }
        AbstractC3011r abstractC3011r = this.f10781a;
        if (abstractC3011r == null) {
            C3723a c3723a = this.f10785e;
            C3004k c3004k = this.f10784d;
            List<InterfaceC3012s> list = c3004k.f10299e;
            InterfaceC3012s interfaceC3012s = this.f10786f;
            if (!list.contains(interfaceC3012s)) {
                interfaceC3012s = c3004k.f10298d;
            }
            boolean z7 = false;
            for (InterfaceC3012s interfaceC3012s2 : list) {
                if (z7) {
                    AbstractC3011r abstractC3011rMo6089a = interfaceC3012s2.mo6089a(c3004k, c3723a);
                    if (abstractC3011rMo6089a != null) {
                        this.f10781a = abstractC3011rMo6089a;
                        abstractC3011r = abstractC3011rMo6089a;
                    }
                } else if (interfaceC3012s2 == interfaceC3012s) {
                    z7 = true;
                }
            }
            throw new IllegalArgumentException("GSON cannot serialize " + c3723a);
        }
        return abstractC3011r.mo6077a(c3812a);
    }

    @Override
    public final void mo6078b(C3813b c3813b, Object obj) throws IOException {
        if (this.f10783c) {
            c3813b.m7626i();
            return;
        }
        AbstractC3011r abstractC3011r = this.f10781a;
        if (abstractC3011r == null) {
            C3723a c3723a = this.f10785e;
            C3004k c3004k = this.f10784d;
            List<InterfaceC3012s> list = c3004k.f10299e;
            InterfaceC3012s interfaceC3012s = this.f10786f;
            if (!list.contains(interfaceC3012s)) {
                interfaceC3012s = c3004k.f10298d;
            }
            boolean z7 = false;
            for (InterfaceC3012s interfaceC3012s2 : list) {
                if (z7) {
                    AbstractC3011r abstractC3011rMo6089a = interfaceC3012s2.mo6089a(c3004k, c3723a);
                    if (abstractC3011rMo6089a != null) {
                        this.f10781a = abstractC3011rMo6089a;
                        abstractC3011r = abstractC3011rMo6089a;
                    }
                } else if (interfaceC3012s2 == interfaceC3012s) {
                    z7 = true;
                }
            }
            throw new IllegalArgumentException("GSON cannot serialize " + c3723a);
        }
        abstractC3011r.mo6078b(c3813b, obj);
    }
}
