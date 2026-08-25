package p224u9;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import p103j9.AbstractC2796i;
import p156o9.AbstractC3280d;
import p243w8.C4065g;

public abstract class AbstractC3939d {
    private static volatile Choreographer choreographer;

    static {
        Object objM6588f;
        try {
            objM6588f = new C3938c(m7863a(Looper.getMainLooper()));
        } catch (Throwable th) {
            objM6588f = AbstractC3280d.m6588f(th);
        }
        if (objM6588f instanceof C4065g) {
            objM6588f = null;
        }
    }

    public static final Handler m7863a(Looper looper) throws IllegalAccessException, InvocationTargetException {
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        AbstractC2796i.m5783d(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }
}
