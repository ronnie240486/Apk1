package androidx.media3.exoplayer;

import p020b7.InterfaceC1339e0;

public final class C0803m implements InterfaceC1339e0 {

    public final int f2888a;

    public final LoadControl f2889b;

    public C0803m(LoadControl loadControl, int i6) {
        this.f2888a = i6;
        this.f2889b = loadControl;
    }

    @Override
    public final Object get() {
        switch (this.f2888a) {
            case 0:
                return ExoPlayer.Builder.lambda$setLoadControl$19(this.f2889b);
            default:
                return ExoPlayer.Builder.lambda$new$11(this.f2889b);
        }
    }
}
