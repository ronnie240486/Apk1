package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;

public abstract class AbstractC0313a {
    public static void m941a(Object obj) {
        ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
    }

    public static void m942b(Activity activity, String[] strArr, int i6) {
        activity.requestPermissions(strArr, i6);
    }

    public static boolean m943c(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
