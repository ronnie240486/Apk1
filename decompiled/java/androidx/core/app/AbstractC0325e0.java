package androidx.core.app;

import android.app.Notification;

public abstract class AbstractC0325e0 {
    public static Notification.MessagingStyle m953a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
        return messagingStyle.addHistoricMessage(message);
    }
}
