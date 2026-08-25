package androidx.media3.common;

import p020b7.InterfaceC1339e0;

public final class C0612u implements InterfaceC1339e0 {

    public final int f2633a;

    public final SimpleBasePlayer.State f2634b;

    public C0612u(SimpleBasePlayer.State state, int i6) {
        this.f2633a = i6;
        this.f2634b = state;
    }

    @Override
    public final Object get() {
        switch (this.f2633a) {
            case 0:
                return SimpleBasePlayer.lambda$setVideoSurface$17(this.f2634b);
            case 1:
                return SimpleBasePlayer.lambda$increaseDeviceVolume$25(this.f2634b);
            case 2:
                return SimpleBasePlayer.lambda$decreaseDeviceVolume$26(this.f2634b);
            case 3:
                return SimpleBasePlayer.lambda$release$13(this.f2634b);
            case 4:
                return SimpleBasePlayer.lambda$clearVideoOutput$21(this.f2634b);
            case 5:
                return SimpleBasePlayer.lambda$increaseDeviceVolume$24(this.f2634b);
            case 6:
                return SimpleBasePlayer.lambda$prepare$7(this.f2634b);
            default:
                return SimpleBasePlayer.lambda$decreaseDeviceVolume$27(this.f2634b);
        }
    }
}
