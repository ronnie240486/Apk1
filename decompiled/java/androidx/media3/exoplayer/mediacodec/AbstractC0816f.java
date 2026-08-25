package androidx.media3.exoplayer.mediacodec;

import android.content.Context;

public abstract class AbstractC0816f {
    static {
        MediaCodecAdapter.Factory factory = MediaCodecAdapter.Factory.DEFAULT;
    }

    public static MediaCodecAdapter.Factory m2324a(Context context) {
        return new DefaultMediaCodecAdapterFactory(context);
    }
}
