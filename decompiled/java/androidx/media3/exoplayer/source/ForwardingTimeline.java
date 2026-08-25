package androidx.media3.exoplayer.source;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public abstract class ForwardingTimeline extends Timeline {
    protected final Timeline timeline;

    public ForwardingTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int getFirstWindowIndex(boolean z7) {
        return this.timeline.getFirstWindowIndex(z7);
    }

    @Override
    public int getIndexOfPeriod(Object obj) {
        return this.timeline.getIndexOfPeriod(obj);
    }

    @Override
    public int getLastWindowIndex(boolean z7) {
        return this.timeline.getLastWindowIndex(z7);
    }

    @Override
    public int getNextWindowIndex(int i6, int i10, boolean z7) {
        return this.timeline.getNextWindowIndex(i6, i10, z7);
    }

    @Override
    public Timeline.Period getPeriod(int i6, Timeline.Period period, boolean z7) {
        return this.timeline.getPeriod(i6, period, z7);
    }

    @Override
    public final Timeline.Period getPeriodByUid(Object obj, Timeline.Period period) {
        return super.getPeriodByUid(obj, period);
    }

    @Override
    public int getPeriodCount() {
        return this.timeline.getPeriodCount();
    }

    @Override
    public int getPreviousWindowIndex(int i6, int i10, boolean z7) {
        return this.timeline.getPreviousWindowIndex(i6, i10, z7);
    }

    @Override
    public Object getUidOfPeriod(int i6) {
        return this.timeline.getUidOfPeriod(i6);
    }

    @Override
    public Timeline.Window getWindow(int i6, Timeline.Window window, long j10) {
        return this.timeline.getWindow(i6, window, j10);
    }

    @Override
    public int getWindowCount() {
        return this.timeline.getWindowCount();
    }

    @Override
    public final int hashCode() {
        return super.hashCode();
    }
}
