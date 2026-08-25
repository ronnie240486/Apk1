package androidx.media3.exoplayer.trackselection;

import android.os.Bundle;
import androidx.media3.exoplayer.source.TrackGroupArray;
import p020b7.InterfaceC1346i;

public final class C0943e implements InterfaceC1346i {

    public final int f3028a;

    public C0943e(int i6) {
        this.f3028a = i6;
    }

    @Override
    public final Object apply(Object obj) {
        switch (this.f3028a) {
            case 0:
                return ((TrackGroupArray) obj).toBundle();
            case 1:
                return ((DefaultTrackSelector.SelectionOverride) obj).toBundle();
            case 2:
                return TrackGroupArray.fromBundle((Bundle) obj);
            default:
                return DefaultTrackSelector.SelectionOverride.fromBundle((Bundle) obj);
        }
    }
}
