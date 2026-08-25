package qa;

import p091i9.InterfaceC2713a;

public final class C3553a implements InterfaceC2713a {

    public final int f11956a;

    public final Object f11957b;

    public C3553a(int i6, Object obj) {
        this.f11956a = i6;
        this.f11957b = obj;
    }

    @Override
    public final Object invoke() {
        switch (this.f11956a) {
            case 0:
                return new C3567o(((C3559g) this.f11957b).f11971a);
            case 1:
                C3564l c3564l = (C3564l) this.f11957b;
                boolean z7 = true;
                if (AbstractC3563k.f11982a[c3564l.f11988F.ordinal()] == 1) {
                    z7 = false;
                } else {
                    c3564l.m7176b();
                }
                return Boolean.valueOf(z7);
            default:
                return new C3564l(((C3567o) this.f11957b).f12022a);
        }
    }
}
