package androidx.media3.exoplayer.hls;

public final class RunnableC0782i implements Runnable {

    public final int f2875a;

    public final Object f2876b;

    public RunnableC0782i(int i6, Object obj) {
        this.f2875a = i6;
        this.f2876b = obj;
    }

    @Override
    public final void run() {
        switch (this.f2875a) {
            case 0:
                ((HlsSampleStreamWrapper) this.f2876b).maybeFinishPrepare();
                break;
            case 1:
                ((HlsSampleStreamWrapper) this.f2876b).onTracksEnded();
                break;
            default:
                ((HlsSampleStreamWrapper.Callback) this.f2876b).onPrepared();
                break;
        }
    }
}
