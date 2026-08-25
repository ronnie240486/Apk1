package p014b1;

import android.os.Trace;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.mars.xlog.Log;
import io.binstream.libtvcar.Libtvcar;
import java.lang.reflect.Method;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p094j0.AbstractC2766n;
import p193ra.C3663f;

public final class RunnableC1238l implements Runnable {

    public final int f3936a;

    public RunnableC1238l(int i6) {
        this.f3936a = i6;
    }

    @Override
    public final void run() {
        boolean z7 = true;
        switch (this.f3936a) {
            case 0:
                try {
                    Method method = AbstractC2766n.f9481b;
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (C1235i.f3923j == null) {
                        z7 = false;
                    }
                    if (z7) {
                        C1235i.m3106a().m3108c();
                        break;
                    }
                    return;
                } finally {
                    Method method2 = AbstractC2766n.f9481b;
                    Trace.endSection();
                }
            case 1:
                NativeCrashHandler.getInstance().unBlockSigquit(true);
                return;
            case 2:
                NativeCrashHandler.getInstance().unBlockSigquit(false);
                return;
            case 3:
                C3663f c3663fM7415b = C3663f.m7415b();
                if (!c3663fM7415b.m7417c() || c3663fM7415b.f12273f >= c3663fM7415b.f12272e.getSources().size()) {
                    return;
                }
                c3663fM7415b.f12270c.put(String.valueOf(c3663fM7415b.f12272e.getChid()), c3663fM7415b.f12272e.getSources().get(c3663fM7415b.f12273f).getSubTitle());
                return;
            case 4:
                String strM165s = AbstractC0032a.m165s("D8vhytbpzbYt9MHO\n", "W52iq6S6qMQ=\n");
                String strM165s2 = AbstractC0032a.m165s("phFLTIIWV9qXRV5IlVdJk4cQRB6aWVTD\n", "9WUqPvY2O7M=\n");
                boolean z10 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s, strM165s2);
                Libtvcar.run();
                return;
            case 5:
                return;
            case 6:
                AbstractC3331m.f11244b = false;
                return;
            default:
                AbstractC3331m.f11244b = false;
                return;
        }
    }

    public String toString() {
        switch (this.f3936a) {
            case 5:
                return "EmptyRunnable";
            default:
                return super.toString();
        }
    }

    private final void m3112a() {
    }
}
