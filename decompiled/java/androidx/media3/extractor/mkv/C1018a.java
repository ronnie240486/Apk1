package androidx.media3.extractor.mkv;

import android.net.Uri;
import androidx.media3.extractor.AbstractC1010c;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.p010ts.TsExtractor;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

public final class C1018a implements ExtractorsFactory {

    public final int f3097a;

    public final SubtitleParser.Factory f3098b;

    public C1018a(SubtitleParser.Factory factory, int i6) {
        this.f3097a = i6;
        this.f3098b = factory;
    }

    @Override
    public final Extractor[] createExtractors() {
        switch (this.f3097a) {
            case 0:
                return MatroskaExtractor.lambda$newFactory$0(this.f3098b);
            case 1:
                return FragmentedMp4Extractor.lambda$newFactory$0(this.f3098b);
            case 2:
                return Mp4Extractor.lambda$newFactory$0(this.f3098b);
            default:
                return TsExtractor.lambda$newFactory$0(this.f3098b);
        }
    }

    @Override
    public final ExtractorsFactory experimentalSetCodecsToParseWithinGopSampleDependencies(int i6) {
        int i10 = this.f3097a;
        return AbstractC1010c.m2648b(this, i6);
    }

    @Override
    public final ExtractorsFactory experimentalSetTextTrackTranscodingEnabled(boolean z7) {
        int i6 = this.f3097a;
        return AbstractC1010c.m2649c(this, z7);
    }

    @Override
    public final ExtractorsFactory setSubtitleParserFactory(SubtitleParser.Factory factory) {
        int i6 = this.f3097a;
        return AbstractC1010c.m2650d(this, factory);
    }

    @Override
    public final Extractor[] createExtractors(Uri uri, Map map) {
        int i6 = this.f3097a;
        return AbstractC1010c.m2647a(this, uri, map);
    }
}
