package androidx.media3.datasource.cache;

import androidx.media3.common.util.UnstableApi;
import java.util.TreeSet;

@UnstableApi
public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor {
    private long currentSize;
    private final TreeSet<CacheSpan> leastRecentlyUsed = new TreeSet<>(new C0646c(0));
    private final long maxBytes;

    public LeastRecentlyUsedCacheEvictor(long j10) {
        this.maxBytes = j10;
    }

    public static int compare(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        long j10 = cacheSpan.lastTouchTimestamp;
        long j11 = cacheSpan2.lastTouchTimestamp;
        if (j10 - j11 == 0) {
            return cacheSpan.compareTo(cacheSpan2);
        }
        return j10 < j11 ? -1 : 1;
    }

    private void evictCache(Cache cache, long j10) {
        while (this.currentSize + j10 > this.maxBytes && !this.leastRecentlyUsed.isEmpty()) {
            cache.removeSpan(this.leastRecentlyUsed.first());
        }
    }

    @Override
    public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        this.leastRecentlyUsed.add(cacheSpan);
        this.currentSize += cacheSpan.length;
        evictCache(cache, 0L);
    }

    @Override
    public void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        this.leastRecentlyUsed.remove(cacheSpan);
        this.currentSize -= cacheSpan.length;
    }

    @Override
    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        onSpanRemoved(cache, cacheSpan);
        onSpanAdded(cache, cacheSpan2);
    }

    @Override
    public void onStartFile(Cache cache, String str, long j10, long j11) {
        if (j11 != -1) {
            evictCache(cache, j11);
        }
    }

    @Override
    public boolean requiresCacheSpanTouches() {
        return true;
    }

    @Override
    public void onCacheInitialized() {
    }
}
