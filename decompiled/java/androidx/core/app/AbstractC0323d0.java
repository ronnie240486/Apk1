package androidx.core.app;

import android.app.Notification;

public abstract class AbstractC0323d0 {
    public static Notification.MessagingStyle m950a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
        return messagingStyle.addMessage(message);
    }

    public static Notification.MessagingStyle m951b(CharSequence charSequence) {
        return new Notification.MessagingStyle(charSequence);
    }

    public static Notification.MessagingStyle m952c(Notification.MessagingStyle messagingStyle, CharSequence charSequence) {
        return messagingStyle.setConversationTitle(charSequence);
    }
}
