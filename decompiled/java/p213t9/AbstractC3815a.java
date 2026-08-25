package p213t9;

import androidx.fragment.app.C0423q;
import com.bumptech.glide.AbstractC1466d;
import p008a9.InterfaceC0074d;
import p008a9.InterfaceC0079i;
import p021b9.EnumC1367a;
import p030c9.AbstractC1431a;
import p091i9.InterfaceC2728p;
import p103j9.AbstractC2804q;
import p156o9.AbstractC3280d;
import p187r4.AbstractC3612b;
import p215u.AbstractC3885h;
import p243w8.AbstractC4066h;
import p243w8.C4070l;
import p254x9.AbstractC4159a;

public abstract class AbstractC3815a extends C3874y0 implements InterfaceC0074d, InterfaceC3861s {

    public final InterfaceC0079i f12897c;

    public AbstractC3815a(InterfaceC0079i interfaceC0079i, boolean z7) {
        super(z7);
        m7729x((InterfaceC3858q0) interfaceC0079i.mo252e(C3857q.f12952b));
        this.f12897c = interfaceC0079i.mo253f(this);
    }

    @Override
    public final void mo7634D(Object obj) {
        if (obj instanceof C3845k) {
            C3845k c3845k = (C3845k) obj;
            Throwable th = c3845k.f12934a;
            c3845k.getClass();
            C3845k.f12933b.get(c3845k);
        }
    }

    public final void m7635I(int i6, AbstractC3815a abstractC3815a, InterfaceC2728p interfaceC2728p) {
        int iM7785a = AbstractC3885h.m7785a(i6);
        if (iM7785a == 0) {
            AbstractC3612b.m7257M(interfaceC2728p, abstractC3815a, this);
            return;
        }
        if (iM7785a != 1) {
            if (iM7785a == 2) {
                AbstractC1466d.m3499r(((AbstractC1431a) interfaceC2728p).create(abstractC3815a, this)).resumeWith(C4070l.f13734a);
                return;
            }
            if (iM7785a != 3) {
                throw new C0423q(13);
            }
            try {
                InterfaceC0079i interfaceC0079i = this.f12897c;
                Object objM8209j = AbstractC4159a.m8209j(interfaceC0079i, null);
                try {
                    AbstractC2804q.m5797b(interfaceC2728p);
                    Object objInvoke = interfaceC2728p.invoke(abstractC3815a, this);
                    AbstractC4159a.m8204e(interfaceC0079i, objM8209j);
                    if (objInvoke != EnumC1367a.f4179a) {
                        resumeWith(objInvoke);
                    }
                } catch (Throwable th) {
                    AbstractC4159a.m8204e(interfaceC0079i, objM8209j);
                    throw th;
                }
            } catch (Throwable th2) {
                resumeWith(AbstractC3280d.m6588f(th2));
            }
        }
    }

    @Override
    public final InterfaceC0079i mo1512d() {
        return this.f12897c;
    }

    @Override
    public final InterfaceC0079i getContext() {
        return this.f12897c;
    }

    @Override
    public final String mo7636l() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override
    public final void resumeWith(Object obj) {
        Throwable thM8065a = AbstractC4066h.m8065a(obj);
        if (thM8065a != null) {
            obj = new C3845k(thM8065a, false);
        }
        Object objM7714A = m7714A(obj);
        if (objM7714A == AbstractC3865u.f12958d) {
            return;
        }
        mo7679i(objM7714A);
    }

    @Override
    public final void mo7637w(C0423q c0423q) {
        AbstractC3865u.m7693h(this.f12897c, c0423q);
    }
}
