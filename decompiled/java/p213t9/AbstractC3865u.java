package p213t9;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p008a9.C0075e;
import p008a9.C0080j;
import p008a9.InterfaceC0074d;
import p008a9.InterfaceC0079i;
import p021b9.EnumC1367a;
import p030c9.AbstractC1433c;
import p030c9.InterfaceC1434d;
import p091i9.InterfaceC2728p;
import p103j9.AbstractC2796i;
import p123l5.AbstractC2973a;
import p156o9.AbstractC3280d;
import p187r4.AbstractC3612b;
import p222u7.AbstractC3928d;
import p222u7.C3926b;
import p243w8.AbstractC4066h;
import p254x9.AbstractC4159a;
import p254x9.C4162d;
import p254x9.C4165g;
import p254x9.C4176r;
import p275z9.C4362d;

public abstract class AbstractC3865u {

    public static final C3926b f12955a = new C3926b("RESUME_TOKEN", 1);

    public static final C3926b f12956b = new C3926b("CLOSED_EMPTY", 1);

    public static final C3926b f12957c = new C3926b("COMPLETING_ALREADY", 1);

    public static final C3926b f12958d = new C3926b("COMPLETING_WAITING_CHILDREN", 1);

    public static final C3926b f12959e = new C3926b("COMPLETING_RETRY", 1);

    public static final C3926b f12960f = new C3926b("TOO_LATE_TO_CANCEL", 1);

    public static final C3926b f12961g = new C3926b("SEALED", 1);

    public static final C3825d0 f12962h = new C3825d0(false);

    public static final C3825d0 f12963i = new C3825d0(true);

    public static final void m7686a(InterfaceC0079i interfaceC0079i, CancellationException cancellationException) {
        InterfaceC3858q0 interfaceC3858q0 = (InterfaceC3858q0) interfaceC0079i.mo252e(C3857q.f12952b);
        if (interfaceC3858q0 != null) {
            C3874y0 c3874y0 = (C3874y0) interfaceC3858q0;
            if (cancellationException == null) {
                cancellationException = new C3860r0(c3874y0.mo7636l(), null, c3874y0);
            }
            c3874y0.m7721j(cancellationException);
        }
    }

    public static void m7688c(InterfaceC3858q0 interfaceC3858q0) {
        C3874y0 c3874y0 = (C3874y0) interfaceC3858q0;
        c3874y0.getClass();
        c3874y0.m7721j(new C3860r0(c3874y0.mo7636l(), null, c3874y0));
    }

