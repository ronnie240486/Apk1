package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MaskingMediaPeriod;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class MediaSourceList {
    private static final String TAG = "MediaSourceList";
    private final HandlerWrapper eventHandler;
    private final AnalyticsCollector eventListener;
    private boolean isPrepared;
    private final MediaSourceListInfoRefreshListener mediaSourceListInfoListener;
    private TransferListener mediaTransferListener;
    private final PlayerId playerId;
    private ShuffleOrder shuffleOrder = new ShuffleOrder.DefaultShuffleOrder(0);
    private final IdentityHashMap<MediaPeriod, MediaSourceHolder> mediaSourceByMediaPeriod = new IdentityHashMap<>();
    private final Map<Object, MediaSourceHolder> mediaSourceByUid = new HashMap();
    private final List<MediaSourceHolder> mediaSourceHolders = new ArrayList();
    private final HashMap<MediaSourceHolder, MediaSourceAndListener> childSources = new HashMap<>();
    private final Set<MediaSourceHolder> enabledMediaSourceHolders = new HashSet();

    public final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {

        private final MediaSourceHolder f2679id;

        public ForwardingEventListener(MediaSourceHolder mediaSourceHolder) {
            this.f2679id = mediaSourceHolder;
        }

        private Pair<Integer, MediaSource.MediaPeriodId> getEventParameters(int i6, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodId2 = null;
            if (mediaPeriodId != null) {
                MediaSource.MediaPeriodId mediaPeriodIdForChildMediaPeriodId = MediaSourceList.getMediaPeriodIdForChildMediaPeriodId(this.f2679id, mediaPeriodId);
                if (mediaPeriodIdForChildMediaPeriodId == null) {
                    return null;
                }
                mediaPeriodId2 = mediaPeriodIdForChildMediaPeriodId;
            }
            return Pair.create(Integer.valueOf(MediaSourceList.getWindowIndexForChildWindowIndex(this.f2679id, i6)), mediaPeriodId2);
        }

        public void lambda$onDownstreamFormatChanged$5(Pair pair, MediaLoadData mediaLoadData) {
            MediaSourceList.this.eventListener.onDownstreamFormatChanged(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, mediaLoadData);
        }

        public void lambda$onDrmKeysLoaded$7(Pair pair) {
            MediaSourceList.this.eventListener.onDrmKeysLoaded(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        public void lambda$onDrmKeysRemoved$10(Pair pair) {
            MediaSourceList.this.eventListener.onDrmKeysRemoved(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        public void lambda$onDrmKeysRestored$9(Pair pair) {
            MediaSourceList.this.eventListener.onDrmKeysRestored(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        public void lambda$onDrmSessionAcquired$6(Pair pair, int i6) {
            MediaSourceList.this.eventListener.onDrmSessionAcquired(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, i6);
        }

        public void lambda$onDrmSessionManagerError$8(Pair pair, Exception exc) {
            MediaSourceList.this.eventListener.onDrmSessionManagerError(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, exc);
        }

        public void lambda$onDrmSessionReleased$11(Pair pair) {
            MediaSourceList.this.eventListener.onDrmSessionReleased(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        public void lambda$onLoadCanceled$2(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceList.this.eventListener.onLoadCanceled(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        public void lambda$onLoadCompleted$1(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceList.this.eventListener.onLoadCompleted(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        public void lambda$onLoadError$3(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z7) {
            MediaSourceList.this.eventListener.onLoadError(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData, iOException, z7);
        }

        public void lambda$onLoadStarted$0(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i6) {
            MediaSourceList.this.eventListener.onLoadStarted(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData, i6);
        }

        public void lambda$onUpstreamDiscarded$4(Pair pair, MediaLoadData mediaLoadData) {
            MediaSourceList.this.eventListener.onUpstreamDiscarded(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) Assertions.checkNotNull((MediaSource.MediaPeriodId) pair.second), mediaLoadData);
        }

        @Override
        public void onDownstreamFormatChanged(int i6, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i6, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new RunnableC0827n0(this, eventParameters, mediaLoadData, 1));
            }
        }

        @Override
        public void onDrmKeysLoaded(int i6, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i6, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new RunnableC0851r0(this, eventParameters, 3));
            }
        }

        @Override
        public void onDrmKeysRemoved(int i6, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i6, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new RunnableC0851r0(this, eventParameters, 0));
            }
        }

        @Override
        public void onDrmKeysRestored(int i6, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i6, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new RunnableC0851r0(this, eventParameters, 1));
            }
        }

        @Override
        public void onDrmSessionAcquired(int i6, MediaSource.MediaPeriodId mediaPeriodId, final int i10) {
            final Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i6, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new Runnable() {
                    @Override
                    public final void run() {
                        this.f2956a.lambda$onDrmSessionAcquired$6(eventParameters, i10);
                    }
                });
            }
        }

        @Override
        public void onDrmSessionManagerError(int i6, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i6, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new RunnableC0802l0(this, eventParameters, exc, 1));
            }
        }

        @Override
        public void onDrmSessionReleased(int i6, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i6, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new RunnableC0851r0(this, eventParameters, 2));
            }
        }

        @Override
        public void onLoadCanceled(int i6, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i6, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new RunnableC0850q0(this, eventParameters, loadEventInfo, mediaLoadData, 0));
            }
        }

        @Override
        public void onLoadCompleted(int i6, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i6, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new RunnableC0850q0(this, eventParameters, loadEventInfo, mediaLoadData, 1));
            }
        }

        @Override
        public void onLoadError(int i6, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z7) {
            final Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i6, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new Runnable() {
                    @Override
                    public final void run() {
                        this.f2928a.lambda$onLoadError$3(eventParameters, loadEventInfo, mediaLoadData, iOException, z7);
                    }
                });
            }
        }

        @Override
        public void onLoadStarted(int i6, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final int i10) {
            final Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i6, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new Runnable() {
                    @Override
                    public final void run() {
                        this.f2910a.lambda$onLoadStarted$0(eventParameters, loadEventInfo, mediaLoadData, i10);
                    }
                });
            }
        }

        @Override
        public void onUpstreamDiscarded(int i6, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> eventParameters = getEventParameters(i6, mediaPeriodId);
            if (eventParameters != null) {
                MediaSourceList.this.eventHandler.post(new RunnableC0827n0(this, eventParameters, mediaLoadData, 0));
            }
        }
    }

    public static final class MediaSourceAndListener {
        public final MediaSource.MediaSourceCaller caller;
        public final ForwardingEventListener eventListener;
        public final MediaSource mediaSource;

        public MediaSourceAndListener(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, ForwardingEventListener forwardingEventListener) {
            this.mediaSource = mediaSource;
            this.caller = mediaSourceCaller;
            this.eventListener = forwardingEventListener;
        }
    }

    public static final class MediaSourceHolder implements MediaSourceInfoHolder {
        public int firstWindowIndexInChild;
        public boolean isRemoved;
        public final MaskingMediaSource mediaSource;
        public final List<MediaSource.MediaPeriodId> activeMediaPeriodIds = new ArrayList();
        public final Object uid = new Object();

        public MediaSourceHolder(MediaSource mediaSource, boolean z7) {
            this.mediaSource = new MaskingMediaSource(mediaSource, z7);
        }

        @Override
        public Timeline getTimeline() {
            return this.mediaSource.getTimeline();
        }

        @Override
        public Object getUid() {
            return this.uid;
        }

        public void reset(int i6) {
            this.firstWindowIndexInChild = i6;
            this.isRemoved = false;
            this.activeMediaPeriodIds.clear();
        }
    }

    public interface MediaSourceListInfoRefreshListener {
        void onPlaylistUpdateRequested();
    }

    public MediaSourceList(MediaSourceListInfoRefreshListener mediaSourceListInfoRefreshListener, AnalyticsCollector analyticsCollector, HandlerWrapper handlerWrapper, PlayerId playerId) {
        this.playerId = playerId;
        this.mediaSourceListInfoListener = mediaSourceListInfoRefreshListener;
        this.eventListener = analyticsCollector;
        this.eventHandler = handlerWrapper;
    }

    private void correctOffsets(int i6, int i10) {
        while (i6 < this.mediaSourceHolders.size()) {
            this.mediaSourceHolders.get(i6).firstWindowIndexInChild += i10;
            i6++;
        }
    }

    private void disableChildSource(MediaSourceHolder mediaSourceHolder) {
        MediaSourceAndListener mediaSourceAndListener = this.childSources.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.mediaSource.disable(mediaSourceAndListener.caller);
        }
    }

    private void disableUnusedMediaSources() {
        Iterator<MediaSourceHolder> it = this.enabledMediaSourceHolders.iterator();
        while (it.hasNext()) {
            MediaSourceHolder next = it.next();
            if (next.activeMediaPeriodIds.isEmpty()) {
                disableChildSource(next);
                it.remove();
            }
        }
    }

    private void enableMediaSource(MediaSourceHolder mediaSourceHolder) {
        this.enabledMediaSourceHolders.add(mediaSourceHolder);
        MediaSourceAndListener mediaSourceAndListener = this.childSources.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.mediaSource.enable(mediaSourceAndListener.caller);
        }
    }

    private static Object getChildPeriodUid(Object obj) {
        return AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(obj);
    }

    public static MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i6 = 0; i6 < mediaSourceHolder.activeMediaPeriodIds.size(); i6++) {
            if (mediaSourceHolder.activeMediaPeriodIds.get(i6).windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return mediaPeriodId.copyWithPeriodUid(getPeriodUid(mediaSourceHolder, mediaPeriodId.periodUid));
            }
        }
        return null;
    }

    private static Object getMediaSourceHolderUid(Object obj) {
        return AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(obj);
    }

    private static Object getPeriodUid(MediaSourceHolder mediaSourceHolder, Object obj) {
        return AbstractConcatenatedTimeline.getConcatenatedUid(mediaSourceHolder.uid, obj);
    }

    public static int getWindowIndexForChildWindowIndex(MediaSourceHolder mediaSourceHolder, int i6) {
        return i6 + mediaSourceHolder.firstWindowIndexInChild;
    }

    public void lambda$prepareChildSource$0(MediaSource mediaSource, Timeline timeline) {
        this.mediaSourceListInfoListener.onPlaylistUpdateRequested();
    }

    private void maybeReleaseChildSource(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.isRemoved && mediaSourceHolder.activeMediaPeriodIds.isEmpty()) {
            MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.checkNotNull(this.childSources.remove(mediaSourceHolder));
            mediaSourceAndListener.mediaSource.releaseSource(mediaSourceAndListener.caller);
            mediaSourceAndListener.mediaSource.removeEventListener(mediaSourceAndListener.eventListener);
            mediaSourceAndListener.mediaSource.removeDrmEventListener(mediaSourceAndListener.eventListener);
            this.enabledMediaSourceHolders.remove(mediaSourceHolder);
        }
    }

    private void prepareChildSource(MediaSourceHolder mediaSourceHolder) {
        MaskingMediaSource maskingMediaSource = mediaSourceHolder.mediaSource;
        MediaSource.MediaSourceCaller mediaSourceCaller = new MediaSource.MediaSourceCaller() {
            @Override
            public final void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
                this.f2890a.lambda$prepareChildSource$0(mediaSource, timeline);
            }
        };
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(mediaSourceHolder);
        this.childSources.put(mediaSourceHolder, new MediaSourceAndListener(maskingMediaSource, mediaSourceCaller, forwardingEventListener));
        maskingMediaSource.addEventListener(Util.createHandlerForCurrentOrMainLooper(), forwardingEventListener);
        maskingMediaSource.addDrmEventListener(Util.createHandlerForCurrentOrMainLooper(), forwardingEventListener);
        maskingMediaSource.prepareSource(mediaSourceCaller, this.mediaTransferListener, this.playerId);
    }

    private void removeMediaSourcesInternal(int i6, int i10) {
        for (int i11 = i10 - 1; i11 >= i6; i11--) {
            MediaSourceHolder mediaSourceHolderRemove = this.mediaSourceHolders.remove(i11);
            this.mediaSourceByUid.remove(mediaSourceHolderRemove.uid);
            correctOffsets(i11, -mediaSourceHolderRemove.mediaSource.getTimeline().getWindowCount());
            mediaSourceHolderRemove.isRemoved = true;
            if (this.isPrepared) {
                maybeReleaseChildSource(mediaSourceHolderRemove);
            }
        }
    }

    public Timeline addMediaSources(int i6, List<MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        if (!list.isEmpty()) {
            this.shuffleOrder = shuffleOrder;
            for (int i10 = i6; i10 < list.size() + i6; i10++) {
                MediaSourceHolder mediaSourceHolder = list.get(i10 - i6);
                if (i10 > 0) {
                    MediaSourceHolder mediaSourceHolder2 = this.mediaSourceHolders.get(i10 - 1);
                    mediaSourceHolder.reset(mediaSourceHolder2.mediaSource.getTimeline().getWindowCount() + mediaSourceHolder2.firstWindowIndexInChild);
                } else {
                    mediaSourceHolder.reset(0);
                }
                correctOffsets(i10, mediaSourceHolder.mediaSource.getTimeline().getWindowCount());
                this.mediaSourceHolders.add(i10, mediaSourceHolder);
                this.mediaSourceByUid.put(mediaSourceHolder.uid, mediaSourceHolder);
                if (this.isPrepared) {
                    prepareChildSource(mediaSourceHolder);
                    if (this.mediaSourceByMediaPeriod.isEmpty()) {
                        this.enabledMediaSourceHolders.add(mediaSourceHolder);
                    } else {
                        disableChildSource(mediaSourceHolder);
                    }
                }
            }
        }
        return createTimeline();
    }

    public Timeline clear(ShuffleOrder shuffleOrder) {
        if (shuffleOrder == null) {
            shuffleOrder = this.shuffleOrder.cloneAndClear();
        }
        this.shuffleOrder = shuffleOrder;
        removeMediaSourcesInternal(0, getSize());
        return createTimeline();
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j10) {
        Object mediaSourceHolderUid = getMediaSourceHolderUid(mediaPeriodId.periodUid);
        MediaSource.MediaPeriodId mediaPeriodIdCopyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(getChildPeriodUid(mediaPeriodId.periodUid));
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.checkNotNull(this.mediaSourceByUid.get(mediaSourceHolderUid));
        enableMediaSource(mediaSourceHolder);
        mediaSourceHolder.activeMediaPeriodIds.add(mediaPeriodIdCopyWithPeriodUid);
        MaskingMediaPeriod maskingMediaPeriodCreatePeriod = mediaSourceHolder.mediaSource.createPeriod(mediaPeriodIdCopyWithPeriodUid, allocator, j10);
        this.mediaSourceByMediaPeriod.put(maskingMediaPeriodCreatePeriod, mediaSourceHolder);
        disableUnusedMediaSources();
        return maskingMediaPeriodCreatePeriod;
    }

    public Timeline createTimeline() {
        if (this.mediaSourceHolders.isEmpty()) {
            return Timeline.EMPTY;
        }
        int windowCount = 0;
        for (int i6 = 0; i6 < this.mediaSourceHolders.size(); i6++) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i6);
            mediaSourceHolder.firstWindowIndexInChild = windowCount;
            windowCount += mediaSourceHolder.mediaSource.getTimeline().getWindowCount();
        }
        return new PlaylistTimeline(this.mediaSourceHolders, this.shuffleOrder);
    }

    public ShuffleOrder getShuffleOrder() {
        return this.shuffleOrder;
    }

    public int getSize() {
        return this.mediaSourceHolders.size();
    }

    public boolean isPrepared() {
        return this.isPrepared;
    }

    public Timeline moveMediaSource(int i6, int i10, ShuffleOrder shuffleOrder) {
        return moveMediaSourceRange(i6, i6 + 1, i10, shuffleOrder);
    }

    public Timeline moveMediaSourceRange(int i6, int i10, int i11, ShuffleOrder shuffleOrder) {
        Assertions.checkArgument(i6 >= 0 && i6 <= i10 && i10 <= getSize() && i11 >= 0);
        this.shuffleOrder = shuffleOrder;
        if (i6 == i10 || i6 == i11) {
            return createTimeline();
        }
        int iMin = Math.min(i6, i11);
        int iMax = Math.max(((i10 - i6) + i11) - 1, i10 - 1);
        int windowCount = this.mediaSourceHolders.get(iMin).firstWindowIndexInChild;
        Util.moveItems(this.mediaSourceHolders, i6, i10, i11);
        while (iMin <= iMax) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(iMin);
            mediaSourceHolder.firstWindowIndexInChild = windowCount;
            windowCount += mediaSourceHolder.mediaSource.getTimeline().getWindowCount();
            iMin++;
        }
        return createTimeline();
    }

    public void prepare(TransferListener transferListener) {
        Assertions.checkState(!this.isPrepared);
        this.mediaTransferListener = transferListener;
        for (int i6 = 0; i6 < this.mediaSourceHolders.size(); i6++) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i6);
            prepareChildSource(mediaSourceHolder);
            this.enabledMediaSourceHolders.add(mediaSourceHolder);
        }
        this.isPrepared = true;
    }

    public void release() {
        for (MediaSourceAndListener mediaSourceAndListener : this.childSources.values()) {
            try {
                mediaSourceAndListener.mediaSource.releaseSource(mediaSourceAndListener.caller);
            } catch (RuntimeException e5) {
                Log.m1716e(TAG, "Failed to release child source.", e5);
            }
            mediaSourceAndListener.mediaSource.removeEventListener(mediaSourceAndListener.eventListener);
            mediaSourceAndListener.mediaSource.removeDrmEventListener(mediaSourceAndListener.eventListener);
        }
        this.childSources.clear();
        this.enabledMediaSourceHolders.clear();
        this.isPrepared = false;
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.checkNotNull(this.mediaSourceByMediaPeriod.remove(mediaPeriod));
        mediaSourceHolder.mediaSource.releasePeriod(mediaPeriod);
        mediaSourceHolder.activeMediaPeriodIds.remove(((MaskingMediaPeriod) mediaPeriod).f2962id);
        if (!this.mediaSourceByMediaPeriod.isEmpty()) {
            disableUnusedMediaSources();
        }
        maybeReleaseChildSource(mediaSourceHolder);
    }

    public Timeline removeMediaSourceRange(int i6, int i10, ShuffleOrder shuffleOrder) {
        Assertions.checkArgument(i6 >= 0 && i6 <= i10 && i10 <= getSize());
        this.shuffleOrder = shuffleOrder;
        removeMediaSourcesInternal(i6, i10);
        return createTimeline();
    }

    public Timeline setMediaSources(List<MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        removeMediaSourcesInternal(0, this.mediaSourceHolders.size());
        return addMediaSources(this.mediaSourceHolders.size(), list, shuffleOrder);
    }

    public Timeline setShuffleOrder(ShuffleOrder shuffleOrder) {
        int size = getSize();
        if (shuffleOrder.getLength() != size) {
            shuffleOrder = shuffleOrder.cloneAndClear().cloneAndInsert(0, size);
        }
        this.shuffleOrder = shuffleOrder;
        return createTimeline();
    }

    public Timeline updateMediaSourcesWithMediaItems(int i6, int i10, List<MediaItem> list) {
        Assertions.checkArgument(i6 >= 0 && i6 <= i10 && i10 <= getSize());
        Assertions.checkArgument(list.size() == i10 - i6);
        for (int i11 = i6; i11 < i10; i11++) {
            this.mediaSourceHolders.get(i11).mediaSource.updateMediaItem(list.get(i11 - i6));
        }
        return createTimeline();
    }
}
