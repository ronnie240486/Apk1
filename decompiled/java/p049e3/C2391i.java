package p049e3;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.Log;
import java.security.MessageDigest;
import p228v2.InterfaceC3978e;
import p259y2.InterfaceC4238a;

public final class C2391i extends AbstractC2385e {

    public static final byte[] f8352b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(InterfaceC3978e.f13509a);

    @Override
    public final void mo3160a(MessageDigest messageDigest) {
        messageDigest.update(f8352b);
    }

    @Override
    public final Bitmap mo5411c(InterfaceC4238a interfaceC4238a, Bitmap bitmap, int i6, int i10) {
        Paint paint = AbstractC2408z.f8397a;
        if (bitmap.getWidth() > i6 || bitmap.getHeight() > i10) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return AbstractC2408z.m5443b(interfaceC4238a, bitmap, i6, i10);
        }
        if (!Log.isLoggable("TransformationUtils", 2)) {
            return bitmap;
        }
        Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        return bitmap;
    }

    @Override
    public final boolean equals(Object obj) {
        return obj instanceof C2391i;
    }

    @Override
    public final int hashCode() {
        return -670243078;
    }
}
