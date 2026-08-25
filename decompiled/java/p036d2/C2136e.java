package p036d2;

import androidx.lifecycle.C0542p0;
import com.bumptech.glide.AbstractC1466d;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p008a9.C0080j;
import p008a9.InterfaceC0074d;
import p009aa.C0085e;
import p009aa.InterfaceC0081a;
import p021b9.EnumC1367a;
import p030c9.AbstractC1433c;
import p130m2.C3065m;
import p156o9.AbstractC3280d;
import p213t9.AbstractC3865u;
import p213t9.C3818b;
import p213t9.C3827e;
import p213t9.C3842j;
import p213t9.C3850m0;
import p222u7.C3926b;
import p243w8.C4070l;
import p254x9.AbstractC4159a;
import p254x9.C4165g;

public final class C2136e {

    public final AbstractC2145n f7756a;

    public final C3065m f7757b;

    public final C0085e f7758c;

    public final EnumC2141j f7759d;

    public C2136e(AbstractC2145n abstractC2145n, C3065m c3065m, C0085e c0085e, EnumC2141j enumC2141j) {
        this.f7756a = abstractC2145n;
        this.f7757b = c3065m;
        this.f7758c = c0085e;
        this.f7759d = enumC2141j;
    }

    public final Object m5081a(AbstractC1433c abstractC1433c) throws Throwable {
        C2135d c2135d;
        C0085e c0085e;
        int andDecrement;
        int i6;
        C2136e c2136e;
        C3827e c3827e;
        C3827e c3827e2;
        InterfaceC0081a interfaceC0081a;
        Throwable th;
        if (abstractC1433c instanceof C2135d) {
            c2135d = (C2135d) abstractC1433c;
            int i10 = c2135d.f7755e;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c2135d.f7755e = i10 - Integer.MIN_VALUE;
            } else {
                c2135d = new C2135d(this, abstractC1433c);
            }
        } else {
            c2135d = new C2135d(this, abstractC1433c);
        }
        Object obj = c2135d.f7753c;
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        int i11 = c2135d.f7755e;
        try {
            if (i11 == 0) {
                AbstractC3280d.m6570I(obj);
                c2135d.f7751a = this;
                c0085e = this.f7758c;
                c2135d.f7752b = c0085e;
                c2135d.f7755e = 1;
                c0085e.getClass();
                do {
                    andDecrement = C0085e.f215g.getAndDecrement(c0085e);
                    i6 = c0085e.f216a;
                } while (andDecrement > i6);
                Object obj2 = C4070l.f13734a;
                if (andDecrement <= 0) {
                    InterfaceC0074d interfaceC0074dM3499r = AbstractC1466d.m3499r(c2135d);
                    if (interfaceC0074dM3499r instanceof C4165g) {
                        C4165g c4165g = (C4165g) interfaceC0074dM3499r;
                        loop2: while (true) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C4165g.f14089h;
                            Object obj3 = atomicReferenceFieldUpdater.get(c4165g);
                            C3926b c3926b = AbstractC4159a.f14080d;
                            if (obj3 == null) {
                                atomicReferenceFieldUpdater.set(c4165g, c3926b);
                                c3827e = null;
                                break;
                            }
                            if (obj3 instanceof C3827e) {
                                do {
                                    if (atomicReferenceFieldUpdater.compareAndSet(c4165g, obj3, c3926b)) {
                                        c3827e = (C3827e) obj3;
                                        break loop2;
                                    }
                                } while (atomicReferenceFieldUpdater.get(c4165g) == obj3);
                            } else if (obj3 != c3926b && !(obj3 instanceof Throwable)) {
                                throw new IllegalStateException(("Inconsistent state " + obj3).toString());
                            }
                        }
                        if (c3827e != null) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C3827e.f12906g;
                            Object obj4 = atomicReferenceFieldUpdater2.get(c3827e);
                            if (!(obj4 instanceof C3842j) || ((C3842j) obj4).f12929d == null) {
                                C3827e.f12905f.set(c3827e, 536870911);
                                atomicReferenceFieldUpdater2.set(c3827e, C3818b.f12900a);
                                c3827e2 = c3827e;
                            } else {
                                c3827e.m7655k();
                                c3827e2 = null;
                            }
                            if (c3827e2 == null) {
                                c3827e2 = new C3827e(interfaceC0074dM3499r, 2);
                            }
                        } else {
                            c3827e2 = new C3827e(interfaceC0074dM3499r, 2);
                        }
                    } else {
                        c3827e2 = new C3827e(interfaceC0074dM3499r, 1);
                    }
                    try {
                        if (!c0085e.m254a(c3827e2)) {
                            while (true) {
                                int andDecrement2 = C0085e.f215g.getAndDecrement(c0085e);
                                if (andDecrement2 <= i6) {
                                    if (andDecrement2 > 0) {
                                        c3827e2.m7664u(obj2, c3827e2.f12898c, c0085e.f217b);
                                        break;
                                    }
                                    if (c0085e.m254a(c3827e2)) {
                                        break;
                                    }
                                }
                            }
                        }
                        Object objM7657m = c3827e2.m7657m();
                        if (objM7657m != enumC1367a) {
                            objM7657m = obj2;
                        }
                        if (objM7657m == enumC1367a) {
                            obj2 = objM7657m;
                        }
                    } catch (Throwable th2) {
                        c3827e2.m7663t();
                        throw th2;
                    }
                }
                if (obj2 == enumC1367a) {
                    return enumC1367a;
                }
                c2136e = this;
            } else {
                if (i11 != 1) {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    interfaceC0081a = (InterfaceC0081a) c2135d.f7751a;
                    try {
                        AbstractC3280d.m6570I(obj);
                        C2138g c2138g = (C2138g) obj;
                        ((C0085e) interfaceC0081a).m255b();
                        return c2138g;
                    } catch (Throwable th3) {
                        th = th3;
                        ((C0085e) interfaceC0081a).m255b();
                        throw th;
                    }
                }
                C0085e c0085e2 = c2135d.f7752b;
                c2136e = (C2136e) c2135d.f7751a;
                AbstractC3280d.m6570I(obj);
                c0085e = c0085e2;
            }
            C0542p0 c0542p0 = new C0542p0(1, c2136e);
            c2135d.f7751a = c0085e;
            c2135d.f7752b = null;
            c2135d.f7755e = 2;
            Object objM7701p = AbstractC3865u.m7701p(C0080j.f206a, new C3850m0(c0542p0, null), c2135d);
            if (objM7701p == enumC1367a) {
                return enumC1367a;
            }
            interfaceC0081a = c0085e;
            obj = objM7701p;
            C2138g c2138g2 = (C2138g) obj;
            ((C0085e) interfaceC0081a).m255b();
            return c2138g2;
        } catch (Throwable th4) {
            interfaceC0081a = c0085e;
            th = th4;
            ((C0085e) interfaceC0081a).m255b();
            throw th;
        }
    }
}
