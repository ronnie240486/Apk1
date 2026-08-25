package okhttp3;

import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.lzy.okgo.cookie.SerializableCookie;
import com.lzy.okgo.model.Progress;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;
import p000a.AbstractC0004e;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3656n;
import p243w8.C4064f;
import p253x8.AbstractC4148k;
import p253x8.AbstractC4158u;

public final class Request {
    private final RequestBody body;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Map<Class<?>, Object> tags;
    private final HttpUrl url;

    public static class Builder {
        private RequestBody body;
        private Headers.Builder headers;
        private String method;
        private Map<Class<?>, Object> tags;
        private HttpUrl url;

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public static Builder delete$default(Builder builder, RequestBody requestBody, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i6 & 1) != 0) {
                requestBody = Util.EMPTY_REQUEST;
            }
            return builder.delete(requestBody);
        }

        public Builder addHeader(String str, String str2) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            AbstractC2796i.m5785f(str2, "value");
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            HttpUrl httpUrl = this.url;
            if (httpUrl != null) {
                return new Request(httpUrl, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
            }
            throw new IllegalStateException("url == null");
        }

        public Builder cacheControl(CacheControl cacheControl) {
            AbstractC2796i.m5785f(cacheControl, "cacheControl");
            String string = cacheControl.toString();
            return string.length() == 0 ? removeHeader("Cache-Control") : header("Cache-Control", string);
        }

        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        public Builder get() {
            return method("GET", null);
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder header(String str, String str2) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            AbstractC2796i.m5785f(str2, "value");
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            AbstractC2796i.m5785f(headers, "headers");
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            AbstractC2796i.m5785f(str, "method");
            if (str.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if (requestBody == null) {
                if (HttpMethod.requiresRequestBody(str)) {
                    throw new IllegalArgumentException(AbstractC0004e.m24r("method ", str, " must have a request body.").toString());
                }
            } else if (!HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException(AbstractC0004e.m24r("method ", str, " must not have a request body.").toString());
            }
            this.method = str;
            this.body = requestBody;
            return this;
        }

        public Builder patch(RequestBody requestBody) {
            AbstractC2796i.m5785f(requestBody, TtmlNode.TAG_BODY);
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            AbstractC2796i.m5785f(requestBody, TtmlNode.TAG_BODY);
            return method(HlsMediaPlaylist.Interstitial.CUE_TRIGGER_POST, requestBody);
        }

        public Builder put(RequestBody requestBody) {
            AbstractC2796i.m5785f(requestBody, TtmlNode.TAG_BODY);
            return method("PUT", requestBody);
        }

        public Builder removeHeader(String str) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            this.headers.removeAll(str);
            return this;
        }

        public final void setBody$okhttp(RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            AbstractC2796i.m5785f(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(String str) {
            AbstractC2796i.m5785f(str, "<set-?>");
            this.method = str;
        }

        public final void setTags$okhttp(Map<Class<?>, Object> map) {
            AbstractC2796i.m5785f(map, "<set-?>");
            this.tags = map;
        }

        public final void setUrl$okhttp(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public Builder tag(Object obj) {
            return tag(Object.class, obj);
        }

        public Builder url(HttpUrl httpUrl) {
            AbstractC2796i.m5785f(httpUrl, Progress.URL);
            this.url = httpUrl;
            return this;
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public <T> Builder tag(Class<? super T> cls, T t5) {
            AbstractC2796i.m5785f(cls, SessionDescription.ATTR_TYPE);
            if (t5 == null) {
                this.tags.remove(cls);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.tags;
                T tCast = cls.cast(t5);
                AbstractC2796i.m5782c(tCast);
                map.put(cls, tCast);
            }
            return this;
        }

        public Builder url(String str) {
            AbstractC2796i.m5785f(str, Progress.URL);
            if (AbstractC3656n.m7404V(str, "ws:", true)) {
                String strSubstring = str.substring(3);
                AbstractC2796i.m5784e(strSubstring, "this as java.lang.String).substring(startIndex)");
                str = "http:".concat(strSubstring);
            } else if (AbstractC3656n.m7404V(str, "wss:", true)) {
                String strSubstring2 = str.substring(4);
                AbstractC2796i.m5784e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                str = "https:".concat(strSubstring2);
            }
            return url(HttpUrl.Companion.get(str));
        }

        public Builder(Request request) {
            LinkedHashMap linkedHashMapM8199s;
            AbstractC2796i.m5785f(request, Progress.REQUEST);
            this.tags = new LinkedHashMap();
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            if (request.getTags$okhttp().isEmpty()) {
                linkedHashMapM8199s = new LinkedHashMap();
            } else {
                linkedHashMapM8199s = AbstractC4158u.m8199s(request.getTags$okhttp());
            }
            this.tags = linkedHashMapM8199s;
            this.headers = request.headers().newBuilder();
        }

        public Builder url(URL url) {
            AbstractC2796i.m5785f(url, Progress.URL);
            HttpUrl.Companion companion = HttpUrl.Companion;
            String string = url.toString();
            AbstractC2796i.m5784e(string, "url.toString()");
            return url(companion.get(string));
        }
    }

    public Request(HttpUrl httpUrl, String str, Headers headers, RequestBody requestBody, Map<Class<?>, ? extends Object> map) {
        AbstractC2796i.m5785f(httpUrl, Progress.URL);
        AbstractC2796i.m5785f(str, "method");
        AbstractC2796i.m5785f(headers, "headers");
        AbstractC2796i.m5785f(map, "tags");
        this.url = httpUrl;
        this.method = str;
        this.headers = headers;
        this.body = requestBody;
        this.tags = map;
    }

    public final RequestBody m8534deprecated_body() {
        return this.body;
    }

    public final CacheControl m8535deprecated_cacheControl() {
        return cacheControl();
    }

    public final Headers m8536deprecated_headers() {
        return this.headers;
    }

    public final String m8537deprecated_method() {
        return this.method;
    }

    public final HttpUrl m8538deprecated_url() {
        return this.url;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControl2 = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = cacheControl2;
        return cacheControl2;
    }

    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final String header(String str) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        return this.headers.get(str);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String method() {
        return this.method;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final Object tag() {
        return tag(Object.class);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i6 = 0;
            for (C4064f c4064f : this.headers) {
                int i10 = i6 + 1;
                if (i6 < 0) {
                    AbstractC4148k.m8192P();
                    throw null;
                }
                C4064f c4064f2 = c4064f;
                String str = (String) c4064f2.f13727a;
                String str2 = (String) c4064f2.f13728b;
                if (i6 > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                sb.append(str2);
                i6 = i10;
            }
            sb.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        String string = sb.toString();
        AbstractC2796i.m5784e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final List<String> headers(String str) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        return this.headers.values(str);
    }

    public final <T> T tag(Class<? extends T> cls) {
        AbstractC2796i.m5785f(cls, SessionDescription.ATTR_TYPE);
        return cls.cast(this.tags.get(cls));
    }
}
