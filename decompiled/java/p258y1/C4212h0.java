package p258y1;

import android.graphics.Matrix;
import android.view.View;

public class C4212h0 extends AbstractC4233v {

    public static boolean f14319v = true;

    public static boolean f14320w = true;

    public static boolean f14321x = true;

    public static boolean f14322y = true;

    public float mo8259k(View view) {
        if (f14319v) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f14319v = false;
            }
        }
        return view.getAlpha();
    }

    public void mo8260l(View view, Matrix matrix) {
        if (f14320w) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f14320w = false;
            }
        }
    }

    public void mo8261m(View view, float f) {
        if (f14319v) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                f14319v = false;
            }
        }
        view.setAlpha(f);
    }

    public void mo8262n(View view, Matrix matrix) {
        if (f14321x) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f14321x = false;
            }
        }
    }

    public void mo8263o(View view, Matrix matrix) {
        if (f14322y) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f14322y = false;
            }
        }
    }
}
