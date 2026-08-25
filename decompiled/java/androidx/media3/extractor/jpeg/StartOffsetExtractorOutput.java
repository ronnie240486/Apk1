package androidx.media3.extractor.jpeg;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ForwardingSeekMap;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;

@UnstableApi
public final class StartOffsetExtractorOutput implements ExtractorOutput {
    private final ExtractorOutput extractorOutput;
    private final long startOffset;

    public StartOffsetExtractorOutput(long j10, ExtractorOutput extractorOutput) {
        this.startOffset = j10;
        this.extractorOutput = extractorOutput;
    }

    @Override
    public void endTracks() {
        this.extractorOutput.endTracks();
    }

    @Override
    public void seekMap(final SeekMap seekMap) {
        this.extractorOutput.seekMap(new ForwardingSeekMap(seekMap) {
            @Override
            public SeekMap.SeekPoints getSeekPoints(long j10) {
                SeekMap.SeekPoints seekPoints = seekMap.getSeekPoints(j10);
                SeekPoint seekPoint = seekPoints.first;
                SeekPoint seekPoint2 = new SeekPoint(seekPoint.timeUs, StartOffsetExtractorOutput.this.startOffset + seekPoint.position);
                SeekPoint seekPoint3 = seekPoints.second;
                return new SeekMap.SeekPoints(seekPoint2, new SeekPoint(seekPoint3.timeUs, StartOffsetExtractorOutput.this.startOffset + seekPoint3.position));
            }
        });
    }

    @Override
    public TrackOutput track(int i6, int i10) {
        return this.extractorOutput.track(i6, i10);
    }
}
