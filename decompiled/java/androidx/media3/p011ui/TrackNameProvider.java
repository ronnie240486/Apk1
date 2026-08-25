package androidx.media3.p011ui;

import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface TrackNameProvider {
    String getTrackName(Format format);
}
