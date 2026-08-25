package p020b7;

import java.io.Serializable;
import java.util.Arrays;
import p249x4.C4112e;

public final class C1345h0 implements InterfaceC1339e0, Serializable {

    public final C4112e f4165a;

    public C1345h0(C4112e c4112e) {
        this.f4165a = c4112e;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1345h0) {
            return AbstractC1332b.m3225p(this.f4165a, ((C1345h0) obj).f4165a);
        }
        return false;
    }

    @Override
    public final Object get() {
        return this.f4165a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4165a});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.f4165a + ")";
    }
}
