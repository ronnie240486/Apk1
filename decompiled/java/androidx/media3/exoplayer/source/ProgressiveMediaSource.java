package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Looper;
import androidx.media3.common.C0565C;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.util.ReleasableExecutor;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Objects;
import java.util.concurrent.Executor;
import p020b7.InterfaceC1339e0;

@UnstableApi
public final class ProgressiveMediaSource extends BaseMediaSource implements ProgressiveMediaPeriod.Listener {
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;
    private final int continueLoadingCheckIntervalBytes;
    private final DataSource.Factory dataSourceFactory;
    private final InterfaceC1339e0 downloadExecutorSupplier;
    private final DrmSessionManager drmSessionManager;
    private Listener listener;
    private final LoadErrorHandlingPolicy loadableLoadErrorHandlingPolicy;
    private MediaItem mediaItem;
    private final ProgressiveMediaExtractor.Factory progressiveMediaExtractorFactory;
    private final Format singleTrackFormat;
    private final int singleTrackId;
    private long timelineDurationUs;
    private boolean timelineIsLive;
    private boolean timelineIsPlaceholder;
    private boolean timelineIsSeekable;
    private TransferListener transferListener;

    public static final class Factory implements MediaSourceFactory {
        private int continueLoadingCheckIntervalBytes;
        private final DataSource.Factory dataSourceFactory;
        private InterfaceC1339e0 downloadExecutorSupplier;
        private DrmSessionManagerProvider drmSessionManagerProvider;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private ProgressiveMediaExtractor.Factory progressiveMediaExtractorFactory;
        private Format singleTrackFormat;
        private int singleTrackId;

        public Factory(DataSource.Factory factory) {
            this(factory, new DefaultExtractorsFactory());
        }

        public static ProgressiveMediaExtractor lambda$new$0(ExtractorsFactory extractorsFactory, PlayerId playerId) {
            return new BundledExtractorsAdapter(extractorsFactory);
        }

        public static ReleasableExecutor lambda$setDownloadExecutor$1(InterfaceC1339e0 interfaceC1339e0, Consumer consumer) {
            return ReleasableExecutor.CC.m2603a((Executor) interfaceC1339e0.get(), consumer);
        }

        public Factory enableLazyLoadingWithSingleTrack(int i6, Format format) {
            this.singleTrackId = i6;
            this.singleTrackFormat = (Format) Assertions.checkNotNull(format);
            return this;
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
            return new int[]{4};
        }

        @Override
        public final MediaSource.Factory setCmcdConfigurationFactory(CmcdConfiguration.Factory factory) {
            return AbstractC0908h.m2486c(this, factory);
        }

        public Factory setContinueLoadingCheckIntervalBytes(int i6) {
            this.continueLoadingCheckIntervalBytes = i6;
            return this;
        }

        public <T extends Executor> Factory setDownloadExecutor(InterfaceC1339e0 interfaceC1339e0, Consumer<T> consumer) {
            this.downloadExecutorSupplier = new C0917o(interfaceC1339e0, 0, consumer);
            return this;
        }

        @Override
        public final MediaSource.Factory setSubtitleParserFactory(SubtitleParser.Factory factory) {
            return AbstractC0908h.m2487d(this, factory);
        }

        public Factory(DataSource.Factory factory, final ExtractorsFactory extractorsFactory) {
            this(factory, new ProgressiveMediaExtractor.Factory() {
                @Override
                public final ProgressiveMediaExtractor createProgressiveMediaExtractor(PlayerId playerId) {
                    return ProgressiveMediaSource.Factory.lambda$new$0(extractorsFactory, playerId);
                }
            });
        }

