package p228v2;

import java.security.MessageDigest;
import p186r3.C3598b;

public final class C3981h implements InterfaceC3978e {

    public final C3598b f13515b = new C3598b(0);

    @Override
    public final void mo3160a(MessageDigest messageDigest) {
        int i6 = 0;
        while (true) {
            C3598b c3598b = this.f13515b;
            if (i6 >= c3598b.f11334c) {
                return;
            }
            C3980g c3980g = (C3980g) c3598b.m6812f(i6);
            Object objM6816j = this.f13515b.m6816j(i6);
            InterfaceC3979f interfaceC3979f = c3980g.f13512b;
            if (c3980g.f13514d == null) {
                c3980g.f13514d = c3980g.f13513c.getBytes(InterfaceC3978e.f13509a);
            }
            interfaceC3979f.mo5416a(c3980g.f13514d, objM6816j, messageDigest);
            i6++;
        }
    }

    public final Object m7967c(C3980g c3980g) {
        C3598b c3598b = this.f13515b;
        return c3598b.containsKey(c3980g) ? c3598b.get(c3980g) : c3980g.f13511a;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof C3981h) {
            return this.f13515b.equals(((C3981h) obj).f13515b);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.f13515b.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.f13515b + '}';
    }
}
