package p041d7;

import java.io.Serializable;
import java.util.ArrayList;
import p020b7.InterfaceC1339e0;

public final class C2277q4 implements InterfaceC1339e0, Serializable {

    public final int f8031a;

    public final int f8032b;

    public C2277q4(int i6) {
        this.f8031a = i6;
        switch (i6) {
            case 1:
                AbstractC2182d0.m5141d(2, "expectedValuesPerKey");
                this.f8032b = 2;
                break;
            default:
                AbstractC2182d0.m5141d(2, "expectedValuesPerKey");
                this.f8032b = 2;
                break;
        }
    }

    @Override
    public final Object get() {
        switch (this.f8031a) {
            case 0:
                return new ArrayList(this.f8032b);
            default:
                return C2231k0.m5226d(this.f8032b);
        }
    }
}
