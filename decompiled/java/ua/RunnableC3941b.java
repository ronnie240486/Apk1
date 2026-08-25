package ua;

import android.util.Log;
import p124l6.C2982h;

public final class RunnableC3941b implements Runnable {

    public final C2982h f13241a = new C2982h(11);

    public final C3944e f13242b;

    public volatile boolean f13243c;

    public RunnableC3941b(C3944e c3944e) {
        this.f13242b = c3944e;
    }

    @Override
    public final void run() {
        while (true) {
            try {
                try {
                    C3948i c3948iM6050w = this.f13241a.m6050w();
                    if (c3948iM6050w == null) {
                        synchronized (this) {
                            c3948iM6050w = this.f13241a.m6049v();
                            if (c3948iM6050w == null) {
                                this.f13243c = false;
                                this.f13243c = false;
                                return;
                            }
                        }
                    }
                    this.f13242b.m7868c(c3948iM6050w);
                } catch (InterruptedException e5) {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e5);
                    this.f13243c = false;
                    return;
                }
            } catch (Throwable th) {
                this.f13243c = false;
                throw th;
            }
        }
    }
}
