package p205t;

import android.view.View;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import p000a.AbstractC0004e;
import p187r4.AbstractC3612b;

public abstract class AbstractC3761h0 {

    public AbstractC3612b f12608a;

    public int[] f12609b = new int[10];

    public float[] f12610c = new float[10];

    public int f12611d;

    public String f12612e;

    public final float m7507a(float f) {
        return (float) this.f12608a.mo7275q(f);
    }

    public void mo7505b(int i6, float f) {
        int[] iArr = this.f12609b;
        if (iArr.length < this.f12611d + 1) {
            this.f12609b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f12610c;
            this.f12610c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f12609b;
        int i10 = this.f12611d;
        iArr2[i10] = i6;
        this.f12610c[i10] = f;
        this.f12611d = i10 + 1;
    }

    public abstract void mo7504c(View view, float f);

    public void mo7506d(int i6) {
        int i10 = this.f12611d;
        if (i10 == 0) {
            return;
        }
        int[] iArr = this.f12609b;
        float[] fArr = this.f12610c;
        int[] iArr2 = new int[iArr.length + 10];
        iArr2[0] = i10 - 1;
        iArr2[1] = 0;
        int i11 = 2;
        while (i11 > 0) {
            int i12 = i11 - 1;
            int i13 = iArr2[i12];
            int i14 = i11 - 2;
            int i15 = iArr2[i14];
            if (i13 < i15) {
                int i16 = iArr[i15];
                int i17 = i13;
                int i18 = i17;
                while (i17 < i15) {
                    int i19 = iArr[i17];
                    if (i19 <= i16) {
                        int i20 = iArr[i18];
                        iArr[i18] = i19;
                        iArr[i17] = i20;
                        float f = fArr[i18];
                        fArr[i18] = fArr[i17];
                        fArr[i17] = f;
                        i18++;
                    }
                    i17++;
                }
                int i21 = iArr[i18];
                iArr[i18] = iArr[i15];
                iArr[i15] = i21;
                float f3 = fArr[i18];
                fArr[i18] = fArr[i15];
                fArr[i15] = f3;
                iArr2[i14] = i18 - 1;
                iArr2[i12] = i13;
                int i22 = i11 + 1;
                iArr2[i11] = i15;
                i11 += 2;
                iArr2[i22] = i18 + 1;
            } else {
                i11 = i14;
            }
        }
        int i23 = 1;
        for (int i24 = 1; i24 < this.f12611d; i24++) {
            int[] iArr3 = this.f12609b;
            if (iArr3[i24 - 1] != iArr3[i24]) {
                i23++;
            }
        }
        double[] dArr = new double[i23];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i23, 1);
        int i25 = 0;
        for (int i26 = 0; i26 < this.f12611d; i26++) {
            if (i26 > 0) {
                int[] iArr4 = this.f12609b;
                if (iArr4[i26] != iArr4[i26 - 1]) {
                    dArr[i25] = ((double) this.f12609b[i26]) * 0.01d;
                    dArr2[i25][0] = this.f12610c[i26];
                    i25++;
                }
            } else {
                dArr[i25] = ((double) this.f12609b[i26]) * 0.01d;
                dArr2[i25][0] = this.f12610c[i26];
                i25++;
            }
        }
        this.f12608a = AbstractC3612b.m7269k(i6, dArr, dArr2);
    }

    public final String toString() {
        String string = this.f12612e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i6 = 0; i6 < this.f12611d; i6++) {
            StringBuilder sbM29w = AbstractC0004e.m29w(string, "[");
            sbM29w.append(this.f12609b[i6]);
            sbM29w.append(" , ");
            sbM29w.append(decimalFormat.format(this.f12610c[i6]));
            sbM29w.append("] ");
            string = sbM29w.toString();
        }
        return string;
    }
}
