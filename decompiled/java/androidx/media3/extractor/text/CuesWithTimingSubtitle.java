package androidx.media3.extractor.text;

import androidx.media3.common.C0565C;
import androidx.media3.common.C0596g;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p041d7.AbstractC2173b5;
import p041d7.AbstractC2301u1;
import p041d7.C2166a5;
import p041d7.C2175c0;
import p041d7.C2180c5;

@UnstableApi
public final class CuesWithTimingSubtitle implements Subtitle {
    private static final AbstractC2173b5 CUES_BY_START_TIME_ASCENDING;
    private static final String TAG = "CuesWithTimingSubtitle";
    private final AbstractC2301u1 eventCues;
    private final long[] eventTimesUs;

    static {
        C2166a5 c2166a5 = C2166a5.f7831a;
        C0596g c0596g = new C0596g(18);
        c2166a5.getClass();
        CUES_BY_START_TIME_ASCENDING = new C2175c0(c0596g, c2166a5);
    }

    public CuesWithTimingSubtitle(List<CuesWithTiming> list) {
        int i6 = 0;
        if (list.size() == 1) {
            Iterator<T> it = list.iterator();
            Object next = it.next();
            if (!it.hasNext()) {
                CuesWithTiming cuesWithTiming = (CuesWithTiming) next;
                long jNormalizeUnsetStartTimeToZero = normalizeUnsetStartTimeToZero(cuesWithTiming.startTimeUs);
                if (cuesWithTiming.durationUs == C0565C.TIME_UNSET) {
                    this.eventCues = AbstractC2301u1.m5275r(cuesWithTiming.cues);
                    this.eventTimesUs = new long[]{jNormalizeUnsetStartTimeToZero};
                    return;
                } else {
                    this.eventCues = AbstractC2301u1.m5276s(cuesWithTiming.cues, AbstractC2301u1.m5274q());
                    this.eventTimesUs = new long[]{jNormalizeUnsetStartTimeToZero, cuesWithTiming.durationUs + jNormalizeUnsetStartTimeToZero};
                    return;
                }
            }
            StringBuilder sb = new StringBuilder("expected one element but was: <");
            sb.append(next);
            while (i6 < 4 && it.hasNext()) {
                sb.append(", ");
                sb.append(it.next());
                i6++;
            }
            if (it.hasNext()) {
                sb.append(", ...");
            }
            sb.append('>');
            throw new IllegalArgumentException(sb.toString());
        }
        long[] jArr = new long[list.size() * 2];
        this.eventTimesUs = jArr;
        Arrays.fill(jArr, Long.MAX_VALUE);
        ArrayList arrayList = new ArrayList();
        C2180c5 c2180c5M5279v = AbstractC2301u1.m5279v(CUES_BY_START_TIME_ASCENDING, list);
        int i10 = 0;
        while (i6 < c2180c5M5279v.size()) {
            CuesWithTiming cuesWithTiming2 = (CuesWithTiming) c2180c5M5279v.get(i6);
            long jNormalizeUnsetStartTimeToZero2 = normalizeUnsetStartTimeToZero(cuesWithTiming2.startTimeUs);
            long j10 = cuesWithTiming2.durationUs + jNormalizeUnsetStartTimeToZero2;
            if (i10 != 0) {
                int i11 = i10 - 1;
                long j11 = this.eventTimesUs[i11];
                if (j11 < jNormalizeUnsetStartTimeToZero2) {
                    this.eventTimesUs[i10] = jNormalizeUnsetStartTimeToZero2;
                    arrayList.add(cuesWithTiming2.cues);
                    i10++;
                } else if (j11 == jNormalizeUnsetStartTimeToZero2 && ((AbstractC2301u1) arrayList.get(i11)).isEmpty()) {
                    arrayList.set(i11, cuesWithTiming2.cues);
                } else {
                    Log.m1719w(TAG, "Truncating unsupported overlapping cues.");
                    this.eventTimesUs[i11] = jNormalizeUnsetStartTimeToZero2;
                    arrayList.set(i11, cuesWithTiming2.cues);
                }
            } else {
                this.eventTimesUs[i10] = jNormalizeUnsetStartTimeToZero2;
                arrayList.add(cuesWithTiming2.cues);
                i10++;
            }
            if (cuesWithTiming2.durationUs != C0565C.TIME_UNSET) {
                this.eventTimesUs[i10] = j10;
                arrayList.add(AbstractC2301u1.m5274q());
                i10++;
            }
            i6++;
        }
        this.eventCues = AbstractC2301u1.m5272n(arrayList);
    }

    public static Comparable lambda$static$0(CuesWithTiming cuesWithTiming) {
        return Long.valueOf(normalizeUnsetStartTimeToZero(cuesWithTiming.startTimeUs));
    }

    private static long normalizeUnsetStartTimeToZero(long j10) {
        if (j10 == C0565C.TIME_UNSET) {
            return 0L;
        }
        return j10;
    }

    @Override
    public long getEventTime(int i6) {
        Assertions.checkArgument(i6 < this.eventCues.size());
        return this.eventTimesUs[i6];
    }

    @Override
    public int getEventTimeCount() {
        return this.eventCues.size();
    }

    @Override
    public int getNextEventTimeIndex(long j10) {
        int iBinarySearchCeil = Util.binarySearchCeil(this.eventTimesUs, j10, false, false);
        if (iBinarySearchCeil < this.eventCues.size()) {
            return iBinarySearchCeil;
        }
        return -1;
    }

    @Override
    public AbstractC2301u1 getCues(long j10) {
        int iBinarySearchFloor = Util.binarySearchFloor(this.eventTimesUs, j10, true, false);
        return iBinarySearchFloor == -1 ? AbstractC2301u1.m5274q() : (AbstractC2301u1) this.eventCues.get(iBinarySearchFloor);
    }
}
