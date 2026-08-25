package p081h8;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import p090i8.AbstractC2712f;

public abstract class AbstractC2670a {

    public static final C2674e f9297a;

    static {
        Looper mainLooper = Looper.getMainLooper();
        AbstractC2712f abstractC2712f = AbstractC2671b.f9298a;
        boolean z7 = true;
        if (Build.VERSION.SDK_INT < 22) {
            Message messageObtain = Message.obtain();
            try {
                messageObtain.setAsynchronous(true);
            } catch (NoSuchMethodError unused) {
                z7 = false;
            }
            messageObtain.recycle();
        }
        f9297a = new C2674e(new Handler(mainLooper), z7);
    }
}
