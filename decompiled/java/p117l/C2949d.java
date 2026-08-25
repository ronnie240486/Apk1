package p117l;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p123l5.AbstractC2973a;

public final class C2949d extends AbstractC2973a {

    public final Object f10118r = new Object();

    public final ExecutorService f10119s = Executors.newFixedThreadPool(4, new ThreadFactoryC2947b(0));

    public volatile Handler f10120t;

    public static Handler m5970V(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return AbstractC2948c.m5969a(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }
}
