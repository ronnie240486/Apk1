package p173q1;

import android.os.Handler;
import android.os.Looper;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;

public final class C3453v0 {

    public final Handler f11696a = new Handler(Looper.getMainLooper());

    public final Runnable f11697b;

    public long f11698c;

    public long f11699d;

    public boolean f11700e;

    public C3453v0(Runnable runnable) {
        this.f11697b = runnable;
    }

    public final void m7083a(long j10, boolean z7) {
        if (z7) {
            long j11 = this.f11699d;
            if (j11 - j10 >= SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS) {
                return;
            }
            this.f11698c = Math.max(this.f11698c, (j10 + SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS) - j11);
            this.f11700e = true;
        }
    }
}
