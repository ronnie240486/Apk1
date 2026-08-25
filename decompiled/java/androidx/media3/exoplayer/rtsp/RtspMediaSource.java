package androidx.media3.exoplayer.rtsp;

import android.net.Uri;
import androidx.media3.common.C0565C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.AbstractC0908h;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.ForwardingTimeline;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceFactory;
import androidx.media3.exoplayer.source.SinglePeriodTimeline;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.IOException;
import javax.net.SocketFactory;
import p020b7.AbstractC1332b;

@UnstableApi
public final class RtspMediaSource extends BaseMediaSource {
    public static final long DEFAULT_TIMEOUT_MS = 8000;
    private final boolean debugLoggingEnabled;
    private MediaItem mediaItem;
    private final RtpDataChannel.Factory rtpDataChannelFactory;
    private final SocketFactory socketFactory;
    private boolean timelineIsLive;
    private boolean timelineIsSeekable;
    private final Uri uri;
    private final String userAgent;
    private long timelineDurationUs = C0565C.TIME_UNSET;
    private boolean timelineIsPlaceholder = true;

    public static final class Factory implements MediaSourceFactory {
        private boolean debugLoggingEnabled;
        private boolean forceUseRtpTcp;
        private long timeoutMs = RtspMediaSource.DEFAULT_TIMEOUT_MS;
        private String userAgent = MediaLibraryInfo.VERSION_SLASHY;
        private SocketFactory socketFactory = SocketFactory.getDefault();

        private boolean shouldForceUseRtpTcp(MediaItem mediaItem) {
            if (this.forceUseRtpTcp) {
                return true;
            }
            String scheme = ((MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration)).uri.getScheme();
            return scheme != null && AbstractC1332b.m3226q("rtspt", scheme);
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
            return new int[]{3};
        }

        @Override
        public final MediaSource.Factory setCmcdConfigurationFactory(CmcdConfiguration.Factory factory) {
            return AbstractC0908h.m2486c(this, factory);
        }

        public Factory setDebugLoggingEnabled(boolean z7) {
            this.debugLoggingEnabled = z7;
            return this;
        }

        @Override
        public Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        public Factory setForceUseRtpTcp(boolean z7) {
            this.forceUseRtpTcp = z7;
            return this;
        }

        @Override
        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }

        public Factory setSocketFactory(SocketFactory socketFactory) {
            this.socketFactory = socketFactory;
            return this;
        }

        @Override
        public final MediaSource.Factory setSubtitleParserFactory(SubtitleParser.Factory factory) {
            return AbstractC0908h.m2487d(this, factory);
        }

        public Factory setTimeoutMs(long j10) {
            Assertions.checkArgument(j10 > 0);
            this.timeoutMs = j10;
            return this;
        }

        public Factory setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        @Override
        public RtspMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.localConfiguration);
            return new RtspMediaSource(mediaItem, shouldForceUseRtpTcp(mediaItem) ? new TransferRtpDataChannelFactory(this.timeoutMs) : new UdpDataSourceRtpDataChannelFactory(this.timeoutMs), this.userAgent, this.socketFactory, this.debugLoggingEnabled);
        }
    }

    public static class RtspPlaybackException extends IOException {
        public RtspPlaybackException(String str) {
            super(str);
        }

        public RtspPlaybackException(Throwable th) {
            super(th);
        }

        public RtspPlaybackException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static final class RtspUdpUnsupportedTransportException extends RtspPlaybackException {
        public RtspUdpUnsupportedTransportException(String str) {
            super(str);
        }
    }

    static {
        MediaLibraryInfo.registerModule("media3.exoplayer.rtsp");
    }

    public RtspMediaSource(MediaItem mediaItem, RtpDataChannel.Factory factory, String str, SocketFactory socketFactory, boolean z7) {
        this.mediaItem = mediaItem;
        this.rtpDataChannelFactory = factory;
        this.userAgent = str;
        this.uri = maybeConvertRtsptUriScheme(((MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration)).uri);
        this.socketFactory = socketFactory;
        this.debugLoggingEnabled = z7;
    }

    private static Uri maybeConvertRtsptUriScheme(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null || !AbstractC1332b.m3226q("rtspt", scheme)) {
            return uri;
        }
        return Uri.parse("rtsp" + uri.toString().substring(5));
    }

    public void notifySourceInfoRefreshed() {
        Timeline singlePeriodTimeline = new SinglePeriodTimeline(this.timelineDurationUs, this.timelineIsSeekable, false, this.timelineIsLive, (Object) null, getMediaItem());
        if (this.timelineIsPlaceholder) {
            singlePeriodTimeline = new ForwardingTimeline(singlePeriodTimeline) {
                @Override
                public Timeline.Period getPeriod(int i6, Timeline.Period period, boolean z7) {
                    super.getPeriod(i6, period, z7);
                    period.isPlaceholder = true;
                    return period;
                }

                @Override
                public Timeline.Window getWindow(int i6, Timeline.Window window, long j10) {
                    super.getWindow(i6, window, j10);
                    window.isPlaceholder = true;
                    return window;
                }
            };
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    @Override
    public boolean canUpdateMediaItem(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = mediaItem.localConfiguration;
        return localConfiguration != null && maybeConvertRtsptUriScheme(localConfiguration.uri).equals(this.uri);
    }

    @Override
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j10) {
        return new RtspMediaPeriod(allocator, this.rtpDataChannelFactory, this.uri, new RtspMediaPeriod.Listener() {
            @Override
            public void onSeekingUnsupported() {
                RtspMediaSource.this.timelineIsSeekable = false;
                RtspMediaSource.this.notifySourceInfoRefreshed();
            }

            @Override
            public void onSourceInfoRefreshed(RtspSessionTiming rtspSessionTiming) {
                RtspMediaSource.this.timelineDurationUs = Util.msToUs(rtspSessionTiming.getDurationMs());
                RtspMediaSource.this.timelineIsSeekable = !rtspSessionTiming.isLive();
                RtspMediaSource.this.timelineIsLive = rtspSessionTiming.isLive();
                RtspMediaSource.this.timelineIsPlaceholder = false;
                RtspMediaSource.this.notifySourceInfoRefreshed();
            }
        }, this.userAgent, this.socketFactory, this.debugLoggingEnabled);
    }

    @Override
    public synchronized MediaItem getMediaItem() {
        return this.mediaItem;
    }

    @Override
    public void prepareSourceInternal(TransferListener transferListener) {
        notifySourceInfoRefreshed();
    }

    @Override
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((RtspMediaPeriod) mediaPeriod).release();
    }

    @Override
    public synchronized void updateMediaItem(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }

    @Override
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override
    public void releaseSourceInternal() {
    }
}
