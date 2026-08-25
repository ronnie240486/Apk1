package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import java.util.Locale;

public abstract class AbstractC0266s0 {
    public static Drawable[] m766a(TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    public static void m767b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public static void m768c(TextView textView, Locale locale) {
        textView.setTextLocale(locale);
    }
}
