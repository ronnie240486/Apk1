package com.google.android.gms.internal.cast;

public final class C1720w7 implements InterfaceC1520b8 {

    public final AbstractC1728x6 f5718a;

    public final C1661q2 f5719b;

    public C1720w7(C1661q2 c1661q2, AbstractC1728x6 abstractC1728x6) {
        C1661q2 c1661q3 = AbstractC1559f7.f5301a;
        this.f5719b = c1661q2;
        this.f5718a = abstractC1728x6;
    }

    @Override
    public final void mo3735a(Object obj, C1675r7 c1675r7) {
        obj.getClass();
        throw new ClassCastException();
    }

    @Override
    public final AbstractC1589i7 mo3736b() {
        AbstractC1728x6 abstractC1728x6 = this.f5718a;
        return abstractC1728x6 instanceof AbstractC1589i7 ? (AbstractC1589i7) ((AbstractC1589i7) abstractC1728x6).mo3714h(4, null) : ((AbstractC1579h7) ((AbstractC1589i7) abstractC1728x6).mo3714h(5, null)).m3840b();
    }

    @Override
    public final boolean mo3737c(AbstractC1589i7 abstractC1589i7, Object obj) {
        return abstractC1589i7.zzc.equals(((AbstractC1589i7) obj).zzc);
    }

    @Override
    public final void mo3738d(Object obj) {
        this.f5719b.getClass();
        C1661q2.m3974b(obj);
        C1661q2 c1661q2 = AbstractC1559f7.f5301a;
        obj.getClass();
        throw new ClassCastException();
    }

    @Override
    public final int mo3739e(AbstractC1589i7 abstractC1589i7) {
        C1550e8 c1550e8 = abstractC1589i7.zzc;
        int i6 = c1550e8.f5289c;
        if (i6 != -1) {
            return i6;
        }
        c1550e8.f5289c = 0;
        return 0;
    }

    @Override
    public final boolean mo3740f(Object obj) {
        obj.getClass();
        throw new ClassCastException();
    }

    @Override
    public final void mo3741g(Object obj, Object obj2) {
        AbstractC1530c8.m3776q(obj, obj2);
    }

    @Override
    public final int mo3742h(AbstractC1589i7 abstractC1589i7) {
        abstractC1589i7.zzc.getClass();
        return 506991;
    }
}
