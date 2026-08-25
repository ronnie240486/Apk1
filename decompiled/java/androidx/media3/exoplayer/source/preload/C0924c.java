package androidx.media3.exoplayer.source.preload;

import androidx.media3.exoplayer.LoadControl;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import p020b7.InterfaceC1339e0;

public final class C0924c implements InterfaceC1339e0 {

    public final int f3004a;

    public final Object f3005b;

    public C0924c(int i6, Object obj) {
        this.f3004a = i6;
        this.f3005b = obj;
    }

    @Override
    public final Object get() {
        switch (this.f3004a) {
            case 0:
                return DefaultPreloadManager.Builder.lambda$setLoadControl$5((LoadControl) this.f3005b);
            case 1:
                return DefaultPreloadManager.Builder.lambda$setRenderersFactory$4((RenderersFactory) this.f3005b);
            case 2:
                return DefaultPreloadManager.Builder.lambda$setBandwidthMeter$6((BandwidthMeter) this.f3005b);
            default:
                return DefaultPreloadManager.Builder.lambda$setMediaSourceFactory$3((MediaSource.Factory) this.f3005b);
        }
    }
}
