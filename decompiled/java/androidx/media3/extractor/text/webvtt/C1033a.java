package androidx.media3.extractor.text.webvtt;

import java.util.Comparator;

public final class C1033a implements Comparator {

    public final int f3113a;

    public C1033a(int i6) {
        this.f3113a = i6;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        switch (this.f3113a) {
            case 0:
                return WebvttCueParser.Element.lambda$static$0((WebvttCueParser.Element) obj, (WebvttCueParser.Element) obj2);
            default:
                return WebvttSubtitle.lambda$getCues$0((WebvttCueInfo) obj, (WebvttCueInfo) obj2);
        }
    }
}
