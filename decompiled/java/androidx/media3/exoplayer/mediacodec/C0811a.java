package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;

public final class C0811a implements MediaCodec.OnFrameRenderedListener {

    public final int f2891a;

    public final MediaCodecAdapter.OnFrameRenderedListener f2892b;

    public final MediaCodecAdapter f2893c;

    public C0811a(MediaCodecAdapter mediaCodecAdapter, MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, int i6) {
        this.f2891a = i6;
        this.f2893c = mediaCodecAdapter;
        this.f2892b = onFrameRenderedListener;
    }

    @Override
    public final void onFrameRendered(MediaCodec mediaCodec, long j10, long j11) {
        switch (this.f2891a) {
            case 0:
                ((AsynchronousMediaCodecAdapter) this.f2893c).lambda$setOnFrameRenderedListener$0(this.f2892b, mediaCodec, j10, j11);
                break;
            default:
                ((SynchronousMediaCodecAdapter) this.f2893c).lambda$setOnFrameRenderedListener$0(this.f2892b, mediaCodec, j10, j11);
                break;
        }
    }
}
