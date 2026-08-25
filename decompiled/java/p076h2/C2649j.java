package p076h2;

import p030c9.AbstractC1433c;

public final class C2649j extends AbstractC1433c {

    public C2650k f9242a;

    public C2648i f9243b;

    public Object f9244c;

    public final C2650k f9245d;

    public int f9246e;

    public C2649j(C2650k c2650k, AbstractC1433c abstractC1433c) {
        super(abstractC1433c);
        this.f9245d = c2650k;
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        this.f9244c = obj;
        this.f9246e |= Integer.MIN_VALUE;
        return this.f9245d.m5666b(null, this);
    }
}
