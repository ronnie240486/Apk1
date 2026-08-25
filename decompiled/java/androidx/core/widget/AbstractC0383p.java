package androidx.core.widget;

import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.widget.TextView;

public abstract class AbstractC0383p {
    public static String[] m1154b(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    public static PrecomputedText.Params m1155c(TextView textView) {
        return textView.getTextMetricsParams();
    }

    public static void m1156d(TextView textView, int i6) {
        textView.setFirstBaselineToTopHeight(i6);
    }

    public static CharSequence m1153a(PrecomputedText precomputedText) {
        return precomputedText;
    }
}
