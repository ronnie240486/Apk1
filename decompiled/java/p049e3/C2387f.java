package p049e3;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;
import p002a1.C0026b;
import p228v2.C3981h;
import p228v2.InterfaceC3983j;
import p247x2.InterfaceC4102x;

public final class C2387f implements InterfaceC3983j {

    public final int f8340a;

    public final C2398p f8341b;

    public C2387f(C2398p c2398p, int i6) {
        this.f8340a = i6;
        this.f8341b = c2398p;
    }

    @Override
    public final InterfaceC4102x mo5398a(Object obj, int i6, int i10, C3981h c3981h) {
        switch (this.f8340a) {
            case 0:
                C2398p c2398p = this.f8341b;
                return c2398p.m5432a(new C0026b((ByteBuffer) obj, c2398p.f8375d, c2398p.f8374c, 17), i6, i10, c3981h, C2398p.f8370k);
            default:
                C2398p c2398p2 = this.f8341b;
                return c2398p2.m5432a(new C0026b((ParcelFileDescriptor) obj, c2398p2.f8375d, c2398p2.f8374c), i6, i10, c3981h, C2398p.f8370k);
        }
    }

    @Override
    public final boolean mo5399b(Object obj, C3981h c3981h) {
        switch (this.f8340a) {
            case 0:
                this.f8341b.getClass();
                return true;
            default:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
                String str = Build.MANUFACTURER;
                return (!("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912) && !"robolectric".equals(Build.FINGERPRINT);
        }
    }
}
