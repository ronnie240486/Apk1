package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.C0565C;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import java.util.ArrayList;
import java.util.List;
import p041d7.AbstractC2301u1;
import p041d7.C2288s1;

final class MediaPeriodQueue {
    public static final long INITIAL_RENDERER_POSITION_OFFSET_US = 1000000000000L;
    private static final int MAXIMUM_BUFFER_AHEAD_PERIODS = 100;
    static final int UPDATE_PERIOD_QUEUE_ALTERED_PREWARMING_PERIOD = 2;
    static final int UPDATE_PERIOD_QUEUE_ALTERED_READING_PERIOD = 1;
    private final AnalyticsCollector analyticsCollector;
    private final HandlerWrapper analyticsCollectorHandler;
    private int length;
    private MediaPeriodHolder loading;
    private final MediaPeriodHolder.Factory mediaPeriodHolderFactory;
    private long nextWindowSequenceNumber;
    private Object oldFrontPeriodUid;
    private long oldFrontPeriodWindowSequenceNumber;
    private MediaPeriodHolder playing;
    private ExoPlayer.PreloadConfiguration preloadConfiguration;
    private MediaPeriodHolder preloading;
    private MediaPeriodHolder prewarming;
    private MediaPeriodHolder reading;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private final Timeline.Period period = new Timeline.Period();
    private final Timeline.Window window = new Timeline.Window();
    private List<MediaPeriodHolder> preloadPriorityList = new ArrayList();

    public MediaPeriodQueue(AnalyticsCollector analyticsCollector, HandlerWrapper handlerWrapper, MediaPeriodHolder.Factory factory, ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.analyticsCollector = analyticsCollector;
        this.analyticsCollectorHandler = handlerWrapper;
        this.mediaPeriodHolderFactory = factory;
        this.preloadConfiguration = preloadConfiguration;
    }

    public static boolean areDurationsCompatible(long j10, long j11) {
        return j10 == C0565C.TIME_UNSET || j10 == j11;
    }

    private boolean canKeepMediaPeriodHolder(MediaPeriodInfo mediaPeriodInfo, MediaPeriodInfo mediaPeriodInfo2) {
        return mediaPeriodInfo.startPositionUs == mediaPeriodInfo2.startPositionUs && mediaPeriodInfo.f2678id.equals(mediaPeriodInfo2.f2678id);
    }

    private Pair<Object, Long> getDefaultPeriodPositionOfNextWindow(Timeline timeline, Object obj, long j10) {
        int nextWindowIndex = timeline.getNextWindowIndex(timeline.getPeriodByUid(obj, this.period).windowIndex, this.repeatMode, this.shuffleModeEnabled);
        if (nextWindowIndex != -1) {
            return timeline.getPeriodPositionUs(this.window, this.period, nextWindowIndex, C0565C.TIME_UNSET, j10);
        }
        return null;
    }

    private MediaPeriodInfo getFirstMediaPeriodInfo(PlaybackInfo playbackInfo) {
        return getMediaPeriodInfo(playbackInfo.timeline, playbackInfo.periodId, playbackInfo.requestedContentPositionUs, playbackInfo.positionUs);
    }

    private MediaPeriodInfo getFirstMediaPeriodInfoOfNextPeriod(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j10) {
        long j11;
        long j12;
        Object obj;
        long j13;
        long j14;
        long jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
        int nextPeriodIndex = timeline.getNextPeriodIndex(timeline.getIndexOfPeriod(mediaPeriodInfo.f2678id.periodUid), this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
        if (nextPeriodIndex == -1) {
            return null;
        }
        int i6 = timeline.getPeriod(nextPeriodIndex, this.period, true).windowIndex;
        Object objCheckNotNull = Assertions.checkNotNull(this.period.uid);
        long j15 = mediaPeriodInfo.f2678id.windowSequenceNumber;
        if (timeline.getWindow(i6, this.window).firstPeriodIndex == nextPeriodIndex) {
            Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.window, this.period, i6, C0565C.TIME_UNSET, Math.max(0L, j10));
            if (periodPositionUs == null) {
                return null;
            }
            Object obj2 = periodPositionUs.first;
            long jLongValue = ((Long) periodPositionUs.second).longValue();
            MediaPeriodHolder next = mediaPeriodHolder.getNext();
            if (next == null || !next.uid.equals(obj2)) {
                jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods = resolvePeriodUidToWindowSequenceNumberInPreloadPeriods(obj2);
                if (jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods == -1) {
                    jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods = this.nextWindowSequenceNumber;
                    this.nextWindowSequenceNumber = 1 + jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods;
                }
            } else {
                jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods = next.info.f2678id.windowSequenceNumber;
            }
            j11 = jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods;
            j12 = -9223372036854775807L;
            obj = obj2;
            j13 = jLongValue;
        } else {
            j11 = j15;
            j12 = 0;
            obj = objCheckNotNull;
            j13 = 0;
        }
        MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds = resolveMediaPeriodIdForAds(timeline, obj, j13, j11, this.window, this.period);
        if (j12 == C0565C.TIME_UNSET || mediaPeriodInfo.requestedContentPositionUs == C0565C.TIME_UNSET) {
            j14 = j13;
        } else {
            boolean zHasServerSideInsertedAds = hasServerSideInsertedAds(mediaPeriodInfo.f2678id.periodUid, timeline);
            if (mediaPeriodIdResolveMediaPeriodIdForAds.isAd() && zHasServerSideInsertedAds) {
                j12 = mediaPeriodInfo.requestedContentPositionUs;
            } else if (zHasServerSideInsertedAds) {
                j14 = mediaPeriodInfo.requestedContentPositionUs;
            }
            j14 = j13;
        }
        return getMediaPeriodInfo(timeline, mediaPeriodIdResolveMediaPeriodIdForAds, j12, j14);
    }

