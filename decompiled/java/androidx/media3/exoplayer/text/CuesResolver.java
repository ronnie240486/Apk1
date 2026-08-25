package androidx.media3.exoplayer.text;

import androidx.media3.extractor.text.CuesWithTiming;
import p041d7.AbstractC2301u1;

interface CuesResolver {
    boolean addCues(CuesWithTiming cuesWithTiming, long j10);

    void clear();

    void discardCuesBeforeTimeUs(long j10);

    AbstractC2301u1 getCuesAtTimeUs(long j10);

    long getNextCueChangeTimeUs(long j10);

    long getPreviousCueChangeTimeUs(long j10);
}
