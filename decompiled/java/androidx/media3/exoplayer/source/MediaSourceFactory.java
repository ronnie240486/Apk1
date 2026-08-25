package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.text.SubtitleParser;

@UnstableApi
@Deprecated
public interface MediaSourceFactory extends MediaSource.Factory {

    @UnstableApi
    public static final MediaSourceFactory UNSUPPORTED = new MediaSourceFactory() {
        @Override
        public MediaSource createMediaSource(MediaItem mediaItem) {
            throw new UnsupportedOperationException();
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
            throw new UnsupportedOperationException();
        }

        @Override
        public final MediaSource.Factory setCmcdConfigurationFactory(CmcdConfiguration.Factory factory) {
            return AbstractC0908h.m2486c(this, factory);
        }

        @Override
        public MediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        @Override
        public MediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }

        @Override
        public final MediaSource.Factory setSubtitleParserFactory(SubtitleParser.Factory factory) {
            return AbstractC0908h.m2487d(this, factory);
        }
    };
}
