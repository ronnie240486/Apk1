package androidx.media3.exoplayer;

import p020b7.InterfaceC1346i;

public final class C0996x0 implements InterfaceC1346i {

    public final int f3076a;

    public final Object f3077b;

    public final int f3078c;

    public C0996x0(int i6, int i10, Object obj) {
        this.f3076a = i10;
        this.f3077b = obj;
        this.f3078c = i6;
    }

    @Override
    public final Object apply(Object obj) {
        switch (this.f3076a) {
            case 0:
                return ((StreamVolumeManager) this.f3077b).lambda$increaseVolume$6(this.f3078c, (StreamVolumeManager.StreamVolumeState) obj);
            case 1:
                return ((StreamVolumeManager) this.f3077b).lambda$decreaseVolume$8(this.f3078c, (StreamVolumeManager.StreamVolumeState) obj);
            case 2:
                return ((StreamVolumeManager) this.f3077b).lambda$setStreamType$2(this.f3078c, (StreamVolumeManager.StreamVolumeState) obj);
            default:
                return ((ExoPlayerImpl) this.f3077b).lambda$setAudioSessionId$11(this.f3078c, (Integer) obj);
        }
    }
}
