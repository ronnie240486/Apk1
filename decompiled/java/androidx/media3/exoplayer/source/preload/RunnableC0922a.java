package androidx.media3.exoplayer.source.preload;

import androidx.media3.exoplayer.source.MediaSource;

public final class RunnableC0922a implements Runnable {

    public final int f3001a;

    public final BasePreloadManager f3002b;

    public final MediaSource f3003c;

    public RunnableC0922a(BasePreloadManager basePreloadManager, MediaSource mediaSource, int i6) {
        this.f3001a = i6;
        this.f3002b = basePreloadManager;
        this.f3003c = mediaSource;
    }

    @Override
    public final void run() {
        switch (this.f3001a) {
            case 0:
                this.f3002b.lambda$onPreloadCompleted$2(this.f3003c);
                break;
            default:
                this.f3002b.lambda$onPreloadSkipped$5(this.f3003c);
                break;
        }
    }
}
