package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.util.Consumer;
import androidx.media3.extractor.AbstractC1010c;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

public final class C0900c implements ExtractorsFactory, Consumer {

    public final Object f2979a;

    public final Object f2980b;

    public C0900c(Object obj, Object obj2) {
        this.f2979a = obj;
        this.f2980b = obj2;
    }

    @Override
    public void accept(Object obj) {
        ((MediaSourceEventListener.EventDispatcher) this.f2979a).lambda$downstreamFormatChanged$5((MediaLoadData) this.f2980b, (MediaSourceEventListener) obj);
    }

    @Override
    public Extractor[] createExtractors() {
        return ((DefaultMediaSourceFactory) this.f2979a).lambda$createMediaSource$0((Format) this.f2980b);
    }

    @Override
    public ExtractorsFactory experimentalSetCodecsToParseWithinGopSampleDependencies(int i6) {
        return AbstractC1010c.m2648b(this, i6);
    }

    @Override
    public ExtractorsFactory experimentalSetTextTrackTranscodingEnabled(boolean z7) {
        return AbstractC1010c.m2649c(this, z7);
    }

    @Override
    public ExtractorsFactory setSubtitleParserFactory(SubtitleParser.Factory factory) {
        return AbstractC1010c.m2650d(this, factory);
    }

    @Override
    public Extractor[] createExtractors(Uri uri, Map map) {
        return AbstractC1010c.m2647a(this, uri, map);
    }
}
