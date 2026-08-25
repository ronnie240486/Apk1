package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C0565C;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import p020b7.InterfaceC1339e0;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;
import p041d7.C2288s1;

final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList.MediaSourceListInfoRefreshListener, DefaultMediaClock.PlaybackParametersListener, PlayerMessage.Sender, AudioFocusManager.PlayerControl {
    private static final long BUFFERING_MAXIMUM_INTERVAL_MS = Util.usToMs(Renderer.DEFAULT_DURATION_TO_PROGRESS_US);
    private static final int MSG_ADD_MEDIA_SOURCES = 18;
    private static final int MSG_ATTEMPT_RENDERER_ERROR_RECOVERY = 25;
    private static final int MSG_AUDIO_FOCUS_PLAYER_COMMAND = 33;
    private static final int MSG_AUDIO_FOCUS_VOLUME_MULTIPLIER = 34;
    private static final int MSG_DO_SOME_WORK = 2;
    private static final int MSG_MOVE_MEDIA_SOURCES = 19;
    private static final int MSG_PERIOD_PREPARED = 8;
    private static final int MSG_PLAYBACK_PARAMETERS_CHANGED_INTERNAL = 16;
    private static final int MSG_PLAYLIST_UPDATE_REQUESTED = 22;
    private static final int MSG_PREPARE = 29;
    private static final int MSG_RELEASE = 7;
    private static final int MSG_REMOVE_MEDIA_SOURCES = 20;
    private static final int MSG_RENDERER_CAPABILITIES_CHANGED = 26;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SEND_MESSAGE = 14;
    private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 15;
    private static final int MSG_SET_AUDIO_ATTRIBUTES = 31;
    private static final int MSG_SET_FOREGROUND_MODE = 13;
    private static final int MSG_SET_MEDIA_SOURCES = 17;
    private static final int MSG_SET_PAUSE_AT_END_OF_WINDOW = 23;
    private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SET_PRELOAD_CONFIGURATION = 28;
    private static final int MSG_SET_REPEAT_MODE = 11;
    private static final int MSG_SET_SEEK_PARAMETERS = 5;
    private static final int MSG_SET_SHUFFLE_ENABLED = 12;
    private static final int MSG_SET_SHUFFLE_ORDER = 21;
    private static final int MSG_SET_VIDEO_OUTPUT = 30;
    private static final int MSG_SET_VOLUME = 32;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 9;
    private static final int MSG_STOP = 6;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 10;
    private static final int MSG_UPDATE_MEDIA_SOURCES_WITH_MEDIA_ITEMS = 27;
    private static final long PLAYBACK_BUFFER_EMPTY_THRESHOLD_US = 500000;
    private static final long PLAYBACK_STUCK_AFTER_MS = 4000;
    private static final long READY_MAXIMUM_INTERVAL_MS = 1000;
    private static final String TAG = "ExoPlayerImplInternal";
    private final AnalyticsCollector analyticsCollector;
    private final HandlerWrapper applicationLooperHandler;
    private final AudioFocusManager audioFocusManager;
    private final long backBufferDurationUs;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    private boolean deliverPendingMessageAtStartPositionRequired;
    private final boolean dynamicSchedulingEnabled;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private int enabledRendererCount;
    private boolean foregroundMode;
    private final HandlerWrapper handler;
    private final boolean hasSecondaryRenderers;
    private boolean isPrewarmingDisabledUntilNextTransition;
    private boolean isRebuffering;
    private final LivePlaybackSpeedControl livePlaybackSpeedControl;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private final MediaSourceList mediaSourceList;
    private int nextPendingMessageIndexHint;
    private boolean offloadSchedulingEnabled;
    private boolean pauseAtEndOfWindow;
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList<PendingMessageInfo> pendingMessages;
    private boolean pendingPauseAtEndOfPeriod;
    private ExoPlaybackException pendingRecoverableRendererError;
    private final Timeline.Period period;
    private PlaybackInfo playbackInfo;
    private PlaybackInfoUpdate playbackInfoUpdate;
    private final PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private final Looper playbackLooper;
    private final PlaybackLooperProvider playbackLooperProvider;
    private final PlayerId playerId;
    private ExoPlayer.PreloadConfiguration preloadConfiguration;
    private final MediaPeriodQueue queue;
    private final long releaseTimeoutMs;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionElapsedRealtimeUs;
    private long rendererPositionUs;
    private final boolean[] rendererReportedReady;
    private final RendererHolder[] renderers;
    private int repeatMode;
    private boolean requestForRendererSleep;
    private final boolean retainBackBufferFromKeyframe;
    private SeekParameters seekParameters;
    private long setForegroundModeTimeoutMs;
    private boolean shouldContinueLoading;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;
    private long prewarmingMediaPeriodDiscontinuity = C0565C.TIME_UNSET;
    private float volume = 1.0f;
    private long playbackMaybeBecameStuckAtMs = C0565C.TIME_UNSET;
    private long lastRebufferRealtimeMs = C0565C.TIME_UNSET;
    private Timeline lastPreloadPoolInvalidationTimeline = Timeline.EMPTY;

    public static final class MediaSourceListUpdateMessage {
        private final List<MediaSourceList.MediaSourceHolder> mediaSourceHolders;
        private final long positionUs;
        private final ShuffleOrder shuffleOrder;
        private final int windowIndex;

        private MediaSourceListUpdateMessage(List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder, int i6, long j10) {
            this.mediaSourceHolders = list;
            this.shuffleOrder = shuffleOrder;
            this.windowIndex = i6;
            this.positionUs = j10;
        }
    }

    public static class MoveMediaItemsMessage {
        public final int fromIndex;
        public final int newFromIndex;
        public final ShuffleOrder shuffleOrder;
        public final int toIndex;

        public MoveMediaItemsMessage(int i6, int i10, int i11, ShuffleOrder shuffleOrder) {
            this.fromIndex = i6;
            this.toIndex = i10;
            this.newFromIndex = i11;
            this.shuffleOrder = shuffleOrder;
        }
    }

    public static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        public void setResolvedPosition(int i6, long j10, Object obj) {
            this.resolvedPeriodIndex = i6;
            this.resolvedPeriodTimeUs = j10;
            this.resolvedPeriodUid = obj;
        }

        @Override
        public int compareTo(PendingMessageInfo pendingMessageInfo) {
            Object obj = this.resolvedPeriodUid;
            if ((obj == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i6 = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
            return i6 != 0 ? i6 : Util.compareLong(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
        }
    }

    public static final class PlaybackInfoUpdate {
        public int discontinuityReason;
        private boolean hasPendingChange;
        public int operationAcks;
        public PlaybackInfo playbackInfo;
        public boolean positionDiscontinuity;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo) {
            this.playbackInfo = playbackInfo;
        }

        public void incrementPendingOperationAcks(int i6) {
            this.hasPendingChange |= i6 > 0;
            this.operationAcks += i6;
        }

        public void setPlaybackInfo(PlaybackInfo playbackInfo) {
            this.hasPendingChange |= this.playbackInfo != playbackInfo;
            this.playbackInfo = playbackInfo;
        }

        public void setPositionDiscontinuity(int i6) {
            if (this.positionDiscontinuity && this.discontinuityReason != 5) {
                Assertions.checkArgument(i6 == 5);
                return;
            }
            this.hasPendingChange = true;
            this.positionDiscontinuity = true;
            this.discontinuityReason = i6;
        }
    }

    public interface PlaybackInfoUpdateListener {
        void onPlaybackInfoUpdate(PlaybackInfoUpdate playbackInfoUpdate);
    }

    public static final class PositionUpdateForPlaylistChange {
        public final boolean endPlayback;
        public final boolean forceBufferingState;
        public final MediaSource.MediaPeriodId periodId;
        public final long periodPositionUs;
        public final long requestedContentPositionUs;
        public final boolean setTargetLiveOffset;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long j10, long j11, boolean z7, boolean z10, boolean z11) {
            this.periodId = mediaPeriodId;
            this.periodPositionUs = j10;
            this.requestedContentPositionUs = j11;
            this.forceBufferingState = z7;
            this.endPlayback = z10;
            this.setTargetLiveOffset = z11;
        }
    }

    public static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline, int i6, long j10) {
            this.timeline = timeline;
            this.windowIndex = i6;
            this.windowPositionUs = j10;
        }
    }

    public ExoPlayerImplInternal(Context context, Renderer[] rendererArr, Renderer[] rendererArr2, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i6, boolean z7, AnalyticsCollector analyticsCollector, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long j10, boolean z10, boolean z11, Looper looper, Clock clock, PlaybackInfoUpdateListener playbackInfoUpdateListener, PlayerId playerId, PlaybackLooperProvider playbackLooperProvider, ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.playbackInfoUpdateListener = playbackInfoUpdateListener;
        this.trackSelector = trackSelector;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl;
        this.bandwidthMeter = bandwidthMeter;
        this.repeatMode = i6;
        this.shuffleModeEnabled = z7;
        this.seekParameters = seekParameters;
        this.livePlaybackSpeedControl = livePlaybackSpeedControl;
        this.releaseTimeoutMs = j10;
        this.setForegroundModeTimeoutMs = j10;
        this.pauseAtEndOfWindow = z10;
        this.dynamicSchedulingEnabled = z11;
        this.clock = clock;
        this.playerId = playerId;
        this.preloadConfiguration = preloadConfiguration;
        this.analyticsCollector = analyticsCollector;
        this.backBufferDurationUs = loadControl.getBackBufferDurationUs(playerId);
        this.retainBackBufferFromKeyframe = loadControl.retainBackBufferFromKeyframe(playerId);
        PlaybackInfo playbackInfoCreateDummy = PlaybackInfo.createDummy(trackSelectorResult);
        this.playbackInfo = playbackInfoCreateDummy;
        this.playbackInfoUpdate = new PlaybackInfoUpdate(playbackInfoCreateDummy);
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        this.rendererReportedReady = new boolean[rendererArr.length];
        RendererCapabilities.Listener rendererCapabilitiesListener = trackSelector.getRendererCapabilitiesListener();
        this.renderers = new RendererHolder[rendererArr.length];
        boolean z12 = false;
        for (int i10 = 0; i10 < rendererArr.length; i10++) {
            rendererArr[i10].init(i10, playerId, clock);
            this.rendererCapabilities[i10] = rendererArr[i10].getCapabilities();
            if (rendererCapabilitiesListener != null) {
                this.rendererCapabilities[i10].setListener(rendererCapabilitiesListener);
            }
            Renderer renderer = rendererArr2[i10];
            if (renderer != null) {
                renderer.init(rendererArr.length + i10, playerId, clock);
                z12 = true;
            }
            this.renderers[i10] = new RendererHolder(rendererArr[i10], rendererArr2[i10], i10);
        }
        this.hasSecondaryRenderers = z12;
        this.mediaClock = new DefaultMediaClock(this, clock);
        this.pendingMessages = new ArrayList<>();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector.init(this, bandwidthMeter);
        this.deliverPendingMessageAtStartPositionRequired = true;
        HandlerWrapper handlerWrapperCreateHandler = clock.createHandler(looper, null);
        this.applicationLooperHandler = handlerWrapperCreateHandler;
        this.queue = new MediaPeriodQueue(analyticsCollector, handlerWrapperCreateHandler, new C0970v(9, this), preloadConfiguration);
        this.mediaSourceList = new MediaSourceList(this, analyticsCollector, handlerWrapperCreateHandler, playerId);
        PlaybackLooperProvider playbackLooperProvider2 = playbackLooperProvider == null ? new PlaybackLooperProvider() : playbackLooperProvider;
        this.playbackLooperProvider = playbackLooperProvider2;
        Looper looperObtainLooper = playbackLooperProvider2.obtainLooper();
        this.playbackLooper = looperObtainLooper;
        this.handler = clock.createHandler(looperObtainLooper, this);
        this.audioFocusManager = new AudioFocusManager(context, looperObtainLooper, this);
    }

    private void addMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i6) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.mediaSourceList;
        if (i6 == -1) {
            i6 = mediaSourceList.getSize();
        }
        handleMediaSourceListInfoRefreshed(mediaSourceList.addMediaSources(i6, mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    private void allowRenderersToRenderStartOfStreams() {
        TrackSelectorResult trackSelectorResult = this.queue.getPlayingPeriod().getTrackSelectorResult();
        for (int i6 = 0; i6 < this.renderers.length; i6++) {
            if (trackSelectorResult.isRendererEnabled(i6)) {
                this.renderers[i6].enableMayRenderStartOfStream();
            }
        }
    }

    private boolean areRenderersPrewarming() {
        if (!this.hasSecondaryRenderers) {
            return false;
        }
        for (RendererHolder rendererHolder : this.renderers) {
            if (rendererHolder.isPrewarming()) {
                return true;
            }
        }
        return false;
    }

    private void attemptRendererErrorRecovery() throws ExoPlaybackException {
        reselectTracksInternalAndSeek();
    }

    public MediaPeriodHolder createMediaPeriodHolder(MediaPeriodInfo mediaPeriodInfo, long j10) {
        return new MediaPeriodHolder(this.rendererCapabilities, j10, this.trackSelector, this.loadControl.getAllocator(), this.mediaSourceList, mediaPeriodInfo, this.emptyTrackSelectorResult, this.preloadConfiguration.targetPreloadDurationUs);
    }

    private void deliverMessage(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.isCanceled()) {
            return;
        }
        try {
            playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
        } finally {
            playerMessage.markAsProcessed(true);
        }
    }

    private void disableAndResetPrewarmingRenderers() {
        if (this.hasSecondaryRenderers && areRenderersPrewarming()) {
            for (RendererHolder rendererHolder : this.renderers) {
                int enabledRendererCount = rendererHolder.getEnabledRendererCount();
                rendererHolder.disablePrewarming(this.mediaClock);
                this.enabledRendererCount -= enabledRendererCount - rendererHolder.getEnabledRendererCount();
            }
            this.prewarmingMediaPeriodDiscontinuity = C0565C.TIME_UNSET;
        }
    }

    private void disableRenderer(int i6) throws ExoPlaybackException {
        int enabledRendererCount = this.renderers[i6].getEnabledRendererCount();
        this.renderers[i6].disable(this.mediaClock);
        maybeTriggerOnRendererReadyChanged(i6, false);
        this.enabledRendererCount -= enabledRendererCount;
    }

    private void disableRenderers() throws ExoPlaybackException {
        for (int i6 = 0; i6 < this.renderers.length; i6++) {
            disableRenderer(i6);
        }
        this.prewarmingMediaPeriodDiscontinuity = C0565C.TIME_UNSET;
    }

    private void doSomeWork() throws ExoPlaybackException, IOException {
        boolean z7;
        boolean z10;
        int i6;
        long jUptimeMillis = this.clock.uptimeMillis();
        this.handler.removeMessages(2);
        updatePeriods();
        int i10 = this.playbackInfo.playbackState;
        if (i10 == 1 || i10 == 4) {
            return;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            scheduleNextWork(jUptimeMillis);
            return;
        }
        TraceUtil.beginSection("doSomeWork");
        updatePlaybackPositions();
        if (playingPeriod.prepared) {
            this.rendererPositionElapsedRealtimeUs = Util.msToUs(this.clock.elapsedRealtime());
            playingPeriod.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
            int i11 = 0;
            z7 = true;
            z10 = true;
            while (true) {
                RendererHolder[] rendererHolderArr = this.renderers;
                if (i11 >= rendererHolderArr.length) {
                    break;
                }
                RendererHolder rendererHolder = rendererHolderArr[i11];
                if (rendererHolder.getEnabledRendererCount() == 0) {
                    maybeTriggerOnRendererReadyChanged(i11, false);
                } else {
                    rendererHolder.render(this.rendererPositionUs, this.rendererPositionElapsedRealtimeUs);
                    z7 = z7 && rendererHolder.isEnded();
                    boolean zAllowsPlayback = rendererHolder.allowsPlayback(playingPeriod);
                    maybeTriggerOnRendererReadyChanged(i11, zAllowsPlayback);
                    z10 = z10 && zAllowsPlayback;
                    if (!zAllowsPlayback) {
                        maybeThrowRendererStreamError(i11);
                    }
                }
                i11++;
            }
        } else {
            playingPeriod.mediaPeriod.maybeThrowPrepareError();
            z7 = true;
            z10 = true;
        }
        long j10 = playingPeriod.info.durationUs;
        boolean z11 = z7 && playingPeriod.prepared && (j10 == C0565C.TIME_UNSET || j10 <= this.playbackInfo.positionUs);
        if (z11 && this.pendingPauseAtEndOfPeriod) {
            this.pendingPauseAtEndOfPeriod = false;
            setPlayWhenReadyInternal(false, this.playbackInfo.playbackSuppressionReason, false, 5);
        }
        if (z11 && playingPeriod.info.isFinal) {
            setState(4);
            stopRenderers();
        } else if (this.playbackInfo.playbackState == 2 && shouldTransitionToReadyState(z10)) {
            setState(3);
            this.pendingRecoverableRendererError = null;
            if (shouldPlayWhenReady()) {
                updateRebufferingState(false, false);
                this.mediaClock.start();
                startRenderers();
            }
        } else if (this.playbackInfo.playbackState == 3 && (this.enabledRendererCount != 0 ? !z10 : !isTimelineReady())) {
            updateRebufferingState(shouldPlayWhenReady(), false);
            setState(2);
            if (this.isRebuffering) {
                notifyTrackSelectionRebuffer();
                this.livePlaybackSpeedControl.notifyRebuffer();
            }
            stopRenderers();
        }
        if (this.playbackInfo.playbackState == 2) {
            int i12 = 0;
            while (true) {
                RendererHolder[] rendererHolderArr2 = this.renderers;
                if (i12 >= rendererHolderArr2.length) {
                    break;
                }
                if (rendererHolderArr2[i12].isReadingFromPeriod(playingPeriod)) {
                    maybeThrowRendererStreamError(i12);
                }
                i12++;
            }
            PlaybackInfo playbackInfo = this.playbackInfo;
            if (playbackInfo.isLoading || playbackInfo.totalBufferedDurationUs >= PLAYBACK_BUFFER_EMPTY_THRESHOLD_US || !isLoadingPossible(this.queue.getLoadingPeriod()) || !shouldPlayWhenReady()) {
                this.playbackMaybeBecameStuckAtMs = C0565C.TIME_UNSET;
            } else if (this.playbackMaybeBecameStuckAtMs == C0565C.TIME_UNSET) {
                this.playbackMaybeBecameStuckAtMs = this.clock.elapsedRealtime();
            } else if (this.clock.elapsedRealtime() - this.playbackMaybeBecameStuckAtMs >= PLAYBACK_STUCK_AFTER_MS) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        } else {
            this.playbackMaybeBecameStuckAtMs = C0565C.TIME_UNSET;
        }
        boolean z12 = shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
        boolean z13 = this.offloadSchedulingEnabled && this.requestForRendererSleep && z12;
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.sleepingForOffload != z13) {
            this.playbackInfo = playbackInfo2.copyWithSleepingForOffload(z13);
        }
        this.requestForRendererSleep = false;
        if (!z13 && (i6 = this.playbackInfo.playbackState) != 4 && (z12 || i6 == 2 || (i6 == 3 && this.enabledRendererCount != 0))) {
            scheduleNextWork(jUptimeMillis);
        }
        TraceUtil.endSection();
    }

    private void enableRenderer(MediaPeriodHolder mediaPeriodHolder, int i6, boolean z7, long j10) throws ExoPlaybackException {
        RendererHolder rendererHolder = this.renderers[i6];
        if (rendererHolder.isRendererEnabled()) {
            return;
        }
        boolean z10 = mediaPeriodHolder == this.queue.getPlayingPeriod();
        TrackSelectorResult trackSelectorResult = mediaPeriodHolder.getTrackSelectorResult();
        RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i6];
        ExoTrackSelection exoTrackSelection = trackSelectorResult.selections[i6];
        boolean z11 = shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
        boolean z12 = !z7 && z11;
        this.enabledRendererCount++;
        rendererHolder.enable(rendererConfiguration, exoTrackSelection, mediaPeriodHolder.sampleStreams[i6], this.rendererPositionUs, z12, z10, j10, mediaPeriodHolder.getRendererOffset(), mediaPeriodHolder.info.f2678id, this.mediaClock);
        rendererHolder.handleMessage(11, new Renderer.WakeupListener() {
            @Override
            public void onSleep() {
                ExoPlayerImplInternal.this.requestForRendererSleep = true;
            }

            @Override
            public void onWakeup() {
                if (ExoPlayerImplInternal.this.dynamicSchedulingEnabled || ExoPlayerImplInternal.this.offloadSchedulingEnabled) {
                    ExoPlayerImplInternal.this.handler.sendEmptyMessage(2);
                }
            }
        }, mediaPeriodHolder);
        if (z11 && z10) {
            rendererHolder.start();
        }
    }

    private void enableRenderers() throws ExoPlaybackException {
        enableRenderers(new boolean[this.renderers.length], this.queue.getReadingPeriod().getStartPositionRendererTime());
    }

    private AbstractC2301u1 extractMetadataFromTrackSelectionArray(ExoTrackSelection[] exoTrackSelectionArr) {
        C2288s1 c2288s1 = new C2288s1(4);
        boolean z7 = false;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                Metadata metadata = exoTrackSelection.getFormat(0).metadata;
                if (metadata == null) {
                    c2288s1.m5255a(new Metadata(new Metadata.Entry[0]));
                } else {
                    c2288s1.m5255a(metadata);
                    z7 = true;
                }
            }
        }
        if (z7) {
            return c2288s1.m5262g();
        }
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        return C2180c5.f7862e;
    }

    private long getCurrentLiveOffsetUs() {
        PlaybackInfo playbackInfo = this.playbackInfo;
        return getLiveOffsetUs(playbackInfo.timeline, playbackInfo.periodId.periodUid, playbackInfo.positionUs);
    }

    private long getLiveOffsetUs(Timeline timeline, Object obj, long j10) {
        timeline.getWindow(timeline.getPeriodByUid(obj, this.period).windowIndex, this.window);
        Timeline.Window window = this.window;
        if (window.windowStartTimeMs != C0565C.TIME_UNSET && window.isLive()) {
            Timeline.Window window2 = this.window;
            if (window2.isDynamic) {
                return Util.msToUs(window2.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - (this.period.getPositionInWindowUs() + j10);
            }
        }
        return C0565C.TIME_UNSET;
    }

    private long getMaxRendererReadPositionUs(MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder == null) {
            return 0L;
        }
        long rendererOffset = mediaPeriodHolder.getRendererOffset();
        if (!mediaPeriodHolder.prepared) {
            return rendererOffset;
        }
        int i6 = 0;
        while (true) {
            RendererHolder[] rendererHolderArr = this.renderers;
            if (i6 >= rendererHolderArr.length) {
                return rendererOffset;
            }
            if (rendererHolderArr[i6].isReadingFromPeriod(mediaPeriodHolder)) {
                long readingPositionUs = this.renderers[i6].getReadingPositionUs(mediaPeriodHolder);
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                rendererOffset = Math.max(readingPositionUs, rendererOffset);
            }
            i6++;
        }
    }

    private Pair<MediaSource.MediaPeriodId, Long> getPlaceholderFirstMediaPeriodPositionUs(Timeline timeline) {
        if (timeline.isEmpty()) {
            return Pair.create(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L);
        }
        Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.window, this.period, timeline.getFirstWindowIndex(this.shuffleModeEnabled), C0565C.TIME_UNSET);
        MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = this.queue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline, periodPositionUs.first, 0L);
        long jLongValue = ((Long) periodPositionUs.second).longValue();
        if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
            timeline.getPeriodByUid(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, this.period);
            jLongValue = mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup == this.period.getFirstAdIndexToPlay(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex) ? this.period.getAdResumePositionUs() : 0L;
        }
        return Pair.create(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, Long.valueOf(jLongValue));
    }

    private long getTotalBufferedDurationUs() {
        return getTotalBufferedDurationUs(this.playbackInfo.bufferedPositionUs);
    }

    private void handleAudioFocusPlayerCommandInternal(int i6) throws ExoPlaybackException {
        PlaybackInfo playbackInfo = this.playbackInfo;
        updatePlayWhenReadyWithAudioFocus(playbackInfo.playWhenReady, i6, playbackInfo.playbackSuppressionReason, playbackInfo.playWhenReadyChangeReason);
    }

    private void handleAudioFocusVolumeMultiplierChange() throws ExoPlaybackException {
        setVolumeInternal(this.volume);
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.queue.isLoading(mediaPeriod)) {
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
        } else if (this.queue.isPreloading(mediaPeriod)) {
            maybeContinuePreloading();
        }
    }

    private void handleIoException(IOException iOException, int i6) {
        ExoPlaybackException exoPlaybackExceptionCreateForSource = ExoPlaybackException.createForSource(iOException, i6);
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            exoPlaybackExceptionCreateForSource = exoPlaybackExceptionCreateForSource.copyWithMediaPeriodId(playingPeriod.info.f2678id);
        }
        Log.m1716e(TAG, "Playback error", exoPlaybackExceptionCreateForSource);
        stopInternal(false, false);
        this.playbackInfo = this.playbackInfo.copyWithPlaybackError(exoPlaybackExceptionCreateForSource);
    }

    private void handleLoadingMediaPeriodChanged(boolean z7) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaSource.MediaPeriodId mediaPeriodId = loadingPeriod == null ? this.playbackInfo.periodId : loadingPeriod.info.f2678id;
        boolean zEquals = this.playbackInfo.loadingMediaPeriodId.equals(mediaPeriodId);
        if (!zEquals) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaPeriodId);
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        playbackInfo.bufferedPositionUs = loadingPeriod == null ? playbackInfo.positionUs : loadingPeriod.getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if ((!zEquals || z7) && loadingPeriod != null && loadingPeriod.prepared) {
            updateLoadControlTrackSelection(loadingPeriod.info.f2678id, loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
        }
    }

    private void handleLoadingPeriodPrepared(MediaPeriodHolder mediaPeriodHolder) throws ExoPlaybackException {
        if (!mediaPeriodHolder.prepared) {
            float f = this.mediaClock.getPlaybackParameters().speed;
            PlaybackInfo playbackInfo = this.playbackInfo;
            mediaPeriodHolder.handlePrepared(f, playbackInfo.timeline, playbackInfo.playWhenReady);
        }
        updateLoadControlTrackSelection(mediaPeriodHolder.info.f2678id, mediaPeriodHolder.getTrackGroups(), mediaPeriodHolder.getTrackSelectorResult());
        if (mediaPeriodHolder == this.queue.getPlayingPeriod()) {
            resetRendererPosition(mediaPeriodHolder.info.startPositionUs);
            enableRenderers();
            mediaPeriodHolder.allRenderersInCorrectState = true;
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            MediaSource.MediaPeriodId mediaPeriodId = playbackInfo2.periodId;
            long j10 = mediaPeriodHolder.info.startPositionUs;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j10, playbackInfo2.requestedContentPositionUs, j10, false, 5);
        }
        maybeContinueLoading();
    }

    private void handleMediaSourceListInfoRefreshed(Timeline timeline, boolean z7) throws Throwable {
        SeekPosition seekPosition;
        boolean z10;
        long j10;
        long jSeekToPeriodPosition;
        PositionUpdateForPlaylistChange positionUpdateForPlaylistChangeResolvePositionForPlaylistChange = resolvePositionForPlaylistChange(timeline, this.playbackInfo, this.pendingInitialSeekPosition, this.queue, this.repeatMode, this.shuffleModeEnabled, this.window, this.period);
        MediaSource.MediaPeriodId mediaPeriodId = positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.periodId;
        long j11 = positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.requestedContentPositionUs;
        boolean z11 = positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.forceBufferingState;
        long j12 = positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.periodPositionUs;
        boolean z12 = (this.playbackInfo.periodId.equals(mediaPeriodId) && j12 == this.playbackInfo.positionUs) ? false : true;
        try {
            if (positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.endPlayback) {
                if (this.playbackInfo.playbackState != 1) {
                    setState(4);
                }
                resetInternal(false, false, false, true);
            }
            for (RendererHolder rendererHolder : this.renderers) {
                rendererHolder.setTimeline(timeline);
            }
            try {
                if (z12) {
                    j10 = j11;
                    z10 = false;
                    jSeekToPeriodPosition = j12;
                    if (!timeline.isEmpty()) {
                        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
                            if (playingPeriod.info.f2678id.equals(mediaPeriodId)) {
                                playingPeriod.info = this.queue.getUpdatedMediaPeriodInfo(timeline, playingPeriod.info);
                                playingPeriod.updateClipping();
                            }
                        }
                        jSeekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, jSeekToPeriodPosition, z11);
                    }
                } else {
                    try {
                        z10 = false;
                        j10 = j11;
                        jSeekToPeriodPosition = j12;
                        int iUpdateQueuedPeriods = this.queue.updateQueuedPeriods(timeline, this.rendererPositionUs, this.queue.getReadingPeriod() == null ? 0L : getMaxRendererReadPositionUs(this.queue.getReadingPeriod()), (!areRenderersPrewarming() || this.queue.getPrewarmingPeriod() == null) ? 0L : getMaxRendererReadPositionUs(this.queue.getPrewarmingPeriod()));
                        if ((iUpdateQueuedPeriods & 1) != 0) {
                            seekToCurrentPosition(false);
                        } else if ((iUpdateQueuedPeriods & 2) != 0) {
                            disableAndResetPrewarmingRenderers();
                        }
                    } catch (Throwable th) {
                        th = th;
                        j11 = j12;
                        seekPosition = null;
                        PlaybackInfo playbackInfo = this.playbackInfo;
                        SeekPosition seekPosition2 = seekPosition;
                        updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaPeriodId, playbackInfo.timeline, playbackInfo.periodId, positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.setTargetLiveOffset ? j11 : -9223372036854775807L, false);
                        if (z12 || j11 != this.playbackInfo.requestedContentPositionUs) {
                            PlaybackInfo playbackInfo2 = this.playbackInfo;
                            Object obj = playbackInfo2.periodId.periodUid;
                            Timeline timeline2 = playbackInfo2.timeline;
                            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j11, j11, this.playbackInfo.discontinuityStartPositionUs, z12 && z7 && !timeline2.isEmpty() && !timeline2.getPeriodByUid(obj, this.period).isPlaceholder, timeline.getIndexOfPeriod(obj) == -1 ? 4 : 3);
                        }
                        resetPendingPauseAtEndOfPeriod();
                        resolvePendingMessagePositions(timeline, this.playbackInfo.timeline);
                        this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline);
                        if (!timeline.isEmpty()) {
                            this.pendingInitialSeekPosition = seekPosition2;
                        }
                        handleLoadingMediaPeriodChanged(false);
                        this.handler.sendEmptyMessage(2);
                        throw th;
                    }
                }
                PlaybackInfo playbackInfo3 = this.playbackInfo;
                updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaPeriodId, playbackInfo3.timeline, playbackInfo3.periodId, positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.setTargetLiveOffset ? jSeekToPeriodPosition : -9223372036854775807L, false);
                if (z12 || j10 != this.playbackInfo.requestedContentPositionUs) {
                    PlaybackInfo playbackInfo4 = this.playbackInfo;
                    Object obj2 = playbackInfo4.periodId.periodUid;
                    Timeline timeline3 = playbackInfo4.timeline;
                    this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, jSeekToPeriodPosition, j10, this.playbackInfo.discontinuityStartPositionUs, z12 && z7 && !timeline3.isEmpty() && !timeline3.getPeriodByUid(obj2, this.period).isPlaceholder, timeline.getIndexOfPeriod(obj2) == -1 ? 4 : 3);
                }
                resetPendingPauseAtEndOfPeriod();
                resolvePendingMessagePositions(timeline, this.playbackInfo.timeline);
                this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline);
                if (!timeline.isEmpty()) {
                    this.pendingInitialSeekPosition = null;
                }
                handleLoadingMediaPeriodChanged(z10);
                this.handler.sendEmptyMessage(2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            j11 = j12;
            seekPosition = null;
        }
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.queue.isLoading(mediaPeriod)) {
            handleLoadingPeriodPrepared((MediaPeriodHolder) Assertions.checkNotNull(this.queue.getLoadingPeriod()));
            return;
        }
        MediaPeriodHolder preloadHolderByMediaPeriod = this.queue.getPreloadHolderByMediaPeriod(mediaPeriod);
        if (preloadHolderByMediaPeriod != null) {
            Assertions.checkState(!preloadHolderByMediaPeriod.prepared);
            float f = this.mediaClock.getPlaybackParameters().speed;
            PlaybackInfo playbackInfo = this.playbackInfo;
            preloadHolderByMediaPeriod.handlePrepared(f, playbackInfo.timeline, playbackInfo.playWhenReady);
            if (this.queue.isPreloading(mediaPeriod)) {
                maybeContinuePreloading();
            }
        }
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, boolean z7) throws ExoPlaybackException {
        handlePlaybackParameters(playbackParameters, playbackParameters.speed, true, z7);
    }

    private PlaybackInfo handlePositionDiscontinuity(MediaSource.MediaPeriodId mediaPeriodId, long j10, long j11, long j12, boolean z7, int i6) {
        List<Metadata> list;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        this.deliverPendingMessageAtStartPositionRequired = (!this.deliverPendingMessageAtStartPositionRequired && j10 == this.playbackInfo.positionUs && mediaPeriodId.equals(this.playbackInfo.periodId)) ? false : true;
        resetPendingPauseAtEndOfPeriod();
        PlaybackInfo playbackInfo = this.playbackInfo;
        TrackGroupArray trackGroupArray2 = playbackInfo.trackGroups;
        TrackSelectorResult trackSelectorResult2 = playbackInfo.trackSelectorResult;
        List<Metadata> list2 = playbackInfo.staticMetadata;
        if (this.mediaSourceList.isPrepared()) {
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            TrackGroupArray trackGroups = playingPeriod == null ? TrackGroupArray.EMPTY : playingPeriod.getTrackGroups();
            TrackSelectorResult trackSelectorResult3 = playingPeriod == null ? this.emptyTrackSelectorResult : playingPeriod.getTrackSelectorResult();
            AbstractC2301u1 abstractC2301u1ExtractMetadataFromTrackSelectionArray = extractMetadataFromTrackSelectionArray(trackSelectorResult3.selections);
            if (playingPeriod != null) {
                MediaPeriodInfo mediaPeriodInfo = playingPeriod.info;
                if (mediaPeriodInfo.requestedContentPositionUs != j11) {
                    playingPeriod.info = mediaPeriodInfo.copyWithRequestedContentPositionUs(j11);
                }
            }
            maybeUpdateOffloadScheduling();
            trackGroupArray = trackGroups;
            trackSelectorResult = trackSelectorResult3;
            list = abstractC2301u1ExtractMetadataFromTrackSelectionArray;
        } else if (mediaPeriodId.equals(this.playbackInfo.periodId)) {
            list = list2;
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult2;
        } else {
            TrackGroupArray trackGroupArray3 = TrackGroupArray.EMPTY;
            TrackSelectorResult trackSelectorResult4 = this.emptyTrackSelectorResult;
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            trackGroupArray = trackGroupArray3;
            trackSelectorResult = trackSelectorResult4;
            list = C2180c5.f7862e;
        }
        if (z7) {
            this.playbackInfoUpdate.setPositionDiscontinuity(i6);
        }
        return this.playbackInfo.copyWithNewPosition(mediaPeriodId, j10, j11, j12, getTotalBufferedDurationUs(), trackGroupArray, trackSelectorResult, list);
    }

    private boolean hasReadingPeriodFinishedReading() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (!readingPeriod.prepared) {
            return false;
        }
        int i6 = 0;
        while (true) {
            RendererHolder[] rendererHolderArr = this.renderers;
            if (i6 >= rendererHolderArr.length) {
                return true;
            }
            if (!rendererHolderArr[i6].hasFinishedReadingFromPeriod(readingPeriod)) {
                return false;
            }
            i6++;
        }
    }

    private static boolean isIgnorableServerSideAdInsertionPeriodChange(boolean z7, MediaSource.MediaPeriodId mediaPeriodId, long j10, MediaSource.MediaPeriodId mediaPeriodId2, Timeline.Period period, long j11) {
        if (z7 || j10 != j11 || !mediaPeriodId.periodUid.equals(mediaPeriodId2.periodUid)) {
            return false;
        }
        if (mediaPeriodId.isAd() && period.isServerSideInsertedAdGroup(mediaPeriodId.adGroupIndex)) {
            return (period.getAdState(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup) == 4 || period.getAdState(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup) == 2) ? false : true;
        }
        return mediaPeriodId2.isAd() && period.isServerSideInsertedAdGroup(mediaPeriodId2.adGroupIndex);
    }

    private boolean isLoadingPossible(MediaPeriodHolder mediaPeriodHolder) {
        return (mediaPeriodHolder == null || mediaPeriodHolder.hasLoadingError() || mediaPeriodHolder.getNextLoadPositionUs() == Long.MIN_VALUE) ? false : true;
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long j10 = playingPeriod.info.durationUs;
        return playingPeriod.prepared && (j10 == C0565C.TIME_UNSET || this.playbackInfo.positionUs < j10 || !shouldPlayWhenReady());
    }

    private static boolean isUsingPlaceholderPeriod(PlaybackInfo playbackInfo, Timeline.Period period) {
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
        Timeline timeline = playbackInfo.timeline;
        return timeline.isEmpty() || timeline.getPeriodByUid(mediaPeriodId.periodUid, period).isPlaceholder;
    }

    public void lambda$maybeTriggerOnRendererReadyChanged$1(int i6, boolean z7) {
        this.analyticsCollector.onRendererReadyChanged(i6, this.renderers[i6].getTrackType(), z7);
    }

    public Boolean lambda$release$0() {
        return Boolean.valueOf(this.released);
    }

    public void lambda$sendMessageToTargetThread$2(PlayerMessage playerMessage) {
        try {
            deliverMessage(playerMessage);
        } catch (ExoPlaybackException e5) {
            Log.m1716e(TAG, "Unexpected error delivering message on external thread.", e5);
            throw new RuntimeException(e5);
        }
    }

    private void maybeContinueLoading() {
        boolean zShouldContinueLoading = shouldContinueLoading();
        this.shouldContinueLoading = zShouldContinueLoading;
        if (zShouldContinueLoading) {
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkNotNull(this.queue.getLoadingPeriod());
            mediaPeriodHolder.continueLoading(new LoadingInfo.Builder().setPlaybackPositionUs(mediaPeriodHolder.toPeriodTime(this.rendererPositionUs)).setPlaybackSpeed(this.mediaClock.getPlaybackParameters().speed).setLastRebufferRealtimeMs(this.lastRebufferRealtimeMs).build());
        }
        updateIsLoading();
    }

    private void maybeContinuePreloading() {
        this.queue.maybeUpdatePreloadMediaPeriodHolder();
        MediaPeriodHolder preloadingPeriod = this.queue.getPreloadingPeriod();
        if (preloadingPeriod != null) {
            if ((!preloadingPeriod.prepareCalled || preloadingPeriod.prepared) && !preloadingPeriod.mediaPeriod.isLoading()) {
                if (this.loadControl.shouldContinuePreloading(this.playbackInfo.timeline, preloadingPeriod.info.f2678id, preloadingPeriod.prepared ? preloadingPeriod.mediaPeriod.getBufferedPositionUs() : 0L)) {
                    if (preloadingPeriod.prepareCalled) {
                        preloadingPeriod.continueLoading(new LoadingInfo.Builder().setPlaybackPositionUs(preloadingPeriod.toPeriodTime(this.rendererPositionUs)).setPlaybackSpeed(this.mediaClock.getPlaybackParameters().speed).setLastRebufferRealtimeMs(this.lastRebufferRealtimeMs).build());
                    } else {
                        preloadingPeriod.prepare(this, preloadingPeriod.info.startPositionUs);
                    }
                }
            }
        }
    }

    private void maybeHandlePrewarmingTransition() throws ExoPlaybackException {
        for (RendererHolder rendererHolder : this.renderers) {
            rendererHolder.maybeHandlePrewarmingTransition();
        }
    }

    private void maybeNotifyPlaybackInfoChanged() {
        this.playbackInfoUpdate.setPlaybackInfo(this.playbackInfo);
        if (this.playbackInfoUpdate.hasPendingChange) {
            this.playbackInfoUpdateListener.onPlaybackInfoUpdate(this.playbackInfoUpdate);
            this.playbackInfoUpdate = new PlaybackInfoUpdate(this.playbackInfo);
        }
    }

    private void maybePrewarmRenderers() throws ExoPlaybackException {
        MediaPeriodHolder prewarmingPeriod = this.queue.getPrewarmingPeriod();
        if (prewarmingPeriod == null) {
            return;
        }
        TrackSelectorResult trackSelectorResult = prewarmingPeriod.getTrackSelectorResult();
        for (int i6 = 0; i6 < this.renderers.length; i6++) {
            if (trackSelectorResult.isRendererEnabled(i6) && this.renderers[i6].hasSecondary() && !this.renderers[i6].isPrewarming()) {
                this.renderers[i6].startPrewarming();
                enableRenderer(prewarmingPeriod, i6, false, prewarmingPeriod.getStartPositionRendererTime());
            }
        }
        if (areRenderersPrewarming()) {
            this.prewarmingMediaPeriodDiscontinuity = prewarmingPeriod.mediaPeriod.readDiscontinuity();
            if (prewarmingPeriod.isFullyBuffered()) {
                return;
            }
            this.queue.removeAfter(prewarmingPeriod);
            handleLoadingMediaPeriodChanged(false);
            maybeContinueLoading();
        }
    }

    private void maybeThrowRendererStreamError(int i6) throws ExoPlaybackException, IOException {
        RendererHolder rendererHolder = this.renderers[i6];
        try {
            rendererHolder.maybeThrowStreamError((MediaPeriodHolder) Assertions.checkNotNull(this.queue.getPlayingPeriod()));
        } catch (IOException | RuntimeException e5) {
            int trackType = rendererHolder.getTrackType();
            if (trackType != 3 && trackType != 5) {
                throw e5;
            }
            TrackSelectorResult trackSelectorResult = this.queue.getPlayingPeriod().getTrackSelectorResult();
            Log.m1716e(TAG, "Disabling track due to error: " + Format.toLogString(trackSelectorResult.selections[i6].getSelectedFormat()), e5);
            TrackSelectorResult trackSelectorResult2 = new TrackSelectorResult((RendererConfiguration[]) trackSelectorResult.rendererConfigurations.clone(), (ExoTrackSelection[]) trackSelectorResult.selections.clone(), trackSelectorResult.tracks, trackSelectorResult.info);
            trackSelectorResult2.rendererConfigurations[i6] = null;
            trackSelectorResult2.selections[i6] = null;
            disableRenderer(i6);
            this.queue.getPlayingPeriod().applyTrackSelection(trackSelectorResult2, this.playbackInfo.positionUs, false);
        }
    }

    private void maybeTriggerOnRendererReadyChanged(final int i6, final boolean z7) {
        boolean[] zArr = this.rendererReportedReady;
        if (zArr[i6] != z7) {
            zArr[i6] = z7;
            this.applicationLooperHandler.post(new Runnable() {
                @Override
                public final void run() {
                    this.f2880a.lambda$maybeTriggerOnRendererReadyChanged$1(i6, z7);
                }
            });
        }
    }

    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void maybeTriggerPendingMessages(long j10, long j11) throws ExoPlaybackException {
        if (this.pendingMessages.isEmpty() || this.playbackInfo.periodId.isAd()) {
            return;
        }
        if (this.deliverPendingMessageAtStartPositionRequired) {
            j10--;
            this.deliverPendingMessageAtStartPositionRequired = false;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        int indexOfPeriod = playbackInfo.timeline.getIndexOfPeriod(playbackInfo.periodId.periodUid);
        int iMin = Math.min(this.nextPendingMessageIndexHint, this.pendingMessages.size());
        PendingMessageInfo pendingMessageInfo = iMin > 0 ? this.pendingMessages.get(iMin - 1) : null;
        while (pendingMessageInfo != null) {
            int i6 = pendingMessageInfo.resolvedPeriodIndex;
            if (i6 <= indexOfPeriod && (i6 != indexOfPeriod || pendingMessageInfo.resolvedPeriodTimeUs <= j10)) {
                break;
            }
            int i10 = iMin - 1;
            pendingMessageInfo = i10 > 0 ? this.pendingMessages.get(iMin - 2) : null;
            iMin = i10;
        }
        if (iMin < this.pendingMessages.size()) {
            PendingMessageInfo pendingMessageInfo2 = this.pendingMessages.get(iMin);
            while (pendingMessageInfo2 != null && pendingMessageInfo2.resolvedPeriodUid != null) {
                int i11 = pendingMessageInfo2.resolvedPeriodIndex;
                if (i11 >= indexOfPeriod && (i11 != indexOfPeriod || pendingMessageInfo2.resolvedPeriodTimeUs > j10)) {
                    break;
                }
                iMin++;
                pendingMessageInfo2 = iMin < this.pendingMessages.size() ? this.pendingMessages.get(iMin) : null;
            }
            while (pendingMessageInfo2 != null && pendingMessageInfo2.resolvedPeriodUid != null && pendingMessageInfo2.resolvedPeriodIndex == indexOfPeriod) {
                long j12 = pendingMessageInfo2.resolvedPeriodTimeUs;
                if (j12 <= j10 || j12 > j11) {
                    break;
                }
                try {
                    sendMessageToTarget(pendingMessageInfo2.message);
                    if (pendingMessageInfo2.message.getDeleteAfterDelivery() || pendingMessageInfo2.message.isCanceled()) {
                        this.pendingMessages.remove(iMin);
                    } else {
                        iMin++;
                    }
                    pendingMessageInfo2 = iMin < this.pendingMessages.size() ? this.pendingMessages.get(iMin) : null;
                } catch (Throwable th) {
                    if (pendingMessageInfo2.message.getDeleteAfterDelivery() || pendingMessageInfo2.message.isCanceled()) {
                        this.pendingMessages.remove(iMin);
                    }
                    throw th;
                }
            }
            this.nextPendingMessageIndexHint = iMin;
        }
    }

    private boolean maybeUpdateLoadingPeriod() throws ExoPlaybackException {
        MediaPeriodInfo nextMediaPeriodInfo;
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        boolean z7 = false;
        if (this.queue.shouldLoadNextMediaPeriod() && (nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo)) != null) {
            MediaPeriodHolder mediaPeriodHolderEnqueueNextMediaPeriodHolder = this.queue.enqueueNextMediaPeriodHolder(nextMediaPeriodInfo);
            if (!mediaPeriodHolderEnqueueNextMediaPeriodHolder.prepareCalled) {
                mediaPeriodHolderEnqueueNextMediaPeriodHolder.prepare(this, nextMediaPeriodInfo.startPositionUs);
            } else if (mediaPeriodHolderEnqueueNextMediaPeriodHolder.prepared) {
                this.handler.obtainMessage(8, mediaPeriodHolderEnqueueNextMediaPeriodHolder.mediaPeriod).sendToTarget();
            }
            if (this.queue.getPlayingPeriod() == mediaPeriodHolderEnqueueNextMediaPeriodHolder) {
                resetRendererPosition(nextMediaPeriodInfo.startPositionUs);
            }
            handleLoadingMediaPeriodChanged(false);
            z7 = true;
        }
        if (this.shouldContinueLoading) {
            this.shouldContinueLoading = isLoadingPossible(this.queue.getLoadingPeriod());
            updateIsLoading();
        } else {
            maybeContinueLoading();
        }
        return z7;
    }

    private void maybeUpdateOffloadScheduling() {
        MediaPeriodHolder playingPeriod;
        boolean z7;
        if (this.queue.getPlayingPeriod() == this.queue.getReadingPeriod() && (playingPeriod = this.queue.getPlayingPeriod()) != null) {
            TrackSelectorResult trackSelectorResult = playingPeriod.getTrackSelectorResult();
            boolean z10 = false;
            int i6 = 0;
            boolean z11 = false;
            while (true) {
                if (i6 >= this.renderers.length) {
                    z7 = true;
                    break;
                }
                if (trackSelectorResult.isRendererEnabled(i6)) {
                    if (this.renderers[i6].getTrackType() != 1) {
                        z7 = false;
                        break;
                    } else if (trackSelectorResult.rendererConfigurations[i6].offloadModePreferred != 0) {
                        z11 = true;
                    }
                }
                i6++;
            }
            if (z11 && z7) {
                z10 = true;
            }
            setOffloadSchedulingEnabled(z10);
        }
    }

    private void maybeUpdatePlayingPeriod() throws ExoPlaybackException {
        boolean z7;
        boolean z10 = false;
        while (shouldAdvancePlayingPeriod()) {
            if (z10) {
                maybeNotifyPlaybackInfoChanged();
            }
            this.isPrewarmingDisabledUntilNextTransition = false;
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkNotNull(this.queue.advancePlayingPeriod());
            if (this.playbackInfo.periodId.periodUid.equals(mediaPeriodHolder.info.f2678id.periodUid)) {
                MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
                if (mediaPeriodId.adGroupIndex == -1) {
                    MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodHolder.info.f2678id;
                    if (mediaPeriodId2.adGroupIndex != -1 || mediaPeriodId.nextAdGroupIndex == mediaPeriodId2.nextAdGroupIndex) {
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                } else {
                    z7 = false;
                }
            } else {
                z7 = false;
            }
            MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodInfo.f2678id;
            long j10 = mediaPeriodInfo.startPositionUs;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId3, j10, mediaPeriodInfo.requestedContentPositionUs, j10, !z7, 0);
            resetPendingPauseAtEndOfPeriod();
            updatePlaybackPositions();
            if (areRenderersPrewarming() && mediaPeriodHolder == this.queue.getPrewarmingPeriod()) {
                maybeHandlePrewarmingTransition();
            }
            if (this.playbackInfo.playbackState == 3) {
                startRenderers();
            }
            allowRenderersToRenderStartOfStreams();
            z10 = true;
        }
    }

    private void maybeUpdatePreloadPeriods(boolean z7) {
        if (this.preloadConfiguration.targetPreloadDurationUs == C0565C.TIME_UNSET) {
            return;
        }
        if (z7 || !this.playbackInfo.timeline.equals(this.lastPreloadPoolInvalidationTimeline)) {
            Timeline timeline = this.playbackInfo.timeline;
            this.lastPreloadPoolInvalidationTimeline = timeline;
            this.queue.invalidatePreloadPool(timeline);
        }
        maybeContinuePreloading();
    }

    private void maybeUpdatePrewarmingPeriod() throws ExoPlaybackException {
        MediaPeriodHolder prewarmingPeriod;
        if (this.pendingPauseAtEndOfPeriod || !this.hasSecondaryRenderers || this.isPrewarmingDisabledUntilNextTransition || areRenderersPrewarming() || (prewarmingPeriod = this.queue.getPrewarmingPeriod()) == null || prewarmingPeriod != this.queue.getReadingPeriod() || prewarmingPeriod.getNext() == null || !prewarmingPeriod.getNext().prepared) {
            return;
        }
        this.queue.advancePrewarmingPeriod();
        maybePrewarmRenderers();
    }

    private void maybeUpdateReadingPeriod() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return;
        }
        int i6 = 0;
        if (readingPeriod.getNext() == null || this.pendingPauseAtEndOfPeriod) {
            if (readingPeriod.info.isFinal || this.pendingPauseAtEndOfPeriod) {
                RendererHolder[] rendererHolderArr = this.renderers;
                int length = rendererHolderArr.length;
                while (i6 < length) {
                    RendererHolder rendererHolder = rendererHolderArr[i6];
                    if (rendererHolder.isReadingFromPeriod(readingPeriod) && rendererHolder.hasReadPeriodToEnd(readingPeriod)) {
                        long j10 = readingPeriod.info.durationUs;
                        rendererHolder.setCurrentStreamFinal(readingPeriod, (j10 == C0565C.TIME_UNSET || j10 == Long.MIN_VALUE) ? -9223372036854775807L : readingPeriod.getRendererOffset() + readingPeriod.info.durationUs);
                    }
                    i6++;
                }
                return;
            }
            return;
        }
        if (hasReadingPeriodFinishedReading()) {
            if (areRenderersPrewarming() && this.queue.getPrewarmingPeriod() == this.queue.getReadingPeriod()) {
                return;
            }
            if (readingPeriod.getNext().prepared || this.rendererPositionUs >= readingPeriod.getNext().getStartPositionRendererTime()) {
                TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
                MediaPeriodHolder mediaPeriodHolderAdvanceReadingPeriod = this.queue.advanceReadingPeriod();
                TrackSelectorResult trackSelectorResult2 = mediaPeriodHolderAdvanceReadingPeriod.getTrackSelectorResult();
                Timeline timeline = this.playbackInfo.timeline;
                updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaPeriodHolderAdvanceReadingPeriod.info.f2678id, timeline, readingPeriod.info.f2678id, C0565C.TIME_UNSET, false);
                if (mediaPeriodHolderAdvanceReadingPeriod.prepared && ((this.hasSecondaryRenderers && this.prewarmingMediaPeriodDiscontinuity != C0565C.TIME_UNSET) || mediaPeriodHolderAdvanceReadingPeriod.mediaPeriod.readDiscontinuity() != C0565C.TIME_UNSET)) {
                    this.prewarmingMediaPeriodDiscontinuity = C0565C.TIME_UNSET;
                    boolean z7 = this.hasSecondaryRenderers && !this.isPrewarmingDisabledUntilNextTransition;
                    if (z7) {
                        for (int i10 = 0; i10 < this.renderers.length; i10++) {
                            if (trackSelectorResult2.isRendererEnabled(i10) && !MimeTypes.allSamplesAreSyncSamples(trackSelectorResult2.selections[i10].getSelectedFormat().sampleMimeType, trackSelectorResult2.selections[i10].getSelectedFormat().codecs) && !this.renderers[i10].isPrewarming()) {
                                z7 = false;
                                break;
                            }
                        }
                    }
                    if (!z7) {
                        setAllNonPrewarmingRendererStreamsFinal(mediaPeriodHolderAdvanceReadingPeriod.getStartPositionRendererTime());
                        if (mediaPeriodHolderAdvanceReadingPeriod.isFullyBuffered()) {
                            return;
                        }
                        this.queue.removeAfter(mediaPeriodHolderAdvanceReadingPeriod);
                        handleLoadingMediaPeriodChanged(false);
                        maybeContinueLoading();
                        return;
                    }
                }
                RendererHolder[] rendererHolderArr2 = this.renderers;
                int length2 = rendererHolderArr2.length;
                while (i6 < length2) {
                    rendererHolderArr2[i6].maybeSetOldStreamToFinal(trackSelectorResult, trackSelectorResult2, mediaPeriodHolderAdvanceReadingPeriod.getStartPositionRendererTime());
                    i6++;
                }
            }
        }
    }

    private void maybeUpdateReadingRenderers() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null || this.queue.getPlayingPeriod() == readingPeriod || readingPeriod.allRenderersInCorrectState || !updateRenderersForTransition()) {
            return;
        }
        this.queue.getReadingPeriod().allRenderersInCorrectState = true;
    }

    private void mediaSourceListUpdateRequestedInternal() throws Throwable {
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.createTimeline(), true);
    }

    private void moveMediaItemsInternal(MoveMediaItemsMessage moveMediaItemsMessage) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.moveMediaSourceRange(moveMediaItemsMessage.fromIndex, moveMediaItemsMessage.toIndex, moveMediaItemsMessage.newFromIndex, moveMediaItemsMessage.shuffleOrder), false);
    }

    private void notifyTrackSelectionDiscontinuity() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onDiscontinuity();
                }
            }
        }
    }

    private void notifyTrackSelectionPlayWhenReadyChanged(boolean z7) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlayWhenReadyChanged(z7);
                }
            }
        }
    }

    private void notifyTrackSelectionRebuffer() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onRebuffer();
                }
            }
        }
    }

    private void prepareInternal() throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        resetInternal(false, false, false, true);
        this.loadControl.onPrepared(this.playerId);
        setState(this.playbackInfo.timeline.isEmpty() ? 4 : 2);
        updatePlayWhenReadyWithAudioFocus();
        this.mediaSourceList.prepare(this.bandwidthMeter.getTransferListener());
        this.handler.sendEmptyMessage(2);
    }

    private void releaseInternal() {
        try {
            resetInternal(true, false, true, false);
            releaseRenderers();
            this.loadControl.onReleased(this.playerId);
            this.audioFocusManager.release();
            this.trackSelector.release();
            setState(1);
            this.playbackLooperProvider.releaseLooper();
            synchronized (this) {
                this.released = true;
                notifyAll();
            }
        } catch (Throwable th) {
            this.playbackLooperProvider.releaseLooper();
            synchronized (this) {
                this.released = true;
                notifyAll();
                throw th;
            }
        }
    }

    private void releaseRenderers() {
        for (int i6 = 0; i6 < this.renderers.length; i6++) {
            this.rendererCapabilities[i6].clearListener();
            this.renderers[i6].release();
        }
    }

    private void removeMediaItemsInternal(int i6, int i10, ShuffleOrder shuffleOrder) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.removeMediaSourceRange(i6, i10, shuffleOrder), false);
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        float f = this.mediaClock.getPlaybackParameters().speed;
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        int i6 = 1;
        TrackSelectorResult trackSelectorResult = null;
        boolean z7 = true;
        while (playingPeriod != null && playingPeriod.prepared) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            TrackSelectorResult trackSelectorResultSelectTracks = playingPeriod.selectTracks(f, playbackInfo.timeline, playbackInfo.playWhenReady);
            if (playingPeriod == this.queue.getPlayingPeriod()) {
                trackSelectorResult = trackSelectorResultSelectTracks;
            }
            if (!trackSelectorResultSelectTracks.isEquivalent(playingPeriod.getTrackSelectorResult())) {
                if (z7) {
                    MediaPeriodHolder playingPeriod2 = this.queue.getPlayingPeriod();
                    boolean z10 = (this.queue.removeAfter(playingPeriod2) & i6) != 0;
                    boolean[] zArr = new boolean[this.renderers.length];
                    long jApplyTrackSelection = playingPeriod2.applyTrackSelection((TrackSelectorResult) Assertions.checkNotNull(trackSelectorResult), this.playbackInfo.positionUs, z10, zArr);
                    PlaybackInfo playbackInfo2 = this.playbackInfo;
                    boolean z11 = (playbackInfo2.playbackState == 4 || jApplyTrackSelection == playbackInfo2.positionUs) ? false : true;
                    PlaybackInfo playbackInfo3 = this.playbackInfo;
                    this.playbackInfo = handlePositionDiscontinuity(playbackInfo3.periodId, jApplyTrackSelection, playbackInfo3.requestedContentPositionUs, playbackInfo3.discontinuityStartPositionUs, z11, 5);
                    if (z11) {
                        resetRendererPosition(jApplyTrackSelection);
                    }
                    disableAndResetPrewarmingRenderers();
                    boolean[] zArr2 = new boolean[this.renderers.length];
                    int i10 = 0;
                    while (true) {
                        RendererHolder[] rendererHolderArr = this.renderers;
                        if (i10 >= rendererHolderArr.length) {
                            break;
                        }
                        int enabledRendererCount = rendererHolderArr[i10].getEnabledRendererCount();
                        zArr2[i10] = this.renderers[i10].isRendererEnabled();
                        this.renderers[i10].maybeDisableOrResetPosition(playingPeriod2.sampleStreams[i10], this.mediaClock, this.rendererPositionUs, zArr[i10]);
                        if (enabledRendererCount - this.renderers[i10].getEnabledRendererCount() > 0) {
                            maybeTriggerOnRendererReadyChanged(i10, false);
                        }
                        this.enabledRendererCount -= enabledRendererCount - this.renderers[i10].getEnabledRendererCount();
                        i10++;
                    }
                    enableRenderers(zArr2, this.rendererPositionUs);
                    playingPeriod2.allRenderersInCorrectState = true;
                } else {
                    this.queue.removeAfter(playingPeriod);
                    if (playingPeriod.prepared) {
                        long jMax = Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs));
                        if (this.hasSecondaryRenderers && areRenderersPrewarming() && this.queue.getPrewarmingPeriod() == playingPeriod) {
                            disableAndResetPrewarmingRenderers();
                        }
                        playingPeriod.applyTrackSelection(trackSelectorResultSelectTracks, jMax, false);
                    }
                }
                handleLoadingMediaPeriodChanged(true);
                if (this.playbackInfo.playbackState != 4) {
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (playingPeriod == readingPeriod) {
                z7 = false;
            }
            playingPeriod = playingPeriod.getNext();
            i6 = 1;
        }
    }

    private void reselectTracksInternalAndSeek() throws ExoPlaybackException {
        reselectTracksInternal();
        seekToCurrentPosition(true);
    }

    private void resetInternal(boolean z7, boolean z10, boolean z11, boolean z12) {
        long j10;
        long j11;
        Timeline timeline;
        MediaSource.MediaPeriodId mediaPeriodId;
        List list;
        this.handler.removeMessages(2);
        this.pendingRecoverableRendererError = null;
        boolean z13 = true;
        updateRebufferingState(false, true);
        this.mediaClock.stop();
        this.rendererPositionUs = MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US;
        try {
            disableRenderers();
        } catch (ExoPlaybackException | RuntimeException e5) {
            Log.m1716e(TAG, "Disable failed.", e5);
        }
        if (z7) {
            for (RendererHolder rendererHolder : this.renderers) {
                try {
                    rendererHolder.reset();
                } catch (RuntimeException e10) {
                    Log.m1716e(TAG, "Reset failed.", e10);
                }
            }
        }
        this.enabledRendererCount = 0;
        PlaybackInfo playbackInfo = this.playbackInfo;
        MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo.periodId;
        long jLongValue = playbackInfo.positionUs;
        long j12 = (this.playbackInfo.periodId.isAd() || isUsingPlaceholderPeriod(this.playbackInfo, this.period)) ? this.playbackInfo.requestedContentPositionUs : this.playbackInfo.positionUs;
        if (z10) {
            this.pendingInitialSeekPosition = null;
            Pair<MediaSource.MediaPeriodId, Long> placeholderFirstMediaPeriodPositionUs = getPlaceholderFirstMediaPeriodPositionUs(this.playbackInfo.timeline);
            mediaPeriodId2 = (MediaSource.MediaPeriodId) placeholderFirstMediaPeriodPositionUs.first;
            jLongValue = ((Long) placeholderFirstMediaPeriodPositionUs.second).longValue();
            boolean zEquals = mediaPeriodId2.equals(this.playbackInfo.periodId);
            j12 = C0565C.TIME_UNSET;
            if (zEquals) {
                j10 = jLongValue;
                j11 = j12;
                z13 = false;
            } else {
                j10 = jLongValue;
                j11 = -9223372036854775807L;
            }
        } else {
            j10 = jLongValue;
            j11 = j12;
            z13 = false;
        }
        this.queue.clear();
        this.shouldContinueLoading = false;
        Timeline timelineCopyWithPlaceholderTimeline = this.playbackInfo.timeline;
        if (z11 && (timelineCopyWithPlaceholderTimeline instanceof PlaylistTimeline)) {
            timelineCopyWithPlaceholderTimeline = ((PlaylistTimeline) timelineCopyWithPlaceholderTimeline).copyWithPlaceholderTimeline(this.mediaSourceList.getShuffleOrder());
            if (mediaPeriodId2.adGroupIndex != -1) {
                timelineCopyWithPlaceholderTimeline.getPeriodByUid(mediaPeriodId2.periodUid, this.period);
                if (timelineCopyWithPlaceholderTimeline.getWindow(this.period.windowIndex, this.window).isLive()) {
                    timeline = timelineCopyWithPlaceholderTimeline;
                    mediaPeriodId = new MediaSource.MediaPeriodId(mediaPeriodId2.periodUid, mediaPeriodId2.windowSequenceNumber);
                } else {
                    timeline = timelineCopyWithPlaceholderTimeline;
                    mediaPeriodId = mediaPeriodId2;
                }
            } else {
                timeline = timelineCopyWithPlaceholderTimeline;
                mediaPeriodId = mediaPeriodId2;
            }
        } else {
            timeline = timelineCopyWithPlaceholderTimeline;
            mediaPeriodId = mediaPeriodId2;
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        int i6 = playbackInfo2.playbackState;
        ExoPlaybackException exoPlaybackException = z12 ? null : playbackInfo2.playbackError;
        TrackGroupArray trackGroupArray = z13 ? TrackGroupArray.EMPTY : playbackInfo2.trackGroups;
        TrackSelectorResult trackSelectorResult = z13 ? this.emptyTrackSelectorResult : playbackInfo2.trackSelectorResult;
        if (z13) {
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            list = C2180c5.f7862e;
        } else {
            list = playbackInfo2.staticMetadata;
        }
        this.playbackInfo = new PlaybackInfo(timeline, mediaPeriodId, j11, j10, i6, exoPlaybackException, false, trackGroupArray, trackSelectorResult, list, mediaPeriodId, playbackInfo2.playWhenReady, playbackInfo2.playWhenReadyChangeReason, playbackInfo2.playbackSuppressionReason, playbackInfo2.playbackParameters, j10, 0L, j10, 0L, false);
        if (z11) {
            this.queue.releasePreloadPool();
            this.mediaSourceList.release();
        }
    }

    private void resetPendingPauseAtEndOfPeriod() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        this.pendingPauseAtEndOfPeriod = playingPeriod != null && playingPeriod.info.isLastInTimelineWindow && this.pauseAtEndOfWindow;
    }

    private void resetRendererPosition(long j10) throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long rendererTime = playingPeriod == null ? j10 + MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : playingPeriod.toRendererTime(j10);
        this.rendererPositionUs = rendererTime;
        this.mediaClock.resetPosition(rendererTime);
        for (RendererHolder rendererHolder : this.renderers) {
            rendererHolder.resetPosition(playingPeriod, this.rendererPositionUs);
        }
        notifyTrackSelectionDiscontinuity();
    }

    private static void resolvePendingMessageEndOfStreamPosition(Timeline timeline, PendingMessageInfo pendingMessageInfo, Timeline.Window window, Timeline.Period period) {
        int i6 = timeline.getWindow(timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, window).lastPeriodIndex;
        Object obj = timeline.getPeriod(i6, period, true).uid;
        long j10 = period.durationUs;
        pendingMessageInfo.setResolvedPosition(i6, j10 != C0565C.TIME_UNSET ? j10 - 1 : Long.MAX_VALUE, obj);
    }

    private static boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo, Timeline timeline, Timeline timeline2, int i6, boolean z7, Timeline.Window window, Timeline.Period period) {
        Object obj = pendingMessageInfo.resolvedPeriodUid;
        if (obj == null) {
            Pair<Object, Long> pairResolveSeekPositionUs = resolveSeekPositionUs(timeline, new SeekPosition(pendingMessageInfo.message.getTimeline(), pendingMessageInfo.message.getMediaItemIndex(), pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE ? C0565C.TIME_UNSET : Util.msToUs(pendingMessageInfo.message.getPositionMs())), false, i6, z7, window, period);
            if (pairResolveSeekPositionUs == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(timeline.getIndexOfPeriod(pairResolveSeekPositionUs.first), ((Long) pairResolveSeekPositionUs.second).longValue(), pairResolveSeekPositionUs.first);
            if (pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE) {
                resolvePendingMessageEndOfStreamPosition(timeline, pendingMessageInfo, window, period);
            }
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        if (indexOfPeriod == -1) {
            return false;
        }
        if (pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE) {
            resolvePendingMessageEndOfStreamPosition(timeline, pendingMessageInfo, window, period);
            return true;
        }
        pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod;
        timeline2.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period);
        if (period.isPlaceholder && timeline2.getWindow(period.windowIndex, window).firstPeriodIndex == timeline2.getIndexOfPeriod(pendingMessageInfo.resolvedPeriodUid)) {
            Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, period.getPositionInWindowUs() + pendingMessageInfo.resolvedPeriodTimeUs);
            pendingMessageInfo.setResolvedPosition(timeline.getIndexOfPeriod(periodPositionUs.first), ((Long) periodPositionUs.second).longValue(), periodPositionUs.first);
        }
        return true;
    }

    private void resolvePendingMessagePositions(Timeline timeline, Timeline timeline2) {
        if (timeline.isEmpty() && timeline2.isEmpty()) {
            return;
        }
        for (int size = this.pendingMessages.size() - 1; size >= 0; size--) {
            if (!resolvePendingMessagePosition(this.pendingMessages.get(size), timeline, timeline2, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                this.pendingMessages.get(size).message.markAsProcessed(false);
                this.pendingMessages.remove(size);
            }
        }
        Collections.sort(this.pendingMessages);
    }

    private static PositionUpdateForPlaylistChange resolvePositionForPlaylistChange(Timeline timeline, PlaybackInfo playbackInfo, SeekPosition seekPosition, MediaPeriodQueue mediaPeriodQueue, int i6, boolean z7, Timeline.Window window, Timeline.Period period) {
        MediaSource.MediaPeriodId mediaPeriodId;
        int i10;
        int i11;
        boolean z10;
        boolean z11;
        boolean z12;
        int firstWindowIndex;
        boolean z13;
        long j10;
        int i12;
        boolean z14;
        int firstWindowIndex2;
        boolean z15;
        boolean z16;
        if (timeline.isEmpty()) {
            return new PositionUpdateForPlaylistChange(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L, C0565C.TIME_UNSET, false, true, false);
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo.periodId;
        Object obj = mediaPeriodId2.periodUid;
        boolean zIsUsingPlaceholderPeriod = isUsingPlaceholderPeriod(playbackInfo, period);
        long jLongValue = (playbackInfo.periodId.isAd() || zIsUsingPlaceholderPeriod) ? playbackInfo.requestedContentPositionUs : playbackInfo.positionUs;
        if (seekPosition != null) {
            i10 = -1;
            Pair<Object, Long> pairResolveSeekPositionUs = resolveSeekPositionUs(timeline, seekPosition, true, i6, z7, window, period);
            if (pairResolveSeekPositionUs == null) {
                firstWindowIndex2 = timeline.getFirstWindowIndex(z7);
                jLongValue = jLongValue;
                z14 = false;
                z15 = false;
                z16 = true;
            } else {
                if (seekPosition.windowPositionUs == C0565C.TIME_UNSET) {
                    firstWindowIndex2 = timeline.getPeriodByUid(pairResolveSeekPositionUs.first, period).windowIndex;
                    jLongValue = jLongValue;
                    z14 = false;
                } else {
                    obj = pairResolveSeekPositionUs.first;
                    jLongValue = ((Long) pairResolveSeekPositionUs.second).longValue();
                    z14 = true;
                    firstWindowIndex2 = -1;
                }
                z15 = playbackInfo.playbackState == 4;
                z16 = false;
            }
            z12 = z14;
            z10 = z15;
            z11 = z16;
            i11 = firstWindowIndex2;
            mediaPeriodId = mediaPeriodId2;
        } else {
            mediaPeriodId = mediaPeriodId2;
            i10 = -1;
            if (playbackInfo.timeline.isEmpty()) {
                firstWindowIndex = timeline.getFirstWindowIndex(z7);
            } else if (timeline.getIndexOfPeriod(obj) == -1) {
                int iResolveSubsequentPeriod = resolveSubsequentPeriod(window, period, i6, z7, obj, playbackInfo.timeline, timeline);
                if (iResolveSubsequentPeriod == -1) {
                    iResolveSubsequentPeriod = timeline.getFirstWindowIndex(z7);
                    z13 = true;
                } else {
                    z13 = false;
                }
                i11 = iResolveSubsequentPeriod;
                z11 = z13;
                jLongValue = jLongValue;
                mediaPeriodId = mediaPeriodId;
                z10 = false;
                z12 = false;
            } else if (jLongValue == C0565C.TIME_UNSET) {
                firstWindowIndex = timeline.getPeriodByUid(obj, period).windowIndex;
            } else if (zIsUsingPlaceholderPeriod) {
                mediaPeriodId = mediaPeriodId;
                playbackInfo.timeline.getPeriodByUid(mediaPeriodId.periodUid, period);
                if (playbackInfo.timeline.getWindow(period.windowIndex, window).firstPeriodIndex == playbackInfo.timeline.getIndexOfPeriod(mediaPeriodId.periodUid)) {
                    Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(obj, period).windowIndex, period.getPositionInWindowUs() + jLongValue);
                    obj = periodPositionUs.first;
                    jLongValue = ((Long) periodPositionUs.second).longValue();
                } else {
                    jLongValue = jLongValue;
                }
                i11 = -1;
                z10 = false;
                z11 = false;
                z12 = true;
            } else {
                i11 = -1;
                z10 = false;
                z11 = false;
                z12 = false;
            }
            i11 = firstWindowIndex;
            z10 = false;
            z11 = false;
            z12 = false;
        }
        if (i11 != i10) {
            Pair<Object, Long> periodPositionUs2 = timeline.getPeriodPositionUs(window, period, i11, C0565C.TIME_UNSET);
            obj = periodPositionUs2.first;
            jLongValue = ((Long) periodPositionUs2.second).longValue();
            j10 = -9223372036854775807L;
        } else {
            j10 = jLongValue;
        }
        MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodQueue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline, obj, jLongValue);
        int i13 = mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.nextAdGroupIndex;
        boolean z17 = mediaPeriodId.periodUid.equals(obj) && !mediaPeriodId.isAd() && !mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd() && (i13 == i10 || ((i12 = mediaPeriodId.nextAdGroupIndex) != i10 && i13 >= i12));
        MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId;
        boolean zIsIgnorableServerSideAdInsertionPeriodChange = isIgnorableServerSideAdInsertionPeriodChange(zIsUsingPlaceholderPeriod, mediaPeriodId, jLongValue, mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, timeline.getPeriodByUid(obj, period), j10);
        if (z17 || zIsIgnorableServerSideAdInsertionPeriodChange) {
            mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodId3;
        }
        if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
            if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.equals(mediaPeriodId3)) {
                jLongValue = playbackInfo.positionUs;
            } else {
                timeline.getPeriodByUid(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, period);
                jLongValue = mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup == period.getFirstAdIndexToPlay(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex) ? period.getAdResumePositionUs() : 0L;
            }
        }
        return new PositionUpdateForPlaylistChange(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, jLongValue, j10, z10, z11, z12);
    }

    private static Pair<Object, Long> resolveSeekPositionUs(Timeline timeline, SeekPosition seekPosition, boolean z7, int i6, boolean z10, Timeline.Window window, Timeline.Period period) {
        int iResolveSubsequentPeriod;
        Timeline timeline2 = seekPosition.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        Timeline timeline3 = timeline2.isEmpty() ? timeline : timeline2;
        try {
            Pair<Object, Long> periodPositionUs = timeline3.getPeriodPositionUs(window, period, seekPosition.windowIndex, seekPosition.windowPositionUs);
            if (timeline.equals(timeline3)) {
                return periodPositionUs;
            }
            if (timeline.getIndexOfPeriod(periodPositionUs.first) != -1) {
                return (timeline3.getPeriodByUid(periodPositionUs.first, period).isPlaceholder && timeline3.getWindow(period.windowIndex, window).firstPeriodIndex == timeline3.getIndexOfPeriod(periodPositionUs.first)) ? timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(periodPositionUs.first, period).windowIndex, seekPosition.windowPositionUs) : periodPositionUs;
            }
            if (z7 && (iResolveSubsequentPeriod = resolveSubsequentPeriod(window, period, i6, z10, periodPositionUs.first, timeline3, timeline)) != -1) {
                return timeline.getPeriodPositionUs(window, period, iResolveSubsequentPeriod, C0565C.TIME_UNSET);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    public static int resolveSubsequentPeriod(Timeline.Window window, Timeline.Period period, int i6, boolean z7, Object obj, Timeline timeline, Timeline timeline2) {
        Object obj2 = timeline.getWindow(timeline.getPeriodByUid(obj, period).windowIndex, window).uid;
        for (int i10 = 0; i10 < timeline2.getWindowCount(); i10++) {
            if (timeline2.getWindow(i10, window).uid.equals(obj2)) {
                return i10;
            }
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int nextPeriodIndex = indexOfPeriod;
        int indexOfPeriod2 = -1;
        for (int i11 = 0; i11 < periodCount && indexOfPeriod2 == -1; i11++) {
            nextPeriodIndex = timeline.getNextPeriodIndex(nextPeriodIndex, period, window, i6, z7);
            if (nextPeriodIndex == -1) {
                break;
            }
            indexOfPeriod2 = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(nextPeriodIndex));
        }
        if (indexOfPeriod2 == -1) {
            return -1;
        }
        return timeline2.getPeriod(indexOfPeriod2, period).windowIndex;
    }

    private void scheduleNextWork(long j10) {
        long jMin = (this.playbackInfo.playbackState != 3 || (!this.dynamicSchedulingEnabled && shouldPlayWhenReady())) ? BUFFERING_MAXIMUM_INTERVAL_MS : 1000L;
        if (this.dynamicSchedulingEnabled && shouldPlayWhenReady()) {
            for (RendererHolder rendererHolder : this.renderers) {
                jMin = Math.min(jMin, Util.usToMs(rendererHolder.getMinDurationToProgressUs(this.rendererPositionUs, this.rendererPositionElapsedRealtimeUs)));
            }
            MediaPeriodHolder next = this.queue.getPlayingPeriod() != null ? this.queue.getPlayingPeriod().getNext() : null;
            if (next != null) {
                if ((Util.msToUs(jMin) * this.playbackInfo.playbackParameters.speed) + this.rendererPositionUs >= next.getStartPositionRendererTime()) {
                    jMin = Math.min(jMin, BUFFERING_MAXIMUM_INTERVAL_MS);
                }
            }
        }
        this.handler.sendEmptyMessageAtTime(2, j10 + jMin);
    }

    private void seekToCurrentPosition(boolean z7) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.f2678id;
        long jSeekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true, false);
        if (jSeekToPeriodPosition != this.playbackInfo.positionUs) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, jSeekToPeriodPosition, playbackInfo.requestedContentPositionUs, playbackInfo.discontinuityStartPositionUs, z7, 5);
        }
    }

    private void seekToInternal(SeekPosition seekPosition) throws Throwable {
        long jLongValue;
        long j10;
        boolean z7;
        MediaSource.MediaPeriodId mediaPeriodId;
        long adResumePositionUs;
        long j11;
        long j12;
        long adjustedSeekPositionUs;
        boolean z10;
        long jSeekToPeriodPosition;
        long j13;
        MediaPeriodHolder playingPeriod;
        PlaybackInfo playbackInfo;
        int i6;
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        Pair<Object, Long> pairResolveSeekPositionUs = resolveSeekPositionUs(this.playbackInfo.timeline, seekPosition, true, this.repeatMode, this.shuffleModeEnabled, this.window, this.period);
        try {
            if (pairResolveSeekPositionUs != null) {
                Object obj = pairResolveSeekPositionUs.first;
                jLongValue = ((Long) pairResolveSeekPositionUs.second).longValue();
                long j14 = seekPosition.windowPositionUs == C0565C.TIME_UNSET ? -9223372036854775807L : jLongValue;
                MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = this.queue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(this.playbackInfo.timeline, obj, jLongValue);
                if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
                    this.playbackInfo.timeline.getPeriodByUid(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, this.period);
                    adResumePositionUs = this.period.getFirstAdIndexToPlay(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex) == mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup ? this.period.getAdResumePositionUs() : 0L;
                    j11 = j14;
                    z7 = true;
                    mediaPeriodId = mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange;
                } else {
                    j10 = j14;
                    z7 = seekPosition.windowPositionUs == C0565C.TIME_UNSET;
                    mediaPeriodId = mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange;
                }
                if (this.playbackInfo.timeline.isEmpty()) {
                    if (pairResolveSeekPositionUs == null) {
                        if (this.playbackInfo.playbackState != 1) {
                            setState(4);
                        }
                        resetInternal(false, true, false, true);
                    } else {
                        if (mediaPeriodId.equals(this.playbackInfo.periodId)) {
                            playingPeriod = this.queue.getPlayingPeriod();
                            if (playingPeriod == null && playingPeriod.prepared && adResumePositionUs != 0) {
                                adjustedSeekPositionUs = playingPeriod.mediaPeriod.getAdjustedSeekPositionUs(adResumePositionUs, this.seekParameters);
                            } else {
                                adjustedSeekPositionUs = adResumePositionUs;
                            }
                            if (Util.usToMs(adjustedSeekPositionUs) == Util.usToMs(this.playbackInfo.positionUs) && ((i6 = (playbackInfo = this.playbackInfo).playbackState) == 2 || i6 == 3)) {
                                long j15 = playbackInfo.positionUs;
                                this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j15, j11, j15, z7, 2);
                                return;
                            }
                        } else {
                            adjustedSeekPositionUs = adResumePositionUs;
                        }
                        if (this.playbackInfo.playbackState == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        jSeekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, adjustedSeekPositionUs, z10);
                        z7 |= adResumePositionUs != jSeekToPeriodPosition;
                        try {
                            PlaybackInfo playbackInfo2 = this.playbackInfo;
                            Timeline timeline = playbackInfo2.timeline;
                            updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaPeriodId, timeline, playbackInfo2.periodId, j11, true);
                            j13 = jSeekToPeriodPosition;
                        } catch (Throwable th) {
                            th = th;
                            j12 = jSeekToPeriodPosition;
                            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j12, j11, j12, z7, 2);
                            throw th;
                        }
                    }
                    this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j13, j11, j13, z7, 2);
                    return;
                }
                this.pendingInitialSeekPosition = seekPosition;
                j13 = adResumePositionUs;
                this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j13, j11, j13, z7, 2);
                return;
            }
            Pair<MediaSource.MediaPeriodId, Long> placeholderFirstMediaPeriodPositionUs = getPlaceholderFirstMediaPeriodPositionUs(this.playbackInfo.timeline);
            mediaPeriodId = (MediaSource.MediaPeriodId) placeholderFirstMediaPeriodPositionUs.first;
            jLongValue = ((Long) placeholderFirstMediaPeriodPositionUs.second).longValue();
            z7 = !this.playbackInfo.timeline.isEmpty();
            j10 = -9223372036854775807L;
            if (this.playbackInfo.timeline.isEmpty()) {
                if (pairResolveSeekPositionUs == null) {
                    if (this.playbackInfo.playbackState != 1) {
                        setState(4);
                    }
                    resetInternal(false, true, false, true);
                } else {
                    if (mediaPeriodId.equals(this.playbackInfo.periodId)) {
                        playingPeriod = this.queue.getPlayingPeriod();
                        if (playingPeriod == null) {
                            adjustedSeekPositionUs = adResumePositionUs;
                        } else {
                            adjustedSeekPositionUs = adResumePositionUs;
                        }
                        if (Util.usToMs(adjustedSeekPositionUs) == Util.usToMs(this.playbackInfo.positionUs)) {
                            long j16 = playbackInfo.positionUs;
                            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j16, j11, j16, z7, 2);
                            return;
                        }
                    } else {
                        adjustedSeekPositionUs = adResumePositionUs;
                    }
                    if (this.playbackInfo.playbackState == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    jSeekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, adjustedSeekPositionUs, z10);
                    z7 |= adResumePositionUs != jSeekToPeriodPosition;
                    PlaybackInfo playbackInfo3 = this.playbackInfo;
                    Timeline timeline2 = playbackInfo3.timeline;
                    updatePlaybackSpeedSettingsForNewPeriod(timeline2, mediaPeriodId, timeline2, playbackInfo3.periodId, j11, true);
                    j13 = jSeekToPeriodPosition;
                }
                this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j13, j11, j13, z7, 2);
                return;
            }
            this.pendingInitialSeekPosition = seekPosition;
            j13 = adResumePositionUs;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j13, j11, j13, z7, 2);
            return;
        } catch (Throwable th2) {
            th = th2;
            j12 = adResumePositionUs;
        }
        adResumePositionUs = jLongValue;
        j11 = j10;
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j10, boolean z7) throws ExoPlaybackException {
        return seekToPeriodPosition(mediaPeriodId, j10, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod(), z7);
    }

    private void sendMessageInternal(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getPositionMs() == C0565C.TIME_UNSET) {
            sendMessageToTarget(playerMessage);
            return;
        }
        if (this.playbackInfo.timeline.isEmpty()) {
            this.pendingMessages.add(new PendingMessageInfo(playerMessage));
            return;
        }
        PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
        Timeline timeline = this.playbackInfo.timeline;
        if (!resolvePendingMessagePosition(pendingMessageInfo, timeline, timeline, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
            playerMessage.markAsProcessed(false);
        } else {
            this.pendingMessages.add(pendingMessageInfo);
            Collections.sort(this.pendingMessages);
        }
    }

    private void sendMessageToTarget(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getLooper() != this.playbackLooper) {
            this.handler.obtainMessage(15, playerMessage).sendToTarget();
            return;
        }
        deliverMessage(playerMessage);
        int i6 = this.playbackInfo.playbackState;
        if (i6 == 3 || i6 == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void sendMessageToTargetThread(PlayerMessage playerMessage) {
        Looper looper = playerMessage.getLooper();
        if (looper.getThread().isAlive()) {
            this.clock.createHandler(looper, null).post(new RunnableC0765h(this, 3, playerMessage));
        } else {
            Log.m1719w("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
        }
    }

    private void setAllNonPrewarmingRendererStreamsFinal(long j10) {
        for (RendererHolder rendererHolder : this.renderers) {
            rendererHolder.setAllNonPrewarmingRendererStreamsFinal(j10);
        }
    }

    private void setAudioAttributesInternal(AudioAttributes audioAttributes, boolean z7) throws ExoPlaybackException {
        this.trackSelector.setAudioAttributes(audioAttributes);
        AudioFocusManager audioFocusManager = this.audioFocusManager;
        if (!z7) {
            audioAttributes = null;
        }
        audioFocusManager.setAudioAttributes(audioAttributes);
        updatePlayWhenReadyWithAudioFocus();
    }

    private void setForegroundModeInternal(boolean z7, AtomicBoolean atomicBoolean) {
        if (this.foregroundMode != z7) {
            this.foregroundMode = z7;
            if (!z7) {
                for (RendererHolder rendererHolder : this.renderers) {
                    rendererHolder.reset();
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void setMediaClockPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.removeMessages(16);
        this.mediaClock.setPlaybackParameters(playbackParameters);
    }

    private void setMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        if (mediaSourceListUpdateMessage.windowIndex != -1) {
            this.pendingInitialSeekPosition = new SeekPosition(new PlaylistTimeline(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), mediaSourceListUpdateMessage.windowIndex, mediaSourceListUpdateMessage.positionUs);
        }
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setMediaSources(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    private void setOffloadSchedulingEnabled(boolean z7) {
        if (z7 == this.offloadSchedulingEnabled) {
            return;
        }
        this.offloadSchedulingEnabled = z7;
        if (z7 || !this.playbackInfo.sleepingForOffload) {
            return;
        }
        this.handler.sendEmptyMessage(2);
    }

    private void setPauseAtEndOfWindowInternal(boolean z7) throws ExoPlaybackException {
        this.pauseAtEndOfWindow = z7;
        resetPendingPauseAtEndOfPeriod();
        if (!this.pendingPauseAtEndOfPeriod || this.queue.getReadingPeriod() == this.queue.getPlayingPeriod()) {
            return;
        }
        seekToCurrentPosition(true);
        handleLoadingMediaPeriodChanged(false);
    }

    private void setPlayWhenReadyInternal(boolean z7, int i6, boolean z10, int i10) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(z10 ? 1 : 0);
        updatePlayWhenReadyWithAudioFocus(z7, i6, i10);
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters) throws ExoPlaybackException {
        setMediaClockPlaybackParameters(playbackParameters);
        handlePlaybackParameters(this.mediaClock.getPlaybackParameters(), true);
    }

    private void setPreloadConfigurationInternal(ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.preloadConfiguration = preloadConfiguration;
        this.queue.updatePreloadConfiguration(this.playbackInfo.timeline, preloadConfiguration);
    }

    private void setRepeatModeInternal(int i6) throws ExoPlaybackException {
        this.repeatMode = i6;
        int iUpdateRepeatMode = this.queue.updateRepeatMode(this.playbackInfo.timeline, i6);
        if ((iUpdateRepeatMode & 1) != 0) {
            seekToCurrentPosition(true);
        } else if ((iUpdateRepeatMode & 2) != 0) {
            disableAndResetPrewarmingRenderers();
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setSeekParametersInternal(SeekParameters seekParameters) {
        this.seekParameters = seekParameters;
    }

    private void setShuffleModeEnabledInternal(boolean z7) throws ExoPlaybackException {
        this.shuffleModeEnabled = z7;
        int iUpdateShuffleModeEnabled = this.queue.updateShuffleModeEnabled(this.playbackInfo.timeline, z7);
        if ((iUpdateShuffleModeEnabled & 1) != 0) {
            seekToCurrentPosition(true);
        } else if ((iUpdateShuffleModeEnabled & 2) != 0) {
            disableAndResetPrewarmingRenderers();
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setShuffleOrderInternal(ShuffleOrder shuffleOrder) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setShuffleOrder(shuffleOrder), false);
    }

    private void setState(int i6) {
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.playbackState != i6) {
            if (i6 != 2) {
                this.playbackMaybeBecameStuckAtMs = C0565C.TIME_UNSET;
            }
            this.playbackInfo = playbackInfo.copyWithPlaybackState(i6);
        }
    }

    private void setVideoOutputInternal(Object obj, AtomicBoolean atomicBoolean) throws ExoPlaybackException {
        for (RendererHolder rendererHolder : this.renderers) {
            rendererHolder.setVideoOutput(obj);
        }
        int i6 = this.playbackInfo.playbackState;
        if (i6 == 3 || i6 == 2) {
            this.handler.sendEmptyMessage(2);
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void setVolumeInternal(float f) throws ExoPlaybackException {
        this.volume = f;
        float volumeMultiplier = f * this.audioFocusManager.getVolumeMultiplier();
        for (RendererHolder rendererHolder : this.renderers) {
            rendererHolder.setVolume(volumeMultiplier);
        }
    }

    private boolean shouldAdvancePlayingPeriod() {
        MediaPeriodHolder playingPeriod;
        MediaPeriodHolder next;
        return shouldPlayWhenReady() && !this.pendingPauseAtEndOfPeriod && (playingPeriod = this.queue.getPlayingPeriod()) != null && (next = playingPeriod.getNext()) != null && this.rendererPositionUs >= next.getStartPositionRendererTime() && next.allRenderersInCorrectState;
    }

    private boolean shouldContinueLoading() {
        if (!isLoadingPossible(this.queue.getLoadingPeriod())) {
            return false;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        long totalBufferedDurationUs = getTotalBufferedDurationUs(loadingPeriod.getNextLoadPositionUs());
        LoadControl.Parameters parameters = new LoadControl.Parameters(this.playerId, this.playbackInfo.timeline, loadingPeriod.info.f2678id, loadingPeriod == this.queue.getPlayingPeriod() ? loadingPeriod.toPeriodTime(this.rendererPositionUs) : loadingPeriod.toPeriodTime(this.rendererPositionUs) - loadingPeriod.info.startPositionUs, totalBufferedDurationUs, this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.playWhenReady, this.isRebuffering, shouldUseLivePlaybackSpeedControl(this.playbackInfo.timeline, loadingPeriod.info.f2678id) ? this.livePlaybackSpeedControl.getTargetLiveOffsetUs() : C0565C.TIME_UNSET, this.lastRebufferRealtimeMs);
        boolean zShouldContinueLoading = this.loadControl.shouldContinueLoading(parameters);
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (zShouldContinueLoading || !playingPeriod.prepared || totalBufferedDurationUs >= PLAYBACK_BUFFER_EMPTY_THRESHOLD_US) {
            return zShouldContinueLoading;
        }
        if (this.backBufferDurationUs <= 0 && !this.retainBackBufferFromKeyframe) {
            return zShouldContinueLoading;
        }
        playingPeriod.mediaPeriod.discardBuffer(this.playbackInfo.positionUs, false);
        return this.loadControl.shouldContinueLoading(parameters);
    }

    private boolean shouldPlayWhenReady() {
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.playWhenReady && playbackInfo.playbackSuppressionReason == 0;
    }

    private boolean shouldTransitionToReadyState(boolean z7) {
        if (this.enabledRendererCount == 0) {
            return isTimelineReady();
        }
        boolean z10 = false;
        if (!z7) {
            return false;
        }
        if (!this.playbackInfo.isLoading) {
            return true;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long targetLiveOffsetUs = shouldUseLivePlaybackSpeedControl(this.playbackInfo.timeline, playingPeriod.info.f2678id) ? this.livePlaybackSpeedControl.getTargetLiveOffsetUs() : C0565C.TIME_UNSET;
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        boolean z11 = loadingPeriod.isFullyBuffered() && loadingPeriod.info.isFinal;
        if (loadingPeriod.info.f2678id.isAd() && !loadingPeriod.prepared) {
            z10 = true;
        }
        if (z11 || z10) {
            return true;
        }
        return this.loadControl.shouldStartPlayback(new LoadControl.Parameters(this.playerId, this.playbackInfo.timeline, playingPeriod.info.f2678id, playingPeriod.toPeriodTime(this.rendererPositionUs), getTotalBufferedDurationUs(loadingPeriod.getBufferedPositionUs()), this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.playWhenReady, this.isRebuffering, targetLiveOffsetUs, this.lastRebufferRealtimeMs));
    }

    private boolean shouldUseLivePlaybackSpeedControl(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (mediaPeriodId.isAd() || timeline.isEmpty()) {
            return false;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        if (!this.window.isLive()) {
            return false;
        }
        Timeline.Window window = this.window;
        return window.isDynamic && window.windowStartTimeMs != C0565C.TIME_UNSET;
    }

    private void startRenderers() throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            return;
        }
        TrackSelectorResult trackSelectorResult = playingPeriod.getTrackSelectorResult();
        for (int i6 = 0; i6 < this.renderers.length; i6++) {
            if (trackSelectorResult.isRendererEnabled(i6)) {
                this.renderers[i6].start();
            }
        }
    }

    private void stopInternal(boolean z7, boolean z10) {
        resetInternal(z7 || !this.foregroundMode, false, true, false);
        this.playbackInfoUpdate.incrementPendingOperationAcks(z10 ? 1 : 0);
        this.loadControl.onStopped(this.playerId);
        this.audioFocusManager.updateAudioFocus(this.playbackInfo.playWhenReady, 1);
        setState(1);
    }

    private void stopRenderers() throws ExoPlaybackException {
        this.mediaClock.stop();
        for (RendererHolder rendererHolder : this.renderers) {
            rendererHolder.stop();
        }
    }

    private void updateIsLoading() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        boolean z7 = this.shouldContinueLoading || (loadingPeriod != null && loadingPeriod.mediaPeriod.isLoading());
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (z7 != playbackInfo.isLoading) {
            this.playbackInfo = playbackInfo.copyWithIsLoading(z7);
        }
    }

    private void updateLoadControlTrackSelection(MediaSource.MediaPeriodId mediaPeriodId, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkNotNull(this.queue.getLoadingPeriod());
        this.loadControl.onTracksSelected(new LoadControl.Parameters(this.playerId, this.playbackInfo.timeline, mediaPeriodId, mediaPeriodHolder == this.queue.getPlayingPeriod() ? mediaPeriodHolder.toPeriodTime(this.rendererPositionUs) : mediaPeriodHolder.toPeriodTime(this.rendererPositionUs) - mediaPeriodHolder.info.startPositionUs, getTotalBufferedDurationUs(mediaPeriodHolder.getBufferedPositionUs()), this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.playWhenReady, this.isRebuffering, shouldUseLivePlaybackSpeedControl(this.playbackInfo.timeline, mediaPeriodHolder.info.f2678id) ? this.livePlaybackSpeedControl.getTargetLiveOffsetUs() : C0565C.TIME_UNSET, this.lastRebufferRealtimeMs), trackGroupArray, trackSelectorResult.selections);
    }

    private void updateMediaSourcesWithMediaItemsInternal(int i6, int i10, List<MediaItem> list) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.updateMediaSourcesWithMediaItems(i6, i10, list), false);
    }

    private void updatePeriods() throws ExoPlaybackException {
        if (this.playbackInfo.timeline.isEmpty() || !this.mediaSourceList.isPrepared()) {
            return;
        }
        boolean zMaybeUpdateLoadingPeriod = maybeUpdateLoadingPeriod();
        maybeUpdatePrewarmingPeriod();
        maybeUpdateReadingPeriod();
        maybeUpdateReadingRenderers();
        maybeUpdatePlayingPeriod();
        maybeUpdatePreloadPeriods(zMaybeUpdateLoadingPeriod);
    }

    private static int updatePlayWhenReadyChangeReason(int i6, int i10) {
        if (i6 == -1) {
            return 2;
        }
        if (i10 == 2) {
            return 1;
        }
        return i10;
    }

    private void updatePlayWhenReadyWithAudioFocus() throws ExoPlaybackException {
        PlaybackInfo playbackInfo = this.playbackInfo;
        updatePlayWhenReadyWithAudioFocus(playbackInfo.playWhenReady, playbackInfo.playbackSuppressionReason, playbackInfo.playWhenReadyChangeReason);
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            return;
        }
        long discontinuity = playingPeriod.prepared ? playingPeriod.mediaPeriod.readDiscontinuity() : -9223372036854775807L;
        if (discontinuity != C0565C.TIME_UNSET) {
            if (!playingPeriod.isFullyBuffered()) {
                this.queue.removeAfter(playingPeriod);
                handleLoadingMediaPeriodChanged(false);
                maybeContinueLoading();
            }
            resetRendererPosition(discontinuity);
            if (discontinuity != this.playbackInfo.positionUs) {
                PlaybackInfo playbackInfo = this.playbackInfo;
                this.playbackInfo = handlePositionDiscontinuity(playbackInfo.periodId, discontinuity, playbackInfo.requestedContentPositionUs, discontinuity, true, 5);
            }
        } else {
            long jSyncAndGetPositionUs = this.mediaClock.syncAndGetPositionUs(playingPeriod != this.queue.getReadingPeriod());
            this.rendererPositionUs = jSyncAndGetPositionUs;
            long periodTime = playingPeriod.toPeriodTime(jSyncAndGetPositionUs);
            maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
            if (this.mediaClock.hasSkippedSilenceSinceLastCall()) {
                boolean z7 = !this.playbackInfoUpdate.positionDiscontinuity;
                PlaybackInfo playbackInfo2 = this.playbackInfo;
                this.playbackInfo = handlePositionDiscontinuity(playbackInfo2.periodId, periodTime, playbackInfo2.requestedContentPositionUs, periodTime, z7, 6);
            } else {
                this.playbackInfo.updatePositionUs(periodTime);
            }
        }
        this.playbackInfo.bufferedPositionUs = this.queue.getLoadingPeriod().getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        PlaybackInfo playbackInfo3 = this.playbackInfo;
        if (playbackInfo3.playWhenReady && playbackInfo3.playbackState == 3 && shouldUseLivePlaybackSpeedControl(playbackInfo3.timeline, playbackInfo3.periodId) && this.playbackInfo.playbackParameters.speed == 1.0f) {
            float adjustedPlaybackSpeed = this.livePlaybackSpeedControl.getAdjustedPlaybackSpeed(getCurrentLiveOffsetUs(), this.playbackInfo.totalBufferedDurationUs);
            if (this.mediaClock.getPlaybackParameters().speed != adjustedPlaybackSpeed) {
                setMediaClockPlaybackParameters(this.playbackInfo.playbackParameters.withSpeed(adjustedPlaybackSpeed));
                handlePlaybackParameters(this.playbackInfo.playbackParameters, this.mediaClock.getPlaybackParameters().speed, false, false);
            }
        }
    }

    private void updatePlaybackSpeedSettingsForNewPeriod(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId2, long j10, boolean z7) throws ExoPlaybackException {
        if (!shouldUseLivePlaybackSpeedControl(timeline, mediaPeriodId)) {
            PlaybackParameters playbackParameters = mediaPeriodId.isAd() ? PlaybackParameters.DEFAULT : this.playbackInfo.playbackParameters;
            if (this.mediaClock.getPlaybackParameters().equals(playbackParameters)) {
                return;
            }
            setMediaClockPlaybackParameters(playbackParameters);
            handlePlaybackParameters(this.playbackInfo.playbackParameters, playbackParameters.speed, false, false);
            return;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        this.livePlaybackSpeedControl.setLiveConfiguration((MediaItem.LiveConfiguration) Util.castNonNull(this.window.liveConfiguration));
        if (j10 != C0565C.TIME_UNSET) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(getLiveOffsetUs(timeline, mediaPeriodId.periodUid, j10));
            return;
        }
        if (!Objects.equals(!timeline2.isEmpty() ? timeline2.getWindow(timeline2.getPeriodByUid(mediaPeriodId2.periodUid, this.period).windowIndex, this.window).uid : null, this.window.uid) || z7) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(C0565C.TIME_UNSET);
        }
    }

    private static int updatePlaybackSuppressionReason(int i6, int i10) {
        if (i6 == 0) {
            return 1;
        }
        if (i10 == 1) {
            return 0;
        }
        return i10;
    }

    private void updateRebufferingState(boolean z7, boolean z10) {
        this.isRebuffering = z7;
        this.lastRebufferRealtimeMs = (!z7 || z10) ? C0565C.TIME_UNSET : this.clock.elapsedRealtime();
    }

    private boolean updateRenderersForTransition() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        int i6 = 0;
        boolean z7 = true;
        while (true) {
            RendererHolder[] rendererHolderArr = this.renderers;
            if (i6 >= rendererHolderArr.length) {
                break;
            }
            int enabledRendererCount = rendererHolderArr[i6].getEnabledRendererCount();
            int iReplaceStreamsOrDisableRendererForTransition = this.renderers[i6].replaceStreamsOrDisableRendererForTransition(readingPeriod, trackSelectorResult, this.mediaClock);
            if ((iReplaceStreamsOrDisableRendererForTransition & 2) != 0 && this.offloadSchedulingEnabled) {
                setOffloadSchedulingEnabled(false);
            }
            this.enabledRendererCount -= enabledRendererCount - this.renderers[i6].getEnabledRendererCount();
            z7 &= (iReplaceStreamsOrDisableRendererForTransition & 1) != 0;
            i6++;
        }
        if (z7) {
            for (int i10 = 0; i10 < this.renderers.length; i10++) {
                if (trackSelectorResult.isRendererEnabled(i10) && !this.renderers[i10].isReadingFromPeriod(readingPeriod)) {
                    enableRenderer(readingPeriod, i10, false, readingPeriod.getStartPositionRendererTime());
                }
            }
        }
        return z7;
    }

    private void updateTrackSelectionPlaybackSpeed(float f) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlaybackSpeed(f);
                }
            }
        }
    }

    private synchronized void waitUninterruptibly(InterfaceC1339e0 interfaceC1339e0, long j10) {
        long jElapsedRealtime = this.clock.elapsedRealtime() + j10;
        boolean z7 = false;
        while (!((Boolean) interfaceC1339e0.get()).booleanValue() && j10 > 0) {
            try {
                this.clock.onThreadBlocked();
                wait(j10);
            } catch (InterruptedException unused) {
                z7 = true;
            }
            j10 = jElapsedRealtime - this.clock.elapsedRealtime();
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
    }

    public void addMediaSources(int i6, List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(18, i6, 0, new MediaSourceListUpdateMessage(list, shuffleOrder, -1, C0565C.TIME_UNSET)).sendToTarget();
    }

    @Override
    public void executePlayerCommand(int i6) {
        this.handler.obtainMessage(33, i6, 0).sendToTarget();
    }

    public void experimentalSetForegroundModeTimeoutMs(long j10) {
        this.setForegroundModeTimeoutMs = j10;
    }

    public Looper getPlaybackLooper() {
        return this.playbackLooper;
    }

    @Override
    public boolean handleMessage(Message message) throws Throwable {
        ExoPlaybackException exoPlaybackException;
        ExoPlaybackException exoPlaybackException2;
        int i6;
        MediaPeriodHolder readingPeriod;
        int i10 = 1000;
        try {
            switch (message.what) {
                case 1:
                    boolean z7 = message.arg1 != 0;
                    int i11 = message.arg2;
                    setPlayWhenReadyInternal(z7, i11 >> 4, true, i11 & 15);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((SeekPosition) message.obj);
                    break;
                case 4:
                    setPlaybackParametersInternal((PlaybackParameters) message.obj);
                    break;
                case 5:
                    setSeekParametersInternal((SeekParameters) message.obj);
                    break;
                case 6:
                    stopInternal(false, true);
                    break;
                case 7:
                    releaseInternal();
                    return true;
                case 8:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    break;
                case 9:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    break;
                case 10:
                    reselectTracksInternal();
                    break;
                case 11:
                    setRepeatModeInternal(message.arg1);
                    break;
                case 12:
                    setShuffleModeEnabledInternal(message.arg1 != 0);
                    break;
                case 13:
                    setForegroundModeInternal(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    sendMessageInternal((PlayerMessage) message.obj);
                    break;
                case 15:
                    sendMessageToTargetThread((PlayerMessage) message.obj);
                    break;
                case 16:
                    handlePlaybackParameters((PlaybackParameters) message.obj, false);
                    break;
                case 17:
                    setMediaItemsInternal((MediaSourceListUpdateMessage) message.obj);
                    break;
                case 18:
                    addMediaItemsInternal((MediaSourceListUpdateMessage) message.obj, message.arg1);
                    break;
                case 19:
                    moveMediaItemsInternal((MoveMediaItemsMessage) message.obj);
                    break;
                case 20:
                    removeMediaItemsInternal(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    setShuffleOrderInternal((ShuffleOrder) message.obj);
                    break;
                case 22:
                    mediaSourceListUpdateRequestedInternal();
                    break;
                case 23:
                    setPauseAtEndOfWindowInternal(message.arg1 != 0);
                    break;
                case 24:
                default:
                    return false;
                case 25:
                    attemptRendererErrorRecovery();
                    break;
                case 26:
                    reselectTracksInternalAndSeek();
                    break;
                case 27:
                    updateMediaSourcesWithMediaItemsInternal(message.arg1, message.arg2, (List) message.obj);
                    break;
                case 28:
                    setPreloadConfigurationInternal((ExoPlayer.PreloadConfiguration) message.obj);
                    break;
                case 29:
                    prepareInternal();
                    break;
                case 30:
                    Pair pair = (Pair) message.obj;
                    setVideoOutputInternal(pair.first, (AtomicBoolean) pair.second);
                    break;
                case 31:
                    setAudioAttributesInternal((AudioAttributes) message.obj, message.arg1 != 0);
                    break;
                case 32:
                    setVolumeInternal(((Float) message.obj).floatValue());
                    break;
                case 33:
                    handleAudioFocusPlayerCommandInternal(message.arg1);
                    break;
                case 34:
                    handleAudioFocusVolumeMultiplierChange();
                    break;
            }
        } catch (ParserException e5) {
            int i12 = e5.dataType;
            if (i12 == 1) {
                i10 = e5.contentIsMalformed ? PlaybackException.ERROR_CODE_PARSING_CONTAINER_MALFORMED : PlaybackException.ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED;
            } else if (i12 == 4) {
                i10 = e5.contentIsMalformed ? PlaybackException.ERROR_CODE_PARSING_MANIFEST_MALFORMED : PlaybackException.ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED;
            }
            handleIoException(e5, i10);
        } catch (DataSourceException e10) {
            handleIoException(e10, e10.reason);
        } catch (ExoPlaybackException e11) {
            ExoPlaybackException exoPlaybackExceptionCopyWithMediaPeriodId = e11;
            if (exoPlaybackExceptionCopyWithMediaPeriodId.type == 1 && (readingPeriod = this.queue.getReadingPeriod()) != null) {
                RendererHolder[] rendererHolderArr = this.renderers;
                int i13 = exoPlaybackExceptionCopyWithMediaPeriodId.rendererIndex;
                exoPlaybackExceptionCopyWithMediaPeriodId = exoPlaybackExceptionCopyWithMediaPeriodId.copyWithMediaPeriodId((!rendererHolderArr[i13 % rendererHolderArr.length].isRendererPrewarming(i13) || readingPeriod.getNext() == null) ? readingPeriod.info.f2678id : readingPeriod.getNext().info.f2678id);
            }
            if (exoPlaybackExceptionCopyWithMediaPeriodId.type == 1) {
                RendererHolder[] rendererHolderArr2 = this.renderers;
                int i14 = exoPlaybackExceptionCopyWithMediaPeriodId.rendererIndex;
                if (rendererHolderArr2[i14 % rendererHolderArr2.length].isRendererPrewarming(i14)) {
                    this.isPrewarmingDisabledUntilNextTransition = true;
                    disableAndResetPrewarmingRenderers();
                    MediaPeriodHolder prewarmingPeriod = this.queue.getPrewarmingPeriod();
                    MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
                    if (this.queue.getPlayingPeriod() != prewarmingPeriod) {
                        while (playingPeriod != null && playingPeriod.getNext() != prewarmingPeriod) {
                            playingPeriod = playingPeriod.getNext();
                        }
                    }
                    this.queue.removeAfter(playingPeriod);
                    if (this.playbackInfo.playbackState != 4) {
                        maybeContinueLoading();
                        this.handler.sendEmptyMessage(2);
                    }
                } else {
                    exoPlaybackException = this.pendingRecoverableRendererError;
                    if (exoPlaybackException != null) {
                        exoPlaybackException.addSuppressed(exoPlaybackExceptionCopyWithMediaPeriodId);
                        exoPlaybackExceptionCopyWithMediaPeriodId = this.pendingRecoverableRendererError;
                    }
                    exoPlaybackException2 = exoPlaybackExceptionCopyWithMediaPeriodId;
                    if (exoPlaybackException2.type != 1 && this.queue.getPlayingPeriod() != this.queue.getReadingPeriod()) {
                        while (this.queue.getPlayingPeriod() != this.queue.getReadingPeriod()) {
                            this.queue.advancePlayingPeriod();
                        }
                        MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkNotNull(this.queue.getPlayingPeriod());
                        maybeNotifyPlaybackInfoChanged();
                        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
                        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f2678id;
                        long j10 = mediaPeriodInfo.startPositionUs;
                        this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j10, mediaPeriodInfo.requestedContentPositionUs, j10, true, 0);
                    }
                    if (exoPlaybackException2.isRecoverable || !(this.pendingRecoverableRendererError == null || (i6 = exoPlaybackException2.errorCode) == 5004 || i6 == 5003)) {
                        Log.m1716e(TAG, "Playback error", exoPlaybackException2);
                        stopInternal(true, false);
                        this.playbackInfo = this.playbackInfo.copyWithPlaybackError(exoPlaybackException2);
                    } else {
                        Log.m1720w(TAG, "Recoverable renderer error", exoPlaybackException2);
                        if (this.pendingRecoverableRendererError == null) {
                            this.pendingRecoverableRendererError = exoPlaybackException2;
                        }
                        HandlerWrapper handlerWrapper = this.handler;
                        handlerWrapper.sendMessageAtFrontOfQueue(handlerWrapper.obtainMessage(25, exoPlaybackException2));
                    }
                }
            } else {
                exoPlaybackException = this.pendingRecoverableRendererError;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(exoPlaybackExceptionCopyWithMediaPeriodId);
                    exoPlaybackExceptionCopyWithMediaPeriodId = this.pendingRecoverableRendererError;
                }
                exoPlaybackException2 = exoPlaybackExceptionCopyWithMediaPeriodId;
                if (exoPlaybackException2.type != 1) {
                }
                if (exoPlaybackException2.isRecoverable) {
                    Log.m1716e(TAG, "Playback error", exoPlaybackException2);
                    stopInternal(true, false);
                    this.playbackInfo = this.playbackInfo.copyWithPlaybackError(exoPlaybackException2);
                } else {
                    Log.m1716e(TAG, "Playback error", exoPlaybackException2);
                    stopInternal(true, false);
                    this.playbackInfo = this.playbackInfo.copyWithPlaybackError(exoPlaybackException2);
                }
            }
        } catch (DrmSession.DrmSessionException e12) {
            handleIoException(e12, e12.errorCode);
        } catch (BehindLiveWindowException e13) {
            handleIoException(e13, 1002);
        } catch (IOException e14) {
            handleIoException(e14, 2000);
        } catch (RuntimeException e15) {
            ExoPlaybackException exoPlaybackExceptionCreateForUnexpected = ExoPlaybackException.createForUnexpected(e15, ((e15 instanceof IllegalStateException) || (e15 instanceof IllegalArgumentException)) ? 1004 : 1000);
            Log.m1716e(TAG, "Playback error", exoPlaybackExceptionCreateForUnexpected);
            stopInternal(true, false);
            this.playbackInfo = this.playbackInfo.copyWithPlaybackError(exoPlaybackExceptionCreateForUnexpected);
        }
        maybeNotifyPlaybackInfoChanged();
        return true;
    }

    public void moveMediaSources(int i6, int i10, int i11, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(19, new MoveMediaItemsMessage(i6, i10, i11, shuffleOrder)).sendToTarget();
    }

    @Override
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(16, playbackParameters).sendToTarget();
    }

    @Override
    public void onPlaylistUpdateRequested() {
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessage(22);
    }

    @Override
    public void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    @Override
    public void onRendererCapabilitiesChanged(Renderer renderer) {
        this.handler.sendEmptyMessage(26);
    }

    @Override
    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(10);
    }

    public void prepare() {
        this.handler.obtainMessage(29).sendToTarget();
    }

    public synchronized boolean release() {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            this.handler.sendEmptyMessage(7);
            waitUninterruptibly(new C0766h0(0, this), this.releaseTimeoutMs);
            return this.released;
        }
        return true;
    }

    public void removeMediaSources(int i6, int i10, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(20, i6, i10, shuffleOrder).sendToTarget();
    }

    public void seekTo(Timeline timeline, int i6, long j10) {
        this.handler.obtainMessage(3, new SeekPosition(timeline, i6, j10)).sendToTarget();
    }

    @Override
    public synchronized void sendMessage(PlayerMessage playerMessage) {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            this.handler.obtainMessage(14, playerMessage).sendToTarget();
            return;
        }
        Log.m1719w(TAG, "Ignoring messages sent after release.");
        playerMessage.markAsProcessed(false);
    }

    public void setAudioAttributes(AudioAttributes audioAttributes, boolean z7) {
        this.handler.obtainMessage(31, z7 ? 1 : 0, 0, audioAttributes).sendToTarget();
    }

    public synchronized boolean setForegroundMode(boolean z7) {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            if (z7) {
                this.handler.obtainMessage(13, 1, 0).sendToTarget();
                return true;
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.handler.obtainMessage(13, 0, 0, atomicBoolean).sendToTarget();
            waitUninterruptibly(new C0766h0(1, atomicBoolean), this.setForegroundModeTimeoutMs);
            return atomicBoolean.get();
        }
        return true;
    }

    public void setMediaSources(List<MediaSourceList.MediaSourceHolder> list, int i6, long j10, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(17, new MediaSourceListUpdateMessage(list, shuffleOrder, i6, j10)).sendToTarget();
    }

    public void setPauseAtEndOfWindow(boolean z7) {
        this.handler.obtainMessage(23, z7 ? 1 : 0, 0).sendToTarget();
    }

    public void setPlayWhenReady(boolean z7, int i6, int i10) {
        this.handler.obtainMessage(1, z7 ? 1 : 0, i6 | (i10 << 4)).sendToTarget();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public void setPreloadConfiguration(ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.handler.obtainMessage(28, preloadConfiguration).sendToTarget();
    }

    public void setRepeatMode(int i6) {
        this.handler.obtainMessage(11, i6, 0).sendToTarget();
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        this.handler.obtainMessage(5, seekParameters).sendToTarget();
    }

    public void setShuffleModeEnabled(boolean z7) {
        this.handler.obtainMessage(12, z7 ? 1 : 0, 0).sendToTarget();
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(21, shuffleOrder).sendToTarget();
    }

    public synchronized boolean setVideoOutput(Object obj, long j10) {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.handler.obtainMessage(30, new Pair(obj, atomicBoolean)).sendToTarget();
            if (j10 == C0565C.TIME_UNSET) {
                return true;
            }
            waitUninterruptibly(new C0766h0(1, atomicBoolean), j10);
            return atomicBoolean.get();
        }
        return true;
    }

    public void setVolume(float f) {
        this.handler.obtainMessage(32, Float.valueOf(f)).sendToTarget();
    }

    @Override
    public void setVolumeMultiplier(float f) {
        this.handler.sendEmptyMessage(34);
    }

    public void stop() {
        this.handler.obtainMessage(6).sendToTarget();
    }

    public void updateMediaSourcesWithMediaItems(int i6, int i10, List<MediaItem> list) {
        this.handler.obtainMessage(27, i6, i10, list).sendToTarget();
    }

    private long getTotalBufferedDurationUs(long j10) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null) {
            return 0L;
        }
        return Math.max(0L, j10 - loadingPeriod.toPeriodTime(this.rendererPositionUs));
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, float f, boolean z7, boolean z10) throws ExoPlaybackException {
        if (z7) {
            if (z10) {
                this.playbackInfoUpdate.incrementPendingOperationAcks(1);
            }
            this.playbackInfo = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
        }
        updateTrackSelectionPlaybackSpeed(playbackParameters.speed);
        for (RendererHolder rendererHolder : this.renderers) {
            rendererHolder.setPlaybackSpeed(f, playbackParameters.speed);
        }
    }

    private void updatePlayWhenReadyWithAudioFocus(boolean z7, int i6, int i10) throws ExoPlaybackException {
        updatePlayWhenReadyWithAudioFocus(z7, this.audioFocusManager.updateAudioFocus(z7, this.playbackInfo.playbackState), i6, i10);
    }

    @Override
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    private void enableRenderers(boolean[] zArr, long j10) throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        for (int i6 = 0; i6 < this.renderers.length; i6++) {
            if (!trackSelectorResult.isRendererEnabled(i6)) {
                this.renderers[i6].reset();
            }
        }
        for (int i10 = 0; i10 < this.renderers.length; i10++) {
            if (trackSelectorResult.isRendererEnabled(i10) && !this.renderers[i10].isReadingFromPeriod(readingPeriod)) {
                enableRenderer(readingPeriod, i10, zArr[i10], j10);
            }
        }
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j10, boolean z7, boolean z10) throws ExoPlaybackException {
        stopRenderers();
        updateRebufferingState(false, true);
        if (z10 || this.playbackInfo.playbackState == 3) {
            setState(2);
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder next = playingPeriod;
        while (next != null && !mediaPeriodId.equals(next.info.f2678id)) {
            next = next.getNext();
        }
        if (z7 || playingPeriod != next || (next != null && next.toRendererTime(j10) < 0)) {
            disableRenderers();
            if (next != null) {
                while (this.queue.getPlayingPeriod() != next) {
                    this.queue.advancePlayingPeriod();
                }
                this.queue.removeAfter(next);
                next.setRendererOffset(MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US);
                enableRenderers();
                next.allRenderersInCorrectState = true;
            }
        }
        disableAndResetPrewarmingRenderers();
        if (next != null) {
            this.queue.removeAfter(next);
            if (!next.prepared) {
                next.info = next.info.copyWithStartPositionUs(j10);
            } else if (next.hasEnabledTracks) {
                j10 = next.mediaPeriod.seekToUs(j10);
                next.mediaPeriod.discardBuffer(j10 - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
            }
            resetRendererPosition(j10);
            maybeContinueLoading();
        } else {
            this.queue.clear();
            resetRendererPosition(j10);
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return j10;
    }

    private void updatePlayWhenReadyWithAudioFocus(boolean z7, int i6, int i10, int i11) throws ExoPlaybackException {
        boolean z10 = z7 && i6 != -1;
        int iUpdatePlayWhenReadyChangeReason = updatePlayWhenReadyChangeReason(i6, i11);
        int iUpdatePlaybackSuppressionReason = updatePlaybackSuppressionReason(i6, i10);
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.playWhenReady == z10 && playbackInfo.playbackSuppressionReason == iUpdatePlaybackSuppressionReason && playbackInfo.playWhenReadyChangeReason == iUpdatePlayWhenReadyChangeReason) {
            return;
        }
        this.playbackInfo = playbackInfo.copyWithPlayWhenReady(z10, iUpdatePlayWhenReadyChangeReason, iUpdatePlaybackSuppressionReason);
        updateRebufferingState(false, false);
        notifyTrackSelectionPlayWhenReadyChanged(z10);
        if (!shouldPlayWhenReady()) {
            stopRenderers();
            updatePlaybackPositions();
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            return;
        }
        int i12 = this.playbackInfo.playbackState;
        if (i12 == 3) {
            this.mediaClock.start();
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (i12 == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }
}
