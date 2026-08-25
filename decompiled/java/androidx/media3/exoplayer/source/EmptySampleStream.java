package androidx.media3.exoplayer.source;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;

@UnstableApi
public final class EmptySampleStream implements SampleStream {
    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i6) {
        decoderInputBuffer.setFlags(4);
        return -4;
    }

    @Override
    public int skipData(long j10) {
        return 0;
    }

    @Override
    public void maybeThrowError() {
    }
}
