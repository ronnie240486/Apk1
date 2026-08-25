package p016b3;

import java.io.File;
import p175q3.C3470d;
import p228v2.C3981h;

public final class C1265d implements InterfaceC1288u {

    public final int f4002a;

    public final Object f4003b;

    public C1265d(int i6, Object obj) {
        this.f4002a = i6;
        this.f4003b = obj;
    }

    @Override
    public final C1287t mo3137a(Object obj, int i6, int i10, C3981h c3981h) {
        switch (this.f4002a) {
            case 0:
                byte[] bArr = (byte[]) obj;
                return new C1287t(new C3470d(bArr), new C1283p(bArr, 1, (C1263c) this.f4003b));
            case 1:
                return new C1287t(new C3470d(obj), new C1269f(0, obj.toString(), (C1263c) this.f4003b));
            default:
                File file = (File) obj;
                return new C1287t(new C3470d(file), new C1269f(1, file, (C1263c) this.f4003b));
        }
    }

    @Override
    public final boolean mo3138b(Object obj) {
        switch (this.f4002a) {
            case 0:
                return true;
            case 1:
                return obj.toString().startsWith("data:image");
            default:
                return true;
        }
    }
}
