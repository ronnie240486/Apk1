package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.List;
import java.util.Map;

public final class C0784k implements HlsExtractorFactory {
    @Override
    public final HlsMediaChunkExtractor createExtractor(Uri uri, Format format, List list, TimestampAdjuster timestampAdjuster, Map map, ExtractorInput extractorInput, PlayerId playerId) {
        return MediaParserHlsMediaChunkExtractor.lambda$static$0(uri, format, list, timestampAdjuster, map, extractorInput, playerId);
    }

    @Override
    public final HlsExtractorFactory experimentalParseSubtitlesDuringExtraction(boolean z7) {
        return AbstractC0774a.m2233a(this, z7);
    }

    @Override
    public final HlsExtractorFactory experimentalSetCodecsToParseWithinGopSampleDependencies(int i6) {
        return AbstractC0774a.m2234b(this, i6);
    }

    @Override
    public final Format getOutputTextFormat(Format format) {
        return AbstractC0774a.m2235c(this, format);
    }

    @Override
    public final HlsExtractorFactory setSubtitleParserFactory(SubtitleParser.Factory factory) {
        return AbstractC0774a.m2236d(this, factory);
    }
}
