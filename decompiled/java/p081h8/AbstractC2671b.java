package p081h8;

import p090i8.AbstractC2712f;
import p191r8.AbstractC3642a;

public abstract class AbstractC2671b {

    public static final AbstractC2712f f9298a;

    static {
        try {
            C2674e c2674e = AbstractC2670a.f9297a;
            if (c2674e == null) {
                throw new NullPointerException("Scheduler Callable returned null");
            }
            f9298a = c2674e;
        } catch (Throwable th) {
            throw AbstractC3642a.m7373b(th);
        }
    }
}
