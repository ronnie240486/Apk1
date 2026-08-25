package androidx.media3.exoplayer.source;

import android.content.Context;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.C0565C;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.rtsp.RtspMediaSource;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.AbstractC1009b;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleExtractor;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p000a.AbstractC0004e;
import p020b7.InterfaceC1339e0;
import p041d7.AbstractC2301u1;
import p187r4.AbstractC3612b;

public final class DefaultMediaSourceFactory implements MediaSourceFactory {
    private static final String TAG = "DMediaSourceFactory";
    private AdViewProvider adViewProvider;
    private AdsLoader.Provider adsLoaderProvider;
    private DataSource.Factory dataSourceFactory;
    private final DelegateFactoryLoader delegateFactoryLoader;
    private ExternalLoader externalImageLoader;
    private long liveMaxOffsetMs;
    private float liveMaxSpeed;
    private long liveMinOffsetMs;
    private float liveMinSpeed;
    private long liveTargetOffsetMs;
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private boolean parseSubtitlesDuringExtraction;
    private MediaSource.Factory serverSideAdInsertionMediaSourceFactory;
    private SubtitleParser.Factory subtitleParserFactory;

    @UnstableApi
    @Deprecated
    public interface AdsLoaderProvider extends AdsLoader.Provider {
    }

    public static final class DelegateFactoryLoader {
        private CmcdConfiguration.Factory cmcdConfigurationFactory;
        private int codecsToParseWithinGopSampleDependencies;
        private DataSource.Factory dataSourceFactory;
        private DrmSessionManagerProvider drmSessionManagerProvider;
        private final ExtractorsFactory extractorsFactory;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private SubtitleParser.Factory subtitleParserFactory;
        private final Map<Integer, InterfaceC1339e0> mediaSourceFactorySuppliers = new HashMap();
        private final Map<Integer, MediaSource.Factory> mediaSourceFactories = new HashMap();
        private boolean parseSubtitlesDuringExtraction = true;

        public DelegateFactoryLoader(ExtractorsFactory extractorsFactory, SubtitleParser.Factory factory) {
            this.extractorsFactory = extractorsFactory;
            this.subtitleParserFactory = factory;
        }

        private void ensureAllSuppliersAreLoaded() {
            maybeLoadSupplier(0);
            maybeLoadSupplier(1);
            maybeLoadSupplier(2);
            maybeLoadSupplier(3);
            maybeLoadSupplier(4);
        }

        public MediaSource.Factory lambda$loadSupplier$4(DataSource.Factory factory) {
            return new ProgressiveMediaSource.Factory(factory, this.extractorsFactory);
        }

