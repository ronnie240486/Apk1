package androidx.media3.exoplayer.analytics;

import android.os.Looper;
import android.util.SparseArray;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C0605n;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import p000a.RunnableC0001b;
import p005a4.C0060s;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2301u1;
import p041d7.AbstractC2331z1;
import p041d7.C2180c5;
import p041d7.C2204g1;
import p041d7.C2215h5;
import p041d7.C2325y1;

@UnstableApi
public class DefaultAnalyticsCollector implements AnalyticsCollector {
    private final Clock clock;
    private final SparseArray<AnalyticsListener.EventTime> eventTimes;
    private HandlerWrapper handler;
    private boolean isSeeking;
    private ListenerSet<AnalyticsListener> listeners;
    private final MediaPeriodQueueTracker mediaPeriodQueueTracker;
    private final Timeline.Period period;
    private Player player;
    private final Timeline.Window window;

    public static final class MediaPeriodQueueTracker {
        private MediaSource.MediaPeriodId currentPlayerMediaPeriod;
        private AbstractC2301u1 mediaPeriodQueue;
        private AbstractC2331z1 mediaPeriodTimelines;
        private final Timeline.Period period;
        private MediaSource.MediaPeriodId playingMediaPeriod;
        private MediaSource.MediaPeriodId readingMediaPeriod;

        public MediaPeriodQueueTracker(Timeline.Period period) {
            this.period = period;
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            this.mediaPeriodQueue = C2180c5.f7862e;
            this.mediaPeriodTimelines = C2215h5.f7927g;
        }

        private void addTimelineForMediaPeriodId(C2325y1 c2325y1, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            if (mediaPeriodId == null) {
                return;
            }
            if (timeline.getIndexOfPeriod(mediaPeriodId.periodUid) != -1) {
                c2325y1.m5292b(mediaPeriodId, timeline);
                return;
            }
            Timeline timeline2 = (Timeline) this.mediaPeriodTimelines.get(mediaPeriodId);
            if (timeline2 != null) {
                c2325y1.m5292b(mediaPeriodId, timeline2);
            }
        }

