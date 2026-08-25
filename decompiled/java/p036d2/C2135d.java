package p036d2;

import p009aa.C0085e;
import p030c9.AbstractC1433c;

public final class C2135d extends AbstractC1433c {

    public Object f7751a;

    public C0085e f7752b;

    public Object f7753c;

    public final C2136e f7754d;

    public int f7755e;

    public C2135d(C2136e c2136e, AbstractC1433c abstractC1433c) {
        super(abstractC1433c);
        this.f7754d = c2136e;
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        this.f7753c = obj;
        this.f7755e |= Integer.MIN_VALUE;
        return this.f7754d.m5081a(this);
    }
}
