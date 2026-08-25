package androidx.media3.exoplayer.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.Surface;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import java.io.IOException;
import java.nio.ByteBuffer;

@UnstableApi
public final class SynchronousMediaCodecAdapter implements MediaCodecAdapter {
    private final MediaCodec codec;
    private final LoudnessCodecController loudnessCodecController;

    public static class Factory implements MediaCodecAdapter.Factory {
        @Override
        @SuppressLint({"WrongConstant"})
        public MediaCodecAdapter createAdapter(MediaCodecAdapter.Configuration configuration) throws Throwable {
            MediaCodec mediaCodec = 0;
            mediaCodec = 0;
            try {
                MediaCodec mediaCodecCreateCodec = createCodec(configuration);
                try {
                    TraceUtil.beginSection("configureCodec");
                    Surface surface = configuration.surface;
                    mediaCodecCreateCodec.configure(configuration.mediaFormat, surface, configuration.crypto, (surface == null && configuration.codecInfo.detachedSurfaceSupported && Util.SDK_INT >= 35) ? 8 : 0);
                    TraceUtil.endSection();
                    TraceUtil.beginSection("startCodec");
                    mediaCodecCreateCodec.start();
                    TraceUtil.endSection();
                    return new SynchronousMediaCodecAdapter(mediaCodecCreateCodec, configuration.loudnessCodecController);
                } catch (IOException e5) {
                    e = e5;
                    mediaCodec = mediaCodecCreateCodec;
                    if (mediaCodec != 0) {
                        mediaCodec.release();
                    }
                    throw e;
                } catch (RuntimeException e10) {
                    e = e10;
                    mediaCodec = mediaCodecCreateCodec;
                    if (mediaCodec != 0) {
                        mediaCodec.release();
                    }
                    throw e;
                }
            } catch (IOException e11) {
                e = e11;
            } catch (RuntimeException e12) {
                e = e12;
            }
        }

        public MediaCodec createCodec(MediaCodecAdapter.Configuration configuration) throws IOException {
            Assertions.checkNotNull(configuration.codecInfo);
            String str = configuration.codecInfo.name;
            TraceUtil.beginSection("createCodec:" + str);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            TraceUtil.endSection();
            return mediaCodecCreateByCodecName;
        }
    }

    public void lambda$setOnFrameRenderedListener$0(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j10, long j11) {
        onFrameRenderedListener.onFrameRendered(this, j10, j11);
    }

    @Override
    public int dequeueInputBufferIndex() {
        return this.codec.dequeueInputBuffer(0L);
    }

    @Override
    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, 0L);
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override
    public void detachOutputSurface() {
        this.codec.detachOutputSurface();
    }

    @Override
    public void flush() {
        this.codec.flush();
    }

    @Override
    public ByteBuffer getInputBuffer(int i6) {
        return this.codec.getInputBuffer(i6);
    }

    @Override
    public PersistableBundle getMetrics() {
        return this.codec.getMetrics();
    }

    @Override
    public ByteBuffer getOutputBuffer(int i6) {
        return this.codec.getOutputBuffer(i6);
    }

    @Override
    public MediaFormat getOutputFormat() {
        return this.codec.getOutputFormat();
    }

    @Override
    public boolean needsReconfiguration() {
        return false;
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
    public final boolean registerOnBufferAvailableListener(MediaCodecAdapter.OnBufferAvailableListener onBufferAvailableListener) {
        return AbstractC0815e.m2323a(this, onBufferAvailableListener);
    }

    @Override
    public void release() {
        LoudnessCodecController loudnessCodecController;
        try {
            int i6 = Util.SDK_INT;
            if (i6 >= 30 && i6 < 33) {
                this.codec.stop();
            }
        } finally {
            if (Util.SDK_INT >= 35 && (loudnessCodecController = this.loudnessCodecController) != null) {
                loudnessCodecController.removeMediaCodec(this.codec);
            }
            this.codec.release();
        }
    }

    @Override
    public void releaseOutputBuffer(int i6, boolean z7) {
        this.codec.releaseOutputBuffer(i6, z7);
    }

    @Override
    public void setOnFrameRenderedListener(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        this.codec.setOnFrameRenderedListener(new C0811a(this, onFrameRenderedListener, 1), handler);
    }

    @Override
    public void setOutputSurface(Surface surface) {
        this.codec.setOutputSurface(surface);
    }

    @Override
    public void setParameters(Bundle bundle) {
        this.codec.setParameters(bundle);
    }

    @Override
    public void setVideoScalingMode(int i6) {
        this.codec.setVideoScalingMode(i6);
    }

    private SynchronousMediaCodecAdapter(MediaCodec mediaCodec, LoudnessCodecController loudnessCodecController) {
        this.codec = mediaCodec;
        this.loudnessCodecController = loudnessCodecController;
        if (Util.SDK_INT < 35 || loudnessCodecController == null) {
            return;
        }
        loudnessCodecController.addMediaCodec(mediaCodec);
    }

    @Override
    public void releaseOutputBuffer(int i6, long j10) {
        this.codec.releaseOutputBuffer(i6, j10);
    }
}
