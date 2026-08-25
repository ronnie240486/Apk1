package p076h2;

import p025c2.C1382c;
import p025c2.C1383d;
import p030c9.AbstractC1433c;
import p130m2.C3061i;
import p130m2.C3065m;

public final class C2644e extends AbstractC1433c {

    public C2648i f9203a;

    public C1382c f9204b;

    public C3061i f9205c;

    public Object f9206d;

    public C3065m f9207e;

    public C1383d f9208f;

    public int f9209g;

    public Object f9210h;

    public final C2648i f9211i;

    public int f9212j;

    public C2644e(C2648i c2648i, AbstractC1433c abstractC1433c) {
        super(abstractC1433c);
        this.f9211i = c2648i;
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        this.f9210h = obj;
        this.f9212j |= Integer.MIN_VALUE;
        return this.f9211i.m5663c(null, null, null, null, null, this);
    }
}
