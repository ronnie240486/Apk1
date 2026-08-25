package androidx.media3.exoplayer.rtsp;

import android.os.HandlerThread;

public final class RunnableC0866e implements Runnable {

    public final int f2951a;

    public final Object f2952b;

    public RunnableC0866e(int i6, Object obj) {
        this.f2951a = i6;
        this.f2952b = obj;
    }

    @Override
    public final void run() {
        switch (this.f2951a) {
            case 0:
                RtspMediaPeriod.access$500((RtspMediaPeriod) this.f2952b);
                break;
            case 1:
                RtspMediaPeriod.access$500((RtspMediaPeriod) this.f2952b);
                break;
            default:
                ((HandlerThread) this.f2952b).quit();
                break;
        }
    }
}
