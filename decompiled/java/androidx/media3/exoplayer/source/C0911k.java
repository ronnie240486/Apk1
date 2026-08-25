package androidx.media3.exoplayer.source;

import android.os.Bundle;
import androidx.media3.common.TrackGroup;
import androidx.media3.extractor.Extractor;
import p020b7.InterfaceC1346i;

public final class C0911k implements InterfaceC1346i {

    public final int f2990a;

    public C0911k(int i6) {
        this.f2990a = i6;
    }

    @Override
    public final Object apply(Object obj) {
        switch (this.f2990a) {
            case 0:
                return MergingMediaPeriod.lambda$selectTracks$0((MediaPeriod) obj);
            case 1:
                return BundledExtractorsAdapter.lambda$init$0((Extractor) obj);
            case 2:
                return TrackGroupArray.lambda$getTrackTypes$0((TrackGroup) obj);
            case 3:
                return ((TrackGroup) obj).toBundle();
            default:
                return TrackGroup.fromBundle((Bundle) obj);
        }
    }
}
