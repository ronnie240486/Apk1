package androidx.media3.exoplayer.util;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.widget.TextView;
import androidx.media3.common.AbstractC0602k;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.ColorInfo;
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
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.ExoPlayer;
import java.util.List;
import java.util.Locale;
import p000a.AbstractC0004e;

public class DebugTextViewHelper {
    private static final int REFRESH_INTERVAL_MS = 1000;
    private final ExoPlayer player;
    private boolean started;
    private final TextView textView;
    private final Updater updater;

    public final class Updater implements Player.Listener, Runnable {
        private Updater() {
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
        public final void onMetadata(Metadata metadata) {
            AbstractC0602k.m1696o(this, metadata);
        }

        @Override
        public void onPlayWhenReadyChanged(boolean z7, int i6) {
            DebugTextViewHelper.this.updateAndPost();
        }

        @Override
        public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            AbstractC0602k.m1698q(this, playbackParameters);
        }

        @Override
        public void onPlaybackStateChanged(int i6) {
            DebugTextViewHelper.this.updateAndPost();
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
        public void run() {
            DebugTextViewHelper.this.updateAndPost();
        }

        @Override
        public final void onCues(List list) {
            AbstractC0602k.m1686e(this, list);
        }

        @Override
        public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i6) {
            DebugTextViewHelper.this.updateAndPost();
        }
    }

    public DebugTextViewHelper(ExoPlayer exoPlayer, TextView textView) {
        Assertions.checkArgument(exoPlayer.getApplicationLooper() == Looper.getMainLooper());
        this.player = exoPlayer;
        this.textView = textView;
        this.updater = new Updater();
    }

    private static String getColorInfoString(ColorInfo colorInfo) {
        if (colorInfo == null || !colorInfo.isValid()) {
            return "";
        }
        return " colr:" + colorInfo.toLogString();
    }

    private static String getDecoderCountersBufferCountString(DecoderCounters decoderCounters) {
        if (decoderCounters == null) {
            return "";
        }
        decoderCounters.ensureUpdated();
        return " sib:" + decoderCounters.skippedInputBufferCount + " sb:" + decoderCounters.skippedOutputBufferCount + " rb:" + decoderCounters.renderedOutputBufferCount + " dib:" + decoderCounters.droppedInputBufferCount + " db:" + decoderCounters.droppedBufferCount + " mcdb:" + decoderCounters.maxConsecutiveDroppedBufferCount + " dk:" + decoderCounters.droppedToKeyframeCount;
    }

    private static String getPixelAspectRatioString(float f) {
        return (f == -1.0f || f == 1.0f) ? "" : " par:".concat(String.format(Locale.US, "%.02f", Float.valueOf(f)));
    }

    private static String getVideoFrameProcessingOffsetAverageString(long j10, int i6) {
        return i6 == 0 ? "N/A" : String.valueOf((long) (j10 / ((double) i6)));
    }

    @UnstableApi
    public String getAudioString() {
        Format audioFormat = this.player.getAudioFormat();
        DecoderCounters audioDecoderCounters = this.player.getAudioDecoderCounters();
        if (audioFormat == null || audioDecoderCounters == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("\n");
        sb.append(audioFormat.sampleMimeType);
        sb.append("(id:");
        sb.append(audioFormat.f2579id);
        sb.append(" hz:");
        sb.append(audioFormat.sampleRate);
        sb.append(" ch:");
        sb.append(audioFormat.channelCount);
        return AbstractC0004e.m26t(sb, getDecoderCountersBufferCountString(audioDecoderCounters), ")");
    }

    @UnstableApi
    public String getDebugString() {
        return getPlayerStateString() + getVideoString() + getAudioString();
    }

    @UnstableApi
    public String getPlayerStateString() {
        String str;
        int playbackState = this.player.getPlaybackState();
        if (playbackState == 1) {
            str = "idle";
        } else if (playbackState == 2) {
            str = "buffering";
        } else if (playbackState != 3) {
            str = playbackState != 4 ? "unknown" : "ended";
        } else {
            str = "ready";
        }
        return "playWhenReady:" + this.player.getPlayWhenReady() + " playbackState:" + str + " item:" + this.player.getCurrentMediaItemIndex();
    }

    @UnstableApi
    public String getVideoString() {
        Format videoFormat = this.player.getVideoFormat();
        VideoSize videoSize = this.player.getVideoSize();
        DecoderCounters videoDecoderCounters = this.player.getVideoDecoderCounters();
        if (videoFormat == null || videoDecoderCounters == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("\n");
        sb.append(videoFormat.sampleMimeType);
        sb.append("(id:");
        sb.append(videoFormat.f2579id);
        sb.append(" r:");
        sb.append(videoSize.width);
        sb.append("x");
        sb.append(videoSize.height);
        sb.append(getColorInfoString(videoFormat.colorInfo));
        sb.append(getPixelAspectRatioString(videoSize.pixelWidthHeightRatio));
        sb.append(getDecoderCountersBufferCountString(videoDecoderCounters));
        sb.append(" vfpo: ");
        return AbstractC0004e.m26t(sb, getVideoFrameProcessingOffsetAverageString(videoDecoderCounters.totalVideoFrameProcessingOffsetUs, videoDecoderCounters.videoFrameProcessingOffsetCount), ")");
    }

    public final void start() {
        if (this.started) {
            return;
        }
        this.started = true;
        this.player.addListener(this.updater);
        updateAndPost();
    }

    public final void stop() {
        if (this.started) {
            this.started = false;
            this.player.removeListener(this.updater);
            this.textView.removeCallbacks(this.updater);
        }
    }

    @SuppressLint({"SetTextI18n"})
    @UnstableApi
    public final void updateAndPost() {
        this.textView.setText(getDebugString());
        this.textView.removeCallbacks(this.updater);
        this.textView.postDelayed(this.updater, 1000L);
    }
}
