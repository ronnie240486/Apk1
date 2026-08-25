package p258y1;

import android.graphics.Matrix;
import android.view.View;

public final class C4213i {

    public final Matrix f14323a = new Matrix();

    public final View f14324b;

    public final float[] f14325c;

    public float f14326d;

    public float f14327e;

    public C4213i(View view, float[] fArr) {
        this.f14324b = view;
        float[] fArr2 = (float[]) fArr.clone();
        this.f14325c = fArr2;
        this.f14326d = fArr2[2];
        this.f14327e = fArr2[5];
        m8264a();
    }

    public final void m8264a() {
        float f = this.f14326d;
        float[] fArr = this.f14325c;
        fArr[2] = f;
        fArr[5] = this.f14327e;
        Matrix matrix = this.f14323a;
        matrix.setValues(fArr);
        AbstractC4210g0.f14313a.mo8260l(this.f14324b, matrix);
    }
}
