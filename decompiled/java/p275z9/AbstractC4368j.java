package p275z9;

import androidx.leanback.widget.C0486o;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.util.concurrent.TimeUnit;
import p254x9.AbstractC4159a;
import p254x9.AbstractC4178t;

public abstract class AbstractC4368j {

    public static final String f14830a;

    public static final long f14831b;

    public static final int f14832c;

    public static final int f14833d;

    public static final long f14834e;

    public static final C4364f f14835f;

    public static final C0486o f14836g;

    public static final C0486o f14837h;

    static {
        String property;
        int i6 = AbstractC4178t.f14117a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f14830a = property;
        f14831b = AbstractC4159a.m8207h("kotlinx.coroutines.scheduler.resolution.ns", SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US, 1L, Long.MAX_VALUE);
        int i10 = AbstractC4178t.f14117a;
        if (i10 < 2) {
            i10 = 2;
        }
        f14832c = AbstractC4159a.m8208i("kotlinx.coroutines.scheduler.core.pool.size", i10, 1, 0, 8);
        f14833d = AbstractC4159a.m8208i("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        f14834e = TimeUnit.SECONDS.toNanos(AbstractC4159a.m8207h("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f14835f = C4364f.f14825a;
        f14836g = new C0486o(0);
        f14837h = new C0486o(1);
    }
}
