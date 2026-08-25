package androidx.appcompat.widget;

import android.widget.TextView;

public abstract class AbstractC0281v0 {
    public static int m792a(TextView textView) {
        return textView.getAutoSizeStepGranularity();
    }

    public static void m793b(TextView textView, int i6, int i10, int i11, int i12) {
        textView.setAutoSizeTextTypeUniformWithConfiguration(i6, i10, i11, i12);
    }

    public static void m794c(TextView textView, int[] iArr, int i6) {
        textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i6);
    }

    public static boolean m795d(TextView textView, String str) {
        return textView.setFontVariationSettings(str);
    }
}
