package p247x2;

import java.security.MessageDigest;
import p186r3.AbstractC3602f;
import p186r3.C3598b;
import p228v2.C3981h;
import p228v2.InterfaceC3978e;

public final class C4095q implements InterfaceC3978e {

    public final Object f13870b;

    public final int f13871c;

    public final int f13872d;

    public final Class f13873e;

    public final Class f13874f;

    public final InterfaceC3978e f13875g;

    public final C3598b f13876h;

    public final C3981h f13877i;

    public int f13878j;

    public C4095q(Object obj, InterfaceC3978e interfaceC3978e, int i6, int i10, C3598b c3598b, Class cls, Class cls2, C3981h c3981h) {
        AbstractC3602f.m7225c(obj, "Argument must not be null");
        this.f13870b = obj;
        this.f13875g = interfaceC3978e;
        this.f13871c = i6;
        this.f13872d = i10;
        AbstractC3602f.m7225c(c3598b, "Argument must not be null");
        this.f13876h = c3598b;
        AbstractC3602f.m7225c(cls, "Resource class must not be null");
        this.f13873e = cls;
        AbstractC3602f.m7225c(cls2, "Transcode class must not be null");
        this.f13874f = cls2;
        AbstractC3602f.m7225c(c3981h, "Argument must not be null");
        this.f13877i = c3981h;
    }

    @Override
    public final void mo3160a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof C4095q)) {
            return false;
        }
        C4095q c4095q = (C4095q) obj;
        return this.f13870b.equals(c4095q.f13870b) && this.f13875g.equals(c4095q.f13875g) && this.f13872d == c4095q.f13872d && this.f13871c == c4095q.f13871c && this.f13876h.equals(c4095q.f13876h) && this.f13873e.equals(c4095q.f13873e) && this.f13874f.equals(c4095q.f13874f) && this.f13877i.equals(c4095q.f13877i);
    }

    @Override
    public final int hashCode() {
        if (this.f13878j == 0) {
            int iHashCode = this.f13870b.hashCode();
            this.f13878j = iHashCode;
            int iHashCode2 = ((((this.f13875g.hashCode() + (iHashCode * 31)) * 31) + this.f13871c) * 31) + this.f13872d;
            this.f13878j = iHashCode2;
            int iHashCode3 = this.f13876h.hashCode() + (iHashCode2 * 31);
            this.f13878j = iHashCode3;
            int iHashCode4 = this.f13873e.hashCode() + (iHashCode3 * 31);
            this.f13878j = iHashCode4;
            int iHashCode5 = this.f13874f.hashCode() + (iHashCode4 * 31);
            this.f13878j = iHashCode5;
            this.f13878j = this.f13877i.f13515b.hashCode() + (iHashCode5 * 31);
        }
        return this.f13878j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.f13870b + ", width=" + this.f13871c + ", height=" + this.f13872d + ", resourceClass=" + this.f13873e + ", transcodeClass=" + this.f13874f + ", signature=" + this.f13875g + ", hashCode=" + this.f13878j + ", transformations=" + this.f13876h + ", options=" + this.f13877i + '}';
    }
}
