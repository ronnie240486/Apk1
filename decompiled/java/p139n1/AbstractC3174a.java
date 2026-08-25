package p139n1;

import android.app.Notification;
import android.media.session.MediaSession;
import android.support.v4.media.session.MediaSessionCompat;

public abstract class AbstractC3174a {
    public static Notification.MediaStyle m6375a() {
        return new Notification.MediaStyle();
    }

    public static Notification.MediaStyle m6376b(Notification.MediaStyle mediaStyle, int[] iArr, MediaSessionCompat.Token token) {
        if (iArr != null) {
            m6379e(mediaStyle, iArr);
        }
        if (token != null) {
            m6377c(mediaStyle, (MediaSession.Token) token.getToken());
        }
        return mediaStyle;
    }

    public static void m6377c(Notification.MediaStyle mediaStyle, MediaSession.Token token) {
        mediaStyle.setMediaSession(token);
    }

    public static void m6378d(Notification.Builder builder, Notification.MediaStyle mediaStyle) {
        builder.setStyle(mediaStyle);
    }

    public static void m6379e(Notification.MediaStyle mediaStyle, int... iArr) {
        mediaStyle.setShowActionsInCompactView(iArr);
    }
}
