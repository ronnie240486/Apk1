package p067g2;

import p030c9.AbstractC1433c;

public final class C2603j extends AbstractC1433c {

    public Object f9059a;

    public final C2605l f9060b;

    public int f9061c;

    public C2603j(C2605l c2605l, AbstractC1433c abstractC1433c) {
        super(abstractC1433c);
        this.f9060b = c2605l;
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        this.f9059a = obj;
        this.f9061c |= Integer.MIN_VALUE;
        return this.f9060b.m5617b(null, this);
    }
}
