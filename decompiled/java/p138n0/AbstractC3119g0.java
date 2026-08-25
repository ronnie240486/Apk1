package p138n0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import com.p2serv.android.p032ds.R;
import p056f0.C2480c;

public abstract class AbstractC3119g0 {
    public static void m6162a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static C3153r1 m6163b(View view, C3153r1 c3153r1, Rect rect) {
        WindowInsets windowInsetsM6330g = c3153r1.m6330g();
        if (windowInsetsM6330g != null) {
            return C3153r1.m6324h(view.computeSystemWindowInsets(windowInsetsM6330g, rect), view);
        }
        rect.setEmpty();
        return c3153r1;
    }

    public static boolean m6164c(View view, float f, float f3, boolean z7) {
        return view.dispatchNestedFling(f, f3, z7);
    }

    public static boolean m6165d(View view, float f, float f3) {
        return view.dispatchNestedPreFling(f, f3);
    }

    public static boolean m6166e(View view, int i6, int i10, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i6, i10, iArr, iArr2);
    }

    public static boolean m6167f(View view, int i6, int i10, int i11, int i12, int[] iArr) {
        return view.dispatchNestedScroll(i6, i10, i11, i12, iArr);
    }

    public static ColorStateList m6168g(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode m6169h(View view) {
        return view.getBackgroundTintMode();
    }

    public static float m6170i(View view) {
        return view.getElevation();
    }

    public static C3153r1 m6171j(View view) {
        AbstractC3126i1 c3120g1;
        if (!AbstractC3111d1.f10584d || !view.isAttachedToWindow()) {
            return null;
        }
        try {
            Object obj = AbstractC3111d1.f10581a.get(view.getRootView());
            if (obj == null) {
                return null;
            }
            Rect rect = (Rect) AbstractC3111d1.f10582b.get(obj);
            Rect rect2 = (Rect) AbstractC3111d1.f10583c.get(obj);
            if (rect == null || rect2 == null) {
                return null;
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 30) {
                c3120g1 = new C3123h1();
            } else {
                c3120g1 = i6 >= 29 ? new C3120g1() : new C3114e1();
            }
            c3120g1.mo6133c(C2480c.m5515a(rect.left, rect.top, rect.right, rect.bottom));
            c3120g1.mo6134d(C2480c.m5515a(rect2.left, rect2.top, rect2.right, rect2.bottom));
            C3153r1 c3153r1Mo6132b = c3120g1.mo6132b();
            c3153r1Mo6132b.f10641a.mo6234r(c3153r1Mo6132b);
            c3153r1Mo6132b.f10641a.mo6226d(view.getRootView());
            return c3153r1Mo6132b;
        } catch (IllegalAccessException e5) {
            Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e5.getMessage(), e5);
            return null;
        }
    }

    public static String m6172k(View view) {
        return view.getTransitionName();
    }

    public static float m6173l(View view) {
        return view.getTranslationZ();
    }

    public static float m6174m(View view) {
        return view.getZ();
    }

    public static boolean m6175n(View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean m6176o(View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean m6177p(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void m6178q(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void m6179r(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void m6180s(View view, float f) {
        view.setElevation(f);
    }

    public static void m6181t(View view, boolean z7) {
        view.setNestedScrollingEnabled(z7);
    }

    public static void m6182u(View view, InterfaceC3154s interfaceC3154s) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, interfaceC3154s);
        }
        if (interfaceC3154s == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC3116f0(view, interfaceC3154s));
        }
    }

    public static void m6183v(View view, String str) {
        view.setTransitionName(str);
    }

    public static void m6184w(View view, float f) {
        view.setTranslationZ(f);
    }

    public static void m6185x(View view, float f) {
        view.setZ(f);
    }

    public static boolean m6186y(View view, int i6) {
        return view.startNestedScroll(i6);
    }

    public static void m6187z(View view) {
        view.stopNestedScroll();
    }
}
