package androidx.media3.exoplayer.drm;

public final class RunnableC0749g implements Runnable {

    public final int f2822a;

    public final DrmSessionEventListener.EventDispatcher f2823b;

    public final DrmSessionEventListener f2824c;

    public RunnableC0749g(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, int i6) {
        this.f2822a = i6;
        this.f2823b = eventDispatcher;
        this.f2824c = drmSessionEventListener;
    }

    @Override
    public final void run() {
        switch (this.f2822a) {
            case 0:
                this.f2823b.lambda$drmKeysRemoved$4(this.f2824c);
                break;
            case 1:
                this.f2823b.lambda$drmKeysRestored$3(this.f2824c);
                break;
            case 2:
                this.f2823b.lambda$drmKeysLoaded$1(this.f2824c);
                break;
            default:
                this.f2823b.lambda$drmSessionReleased$5(this.f2824c);
                break;
        }
    }
}
