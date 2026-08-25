package androidx.core.app;

import android.app.Notification;
import android.graphics.drawable.Icon;

public abstract class AbstractC0350r {
    public static void m1013a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
        bigPictureStyle.bigPicture(icon);
    }

    public static void m1014b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
        bigPictureStyle.setContentDescription(charSequence);
    }

    public static void m1015c(Notification.BigPictureStyle bigPictureStyle, boolean z7) {
        bigPictureStyle.showBigPictureWhenCollapsed(z7);
    }
}
