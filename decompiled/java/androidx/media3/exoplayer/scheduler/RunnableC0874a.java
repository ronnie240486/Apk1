package androidx.media3.exoplayer.scheduler;

public final class RunnableC0874a implements Runnable {

    public final int f2959a;

    public final RequirementsWatcher.NetworkCallback f2960b;

    public RunnableC0874a(RequirementsWatcher.NetworkCallback networkCallback, int i6) {
        this.f2959a = i6;
        this.f2960b = networkCallback;
    }

    @Override
    public final void run() {
        switch (this.f2959a) {
            case 0:
                this.f2960b.lambda$postCheckRequirements$0();
                break;
            default:
                this.f2960b.lambda$postRecheckNotMetNetworkRequirements$1();
                break;
        }
    }
}
