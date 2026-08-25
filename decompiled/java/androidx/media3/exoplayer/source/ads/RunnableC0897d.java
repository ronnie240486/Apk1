package androidx.media3.exoplayer.source.ads;

import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.source.MediaSource;
import java.io.IOException;
import p041d7.AbstractC2331z1;

public final class RunnableC0897d implements Runnable {

    public final int f2970a;

    public final Object f2971b;

    public final Object f2972c;

    public final Object f2973d;

    public RunnableC0897d(Object obj, Object obj2, Object obj3, int i6) {
        this.f2970a = i6;
        this.f2971b = obj;
        this.f2972c = obj2;
        this.f2973d = obj3;
    }

    @Override
    public final void run() {
        switch (this.f2970a) {
            case 0:
                ((AdsMediaSource.AdPrepareListener) this.f2971b).lambda$onPrepareError$1((MediaSource.MediaPeriodId) this.f2972c, (IOException) this.f2973d);
                break;
            default:
                ((ServerSideAdInsertionMediaSource) this.f2971b).lambda$setAdPlaybackStates$0((AbstractC2331z1) this.f2972c, (Timeline) this.f2973d);
                break;
        }
    }
}
