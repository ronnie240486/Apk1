package androidx.media3.exoplayer.offline;

import java.io.IOException;

public final class RunnableC0845h implements Runnable {

    public final int f2921a;

    public final Object f2922b;

    public final Object f2923c;

    public RunnableC0845h(Object obj, int i6, Object obj2) {
        this.f2921a = i6;
        this.f2922b = obj;
        this.f2923c = obj2;
    }

    @Override
    public final void run() {
        switch (this.f2921a) {
            case 0:
                ((DownloadService.DownloadManagerHelper) this.f2922b).lambda$attachService$0((DownloadService) this.f2923c);
                break;
            case 1:
                ((DownloadHelper) this.f2922b).lambda$onMediaPreparationFailed$3((IOException) this.f2923c);
                break;
            default:
                ((DownloadHelper) this.f2922b).lambda$prepare$1((DownloadHelper.Callback) this.f2923c);
                break;
        }
    }
}
