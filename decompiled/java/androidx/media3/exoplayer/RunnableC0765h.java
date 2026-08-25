package androidx.media3.exoplayer;

import android.content.Context;

public final class RunnableC0765h implements Runnable {

    public final int f2851a;

    public final Object f2852b;

    public final Object f2853c;

    public RunnableC0765h(Object obj, int i6, Object obj2) {
        this.f2851a = i6;
        this.f2853c = obj;
        this.f2852b = obj2;
    }

    @Override
    public final void run() {
        switch (this.f2851a) {
            case 0:
                ((DefaultSuitableOutputChecker.ImplApi23) this.f2853c).lambda$enable$1((Context) this.f2852b);
                break;
            case 1:
                ((DefaultSuitableOutputChecker.ImplApi35) this.f2853c).lambda$enable$1((Context) this.f2852b);
                break;
            case 2:
                ((ExoPlayerImpl) this.f2853c).lambda$new$1((ExoPlayerImplInternal.PlaybackInfoUpdate) this.f2852b);
                break;
            default:
                ((ExoPlayerImplInternal) this.f2853c).lambda$sendMessageToTargetThread$2((PlayerMessage) this.f2852b);
                break;
        }
    }
}
