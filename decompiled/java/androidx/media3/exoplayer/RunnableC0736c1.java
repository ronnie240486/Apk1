package androidx.media3.exoplayer;

public final class RunnableC0736c1 implements Runnable {

    public final int f2804a;

    public final boolean f2805b;

    public final Object f2806c;

    public RunnableC0736c1(int i6, Object obj, boolean z7) {
        this.f2804a = i6;
        this.f2806c = obj;
        this.f2805b = z7;
    }

    @Override
    public final void run() {
        switch (this.f2804a) {
            case 0:
                ((WakeLockManager) this.f2806c).lambda$setStayAwake$1(this.f2805b);
                break;
            default:
                ((WifiLockManager) this.f2806c).lambda$setStayAwake$1(this.f2805b);
                break;
        }
    }
}
