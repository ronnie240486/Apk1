package p076h2;

import p025c2.C1382c;
import p025c2.C1383d;
import p030c9.AbstractC1433c;
import p067g2.C2606m;
import p130m2.C3061i;
import p130m2.C3065m;

public final class C2641b extends AbstractC1433c {

    public C2648i f9173a;

    public C2606m f9174b;

    public C1382c f9175c;

    public C3061i f9176d;

    public Object f9177e;

    public C3065m f9178f;

    public C1383d f9179g;

    public int f9180h;

    public Object f9181i;

    public final C2648i f9182j;

    public int f9183k;

    public C2641b(C2648i c2648i, AbstractC1433c abstractC1433c) {
        super(abstractC1433c);
        this.f9182j = c2648i;
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        this.f9181i = obj;
        this.f9183k |= Integer.MIN_VALUE;
        return C2648i.m5661a(this.f9182j, null, null, null, null, null, null, this);
    }
}
