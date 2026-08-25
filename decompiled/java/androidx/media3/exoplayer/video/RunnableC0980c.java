package androidx.media3.exoplayer.video;

public final class RunnableC0980c implements Runnable {

    public final int f3045a;

    public final Object f3046b;

    public RunnableC0980c(int i6, Object obj) {
        this.f3045a = i6;
        this.f3046b = obj;
    }

    @Override
    public final void run() {
        switch (this.f3045a) {
            case 0:
                ((DefaultVideoSink.FrameRendererImpl) this.f3046b).lambda$renderFrame$1();
                break;
            case 1:
                ((DefaultVideoSink.FrameRendererImpl) this.f3046b).lambda$dropFrame$2();
                break;
            default:
                ((PlaybackVideoGraphWrapper) this.f3046b).lambda$flush$1();
                break;
        }
    }
}