    public static void m7689d(C4162d c4162d) {
        InterfaceC3858q0 interfaceC3858q0 = (InterfaceC3858q0) c4162d.f14086a.mo252e(C3857q.f12952b);
        if (interfaceC3858q0 != null) {
            C3874y0 c3874y0 = (C3874y0) interfaceC3858q0;
            c3874y0.m7721j(new C3860r0(c3874y0.mo7636l(), null, c3874y0));
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + c4162d).toString());
        }
    }

    public static final InterfaceC0079i m7690e(InterfaceC0079i interfaceC0079i, InterfaceC0079i interfaceC0079i2, boolean z7) {
        Boolean bool = Boolean.FALSE;
        C3849m c3849m = C3849m.f12939c;
        boolean zBooleanValue = ((Boolean) interfaceC0079i.mo250a(bool, c3849m)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) interfaceC0079i2.mo250a(bool, c3849m)).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return interfaceC0079i.mo253f(interfaceC0079i2);
        }
        C0080j c0080j = C0080j.f206a;
        InterfaceC0079i interfaceC0079i3 = (InterfaceC0079i) interfaceC0079i.mo250a(c0080j, new C3849m(2, 2));
        Object objMo250a = interfaceC0079i2;
        if (zBooleanValue2) {
            objMo250a = interfaceC0079i2.mo250a(c0080j, C3849m.f12938b);
        }
        return interfaceC0079i3.mo253f((InterfaceC0079i) objMo250a);
    }

    public static final String m7691f(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final InterfaceC3858q0 m7692g(InterfaceC0079i interfaceC0079i) {
        InterfaceC3858q0 interfaceC3858q0 = (InterfaceC3858q0) interfaceC0079i.mo252e(C3857q.f12952b);
        if (interfaceC3858q0 != null) {
            return interfaceC3858q0;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + interfaceC0079i).toString());
    }

    public static final void m7693h(InterfaceC0079i interfaceC0079i, Throwable th) {
        try {
            InterfaceC3859r interfaceC3859r = (InterfaceC3859r) interfaceC0079i.mo252e(C3857q.f12951a);
            if (interfaceC3859r != null) {
                interfaceC3859r.mo3263b(interfaceC0079i, th);
            } else {
                AbstractC4159a.m8203d(interfaceC0079i, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                AbstractC2973a.m6013a(runtimeException, th);
                th = runtimeException;
            }
            AbstractC4159a.m8203d(interfaceC0079i, th);
        }
    }

    public static InterfaceC3822c0 m7694i(InterfaceC3858q0 interfaceC3858q0, boolean z7, AbstractC3866u0 abstractC3866u0, int i6) {
        if ((i6 & 1) != 0) {
            z7 = false;
        }
        return ((C3874y0) interfaceC3858q0).m7730y(z7, (i6 & 2) != 0, abstractC3866u0);
    }

    public static final boolean m7695j(int i6) {
        return i6 == 1 || i6 == 2;
    }

    public static C3871x m7696k(InterfaceC3861s interfaceC3861s, AbstractC3855p abstractC3855p, InterfaceC2728p interfaceC2728p, int i6) {
        boolean z7 = true;
        InterfaceC0079i interfaceC0079i = abstractC3855p;
        if ((i6 & 1) != 0) {
            interfaceC0079i = C0080j.f206a;
        }
        InterfaceC0079i interfaceC0079iM7690e = m7690e(interfaceC3861s.mo1512d(), interfaceC0079i, true);
        C4362d c4362d = AbstractC3819b0.f12901a;
        if (interfaceC0079iM7690e != c4362d && interfaceC0079iM7690e.mo252e(C0075e.f205a) == null) {
            interfaceC0079iM7690e = interfaceC0079iM7690e.mo253f(c4362d);
        }
        C3871x c3871x = new C3871x(interfaceC0079iM7690e, z7, 1);
        c3871x.m7635I(1, c3871x, interfaceC2728p);
        return c3871x;
    }

    public static final Object m7697l(Object obj) {
        return obj instanceof C3845k ? AbstractC3280d.m6588f(((C3845k) obj).f12934a) : obj;
    }

    public static final void m7698m(C3827e c3827e, InterfaceC0074d interfaceC0074d, boolean z7) {
        Object obj = C3827e.f12906g.get(c3827e);
        Throwable thMo7640c = c3827e.mo7640c(obj);
        Object objM6588f = thMo7640c != null ? AbstractC3280d.m6588f(thMo7640c) : c3827e.mo7641d(obj);
        if (!z7) {
            interfaceC0074d.resumeWith(objM6588f);
            return;
        }
        AbstractC2796i.m5783d(interfaceC0074d, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        C4165g c4165g = (C4165g) interfaceC0074d;
        AbstractC1433c abstractC1433c = c4165g.f14091e;
        InterfaceC0079i context = abstractC1433c.getContext();
        Object objM8209j = AbstractC4159a.m8209j(context, c4165g.f14093g);
        C3841i1 c3841i1M7700o = objM8209j != AbstractC4159a.f14082f ? m7700o(abstractC1433c, context, objM8209j) : null;
        try {
            abstractC1433c.resumeWith(objM6588f);
        } finally {
            if (c3841i1M7700o == null || c3841i1M7700o.m7677J()) {
                AbstractC4159a.m8204e(context, objM8209j);
            }
        }
    }

    public static final String m7699n(InterfaceC0074d interfaceC0074d) {
        Object objM6588f;
        if (interfaceC0074d instanceof C4165g) {
            return interfaceC0074d.toString();
        }
        try {
            objM6588f = interfaceC0074d + '@' + m7691f(interfaceC0074d);
        } catch (Throwable th) {
            objM6588f = AbstractC3280d.m6588f(th);
        }
        if (AbstractC4066h.m8065a(objM6588f) != null) {
            objM6588f = interfaceC0074d.getClass().getName() + '@' + m7691f(interfaceC0074d);
        }
        return (String) objM6588f;
    }

    public static final C3841i1 m7700o(AbstractC1433c abstractC1433c, InterfaceC0079i interfaceC0079i, Object obj) {
        C3841i1 c3841i1 = null;
        if (!(abstractC1433c instanceof InterfaceC1434d)) {
            return null;
        }
        if (interfaceC0079i.mo252e(C3844j1.f12932a) != null) {
            while (!(abstractC1433c instanceof C3875z) && (abstractC1433c = abstractC1433c.getCallerFrame()) != 0) {
                if (abstractC1433c instanceof C3841i1) {
                    c3841i1 = (C3841i1) abstractC1433c;
                    break;
                }
            }
            if (c3841i1 != null) {
                c3841i1.m7678K(interfaceC0079i, obj);
            }
        }
        return c3841i1;
    }

    public static final Object m7701p(InterfaceC0079i interfaceC0079i, InterfaceC2728p interfaceC2728p, AbstractC1433c abstractC1433c) throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        InterfaceC3846k0 interfaceC3846k0;
        InterfaceC0079i context = abstractC1433c.getContext();
        InterfaceC0079i interfaceC0079iMo253f = !((Boolean) interfaceC0079i.mo250a(Boolean.FALSE, C3849m.f12939c)).booleanValue() ? context.mo253f(interfaceC0079i) : m7690e(context, interfaceC0079i, false);
        InterfaceC3858q0 interfaceC3858q0 = (InterfaceC3858q0) interfaceC0079iMo253f.mo252e(C3857q.f12952b);
        if (interfaceC3858q0 != null && !interfaceC3858q0.isActive()) {
            throw ((C3874y0) interfaceC3858q0).m7726q();
        }
        if (interfaceC0079iMo253f == context) {
            C4176r c4176r = new C4176r(interfaceC0079iMo253f, abstractC1433c);
            return AbstractC3928d.m7861z(c4176r, c4176r, interfaceC2728p);
        }
        C0075e c0075e = C0075e.f205a;
        if (AbstractC2796i.m5780a(interfaceC0079iMo253f.mo252e(c0075e), context.mo252e(c0075e))) {
            C3841i1 c3841i1 = new C3841i1(interfaceC0079iMo253f, abstractC1433c);
            InterfaceC0079i interfaceC0079i2 = c3841i1.f12897c;
            Object objM8209j = AbstractC4159a.m8209j(interfaceC0079i2, null);
            try {
                return AbstractC3928d.m7861z(c3841i1, c3841i1, interfaceC2728p);
            } finally {
                AbstractC4159a.m8204e(interfaceC0079i2, objM8209j);
            }
        }
        C3875z c3875z = new C3875z(interfaceC0079iMo253f, abstractC1433c);
        AbstractC3612b.m7257M(interfaceC2728p, c3875z, c3875z);
        do {
            atomicIntegerFieldUpdater = C3875z.f12983e;
            int i6 = atomicIntegerFieldUpdater.get(c3875z);
            if (i6 != 0) {
                if (i6 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                Object objM7728u = c3875z.m7728u();
                C3848l0 c3848l0 = objM7728u instanceof C3848l0 ? (C3848l0) objM7728u : null;
                if (c3848l0 != null && (interfaceC3846k0 = c3848l0.f12937a) != null) {
                    objM7728u = interfaceC3846k0;
                }
                if (objM7728u instanceof C3845k) {
                    throw ((C3845k) objM7728u).f12934a;
                }
                return objM7728u;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(c3875z, 0, 1));
        return EnumC1367a.f4179a;
    }
}