    private MediaPeriodInfo getFollowingMediaPeriodInfo(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j10) {
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
        long rendererOffset = (mediaPeriodHolder.getRendererOffset() + mediaPeriodInfo.durationUs) - j10;
        return mediaPeriodInfo.isLastInTimelinePeriod ? getFirstMediaPeriodInfoOfNextPeriod(timeline, mediaPeriodHolder, rendererOffset) : getFollowingMediaPeriodInfoOfCurrentPeriod(timeline, mediaPeriodHolder, rendererOffset);
    }

    private MediaPeriodInfo getFollowingMediaPeriodInfoOfCurrentPeriod(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j10) {
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f2678id;
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        boolean z7 = mediaPeriodInfo.isFollowedByTransitionToSameStream;
        if (!mediaPeriodId.isAd()) {
            int i6 = mediaPeriodId.nextAdGroupIndex;
            if (i6 != -1 && this.period.isLivePostrollPlaceholder(i6)) {
                return getFirstMediaPeriodInfoOfNextPeriod(timeline, mediaPeriodHolder, j10);
            }
            int firstAdIndexToPlay = this.period.getFirstAdIndexToPlay(mediaPeriodId.nextAdGroupIndex);
            boolean z10 = this.period.isServerSideInsertedAdGroup(mediaPeriodId.nextAdGroupIndex) && this.period.getAdState(mediaPeriodId.nextAdGroupIndex, firstAdIndexToPlay) == 3;
            if (firstAdIndexToPlay == this.period.getAdCountInAdGroup(mediaPeriodId.nextAdGroupIndex) || z10) {
                return getMediaPeriodInfoForContent(timeline, mediaPeriodId.periodUid, getMinStartPositionAfterAdGroupUs(timeline, mediaPeriodId.periodUid, mediaPeriodId.nextAdGroupIndex), mediaPeriodInfo.durationUs, mediaPeriodId.windowSequenceNumber, false);
            }
            return getMediaPeriodInfoForAd(timeline, mediaPeriodId.periodUid, mediaPeriodId.nextAdGroupIndex, firstAdIndexToPlay, mediaPeriodInfo.durationUs, mediaPeriodId.windowSequenceNumber, z7);
        }
        int i10 = mediaPeriodId.adGroupIndex;
        int adCountInAdGroup = this.period.getAdCountInAdGroup(i10);
        if (adCountInAdGroup == -1) {
            return null;
        }
        int nextAdIndexToPlay = this.period.getNextAdIndexToPlay(i10, mediaPeriodId.adIndexInAdGroup);
        if (nextAdIndexToPlay < adCountInAdGroup) {
            return getMediaPeriodInfoForAd(timeline, mediaPeriodId.periodUid, i10, nextAdIndexToPlay, mediaPeriodInfo.requestedContentPositionUs, mediaPeriodId.windowSequenceNumber, z7);
        }
        long jLongValue = mediaPeriodInfo.requestedContentPositionUs;
        if (jLongValue == C0565C.TIME_UNSET) {
            Timeline.Window window = this.window;
            Timeline.Period period = this.period;
            Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(window, period, period.windowIndex, C0565C.TIME_UNSET, Math.max(0L, j10));
            if (periodPositionUs == null) {
                return null;
            }
            jLongValue = ((Long) periodPositionUs.second).longValue();
        }
        return getMediaPeriodInfoForContent(timeline, mediaPeriodId.periodUid, Math.max(getMinStartPositionAfterAdGroupUs(timeline, mediaPeriodId.periodUid, mediaPeriodId.adGroupIndex), jLongValue), mediaPeriodInfo.requestedContentPositionUs, mediaPeriodId.windowSequenceNumber, z7);
    }

    private MediaPeriodInfo getMediaPeriodInfo(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j10, long j11) {
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        return mediaPeriodId.isAd() ? getMediaPeriodInfoForAd(timeline, mediaPeriodId.periodUid, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, j10, mediaPeriodId.windowSequenceNumber, false) : getMediaPeriodInfoForContent(timeline, mediaPeriodId.periodUid, j11, j10, mediaPeriodId.windowSequenceNumber, false);
    }

