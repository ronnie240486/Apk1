package androidx.media3.exoplayer.audio;

public final class RunnableC0723g implements Runnable {

    public final int f2783a;

    public final AudioRendererEventListener.EventDispatcher f2784b;

    public final Exception f2785c;

    public RunnableC0723g(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc, int i6) {
        this.f2783a = i6;
        this.f2784b = eventDispatcher;
        this.f2785c = exc;
    }

    @Override
    public final void run() {
        switch (this.f2783a) {
            case 0:
                this.f2784b.lambda$audioCodecError$9(this.f2785c);
                break;
            default:
                this.f2784b.lambda$audioSinkError$8(this.f2785c);
                break;
        }
    }
}
