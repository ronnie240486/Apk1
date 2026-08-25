package androidx.core.app;

import android.app.Notification;
import android.app.Person;
import android.os.Parcelable;

public abstract class AbstractC0331h0 {
    public static Notification.MessagingStyle.Message m966b(CharSequence charSequence, long j10, Person person) {
        return new Notification.MessagingStyle.Message(charSequence, j10, person);
    }

    public static Parcelable m965a(Person person) {
        return person;
    }
}
