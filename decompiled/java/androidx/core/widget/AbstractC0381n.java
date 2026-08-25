package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.TextView;

public abstract class AbstractC0381n {
    public static int m1144a(TextView textView) {
        return textView.getBreakStrategy();
    }

    public static ColorStateList m1145b(TextView textView) {
        return textView.getCompoundDrawableTintList();
    }

    public static PorterDuff.Mode m1146c(TextView textView) {
        return textView.getCompoundDrawableTintMode();
    }

    public static int m1147d(TextView textView) {
        return textView.getHyphenationFrequency();
    }

    public static void m1148e(TextView textView, int i6) {
        textView.setBreakStrategy(i6);
    }

    public static void m1149f(TextView textView, ColorStateList colorStateList) {
        textView.setCompoundDrawableTintList(colorStateList);
    }

    public static void m1150g(TextView textView, PorterDuff.Mode mode) {
        textView.setCompoundDrawableTintMode(mode);
    }

    public static void m1151h(TextView textView, int i6) {
        textView.setHyphenationFrequency(i6);
    }
}
