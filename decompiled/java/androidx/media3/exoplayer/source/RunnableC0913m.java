package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Consumer;
import androidx.media3.extractor.SeekMap;

public final class RunnableC0913m implements Runnable {

    public final int f2993a;

    public final Object f2994b;

    public final Object f2995c;

    public RunnableC0913m(Object obj, int i6, Object obj2) {
        this.f2993a = i6;
        this.f2994b = obj;
        this.f2995c = obj2;
    }

    @Override
    public final void run() {
        switch (this.f2993a) {
            case 0:
                ((ProgressiveMediaPeriod) this.f2994b).lambda$seekMap$1((SeekMap) this.f2995c);
                break;
            default:
                ((Consumer) this.f2994b).accept((MediaSourceEventListener) this.f2995c);
                break;
        }
    }
}
