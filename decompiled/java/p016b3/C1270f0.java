package p016b3;

import java.io.File;
import p175q3.C3470d;
import p228v2.C3981h;

public final class C1270f0 implements InterfaceC1288u {

    public static final C1270f0 f4014b = new C1270f0(0);

    public final int f4015a;

    public C1270f0(int i6) {
        this.f4015a = i6;
    }

    @Override
    public final C1287t mo3137a(Object obj, int i6, int i10, C3981h c3981h) {
        switch (this.f4015a) {
            case 0:
                return new C1287t(new C3470d(obj), new C1267e(1, obj));
            case 1:
                File file = (File) obj;
                return new C1287t(new C3470d(file), new C1267e(0, file));
            default:
                return null;
        }
    }

    @Override
    public final boolean mo3138b(Object obj) {
        switch (this.f4015a) {
            case 0:
                return true;
            case 1:
                return true;
            default:
                return false;
        }
    }
}
