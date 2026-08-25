package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final class RunnableC0725i implements Runnable {

    public final int f2788a;

    public final String f2789b;

    public final long f2790c;

    public final long f2791d;

    public final Object f2792e;

    public RunnableC0725i(Object obj, String str, long j10, long j11, int i6) {
        this.f2788a = i6;
        this.f2792e = obj;
        this.f2789b = str;
        this.f2790c = j10;
        this.f2791d = j11;
    }

    @Override
    public final void run() {
        switch (this.f2788a) {
            case 0:
                ((AudioRendererEventListener.EventDispatcher) this.f2792e).lambda$decoderInitialized$1(this.f2789b, this.f2790c, this.f2791d);
                break;
            default:
                ((VideoRendererEventListener.EventDispatcher) this.f2792e).lambda$decoderInitialized$1(this.f2789b, this.f2790c, this.f2791d);
                break;
        }
    }
}
