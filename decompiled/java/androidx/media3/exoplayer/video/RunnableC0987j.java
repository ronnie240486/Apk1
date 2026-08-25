package androidx.media3.exoplayer.video;

public final class RunnableC0987j implements Runnable {

    public final int f3058a = 0;

    public final VideoRendererEventListener.EventDispatcher f3059b;

    public final long f3060c;

    public final int f3061d;

    public RunnableC0987j(VideoRendererEventListener.EventDispatcher eventDispatcher, int i6, long j10) {
        this.f3059b = eventDispatcher;
        this.f3061d = i6;
        this.f3060c = j10;
    }

    @Override
    public final void run() {
        switch (this.f3058a) {
            case 0:
                this.f3059b.lambda$droppedFrames$3(this.f3061d, this.f3060c);
                break;
            default:
                this.f3059b.lambda$reportVideoFrameProcessingOffset$4(this.f3060c, this.f3061d);
                break;
        }
    }

    public RunnableC0987j(VideoRendererEventListener.EventDispatcher eventDispatcher, long j10, int i6) {
        this.f3059b = eventDispatcher;
        this.f3060c = j10;
        this.f3061d = i6;
    }
}
