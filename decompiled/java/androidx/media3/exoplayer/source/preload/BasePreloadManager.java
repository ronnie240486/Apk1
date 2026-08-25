package androidx.media3.exoplayer.source.preload;

import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.C0565C;
import androidx.media3.common.C0628x;
import androidx.media3.common.FlagSet;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.RunnableC0624i;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import p020b7.InterfaceC1339e0;

@UnstableApi
public abstract class BasePreloadManager<T> {
    private final Handler applicationHandler;
    private final ListenerSet<PreloadManagerListener> listeners;
    private final Object lock = new Object();
    private final Map<MediaItem, BasePreloadManager<T>.MediaSourceHolder> mediaItemMediaSourceHolderMap;
    private final MediaSource.Factory mediaSourceFactory;
    protected final Comparator<T> rankingDataComparator;
    private final PriorityQueue<BasePreloadManager<T>.MediaSourceHolder> sourceHolderPriorityQueue;
    private final TargetPreloadStatusControl<T> targetPreloadStatusControl;
    private TargetPreloadStatusControl.PreloadStatus targetPreloadStatusOfCurrentPreloadingSource;

    public static abstract class BuilderBase<T> {
        protected InterfaceC1339e0 mediaSourceFactorySupplier;
        protected final Comparator<T> rankingDataComparator;
        protected final TargetPreloadStatusControl<T> targetPreloadStatusControl;

        public BuilderBase(Comparator<T> comparator, TargetPreloadStatusControl<T> targetPreloadStatusControl, InterfaceC1339e0 interfaceC1339e0) {
            this.rankingDataComparator = comparator;
            this.targetPreloadStatusControl = targetPreloadStatusControl;
            this.mediaSourceFactorySupplier = interfaceC1339e0;
        }

        public abstract BasePreloadManager<T> build();
    }

    public final class MediaSourceHolder implements Comparable<BasePreloadManager<T>.MediaSourceHolder> {
        public final MediaSource mediaSource;
        public final T rankingData;
        public final long startPositionUs;

        public MediaSourceHolder(BasePreloadManager basePreloadManager, MediaSource mediaSource, T t5) {
            this(mediaSource, t5, C0565C.TIME_UNSET);
        }

        public MediaSourceHolder(MediaSource mediaSource, T t5, long j10) {
            this.mediaSource = mediaSource;
            this.rankingData = t5;
            this.startPositionUs = j10;
        }

        @Override
        public int compareTo(BasePreloadManager<T>.MediaSourceHolder mediaSourceHolder) {
            return BasePreloadManager.this.rankingDataComparator.compare(this.rankingData, mediaSourceHolder.rankingData);
        }
    }

    public BasePreloadManager(Comparator<T> comparator, TargetPreloadStatusControl<T> targetPreloadStatusControl, MediaSource.Factory factory) {
        Handler handlerCreateHandlerForCurrentOrMainLooper = Util.createHandlerForCurrentOrMainLooper();
        this.applicationHandler = handlerCreateHandlerForCurrentOrMainLooper;
        this.rankingDataComparator = comparator;
        this.targetPreloadStatusControl = targetPreloadStatusControl;
        this.mediaSourceFactory = factory;
        this.listeners = new ListenerSet<>(handlerCreateHandlerForCurrentOrMainLooper.getLooper(), Clock.DEFAULT, new C0923b());
        this.mediaItemMediaSourceHolderMap = new HashMap();
        this.sourceHolderPriorityQueue = new PriorityQueue<>();
    }

    private boolean isPreloading(MediaSource mediaSource) {
        return !this.sourceHolderPriorityQueue.isEmpty() && ((MediaSourceHolder) Assertions.checkNotNull(this.sourceHolderPriorityQueue.peek())).mediaSource == mediaSource;
    }

    public static void lambda$onPreloadCompleted$1(MediaSource mediaSource, PreloadManagerListener preloadManagerListener) {
        preloadManagerListener.onCompleted(mediaSource.getMediaItem());
    }

    public void lambda$onPreloadCompleted$2(MediaSource mediaSource) {
        this.listeners.sendEvent(-1, new C0628x(1, mediaSource));
        lambda$onPreloadSkipped$5(mediaSource);
    }

    public void lambda$onPreloadError$4(PreloadException preloadException, MediaSource mediaSource) {
        this.listeners.sendEvent(-1, new C0628x(2, preloadException));
        lambda$onPreloadSkipped$5(mediaSource);
    }

