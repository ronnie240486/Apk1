package p138n0;

import android.view.View;
import android.view.WindowInsets;

public abstract class AbstractC3113e0 {
    public static WindowInsets m6128a(View view, WindowInsets windowInsets) {
        return view.dispatchApplyWindowInsets(windowInsets);
    }

    public static WindowInsets m6129b(View view, WindowInsets windowInsets) {
        return view.onApplyWindowInsets(windowInsets);
    }

    public static void m6130c(View view) {
        view.requestApplyInsets();
    }
}
