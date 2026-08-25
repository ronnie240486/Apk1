package p065g0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public abstract class AbstractC2581a {
    public static void m5579a(Drawable drawable, Resources.Theme theme) {
        drawable.applyTheme(theme);
    }

    public static boolean m5580b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter m5581c(Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static void m5582d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    public static void m5583e(Drawable drawable, float f, float f3) {
        drawable.setHotspot(f, f3);
    }

    public static void m5584f(Drawable drawable, int i6, int i10, int i11, int i12) {
        drawable.setHotspotBounds(i6, i10, i11, i12);
    }

    public static void m5585g(Drawable drawable, int i6) {
        drawable.setTint(i6);
    }

    public static void m5586h(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void m5587i(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }
}
