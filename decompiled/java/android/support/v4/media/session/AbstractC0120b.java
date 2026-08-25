package android.support.v4.media.session;

import android.app.Person;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.PrecomputedText;
import android.text.TextPaint;

public abstract class AbstractC0120b {
    public static Person m332d(Parcelable parcelable) {
        return (Person) parcelable;
    }

    public static ImageDecoder.Source m335g(Object obj) {
        return (ImageDecoder.Source) obj;
    }

    public static AnimatedImageDrawable m337i(Drawable drawable) {
        return (AnimatedImageDrawable) drawable;
    }

    public static PrecomputedText.Params.Builder m342n(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    public static void m351w(Object obj) {
    }

    public static boolean m353y(Drawable drawable) {
        return drawable instanceof AnimatedImageDrawable;
    }

    public static boolean m354z(CharSequence charSequence) {
        return charSequence instanceof PrecomputedText;
    }
}
