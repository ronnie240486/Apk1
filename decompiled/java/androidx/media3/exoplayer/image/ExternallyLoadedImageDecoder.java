package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.AbstractC0947u0;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

@UnstableApi
public final class ExternallyLoadedImageDecoder implements ImageDecoder {
    private final BitmapResolver bitmapResolver;
    private final DecoderInputBuffer inputBuffer;
    private final ImageOutputBuffer outputBuffer;
    private ListenableFuture<Bitmap> pendingDecode;
    private long pendingDecodeTimeUs;
    private boolean pendingEndOfStream;

    public interface BitmapResolver {
        ListenableFuture<Bitmap> resolve(ExternalImageRequest externalImageRequest);
    }

    public static final class ExternalImageRequest {
        public final Uri uri;

        public ExternalImageRequest(Uri uri) {
            this.uri = uri;
        }
    }

    public static final class Factory implements ImageDecoder.Factory {
        private final BitmapResolver bitmapResolver;

        public Factory(BitmapResolver bitmapResolver) {
            this.bitmapResolver = bitmapResolver;
        }

        @Override
        public int supportsFormat(Format format) {
            int i6;
            if (Objects.equals(format.sampleMimeType, MimeTypes.APPLICATION_EXTERNALLY_LOADED_IMAGE)) {
                i6 = 4;
            } else {
                i6 = MimeTypes.isImage(format.sampleMimeType) ? 1 : 0;
            }
            return AbstractC0947u0.m2577c(i6);
        }

        @Override
        public ExternallyLoadedImageDecoder createImageDecoder() {
            return new ExternallyLoadedImageDecoder(this.bitmapResolver);
        }
    }

    private void resetState() {
        ListenableFuture<Bitmap> listenableFuture = this.pendingDecode;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.pendingDecode = null;
        }
        this.pendingEndOfStream = false;
        this.outputBuffer.release();
    }

    @Override
    public void flush() {
        resetState();
    }

    @Override
    public String getName() {
        return "externallyLoadedImageDecoder";
    }

    @Override
    public void release() {
        resetState();
    }

    private ExternallyLoadedImageDecoder(BitmapResolver bitmapResolver) {
        this.bitmapResolver = bitmapResolver;
        this.inputBuffer = new DecoderInputBuffer(1);
        this.outputBuffer = new ImageOutputBuffer() {
            @Override
            public void release() {
                clear();
            }
        };
    }

    @Override
    public DecoderInputBuffer dequeueInputBuffer() {
        if (this.pendingDecode == null) {
            return this.inputBuffer;
        }
        return null;
    }

    @Override
    public ImageOutputBuffer dequeueOutputBuffer() throws ImageDecoderException {
        if (this.pendingEndOfStream) {
            this.outputBuffer.addFlag(4);
            this.pendingEndOfStream = false;
            return this.outputBuffer;
        }
        ListenableFuture<Bitmap> listenableFuture = this.pendingDecode;
        if (listenableFuture != null) {
            try {
                if (listenableFuture.isDone()) {
                    try {
                        this.outputBuffer.bitmap = (Bitmap) Futures.getDone(this.pendingDecode);
                        ImageOutputBuffer imageOutputBuffer = this.outputBuffer;
                        imageOutputBuffer.timeUs = this.pendingDecodeTimeUs;
                        this.pendingDecode = null;
                        return imageOutputBuffer;
                    } catch (CancellationException e5) {
                        throw new ImageDecoderException(e5);
                    } catch (ExecutionException e10) {
                        throw new ImageDecoderException(e10.getCause());
                    }
                }
            } catch (Throwable th) {
                this.pendingDecode = null;
                throw th;
            }
        }
        return null;
    }

    @Override
    public void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (decoderInputBuffer.isEndOfStream()) {
            this.pendingEndOfStream = true;
            decoderInputBuffer.clear();
            return;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.data);
        Assertions.checkState(byteBuffer.hasArray());
        this.pendingDecode = this.bitmapResolver.resolve(new ExternalImageRequest(Uri.parse(new String(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.remaining(), StandardCharsets.UTF_8))));
        this.pendingDecodeTimeUs = decoderInputBuffer.timeUs;
        decoderInputBuffer.clear();
    }

    @Override
    public void setOutputStartTimeUs(long j10) {
    }
}
