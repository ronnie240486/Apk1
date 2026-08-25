package p258y1;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.appcompat.widget.C0209g3;

public abstract class AbstractC4210g0 {

    public static final C4212h0 f14313a;

    public static final C0209g3 f14314b;

    public static final C0209g3 f14315c;

    static {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            f14313a = new C4218k0();
        } else if (i6 >= 23) {
            f14313a = new C4216j0();
        } else if (i6 >= 22) {
            f14313a = new C4214i0();
        } else {
            f14313a = new C4212h0();
        }
        f14314b = new C0209g3("translationAlpha", Float.class, 18);
        f14315c = new C0209g3("clipBounds", Rect.class, 19);
    }

    public static void m8256a(View view, int i6, int i10, int i11, int i12) {
        f14313a.mo8265h(view, i6, i10, i11, i12);
    }

    public static void m8257b(View view, float f) {
        f14313a.mo8261m(view, f);
    }

    public static void m8258c(int i6, View view) {
        f14313a.mo8266i(i6, view);
    }
}
