package p094j0;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

public abstract class AbstractC2766n {

    public static final long f9480a;

    public static final Method f9481b;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f9480a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f9481b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e5) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e5);
            }
        }
    }

    public static boolean m5740a() {
        if (Build.VERSION.SDK_INT >= 29) {
            return AbstractC2765m.m5738c();
        }
        try {
            return ((Boolean) f9481b.invoke(null, Long.valueOf(f9480a))).booleanValue();
        } catch (Exception unused) {
            Log.v("TraceCompat", "Unable to invoke isTagEnabled() via reflection.");
            return false;
        }
    }
}
