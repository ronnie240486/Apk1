package androidx.media3.exoplayer.source.ads;

public final class RunnableC0896c implements Runnable {

    public final int f2967a;

    public final AdsMediaSource f2968b;

    public final AdsMediaSource.ComponentListener f2969c;

    public RunnableC0896c(AdsMediaSource adsMediaSource, AdsMediaSource.ComponentListener componentListener, int i6) {
        this.f2967a = i6;
        this.f2968b = adsMediaSource;
        this.f2969c = componentListener;
    }

    @Override
    public final void run() {
        switch (this.f2967a) {
            case 0:
                this.f2968b.lambda$prepareSourceInternal$0(this.f2969c);
                break;
            default:
                this.f2968b.lambda$releaseSourceInternal$1(this.f2969c);
                break;
        }
    }
}
