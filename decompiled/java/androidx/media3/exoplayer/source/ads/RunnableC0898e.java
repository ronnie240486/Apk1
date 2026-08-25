package androidx.media3.exoplayer.source.ads;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.source.MediaSource;

public final class RunnableC0898e implements Runnable {

    public final int f2974a;

    public final Object f2975b;

    public final Object f2976c;

    public RunnableC0898e(Object obj, int i6, Object obj2) {
        this.f2974a = i6;
        this.f2975b = obj;
        this.f2976c = obj2;
    }

    @Override
    public final void run() {
        switch (this.f2974a) {
            case 0:
                ((AdsMediaSource.AdPrepareListener) this.f2975b).lambda$onPrepareComplete$0((MediaSource.MediaPeriodId) this.f2976c);
                break;
            case 1:
                ((AdsMediaSource.ComponentListener) this.f2975b).lambda$onAdPlaybackState$0((AdPlaybackState) this.f2976c);
                break;
            default:
                ((AdsMediaSource) this.f2975b).lambda$onChildSourceInfoRefreshed$2((Timeline) this.f2976c);
                break;
        }
    }
}
