package p067g2;

import p030c9.AbstractC1433c;
import p048e2.C2375j;

public final class C2604k extends AbstractC1433c {

    public C2605l f9062a;

    public C2375j f9063b;

    public Object f9064c;

    public Object f9065d;

    public final C2605l f9066e;

    public int f9067f;

    public C2604k(C2605l c2605l, AbstractC1433c abstractC1433c) {
        super(abstractC1433c);
        this.f9066e = c2605l;
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        this.f9065d = obj;
        this.f9067f |= Integer.MIN_VALUE;
        return this.f9066e.mo5615a(this);
    }
}
