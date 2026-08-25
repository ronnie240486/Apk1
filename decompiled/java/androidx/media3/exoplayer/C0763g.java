package androidx.media3.exoplayer;

import androidx.media3.common.util.BackgroundThreadStateHandler;

public final class C0763g implements BackgroundThreadStateHandler.StateChangeListener {

    public final int f2847a;

    public final SuitableOutputChecker.Callback f2848b;

    public C0763g(SuitableOutputChecker.Callback callback, int i6) {
        this.f2847a = i6;
        this.f2848b = callback;
    }

    @Override
    public final void onStateChanged(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        Boolean bool2 = (Boolean) obj2;
        switch (this.f2847a) {
            case 0:
                DefaultSuitableOutputChecker.ImplApi23.lambda$enable$0(this.f2848b, bool, bool2);
                break;
            default:
                DefaultSuitableOutputChecker.ImplApi35.lambda$enable$0(this.f2848b, bool, bool2);
                break;
        }
    }
}
