package androidx.media3.common.util;

import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArraySet;
import p207t1.C3789a;

public final class RunnableC0619d implements Runnable {

    public final int f2640a;

    public final int f2641b;

    public final Object f2642c;

    public final Object f2643d;

    public RunnableC0619d(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, int i6) {
        this.f2640a = 1;
        this.f2642c = eventDispatcher;
        this.f2643d = drmSessionEventListener;
        this.f2641b = i6;
    }

    @Override
    public final void run() {
        switch (this.f2640a) {
            case 0:
                ListenerSet.lambda$queueEvent$0((CopyOnWriteArraySet) this.f2642c, this.f2641b, (ListenerSet.Event) this.f2643d);
                break;
            case 1:
                ((DrmSessionEventListener.EventDispatcher) this.f2642c).lambda$drmSessionAcquired$0((DrmSessionEventListener) this.f2643d, this.f2641b);
                break;
            default:
                ((C3789a) this.f2642c).f12758b.mo6880b(this.f2641b, (Serializable) this.f2643d);
                break;
        }
    }

    public RunnableC0619d(Object obj, int i6, Object obj2, int i10) {
        this.f2640a = i10;
        this.f2642c = obj;
        this.f2641b = i6;
        this.f2643d = obj2;
    }
}
