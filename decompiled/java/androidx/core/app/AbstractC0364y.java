package androidx.core.app;

import android.app.Notification;
import android.app.Person;
import android.os.Parcelable;

public abstract class AbstractC0364y {
    public static Notification.Builder m1066a(Notification.Builder builder, Person person) {
        return builder.addPerson(person);
    }

    public static Parcelable m1067b(Person person) {
        return person;
    }
}
