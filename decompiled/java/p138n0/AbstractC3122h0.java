package p138n0;

import android.view.View;
import android.view.WindowInsets;

public abstract class AbstractC3122h0 {
    public static C3153r1 m6189a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        C3153r1 c3153r1M6324h = C3153r1.m6324h(rootWindowInsets, null);
        C3144o1 c3144o1 = c3153r1M6324h.f10641a;
        c3144o1.mo6234r(c3153r1M6324h);
        c3144o1.mo6226d(view.getRootView());
        return c3153r1M6324h;
    }

    public static int m6190b(View view) {
        return view.getScrollIndicators();
    }

    public static void m6191c(View view, int i6) {
        view.setScrollIndicators(i6);
    }

    public static void m6192d(View view, int i6, int i10) {
        view.setScrollIndicators(i6, i10);
    }
}
