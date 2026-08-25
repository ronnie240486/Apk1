package androidx.media3.exoplayer.source;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import androidx.media3.common.C0565C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.upstream.Allocator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import p041d7.AbstractC2301u1;
import p041d7.C2288s1;

@UnstableApi
public final class ConcatenatingMediaSource2 extends CompositeMediaSource<Integer> {
    private static final int MSG_UPDATE_TIMELINE = 1;
    private MediaItem mediaItem;
    private final IdentityHashMap<MediaPeriod, MediaSourceHolder> mediaSourceByMediaPeriod;
    private final AbstractC2301u1 mediaSourceHolders;
    private Handler playbackThreadHandler;
    private boolean timelineUpdateScheduled;

    public static final class Builder {
        private int index;
        private MediaItem mediaItem;
        private MediaSource.Factory mediaSourceFactory;
        private final C2288s1 mediaSourceHoldersBuilder = AbstractC2301u1.m5269k();

        public Builder add(MediaItem mediaItem) {
            return add(mediaItem, C0565C.TIME_UNSET);
        }

        public ConcatenatingMediaSource2 build() {
            Assertions.checkArgument(this.index > 0, "Must add at least one source to the concatenation.");
            if (this.mediaItem == null) {
                this.mediaItem = MediaItem.fromUri(Uri.EMPTY);
            }
            return new ConcatenatingMediaSource2(this.mediaItem, this.mediaSourceHoldersBuilder.m5262g());
        }

        public Builder setMediaItem(MediaItem mediaItem) {
            this.mediaItem = mediaItem;
            return this;
        }

        public Builder setMediaSourceFactory(MediaSource.Factory factory) {
            this.mediaSourceFactory = (MediaSource.Factory) Assertions.checkNotNull(factory);
            return this;
        }

        public Builder useDefaultMediaSourceFactory(Context context) {
            return setMediaSourceFactory(new DefaultMediaSourceFactory(context));
        }

        public Builder add(MediaItem mediaItem, long j10) {
            Assertions.checkNotNull(mediaItem);
            if (j10 == C0565C.TIME_UNSET) {
                MediaItem.ClippingConfiguration clippingConfiguration = mediaItem.clippingConfiguration;
                if (clippingConfiguration.endPositionMs != Long.MIN_VALUE) {
                    j10 = Util.usToMs(clippingConfiguration.endPositionUs - clippingConfiguration.startPositionUs);
                }
            }
            Assertions.checkStateNotNull(this.mediaSourceFactory, "Must use useDefaultMediaSourceFactory or setMediaSourceFactory first.");
            return add(this.mediaSourceFactory.createMediaSource(mediaItem), j10);
        }

        public Builder add(MediaSource mediaSource) {
            return add(mediaSource, C0565C.TIME_UNSET);
        }

        public Builder add(MediaSource mediaSource, long j10) {
            Assertions.checkNotNull(mediaSource);
            Assertions.checkState(((mediaSource instanceof ProgressiveMediaSource) && j10 == C0565C.TIME_UNSET) ? false : true, "Progressive media source must define an initial placeholder duration.");
            C2288s1 c2288s1 = this.mediaSourceHoldersBuilder;
            int i6 = this.index;
            this.index = i6 + 1;
            c2288s1.m5255a(new MediaSourceHolder(mediaSource, i6, Util.msToUs(j10)));
            return this;
        }
    }

    public static final class ConcatenatedTimeline extends Timeline {
        private final long defaultPositionUs;
        private final long durationUs;
        private final AbstractC2301u1 firstPeriodIndices;
        private final boolean isDynamic;
        private final boolean isSeekable;
        private final Object manifest;
        private final MediaItem mediaItem;
        private final AbstractC2301u1 periodOffsetsInWindowUs;
        private final AbstractC2301u1 timelines;

