package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.C0565C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class SinglePeriodTimeline extends Timeline {
    private final long elapsedRealtimeEpochOffsetMs;
    private final boolean isDynamic;
    private final boolean isSeekable;
    private final MediaItem.LiveConfiguration liveConfiguration;
    private final Object manifest;
    private final MediaItem mediaItem;
    private final long periodDurationUs;
    private final long presentationStartTimeMs;
    private final boolean suppressPositionProjection;
    private final long windowDefaultStartPositionUs;
    private final long windowDurationUs;
    private final long windowPositionInPeriodUs;
    private final long windowStartTimeMs;
    private static final Object UID = new Object();
    private static final MediaItem MEDIA_ITEM = new MediaItem.Builder().setMediaId("SinglePeriodTimeline").setUri(Uri.EMPTY).build();

    @Deprecated
    public SinglePeriodTimeline(long j10, boolean z7, boolean z10, boolean z11, Object obj, Object obj2) {
        this(j10, j10, 0L, 0L, z7, z10, z11, obj, obj2);
    }

    @Override
    public int getIndexOfPeriod(Object obj) {
        return UID.equals(obj) ? 0 : -1;
    }

    @Override
    public Timeline.Period getPeriod(int i6, Timeline.Period period, boolean z7) {
        Assertions.checkIndex(i6, 0, 1);
        return period.set(null, z7 ? UID : null, 0, this.periodDurationUs, -this.windowPositionInPeriodUs);
    }

    @Override
    public int getPeriodCount() {
        return 1;
    }

    @Override
    public Object getUidOfPeriod(int i6) {
        Assertions.checkIndex(i6, 0, 1);
        return UID;
    }

    @Override
    public Timeline.Window getWindow(int i6, Timeline.Window window, long j10) {
        long j11;
        Assertions.checkIndex(i6, 0, 1);
        long j12 = this.windowDefaultStartPositionUs;
        boolean z7 = this.isDynamic;
        if (!z7 || this.suppressPositionProjection || j10 == 0) {
            j11 = j12;
        } else {
            long j13 = this.windowDurationUs;
            if (j13 != C0565C.TIME_UNSET) {
                j12 += j10;
                if (j12 <= j13) {
                    j11 = j12;
                }
            }
            j11 = -9223372036854775807L;
        }
        return window.set(Timeline.Window.SINGLE_WINDOW_UID, this.mediaItem, this.manifest, this.presentationStartTimeMs, this.windowStartTimeMs, this.elapsedRealtimeEpochOffsetMs, this.isSeekable, z7, this.liveConfiguration, j11, this.windowDurationUs, 0, 0, this.windowPositionInPeriodUs);
    }

    @Override
    public int getWindowCount() {
        return 1;
    }

    public SinglePeriodTimeline(long j10, boolean z7, boolean z10, boolean z11, Object obj, MediaItem mediaItem) {
        this(j10, j10, 0L, 0L, z7, z10, z11, obj, mediaItem);
    }

    @Deprecated
    public SinglePeriodTimeline(long j10, long j11, long j12, long j13, boolean z7, boolean z10, boolean z11, Object obj, Object obj2) {
        this(C0565C.TIME_UNSET, C0565C.TIME_UNSET, C0565C.TIME_UNSET, j10, j11, j12, j13, z7, z10, z11, obj, obj2);
    }

    public SinglePeriodTimeline(long j10, long j11, long j12, long j13, boolean z7, boolean z10, boolean z11, Object obj, MediaItem mediaItem) {
        this(C0565C.TIME_UNSET, C0565C.TIME_UNSET, C0565C.TIME_UNSET, j10, j11, j12, j13, z7, z10, false, obj, mediaItem, z11 ? mediaItem.liveConfiguration : null);
    }

    @Deprecated
    public SinglePeriodTimeline(long j10, long j11, long j12, long j13, long j14, long j15, long j16, boolean z7, boolean z10, boolean z11, Object obj, Object obj2) {
        MediaItem mediaItem = MEDIA_ITEM;
        this(j10, j11, j12, j13, j14, j15, j16, z7, z10, false, obj, mediaItem.buildUpon().setTag(obj2).build(), z11 ? mediaItem.liveConfiguration : null);
    }

    @Deprecated
    public SinglePeriodTimeline(long j10, long j11, long j12, long j13, long j14, long j15, long j16, boolean z7, boolean z10, Object obj, MediaItem mediaItem, MediaItem.LiveConfiguration liveConfiguration) {
        this(j10, j11, j12, j13, j14, j15, j16, z7, z10, false, obj, mediaItem, liveConfiguration);
    }

    public SinglePeriodTimeline(long j10, long j11, long j12, long j13, long j14, long j15, long j16, boolean z7, boolean z10, boolean z11, Object obj, MediaItem mediaItem, MediaItem.LiveConfiguration liveConfiguration) {
        this.presentationStartTimeMs = j10;
        this.windowStartTimeMs = j11;
        this.elapsedRealtimeEpochOffsetMs = j12;
        this.periodDurationUs = j13;
        this.windowDurationUs = j14;
        this.windowPositionInPeriodUs = j15;
        this.windowDefaultStartPositionUs = j16;
        this.isSeekable = z7;
        this.isDynamic = z10;
        this.suppressPositionProjection = z11;
        this.manifest = obj;
        this.mediaItem = (MediaItem) Assertions.checkNotNull(mediaItem);
        this.liveConfiguration = liveConfiguration;
    }
}
