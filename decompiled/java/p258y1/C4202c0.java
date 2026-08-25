package p258y1;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import p055ea.AbstractC2460q;

public final class C4202c0 implements TypeEvaluator {

    public final float[] f14279a = new float[9];

    public final float[] f14280b = new float[9];

    public final Matrix f14281c = new Matrix();

    @Override
    public final Object evaluate(float f, Object obj, Object obj2) {
        float[] fArr = this.f14279a;
        ((Matrix) obj).getValues(fArr);
        float[] fArr2 = this.f14280b;
        ((Matrix) obj2).getValues(fArr2);
        for (int i6 = 0; i6 < 9; i6++) {
            float f3 = fArr2[i6];
            float f4 = fArr[i6];
            fArr2[i6] = AbstractC2460q.m5490d(f3, f4, f, f4);
        }
        Matrix matrix = this.f14281c;
        matrix.setValues(fArr2);
        return matrix;
    }
}
