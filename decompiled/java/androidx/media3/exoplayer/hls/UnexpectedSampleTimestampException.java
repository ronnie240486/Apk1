package androidx.media3.exoplayer.hls;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import java.io.IOException;
import p000a.AbstractC0004e;

final class UnexpectedSampleTimestampException extends IOException {
    public final long lastAcceptedSampleTimeUs;
    public final MediaChunk mediaChunk;
    public final long rejectedSampleTimeUs;

    public UnexpectedSampleTimestampException(MediaChunk mediaChunk, long j10, long j11) {
        StringBuilder sb = new StringBuilder("Unexpected sample timestamp: ");
        sb.append(Util.usToMs(j11));
        sb.append(" in chunk [");
        sb.append(mediaChunk.startTimeUs);
        sb.append(", ");
        super(AbstractC0004e.m25s(sb, mediaChunk.endTimeUs, "]"));
        this.mediaChunk = mediaChunk;
        this.lastAcceptedSampleTimeUs = j10;
        this.rejectedSampleTimeUs = j11;
    }
}
