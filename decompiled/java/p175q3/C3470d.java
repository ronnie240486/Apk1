package p175q3;

import java.security.MessageDigest;
import p186r3.AbstractC3602f;
import p228v2.InterfaceC3978e;

public final class C3470d implements InterfaceC3978e {

    public final Object f11735b;

    public C3470d(Object obj) {
        AbstractC3602f.m7225c(obj, "Argument must not be null");
        this.f11735b = obj;
    }

    @Override
    public final void mo3160a(MessageDigest messageDigest) {
        messageDigest.update(this.f11735b.toString().getBytes(InterfaceC3978e.f13509a));
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof C3470d) {
            return this.f11735b.equals(((C3470d) obj).f11735b);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.f11735b.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.f11735b + '}';
    }
}
