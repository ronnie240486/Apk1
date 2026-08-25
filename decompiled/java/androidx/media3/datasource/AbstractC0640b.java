package androidx.media3.datasource;

import android.net.http.HttpEngine;
import android.net.http.NetworkException;
import android.net.http.UrlResponseInfo;

public abstract class AbstractC0640b {
    public static HttpEngine m1754e(Object obj) {
        return (HttpEngine) obj;
    }

    public static NetworkException m1755f(Object obj) {
        return (NetworkException) obj;
    }

    public static UrlResponseInfo m1760k(Object obj) {
        return (UrlResponseInfo) obj;
    }

    public static boolean m1773x(Object obj) {
        return obj instanceof NetworkException;
    }
}
