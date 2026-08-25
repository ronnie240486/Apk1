package p081h8;

import android.os.Handler;
import com.bumptech.glide.AbstractC1466d;
import p102j8.InterfaceC2787b;

public final class RunnableC2673d implements Runnable, InterfaceC2787b {

    public final Handler f9302a;

    public final Runnable f9303b;

    public RunnableC2673d(Handler handler, Runnable runnable) {
        this.f9302a = handler;
        this.f9303b = runnable;
    }

    @Override
    public final void mo5675a() {
        this.f9302a.removeCallbacks(this);
    }

    @Override
    public final void run() {
        try {
            this.f9303b.run();
        } catch (Throwable th) {
            AbstractC1466d.m3505y(th);
        }
    }
}
