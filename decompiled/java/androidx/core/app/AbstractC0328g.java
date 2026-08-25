package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;

public abstract class AbstractC0328g {
    public static int m960a(AppOpsManager appOpsManager, String str, int i6, String str2) {
        if (appOpsManager == null) {
            return 1;
        }
        return appOpsManager.checkOpNoThrow(str, i6, str2);
    }

    public static String m961b(Context context) {
        return context.getOpPackageName();
    }

    public static AppOpsManager m962c(Context context) {
        return (AppOpsManager) context.getSystemService(AppOpsManager.class);
    }
}
