package p254x9;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p000a.AbstractC0004e;
import p008a9.InterfaceC0074d;
import p008a9.InterfaceC0079i;
import p009aa.C0087g;
import p030c9.AbstractC1433c;
import p055ea.AbstractC2460q;
import p091i9.InterfaceC2724l;
import p091i9.InterfaceC2728p;
import p103j9.AbstractC2796i;
import p123l5.AbstractC2973a;
import p156o9.AbstractC3280d;
import p192r9.AbstractC3655m;
import p213t9.AbstractC3832f1;
import p213t9.AbstractC3834g0;
import p213t9.AbstractC3855p;
import p213t9.AbstractC3865u;
import p213t9.C3841i1;
import p213t9.C3845k;
import p213t9.C3847l;
import p213t9.C3857q;
import p213t9.C3874y0;
import p213t9.InterfaceC3829e1;
import p213t9.InterfaceC3858q0;
import p213t9.InterfaceC3859r;
import p222u7.C3926b;
import p243w8.AbstractC4066h;
import p253x8.C4145h;

public abstract class AbstractC4159a {

    public static final C3926b f14077a = new C3926b("NO_DECISION", 1);

    public static final C3926b f14078b = new C3926b("CLOSED", 1);

    public static final C3926b f14079c = new C3926b("UNDEFINED", 1);

    public static final C3926b f14080d = new C3926b("REUSABLE_CLAIMED", 1);

    public static final C3926b f14081e = new C3926b("CONDITION_FALSE", 1);

    public static final C3926b f14082f = new C3926b("NO_THREAD_ELEMENTS", 1);

    public static final void m8200a(int i6) {
        if (i6 < 1) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final Object m8201b(C0087g c0087g, long j10, InterfaceC2728p interfaceC2728p) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        while (true) {
            if (c0087g.f14116c >= j10 && !c0087g.mo8211a()) {
                return c0087g;
            }
            Object obj = AbstractC4161c.f14084a.get(c0087g);
            C3926b c3926b = f14078b;
            if (obj == c3926b) {
                return c3926b;
            }
            AbstractC4177s abstractC4177s = (AbstractC4177s) ((AbstractC4161c) obj);
            if (abstractC4177s == null) {
                abstractC4177s = (AbstractC4177s) interfaceC2728p.invoke(Long.valueOf(c0087g.f14116c + 1), c0087g);
                do {
                    atomicReferenceFieldUpdater = AbstractC4161c.f14084a;
                    if (atomicReferenceFieldUpdater.compareAndSet(c0087g, null, abstractC4177s)) {
                        if (c0087g.mo8211a()) {
                            c0087g.m8212b();
                        }
                    }
                } while (atomicReferenceFieldUpdater.get(c0087g) == null);
            }
            c0087g = abstractC4177s;
        }
    }

