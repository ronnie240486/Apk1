package androidx.media3.exoplayer.hls;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Consumer;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;

public final class C0778e implements Consumer {

    public final int f2862a;

    public final Object f2863b;

    public final int f2864c;

    public final int f2865d;

    public final Object f2866e;

    public C0778e(Object obj, Object obj2, int i6, int i10, int i11) {
        this.f2862a = i11;
        this.f2866e = obj;
        this.f2863b = obj2;
        this.f2864c = i6;
        this.f2865d = i10;
    }

    @Override
    public final void accept(Object obj) {
        HlsInterstitialsAdsLoader.Listener listener = (HlsInterstitialsAdsLoader.Listener) obj;
        switch (this.f2862a) {
            case 0:
                listener.onAdCompleted((MediaItem) this.f2866e, this.f2863b, this.f2864c, this.f2865d);
                break;
            default:
                HlsInterstitialsAdsLoader.lambda$handlePrepareComplete$2((AdsMediaSource) this.f2866e, this.f2863b, this.f2864c, this.f2865d, listener);
                break;
        }
    }
}
