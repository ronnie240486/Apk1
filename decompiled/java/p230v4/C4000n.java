package p230v4;

import android.os.Looper;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.Locale;
import p018b5.AbstractC1312l;
import p173q1.RunnableC3431n1;

public final class C4000n {

    public static final Object f13548i = new Object();

    public final C3988b f13549a;

    public final long f13550b;

    public final String f13551c;

    public InterfaceC3999m f13555g;

    public RunnableC3431n1 f13556h;

    public long f13553e = -1;

    public long f13554f = 0;

    public final HandlerC1731y0 f13552d = new HandlerC1731y0(Looper.getMainLooper(), 0);

    public C4000n(long j10, String str) {
        this.f13550b = j10;
        this.f13551c = str;
        this.f13549a = new C3988b("RequestTracker", str);
    }

    public final void m7992a(long j10, InterfaceC3999m interfaceC3999m) {
        InterfaceC3999m interfaceC3999m2;
        long j11;
        long j12;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Object obj = f13548i;
        synchronized (obj) {
            interfaceC3999m2 = this.f13555g;
            j11 = this.f13553e;
            j12 = this.f13554f;
            this.f13553e = j10;
            this.f13555g = interfaceC3999m;
            this.f13554f = jCurrentTimeMillis;
        }
        if (interfaceC3999m2 != null) {
            interfaceC3999m2.mo7339d(this.f13551c, j11, j12, jCurrentTimeMillis);
        }
        synchronized (obj) {
            try {
                RunnableC3431n1 runnableC3431n1 = this.f13556h;
                if (runnableC3431n1 != null) {
                    this.f13552d.removeCallbacks(runnableC3431n1);
                }
                RunnableC3431n1 runnableC3431n2 = new RunnableC3431n1(4, this);
                this.f13556h = runnableC3431n2;
                this.f13552d.postDelayed(runnableC3431n2, this.f13550b);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m7993b(long j10, int i6, C3997k c3997k) {
        synchronized (f13548i) {
            try {
                if (m7994c(j10)) {
                    Locale locale = Locale.ROOT;
                    m7996e(i6, c3997k, "request " + j10 + " completed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean m7994c(long j10) {
        boolean z7;
        synchronized (f13548i) {
            long j11 = this.f13553e;
            z7 = false;
            if (j11 != -1 && j11 == j10) {
                z7 = true;
            }
        }
        return z7;
    }

    public final boolean m7995d() {
        boolean z7;
        synchronized (f13548i) {
            z7 = this.f13553e != -1;
        }
        return z7;
    }

    public final void m7996e(int i6, C3997k c3997k, String str) {
        this.f13549a.m7975b(str, new Object[0]);
        Object obj = f13548i;
        synchronized (obj) {
            try {
                if (this.f13555g != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    InterfaceC3999m interfaceC3999m = this.f13555g;
                    AbstractC1312l.m3198e(interfaceC3999m);
                    interfaceC3999m.mo7338c(this.f13551c, this.f13553e, i6, c3997k, this.f13554f, jCurrentTimeMillis);
                }
                this.f13553e = -1L;
                this.f13555g = null;
                synchronized (obj) {
                    try {
                        RunnableC3431n1 runnableC3431n1 = this.f13556h;
                        if (runnableC3431n1 != null) {
                            this.f13552d.removeCallbacks(runnableC3431n1);
                            this.f13556h = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean m7997f(int i6) {
        synchronized (f13548i) {
            try {
                if (!m7995d()) {
                    return false;
                }
                Locale locale = Locale.ROOT;
                m7996e(i6, null, "clearing request " + this.f13553e);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
