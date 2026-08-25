package androidx.media3.extractor.mp3;

import android.util.Pair;
import androidx.media3.common.C0565C;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.metadata.id3.MlltFrame;

final class MlltSeeker implements Seeker {
    private final long durationUs;
    private final long[] referencePositions;
    private final long[] referenceTimesMs;

    private MlltSeeker(long[] jArr, long[] jArr2, long j10) {
        this.referencePositions = jArr;
        this.referenceTimesMs = jArr2;
        this.durationUs = j10 == C0565C.TIME_UNSET ? Util.msToUs(jArr2[jArr2.length - 1]) : j10;
    }

    public static MlltSeeker create(long j10, MlltFrame mlltFrame, long j11) {
        int length = mlltFrame.bytesDeviations.length;
        int i6 = length + 1;
        long[] jArr = new long[i6];
        long[] jArr2 = new long[i6];
        jArr[0] = j10;
        long j12 = 0;
        jArr2[0] = 0;
        for (int i10 = 1; i10 <= length; i10++) {
            int i11 = i10 - 1;
            j10 += (long) (mlltFrame.bytesBetweenReference + mlltFrame.bytesDeviations[i11]);
            j12 += (long) (mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i11]);
            jArr[i10] = j10;
            jArr2[i10] = j12;
        }
        return new MlltSeeker(jArr, jArr2, j11);
    }

    private static Pair<Long, Long> linearlyInterpolate(long j10, long[] jArr, long[] jArr2) {
        int iBinarySearchFloor = Util.binarySearchFloor(jArr, j10, true, true);
        long j11 = jArr[iBinarySearchFloor];
        long j12 = jArr2[iBinarySearchFloor];
        int i6 = iBinarySearchFloor + 1;
        if (i6 == jArr.length) {
            return Pair.create(Long.valueOf(j11), Long.valueOf(j12));
        }
        long j13 = jArr[i6];
        return Pair.create(Long.valueOf(j10), Long.valueOf(((long) ((j13 == j11 ? 0.0d : (j10 - j11) / (j13 - j11)) * (jArr2[i6] - j12))) + j12));
    }

    @Override
    public int getAverageBitrate() {
        return C0565C.RATE_UNSET_INT;
    }

    @Override
    public long getDataEndPosition() {
        return -1L;
    }

    @Override
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override
    public SeekMap.SeekPoints getSeekPoints(long j10) {
        Pair<Long, Long> pairLinearlyInterpolate = linearlyInterpolate(Util.usToMs(Util.constrainValue(j10, 0L, this.durationUs)), this.referenceTimesMs, this.referencePositions);
        return new SeekMap.SeekPoints(new SeekPoint(Util.msToUs(((Long) pairLinearlyInterpolate.first).longValue()), ((Long) pairLinearlyInterpolate.second).longValue()));
    }

    @Override
    public long getTimeUs(long j10) {
        return Util.msToUs(((Long) linearlyInterpolate(j10, this.referencePositions, this.referenceTimesMs).second).longValue());
    }

    @Override
    public boolean isSeekable() {
        return true;
    }
}
