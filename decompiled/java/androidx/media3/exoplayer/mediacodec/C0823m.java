package androidx.media3.exoplayer.mediacodec;

import androidx.media3.common.Format;

public final class C0823m implements MediaCodecUtil.ScoreProvider {

    public final int f2899a;

    public final Format f2900b;

    public C0823m(Format format, int i6) {
        this.f2899a = i6;
        this.f2900b = format;
    }

    @Override
    public final int getScore(Object obj) {
        switch (this.f2899a) {
            case 0:
                return MediaCodecUtil.lambda$getDecoderInfosSortedByFullFormatSupport$1(this.f2900b, (MediaCodecInfo) obj);
            default:
                return MediaCodecUtil.lambda$getDecoderInfosSortedByFormatSupport$0(this.f2900b, (MediaCodecInfo) obj);
        }
    }
}
