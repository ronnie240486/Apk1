package okhttp3;

import com.lzy.okgo.cookie.SerializableCookie;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.Progress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3648f;
import p192r9.AbstractC3656n;
import p253x8.C4155r;

public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    public static final class Builder {
        private String domain;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private boolean persistent;
        private boolean secure;
        private String value;
        private long expiresAt = DatesKt.MAX_DATE;
        private String path = "/";

        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j10 = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j10, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
            }
            throw new NullPointerException("builder.domain == null");
        }

        public final Builder domain(String str) {
            AbstractC2796i.m5785f(str, SerializableCookie.DOMAIN);
            return domain(str, false);
        }

        public final Builder expiresAt(long j10) {
            if (j10 <= 0) {
                j10 = Long.MIN_VALUE;
            }
            if (j10 > DatesKt.MAX_DATE) {
                j10 = 253402300799999L;
            }
            this.expiresAt = j10;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String str) {
            AbstractC2796i.m5785f(str, SerializableCookie.DOMAIN);
            return domain(str, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String str) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            if (!AbstractC2796i.m5780a(AbstractC3648f.m7392n0(str).toString(), str)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.name = str;
            return this;
        }

        public final Builder path(String str) {
            AbstractC2796i.m5785f(str, "path");
            if (!AbstractC3656n.m7404V(str, "/", false)) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.path = str;
            return this;
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String str) {
            AbstractC2796i.m5785f(str, "value");
            if (!AbstractC2796i.m5780a(AbstractC3648f.m7392n0(str).toString(), str)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.value = str;
            return this;
        }

        private final Builder domain(String str, boolean z7) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException(AbstractC2460q.m5501o("unexpected domain: ", str));
            }
            this.domain = canonicalHost;
            this.hostOnly = z7;
            return this;
        }
    }

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        private final int dateCharacterOffset(String str, int i6, int i10, boolean z7) {
            while (i6 < i10) {
                char cCharAt = str.charAt(i6);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z7)) {
                    return i6;
                }
                i6++;
            }
            return i10;
        }

        public final boolean domainMatch(String str, String str2) {
            if (AbstractC2796i.m5780a(str, str2)) {
                return true;
            }
            return AbstractC3656n.m7397O(str, str2, false) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.canParseAsIpAddress(str);
        }

        private final String parseDomain(String str) {
            if (AbstractC3656n.m7397O(str, ".", false)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(AbstractC3648f.m7385g0(str, "."));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        private final long parseExpires(String str, int i6, int i10) {
            int iDateCharacterOffset = dateCharacterOffset(str, i6, i10, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int iM7381c0 = -1;
            int i14 = -1;
            int i15 = -1;
            while (iDateCharacterOffset < i10) {
                int iDateCharacterOffset2 = dateCharacterOffset(str, iDateCharacterOffset + 1, i10, true);
                matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
                if (i12 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String strGroup = matcher.group(1);
                    AbstractC2796i.m5784e(strGroup, "matcher.group(1)");
                    i12 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    AbstractC2796i.m5784e(strGroup2, "matcher.group(2)");
                    i14 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    AbstractC2796i.m5784e(strGroup3, "matcher.group(3)");
                    i15 = Integer.parseInt(strGroup3);
                } else if (i13 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String strGroup4 = matcher.group(1);
                    AbstractC2796i.m5784e(strGroup4, "matcher.group(1)");
                    i13 = Integer.parseInt(strGroup4);
                } else if (iM7381c0 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String strGroup5 = matcher.group(1);
                    AbstractC2796i.m5784e(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    AbstractC2796i.m5784e(locale, "US");
                    String lowerCase = strGroup5.toLowerCase(locale);
                    AbstractC2796i.m5784e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String strPattern = Cookie.MONTH_PATTERN.pattern();
                    AbstractC2796i.m5784e(strPattern, "MONTH_PATTERN.pattern()");
                    iM7381c0 = AbstractC3648f.m7381c0(strPattern, lowerCase, 0, false, 6) / 4;
                } else if (i11 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String strGroup6 = matcher.group(1);
                    AbstractC2796i.m5784e(strGroup6, "matcher.group(1)");
                    i11 = Integer.parseInt(strGroup6);
                }
                iDateCharacterOffset = dateCharacterOffset(str, iDateCharacterOffset2 + 1, i10, false);
            }
            if (70 <= i11 && i11 < 100) {
                i11 += 1900;
            }
            if (i11 >= 0 && i11 < 70) {
                i11 += 2000;
            }
            if (i11 < 1601) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (iM7381c0 == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i13 || i13 >= 32) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i12 < 0 || i12 >= 24) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i14 < 0 || i14 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i15 < 0 || i15 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i11);
            gregorianCalendar.set(2, iM7381c0 - 1);
            gregorianCalendar.set(5, i13);
            gregorianCalendar.set(11, i12);
            gregorianCalendar.set(12, i14);
            gregorianCalendar.set(13, i15);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long parseMaxAge(String str) {
            try {
                long j10 = Long.parseLong(str);
                if (j10 <= 0) {
                    return Long.MIN_VALUE;
                }
                return j10;
            } catch (NumberFormatException e5) {
                Pattern patternCompile = Pattern.compile("-?\\d+");
                AbstractC2796i.m5784e(patternCompile, "compile(...)");
                AbstractC2796i.m5785f(str, "input");
                if (patternCompile.matcher(str).matches()) {
                    return AbstractC3656n.m7404V(str, "-", false) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e5;
            }
        }

        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String strEncodedPath = httpUrl.encodedPath();
            if (AbstractC2796i.m5780a(strEncodedPath, str)) {
                return true;
            }
            return AbstractC3656n.m7404V(strEncodedPath, str, false) && (AbstractC3656n.m7397O(str, "/", false) || strEncodedPath.charAt(str.length()) == '/');
        }

        public final Cookie parse(HttpUrl httpUrl, String str) {
            AbstractC2796i.m5785f(httpUrl, Progress.URL);
            AbstractC2796i.m5785f(str, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), httpUrl, str);
        }

        public final Cookie parse$okhttp(long j10, HttpUrl httpUrl, String str) {
            long j11;
            long j12;
            Cookie cookie;
            String str2;
            String str3;
            AbstractC2796i.m5785f(httpUrl, Progress.URL);
            AbstractC2796i.m5785f(str, "setCookie");
            int iDelimiterOffset$default = Util.delimiterOffset$default(str, ';', 0, 0, 6, (Object) null);
            int iDelimiterOffset$default2 = Util.delimiterOffset$default(str, '=', 0, iDelimiterOffset$default, 2, (Object) null);
            if (iDelimiterOffset$default2 == iDelimiterOffset$default) {
                return null;
            }
            String strTrimSubstring$default = Util.trimSubstring$default(str, 0, iDelimiterOffset$default2, 1, null);
            if (strTrimSubstring$default.length() == 0 || Util.indexOfControlOrNonAscii(strTrimSubstring$default) != -1) {
                return null;
            }
            String strTrimSubstring = Util.trimSubstring(str, iDelimiterOffset$default2 + 1, iDelimiterOffset$default);
            if (Util.indexOfControlOrNonAscii(strTrimSubstring) != -1) {
                return null;
            }
            int i6 = iDelimiterOffset$default + 1;
            int length = str.length();
            String str4 = null;
            String domain = null;
            long maxAge = -1;
            boolean z7 = false;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = true;
            long expires = DatesKt.MAX_DATE;
            while (i6 < length) {
                int iDelimiterOffset = Util.delimiterOffset(str, ';', i6, length);
                int iDelimiterOffset2 = Util.delimiterOffset(str, '=', i6, iDelimiterOffset);
                String strTrimSubstring2 = Util.trimSubstring(str, i6, iDelimiterOffset2);
                String strTrimSubstring3 = iDelimiterOffset2 < iDelimiterOffset ? Util.trimSubstring(str, iDelimiterOffset2 + 1, iDelimiterOffset) : "";
                if (AbstractC3656n.m7398P(strTrimSubstring2, "expires")) {
                    try {
                        expires = parseExpires(strTrimSubstring3, 0, strTrimSubstring3.length());
                        z11 = true;
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (AbstractC3656n.m7398P(strTrimSubstring2, "max-age")) {
                    maxAge = parseMaxAge(strTrimSubstring3);
                    z11 = true;
                } else if (AbstractC3656n.m7398P(strTrimSubstring2, SerializableCookie.DOMAIN)) {
                    domain = parseDomain(strTrimSubstring3);
                    z12 = false;
                } else if (AbstractC3656n.m7398P(strTrimSubstring2, "path")) {
                    str4 = strTrimSubstring3;
                } else if (AbstractC3656n.m7398P(strTrimSubstring2, "secure")) {
                    z7 = true;
                } else if (AbstractC3656n.m7398P(strTrimSubstring2, "httponly")) {
                    z10 = true;
                }
                i6 = iDelimiterOffset + 1;
            }
            long j13 = Long.MIN_VALUE;
            if (maxAge == Long.MIN_VALUE) {
                j11 = j13;
            } else if (maxAge != -1) {
                j13 = j10 + (maxAge <= 9223372036854775L ? maxAge * ((long) 1000) : Long.MAX_VALUE);
                if (j13 >= j10) {
                    j12 = DatesKt.MAX_DATE;
                    if (j13 <= DatesKt.MAX_DATE) {
                        j11 = j13;
                    }
                } else {
                    j12 = DatesKt.MAX_DATE;
                }
                j11 = j12;
            } else {
                j11 = expires;
            }
            String strHost = httpUrl.host();
            if (domain == null) {
                str2 = strHost;
                cookie = null;
            } else {
                if (!domainMatch(strHost, domain)) {
                    return null;
                }
                cookie = null;
                str2 = domain;
            }
            if (strHost.length() != str2.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(str2) == null) {
                return cookie;
            }
            String strSubstring = "/";
            if (str4 == null || !AbstractC3656n.m7404V(str4, "/", false)) {
                String strEncodedPath = httpUrl.encodedPath();
                int iM7384f0 = AbstractC3648f.m7384f0(strEncodedPath, '/', 0, 6);
                if (iM7384f0 != 0) {
                    strSubstring = strEncodedPath.substring(0, iM7384f0);
                    AbstractC2796i.m5784e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                str3 = strSubstring;
            } else {
                str3 = str4;
            }
            return new Cookie(strTrimSubstring$default, strTrimSubstring, j11, str2, str3, z7, z10, z11, z12, null);
        }

        public final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
            AbstractC2796i.m5785f(httpUrl, Progress.URL);
            AbstractC2796i.m5785f(headers, "headers");
            List<String> listValues = headers.values(HttpHeaders.HEAD_KEY_SET_COOKIE);
            int size = listValues.size();
            ArrayList arrayList = null;
            for (int i6 = 0; i6 < size; i6++) {
                Cookie cookie = parse(httpUrl, listValues.get(i6));
                if (cookie != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(cookie);
                }
            }
            if (arrayList == null) {
                return C4155r.f14074a;
            }
            List<Cookie> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            AbstractC2796i.m5784e(listUnmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return listUnmodifiableList;
        }

        private Companion() {
        }
    }

    public Cookie(String str, String str2, long j10, String str3, String str4, boolean z7, boolean z10, boolean z11, boolean z12, AbstractC2793f abstractC2793f) {
        this(str, str2, j10, str3, str4, z7, z10, z11, z12);
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    public final String m8452deprecated_domain() {
        return this.domain;
    }

    public final long m8453deprecated_expiresAt() {
        return this.expiresAt;
    }

    public final boolean m8454deprecated_hostOnly() {
        return this.hostOnly;
    }

    public final boolean m8455deprecated_httpOnly() {
        return this.httpOnly;
    }

    public final String m8456deprecated_name() {
        return this.name;
    }

    public final String m8457deprecated_path() {
        return this.path;
    }

    public final boolean m8458deprecated_persistent() {
        return this.persistent;
    }

    public final boolean m8459deprecated_secure() {
        return this.secure;
    }

    public final String m8460deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (AbstractC2796i.m5780a(cookie.name, this.name) && AbstractC2796i.m5780a(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && AbstractC2796i.m5780a(cookie.domain, this.domain) && AbstractC2796i.m5780a(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        int iM14h = AbstractC0004e.m14h(AbstractC0004e.m14h(527, 31, this.name), 31, this.value);
        long j10 = this.expiresAt;
        return ((((((AbstractC0004e.m14h(AbstractC0004e.m14h((iM14h + ((int) (j10 ^ (j10 >>> 32)))) * 31, 31, this.domain), 31, this.path) + (this.secure ? 1231 : 1237)) * 31) + (this.httpOnly ? 1231 : 1237)) * 31) + (this.persistent ? 1231 : 1237)) * 31) + (this.hostOnly ? 1231 : 1237);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl httpUrl) {
        AbstractC2796i.m5785f(httpUrl, Progress.URL);
        if ((this.hostOnly ? AbstractC2796i.m5780a(httpUrl.host(), this.domain) : Companion.domainMatch(httpUrl.host(), this.domain)) && Companion.pathMatch(httpUrl, this.path)) {
            return !this.secure || httpUrl.isHttps();
        }
        return false;
    }

    public final String name() {
        return this.name;
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z7) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        AbstractC2796i.m5784e(string, "toString()");
        return string;
    }

    public final String value() {
        return this.value;
    }

    private Cookie(String str, String str2, long j10, String str3, String str4, boolean z7, boolean z10, boolean z11, boolean z12) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j10;
        this.domain = str3;
        this.path = str4;
        this.secure = z7;
        this.httpOnly = z10;
        this.persistent = z11;
        this.hostOnly = z12;
    }
}
