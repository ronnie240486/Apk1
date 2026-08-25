package p254x9;

import com.bumptech.glide.AbstractC1466d;
import p008a9.InterfaceC0079i;
import p030c9.AbstractC1433c;
import p030c9.InterfaceC1434d;
import p213t9.AbstractC3815a;
import p213t9.AbstractC3865u;

public class C4176r extends AbstractC3815a implements InterfaceC1434d {

    public final AbstractC1433c f14114d;

    public C4176r(InterfaceC0079i interfaceC0079i, AbstractC1433c abstractC1433c) {
        super(interfaceC0079i, true);
        this.f14114d = abstractC1433c;
    }

    @Override
    public final InterfaceC1434d getCallerFrame() {
        AbstractC1433c abstractC1433c = this.f14114d;
        if (abstractC1433c instanceof InterfaceC1434d) {
            return abstractC1433c;
        }
        return null;
    }

    @Override
    public void mo7720h(Object obj) {
        AbstractC4159a.m8205f(AbstractC1466d.m3499r(this.f14114d), AbstractC3865u.m7697l(obj), null);
    }

    @Override
    public void mo7679i(Object obj) {
        this.f14114d.resumeWith(AbstractC3865u.m7697l(obj));
    }

    @Override
    public final boolean mo7731z() {
        return true;
    }
}
