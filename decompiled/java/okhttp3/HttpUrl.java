package okhttp3;

import androidx.media3.extractor.p010ts.PsExtractor;
import com.alibaba.fastjson.asm.Opcodes;
import com.bumptech.glide.AbstractC1465c;
import com.lzy.okgo.cookie.SerializableCookie;
import com.lzy.okgo.model.Progress;
import java.io.EOFException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import okio.Utf8;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p156o9.AbstractC3280d;
import p156o9.C3282f;
import p192r9.AbstractC3648f;
import p192r9.AbstractC3656n;
import p253x8.AbstractC4149l;
import p253x8.C4155r;
import p253x8.C4157t;

public final class HttpUrl {
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;
    public static final Companion Companion = new Companion(null);
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static final class Builder {
        public static final Companion Companion = new Companion(null);
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = "";
        private String encodedPassword = "";
        private int port = -1;

        public static final class Companion {
            public Companion(AbstractC2793f abstractC2793f) {
                this();
            }

            public final int parsePort(String str, int i6, int i10) {
                try {
                    int i11 = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i6, i10, "", false, false, false, false, null, 248, null));
                    if (1 > i11 || i11 >= 65536) {
                        return -1;
                    }
                    return i11;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            public final int portColonOffset(String str, int i6, int i10) {
                while (i6 < i10) {
                    char cCharAt = str.charAt(i6);
                    if (cCharAt == '[') {
                        do {
                            i6++;
                            if (i6 >= i10) {
                                break;
                            }
                        } while (str.charAt(i6) != ']');
                    } else if (cCharAt == ':') {
                        return i6;
                    }
                    i6++;
                }
                return i10;
            }

            public final int schemeDelimiterOffset(String str, int i6, int i10) {
                if (i10 - i6 < 2) {
                    return -1;
                }
                char cCharAt = str.charAt(i6);
                if ((AbstractC2796i.m5787h(cCharAt, 97) < 0 || AbstractC2796i.m5787h(cCharAt, 122) > 0) && (AbstractC2796i.m5787h(cCharAt, 65) < 0 || AbstractC2796i.m5787h(cCharAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    i6++;
                    if (i6 >= i10) {
                        return -1;
                    }
                    char cCharAt2 = str.charAt(i6);
                    if ('a' > cCharAt2 || cCharAt2 >= '{') {
                        if ('A' > cCharAt2 || cCharAt2 >= '[') {
                            if ('0' > cCharAt2 || cCharAt2 >= ':') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i6;
                                    }
                                    return -1;
                                }
                            }
                        }
                    }
                }
            }

            public final int slashCount(String str, int i6, int i10) {
                int i11 = 0;
                while (i6 < i10) {
                    char cCharAt = str.charAt(i6);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i11++;
                    i6++;
                }
                return i11;
            }

            private Companion() {
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i6 = this.port;
            if (i6 != -1) {
                return i6;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            AbstractC2796i.m5782c(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            return AbstractC2796i.m5780a(str, ".") || AbstractC3656n.m7398P(str, "%2e");
        }

        private final boolean isDotDot(String str) {
            return AbstractC2796i.m5780a(str, "..") || AbstractC3656n.m7398P(str, "%2e.") || AbstractC3656n.m7398P(str, ".%2e") || AbstractC3656n.m7398P(str, "%2e%2e");
        }

        private final void pop() {
            List<String> list = this.encodedPathSegments;
            if (list.remove(list.size() - 1).length() != 0 || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
            }
        }

        private final void push(String str, int i6, int i10, boolean z7, boolean z10) {
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i6, i10, HttpUrl.PATH_SEGMENT_ENCODE_SET, z10, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null);
            if (isDot(strCanonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(strCanonicalize$okhttp$default)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, strCanonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(strCanonicalize$okhttp$default);
            }
            if (z7) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            AbstractC2796i.m5782c(list);
            int size = list.size() - 2;
            int iM6598p = AbstractC3280d.m6598p(size, 0, -2);
            if (iM6598p > size) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                AbstractC2796i.m5782c(list2);
                if (AbstractC2796i.m5780a(str, list2.get(size))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    AbstractC2796i.m5782c(list3);
                    list3.remove(size + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    AbstractC2796i.m5782c(list4);
                    list4.remove(size);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    AbstractC2796i.m5782c(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (size == iM6598p) {
                    return;
                } else {
                    size -= 2;
                }
            }
        }

        private final void resolvePath(String str, int i6, int i10) {
            if (i6 == i10) {
                return;
            }
            char cCharAt = str.charAt(i6);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i6++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i11 = i6;
                while (i11 < i10) {
                    i6 = Util.delimiterOffset(str, "/\\", i11, i10);
                    boolean z7 = i6 < i10;
                    push(str, i11, i6, z7, true);
                    if (z7) {
                        i11 = i6 + 1;
                    }
                }
                return;
            }
        }

        public final Builder addEncodedPathSegment(String str) {
            AbstractC2796i.m5785f(str, "encodedPathSegment");
            push(str, 0, str.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String str) {
            AbstractC2796i.m5785f(str, "encodedPathSegments");
            return addPathSegments(str, true);
        }

        public final Builder addEncodedQueryParameter(String str, String str2) {
            AbstractC2796i.m5785f(str, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            AbstractC2796i.m5782c(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            AbstractC2796i.m5782c(list2);
            list2.add(str2 != null ? Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null) : null);
            return this;
        }

        public final Builder addPathSegment(String str) {
            AbstractC2796i.m5785f(str, "pathSegment");
            push(str, 0, str.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String str) {
            AbstractC2796i.m5785f(str, "pathSegments");
            return addPathSegments(str, false);
        }

        public final Builder addQueryParameter(String str, String str2) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            AbstractC2796i.m5782c(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            AbstractC2796i.m5782c(list2);
            list2.add(str2 != null ? Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null) : null);
            return this;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            Companion companion = HttpUrl.Companion;
            String strPercentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
            String strPercentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iEffectivePort = effectivePort();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(AbstractC4149l.m8193Q(list));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, (String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                arrayList = new ArrayList(AbstractC4149l.m8193Q(list2));
                for (String str3 : list2) {
                    arrayList.add(str3 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str3, 0, 0, true, 3, null) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, strPercentDecode$okhttp$default, strPercentDecode$okhttp$default2, str2, iEffectivePort, arrayList2, arrayList, str4 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str4, 0, 0, false, 7, null) : null, toString());
        }

        public final Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, null, 179, null) : null;
            return this;
        }

        public final Builder encodedPassword(String str) {
            AbstractC2796i.m5785f(str, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        public final Builder encodedPath(String str) {
            AbstractC2796i.m5785f(str, "encodedPath");
            if (!AbstractC3656n.m7404V(str, "/", false)) {
                throw new IllegalArgumentException("unexpected encodedPath: ".concat(str).toString());
            }
            resolvePath(str, 0, str.length());
            return this;
        }

        public final Builder encodedQuery(String str) {
            List<String> queryNamesAndValues$okhttp;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null);
                if (strCanonicalize$okhttp$default != null) {
                    queryNamesAndValues$okhttp = companion.toQueryNamesAndValues$okhttp(strCanonicalize$okhttp$default);
                } else {
                    queryNamesAndValues$okhttp = null;
                }
            } else {
                queryNamesAndValues$okhttp = null;
            }
            this.encodedQueryNamesAndValues = queryNamesAndValues$okhttp;
            return this;
        }

        public final Builder encodedUsername(String str) {
            AbstractC2796i.m5785f(str, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        public final Builder fragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, null, Opcodes.NEW, null) : null;
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String str) {
            AbstractC2796i.m5785f(str, SerializableCookie.HOST);
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, 0, 0, false, 7, null));
            if (canonicalHost == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(str));
            }
            this.host = canonicalHost;
            return this;
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String str) {
            int iDelimiterOffset;
            int i6;
            int i10;
            boolean z7;
            String strConcat = str;
            AbstractC2796i.m5785f(strConcat, "input");
            int iIndexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(strConcat, 0, 0, 3, null);
            int iIndexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(strConcat, iIndexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = Companion;
            int iSchemeDelimiterOffset = companion.schemeDelimiterOffset(strConcat, iIndexOfFirstNonAsciiWhitespace$default, iIndexOfLastNonAsciiWhitespace$default);
            byte b8 = -1;
            if (iSchemeDelimiterOffset != -1) {
                if (AbstractC3656n.m7403U(strConcat, iIndexOfFirstNonAsciiWhitespace$default, "https:", true)) {
                    this.scheme = "https";
                    iIndexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    if (!AbstractC3656n.m7403U(strConcat, iIndexOfFirstNonAsciiWhitespace$default, "http:", true)) {
                        StringBuilder sb = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = strConcat.substring(0, iSchemeDelimiterOffset);
                        AbstractC2796i.m5784e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb.append(strSubstring);
                        sb.append('\'');
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.scheme = "http";
                    iIndexOfFirstNonAsciiWhitespace$default += 5;
                }
            } else {
                if (httpUrl == null) {
                    if (str.length() > 6) {
                        strConcat = AbstractC3648f.m7391m0(6, strConcat).concat("...");
                    }
                    throw new IllegalArgumentException(AbstractC2460q.m5501o("Expected URL scheme 'http' or 'https' but no scheme was found for ", strConcat));
                }
                this.scheme = httpUrl.scheme();
            }
            int iSlashCount = companion.slashCount(strConcat, iIndexOfFirstNonAsciiWhitespace$default, iIndexOfLastNonAsciiWhitespace$default);
            byte b10 = Utf8.REPLACEMENT_BYTE;
            byte b11 = 35;
            if (iSlashCount >= 2 || httpUrl == null || !AbstractC2796i.m5780a(httpUrl.scheme(), this.scheme)) {
                int i11 = iIndexOfFirstNonAsciiWhitespace$default + iSlashCount;
                boolean z10 = false;
                boolean z11 = false;
                while (true) {
                    iDelimiterOffset = Util.delimiterOffset(strConcat, "@/\\?#", i11, iIndexOfLastNonAsciiWhitespace$default);
                    byte bCharAt = iDelimiterOffset != iIndexOfLastNonAsciiWhitespace$default ? strConcat.charAt(iDelimiterOffset) : (byte) -1;
                    if (bCharAt == b8 || bCharAt == b11 || bCharAt == 47 || bCharAt == 92 || bCharAt == b10) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z10) {
                            i10 = iDelimiterOffset;
                            this.encodedPassword += "%40" + Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i11, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null);
                        } else {
                            int iDelimiterOffset2 = Util.delimiterOffset(strConcat, ':', i11, iDelimiterOffset);
                            Companion companion2 = HttpUrl.Companion;
                            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, str, i11, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null);
                            if (z11) {
                                strCanonicalize$okhttp$default = this.encodedUsername + "%40" + strCanonicalize$okhttp$default;
                            }
                            this.encodedUsername = strCanonicalize$okhttp$default;
                            i10 = iDelimiterOffset;
                            if (iDelimiterOffset2 != i10) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, str, iDelimiterOffset2 + 1, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null);
                                z7 = true;
                            } else {
                                z7 = z10;
                            }
                            z10 = z7;
                            z11 = true;
                        }
                        i11 = i10 + 1;
                        iIndexOfLastNonAsciiWhitespace$default = iIndexOfLastNonAsciiWhitespace$default;
                        b11 = 35;
                        b10 = Utf8.REPLACEMENT_BYTE;
                        b8 = -1;
                    }
                }
                i6 = iIndexOfLastNonAsciiWhitespace$default;
                Companion companion3 = Companion;
                int iPortColonOffset = companion3.portColonOffset(strConcat, i11, iDelimiterOffset);
                int i12 = iPortColonOffset + 1;
                if (i12 < iDelimiterOffset) {
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, i11, iPortColonOffset, false, 4, null));
                    int port = companion3.parsePort(strConcat, i12, iDelimiterOffset);
                    this.port = port;
                    if (port == -1) {
                        StringBuilder sb2 = new StringBuilder("Invalid URL port: \"");
                        String strSubstring2 = strConcat.substring(i12, iDelimiterOffset);
                        AbstractC2796i.m5784e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb2.append(strSubstring2);
                        sb2.append('\"');
                        throw new IllegalArgumentException(sb2.toString().toString());
                    }
                } else {
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, str, i11, iPortColonOffset, false, 4, null));
                    String str2 = this.scheme;
                    AbstractC2796i.m5782c(str2);
                    this.port = companion4.defaultPort(str2);
                }
                if (this.host == null) {
                    StringBuilder sb3 = new StringBuilder("Invalid URL host: \"");
                    String strSubstring3 = strConcat.substring(i11, iPortColonOffset);
                    AbstractC2796i.m5784e(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb3.append(strSubstring3);
                    sb3.append('\"');
                    throw new IllegalArgumentException(sb3.toString().toString());
                }
                iIndexOfFirstNonAsciiWhitespace$default = iDelimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (iIndexOfFirstNonAsciiWhitespace$default == iIndexOfLastNonAsciiWhitespace$default || strConcat.charAt(iIndexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i6 = iIndexOfLastNonAsciiWhitespace$default;
            }
            int i13 = i6;
            int iDelimiterOffset3 = Util.delimiterOffset(strConcat, "?#", iIndexOfFirstNonAsciiWhitespace$default, i13);
            resolvePath(strConcat, iIndexOfFirstNonAsciiWhitespace$default, iDelimiterOffset3);
            if (iDelimiterOffset3 < i13 && strConcat.charAt(iDelimiterOffset3) == '?') {
                int iDelimiterOffset4 = Util.delimiterOffset(strConcat, '#', iDelimiterOffset3, i13);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, str, iDelimiterOffset3 + 1, iDelimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
                iDelimiterOffset3 = iDelimiterOffset4;
            }
            if (iDelimiterOffset3 < i13 && strConcat.charAt(iDelimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, iDelimiterOffset3 + 1, i13, "", true, false, false, true, null, Opcodes.ARETURN, null);
            }
            return this;
        }

        public final Builder password(String str) {
            AbstractC2796i.m5785f(str, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final Builder port(int i6) {
            if (1 > i6 || i6 >= 65536) {
                throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "unexpected port: ").toString());
            }
            this.port = i6;
            return this;
        }

        public final Builder query(String str) {
            List<String> queryNamesAndValues$okhttp;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null);
                if (strCanonicalize$okhttp$default != null) {
                    queryNamesAndValues$okhttp = companion.toQueryNamesAndValues$okhttp(strCanonicalize$okhttp$default);
                } else {
                    queryNamesAndValues$okhttp = null;
                }
            } else {
                queryNamesAndValues$okhttp = null;
            }
            this.encodedQueryNamesAndValues = queryNamesAndValues$okhttp;
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String strReplaceAll;
            String str = this.host;
            if (str != null) {
                Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
                AbstractC2796i.m5784e(patternCompile, "compile(...)");
                strReplaceAll = patternCompile.matcher(str).replaceAll("");
                AbstractC2796i.m5784e(strReplaceAll, "replaceAll(...)");
            } else {
                strReplaceAll = null;
            }
            this.host = strReplaceAll;
            int size = this.encodedPathSegments.size();
            for (int i6 = 0; i6 < size; i6++) {
                List<String> list = this.encodedPathSegments;
                list.set(i6, Companion.canonicalize$okhttp$default(HttpUrl.Companion, list.get(i6), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    String str2 = list2.get(i10);
                    list2.set(i10, str2 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str3, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, Opcodes.IF_ICMPGT, null) : null;
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String str) {
            AbstractC2796i.m5785f(str, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        public final Builder removeAllQueryParameters(String str) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        public final Builder removePathSegment(int i6) {
            this.encodedPathSegments.remove(i6);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public final Builder scheme(String str) {
            AbstractC2796i.m5785f(str, "scheme");
            if (str.equalsIgnoreCase("http")) {
                this.scheme = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: ".concat(str));
                }
                this.scheme = "https";
            }
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            AbstractC2796i.m5785f(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i6, String str) {
            AbstractC2796i.m5785f(str, "encodedPathSegment");
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            this.encodedPathSegments.set(i6, strCanonicalize$okhttp$default);
            if (isDot(strCanonicalize$okhttp$default) || isDotDot(strCanonicalize$okhttp$default)) {
                throw new IllegalArgumentException("unexpected path segment: ".concat(str).toString());
            }
            return this;
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String str, String str2) {
            AbstractC2796i.m5785f(str, "encodedName");
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            AbstractC2796i.m5785f(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i6, String str) {
            AbstractC2796i.m5785f(str, "pathSegment");
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if (isDot(strCanonicalize$okhttp$default) || isDotDot(strCanonicalize$okhttp$default)) {
                throw new IllegalArgumentException("unexpected path segment: ".concat(str).toString());
            }
            this.encodedPathSegments.set(i6, strCanonicalize$okhttp$default);
            return this;
        }

        public final void setPort$okhttp(int i6) {
            this.port = i6;
        }

        public final Builder setQueryParameter(String str, String str2) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                if (AbstractC3648f.m7375W(str2, ':')) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int iEffectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 == null || iEffectivePort != HttpUrl.Companion.defaultPort(str3)) {
                    sb.append(':');
                    sb.append(iEffectivePort);
                }
            }
            Companion companion = HttpUrl.Companion;
            companion.toPathString$okhttp(this.encodedPathSegments, sb);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                List<String> list = this.encodedQueryNamesAndValues;
                AbstractC2796i.m5782c(list);
                companion.toQueryString$okhttp(list, sb);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            String string = sb.toString();
            AbstractC2796i.m5784e(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        public final Builder username(String str) {
            AbstractC2796i.m5785f(str, "username");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        private final Builder addPathSegments(String str, boolean z7) {
            int i6 = 0;
            do {
                int iDelimiterOffset = Util.delimiterOffset(str, "/\\", i6, str.length());
                push(str, i6, iDelimiterOffset, iDelimiterOffset < str.length(), z7);
                i6 = iDelimiterOffset + 1;
            } while (i6 <= str.length());
            return this;
        }
    }

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public static String canonicalize$okhttp$default(Companion companion, String str, int i6, int i10, String str2, boolean z7, boolean z10, boolean z11, boolean z12, Charset charset, int i11, Object obj) {
            return companion.canonicalize$okhttp(str, (i11 & 1) != 0 ? 0 : i6, (i11 & 2) != 0 ? str.length() : i10, str2, (i11 & 8) != 0 ? false : z7, (i11 & 16) != 0 ? false : z10, (i11 & 32) != 0 ? false : z11, (i11 & 64) != 0 ? false : z12, (i11 & 128) != 0 ? null : charset);
        }

        private final boolean isPercentEncoded(String str, int i6, int i10) {
            int i11 = i6 + 2;
            return i11 < i10 && str.charAt(i6) == '%' && Util.parseHexDigit(str.charAt(i6 + 1)) != -1 && Util.parseHexDigit(str.charAt(i11)) != -1;
        }

        public static String percentDecode$okhttp$default(Companion companion, String str, int i6, int i10, boolean z7, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i6 = 0;
            }
            if ((i11 & 2) != 0) {
                i10 = str.length();
            }
            if ((i11 & 4) != 0) {
                z7 = false;
            }
            return companion.percentDecode$okhttp(str, i6, i10, z7);
        }

        private final void writeCanonicalized(Buffer buffer, String str, int i6, int i10, String str2, boolean z7, boolean z10, boolean z11, boolean z12, Charset charset) throws EOFException {
            Buffer buffer2 = null;
            int iCharCount = i6;
            while (iCharCount < i10) {
                int iCodePointAt = str.codePointAt(iCharCount);
                if (!z7 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                    if (iCodePointAt == 43 && z11) {
                        buffer.writeUtf8(z7 ? "+" : "%2B");
                    } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z12) || AbstractC3648f.m7375W(str2, (char) iCodePointAt))) {
                        if (buffer2 == null) {
                            buffer2 = new Buffer();
                        }
                        if (charset != null || charset.equals(StandardCharsets.UTF_8)) {
                            buffer2.writeUtf8CodePoint(iCodePointAt);
                        } else {
                            buffer2.writeString(str, iCharCount, Character.charCount(iCodePointAt) + iCharCount, charset);
                        }
                        while (!buffer2.exhausted()) {
                            byte b8 = buffer2.readByte();
                            buffer.writeByte(37);
                            buffer.writeByte((int) HttpUrl.HEX_DIGITS[((b8 & 255) >> 4) & 15]);
                            buffer.writeByte((int) HttpUrl.HEX_DIGITS[b8 & 15]);
                        }
                    } else {
                        if (iCodePointAt == 37) {
                            if (z7) {
                                if (z10) {
                                    if (!isPercentEncoded(str, iCharCount, i10)) {
                                    }
                                }
                            }
                            if (buffer2 == null) {
                                buffer2 = new Buffer();
                            }
                            if (charset != null) {
                                buffer2.writeUtf8CodePoint(iCodePointAt);
                            } else {
                                buffer2.writeUtf8CodePoint(iCodePointAt);
                            }
                            while (!buffer2.exhausted()) {
                                byte b10 = buffer2.readByte();
                                buffer.writeByte(37);
                                buffer.writeByte((int) HttpUrl.HEX_DIGITS[((b10 & 255) >> 4) & 15]);
                                buffer.writeByte((int) HttpUrl.HEX_DIGITS[b10 & 15]);
                            }
                        }
                        buffer.writeUtf8CodePoint(iCodePointAt);
                    }
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
        }

        private final void writePercentDecoded(Buffer buffer, String str, int i6, int i10, boolean z7) {
            int i11;
            while (i6 < i10) {
                int iCodePointAt = str.codePointAt(i6);
                if (iCodePointAt == 37 && (i11 = i6 + 2) < i10) {
                    int hexDigit = Util.parseHexDigit(str.charAt(i6 + 1));
                    int hexDigit2 = Util.parseHexDigit(str.charAt(i11));
                    if (hexDigit == -1 || hexDigit2 == -1) {
                        buffer.writeUtf8CodePoint(iCodePointAt);
                        i6 += Character.charCount(iCodePointAt);
                    } else {
                        buffer.writeByte((hexDigit << 4) + hexDigit2);
                        i6 = Character.charCount(iCodePointAt) + i11;
                    }
                } else if (iCodePointAt == 43 && z7) {
                    buffer.writeByte(32);
                    i6++;
                } else {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                    i6 += Character.charCount(iCodePointAt);
                }
            }
        }

        public final HttpUrl m8492deprecated_get(String str) {
            AbstractC2796i.m5785f(str, Progress.URL);
            return get(str);
        }

        public final HttpUrl m8495deprecated_parse(String str) {
            AbstractC2796i.m5785f(str, Progress.URL);
            return parse(str);
        }

        public final String canonicalize$okhttp(String str, int i6, int i10, String str2, boolean z7, boolean z10, boolean z11, boolean z12, Charset charset) throws EOFException {
            AbstractC2796i.m5785f(str, "<this>");
            AbstractC2796i.m5785f(str2, "encodeSet");
            int iCharCount = i6;
            while (true) {
                if (iCharCount >= i10) {
                    String strSubstring = str.substring(i6, i10);
                    AbstractC2796i.m5784e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return strSubstring;
                }
                int iCodePointAt = str.codePointAt(iCharCount);
                if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z12) || AbstractC3648f.m7375W(str2, (char) iCodePointAt))) {
                    break;
                }
                if (iCodePointAt == 37) {
                    if (!z7) {
                        break;
                    }
                    if (z10) {
                        if (isPercentEncoded(str, iCharCount, i10)) {
                        }
                    }
                    if (iCodePointAt == 43) {
                    }
                    iCharCount += Character.charCount(iCodePointAt);
                } else if (iCodePointAt == 43 || !z11) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i6, iCharCount);
                writeCanonicalized(buffer, str, iCharCount, i10, str2, z7, z10, z11, z12, charset);
                return buffer.readUtf8();
            }
            Buffer buffer2 = new Buffer();
            buffer2.writeUtf8(str, i6, iCharCount);
            writeCanonicalized(buffer2, str, iCharCount, i10, str2, z7, z10, z11, z12, charset);
            return buffer2.readUtf8();
        }

        public final int defaultPort(String str) {
            AbstractC2796i.m5785f(str, "scheme");
            if (str.equals("http")) {
                return 80;
            }
            return str.equals("https") ? 443 : -1;
        }

        public final HttpUrl get(String str) {
            AbstractC2796i.m5785f(str, "<this>");
            return new Builder().parse$okhttp(null, str).build();
        }

        public final HttpUrl parse(String str) {
            AbstractC2796i.m5785f(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String percentDecode$okhttp(String str, int i6, int i10, boolean z7) {
            AbstractC2796i.m5785f(str, "<this>");
            for (int i11 = i6; i11 < i10; i11++) {
                char cCharAt = str.charAt(i11);
                if (cCharAt == '%' || (cCharAt == '+' && z7)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i6, i11);
                    writePercentDecoded(buffer, str, i11, i10, z7);
                    return buffer.readUtf8();
                }
            }
            String strSubstring = str.substring(i6, i10);
            AbstractC2796i.m5784e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void toPathString$okhttp(List<String> list, StringBuilder sb) {
            AbstractC2796i.m5785f(list, "<this>");
            AbstractC2796i.m5785f(sb, "out");
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                sb.append('/');
                sb.append(list.get(i6));
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String str) {
            AbstractC2796i.m5785f(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            while (i6 <= str.length()) {
                int iM7380b0 = AbstractC3648f.m7380b0(str, '&', i6, false, 4);
                if (iM7380b0 == -1) {
                    iM7380b0 = str.length();
                }
                int iM7380b1 = AbstractC3648f.m7380b0(str, '=', i6, false, 4);
                if (iM7380b1 == -1 || iM7380b1 > iM7380b0) {
                    String strSubstring = str.substring(i6, iM7380b0);
                    AbstractC2796i.m5784e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i6, iM7380b1);
                    AbstractC2796i.m5784e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iM7380b1 + 1, iM7380b0);
                    AbstractC2796i.m5784e(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i6 = iM7380b0 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> list, StringBuilder sb) {
            AbstractC2796i.m5785f(list, "<this>");
            AbstractC2796i.m5785f(sb, "out");
            C3282f c3282fM3479n = AbstractC1465c.m3479n(AbstractC1465c.m3480o(0, list.size()), 2);
            int i6 = c3282fM3479n.f10989a;
            int i10 = c3282fM3479n.f10990b;
            int i11 = c3282fM3479n.f10991c;
            if ((i11 <= 0 || i6 > i10) && (i11 >= 0 || i10 > i6)) {
                return;
            }
            while (true) {
                String str = list.get(i6);
                String str2 = list.get(i6 + 1);
                if (i6 > 0) {
                    sb.append('&');
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append('=');
                    sb.append(str2);
                }
                if (i6 == i10) {
                    return;
                } else {
                    i6 += i11;
                }
            }
        }

        private Companion() {
        }

        public final HttpUrl m8494deprecated_get(URL url) {
            AbstractC2796i.m5785f(url, Progress.URL);
            return get(url);
        }

        public final HttpUrl get(URL url) {
            AbstractC2796i.m5785f(url, "<this>");
            String string = url.toString();
            AbstractC2796i.m5784e(string, "toString()");
            return parse(string);
        }

        public final HttpUrl m8493deprecated_get(URI uri) {
            AbstractC2796i.m5785f(uri, "uri");
            return get(uri);
        }

        public final HttpUrl get(URI uri) {
            AbstractC2796i.m5785f(uri, "<this>");
            String string = uri.toString();
            AbstractC2796i.m5784e(string, "toString()");
            return parse(string);
        }
    }

    public HttpUrl(String str, String str2, String str3, String str4, int i6, List<String> list, List<String> list2, String str5, String str6) {
        AbstractC2796i.m5785f(str, "scheme");
        AbstractC2796i.m5785f(str2, "username");
        AbstractC2796i.m5785f(str3, "password");
        AbstractC2796i.m5785f(str4, SerializableCookie.HOST);
        AbstractC2796i.m5785f(list, "pathSegments");
        AbstractC2796i.m5785f(str6, Progress.URL);
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i6;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
        this.isHttps = AbstractC2796i.m5780a(str, "https");
    }

    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    public final String m8473deprecated_encodedFragment() {
        return encodedFragment();
    }

    public final String m8474deprecated_encodedPassword() {
        return encodedPassword();
    }

    public final String m8475deprecated_encodedPath() {
        return encodedPath();
    }

    public final List<String> m8476deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    public final String m8477deprecated_encodedQuery() {
        return encodedQuery();
    }

    public final String m8478deprecated_encodedUsername() {
        return encodedUsername();
    }

    public final String m8479deprecated_fragment() {
        return this.fragment;
    }

    public final String m8480deprecated_host() {
        return this.host;
    }

    public final String m8481deprecated_password() {
        return this.password;
    }

    public final List<String> m8482deprecated_pathSegments() {
        return this.pathSegments;
    }

    public final int m8483deprecated_pathSize() {
        return pathSize();
    }

    public final int m8484deprecated_port() {
        return this.port;
    }

    public final String m8485deprecated_query() {
        return query();
    }

    public final Set<String> m8486deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    public final int m8487deprecated_querySize() {
        return querySize();
    }

    public final String m8488deprecated_scheme() {
        return this.scheme;
    }

    public final URI m8489deprecated_uri() {
        return uri();
    }

    public final URL m8490deprecated_url() {
        return url();
    }

    public final String m8491deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String strSubstring = this.url.substring(AbstractC3648f.m7380b0(this.url, '#', 0, false, 6) + 1);
        AbstractC2796i.m5784e(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        String strSubstring = this.url.substring(AbstractC3648f.m7380b0(this.url, ':', this.scheme.length() + 3, false, 4) + 1, AbstractC3648f.m7380b0(this.url, '@', 0, false, 6));
        AbstractC2796i.m5784e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String encodedPath() {
        int iM7380b0 = AbstractC3648f.m7380b0(this.url, '/', this.scheme.length() + 3, false, 4);
        String str = this.url;
        String strSubstring = this.url.substring(iM7380b0, Util.delimiterOffset(str, "?#", iM7380b0, str.length()));
        AbstractC2796i.m5784e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final List<String> encodedPathSegments() {
        int iM7380b0 = AbstractC3648f.m7380b0(this.url, '/', this.scheme.length() + 3, false, 4);
        String str = this.url;
        int iDelimiterOffset = Util.delimiterOffset(str, "?#", iM7380b0, str.length());
        ArrayList arrayList = new ArrayList();
        while (iM7380b0 < iDelimiterOffset) {
            int i6 = iM7380b0 + 1;
            int iDelimiterOffset2 = Util.delimiterOffset(this.url, '/', i6, iDelimiterOffset);
            String strSubstring = this.url.substring(i6, iDelimiterOffset2);
            AbstractC2796i.m5784e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iM7380b0 = iDelimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iM7380b0 = AbstractC3648f.m7380b0(this.url, '?', 0, false, 6) + 1;
        String str = this.url;
        String strSubstring = this.url.substring(iM7380b0, Util.delimiterOffset(str, '#', iM7380b0, str.length()));
        AbstractC2796i.m5784e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String strSubstring = this.url.substring(length, Util.delimiterOffset(str, ":@", length, str.length()));
        AbstractC2796i.m5784e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && AbstractC2796i.m5780a(((HttpUrl) obj).url, this.url);
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    public final String queryParameter(String str) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        C3282f c3282fM3479n = AbstractC1465c.m3479n(AbstractC1465c.m3480o(0, list.size()), 2);
        int i6 = c3282fM3479n.f10989a;
        int i10 = c3282fM3479n.f10990b;
        int i11 = c3282fM3479n.f10991c;
        if ((i11 > 0 && i6 <= i10) || (i11 < 0 && i10 <= i6)) {
            while (!str.equals(this.queryNamesAndValues.get(i6))) {
                if (i6 != i10) {
                    i6 += i11;
                }
            }
            return this.queryNamesAndValues.get(i6 + 1);
        }
        return null;
    }

    public final String queryParameterName(int i6) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(i6 * 2);
        AbstractC2796i.m5782c(str);
        return str;
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return C4157t.f14076a;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        C3282f c3282fM3479n = AbstractC1465c.m3479n(AbstractC1465c.m3480o(0, this.queryNamesAndValues.size()), 2);
        int i6 = c3282fM3479n.f10989a;
        int i10 = c3282fM3479n.f10990b;
        int i11 = c3282fM3479n.f10991c;
        if ((i11 > 0 && i6 <= i10) || (i11 < 0 && i10 <= i6)) {
            while (true) {
                String str = this.queryNamesAndValues.get(i6);
                AbstractC2796i.m5782c(str);
                linkedHashSet.add(str);
                if (i6 == i10) {
                    break;
                }
                i6 += i11;
            }
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        AbstractC2796i.m5784e(setUnmodifiableSet, "unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public final String queryParameterValue(int i6) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i6 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String str) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        if (this.queryNamesAndValues == null) {
            return C4155r.f14074a;
        }
        ArrayList arrayList = new ArrayList();
        C3282f c3282fM3479n = AbstractC1465c.m3479n(AbstractC1465c.m3480o(0, this.queryNamesAndValues.size()), 2);
        int i6 = c3282fM3479n.f10989a;
        int i10 = c3282fM3479n.f10990b;
        int i11 = c3282fM3479n.f10991c;
        if ((i11 > 0 && i6 <= i10) || (i11 < 0 && i10 <= i6)) {
            while (true) {
                if (str.equals(this.queryNamesAndValues.get(i6))) {
                    arrayList.add(this.queryNamesAndValues.get(i6 + 1));
                }
                if (i6 == i10) {
                    break;
                }
                i6 += i11;
            }
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        AbstractC2796i.m5784e(listUnmodifiableList, "unmodifiableList(result)");
        return listUnmodifiableList;
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String redact() {
        Builder builderNewBuilder = newBuilder("/...");
        AbstractC2796i.m5782c(builderNewBuilder);
        return builderNewBuilder.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String str) {
        AbstractC2796i.m5785f(str, "link");
        Builder builderNewBuilder = newBuilder(str);
        if (builderNewBuilder != null) {
            return builderNewBuilder.build();
        }
        return null;
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String string = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e5) {
            try {
                Pattern patternCompile = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                AbstractC2796i.m5784e(patternCompile, "compile(...)");
                AbstractC2796i.m5785f(string, "input");
                String strReplaceAll = patternCompile.matcher(string).replaceAll("");
                AbstractC2796i.m5784e(strReplaceAll, "replaceAll(...)");
                URI uriCreate = URI.create(strReplaceAll);
                AbstractC2796i.m5784e(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e5);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e5) {
            throw new RuntimeException(e5);
        }
    }

    public final String username() {
        return this.username;
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public static final HttpUrl get(URL url) {
        return Companion.get(url);
    }

    public final Builder newBuilder(String str) {
        AbstractC2796i.m5785f(str, "link");
        try {
            return new Builder().parse$okhttp(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
