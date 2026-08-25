package androidx.media3.exoplayer.source.preload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.C0565C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.C0932t;
import androidx.media3.exoplayer.DefaultRendererCapabilitiesList;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.LoadControl;
import androidx.media3.exoplayer.PlaybackLooperProvider;
import androidx.media3.exoplayer.RendererCapabilitiesList;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Comparator;
import p000a.RunnableC0001b;
import p020b7.AbstractC1332b;
import p020b7.InterfaceC1339e0;
import p020b7.InterfaceC1354n;

@UnstableApi
public final class DefaultPreloadManager extends BasePreloadManager<Integer> {
    private final boolean deprecatedConstructorCalled;
    private final Handler preloadHandler;
    private final PlaybackLooperProvider preloadLooperProvider;
    private final PreloadMediaSource.Factory preloadMediaSourceFactory;
    private final RendererCapabilitiesList rendererCapabilitiesList;
    private final TrackSelector trackSelector;

    public static final class Builder extends BasePreloadManager.BuilderBase<Integer> {
        private InterfaceC1339e0 bandwidthMeterSupplier;
        private boolean buildCalled;
        private boolean buildExoPlayerCalled;
        private final Context context;
        private InterfaceC1339e0 loadControlSupplier;
        private PlaybackLooperProvider preloadLooperProvider;
        private InterfaceC1339e0 renderersFactorySupplier;
        private TrackSelector.Factory trackSelectorFactory;

        public Builder(final Context context, TargetPreloadStatusControl<Integer> targetPreloadStatusControl) {
            final int i6 = 0;
            super(new RankingDataComparator(), targetPreloadStatusControl, AbstractC1332b.m3229t(new InterfaceC1339e0() {
                @Override
                public final Object get() {
                    switch (i6) {
                        case 0:
                            return DefaultPreloadManager.Builder.lambda$new$0(context);
                        case 1:
                            return DefaultBandwidthMeter.getSingletonInstance(context);
                        default:
                            return DefaultPreloadManager.Builder.lambda$new$2(context);
                    }
                }
            }));
            this.context = context;
            this.preloadLooperProvider = new PlaybackLooperProvider();
            this.trackSelectorFactory = new C0923b();
            final int i10 = 1;
            this.bandwidthMeterSupplier = new InterfaceC1339e0() {
                @Override
                public final Object get() {
                    switch (i10) {
                        case 0:
                            return DefaultPreloadManager.Builder.lambda$new$0(context);
                        case 1:
                            return DefaultBandwidthMeter.getSingletonInstance(context);
                        default:
                            return DefaultPreloadManager.Builder.lambda$new$2(context);
                    }
                }
            };
            final int i11 = 2;
            this.renderersFactorySupplier = AbstractC1332b.m3229t(new InterfaceC1339e0() {
                @Override
                public final Object get() {
                    switch (i11) {
                        case 0:
                            return DefaultPreloadManager.Builder.lambda$new$0(context);
                        case 1:
                            return DefaultBandwidthMeter.getSingletonInstance(context);
                        default:
                            return DefaultPreloadManager.Builder.lambda$new$2(context);
                    }
                }
            });
            this.loadControlSupplier = AbstractC1332b.m3229t(new C0932t());
        }

        public static MediaSource.Factory lambda$new$0(Context context) {
            return new DefaultMediaSourceFactory(context);
        }

        public static RenderersFactory lambda$new$2(Context context) {
            return new DefaultRenderersFactory(context);
        }

        public ExoPlayer buildExoPlayer() {
            return buildExoPlayer(new ExoPlayer.Builder(this.context));
        }

        public Builder setBandwidthMeter(BandwidthMeter bandwidthMeter) {
            Assertions.checkState((this.buildCalled || this.buildExoPlayerCalled) ? false : true);
            this.bandwidthMeterSupplier = new C0924c(2, bandwidthMeter);
            return this;
        }

        public Builder setLoadControl(LoadControl loadControl) {
            Assertions.checkState((this.buildCalled || this.buildExoPlayerCalled) ? false : true);
            this.loadControlSupplier = new C0924c(0, loadControl);
            return this;
        }

        public Builder setMediaSourceFactory(MediaSource.Factory factory) {
            Assertions.checkState((this.buildCalled || this.buildExoPlayerCalled) ? false : true);
            this.mediaSourceFactorySupplier = new C0924c(3, factory);
            return this;
        }

        public Builder setPreloadLooper(Looper looper) {
            Assertions.checkState((this.buildCalled || this.buildExoPlayerCalled) ? false : true);
            this.preloadLooperProvider = new PlaybackLooperProvider(looper);
            return this;
        }

        public Builder setRenderersFactory(RenderersFactory renderersFactory) {
            Assertions.checkState((this.buildCalled || this.buildExoPlayerCalled) ? false : true);
            this.renderersFactorySupplier = new C0924c(1, renderersFactory);
            return this;
        }

