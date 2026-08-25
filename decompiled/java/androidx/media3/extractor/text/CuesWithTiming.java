package androidx.media3.extractor.text;

import androidx.media3.common.C0565C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.UnstableApi;
import java.util.List;
import p041d7.AbstractC2301u1;

@UnstableApi
public class CuesWithTiming {
    public final AbstractC2301u1 cues;
    public final long durationUs;
    public final long endTimeUs;
    public final long startTimeUs;

    public CuesWithTiming(List<Cue> list, long j10, long j11) {
        this.cues = AbstractC2301u1.m5272n(list);
        this.startTimeUs = j10;
        this.durationUs = j11;
        long j12 = C0565C.TIME_UNSET;
        if (j10 != C0565C.TIME_UNSET && j11 != C0565C.TIME_UNSET) {
            j12 = j10 + j11;
        }
        this.endTimeUs = j12;
    }
}
