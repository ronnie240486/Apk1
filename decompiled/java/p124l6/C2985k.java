package p124l6;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import p055ea.AbstractC2460q;

public final class C2985k implements TypeEvaluator {

    public final float[] f10233a = new float[9];

    public final float[] f10234b = new float[9];

    public final Matrix f10235c = new Matrix();

    public final AbstractC2991q f10236d;

    public C2985k(AbstractC2991q abstractC2991q) {
        this.f10236d = abstractC2991q;
    }

    @Override
    public final Object evaluate(float f, Object obj, Object obj2) {
        this.f10236d.f10278p = f;
        float[] fArr = this.f10233a;
        ((Matrix) obj).getValues(fArr);
        float[] fArr2 = this.f10234b;
        ((Matrix) obj2).getValues(fArr2);
        for (int i6 = 0; i6 < 9; i6++) {
            float f3 = fArr2[i6];
            float f4 = fArr[i6];
            fArr2[i6] = AbstractC2460q.m5490d(f3, f4, f, f4);
        }
        Matrix matrix = this.f10235c;
        matrix.setValues(fArr2);
        return matrix;
    }
}
