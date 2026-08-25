package androidx.media3.exoplayer.source;

import android.os.Handler;
import android.os.Message;

public final class C0899b implements Handler.Callback {

    public final int f2977a;

    public final CompositeMediaSource f2978b;

    public C0899b(CompositeMediaSource compositeMediaSource, int i6) {
        this.f2977a = i6;
        this.f2978b = compositeMediaSource;
    }

    @Override
    public final boolean handleMessage(Message message) {
        switch (this.f2977a) {
            case 0:
                return ((ConcatenatingMediaSource) this.f2978b).handleMessage(message);
            default:
                return ((ConcatenatingMediaSource2) this.f2978b).handleMessage(message);
        }
    }
}
