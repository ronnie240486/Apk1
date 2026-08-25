package androidx.media3.exoplayer;

public final class RunnableC0739d1 implements Runnable {

    public final int f2811a;

    public final boolean f2812b;

    public final boolean f2813c;

    public final Object f2814d;

    public RunnableC0739d1(Object obj, boolean z7, boolean z10, int i6) {
        this.f2811a = i6;
        this.f2814d = obj;
        this.f2812b = z7;
        this.f2813c = z10;
    }

    @Override
    public final void run() {
        switch (this.f2811a) {
            case 0:
                ((WakeLockManager) this.f2814d).lambda$setEnabled$0(this.f2812b, this.f2813c);
                break;
            default:
                ((WifiLockManager) this.f2814d).lambda$setEnabled$0(this.f2812b, this.f2813c);
                break;
        }
    }
}
