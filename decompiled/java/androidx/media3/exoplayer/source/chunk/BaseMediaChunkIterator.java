package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.util.UnstableApi;
import java.util.NoSuchElementException;

@UnstableApi
public abstract class BaseMediaChunkIterator implements MediaChunkIterator {
    private long currentIndex;
    private final long fromIndex;
    private final long toIndex;

    public BaseMediaChunkIterator(long j10, long j11) {
        this.fromIndex = j10;
        this.toIndex = j11;
        reset();
    }

    public final void checkInBounds() {
        long j10 = this.currentIndex;
        if (j10 < this.fromIndex || j10 > this.toIndex) {
            throw new NoSuchElementException();
        }
    }

    public final long getCurrentIndex() {
        return this.currentIndex;
    }

    @Override
    public boolean isEnded() {
        return this.currentIndex > this.toIndex;
    }

    @Override
    public boolean next() {
        this.currentIndex++;
        return !isEnded();
    }

    @Override
    public void reset() {
        this.currentIndex = this.fromIndex - 1;
    }
}
