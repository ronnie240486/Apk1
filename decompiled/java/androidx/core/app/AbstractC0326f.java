package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;

public abstract class AbstractC0326f {
    public static <T> T m954a(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    public static int m955b(AppOpsManager appOpsManager, String str, String str2) {
        return appOpsManager.noteProxyOp(str, str2);
    }

    public static int m956c(AppOpsManager appOpsManager, String str, String str2) {
        return appOpsManager.noteProxyOpNoThrow(str, str2);
    }

    public static String m957d(String str) {
        return AppOpsManager.permissionToOp(str);
    }
}
