package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.DecoderCounters;

public final class RunnableC0719c implements Runnable {

    public final int f2770a;

    public final AudioRendererEventListener.EventDispatcher f2771b;

    public final DecoderCounters f2772c;

    public RunnableC0719c(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters, int i6) {
        this.f2770a = i6;
        this.f2771b = eventDispatcher;
        this.f2772c = decoderCounters;
    }

    @Override
    public final void run() {
        switch (this.f2770a) {
            case 0:
                this.f2771b.lambda$enabled$0(this.f2772c);
                break;
            default:
                this.f2771b.lambda$disabled$6(this.f2772c);
                break;
        }
    }
}