        private InterfaceC1339e0 loadSupplier(int i6) throws ClassNotFoundException {
            InterfaceC1339e0 interfaceC1339e0;
            InterfaceC1339e0 c0917o;
            InterfaceC1339e0 interfaceC1339e1;
            final int i10 = 1;
            final int i11 = 2;
            InterfaceC1339e0 interfaceC1339e2 = this.mediaSourceFactorySuppliers.get(Integer.valueOf(i6));
            if (interfaceC1339e2 != null) {
                return interfaceC1339e2;
            }
            final DataSource.Factory factory = (DataSource.Factory) Assertions.checkNotNull(this.dataSourceFactory);
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2) {
                        final Class clsAsSubclass = HlsMediaSource.Factory.class.asSubclass(MediaSource.Factory.class);
                        interfaceC1339e1 = new InterfaceC1339e0() {
                            @Override
                            public final Object get() {
                                switch (i11) {
                                    case 0:
                                        break;
                                    case 1:
                                        break;
                                }
                                return DefaultMediaSourceFactory.access$100(clsAsSubclass, factory);
                            }
                        };
                    } else if (i6 == 3) {
                        final Class clsAsSubclass2 = RtspMediaSource.Factory.class.asSubclass(MediaSource.Factory.class);
                        interfaceC1339e0 = new InterfaceC1339e0() {
                            @Override
                            public final Object get() {
                                return DefaultMediaSourceFactory.access$000(clsAsSubclass2);
                            }
                        };
                    } else {
                        if (i6 != 4) {
                            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Unrecognized contentType: "));
                        }
                        c0917o = new C0917o(this, i11, factory);
                    }
                    this.mediaSourceFactorySuppliers.put(Integer.valueOf(i6), c0917o);
                    return c0917o;
                }
                final Class clsAsSubclass3 = SsMediaSource.Factory.class.asSubclass(MediaSource.Factory.class);
                interfaceC1339e1 = new InterfaceC1339e0() {
                    @Override
                    public final Object get() {
                        switch (i10) {
                            case 0:
                                break;
                            case 1:
                                break;
                        }
                        return DefaultMediaSourceFactory.access$100(clsAsSubclass3, factory);
                    }
                };
                c0917o = interfaceC1339e1;
                this.mediaSourceFactorySuppliers.put(Integer.valueOf(i6), c0917o);
                return c0917o;
            }
            final Class<? extends U> clsAsSubclass4 = Class.forName("androidx.media3.exoplayer.dash.DashMediaSource$Factory").asSubclass(MediaSource.Factory.class);
            final int i12 = 0;
            interfaceC1339e0 = new InterfaceC1339e0() {
                @Override
                public final Object get() {
                    switch (i12) {
                        case 0:
                            break;
                        case 1:
                            break;
                    }
                    return DefaultMediaSourceFactory.access$100(clsAsSubclass4, factory);
                }
            };
            c0917o = interfaceC1339e0;
            this.mediaSourceFactorySuppliers.put(Integer.valueOf(i6), c0917o);
            return c0917o;
        }

        private InterfaceC1339e0 maybeLoadSupplier(int i6) {
            try {
                return loadSupplier(i6);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }

        public MediaSource.Factory getMediaSourceFactory(int i6) throws ClassNotFoundException {
            MediaSource.Factory factory = this.mediaSourceFactories.get(Integer.valueOf(i6));
            if (factory != null) {
                return factory;
            }
            MediaSource.Factory factory2 = (MediaSource.Factory) loadSupplier(i6).get();
            CmcdConfiguration.Factory factory3 = this.cmcdConfigurationFactory;
            if (factory3 != null) {
                factory2.setCmcdConfigurationFactory(factory3);
            }
            DrmSessionManagerProvider drmSessionManagerProvider = this.drmSessionManagerProvider;
            if (drmSessionManagerProvider != null) {
                factory2.setDrmSessionManagerProvider(drmSessionManagerProvider);
            }
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
            if (loadErrorHandlingPolicy != null) {
                factory2.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy);
            }
            factory2.setSubtitleParserFactory(this.subtitleParserFactory);
            factory2.experimentalParseSubtitlesDuringExtraction(this.parseSubtitlesDuringExtraction);
            factory2.experimentalSetCodecsToParseWithinGopSampleDependencies(this.codecsToParseWithinGopSampleDependencies);
            this.mediaSourceFactories.put(Integer.valueOf(i6), factory2);
            return factory2;
        }

        public int[] getSupportedTypes() {
            ensureAllSuppliersAreLoaded();
            return AbstractC3612b.m7258N(this.mediaSourceFactorySuppliers.keySet());
        }

        public void setCmcdConfigurationFactory(CmcdConfiguration.Factory factory) {
            this.cmcdConfigurationFactory = factory;
            Iterator<MediaSource.Factory> it = this.mediaSourceFactories.values().iterator();
            while (it.hasNext()) {
                it.next().setCmcdConfigurationFactory(factory);
            }
        }

        public void setCodecsToParseWithinGopSampleDependencies(int i6) {
            this.codecsToParseWithinGopSampleDependencies = i6;
            this.extractorsFactory.experimentalSetCodecsToParseWithinGopSampleDependencies(i6);
        }

        public void setDataSourceFactory(DataSource.Factory factory) {
            if (factory != this.dataSourceFactory) {
                this.dataSourceFactory = factory;
                this.mediaSourceFactorySuppliers.clear();
                this.mediaSourceFactories.clear();
            }
        }

        public void setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.drmSessionManagerProvider = drmSessionManagerProvider;
            Iterator<MediaSource.Factory> it = this.mediaSourceFactories.values().iterator();
            while (it.hasNext()) {
                it.next().setDrmSessionManagerProvider(drmSessionManagerProvider);
            }
        }

        public void setJpegExtractorFlags(int i6) {
            ExtractorsFactory extractorsFactory = this.extractorsFactory;
            if (extractorsFactory instanceof DefaultExtractorsFactory) {
                ((DefaultExtractorsFactory) extractorsFactory).setJpegExtractorFlags(i6);
            }
        }

        public void setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
            Iterator<MediaSource.Factory> it = this.mediaSourceFactories.values().iterator();
            while (it.hasNext()) {
                it.next().setLoadErrorHandlingPolicy(loadErrorHandlingPolicy);
            }
        }

        public void setParseSubtitlesDuringExtraction(boolean z7) {
            this.parseSubtitlesDuringExtraction = z7;
            this.extractorsFactory.experimentalSetTextTrackTranscodingEnabled(z7);
            Iterator<MediaSource.Factory> it = this.mediaSourceFactories.values().iterator();
            while (it.hasNext()) {
                it.next().experimentalParseSubtitlesDuringExtraction(z7);
            }
        }

        public void setSubtitleParserFactory(SubtitleParser.Factory factory) {
            this.subtitleParserFactory = factory;
            this.extractorsFactory.setSubtitleParserFactory(factory);
            Iterator<MediaSource.Factory> it = this.mediaSourceFactories.values().iterator();
            while (it.hasNext()) {
                it.next().setSubtitleParserFactory(factory);
            }
        }
    }

    public DefaultMediaSourceFactory(Context context) {
        this(new DefaultDataSource.Factory(context));
    }

    public static MediaSource.Factory access$000(Class cls) {
        return newInstance(cls);
    }

    public static MediaSource.Factory access$100(Class cls, DataSource.Factory factory) {
        return newInstance(cls, factory);
    }

    public Extractor[] lambda$createMediaSource$0(Format format) {
        return new Extractor[]{this.subtitleParserFactory.supportsFormat(format) ? new SubtitleExtractor(this.subtitleParserFactory.create(format), null) : new UnknownSubtitlesExtractor(format)};
    }

    private static MediaSource maybeClipMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        MediaItem.ClippingConfiguration clippingConfiguration = mediaItem.clippingConfiguration;
        return (clippingConfiguration.startPositionUs == 0 && clippingConfiguration.endPositionUs == Long.MIN_VALUE && !clippingConfiguration.relativeToDefaultPosition) ? mediaSource : new ClippingMediaSource.Builder(mediaSource).setStartPositionUs(mediaItem.clippingConfiguration.startPositionUs).setEndPositionUs(mediaItem.clippingConfiguration.endPositionUs).setEnableInitialDiscontinuity(!mediaItem.clippingConfiguration.startsAtKeyFrame).setAllowDynamicClippingUpdates(mediaItem.clippingConfiguration.relativeToLiveWindow).setRelativeToDefaultPosition(mediaItem.clippingConfiguration.relativeToDefaultPosition).build();
    }

    private MediaSource maybeWrapWithAdsMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        Assertions.checkNotNull(mediaItem.localConfiguration);
        MediaItem.AdsConfiguration adsConfiguration = mediaItem.localConfiguration.adsConfiguration;
        if (adsConfiguration == null) {
            return mediaSource;
        }
        AdsLoader.Provider provider = this.adsLoaderProvider;
        AdViewProvider adViewProvider = this.adViewProvider;
        if (provider == null || adViewProvider == null) {
            Log.m1719w(TAG, "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return mediaSource;
        }
        AdsLoader adsLoader = provider.getAdsLoader(adsConfiguration);
        if (adsLoader == null) {
            Log.m1719w(TAG, "Playing media without ads, as no AdsLoader was provided.");
            return mediaSource;
        }
        DataSpec dataSpec = new DataSpec(adsConfiguration.adTagUri);
        Object obj = adsConfiguration.adsId;
        return new AdsMediaSource(mediaSource, dataSpec, obj != null ? obj : AbstractC2301u1.m5277t(mediaItem.mediaId, mediaItem.localConfiguration.uri, adsConfiguration.adTagUri), this, adsLoader, adViewProvider, true);
    }

    public static MediaSource.Factory newInstance(Class<? extends MediaSource.Factory> cls, DataSource.Factory factory) {
        try {
            return cls.getConstructor(DataSource.Factory.class).newInstance(factory);
        } catch (Exception e5) {
            throw new IllegalStateException(e5);
        }
    }

    public DefaultMediaSourceFactory clearLocalAdInsertionComponents() {
        this.adsLoaderProvider = null;
        this.adViewProvider = null;
        return this;
    }

    @Override
    @UnstableApi
    public MediaSource createMediaSource(MediaItem mediaItem) {
        Assertions.checkNotNull(mediaItem.localConfiguration);
        String scheme = mediaItem.localConfiguration.uri.getScheme();
        if (scheme != null && scheme.equals(C0565C.SSAI_SCHEME)) {
            return ((MediaSource.Factory) Assertions.checkNotNull(this.serverSideAdInsertionMediaSourceFactory)).createMediaSource(mediaItem);
        }
        if (Objects.equals(mediaItem.localConfiguration.mimeType, MimeTypes.APPLICATION_EXTERNALLY_LOADED_IMAGE)) {
            return new ExternallyLoadedMediaSource.Factory(Util.msToUs(mediaItem.localConfiguration.imageDurationMs), (ExternalLoader) Assertions.checkNotNull(this.externalImageLoader)).createMediaSource(mediaItem);
        }
        MediaItem.LocalConfiguration localConfiguration = mediaItem.localConfiguration;
        int iInferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(localConfiguration.uri, localConfiguration.mimeType);
        if (mediaItem.localConfiguration.imageDurationMs != C0565C.TIME_UNSET) {
            this.delegateFactoryLoader.setJpegExtractorFlags(1);
        }
        try {
            MediaSource.Factory mediaSourceFactory = this.delegateFactoryLoader.getMediaSourceFactory(iInferContentTypeForUriAndMimeType);
            MediaItem.LiveConfiguration.Builder builderBuildUpon = mediaItem.liveConfiguration.buildUpon();
            if (mediaItem.liveConfiguration.targetOffsetMs == C0565C.TIME_UNSET) {
                builderBuildUpon.setTargetOffsetMs(this.liveTargetOffsetMs);
            }
            if (mediaItem.liveConfiguration.minPlaybackSpeed == -3.4028235E38f) {
                builderBuildUpon.setMinPlaybackSpeed(this.liveMinSpeed);
            }
            if (mediaItem.liveConfiguration.maxPlaybackSpeed == -3.4028235E38f) {
                builderBuildUpon.setMaxPlaybackSpeed(this.liveMaxSpeed);
            }
            if (mediaItem.liveConfiguration.minOffsetMs == C0565C.TIME_UNSET) {
                builderBuildUpon.setMinOffsetMs(this.liveMinOffsetMs);
            }
            if (mediaItem.liveConfiguration.maxOffsetMs == C0565C.TIME_UNSET) {
                builderBuildUpon.setMaxOffsetMs(this.liveMaxOffsetMs);
            }
            MediaItem.LiveConfiguration liveConfigurationBuild = builderBuildUpon.build();
            if (!liveConfigurationBuild.equals(mediaItem.liveConfiguration)) {
                mediaItem = mediaItem.buildUpon().setLiveConfiguration(liveConfigurationBuild).build();
            }
            MediaSource mediaSourceCreateMediaSource = mediaSourceFactory.createMediaSource(mediaItem);
            AbstractC2301u1 abstractC2301u1 = ((MediaItem.LocalConfiguration) Util.castNonNull(mediaItem.localConfiguration)).subtitleConfigurations;
            if (!abstractC2301u1.isEmpty()) {
                MediaSource[] mediaSourceArr = new MediaSource[abstractC2301u1.size() + 1];
                mediaSourceArr[0] = mediaSourceCreateMediaSource;
                for (int i6 = 0; i6 < abstractC2301u1.size(); i6++) {
                    if (this.parseSubtitlesDuringExtraction) {
                        Format formatBuild = new Format.Builder().setSampleMimeType(((MediaItem.SubtitleConfiguration) abstractC2301u1.get(i6)).mimeType).setLanguage(((MediaItem.SubtitleConfiguration) abstractC2301u1.get(i6)).language).setSelectionFlags(((MediaItem.SubtitleConfiguration) abstractC2301u1.get(i6)).selectionFlags).setRoleFlags(((MediaItem.SubtitleConfiguration) abstractC2301u1.get(i6)).roleFlags).setLabel(((MediaItem.SubtitleConfiguration) abstractC2301u1.get(i6)).label).setId(((MediaItem.SubtitleConfiguration) abstractC2301u1.get(i6)).f2581id).build();
                        ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(this.dataSourceFactory, new C0900c(this, formatBuild));
                        if (this.subtitleParserFactory.supportsFormat(formatBuild)) {
                            formatBuild = formatBuild.buildUpon().setSampleMimeType(MimeTypes.APPLICATION_MEDIA3_CUES).setCodecs(formatBuild.sampleMimeType).setCueReplacementBehavior(this.subtitleParserFactory.getCueReplacementBehavior(formatBuild)).build();
                        }
                        ProgressiveMediaSource.Factory factoryEnableLazyLoadingWithSingleTrack = factory.enableLazyLoadingWithSingleTrack(0, formatBuild);
                        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
                        if (loadErrorHandlingPolicy != null) {
                            factoryEnableLazyLoadingWithSingleTrack.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy);
                        }
                        mediaSourceArr[i6 + 1] = factoryEnableLazyLoadingWithSingleTrack.createMediaSource(MediaItem.fromUri(((MediaItem.SubtitleConfiguration) abstractC2301u1.get(i6)).uri.toString()));
                    } else {
                        SingleSampleMediaSource.Factory factory2 = new SingleSampleMediaSource.Factory(this.dataSourceFactory);
                        LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.loadErrorHandlingPolicy;
                        if (loadErrorHandlingPolicy2 != null) {
                            factory2.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy2);
                        }
                        mediaSourceArr[i6 + 1] = factory2.createMediaSource((MediaItem.SubtitleConfiguration) abstractC2301u1.get(i6), C0565C.TIME_UNSET);
                    }
                }
                mediaSourceCreateMediaSource = new MergingMediaSource(mediaSourceArr);
            }
            return maybeWrapWithAdsMediaSource(mediaItem, maybeClipMediaSource(mediaItem, mediaSourceCreateMediaSource));
        } catch (ClassNotFoundException e5) {
            throw new IllegalStateException(e5);
        }
    }

    @Override
    @UnstableApi
    public int[] getSupportedTypes() {
        return this.delegateFactoryLoader.getSupportedTypes();
    }

    @UnstableApi
    @Deprecated
    public DefaultMediaSourceFactory setAdViewProvider(AdViewProvider adViewProvider) {
        this.adViewProvider = adViewProvider;
        return this;
    }

    @UnstableApi
    @Deprecated
    public DefaultMediaSourceFactory setAdsLoaderProvider(AdsLoader.Provider provider) {
        this.adsLoaderProvider = provider;
        return this;
    }

    public DefaultMediaSourceFactory setDataSourceFactory(DataSource.Factory factory) {
        this.dataSourceFactory = factory;
        this.delegateFactoryLoader.setDataSourceFactory(factory);
        return this;
    }

    @UnstableApi
    public DefaultMediaSourceFactory setExternalImageLoader(ExternalLoader externalLoader) {
        this.externalImageLoader = externalLoader;
        return this;
    }

    @UnstableApi
    public DefaultMediaSourceFactory setLiveMaxOffsetMs(long j10) {
        this.liveMaxOffsetMs = j10;
        return this;
    }

    @UnstableApi
    public DefaultMediaSourceFactory setLiveMaxSpeed(float f) {
        this.liveMaxSpeed = f;
        return this;
    }

    @UnstableApi
    public DefaultMediaSourceFactory setLiveMinOffsetMs(long j10) {
        this.liveMinOffsetMs = j10;
        return this;
    }

    @UnstableApi
    public DefaultMediaSourceFactory setLiveMinSpeed(float f) {
        this.liveMinSpeed = f;
        return this;
    }

    @UnstableApi
    public DefaultMediaSourceFactory setLiveTargetOffsetMs(long j10) {
        this.liveTargetOffsetMs = j10;
        return this;
    }

    public DefaultMediaSourceFactory setLocalAdInsertionComponents(AdsLoader.Provider provider, AdViewProvider adViewProvider) {
        this.adsLoaderProvider = (AdsLoader.Provider) Assertions.checkNotNull(provider);
        this.adViewProvider = (AdViewProvider) Assertions.checkNotNull(adViewProvider);
        return this;
    }

    public DefaultMediaSourceFactory setServerSideAdInsertionMediaSourceFactory(MediaSource.Factory factory) {
        this.serverSideAdInsertionMediaSourceFactory = factory;
        return this;
    }

    @UnstableApi
    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this(new DefaultDataSource.Factory(context), extractorsFactory);
    }

    @Override
    @UnstableApi
    @Deprecated
    public DefaultMediaSourceFactory experimentalParseSubtitlesDuringExtraction(boolean z7) {
        this.parseSubtitlesDuringExtraction = z7;
        this.delegateFactoryLoader.setParseSubtitlesDuringExtraction(z7);
        return this;
    }

    @Override
    @UnstableApi
    public DefaultMediaSourceFactory experimentalSetCodecsToParseWithinGopSampleDependencies(int i6) {
        this.delegateFactoryLoader.setCodecsToParseWithinGopSampleDependencies(i6);
        return this;
    }

    @Override
    @UnstableApi
    public DefaultMediaSourceFactory setCmcdConfigurationFactory(CmcdConfiguration.Factory factory) {
        this.delegateFactoryLoader.setCmcdConfigurationFactory((CmcdConfiguration.Factory) Assertions.checkNotNull(factory));
        return this;
    }

    @Override
    @UnstableApi
    public DefaultMediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
        this.delegateFactoryLoader.setDrmSessionManagerProvider((DrmSessionManagerProvider) Assertions.checkNotNull(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    @Override
    @UnstableApi
    public DefaultMediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        this.loadErrorHandlingPolicy = (LoadErrorHandlingPolicy) Assertions.checkNotNull(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.delegateFactoryLoader.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy);
        return this;
    }

    @Override
    @UnstableApi
    public DefaultMediaSourceFactory setSubtitleParserFactory(SubtitleParser.Factory factory) {
        this.subtitleParserFactory = (SubtitleParser.Factory) Assertions.checkNotNull(factory);
        this.delegateFactoryLoader.setSubtitleParserFactory(factory);
        return this;
    }

    @UnstableApi
    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, new DefaultExtractorsFactory());
    }

    public static MediaSource.Factory newInstance(Class<? extends MediaSource.Factory> cls) {
        try {
            return cls.getConstructor(null).newInstance(null);
        } catch (Exception e5) {
            throw new IllegalStateException(e5);
        }
    }

    @UnstableApi
    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.dataSourceFactory = factory;
        DefaultSubtitleParserFactory defaultSubtitleParserFactory = new DefaultSubtitleParserFactory();
        this.subtitleParserFactory = defaultSubtitleParserFactory;
        DelegateFactoryLoader delegateFactoryLoader = new DelegateFactoryLoader(extractorsFactory, defaultSubtitleParserFactory);
        this.delegateFactoryLoader = delegateFactoryLoader;
        delegateFactoryLoader.setDataSourceFactory(factory);
        this.liveTargetOffsetMs = C0565C.TIME_UNSET;
        this.liveMinOffsetMs = C0565C.TIME_UNSET;
        this.liveMaxOffsetMs = C0565C.TIME_UNSET;
        this.liveMinSpeed = -3.4028235E38f;
        this.liveMaxSpeed = -3.4028235E38f;
        this.parseSubtitlesDuringExtraction = true;
    }

    public static final class UnknownSubtitlesExtractor implements Extractor {
        private final Format format;

        public UnknownSubtitlesExtractor(Format format) {
            this.format = format;
        }

        @Override
        public final List getSniffFailureDetails() {
            return AbstractC1009b.m2645a(this);
        }

        @Override
        public final Extractor getUnderlyingImplementation() {
            return AbstractC1009b.m2646b(this);
        }

        @Override
        public void init(ExtractorOutput extractorOutput) {
            TrackOutput trackOutputTrack = extractorOutput.track(0, 3);
            extractorOutput.seekMap(new SeekMap.Unseekable(C0565C.TIME_UNSET));
            extractorOutput.endTracks();
            trackOutputTrack.format(this.format.buildUpon().setSampleMimeType(MimeTypes.TEXT_UNKNOWN).setCodecs(this.format.sampleMimeType).build());
        }

        @Override
        public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
            return extractorInput.skip(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }

        @Override
        public boolean sniff(ExtractorInput extractorInput) {
            return true;
        }

        @Override
        public void release() {
        }

        @Override
        public void seek(long j10, long j11) {
        }
    }
}
