package p113k7;

import p080h7.C2664b;
import p080h7.C2665c;
import p080h7.InterfaceC2669g;

public final class C2900g implements InterfaceC2669g {

    public boolean f9850a = false;

    public boolean f9851b = false;

    public C2665c f9852c;

    public final C2898e f9853d;

    public C2900g(C2898e c2898e) {
        this.f9853d = c2898e;
    }

    @Override
    public final InterfaceC2669g mo5673b(String str) {
        if (this.f9850a) {
            throw new C2664b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f9850a = true;
        this.f9853d.m5899c(this.f9852c, str, this.f9851b);
        return this;
    }

    @Override
    public final InterfaceC2669g mo5674c(boolean z7) {
        if (this.f9850a) {
            throw new C2664b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f9850a = true;
        this.f9853d.m5898b(this.f9852c, z7 ? 1 : 0, this.f9851b);
        return this;
    }
}
