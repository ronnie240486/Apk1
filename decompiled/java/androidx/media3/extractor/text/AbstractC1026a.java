package androidx.media3.extractor.text;

import androidx.media3.common.C0628x;
import androidx.media3.common.util.Consumer;
import p041d7.AbstractC2301u1;
import p041d7.C2288s1;

public abstract class AbstractC1026a {
    public static void m2673a(SubtitleParser subtitleParser, byte[] bArr, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        subtitleParser.parse(bArr, 0, bArr.length, outputOptions, consumer);
    }

    public static Subtitle m2674b(SubtitleParser subtitleParser, byte[] bArr, int i6, int i10) {
        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
        subtitleParser.parse(bArr, i6, i10, SubtitleParser.OutputOptions.ALL, new C0628x(8, c2288s1M5269k));
        return new CuesWithTimingSubtitle(c2288s1M5269k.m5262g());
    }

    public static void m2675c(SubtitleParser subtitleParser) {
    }
}
