package androidx.media3.exoplayer.image;

import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;

@UnstableApi
public interface ImageDecoder extends Decoder<DecoderInputBuffer, ImageOutputBuffer, ImageDecoderException> {

    public interface Factory {
        public static final Factory DEFAULT = new BitmapFactoryImageDecoder.Factory();

        ImageDecoder createImageDecoder();

        int supportsFormat(Format format);
    }

    @Override
    ImageOutputBuffer dequeueOutputBuffer() throws ImageDecoderException;

    @Override
    ImageOutputBuffer dequeueOutputBuffer() throws DecoderException;

    void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ImageDecoderException;

    @Override
    void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws DecoderException;
}
