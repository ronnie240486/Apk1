package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.source.MediaSource;
import p041d7.C2288s1;

public final class RunnableC0802l0 implements Runnable {

    public final int f2884a;

    public final Object f2885b;

    public final Object f2886c;

    public final Object f2887d;

    public RunnableC0802l0(Object obj, Object obj2, Object obj3, int i6) {
        this.f2884a = i6;
        this.f2885b = obj;
        this.f2886c = obj2;
        this.f2887d = obj3;
    }

    @Override
    public final void run() {
        switch (this.f2884a) {
            case 0:
                ((MediaPeriodQueue) this.f2885b).lambda$notifyQueueUpdate$0((C2288s1) this.f2886c, (MediaSource.MediaPeriodId) this.f2887d);
                break;
            default:
                ((MediaSourceList.ForwardingEventListener) this.f2885b).lambda$onDrmSessionManagerError$8((Pair) this.f2886c, (Exception) this.f2887d);
                break;
        }
    }
}
