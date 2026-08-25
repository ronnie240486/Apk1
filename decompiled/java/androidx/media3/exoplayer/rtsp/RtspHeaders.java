package androidx.media3.exoplayer.rtsp;

import androidx.media3.common.util.Util;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p020b7.AbstractC1332b;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2267p1;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2203g0;
import p041d7.C2217i0;
import p041d7.C2273q0;
import p041d7.C2288s1;
import p041d7.C2307v1;
import p041d7.C2313w1;
import p041d7.C2325y1;

final class RtspHeaders {
    public static final String ACCEPT = "Accept";
    public static final String ALLOW = "Allow";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BANDWIDTH = "Bandwidth";
    public static final String BLOCKSIZE = "Blocksize";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONNECTION = "Connection";
    public static final String CONTENT_BASE = "Content-Base";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_LANGUAGE = "Content-Language";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_LOCATION = "Content-Location";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CSEQ = "CSeq";
    public static final String DATE = "Date";
    public static final RtspHeaders EMPTY = new Builder().build();
    public static final String EXPIRES = "Expires";
    public static final String LOCATION = "Location";
    public static final String PROXY_AUTHENTICATE = "Proxy-Authenticate";
    public static final String PROXY_REQUIRE = "Proxy-Require";
    public static final String PUBLIC = "Public";
    public static final String RANGE = "Range";
    public static final String RTCP_INTERVAL = "RTCP-Interval";
    public static final String RTP_INFO = "RTP-Info";
    public static final String SCALE = "Scale";
    public static final String SESSION = "Session";
    public static final String SPEED = "Speed";
    public static final String SUPPORTED = "Supported";
    public static final String TIMESTAMP = "Timestamp";
    public static final String TRANSPORT = "Transport";
    public static final String USER_AGENT = "User-Agent";
    public static final String VIA = "Via";
    public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
    private final C2313w1 namesAndValues;

    public static final class Builder {
        private final C2307v1 namesAndValuesBuilder;

        public Builder add(String str, String str2) {
            this.namesAndValuesBuilder.m5284e(RtspHeaders.convertToStandardHeaderName(str.trim()), str2.trim());
            return this;
        }

        public Builder addAll(List<String> list) {
            for (int i6 = 0; i6 < list.size(); i6++) {
                String[] strArrSplitAtFirst = Util.splitAtFirst(list.get(i6), ":\\s?");
                if (strArrSplitAtFirst.length == 2) {
                    add(strArrSplitAtFirst[0], strArrSplitAtFirst[1]);
                }
            }
            return this;
        }

        public RtspHeaders build() {
            return new RtspHeaders(this);
        }

        public Builder() {
            this.namesAndValuesBuilder = new C2307v1();
        }

