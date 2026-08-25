package androidx.media3.exoplayer.source;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.AbstractConcatenatedTimeline;
import androidx.media3.exoplayer.upstream.Allocator;
import java.util.HashMap;
import java.util.Map;

@UnstableApi
@Deprecated
public final class LoopingMediaSource extends WrappingMediaSource {
    private final Map<MediaSource.MediaPeriodId, MediaSource.MediaPeriodId> childMediaPeriodIdToMediaPeriodId;
    private final int loopCount;
    private final Map<MediaPeriod, MediaSource.MediaPeriodId> mediaPeriodToChildMediaPeriodId;

    public static final class InfinitelyLoopingTimeline extends ForwardingTimeline {
        public InfinitelyLoopingTimeline(Timeline timeline) {
            super(timeline);
        }

        @Override
        public int getNextWindowIndex(int i6, int i10, boolean z7) {
            int nextWindowIndex = this.timeline.getNextWindowIndex(i6, i10, z7);
            return nextWindowIndex == -1 ? getFirstWindowIndex(z7) : nextWindowIndex;
        }

        @Override
        public int getPreviousWindowIndex(int i6, int i10, boolean z7) {
            int previousWindowIndex = this.timeline.getPreviousWindowIndex(i6, i10, z7);
            return previousWindowIndex == -1 ? getLastWindowIndex(z7) : previousWindowIndex;
        }
    }

    public static final class LoopingTimeline extends AbstractConcatenatedTimeline {
        private final int childPeriodCount;
        private final Timeline childTimeline;
        private final int childWindowCount;
        private final int loopCount;

        public LoopingTimeline(Timeline timeline, int i6) {
            super(false, new ShuffleOrder.UnshuffledShuffleOrder(i6));
            this.childTimeline = timeline;
            int periodCount = timeline.getPeriodCount();
            this.childPeriodCount = periodCount;
            this.childWindowCount = timeline.getWindowCount();
            this.loopCount = i6;
            if (periodCount > 0) {
                Assertions.checkState(i6 <= Integer.MAX_VALUE / periodCount, "LoopingMediaSource contains too many periods");
            }
        }

        @Override
        public int getChildIndexByChildUid(Object obj) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }

        @Override
        public int getChildIndexByPeriodIndex(int i6) {
            return i6 / this.childPeriodCount;
        }

        @Override
        public int getChildIndexByWindowIndex(int i6) {
            return i6 / this.childWindowCount;
        }

        @Override
        public Object getChildUidByChildIndex(int i6) {
            return Integer.valueOf(i6);
        }

        @Override
        public int getFirstPeriodIndexByChildIndex(int i6) {
            return i6 * this.childPeriodCount;
        }

        @Override
        public int getFirstWindowIndexByChildIndex(int i6) {
            return i6 * this.childWindowCount;
        }

        @Override
        public int getPeriodCount() {
            return this.childPeriodCount * this.loopCount;
        }

        @Override
        public Timeline getTimelineByChildIndex(int i6) {
            return this.childTimeline;
        }

        @Override
        public int getWindowCount() {
            return this.childWindowCount * this.loopCount;
        }
    }

    public LoopingMediaSource(MediaSource mediaSource) {
        this(mediaSource, Integer.MAX_VALUE);
    }

    @Override
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j10) {
        if (this.loopCount == Integer.MAX_VALUE) {
            return this.mediaSource.createPeriod(mediaPeriodId, allocator, j10);
        }
        MediaSource.MediaPeriodId mediaPeriodIdCopyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(mediaPeriodId.periodUid));
        this.childMediaPeriodIdToMediaPeriodId.put(mediaPeriodIdCopyWithPeriodUid, mediaPeriodId);
        MediaPeriod mediaPeriodCreatePeriod = this.mediaSource.createPeriod(mediaPeriodIdCopyWithPeriodUid, allocator, j10);
        this.mediaPeriodToChildMediaPeriodId.put(mediaPeriodCreatePeriod, mediaPeriodIdCopyWithPeriodUid);
        return mediaPeriodCreatePeriod;
    }

    @Override
    public Timeline getInitialTimeline() {
        MaskingMediaSource maskingMediaSource = (MaskingMediaSource) this.mediaSource;
        return this.loopCount != Integer.MAX_VALUE ? new LoopingTimeline(maskingMediaSource.getTimeline(), this.loopCount) : new InfinitelyLoopingTimeline(maskingMediaSource.getTimeline());
    }

    @Override
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.loopCount != Integer.MAX_VALUE ? this.childMediaPeriodIdToMediaPeriodId.get(mediaPeriodId) : mediaPeriodId;
    }

    @Override
    public boolean isSingleWindow() {
        return false;
    }

    @Override
    public void onChildSourceInfoRefreshed(Timeline timeline) {
        refreshSourceInfo(this.loopCount != Integer.MAX_VALUE ? new LoopingTimeline(timeline, this.loopCount) : new InfinitelyLoopingTimeline(timeline));
    }

    @Override
    public void releasePeriod(MediaPeriod mediaPeriod) {
        this.mediaSource.releasePeriod(mediaPeriod);
        MediaSource.MediaPeriodId mediaPeriodIdRemove = this.mediaPeriodToChildMediaPeriodId.remove(mediaPeriod);
        if (mediaPeriodIdRemove != null) {
            this.childMediaPeriodIdToMediaPeriodId.remove(mediaPeriodIdRemove);
        }
    }

    public LoopingMediaSource(MediaSource mediaSource, int i6) {
        super(new MaskingMediaSource(mediaSource, false));
        Assertions.checkArgument(i6 > 0);
        this.loopCount = i6;
        this.childMediaPeriodIdToMediaPeriodId = new HashMap();
        this.mediaPeriodToChildMediaPeriodId = new HashMap();
    }
}
