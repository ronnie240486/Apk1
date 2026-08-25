package p049e3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.concurrent.locks.Lock;
import p259y2.InterfaceC4238a;

public abstract class AbstractC2400r {

    public static final C2399q f8377a = new C2399q(10);

    public static C2383d m5435a(InterfaceC4238a interfaceC4238a, Drawable drawable, int i6, int i10) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z7 = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            if (i6 != Integer.MIN_VALUE || current.getIntrinsicWidth() > 0) {
                if (i10 != Integer.MIN_VALUE || current.getIntrinsicHeight() > 0) {
                    if (current.getIntrinsicWidth() > 0) {
                        i6 = current.getIntrinsicWidth();
                    }
                    if (current.getIntrinsicHeight() > 0) {
                        i10 = current.getIntrinsicHeight();
                    }
                    Lock lock = AbstractC2408z.f8398b;
                    lock.lock();
                    Bitmap bitmapMo6925e = interfaceC4238a.mo6925e(i6, i10, Bitmap.Config.ARGB_8888);
                    try {
                        Canvas canvas = new Canvas(bitmapMo6925e);
                        current.setBounds(0, 0, i6, i10);
                        current.draw(canvas);
                        canvas.setBitmap(null);
                        lock.unlock();
                        bitmap = bitmapMo6925e;
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                    Log.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                }
                z7 = true;
            } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            bitmap = null;
            z7 = true;
        }
        if (!z7) {
            interfaceC4238a = f8377a;
        }
        return C2383d.m5410b(bitmap, interfaceC4238a);
    }
}
