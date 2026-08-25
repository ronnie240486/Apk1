package okhttp3;

import com.lzy.okgo.cookie.SerializableCookie;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p156o9.AbstractC3280d;
import p192r9.AbstractC3656n;

public final class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    private final String subtype;
    private final String type;
    public static final Companion Companion = new Companion(null);
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final MediaType m8498deprecated_get(String str) {
            AbstractC2796i.m5785f(str, "mediaType");
            return get(str);
        }

        public final MediaType m8499deprecated_parse(String str) {
            AbstractC2796i.m5785f(str, "mediaType");
            return parse(str);
        }

        public final MediaType get(String str) {
            AbstractC2796i.m5785f(str, "<this>");
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(str);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
            }
            String strGroup = matcher.group(1);
            AbstractC2796i.m5784e(strGroup, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            AbstractC2796i.m5784e(locale, "US");
            String lowerCase = strGroup.toLowerCase(locale);
            AbstractC2796i.m5784e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            String strGroup2 = matcher.group(2);
            AbstractC2796i.m5784e(strGroup2, "typeSubtype.group(2)");
            String lowerCase2 = strGroup2.toLowerCase(locale);
            AbstractC2796i.m5784e(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = MediaType.PARAMETER.matcher(str);
            int iEnd = matcher.end();
            while (iEnd < str.length()) {
                matcher2.region(iEnd, str.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sb = new StringBuilder("Parameter is not formatted correctly: \"");
                    String strSubstring = str.substring(iEnd);
                    AbstractC2796i.m5784e(strSubstring, "this as java.lang.String).substring(startIndex)");
                    sb.append(strSubstring);
                    sb.append("\" for: \"");
                    sb.append(str);
                    sb.append('\"');
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                String strGroup3 = matcher2.group(1);
                if (strGroup3 == null) {
                    iEnd = matcher2.end();
                } else {
                    String strGroup4 = matcher2.group(2);
                    if (strGroup4 == null) {
                        strGroup4 = matcher2.group(3);
                    } else if (AbstractC3656n.m7404V(strGroup4, "'", false) && AbstractC3656n.m7397O(strGroup4, "'", false) && strGroup4.length() > 2) {
                        strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                        AbstractC2796i.m5784e(strGroup4, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    arrayList.add(strGroup3);
                    arrayList.add(strGroup4);
                    iEnd = matcher2.end();
                }
            }
            return new MediaType(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]), null);
        }

        public final MediaType parse(String str) {
            AbstractC2796i.m5785f(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private Companion() {
        }
    }

    public MediaType(String str, String str2, String str3, String[] strArr, AbstractC2793f abstractC2793f) {
        this(str, str2, str3, strArr);
    }

    public static Charset charset$default(MediaType mediaType, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    public static final MediaType get(String str) {
        return Companion.get(str);
    }

    public static final MediaType parse(String str) {
        return Companion.parse(str);
    }

    public final String m8496deprecated_subtype() {
        return this.subtype;
    }

    public final String m8497deprecated_type() {
        return this.type;
    }

    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && AbstractC2796i.m5780a(((MediaType) obj).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String parameter(String str) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        int i6 = 0;
        int iM6598p = AbstractC3280d.m6598p(0, this.parameterNamesAndValues.length - 1, 2);
        if (iM6598p < 0) {
            return null;
        }
        while (!AbstractC3656n.m7398P(this.parameterNamesAndValues[i6], str)) {
            if (i6 == iM6598p) {
                return null;
            }
            i6 += 2;
        }
        return this.parameterNamesAndValues[i6 + 1];
    }

    public final String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public final String type() {
        return this.type;
    }

    private MediaType(String str, String str2, String str3, String[] strArr) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    public final Charset charset(Charset charset) {
        String strParameter = parameter("charset");
        if (strParameter == null) {
            return charset;
        }
        try {
            return Charset.forName(strParameter);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
