package p138n0;

import android.view.View;
import android.view.autofill.AutofillId;
import java.util.Collection;

public abstract class AbstractC3128j0 {
    public static void m6206a(View view, Collection<View> collection, int i6) {
        view.addKeyboardNavigationClusters(collection, i6);
    }

    public static AutofillId m6207b(View view) {
        return view.getAutofillId();
    }

    public static int m6208c(View view) {
        return view.getImportantForAutofill();
    }

    public static int m6209d(View view) {
        return view.getNextClusterForwardId();
    }

    public static boolean m6210e(View view) {
        return view.hasExplicitFocusable();
    }

    public static boolean m6211f(View view) {
        return view.isFocusedByDefault();
    }

    public static boolean m6212g(View view) {
        return view.isImportantForAutofill();
    }

    public static boolean m6213h(View view) {
        return view.isKeyboardNavigationCluster();
    }

    public static View m6214i(View view, View view2, int i6) {
        return view.keyboardNavigationClusterSearch(view2, i6);
    }

    public static boolean m6215j(View view) {
        return view.restoreDefaultFocus();
    }

    public static void m6216k(View view, String... strArr) {
        view.setAutofillHints(strArr);
    }

    public static void m6217l(View view, boolean z7) {
        view.setFocusedByDefault(z7);
    }

    public static void m6218m(View view, int i6) {
        view.setImportantForAutofill(i6);
    }

    public static void m6219n(View view, boolean z7) {
        view.setKeyboardNavigationCluster(z7);
    }

    public static void m6220o(View view, int i6) {
        view.setNextClusterForwardId(i6);
    }

    public static void m6221p(View view, CharSequence charSequence) {
        view.setTooltipText(charSequence);
    }
}
