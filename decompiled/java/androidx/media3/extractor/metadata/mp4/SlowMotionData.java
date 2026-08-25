package androidx.media3.extractor.metadata.mp4;

import androidx.media3.common.AbstractC0600i;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.cache.C0646c;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import p041d7.AbstractC2259o0;

@UnstableApi
public final class SlowMotionData implements Metadata.Entry {
    public final List<Segment> segments;

    public static final class Segment {
        public static final Comparator<Segment> BY_START_THEN_END_THEN_DIVISOR = new C0646c(1);
        public final long endTimeMs;
        public final int speedDivisor;
        public final long startTimeMs;

        public Segment(long j10, long j11, int i6) {
            Assertions.checkArgument(j10 < j11);
            this.startTimeMs = j10;
            this.endTimeMs = j11;
            this.speedDivisor = i6;
        }

        public static int lambda$static$0(Segment segment, Segment segment2) {
            return AbstractC2259o0.f8011a.mo5245b(segment.startTimeMs, segment2.startTimeMs).mo5245b(segment.endTimeMs, segment2.endTimeMs).mo5244a(segment.speedDivisor, segment2.speedDivisor).mo5249f();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Segment.class != obj.getClass()) {
                return false;
            }
            Segment segment = (Segment) obj;
            return this.startTimeMs == segment.startTimeMs && this.endTimeMs == segment.endTimeMs && this.speedDivisor == segment.speedDivisor;
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.startTimeMs), Long.valueOf(this.endTimeMs), Integer.valueOf(this.speedDivisor));
        }

        public String toString() {
            return Util.formatInvariant("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.startTimeMs), Long.valueOf(this.endTimeMs), Integer.valueOf(this.speedDivisor));
        }
    }

    public SlowMotionData(List<Segment> list) {
        this.segments = list;
        Assertions.checkArgument(!doSegmentsOverlap(list));
    }

    private static boolean doSegmentsOverlap(List<Segment> list) {
        if (list.isEmpty()) {
            return false;
        }
        long j10 = list.get(0).endTimeMs;
        for (int i6 = 1; i6 < list.size(); i6++) {
            if (list.get(i6).startTimeMs < j10) {
                return true;
            }
            j10 = list.get(i6).endTimeMs;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SlowMotionData.class != obj.getClass()) {
            return false;
        }
        return this.segments.equals(((SlowMotionData) obj).segments);
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
        return this.segments.hashCode();
    }

    @Override
    public final void populateMediaMetadata(MediaMetadata.Builder builder) {
        AbstractC0600i.m1664c(this, builder);
    }

    public String toString() {
        return "SlowMotion: segments=" + this.segments;
    }
}
