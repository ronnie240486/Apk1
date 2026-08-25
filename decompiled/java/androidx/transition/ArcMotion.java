package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import p046e0.AbstractC2343b;
import p258y1.AbstractC4233v;

public class ArcMotion extends PathMotion {

    public static final float f3753a = (float) Math.tan(Math.toRadians(35.0d));

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4233v.f14378h);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        m3027a(!AbstractC2343b.m5319e(xmlPullParser, "minimumVerticalAngle") ? 0.0f : typedArrayObtainStyledAttributes.getFloat(1, 0.0f));
        m3027a(AbstractC2343b.m5319e(xmlPullParser, "minimumHorizontalAngle") ? typedArrayObtainStyledAttributes.getFloat(0, 0.0f) : 0.0f);
        m3027a(AbstractC2343b.m5319e(xmlPullParser, "maximumAngle") ? typedArrayObtainStyledAttributes.getFloat(2, 70.0f) : 70.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float m3027a(float f) {
        if (f < 0.0f || f > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f / 2.0f));
    }
}
