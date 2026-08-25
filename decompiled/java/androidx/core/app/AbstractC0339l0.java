package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.os.Bundle;

public abstract class AbstractC0339l0 {
    public static Notification.Builder m976a(Notification.Builder builder, Notification.Action action) {
        return builder.addAction(action);
    }

    public static Notification.Action.Builder m977b(Notification.Action.Builder builder, Bundle bundle) {
        return builder.addExtras(bundle);
    }

    public static Notification.Action.Builder m978c(Notification.Action.Builder builder, RemoteInput remoteInput) {
        return builder.addRemoteInput(remoteInput);
    }

    public static Notification.Action m979d(Notification.Action.Builder builder) {
        return builder.build();
    }

    public static Notification.Action.Builder m980e(int i6, CharSequence charSequence, PendingIntent pendingIntent) {
        return new Notification.Action.Builder(i6, charSequence, pendingIntent);
    }

    public static String m981f(Notification notification) {
        return notification.getGroup();
    }

    public static Notification.Builder m982g(Notification.Builder builder, String str) {
        return builder.setGroup(str);
    }

    public static Notification.Builder m983h(Notification.Builder builder, boolean z7) {
        return builder.setGroupSummary(z7);
    }

    public static Notification.Builder m984i(Notification.Builder builder, boolean z7) {
        return builder.setLocalOnly(z7);
    }

    public static Notification.Builder m985j(Notification.Builder builder, String str) {
        return builder.setSortKey(str);
    }
}
