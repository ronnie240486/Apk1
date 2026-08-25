package p254x9;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p008a9.InterfaceC0074d;
import p008a9.InterfaceC0079i;
import p030c9.AbstractC1433c;
import p030c9.InterfaceC1434d;
import p103j9.AbstractC2796i;
import p213t9.AbstractC3816a0;
import p213t9.AbstractC3832f1;
import p213t9.AbstractC3834g0;
import p213t9.AbstractC3855p;
import p213t9.AbstractC3865u;
import p213t9.C3845k;
import p213t9.C3847l;
import p243w8.AbstractC4066h;
import p253x8.C4145h;

public final class C4165g extends AbstractC3816a0 implements InterfaceC1434d, InterfaceC0074d {

    public static final AtomicReferenceFieldUpdater f14089h = AtomicReferenceFieldUpdater.newUpdater(C4165g.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    public final AbstractC3855p f14090d;

    public final AbstractC1433c f14091e;

    public Object f14092f;

    public final Object f14093g;

    public C4165g(AbstractC3855p abstractC3855p, AbstractC1433c abstractC1433c) {
        super(-1);
        this.f14090d = abstractC3855p;
        this.f14091e = abstractC1433c;
        this.f14092f = AbstractC4159a.f14079c;
        Object objMo250a = abstractC1433c.getContext().mo250a(0, C4179u.f14118b);
        AbstractC2796i.m5782c(objMo250a);
        this.f14093g = objMo250a;
    }

    @Override
    public final void mo7638a(Object obj, CancellationException cancellationException) {
        if (obj instanceof C3847l) {
            ((C3847l) obj).f12936b.invoke(cancellationException);
        }
    }

    @Override
    public final Object mo7643f() {
        Object obj = this.f14092f;
        this.f14092f = AbstractC4159a.f14079c;
        return obj;
    }

    @Override
    public final InterfaceC1434d getCallerFrame() {
        AbstractC1433c abstractC1433c = this.f14091e;
        if (abstractC1433c instanceof InterfaceC1434d) {
            return abstractC1433c;
        }
        return null;
    }

    @Override
    public final InterfaceC0079i getContext() {
        return this.f14091e.getContext();
    }

    @Override
    public final void resumeWith(Object obj) {
        AbstractC1433c abstractC1433c = this.f14091e;
        InterfaceC0079i context = abstractC1433c.getContext();
        Throwable thM8065a = AbstractC4066h.m8065a(obj);
        Object c3845k = thM8065a == null ? obj : new C3845k(thM8065a, false);
        AbstractC3855p abstractC3855p = this.f14090d;
        if (abstractC3855p.mo7683g()) {
            this.f14092f = c3845k;
            this.f12898c = 0;
            abstractC3855p.mo7665d(context, this);
            return;
        }
        AbstractC3834g0 abstractC3834g0M7670a = AbstractC3832f1.m7670a();
        if (abstractC3834g0M7670a.f12916c >= 4294967296L) {
            this.f14092f = c3845k;
            this.f12898c = 0;
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
            InterfaceC0079i context2 = abstractC1433c.getContext();
            Object objM8209j = AbstractC4159a.m8209j(context2, this.f14093g);
            try {
                abstractC1433c.resumeWith(obj);
                AbstractC4159a.m8204e(context2, objM8209j);
                while (abstractC3834g0M7670a.m7674k()) {
                }
            } catch (Throwable th) {
                AbstractC4159a.m8204e(context2, objM8209j);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                m7642e(th2, null);
            } finally {
                abstractC3834g0M7670a.m7672h();
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f14090d + ", " + AbstractC3865u.m7699n(this.f14091e) + ']';
    }

    @Override
    public final InterfaceC0074d mo7639b() {
        return this;
    }
}
