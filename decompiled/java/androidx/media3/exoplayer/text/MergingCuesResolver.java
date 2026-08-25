package androidx.media3.exoplayer.text;

import androidx.media3.common.C0565C;
import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.text.CuesWithTiming;
import java.util.ArrayList;
import java.util.List;
import p020b7.InterfaceC1346i;
import p041d7.AbstractC2173b5;
import p041d7.AbstractC2301u1;
import p041d7.C2166a5;
import p041d7.C2175c0;
import p041d7.C2180c5;
import p041d7.C2229j5;
import p041d7.C2266p0;
import p041d7.C2288s1;

final class MergingCuesResolver implements CuesResolver {
    private static final AbstractC2173b5 CUES_DISPLAY_PRIORITY_COMPARATOR;
    private final List<CuesWithTiming> cuesWithTimingList = new ArrayList();

    static {
        C2166a5 c2166a5 = C2166a5.f7831a;
        final int i6 = 0;
        InterfaceC1346i interfaceC1346i = new InterfaceC1346i() {
            @Override
            public final Object apply(Object obj) {
                CuesWithTiming cuesWithTiming = (CuesWithTiming) obj;
                switch (i6) {
                    case 0:
                        return MergingCuesResolver.lambda$static$0(cuesWithTiming);
                    default:
                        return MergingCuesResolver.lambda$static$1(cuesWithTiming);
                }
            }
        };
        c2166a5.getClass();
        C2175c0 c2175c0 = new C2175c0(interfaceC1346i, c2166a5);
        C2229j5 c2229j5 = C2229j5.f7960a;
        final int i10 = 1;
        InterfaceC1346i interfaceC1346i2 = new InterfaceC1346i() {
            @Override
            public final Object apply(Object obj) {
                CuesWithTiming cuesWithTiming = (CuesWithTiming) obj;
                switch (i10) {
                    case 0:
                        return MergingCuesResolver.lambda$static$0(cuesWithTiming);
                    default:
                        return MergingCuesResolver.lambda$static$1(cuesWithTiming);
                }
            }
        };
        c2229j5.getClass();
        CUES_DISPLAY_PRIORITY_COMPARATOR = new C2266p0(c2175c0, new C2175c0(interfaceC1346i2, c2229j5));
    }

    public static Long lambda$static$0(CuesWithTiming cuesWithTiming) {
        return Long.valueOf(cuesWithTiming.startTimeUs);
    }

    public static Long lambda$static$1(CuesWithTiming cuesWithTiming) {
        return Long.valueOf(cuesWithTiming.durationUs);
    }

    @Override
    public boolean addCues(CuesWithTiming cuesWithTiming, long j10) {
        Assertions.checkArgument(cuesWithTiming.startTimeUs != C0565C.TIME_UNSET);
        Assertions.checkArgument(cuesWithTiming.durationUs != C0565C.TIME_UNSET);
        boolean z7 = cuesWithTiming.startTimeUs <= j10 && j10 < cuesWithTiming.endTimeUs;
        for (int size = this.cuesWithTimingList.size() - 1; size >= 0; size--) {
            if (cuesWithTiming.startTimeUs >= this.cuesWithTimingList.get(size).startTimeUs) {
                this.cuesWithTimingList.add(size + 1, cuesWithTiming);
                return z7;
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
        int i6 = 0;
        while (i6 < this.cuesWithTimingList.size()) {
            long j11 = this.cuesWithTimingList.get(i6).startTimeUs;
            if (j10 > j11 && j10 > this.cuesWithTimingList.get(i6).endTimeUs) {
                this.cuesWithTimingList.remove(i6);
                i6--;
            } else if (j10 < j11) {
                return;
            }
            i6++;
        }
    }

    @Override
    public AbstractC2301u1 getCuesAtTimeUs(long j10) {
        if (!this.cuesWithTimingList.isEmpty()) {
            if (j10 >= this.cuesWithTimingList.get(0).startTimeUs) {
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < this.cuesWithTimingList.size(); i6++) {
                    CuesWithTiming cuesWithTiming = this.cuesWithTimingList.get(i6);
                    if (j10 >= cuesWithTiming.startTimeUs && j10 < cuesWithTiming.endTimeUs) {
                        arrayList.add(cuesWithTiming);
                    }
                    if (j10 < cuesWithTiming.startTimeUs) {
                        break;
                    }
                }
                C2180c5 c2180c5M5279v = AbstractC2301u1.m5279v(CUES_DISPLAY_PRIORITY_COMPARATOR, arrayList);
                C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
                for (int i10 = 0; i10 < c2180c5M5279v.size(); i10++) {
                    c2288s1M5269k.m5257d(((CuesWithTiming) c2180c5M5279v.get(i10)).cues);
                }
                return c2288s1M5269k.m5262g();
            }
        }
        return AbstractC2301u1.m5274q();
    }

    @Override
    public long getNextCueChangeTimeUs(long j10) {
        long jMin = -9223372036854775807L;
        for (int i6 = 0; i6 < this.cuesWithTimingList.size(); i6++) {
            long j11 = this.cuesWithTimingList.get(i6).startTimeUs;
            long j12 = this.cuesWithTimingList.get(i6).endTimeUs;
            if (j10 < j11) {
                if (jMin != C0565C.TIME_UNSET) {
                    jMin = Math.min(jMin, j11);
                    break;
                }
                jMin = j11;
                break;
            }
            if (j10 < j12) {
                jMin = jMin == C0565C.TIME_UNSET ? j12 : Math.min(jMin, j12);
            }
        }
        if (jMin != C0565C.TIME_UNSET) {
            return jMin;
        }
        return Long.MIN_VALUE;
    }

    @Override
    public long getPreviousCueChangeTimeUs(long j10) {
        if (this.cuesWithTimingList.isEmpty()) {
            return C0565C.TIME_UNSET;
        }
        if (j10 < this.cuesWithTimingList.get(0).startTimeUs) {
            return C0565C.TIME_UNSET;
        }
        long jMax = this.cuesWithTimingList.get(0).startTimeUs;
        for (int i6 = 0; i6 < this.cuesWithTimingList.size(); i6++) {
            long j11 = this.cuesWithTimingList.get(i6).startTimeUs;
            long j12 = this.cuesWithTimingList.get(i6).endTimeUs;
            if (j12 > j10) {
                if (j11 > j10) {
                    break;
                }
                jMax = Math.max(jMax, j11);
            } else {
                jMax = Math.max(jMax, j12);
            }
        }
        return jMax;
    }
}
