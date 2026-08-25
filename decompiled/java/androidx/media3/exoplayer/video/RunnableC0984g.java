package androidx.media3.exoplayer.video;

public final class RunnableC0984g implements Runnable {

    public final int f3055a;

    public final PlaybackVideoGraphWrapper.InputVideoSink f3056b;

    public final VideoSink.Listener f3057c;

    public RunnableC0984g(PlaybackVideoGraphWrapper.InputVideoSink inputVideoSink, VideoSink.Listener listener, int i6) {
        this.f3055a = i6;
        this.f3056b = inputVideoSink;
        this.f3057c = listener;
    }

    @Override
    public final void run() {
        switch (this.f3055a) {
            case 0:
                this.f3056b.lambda$onFirstFrameRendered$0(this.f3057c);
                break;
            default:
                this.f3056b.lambda$onFrameDropped$1(this.f3057c);
                break;
        }
    }
}
