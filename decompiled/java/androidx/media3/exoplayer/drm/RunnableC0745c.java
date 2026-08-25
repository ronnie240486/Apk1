package androidx.media3.exoplayer.drm;

import androidx.media3.common.Format;
import com.google.common.util.concurrent.SettableFuture;

public final class RunnableC0745c implements Runnable {

    public final int f2817a;

    public final Object f2818b;

    public final Object f2819c;

    public RunnableC0745c(Object obj, int i6, Object obj2) {
        this.f2817a = i6;
        this.f2818b = obj;
        this.f2819c = obj2;
    }

    @Override
    public final void run() {
        switch (this.f2817a) {
            case 0:
                ((DefaultDrmSessionManager.PreacquiredSessionReference) this.f2818b).lambda$acquire$0((Format) this.f2819c);
                break;
            default:
                ((OfflineLicenseHelper) this.f2818b).lambda$releaseManagerOnHandlerThread$4((SettableFuture) this.f2819c);
                break;
        }
    }
}
