package p124l6;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;
import android.graphics.Rect;
import com.bumptech.glide.AbstractC1466d;
import p055ea.AbstractC2460q;
import p056f0.C2483f;

public final class C2987m implements TypeEvaluator {

    public final int f10246a;

    public Object f10247b;

    public C2987m(int i6) {
        this.f10246a = i6;
    }

    @Override
    public final Object evaluate(float f, Object obj, Object obj2) {
        switch (this.f10246a) {
            case 0:
                float fFloatValue = ((FloatEvaluator) this.f10247b).evaluate(f, (Number) obj, (Number) obj2).floatValue();
                if (fFloatValue < 0.1f) {
                    fFloatValue = 0.0f;
                }
                return Float.valueOf(fFloatValue);
            case 1:
                float[] fArr = (float[]) obj;
                float[] fArr2 = (float[]) obj2;
                float[] fArr3 = (float[]) this.f10247b;
                if (fArr3 == null) {
                    fArr3 = new float[fArr.length];
                }
                for (int i6 = 0; i6 < fArr3.length; i6++) {
                    float f3 = fArr[i6];
                    fArr3[i6] = AbstractC2460q.m5490d(fArr2[i6], f3, f, f3);
                }
                return fArr3;
            case 2:
                Rect rect = (Rect) obj;
                Rect rect2 = (Rect) obj2;
                int i10 = rect.left;
                int i11 = i10 + ((int) ((rect2.left - i10) * f));
                int i12 = rect.top;
                int i13 = i12 + ((int) ((rect2.top - i12) * f));
                int i14 = rect.right;
                int i15 = i14 + ((int) ((rect2.right - i14) * f));
                int i16 = rect.bottom;
                int i17 = i16 + ((int) ((rect2.bottom - i16) * f));
                Rect rect3 = (Rect) this.f10247b;
                if (rect3 == null) {
                    return new Rect(i11, i13, i15, i17);
                }
                rect3.set(i11, i13, i15, i17);
                return rect3;
            default:
                C2483f[] c2483fArr = (C2483f[]) obj;
                C2483f[] c2483fArr2 = (C2483f[]) obj2;
                if (!AbstractC1466d.m3486a(c2483fArr, c2483fArr2)) {
                    throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
                }
                if (!AbstractC1466d.m3486a((C2483f[]) this.f10247b, c2483fArr)) {
                    this.f10247b = AbstractC1466d.m3490h(c2483fArr);
                }
                for (int i18 = 0; i18 < c2483fArr.length; i18++) {
                    C2483f c2483f = ((C2483f[]) this.f10247b)[i18];
                    C2483f c2483f2 = c2483fArr[i18];
                    C2483f c2483f3 = c2483fArr2[i18];
                    c2483f.getClass();
                    c2483f.f8686a = c2483f2.f8686a;
                    int i19 = 0;
                    while (true) {
                        float[] fArr4 = c2483f2.f8687b;
                        if (i19 < fArr4.length) {
                            c2483f.f8687b[i19] = (c2483f3.f8687b[i19] * f) + ((1.0f - f) * fArr4[i19]);
                            i19++;
                        }
                    }
                }
                return (C2483f[]) this.f10247b;
        }
    }
}
