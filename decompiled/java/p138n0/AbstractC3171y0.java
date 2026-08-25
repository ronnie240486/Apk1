package p138n0;

import android.view.View;
import android.view.ViewParent;

public abstract class AbstractC3171y0 {
    public static boolean m6368a(ViewParent viewParent, View view, float f, float f3, boolean z7) {
        return viewParent.onNestedFling(view, f, f3, z7);
    }

    public static boolean m6369b(ViewParent viewParent, View view, float f, float f3) {
        return viewParent.onNestedPreFling(view, f, f3);
    }

    public static void m6370c(ViewParent viewParent, View view, int i6, int i10, int[] iArr) {
        viewParent.onNestedPreScroll(view, i6, i10, iArr);
    }

    public static void m6371d(ViewParent viewParent, View view, int i6, int i10, int i11, int i12) {
        viewParent.onNestedScroll(view, i6, i10, i11, i12);
    }

    public static void m6372e(ViewParent viewParent, View view, View view2, int i6) {
        viewParent.onNestedScrollAccepted(view, view2, i6);
    }

    public static boolean m6373f(ViewParent viewParent, View view, View view2, int i6) {
        return viewParent.onStartNestedScroll(view, view2, i6);
    }

    public static void m6374g(ViewParent viewParent, View view) {
        viewParent.onStopNestedScroll(view);
    }
}
