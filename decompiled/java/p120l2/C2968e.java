package p120l2;

import android.graphics.Bitmap;
import com.lzy.okgo.model.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import p103j9.AbstractC2796i;
import p185r2.AbstractC3587f;
import p185r2.AbstractC3596o;
import p192r9.AbstractC3655m;
import p192r9.AbstractC3656n;

public final class C2968e {

    public final Request f10158a;

    public final C2966c f10159b;

    public final Date f10160c;

    public final String f10161d;

    public final Date f10162e;

    public final String f10163f;

    public final Date f10164g;

    public final long f10165h;

    public final long f10166i;

    public final String f10167j;

    public final int f10168k;

    public C2968e(Request request, C2966c c2966c) {
        int i6;
        this.f10158a = request;
        this.f10159b = c2966c;
        this.f10168k = -1;
        if (c2966c != null) {
            this.f10165h = c2966c.f10154c;
            this.f10166i = c2966c.f10155d;
            Headers headers = c2966c.f10157f;
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                String strName = headers.name(i10);
                if (AbstractC3656n.m7398P(strName, "Date")) {
                    this.f10160c = headers.getDate("Date");
                    this.f10161d = headers.value(i10);
                } else if (AbstractC3656n.m7398P(strName, "Expires")) {
                    this.f10164g = headers.getDate("Expires");
                } else if (AbstractC3656n.m7398P(strName, HttpHeaders.HEAD_KEY_LAST_MODIFIED)) {
                    this.f10162e = headers.getDate(HttpHeaders.HEAD_KEY_LAST_MODIFIED);
                    this.f10163f = headers.value(i10);
                } else if (AbstractC3656n.m7398P(strName, HttpHeaders.HEAD_KEY_E_TAG)) {
                    this.f10167j = headers.value(i10);
                } else if (AbstractC3656n.m7398P(strName, "Age")) {
                    String strValue = headers.value(i10);
                    Bitmap.Config[] configArr = AbstractC3587f.f12065a;
                    Long lM7395M = AbstractC3655m.m7395M(strValue);
                    if (lM7395M != null) {
                        long jLongValue = lM7395M.longValue();
                        i6 = jLongValue > 2147483647L ? Integer.MAX_VALUE : jLongValue < 0 ? 0 : (int) jLongValue;
                    } else {
                        i6 = -1;
                    }
                    this.f10168k = i6;
                }
            }
        }
    }

    public final C2969f m6007a() {
        long time;
        String str;
        Request request = this.f10158a;
        C2966c c2966c = this.f10159b;
        if (c2966c == null) {
            return new C2969f(request, null);
        }
        if (request.isHttps() && !c2966c.f10156e) {
            return new C2969f(request, null);
        }
        ?? r10 = c2966c.f10152a;
        CacheControl cacheControl = (CacheControl) r10.getValue();
        if (request.cacheControl().noStore() || ((CacheControl) r10.getValue()).noStore() || AbstractC2796i.m5780a(c2966c.f10157f.get("Vary"), "*")) {
            return new C2969f(request, null);
        }
        CacheControl cacheControl2 = request.cacheControl();
        if (cacheControl2.noCache() || request.header(HttpHeaders.HEAD_KEY_IF_MODIFIED_SINCE) != null || request.header(HttpHeaders.HEAD_KEY_IF_NONE_MATCH) != null) {
            return new C2969f(request, null);
        }
        long time2 = this.f10166i;
        Date date = this.f10160c;
        long jMax = date != null ? Math.max(0L, time2 - date.getTime()) : 0L;
        int i6 = this.f10168k;
        if (i6 != -1) {
            jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i6));
        }
        long time3 = this.f10165h;
        long jLongValue = jMax + (time2 - time3) + (((Number) AbstractC3596o.f12089a.invoke()).longValue() - time2);
        CacheControl cacheControl3 = (CacheControl) r10.getValue();
        int iMaxAgeSeconds = cacheControl3.maxAgeSeconds();
        Date date2 = this.f10162e;
        if (iMaxAgeSeconds != -1) {
            time = TimeUnit.SECONDS.toMillis(cacheControl3.maxAgeSeconds());
        } else {
            Date date3 = this.f10164g;
            if (date3 != null) {
                if (date != null) {
                    time2 = date.getTime();
                }
                time = date3.getTime() - time2;
                if (time <= 0) {
                    time = 0;
                }
            } else if (date2 == null || request.url().query() != null) {
                time = 0;
            } else {
                if (date != null) {
                    time3 = date.getTime();
                }
                long time4 = time3 - date2.getTime();
                if (time4 > 0) {
                    time = time4 / ((long) 10);
                } else {
                    time = 0;
                }
            }
        }
        if (cacheControl2.maxAgeSeconds() != -1) {
            time = Math.min(time, TimeUnit.SECONDS.toMillis(cacheControl2.maxAgeSeconds()));
        }
        long millis = cacheControl2.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(cacheControl2.minFreshSeconds()) : 0L;
        long millis2 = (cacheControl.mustRevalidate() || cacheControl2.maxStaleSeconds() == -1) ? 0L : TimeUnit.SECONDS.toMillis(cacheControl2.maxStaleSeconds());
        if (!cacheControl.noCache() && jLongValue + millis < time + millis2) {
            return new C2969f(null, c2966c);
        }
        String str2 = this.f10167j;
        if (str2 != null) {
            str = HttpHeaders.HEAD_KEY_IF_NONE_MATCH;
        } else {
            if (date2 != null) {
                str2 = this.f10163f;
                AbstractC2796i.m5782c(str2);
            } else {
                if (date == null) {
                    return new C2969f(request, null);
                }
                str2 = this.f10161d;
                AbstractC2796i.m5782c(str2);
            }
            str = HttpHeaders.HEAD_KEY_IF_MODIFIED_SINCE;
        }
        return new C2969f(request.newBuilder().addHeader(str, str2).build(), c2966c);
    }
}
