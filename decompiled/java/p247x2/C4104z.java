package p247x2;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import p186r3.AbstractC3610n;
import p186r3.C3606j;
import p228v2.C3981h;
import p228v2.InterfaceC3978e;
import p228v2.InterfaceC3985l;
import p259y2.C4241d;
import p259y2.C4242e;
import p259y2.C4243f;
import p259y2.InterfaceC4245h;

public final class C4104z implements InterfaceC3978e {

    public static final C3606j f13912j = new C3606j(50);

    public final C4243f f13913b;

    public final InterfaceC3978e f13914c;

    public final InterfaceC3978e f13915d;

    public final int f13916e;

    public final int f13917f;

    public final Class f13918g;

    public final C3981h f13919h;

    public final InterfaceC3985l f13920i;

    public C4104z(C4243f c4243f, InterfaceC3978e interfaceC3978e, InterfaceC3978e interfaceC3978e2, int i6, int i10, InterfaceC3985l interfaceC3985l, Class cls, C3981h c3981h) {
        this.f13913b = c4243f;
        this.f13914c = interfaceC3978e;
        this.f13915d = interfaceC3978e2;
        this.f13916e = i6;
        this.f13917f = i10;
        this.f13920i = interfaceC3985l;
        this.f13918g = cls;
        this.f13919h = c3981h;
    }

    @Override
    public final void mo3160a(MessageDigest messageDigest) {
        Object objM8289f;
        C4243f c4243f = this.f13913b;
        synchronized (c4243f) {
            C4242e c4242e = c4243f.f14407b;
            InterfaceC4245h interfaceC4245hM8283e = (InterfaceC4245h) ((ArrayDeque) c4242e.f7850a).poll();
            if (interfaceC4245hM8283e == null) {
                interfaceC4245hM8283e = c4242e.m8283e();
            }
            C4241d c4241d = (C4241d) interfaceC4245hM8283e;
            c4241d.f14403b = 8;
            c4241d.f14404c = byte[].class;
            objM8289f = c4243f.m8289f(c4241d, byte[].class);
        }
        byte[] bArr = (byte[]) objM8289f;
        ByteBuffer.wrap(bArr).putInt(this.f13916e).putInt(this.f13917f).array();
        this.f13915d.mo3160a(messageDigest);
        this.f13914c.mo3160a(messageDigest);
        messageDigest.update(bArr);
        InterfaceC3985l interfaceC3985l = this.f13920i;
        if (interfaceC3985l != null) {
            interfaceC3985l.mo3160a(messageDigest);
        }
        this.f13919h.mo3160a(messageDigest);
        C3606j c3606j = f13912j;
        Class cls = this.f13918g;
        byte[] bytes = (byte[]) c3606j.m7227a(cls);
        if (bytes == null) {
            bytes = cls.getName().getBytes(InterfaceC3978e.f13509a);
            c3606j.m7229d(cls, bytes);
        }
        messageDigest.update(bytes);
        this.f13913b.m8291h(bArr);
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof C4104z)) {
            return false;
        }
        C4104z c4104z = (C4104z) obj;
        return this.f13917f == c4104z.f13917f && this.f13916e == c4104z.f13916e && AbstractC3610n.m7234b(this.f13920i, c4104z.f13920i) && this.f13918g.equals(c4104z.f13918g) && this.f13914c.equals(c4104z.f13914c) && this.f13915d.equals(c4104z.f13915d) && this.f13919h.equals(c4104z.f13919h);
    }

    @Override
    public final int hashCode() {
        int iHashCode = ((((this.f13915d.hashCode() + (this.f13914c.hashCode() * 31)) * 31) + this.f13916e) * 31) + this.f13917f;
        InterfaceC3985l interfaceC3985l = this.f13920i;
        if (interfaceC3985l != null) {
            iHashCode = (iHashCode * 31) + interfaceC3985l.hashCode();
        }
        return this.f13919h.f13515b.hashCode() + ((this.f13918g.hashCode() + (iHashCode * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f13914c + ", signature=" + this.f13915d + ", width=" + this.f13916e + ", height=" + this.f13917f + ", decodedResourceClass=" + this.f13918g + ", transformation='" + this.f13920i + "', options=" + this.f13919h + '}';
    }
}
