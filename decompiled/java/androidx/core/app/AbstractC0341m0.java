package androidx.core.app;

import android.app.Notification;
import android.media.AudioAttributes;
import android.net.Uri;

public abstract class AbstractC0341m0 {
    public static Notification.Builder m987a(Notification.Builder builder, String str) {
        return builder.addPerson(str);
    }

    public static Notification.Builder m988b(Notification.Builder builder, String str) {
        return builder.setCategory(str);
    }

    public static Notification.Builder m989c(Notification.Builder builder, int i6) {
        return builder.setColor(i6);
    }

    public static Notification.Builder m990d(Notification.Builder builder, Notification notification) {
        return builder.setPublicVersion(notification);
    }

    public static Notification.Builder m991e(Notification.Builder builder, Uri uri, Object obj) {
        return builder.setSound(uri, (AudioAttributes) obj);
    }

    public static Notification.Builder m992f(Notification.Builder builder, int i6) {
        return builder.setVisibility(i6);
    }
}
