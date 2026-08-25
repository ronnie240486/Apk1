package p030c9;

import p008a9.InterfaceC0074d;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2802o;
import p103j9.C2803p;
import p103j9.InterfaceC2794g;

public abstract class AbstractC1439i extends AbstractC1433c implements InterfaceC2794g {

    public final int f4370a;

    public AbstractC1439i(InterfaceC0074d interfaceC0074d) {
        super(interfaceC0074d);
        this.f4370a = 2;
    }

    @Override
    public final int getArity() {
        return this.f4370a;
    }

    @Override
    public final String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        AbstractC2802o.f9541a.getClass();
        String strM5795a = C2803p.m5795a(this);
        AbstractC2796i.m5784e(strM5795a, "renderLambdaToString(...)");
        return strM5795a;
    }
}
