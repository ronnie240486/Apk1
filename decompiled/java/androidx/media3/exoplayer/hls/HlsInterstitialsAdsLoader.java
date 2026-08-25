package androidx.media3.exoplayer.hls;

import android.content.Context;
import androidx.media3.common.AbstractC0602k;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C0565C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.source.AbstractC0908h;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@UnstableApi
public final class HlsInterstitialsAdsLoader implements AdsLoader {
    private static final String TAG = "HlsInterstitiaAdsLoader";
    private boolean isReleased;
    private Player player;
    private final PlayerListener playerListener = new PlayerListener();
    private final Map<Object, AdsLoader.EventListener> activeEventListeners = new HashMap();
    private final Map<Object, AdPlaybackState> activeAdPlaybackStates = new HashMap();
    private final List<Listener> listeners = new ArrayList();
    private final Set<Object> unsupportedAdsIds = new HashSet();

    public static final class AdsMediaSourceFactory implements MediaSource.Factory {
        private final AdViewProvider adViewProvider;
        private final HlsInterstitialsAdsLoader adsLoader;
        private final MediaSource.Factory mediaSourceFactory;

        public AdsMediaSourceFactory(HlsInterstitialsAdsLoader hlsInterstitialsAdsLoader, AdViewProvider adViewProvider, Context context) {
            this(hlsInterstitialsAdsLoader, context, null, adViewProvider);
        }

