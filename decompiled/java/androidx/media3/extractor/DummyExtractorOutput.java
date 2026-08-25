package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
@Deprecated
public final class DummyExtractorOutput implements ExtractorOutput {
    @Override
    public TrackOutput track(int i6, int i10) {
        return new DiscardingTrackOutput();
    }

    @Override
    public void endTracks() {
    }

    @Override
    public void seekMap(SeekMap seekMap) {
    }
}
