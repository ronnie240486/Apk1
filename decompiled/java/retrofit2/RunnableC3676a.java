package retrofit2;

public final class RunnableC3676a implements Runnable {

    public final int f12289a;

    public final DefaultCallAdapterFactory.ExecutorCallbackCall.C36651 f12290b;

    public final Callback f12291c;

    public final Object f12292d;

    public RunnableC3676a(DefaultCallAdapterFactory.ExecutorCallbackCall.C36651 c36651, Callback callback, Object obj, int i6) {
        this.f12289a = i6;
        this.f12290b = c36651;
        this.f12291c = callback;
        this.f12292d = obj;
    }

    @Override
    public final void run() {
        switch (this.f12289a) {
            case 0:
                this.f12290b.lambda$onResponse$0(this.f12291c, (Response) this.f12292d);
                break;
            default:
                this.f12290b.lambda$onFailure$1(this.f12291c, (Throwable) this.f12292d);
                break;
        }
    }
}
