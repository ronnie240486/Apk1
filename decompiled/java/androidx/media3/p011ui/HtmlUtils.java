package androidx.media3.p011ui;

import android.graphics.Color;
import androidx.media3.common.util.Util;

final class HtmlUtils {
    private HtmlUtils() {
    }

    public static String cssAllClassDescendantsSelector(String str) {
        return "." + str + ",." + str + " *";
    }

    public static String toCssRgba(int i6) {
        return Util.formatInvariant("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i6)), Integer.valueOf(Color.green(i6)), Integer.valueOf(Color.blue(i6)), Double.valueOf(((double) Color.alpha(i6)) / 255.0d));
    }
}