    public static final AbstractC4177s m8202c(Object obj) {
        if (obj == f14078b) {
            throw new IllegalStateException("Does not contain segment");
        }
        AbstractC2796i.m5783d(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (AbstractC4177s) obj;
    }

    public static final void m8203d(InterfaceC0079i interfaceC0079i, Throwable th) {
        Throwable runtimeException;
        Iterator it = AbstractC4163e.f14087a.iterator();
        while (it.hasNext()) {
            try {
                ((InterfaceC3859r) it.next()).mo3263b(interfaceC0079i, th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    AbstractC2973a.m6013a(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            AbstractC2973a.m6013a(th, new C4164f(interfaceC0079i));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final void m8204e(InterfaceC0079i interfaceC0079i, Object obj) {
        if (obj == f14082f) {
            return;
        }
        if (!(obj instanceof C4181w)) {
            Object objMo250a = interfaceC0079i.mo250a(null, C4179u.f14119c);
            AbstractC2796i.m5783d(objMo250a, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            AbstractC2460q.m5499m(objMo250a);
            throw null;
        }
        C4181w c4181w = (C4181w) obj;
        InterfaceC3829e1[] interfaceC3829e1Arr = c4181w.f14124b;
        int length = interfaceC3829e1Arr.length - 1;
        if (length < 0) {
            return;
        }
        InterfaceC3829e1 interfaceC3829e1 = interfaceC3829e1Arr[length];
        AbstractC2796i.m5782c(null);
        Object obj2 = c4181w.f14123a[length];
        throw null;
    }

    public static final void m8205f(InterfaceC0074d interfaceC0074d, Object obj, InterfaceC2724l interfaceC2724l) {
        Object c3845k;
        if (!(interfaceC0074d instanceof C4165g)) {
            interfaceC0074d.resumeWith(obj);
            return;
        }
        C4165g c4165g = (C4165g) interfaceC0074d;
        Throwable thM8065a = AbstractC4066h.m8065a(obj);
        if (thM8065a == null) {
            c3845k = interfaceC2724l != null ? new C3847l(obj, interfaceC2724l) : obj;
        } else {
            c3845k = new C3845k(thM8065a, false);
        }
        AbstractC1433c abstractC1433c = c4165g.f14091e;
        abstractC1433c.getContext();
        AbstractC3855p abstractC3855p = c4165g.f14090d;
        if (abstractC3855p.mo7683g()) {
            c4165g.f14092f = c3845k;
            c4165g.f12898c = 1;
            abstractC3855p.mo7665d(abstractC1433c.getContext(), c4165g);
            return;
        }
        AbstractC3834g0 abstractC3834g0M7670a = AbstractC3832f1.m7670a();
        if (abstractC3834g0M7670a.f12916c >= 4294967296L) {
            c4165g.f14092f = c3845k;
            c4165g.f12898c = 1;
            C4145h c4145h = abstractC3834g0M7670a.f12918e;
            if (c4145h == null) {
                c4145h = new C4145h();
                abstractC3834g0M7670a.f12918e = c4145h;
            }
            c4145h.addLast(c4165g);
            return;
        }
        abstractC3834g0M7670a.m7673j(true);
        try {
            InterfaceC3858q0 interfaceC3858q0 = (InterfaceC3858q0) abstractC1433c.getContext().mo252e(C3857q.f12952b);
            if (interfaceC3858q0 == null || interfaceC3858q0.isActive()) {
                Object obj2 = c4165g.f14093g;
                InterfaceC0079i context = abstractC1433c.getContext();
                Object objM8209j = m8209j(context, obj2);
                C3841i1 c3841i1M7700o = objM8209j != f14082f ? AbstractC3865u.m7700o(abstractC1433c, context, objM8209j) : null;
                try {
                    abstractC1433c.resumeWith(obj);
                    if (c3841i1M7700o == null || c3841i1M7700o.m7677J()) {
                        m8204e(context, objM8209j);
                    }
                } catch (Throwable th) {
                    if (c3841i1M7700o == null || c3841i1M7700o.m7677J()) {
                        m8204e(context, objM8209j);
                    }
                    throw th;
                }
            } else {
                CancellationException cancellationExceptionM7726q = ((C3874y0) interfaceC3858q0).m7726q();
                c4165g.mo7638a(c3845k, cancellationExceptionM7726q);
                c4165g.resumeWith(AbstractC3280d.m6588f(cancellationExceptionM7726q));
            }
            while (abstractC3834g0M7670a.m7674k()) {
            }
        } catch (Throwable th2) {
            try {
                c4165g.m7642e(th2, null);
            } finally {
                abstractC3834g0M7670a.m7672h();
            }
        }
    }

    public static final long m8207h(String str, long j10, long j11, long j12) {
        String property;
        int i6 = AbstractC4178t.f14117a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j10;
        }
        Long lM7395M = AbstractC3655m.m7395M(property);
        if (lM7395M == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lM7395M.longValue();
        if (j11 <= jLongValue && jLongValue <= j12) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j11 + ".." + j12 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int m8208i(String str, int i6, int i10, int i11, int i12) {
        if ((i12 & 4) != 0) {
            i10 = 1;
        }
        if ((i12 & 8) != 0) {
            i11 = Integer.MAX_VALUE;
        }
        return (int) m8207h(str, i6, i10, i11);
    }

    public static final Object m8209j(InterfaceC0079i interfaceC0079i, Object obj) {
        if (obj == null) {
            obj = interfaceC0079i.mo250a(0, C4179u.f14118b);
            AbstractC2796i.m5782c(obj);
        }
        if (obj == 0) {
            return f14082f;
        }
        if (obj instanceof Integer) {
            return interfaceC0079i.mo250a(new C4181w(interfaceC0079i, ((Number) obj).intValue()), C4179u.f14120d);
        }
        AbstractC2460q.m5499m(obj);
        throw null;
    }
}
