package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.source.preload.PreloadMediaSource;

public final class RunnableC0720d implements Runnable {

    public final int f2773a;

    public final long f2774b;

    public final Object f2775c;

    public RunnableC0720d(Object obj, long j10, int i6) {
        this.f2773a = i6;
        this.f2775c = obj;
        this.f2774b = j10;
    }

    @Override
    public final void run() {
        switch (this.f2773a) {
            case 0:
                ((AudioRendererEventListener.EventDispatcher) this.f2775c).lambda$positionAdvancing$3(this.f2774b);
                break;
            default:
                ((PreloadMediaSource) this.f2775c).lambda$preload$0(this.f2774b);
                break;
        }
    }
}
