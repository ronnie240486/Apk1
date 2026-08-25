package androidx.media3.exoplayer;

import android.util.Pair;

public final class RunnableC0851r0 implements Runnable {

    public final int f2941a;

    public final MediaSourceList.ForwardingEventListener f2942b;

    public final Pair f2943c;

    public RunnableC0851r0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, int i6) {
        this.f2941a = i6;
        this.f2942b = forwardingEventListener;
        this.f2943c = pair;
    }

    @Override
    public final void run() {
        switch (this.f2941a) {
            case 0:
                this.f2942b.lambda$onDrmKeysRemoved$10(this.f2943c);
                break;
            case 1:
                this.f2942b.lambda$onDrmKeysRestored$9(this.f2943c);
                break;
            case 2:
                this.f2942b.lambda$onDrmSessionReleased$11(this.f2943c);
                break;
            default:
                this.f2942b.lambda$onDrmKeysLoaded$7(this.f2943c);
                break;
        }
    }
}
