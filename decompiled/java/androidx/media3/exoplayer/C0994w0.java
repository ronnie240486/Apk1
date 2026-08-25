package androidx.media3.exoplayer;

import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.extractor.Extractor;
import p020b7.InterfaceC1346i;

public final class C0994w0 implements InterfaceC1346i {

    public final int f3073a;

    public C0994w0(int i6) {
        this.f3073a = i6;
    }

    @Override
    public final Object apply(Object obj) {
        switch (this.f3073a) {
            case 0:
                return StreamVolumeManager.lambda$release$11((StreamVolumeManager.StreamVolumeState) obj);
            case 1:
                return StreamVolumeManager.lambda$increaseVolume$5((StreamVolumeManager.StreamVolumeState) obj);
            case 2:
                return StreamVolumeManager.lambda$decreaseVolume$7((StreamVolumeManager.StreamVolumeState) obj);
            case 3:
                return new DefaultAnalyticsCollector((Clock) obj);
            default:
                return MediaExtractorCompat.lambda$selectExtractor$0((Extractor) obj);
        }
    }
}
