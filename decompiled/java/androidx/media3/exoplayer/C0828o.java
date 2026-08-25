package androidx.media3.exoplayer;

import p020b7.InterfaceC1339e0;

public final class C0828o implements InterfaceC1339e0 {

    public final int f2908a;

    public final RenderersFactory f2909b;

    public C0828o(RenderersFactory renderersFactory, int i6) {
        this.f2908a = i6;
        this.f2909b = renderersFactory;
    }

    @Override
    public final Object get() {
        switch (this.f2908a) {
            case 0:
                return ExoPlayer.Builder.lambda$setRenderersFactory$16(this.f2909b);
            case 1:
                return ExoPlayer.Builder.lambda$new$6(this.f2909b);
            case 2:
                return ExoPlayer.Builder.lambda$new$2(this.f2909b);
            default:
                return ExoPlayer.Builder.lambda$new$8(this.f2909b);
        }
    }
}
