package androidx.media3.datasource.cache;

import androidx.media3.datasource.DataSpec;

public abstract class AbstractC0644a {
    public static String m1778a(DataSpec dataSpec) {
        String str = dataSpec.key;
        return str != null ? str : dataSpec.uri.toString();
    }
}
