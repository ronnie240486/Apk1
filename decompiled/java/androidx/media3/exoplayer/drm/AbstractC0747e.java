package androidx.media3.exoplayer.drm;

public abstract class AbstractC0747e {
    public static boolean m2206a(DrmSession drmSession) {
        return false;
    }

    public static void m2207b(DrmSession drmSession, DrmSession drmSession2) {
        if (drmSession == drmSession2) {
            return;
        }
        if (drmSession2 != null) {
            drmSession2.acquire(null);
        }
        if (drmSession != null) {
            drmSession.release(null);
        }
    }
}
