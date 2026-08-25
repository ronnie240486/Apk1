package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.util.ReleasableExecutor;
import java.util.concurrent.Executor;
import p020b7.AbstractC1332b;
import p020b7.InterfaceC1339e0;
import p041d7.AbstractC2301u1;

@UnstableApi
@Deprecated
public final class SingleSampleMediaSource extends BaseMediaSource {
    private final DataSource.Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final InterfaceC1339e0 downloadExecutorSupplier;
    private final long durationUs;
    private final Format format;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final MediaItem mediaItem;
    private final Timeline timeline;
    private TransferListener transferListener;
    private final boolean treatLoadErrorsAsEndOfStream;

    public static final class Factory {
        private final DataSource.Factory dataSourceFactory;
        private InterfaceC1339e0 downloadExecutorSupplier;
        private Object tag;
        private String trackId;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        private boolean treatLoadErrorsAsEndOfStream = true;

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = (DataSource.Factory) Assertions.checkNotNull(factory);
        }

        public static ReleasableExecutor lambda$setDownloadExecutor$0(InterfaceC1339e0 interfaceC1339e0, Consumer consumer) {
            return ReleasableExecutor.CC.m2603a((Executor) interfaceC1339e0.get(), consumer);
        }

        public SingleSampleMediaSource createMediaSource(MediaItem.SubtitleConfiguration subtitleConfiguration, long j10) {
            return new SingleSampleMediaSource(this.trackId, subtitleConfiguration, this.dataSourceFactory, j10, this.loadErrorHandlingPolicy, this.treatLoadErrorsAsEndOfStream, this.tag, this.downloadExecutorSupplier);
        }

        public <T extends Executor> Factory setDownloadExecutor(InterfaceC1339e0 interfaceC1339e0, Consumer<T> consumer) {
            this.downloadExecutorSupplier = new C0917o(interfaceC1339e0, 1, consumer);
            return this;
        }

        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            }
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
            return this;
        }

        public Factory setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        @Deprecated
        public Factory setTrackId(String str) {
            this.trackId = str;
            return this;
        }

        public Factory setTreatLoadErrorsAsEndOfStream(boolean z7) {
            this.treatLoadErrorsAsEndOfStream = z7;
            return this;
        }
    }

    @Override
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j10) {
        DataSpec dataSpec = this.dataSpec;
        DataSource.Factory factory = this.dataSourceFactory;
        TransferListener transferListener = this.transferListener;
        Format format = this.format;
        long j11 = this.durationUs;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        MediaSourceEventListener.EventDispatcher eventDispatcherCreateEventDispatcher = createEventDispatcher(mediaPeriodId);
        boolean z7 = this.treatLoadErrorsAsEndOfStream;
        InterfaceC1339e0 interfaceC1339e0 = this.downloadExecutorSupplier;
        return new SingleSampleMediaPeriod(dataSpec, factory, transferListener, format, j11, loadErrorHandlingPolicy, eventDispatcherCreateEventDispatcher, z7, interfaceC1339e0 != null ? (ReleasableExecutor) interfaceC1339e0.get() : null);
    }

    @Override
    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    @Override
    public void prepareSourceInternal(TransferListener transferListener) {
        this.transferListener = transferListener;
        refreshSourceInfo(this.timeline);
    }

    @Override
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((SingleSampleMediaPeriod) mediaPeriod).release();
    }

    private SingleSampleMediaSource(String str, MediaItem.SubtitleConfiguration subtitleConfiguration, DataSource.Factory factory, long j10, LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean z7, Object obj, InterfaceC1339e0 interfaceC1339e0) {
        this.dataSourceFactory = factory;
        this.durationUs = j10;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.treatLoadErrorsAsEndOfStream = z7;
        MediaItem mediaItemBuild = new MediaItem.Builder().setUri(Uri.EMPTY).setMediaId(subtitleConfiguration.uri.toString()).setSubtitleConfigurations(AbstractC2301u1.m5275r(subtitleConfiguration)).setTag(obj).build();
        this.mediaItem = mediaItemBuild;
        Format.Builder label = new Format.Builder().setSampleMimeType((String) AbstractC1332b.m3227r(subtitleConfiguration.mimeType, MimeTypes.TEXT_UNKNOWN)).setLanguage(subtitleConfiguration.language).setSelectionFlags(subtitleConfiguration.selectionFlags).setRoleFlags(subtitleConfiguration.roleFlags).setLabel(subtitleConfiguration.label);
        String str2 = subtitleConfiguration.f2581id;
        this.format = label.setId(str2 == null ? str : str2).build();
        this.dataSpec = new DataSpec.Builder().setUri(subtitleConfiguration.uri).setFlags(1).build();
        this.timeline = new SinglePeriodTimeline(j10, true, false, false, (Object) null, mediaItemBuild);
        this.downloadExecutorSupplier = interfaceC1339e0;
    }

    @Override
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override
    public void releaseSourceInternal() {
    }
}