        private static MediaSource.MediaPeriodId findCurrentPlayerMediaPeriodInQueue(Player player, AbstractC2301u1 abstractC2301u1, MediaSource.MediaPeriodId mediaPeriodId, Timeline.Period period) {
            Timeline currentTimeline = player.getCurrentTimeline();
            int currentPeriodIndex = player.getCurrentPeriodIndex();
            Object uidOfPeriod = currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(currentPeriodIndex);
            int adGroupIndexAfterPositionUs = (player.isPlayingAd() || currentTimeline.isEmpty()) ? -1 : currentTimeline.getPeriod(currentPeriodIndex, period).getAdGroupIndexAfterPositionUs(Util.msToUs(player.getCurrentPosition()) - period.getPositionInWindowUs());
            for (int i6 = 0; i6 < abstractC2301u1.size(); i6++) {
                MediaSource.MediaPeriodId mediaPeriodId2 = (MediaSource.MediaPeriodId) abstractC2301u1.get(i6);
                if (isMatchingMediaPeriod(mediaPeriodId2, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodId2;
                }
            }
            if (abstractC2301u1.isEmpty() && mediaPeriodId != null) {
                if (isMatchingMediaPeriod(mediaPeriodId, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodId;
                }
            }
            return null;
        }

        private static boolean isMatchingMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Object obj, boolean z7, int i6, int i10, int i11) {
            if (mediaPeriodId.periodUid.equals(obj)) {
                return (z7 && mediaPeriodId.adGroupIndex == i6 && mediaPeriodId.adIndexInAdGroup == i10) || (!z7 && mediaPeriodId.adGroupIndex == -1 && mediaPeriodId.nextAdGroupIndex == i11);
            }
            return false;
        }

        private void updateMediaPeriodTimelines(Timeline timeline) {
            C2325y1 c2325y1M5295a = AbstractC2331z1.m5295a();
            if (this.mediaPeriodQueue.isEmpty()) {
                addTimelineForMediaPeriodId(c2325y1M5295a, this.playingMediaPeriod, timeline);
                if (!Objects.equals(this.readingMediaPeriod, this.playingMediaPeriod)) {
                    addTimelineForMediaPeriodId(c2325y1M5295a, this.readingMediaPeriod, timeline);
                }
                if (!Objects.equals(this.currentPlayerMediaPeriod, this.playingMediaPeriod) && !Objects.equals(this.currentPlayerMediaPeriod, this.readingMediaPeriod)) {
                    addTimelineForMediaPeriodId(c2325y1M5295a, this.currentPlayerMediaPeriod, timeline);
                }
            } else {
                for (int i6 = 0; i6 < this.mediaPeriodQueue.size(); i6++) {
                    addTimelineForMediaPeriodId(c2325y1M5295a, (MediaSource.MediaPeriodId) this.mediaPeriodQueue.get(i6), timeline);
                }
                if (!this.mediaPeriodQueue.contains(this.currentPlayerMediaPeriod)) {
                    addTimelineForMediaPeriodId(c2325y1M5295a, this.currentPlayerMediaPeriod, timeline);
                }
            }
            this.mediaPeriodTimelines = c2325y1M5295a.m5291a();
        }

        public MediaSource.MediaPeriodId getCurrentPlayerMediaPeriod() {
            return this.currentPlayerMediaPeriod;
        }

        public MediaSource.MediaPeriodId getLoadingMediaPeriod() {
            if (this.mediaPeriodQueue.isEmpty()) {
                return null;
            }
            return (MediaSource.MediaPeriodId) AbstractC2182d0.m5151n(this.mediaPeriodQueue);
        }

        public Timeline getMediaPeriodIdTimeline(MediaSource.MediaPeriodId mediaPeriodId) {
            return (Timeline) this.mediaPeriodTimelines.get(mediaPeriodId);
        }

        public MediaSource.MediaPeriodId getPlayingMediaPeriod() {
            return this.playingMediaPeriod;
        }

        public MediaSource.MediaPeriodId getReadingMediaPeriod() {
            return this.readingMediaPeriod;
        }

        public void onPositionDiscontinuity(Player player) {
            this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
        }

        public void onQueueUpdated(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId, Player player) {
            this.mediaPeriodQueue = AbstractC2301u1.m5272n(list);
            if (!list.isEmpty()) {
                this.playingMediaPeriod = list.get(0);
                this.readingMediaPeriod = (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId);
            }
            if (this.currentPlayerMediaPeriod == null) {
                this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
            }
            updateMediaPeriodTimelines(player.getCurrentTimeline());
        }

        public void onTimelineChanged(Player player) {
            this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
            updateMediaPeriodTimelines(player.getCurrentTimeline());
        }
    }

    public DefaultAnalyticsCollector(Clock clock) {
        this.clock = (Clock) Assertions.checkNotNull(clock);
        this.listeners = new ListenerSet<>(Util.getCurrentOrMainLooper(), clock, new C0060s(4));
        Timeline.Period period = new Timeline.Period();
        this.period = period;
        this.window = new Timeline.Window();
        this.mediaPeriodQueueTracker = new MediaPeriodQueueTracker(period);
        this.eventTimes = new SparseArray<>();
    }

    private AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getLoadingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateMediaPeriodEventTime(int i6, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.checkNotNull(this.player);
        if (mediaPeriodId != null) {
            return this.mediaPeriodQueueTracker.getMediaPeriodIdTimeline(mediaPeriodId) != null ? generateEventTime(mediaPeriodId) : generateEventTime(Timeline.EMPTY, i6, mediaPeriodId);
        }
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (i6 >= currentTimeline.getWindowCount()) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, i6, null);
    }