        public Builder setTrackSelectorFactory(TrackSelector.Factory factory) {
            Assertions.checkState((this.buildCalled || this.buildExoPlayerCalled) ? false : true);
            this.trackSelectorFactory = factory;
            return this;
        }

        @Override
        public BasePreloadManager<Integer> build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new DefaultPreloadManager(this);
        }

        public ExoPlayer buildExoPlayer(ExoPlayer.Builder builder) {
            this.buildExoPlayerCalled = true;
            return builder.setMediaSourceFactory((MediaSource.Factory) this.mediaSourceFactorySupplier.get()).setBandwidthMeter((BandwidthMeter) this.bandwidthMeterSupplier.get()).setRenderersFactory((RenderersFactory) this.renderersFactorySupplier.get()).setLoadControl((LoadControl) this.loadControlSupplier.get()).setPlaybackLooperProvider(this.preloadLooperProvider).setTrackSelector(this.trackSelectorFactory.createTrackSelector(this.context)).build();
        }

        public static BandwidthMeter lambda$setBandwidthMeter$6(BandwidthMeter bandwidthMeter) {
            return bandwidthMeter;
        }

        public static LoadControl lambda$setLoadControl$5(LoadControl loadControl) {
            return loadControl;
        }

        public static MediaSource.Factory lambda$setMediaSourceFactory$3(MediaSource.Factory factory) {
            return factory;
        }

