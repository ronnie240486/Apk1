package p049e3;

import android.graphics.Bitmap;
import java.security.MessageDigest;
import p228v2.InterfaceC3978e;
import p259y2.InterfaceC4238a;

public final class C2403u extends AbstractC2385e {

    public static final byte[] f8380b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(InterfaceC3978e.f13509a);

    @Override
    public final void mo3160a(MessageDigest messageDigest) {
        messageDigest.update(f8380b);
    }

    @Override
    public final Bitmap mo5411c(InterfaceC4238a interfaceC4238a, Bitmap bitmap, int i6, int i10) {
        return AbstractC2408z.m5443b(interfaceC4238a, bitmap, i6, i10);
    }

    @Override
    public final boolean equals(Object obj) {
        return obj instanceof C2403u;
    }

    @Override
    public final int hashCode() {
        return 1572326941;
    }
}
