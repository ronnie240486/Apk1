package androidx.media3.exoplayer.source.preload;

import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.source.MediaPeriod;

public final class RunnableC0931j implements Runnable {

    public final int f3012a;

    public final Object f3013b;

    public final Object f3014c;

    public RunnableC0931j(Object obj, int i6, Object obj2) {
        this.f3012a = i6;
        this.f3013b = obj;
        this.f3014c = obj2;
    }

    @Override
    public final void run() {
        switch (this.f3012a) {
            case 0:
                ((PreloadMediaSource.PreloadMediaPeriodCallback) this.f3013b).lambda$onPrepared$0((MediaPeriod) this.f3014c);
                break;
            case 1:
                ((PreloadMediaSource.PreloadMediaPeriodCallback) this.f3013b).lambda$onContinueLoadingRequested$1((MediaPeriod) this.f3014c);
                break;
            default:
                ((PreloadMediaSource) this.f3013b).lambda$onChildSourceInfoRefreshed$2((Timeline) this.f3014c);
                break;
        }
    }
}
