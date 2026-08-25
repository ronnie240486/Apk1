package androidx.core.app;

import android.app.Notification;
import android.content.LocusId;

public abstract class AbstractC0351r0 {
    public static Notification.Builder m1016a(Notification.Builder builder, boolean z7) {
        return builder.setAllowSystemGeneratedContextualActions(z7);
    }

    public static Notification.Builder m1017b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
        return builder.setBubbleMetadata(bubbleMetadata);
    }

    public static Notification.Action.Builder m1018c(Notification.Action.Builder builder, boolean z7) {
        return builder.setContextual(z7);
    }

    public static Notification.Builder m1019d(Notification.Builder builder, Object obj) {
        return builder.setLocusId((LocusId) obj);
    }
}
