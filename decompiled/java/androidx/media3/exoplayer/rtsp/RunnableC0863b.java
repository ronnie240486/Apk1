package androidx.media3.exoplayer.rtsp;

import java.io.Serializable;
import java.util.List;

public final class RunnableC0863b implements Runnable {

    public final int f2945a;

    public final Object f2946b;

    public final Serializable f2947c;

    public final Object f2948d;

    public RunnableC0863b(Object obj, Serializable serializable, Object obj2, int i6) {
        this.f2945a = i6;
        this.f2946b = obj;
        this.f2947c = serializable;
        this.f2948d = obj2;
    }

    @Override
    public final void run() {
        switch (this.f2945a) {
            case 0:
                ((RtpDataLoadable) this.f2946b).lambda$load$0((String) this.f2947c, (RtpDataChannel) this.f2948d);
                break;
            default:
                ((RtspMessageChannel.Sender) this.f2946b).lambda$send$0((byte[]) this.f2947c, (List) this.f2948d);
                break;
        }
    }
}
