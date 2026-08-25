package p165p4;

import android.app.NotificationChannel;
import java.lang.invoke.MethodHandles;

public abstract class AbstractC3361f {
    public static NotificationChannel m6826b(String str) {
        return new NotificationChannel("cast_remote_display_local_service", str, 2);
    }

    public static Class m6830f() {
        return MethodHandles.Lookup.class;
    }

    public static MethodHandles.Lookup m6835k(Object obj) {
        return (MethodHandles.Lookup) obj;
    }

    public static NotificationChannel m6838n(String str) {
        return new NotificationChannel("cast_media_notification", str, 2);
    }

    public static NotificationChannel m6839o(String str) {
        return new NotificationChannel("com.google.android.gms.availability", str, 4);
    }
}