        @Override
        public ProgressiveMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.localConfiguration);
            return new ProgressiveMediaSource(mediaItem, this.dataSourceFactory, this.progressiveMediaExtractorFactory, this.drmSessionManagerProvider.get(mediaItem), this.loadErrorHandlingPolicy, this.continueLoadingCheckIntervalBytes, this.singleTrackId, this.singleTrackFormat, this.downloadExecutorSupplier);
        }

        @Override
        public Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.drmSessionManagerProvider = (DrmSessionManagerProvider) Assertions.checkNotNull(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override
        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.loadErrorHandlingPolicy = (LoadErrorHandlingPolicy) Assertions.checkNotNull(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2) {
            this(factory, factory2, new DefaultDrmSessionManagerProvider(), new DefaultLoadErrorHandlingPolicy(), ProgressiveMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
        }

        public Factory(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManagerProvider drmSessionManagerProvider, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i6) {
            this.dataSourceFactory = factory;
            this.progressiveMediaExtractorFactory = factory2;
            this.drmSessionManagerProvider = drmSessionManagerProvider;
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
            this.continueLoadingCheckIntervalBytes = i6;
        }
    }

    public interface Listener {
        void onSeekMap(MediaSource mediaSource, SeekMap seekMap);
    }

    private MediaItem.LocalConfiguration getLocalConfiguration() {
        return (MediaItem.LocalConfiguration) Assertions.checkNotNull(getMediaItem().localConfiguration);
    }

    private void notifySourceInfoRefreshed() {
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
        MediaItem.LocalConfiguration localConfiguration = getLocalConfiguration();
        MediaItem.LocalConfiguration localConfiguration2 = mediaItem.localConfiguration;
        return localConfiguration2 != null && localConfiguration2.uri.equals(localConfiguration.uri) && localConfiguration2.imageDurationMs == localConfiguration.imageDurationMs && Objects.equals(localConfiguration2.customCacheKey, localConfiguration.customCacheKey);
    }

    public void clearListener() {
        this.listener = null;
    }

    @Override
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j10) {
        DataSource dataSourceCreateDataSource = this.dataSourceFactory.createDataSource();
        TransferListener transferListener = this.transferListener;
        if (transferListener != null) {
            dataSourceCreateDataSource.addTransferListener(transferListener);
        }
        MediaItem.LocalConfiguration localConfiguration = getLocalConfiguration();
        Uri uri = localConfiguration.uri;
        ProgressiveMediaExtractor progressiveMediaExtractorCreateProgressiveMediaExtractor = this.progressiveMediaExtractorFactory.createProgressiveMediaExtractor(getPlayerId());
        DrmSessionManager drmSessionManager = this.drmSessionManager;
        DrmSessionEventListener.EventDispatcher eventDispatcherCreateDrmEventDispatcher = createDrmEventDispatcher(mediaPeriodId);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadableLoadErrorHandlingPolicy;
        MediaSourceEventListener.EventDispatcher eventDispatcherCreateEventDispatcher = createEventDispatcher(mediaPeriodId);
        String str = localConfiguration.customCacheKey;
        int i6 = this.continueLoadingCheckIntervalBytes;
        int i10 = this.singleTrackId;
        Format format = this.singleTrackFormat;
        long jMsToUs = Util.msToUs(localConfiguration.imageDurationMs);
        InterfaceC1339e0 interfaceC1339e0 = this.downloadExecutorSupplier;
        return new ProgressiveMediaPeriod(uri, dataSourceCreateDataSource, progressiveMediaExtractorCreateProgressiveMediaExtractor, drmSessionManager, eventDispatcherCreateDrmEventDispatcher, loadErrorHandlingPolicy, eventDispatcherCreateEventDispatcher, this, allocator, str, i6, i10, format, jMsToUs, interfaceC1339e0 != null ? (ReleasableExecutor) interfaceC1339e0.get() : null);
    }

    @Override
    public synchronized MediaItem getMediaItem() {
        return this.mediaItem;
    }

    @Override
    public void onSourceInfoRefreshed(long j10, SeekMap seekMap, boolean z7) {
        if (j10 == C0565C.TIME_UNSET) {
            j10 = this.timelineDurationUs;
        }
        boolean zIsSeekable = seekMap.isSeekable();
        if (!this.timelineIsPlaceholder && this.timelineDurationUs == j10 && this.timelineIsSeekable == zIsSeekable && this.timelineIsLive == z7) {
            return;
        }
        this.timelineDurationUs = j10;
        this.timelineIsSeekable = zIsSeekable;
        this.timelineIsLive = z7;
        this.timelineIsPlaceholder = false;
        notifySourceInfoRefreshed();
        Listener listener = this.listener;
        if (listener != null) {
            listener.onSeekMap(this, seekMap);
        }
    }

    @Override
    public void prepareSourceInternal(TransferListener transferListener) {
        this.transferListener = transferListener;
        this.drmSessionManager.setPlayer((Looper) Assertions.checkNotNull(Looper.myLooper()), getPlayerId());
        this.drmSessionManager.prepare();
        notifySourceInfoRefreshed();
    }

    @Override
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((ProgressiveMediaPeriod) mediaPeriod).release();
    }

    @Override
    public void releaseSourceInternal() {
        this.drmSessionManager.release();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public synchronized void updateMediaItem(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }

    private ProgressiveMediaSource(MediaItem mediaItem, DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i6, int i10, Format format, InterfaceC1339e0 interfaceC1339e0) {
        this.mediaItem = mediaItem;
        this.dataSourceFactory = factory;
        this.progressiveMediaExtractorFactory = factory2;
        this.drmSessionManager = drmSessionManager;
        this.loadableLoadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.continueLoadingCheckIntervalBytes = i6;
        this.singleTrackFormat = format;
        this.singleTrackId = i10;
        this.timelineIsPlaceholder = true;
        this.timelineDurationUs = C0565C.TIME_UNSET;
        this.downloadExecutorSupplier = interfaceC1339e0;
    }

    @Override
    public void maybeThrowSourceInfoRefreshError() {
    }
}
