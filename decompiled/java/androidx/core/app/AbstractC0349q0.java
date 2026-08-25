package androidx.core.app;

import android.app.Notification;
import android.app.Person;

public abstract class AbstractC0349q0 {
    public static Notification.Builder m1011a(Notification.Builder builder, Person person) {
        return builder.addPerson(person);
    }

    public static Notification.Action.Builder m1012b(Notification.Action.Builder builder, int i6) {
        return builder.setSemanticAction(i6);
    }
}
