package p187r4;

import androidx.media3.exoplayer.Renderer;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.internal.ResourceProvider;
import com.google.android.gms.internal.cast.AbstractC1714w1;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public final class C3613c {

    public String f12130a;

    public final AbstractC1714w1 f12131b = NotificationOptions.f4845I;

    public final int[] f12132c = NotificationOptions.f4846J;

    public final int f12133d = m7281b("smallIconDrawableResId");

    public final int f12134e = m7281b("stopLiveStreamDrawableResId");

    public final int f12135f = m7281b("pauseDrawableResId");

    public final int f12136g = m7281b("playDrawableResId");

    public final int f12137h = m7281b("skipNextDrawableResId");

    public final int f12138i = m7281b("skipPrevDrawableResId");

    public final int f12139j = m7281b("forwardDrawableResId");

    public final int f12140k = m7281b("forward10DrawableResId");

    public final int f12141l = m7281b("forward30DrawableResId");

    public final int f12142m = m7281b("rewindDrawableResId");

    public final int f12143n = m7281b("rewind10DrawableResId");

    public final int f12144o = m7281b("rewind30DrawableResId");

    public final int f12145p = m7281b("disconnectDrawableResId");

    public final long f12146q = Renderer.DEFAULT_DURATION_TO_PROGRESS_US;

    public static int m7281b(String str) {
        try {
            Map map = ResourceProvider.f4881a;
            Integer num = (Integer) ResourceProvider.class.getMethod("findResourceByName", String.class).invoke(null, str);
            if (num == null) {
                return 0;
            }
            return num.intValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return 0;
        }
    }

    public final NotificationOptions m7282a() {
        return new NotificationOptions(this.f12131b, this.f12132c, this.f12146q, this.f12130a, this.f12133d, this.f12134e, this.f12135f, this.f12136g, this.f12137h, this.f12138i, this.f12139j, this.f12140k, this.f12141l, this.f12142m, this.f12143n, this.f12144o, this.f12145p, m7281b("notificationImageSizeDimenResId"), m7281b("castingToDeviceStringResId"), m7281b("stopLiveStreamStringResId"), m7281b("pauseStringResId"), m7281b("playStringResId"), m7281b("skipNextStringResId"), m7281b("skipPrevStringResId"), m7281b("forwardStringResId"), m7281b("forward10StringResId"), m7281b("forward30StringResId"), m7281b("rewindStringResId"), m7281b("rewind10StringResId"), m7281b("rewind30StringResId"), m7281b("disconnectStringResId"), null, false, false);
    }
}
