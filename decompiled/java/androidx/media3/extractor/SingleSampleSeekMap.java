package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class SingleSampleSeekMap implements SeekMap {
    private final long durationUs;
    private final long startPosition;

    public SingleSampleSeekMap(long j10) {
        this(j10, 0L);
    }

    @Override
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override
    public SeekMap.SeekPoints getSeekPoints(long j10) {
        return new SeekMap.SeekPoints(new SeekPoint(j10, this.startPosition));
    }

    @Override
    public boolean isSeekable() {
        return true;
    }

    public SingleSampleSeekMap(long j10, long j11) {
        this.durationUs = j10;
        this.startPosition = j11;
    }
}