    public void lambda$onPreloadSkipped$5(MediaSource mediaSource) {
        synchronized (this.lock) {
            try {
                if (isPreloading(mediaSource)) {
                    do {
                        this.sourceHolderPriorityQueue.poll();
                        if (this.sourceHolderPriorityQueue.isEmpty()) {
                            break;
                        }
                    } while (!maybeStartPreloadNextSource());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean maybeStartPreloadNextSource() {
        if (!shouldStartPreloadingNextSource()) {
            return false;
        }
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.checkNotNull(this.sourceHolderPriorityQueue.peek());
        TargetPreloadStatusControl.PreloadStatus targetPreloadStatus = this.targetPreloadStatusControl.getTargetPreloadStatus(mediaSourceHolder.rankingData);
        this.targetPreloadStatusOfCurrentPreloadingSource = targetPreloadStatus;
        if (targetPreloadStatus != null) {
            preloadSourceInternal(mediaSourceHolder.mediaSource, mediaSourceHolder.startPositionUs);
            return true;
        }
        clearSourceInternal(mediaSourceHolder.mediaSource);
        return false;
    }

    private void verifyApplicationThread() {
        if (Looper.myLooper() != this.applicationHandler.getLooper()) {
            throw new IllegalStateException("Preload manager is accessed on the wrong thread.");
        }
    }

    public final void add(MediaItem mediaItem, T t5) {
        add(this.mediaSourceFactory.createMediaSource(mediaItem), t5);
    }

    public void addListener(PreloadManagerListener preloadManagerListener) {
        this.listeners.add(preloadManagerListener);
    }

    public void clearListeners() {
        verifyApplicationThread();
        this.listeners.clear();
    }

    public abstract void clearSourceInternal(MediaSource mediaSource);

    public final MediaSource getMediaSource(MediaItem mediaItem) {
        if (this.mediaItemMediaSourceHolderMap.containsKey(mediaItem)) {
            return this.mediaItemMediaSourceHolderMap.get(mediaItem).mediaSource;
        }
        return null;
    }

    public final int getSourceCount() {
        return this.mediaItemMediaSourceHolderMap.size();
    }

    public final TargetPreloadStatusControl.PreloadStatus getTargetPreloadStatus(MediaSource mediaSource) {
        synchronized (this.lock) {
            try {
                if (!isPreloading(mediaSource)) {
                    return null;
                }
                return this.targetPreloadStatusOfCurrentPreloadingSource;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void invalidate() {
        synchronized (this.lock) {
            try {
                this.sourceHolderPriorityQueue.clear();
                this.sourceHolderPriorityQueue.addAll(this.mediaItemMediaSourceHolderMap.values());
                while (!this.sourceHolderPriorityQueue.isEmpty() && !maybeStartPreloadNextSource()) {
                    this.sourceHolderPriorityQueue.poll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onPreloadCompleted(MediaSource mediaSource) {
        synchronized (this.lock) {
            try {
                if (isPreloading(mediaSource)) {
                    this.applicationHandler.post(new RunnableC0922a(this, mediaSource, 0));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onPreloadError(PreloadException preloadException, MediaSource mediaSource) {
        synchronized (this.lock) {
            try {
                if (isPreloading(mediaSource)) {
                    this.applicationHandler.post(new RunnableC0624i(this, preloadException, mediaSource, 4));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onPreloadSkipped(MediaSource mediaSource) {
        synchronized (this.lock) {
            try {
                if (isPreloading(mediaSource)) {
                    this.applicationHandler.post(new RunnableC0922a(this, mediaSource, 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void preloadSourceInternal(MediaSource mediaSource, long j10);

    public final void release() {
        reset();
        releaseInternal();
        clearListeners();
    }

    public abstract void releaseSourceInternal(MediaSource mediaSource);

    public final boolean remove(MediaItem mediaItem) {
        if (!this.mediaItemMediaSourceHolderMap.containsKey(mediaItem)) {
            return false;
        }
        MediaSource mediaSource = this.mediaItemMediaSourceHolderMap.get(mediaItem).mediaSource;
        this.mediaItemMediaSourceHolderMap.remove(mediaItem);
        releaseSourceInternal(mediaSource);
        return true;
    }

    public void removeListener(PreloadManagerListener preloadManagerListener) {
        verifyApplicationThread();
        this.listeners.remove(preloadManagerListener);
    }

    public final void reset() {
        Iterator<BasePreloadManager<T>.MediaSourceHolder> it = this.mediaItemMediaSourceHolderMap.values().iterator();
        while (it.hasNext()) {
            releaseSourceInternal(it.next().mediaSource);
        }
        this.mediaItemMediaSourceHolderMap.clear();
        synchronized (this.lock) {
            this.sourceHolderPriorityQueue.clear();
            this.targetPreloadStatusOfCurrentPreloadingSource = null;
        }
    }

    public boolean shouldStartPreloadingNextSource() {
        return true;
    }

    public final void add(MediaSource mediaSource, T t5) {
        MediaSource mediaSourceCreateMediaSourceForPreloading = createMediaSourceForPreloading(mediaSource);
        this.mediaItemMediaSourceHolderMap.put(mediaSourceCreateMediaSourceForPreloading.getMediaItem(), new MediaSourceHolder(this, mediaSourceCreateMediaSourceForPreloading, t5));
    }

    public final boolean remove(MediaSource mediaSource) {
        MediaItem mediaItem = mediaSource.getMediaItem();
        if (!this.mediaItemMediaSourceHolderMap.containsKey(mediaItem) || mediaSource != this.mediaItemMediaSourceHolderMap.get(mediaItem).mediaSource) {
            return false;
        }
        this.mediaItemMediaSourceHolderMap.remove(mediaItem);
        releaseSourceInternal(mediaSource);
        return true;
    }

    public void releaseInternal() {
    }

    public MediaSource createMediaSourceForPreloading(MediaSource mediaSource) {
        return mediaSource;
    }

    public static void lambda$new$0(PreloadManagerListener preloadManagerListener, FlagSet flagSet) {
    }
}
