package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
public class ForwardingTrackOutput implements TrackOutput {
    private final TrackOutput trackOutput;

    public ForwardingTrackOutput(TrackOutput trackOutput) {
        this.trackOutput = trackOutput;
    }

    @Override
    public void durationUs(long j10) {
        this.trackOutput.durationUs(j10);
    }

    @Override
    public void format(Format format) {
        this.trackOutput.format(format);
    }

    @Override
    public int sampleData(DataReader dataReader, int i6, boolean z7) throws IOException {
        return this.trackOutput.sampleData(dataReader, i6, z7);
    }

    @Override
    public void sampleMetadata(long j10, int i6, int i10, int i11, TrackOutput.CryptoData cryptoData) {
        this.trackOutput.sampleMetadata(j10, i6, i10, i11, cryptoData);
    }

    @Override
    public void sampleData(ParsableByteArray parsableByteArray, int i6) {
        this.trackOutput.sampleData(parsableByteArray, i6);
    }

    @Override
    public int sampleData(DataReader dataReader, int i6, boolean z7, int i10) throws IOException {
        return this.trackOutput.sampleData(dataReader, i6, z7, i10);
    }

    @Override
    public void sampleData(ParsableByteArray parsableByteArray, int i6, int i10) {
        this.trackOutput.sampleData(parsableByteArray, i6, i10);
    }
}
