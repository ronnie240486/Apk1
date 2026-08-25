package p269z2;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import p187r4.C3624n;

public final class C4305f {

    public static final int f14603e;

    public final Context f14604a;

    public final ActivityManager f14605b;

    public final C3624n f14606c;

    public final float f14607d;

    static {
        f14603e = Build.VERSION.SDK_INT < 26 ? 4 : 1;
    }

    public C4305f(Context context) {
        this.f14607d = f14603e;
        this.f14604a = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.f14605b = activityManager;
        this.f14606c = new C3624n(12, context.getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT < 26 || !activityManager.isLowRamDevice()) {
            return;
        }
        this.f14607d = 0.0f;
    }
}
