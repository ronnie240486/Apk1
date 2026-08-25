package p213t9;

import androidx.fragment.app.C0423q;
import com.bumptech.glide.AbstractC1466d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p008a9.InterfaceC0077g;
import p008a9.InterfaceC0078h;
import p008a9.InterfaceC0079i;
import p091i9.InterfaceC2724l;
import p091i9.InterfaceC2728p;
import p103j9.AbstractC2796i;
import p123l5.AbstractC2973a;
import p222u7.C3926b;
import p254x9.AbstractC4173o;
import p254x9.C4168j;

public class C3874y0 implements InterfaceC3858q0, InterfaceC3823c1 {

    public static final AtomicReferenceFieldUpdater f12981a = AtomicReferenceFieldUpdater.newUpdater(C3874y0.class, Object.class, "_state");

    public static final AtomicReferenceFieldUpdater f12982b = AtomicReferenceFieldUpdater.newUpdater(C3874y0.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    public C3874y0(boolean z7) {
        this._state = z7 ? AbstractC3865u.f12963i : AbstractC3865u.f12962h;
    }

    public static C3839i m7712B(C4168j c4168j) {
        while (c4168j.mo7732h()) {
            C4168j c4168jM8215d = c4168j.m8215d();
            if (c4168jM8215d == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C4168j.f14101b;
                Object obj = atomicReferenceFieldUpdater.get(c4168j);
                while (true) {
                    c4168j = (C4168j) obj;
                    if (!c4168j.mo7732h()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(c4168j);
                }
            } else {
                c4168j = c4168jM8215d;
            }
        }
        while (true) {
            c4168j = c4168j.m8218g();
            if (!c4168j.mo7732h()) {
                if (c4168j instanceof C3839i) {
                    return (C3839i) c4168j;
                }
                if (c4168j instanceof C3876z0) {
                    return null;
                }
            }
        }
    }

    public static String m7713G(Object obj) {
        if (!(obj instanceof C3870w0)) {
            if (obj instanceof InterfaceC3846k0) {
                return ((InterfaceC3846k0) obj).isActive() ? "Active" : "New";
            }
            return obj instanceof C3845k ? "Cancelled" : "Completed";
        }
        C3870w0 c3870w0 = (C3870w0) obj;
        if (c3870w0.m7706d()) {
            return "Cancelling";
        }
        return c3870w0.m7707e() ? "Completing" : "Active";
    }

    public final Object m7714A(Object obj) {
        Object objM7718H;
        do {
            objM7718H = m7718H(m7728u(), obj);
            if (objM7718H == AbstractC3865u.f12957c) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                C3845k c3845k = obj instanceof C3845k ? (C3845k) obj : null;
                throw new IllegalStateException(str, c3845k != null ? c3845k.f12934a : null);
            }
        } while (objM7718H == AbstractC3865u.f12959e);
        return objM7718H;
    }

    public final void m7715C(C3876z0 c3876z0, Throwable th) {
        Object objM8217f = c3876z0.m8217f();
        AbstractC2796i.m5783d(objM8217f, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        C0423q c0423q = null;
        for (C4168j c4168jM8218g = (C4168j) objM8217f; !c4168jM8218g.equals(c3876z0); c4168jM8218g = c4168jM8218g.m8218g()) {
            if (c4168jM8218g instanceof AbstractC3862s0) {
                AbstractC3866u0 abstractC3866u0 = (AbstractC3866u0) c4168jM8218g;
                try {
                    abstractC3866u0.mo7671j(th);
                } catch (Throwable th2) {
                    if (c0423q != null) {
                        AbstractC2973a.m6013a(c0423q, th2);
                    } else {
                        c0423q = new C0423q("Exception in completion handler " + abstractC3866u0 + " for " + this, th2, 8);
                    }
                }
            }
        }
        if (c0423q != null) {
            mo7637w(c0423q);
        }
        m7722k(th);
    }

    public final void m7717F(AbstractC3866u0 abstractC3866u0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        C3876z0 c3876z0 = new C3876z0();
        abstractC3866u0.getClass();
        C4168j.f14101b.lazySet(c3876z0, abstractC3866u0);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C4168j.f14100a;
        atomicReferenceFieldUpdater2.lazySet(c3876z0, abstractC3866u0);
        loop0: while (abstractC3866u0.m8217f() == abstractC3866u0) {
            do {
                if (atomicReferenceFieldUpdater2.compareAndSet(abstractC3866u0, abstractC3866u0, c3876z0)) {
                    c3876z0.m8216e(abstractC3866u0);
                    break loop0;
                }
            } while (atomicReferenceFieldUpdater2.get(abstractC3866u0) == abstractC3866u0);
        }
        C4168j c4168jM8218g = abstractC3866u0.m8218g();
        do {
            atomicReferenceFieldUpdater = f12981a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, abstractC3866u0, c4168jM8218g)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == abstractC3866u0);
    }

    public final Object m7718H(Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        if (!(obj instanceof InterfaceC3846k0)) {
            return AbstractC3865u.f12957c;
        }
        if (((obj instanceof C3825d0) || (obj instanceof AbstractC3866u0)) && !(obj instanceof C3839i) && !(obj2 instanceof C3845k)) {
            InterfaceC3846k0 interfaceC3846k0 = (InterfaceC3846k0) obj;
            Object c3848l0 = obj2 instanceof InterfaceC3846k0 ? new C3848l0((InterfaceC3846k0) obj2) : obj2;
            do {
                atomicReferenceFieldUpdater = f12981a;
                if (atomicReferenceFieldUpdater.compareAndSet(this, interfaceC3846k0, c3848l0)) {
                    mo7634D(obj2);
                    m7723n(interfaceC3846k0, obj2);
                    return obj2;
                }
            } while (atomicReferenceFieldUpdater.get(this) == interfaceC3846k0);
            return AbstractC3865u.f12959e;
        }
        InterfaceC3846k0 interfaceC3846k1 = (InterfaceC3846k0) obj;
        C3876z0 c3876z0M7727t = m7727t(interfaceC3846k1);
        if (c3876z0M7727t == null) {
            return AbstractC3865u.f12959e;
        }
        C3839i c3839iM7712B = null;
        C3870w0 c3870w0 = interfaceC3846k1 instanceof C3870w0 ? (C3870w0) interfaceC3846k1 : null;
        if (c3870w0 == null) {
            c3870w0 = new C3870w0(c3876z0M7727t, null);
        }
        synchronized (c3870w0) {
            if (c3870w0.m7707e()) {
                return AbstractC3865u.f12957c;
            }
            C3870w0.f12972b.set(c3870w0, 1);
            if (c3870w0 != interfaceC3846k1) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f12981a;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, interfaceC3846k1, c3870w0)) {
                    if (atomicReferenceFieldUpdater2.get(this) != interfaceC3846k1) {
                        return AbstractC3865u.f12959e;
                    }
                }
            }
            boolean zM7706d = c3870w0.m7706d();
            C3845k c3845k = obj2 instanceof C3845k ? (C3845k) obj2 : null;
            if (c3845k != null) {
                c3870w0.m7704a(c3845k.f12934a);
            }
            Throwable thM7705b = c3870w0.m7705b();
            if (zM7706d) {
                thM7705b = null;
            }
            if (thM7705b != null) {
                m7715C(c3876z0M7727t, thM7705b);
            }
            C3839i c3839i = interfaceC3846k1 instanceof C3839i ? (C3839i) interfaceC3846k1 : null;
            if (c3839i == null) {
                C3876z0 c3876z0Mo7647c = interfaceC3846k1.mo7647c();
                if (c3876z0Mo7647c != null) {
                    c3839iM7712B = m7712B(c3876z0Mo7647c);
                }
            } else {
                c3839iM7712B = c3839i;
            }
            if (c3839iM7712B != null) {
                while (AbstractC3865u.m7694i(c3839iM7712B.f12923e, false, new C3868v0(this, c3870w0, c3839iM7712B, obj2), 1) == C3817a1.f12899a) {
                    c3839iM7712B = m7712B(c3839iM7712B);
                    if (c3839iM7712B == null) {
                    }
                }
                return AbstractC3865u.f12958d;
            }
            return m7725p(c3870w0, obj2);
        }
    }

    @Override
    public final Object mo250a(Object obj, InterfaceC2728p interfaceC2728p) {
        return interfaceC2728p.invoke(obj, this);
    }

    @Override
    public final InterfaceC0079i mo251c(InterfaceC0078h interfaceC0078h) {
        return AbstractC1466d.m3504x(this, interfaceC0078h);
    }

    @Override
    public final InterfaceC0077g mo252e(InterfaceC0078h interfaceC0078h) {
        return AbstractC1466d.m3491i(this, interfaceC0078h);
    }

    @Override
    public final InterfaceC0079i mo253f(InterfaceC0079i interfaceC0079i) {
        return AbstractC1466d.m3482A(this, interfaceC0079i);
    }

    public final boolean m7719g(InterfaceC3846k0 interfaceC3846k0, C3876z0 c3876z0, AbstractC3866u0 abstractC3866u0) {
        char c5;
        C3872x0 c3872x0 = new C3872x0(abstractC3866u0, this, interfaceC3846k0);
        do {
            C4168j c4168jM8215d = c3876z0.m8215d();
            if (c4168jM8215d == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C4168j.f14101b;
                Object obj = atomicReferenceFieldUpdater.get(c3876z0);
                while (true) {
                    c4168jM8215d = (C4168j) obj;
                    if (!c4168jM8215d.mo7732h()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(c4168jM8215d);
                }
            }
            C4168j.f14101b.lazySet(abstractC3866u0, c4168jM8215d);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C4168j.f14100a;
            atomicReferenceFieldUpdater2.lazySet(abstractC3866u0, c3876z0);
            c3872x0.f12978c = c3876z0;
            while (true) {
                if (atomicReferenceFieldUpdater2.compareAndSet(c4168jM8215d, c3876z0, c3872x0)) {
                    if (c3872x0.mo8210a(c4168jM8215d) != null) {
                        c5 = 2;
                        break;
                    }
                    c5 = 1;
                    break;
                }
                if (atomicReferenceFieldUpdater2.get(c4168jM8215d) != c3876z0) {
                    c5 = 0;
                    break;
                }
            }
            if (c5 == 1) {
                return true;
            }
        } while (c5 != 2);
        return false;
    }

    @Override
    public final InterfaceC0078h getKey() {
        return C3857q.f12952b;
    }

    public void mo7679i(Object obj) {
        mo7720h(obj);
    }

    @Override
    public boolean isActive() {
        Object objM7728u = m7728u();
        return (objM7728u instanceof InterfaceC3846k0) && ((InterfaceC3846k0) objM7728u).isActive();
    }

    public final boolean m7721j(Object obj) {
        C3926b c3926b;
        Object objM7718H = AbstractC3865u.f12957c;
        if (mo7685s()) {
            do {
                Object objM7728u = m7728u();
                if (!(objM7728u instanceof InterfaceC3846k0) || ((objM7728u instanceof C3870w0) && ((C3870w0) objM7728u).m7707e())) {
                    objM7718H = AbstractC3865u.f12957c;
                    break;
                }
                objM7718H = m7718H(objM7728u, new C3845k(m7724o(obj), false));
            } while (objM7718H == AbstractC3865u.f12959e);
            if (objM7718H == AbstractC3865u.f12958d) {
                return true;
            }
        }
        if (objM7718H == AbstractC3865u.f12957c) {
            Throwable thM7724o = null;
            loop1: while (true) {
                Object objM7728u2 = m7728u();
                if (objM7728u2 instanceof C3870w0) {
                    synchronized (objM7728u2) {
                        try {
                            C3870w0 c3870w0 = (C3870w0) objM7728u2;
                            c3870w0.getClass();
                            if (C3870w0.f12974d.get(c3870w0) == AbstractC3865u.f12961g) {
                                c3926b = AbstractC3865u.f12960f;
                            } else {
                                boolean zM7706d = ((C3870w0) objM7728u2).m7706d();
                                if (thM7724o == null) {
                                    thM7724o = m7724o(obj);
                                }
                                ((C3870w0) objM7728u2).m7704a(thM7724o);
                                Throwable thM7705b = zM7706d ? null : ((C3870w0) objM7728u2).m7705b();
                                if (thM7705b != null) {
                                    m7715C(((C3870w0) objM7728u2).f12975a, thM7705b);
                                }
                                c3926b = AbstractC3865u.f12957c;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } else if (objM7728u2 instanceof InterfaceC3846k0) {
                    if (thM7724o == null) {
                        thM7724o = m7724o(obj);
                    }
                    InterfaceC3846k0 interfaceC3846k0 = (InterfaceC3846k0) objM7728u2;
                    if (interfaceC3846k0.isActive()) {
                        C3876z0 c3876z0M7727t = m7727t(interfaceC3846k0);
                        if (c3876z0M7727t == null) {
                            continue;
                        } else {
                            C3870w0 c3870w1 = new C3870w0(c3876z0M7727t, thM7724o);
                            while (true) {
                                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12981a;
                                if (atomicReferenceFieldUpdater.compareAndSet(this, interfaceC3846k0, c3870w1)) {
                                    m7715C(c3876z0M7727t, thM7724o);
                                    c3926b = AbstractC3865u.f12957c;
                                } else if (atomicReferenceFieldUpdater.get(this) != interfaceC3846k0) {
                                }
                            }
                        }
                    } else {
                        Object objM7718H2 = m7718H(objM7728u2, new C3845k(thM7724o, false));
                        if (objM7718H2 == AbstractC3865u.f12957c) {
                            throw new IllegalStateException(("Cannot happen in " + objM7728u2).toString());
                        }
                        if (objM7718H2 != AbstractC3865u.f12959e) {
                            objM7718H = objM7718H2;
                            break;
                        }
                    }
                } else {
                    c3926b = AbstractC3865u.f12960f;
                }
                objM7718H = c3926b;
                break;
            }
        }
        if (objM7718H != AbstractC3865u.f12957c && objM7718H != AbstractC3865u.f12958d) {
            if (objM7718H == AbstractC3865u.f12960f) {
                return false;
            }
            mo7720h(objM7718H);
        }
        return true;
    }

    public final boolean m7722k(Throwable th) {
        if (mo7731z()) {
            return true;
        }
        boolean z7 = th instanceof CancellationException;
        InterfaceC3836h interfaceC3836h = (InterfaceC3836h) f12982b.get(this);
        if (interfaceC3836h == null || interfaceC3836h == C3817a1.f12899a) {
            return z7;
        }
        return interfaceC3836h.mo7645b(th) || z7;
    }

    public String mo7636l() {
        return "Job was cancelled";
    }

    public boolean mo7648m(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return m7721j(th) && mo7684r();
    }

    public final void m7723n(InterfaceC3846k0 interfaceC3846k0, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12982b;
        InterfaceC3836h interfaceC3836h = (InterfaceC3836h) atomicReferenceFieldUpdater.get(this);
        if (interfaceC3836h != null) {
            interfaceC3836h.mo7644a();
            atomicReferenceFieldUpdater.set(this, C3817a1.f12899a);
        }
        C0423q c0423q = null;
        C3845k c3845k = obj instanceof C3845k ? (C3845k) obj : null;
        Throwable th = c3845k != null ? c3845k.f12934a : null;
        if (interfaceC3846k0 instanceof AbstractC3866u0) {
            try {
                ((AbstractC3866u0) interfaceC3846k0).mo7671j(th);
                return;
            } catch (Throwable th2) {
                mo7637w(new C0423q("Exception in completion handler " + interfaceC3846k0 + " for " + this, th2, 8));
                return;
            }
        }
        C3876z0 c3876z0Mo7647c = interfaceC3846k0.mo7647c();
        if (c3876z0Mo7647c != null) {
            Object objM8217f = c3876z0Mo7647c.m8217f();
            AbstractC2796i.m5783d(objM8217f, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            for (C4168j c4168jM8218g = (C4168j) objM8217f; !c4168jM8218g.equals(c3876z0Mo7647c); c4168jM8218g = c4168jM8218g.m8218g()) {
                if (c4168jM8218g instanceof AbstractC3866u0) {
                    AbstractC3866u0 abstractC3866u0 = (AbstractC3866u0) c4168jM8218g;
                    try {
                        abstractC3866u0.mo7671j(th);
                    } catch (Throwable th3) {
                        if (c0423q != null) {
                            AbstractC2973a.m6013a(c0423q, th3);
                        } else {
                            c0423q = new C0423q("Exception in completion handler " + abstractC3866u0 + " for " + this, th3, 8);
                        }
                    }
                }
            }
            if (c0423q != null) {
                mo7637w(c0423q);
            }
        }
    }

    public final Throwable m7724o(Object obj) {
        Throwable thM7705b;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        C3874y0 c3874y0 = (C3874y0) ((InterfaceC3823c1) obj);
        Object objM7728u = c3874y0.m7728u();
        if (objM7728u instanceof C3870w0) {
            thM7705b = ((C3870w0) objM7728u).m7705b();
        } else if (objM7728u instanceof C3845k) {
            thM7705b = ((C3845k) objM7728u).f12934a;
        } else {
            if (objM7728u instanceof InterfaceC3846k0) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objM7728u).toString());
            }
            thM7705b = null;
        }
        CancellationException c3860r0 = thM7705b instanceof CancellationException ? (CancellationException) thM7705b : null;
        if (c3860r0 == null) {
            c3860r0 = new C3860r0("Parent job is ".concat(m7713G(objM7728u)), thM7705b, c3874y0);
        }
        return c3860r0;
    }

    public final Object m7725p(C3870w0 c3870w0, Object obj) {
        Object obj2 = null;
        Throwable c3860r0 = null;
        C3845k c3845k = obj instanceof C3845k ? (C3845k) obj : null;
        Throwable th = c3845k != null ? c3845k.f12934a : null;
        synchronized (c3870w0) {
            c3870w0.m7706d();
            ArrayList<Throwable> arrayListM7708f = c3870w0.m7708f(th);
            if (!arrayListM7708f.isEmpty()) {
                for (Object obj3 : arrayListM7708f) {
                    if (!(((Throwable) obj3) instanceof CancellationException)) {
                        obj2 = obj3;
                        break;
                    }
                }
                c3860r0 = (Throwable) obj2;
                if (c3860r0 == null) {
                    c3860r0 = (Throwable) arrayListM7708f.get(0);
                }
            } else if (c3870w0.m7706d()) {
                c3860r0 = new C3860r0(mo7636l(), null, this);
            }
            if (c3860r0 != null && arrayListM7708f.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListM7708f.size()));
                for (Throwable th2 : arrayListM7708f) {
                    if (th2 != c3860r0 && th2 != c3860r0 && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        AbstractC2973a.m6013a(c3860r0, th2);
                    }
                }
            }
        }
        if (c3860r0 != null && c3860r0 != th) {
            obj = new C3845k(c3860r0, false);
        }
        if (c3860r0 != null && (m7722k(c3860r0) || mo7709v(c3860r0))) {
            AbstractC2796i.m5783d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            C3845k.f12933b.compareAndSet((C3845k) obj, 0, 1);
        }
        mo7634D(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12981a;
        Object c3848l0 = obj instanceof InterfaceC3846k0 ? new C3848l0((InterfaceC3846k0) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, c3870w0, c3848l0) && atomicReferenceFieldUpdater.get(this) == c3870w0) {
        }
        m7723n(c3870w0, obj);
        return obj;
    }

    public final CancellationException m7726q() {
        CancellationException cancellationException;
        Object objM7728u = m7728u();
        if (!(objM7728u instanceof C3870w0)) {
            if (objM7728u instanceof InterfaceC3846k0) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(objM7728u instanceof C3845k)) {
                return new C3860r0(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((C3845k) objM7728u).f12934a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new C3860r0(mo7636l(), th, this) : cancellationException;
        }
        Throwable thM7705b = ((C3870w0) objM7728u).m7705b();
        if (thM7705b == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = thM7705b instanceof CancellationException ? (CancellationException) thM7705b : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = mo7636l();
        }
        return new C3860r0(strConcat, thM7705b, this);
    }

    public boolean mo7684r() {
        return true;
    }

    public boolean mo7685s() {
        return false;
    }

    public final C3876z0 m7727t(InterfaceC3846k0 interfaceC3846k0) {
        C3876z0 c3876z0Mo7647c = interfaceC3846k0.mo7647c();
        if (c3876z0Mo7647c != null) {
            return c3876z0Mo7647c;
        }
        if (interfaceC3846k0 instanceof C3825d0) {
            return new C3876z0();
        }
        if (interfaceC3846k0 instanceof AbstractC3866u0) {
            m7717F((AbstractC3866u0) interfaceC3846k0);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + interfaceC3846k0).toString());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + m7713G(m7728u()) + '}');
        sb.append('@');
        sb.append(AbstractC3865u.m7691f(this));
        return sb.toString();
    }

    public final Object m7728u() {
        while (true) {
            Object obj = f12981a.get(this);
            if (!(obj instanceof AbstractC4173o)) {
                return obj;
            }
            ((AbstractC4173o) obj).mo8210a(this);
        }
    }

    public boolean mo7709v(Throwable th) {
        return false;
    }

    public final void m7729x(InterfaceC3858q0 interfaceC3858q0) {
        byte b8;
        C3817a1 c3817a1 = C3817a1.f12899a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12982b;
        if (interfaceC3858q0 == null) {
            atomicReferenceFieldUpdater.set(this, c3817a1);
            return;
        }
        C3874y0 c3874y0 = (C3874y0) interfaceC3858q0;
        do {
            Object objM7728u = c3874y0.m7728u();
            boolean z7 = objM7728u instanceof C3825d0;
            b8 = 0;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f12981a;
            if (z7) {
                if (!((C3825d0) objM7728u).f12904a) {
                    C3825d0 c3825d0 = AbstractC3865u.f12963i;
                    while (true) {
                        if (atomicReferenceFieldUpdater2.compareAndSet(c3874y0, objM7728u, c3825d0)) {
                            c3874y0.getClass();
                            b8 = 1;
                        } else if (atomicReferenceFieldUpdater2.get(c3874y0) != objM7728u) {
                            b8 = -1;
                        }
                    }
                }
            } else if (objM7728u instanceof C3843j0) {
                C3876z0 c3876z0 = ((C3843j0) objM7728u).f12931a;
                while (true) {
                    if (atomicReferenceFieldUpdater2.compareAndSet(c3874y0, objM7728u, c3876z0)) {
                        c3874y0.getClass();
                        b8 = 1;
                    } else if (atomicReferenceFieldUpdater2.get(c3874y0) != objM7728u) {
                        b8 = -1;
                    }
                }
            }
            if (b8 == 0) {
                break;
            }
        } while (b8 != 1);
        InterfaceC3836h interfaceC3836h = (InterfaceC3836h) AbstractC3865u.m7694i(c3874y0, true, new C3839i(this), 2);
        atomicReferenceFieldUpdater.set(this, interfaceC3836h);
        if (m7728u() instanceof InterfaceC3846k0) {
            return;
        }
        interfaceC3836h.mo7644a();
        atomicReferenceFieldUpdater.set(this, c3817a1);
    }

    public final InterfaceC3822c0 m7730y(boolean z7, boolean z10, InterfaceC2724l interfaceC2724l) {
        AbstractC3866u0 c3856p0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Throwable thM7705b;
        if (z7) {
            c3856p0 = interfaceC2724l instanceof AbstractC3862s0 ? (AbstractC3862s0) interfaceC2724l : null;
            if (c3856p0 == null) {
                c3856p0 = new C3854o0(interfaceC2724l);
            }
        } else {
            c3856p0 = interfaceC2724l instanceof AbstractC3866u0 ? (AbstractC3866u0) interfaceC2724l : null;
            if (c3856p0 == null) {
                c3856p0 = new C3856p0(interfaceC2724l);
            }
        }
        c3856p0.f12964d = this;
        while (true) {
            Object objM7728u = m7728u();
            if (objM7728u instanceof C3825d0) {
                C3825d0 c3825d0 = (C3825d0) objM7728u;
                if (c3825d0.f12904a) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f12981a;
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, objM7728u, c3856p0)) {
                        if (atomicReferenceFieldUpdater2.get(this) != objM7728u) {
                        }
                    }
                    return c3856p0;
                }
                C3876z0 c3876z0 = new C3876z0();
                InterfaceC3846k0 c3843j0 = c3825d0.f12904a ? c3876z0 : new C3843j0(c3876z0);
                do {
                    atomicReferenceFieldUpdater = f12981a;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, c3825d0, c3843j0)) {
                        break;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == c3825d0);
            } else {
                if (!(objM7728u instanceof InterfaceC3846k0)) {
                    if (z10) {
                        C3845k c3845k = objM7728u instanceof C3845k ? (C3845k) objM7728u : null;
                        interfaceC2724l.invoke(c3845k != null ? c3845k.f12934a : null);
                    }
                    return C3817a1.f12899a;
                }
                C3876z0 c3876z0Mo7647c = ((InterfaceC3846k0) objM7728u).mo7647c();
                if (c3876z0Mo7647c == null) {
                    AbstractC2796i.m5783d(objM7728u, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    m7717F((AbstractC3866u0) objM7728u);
                } else {
                    InterfaceC3822c0 interfaceC3822c0 = C3817a1.f12899a;
                    if (z7 && (objM7728u instanceof C3870w0)) {
                        synchronized (objM7728u) {
                            try {
                                thM7705b = ((C3870w0) objM7728u).m7705b();
                                if (thM7705b == null || ((interfaceC2724l instanceof C3839i) && !((C3870w0) objM7728u).m7707e())) {
                                    if (m7719g((InterfaceC3846k0) objM7728u, c3876z0Mo7647c, c3856p0)) {
                                        if (thM7705b == null) {
                                            return c3856p0;
                                        }
                                        interfaceC3822c0 = c3856p0;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (thM7705b != null) {
                            if (z10) {
                                interfaceC2724l.invoke(thM7705b);
                            }
                            return interfaceC3822c0;
                        }
                        if (m7719g((InterfaceC3846k0) objM7728u, c3876z0Mo7647c, c3856p0)) {
                            return c3856p0;
                        }
                    } else {
                        thM7705b = null;
                        if (thM7705b != null) {
                            if (z10) {
                                interfaceC2724l.invoke(thM7705b);
                            }
                            return interfaceC3822c0;
                        }
                        if (m7719g((InterfaceC3846k0) objM7728u, c3876z0Mo7647c, c3856p0)) {
                            return c3856p0;
                        }
                    }
                }
            }
        }
    }

    public boolean mo7731z() {
        return false;
    }

    public void m7716E() {
    }

    public void mo7634D(Object obj) {
    }

    public void mo7720h(Object obj) {
    }

    public void mo7637w(C0423q c0423q) {
        throw c0423q;
    }
}
