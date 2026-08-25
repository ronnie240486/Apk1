package androidx.core.app;

import android.app.Notification;
import android.widget.RemoteViews;

public abstract class AbstractC0345o0 {
    public static Notification.Action.Builder m997a(Notification.Action.Builder builder, boolean z7) {
        return builder.setAllowGeneratedReplies(z7);
    }

    public static Notification.Builder m998b(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomBigContentView(remoteViews);
    }

    public static Notification.Builder m999c(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomContentView(remoteViews);
    }

    public static Notification.Builder m1000d(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomHeadsUpContentView(remoteViews);
    }

    public static Notification.Builder m1001e(Notification.Builder builder, CharSequence[] charSequenceArr) {
        return builder.setRemoteInputHistory(charSequenceArr);
    }
}
