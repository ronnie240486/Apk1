package p213t9;

import androidx.fragment.app.C0423q;
import androidx.media3.common.C0565C;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p008a9.InterfaceC0074d;
import p008a9.InterfaceC0079i;
import p021b9.EnumC1367a;
import p030c9.InterfaceC1434d;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p222u7.C3926b;
import p243w8.AbstractC4066h;
import p253x8.C4145h;
import p254x9.AbstractC4159a;
import p254x9.AbstractC4177s;
import p254x9.C4165g;

public final class C3827e extends AbstractC3816a0 implements InterfaceC3824d, InterfaceC1434d {

    public static final AtomicIntegerFieldUpdater f12905f = AtomicIntegerFieldUpdater.newUpdater(C3827e.class, "_decisionAndIndex");

    public static final AtomicReferenceFieldUpdater f12906g = AtomicReferenceFieldUpdater.newUpdater(C3827e.class, Object.class, "_state");

    public static final AtomicReferenceFieldUpdater f12907h = AtomicReferenceFieldUpdater.newUpdater(C3827e.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    public final InterfaceC0074d f12908d;

    public final InterfaceC0079i f12909e;

    public C3827e(InterfaceC0074d interfaceC0074d, int i6) {
        super(i6);
        this.f12908d = interfaceC0074d;
        this.f12909e = interfaceC0074d.getContext();
        this._decisionAndIndex = 536870911;
        this._state = C3818b.f12900a;
    }

    public static void m7649s(InterfaceC3820b1 interfaceC3820b1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + interfaceC3820b1 + ", already has " + obj).toString());
    }

    public static Object m7650v(InterfaceC3820b1 interfaceC3820b1, Object obj, int i6, InterfaceC2724l interfaceC2724l) {
        if ((obj instanceof C3845k) || !AbstractC3865u.m7695j(i6)) {
            return obj;
        }
        if (interfaceC2724l != null || (interfaceC3820b1 instanceof C3852n0)) {
            return new C3842j(obj, interfaceC3820b1 instanceof C3852n0 ? (C3852n0) interfaceC3820b1 : null, interfaceC2724l, (CancellationException) null, 16);
        }
        return obj;
    }

    @Override
    public final void mo7638a(Object obj, CancellationException cancellationException) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12906g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof InterfaceC3820b1) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof C3845k) {
                return;
            }
            if (!(obj2 instanceof C3842j)) {
                C3842j c3842j = new C3842j(obj2, (C3852n0) null, (InterfaceC2724l) null, cancellationException, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, c3842j)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    }
                }
                return;
            }
            C3842j c3842j2 = (C3842j) obj2;
            if (c3842j2.f12930e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            C3842j c3842jM7680a = C3842j.m7680a(c3842j2, null, cancellationException, 15);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, c3842jM7680a)) {
                    C3852n0 c3852n0 = c3842j2.f12927b;
                    if (c3852n0 != null) {
                        m7651g(c3852n0, cancellationException);
                    }
                    InterfaceC2724l interfaceC2724l = c3842j2.f12928c;
                    if (interfaceC2724l != null) {
                        m7652h(interfaceC2724l, cancellationException);
                        return;
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj2);
        }
    }

    @Override
    public final InterfaceC0074d mo7639b() {
        return this.f12908d;
    }

    @Override
    public final Throwable mo7640c(Object obj) {
        Throwable thMo7640c = super.mo7640c(obj);
        if (thMo7640c != null) {
            return thMo7640c;
        }
        return null;
    }

    @Override
    public final Object mo7641d(Object obj) {
        return obj instanceof C3842j ? ((C3842j) obj).f12926a : obj;
    }

    @Override
    public final Object mo7643f() {
        return f12906g.get(this);
    }

    public final void m7651g(C3852n0 c3852n0, Throwable th) {
        try {
            c3852n0.m7681a(th);
        } catch (Throwable th2) {
            AbstractC3865u.m7693h(this.f12909e, new C0423q("Exception in invokeOnCancellation handler for " + this, th2, 8));
        }
    }

    @Override
    public final InterfaceC1434d getCallerFrame() {
        InterfaceC0074d interfaceC0074d = this.f12908d;
        if (interfaceC0074d instanceof InterfaceC1434d) {
            return (InterfaceC1434d) interfaceC0074d;
        }
        return null;
    }

    @Override
    public final InterfaceC0079i getContext() {
        return this.f12909e;
    }

    public final void m7652h(InterfaceC2724l interfaceC2724l, Throwable th) {
        try {
            interfaceC2724l.invoke(th);
        } catch (Throwable th2) {
            AbstractC3865u.m7693h(this.f12909e, new C0423q("Exception in resume onCancellation handler for " + this, th2, 8));
        }
    }

    public final void m7653i(AbstractC4177s abstractC4177s, Throwable th) {
        int i6 = f12905f.get(this) & 536870911;
        if (i6 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            abstractC4177s.mo257e(i6);
        } catch (Throwable th2) {
            AbstractC3865u.m7693h(this.f12909e, new C0423q("Exception in invokeOnCancellation handler for " + this, th2, 8));
        }
    }

    public final void m7654j(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12906g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof InterfaceC3820b1)) {
                return;
            }
            C3830f c3830f = new C3830f(this, th, (obj instanceof C3852n0) || (obj instanceof AbstractC4177s));
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, c3830f)) {
                    InterfaceC3820b1 interfaceC3820b1 = (InterfaceC3820b1) obj;
                    if (interfaceC3820b1 instanceof C3852n0) {
                        m7651g((C3852n0) obj, th);
                    } else if (interfaceC3820b1 instanceof AbstractC4177s) {
                        m7653i((AbstractC4177s) obj, th);
                    }
                    if (!m7662r()) {
                        m7655k();
                    }
                    m7656l(this.f12898c);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj);
        }
    }

    public final void m7655k() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12907h;
        InterfaceC3822c0 interfaceC3822c0 = (InterfaceC3822c0) atomicReferenceFieldUpdater.get(this);
        if (interfaceC3822c0 == null) {
            return;
        }
        interfaceC3822c0.mo7644a();
        atomicReferenceFieldUpdater.set(this, C3817a1.f12899a);
    }

    public final void m7656l(int i6) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        do {
            atomicIntegerFieldUpdater = f12905f;
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z7 = i6 == 4;
                InterfaceC0074d interfaceC0074d = this.f12908d;
                if (z7 || !(interfaceC0074d instanceof C4165g) || AbstractC3865u.m7695j(i6) != AbstractC3865u.m7695j(this.f12898c)) {
                    AbstractC3865u.m7698m(this, interfaceC0074d, z7);
                    return;
                }
                AbstractC3855p abstractC3855p = ((C4165g) interfaceC0074d).f14090d;
                InterfaceC0079i context = ((C4165g) interfaceC0074d).f14091e.getContext();
                if (abstractC3855p.mo7683g()) {
                    abstractC3855p.mo7665d(context, this);
                    return;
                }
                AbstractC3834g0 abstractC3834g0M7670a = AbstractC3832f1.m7670a();
                if (abstractC3834g0M7670a.f12916c >= 4294967296L) {
                    C4145h c4145h = abstractC3834g0M7670a.f12918e;
                    if (c4145h == null) {
                        c4145h = new C4145h();
                        abstractC3834g0M7670a.f12918e = c4145h;
                    }
                    c4145h.addLast(this);
                    return;
                }
                abstractC3834g0M7670a.m7673j(true);
                try {
                    AbstractC3865u.m7698m(this, interfaceC0074d, true);
                    do {
                    } while (abstractC3834g0M7670a.m7674k());
                } catch (Throwable th) {
                    try {
                        m7642e(th, null);
                    } finally {
                        abstractC3834g0M7670a.m7672h();
                    }
                }
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
    }

    public final Object m7657m() throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        boolean zM7662r = m7662r();
        do {
            atomicIntegerFieldUpdater = f12905f;
            i6 = atomicIntegerFieldUpdater.get(this);
            int i10 = i6 >> 29;
            if (i10 != 0) {
                if (i10 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zM7662r) {
                    m7663t();
                }
                Object obj = f12906g.get(this);
                if (obj instanceof C3845k) {
                    throw ((C3845k) obj).f12934a;
                }
                if (AbstractC3865u.m7695j(this.f12898c)) {
                    InterfaceC3858q0 interfaceC3858q0 = (InterfaceC3858q0) this.f12909e.mo252e(C3857q.f12952b);
                    if (interfaceC3858q0 != null && !interfaceC3858q0.isActive()) {
                        CancellationException cancellationExceptionM7726q = ((C3874y0) interfaceC3858q0).m7726q();
                        mo7638a(obj, cancellationExceptionM7726q);
                        throw cancellationExceptionM7726q;
                    }
                }
                return mo7641d(obj);
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, C0565C.BUFFER_FLAG_LAST_SAMPLE + (536870911 & i6)));
        if (((InterfaceC3822c0) f12907h.get(this)) == null) {
            m7659o();
        }
        if (zM7662r) {
            m7663t();
        }
        return EnumC1367a.f4179a;
    }

    public final void m7658n() {
        InterfaceC3822c0 interfaceC3822c0M7659o = m7659o();
        if (interfaceC3822c0M7659o == null || (f12906g.get(this) instanceof InterfaceC3820b1)) {
            return;
        }
        interfaceC3822c0M7659o.mo7644a();
        f12907h.set(this, C3817a1.f12899a);
    }

    public final InterfaceC3822c0 m7659o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        InterfaceC3858q0 interfaceC3858q0 = (InterfaceC3858q0) this.f12909e.mo252e(C3857q.f12952b);
        if (interfaceC3858q0 == null) {
            return null;
        }
        InterfaceC3822c0 interfaceC3822c0M7694i = AbstractC3865u.m7694i(interfaceC3858q0, true, new C3833g(this), 2);
        do {
            atomicReferenceFieldUpdater = f12907h;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, interfaceC3822c0M7694i)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return interfaceC3822c0M7694i;
    }

    public final void m7660p(InterfaceC2724l interfaceC2724l) {
        m7661q(interfaceC2724l instanceof C3852n0 ? (C3852n0) interfaceC2724l : new C3852n0(interfaceC2724l));
    }

    public final void m7661q(InterfaceC3820b1 interfaceC3820b1) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12906g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof C3818b) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, interfaceC3820b1)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            }
            if (obj instanceof C3852n0 ? true : obj instanceof AbstractC4177s) {
                m7649s(interfaceC3820b1, obj);
                throw null;
            }
            if (obj instanceof C3845k) {
                C3845k c3845k = (C3845k) obj;
                c3845k.getClass();
                if (!C3845k.f12933b.compareAndSet(c3845k, 0, 1)) {
                    m7649s(interfaceC3820b1, obj);
                    throw null;
                }
                if (obj instanceof C3830f) {
                    if (!(obj instanceof C3845k)) {
                        c3845k = null;
                    }
                    Throwable th = c3845k != null ? c3845k.f12934a : null;
                    if (interfaceC3820b1 instanceof C3852n0) {
                        m7651g((C3852n0) interfaceC3820b1, th);
                        return;
                    } else {
                        AbstractC2796i.m5783d(interfaceC3820b1, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        m7653i((AbstractC4177s) interfaceC3820b1, th);
                        return;
                    }
                }
                return;
            }
            if (!(obj instanceof C3842j)) {
                if (interfaceC3820b1 instanceof AbstractC4177s) {
                    return;
                }
                AbstractC2796i.m5783d(interfaceC3820b1, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                C3842j c3842j = new C3842j(obj, (C3852n0) interfaceC3820b1, (InterfaceC2724l) null, (CancellationException) null, 28);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c3842j)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            }
            C3842j c3842j2 = (C3842j) obj;
            if (c3842j2.f12927b != null) {
                m7649s(interfaceC3820b1, obj);
                throw null;
            }
            if (interfaceC3820b1 instanceof AbstractC4177s) {
                return;
            }
            AbstractC2796i.m5783d(interfaceC3820b1, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
            C3852n0 c3852n0 = (C3852n0) interfaceC3820b1;
            Throwable th2 = c3842j2.f12930e;
            if (th2 != null) {
                m7651g(c3852n0, th2);
                return;
            }
            C3842j c3842jM7680a = C3842j.m7680a(c3842j2, c3852n0, null, 29);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c3842jM7680a)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                }
            }
            return;
        }
    }

    public final boolean m7662r() {
        if (this.f12898c == 2) {
            InterfaceC0074d interfaceC0074d = this.f12908d;
            AbstractC2796i.m5783d(interfaceC0074d, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (C4165g.f14089h.get((C4165g) interfaceC0074d) != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final void resumeWith(Object obj) {
        Throwable thM8065a = AbstractC4066h.m8065a(obj);
        if (thM8065a != null) {
            obj = new C3845k(thM8065a, false);
        }
        m7664u(obj, this.f12898c, null);
    }

    public final void m7663t() {
        InterfaceC0074d interfaceC0074d = this.f12908d;
        Throwable th = null;
        C4165g c4165g = interfaceC0074d instanceof C4165g ? (C4165g) interfaceC0074d : null;
        if (c4165g != null) {
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C4165g.f14089h;
                Object obj = atomicReferenceFieldUpdater.get(c4165g);
                C3926b c3926b = AbstractC4159a.f14080d;
                if (obj != c3926b) {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(c4165g, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(c4165g) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                    break;
                }
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(c4165g, c3926b, this)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(c4165g) == c3926b);
            }
            if (th == null) {
                return;
            }
            m7655k();
            m7654j(th);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("CancellableContinuation(");
        sb.append(AbstractC3865u.m7699n(this.f12908d));
        sb.append("){");
        Object obj = f12906g.get(this);
        if (obj instanceof InterfaceC3820b1) {
            str = "Active";
        } else {
            str = obj instanceof C3830f ? "Cancelled" : "Completed";
        }
        sb.append(str);
        sb.append("}@");
        sb.append(AbstractC3865u.m7691f(this));
        return sb.toString();
    }

    public final void m7664u(Object obj, int i6, InterfaceC2724l interfaceC2724l) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12906g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof InterfaceC3820b1)) {
                if (obj2 instanceof C3830f) {
                    C3830f c3830f = (C3830f) obj2;
                    c3830f.getClass();
                    if (C3830f.f12910c.compareAndSet(c3830f, 0, 1)) {
                        if (interfaceC2724l != null) {
                            m7652h(interfaceC2724l, c3830f.f12934a);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
            Object objM7650v = m7650v((InterfaceC3820b1) obj2, obj, i6, interfaceC2724l);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, objM7650v)) {
                    if (!m7662r()) {
                        m7655k();
                    }
                    m7656l(i6);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj2);
        }
    }
}
