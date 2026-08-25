package androidx.media3.exoplayer.analytics;

import p020b7.InterfaceC1339e0;

public final class C0709z implements InterfaceC1339e0 {

    public final int f2769a;

    public C0709z(int i6) {
        this.f2769a = i6;
    }

    @Override
    public final Object get() {
        switch (this.f2769a) {
            case 0:
                return DefaultPlaybackSessionManager.generateDefaultSessionId();
            default:
                throw new IllegalStateException();
        }
    }
}
