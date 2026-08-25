package p030c9;

import p008a9.C0080j;
import p008a9.InterfaceC0074d;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2802o;
import p103j9.C2803p;
import p103j9.InterfaceC2794g;

public abstract class AbstractC1438h extends AbstractC1437g implements InterfaceC2794g {
    private final int arity;

    public AbstractC1438h(InterfaceC0074d interfaceC0074d) {
        super(interfaceC0074d);
        if (interfaceC0074d != null && interfaceC0074d.getContext() != C0080j.f206a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
        this.arity = 2;
    }

    @Override
    public int getArity() {
        return this.arity;
    }

    @Override
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        AbstractC2802o.f9541a.getClass();
        String strM5795a = C2803p.m5795a(this);
        AbstractC2796i.m5784e(strM5795a, "renderLambdaToString(...)");
        return strM5795a;
    }
}
