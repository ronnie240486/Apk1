package p236w;

public class C4033h extends C4032g {

    public int f13675m;

    public C4033h(AbstractC4039n abstractC4039n) {
        super(abstractC4039n);
        if (abstractC4039n instanceof C4036k) {
            this.f13667e = 2;
        } else {
            this.f13667e = 3;
        }
    }

    @Override
    public final void mo8030d(int i6) {
        if (this.f13672j) {
            return;
        }
        this.f13672j = true;
        this.f13669g = i6;
        for (InterfaceC4030e interfaceC4030e : this.f13673k) {
            interfaceC4030e.mo8013a(interfaceC4030e);
        }
    }
}
