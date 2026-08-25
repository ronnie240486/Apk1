package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.os.Bundle;
import androidx.media3.decoder.CryptoInfo;

class SynchronousMediaCodecBufferEnqueuer implements MediaCodecBufferEnqueuer {
    private final MediaCodec codec;

    public SynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec) {
        this.codec = mediaCodec;
    }

    @Override
    public void queueInputBuffer(int i6, int i10, int i11, long j10, int i12) {
        this.codec.queueInputBuffer(i6, i10, i11, j10, i12);
    }

    @Override
    public void queueSecureInputBuffer(int i6, int i10, CryptoInfo cryptoInfo, long j10, int i11) {
        this.codec.queueSecureInputBuffer(i6, i10, cryptoInfo.getFrameworkCryptoInfo(), j10, i11);
    }

    @Override
    public void setParameters(Bundle bundle) {
        this.codec.setParameters(bundle);
    }

    @Override
    public void flush() {
    }

    @Override
    public void maybeThrowException() {
    }

    @Override
    public void shutdown() {
    }

    @Override
    public void start() {
    }

    @Override
    public void waitUntilQueueingComplete() {
    }
}
