package p205t;

import android.util.SparseArray;
import android.view.View;
import java.lang.reflect.Array;
import p187r4.AbstractC3612b;
import p256y.C4184a;

public final class C3755e0 extends AbstractC3761h0 {

    public SparseArray f12596f;

    public float[] f12597g;

    @Override
    public final void mo7505b(int i6, float f) {
        throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
    }

    @Override
    public final void mo7504c(View view, float f) {
        this.f12608a.mo7277s(f, this.f12597g);
        ((C4184a) this.f12596f.valueAt(0)).m8238g(view, this.f12597g);
    }

    @Override
    public final void mo7506d(int i6) {
        SparseArray sparseArray = this.f12596f;
        int size = sparseArray.size();
        int iM8237d = ((C4184a) sparseArray.valueAt(0)).m8237d();
        double[] dArr = new double[size];
        this.f12597g = new float[iM8237d];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, iM8237d);
        for (int i10 = 0; i10 < size; i10++) {
            int iKeyAt = sparseArray.keyAt(i10);
            C4184a c4184a = (C4184a) sparseArray.valueAt(i10);
            dArr[i10] = ((double) iKeyAt) * 0.01d;
            c4184a.m8236c(this.f12597g);
            int i11 = 0;
            while (true) {
                float[] fArr = this.f12597g;
                if (i11 < fArr.length) {
                    dArr2[i10][i11] = fArr[i11];
                    i11++;
                }
            }
        }
        this.f12608a = AbstractC3612b.m7269k(i6, dArr, dArr2);
    }
}
