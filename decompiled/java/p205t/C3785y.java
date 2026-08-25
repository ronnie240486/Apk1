package p205t;

import androidx.constraintlayout.widget.C0307c;
import java.util.LinkedHashMap;
import p194s.C3681e;
import p256y.C4184a;
import p256y.C4188e;

public final class C3785y implements Comparable {

    public static final String[] f12734n = {"position", "x", "y", "width", "height", "pathRotate"};

    public C3681e f12735a;

    public float f12737c;

    public float f12738d;

    public float f12739e;

    public float f12740f;

    public float f12741g;

    public float f12742h;

    public int f12736b = 0;

    public float f12743i = Float.NaN;

    public int f12744j = -1;

    public final LinkedHashMap f12745k = new LinkedHashMap();

    public double[] f12746l = new double[18];

    public double[] f12747m = new double[18];

    public static boolean m7536b(float f, float f3) {
        if (Float.isNaN(f) || Float.isNaN(f3)) {
            return Float.isNaN(f) != Float.isNaN(f3);
        }
        return Math.abs(f - f3) > 1.0E-6f;
    }

    public static void m7537d(float f, float f3, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            float f12 = (float) dArr[i6];
            double d = dArr2[i6];
            int i10 = iArr[i6];
            if (i10 == 1) {
                f4 = f12;
            } else if (i10 == 2) {
                f10 = f12;
            } else if (i10 == 3) {
                f5 = f12;
            } else if (i10 == 4) {
                f11 = f12;
            }
        }
        float f13 = f4 - ((0.0f * f5) / 2.0f);
        float f14 = f10 - ((0.0f * f11) / 2.0f);
        fArr[0] = (((f5 * 1.0f) + f13) * f) + ((1.0f - f) * f13) + 0.0f;
        fArr[1] = (((f11 * 1.0f) + f14) * f3) + ((1.0f - f3) * f14) + 0.0f;
    }

    public final void m7538a(C0307c c0307c) {
        this.f12735a = C3681e.m7432c(c0307c.f1408c.f14211c);
        C4188e c4188e = c0307c.f1408c;
        this.f12744j = c4188e.f14212d;
        this.f12743i = c4188e.f14215g;
        this.f12736b = c4188e.f14213e;
        for (String str : c0307c.f1411f.keySet()) {
            C4184a c4184a = (C4184a) c0307c.f1411f.get(str);
            if (c4184a.f14129b != 5) {
                this.f12745k.put(str, c4184a);
            }
        }
    }

    public final void m7539c(int[] iArr, double[] dArr, float[] fArr, int i6) {
        float f = this.f12739e;
        float f3 = this.f12740f;
        float f4 = this.f12741g;
        float f5 = this.f12742h;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f10 = (float) dArr[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f = f10;
            } else if (i11 == 2) {
                f3 = f10;
            } else if (i11 == 3) {
                f4 = f10;
            } else if (i11 == 4) {
                f5 = f10;
            }
        }
        fArr[i6] = (f4 / 2.0f) + f + 0.0f;
        fArr[i6 + 1] = (f5 / 2.0f) + f3 + 0.0f;
    }

    @Override
    public final int compareTo(Object obj) {
        return Float.compare(this.f12738d, ((C3785y) obj).f12738d);
    }
}
