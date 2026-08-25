package androidx.media3.exoplayer.audio;

public final class RunnableC0722f implements Runnable {

    public final int f2780a;

    public final AudioRendererEventListener.EventDispatcher f2781b;

    public final AudioSink.AudioTrackConfig f2782c;

    public RunnableC0722f(AudioRendererEventListener.EventDispatcher eventDispatcher, AudioSink.AudioTrackConfig audioTrackConfig, int i6) {
        this.f2780a = i6;
        this.f2781b = eventDispatcher;
        this.f2782c = audioTrackConfig;
    }

    @Override
    public final void run() {
        switch (this.f2780a) {
            case 0:
                this.f2781b.lambda$audioTrackInitialized$10(this.f2782c);
                break;
            default:
                this.f2781b.lambda$audioTrackReleased$11(this.f2782c);
                break;
        }
    }
}
