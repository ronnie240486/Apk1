package androidx.media3.exoplayer.source;

public final class RunnableC0912l implements Runnable {

    public final int f2991a;

    public final ProgressiveMediaPeriod f2992b;

    public RunnableC0912l(ProgressiveMediaPeriod progressiveMediaPeriod, int i6) {
        this.f2991a = i6;
        this.f2992b = progressiveMediaPeriod;
    }

    @Override
    public final void run() {
        switch (this.f2991a) {
            case 0:
                this.f2992b.lambda$onLengthKnown$2();
                break;
            case 1:
                this.f2992b.maybeFinishPrepare();
                break;
            default:
                this.f2992b.lambda$new$0();
                break;
        }
    }
}
