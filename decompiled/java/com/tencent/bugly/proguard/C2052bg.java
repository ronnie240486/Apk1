package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public final class C2052bg extends Thread {

    public RunnableC2051bf f7470a;

    private a f7476g;

    private boolean f7472c = false;

    private boolean f7473d = true;

    private boolean f7474e = false;

    private int f7475f = 1;

    public boolean f7471b = true;

    public interface a {
    }

    public final boolean m4844a() {
        this.f7472c = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e5) {
            C2029al.m4643b(e5);
        }
        C2029al.m4645d("MainHandlerChecker is reset to null.", new Object[0]);
        this.f7470a = null;
        return true;
    }

    public final boolean m4845b() {
        Handler handler = new Handler(Looper.getMainLooper());
        RunnableC2051bf runnableC2051bf = this.f7470a;
        if (runnableC2051bf != null) {
            runnableC2051bf.f7464b = 5000L;
        } else {
            this.f7470a = new RunnableC2051bf(handler, handler.getLooper().getThread().getName());
        }
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e5) {
            C2029al.m4643b(e5);
            return false;
        }
    }

    public final synchronized void m4846c() {
        this.f7473d = false;
        C2029al.m4644c("Record stack trace is disabled.", new Object[0]);
    }

    public final synchronized void m4847d() {
        this.f7474e = true;
    }

    @Override
    public final void run() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (!this.f7472c) {
            try {
                RunnableC2051bf runnableC2051bf = this.f7470a;
                boolean z7 = false;
                if (runnableC2051bf == null) {
                    C2029al.m4644c("Main handler checker is null. Stop thread monitor.", new Object[0]);
                    return;
                }
                if (runnableC2051bf.f7465c) {
                    runnableC2051bf.f7465c = false;
                    runnableC2051bf.f7466d = SystemClock.uptimeMillis();
                    runnableC2051bf.f7463a.post(runnableC2051bf);
                }
                m4843a(runnableC2051bf);
                if (this.f7471b && this.f7473d) {
                    long jM4840b = runnableC2051bf.m4840b();
                    if (jM4840b > 1510 && jM4840b < 199990) {
                        boolean z10 = true;
                        if (jM4840b <= 5010) {
                            this.f7475f = 1;
                            C2029al.m4644c("timeSinceMsgSent in [2s, 5s], record stack", new Object[0]);
                            z7 = true;
                        } else {
                            int i6 = this.f7475f;
                            int i10 = i6 + 1;
                            this.f7475f = i10;
                            if ((i6 & i10) != 0) {
                                z10 = false;
                            }
                            if (z10) {
                                C2029al.m4644c("timeSinceMsgSent in (5s, 200s), should record stack:true", new Object[0]);
                            }
                            z7 = z10;
                        }
                    }
                }
                if (z7) {
                    runnableC2051bf.m4842d();
                }
                if (this.f7476g != null && this.f7473d) {
                    runnableC2051bf.m4839a();
                    runnableC2051bf.m4840b();
                }
                C2033ap.m4699b(500 - ((System.currentTimeMillis() - jCurrentTimeMillis) % 500));
            } catch (Exception e5) {
                C2029al.m4643b(e5);
            } catch (OutOfMemoryError e10) {
                C2029al.m4643b(e10);
            }
        }
    }

    private synchronized void m4843a(RunnableC2051bf runnableC2051bf) {
        if (this.f7473d) {
            return;
        }
        if (this.f7474e && !runnableC2051bf.m4839a()) {
            C2029al.m4644c("Restart getting main stack trace.", new Object[0]);
            this.f7473d = true;
            this.f7474e = false;
        }
    }
}
