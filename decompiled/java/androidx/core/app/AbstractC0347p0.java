package androidx.core.app;

import android.app.Notification;
import android.content.Context;

public abstract class AbstractC0347p0 {
    public static Notification.Builder m1003a(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    public static Notification.Builder m1004b(Notification.Builder builder, int i6) {
        return builder.setBadgeIconType(i6);
    }

    public static Notification.Builder m1005c(Notification.Builder builder, boolean z7) {
        return builder.setColorized(z7);
    }

    public static Notification.Builder m1006d(Notification.Builder builder, int i6) {
        return builder.setGroupAlertBehavior(i6);
    }

    public static Notification.Builder m1007e(Notification.Builder builder, CharSequence charSequence) {
        return builder.setSettingsText(charSequence);
    }

    public static Notification.Builder m1008f(Notification.Builder builder, String str) {
        return builder.setShortcutId(str);
    }

    public static Notification.Builder m1009g(Notification.Builder builder, long j10) {
        return builder.setTimeoutAfter(j10);
    }
}
