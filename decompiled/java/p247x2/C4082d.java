package p247x2;

import java.security.MessageDigest;
import p228v2.InterfaceC3978e;

public final class C4082d implements InterfaceC3978e {

    public final InterfaceC3978e f13770b;

    public final InterfaceC3978e f13771c;

    public C4082d(InterfaceC3978e interfaceC3978e, InterfaceC3978e interfaceC3978e2) {
        this.f13770b = interfaceC3978e;
        this.f13771c = interfaceC3978e2;
    }

    @Override
    public final void mo3160a(MessageDigest messageDigest) {
        this.f13770b.mo3160a(messageDigest);
        this.f13771c.mo3160a(messageDigest);
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof C4082d)) {
            return false;
        }
        C4082d c4082d = (C4082d) obj;
        return this.f13770b.equals(c4082d.f13770b) && this.f13771c.equals(c4082d.f13771c);
    }

    @Override
    public final int hashCode() {
        return this.f13771c.hashCode() + (this.f13770b.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.f13770b + ", signature=" + this.f13771c + '}';
    }
}
