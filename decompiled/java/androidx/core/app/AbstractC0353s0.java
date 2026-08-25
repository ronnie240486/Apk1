package androidx.core.app;

import android.app.Notification;

public abstract class AbstractC0353s0 {
    public static Notification.Action.Builder m1021a(Notification.Action.Builder builder, boolean z7) {
        return builder.setAuthenticationRequired(z7);
    }

    public static Notification.Builder m1022b(Notification.Builder builder, int i6) {
        return builder.setForegroundServiceBehavior(i6);
    }
}
