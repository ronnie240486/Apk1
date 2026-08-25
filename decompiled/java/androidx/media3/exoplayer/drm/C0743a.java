package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.Consumer;

public final class C0743a implements Consumer, DrmSessionManager.DrmSessionReference {

    public final int f2815a;

    public C0743a(int i6) {
        this.f2815a = i6;
    }

    @Override
    public void accept(Object obj) {
        DrmSessionEventListener.EventDispatcher eventDispatcher = (DrmSessionEventListener.EventDispatcher) obj;
        switch (this.f2815a) {
            case 0:
                eventDispatcher.drmSessionAcquired(3);
                break;
            case 1:
                eventDispatcher.drmKeysRemoved();
                break;
            case 2:
                eventDispatcher.drmKeysLoaded();
                break;
            default:
                eventDispatcher.drmKeysRestored();
                break;
        }
    }

    @Override
    public void release() {
        AbstractC0751i.m2217a();
    }
}
