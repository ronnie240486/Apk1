package androidx.media3.exoplayer.drm;

public final class RunnableC0746d implements Runnable {

    public final int f2820a;

    public final Object f2821b;

    public RunnableC0746d(int i6, Object obj) {
        this.f2820a = i6;
        this.f2821b = obj;
    }

    @Override
    public final void run() {
        switch (this.f2820a) {
            case 0:
                ((DefaultDrmSessionManager.PreacquiredSessionReference) this.f2821b).lambda$release$1();
                break;
            default:
                ((DefaultDrmSession) this.f2821b).release(null);
                break;
        }
    }
}
