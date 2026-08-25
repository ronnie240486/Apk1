package androidx.media3.exoplayer.source.preload;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface TargetPreloadStatusControl<T> {

    public interface PreloadStatus {
        int getStage();

        long getValue();
    }

    PreloadStatus getTargetPreloadStatus(T t5);
}
