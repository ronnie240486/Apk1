package androidx.media3.exoplayer.source.preload;

import p020b7.InterfaceC1354n;

public final class C0926e implements InterfaceC1354n {

    public final int f3008a;

    public C0926e(int i6) {
        this.f3008a = i6;
    }

    @Override
    public final boolean apply(Object obj) {
        DefaultPreloadManager.Status status = (DefaultPreloadManager.Status) obj;
        switch (this.f3008a) {
            case 0:
                return DefaultPreloadManager.SourcePreloadControl.lambda$onTracksSelected$1(status);
            default:
                return DefaultPreloadManager.SourcePreloadControl.lambda$onSourcePrepared$0(status);
        }
    }
}
