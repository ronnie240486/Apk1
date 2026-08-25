package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import java.util.List;

@UnstableApi
public final class FixedTrackSelection extends BaseTrackSelection {
    private final Object data;
    private final int reason;

    public FixedTrackSelection(TrackGroup trackGroup, int i6) {
        this(trackGroup, i6, 0);
    }

    @Override
    public int getSelectedIndex() {
        return 0;
    }

    @Override
    public Object getSelectionData() {
        return this.data;
    }

    @Override
    public int getSelectionReason() {
        return this.reason;
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i6, int i10) {
        this(trackGroup, i6, i10, 0, null);
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i6, int i10, int i11, Object obj) {
        super(trackGroup, new int[]{i6}, i10);
        this.reason = i11;
        this.data = obj;
    }

    @Override
    public void updateSelectedTrack(long j10, long j11, long j12, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
    }
}