    private AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getPlayingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateReadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getReadingMediaPeriod());
    }

    private AnalyticsListener.EventTime getEventTimeForErrorEvent(PlaybackException playbackException) {
        MediaSource.MediaPeriodId mediaPeriodId;
        return (!(playbackException instanceof ExoPlaybackException) || (mediaPeriodId = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? generateCurrentPlayerMediaPeriodEventTime() : generateEventTime(mediaPeriodId);
    }

    public static void lambda$onAudioDecoderInitialized$5(AnalyticsListener.EventTime eventTime, String str, long j10, long j11, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioDecoderInitialized(eventTime, str, j10);
        analyticsListener.onAudioDecoderInitialized(eventTime, str, j11, j10);
    }

    public static void lambda$onDrmSessionAcquired$64(AnalyticsListener.EventTime eventTime, int i6, AnalyticsListener analyticsListener) {
        analyticsListener.onDrmSessionAcquired(eventTime);
        analyticsListener.onDrmSessionAcquired(eventTime, i6);
    }

    public static void lambda$onIsLoadingChanged$35(AnalyticsListener.EventTime eventTime, boolean z7, AnalyticsListener analyticsListener) {
        analyticsListener.onLoadingChanged(eventTime, z7);
        analyticsListener.onIsLoadingChanged(eventTime, z7);
    }

    public static void lambda$onLoadStarted$26(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i6, AnalyticsListener analyticsListener) {
        analyticsListener.onLoadStarted(eventTime, loadEventInfo, mediaLoadData);
        analyticsListener.onLoadStarted(eventTime, loadEventInfo, mediaLoadData, i6);
    }

    public static void lambda$onPositionDiscontinuity$46(AnalyticsListener.EventTime eventTime, int i6, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, AnalyticsListener analyticsListener) {
        analyticsListener.onPositionDiscontinuity(eventTime, i6);
        analyticsListener.onPositionDiscontinuity(eventTime, positionInfo, positionInfo2, i6);
    }

    public static void lambda$onVideoDecoderInitialized$17(AnalyticsListener.EventTime eventTime, String str, long j10, long j11, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoDecoderInitialized(eventTime, str, j10);
        analyticsListener.onVideoDecoderInitialized(eventTime, str, j11, j10);
    }

    public static void lambda$onVideoSizeChanged$59(AnalyticsListener.EventTime eventTime, VideoSize videoSize, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoSizeChanged(eventTime, videoSize);
        analyticsListener.onVideoSizeChanged(eventTime, videoSize.width, videoSize.height, 0, videoSize.pixelWidthHeightRatio);
    }

    public void lambda$setPlayer$1(Player player, AnalyticsListener analyticsListener, FlagSet flagSet) {
        analyticsListener.onEvents(player, new AnalyticsListener.Events(flagSet, this.eventTimes));
    }

    public void releaseInternal() {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, AnalyticsListener.EVENT_PLAYER_RELEASED, new C0686c(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 0));
        this.listeners.release();
    }

    @Override
    public void addListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.listeners.add(analyticsListener);
    }

    public final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod());
    }

    public final AnalyticsListener.EventTime generateEventTime(Timeline timeline, int i6, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaSource.MediaPeriodId mediaPeriodId2 = timeline.isEmpty() ? null : mediaPeriodId;
        long jElapsedRealtime = this.clock.elapsedRealtime();
        boolean z7 = timeline.equals(this.player.getCurrentTimeline()) && i6 == this.player.getCurrentMediaItemIndex();
        long defaultPositionMs = 0;
        if (mediaPeriodId2 == null || !mediaPeriodId2.isAd()) {
            if (z7) {
                defaultPositionMs = this.player.getContentPosition();
            } else if (!timeline.isEmpty()) {
                defaultPositionMs = timeline.getWindow(i6, this.window).getDefaultPositionMs();
            }
        } else if (z7 && this.player.getCurrentAdGroupIndex() == mediaPeriodId2.adGroupIndex && this.player.getCurrentAdIndexInAdGroup() == mediaPeriodId2.adIndexInAdGroup) {
            defaultPositionMs = this.player.getCurrentPosition();
        }
        return new AnalyticsListener.EventTime(jElapsedRealtime, timeline, i6, mediaPeriodId2, defaultPositionMs, this.player.getCurrentTimeline(), this.player.getCurrentMediaItemIndex(), this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod(), this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
    }

    @Override
    public final void notifySeekStarted() {
        if (this.isSeeking) {
            return;
        }
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        this.isSeeking = true;
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, -1, new C0686c(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 3));
    }

    @Override
    public final void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, 20, new C0684b(eventTimeGenerateReadingMediaPeriodEventTime, 4, audioAttributes));
    }

    @Override
    public final void onAudioCodecError(Exception exc) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_AUDIO_CODEC_ERROR, new C0694k(eventTimeGenerateReadingMediaPeriodEventTime, exc, 2));
    }

    @Override
    public final void onAudioDecoderInitialized(String str, long j10, long j11) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_AUDIO_DECODER_INITIALIZED, new C0697n(eventTimeGenerateReadingMediaPeriodEventTime, str, j11, j10, 0));
    }

    @Override
    public final void onAudioDecoderReleased(String str) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_AUDIO_DECODER_RELEASED, new C0690g(eventTimeGenerateReadingMediaPeriodEventTime, str, 0));
    }

    @Override
    public final void onAudioDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(eventTimeGeneratePlayingMediaPeriodEventTime, AnalyticsListener.EVENT_AUDIO_DISABLED, new C0687d(eventTimeGeneratePlayingMediaPeriodEventTime, decoderCounters, 1));
    }

    @Override
    public final void onAudioEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_AUDIO_ENABLED, new C0687d(eventTimeGenerateReadingMediaPeriodEventTime, decoderCounters, 0));
    }

    @Override
    public final void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_AUDIO_INPUT_FORMAT_CHANGED, new C0703t(eventTimeGenerateReadingMediaPeriodEventTime, format, decoderReuseEvaluation, 1));
    }

    @Override
    public final void onAudioPositionAdvancing(long j10) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_AUDIO_POSITION_ADVANCING, new C0688e(eventTimeGenerateReadingMediaPeriodEventTime, j10, 1));
    }

    @Override
    public final void onAudioSessionIdChanged(int i6) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, 21, new C0691h(eventTimeGenerateReadingMediaPeriodEventTime, i6, 4));
    }

    @Override
    public final void onAudioSinkError(Exception exc) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_AUDIO_SINK_ERROR, new C0694k(eventTimeGenerateReadingMediaPeriodEventTime, exc, 3));
    }

    @Override
    public void onAudioTrackInitialized(AudioSink.AudioTrackConfig audioTrackConfig) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_AUDIO_TRACK_INITIALIZED, new C0704u(eventTimeGenerateReadingMediaPeriodEventTime, audioTrackConfig, 0));
    }

    @Override
    public void onAudioTrackReleased(AudioSink.AudioTrackConfig audioTrackConfig) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_AUDIO_TRACK_RELEASED, new C0704u(eventTimeGenerateReadingMediaPeriodEventTime, audioTrackConfig, 1));
    }

    @Override
    public final void onAudioUnderrun(int i6, long j10, long j11) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_AUDIO_UNDERRUN, new C0692i(eventTimeGenerateReadingMediaPeriodEventTime, i6, j10, j11, 1));
    }

    @Override
    public void onAvailableCommandsChanged(Player.Commands commands) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 13, new C0684b(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 2, commands));
    }

    @Override
    public final void onBandwidthSample(int i6, long j10, long j11) {
        AnalyticsListener.EventTime eventTimeGenerateLoadingMediaPeriodEventTime = generateLoadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateLoadingMediaPeriodEventTime, AnalyticsListener.EVENT_BANDWIDTH_ESTIMATE, new C0692i(eventTimeGenerateLoadingMediaPeriodEventTime, i6, j10, j11, 0));
    }

    @Override
    public void onCues(List<Cue> list) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 27, new C0684b(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 7, list));
    }

    @Override
    public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 29, new C0684b(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 8, deviceInfo));
    }

    @Override
    public void onDeviceVolumeChanged(int i6, boolean z7) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 30, new C0696m(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, i6, z7));
    }

    @Override
    public final void onDownstreamFormatChanged(int i6, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i6, mediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, 1004, new C0701r(eventTimeGenerateMediaPeriodEventTime, mediaLoadData, 0));
    }

    @Override
    public final void onDrmKeysLoaded(int i6, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i6, mediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_KEYS_LOADED, new C0686c(eventTimeGenerateMediaPeriodEventTime, 4));
    }

    @Override
    public final void onDrmKeysRemoved(int i6, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i6, mediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_KEYS_REMOVED, new C0686c(eventTimeGenerateMediaPeriodEventTime, 1));
    }

    @Override
    public final void onDrmKeysRestored(int i6, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i6, mediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_KEYS_RESTORED, new C0686c(eventTimeGenerateMediaPeriodEventTime, 2));
    }

    @Override
    public final void onDrmSessionAcquired(int i6, MediaSource.MediaPeriodId mediaPeriodId, int i10) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i6, mediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, new C0691h(eventTimeGenerateMediaPeriodEventTime, i10, 3));
    }

    @Override
    public final void onDrmSessionManagerError(int i6, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i6, mediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, 1024, new C0694k(eventTimeGenerateMediaPeriodEventTime, exc, 1));
    }

    @Override
    public final void onDrmSessionReleased(int i6, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i6, mediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_SESSION_RELEASED, new C0686c(eventTimeGenerateMediaPeriodEventTime, 5));
    }

    @Override
    public final void onDroppedFrames(int i6, long j10) {
        AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(eventTimeGeneratePlayingMediaPeriodEventTime, AnalyticsListener.EVENT_DROPPED_VIDEO_FRAMES, new C0698o(eventTimeGeneratePlayingMediaPeriodEventTime, i6, j10));
    }

    @Override
    public final void onIsLoadingChanged(boolean z7) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 3, new C0689f(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 0, z7));
    }

    @Override
    public void onIsPlayingChanged(boolean z7) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 7, new C0689f(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 2, z7));
    }

    @Override
    public final void onLoadCanceled(int i6, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i6, mediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, 1002, new C0702s(eventTimeGenerateMediaPeriodEventTime, loadEventInfo, mediaLoadData, 0));
    }

    @Override
    public final void onLoadCompleted(int i6, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i6, mediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, 1001, new C0702s(eventTimeGenerateMediaPeriodEventTime, loadEventInfo, mediaLoadData, 1));
    }

    @Override
    public final void onLoadError(int i6, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z7) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i6, mediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, 1003, new C0695l(eventTimeGenerateMediaPeriodEventTime, loadEventInfo, mediaLoadData, iOException, z7));
    }

    @Override
    public final void onLoadStarted(int i6, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i10) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i6, mediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, 1000, new C0706w(eventTimeGenerateMediaPeriodEventTime, loadEventInfo, mediaLoadData, i10, 1));
    }

    @Override
    public void onMaxSeekToPreviousPositionChanged(long j10) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 18, new C0688e(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, j10, 3));
    }

    @Override
    public final void onMediaItemTransition(MediaItem mediaItem, int i6) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 1, new C0605n(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, mediaItem, i6, 1));
    }

    @Override
    public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 14, new C0705v(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, mediaMetadata, 1));
    }

    @Override
    public final void onMetadata(Metadata metadata) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 28, new C0684b(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 5, metadata));
    }

    @Override
    public final void onPlayWhenReadyChanged(boolean z7, int i6) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 5, new C0696m(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, i6, 2, z7));
    }

    @Override
    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 12, new C0684b(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 0, playbackParameters));
    }

    @Override
    public final void onPlaybackStateChanged(int i6) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 4, new C0691h(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, i6, 2));
    }

    @Override
    public final void onPlaybackSuppressionReasonChanged(int i6) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 6, new C0691h(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, i6, 1));
    }

    @Override
    public final void onPlayerError(PlaybackException playbackException) {
        AnalyticsListener.EventTime eventTimeForErrorEvent = getEventTimeForErrorEvent(playbackException);
        sendEvent(eventTimeForErrorEvent, 10, new C0699p(eventTimeForErrorEvent, playbackException, 1));
    }

    @Override
    public void onPlayerErrorChanged(PlaybackException playbackException) {
        AnalyticsListener.EventTime eventTimeForErrorEvent = getEventTimeForErrorEvent(playbackException);
        sendEvent(eventTimeForErrorEvent, 10, new C0699p(eventTimeForErrorEvent, playbackException, 0));
    }

    @Override
    public final void onPlayerStateChanged(boolean z7, int i6) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, -1, new C0696m(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, i6, 0, z7));
    }

    @Override
    public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 15, new C0705v(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, mediaMetadata, 0));
    }

    @Override
    public void onPositionDiscontinuity(int i6) {
    }

    @Override
    public void onRenderedFirstFrame() {
    }

    @Override
    public void onRendererReadyChanged(final int i6, final int i10, final boolean z7) {
        final AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_RENDERER_READY_CHANGED, new ListenerSet.Event() {
            @Override
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onRendererReadyChanged(eventTimeGenerateReadingMediaPeriodEventTime, i6, i10, z7);
            }
        });
    }

    @Override
    public final void onRepeatModeChanged(int i6) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 8, new C0691h(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, i6, 5));
    }

    @Override
    public void onSeekBackIncrementChanged(long j10) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 16, new C0688e(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, j10, 2));
    }

    @Override
    public void onSeekForwardIncrementChanged(long j10) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 17, new C0688e(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, j10, 0));
    }

    @Override
    public final void onShuffleModeEnabledChanged(boolean z7) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 9, new C0689f(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 3, z7));
    }

    @Override
    public final void onSkipSilenceEnabledChanged(boolean z7) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, 23, new C0689f(eventTimeGenerateReadingMediaPeriodEventTime, 1, z7));
    }

    @Override
    public final void onSurfaceSizeChanged(final int i6, final int i10) {
        final AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, 24, new ListenerSet.Event() {
            @Override
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onSurfaceSizeChanged(eventTimeGenerateReadingMediaPeriodEventTime, i6, i10);
            }
        });
    }

    @Override
    public final void onTimelineChanged(Timeline timeline, int i6) {
        this.mediaPeriodQueueTracker.onTimelineChanged((Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 0, new C0691h(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, i6, 0));
    }

    @Override
    public void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 19, new C0684b(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 1, trackSelectionParameters));
    }

    @Override
    public void onTracksChanged(Tracks tracks) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 2, new C0684b(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 6, tracks));
    }

    @Override
    public final void onUpstreamDiscarded(int i6, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i6, mediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, 1005, new C0701r(eventTimeGenerateMediaPeriodEventTime, mediaLoadData, 1));
    }

    @Override
    public final void onVideoCodecError(Exception exc) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_VIDEO_CODEC_ERROR, new C0694k(eventTimeGenerateReadingMediaPeriodEventTime, exc, 0));
    }

    @Override
    public final void onVideoDecoderInitialized(String str, long j10, long j11) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_VIDEO_DECODER_INITIALIZED, new C0697n(eventTimeGenerateReadingMediaPeriodEventTime, str, j11, j10, 1));
    }

    @Override
    public final void onVideoDecoderReleased(String str) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_VIDEO_DECODER_RELEASED, new C0690g(eventTimeGenerateReadingMediaPeriodEventTime, str, 1));
    }

    @Override
    public final void onVideoDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(eventTimeGeneratePlayingMediaPeriodEventTime, AnalyticsListener.EVENT_VIDEO_DISABLED, new C0687d(eventTimeGeneratePlayingMediaPeriodEventTime, decoderCounters, 2));
    }

    @Override
    public final void onVideoEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_VIDEO_ENABLED, new C0687d(eventTimeGenerateReadingMediaPeriodEventTime, decoderCounters, 3));
    }

    @Override
    public final void onVideoFrameProcessingOffset(long j10, int i6) {
        AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(eventTimeGeneratePlayingMediaPeriodEventTime, AnalyticsListener.EVENT_VIDEO_FRAME_PROCESSING_OFFSET, new C0698o(eventTimeGeneratePlayingMediaPeriodEventTime, j10, i6));
    }

    @Override
    public final void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_VIDEO_INPUT_FORMAT_CHANGED, new C0703t(eventTimeGenerateReadingMediaPeriodEventTime, format, decoderReuseEvaluation, 0));
    }

    @Override
    public final void onVideoSizeChanged(VideoSize videoSize) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, 25, new C0684b(eventTimeGenerateReadingMediaPeriodEventTime, 9, videoSize));
    }

    @Override
    public final void onVolumeChanged(final float f) {
        final AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, 22, new ListenerSet.Event() {
            @Override
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onVolumeChanged(eventTimeGenerateReadingMediaPeriodEventTime, f);
            }
        });
    }

    @Override
    public void release() {
        ((HandlerWrapper) Assertions.checkStateNotNull(this.handler)).post(new RunnableC0001b(5, this));
    }

    @Override
    public void removeListener(AnalyticsListener analyticsListener) {
        this.listeners.remove(analyticsListener);
    }

    public final void sendEvent(AnalyticsListener.EventTime eventTime, int i6, ListenerSet.Event<AnalyticsListener> event) {
        this.eventTimes.put(i6, eventTime);
        this.listeners.sendEvent(i6, event);
    }

    @Override
    public void setPlayer(Player player, Looper looper) {
        Assertions.checkState(this.player == null || this.mediaPeriodQueueTracker.mediaPeriodQueue.isEmpty());
        this.player = (Player) Assertions.checkNotNull(player);
        this.handler = this.clock.createHandler(looper, null);
        this.listeners = this.listeners.copy(looper, new C0684b(this, 3, player));
    }

    @Deprecated
    public void setThrowsWhenUsingWrongThread(boolean z7) {
        this.listeners.setThrowsWhenUsingWrongThread(z7);
    }

    @Override
    public final void updateMediaPeriodQueueInfo(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onQueueUpdated(list, mediaPeriodId, (Player) Assertions.checkNotNull(this.player));
    }

    @Override
    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i6) {
        if (i6 == 1) {
            this.isSeeking = false;
        }
        this.mediaPeriodQueueTracker.onPositionDiscontinuity((Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 11, new C0706w(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, positionInfo, positionInfo2, i6));
    }

    @Override
    public final void onRenderedFirstFrame(Object obj, long j10) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, 26, new C0707x(j10, eventTimeGenerateReadingMediaPeriodEventTime, obj));
    }

    @Override
    public void onCues(CueGroup cueGroup) {
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 27, new C0684b(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 10, cueGroup));
    }

    private AnalyticsListener.EventTime generateEventTime(MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.checkNotNull(this.player);
        Timeline mediaPeriodIdTimeline = mediaPeriodId == null ? null : this.mediaPeriodQueueTracker.getMediaPeriodIdTimeline(mediaPeriodId);
        if (mediaPeriodId != null && mediaPeriodIdTimeline != null) {
            return generateEventTime(mediaPeriodIdTimeline, mediaPeriodIdTimeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, mediaPeriodId);
        }
        int currentMediaItemIndex = this.player.getCurrentMediaItemIndex();
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (currentMediaItemIndex >= currentTimeline.getWindowCount()) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, currentMediaItemIndex, null);
    }

    @Override
    public void onLoadingChanged(boolean z7) {
    }

    public static void lambda$new$0(AnalyticsListener analyticsListener, FlagSet flagSet) {
    }

    @Override
    public void onEvents(Player player, Player.Events events) {
    }
}
