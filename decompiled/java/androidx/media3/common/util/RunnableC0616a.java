package androidx.media3.common.util;

public final class RunnableC0616a implements Runnable {

    public final int f2636a;

    public final BackgroundThreadStateHandler f2637b;

    public final Object f2638c;

    public RunnableC0616a(BackgroundThreadStateHandler backgroundThreadStateHandler, Object obj, int i6) {
        this.f2636a = i6;
        this.f2637b = backgroundThreadStateHandler;
        this.f2638c = obj;
    }

    @Override
    public final void run() {
        switch (this.f2636a) {
            case 0:
                this.f2637b.lambda$setStateInBackground$2(this.f2638c);
                break;
            default:
                this.f2637b.lambda$updateStateAsync$0(this.f2638c);
                break;
        }
    }
}
