package p213t9;

import p008a9.C0075e;
import p008a9.InterfaceC0079i;
import p030c9.AbstractC1433c;
import p243w8.C4064f;
import p254x9.AbstractC4159a;
import p254x9.C4176r;

public final class C3841i1 extends C4176r {

    public final ThreadLocal f12925e;
    private volatile boolean threadLocalIsSet;

    public C3841i1(InterfaceC0079i interfaceC0079i, AbstractC1433c abstractC1433c) {
        C3844j1 c3844j1 = C3844j1.f12932a;
        super(interfaceC0079i.mo252e(c3844j1) == null ? interfaceC0079i.mo253f(c3844j1) : interfaceC0079i, abstractC1433c);
        this.f12925e = new ThreadLocal();
        if (abstractC1433c.getContext().mo252e(C0075e.f205a) instanceof AbstractC3855p) {
            return;
        }
        Object objM8209j = AbstractC4159a.m8209j(interfaceC0079i, null);
        AbstractC4159a.m8204e(interfaceC0079i, objM8209j);
        m7678K(interfaceC0079i, objM8209j);
    }

    public final boolean m7677J() {
        boolean z7 = this.threadLocalIsSet && this.f12925e.get() == null;
        this.f12925e.remove();
        return !z7;
    }

    public final void m7678K(InterfaceC0079i interfaceC0079i, Object obj) {
        this.threadLocalIsSet = true;
        this.f12925e.set(new C4064f(interfaceC0079i, obj));
    }

    @Override
    public final void mo7679i(Object obj) {
        if (this.threadLocalIsSet) {
            C4064f c4064f = (C4064f) this.f12925e.get();
            if (c4064f != null) {
                AbstractC4159a.m8204e((InterfaceC0079i) c4064f.f13727a, c4064f.f13728b);
            }
            this.f12925e.remove();
        }
        Object objM7697l = AbstractC3865u.m7697l(obj);
        AbstractC1433c abstractC1433c = this.f14114d;
        InterfaceC0079i context = abstractC1433c.getContext();
        Object objM8209j = AbstractC4159a.m8209j(context, null);
        C3841i1 c3841i1M7700o = objM8209j != AbstractC4159a.f14082f ? AbstractC3865u.m7700o(abstractC1433c, context, objM8209j) : null;
        try {
            this.f14114d.resumeWith(objM7697l);
        } finally {
            if (c3841i1M7700o == null || c3841i1M7700o.m7677J()) {
                AbstractC4159a.m8204e(context, objM8209j);
            }
        }
    }
}
