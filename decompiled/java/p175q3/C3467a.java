package p175q3;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import p186r3.AbstractC3610n;
import p228v2.InterfaceC3978e;

public final class C3467a implements InterfaceC3978e {

    public final int f11731b;

    public final InterfaceC3978e f11732c;

    public C3467a(int i6, InterfaceC3978e interfaceC3978e) {
        this.f11731b = i6;
        this.f11732c = interfaceC3978e;
    }

    @Override
    public final void mo3160a(MessageDigest messageDigest) {
        this.f11732c.mo3160a(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f11731b).array());
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof C3467a)) {
            return false;
        }
        C3467a c3467a = (C3467a) obj;
        return this.f11731b == c3467a.f11731b && this.f11732c.equals(c3467a.f11732c);
    }

    @Override
    public final int hashCode() {
        return AbstractC3610n.m7240h(this.f11731b, this.f11732c);
    }
}
