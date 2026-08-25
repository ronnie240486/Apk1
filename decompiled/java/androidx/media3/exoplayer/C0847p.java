package androidx.media3.exoplayer;

import androidx.media3.exoplayer.source.MediaSource;
import p020b7.InterfaceC1339e0;

public final class C0847p implements InterfaceC1339e0 {

    public final int f2926a;

    public final MediaSource.Factory f2927b;

    public C0847p(MediaSource.Factory factory, int i6) {
        this.f2926a = i6;
        this.f2927b = factory;
    }

    @Override
    public final Object get() {
        switch (this.f2926a) {
            case 0:
                return ExoPlayer.Builder.lambda$new$7(this.f2927b);
            case 1:
                return ExoPlayer.Builder.lambda$new$9(this.f2927b);
            case 2:
                return ExoPlayer.Builder.lambda$new$5(this.f2927b);
            default:
                return ExoPlayer.Builder.lambda$setMediaSourceFactory$17(this.f2927b);
        }
    }
}
