package p049e3;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.security.MessageDigest;
import p228v2.InterfaceC3978e;
import p259y2.InterfaceC4238a;

public final class C2390h extends AbstractC2385e {

    public static final byte[] f8351b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(InterfaceC3978e.f13509a);

    @Override
    public final void mo3160a(MessageDigest messageDigest) {
        messageDigest.update(f8351b);
    }

    @Override
    public final Bitmap mo5411c(InterfaceC4238a interfaceC4238a, Bitmap bitmap, int i6, int i10) {
        float width;
        float height;
        Paint paint = AbstractC2408z.f8397a;
        if (bitmap.getWidth() == i6 && bitmap.getHeight() == i10) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap.getWidth() * i10 > bitmap.getHeight() * i6) {
            width = i10 / bitmap.getHeight();
            width2 = (i6 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i6 / bitmap.getWidth();
            height = (i10 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapMo6925e = interfaceC4238a.mo6925e(i6, i10, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        bitmapMo6925e.setHasAlpha(bitmap.hasAlpha());
        AbstractC2408z.m5442a(bitmap, bitmapMo6925e, matrix);
        return bitmapMo6925e;
    }

    @Override
    public final boolean equals(Object obj) {
        return obj instanceof C2390h;
    }

    @Override
    public final int hashCode() {
        return -599754482;
    }
}
