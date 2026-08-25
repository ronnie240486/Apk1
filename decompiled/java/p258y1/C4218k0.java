package p258y1;

import android.graphics.Matrix;
import android.view.View;

public final class C4218k0 extends C4216j0 {
    @Override
    public final void mo8265h(View view, int i6, int i10, int i11, int i12) {
        view.setLeftTopRightBottom(i6, i10, i11, i12);
    }

    @Override
    public final void mo8266i(int i6, View view) {
        view.setTransitionVisibility(i6);
    }

    @Override
    public final float mo8259k(View view) {
        return view.getTransitionAlpha();
    }

    @Override
    public final void mo8260l(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override
    public final void mo8261m(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override
    public final void mo8262n(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override
    public final void mo8263o(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