        @Override
        public MediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.localConfiguration);
            MediaSource mediaSourceCreateMediaSource = this.mediaSourceFactory.createMediaSource(mediaItem);
            MediaItem.AdsConfiguration adsConfiguration = mediaItem.localConfiguration.adsConfiguration;
            if (adsConfiguration == null) {
                return mediaSourceCreateMediaSource;
            }
            if (adsConfiguration.adsId instanceof String) {
                return new AdsMediaSource(mediaSourceCreateMediaSource, new DataSpec(mediaItem.localConfiguration.adsConfiguration.adTagUri), Assertions.checkNotNull(mediaItem.localConfiguration.adsConfiguration.adsId), this.mediaSourceFactory, this.adsLoader, this.adViewProvider, false);
            }
            throw new IllegalArgumentException("Please use an AdsConfiguration with an adsId of type String when using HlsInterstitialsAdsLoader");
        }

        @Override
        public final MediaSource.Factory experimentalParseSubtitlesDuringExtraction(boolean z7) {
            return AbstractC0908h.m2484a(this, z7);
        }

        @Override
        public final MediaSource.Factory experimentalSetCodecsToParseWithinGopSampleDependencies(int i6) {
            return AbstractC0908h.m2485b(this, i6);
        }

        @Override
        public int[] getSupportedTypes() {
            return new int[]{2};
        }

        @Override
        public final MediaSource.Factory setCmcdConfigurationFactory(CmcdConfiguration.Factory factory) {
            return AbstractC0908h.m2486c(this, factory);
        }

        @Override
        public final MediaSource.Factory setSubtitleParserFactory(SubtitleParser.Factory factory) {
            return AbstractC0908h.m2487d(this, factory);
        }

        public AdsMediaSourceFactory(HlsInterstitialsAdsLoader hlsInterstitialsAdsLoader, AdViewProvider adViewProvider, MediaSource.Factory factory) {
            this(hlsInterstitialsAdsLoader, null, factory, adViewProvider);
        }

        @Override
        public AdsMediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.mediaSourceFactory.setDrmSessionManagerProvider(drmSessionManagerProvider);
            return this;
        }

        @Override
        public AdsMediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.mediaSourceFactory.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy);
            return this;
        }

        private AdsMediaSourceFactory(HlsInterstitialsAdsLoader hlsInterstitialsAdsLoader, Context context, MediaSource.Factory factory, AdViewProvider adViewProvider) {
            boolean z7 = true;
            Assertions.checkArgument((context == null && factory == null) ? false : true);
            this.adsLoader = hlsInterstitialsAdsLoader;
            factory = factory == null ? new HlsMediaSource.Factory(new DefaultDataSource.Factory((Context) Assertions.checkNotNull(context))) : factory;
            this.mediaSourceFactory = factory;
            this.adViewProvider = adViewProvider;
            int[] supportedTypes = factory.getSupportedTypes();
            for (int i6 : supportedTypes) {
                if (i6 == 2) {
                    Assertions.checkState(z7);
                }
            }
            z7 = false;
            Assertions.checkState(z7);
        }
    }

    public interface Listener {
        void onAdCompleted(MediaItem mediaItem, Object obj, int i6, int i10);

        void onContentTimelineChanged(MediaItem mediaItem, Object obj, Timeline timeline);

        void onMetadata(MediaItem mediaItem, Object obj, int i6, int i10, Metadata metadata);

        void onPrepareCompleted(MediaItem mediaItem, Object obj, int i6, int i10);

        void onPrepareError(MediaItem mediaItem, Object obj, int i6, int i10, IOException iOException);

        void onStart(MediaItem mediaItem, Object obj, AdViewProvider adViewProvider);

        void onStop(MediaItem mediaItem, Object obj, AdPlaybackState adPlaybackState);
    }

    public class PlayerListener implements Player.Listener {
        private final Timeline.Period period;

        private PlayerListener() {
            this.period = new Timeline.Period();
        }

        private void markAdAsPlayedAndNotifyListeners(MediaItem mediaItem, Object obj, int i6, int i10) {
            AdPlaybackState adPlaybackState = (AdPlaybackState) HlsInterstitialsAdsLoader.this.activeAdPlaybackStates.get(obj);
            if (adPlaybackState != null) {
                HlsInterstitialsAdsLoader.this.putAndNotifyAdPlaybackStateUpdate(obj, adPlaybackState.withPlayedAd(i6, i10));
                HlsInterstitialsAdsLoader.this.notifyListeners(new C0778e(mediaItem, obj, i6, i10, 0));
            }
        }

        @Override
        public final void onAudioAttributesChanged(AudioAttributes audioAttributes) {
            AbstractC0602k.m1682a(this, audioAttributes);
        }

        @Override
        public final void onAudioSessionIdChanged(int i6) {
            AbstractC0602k.m1683b(this, i6);
        }

        @Override
        public final void onAvailableCommandsChanged(Player.Commands commands) {
            AbstractC0602k.m1684c(this, commands);
        }

        @Override
        public final void onCues(CueGroup cueGroup) {
            AbstractC0602k.m1685d(this, cueGroup);
        }

        @Override
        public final void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            AbstractC0602k.m1687f(this, deviceInfo);
        }

        @Override
        public final void onDeviceVolumeChanged(int i6, boolean z7) {
            AbstractC0602k.m1688g(this, i6, z7);
        }

        @Override
        public final void onEvents(Player player, Player.Events events) {
            AbstractC0602k.m1689h(this, player, events);
        }

        @Override
        public final void onIsLoadingChanged(boolean z7) {
            AbstractC0602k.m1690i(this, z7);
        }

        @Override
        public final void onIsPlayingChanged(boolean z7) {
            AbstractC0602k.m1691j(this, z7);
        }

        @Override
        public final void onLoadingChanged(boolean z7) {
            AbstractC0602k.m1692k(this, z7);
        }

        @Override
        public final void onMaxSeekToPreviousPositionChanged(long j10) {
            AbstractC0602k.m1693l(this, j10);
        }

        @Override
        public final void onMediaItemTransition(MediaItem mediaItem, int i6) {
            AbstractC0602k.m1694m(this, mediaItem, i6);
        }

        @Override
        public final void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            AbstractC0602k.m1695n(this, mediaMetadata);
        }

        @Override
        public void onMetadata(Metadata metadata) {
            Player player = HlsInterstitialsAdsLoader.this.player;
            if (player == null || !player.isPlayingAd()) {
                return;
            }
            player.getCurrentTimeline().getPeriod(player.getCurrentPeriodIndex(), this.period);
            Object obj = this.period.adPlaybackState.adsId;
            if (obj == null || !HlsInterstitialsAdsLoader.this.activeAdPlaybackStates.containsKey(obj)) {
                return;
            }
            HlsInterstitialsAdsLoader.this.notifyListeners(new C0779f((MediaItem) Assertions.checkNotNull(player.getCurrentMediaItem()), obj, player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), metadata, 0));
        }

        @Override
        public final void onPlayWhenReadyChanged(boolean z7, int i6) {
            AbstractC0602k.m1697p(this, z7, i6);
        }

        @Override
        public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            AbstractC0602k.m1698q(this, playbackParameters);
        }

        @Override
        public void onPlaybackStateChanged(int i6) {
            Player player = HlsInterstitialsAdsLoader.this.player;
            if (i6 == 4 && player != null && player.isPlayingAd()) {
                player.getCurrentTimeline().getPeriod(player.getCurrentPeriodIndex(), this.period);
                Object obj = this.period.adPlaybackState.adsId;
                if (obj == null || !HlsInterstitialsAdsLoader.this.activeAdPlaybackStates.containsKey(obj)) {
                    return;
                }
                markAdAsPlayedAndNotifyListeners((MediaItem) Assertions.checkNotNull(player.getCurrentMediaItem()), obj, player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup());
            }
        }

        @Override
        public final void onPlaybackSuppressionReasonChanged(int i6) {
            AbstractC0602k.m1700s(this, i6);
        }

        @Override
        public final void onPlayerError(PlaybackException playbackException) {
            AbstractC0602k.m1701t(this, playbackException);
        }

        @Override
        public final void onPlayerErrorChanged(PlaybackException playbackException) {
            AbstractC0602k.m1702u(this, playbackException);
        }

        @Override
        public final void onPlayerStateChanged(boolean z7, int i6) {
            AbstractC0602k.m1703v(this, z7, i6);
        }

        @Override
        public final void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            AbstractC0602k.m1704w(this, mediaMetadata);
        }

        @Override
        public final void onPositionDiscontinuity(int i6) {
            AbstractC0602k.m1705x(this, i6);
        }

        @Override
        public final void onRenderedFirstFrame() {
            AbstractC0602k.m1707z(this);
        }

        @Override
        public final void onRepeatModeChanged(int i6) {
            AbstractC0602k.m1671A(this, i6);
        }

        @Override
        public final void onSeekBackIncrementChanged(long j10) {
            AbstractC0602k.m1672B(this, j10);
        }

        @Override
        public final void onSeekForwardIncrementChanged(long j10) {
            AbstractC0602k.m1673C(this, j10);
        }

        @Override
        public final void onShuffleModeEnabledChanged(boolean z7) {
            AbstractC0602k.m1674D(this, z7);
        }

        @Override
        public final void onSkipSilenceEnabledChanged(boolean z7) {
            AbstractC0602k.m1675E(this, z7);
        }

        @Override
        public final void onSurfaceSizeChanged(int i6, int i10) {
            AbstractC0602k.m1676F(this, i6, i10);
        }

        @Override
        public final void onTimelineChanged(Timeline timeline, int i6) {
            AbstractC0602k.m1677G(this, timeline, i6);
        }

        @Override
        public final void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            AbstractC0602k.m1678H(this, trackSelectionParameters);
        }

        @Override
        public final void onTracksChanged(Tracks tracks) {
            AbstractC0602k.m1679I(this, tracks);
        }

        @Override
        public final void onVideoSizeChanged(VideoSize videoSize) {
            AbstractC0602k.m1680J(this, videoSize);
        }

        @Override
        public final void onVolumeChanged(float f) {
            AbstractC0602k.m1681K(this, f);
        }

        @Override
        public final void onCues(List list) {
            AbstractC0602k.m1686e(this, list);
        }

        @Override
        public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i6) {
            if (i6 != 0 || HlsInterstitialsAdsLoader.this.player == null || positionInfo.mediaItem == null || positionInfo.adGroupIndex == -1) {
                return;
            }
            HlsInterstitialsAdsLoader.this.player.getCurrentTimeline().getPeriod(positionInfo.periodIndex, this.period);
            Object obj = this.period.adPlaybackState.adsId;
            if (obj == null || !HlsInterstitialsAdsLoader.this.activeAdPlaybackStates.containsKey(obj)) {
                return;
            }
            markAdAsPlayedAndNotifyListeners(positionInfo.mediaItem, obj, positionInfo.adGroupIndex, positionInfo.adIndexInAdGroup);
        }
    }

    private static long getInterstitialDurationUs(HlsMediaPlaylist.Interstitial interstitial, long j10) {
        long j11 = interstitial.playoutLimitUs;
        if (j11 != C0565C.TIME_UNSET) {
            return j11;
        }
        long j12 = interstitial.durationUs;
        if (j12 != C0565C.TIME_UNSET) {
            return j12;
        }
        long j13 = interstitial.endDateUnixUs;
        if (j13 != C0565C.TIME_UNSET) {
            return j13 - interstitial.startDateUnixUs;
        }
        long j14 = interstitial.plannedDurationUs;
        return j14 != C0565C.TIME_UNSET ? j14 : j10;
    }

    private static boolean isHlsMediaItem(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = (MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration);
        return Objects.equals(localConfiguration.mimeType, MimeTypes.APPLICATION_M3U8) || Util.inferContentType(localConfiguration.uri) == 2;
    }

    private static boolean isLiveMediaItem(MediaItem mediaItem, Timeline timeline) {
        int firstWindowIndex = timeline.getFirstWindowIndex(false);
        Timeline.Window window = new Timeline.Window();
        while (firstWindowIndex != -1) {
            timeline.getWindow(firstWindowIndex, window);
            if (window.mediaItem.equals(mediaItem)) {
                return window.isLive();
            }
            firstWindowIndex = timeline.getNextWindowIndex(firstWindowIndex, 0, false);
        }
        return false;
    }

    private static boolean isSupportedMediaItem(MediaItem mediaItem, Timeline timeline) {
        return isHlsMediaItem(mediaItem) && !isLiveMediaItem(mediaItem, timeline);
    }

    public static void lambda$handleContentTimelineChanged$1(AdsMediaSource adsMediaSource, Object obj, Timeline timeline, Listener listener) {
        listener.onContentTimelineChanged(adsMediaSource.getMediaItem(), obj, timeline);
    }

    public static void lambda$handlePrepareComplete$2(AdsMediaSource adsMediaSource, Object obj, int i6, int i10, Listener listener) {
        listener.onPrepareCompleted(adsMediaSource.getMediaItem(), obj, i6, i10);
    }

    public static void lambda$handlePrepareError$3(AdsMediaSource adsMediaSource, Object obj, int i6, int i10, IOException iOException, Listener listener) {
        listener.onPrepareError(adsMediaSource.getMediaItem(), obj, i6, i10, iOException);
    }

    public static void lambda$stop$4(AdsMediaSource adsMediaSource, AdPlaybackState adPlaybackState, Listener listener) {
        listener.onStop(adsMediaSource.getMediaItem(), adsMediaSource.getAdsId(), (AdPlaybackState) Assertions.checkNotNull(adPlaybackState));
    }

    private static AdPlaybackState mapHlsInterstitialsToAdPlaybackState(HlsMediaPlaylist hlsMediaPlaylist, AdPlaybackState adPlaybackState) {
        long[] jArr;
        AdPlaybackState adPlaybackStateWithNewAdGroup = adPlaybackState;
        for (int i6 = 0; i6 < hlsMediaPlaylist.interstitials.size(); i6++) {
            HlsMediaPlaylist.Interstitial interstitial = (HlsMediaPlaylist.Interstitial) hlsMediaPlaylist.interstitials.get(i6);
            if (interstitial.assetUri == null) {
                Log.m1719w(TAG, "Ignoring interstitials with X-ASSET-LIST. Not yet supported.");
            } else {
                long j10 = interstitial.cue.contains(HlsMediaPlaylist.Interstitial.CUE_TRIGGER_PRE) ? 0L : interstitial.cue.contains(HlsMediaPlaylist.Interstitial.CUE_TRIGGER_POST) ? Long.MIN_VALUE : interstitial.startDateUnixUs - hlsMediaPlaylist.startTimeUs;
                int adGroupIndexForPositionUs = adPlaybackStateWithNewAdGroup.getAdGroupIndexForPositionUs(j10, hlsMediaPlaylist.durationUs);
                if (adGroupIndexForPositionUs == -1) {
                    adPlaybackStateWithNewAdGroup = adPlaybackStateWithNewAdGroup.withNewAdGroup(0, j10);
                    adGroupIndexForPositionUs = 0;
                } else if (adPlaybackStateWithNewAdGroup.getAdGroup(adGroupIndexForPositionUs).timeUs != j10) {
                    adGroupIndexForPositionUs++;
                    adPlaybackStateWithNewAdGroup = adPlaybackStateWithNewAdGroup.withNewAdGroup(adGroupIndexForPositionUs, j10);
                }
                int iMax = Math.max(adPlaybackStateWithNewAdGroup.getAdGroup(adGroupIndexForPositionUs).count, 0);
                long interstitialDurationUs = getInterstitialDurationUs(interstitial, C0565C.TIME_UNSET);
                if (iMax == 0) {
                    jArr = new long[1];
                } else {
                    long[] jArr2 = adPlaybackStateWithNewAdGroup.getAdGroup(adGroupIndexForPositionUs).durationsUs;
                    long[] jArr3 = new long[jArr2.length + 1];
                    System.arraycopy(jArr2, 0, jArr3, 0, jArr2.length);
                    jArr = jArr3;
                }
                jArr[jArr.length - 1] = interstitialDurationUs;
                long j11 = interstitial.resumeOffsetUs;
                if (j11 == C0565C.TIME_UNSET) {
                    j11 = interstitialDurationUs != C0565C.TIME_UNSET ? interstitialDurationUs : 0L;
                }
                adPlaybackStateWithNewAdGroup = adPlaybackStateWithNewAdGroup.withAdCount(adGroupIndexForPositionUs, iMax + 1).withAdDurationsUs(adGroupIndexForPositionUs, jArr).withContentResumeOffsetUs(adGroupIndexForPositionUs, adPlaybackStateWithNewAdGroup.getAdGroup(adGroupIndexForPositionUs).contentResumeOffsetUs + j11).withAvailableAdMediaItem(adGroupIndexForPositionUs, iMax, MediaItem.fromUri(interstitial.assetUri));
            }
        }
        return adPlaybackStateWithNewAdGroup;
    }

    public void notifyListeners(Consumer<Listener> consumer) {
        for (int i6 = 0; i6 < this.listeners.size(); i6++) {
            consumer.accept(this.listeners.get(i6));
        }
    }

    public void putAndNotifyAdPlaybackStateUpdate(Object obj, AdPlaybackState adPlaybackState) {
        if (adPlaybackState.equals(this.activeAdPlaybackStates.put(obj, adPlaybackState))) {
            return;
        }
        AdsLoader.EventListener eventListener = this.activeEventListeners.get(obj);
        if (eventListener != null) {
            eventListener.onAdPlaybackState(adPlaybackState);
        } else {
            this.activeAdPlaybackStates.remove(obj);
        }
    }

    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void handleContentTimelineChanged(AdsMediaSource adsMediaSource, Timeline timeline) {
        Object adsId = adsMediaSource.getAdsId();
        if (this.isReleased) {
            AdsLoader.EventListener eventListenerRemove = this.activeEventListeners.remove(adsId);
            if (eventListenerRemove != null) {
                this.unsupportedAdsIds.remove(adsId);
                if (((AdPlaybackState) Assertions.checkNotNull(this.activeAdPlaybackStates.remove(adsId))).equals(AdPlaybackState.NONE)) {
                    eventListenerRemove.onAdPlaybackState(new AdPlaybackState(adsId, new long[0]));
                    return;
                }
                return;
            }
            return;
        }
        if (((AdPlaybackState) Assertions.checkNotNull(this.activeAdPlaybackStates.get(adsId))).equals(AdPlaybackState.NONE)) {
            AdPlaybackState adPlaybackState = new AdPlaybackState(adsId, new long[0]);
            Object obj = timeline.getWindow(0, new Timeline.Window()).manifest;
            if (obj instanceof HlsManifest) {
                adPlaybackState = mapHlsInterstitialsToAdPlaybackState(((HlsManifest) obj).mediaPlaylist, adPlaybackState);
            }
            putAndNotifyAdPlaybackStateUpdate(adsId, adPlaybackState);
            if (this.unsupportedAdsIds.contains(adsId)) {
                return;
            }
            notifyListeners(new C0775b(adsMediaSource, adsId, timeline, 0));
        }
    }

    @Override
    public void handlePrepareComplete(AdsMediaSource adsMediaSource, int i6, int i10) {
        Object adsId = adsMediaSource.getAdsId();
        if (this.isReleased || this.unsupportedAdsIds.contains(adsId)) {
            return;
        }
        notifyListeners(new C0778e(adsMediaSource, adsId, i6, i10, 1));
    }

    @Override
    public void handlePrepareError(AdsMediaSource adsMediaSource, int i6, int i10, IOException iOException) {
        Object adsId = adsMediaSource.getAdsId();
        putAndNotifyAdPlaybackStateUpdate(adsId, ((AdPlaybackState) Assertions.checkNotNull(this.activeAdPlaybackStates.get(adsId))).withAdLoadError(i6, i10));
        if (this.isReleased || this.unsupportedAdsIds.contains(adsId)) {
            return;
        }
        notifyListeners(new C0779f(adsMediaSource, adsId, i6, i10, iOException, 1));
    }

    @Override
    public void release() {
        if (this.activeEventListeners.isEmpty()) {
            this.player = null;
        }
        this.isReleased = true;
    }

    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void setPlayer(Player player) {
        boolean z7 = true;
        Assertions.checkState(!this.isReleased);
        if (Objects.equals(this.player, player)) {
            return;
        }
        if (this.player != null && !this.activeEventListeners.isEmpty()) {
            this.player.removeListener(this.playerListener);
        }
        if (player != null && !this.activeEventListeners.isEmpty()) {
            z7 = false;
        }
        Assertions.checkState(z7);
        this.player = player;
    }

    @Override
    public void setSupportedContentTypes(int... iArr) {
        for (int i6 : iArr) {
            if (i6 == 2) {
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void start(AdsMediaSource adsMediaSource, DataSpec dataSpec, Object obj, AdViewProvider adViewProvider, AdsLoader.EventListener eventListener) {
        if (this.isReleased) {
            eventListener.onAdPlaybackState(new AdPlaybackState(obj, new long[0]));
            return;
        }
        if (this.activeAdPlaybackStates.containsKey(obj) || this.unsupportedAdsIds.contains(obj)) {
            throw new IllegalStateException("media item with adsId='" + obj + "' already started. Make sure adsIds are unique within the same playlist.");
        }
        if (this.activeEventListeners.isEmpty()) {
            ((Player) Assertions.checkStateNotNull(this.player, "setPlayer(Player) needs to be called")).addListener(this.playerListener);
        }
        this.activeEventListeners.put(obj, eventListener);
        MediaItem mediaItem = adsMediaSource.getMediaItem();
        Player player = this.player;
        if (player != null && isSupportedMediaItem(mediaItem, player.getCurrentTimeline())) {
            this.activeAdPlaybackStates.put(obj, AdPlaybackState.NONE);
            notifyListeners(new C0775b(mediaItem, obj, adViewProvider, 1));
            return;
        }
        putAndNotifyAdPlaybackStateUpdate(obj, new AdPlaybackState(obj, new long[0]));
        if (this.player != null) {
            Log.m1719w(TAG, "Unsupported media item. Playing without ads for adsId=" + obj);
            this.unsupportedAdsIds.add(obj);
        }
    }

    @Override
    public void stop(final AdsMediaSource adsMediaSource, AdsLoader.EventListener eventListener) {
        Object adsId = adsMediaSource.getAdsId();
        this.activeEventListeners.remove(adsId);
        final AdPlaybackState adPlaybackStateRemove = this.activeAdPlaybackStates.remove(adsId);
        if (this.player != null && this.activeEventListeners.isEmpty()) {
            this.player.removeListener(this.playerListener);
            if (this.isReleased) {
                this.player = null;
            }
        }
        if (!this.isReleased && !this.unsupportedAdsIds.contains(adsId)) {
            notifyListeners(new Consumer() {
                @Override
                public final void accept(Object obj) {
                    HlsInterstitialsAdsLoader.lambda$stop$4(adsMediaSource, adPlaybackStateRemove, (HlsInterstitialsAdsLoader.Listener) obj);
                }
            });
        }
        this.unsupportedAdsIds.remove(adsId);
    }
}
