package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.exoplayer.upstream.experimental.ExperimentalBandwidthMeter;

public final class C0962f implements NetworkTypeObserver.Listener {

    public final int f3038a;

    public final Object f3039b;

    public C0962f(int i6, Object obj) {
        this.f3038a = i6;
        this.f3039b = obj;
    }

    @Override
    public final void onNetworkTypeChanged(int i6) {
        switch (this.f3038a) {
            case 0:
                ((DefaultBandwidthMeter) this.f3039b).onNetworkTypeChanged(i6);
                break;
            default:
                ((ExperimentalBandwidthMeter) this.f3039b).onNetworkTypeChanged(i6);
                break;
        }
    }
}