        public ConcatenatedTimeline(MediaItem mediaItem, AbstractC2301u1 abstractC2301u1, AbstractC2301u1 abstractC2301u2, AbstractC2301u1 abstractC2301u3, boolean z7, boolean z10, long j10, long j11, Object obj) {
            this.mediaItem = mediaItem;
            this.timelines = abstractC2301u1;
            this.firstPeriodIndices = abstractC2301u2;
            this.periodOffsetsInWindowUs = abstractC2301u3;
            this.isSeekable = z7;
            this.isDynamic = z10;
            this.durationUs = j10;
            this.defaultPositionUs = j11;
            this.manifest = obj;
        }

        private int getChildIndexByPeriodIndex(int i6) {
            return Util.binarySearchFloor((List<? extends Comparable<? super Integer>>) this.firstPeriodIndices, Integer.valueOf(i6 + 1), false, false);
        }

        private long getPeriodDurationUs(Timeline.Period period, int i6) {
            if (period.durationUs == C0565C.TIME_UNSET) {
                return C0565C.TIME_UNSET;
            }
            return (i6 == this.periodOffsetsInWindowUs.size() + (-1) ? this.durationUs : ((Long) this.periodOffsetsInWindowUs.get(i6 + 1)).longValue()) - ((Long) this.periodOffsetsInWindowUs.get(i6)).longValue();
        }

        @Override
        public int getIndexOfPeriod(Object obj) {
            if (!(obj instanceof Pair) || !(((Pair) obj).first instanceof Integer)) {
                return -1;
            }
            int childIndex = ConcatenatingMediaSource2.getChildIndex(obj);
            int indexOfPeriod = ((Timeline) this.timelines.get(childIndex)).getIndexOfPeriod(ConcatenatingMediaSource2.getChildPeriodUid(obj));
            if (indexOfPeriod == -1) {
                return -1;
            }
            return ((Integer) this.firstPeriodIndices.get(childIndex)).intValue() + indexOfPeriod;
        }

        @Override
        public Timeline.Period getPeriod(int i6, Timeline.Period period, boolean z7) {
            int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i6);
            ((Timeline) this.timelines.get(childIndexByPeriodIndex)).getPeriod(i6 - ((Integer) this.firstPeriodIndices.get(childIndexByPeriodIndex)).intValue(), period, z7);
            period.windowIndex = 0;
            period.positionInWindowUs = ((Long) this.periodOffsetsInWindowUs.get(i6)).longValue();
            period.durationUs = getPeriodDurationUs(period, i6);
            if (z7) {
                period.uid = ConcatenatingMediaSource2.getPeriodUid(childIndexByPeriodIndex, Assertions.checkNotNull(period.uid));
            }
            return period;
        }

        @Override
        public Timeline.Period getPeriodByUid(Object obj, Timeline.Period period) {
            int childIndex = ConcatenatingMediaSource2.getChildIndex(obj);
            Object childPeriodUid = ConcatenatingMediaSource2.getChildPeriodUid(obj);
            Timeline timeline = (Timeline) this.timelines.get(childIndex);
            int indexOfPeriod = timeline.getIndexOfPeriod(childPeriodUid) + ((Integer) this.firstPeriodIndices.get(childIndex)).intValue();
            timeline.getPeriodByUid(childPeriodUid, period);
            period.windowIndex = 0;
            period.positionInWindowUs = ((Long) this.periodOffsetsInWindowUs.get(indexOfPeriod)).longValue();
            period.durationUs = getPeriodDurationUs(period, indexOfPeriod);
            period.uid = obj;
            return period;
        }

        @Override
        public int getPeriodCount() {
            return this.periodOffsetsInWindowUs.size();
        }

