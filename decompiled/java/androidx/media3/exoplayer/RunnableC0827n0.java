package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.source.MediaLoadData;

public final class RunnableC0827n0 implements Runnable {

    public final int f2904a;

    public final MediaSourceList.ForwardingEventListener f2905b;

    public final Pair f2906c;

    public final MediaLoadData f2907d;

    public RunnableC0827n0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, MediaLoadData mediaLoadData, int i6) {
        this.f2904a = i6;
        this.f2905b = forwardingEventListener;
        this.f2906c = pair;
        this.f2907d = mediaLoadData;
    }

    @Override
    public final void run() {
        switch (this.f2904a) {
            case 0:
                this.f2905b.lambda$onUpstreamDiscarded$4(this.f2906c, this.f2907d);
                break;
            default:
                this.f2905b.lambda$onDownstreamFormatChanged$5(this.f2906c, this.f2907d);
                break;
        }
    }
}
