package p049e3;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.concurrent.locks.Lock;
import p186r3.AbstractC3602f;
import p186r3.AbstractC3610n;
import p228v2.InterfaceC3978e;
import p259y2.InterfaceC4238a;

public final class C2406x extends AbstractC2385e {

    public static final byte[] f8395c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(InterfaceC3978e.f13509a);

    public final int f8396b;

    public C2406x(int i6) {
        AbstractC3602f.m7223a("roundingRadius must be greater than 0.", i6 > 0);
        this.f8396b = i6;
    }

    @Override
    public final void mo3160a(MessageDigest messageDigest) {
        messageDigest.update(f8395c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f8396b).array());
    }

    @Override
    public final Bitmap mo5411c(InterfaceC4238a interfaceC4238a, Bitmap bitmap, int i6, int i10) {
        Bitmap bitmapMo6925e;
        Paint paint = AbstractC2408z.f8397a;
        int i11 = this.f8396b;
        AbstractC3602f.m7223a("roundingRadius must be greater than 0.", i11 > 0);
        Bitmap.Config configM5444c = AbstractC2408z.m5444c(bitmap);
        Bitmap.Config configM5444c2 = AbstractC2408z.m5444c(bitmap);
        if (configM5444c2.equals(bitmap.getConfig())) {
            bitmapMo6925e = bitmap;
        } else {
            bitmapMo6925e = interfaceC4238a.mo6925e(bitmap.getWidth(), bitmap.getHeight(), configM5444c2);
            new Canvas(bitmapMo6925e).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        Bitmap bitmapMo6925e2 = interfaceC4238a.mo6925e(bitmapMo6925e.getWidth(), bitmapMo6925e.getHeight(), configM5444c);
        bitmapMo6925e2.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapMo6925e, tileMode, tileMode);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, bitmapMo6925e2.getWidth(), bitmapMo6925e2.getHeight());
        Lock lock = AbstractC2408z.f8398b;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapMo6925e2);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            float f = i11;
            canvas.drawRoundRect(rectF, f, f, paint2);
            canvas.setBitmap(null);
            lock.unlock();
            if (!bitmapMo6925e.equals(bitmap)) {
                interfaceC4238a.mo5434f(bitmapMo6925e);
            }
            return bitmapMo6925e2;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    @Override
    public final boolean equals(Object obj) {
        return (obj instanceof C2406x) && this.f8396b == ((C2406x) obj).f8396b;
    }

    @Override
    public final int hashCode() {
        return AbstractC3610n.m7239g(-569625254, AbstractC3610n.m7239g(this.f8396b, 17));
    }
}
