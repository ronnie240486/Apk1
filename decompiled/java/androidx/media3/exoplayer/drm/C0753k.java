package androidx.media3.exoplayer.drm;

import java.util.UUID;

public final class C0753k implements ExoMediaDrm.Provider {
    @Override
    public final ExoMediaDrm acquireExoMediaDrm(UUID uuid) {
        return FrameworkMediaDrm.lambda$static$0(uuid);
    }
}
