package androidx.media3.exoplayer.source.ads;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.C0565C;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.ForwardingTimeline;

@UnstableApi
public final class SinglePeriodAdTimeline extends ForwardingTimeline {
    private final AdPlaybackState adPlaybackState;

    public SinglePeriodAdTimeline(Timeline timeline, AdPlaybackState adPlaybackState) {
        super(timeline);
        Assertions.checkState(timeline.getPeriodCount() == 1);
        Assertions.checkState(timeline.getWindowCount() == 1);
        this.adPlaybackState = adPlaybackState;
    }

    @Override
    public Timeline.Period getPeriod(int i6, Timeline.Period period, boolean z7) {
        this.timeline.getPeriod(i6, period, z7);
        long j10 = period.durationUs;
        if (j10 == C0565C.TIME_UNSET) {
            j10 = this.adPlaybackState.contentDurationUs;
        }
        period.set(period.f2583id, period.uid, period.windowIndex, j10, period.getPositionInWindowUs(), this.adPlaybackState, period.isPlaceholder);
        return period;
    }
}
