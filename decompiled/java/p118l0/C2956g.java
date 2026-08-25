package p118l0;

import android.os.Build;
import android.support.v4.media.session.AbstractC0120b;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.Objects;

public final class C2956g {

    public final TextPaint f10132a;

    public final TextDirectionHeuristic f10133b;

    public final int f10134c;

    public final int f10135d;

    public C2956g(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i6, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC0120b.m342n(textPaint).setBreakStrategy(i6).setHyphenationFrequency(i10).setTextDirection(textDirectionHeuristic).build();
        }
        this.f10132a = textPaint;
        this.f10133b = textDirectionHeuristic;
        this.f10134c = i6;
        this.f10135d = i10;
    }

    public final boolean equals(Object obj) {
        TextPaint textPaint;
        float textScaleX;
        TextPaint textPaint2;
        boolean z7;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2956g)) {
            return false;
        }
        C2956g c2956g = (C2956g) obj;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 23) {
            if (this.f10134c == c2956g.f10134c && this.f10135d == c2956g.f10135d) {
                textPaint = this.f10132a;
                if (textPaint.getTextSize() != c2956g.f10132a.getTextSize()) {
                    z7 = false;
                } else {
                    textScaleX = textPaint.getTextScaleX();
                    textPaint2 = c2956g.f10132a;
                    if (textScaleX != textPaint2.getTextScaleX() && textPaint.getTextSkewX() == textPaint2.getTextSkewX() && textPaint.getLetterSpacing() == textPaint2.getLetterSpacing() && TextUtils.equals(textPaint.getFontFeatureSettings(), textPaint2.getFontFeatureSettings()) && textPaint.getFlags() == textPaint2.getFlags() && (i6 < 24 ? textPaint.getTextLocale().equals(textPaint2.getTextLocale()) : textPaint.getTextLocales().equals(textPaint2.getTextLocales())) && (textPaint.getTypeface() != null ? textPaint.getTypeface().equals(textPaint2.getTypeface()) : textPaint2.getTypeface() == null)) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                }
            } else {
                z7 = false;
            }
        } else {
            textPaint = this.f10132a;
            if (textPaint.getTextSize() != c2956g.f10132a.getTextSize()) {
                z7 = false;
            } else {
                textScaleX = textPaint.getTextScaleX();
                textPaint2 = c2956g.f10132a;
                if (textScaleX != textPaint2.getTextScaleX()) {
                    z7 = false;
                } else {
                    z7 = true;
                }
            }
        }
        return z7 && this.f10133b == c2956g.f10133b;
    }

    public final int hashCode() {
        TextDirectionHeuristic textDirectionHeuristic = this.f10133b;
        int i6 = Build.VERSION.SDK_INT;
        int i10 = this.f10135d;
        int i11 = this.f10134c;
        TextPaint textPaint = this.f10132a;
        return i6 >= 24 ? Objects.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i11), Integer.valueOf(i10)) : Objects.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocale(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i11), Integer.valueOf(i10));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder sb2 = new StringBuilder("textSize=");
        TextPaint textPaint = this.f10132a;
        sb2.append(textPaint.getTextSize());
        sb.append(sb2.toString());
        sb.append(", textScaleX=" + textPaint.getTextScaleX());
        sb.append(", textSkewX=" + textPaint.getTextSkewX());
        int i6 = Build.VERSION.SDK_INT;
        sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        if (i6 >= 24) {
            sb.append(", textLocale=" + textPaint.getTextLocales());
        } else {
            sb.append(", textLocale=" + textPaint.getTextLocale());
        }
        sb.append(", typeface=" + textPaint.getTypeface());
        if (i6 >= 26) {
            sb.append(", variationSettings=" + textPaint.getFontVariationSettings());
        }
        sb.append(", textDir=" + this.f10133b);
        sb.append(", breakStrategy=" + this.f10134c);
        sb.append(", hyphenationFrequency=" + this.f10135d);
        sb.append("}");
        return sb.toString();
    }

    public C2956g(PrecomputedText.Params params) {
        this.f10132a = params.getTextPaint();
        this.f10133b = params.getTextDirection();
        this.f10134c = params.getBreakStrategy();
        this.f10135d = params.getHyphenationFrequency();
    }
}
