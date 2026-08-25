package androidx.media3.exoplayer.drm;

import com.google.common.util.concurrent.SettableFuture;

public final class RunnableC0757o implements Runnable {

    public final int f2831a;

    public final OfflineLicenseHelper f2832b;

    public final DrmSession f2833c;

    public final SettableFuture f2834d;

    public RunnableC0757o(DrmSession drmSession, OfflineLicenseHelper offlineLicenseHelper, SettableFuture settableFuture) {
        this.f2831a = 1;
        this.f2832b = offlineLicenseHelper;
        this.f2833c = drmSession;
        this.f2834d = settableFuture;
    }

    @Override
    public final void run() {
        switch (this.f2831a) {
            case 0:
                this.f2832b.lambda$getLicenseDurationRemainingSec$0(this.f2834d, this.f2833c);
                break;
            case 1:
                this.f2832b.lambda$acquireFirstSessionOnHandlerThread$3(this.f2833c, this.f2834d);
                break;
            default:
                this.f2832b.m2205xfae744aa(this.f2834d, this.f2833c);
                break;
        }
    }

    public RunnableC0757o(OfflineLicenseHelper offlineLicenseHelper, SettableFuture settableFuture, DrmSession drmSession, int i6) {
        this.f2831a = i6;
        this.f2832b = offlineLicenseHelper;
        this.f2834d = settableFuture;
        this.f2833c = drmSession;
    }
}
