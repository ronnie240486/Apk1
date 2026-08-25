package p094j0;

import android.os.Trace;

public abstract class AbstractC2765m {
    public static void m5736a(String str, int i6) {
        Trace.beginAsyncSection(str, i6);
    }

    public static void m5737b(String str, int i6) {
        Trace.endAsyncSection(str, i6);
    }

    public static boolean m5738c() {
        return Trace.isEnabled();
    }

    public static void m5739d(String str, long j10) {
        Trace.setCounter(str, j10);
    }
}
