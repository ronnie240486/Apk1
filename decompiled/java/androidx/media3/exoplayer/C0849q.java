package androidx.media3.exoplayer;

import androidx.media3.exoplayer.upstream.BandwidthMeter;
import p020b7.InterfaceC1339e0;

public final class C0849q implements InterfaceC1339e0 {

    public final int f2934a;

    public final BandwidthMeter f2935b;

    public C0849q(BandwidthMeter bandwidthMeter, int i6) {
        this.f2934a = i6;
        this.f2935b = bandwidthMeter;
    }

    @Override
    public final Object get() {
        switch (this.f2934a) {
            case 0:
                return ExoPlayer.Builder.lambda$setBandwidthMeter$20(this.f2935b);
            default:
                return ExoPlayer.Builder.lambda$new$12(this.f2935b);
        }
    }
}
