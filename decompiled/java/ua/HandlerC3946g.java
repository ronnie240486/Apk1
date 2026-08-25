package ua;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.fragment.app.C0423q;
import p124l6.C2982h;

public final class HandlerC3946g extends Handler {

    public final C2982h f13268a;

    public final int f13269b;

    public final C3944e f13270c;

    public boolean f13271d;

    public HandlerC3946g(C3944e c3944e, Looper looper) {
        super(looper);
        this.f13270c = c3944e;
        this.f13269b = 10;
        this.f13268a = new C2982h(11);
    }

    public final void m7875a(C3953n c3953n, Object obj) {
        C3948i c3948iM7877a = C3948i.m7877a(c3953n, obj);
        synchronized (this) {
            try {
                this.f13268a.m6043p(c3948iM7877a);
                if (!this.f13271d) {
                    this.f13271d = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new C0423q("Could not send handler message", 9);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                C3948i c3948iM6049v = this.f13268a.m6049v();
                if (c3948iM6049v == null) {
                    synchronized (this) {
                        c3948iM6049v = this.f13268a.m6049v();
                        if (c3948iM6049v == null) {
                            this.f13271d = false;
                            return;
                        }
                    }
                }
                this.f13270c.m7868c(c3948iM6049v);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f13269b);
            if (!sendMessage(obtainMessage())) {
                throw new C0423q("Could not send handler message", 9);
            }
            this.f13271d = true;
        } catch (Throwable th) {
            this.f13271d = false;
            throw th;
        }
    }
}
