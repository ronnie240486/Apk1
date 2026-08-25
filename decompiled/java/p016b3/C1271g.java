package p016b3;

import p001a0.C0019b;
import p026c3.C1392a;

public final class C1271g implements InterfaceC1289v {

    public final int f4016a;

    public final Object f4017b;

    public C1271g(int i6) {
        this.f4016a = i6;
        switch (i6) {
            case 1:
                this.f4017b = new C0019b(9);
                break;
            default:
                this.f4017b = new C1263c(3);
                break;
        }
    }

    @Override
    public final InterfaceC1288u mo3136a(C1262b0 c1262b0) {
        switch (this.f4016a) {
            case 0:
                return new C1265d(1, (C1263c) this.f4017b);
            default:
                return new C1392a((C0019b) this.f4017b);
        }
    }
}
