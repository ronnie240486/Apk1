package p014b1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000a.RunnableC0001b;
import p003a2.AbstractC0032a;
import p025c2.C1381b;
import p028c6.C1399b;
import p055ea.AbstractC2460q;
import p106k0.AbstractC2854b;
import p106k0.C2859g;
import p249x4.C4112e;

public final class C1241o implements InterfaceC1234h {

    public final Context f3947a;

    public final C1381b f3948b;

    public final C4112e f3949c;

    public final Object f3950d;

    public Handler f3951e;

    public ThreadPoolExecutor f3952f;

    public ThreadPoolExecutor f3953g;

    public AbstractC0032a f3954h;

    public C1241o(Context context, C1381b c1381b) {
        C4112e c4112e = C1242p.f3955d;
        this.f3950d = new Object();
        AbstractC0032a.m162p(context, "Context cannot be null");
        this.f3947a = context.getApplicationContext();
        this.f3948b = c1381b;
        this.f3949c = c4112e;
    }

    @Override
    public final void mo204a(AbstractC0032a abstractC0032a) {
        synchronized (this.f3950d) {
            this.f3954h = abstractC0032a;
        }
        m3121c();
    }

    public final void m3120b() {
        synchronized (this.f3950d) {
            try {
                this.f3954h = null;
                Handler handler = this.f3951e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f3951e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f3953g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f3952f = null;
                this.f3953g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m3121c() {
        synchronized (this.f3950d) {
            try {
                if (this.f3954h == null) {
                    return;
                }
                if (this.f3952f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC1227a("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f3953g = threadPoolExecutor;
                    this.f3952f = threadPoolExecutor;
                }
                this.f3952f.execute(new RunnableC0001b(8, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final C2859g m3122d() {
        try {
            C4112e c4112e = this.f3949c;
            Context context = this.f3947a;
            C1381b c1381b = this.f3948b;
            c4112e.getClass();
            C1399b c1399bM5858a = AbstractC2854b.m5858a(context, c1381b);
            int i6 = c1399bM5858a.f4261a;
            if (i6 != 0) {
                throw new RuntimeException(AbstractC2460q.m5492f(i6, "fetchFonts failed (", ")"));
            }
            C2859g[] c2859gArr = (C2859g[]) c1399bM5858a.f4262b;
            if (c2859gArr == null || c2859gArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return c2859gArr[0];
        } catch (PackageManager.NameNotFoundException e5) {
            throw new RuntimeException("provider not found", e5);
        }
    }
}
