package p128m0;

import p103j9.AbstractC2796i;

public final class C3028d extends C3027c {

    public final Object f10359d;

    public C3028d(int i6) {
        super(i6);
        this.f10359d = new Object();
    }

    @Override
    public final Object mo6099a() {
        Object objMo6099a;
        synchronized (this.f10359d) {
            objMo6099a = super.mo6099a();
        }
        return objMo6099a;
    }

    @Override
    public final boolean mo6101c(Object obj) {
        boolean zMo6101c;
        AbstractC2796i.m5785f(obj, "instance");
        synchronized (this.f10359d) {
            zMo6101c = super.mo6101c(obj);
        }
        return zMo6101c;
    }
}
