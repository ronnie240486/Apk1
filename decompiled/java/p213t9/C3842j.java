package p213t9;

import java.util.concurrent.CancellationException;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;

public final class C3842j {

    public final Object f12926a;

    public final C3852n0 f12927b;

    public final InterfaceC2724l f12928c;

    public final Object f12929d;

    public final Throwable f12930e;

    public C3842j(Object obj, C3852n0 c3852n0, InterfaceC2724l interfaceC2724l, Object obj2, Throwable th) {
        this.f12926a = obj;
        this.f12927b = c3852n0;
        this.f12928c = interfaceC2724l;
        this.f12929d = obj2;
        this.f12930e = th;
    }

    public static C3842j m7680a(C3842j c3842j, C3852n0 c3852n0, CancellationException cancellationException, int i6) {
        Object obj = c3842j.f12926a;
        if ((i6 & 2) != 0) {
            c3852n0 = c3842j.f12927b;
        }
        C3852n0 c3852n1 = c3852n0;
        InterfaceC2724l interfaceC2724l = c3842j.f12928c;
        Object obj2 = c3842j.f12929d;
        Throwable th = cancellationException;
        if ((i6 & 16) != 0) {
            th = c3842j.f12930e;
        }
        c3842j.getClass();
        return new C3842j(obj, c3852n1, interfaceC2724l, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3842j)) {
            return false;
        }
        C3842j c3842j = (C3842j) obj;
        return AbstractC2796i.m5780a(this.f12926a, c3842j.f12926a) && AbstractC2796i.m5780a(this.f12927b, c3842j.f12927b) && AbstractC2796i.m5780a(this.f12928c, c3842j.f12928c) && AbstractC2796i.m5780a(this.f12929d, c3842j.f12929d) && AbstractC2796i.m5780a(this.f12930e, c3842j.f12930e);
    }

    public final int hashCode() {
        Object obj = this.f12926a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        C3852n0 c3852n0 = this.f12927b;
        int iHashCode2 = (iHashCode + (c3852n0 == null ? 0 : c3852n0.hashCode())) * 31;
        InterfaceC2724l interfaceC2724l = this.f12928c;
        int iHashCode3 = (iHashCode2 + (interfaceC2724l == null ? 0 : interfaceC2724l.hashCode())) * 31;
        Object obj2 = this.f12929d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f12930e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f12926a + ", cancelHandler=" + this.f12927b + ", onCancellation=" + this.f12928c + ", idempotentResume=" + this.f12929d + ", cancelCause=" + this.f12930e + ')';
    }

    public C3842j(Object obj, C3852n0 c3852n0, InterfaceC2724l interfaceC2724l, CancellationException cancellationException, int i6) {
        this(obj, (i6 & 2) != 0 ? null : c3852n0, (i6 & 4) != 0 ? null : interfaceC2724l, (Object) null, (i6 & 16) != 0 ? null : cancellationException);
    }
}
