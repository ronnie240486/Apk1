package p258y1;

import android.os.Build;

public abstract class AbstractC4204d0 {

    public static final boolean f14289a;

    public static final boolean f14290b;

    public static final boolean f14291c;

    static {
        int i6 = Build.VERSION.SDK_INT;
        f14289a = true;
        f14290b = true;
        f14291c = i6 >= 28;
    }
}
