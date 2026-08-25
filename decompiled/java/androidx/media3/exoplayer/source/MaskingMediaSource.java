package androidx.media3.exoplayer.source;

import android.util.Pair;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.C0565C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.upstream.Allocator;
import java.util.Objects;

@UnstableApi
public final class MaskingMediaSource extends WrappingMediaSource {
    private boolean hasRealTimeline;
    private boolean hasStartedPreparing;
    private boolean isPrepared;
    private final Timeline.Period period;
    private MaskingTimeline timeline;
    private MaskingMediaPeriod unpreparedMaskingMediaPeriod;
    private final boolean useLazyPreparation;
    private final Timeline.Window window;

    public static final class MaskingTimeline extends ForwardingTimeline {
        public static final Object MASKING_EXTERNAL_PERIOD_UID = new Object();
        private final Object replacedInternalPeriodUid;
        private final Object replacedInternalWindowUid;

        private MaskingTimeline(Timeline timeline, Object obj, Object obj2) {
            super(timeline);
            this.replacedInternalWindowUid = obj;
            this.replacedInternalPeriodUid = obj2;
        }

        public static MaskingTimeline createWithPlaceholderTimeline(MediaItem mediaItem) {
            return new MaskingTimeline(new PlaceholderTimeline(mediaItem), Timeline.Window.SINGLE_WINDOW_UID, MASKING_EXTERNAL_PERIOD_UID);
        }

        public static MaskingTimeline createWithRealTimeline(Timeline timeline, Object obj, Object obj2) {
            return new MaskingTimeline(timeline, obj, obj2);
        }

        public MaskingTimeline cloneWithUpdatedTimeline(Timeline timeline) {
            return new MaskingTimeline(timeline, this.replacedInternalWindowUid, this.replacedInternalPeriodUid);
        }

        @Override
        public int getIndexOfPeriod(Object obj) {
            Object obj2;
            Timeline timeline = this.timeline;
            if (MASKING_EXTERNAL_PERIOD_UID.equals(obj) && (obj2 = this.replacedInternalPeriodUid) != null) {
                obj = obj2;
            }
            return timeline.getIndexOfPeriod(obj);
        }

        @Override
        public Timeline.Period getPeriod(int i6, Timeline.Period period, boolean z7) {
            this.timeline.getPeriod(i6, period, z7);
            if (Objects.equals(period.uid, this.replacedInternalPeriodUid) && z7) {
                period.uid = MASKING_EXTERNAL_PERIOD_UID;
            }
            return period;
        }

        @Override
        public Object getUidOfPeriod(int i6) {
            Object uidOfPeriod = this.timeline.getUidOfPeriod(i6);
            return Objects.equals(uidOfPeriod, this.replacedInternalPeriodUid) ? MASKING_EXTERNAL_PERIOD_UID : uidOfPeriod;
        }

        @Override
        public Timeline.Window getWindow(int i6, Timeline.Window window, long j10) {
            this.timeline.getWindow(i6, window, j10);
            if (Objects.equals(window.uid, this.replacedInternalWindowUid)) {
                window.uid = Timeline.Window.SINGLE_WINDOW_UID;
            }
            return window;
        }
    }

    public static final class PlaceholderTimeline extends Timeline {
        private final MediaItem mediaItem;

        public PlaceholderTimeline(MediaItem mediaItem) {
            this.mediaItem = mediaItem;
        }

        @Override
        public int getIndexOfPeriod(Object obj) {
            return obj == MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID ? 0 : -1;
        }

        @Override
        public Timeline.Period getPeriod(int i6, Timeline.Period period, boolean z7) {
            period.set(z7 ? 0 : null, z7 ? MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID : null, 0, C0565C.TIME_UNSET, 0L, AdPlaybackState.NONE, true);
            return period;
        }

        @Override
        public int getPeriodCount() {
            return 1;
        }

        @Override
        public Object getUidOfPeriod(int i6) {
            return MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
        }

        @Override
        public Timeline.Window getWindow(int i6, Timeline.Window window, long j10) {
            window.set(Timeline.Window.SINGLE_WINDOW_UID, this.mediaItem, null, C0565C.TIME_UNSET, C0565C.TIME_UNSET, C0565C.TIME_UNSET, false, true, null, 0L, C0565C.TIME_UNSET, 0, 0, 0L);
            window.isPlaceholder = true;
            return window;
        }

        @Override
        public int getWindowCount() {
            return 1;
        }
    }

    public MaskingMediaSource(MediaSource mediaSource, boolean z7) {
        super(mediaSource);
        this.useLazyPreparation = z7 && mediaSource.isSingleWindow();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        Timeline initialTimeline = mediaSource.getInitialTimeline();
        if (initialTimeline == null) {
            this.timeline = MaskingTimeline.createWithPlaceholderTimeline(mediaSource.getMediaItem());
        } else {
            this.timeline = MaskingTimeline.createWithRealTimeline(initialTimeline, null, null);
            this.hasRealTimeline = true;
        }
    }

    private Object getExternalPeriodUid(Object obj) {
        return (this.timeline.replacedInternalPeriodUid == null || !this.timeline.replacedInternalPeriodUid.equals(obj)) ? obj : MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
    }

    private Object getInternalPeriodUid(Object obj) {
        return (this.timeline.replacedInternalPeriodUid == null || !obj.equals(MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID)) ? obj : this.timeline.replacedInternalPeriodUid;
    }

