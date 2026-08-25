package androidx.media3.exoplayer.hls;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Consumer;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import java.io.IOException;

public final class C0779f implements Consumer {

    public final int f2867a;

    public final Object f2868b;

    public final int f2869c;

    public final int f2870d;

    public final Object f2871e;

    public final Object f2872f;

    public C0779f(Object obj, Object obj2, int i6, int i10, Object obj3, int i11) {
        this.f2867a = i11;
        this.f2871e = obj;
        this.f2868b = obj2;
        this.f2869c = i6;
        this.f2870d = i10;
        this.f2872f = obj3;
    }

    @Override
    public final void accept(Object obj) {
        switch (this.f2867a) {
            case 0:
                ((HlsInterstitialsAdsLoader.Listener) obj).onMetadata((MediaItem) this.f2871e, this.f2868b, this.f2869c, this.f2870d, (Metadata) this.f2872f);
                break;
            default:
                int i6 = this.f2869c;
                int i10 = this.f2870d;
                HlsInterstitialsAdsLoader.lambda$handlePrepareError$3((AdsMediaSource) this.f2871e, this.f2868b, i6, i10, (IOException) this.f2872f, (HlsInterstitialsAdsLoader.Listener) obj);
                break;
        }
    }
}
