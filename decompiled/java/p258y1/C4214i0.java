package p258y1;

import android.view.View;

public class C4214i0 extends C4212h0 {

    public static boolean f14328z = true;

    @Override
    public void mo8265h(View view, int i6, int i10, int i11, int i12) {
        if (f14328z) {
            try {
                view.setLeftTopRightBottom(i6, i10, i11, i12);
            } catch (NoSuchMethodError unused) {
                f14328z = false;
            }
        }
    }
}
