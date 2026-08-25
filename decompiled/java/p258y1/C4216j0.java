package p258y1;

import android.os.Build;
import android.view.View;

public class C4216j0 extends C4214i0 {

    public static boolean f14337A = true;

    @Override
    public void mo8266i(int i6, View view) {
        if (Build.VERSION.SDK_INT == 28) {
            super.mo8266i(i6, view);
        } else if (f14337A) {
            try {
                view.setTransitionVisibility(i6);
            } catch (NoSuchMethodError unused) {
                f14337A = false;
            }
        }
    }
}
