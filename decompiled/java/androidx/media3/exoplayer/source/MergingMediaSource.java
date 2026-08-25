package androidx.media3.exoplayer.source;

import androidx.media3.common.C0565C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p041d7.AbstractC2182d0;
import p041d7.C2217i0;
import p041d7.C2277q4;
import p041d7.C2284r4;
import p041d7.InterfaceC2270p4;

@UnstableApi
public final class MergingMediaSource extends CompositeMediaSource<Integer> {
    private static final int PERIOD_COUNT_UNSET = -1;
    private static final MediaItem PLACEHOLDER_MEDIA_ITEM = new MediaItem.Builder().setMediaId("MergingMediaSource").build();
    private final boolean adjustPeriodTimeOffsets;
    private final boolean clipDurations;
    private final Map<Object, Long> clippedDurationsUs;
    private final InterfaceC2270p4 clippedMediaPeriods;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final List<List<MediaPeriodAndId>> mediaPeriods;
    private final MediaSource[] mediaSources;
    private IllegalMergeException mergeError;
    private final ArrayList<MediaSource> pendingTimelineSources;
    private int periodCount;
    private long[][] periodTimeOffsetsUs;
    private final Timeline[] timelines;

    public static final class ClippedTimeline extends ForwardingTimeline {
        private final long[] periodDurationsUs;
        private final long[] windowDurationsUs;

        public ClippedTimeline(Timeline timeline, Map<Object, Long> map) {
            super(timeline);
            int windowCount = timeline.getWindowCount();
            this.windowDurationsUs = new long[timeline.getWindowCount()];
            Timeline.Window window = new Timeline.Window();
            for (int i6 = 0; i6 < windowCount; i6++) {
                this.windowDurationsUs[i6] = timeline.getWindow(i6, window).durationUs;
            }
            int periodCount = timeline.getPeriodCount();
            this.periodDurationsUs = new long[periodCount];
            Timeline.Period period = new Timeline.Period();
            for (int i10 = 0; i10 < periodCount; i10++) {
                timeline.getPeriod(i10, period, true);
                long jLongValue = ((Long) Assertions.checkNotNull(map.get(period.uid))).longValue();
                long[] jArr = this.periodDurationsUs;
                jLongValue = jLongValue == Long.MIN_VALUE ? period.durationUs : jLongValue;
                jArr[i10] = jLongValue;
                long j10 = period.durationUs;
                if (j10 != C0565C.TIME_UNSET) {
                    long[] jArr2 = this.windowDurationsUs;
                    int i11 = period.windowIndex;
                    jArr2[i11] = jArr2[i11] - (j10 - jLongValue);
                }
            }
        }

        @Override
        public Timeline.Period getPeriod(int i6, Timeline.Period period, boolean z7) {
            super.getPeriod(i6, period, z7);
            period.durationUs = this.periodDurationsUs[i6];
            return period;
        }

