package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.util.ParsableByteArray;

public abstract class AbstractC1011d {
    public static int m2653b(TrackOutput trackOutput, DataReader dataReader, int i6, boolean z7) {
        return trackOutput.sampleData(dataReader, i6, z7, 0);
    }

    public static void m2654c(TrackOutput trackOutput, ParsableByteArray parsableByteArray, int i6) {
        trackOutput.sampleData(parsableByteArray, i6, 0);
    }

    public static void m2652a(TrackOutput trackOutput, long j10) {
    }
}
