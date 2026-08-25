package androidx.media3.exoplayer.analytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.support.v4.media.AbstractC0107a;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.appcompat.app.RunnableC0147m0;
import androidx.core.app.AbstractC0358v;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C0565C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BackgroundExecutor;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.FileDataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.UdpDataSource;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.UnsupportedDrmException;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import p041d7.AbstractC2301u1;
import p041d7.C2204g1;

@UnstableApi
public final class MediaMetricsListener implements AnalyticsListener, PlaybackSessionManager.Listener {
    private String activeSessionId;
    private int audioUnderruns;
    private final Context context;
    private Format currentAudioFormat;
    private Format currentTextFormat;
    private Format currentVideoFormat;
    private int discontinuityReason;
    private int droppedFrames;
    private boolean hasFatalError;
    private int ioErrorType;
    private boolean isSeeking;
    private PlaybackMetrics.Builder metricsBuilder;
    private PendingFormatUpdate pendingAudioFormat;
    private PlaybackException pendingPlayerError;
    private PendingFormatUpdate pendingTextFormat;
    private PendingFormatUpdate pendingVideoFormat;
    private final PlaybackSession playbackSession;
    private int playedFrames;
    private boolean reportedEventsForCurrentSession;
    private final PlaybackSessionManager sessionManager;
    private final Executor backgroundExecutor = BackgroundExecutor.get();
    private final Timeline.Window window = new Timeline.Window();
    private final Timeline.Period period = new Timeline.Period();
    private final HashMap<String, Long> bandwidthBytes = new HashMap<>();
    private final HashMap<String, Long> bandwidthTimeMs = new HashMap<>();
    private final long startTimeMs = SystemClock.elapsedRealtime();
    private int currentPlaybackState = 0;
    private int currentNetworkType = 0;

    public static final class ErrorInfo {
        public final int errorCode;
        public final int subErrorCode;

        public ErrorInfo(int i6, int i10) {
            this.errorCode = i6;
            this.subErrorCode = i10;
        }
    }

    public static final class PendingFormatUpdate {
        public final Format format;
        public final int selectionReason;
        public final String sessionId;

        public PendingFormatUpdate(Format format, int i6, String str) {
            this.format = format;
            this.selectionReason = i6;
            this.sessionId = str;
        }
    }

    private MediaMetricsListener(Context context, PlaybackSession playbackSession) {
        this.context = context.getApplicationContext();
        this.playbackSession = playbackSession;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.sessionManager = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.setListener(this);
    }

    private boolean canReportPendingFormatUpdate(PendingFormatUpdate pendingFormatUpdate) {
        return pendingFormatUpdate != null && pendingFormatUpdate.sessionId.equals(this.sessionManager.getActiveSessionId());
    }

    public static MediaMetricsListener create(Context context) {
        MediaMetricsManager mediaMetricsManagerM2060b = AbstractC0683a0.m2060b(context.getSystemService("media_metrics"));
        if (mediaMetricsManagerM2060b == null) {
            return null;
        }
        return new MediaMetricsListener(context, mediaMetricsManagerM2060b.createPlaybackSession());
    }

    private void finishCurrentSession() {
        PlaybackMetrics.Builder builder = this.metricsBuilder;
        if (builder != null && this.reportedEventsForCurrentSession) {
            builder.setAudioUnderrunCount(this.audioUnderruns);
            this.metricsBuilder.setVideoFramesDropped(this.droppedFrames);
            this.metricsBuilder.setVideoFramesPlayed(this.playedFrames);
            Long l9 = this.bandwidthTimeMs.get(this.activeSessionId);
            this.metricsBuilder.setNetworkTransferDurationMillis(l9 == null ? 0L : l9.longValue());
            Long l10 = this.bandwidthBytes.get(this.activeSessionId);
            this.metricsBuilder.setNetworkBytesRead(l10 == null ? 0L : l10.longValue());
            this.metricsBuilder.setStreamSource((l10 == null || l10.longValue() <= 0) ? 0 : 1);
            this.backgroundExecutor.execute(new RunnableC0147m0(this, 6, this.metricsBuilder.build()));
        }
        this.metricsBuilder = null;
        this.activeSessionId = null;
        this.audioUnderruns = 0;
        this.droppedFrames = 0;
        this.playedFrames = 0;
        this.currentVideoFormat = null;
        this.currentAudioFormat = null;
        this.currentTextFormat = null;
        this.reportedEventsForCurrentSession = false;
    }

