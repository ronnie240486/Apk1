package androidx.media3.exoplayer.video;

import java.util.concurrent.Executor;

public final class ExecutorC0978a implements Executor {

    public final int f3044a;

    public ExecutorC0978a(int i6) {
        this.f3044a = i6;
    }

    @Override
    public final void execute(Runnable runnable) {
        switch (this.f3044a) {
            case 0:
                DefaultVideoSink.lambda$new$0(runnable);
                break;
            default:
                PlaybackVideoGraphWrapper.lambda$static$0(runnable);
                break;
        }
    }
}
