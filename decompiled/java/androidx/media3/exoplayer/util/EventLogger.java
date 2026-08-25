package androidx.media3.exoplayer.util;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C0565C;
import androidx.media3.common.DeviceInfo;
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
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.analytics.AbstractC0682a;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import p000a.AbstractC0004e;
import p041d7.AbstractC2301u1;
import p055ea.AbstractC2460q;

public class EventLogger implements AnalyticsListener {
    private static final String DEFAULT_TAG = "EventLogger";
    private static final int MAX_TIMELINE_ITEM_LINES = 3;
    private static final NumberFormat TIME_FORMAT;
    private final Timeline.Period period;
    private final long startTimeMs;
    private final String tag;
    private final Timeline.Window window;

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        TIME_FORMAT = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public EventLogger() {
        this(DEFAULT_TAG);
    }

    private static String getAudioTrackConfigString(AudioSink.AudioTrackConfig audioTrackConfig) {
        return audioTrackConfig.encoding + "," + audioTrackConfig.channelConfig + "," + audioTrackConfig.sampleRate + "," + audioTrackConfig.tunneling + "," + audioTrackConfig.offload + "," + audioTrackConfig.bufferSize;
    }

    private static String getDiscontinuityReasonString(int i6) {
        switch (i6) {
            case 0:
                return "AUTO_TRANSITION";
            case 1:
                return "SEEK";
            case 2:
                return "SEEK_ADJUSTMENT";
            case 3:
                return HlsMediaPlaylist.Interstitial.NAVIGATION_RESTRICTION_SKIP;
            case 4:
                return "REMOVE";
            case 5:
                return "INTERNAL";
            case 6:
                return "SILENCE_SKIP";
            default:
                return "?";
        }
    }

    private String getEventString(AnalyticsListener.EventTime eventTime, String str, String str2, Throwable th) {
        StringBuilder sbM29w = AbstractC0004e.m29w(str, " [");
        sbM29w.append(getEventTimeString(eventTime));
        String string = sbM29w.toString();
        if (th instanceof PlaybackException) {
            StringBuilder sbM29w2 = AbstractC0004e.m29w(string, ", errorCode=");
            sbM29w2.append(((PlaybackException) th).getErrorCodeName());
            string = sbM29w2.toString();
        }
        if (str2 != null) {
            string = AbstractC2460q.m5495i(string, ", ", str2);
        }
        String throwableString = Log.getThrowableString(th);
        if (!TextUtils.isEmpty(throwableString)) {
            StringBuilder sbM29w3 = AbstractC0004e.m29w(string, "\n  ");
            sbM29w3.append(throwableString.replace("\n", "\n  "));
            sbM29w3.append('\n');
            string = sbM29w3.toString();
        }
        return AbstractC2460q.m5494h(string, "]");
    }

