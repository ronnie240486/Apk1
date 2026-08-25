package androidx.media3.exoplayer.source.preload;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface PreloadManagerListener {
    void onCompleted(MediaItem mediaItem);

    void onError(PreloadException preloadException);
}
