package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import java.io.EOFException;
import java.io.IOException;

@UnstableApi
public final class DiscardingTrackOutput implements TrackOutput {
    private final byte[] readBuffer = new byte[4096];

    @Override
    public final void durationUs(long j10) {
        AbstractC1011d.m2652a(this, j10);
    }

    @Override
    public final int sampleData(DataReader dataReader, int i6, boolean z7) {
        return AbstractC1011d.m2653b(this, dataReader, i6, z7);
    }

    @Override
    public final void sampleData(ParsableByteArray parsableByteArray, int i6) {
        AbstractC1011d.m2654c(this, parsableByteArray, i6);
    }

    @Override
    public int sampleData(DataReader dataReader, int i6, boolean z7, int i10) throws IOException {
        int i11 = dataReader.read(this.readBuffer, 0, Math.min(this.readBuffer.length, i6));
        if (i11 != -1) {
            return i11;
        }
        if (z7) {
            return -1;
        }
        throw new EOFException();
    }

    @Override
    public void sampleData(ParsableByteArray parsableByteArray, int i6, int i10) {
        parsableByteArray.skipBytes(i6);
    }

    @Override
    public void format(Format format) {
    }

    @Override
    public void sampleMetadata(long j10, int i6, int i10, int i11, TrackOutput.CryptoData cryptoData) {
    }
}
