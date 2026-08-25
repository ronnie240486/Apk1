package p205t;

import android.view.View;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import p000a.AbstractC0004e;
import p187r4.AbstractC3612b;
import p187r4.C3621k;

public abstract class AbstractC3762i {

    public C3756f f12613a;

    public String f12614b;

    public final ArrayList f12615c = new ArrayList();

    public final float m7508a(float f) {
        C3756f c3756f = this.f12613a;
        AbstractC3612b abstractC3612b = c3756f.f12603f;
        if (abstractC3612b != null) {
            abstractC3612b.mo7276r(f, c3756f.f12604g);
        } else {
            double[] dArr = c3756f.f12604g;
            dArr[0] = c3756f.f12602e[0];
            dArr[1] = c3756f.f12599b[0];
        }
        return (float) ((c3756f.f12598a.m7332i(f) * c3756f.f12604g[1]) + c3756f.f12604g[0]);
    }

    public final float m7509b(float f) {
        double d;
        C3756f c3756f = this.f12613a;
        AbstractC3612b abstractC3612b = c3756f.f12603f;
        if (abstractC3612b != null) {
            double d10 = f;
            abstractC3612b.mo7279v(d10, c3756f.f12605h);
            c3756f.f12603f.mo7276r(d10, c3756f.f12604g);
        } else {
            double[] dArr = c3756f.f12605h;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
        }
        double d11 = f;
        C3621k c3621k = c3756f.f12598a;
        double dM7332i = c3621k.m7332i(d11);
        c3621k.getClass();
        double d12 = 0.0d;
        if (d11 <= 0.0d) {
            d = 1.0E-5d;
        } else {
            d = d11 >= 1.0d ? 0.999999d : d11;
        }
        int iBinarySearch = Arrays.binarySearch((double[]) c3621k.f12171c, d);
        if (iBinarySearch <= 0 && iBinarySearch != 0) {
            int i6 = -iBinarySearch;
            int i10 = i6 - 1;
            float[] fArr = (float[]) c3621k.f12170b;
            float f3 = fArr[i10];
            int i11 = i6 - 2;
            float f4 = fArr[i11];
            double[] dArr2 = (double[]) c3621k.f12171c;
            double d13 = dArr2[i10];
            double d14 = dArr2[i11];
            double d15 = ((double) (f3 - f4)) / (d13 - d14);
            d12 = (((double) f4) - (d15 * d14)) + (d * d15);
        }
        double dCos = Math.cos(c3621k.m7331h(d11) * 6.283185307179586d) * d12 * 6.283185307179586d;
        double[] dArr3 = c3756f.f12605h;
        return (float) ((dCos * c3756f.f12604g[1]) + (dM7332i * dArr3[1]) + dArr3[0]);
    }

    public abstract void mo7503c(View view, float f);

    public final String toString() {
        String str = this.f12614b;
        new DecimalFormat("##.##");
        Iterator it = this.f12615c.iterator();
        if (it.hasNext()) {
            throw AbstractC0004e.m18l(it);
        }
        return str;
    }
}
