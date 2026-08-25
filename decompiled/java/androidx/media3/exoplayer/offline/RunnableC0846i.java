package androidx.media3.exoplayer.offline;

public final class RunnableC0846i implements Runnable {

    public final int f2924a;

    public final Object f2925b;

    public RunnableC0846i(int i6, Object obj) {
        this.f2924a = i6;
        this.f2925b = obj;
    }

    @Override
    public final void run() {
        switch (this.f2924a) {
            case 0:
                ((DownloadService.ForegroundNotificationUpdater) this.f2925b).update();
                break;
            default:
                ((DownloadHelper) this.f2925b).lambda$onMediaPrepared$2();
                break;
        }
    }
}