    private String getEventTimeString(AnalyticsListener.EventTime eventTime) {
        String string = "window=" + eventTime.windowIndex;
        if (eventTime.mediaPeriodId != null) {
            StringBuilder sbM29w = AbstractC0004e.m29w(string, ", period=");
            sbM29w.append(eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid));
            string = sbM29w.toString();
            if (eventTime.mediaPeriodId.isAd()) {
                StringBuilder sbM29w2 = AbstractC0004e.m29w(string, ", adGroup=");
                sbM29w2.append(eventTime.mediaPeriodId.adGroupIndex);
                StringBuilder sbM29w3 = AbstractC0004e.m29w(sbM29w2.toString(), ", ad=");
                sbM29w3.append(eventTime.mediaPeriodId.adIndexInAdGroup);
                string = sbM29w3.toString();
            }
        }
        return "eventTime=" + getTimeString(eventTime.realtimeMs - this.startTimeMs) + ", mediaPos=" + getTimeString(eventTime.eventPlaybackPositionMs) + ", " + string;
    }

    private static String getMediaItemTransitionReasonString(int i6) {
        if (i6 == 0) {
            return "REPEAT";
        }
        if (i6 == 1) {
            return "AUTO";
        }
        if (i6 != 2) {
            return i6 != 3 ? "?" : "PLAYLIST_CHANGED";
        }
        return "SEEK";
    }

    private static String getPlayWhenReadyChangeReasonString(int i6) {
        if (i6 == 1) {
            return "USER_REQUEST";
        }
        if (i6 == 2) {
            return "AUDIO_FOCUS_LOSS";
        }
        if (i6 == 3) {
            return "AUDIO_BECOMING_NOISY";
        }
        if (i6 != 4) {
            return i6 != 5 ? "?" : "END_OF_MEDIA_ITEM";
        }
        return "REMOTE";
    }

    private static String getPlaybackSuppressionReasonString(int i6) {
        if (i6 == 0) {
            return "NONE";
        }
        if (i6 != 1) {
            return i6 != 3 ? "?" : "UNSUITABLE_AUDIO_OUTPUT";
        }
        return "TRANSIENT_AUDIO_FOCUS_LOSS";
    }

    private static String getRepeatModeString(int i6) {
        if (i6 == 0) {
            return "OFF";
        }
        if (i6 != 1) {
            return i6 != 2 ? "?" : "ALL";
        }
        return "ONE";
    }

    private static String getStateString(int i6) {
        if (i6 == 1) {
            return "IDLE";
        }
        if (i6 == 2) {
            return "BUFFERING";
        }
        if (i6 != 3) {
            return i6 != 4 ? "?" : "ENDED";
        }
        return "READY";
    }

    private static String getTimeString(long j10) {
        return j10 == C0565C.TIME_UNSET ? "?" : TIME_FORMAT.format(j10 / 1000.0f);
    }

    private static String getTimelineChangeReasonString(int i6) {
        if (i6 != 0) {
            return i6 != 1 ? "?" : "SOURCE_UPDATE";
        }
        return "PLAYLIST_CHANGED";
    }

    private static String getTrackStatusString(boolean z7) {
        return z7 ? "[X]" : "[ ]";
    }

    private void printInternalError(AnalyticsListener.EventTime eventTime, String str, Exception exc) {
        loge(eventTime, "internalError", str, exc);
    }

    private void printMetadata(Metadata metadata, String str) {
        for (int i6 = 0; i6 < metadata.length(); i6++) {
            StringBuilder sbM5498l = AbstractC2460q.m5498l(str);
            sbM5498l.append(metadata.get(i6));
            logd(sbM5498l.toString());
        }
    }

    @UnstableApi
    public void logd(String str) {
        Log.m1713d(this.tag, str);
    }

    @UnstableApi
    public void loge(String str) {
        Log.m1715e(this.tag, str);
    }

    @Override
    @UnstableApi
    public void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        logd(eventTime, "audioAttributes", audioAttributes.contentType + "," + audioAttributes.flags + "," + audioAttributes.usage + "," + audioAttributes.allowedCapturePolicy);
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
    @UnstableApi
    public void onAudioDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        logd(eventTime, "audioDecoderReleased", str);
    }

    @Override
    @UnstableApi
    public void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "audioDisabled");
    }

    @Override
    @UnstableApi
    public void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "audioEnabled");
    }

    @Override
    @UnstableApi
    public void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        logd(eventTime, "audioInputFormat", Format.toLogString(format));
    }

    @Override
    public final void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j10) {
        AbstractC0682a.m2020i(this, eventTime, j10);
    }

    @Override
    @UnstableApi
    public void onAudioSessionIdChanged(AnalyticsListener.EventTime eventTime, int i6) {
        logd(eventTime, "audioSessionId", Integer.toString(i6));
    }

    @Override
    public final void onAudioSinkError(AnalyticsListener.EventTime eventTime, Exception exc) {
        AbstractC0682a.m2024k(this, eventTime, exc);
    }

    @Override
    @UnstableApi
    public void onAudioTrackInitialized(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        logd(eventTime, "audioTrackInit", getAudioTrackConfigString(audioTrackConfig));
    }

    @Override
    @UnstableApi
    public void onAudioTrackReleased(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        logd(eventTime, "audioTrackReleased", getAudioTrackConfigString(audioTrackConfig));
    }

    @Override
    @UnstableApi
    public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i6, long j10, long j11) {
        loge(eventTime, "audioTrackUnderrun", i6 + ", " + j10 + ", " + j11, null);
    }

    @Override
    public final void onAvailableCommandsChanged(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
        AbstractC0682a.m2032o(this, eventTime, commands);
    }

    @Override
    public final void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i6, long j10, long j11) {
        AbstractC0682a.m2034p(this, eventTime, i6, j10, j11);
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
    @UnstableApi
    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        logd(eventTime, "downstreamFormat", Format.toLogString(mediaLoadData.trackFormat));
    }

    @Override
    @UnstableApi
    public void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysLoaded");
    }

    @Override
    @UnstableApi
    public void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRemoved");
    }

    @Override
    @UnstableApi
    public void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRestored");
    }

    @Override
    public final void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        AbstractC0682a.m2052y(this, eventTime);
    }

    @Override
    @UnstableApi
    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        printInternalError(eventTime, "drmSessionManagerError", exc);
    }

    @Override
    @UnstableApi
    public void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmSessionReleased");
    }

    @Override
    @UnstableApi
    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i6, long j10) {
        logd(eventTime, "droppedFrames", Integer.toString(i6));
    }

    @Override
    public final void onEvents(Player player, AnalyticsListener.Events events) {
        AbstractC0682a.m1981D(this, player, events);
    }

    @Override
    @UnstableApi
    public void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z7) {
        logd(eventTime, "loading", Boolean.toString(z7));
    }

    @Override
    @UnstableApi
    public void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z7) {
        logd(eventTime, "isPlaying", Boolean.toString(z7));
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
    @UnstableApi
    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z7) {
        printInternalError(eventTime, "loadError", iOException);
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
    @UnstableApi
    public void onMediaItemTransition(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i6) {
        logd("mediaItem [" + getEventTimeString(eventTime) + ", reason=" + getMediaItemTransitionReasonString(i6) + "]");
    }

    @Override
    public final void onMediaMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        AbstractC0682a.m1992O(this, eventTime, mediaMetadata);
    }

    @Override
    @UnstableApi
    public void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        logd("metadata [" + getEventTimeString(eventTime));
        printMetadata(metadata, "  ");
        logd("]");
    }

    @Override
    @UnstableApi
    public void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z7, int i6) {
        logd(eventTime, "playWhenReady", z7 + ", " + getPlayWhenReadyChangeReasonString(i6));
    }

    @Override
    @UnstableApi
    public void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        logd(eventTime, "playbackParameters", playbackParameters.toString());
    }

    @Override
    @UnstableApi
    public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i6) {
        logd(eventTime, "state", getStateString(i6));
    }

    @Override
    @UnstableApi
    public void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i6) {
        logd(eventTime, "playbackSuppressionReason", getPlaybackSuppressionReasonString(i6));
    }

    @Override
    @UnstableApi
    public void onPlayerError(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        loge(eventTime, "playerFailed", playbackException);
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
    @UnstableApi
    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Object obj, long j10) {
        logd(eventTime, "renderedFirstFrame", String.valueOf(obj));
    }

    @Override
    @UnstableApi
    public void onRendererReadyChanged(AnalyticsListener.EventTime eventTime, int i6, int i10, boolean z7) {
        StringBuilder sbM27u = AbstractC0004e.m27u(i6, "rendererIndex=", ", ");
        sbM27u.append(Util.getTrackTypeString(i10));
        sbM27u.append(", ");
        sbM27u.append(z7);
        logd(eventTime, "rendererReady", sbM27u.toString());
    }

    @Override
    @UnstableApi
    public void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i6) {
        logd(eventTime, "repeatMode", getRepeatModeString(i6));
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
    @UnstableApi
    public void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z7) {
        logd(eventTime, "shuffleModeEnabled", Boolean.toString(z7));
    }

    @Override
    @UnstableApi
    public void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z7) {
        logd(eventTime, "skipSilenceEnabled", Boolean.toString(z7));
    }

    @Override
    @UnstableApi
    public void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i6, int i10) {
        logd(eventTime, "surfaceSize", i6 + ", " + i10);
    }

    @Override
    @UnstableApi
    public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i6) {
        int periodCount = eventTime.timeline.getPeriodCount();
        int windowCount = eventTime.timeline.getWindowCount();
        logd("timeline [" + getEventTimeString(eventTime) + ", periodCount=" + periodCount + ", windowCount=" + windowCount + ", reason=" + getTimelineChangeReasonString(i6));
        for (int i10 = 0; i10 < Math.min(periodCount, 3); i10++) {
            eventTime.timeline.getPeriod(i10, this.period);
            logd("  period [" + getTimeString(this.period.getDurationMs()) + "]");
        }
        if (periodCount > 3) {
            logd("  ...");
        }
        for (int i11 = 0; i11 < Math.min(windowCount, 3); i11++) {
            eventTime.timeline.getWindow(i11, this.window);
            logd("  window [" + getTimeString(this.window.getDurationMs()) + ", seekable=" + this.window.isSeekable + ", dynamic=" + this.window.isDynamic + "]");
        }
        if (windowCount > 3) {
            logd("  ...");
        }
        logd("]");
    }

    @Override
    public final void onTrackSelectionParametersChanged(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        AbstractC0682a.m2027l0(this, eventTime, trackSelectionParameters);
    }

    @Override
    @UnstableApi
    public void onTracksChanged(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        Metadata metadata;
        logd("tracks [" + getEventTimeString(eventTime));
        AbstractC2301u1 groups = tracks.getGroups();
        for (int i6 = 0; i6 < groups.size(); i6++) {
            Tracks.Group group = (Tracks.Group) groups.get(i6);
            logd("  group [");
            for (int i10 = 0; i10 < group.length; i10++) {
                logd("    " + getTrackStatusString(group.isTrackSelected(i10)) + " Track:" + i10 + ", " + Format.toLogString(group.getTrackFormat(i10)) + ", supported=" + Util.getFormatSupportString(group.getTrackSupport(i10)));
            }
            logd("  ]");
        }
        boolean z7 = false;
        for (int i11 = 0; !z7 && i11 < groups.size(); i11++) {
            Tracks.Group group2 = (Tracks.Group) groups.get(i11);
            for (int i12 = 0; !z7 && i12 < group2.length; i12++) {
                if (group2.isTrackSelected(i12) && (metadata = group2.getTrackFormat(i12).metadata) != null && metadata.length() > 0) {
                    logd("  Metadata [");
                    printMetadata(metadata, "    ");
                    logd("  ]");
                    z7 = true;
                }
            }
        }
        logd("]");
    }

    @Override
    @UnstableApi
    public void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        logd(eventTime, "upstreamDiscarded", Format.toLogString(mediaLoadData.trackFormat));
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
    @UnstableApi
    public void onVideoDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        logd(eventTime, "videoDecoderReleased", str);
    }

    @Override
    @UnstableApi
    public void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "videoDisabled");
    }

    @Override
    @UnstableApi
    public void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "videoEnabled");
    }

    @Override
    public final void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j10, int i6) {
        AbstractC0682a.m2045u0(this, eventTime, j10, i6);
    }

    @Override
    @UnstableApi
    public void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        logd(eventTime, "videoInputFormat", Format.toLogString(format));
    }

    @Override
    public final void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i6, int i10, int i11, float f) {
        AbstractC0682a.m2049w0(this, eventTime, i6, i10, i11, f);
    }

    @Override
    @UnstableApi
    public void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f) {
        logd(eventTime, "volume", Float.toString(f));
    }

    public EventLogger(String str) {
        this.tag = str;
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.startTimeMs = SystemClock.elapsedRealtime();
    }

    private void logd(AnalyticsListener.EventTime eventTime, String str) {
        logd(getEventString(eventTime, str, null, null));
    }

    private void loge(AnalyticsListener.EventTime eventTime, String str, Throwable th) {
        loge(getEventString(eventTime, str, null, th));
    }

    @Override
    @UnstableApi
    public void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j10, long j11) {
        logd(eventTime, "audioDecoderInitialized", str);
    }

    @Override
    public final void onCues(AnalyticsListener.EventTime eventTime, List list) {
        AbstractC0682a.m2038r(this, eventTime, list);
    }

    @Override
    @UnstableApi
    public void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime, int i6) {
        logd(eventTime, "drmSessionAcquired", AbstractC0004e.m20n(i6, "state="));
    }

    @Override
    public final void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i6) {
        AbstractC0682a.m1988K(this, eventTime, loadEventInfo, mediaLoadData, i6);
    }

    @Override
    @UnstableApi
    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i6) {
        StringBuilder sb = new StringBuilder("reason=");
        sb.append(getDiscontinuityReasonString(i6));
        sb.append(", PositionInfo:old [mediaItem=");
        sb.append(positionInfo.mediaItemIndex);
        sb.append(", period=");
        sb.append(positionInfo.periodIndex);
        sb.append(", pos=");
        sb.append(positionInfo.positionMs);
        if (positionInfo.adGroupIndex != -1) {
            sb.append(", contentPos=");
            sb.append(positionInfo.contentPositionMs);
            sb.append(", adGroup=");
            sb.append(positionInfo.adGroupIndex);
            sb.append(", ad=");
            sb.append(positionInfo.adIndexInAdGroup);
        }
        sb.append("], PositionInfo:new [mediaItem=");
        sb.append(positionInfo2.mediaItemIndex);
        sb.append(", period=");
        sb.append(positionInfo2.periodIndex);
        sb.append(", pos=");
        sb.append(positionInfo2.positionMs);
        if (positionInfo2.adGroupIndex != -1) {
            sb.append(", contentPos=");
            sb.append(positionInfo2.contentPositionMs);
            sb.append(", adGroup=");
            sb.append(positionInfo2.adGroupIndex);
            sb.append(", ad=");
            sb.append(positionInfo2.adIndexInAdGroup);
        }
        sb.append("]");
        logd(eventTime, "positionDiscontinuity", sb.toString());
    }

    @Override
    @UnstableApi
    public void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j10, long j11) {
        logd(eventTime, "videoDecoderInitialized", str);
    }

    @Override
    @UnstableApi
    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        logd(eventTime, "videoSize", videoSize.width + ", " + videoSize.height);
    }

    private void logd(AnalyticsListener.EventTime eventTime, String str, String str2) {
        logd(getEventString(eventTime, str, str2, null));
    }

    private void loge(AnalyticsListener.EventTime eventTime, String str, String str2, Throwable th) {
        loge(getEventString(eventTime, str, str2, th));
    }

    @UnstableApi
    @Deprecated
    public EventLogger(MappingTrackSelector mappingTrackSelector) {
        this(DEFAULT_TAG);
    }

    @UnstableApi
    @Deprecated
    public EventLogger(MappingTrackSelector mappingTrackSelector, String str) {
        this(str);
    }
}
