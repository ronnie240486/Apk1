package androidx.core.app;

import android.app.NotificationManager;

public abstract class AbstractC0357u0 {
    public static boolean m1029a(NotificationManager notificationManager) {
        return notificationManager.areNotificationsEnabled();
    }

    public static int m1030b(NotificationManager notificationManager) {
        return notificationManager.getImportance();
    }
}
