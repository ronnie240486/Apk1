package p076h2;

import p030c9.AbstractC1433c;

public final class C2645f extends AbstractC1433c {

    public C2648i f9213a;

    public C2650k f9214b;

    public Object f9215c;

    public final C2648i f9216d;

    public int f9217e;

    public C2645f(C2648i c2648i, AbstractC1433c abstractC1433c) {
        super(abstractC1433c);
        this.f9216d = c2648i;
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        this.f9215c = obj;
        this.f9217e |= Integer.MIN_VALUE;
        return this.f9216d.m5664d(null, this);
    }
}
