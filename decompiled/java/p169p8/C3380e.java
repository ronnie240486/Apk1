package p169p8;

import p090i8.AbstractC2712f;
import p090i8.InterfaceC2709c;
import p156o9.AbstractC3280d;
import p180q8.AbstractC3542q;

public final class C3380e extends AbstractC3376a {

    public final AbstractC2712f f11417k;

    public final int f11418l;

    public C3380e(AbstractC3280d abstractC3280d, AbstractC2712f abstractC2712f, int i6) {
        super(abstractC3280d);
        this.f11417k = abstractC2712f;
        this.f11418l = i6;
    }

    @Override
    public final void mo6609G(InterfaceC2709c interfaceC2709c) {
        AbstractC2712f abstractC2712f = this.f11417k;
        boolean z7 = abstractC2712f instanceof AbstractC3542q;
        AbstractC3280d abstractC3280d = this.f11404j;
        if (z7) {
            abstractC3280d.m6608F(interfaceC2709c);
        } else {
            abstractC3280d.m6608F(new RunnableC3379d(interfaceC2709c, abstractC2712f.mo5677a(), this.f11418l));
        }
    }
}
