package p213t9;

import androidx.leanback.widget.C0486o;
import java.util.concurrent.CancellationException;
import p008a9.InterfaceC0074d;
import p008a9.InterfaceC0079i;
import p030c9.AbstractC1433c;
import p103j9.AbstractC2796i;
import p123l5.AbstractC2973a;
import p156o9.AbstractC3280d;
import p243w8.AbstractC4066h;
import p243w8.C4070l;
import p254x9.AbstractC4159a;
import p254x9.C4165g;
import p275z9.AbstractC4368j;
import p275z9.AbstractRunnableC4366h;

public abstract class AbstractC3816a0 extends AbstractRunnableC4366h {

    public int f12898c;

    public AbstractC3816a0(int i6) {
        super(0L, AbstractC4368j.f14836g);
        this.f12898c = i6;
    }

    public abstract void mo7638a(Object obj, CancellationException cancellationException);

    public abstract InterfaceC0074d mo7639b();

    public Throwable mo7640c(Object obj) {
        C3845k c3845k = obj instanceof C3845k ? (C3845k) obj : null;
        if (c3845k != null) {
            return c3845k.f12934a;
        }
        return null;
    }

    public final void m7642e(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            AbstractC2973a.m6013a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        AbstractC2796i.m5782c(th);
        AbstractC3865u.m7693h(mo7639b().getContext(), new C3863t("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object mo7643f();

    @Override
    public final void run() {
        Object objM6588f = C4070l.f13734a;
        C0486o c0486o = this.f14828b;
        try {
            InterfaceC0074d interfaceC0074dMo7639b = mo7639b();
            AbstractC2796i.m5783d(interfaceC0074dMo7639b, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            C4165g c4165g = (C4165g) interfaceC0074dMo7639b;
            AbstractC1433c abstractC1433c = c4165g.f14091e;
            Object obj = c4165g.f14093g;
            InterfaceC0079i context = abstractC1433c.getContext();
            Object objM8209j = AbstractC4159a.m8209j(context, obj);
            C3841i1 c3841i1M7700o = objM8209j != AbstractC4159a.f14082f ? AbstractC3865u.m7700o(abstractC1433c, context, objM8209j) : null;
            try {
                InterfaceC0079i context2 = abstractC1433c.getContext();
                Object objMo7643f = mo7643f();
                Throwable thMo7640c = mo7640c(objMo7643f);
                InterfaceC3858q0 interfaceC3858q0 = (thMo7640c == null && AbstractC3865u.m7695j(this.f12898c)) ? (InterfaceC3858q0) context2.mo252e(C3857q.f12952b) : null;
                if (interfaceC3858q0 != null && !interfaceC3858q0.isActive()) {
                    CancellationException cancellationExceptionM7726q = ((C3874y0) interfaceC3858q0).m7726q();
                    mo7638a(objMo7643f, cancellationExceptionM7726q);
                    abstractC1433c.resumeWith(AbstractC3280d.m6588f(cancellationExceptionM7726q));
                } else if (thMo7640c != null) {
                    abstractC1433c.resumeWith(AbstractC3280d.m6588f(thMo7640c));
                } else {
                    abstractC1433c.resumeWith(mo7641d(objMo7643f));
                }
                if (c3841i1M7700o == null || c3841i1M7700o.m7677J()) {
                    AbstractC4159a.m8204e(context, objM8209j);
                }
                try {
                    c0486o.getClass();
                } catch (Throwable th) {
                    objM6588f = AbstractC3280d.m6588f(th);
                }
                m7642e(null, AbstractC4066h.m8065a(objM6588f));
            } catch (Throwable th2) {
                if (c3841i1M7700o == null || c3841i1M7700o.m7677J()) {
                    AbstractC4159a.m8204e(context, objM8209j);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                c0486o.getClass();
            } catch (Throwable th4) {
                objM6588f = AbstractC3280d.m6588f(th4);
            }
            m7642e(th3, AbstractC4066h.m8065a(objM6588f));
        }
    }

    public Object mo7641d(Object obj) {
        return obj;
    }
}
