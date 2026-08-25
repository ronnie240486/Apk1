package p025c2;

import android.graphics.Bitmap;
import p030c9.AbstractC1433c;
import p130m2.C3061i;
import p130m2.InterfaceC3068p;

public final class C1388i extends AbstractC1433c {

    public C1391l f4218a;

    public InterfaceC3068p f4219b;

    public C3061i f4220c;

    public C1383d f4221d;

    public Bitmap f4222e;

    public Object f4223f;

    public final C1391l f4224g;

    public int f4225h;

    public C1388i(C1391l c1391l, AbstractC1433c abstractC1433c) {
        super(abstractC1433c);
        this.f4224g = c1391l;
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        this.f4223f = obj;
        this.f4225h |= Integer.MIN_VALUE;
        return C1391l.m3264a(this.f4224g, null, this);
    }
}
