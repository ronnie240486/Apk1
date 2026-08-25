package okhttp3.internal;

import com.lzy.okgo.cookie.SerializableCookie;
import com.lzy.okgo.model.Progress;
import javax.net.ssl.SSLSocket;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import p103j9.AbstractC2796i;

public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str) {
        AbstractC2796i.m5785f(builder, "builder");
        AbstractC2796i.m5785f(str, "line");
        return builder.addLenient$okhttp(str);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z7) {
        AbstractC2796i.m5785f(connectionSpec, "connectionSpec");
        AbstractC2796i.m5785f(sSLSocket, "sslSocket");
        connectionSpec.apply$okhttp(sSLSocket, z7);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        AbstractC2796i.m5785f(cache, "cache");
        AbstractC2796i.m5785f(request, Progress.REQUEST);
        return cache.get$okhttp(request);
    }

    public static final String cookieToString(Cookie cookie, boolean z7) {
        AbstractC2796i.m5785f(cookie, SerializableCookie.COOKIE);
        return cookie.toString$okhttp(z7);
    }

    public static final Cookie parseCookie(long j10, HttpUrl httpUrl, String str) {
        AbstractC2796i.m5785f(httpUrl, Progress.URL);
        AbstractC2796i.m5785f(str, "setCookie");
        return Cookie.Companion.parse$okhttp(j10, httpUrl, str);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str, String str2) {
        AbstractC2796i.m5785f(builder, "builder");
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        AbstractC2796i.m5785f(str2, "value");
        return builder.addLenient$okhttp(str, str2);
    }
}