        @Override
        public Object getUidOfPeriod(int i6) {
            int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i6);
            return ConcatenatingMediaSource2.getPeriodUid(childIndexByPeriodIndex, ((Timeline) this.timelines.get(childIndexByPeriodIndex)).getUidOfPeriod(i6 - ((Integer) this.firstPeriodIndices.get(childIndexByPeriodIndex)).intValue()));
        }

        @Override
        public Timeline.Window getWindow(int i6, Timeline.Window window, long j10) {
            return window.set(Timeline.Window.SINGLE_WINDOW_UID, this.mediaItem, this.manifest, C0565C.TIME_UNSET, C0565C.TIME_UNSET, C0565C.TIME_UNSET, this.isSeekable, this.isDynamic, null, this.defaultPositionUs, this.durationUs, 0, getPeriodCount() - 1, -((Long) this.periodOffsetsInWindowUs.get(0)).longValue());
        }

        @Override
        public int getWindowCount() {
            return 1;
        }
    }

    public static final class MediaSourceHolder {
        public int activeMediaPeriods;
        public final int index;
        public final long initialPlaceholderDurationUs;
        public final MaskingMediaSource mediaSource;
        public final HashMap<Object, Long> periodTimeOffsetsByUid = new HashMap<>();

        public MediaSourceHolder(MediaSource mediaSource, int i6, long j10) {
            this.mediaSource = new MaskingMediaSource(mediaSource, false);
            this.index = i6;
            this.initialPlaceholderDurationUs = j10;
        }
    }

    private void disableUnusedMediaSources() {
        for (int i6 = 0; i6 < this.mediaSourceHolders.size(); i6++) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.mediaSourceHolders.get(i6);
            if (mediaSourceHolder.activeMediaPeriods == 0) {
                disableChildSource(Integer.valueOf(mediaSourceHolder.index));
            }
        }
    }

    public static int getChildIndex(Object obj) {
        return ((Integer) ((Pair) obj).first).intValue();
    }

    private static int getChildIndexFromChildWindowSequenceNumber(long j10, int i6) {
        return (int) (j10 % ((long) i6));
    }

    public static Object getChildPeriodUid(Object obj) {
        return ((Pair) obj).second;
    }

    private static long getChildWindowSequenceNumber(long j10, int i6, int i10) {
        return (j10 * ((long) i6)) + ((long) i10);
    }

    public static Object getPeriodUid(int i6, Object obj) {
        return Pair.create(Integer.valueOf(i6), obj);
    }

    private static long getWindowSequenceNumberFromChildWindowSequenceNumber(long j10, int i6) {
        return j10 / ((long) i6);
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            updateTimeline();
        }
        return true;
    }

    private ConcatenatedTimeline maybeCreateConcatenatedTimeline() {
        Timeline timeline;
        long j10;
        Timeline.Period period;
        boolean z7;
        ConcatenatingMediaSource2 concatenatingMediaSource2 = this;
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period2 = new Timeline.Period();
        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
        C2288s1 c2288s1M5269k2 = AbstractC2301u1.m5269k();
        C2288s1 c2288s1M5269k3 = AbstractC2301u1.m5269k();
        int size = concatenatingMediaSource2.mediaSourceHolders.size();
        boolean z10 = true;
        int i6 = 0;
        boolean z11 = true;
        Object obj = null;
        int periodCount = 0;
        boolean z12 = false;
        boolean z13 = true;
        boolean z14 = false;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        while (i6 < size) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) concatenatingMediaSource2.mediaSourceHolders.get(i6);
            Timeline timeline2 = mediaSourceHolder.mediaSource.getTimeline();
            Assertions.checkArgument(timeline2.isEmpty() ^ z10, "Can't concatenate empty child Timeline.");
            c2288s1M5269k.m5256c(timeline2);
            c2288s1M5269k2.m5256c(Integer.valueOf(periodCount));
            periodCount += timeline2.getPeriodCount();
            int i10 = 0;
            while (i10 < timeline2.getWindowCount()) {
                timeline2.getWindow(i10, window);
                if (!z12) {
                    obj = window.manifest;
                    z12 = true;
                }
                boolean z15 = z11 && Objects.equals(obj, window.manifest);
                long j14 = window.durationUs;
                if (j14 == C0565C.TIME_UNSET) {
                    j14 = mediaSourceHolder.initialPlaceholderDurationUs;
                    if (j14 == C0565C.TIME_UNSET) {
                        return null;
                    }
                }
                j11 += j14;
                if (mediaSourceHolder.index == 0 && i10 == 0) {
                    j12 = window.defaultPositionUs;
                    j13 = -window.positionInFirstPeriodUs;
                }
                z13 &= window.isSeekable || window.isPlaceholder;
                z14 |= window.isDynamic;
                int i11 = window.firstPeriodIndex;
                while (i11 <= window.lastPeriodIndex) {
                    c2288s1M5269k3.m5256c(Long.valueOf(j13));
                    timeline2.getPeriod(i11, period2, true);
                    int i12 = periodCount;
                    long j15 = period2.durationUs;
                    if (j15 == C0565C.TIME_UNSET) {
                        Assertions.checkArgument(window.firstPeriodIndex == window.lastPeriodIndex, "Can't apply placeholder duration to multiple periods with unknown duration in a single window.");
                        j15 = window.positionInFirstPeriodUs + j14;
                    }
                    if (i11 != window.firstPeriodIndex || ((mediaSourceHolder.index == 0 && i10 == 0) || j15 == C0565C.TIME_UNSET)) {
                        timeline = timeline2;
                        j10 = 0;
                    } else {
                        Timeline timeline3 = timeline2;
                        j10 = -window.positionInFirstPeriodUs;
                        j15 += j10;
                        timeline = timeline3;
                    }
                    Object objCheckNotNull = Assertions.checkNotNull(period2.uid);
                    Timeline.Window window2 = window;
                    if (mediaSourceHolder.activeMediaPeriods == 0 || !mediaSourceHolder.periodTimeOffsetsByUid.containsKey(objCheckNotNull)) {
                        period = period2;
                    } else {
                        period = period2;
                        if (!mediaSourceHolder.periodTimeOffsetsByUid.get(objCheckNotNull).equals(Long.valueOf(j10))) {
                            z7 = false;
                        }
                        Assertions.checkArgument(z7, "Can't handle windows with changing offset in first period.");
                        mediaSourceHolder.periodTimeOffsetsByUid.put(objCheckNotNull, Long.valueOf(j10));
                        j13 += j15;
                        i11++;
                        periodCount = i12;
                        obj = obj;
                        timeline2 = timeline;
                        window = window2;
                        period2 = period;
                    }
                    z7 = true;
                    Assertions.checkArgument(z7, "Can't handle windows with changing offset in first period.");
                    mediaSourceHolder.periodTimeOffsetsByUid.put(objCheckNotNull, Long.valueOf(j10));
                    j13 += j15;
                    i11++;
                    periodCount = i12;
                    obj = obj;
                    timeline2 = timeline;
                    window = window2;
                    period2 = period;
                }
                i10++;
                i6 = i6;
                z11 = z15;
                obj = obj;
            }
            i6++;
            z10 = true;
            concatenatingMediaSource2 = this;
        }
        return new ConcatenatedTimeline(getMediaItem(), c2288s1M5269k.m5262g(), c2288s1M5269k2.m5262g(), c2288s1M5269k3.m5262g(), z13, z14, j11, j12, z11 ? obj : null);
    }

    private void scheduleTimelineUpdate() {
        if (this.timelineUpdateScheduled) {
            return;
        }
        ((Handler) Assertions.checkNotNull(this.playbackThreadHandler)).obtainMessage(1).sendToTarget();
        this.timelineUpdateScheduled = true;
    }

    private void updateTimeline() {
        this.timelineUpdateScheduled = false;
        ConcatenatedTimeline concatenatedTimelineMaybeCreateConcatenatedTimeline = maybeCreateConcatenatedTimeline();
        if (concatenatedTimelineMaybeCreateConcatenatedTimeline != null) {
            refreshSourceInfo(concatenatedTimelineMaybeCreateConcatenatedTimeline);
        }
    }

    @Override
    public boolean canUpdateMediaItem(MediaItem mediaItem) {
        return true;
    }

    @Override
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j10) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.mediaSourceHolders.get(getChildIndex(mediaPeriodId.periodUid));
        MediaSource.MediaPeriodId mediaPeriodIdCopyWithWindowSequenceNumber = mediaPeriodId.copyWithPeriodUid(getChildPeriodUid(mediaPeriodId.periodUid)).copyWithWindowSequenceNumber(getChildWindowSequenceNumber(mediaPeriodId.windowSequenceNumber, this.mediaSourceHolders.size(), mediaSourceHolder.index));
        enableChildSource(Integer.valueOf(mediaSourceHolder.index));
        mediaSourceHolder.activeMediaPeriods++;
        long jLongValue = mediaPeriodId.isAd() ? 0L : ((Long) Assertions.checkNotNull(mediaSourceHolder.periodTimeOffsetsByUid.get(mediaPeriodIdCopyWithWindowSequenceNumber.periodUid))).longValue();
        TimeOffsetMediaPeriod timeOffsetMediaPeriod = new TimeOffsetMediaPeriod(mediaSourceHolder.mediaSource.createPeriod(mediaPeriodIdCopyWithWindowSequenceNumber, allocator, j10 - jLongValue), jLongValue);
        this.mediaSourceByMediaPeriod.put(timeOffsetMediaPeriod, mediaSourceHolder);
        disableUnusedMediaSources();
        return timeOffsetMediaPeriod;
    }

    @Override
    public Timeline getInitialTimeline() {
        return maybeCreateConcatenatedTimeline();
    }

    @Override
    public synchronized MediaItem getMediaItem() {
        return this.mediaItem;
    }

    @Override
    public int getWindowIndexForChildWindowIndex(Integer num, int i6) {
        return 0;
    }

    @Override
    public void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        this.playbackThreadHandler = new Handler(new C0899b(this, 1));
        for (int i6 = 0; i6 < this.mediaSourceHolders.size(); i6++) {
            prepareChildSource(Integer.valueOf(i6), ((MediaSourceHolder) this.mediaSourceHolders.get(i6)).mediaSource);
        }
        scheduleTimelineUpdate();
    }

    @Override
    public void releasePeriod(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.checkNotNull(this.mediaSourceByMediaPeriod.remove(mediaPeriod));
        mediaSourceHolder.mediaSource.releasePeriod(((TimeOffsetMediaPeriod) mediaPeriod).getWrappedMediaPeriod());
        mediaSourceHolder.activeMediaPeriods--;
        if (this.mediaSourceByMediaPeriod.isEmpty()) {
            return;
        }
        disableUnusedMediaSources();
    }

    @Override
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        Handler handler = this.playbackThreadHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.playbackThreadHandler = null;
        }
        this.timelineUpdateScheduled = false;
    }

    @Override
    public synchronized void updateMediaItem(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }

    private ConcatenatingMediaSource2(MediaItem mediaItem, AbstractC2301u1 abstractC2301u1) {
        this.mediaItem = mediaItem;
        this.mediaSourceHolders = abstractC2301u1;
        this.mediaSourceByMediaPeriod = new IdentityHashMap<>();
    }

    @Override
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() != getChildIndexFromChildWindowSequenceNumber(mediaPeriodId.windowSequenceNumber, this.mediaSourceHolders.size())) {
            return null;
        }
        return mediaPeriodId.copyWithPeriodUid(getPeriodUid(num.intValue(), mediaPeriodId.periodUid)).copyWithWindowSequenceNumber(getWindowSequenceNumberFromChildWindowSequenceNumber(mediaPeriodId.windowSequenceNumber, this.mediaSourceHolders.size()));
    }

    @Override
    public long getMediaTimeForChildMediaTime(Integer num, long j10, MediaSource.MediaPeriodId mediaPeriodId) {
        Long l9;
        return (j10 == C0565C.TIME_UNSET || mediaPeriodId == null || mediaPeriodId.isAd() || (l9 = ((MediaSourceHolder) this.mediaSourceHolders.get(num.intValue())).periodTimeOffsetsByUid.get(mediaPeriodId.periodUid)) == null) ? j10 : Util.usToMs(l9.longValue()) + j10;
    }

    @Override
    public void lambda$prepareChildSource$0(Integer num, MediaSource mediaSource, Timeline timeline) {
        scheduleTimelineUpdate();
    }

    @Override
    public void enableInternal() {
    }
}
