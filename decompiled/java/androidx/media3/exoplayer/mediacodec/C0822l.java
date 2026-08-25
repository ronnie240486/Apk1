package androidx.media3.exoplayer.mediacodec;

import android.os.Bundle;

public final class C0822l implements MediaCodecUtil.ScoreProvider, LoudnessCodecController.LoudnessParameterUpdateListener {

    public final int f2898a;

    public C0822l(int i6) {
        this.f2898a = i6;
    }

    @Override
    public int getScore(Object obj) {
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) obj;
        switch (this.f2898a) {
            case 0:
                return MediaCodecUtil.lambda$getDecoderInfosSortedBySoftwareOnly$2(mediaCodecInfo);
            default:
                return MediaCodecUtil.lambda$applyWorkarounds$3(mediaCodecInfo);
        }
    }

    @Override
    public Bundle onLoudnessParameterUpdate(Bundle bundle) {
        return AbstractC0814d.m2322a(bundle);
    }
}
