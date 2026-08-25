package androidx.media3.exoplayer;

import p020b7.InterfaceC1346i;

public final class C0680a0 implements InterfaceC1346i {

    public final int f2682a;

    public final int f2683b;

    public C0680a0(int i6, int i10) {
        this.f2682a = i10;
        this.f2683b = i6;
    }

    @Override
    public final Object apply(Object obj) {
        switch (this.f2682a) {
            case 0:
                return ExoPlayerImpl.lambda$setAudioSessionId$10(this.f2683b, (Integer) obj);
            case 1:
                return StreamVolumeManager.lambda$setVolume$3(this.f2683b, (StreamVolumeManager.StreamVolumeState) obj);
            default:
                return StreamVolumeManager.lambda$setStreamType$1(this.f2683b, (StreamVolumeManager.StreamVolumeState) obj);
        }
    }
}