    @SuppressLint({"SwitchIntDef"})
    private static int getDrmErrorCode(int i6) {
        switch (Util.getErrorCodeForMediaDrmErrorCode(i6)) {
            case PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED:
                return 24;
            case PlaybackException.ERROR_CODE_DRM_CONTENT_ERROR:
                return 28;
            case PlaybackException.ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED:
                return 25;
            case PlaybackException.ERROR_CODE_DRM_DISALLOWED_OPERATION:
                return 26;
            default:
                return 27;
        }
    }

    private static DrmInitData getDrmInitData(AbstractC2301u1 abstractC2301u1) {
        DrmInitData drmInitData;
        C2204g1 c2204g1ListIterator = abstractC2301u1.listIterator(0);
        while (c2204g1ListIterator.hasNext()) {
            Tracks.Group group = (Tracks.Group) c2204g1ListIterator.next();
            for (int i6 = 0; i6 < group.length; i6++) {
                if (group.isTrackSelected(i6) && (drmInitData = group.getTrackFormat(i6).drmInitData) != null) {
                    return drmInitData;
                }
            }
        }
        return null;
    }

    private static int getDrmType(DrmInitData drmInitData) {
        for (int i6 = 0; i6 < drmInitData.schemeDataCount; i6++) {
            UUID uuid = drmInitData.get(i6).uuid;
            if (uuid.equals(C0565C.WIDEVINE_UUID)) {
                return 3;
            }
            if (uuid.equals(C0565C.PLAYREADY_UUID)) {
                return 2;
            }
            if (uuid.equals(C0565C.CLEARKEY_UUID)) {
                return 6;
            }
        }
        return 1;
    }

