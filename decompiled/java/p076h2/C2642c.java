package p076h2;

import p030c9.AbstractC1433c;
import p103j9.C2801n;
import p130m2.C3061i;

public final class C2642c extends AbstractC1433c {

    public C2648i f9184a;

    public C3061i f9185b;

    public Object f9186c;

    public Object f9187d;

    public C2801n f9188e;

    public C2801n f9189f;

    public C2801n f9190g;

    public C2801n f9191h;

    public Object f9192i;

    public final C2648i f9193j;

    public int f9194k;

    public C2642c(C2648i c2648i, AbstractC1433c abstractC1433c) {
        super(abstractC1433c);
        this.f9193j = c2648i;
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        this.f9192i = obj;
        this.f9194k |= Integer.MIN_VALUE;
        return C2648i.m5662b(this.f9193j, null, null, null, null, this);
    }
}
