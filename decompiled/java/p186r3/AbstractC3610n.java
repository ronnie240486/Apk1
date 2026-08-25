package p186r3;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractC3610n {

    public static final char[] f12112a = "0123456789abcdef".toCharArray();

    public static final char[] f12113b = new char[64];

    public static volatile Handler f12114c;

    public static void m7233a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean m7234b(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static int m7235c(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int m7236d(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i6 = AbstractC3609m.f12111a[config.ordinal()];
        if (i6 == 1) {
            return 1;
        }
        if (i6 == 2 || i6 == 3) {
            return 2;
        }
        return i6 != 4 ? 4 : 8;
    }

    public static ArrayList m7237e(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object obj : collection) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Handler m7238f() {
        if (f12114c == null) {
            synchronized (AbstractC3610n.class) {
                try {
                    if (f12114c == null) {
                        f12114c = new Handler(Looper.getMainLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12114c;
    }

    public static int m7239g(int i6, int i10) {
        return (i10 * 31) + i6;
    }

    public static int m7240h(int i6, Object obj) {
        return m7239g(obj == null ? 0 : obj.hashCode(), i6);
    }

    public static boolean m7241i(int i6, int i10) {
        return (i6 > 0 || i6 == Integer.MIN_VALUE) && (i10 > 0 || i10 == Integer.MIN_VALUE);
    }

    public static void m7242j(Runnable runnable) {
        m7238f().post(runnable);
    }
}