        public Builder addAll(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                add(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder(String str, String str2, int i6) {
            this();
            add("User-Agent", str);
            add(RtspHeaders.CSEQ, String.valueOf(i6));
            if (str2 != null) {
                add(RtspHeaders.SESSION, str2);
            }
        }

        private Builder(C2307v1 c2307v1) {
            this.namesAndValuesBuilder = c2307v1;
        }
    }

    public static String convertToStandardHeaderName(String str) {
        if (AbstractC1332b.m3226q(str, "Accept")) {
            return "Accept";
        }
        if (AbstractC1332b.m3226q(str, ALLOW)) {
            return ALLOW;
        }
        if (AbstractC1332b.m3226q(str, AUTHORIZATION)) {
            return AUTHORIZATION;
        }
        if (AbstractC1332b.m3226q(str, BANDWIDTH)) {
            return BANDWIDTH;
        }
        if (AbstractC1332b.m3226q(str, BLOCKSIZE)) {
            return BLOCKSIZE;
        }
        if (AbstractC1332b.m3226q(str, "Cache-Control")) {
            return "Cache-Control";
        }
        if (AbstractC1332b.m3226q(str, "Connection")) {
            return "Connection";
        }
        if (AbstractC1332b.m3226q(str, CONTENT_BASE)) {
            return CONTENT_BASE;
        }
        if (AbstractC1332b.m3226q(str, "Content-Encoding")) {
            return "Content-Encoding";
        }
        if (AbstractC1332b.m3226q(str, CONTENT_LANGUAGE)) {
            return CONTENT_LANGUAGE;
        }
        if (AbstractC1332b.m3226q(str, "Content-Length")) {
            return "Content-Length";
        }
        if (AbstractC1332b.m3226q(str, CONTENT_LOCATION)) {
            return CONTENT_LOCATION;
        }
        if (AbstractC1332b.m3226q(str, "Content-Type")) {
            return "Content-Type";
        }
        if (AbstractC1332b.m3226q(str, CSEQ)) {
            return CSEQ;
        }
        if (AbstractC1332b.m3226q(str, "Date")) {
            return "Date";
        }
        if (AbstractC1332b.m3226q(str, "Expires")) {
            return "Expires";
        }
        if (AbstractC1332b.m3226q(str, "Location")) {
            return "Location";
        }
        if (AbstractC1332b.m3226q(str, PROXY_AUTHENTICATE)) {
            return PROXY_AUTHENTICATE;
        }
        if (AbstractC1332b.m3226q(str, PROXY_REQUIRE)) {
            return PROXY_REQUIRE;
        }
        if (AbstractC1332b.m3226q(str, PUBLIC)) {
            return PUBLIC;
        }
        if (AbstractC1332b.m3226q(str, "Range")) {
            return "Range";
        }
        if (AbstractC1332b.m3226q(str, RTP_INFO)) {
            return RTP_INFO;
        }
        if (AbstractC1332b.m3226q(str, RTCP_INTERVAL)) {
            return RTCP_INTERVAL;
        }
        if (AbstractC1332b.m3226q(str, SCALE)) {
            return SCALE;
        }
        if (AbstractC1332b.m3226q(str, SESSION)) {
            return SESSION;
        }
        if (AbstractC1332b.m3226q(str, SPEED)) {
            return SPEED;
        }
        if (AbstractC1332b.m3226q(str, SUPPORTED)) {
            return SUPPORTED;
        }
        if (AbstractC1332b.m3226q(str, TIMESTAMP)) {
            return TIMESTAMP;
        }
        if (AbstractC1332b.m3226q(str, TRANSPORT)) {
            return TRANSPORT;
        }
        if (AbstractC1332b.m3226q(str, "User-Agent")) {
            return "User-Agent";
        }
        if (AbstractC1332b.m3226q(str, VIA)) {
            return VIA;
        }
        return AbstractC1332b.m3226q(str, WWW_AUTHENTICATE) ? WWW_AUTHENTICATE : str;
    }

    public C2313w1 asMultiMap() {
        return this.namesAndValues;
    }

    public Builder buildUpon() {
        C2307v1 c2307v1 = new C2307v1();
        for (Map.Entry entry : this.namesAndValues.mo5173d().entrySet()) {
            Object key = entry.getKey();
            Iterable iterable = (Iterable) entry.getValue();
            if (key == null) {
                throw new NullPointerException("null key in entry: null=" + AbstractC2182d0.m5134F(iterable));
            }
            Iterator it = iterable.iterator();
            if (it.hasNext()) {
                C2217i0 c2217i0M5208a = (C2217i0) c2307v1.f7850a;
                if (c2217i0M5208a == null) {
                    c2217i0M5208a = C2217i0.m5208a();
                    c2307v1.f7850a = c2217i0M5208a;
                }
                AbstractC2267p1 abstractC2267p1Mo5118b = (AbstractC2267p1) c2217i0M5208a.get(key);
                if (abstractC2267p1Mo5118b == null) {
                    abstractC2267p1Mo5118b = c2307v1.mo5118b(c2307v1.mo5117a(iterable));
                    C2217i0 c2217i0M5208a2 = (C2217i0) c2307v1.f7850a;
                    if (c2217i0M5208a2 == null) {
                        c2217i0M5208a2 = C2217i0.m5208a();
                        c2307v1.f7850a = c2217i0M5208a2;
                    }
                    c2217i0M5208a2.put(key, abstractC2267p1Mo5118b);
                }
                while (it.hasNext()) {
                    Object next = it.next();
                    AbstractC2182d0.m5140c(key, next);
                    abstractC2267p1Mo5118b.mo5221b(next);
                }
            }
        }
        return new Builder(c2307v1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RtspHeaders) {
            return this.namesAndValues.equals(((RtspHeaders) obj).namesAndValues);
        }
        return false;
    }

    public String get(String str) {
        AbstractC2301u1 abstractC2301u1Values = values(str);
        if (abstractC2301u1Values.isEmpty()) {
            return null;
        }
        return (String) AbstractC2182d0.m5151n(abstractC2301u1Values);
    }

    public int hashCode() {
        return this.namesAndValues.hashCode();
    }

    public AbstractC2301u1 values(String str) {
        return this.namesAndValues.get(convertToStandardHeaderName(str));
    }

    private RtspHeaders(Builder builder) {
        C2313w1 c2313w1;
        C2217i0 c2217i0 = (C2217i0) builder.namesAndValuesBuilder.f7850a;
        if (c2217i0 == null) {
            c2313w1 = C2273q0.f8027h;
        } else {
            Collection collectionEntrySet = c2217i0.entrySet();
            if (((AbstractCollection) collectionEntrySet).isEmpty()) {
                c2313w1 = C2273q0.f8027h;
            } else {
                C2203g0<Map.Entry> c2203g0 = (C2203g0) collectionEntrySet;
                C2325y1 c2325y1 = new C2325y1(((C2217i0) c2203g0.f7904b).size());
                int i6 = 0;
                for (Map.Entry entry : c2203g0) {
                    Object key = entry.getKey();
                    C2180c5 c2180c5M5262g = ((C2288s1) entry.getValue()).m5262g();
                    c2325y1.m5292b(key, c2180c5M5262g);
                    i6 += c2180c5M5262g.f7864d;
                }
                c2313w1 = new C2313w1(c2325y1.m5291a(), i6);
            }
        }
        this.namesAndValues = c2313w1;
    }
}
