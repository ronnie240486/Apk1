package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.DecoderCounters;

public final class RunnableC0989l implements Runnable {

    public final int f3065a;

    public final VideoRendererEventListener.EventDispatcher f3066b;

    public final DecoderCounters f3067c;

    public RunnableC0989l(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters, int i6) {
        this.f3065a = i6;
        this.f3066b = eventDispatcher;
        this.f3067c = decoderCounters;
    }

    @Override
    public final void run() {
        switch (this.f3065a) {
            case 0:
                this.f3066b.lambda$enabled$0(this.f3067c);
                break;
            default:
                this.f3066b.lambda$disabled$8(this.f3067c);
                break;
        }
    }
}