    private boolean setPreparePositionOverrideToUnpreparedMaskingPeriod(long j10) {
        MaskingMediaPeriod maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
        int indexOfPeriod = this.timeline.getIndexOfPeriod(maskingMediaPeriod.f2962id.periodUid);
        if (indexOfPeriod == -1) {
            return false;
        }
        long j11 = this.timeline.getPeriod(indexOfPeriod, this.period).durationUs;
        if (j11 != C0565C.TIME_UNSET && j10 >= j11) {
            j10 = Math.max(0L, j11 - 1);
        }
        maskingMediaPeriod.overridePreparePositionUs(j10);
        return true;
    }

    @Override
    public boolean canUpdateMediaItem(MediaItem mediaItem) {
        return this.mediaSource.canUpdateMediaItem(mediaItem);
    }

    @Override
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId.copyWithPeriodUid(getExternalPeriodUid(mediaPeriodId.periodUid));
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    @Override
    public void onChildSourceInfoRefreshed(Timeline timeline) {
        long j10;
        MediaSource.MediaPeriodId mediaPeriodIdCopyWithPeriodUid;
        if (this.isPrepared) {
            this.timeline = this.timeline.cloneWithUpdatedTimeline(timeline);
            MaskingMediaPeriod maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
            if (maskingMediaPeriod != null) {
                setPreparePositionOverrideToUnpreparedMaskingPeriod(maskingMediaPeriod.getPreparePositionOverrideUs());
            }
        } else {
            if (!timeline.isEmpty()) {
                timeline.getWindow(0, this.window);
                long defaultPositionUs = this.window.getDefaultPositionUs();
                Object obj = this.window.uid;
                MaskingMediaPeriod maskingMediaPeriod2 = this.unpreparedMaskingMediaPeriod;
                if (maskingMediaPeriod2 != null) {
                    long preparePositionUs = maskingMediaPeriod2.getPreparePositionUs();
                    this.timeline.getPeriodByUid(this.unpreparedMaskingMediaPeriod.f2962id.periodUid, this.period);
                    long positionInWindowUs = this.period.getPositionInWindowUs() + preparePositionUs;
                    if (positionInWindowUs != this.timeline.getWindow(0, this.window).getDefaultPositionUs()) {
                        j10 = positionInWindowUs;
                    } else {
                        j10 = defaultPositionUs;
                    }
                } else {
                    j10 = defaultPositionUs;
                }
                Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.window, this.period, 0, j10);
                Object obj2 = periodPositionUs.first;
                long jLongValue = ((Long) periodPositionUs.second).longValue();
                this.timeline = this.hasRealTimeline ? this.timeline.cloneWithUpdatedTimeline(timeline) : MaskingTimeline.createWithRealTimeline(timeline, obj, obj2);
                MaskingMediaPeriod maskingMediaPeriod3 = this.unpreparedMaskingMediaPeriod;
                if (maskingMediaPeriod3 != null && setPreparePositionOverrideToUnpreparedMaskingPeriod(jLongValue)) {
                    MediaSource.MediaPeriodId mediaPeriodId = maskingMediaPeriod3.f2962id;
                    mediaPeriodIdCopyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(getInternalPeriodUid(mediaPeriodId.periodUid));
                }
                this.hasRealTimeline = true;
                this.isPrepared = true;
                refreshSourceInfo(this.timeline);
                if (mediaPeriodIdCopyWithPeriodUid != null) {
                    ((MaskingMediaPeriod) Assertions.checkNotNull(this.unpreparedMaskingMediaPeriod)).createPeriod(mediaPeriodIdCopyWithPeriodUid);
                }
            }
            this.timeline = this.hasRealTimeline ? this.timeline.cloneWithUpdatedTimeline(timeline) : MaskingTimeline.createWithRealTimeline(timeline, Timeline.Window.SINGLE_WINDOW_UID, MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID);
        }
        mediaPeriodIdCopyWithPeriodUid = null;
        this.hasRealTimeline = true;
        this.isPrepared = true;
        refreshSourceInfo(this.timeline);
        if (mediaPeriodIdCopyWithPeriodUid != null) {
            ((MaskingMediaPeriod) Assertions.checkNotNull(this.unpreparedMaskingMediaPeriod)).createPeriod(mediaPeriodIdCopyWithPeriodUid);
        }
    }

    @Override
    public void prepareSourceInternal() {
        if (this.useLazyPreparation) {
            return;
        }
        this.hasStartedPreparing = true;
        prepareChildSource();
    }

    @Override
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).releasePeriod();
        if (mediaPeriod == this.unpreparedMaskingMediaPeriod) {
            this.unpreparedMaskingMediaPeriod = null;
        }
    }

    @Override
    public void releaseSourceInternal() {
        this.isPrepared = false;
        this.hasStartedPreparing = false;
        super.releaseSourceInternal();
    }

    @Override
    public void updateMediaItem(MediaItem mediaItem) {
        if (this.hasRealTimeline) {
            this.timeline = this.timeline.cloneWithUpdatedTimeline(new TimelineWithUpdatedMediaItem(this.timeline.timeline, mediaItem));
        } else {
            this.timeline = MaskingTimeline.createWithPlaceholderTimeline(mediaItem);
        }
        this.mediaSource.updateMediaItem(mediaItem);
    }

    @Override
    public MaskingMediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j10) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j10);
        maskingMediaPeriod.setMediaSource(this.mediaSource);
        if (this.isPrepared) {
            maskingMediaPeriod.createPeriod(mediaPeriodId.copyWithPeriodUid(getInternalPeriodUid(mediaPeriodId.periodUid)));
        } else {
            this.unpreparedMaskingMediaPeriod = maskingMediaPeriod;
            if (!this.hasStartedPreparing) {
                this.hasStartedPreparing = true;
                prepareChildSource();
            }
        }
        return maskingMediaPeriod;
    }

    @Override
    public void maybeThrowSourceInfoRefreshError() {
    }
}