        @Override
        public Timeline.Window getWindow(int i6, Timeline.Window window, long j10) {
            long jMin;
            super.getWindow(i6, window, j10);
            long j11 = this.windowDurationsUs[i6];
            window.durationUs = j11;
            if (j11 != C0565C.TIME_UNSET) {
                long j12 = window.defaultPositionUs;
                if (j12 == C0565C.TIME_UNSET) {
                    jMin = window.defaultPositionUs;
                } else {
                    jMin = Math.min(j12, j11);
                }
            } else {
                jMin = window.defaultPositionUs;
            }
            window.defaultPositionUs = jMin;
            return window;
        }
    }

    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalMergeException(int i6) {
            this.reason = i6;
        }
    }

    public static final class MediaPeriodAndId {
        private final MediaPeriod mediaPeriod;
        private final MediaSource.MediaPeriodId mediaPeriodId;

        private MediaPeriodAndId(MediaSource.MediaPeriodId mediaPeriodId, MediaPeriod mediaPeriod) {
            this.mediaPeriodId = mediaPeriodId;
            this.mediaPeriod = mediaPeriod;
        }
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    private void computePeriodTimeOffsets() {
        Timeline.Period period = new Timeline.Period();
        for (int i6 = 0; i6 < this.periodCount; i6++) {
            long j10 = -this.timelines[0].getPeriod(i6, period).getPositionInWindowUs();
            int i10 = 1;
            while (true) {
                Timeline[] timelineArr = this.timelines;
                if (i10 < timelineArr.length) {
                    this.periodTimeOffsetsUs[i6][i10] = j10 - (-timelineArr[i10].getPeriod(i6, period).getPositionInWindowUs());
                    i10++;
                }
            }
        }
    }

    private void updateClippedDuration() {
        Timeline[] timelineArr;
        Timeline.Period period = new Timeline.Period();
        for (int i6 = 0; i6 < this.periodCount; i6++) {
            long j10 = Long.MIN_VALUE;
            int i10 = 0;
            while (true) {
                timelineArr = this.timelines;
                if (i10 >= timelineArr.length) {
                    break;
                }
                long durationUs = timelineArr[i10].getPeriod(i6, period).getDurationUs();
                if (durationUs != C0565C.TIME_UNSET) {
                    long j11 = durationUs + this.periodTimeOffsetsUs[i6][i10];
                    if (j10 == Long.MIN_VALUE || j11 < j10) {
                        j10 = j11;
                    }
                }
                i10++;
            }
            Object uidOfPeriod = timelineArr[0].getUidOfPeriod(i6);
            this.clippedDurationsUs.put(uidOfPeriod, Long.valueOf(j10));
            Iterator it = this.clippedMediaPeriods.get(uidOfPeriod).iterator();
            while (it.hasNext()) {
                ((ClippingMediaPeriod) it.next()).updateClipping(0L, j10);
            }
        }
    }

    @Override
    public boolean canUpdateMediaItem(MediaItem mediaItem) {
        MediaSource[] mediaSourceArr = this.mediaSources;
        return mediaSourceArr.length > 0 && mediaSourceArr[0].canUpdateMediaItem(mediaItem);
    }

    @Override
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j10) {
        int length = this.mediaSources.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        int indexOfPeriod = this.timelines[0].getIndexOfPeriod(mediaPeriodId.periodUid);
        for (int i6 = 0; i6 < length; i6++) {
            MediaSource.MediaPeriodId mediaPeriodIdCopyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(this.timelines[i6].getUidOfPeriod(indexOfPeriod));
            mediaPeriodArr[i6] = this.mediaSources[i6].createPeriod(mediaPeriodIdCopyWithPeriodUid, allocator, j10 - this.periodTimeOffsetsUs[indexOfPeriod][i6]);
            this.mediaPeriods.get(i6).add(new MediaPeriodAndId(mediaPeriodIdCopyWithPeriodUid, mediaPeriodArr[i6]));
        }
        MergingMediaPeriod mergingMediaPeriod = new MergingMediaPeriod(this.compositeSequenceableLoaderFactory, this.periodTimeOffsetsUs[indexOfPeriod], mediaPeriodArr);
        if (!this.clipDurations) {
            return mergingMediaPeriod;
        }
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(mergingMediaPeriod, false, 0L, ((Long) Assertions.checkNotNull(this.clippedDurationsUs.get(mediaPeriodId.periodUid))).longValue());
        this.clippedMediaPeriods.put(mediaPeriodId.periodUid, clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override
    public MediaItem getMediaItem() {
        MediaSource[] mediaSourceArr = this.mediaSources;
        return mediaSourceArr.length > 0 ? mediaSourceArr[0].getMediaItem() : PLACEHOLDER_MEDIA_ITEM;
    }

    @Override
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalMergeException illegalMergeException = this.mergeError;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override
    public void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        for (int i6 = 0; i6 < this.mediaSources.length; i6++) {
            prepareChildSource(Integer.valueOf(i6), this.mediaSources[i6]);
        }
    }

    @Override
    public void releasePeriod(MediaPeriod mediaPeriod) {
        if (this.clipDurations) {
            ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) mediaPeriod;
            for (Map.Entry entry : this.clippedMediaPeriods.mo5108a()) {
                if (((ClippingMediaPeriod) entry.getValue()).equals(clippingMediaPeriod)) {
                    this.clippedMediaPeriods.remove(entry.getKey(), entry.getValue());
                    break;
                }
            }
            mediaPeriod = clippingMediaPeriod.mediaPeriod;
        }
        MergingMediaPeriod mergingMediaPeriod = (MergingMediaPeriod) mediaPeriod;
        for (int i6 = 0; i6 < this.mediaSources.length; i6++) {
            List<MediaPeriodAndId> list = this.mediaPeriods.get(i6);
            for (int i10 = 0; i10 < list.size(); i10++) {
                if (list.get(i10).mediaPeriod.equals(mediaPeriod)) {
                    list.remove(i10);
                    break;
                }
            }
            this.mediaSources[i6].releasePeriod(mergingMediaPeriod.getChildPeriod(i6));
        }
    }

    @Override
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        Arrays.fill(this.timelines, (Object) null);
        this.periodCount = -1;
        this.mergeError = null;
        this.pendingTimelineSources.clear();
        Collections.addAll(this.pendingTimelineSources, this.mediaSources);
    }

    @Override
    public void updateMediaItem(MediaItem mediaItem) {
        this.mediaSources[0].updateMediaItem(mediaItem);
    }

    public MergingMediaSource(boolean z7, MediaSource... mediaSourceArr) {
        this(z7, false, mediaSourceArr);
    }

    @Override
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        List<MediaPeriodAndId> list = this.mediaPeriods.get(num.intValue());
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (list.get(i6).mediaPeriodId.equals(mediaPeriodId)) {
                return this.mediaPeriods.get(0).get(i6).mediaPeriodId;
            }
        }
        return null;
    }

    @Override
    public void lambda$prepareChildSource$0(Integer num, MediaSource mediaSource, Timeline timeline) {
        if (this.mergeError != null) {
            return;
        }
        if (this.periodCount == -1) {
            this.periodCount = timeline.getPeriodCount();
        } else if (timeline.getPeriodCount() != this.periodCount) {
            this.mergeError = new IllegalMergeException(0);
            return;
        }
        if (this.periodTimeOffsetsUs.length == 0) {
            this.periodTimeOffsetsUs = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.periodCount, this.timelines.length);
        }
        this.pendingTimelineSources.remove(mediaSource);
        this.timelines[num.intValue()] = timeline;
        if (this.pendingTimelineSources.isEmpty()) {
            if (this.adjustPeriodTimeOffsets) {
                computePeriodTimeOffsets();
            }
            Timeline clippedTimeline = this.timelines[0];
            if (this.clipDurations) {
                updateClippedDuration();
                clippedTimeline = new ClippedTimeline(clippedTimeline, this.clippedDurationsUs);
            }
            refreshSourceInfo(clippedTimeline);
        }
    }

    public MergingMediaSource(boolean z7, boolean z10, MediaSource... mediaSourceArr) {
        this(z7, z10, new DefaultCompositeSequenceableLoaderFactory(), mediaSourceArr);
    }

    public MergingMediaSource(boolean z7, boolean z10, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, MediaSource... mediaSourceArr) {
        this.adjustPeriodTimeOffsets = z7;
        this.clipDurations = z10;
        this.mediaSources = mediaSourceArr;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.pendingTimelineSources = new ArrayList<>(Arrays.asList(mediaSourceArr));
        this.periodCount = -1;
        this.mediaPeriods = new ArrayList(mediaSourceArr.length);
        for (int i6 = 0; i6 < mediaSourceArr.length; i6++) {
            this.mediaPeriods.add(new ArrayList());
        }
        this.timelines = new Timeline[mediaSourceArr.length];
        this.periodTimeOffsetsUs = new long[0][];
        this.clippedDurationsUs = new HashMap();
        AbstractC2182d0.m5141d(8, "expectedKeys");
        AbstractC2182d0.m5141d(2, "expectedValuesPerKey");
        C2217i0 c2217i0M5209b = C2217i0.m5209b(8);
        C2277q4 c2277q4 = new C2277q4(0);
        C2284r4 c2284r4 = new C2284r4(c2217i0M5209b);
        c2284r4.f8043h = c2277q4;
        this.clippedMediaPeriods = c2284r4;
    }
}
