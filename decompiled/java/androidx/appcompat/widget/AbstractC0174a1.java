package androidx.appcompat.widget;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;

public abstract class AbstractC0174a1 {
    public static StaticLayout m636a(CharSequence charSequence, Layout.Alignment alignment, int i6, TextView textView, TextPaint textPaint) {
        return new StaticLayout(charSequence, textPaint, i6, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
    }

    public static int m637b(TextView textView) {
        return textView.getMaxLines();
    }
}
