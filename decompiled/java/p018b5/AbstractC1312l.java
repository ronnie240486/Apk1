package p018b5;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

public abstract class AbstractC1312l {

    public static final Object f4098a = new Object();

    public static boolean f4099b;

    public static int f4100c;

    public static void m3194a(Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            throw new IllegalStateException("Must be called on " + handler.getLooper().getThread().getName() + " thread, but got " + name + ".");
        }
    }

    public static void m3195b(String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static void m3196c(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
    }

    public static void m3197d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void m3198e(Object obj) {
        if (obj == null) {
            throw new NullPointerException("null reference");
        }
    }

    public static void m3199f(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void m3200g(String str, boolean z7) {
        if (!z7) {
            throw new IllegalStateException(str);
        }
    }

    public static boolean m3201h(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
