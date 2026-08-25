package p205t;

import android.util.SparseArray;
import android.view.View;
import java.lang.reflect.Array;
import p187r4.AbstractC3612b;
import p256y.C4184a;

public final class C3765j0 extends AbstractC3771m0 {

    public SparseArray f12619g;

    public SparseArray f12620h;

    public float[] f12621i;

    public float[] f12622j;

    @Override
    public final boolean mo7510b(float f, long j10, View view, C3781u c3781u) {
        this.f12624a.mo7277s(f, this.f12621i);
        float[] fArr = this.f12621i;
        float f3 = fArr[fArr.length - 2];
        float f4 = fArr[fArr.length - 1];
        float f5 = (float) (((((j10 - this.f12628e) * 1.0E-9d) * ((double) f3)) + ((double) this.f12629f)) % 1.0d);
        this.f12629f = f5;
        this.f12628e = j10;
        float fSin = (float) Math.sin(f5 * 6.2831855f);
        this.f12627d = false;
        int i6 = 0;
        while (true) {
            float[] fArr2 = this.f12622j;
            if (i6 >= fArr2.length) {
                break;
            }
            boolean z7 = this.f12627d;
            float f10 = this.f12621i[i6];
            this.f12627d = z7 | (((double) f10) != 0.0d);
            fArr2[i6] = (f10 * fSin) + f4;
            i6++;
        }
        ((C4184a) this.f12619g.valueAt(0)).m8238g(view, this.f12622j);
        if (f3 != 0.0f) {
            this.f12627d = true;
        }
        return this.f12627d;
    }

    @Override
    public final void mo7512c(int i6) {
        SparseArray sparseArray = this.f12619g;
        int size = sparseArray.size();
        int iM8237d = ((C4184a) sparseArray.valueAt(0)).m8237d();
        double[] dArr = new double[size];
        int i10 = iM8237d + 2;
        this.f12621i = new float[i10];
        this.f12622j = new float[iM8237d];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i10);
        for (int i11 = 0; i11 < size; i11++) {
            int iKeyAt = sparseArray.keyAt(i11);
            C4184a c4184a = (C4184a) sparseArray.valueAt(i11);
            float[] fArr = (float[]) this.f12620h.valueAt(i11);
            dArr[i11] = ((double) iKeyAt) * 0.01d;
            c4184a.m8236c(this.f12621i);
            int i12 = 0;
            while (true) {
                float[] fArr2 = this.f12621i;
                if (i12 < fArr2.length) {
                    dArr2[i11][i12] = fArr2[i12];
                    i12++;
                }
            }
            double[] dArr3 = dArr2[i11];
            dArr3[iM8237d] = fArr[0];
            dArr3[iM8237d + 1] = fArr[1];
        }
        this.f12624a = AbstractC3612b.m7269k(i6, dArr, dArr2);
    }
}
