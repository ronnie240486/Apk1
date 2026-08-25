package androidx.media3.exoplayer;

import android.content.Context;
import androidx.media3.common.audio.AudioManagerCompat;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import p020b7.InterfaceC1339e0;

public final class C0737d implements InterfaceC1339e0 {

    public final int f2807a;

    public final Context f2808b;

    public C0737d(Context context, int i6) {
        this.f2807a = i6;
        this.f2808b = context;
    }

    @Override
    public final Object get() {
        switch (this.f2807a) {
            case 0:
                return AudioManagerCompat.getAudioManager(this.f2808b);
            case 1:
                return ExoPlayer.Builder.lambda$new$0(this.f2808b);
            case 2:
                return ExoPlayer.Builder.lambda$new$1(this.f2808b);
            case 3:
                return ExoPlayer.Builder.lambda$new$3(this.f2808b);
            case 4:
                return ExoPlayer.Builder.lambda$new$14(this.f2808b);
            case 5:
                return DefaultBandwidthMeter.getSingletonInstance(this.f2808b);
            default:
                return ExoPlayer.Builder.lambda$new$4(this.f2808b);
        }
    }
}
