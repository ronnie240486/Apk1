package androidx.media3.container;

import androidx.media3.common.AbstractC0600i;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import p222u7.AbstractC3928d;

@UnstableApi
public final class Mp4TimestampData implements Metadata.Entry {
    public static final int TIMESCALE_UNSET = -1;
    private static final int UNIX_EPOCH_TO_MP4_TIME_DELTA_SECONDS = 2082844800;
    public final long creationTimestampSeconds;
    public final long modificationTimestampSeconds;
    public final long timescale;

    public Mp4TimestampData(long j10, long j11) {
        this.creationTimestampSeconds = j10;
        this.modificationTimestampSeconds = j11;
        this.timescale = -1L;
    }

    public static long unixTimeToMp4TimeSeconds(long j10) {
        return (j10 / 1000) + 2082844800;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mp4TimestampData)) {
            return false;
        }
        Mp4TimestampData mp4TimestampData = (Mp4TimestampData) obj;
        return this.creationTimestampSeconds == mp4TimestampData.creationTimestampSeconds && this.modificationTimestampSeconds == mp4TimestampData.modificationTimestampSeconds && this.timescale == mp4TimestampData.timescale;
    }

    @Override
    public final byte[] getWrappedMetadataBytes() {
        return AbstractC0600i.m1662a(this);
    }

    @Override
    public final Format getWrappedMetadataFormat() {
        return AbstractC0600i.m1663b(this);
    }

    public int hashCode() {
        return AbstractC3928d.m7854r(this.timescale) + ((AbstractC3928d.m7854r(this.modificationTimestampSeconds) + ((AbstractC3928d.m7854r(this.creationTimestampSeconds) + 527) * 31)) * 31);
    }

    @Override
    public final void populateMediaMetadata(MediaMetadata.Builder builder) {
        AbstractC0600i.m1664c(this, builder);
    }

    public String toString() {
        return "Mp4Timestamp: creation time=" + this.creationTimestampSeconds + ", modification time=" + this.modificationTimestampSeconds + ", timescale=" + this.timescale;
    }

    public Mp4TimestampData(long j10, long j11, long j12) {
        this.creationTimestampSeconds = j10;
        this.modificationTimestampSeconds = j11;
        this.timescale = j12;
    }
}
