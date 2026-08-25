package androidx.media3.exoplayer.source.preload;

public final class RunnableC0929h implements Runnable {

    public final int f3010a;

    public final PreloadMediaSource f3011b;

    public RunnableC0929h(PreloadMediaSource preloadMediaSource, int i6) {
        this.f3010a = i6;
        this.f3011b = preloadMediaSource;
    }

    @Override
    public final void run() {
        switch (this.f3010a) {
            case 0:
                this.f3011b.lambda$releasePreloadMediaSource$3();
                break;
            case 1:
                this.f3011b.lambda$clear$1();
                break;
            default:
                this.f3011b.checkForPreloadError();
                break;
        }
    }
}
