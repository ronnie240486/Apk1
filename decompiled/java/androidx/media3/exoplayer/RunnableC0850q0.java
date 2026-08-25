package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;

public final class RunnableC0850q0 implements Runnable {

    public final int f2936a;

    public final MediaSourceList.ForwardingEventListener f2937b;

    public final Pair f2938c;

    public final LoadEventInfo f2939d;

    public final MediaLoadData f2940e;

    public RunnableC0850q0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i6) {
        this.f2936a = i6;
        this.f2937b = forwardingEventListener;
        this.f2938c = pair;
        this.f2939d = loadEventInfo;
        this.f2940e = mediaLoadData;
    }

    @Override
    public final void run() {
        switch (this.f2936a) {
            case 0:
                this.f2937b.lambda$onLoadCanceled$2(this.f2938c, this.f2939d, this.f2940e);
                break;
            default:
                this.f2937b.lambda$onLoadCompleted$1(this.f2938c, this.f2939d, this.f2940e);
                break;
        }
    }
}
