package androidx.media3.extractor;

import android.net.Uri;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

public abstract class AbstractC1010c {
    public static Extractor[] m2647a(ExtractorsFactory extractorsFactory, Uri uri, Map map) {
        return extractorsFactory.createExtractors();
    }

    public static Extractor[] m2651e() {
        return new Extractor[0];
    }

    public static ExtractorsFactory m2648b(ExtractorsFactory extractorsFactory, int i6) {
        return extractorsFactory;
    }

    public static ExtractorsFactory m2649c(ExtractorsFactory extractorsFactory, boolean z7) {
        return extractorsFactory;
    }

    public static ExtractorsFactory m2650d(ExtractorsFactory extractorsFactory, SubtitleParser.Factory factory) {
        return extractorsFactory;
    }
}