        public static RenderersFactory lambda$setRenderersFactory$4(RenderersFactory renderersFactory) {
            return renderersFactory;
        }
    }

    public static final class RankingDataComparator implements Comparator<Integer> {
        public int currentPlayingIndex = -1;

        @Override
        public int compare(Integer num, Integer num2) {
            return Integer.compare(Math.abs(num.intValue() - this.currentPlayingIndex), Math.abs(num2.intValue() - this.currentPlayingIndex));
        }
    }

    public final class SourcePreloadControl implements PreloadMediaSource.PreloadControl {
        private SourcePreloadControl() {
        }

        private boolean continueOrCompletePreloading(PreloadMediaSource preloadMediaSource, InterfaceC1354n interfaceC1354n, boolean z7) {
            TargetPreloadStatusControl.PreloadStatus targetPreloadStatus = DefaultPreloadManager.this.getTargetPreloadStatus(preloadMediaSource);
            if (targetPreloadStatus == null) {
                DefaultPreloadManager.this.onPreloadSkipped(preloadMediaSource);
                return false;
            }
            if (interfaceC1354n.apply((Status) Assertions.checkNotNull((Status) targetPreloadStatus))) {
                return true;
            }
            if (z7) {
                DefaultPreloadManager.this.clearSourceInternal(preloadMediaSource);
            }
            DefaultPreloadManager.this.onPreloadCompleted(preloadMediaSource);
            return false;
        }

        public static boolean lambda$onContinueLoadingRequested$2(long j10, Status status) {
            return status.getStage() == 2 && status.getValue() > Util.usToMs(j10);
        }

        public static boolean lambda$onSourcePrepared$0(Status status) {
            return status.getStage() > 0;
        }

        public static boolean lambda$onTracksSelected$1(Status status) {
            return status.getStage() > 1;
        }

        @Override
        public boolean onContinueLoadingRequested(PreloadMediaSource preloadMediaSource, final long j10) {
            return continueOrCompletePreloading(preloadMediaSource, new InterfaceC1354n() {
                @Override
                public final boolean apply(Object obj) {
                    return DefaultPreloadManager.SourcePreloadControl.lambda$onContinueLoadingRequested$2(j10, (DefaultPreloadManager.Status) obj);
                }
            }, false);
        }

        @Override
        public void onLoadedToTheEndOfSource(PreloadMediaSource preloadMediaSource) {
            DefaultPreloadManager.this.onPreloadCompleted(preloadMediaSource);
        }

        @Override
        public void onPreloadError(PreloadException preloadException, PreloadMediaSource preloadMediaSource) {
            DefaultPreloadManager.this.onPreloadError(preloadException, preloadMediaSource);
        }

        @Override
        public boolean onSourcePrepared(PreloadMediaSource preloadMediaSource) {
            return continueOrCompletePreloading(preloadMediaSource, new C0926e(1), true);
        }

        @Override
        public boolean onTracksSelected(PreloadMediaSource preloadMediaSource) {
            return continueOrCompletePreloading(preloadMediaSource, new C0926e(0), false);
        }

        @Override
        public void onUsedByPlayer(PreloadMediaSource preloadMediaSource) {
            DefaultPreloadManager.this.onPreloadSkipped(preloadMediaSource);
        }
    }

    public void lambda$releaseInternal$1() {
        this.rendererCapabilitiesList.release();
        if (!this.deprecatedConstructorCalled) {
            this.trackSelector.release();
        }
        this.preloadLooperProvider.releaseLooper();
    }

    @Override
    public void clearSourceInternal(MediaSource mediaSource) {
        Assertions.checkArgument(mediaSource instanceof PreloadMediaSource);
        ((PreloadMediaSource) mediaSource).clear();
    }

    @Override
    public MediaSource createMediaSourceForPreloading(MediaSource mediaSource) {
        return this.preloadMediaSourceFactory.createMediaSource(mediaSource);
    }

    @Override
    public void preloadSourceInternal(MediaSource mediaSource, long j10) {
        Assertions.checkArgument(mediaSource instanceof PreloadMediaSource);
        ((PreloadMediaSource) mediaSource).preload(j10);
    }

    @Override
    public void releaseInternal() {
        this.preloadHandler.post(new RunnableC0001b(7, this));
    }

    @Override
    public void releaseSourceInternal(MediaSource mediaSource) {
        Assertions.checkArgument(mediaSource instanceof PreloadMediaSource);
        ((PreloadMediaSource) mediaSource).releasePreloadMediaSource();
    }

    public void setCurrentPlayingIndex(int i6) {
        ((RankingDataComparator) this.rankingDataComparator).currentPlayingIndex = i6;
    }

    private DefaultPreloadManager(Builder builder) {
        super(new RankingDataComparator(), builder.targetPreloadStatusControl, (MediaSource.Factory) builder.mediaSourceFactorySupplier.get());
        DefaultRendererCapabilitiesList defaultRendererCapabilitiesListCreateRendererCapabilitiesList = new DefaultRendererCapabilitiesList.Factory((RenderersFactory) builder.renderersFactorySupplier.get()).createRendererCapabilitiesList();
        this.rendererCapabilitiesList = defaultRendererCapabilitiesListCreateRendererCapabilitiesList;
        PlaybackLooperProvider playbackLooperProvider = builder.preloadLooperProvider;
        this.preloadLooperProvider = playbackLooperProvider;
        TrackSelector trackSelectorCreateTrackSelector = builder.trackSelectorFactory.createTrackSelector(builder.context);
        this.trackSelector = trackSelectorCreateTrackSelector;
        BandwidthMeter bandwidthMeter = (BandwidthMeter) builder.bandwidthMeterSupplier.get();
        trackSelectorCreateTrackSelector.init(new C0923b(), bandwidthMeter);
        Looper looperObtainLooper = playbackLooperProvider.obtainLooper();
        this.preloadMediaSourceFactory = new PreloadMediaSource.Factory((MediaSource.Factory) builder.mediaSourceFactorySupplier.get(), new SourcePreloadControl(), trackSelectorCreateTrackSelector, bandwidthMeter, defaultRendererCapabilitiesListCreateRendererCapabilitiesList.getRendererCapabilities(), ((LoadControl) builder.loadControlSupplier.get()).getAllocator(), looperObtainLooper);
        this.preloadHandler = Util.createHandler(looperObtainLooper, null);
        this.deprecatedConstructorCalled = false;
    }

    public static class Status implements TargetPreloadStatusControl.PreloadStatus {
        public static final int STAGE_LOADED_FOR_DURATION_MS = 2;
        public static final int STAGE_SOURCE_PREPARED = 0;
        public static final int STAGE_TRACKS_SELECTED = 1;
        private final int stage;
        private final long value;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Stage {
        }

        public Status(int i6, long j10) {
            this.stage = i6;
            this.value = j10;
        }

        @Override
        public int getStage() {
            return this.stage;
        }

        @Override
        public long getValue() {
            return this.value;
        }

        public Status(int i6) {
            this(i6, C0565C.TIME_UNSET);
        }
    }

    @Deprecated
    public DefaultPreloadManager(TargetPreloadStatusControl<Integer> targetPreloadStatusControl, MediaSource.Factory factory, TrackSelector trackSelector, BandwidthMeter bandwidthMeter, RendererCapabilitiesList.Factory factory2, Allocator allocator, Looper looper) {
        super(new RankingDataComparator(), targetPreloadStatusControl, factory);
        RendererCapabilitiesList rendererCapabilitiesListCreateRendererCapabilitiesList = factory2.createRendererCapabilitiesList();
        this.rendererCapabilitiesList = rendererCapabilitiesListCreateRendererCapabilitiesList;
        PlaybackLooperProvider playbackLooperProvider = new PlaybackLooperProvider(looper);
        this.preloadLooperProvider = playbackLooperProvider;
        this.trackSelector = trackSelector;
        Looper looperObtainLooper = playbackLooperProvider.obtainLooper();
        this.preloadMediaSourceFactory = new PreloadMediaSource.Factory(factory, new SourcePreloadControl(), trackSelector, bandwidthMeter, rendererCapabilitiesListCreateRendererCapabilitiesList.getRendererCapabilities(), allocator, looperObtainLooper);
        this.preloadHandler = Util.createHandler(looperObtainLooper, null);
        this.deprecatedConstructorCalled = true;
    }

    public static void lambda$new$0() {
    }
}
