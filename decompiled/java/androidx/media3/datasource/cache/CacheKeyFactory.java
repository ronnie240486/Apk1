package androidx.media3.datasource.cache;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;
import p005a4.C0060s;

@UnstableApi
public interface CacheKeyFactory {
    public static final CacheKeyFactory DEFAULT = new C0060s(3);

    String buildCacheKey(DataSpec dataSpec);
}
