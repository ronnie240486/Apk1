package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import com.bumptech.glide.AbstractC1466d;
import org.xmlpull.v1.XmlPullParser;
import p046e0.AbstractC2343b;
import p258y1.AbstractC4233v;

public class PatternPathMotion extends PathMotion {

    public final Path f3777a = new Path();

    public final Matrix f3778b = new Matrix();

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4233v.f14379i);
        try {
            String strM5318d = AbstractC2343b.m5318d(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (strM5318d == null) {
                throw new RuntimeException("pathData must be supplied for patternPathMotion");
            }
            m3043a(AbstractC1466d.m3489g(strM5318d));
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void m3043a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f = fArr[0];
        float f3 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f4 = fArr[0];
        float f5 = fArr[1];
        if (f4 == f && f5 == f3) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        Matrix matrix = this.f3778b;
        matrix.setTranslate(-f4, -f5);
        float f10 = f - f4;
        float f11 = f3 - f5;
        float fSqrt = 1.0f / ((float) Math.sqrt((f11 * f11) + (f10 * f10)));
        matrix.postScale(fSqrt, fSqrt);
        matrix.postRotate((float) Math.toDegrees(-Math.atan2(f11, f10)));
        path.transform(matrix, this.f3777a);
    }
}
