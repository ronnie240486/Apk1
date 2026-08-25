package okhttp3;

import com.lzy.okgo.model.HttpHeaders;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import p000a.AbstractC0004e;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3648f;
import p192r9.AbstractC3656n;

public final class CacheControl {
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    public static final Companion Companion = new Companion(null);
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j10) {
            if (j10 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j10;
        }

        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        public final Builder maxAge(int i6, TimeUnit timeUnit) {
            AbstractC2796i.m5785f(timeUnit, "timeUnit");
            if (i6 < 0) {
                throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "maxAge < 0: ").toString());
            }
            this.maxAgeSeconds = clampToInt(timeUnit.toSeconds(i6));
            return this;
        }

        public final Builder maxStale(int i6, TimeUnit timeUnit) {
            AbstractC2796i.m5785f(timeUnit, "timeUnit");
            if (i6 < 0) {
                throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "maxStale < 0: ").toString());
            }
            this.maxStaleSeconds = clampToInt(timeUnit.toSeconds(i6));
            return this;
        }

        public final Builder minFresh(int i6, TimeUnit timeUnit) {
            AbstractC2796i.m5785f(timeUnit, "timeUnit");
            if (i6 < 0) {
                throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "minFresh < 0: ").toString());
            }
            this.minFreshSeconds = clampToInt(timeUnit.toSeconds(i6));
            return this;
        }

        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        private final int indexOfElement(String str, String str2, int i6) {
            int length = str.length();
            while (i6 < length) {
                if (AbstractC3648f.m7375W(str2, str.charAt(i6))) {
                    return i6;
                }
                i6++;
            }
            return str.length();
        }

        public static int indexOfElement$default(Companion companion, String str, String str2, int i6, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                i6 = 0;
            }
            return companion.indexOfElement(str, str2, i6);
        }

        public final CacheControl parse(Headers headers) {
            int i6;
            String str;
            int iIndexOfElement;
            int iIndexOfElement2;
            String string;
            String string2;
            Headers headers2 = headers;
            AbstractC2796i.m5785f(headers2, "headers");
            int size = headers.size();
            int i10 = 0;
            boolean z7 = true;
            String str2 = null;
            boolean z10 = false;
            boolean z11 = false;
            int nonNegativeInt = -1;
            int nonNegativeInt2 = -1;
            boolean z12 = false;
            boolean z13 = false;
            boolean z14 = false;
            int nonNegativeInt3 = -1;
            int nonNegativeInt4 = -1;
            boolean z15 = false;
            boolean z16 = false;
            boolean z17 = false;
            while (i10 < size) {
                String strName = headers2.name(i10);
                String strValue = headers2.value(i10);
                if (AbstractC3656n.m7398P(strName, "Cache-Control")) {
                    if (str2 == null) {
                        str2 = strValue;
                    }
                    iIndexOfElement = 0;
                    while (iIndexOfElement < strValue.length()) {
                        iIndexOfElement2 = indexOfElement(strValue, "=,;", iIndexOfElement);
                        String strSubstring = strValue.substring(iIndexOfElement, iIndexOfElement2);
                        AbstractC2796i.m5784e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        string = AbstractC3648f.m7392n0(strSubstring).toString();
                        if (iIndexOfElement2 != strValue.length()) {
                            size = size;
                            if (strValue.charAt(iIndexOfElement2) == ',' && strValue.charAt(iIndexOfElement2) != ';') {
                                int iIndexOfNonWhitespace = Util.indexOfNonWhitespace(strValue, iIndexOfElement2 + 1);
                                if (iIndexOfNonWhitespace >= strValue.length() || strValue.charAt(iIndexOfNonWhitespace) != '\"') {
                                    iIndexOfElement = indexOfElement(strValue, ",;", iIndexOfNonWhitespace);
                                    String strSubstring2 = strValue.substring(iIndexOfNonWhitespace, iIndexOfElement);
                                    AbstractC2796i.m5784e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                    string2 = AbstractC3648f.m7392n0(strSubstring2).toString();
                                } else {
                                    int i11 = iIndexOfNonWhitespace + 1;
                                    int iM7380b0 = AbstractC3648f.m7380b0(strValue, '\"', i11, false, 4);
                                    string2 = strValue.substring(i11, iM7380b0);
                                    AbstractC2796i.m5784e(string2, "this as java.lang.String…ing(startIndex, endIndex)");
                                    iIndexOfElement = iM7380b0 + 1;
                                }
                            }
                            if ("no-cache".equalsIgnoreCase(string)) {
                                z10 = true;
                            } else if ("no-store".equalsIgnoreCase(string)) {
                                z11 = true;
                            } else if ("max-age".equalsIgnoreCase(string)) {
                                nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                            } else if ("s-maxage".equalsIgnoreCase(string)) {
                                nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                            } else if ("private".equalsIgnoreCase(string)) {
                                z12 = true;
                            } else if ("public".equalsIgnoreCase(string)) {
                                z13 = true;
                            } else if ("must-revalidate".equalsIgnoreCase(string)) {
                                z14 = true;
                            } else if ("max-stale".equalsIgnoreCase(string)) {
                                nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                            } else if ("min-fresh".equalsIgnoreCase(string)) {
                                nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                            } else if ("only-if-cached".equalsIgnoreCase(string)) {
                                z15 = true;
                            } else if ("no-transform".equalsIgnoreCase(string)) {
                                z16 = true;
                            } else if ("immutable".equalsIgnoreCase(string)) {
                                z17 = true;
                            }
                        } else {
                            size = size;
                        }
                        iIndexOfElement = iIndexOfElement2 + 1;
                        string2 = null;
                        if ("no-cache".equalsIgnoreCase(string)) {
                            z10 = true;
                        } else if ("no-store".equalsIgnoreCase(string)) {
                            z11 = true;
                        } else if ("max-age".equalsIgnoreCase(string)) {
                            nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                        } else if ("s-maxage".equalsIgnoreCase(string)) {
                            nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                        } else if ("private".equalsIgnoreCase(string)) {
                            z12 = true;
                        } else if ("public".equalsIgnoreCase(string)) {
                            z13 = true;
                        } else if ("must-revalidate".equalsIgnoreCase(string)) {
                            z14 = true;
                        } else if ("max-stale".equalsIgnoreCase(string)) {
                            nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                        } else if ("min-fresh".equalsIgnoreCase(string)) {
                            nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                        } else if ("only-if-cached".equalsIgnoreCase(string)) {
                            z15 = true;
                        } else if ("no-transform".equalsIgnoreCase(string)) {
                            z16 = true;
                        } else if ("immutable".equalsIgnoreCase(string)) {
                            z17 = true;
                        }
                    }
                    i6 = size;
                    str = str2;
                    i10++;
                    headers2 = headers;
                    str2 = str;
                    size = i6;
                } else {
                    if (!AbstractC3656n.m7398P(strName, HttpHeaders.HEAD_KEY_PRAGMA)) {
                        i6 = size;
                        str = str2;
                    }
                    i10++;
                    headers2 = headers;
                    str2 = str;
                    size = i6;
                }
                z7 = false;
                iIndexOfElement = 0;
                while (iIndexOfElement < strValue.length()) {
                    iIndexOfElement2 = indexOfElement(strValue, "=,;", iIndexOfElement);
                    String strSubstring3 = strValue.substring(iIndexOfElement, iIndexOfElement2);
                    AbstractC2796i.m5784e(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    string = AbstractC3648f.m7392n0(strSubstring3).toString();
                    if (iIndexOfElement2 != strValue.length()) {
                        size = size;
                        if (strValue.charAt(iIndexOfElement2) == ',') {
                        }
                        if ("no-cache".equalsIgnoreCase(string)) {
                            z10 = true;
                        } else if ("no-store".equalsIgnoreCase(string)) {
                            z11 = true;
                        } else if ("max-age".equalsIgnoreCase(string)) {
                            nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                        } else if ("s-maxage".equalsIgnoreCase(string)) {
                            nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                        } else if ("private".equalsIgnoreCase(string)) {
                            z12 = true;
                        } else if ("public".equalsIgnoreCase(string)) {
                            z13 = true;
                        } else if ("must-revalidate".equalsIgnoreCase(string)) {
                            z14 = true;
                        } else if ("max-stale".equalsIgnoreCase(string)) {
                            nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                        } else if ("min-fresh".equalsIgnoreCase(string)) {
                            nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                        } else if ("only-if-cached".equalsIgnoreCase(string)) {
                            z15 = true;
                        } else if ("no-transform".equalsIgnoreCase(string)) {
                            z16 = true;
                        } else if ("immutable".equalsIgnoreCase(string)) {
                            z17 = true;
                        }
                    } else {
                        size = size;
                    }
                    iIndexOfElement = iIndexOfElement2 + 1;
                    string2 = null;
                    if ("no-cache".equalsIgnoreCase(string)) {
                        z10 = true;
                    } else if ("no-store".equalsIgnoreCase(string)) {
                        z11 = true;
                    } else if ("max-age".equalsIgnoreCase(string)) {
                        nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                    } else if ("s-maxage".equalsIgnoreCase(string)) {
                        nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                    } else if ("private".equalsIgnoreCase(string)) {
                        z12 = true;
                    } else if ("public".equalsIgnoreCase(string)) {
                        z13 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(string)) {
                        z14 = true;
                    } else if ("max-stale".equalsIgnoreCase(string)) {
                        nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                    } else if ("min-fresh".equalsIgnoreCase(string)) {
                        nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                    } else if ("only-if-cached".equalsIgnoreCase(string)) {
                        z15 = true;
                    } else if ("no-transform".equalsIgnoreCase(string)) {
                        z16 = true;
                    } else if ("immutable".equalsIgnoreCase(string)) {
                        z17 = true;
                    }
                }
                i6 = size;
                str = str2;
                i10++;
                headers2 = headers;
                str2 = str;
                size = i6;
            }
            return new CacheControl(z10, z11, nonNegativeInt, nonNegativeInt2, z12, z13, z14, nonNegativeInt3, nonNegativeInt4, z15, z16, z17, !z7 ? null : str2, null);
        }

        private Companion() {
        }
    }

    public CacheControl(boolean z7, boolean z10, int i6, int i10, boolean z11, boolean z12, boolean z13, int i11, int i12, boolean z14, boolean z15, boolean z16, String str, AbstractC2793f abstractC2793f) {
        this(z7, z10, i6, i10, z11, z12, z13, i11, i12, z14, z15, z16, str);
    }

    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }

    public final boolean m8434deprecated_immutable() {
        return this.immutable;
    }

    public final int m8435deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int m8436deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int m8437deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean m8438deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean m8439deprecated_noCache() {
        return this.noCache;
    }

    public final boolean m8440deprecated_noStore() {
        return this.noStore;
    }

    public final boolean m8441deprecated_noTransform() {
        return this.noTransform;
    }

    public final boolean m8442deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int m8443deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.noCache) {
            sb.append("no-cache, ");
        }
        if (this.noStore) {
            sb.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb.append("max-age=");
            sb.append(this.maxAgeSeconds);
            sb.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb.append("s-maxage=");
            sb.append(this.sMaxAgeSeconds);
            sb.append(", ");
        }
        if (this.isPrivate) {
            sb.append("private, ");
        }
        if (this.isPublic) {
            sb.append("public, ");
        }
        if (this.mustRevalidate) {
            sb.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb.append("max-stale=");
            sb.append(this.maxStaleSeconds);
            sb.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb.append("min-fresh=");
            sb.append(this.minFreshSeconds);
            sb.append(", ");
        }
        if (this.onlyIfCached) {
            sb.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb.append("no-transform, ");
        }
        if (this.immutable) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        AbstractC2796i.m5784e(string, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = string;
        return string;
    }

    private CacheControl(boolean z7, boolean z10, int i6, int i10, boolean z11, boolean z12, boolean z13, int i11, int i12, boolean z14, boolean z15, boolean z16, String str) {
        this.noCache = z7;
        this.noStore = z10;
        this.maxAgeSeconds = i6;
        this.sMaxAgeSeconds = i10;
        this.isPrivate = z11;
        this.isPublic = z12;
        this.mustRevalidate = z13;
        this.maxStaleSeconds = i11;
        this.minFreshSeconds = i12;
        this.onlyIfCached = z14;
        this.noTransform = z15;
        this.immutable = z16;
        this.headerValue = str;
    }
}
