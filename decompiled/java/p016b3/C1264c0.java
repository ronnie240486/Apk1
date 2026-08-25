package p016b3;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import java.io.InputStream;

public final class C1264c0 implements InterfaceC1289v {

    public final int f4000a;

    public final Resources f4001b;

    public C1264c0(Resources resources, int i6) {
        this.f4000a = i6;
        this.f4001b = resources;
    }

    @Override
    public final InterfaceC1288u mo3136a(C1262b0 c1262b0) {
        switch (this.f4000a) {
            case 0:
                return new C1261b(this.f4001b, c1262b0.m3140b(Uri.class, AssetFileDescriptor.class));
            case 1:
                return new C1261b(this.f4001b, c1262b0.m3140b(Uri.class, InputStream.class));
            default:
                return new C1261b(this.f4001b, C1270f0.f4014b);
        }
    }
}