    private MediaPeriodInfo getMediaPeriodInfoForAd(Timeline timeline, Object obj, int i6, int i10, long j10, long j11, boolean z7) {
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, i6, i10, j11);
        long adDurationUs = timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        long adResumePositionUs = i10 == this.period.getFirstAdIndexToPlay(i6) ? this.period.getAdResumePositionUs() : 0L;
        return new MediaPeriodInfo(mediaPeriodId, (adDurationUs == C0565C.TIME_UNSET || adResumePositionUs < adDurationUs) ? adResumePositionUs : Math.max(0L, adDurationUs - 1), j10, C0565C.TIME_UNSET, adDurationUs, z7, this.period.isServerSideInsertedAdGroup(mediaPeriodId.adGroupIndex), false, false, false);
    }

    private MediaPeriodInfo getMediaPeriodInfoForContent(Timeline timeline, Object obj, long j10, long j11, long j12, boolean z7) {
        boolean z10;
        long j13;
        long adGroupTimeUs;
        long j14;
        long jMax = j10;
        timeline.getPeriodByUid(obj, this.period);
        int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(jMax);
        boolean z11 = adGroupIndexAfterPositionUs != -1 && this.period.isLivePostrollPlaceholder(adGroupIndexAfterPositionUs);
        if (adGroupIndexAfterPositionUs == -1) {
            if (this.period.getAdGroupCount() > 0) {
                Timeline.Period period = this.period;
                z10 = period.isServerSideInsertedAdGroup(period.getRemovedAdGroupCount());
            }
        } else {
            if (this.period.isServerSideInsertedAdGroup(adGroupIndexAfterPositionUs)) {
                long adGroupTimeUs2 = this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs);
                Timeline.Period period2 = this.period;
                if (adGroupTimeUs2 == period2.durationUs && period2.hasPlayedAdGroup(adGroupIndexAfterPositionUs)) {
                    adGroupIndexAfterPositionUs = -1;
                }
            }
        }
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, j12, adGroupIndexAfterPositionUs);
        boolean zIsLastInPeriod = isLastInPeriod(mediaPeriodId);
        boolean zIsLastInWindow = isLastInWindow(timeline, mediaPeriodId);
        boolean zIsLastInTimeline = isLastInTimeline(timeline, mediaPeriodId, zIsLastInPeriod);
        boolean z12 = (adGroupIndexAfterPositionUs == -1 || !this.period.isServerSideInsertedAdGroup(adGroupIndexAfterPositionUs) || z11) ? false : true;
        if (adGroupIndexAfterPositionUs == -1 || z11) {
            if (z10) {
                adGroupTimeUs = this.period.durationUs;
            } else {
                j13 = -9223372036854775807L;
            }
            if (j13 != C0565C.TIME_UNSET || j13 == Long.MIN_VALUE) {
                j14 = this.period.durationUs;
            } else {
                j14 = j13;
            }
            if (j14 != C0565C.TIME_UNSET && jMax >= j14) {
                jMax = Math.max(0L, j14 - ((long) ((zIsLastInTimeline && z10) ? 0 : 1)));
            }
            return new MediaPeriodInfo(mediaPeriodId, jMax, j11, j13, j14, z7, z12, zIsLastInPeriod, zIsLastInWindow, zIsLastInTimeline);
        }
        adGroupTimeUs = this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs);
        j13 = adGroupTimeUs;
        if (j13 != C0565C.TIME_UNSET) {
            j14 = this.period.durationUs;
        } else {
            j14 = this.period.durationUs;
        }
        if (j14 != C0565C.TIME_UNSET) {
            jMax = Math.max(0L, j14 - ((long) ((zIsLastInTimeline && z10) ? 0 : 1)));
        }
        return new MediaPeriodInfo(mediaPeriodId, jMax, j11, j13, j14, z7, z12, zIsLastInPeriod, zIsLastInWindow, zIsLastInTimeline);
    }

    private MediaPeriodInfo getMediaPeriodInfoForPeriodPosition(Timeline timeline, Object obj, long j10, long j11) {
        MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds = resolveMediaPeriodIdForAds(timeline, obj, j10, j11, this.window, this.period);
        return mediaPeriodIdResolveMediaPeriodIdForAds.isAd() ? getMediaPeriodInfoForAd(timeline, mediaPeriodIdResolveMediaPeriodIdForAds.periodUid, mediaPeriodIdResolveMediaPeriodIdForAds.adGroupIndex, mediaPeriodIdResolveMediaPeriodIdForAds.adIndexInAdGroup, j10, mediaPeriodIdResolveMediaPeriodIdForAds.windowSequenceNumber, false) : getMediaPeriodInfoForContent(timeline, mediaPeriodIdResolveMediaPeriodIdForAds.periodUid, j10, C0565C.TIME_UNSET, mediaPeriodIdResolveMediaPeriodIdForAds.windowSequenceNumber, false);
    }

    private long getMinStartPositionAfterAdGroupUs(Timeline timeline, Object obj, int i6) {
        timeline.getPeriodByUid(obj, this.period);
        long adGroupTimeUs = this.period.getAdGroupTimeUs(i6);
        return adGroupTimeUs == Long.MIN_VALUE ? this.period.durationUs : this.period.getContentResumeOffsetUs(i6) + adGroupTimeUs;
    }

    private boolean hasServerSideInsertedAds(Object obj, Timeline timeline) {
        int adGroupCount = timeline.getPeriodByUid(obj, this.period).getAdGroupCount();
        int removedAdGroupCount = this.period.getRemovedAdGroupCount();
        return adGroupCount > 0 && this.period.isServerSideInsertedAdGroup(removedAdGroupCount) && (adGroupCount > 1 || this.period.getAdGroupTimeUs(removedAdGroupCount) != Long.MIN_VALUE);
    }

    private boolean isLastInPeriod(MediaSource.MediaPeriodId mediaPeriodId) {
        return !mediaPeriodId.isAd() && mediaPeriodId.nextAdGroupIndex == -1;
    }

    private boolean isLastInTimeline(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, boolean z7) {
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        return !timeline.getWindow(timeline.getPeriod(indexOfPeriod, this.period).windowIndex, this.window).isDynamic && timeline.isLastPeriod(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled) && z7;
    }

    private boolean isLastInWindow(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (isLastInPeriod(mediaPeriodId)) {
            return timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window).lastPeriodIndex == timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        }
        return false;
    }

    private static boolean isSkippableAdPeriod(Timeline.Period period) {
        int adGroupCount = period.getAdGroupCount();
        if (adGroupCount == 0) {
            return false;
        }
        if ((adGroupCount == 1 && period.isLivePostrollPlaceholder(0)) || !period.isServerSideInsertedAdGroup(period.getRemovedAdGroupCount())) {
            return false;
        }
        long contentResumeOffsetUs = 0;
        if (period.getAdGroupIndexForPositionUs(0L) != -1) {
            return false;
        }
        if (period.durationUs == 0) {
            return true;
        }
        int i6 = adGroupCount - (period.isLivePostrollPlaceholder(adGroupCount + (-1)) ? 2 : 1);
        for (int i10 = 0; i10 <= i6; i10++) {
            contentResumeOffsetUs += period.getContentResumeOffsetUs(i10);
        }
        return period.durationUs <= contentResumeOffsetUs;
    }

    public void lambda$notifyQueueUpdate$0(C2288s1 c2288s1, MediaSource.MediaPeriodId mediaPeriodId) {
        this.analyticsCollector.updateMediaPeriodQueueInfo(c2288s1.m5262g(), mediaPeriodId);
    }

    private void notifyQueueUpdate() {
        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
        for (MediaPeriodHolder next = this.playing; next != null; next = next.getNext()) {
            c2288s1M5269k.m5255a(next.info.f2678id);
        }
        MediaPeriodHolder mediaPeriodHolder = this.reading;
        this.analyticsCollectorHandler.post(new RunnableC0802l0(this, c2288s1M5269k, mediaPeriodHolder == null ? null : mediaPeriodHolder.info.f2678id, 0));
    }

    private void releaseAndResetPreloadPriorityList(List<MediaPeriodHolder> list) {
        for (int i6 = 0; i6 < this.preloadPriorityList.size(); i6++) {
            this.preloadPriorityList.get(i6).release();
        }
        this.preloadPriorityList = list;
        this.preloading = null;
        maybeUpdatePreloadMediaPeriodHolder();
    }

    private MediaPeriodHolder removePreloadedMediaPeriodHolder(MediaPeriodInfo mediaPeriodInfo) {
        for (int i6 = 0; i6 < this.preloadPriorityList.size(); i6++) {
            if (this.preloadPriorityList.get(i6).canBeUsedForMediaPeriodInfo(mediaPeriodInfo)) {
                return this.preloadPriorityList.remove(i6);
            }
        }
        return null;
    }

    private long resolvePeriodUidToWindowSequenceNumber(Timeline timeline, Object obj) {
        int indexOfPeriod;
        int i6 = timeline.getPeriodByUid(obj, this.period).windowIndex;
        Object obj2 = this.oldFrontPeriodUid;
        if (obj2 != null && (indexOfPeriod = timeline.getIndexOfPeriod(obj2)) != -1 && timeline.getPeriod(indexOfPeriod, this.period).windowIndex == i6) {
            return this.oldFrontPeriodWindowSequenceNumber;
        }
        for (MediaPeriodHolder next = this.playing; next != null; next = next.getNext()) {
            if (next.uid.equals(obj)) {
                return next.info.f2678id.windowSequenceNumber;
            }
        }
        for (MediaPeriodHolder next2 = this.playing; next2 != null; next2 = next2.getNext()) {
            int indexOfPeriod2 = timeline.getIndexOfPeriod(next2.uid);
            if (indexOfPeriod2 != -1 && timeline.getPeriod(indexOfPeriod2, this.period).windowIndex == i6) {
                return next2.info.f2678id.windowSequenceNumber;
            }
        }
        long jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods = resolvePeriodUidToWindowSequenceNumberInPreloadPeriods(obj);
        if (jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods != -1) {
            return jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods;
        }
        long j10 = this.nextWindowSequenceNumber;
        this.nextWindowSequenceNumber = 1 + j10;
        if (this.playing == null) {
            this.oldFrontPeriodUid = obj;
            this.oldFrontPeriodWindowSequenceNumber = j10;
        }
        return j10;
    }

    private long resolvePeriodUidToWindowSequenceNumberInPreloadPeriods(Object obj) {
        for (int i6 = 0; i6 < this.preloadPriorityList.size(); i6++) {
            MediaPeriodHolder mediaPeriodHolder = this.preloadPriorityList.get(i6);
            if (mediaPeriodHolder.uid.equals(obj)) {
                return mediaPeriodHolder.info.f2678id.windowSequenceNumber;
            }
        }
        return -1L;
    }

    private int updateForPlaybackModeChange(Timeline timeline) {
        MediaPeriodHolder next = this.playing;
        if (next == null) {
            return 0;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(next.uid);
        while (true) {
            indexOfPeriod = timeline.getNextPeriodIndex(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            while (((MediaPeriodHolder) Assertions.checkNotNull(next)).getNext() != null && !next.info.isLastInTimelinePeriod) {
                next = next.getNext();
            }
            MediaPeriodHolder next2 = next.getNext();
            if (indexOfPeriod == -1 || next2 == null || timeline.getIndexOfPeriod(next2.uid) != indexOfPeriod) {
                break;
            }
            next = next2;
        }
        int iRemoveAfter = removeAfter(next);
        next.info = getUpdatedMediaPeriodInfo(timeline, next.info);
        return iRemoveAfter;
    }

    public MediaPeriodHolder advancePlayingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.reading) {
            this.reading = mediaPeriodHolder.getNext();
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.playing;
        if (mediaPeriodHolder2 == this.prewarming) {
            this.prewarming = mediaPeriodHolder2.getNext();
        }
        this.playing.release();
        int i6 = this.length - 1;
        this.length = i6;
        if (i6 == 0) {
            this.loading = null;
            MediaPeriodHolder mediaPeriodHolder3 = this.playing;
            this.oldFrontPeriodUid = mediaPeriodHolder3.uid;
            this.oldFrontPeriodWindowSequenceNumber = mediaPeriodHolder3.info.f2678id.windowSequenceNumber;
        }
        this.playing = this.playing.getNext();
        notifyQueueUpdate();
        return this.playing;
    }

    public MediaPeriodHolder advancePrewarmingPeriod() {
        this.prewarming = ((MediaPeriodHolder) Assertions.checkStateNotNull(this.prewarming)).getNext();
        notifyQueueUpdate();
        return (MediaPeriodHolder) Assertions.checkStateNotNull(this.prewarming);
    }

    public MediaPeriodHolder advanceReadingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.prewarming;
        MediaPeriodHolder mediaPeriodHolder2 = this.reading;
        if (mediaPeriodHolder == mediaPeriodHolder2) {
            this.prewarming = ((MediaPeriodHolder) Assertions.checkStateNotNull(mediaPeriodHolder2)).getNext();
        }
        this.reading = ((MediaPeriodHolder) Assertions.checkStateNotNull(this.reading)).getNext();
        notifyQueueUpdate();
        return (MediaPeriodHolder) Assertions.checkStateNotNull(this.reading);
    }

    public void clear() {
        if (this.length == 0) {
            return;
        }
        MediaPeriodHolder next = (MediaPeriodHolder) Assertions.checkStateNotNull(this.playing);
        this.oldFrontPeriodUid = next.uid;
        this.oldFrontPeriodWindowSequenceNumber = next.info.f2678id.windowSequenceNumber;
        while (next != null) {
            next.release();
            next = next.getNext();
        }
        this.playing = null;
        this.loading = null;
        this.reading = null;
        this.prewarming = null;
        this.length = 0;
        notifyQueueUpdate();
    }

    public MediaPeriodHolder enqueueNextMediaPeriodHolder(MediaPeriodInfo mediaPeriodInfo) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        long rendererOffset = mediaPeriodHolder == null ? INITIAL_RENDERER_POSITION_OFFSET_US : (mediaPeriodHolder.getRendererOffset() + this.loading.info.durationUs) - mediaPeriodInfo.startPositionUs;
        MediaPeriodHolder mediaPeriodHolderRemovePreloadedMediaPeriodHolder = removePreloadedMediaPeriodHolder(mediaPeriodInfo);
        if (mediaPeriodHolderRemovePreloadedMediaPeriodHolder == null) {
            mediaPeriodHolderRemovePreloadedMediaPeriodHolder = this.mediaPeriodHolderFactory.create(mediaPeriodInfo, rendererOffset);
        } else {
            mediaPeriodHolderRemovePreloadedMediaPeriodHolder.info = mediaPeriodInfo;
            mediaPeriodHolderRemovePreloadedMediaPeriodHolder.setRendererOffset(rendererOffset);
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.loading;
        if (mediaPeriodHolder2 != null) {
            mediaPeriodHolder2.setNext(mediaPeriodHolderRemovePreloadedMediaPeriodHolder);
        } else {
            this.playing = mediaPeriodHolderRemovePreloadedMediaPeriodHolder;
            this.reading = mediaPeriodHolderRemovePreloadedMediaPeriodHolder;
            this.prewarming = mediaPeriodHolderRemovePreloadedMediaPeriodHolder;
        }
        this.oldFrontPeriodUid = null;
        this.loading = mediaPeriodHolderRemovePreloadedMediaPeriodHolder;
        this.length++;
        notifyQueueUpdate();
        return mediaPeriodHolderRemovePreloadedMediaPeriodHolder;
    }

    public MediaPeriodHolder getLoadingPeriod() {
        return this.loading;
    }

    public MediaPeriodInfo getNextMediaPeriodInfo(long j10, PlaybackInfo playbackInfo) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        return mediaPeriodHolder == null ? getFirstMediaPeriodInfo(playbackInfo) : getFollowingMediaPeriodInfo(playbackInfo.timeline, mediaPeriodHolder, j10);
    }

    public MediaPeriodHolder getPlayingPeriod() {
        return this.playing;
    }

    public MediaPeriodHolder getPreloadHolderByMediaPeriod(MediaPeriod mediaPeriod) {
        for (int i6 = 0; i6 < this.preloadPriorityList.size(); i6++) {
            MediaPeriodHolder mediaPeriodHolder = this.preloadPriorityList.get(i6);
            if (mediaPeriodHolder.mediaPeriod == mediaPeriod) {
                return mediaPeriodHolder;
            }
        }
        return null;
    }

    public MediaPeriodHolder getPreloadingPeriod() {
        return this.preloading;
    }

    public MediaPeriodHolder getPrewarmingPeriod() {
        return this.prewarming;
    }

    public MediaPeriodHolder getReadingPeriod() {
        return this.reading;
    }

    public MediaPeriodInfo getUpdatedMediaPeriodInfo(Timeline timeline, MediaPeriodInfo mediaPeriodInfo) {
        long durationUs;
        long j10;
        int i6;
        boolean zIsServerSideInsertedAdGroup;
        int i10;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f2678id;
        boolean zIsLastInPeriod = isLastInPeriod(mediaPeriodId);
        boolean zIsLastInWindow = isLastInWindow(timeline, mediaPeriodId);
        boolean zIsLastInTimeline = isLastInTimeline(timeline, mediaPeriodId, zIsLastInPeriod);
        timeline.getPeriodByUid(mediaPeriodInfo.f2678id.periodUid, this.period);
        long adGroupTimeUs = (mediaPeriodId.isAd() || (i10 = mediaPeriodId.nextAdGroupIndex) == -1) ? -9223372036854775807L : this.period.getAdGroupTimeUs(i10);
        if (!mediaPeriodId.isAd()) {
            if (adGroupTimeUs == C0565C.TIME_UNSET || adGroupTimeUs == Long.MIN_VALUE) {
                durationUs = this.period.getDurationUs();
            } else {
                j10 = adGroupTimeUs;
            }
            if (mediaPeriodId.isAd()) {
                zIsServerSideInsertedAdGroup = this.period.isServerSideInsertedAdGroup(mediaPeriodId.adGroupIndex);
            } else {
                i6 = mediaPeriodId.nextAdGroupIndex;
                if (i6 == -1 && this.period.isServerSideInsertedAdGroup(i6)) {
                    zIsServerSideInsertedAdGroup = true;
                } else {
                    zIsServerSideInsertedAdGroup = false;
                }
            }
            return new MediaPeriodInfo(mediaPeriodId, mediaPeriodInfo.startPositionUs, mediaPeriodInfo.requestedContentPositionUs, adGroupTimeUs, j10, mediaPeriodInfo.isPrecededByTransitionFromSameStream, zIsServerSideInsertedAdGroup, zIsLastInPeriod, zIsLastInWindow, zIsLastInTimeline);
        }
        durationUs = this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        j10 = durationUs;
        if (mediaPeriodId.isAd()) {
            zIsServerSideInsertedAdGroup = this.period.isServerSideInsertedAdGroup(mediaPeriodId.adGroupIndex);
        } else {
            i6 = mediaPeriodId.nextAdGroupIndex;
            if (i6 == -1) {
                zIsServerSideInsertedAdGroup = false;
            } else {
                zIsServerSideInsertedAdGroup = false;
            }
        }
        return new MediaPeriodInfo(mediaPeriodId, mediaPeriodInfo.startPositionUs, mediaPeriodInfo.requestedContentPositionUs, adGroupTimeUs, j10, mediaPeriodInfo.isPrecededByTransitionFromSameStream, zIsServerSideInsertedAdGroup, zIsLastInPeriod, zIsLastInWindow, zIsLastInTimeline);
    }

    public void invalidatePreloadPool(Timeline timeline) {
        MediaPeriodHolder mediaPeriodHolder;
        if (this.preloadConfiguration.targetPreloadDurationUs == C0565C.TIME_UNSET || (mediaPeriodHolder = this.loading) == null) {
            releasePreloadPool();
            return;
        }
        ArrayList arrayList = new ArrayList();
        Pair<Object, Long> defaultPeriodPositionOfNextWindow = getDefaultPeriodPositionOfNextWindow(timeline, mediaPeriodHolder.info.f2678id.periodUid, 0L);
        if (defaultPeriodPositionOfNextWindow != null && !timeline.getWindow(timeline.getPeriodByUid(defaultPeriodPositionOfNextWindow.first, this.period).windowIndex, this.window).isLive()) {
            long jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods = resolvePeriodUidToWindowSequenceNumberInPreloadPeriods(defaultPeriodPositionOfNextWindow.first);
            if (jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods == -1) {
                jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods = this.nextWindowSequenceNumber;
                this.nextWindowSequenceNumber = 1 + jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods;
            }
            MediaPeriodInfo mediaPeriodInfoForPeriodPosition = getMediaPeriodInfoForPeriodPosition(timeline, defaultPeriodPositionOfNextWindow.first, ((Long) defaultPeriodPositionOfNextWindow.second).longValue(), jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods);
            MediaPeriodHolder mediaPeriodHolderRemovePreloadedMediaPeriodHolder = removePreloadedMediaPeriodHolder(mediaPeriodInfoForPeriodPosition);
            if (mediaPeriodHolderRemovePreloadedMediaPeriodHolder == null) {
                mediaPeriodHolderRemovePreloadedMediaPeriodHolder = this.mediaPeriodHolderFactory.create(mediaPeriodInfoForPeriodPosition, (mediaPeriodHolder.getRendererOffset() + mediaPeriodHolder.info.durationUs) - mediaPeriodInfoForPeriodPosition.startPositionUs);
            }
            arrayList.add(mediaPeriodHolderRemovePreloadedMediaPeriodHolder);
        }
        releaseAndResetPreloadPriorityList(arrayList);
    }

    public boolean isLoading(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        return mediaPeriodHolder != null && mediaPeriodHolder.mediaPeriod == mediaPeriod;
    }

    public boolean isPreloading(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.preloading;
        return mediaPeriodHolder != null && mediaPeriodHolder.mediaPeriod == mediaPeriod;
    }

    public void maybeUpdatePreloadMediaPeriodHolder() {
        MediaPeriodHolder mediaPeriodHolder = this.preloading;
        if (mediaPeriodHolder == null || mediaPeriodHolder.isFullyPreloaded()) {
            this.preloading = null;
            for (int i6 = 0; i6 < this.preloadPriorityList.size(); i6++) {
                MediaPeriodHolder mediaPeriodHolder2 = this.preloadPriorityList.get(i6);
                if (!mediaPeriodHolder2.isFullyPreloaded()) {
                    this.preloading = mediaPeriodHolder2;
                    return;
                }
            }
        }
    }

    public void reevaluateBuffer(long j10) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.reevaluateBuffer(j10);
        }
    }

    public void releasePreloadPool() {
        if (this.preloadPriorityList.isEmpty()) {
            return;
        }
        releaseAndResetPreloadPriorityList(new ArrayList());
    }

    public int removeAfter(MediaPeriodHolder mediaPeriodHolder) {
        Assertions.checkStateNotNull(mediaPeriodHolder);
        int i6 = 0;
        if (mediaPeriodHolder.equals(this.loading)) {
            return 0;
        }
        this.loading = mediaPeriodHolder;
        while (mediaPeriodHolder.getNext() != null) {
            mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkNotNull(mediaPeriodHolder.getNext());
            if (mediaPeriodHolder == this.reading) {
                MediaPeriodHolder mediaPeriodHolder2 = this.playing;
                this.reading = mediaPeriodHolder2;
                this.prewarming = mediaPeriodHolder2;
                i6 = 3;
            }
            if (mediaPeriodHolder == this.prewarming) {
                this.prewarming = this.reading;
                i6 |= 2;
            }
            mediaPeriodHolder.release();
            this.length--;
        }
        ((MediaPeriodHolder) Assertions.checkNotNull(this.loading)).setNext(null);
        notifyQueueUpdate();
        return i6;
    }

    public MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(Timeline timeline, Object obj, long j10) {
        return resolveMediaPeriodIdForAds(timeline, obj, j10, resolvePeriodUidToWindowSequenceNumber(timeline, obj), this.window, this.period);
    }

    public MediaSource.MediaPeriodId resolveMediaPeriodIdForAdsAfterPeriodPositionChange(Timeline timeline, Object obj, long j10) {
        long jResolvePeriodUidToWindowSequenceNumber = resolvePeriodUidToWindowSequenceNumber(timeline, obj);
        timeline.getPeriodByUid(obj, this.period);
        timeline.getWindow(this.period.windowIndex, this.window);
        boolean z7 = false;
        for (int indexOfPeriod = timeline.getIndexOfPeriod(obj); indexOfPeriod >= this.window.firstPeriodIndex; indexOfPeriod--) {
            timeline.getPeriod(indexOfPeriod, this.period, true);
            boolean z10 = this.period.getAdGroupCount() > 0;
            z7 |= z10;
            Timeline.Period period = this.period;
            if (period.getAdGroupIndexForPositionUs(period.durationUs) != -1) {
                obj = Assertions.checkNotNull(this.period.uid);
            }
            if (z7 && (!z10 || this.period.durationUs != 0)) {
                break;
            }
        }
        return resolveMediaPeriodIdForAds(timeline, obj, j10, jResolvePeriodUidToWindowSequenceNumber, this.window, this.period);
    }

    public boolean shouldLoadNextMediaPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        return mediaPeriodHolder == null || (!mediaPeriodHolder.info.isFinal && mediaPeriodHolder.isFullyBuffered() && this.loading.info.durationUs != C0565C.TIME_UNSET && this.length < 100);
    }

    public void updatePreloadConfiguration(Timeline timeline, ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.preloadConfiguration = preloadConfiguration;
        invalidatePreloadPool(timeline);
    }

    public int updateQueuedPeriods(Timeline timeline, long j10, long j11, long j12) {
        MediaPeriodInfo updatedMediaPeriodInfo;
        MediaPeriodHolder next = this.playing;
        MediaPeriodHolder mediaPeriodHolder = null;
        while (true) {
            boolean z7 = false;
            if (next == null) {
                return 0;
            }
            MediaPeriodInfo mediaPeriodInfo = next.info;
            if (mediaPeriodHolder == null) {
                updatedMediaPeriodInfo = getUpdatedMediaPeriodInfo(timeline, mediaPeriodInfo);
            } else {
                MediaPeriodInfo followingMediaPeriodInfo = getFollowingMediaPeriodInfo(timeline, mediaPeriodHolder, j10);
                if (followingMediaPeriodInfo == null || !canKeepMediaPeriodHolder(mediaPeriodInfo, followingMediaPeriodInfo)) {
                    return removeAfter(mediaPeriodHolder);
                }
                updatedMediaPeriodInfo = followingMediaPeriodInfo;
            }
            next.info = updatedMediaPeriodInfo.copyWithRequestedContentPositionUs(mediaPeriodInfo.requestedContentPositionUs);
            if (!areDurationsCompatible(mediaPeriodInfo.durationUs, updatedMediaPeriodInfo.durationUs)) {
                next.updateClipping();
                long j13 = updatedMediaPeriodInfo.durationUs;
                long rendererTime = j13 == C0565C.TIME_UNSET ? Long.MAX_VALUE : next.toRendererTime(j13);
                int i6 = (next != this.reading || next.info.isFollowedByTransitionToSameStream || (j11 != Long.MIN_VALUE && j11 < rendererTime)) ? 0 : 1;
                if (next == this.prewarming && (j12 == Long.MIN_VALUE || j12 >= rendererTime)) {
                    z7 = true;
                }
                int iRemoveAfter = removeAfter(next);
                if (iRemoveAfter != 0) {
                    return iRemoveAfter;
                }
                return z7 ? i6 | 2 : i6;
            }
            mediaPeriodHolder = next;
            next = next.getNext();
        }
    }

    public int updateRepeatMode(Timeline timeline, int i6) {
        this.repeatMode = i6;
        return updateForPlaybackModeChange(timeline);
    }

    public int updateShuffleModeEnabled(Timeline timeline, boolean z7) {
        this.shuffleModeEnabled = z7;
        return updateForPlaybackModeChange(timeline);
    }

    private static MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(Timeline timeline, Object obj, long j10, long j11, Timeline.Window window, Timeline.Period period) {
        timeline.getPeriodByUid(obj, period);
        timeline.getWindow(period.windowIndex, window);
        Object objCheckNotNull = obj;
        for (int indexOfPeriod = timeline.getIndexOfPeriod(obj); isSkippableAdPeriod(period) && indexOfPeriod <= window.lastPeriodIndex; indexOfPeriod++) {
            timeline.getPeriod(indexOfPeriod, period, true);
            objCheckNotNull = Assertions.checkNotNull(period.uid);
        }
        timeline.getPeriodByUid(objCheckNotNull, period);
        int adGroupIndexForPositionUs = period.getAdGroupIndexForPositionUs(j10);
        if (adGroupIndexForPositionUs == -1) {
            return new MediaSource.MediaPeriodId(objCheckNotNull, j11, period.getAdGroupIndexAfterPositionUs(j10));
        }
        return new MediaSource.MediaPeriodId(objCheckNotNull, adGroupIndexForPositionUs, period.getFirstAdIndexToPlay(adGroupIndexForPositionUs), j11);
    }
}