    private static ErrorInfo getErrorInfo(PlaybackException playbackException, Context context, boolean z7) {
        int i6;
        boolean z10;
        if (playbackException.errorCode == 1001) {
            return new ErrorInfo(20, 0);
        }
        if (playbackException instanceof ExoPlaybackException) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
            z10 = exoPlaybackException.type == 1;
            i6 = exoPlaybackException.rendererFormatSupport;
        } else {
            i6 = 0;
            z10 = false;
        }
        Throwable th = (Throwable) Assertions.checkNotNull(playbackException.getCause());
        if (!(th instanceof IOException)) {
            if (z10 && (i6 == 0 || i6 == 1)) {
                return new ErrorInfo(35, 0);
            }
            if (z10 && i6 == 3) {
                return new ErrorInfo(15, 0);
            }
            if (z10 && i6 == 2) {
                return new ErrorInfo(23, 0);
            }
            if (th instanceof MediaCodecRenderer.DecoderInitializationException) {
                return new ErrorInfo(13, Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaCodecRenderer.DecoderInitializationException) th).diagnosticInfo));
            }
            if (th instanceof MediaCodecDecoderException) {
                return new ErrorInfo(14, ((MediaCodecDecoderException) th).errorCode);
            }
            if (th instanceof OutOfMemoryError) {
                return new ErrorInfo(14, 0);
            }
            if (th instanceof AudioSink.InitializationException) {
                return new ErrorInfo(17, ((AudioSink.InitializationException) th).audioTrackState);
            }
            if (th instanceof AudioSink.WriteException) {
                return new ErrorInfo(18, ((AudioSink.WriteException) th).errorCode);
            }
            if (!(th instanceof MediaCodec.CryptoException)) {
                return new ErrorInfo(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th).getErrorCode();
            return new ErrorInfo(getDrmErrorCode(errorCode), errorCode);
        }
        if (th instanceof HttpDataSource.InvalidResponseCodeException) {
            return new ErrorInfo(5, ((HttpDataSource.InvalidResponseCodeException) th).responseCode);
        }
        if ((th instanceof HttpDataSource.InvalidContentTypeException) || (th instanceof ParserException)) {
            return new ErrorInfo(z7 ? 10 : 11, 0);
        }
        boolean z11 = th instanceof HttpDataSource.HttpDataSourceException;
        if (z11 || (th instanceof UdpDataSource.UdpDataSourceException)) {
            if (NetworkTypeObserver.getInstance(context).getNetworkType() == 1) {
                return new ErrorInfo(3, 0);
            }
            Throwable cause = th.getCause();
            if (cause instanceof UnknownHostException) {
                return new ErrorInfo(6, 0);
            }
            if (cause instanceof SocketTimeoutException) {
                return new ErrorInfo(7, 0);
            }
            return (z11 && ((HttpDataSource.HttpDataSourceException) th).type == 1) ? new ErrorInfo(4, 0) : new ErrorInfo(8, 0);
        }
        if (playbackException.errorCode == 1002) {
            return new ErrorInfo(21, 0);
        }
        if (!(th instanceof DrmSession.DrmSessionException)) {
            if (!(th instanceof FileDataSource.FileDataSourceException) || !(th.getCause() instanceof FileNotFoundException)) {
                return new ErrorInfo(9, 0);
            }
            Throwable cause2 = ((Throwable) Assertions.checkNotNull(th.getCause())).getCause();
            return ((cause2 instanceof ErrnoException) && ((ErrnoException) cause2).errno == OsConstants.EACCES) ? new ErrorInfo(32, 0) : new ErrorInfo(31, 0);
        }
        Throwable th2 = (Throwable) Assertions.checkNotNull(th.getCause());
        if (th2 instanceof MediaDrm.MediaDrmStateException) {
            int errorCodeFromPlatformDiagnosticsInfo = Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo());
            return new ErrorInfo(getDrmErrorCode(errorCodeFromPlatformDiagnosticsInfo), errorCodeFromPlatformDiagnosticsInfo);
        }
        if (Util.SDK_INT >= 23 && AbstractC0107a.m286y(th2)) {
            return new ErrorInfo(27, 0);
        }
        if (th2 instanceof NotProvisionedException) {
            return new ErrorInfo(24, 0);
        }
        if (th2 instanceof DeniedByServerException) {
            return new ErrorInfo(29, 0);
        }
        if (th2 instanceof UnsupportedDrmException) {
            return new ErrorInfo(23, 0);
        }
        return th2 instanceof DefaultDrmSessionManager.MissingSchemeDataException ? new ErrorInfo(28, 0) : new ErrorInfo(30, 0);
    }

    private static Pair<String, String> getLanguageAndRegion(String str) {
        String[] strArrSplit = Util.split(str, "-");
        return Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
    }

    private static int getNetworkType(Context context) {
        switch (NetworkTypeObserver.getInstance(context).getNetworkType()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
            case 8:
            default:
                return 1;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
        }
    }

    private static int getStreamType(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = mediaItem.localConfiguration;
        if (localConfiguration == null) {
            return 0;
        }
        int iInferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(localConfiguration.uri, localConfiguration.mimeType);
        if (iInferContentTypeForUriAndMimeType == 0) {
            return 3;
        }
        if (iInferContentTypeForUriAndMimeType != 1) {
            return iInferContentTypeForUriAndMimeType != 2 ? 1 : 4;
        }
        return 5;
    }

    private static int getTrackChangeReason(int i6) {
        if (i6 == 1) {
            return 2;
        }
        if (i6 != 2) {
            return i6 != 3 ? 1 : 4;
        }
        return 3;
    }

    public void lambda$finishCurrentSession$4(PlaybackMetrics playbackMetrics) {
        this.playbackSession.reportPlaybackMetrics(playbackMetrics);
    }

    public void lambda$maybeReportNetworkChange$1(NetworkEvent networkEvent) {
        this.playbackSession.reportNetworkEvent(networkEvent);
    }

    public void lambda$maybeReportPlaybackError$0(PlaybackErrorEvent playbackErrorEvent) {
        this.playbackSession.reportPlaybackErrorEvent(playbackErrorEvent);
    }

    public void lambda$maybeReportPlaybackStateChange$2(PlaybackStateEvent playbackStateEvent) {
        this.playbackSession.reportPlaybackStateEvent(playbackStateEvent);
    }

    public void lambda$reportTrackChangeEvent$3(TrackChangeEvent trackChangeEvent) {
        this.playbackSession.reportTrackChangeEvent(trackChangeEvent);
    }

    private void maybeAddSessions(AnalyticsListener.Events events) {
        for (int i6 = 0; i6 < events.size(); i6++) {
            int i10 = events.get(i6);
            AnalyticsListener.EventTime eventTime = events.getEventTime(i10);
            if (i10 == 0) {
                this.sessionManager.updateSessionsWithTimelineChange(eventTime);
            } else if (i10 == 11) {
                this.sessionManager.updateSessionsWithDiscontinuity(eventTime, this.discontinuityReason);
            } else {
                this.sessionManager.updateSessions(eventTime);
            }
        }
    }

    private void maybeReportNetworkChange(long j10) {
        int networkType = getNetworkType(this.context);
        if (networkType != this.currentNetworkType) {
            this.currentNetworkType = networkType;
            this.backgroundExecutor.execute(new RunnableC0147m0(this, 4, AbstractC0683a0.m2061c().setNetworkType(networkType).setTimeSinceCreatedMillis(j10 - this.startTimeMs).build()));
        }
    }

    private void maybeReportPlaybackError(long j10) {
        PlaybackException playbackException = this.pendingPlayerError;
        if (playbackException == null) {
            return;
        }
        ErrorInfo errorInfo = getErrorInfo(playbackException, this.context, this.ioErrorType == 4);
        this.backgroundExecutor.execute(new RunnableC0147m0(this, 5, AbstractC0683a0.m2062d().setTimeSinceCreatedMillis(j10 - this.startTimeMs).setErrorCode(errorInfo.errorCode).setSubErrorCode(errorInfo.subErrorCode).setException(playbackException).build()));
        this.reportedEventsForCurrentSession = true;
        this.pendingPlayerError = null;
    }

    private void maybeReportPlaybackStateChange(Player player, AnalyticsListener.Events events, long j10) {
        if (player.getPlaybackState() != 2) {
            this.isSeeking = false;
        }
        if (player.getPlayerError() == null) {
            this.hasFatalError = false;
        } else if (events.contains(10)) {
            this.hasFatalError = true;
        }
        int iResolveNewPlaybackState = resolveNewPlaybackState(player);
        if (this.currentPlaybackState != iResolveNewPlaybackState) {
            this.currentPlaybackState = iResolveNewPlaybackState;
            this.reportedEventsForCurrentSession = true;
            this.backgroundExecutor.execute(new RunnableC0147m0(this, 7, AbstractC0683a0.m2070l().setState(this.currentPlaybackState).setTimeSinceCreatedMillis(j10 - this.startTimeMs).build()));
        }
    }

    private void maybeReportTrackChanges(Player player, AnalyticsListener.Events events, long j10) {
        if (events.contains(2)) {
            Tracks currentTracks = player.getCurrentTracks();
            boolean zIsTypeSelected = currentTracks.isTypeSelected(2);
            boolean zIsTypeSelected2 = currentTracks.isTypeSelected(1);
            boolean zIsTypeSelected3 = currentTracks.isTypeSelected(3);
            if (zIsTypeSelected || zIsTypeSelected2 || zIsTypeSelected3) {
                if (!zIsTypeSelected) {
                    maybeUpdateVideoFormat(j10, null, 0);
                }
                if (!zIsTypeSelected2) {
                    maybeUpdateAudioFormat(j10, null, 0);
                }
                if (!zIsTypeSelected3) {
                    maybeUpdateTextFormat(j10, null, 0);
                }
            }
        }
        if (canReportPendingFormatUpdate(this.pendingVideoFormat)) {
            PendingFormatUpdate pendingFormatUpdate = this.pendingVideoFormat;
            Format format = pendingFormatUpdate.format;
            if (format.height != -1) {
                maybeUpdateVideoFormat(j10, format, pendingFormatUpdate.selectionReason);
                this.pendingVideoFormat = null;
            }
        }
        if (canReportPendingFormatUpdate(this.pendingAudioFormat)) {
            PendingFormatUpdate pendingFormatUpdate2 = this.pendingAudioFormat;
            maybeUpdateAudioFormat(j10, pendingFormatUpdate2.format, pendingFormatUpdate2.selectionReason);
            this.pendingAudioFormat = null;
        }
        if (canReportPendingFormatUpdate(this.pendingTextFormat)) {
            PendingFormatUpdate pendingFormatUpdate3 = this.pendingTextFormat;
            maybeUpdateTextFormat(j10, pendingFormatUpdate3.format, pendingFormatUpdate3.selectionReason);
            this.pendingTextFormat = null;
        }
    }

    private void maybeUpdateAudioFormat(long j10, Format format, int i6) {
        if (Objects.equals(this.currentAudioFormat, format)) {
            return;
        }
        int i10 = (this.currentAudioFormat == null && i6 == 0) ? 1 : i6;
        this.currentAudioFormat = format;
        reportTrackChangeEvent(0, j10, format, i10);
    }

    private void maybeUpdateMetricsBuilderValues(Player player, AnalyticsListener.Events events) {
        DrmInitData drmInitData;
        if (events.contains(0)) {
            AnalyticsListener.EventTime eventTime = events.getEventTime(0);
            if (this.metricsBuilder != null) {
                maybeUpdateTimelineMetadata(eventTime.timeline, eventTime.mediaPeriodId);
            }
        }
        if (events.contains(2) && this.metricsBuilder != null && (drmInitData = getDrmInitData(player.getCurrentTracks().getGroups())) != null) {
            AbstractC0358v.m1041g(Util.castNonNull(this.metricsBuilder)).setDrmType(getDrmType(drmInitData));
        }
        if (events.contains(AnalyticsListener.EVENT_AUDIO_UNDERRUN)) {
            this.audioUnderruns++;
        }
    }

    private void maybeUpdateTextFormat(long j10, Format format, int i6) {
        if (Objects.equals(this.currentTextFormat, format)) {
            return;
        }
        int i10 = (this.currentTextFormat == null && i6 == 0) ? 1 : i6;
        this.currentTextFormat = format;
        reportTrackChangeEvent(2, j10, format, i10);
    }

    private void maybeUpdateTimelineMetadata(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        int indexOfPeriod;
        PlaybackMetrics.Builder builder = this.metricsBuilder;
        if (mediaPeriodId == null || (indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodId.periodUid)) == -1) {
            return;
        }
        timeline.getPeriod(indexOfPeriod, this.period);
        timeline.getWindow(this.period.windowIndex, this.window);
        builder.setStreamType(getStreamType(this.window.mediaItem));
        Timeline.Window window = this.window;
        if (window.durationUs != C0565C.TIME_UNSET && !window.isPlaceholder && !window.isDynamic && !window.isLive()) {
            builder.setMediaDurationMillis(this.window.getDurationMs());
        }
        builder.setPlaybackType(this.window.isLive() ? 2 : 1);
        this.reportedEventsForCurrentSession = true;
    }

    private void maybeUpdateVideoFormat(long j10, Format format, int i6) {
        if (Objects.equals(this.currentVideoFormat, format)) {
            return;
        }
        int i10 = (this.currentVideoFormat == null && i6 == 0) ? 1 : i6;
        this.currentVideoFormat = format;
        reportTrackChangeEvent(1, j10, format, i10);
    }

    private void reportTrackChangeEvent(int i6, long j10, Format format, int i10) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = AbstractC0683a0.m2074p(i6).setTimeSinceCreatedMillis(j10 - this.startTimeMs);
        if (format != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(getTrackChangeReason(i10));
            String str = format.containerMimeType;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = format.sampleMimeType;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = format.codecs;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i11 = format.bitrate;
            if (i11 != -1) {
                timeSinceCreatedMillis.setBitrate(i11);
            }
            int i12 = format.width;
            if (i12 != -1) {
                timeSinceCreatedMillis.setWidth(i12);
            }
            int i13 = format.height;
            if (i13 != -1) {
                timeSinceCreatedMillis.setHeight(i13);
            }
            int i14 = format.channelCount;
            if (i14 != -1) {
                timeSinceCreatedMillis.setChannelCount(i14);
            }
            int i15 = format.sampleRate;
            if (i15 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i15);
            }
            String str4 = format.language;
            if (str4 != null) {
                Pair<String, String> languageAndRegion = getLanguageAndRegion(str4);
                timeSinceCreatedMillis.setLanguage((String) languageAndRegion.first);
                Object obj = languageAndRegion.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f = format.frameRate;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.reportedEventsForCurrentSession = true;
        this.backgroundExecutor.execute(new RunnableC0147m0(this, 3, timeSinceCreatedMillis.build()));
    }

    private int resolveNewPlaybackState(Player player) {
        int playbackState = player.getPlaybackState();
        if (this.isSeeking) {
            return 5;
        }
        if (this.hasFatalError) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            int i6 = this.currentPlaybackState;
            if (i6 == 0 || i6 == 2 || i6 == 12) {
                return 2;
            }
            if (player.getPlayWhenReady()) {
                return player.getPlaybackSuppressionReason() != 0 ? 10 : 6;
            }
            return 7;
        }
        if (playbackState == 3) {
            if (player.getPlayWhenReady()) {
                return player.getPlaybackSuppressionReason() != 0 ? 9 : 3;
            }
            return 4;
        }
        if (playbackState != 1 || this.currentPlaybackState == 0) {
            return this.currentPlaybackState;
        }
        return 12;
    }

    public LogSessionId getLogSessionId() {
        return this.playbackSession.getSessionId();
    }

    @Override
    public final void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        AbstractC0682a.m2004a(this, eventTime, audioAttributes);
    }

    @Override
    public final void onAudioCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
        AbstractC0682a.m2006b(this, eventTime, exc);
    }

    @Override
    public final void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j10) {
        AbstractC0682a.m2008c(this, eventTime, str, j10);
    }

    @Override
    public final void onAudioDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        AbstractC0682a.m2012e(this, eventTime, str);
    }

    @Override
    public final void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        AbstractC0682a.m2014f(this, eventTime, decoderCounters);
    }

    @Override
    public final void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        AbstractC0682a.m2016g(this, eventTime, decoderCounters);
    }

    @Override
    public final void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AbstractC0682a.m2018h(this, eventTime, format, decoderReuseEvaluation);
    }

    @Override
    public final void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j10) {
        AbstractC0682a.m2020i(this, eventTime, j10);
    }

    @Override
    public final void onAudioSessionIdChanged(AnalyticsListener.EventTime eventTime, int i6) {
        AbstractC0682a.m2022j(this, eventTime, i6);
    }

    @Override
    public final void onAudioSinkError(AnalyticsListener.EventTime eventTime, Exception exc) {
        AbstractC0682a.m2024k(this, eventTime, exc);
    }

    @Override
    public final void onAudioTrackInitialized(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        AbstractC0682a.m2026l(this, eventTime, audioTrackConfig);
    }

    @Override
    public final void onAudioTrackReleased(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        AbstractC0682a.m2028m(this, eventTime, audioTrackConfig);
    }

    @Override
    public final void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i6, long j10, long j11) {
        AbstractC0682a.m2030n(this, eventTime, i6, j10, j11);
    }

    @Override
    public final void onAvailableCommandsChanged(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
        AbstractC0682a.m2032o(this, eventTime, commands);
    }

    @Override
    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i6, long j10, long j11) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (mediaPeriodId != null) {
            String sessionForMediaPeriodId = this.sessionManager.getSessionForMediaPeriodId(eventTime.timeline, (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId));
            Long l9 = this.bandwidthBytes.get(sessionForMediaPeriodId);
            Long l10 = this.bandwidthTimeMs.get(sessionForMediaPeriodId);
            this.bandwidthBytes.put(sessionForMediaPeriodId, Long.valueOf((l9 == null ? 0L : l9.longValue()) + j10));
            this.bandwidthTimeMs.put(sessionForMediaPeriodId, Long.valueOf((l10 != null ? l10.longValue() : 0L) + ((long) i6)));
        }
    }

    @Override
    public final void onCues(AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
        AbstractC0682a.m2036q(this, eventTime, cueGroup);
    }

    @Override
    public final void onDeviceInfoChanged(AnalyticsListener.EventTime eventTime, DeviceInfo deviceInfo) {
        AbstractC0682a.m2040s(this, eventTime, deviceInfo);
    }

    @Override
    public final void onDeviceVolumeChanged(AnalyticsListener.EventTime eventTime, int i6, boolean z7) {
        AbstractC0682a.m2042t(this, eventTime, i6, z7);
    }

    @Override
    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        if (eventTime.mediaPeriodId == null) {
            return;
        }
        PendingFormatUpdate pendingFormatUpdate = new PendingFormatUpdate((Format) Assertions.checkNotNull(mediaLoadData.trackFormat), mediaLoadData.trackSelectionReason, this.sessionManager.getSessionForMediaPeriodId(eventTime.timeline, (MediaSource.MediaPeriodId) Assertions.checkNotNull(eventTime.mediaPeriodId)));
        int i6 = mediaLoadData.trackType;
        if (i6 != 0) {
            if (i6 == 1) {
                this.pendingAudioFormat = pendingFormatUpdate;
                return;
            } else if (i6 != 2) {
                if (i6 != 3) {
                    return;
                }
                this.pendingTextFormat = pendingFormatUpdate;
                return;
            }
        }
        this.pendingVideoFormat = pendingFormatUpdate;
    }

    @Override
    public final void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        AbstractC0682a.m2046v(this, eventTime);
    }

    @Override
    public final void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        AbstractC0682a.m2048w(this, eventTime);
    }

    @Override
    public final void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        AbstractC0682a.m2050x(this, eventTime);
    }

    @Override
    public final void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        AbstractC0682a.m2052y(this, eventTime);
    }

    @Override
    public final void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        AbstractC0682a.m1978A(this, eventTime, exc);
    }

    @Override
    public final void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        AbstractC0682a.m1979B(this, eventTime);
    }

    @Override
    public final void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i6, long j10) {
        AbstractC0682a.m1980C(this, eventTime, i6, j10);
    }

    @Override
    public void onEvents(Player player, AnalyticsListener.Events events) {
        if (events.size() == 0) {
            return;
        }
        maybeAddSessions(events);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        maybeUpdateMetricsBuilderValues(player, events);
        maybeReportPlaybackError(jElapsedRealtime);
        maybeReportTrackChanges(player, events, jElapsedRealtime);
        maybeReportNetworkChange(jElapsedRealtime);
        maybeReportPlaybackStateChange(player, events, jElapsedRealtime);
        if (events.contains(AnalyticsListener.EVENT_PLAYER_RELEASED)) {
            this.sessionManager.finishAllSessions(events.getEventTime(AnalyticsListener.EVENT_PLAYER_RELEASED));
        }
    }

    @Override
    public final void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z7) {
        AbstractC0682a.m1982E(this, eventTime, z7);
    }

    @Override
    public final void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z7) {
        AbstractC0682a.m1983F(this, eventTime, z7);
    }

    @Override
    public final void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AbstractC0682a.m1984G(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override
    public final void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AbstractC0682a.m1985H(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override
    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z7) {
        this.ioErrorType = mediaLoadData.dataType;
    }

    @Override
    public final void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AbstractC0682a.m1987J(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override
    public final void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z7) {
        AbstractC0682a.m1989L(this, eventTime, z7);
    }

    @Override
    public final void onMaxSeekToPreviousPositionChanged(AnalyticsListener.EventTime eventTime, long j10) {
        AbstractC0682a.m1990M(this, eventTime, j10);
    }

    @Override
    public final void onMediaItemTransition(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i6) {
        AbstractC0682a.m1991N(this, eventTime, mediaItem, i6);
    }

    @Override
    public final void onMediaMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        AbstractC0682a.m1992O(this, eventTime, mediaMetadata);
    }

    @Override
    public final void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        AbstractC0682a.m1993P(this, eventTime, metadata);
    }

    @Override
    public final void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z7, int i6) {
        AbstractC0682a.m1994Q(this, eventTime, z7, i6);
    }

    @Override
    public final void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        AbstractC0682a.m1995R(this, eventTime, playbackParameters);
    }

    @Override
    public final void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i6) {
        AbstractC0682a.m1996S(this, eventTime, i6);
    }

    @Override
    public final void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i6) {
        AbstractC0682a.m1997T(this, eventTime, i6);
    }

    @Override
    public void onPlayerError(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.pendingPlayerError = playbackException;
    }

    @Override
    public final void onPlayerErrorChanged(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        AbstractC0682a.m1999V(this, eventTime, playbackException);
    }

    @Override
    public final void onPlayerReleased(AnalyticsListener.EventTime eventTime) {
        AbstractC0682a.m2000W(this, eventTime);
    }

    @Override
    public final void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z7, int i6) {
        AbstractC0682a.m2001X(this, eventTime, z7, i6);
    }

    @Override
    public final void onPlaylistMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        AbstractC0682a.m2002Y(this, eventTime, mediaMetadata);
    }

    @Override
    public final void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i6) {
        AbstractC0682a.m2003Z(this, eventTime, i6);
    }

    @Override
    public final void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Object obj, long j10) {
        AbstractC0682a.m2007b0(this, eventTime, obj, j10);
    }

    @Override
    public final void onRendererReadyChanged(AnalyticsListener.EventTime eventTime, int i6, int i10, boolean z7) {
        AbstractC0682a.m2009c0(this, eventTime, i6, i10, z7);
    }

    @Override
    public final void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i6) {
        AbstractC0682a.m2011d0(this, eventTime, i6);
    }

    @Override
    public final void onSeekBackIncrementChanged(AnalyticsListener.EventTime eventTime, long j10) {
        AbstractC0682a.m2013e0(this, eventTime, j10);
    }

    @Override
    public final void onSeekForwardIncrementChanged(AnalyticsListener.EventTime eventTime, long j10) {
        AbstractC0682a.m2015f0(this, eventTime, j10);
    }

    @Override
    public final void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        AbstractC0682a.m2017g0(this, eventTime);
    }

    @Override
    public void onSessionActive(AnalyticsListener.EventTime eventTime, String str) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (mediaPeriodId == null || !mediaPeriodId.isAd()) {
            finishCurrentSession();
            this.activeSessionId = str;
            this.metricsBuilder = AbstractC0683a0.m2067i().setPlayerName(MediaLibraryInfo.TAG).setPlayerVersion(MediaLibraryInfo.VERSION);
            maybeUpdateTimelineMetadata(eventTime.timeline, eventTime.mediaPeriodId);
        }
    }

    @Override
    public void onSessionFinished(AnalyticsListener.EventTime eventTime, String str, boolean z7) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if ((mediaPeriodId == null || !mediaPeriodId.isAd()) && str.equals(this.activeSessionId)) {
            finishCurrentSession();
        }
        this.bandwidthTimeMs.remove(str);
        this.bandwidthBytes.remove(str);
    }

    @Override
    public final void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z7) {
        AbstractC0682a.m2019h0(this, eventTime, z7);
    }

    @Override
    public final void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z7) {
        AbstractC0682a.m2021i0(this, eventTime, z7);
    }

    @Override
    public final void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i6, int i10) {
        AbstractC0682a.m2023j0(this, eventTime, i6, i10);
    }

    @Override
    public final void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i6) {
        AbstractC0682a.m2025k0(this, eventTime, i6);
    }

    @Override
    public final void onTrackSelectionParametersChanged(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        AbstractC0682a.m2027l0(this, eventTime, trackSelectionParameters);
    }

    @Override
    public final void onTracksChanged(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        AbstractC0682a.m2029m0(this, eventTime, tracks);
    }

    @Override
    public final void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        AbstractC0682a.m2031n0(this, eventTime, mediaLoadData);
    }

    @Override
    public final void onVideoCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
        AbstractC0682a.m2033o0(this, eventTime, exc);
    }

    @Override
    public final void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j10) {
        AbstractC0682a.m2035p0(this, eventTime, str, j10);
    }

    @Override
    public final void onVideoDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        AbstractC0682a.m2039r0(this, eventTime, str);
    }

    @Override
    public void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.droppedFrames += decoderCounters.droppedBufferCount;
        this.playedFrames += decoderCounters.renderedOutputBufferCount;
    }

    @Override
    public final void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        AbstractC0682a.m2043t0(this, eventTime, decoderCounters);
    }

    @Override
    public final void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j10, int i6) {
        AbstractC0682a.m2045u0(this, eventTime, j10, i6);
    }

    @Override
    public final void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AbstractC0682a.m2047v0(this, eventTime, format, decoderReuseEvaluation);
    }

    @Override
    public final void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i6, int i10, int i11, float f) {
        AbstractC0682a.m2049w0(this, eventTime, i6, i10, i11, f);
    }

    @Override
    public final void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f) {
        AbstractC0682a.m2053y0(this, eventTime, f);
    }

    @Override
    public final void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j10, long j11) {
        AbstractC0682a.m2010d(this, eventTime, str, j10, j11);
    }

    @Override
    public final void onCues(AnalyticsListener.EventTime eventTime, List list) {
        AbstractC0682a.m2038r(this, eventTime, list);
    }

    @Override
    public final void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime, int i6) {
        AbstractC0682a.m2054z(this, eventTime, i6);
    }

    @Override
    public final void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i6) {
        AbstractC0682a.m1988K(this, eventTime, loadEventInfo, mediaLoadData, i6);
    }

    @Override
    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i6) {
        if (i6 == 1) {
            this.isSeeking = true;
        }
        this.discontinuityReason = i6;
    }

    @Override
    public final void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j10, long j11) {
        AbstractC0682a.m2037q0(this, eventTime, str, j10, j11);
    }

    @Override
    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        PendingFormatUpdate pendingFormatUpdate = this.pendingVideoFormat;
        if (pendingFormatUpdate != null) {
            Format format = pendingFormatUpdate.format;
            if (format.height == -1) {
                this.pendingVideoFormat = new PendingFormatUpdate(format.buildUpon().setWidth(videoSize.width).setHeight(videoSize.height).build(), pendingFormatUpdate.selectionReason, pendingFormatUpdate.sessionId);
            }
        }
    }

    @Override
    public void onSessionCreated(AnalyticsListener.EventTime eventTime, String str) {
    }

    @Override
    public void onAdPlaybackStarted(AnalyticsListener.EventTime eventTime, String str, String str2) {
    }
}
