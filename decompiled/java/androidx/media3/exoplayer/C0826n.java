package androidx.media3.exoplayer;

import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import p020b7.InterfaceC1346i;

public final class C0826n implements InterfaceC1346i {

    public final int f2902a;

    public final Object f2903b;

    public C0826n(int i6, Object obj) {
        this.f2902a = i6;
        this.f2903b = obj;
    }

    @Override
    public final Object apply(Object obj) {
        switch (this.f2902a) {
            case 0:
                return ExoPlayer.Builder.lambda$setAnalyticsCollector$21((AnalyticsCollector) this.f2903b, (Clock) obj);
            case 1:
                return ExoPlayer.Builder.lambda$new$13((AnalyticsCollector) this.f2903b, (Clock) obj);
            default:
                return ((StreamVolumeManager) this.f2903b).lambda$release$12((StreamVolumeManager.StreamVolumeState) obj);
        }
    }
}
