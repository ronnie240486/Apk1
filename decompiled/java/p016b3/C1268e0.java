package p016b3;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public final class C1268e0 implements InterfaceC1289v {

    public static final C1268e0 f4008b = new C1268e0(0);

    public final int f4009a;

    public C1268e0(int i6) {
        this.f4009a = i6;
    }

    @Override
    public final InterfaceC1288u mo3136a(C1262b0 c1262b0) {
        switch (this.f4009a) {
            case 0:
                return C1270f0.f4014b;
            case 1:
                return new C1265d(0, new C1263c(0));
            case 2:
                return new C1265d(0, new C1263c(1));
            case 3:
                return new C1270f0(1);
            case 4:
                return new C1266d0(c1262b0.m3140b(Uri.class, AssetFileDescriptor.class), 0);
            case 5:
                return new C1266d0(c1262b0.m3140b(Uri.class, ParcelFileDescriptor.class), 0);
            case 6:
                return new C1266d0(c1262b0.m3140b(Uri.class, InputStream.class), 0);
            default:
                return new C1276i0(c1262b0.m3140b(C1278k.class, InputStream.class));
        }
    }
}
