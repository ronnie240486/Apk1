package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
@Deprecated
public final class DummyTrackOutput implements TrackOutput {
    private final DiscardingTrackOutput discardingTrackOutput = new DiscardingTrackOutput();

    @Override
    public final void durationUs(long j10) {
        AbstractC1011d.m2652a(this, j10);
    }

    @Override
    public void format(Format format) {
        this.discardingTrackOutput.format(format);
    }

    @Override
    public int sampleData(DataReader dataReader, int i6, boolean z7) throws IOException {
        DiscardingTrackOutput discardingTrackOutput = this.discardingTrackOutput;
        discardingTrackOutput.getClass();
        return AbstractC1011d.m2653b(discardingTrackOutput, dataReader, i6, z7);
    }

    @Override
    public void sampleMetadata(long j10, int i6, int i10, int i11, TrackOutput.CryptoData cryptoData) {
        this.discardingTrackOutput.sampleMetadata(j10, i6, i10, i11, cryptoData);
    }

    @Override
    public void sampleData(ParsableByteArray parsableByteArray, int i6) {
        DiscardingTrackOutput discardingTrackOutput = this.discardingTrackOutput;
        discardingTrackOutput.getClass();
        AbstractC1011d.m2654c(discardingTrackOutput, parsableByteArray, i6);
    }

    @Override
    public int sampleData(DataReader dataReader, int i6, boolean z7, int i10) throws IOException {
        return this.discardingTrackOutput.sampleData(dataReader, i6, z7, i10);
    }

    @Override
    public void sampleData(ParsableByteArray parsableByteArray, int i6, int i10) {
        this.discardingTrackOutput.sampleData(parsableByteArray, i6, i10);
    }
}
