package androidx.media3.common;

import p020b7.InterfaceC1339e0;

public final class C0606o implements InterfaceC1339e0 {

    public final int f2614a;

    public final SimpleBasePlayer.State f2615b;

    public final int f2616c;

    public C0606o(SimpleBasePlayer.State state, int i6, int i10) {
        this.f2614a = i10;
        this.f2615b = state;
        this.f2616c = i6;
    }

    @Override
    public final Object get() {
        switch (this.f2614a) {
            case 0:
                return SimpleBasePlayer.lambda$setDeviceVolume$22(this.f2615b, this.f2616c);
            case 1:
                return SimpleBasePlayer.lambda$setDeviceVolume$23(this.f2615b, this.f2616c);
            default:
                return SimpleBasePlayer.lambda$setRepeatMode$8(this.f2615b, this.f2616c);
        }
    }
}
