package p009aa;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p000a.AbstractC0004e;
import p213t9.AbstractC3865u;
import p213t9.C3827e;
import p213t9.C3842j;
import p213t9.InterfaceC3820b1;
import p213t9.InterfaceC3824d;
import p222u7.C3926b;
import p243w8.C4070l;
import p254x9.AbstractC4159a;
import p254x9.AbstractC4161c;
import p254x9.AbstractC4177s;

public final class C0085e implements InterfaceC0081a {

    public static final AtomicReferenceFieldUpdater f211c = AtomicReferenceFieldUpdater.newUpdater(C0085e.class, Object.class, "head");

    public static final AtomicLongFieldUpdater f212d = AtomicLongFieldUpdater.newUpdater(C0085e.class, "deqIdx");

    public static final AtomicReferenceFieldUpdater f213e = AtomicReferenceFieldUpdater.newUpdater(C0085e.class, Object.class, "tail");

    public static final AtomicLongFieldUpdater f214f = AtomicLongFieldUpdater.newUpdater(C0085e.class, "enqIdx");

    public static final AtomicIntegerFieldUpdater f215g = AtomicIntegerFieldUpdater.newUpdater(C0085e.class, "_availablePermits");
    private volatile int _availablePermits;

    public final int f216a;

    public final C0083c f217b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    public C0085e(int i6, int i10) {
        this.f216a = i6;
        if (i6 <= 0) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Semaphore should have at least 1 permit, but had ").toString());
        }
        if (i10 < 0 || i10 > i6) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "The number of acquired permits should be in 0..").toString());
        }
        C0087g c0087g = new C0087g(0L, null, 2);
        this.head = c0087g;
        this.tail = c0087g;
        this._availablePermits = i6 - i10;
        this.f217b = new C0083c(0, this);
    }

    public final boolean m254a(C3827e c3827e) {
        Object objM8201b;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f213e;
        C0087g c0087g = (C0087g) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f214f.getAndIncrement(this);
        C0082b c0082b = C0082b.f207i;
        long j10 = andIncrement / ((long) AbstractC0086f.f223f);
        loop0: while (true) {
            objM8201b = AbstractC4159a.m8201b(c0087g, j10, c0082b);
            if (objM8201b != AbstractC4159a.f14078b) {
                AbstractC4177s abstractC4177sM8202c = AbstractC4159a.m8202c(objM8201b);
                while (true) {
                    AbstractC4177s abstractC4177s = (AbstractC4177s) atomicReferenceFieldUpdater.get(this);
                    if (abstractC4177s.f14116c >= abstractC4177sM8202c.f14116c) {
                        break loop0;
                    }
                    if (!abstractC4177sM8202c.m8231f()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, abstractC4177s, abstractC4177sM8202c)) {
                            if (!abstractC4177s.m8230c()) {
                                break loop0;
                            }
                            abstractC4177s.m8212b();
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == abstractC4177s);
                    if (abstractC4177sM8202c.m8230c()) {
                        abstractC4177sM8202c.m8212b();
                    }
                }
            } else {
                break;
            }
        }
        C0087g c0087g2 = (C0087g) AbstractC4159a.m8202c(objM8201b);
        int i10 = (int) (andIncrement % ((long) AbstractC0086f.f223f));
        AtomicReferenceArray atomicReferenceArray = c0087g2.f224e;
        while (!atomicReferenceArray.compareAndSet(i10, null, c3827e)) {
            if (atomicReferenceArray.get(i10) != null) {
                C3926b c3926b = AbstractC0086f.f219b;
                C3926b c3926b2 = AbstractC0086f.f220c;
                while (!atomicReferenceArray.compareAndSet(i10, c3926b, c3926b2)) {
                    if (atomicReferenceArray.get(i10) != c3926b) {
                        return false;
                    }
                }
                c3827e.m7664u(C4070l.f13734a, c3827e.f12898c, this.f217b);
                return true;
            }
        }
        do {
            atomicIntegerFieldUpdater = C3827e.f12905f;
            i6 = atomicIntegerFieldUpdater.get(c3827e);
            if ((i6 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(c3827e, i6, ((i6 >> 29) << 29) + i10));
        c3827e.m7661q(c0087g2);
        return true;
    }

    public final void m255b() {
        int i6;
        Object objM8201b;
        boolean z7;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f215g;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i10 = this.f216a;
            if (andIncrement >= i10) {
                do {
                    i6 = atomicIntegerFieldUpdater.get(this);
                    if (i6 <= i10) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, i10));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i10).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f211c;
            C0087g c0087g = (C0087g) atomicReferenceFieldUpdater.get(this);
            long andIncrement2 = f212d.getAndIncrement(this);
            long j10 = andIncrement2 / ((long) AbstractC0086f.f223f);
            C0084d c0084d = C0084d.f210i;
            while (true) {
                objM8201b = AbstractC4159a.m8201b(c0087g, j10, c0084d);
                if (objM8201b != AbstractC4159a.f14078b) {
                    AbstractC4177s abstractC4177sM8202c = AbstractC4159a.m8202c(objM8201b);
                    while (true) {
                        AbstractC4177s abstractC4177s = (AbstractC4177s) atomicReferenceFieldUpdater.get(this);
                        if (abstractC4177s.f14116c >= abstractC4177sM8202c.f14116c) {
                            break;
                        }
                        if (!abstractC4177sM8202c.m8231f()) {
                            break;
                        }
                        do {
                            if (atomicReferenceFieldUpdater.compareAndSet(this, abstractC4177s, abstractC4177sM8202c)) {
                                if (!abstractC4177s.m8230c()) {
                                    break;
                                }
                                abstractC4177s.m8212b();
                                break;
                            }
                        } while (atomicReferenceFieldUpdater.get(this) == abstractC4177s);
                        if (abstractC4177sM8202c.m8230c()) {
                            abstractC4177sM8202c.m8212b();
                        }
                    }
                } else {
                    break;
                }
            }
            C0087g c0087g2 = (C0087g) AbstractC4159a.m8202c(objM8201b);
            C3926b c3926b = null;
            AbstractC4161c.f14085b.lazySet(c0087g2, null);
            z7 = false;
            if (c0087g2.f14116c <= j10) {
                int i11 = (int) (andIncrement2 % ((long) AbstractC0086f.f223f));
                C3926b c3926b2 = AbstractC0086f.f219b;
                AtomicReferenceArray atomicReferenceArray = c0087g2.f224e;
                Object andSet = atomicReferenceArray.getAndSet(i11, c3926b2);
                if (andSet == null) {
                    int i12 = AbstractC0086f.f218a;
                    int i13 = 0;
                    while (true) {
                        if (i13 >= i12) {
                            C3926b c3926b3 = AbstractC0086f.f219b;
                            C3926b c3926b4 = AbstractC0086f.f221d;
                            do {
                                if (atomicReferenceArray.compareAndSet(i11, c3926b3, c3926b4)) {
                                    z7 = true;
                                    break;
                                }
                            } while (atomicReferenceArray.get(i11) == c3926b3);
                            z7 = !z7;
                            break;
                        }
                        if (atomicReferenceArray.get(i11) == AbstractC0086f.f220c) {
                            z7 = true;
                            break;
                        }
                        i13++;
                    }
                } else if (andSet != AbstractC0086f.f222e) {
                    if (!(andSet instanceof InterfaceC3824d)) {
                        throw new IllegalStateException(("unexpected: " + andSet).toString());
                    }
                    C4070l c4070l = C4070l.f13734a;
                    C3827e c3827e = (C3827e) ((InterfaceC3824d) andSet);
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C3827e.f12906g;
                        Object obj = atomicReferenceFieldUpdater2.get(c3827e);
                        boolean z10 = obj instanceof InterfaceC3820b1;
                        C3926b c3926b5 = AbstractC3865u.f12955a;
                        if (!z10) {
                            boolean z11 = obj instanceof C3842j;
                            break;
                        }
                        Object objM7650v = C3827e.m7650v((InterfaceC3820b1) obj, c4070l, c3827e.f12898c, this.f217b);
                        do {
                            if (atomicReferenceFieldUpdater2.compareAndSet(c3827e, obj, objM7650v)) {
                                if (!c3827e.m7662r()) {
                                    c3827e.m7655k();
                                }
                                c3926b = c3926b5;
                                break;
                            }
                        } while (atomicReferenceFieldUpdater2.get(c3827e) == obj);
                    }
                    if (c3926b != null) {
                        c3827e.m7656l(c3827e.f12898c);
                        z7 = true;
                        break;
                        break;
                    }
                }
            }
        } while (!z7);
    }
}
