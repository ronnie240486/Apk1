package androidx.media3.exoplayer.trackselection;

import android.os.SystemClock;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import java.util.Arrays;
import java.util.List;

@UnstableApi
public abstract class BaseTrackSelection implements ExoTrackSelection {
    private final long[] excludeUntilTimes;
    private final Format[] formats;
    protected final TrackGroup group;
    private int hashCode;
    protected final int length;
    private boolean playWhenReady;
    protected final int[] tracks;
    private final int type;

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        this(trackGroup, iArr, 0);
    }

    public static int lambda$new$0(Format format, Format format2) {
        return format2.bitrate - format.bitrate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
        return this.group.equals(baseTrackSelection.group) && Arrays.equals(this.tracks, baseTrackSelection.tracks);
    }

    @Override
    public int evaluateQueueSize(long j10, List<? extends MediaChunk> list) {
        return list.size();
    }

    @Override
    public boolean excludeTrack(int i6, long j10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zIsTrackExcluded = isTrackExcluded(i6, jElapsedRealtime);
        int i10 = 0;
        while (i10 < this.length && !zIsTrackExcluded) {
            zIsTrackExcluded = (i10 == i6 || isTrackExcluded(i10, jElapsedRealtime)) ? false : true;
            i10++;
        }
        if (!zIsTrackExcluded) {
            return false;
        }
        long[] jArr = this.excludeUntilTimes;
        jArr[i6] = Math.max(jArr[i6], Util.addWithOverflowDefault(jElapsedRealtime, j10, Long.MAX_VALUE));
        return true;
    }

    @Override
    public final Format getFormat(int i6) {
        return this.formats[i6];
    }

    @Override
    public final int getIndexInTrackGroup(int i6) {
        return this.tracks[i6];
    }

    @Override
    public long getLatestBitrateEstimate() {
        return AbstractC0944f.m2569a(this);
    }

    public final boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    @Override
    public final Format getSelectedFormat() {
        return this.formats[getSelectedIndex()];
    }

    @Override
    public final int getSelectedIndexInTrackGroup() {
        return this.tracks[getSelectedIndex()];
    }

    @Override
    public final TrackGroup getTrackGroup() {
        return this.group;
    }

    @Override
    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.tracks) + (System.identityHashCode(this.group) * 31);
        }
        return this.hashCode;
    }

    @Override
    public final int indexOf(Format format) {
        for (int i6 = 0; i6 < this.length; i6++) {
            if (this.formats[i6] == format) {
                return i6;
            }
        }
        return -1;
    }

    @Override
    public boolean isTrackExcluded(int i6, long j10) {
        return this.excludeUntilTimes[i6] > j10;
    }

    @Override
    public final int length() {
        return this.tracks.length;
    }

    @Override
    public final void onDiscontinuity() {
        AbstractC0944f.m2570b(this);
    }

    @Override
    public void onPlayWhenReadyChanged(boolean z7) {
        this.playWhenReady = z7;
    }

    @Override
    public final void onRebuffer() {
        AbstractC0944f.m2572d(this);
    }

    @Override
    public final boolean shouldCancelChunkLoad(long j10, Chunk chunk, List list) {
        return AbstractC0944f.m2573e(this, j10, chunk, list);
    }

    public BaseTrackSelection(TrackGroup trackGroup, int[] iArr, int i6) {
        Assertions.checkState(iArr.length > 0);
        this.type = i6;
        this.group = (TrackGroup) Assertions.checkNotNull(trackGroup);
        int length = iArr.length;
        this.length = length;
        this.formats = new Format[length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            this.formats[i10] = trackGroup.getFormat(iArr[i10]);
        }
        Arrays.sort(this.formats, new C0939a(6));
        this.tracks = new int[this.length];
        int i11 = 0;
        while (true) {
            int i12 = this.length;
            if (i11 >= i12) {
                this.excludeUntilTimes = new long[i12];
                this.playWhenReady = false;
                return;
            } else {
                this.tracks[i11] = trackGroup.indexOf(this.formats[i11]);
                i11++;
            }
        }
    }

    @Override
    public final int indexOf(int i6) {
        for (int i10 = 0; i10 < this.length; i10++) {
            if (this.tracks[i10] == i6) {
                return i10;
            }
        }
        return -1;
    }

    @Override
    public void disable() {
    }

    @Override
    public void enable() {
    }

    @Override
    public void onPlaybackSpeed(float f) {
    }
}
