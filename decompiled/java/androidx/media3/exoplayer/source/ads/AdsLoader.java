package androidx.media3.exoplayer.source.ads;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;
import java.io.IOException;

public interface AdsLoader {

    @UnstableApi
    public interface EventListener {
        void onAdClicked();

        void onAdLoadError(AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec);

        void onAdPlaybackState(AdPlaybackState adPlaybackState);

        void onAdTapped();
    }

    public interface Provider {
        AdsLoader getAdsLoader(MediaItem.AdsConfiguration adsConfiguration);
    }

    @UnstableApi
    void handleContentTimelineChanged(AdsMediaSource adsMediaSource, Timeline timeline);

    @UnstableApi
    void handlePrepareComplete(AdsMediaSource adsMediaSource, int i6, int i10);

    @UnstableApi
    void handlePrepareError(AdsMediaSource adsMediaSource, int i6, int i10, IOException iOException);

    void release();

    void setPlayer(Player player);

    @UnstableApi
    void setSupportedContentTypes(int... iArr);

    @UnstableApi
    void start(AdsMediaSource adsMediaSource, DataSpec dataSpec, Object obj, AdViewProvider adViewProvider, EventListener eventListener);

    @UnstableApi
    void stop(AdsMediaSource adsMediaSource, EventListener eventListener);
}
