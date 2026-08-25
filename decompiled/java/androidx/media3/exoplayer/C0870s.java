package androidx.media3.exoplayer;

import androidx.media3.exoplayer.trackselection.TrackSelector;
import p020b7.InterfaceC1339e0;

public final class C0870s implements InterfaceC1339e0 {

    public final int f2954a;

    public final TrackSelector f2955b;

    public C0870s(TrackSelector trackSelector, int i6) {
        this.f2954a = i6;
        this.f2955b = trackSelector;
    }

    @Override
    public final Object get() {
        switch (this.f2954a) {
            case 0:
                return ExoPlayer.Builder.lambda$new$10(this.f2955b);
            default:
                return ExoPlayer.Builder.lambda$setTrackSelector$18(this.f2955b);
        }
    }
}
