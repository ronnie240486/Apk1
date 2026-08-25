package androidx.media3.exoplayer.text;

import androidx.media3.common.C0565C;
import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.text.CuesWithTiming;
import java.util.ArrayList;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;

final class ReplacingCuesResolver implements CuesResolver {
    private final ArrayList<CuesWithTiming> cuesWithTimingList = new ArrayList<>();

    private int getIndexOfCuesStartingAfter(long j10) {
        for (int i6 = 0; i6 < this.cuesWithTimingList.size(); i6++) {
            if (j10 < this.cuesWithTimingList.get(i6).startTimeUs) {
                return i6;
            }
        }
        return this.cuesWithTimingList.size();
    }

    @Override
    public boolean addCues(CuesWithTiming cuesWithTiming, long j10) {
        boolean z7;
        Assertions.checkArgument(cuesWithTiming.startTimeUs != C0565C.TIME_UNSET);
        if (cuesWithTiming.startTimeUs <= j10) {
            long j11 = cuesWithTiming.endTimeUs;
            if (j11 == C0565C.TIME_UNSET || j10 < j11) {
                z7 = true;
            } else {
                z7 = false;
            }
        } else {
            z7 = false;
        }
        for (int size = this.cuesWithTimingList.size() - 1; size >= 0; size--) {
            if (cuesWithTiming.startTimeUs >= this.cuesWithTimingList.get(size).startTimeUs) {
                this.cuesWithTimingList.add(size + 1, cuesWithTiming);
                return z7;
            }
            if (this.cuesWithTimingList.get(size).startTimeUs <= j10) {
                z7 = false;
            }
        }
        this.cuesWithTimingList.add(0, cuesWithTiming);
        return z7;
    }

    @Override
    public void clear() {
        this.cuesWithTimingList.clear();
    }

    @Override
    public void discardCuesBeforeTimeUs(long j10) {
        int indexOfCuesStartingAfter = getIndexOfCuesStartingAfter(j10);
        if (indexOfCuesStartingAfter == 0) {
            return;
        }
        long j11 = this.cuesWithTimingList.get(indexOfCuesStartingAfter - 1).endTimeUs;
        if (j11 == C0565C.TIME_UNSET || j11 >= j10) {
            indexOfCuesStartingAfter--;
        }
        this.cuesWithTimingList.subList(0, indexOfCuesStartingAfter).clear();
    }

    @Override
    public AbstractC2301u1 getCuesAtTimeUs(long j10) {
        int indexOfCuesStartingAfter = getIndexOfCuesStartingAfter(j10);
        if (indexOfCuesStartingAfter == 0) {
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            return C2180c5.f7862e;
        }
        CuesWithTiming cuesWithTiming = this.cuesWithTimingList.get(indexOfCuesStartingAfter - 1);
        long j11 = cuesWithTiming.endTimeUs;
        if (j11 == C0565C.TIME_UNSET || j10 < j11) {
            return cuesWithTiming.cues;
        }
        C2204g1 c2204g2 = AbstractC2301u1.f8069b;
        return C2180c5.f7862e;
    }

    @Override
    public long getNextCueChangeTimeUs(long j10) {
        if (this.cuesWithTimingList.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j10 < this.cuesWithTimingList.get(0).startTimeUs) {
            return this.cuesWithTimingList.get(0).startTimeUs;
        }
        for (int i6 = 1; i6 < this.cuesWithTimingList.size(); i6++) {
            CuesWithTiming cuesWithTiming = this.cuesWithTimingList.get(i6);
            if (j10 < cuesWithTiming.startTimeUs) {
                long j11 = this.cuesWithTimingList.get(i6 - 1).endTimeUs;
                return (j11 == C0565C.TIME_UNSET || j11 <= j10 || j11 >= cuesWithTiming.startTimeUs) ? cuesWithTiming.startTimeUs : j11;
            }
        }
        long j12 = ((CuesWithTiming) AbstractC2182d0.m5151n(this.cuesWithTimingList)).endTimeUs;
        if (j12 == C0565C.TIME_UNSET || j10 >= j12) {
            return Long.MIN_VALUE;
        }
        return j12;
    }

    @Override
    public long getPreviousCueChangeTimeUs(long j10) {
        if (this.cuesWithTimingList.isEmpty() || j10 < this.cuesWithTimingList.get(0).startTimeUs) {
            return C0565C.TIME_UNSET;
        }
        for (int i6 = 1; i6 < this.cuesWithTimingList.size(); i6++) {
            long j11 = this.cuesWithTimingList.get(i6).startTimeUs;
            if (j10 == j11) {
                return j11;
            }
            if (j10 < j11) {
                CuesWithTiming cuesWithTiming = this.cuesWithTimingList.get(i6 - 1);
                long j12 = cuesWithTiming.endTimeUs;
                return (j12 == C0565C.TIME_UNSET || j12 > j10) ? cuesWithTiming.startTimeUs : j12;
            }
        }
        CuesWithTiming cuesWithTiming2 = (CuesWithTiming) AbstractC2182d0.m5151n(this.cuesWithTimingList);
        long j13 = cuesWithTiming2.endTimeUs;
        return (j13 == C0565C.TIME_UNSET || j10 < j13) ? cuesWithTiming2.startTimeUs : j13;
    }
}
