package androidx.core.app;

import android.app.Notification;
import android.app.Person;

public abstract class AbstractC0327f0 {
    public static Notification.MessagingStyle m958a(Person person) {
        return new Notification.MessagingStyle(person);
    }

    public static Notification.MessagingStyle m959b(Notification.MessagingStyle messagingStyle, boolean z7) {
        return messagingStyle.setGroupConversation(z7);
    }
}
