package androidx.appcompat.app;

import android.app.NotificationChannel;
import android.media.AudioFocusRequest;

public abstract class AbstractC0168x {
    public static NotificationChannel m493c(int i6, String str, String str2) {
        return new NotificationChannel(str, str2, i6);
    }

    public static AudioFocusRequest.Builder m498h(int i6) {
        return new AudioFocusRequest.Builder(i6);
    }

    public static AudioFocusRequest m503m(Object obj) {
        return (AudioFocusRequest) obj;
    }

    public static void m509s() {
    }
}
