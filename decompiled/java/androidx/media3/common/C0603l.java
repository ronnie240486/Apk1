package androidx.media3.common;

import p020b7.InterfaceC1339e0;

public final class C0603l implements InterfaceC1339e0 {

    public final int f2605a;

    public final SimpleBasePlayer.State f2606b;

    public final boolean f2607c;

    public C0603l(SimpleBasePlayer.State state, boolean z7, int i6) {
        this.f2605a = i6;
        this.f2606b = state;
        this.f2607c = z7;
    }

    @Override
    public final Object get() {
        switch (this.f2605a) {
            case 0:
                return SimpleBasePlayer.lambda$setPlayWhenReady$1(this.f2606b, this.f2607c);
            case 1:
                return SimpleBasePlayer.lambda$setShuffleModeEnabled$9(this.f2606b, this.f2607c);
            case 2:
                return SimpleBasePlayer.lambda$setDeviceMuted$28(this.f2606b, this.f2607c);
            default:
                return SimpleBasePlayer.lambda$setDeviceMuted$29(this.f2606b, this.f2607c);
        }
    }
}
