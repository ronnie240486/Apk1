package p271z4;

import p230v4.InterfaceC3992f;

public final class C4336g {

    public final InterfaceC3992f f14712a;

    public C4336g(InterfaceC3992f interfaceC3992f) {
        this.f14712a = interfaceC3992f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C4336g) {
            return this.f14712a == ((C4336g) obj).f14712a;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f14712a) * 31) + 1520230490;
    }
}
