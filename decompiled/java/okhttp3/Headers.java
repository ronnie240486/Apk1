package okhttp3;

import com.lzy.okgo.cookie.SerializableCookie;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p103j9.C2788a;
import p115k9.InterfaceC2905a;
import p156o9.AbstractC3280d;
import p192r9.AbstractC3648f;
import p192r9.AbstractC3656n;
import p243w8.C4064f;
import p253x8.C4155r;

public final class Headers implements Iterable<C4064f>, InterfaceC2905a {
    public static final Companion Companion = new Companion(null);
    private final String[] namesAndValues;

    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String str) {
            AbstractC2796i.m5785f(str, "line");
            int iM7380b0 = AbstractC3648f.m7380b0(str, ':', 0, false, 6);
            if (iM7380b0 == -1) {
                throw new IllegalArgumentException("Unexpected header: ".concat(str).toString());
            }
            String strSubstring = str.substring(0, iM7380b0);
            AbstractC2796i.m5784e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String string = AbstractC3648f.m7392n0(strSubstring).toString();
            String strSubstring2 = str.substring(iM7380b0 + 1);
            AbstractC2796i.m5784e(strSubstring2, "this as java.lang.String).substring(startIndex)");
            add(string, strSubstring2);
            return this;
        }

        public final Builder addAll(Headers headers) {
            AbstractC2796i.m5785f(headers, "headers");
            int size = headers.size();
            for (int i6 = 0; i6 < size; i6++) {
                addLenient$okhttp(headers.name(i6), headers.value(i6));
            }
            return this;
        }

        public final Builder addLenient$okhttp(String str) {
            AbstractC2796i.m5785f(str, "line");
            int iM7380b0 = AbstractC3648f.m7380b0(str, ':', 1, false, 4);
            if (iM7380b0 != -1) {
                String strSubstring = str.substring(0, iM7380b0);
                AbstractC2796i.m5784e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = str.substring(iM7380b0 + 1);
                AbstractC2796i.m5784e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(strSubstring, strSubstring2);
            } else if (str.charAt(0) == ':') {
                String strSubstring3 = str.substring(1);
                AbstractC2796i.m5784e(strSubstring3, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp("", strSubstring3);
            } else {
                addLenient$okhttp("", str);
            }
            return this;
        }

        public final Builder addUnsafeNonAscii(String str, String str2) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            AbstractC2796i.m5785f(str2, "value");
            Headers.Companion.checkName(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Headers build() {
            return new Headers((String[]) this.namesAndValues.toArray(new String[0]), null);
        }

        public final String get(String str) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            int size = this.namesAndValues.size() - 2;
            int iM6598p = AbstractC3280d.m6598p(size, 0, -2);
            if (iM6598p > size) {
                return null;
            }
            while (!str.equalsIgnoreCase(this.namesAndValues.get(size))) {
                if (size == iM6598p) {
                    return null;
                }
                size -= 2;
            }
            return this.namesAndValues.get(size + 1);
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String str) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            int i6 = 0;
            while (i6 < this.namesAndValues.size()) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(i6))) {
                    this.namesAndValues.remove(i6);
                    this.namesAndValues.remove(i6);
                    i6 -= 2;
                }
                i6 += 2;
            }
            return this;
        }

        public final Builder set(String str, Date date) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            AbstractC2796i.m5785f(date, "value");
            set(str, DatesKt.toHttpDateString(date));
            return this;
        }

        @IgnoreJRERequirement
        public final Builder set(String str, Instant instant) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            AbstractC2796i.m5785f(instant, "value");
            return set(str, new Date(instant.toEpochMilli()));
        }

        public final Builder set(String str, String str2) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            AbstractC2796i.m5785f(str2, "value");
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            removeAll(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder add(String str, String str2) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            AbstractC2796i.m5785f(str2, "value");
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder add(String str, Date date) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            AbstractC2796i.m5785f(date, "value");
            add(str, DatesKt.toHttpDateString(date));
            return this;
        }

        public final Builder addLenient$okhttp(String str, String str2) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            AbstractC2796i.m5785f(str2, "value");
            this.namesAndValues.add(str);
            this.namesAndValues.add(AbstractC3648f.m7392n0(str2).toString());
            return this;
        }

        @IgnoreJRERequirement
        public final Builder add(String str, Instant instant) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            AbstractC2796i.m5785f(instant, "value");
            add(str, new Date(instant.toEpochMilli()));
            return this;
        }
    }

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final void checkName(String str) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i6 = 0; i6 < length; i6++) {
                char cCharAt = str.charAt(i6);
                if ('!' > cCharAt || cCharAt >= 127) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i6), str).toString());
                }
            }
        }

        public final void checkValue(String str, String str2) {
            int length = str.length();
            for (int i6 = 0; i6 < length; i6++) {
                char cCharAt = str.charAt(i6);
                if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Util.format("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i6), str2));
                    sb.append(Util.isSensitiveHeader(str2) ? "" : ": ".concat(str));
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
        }

        public final String get(String[] strArr, String str) {
            int length = strArr.length - 2;
            int iM6598p = AbstractC3280d.m6598p(length, 0, -2);
            if (iM6598p > length) {
                return null;
            }
            while (!AbstractC3656n.m7398P(str, strArr[length])) {
                if (length == iM6598p) {
                    return null;
                }
                length -= 2;
            }
            return strArr[length + 1];
        }

        public final Headers m8472deprecated_of(String... strArr) {
            AbstractC2796i.m5785f(strArr, "namesAndValues");
            return m6640of((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final Headers m6640of(String... strArr) {
            AbstractC2796i.m5785f(strArr, "namesAndValues");
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            String[] strArr2 = (String[]) strArr.clone();
            int length = strArr2.length;
            int i6 = 0;
            for (int i10 = 0; i10 < length; i10++) {
                String str = strArr2[i10];
                if (str == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                strArr2[i10] = AbstractC3648f.m7392n0(str).toString();
            }
            int iM6598p = AbstractC3280d.m6598p(0, strArr2.length - 1, 2);
            if (iM6598p >= 0) {
                while (true) {
                    String str2 = strArr2[i6];
                    String str3 = strArr2[i6 + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                    if (i6 == iM6598p) {
                        break;
                    }
                    i6 += 2;
                }
            }
            return new Headers(strArr2, null);
        }

        private Companion() {
        }

        public final Headers m8471deprecated_of(Map<String, String> map) {
            AbstractC2796i.m5785f(map, "headers");
            return m6639of(map);
        }

        public final Headers m6639of(Map<String, String> map) {
            AbstractC2796i.m5785f(map, "<this>");
            String[] strArr = new String[map.size() * 2];
            int i6 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                String string = AbstractC3648f.m7392n0(key).toString();
                String string2 = AbstractC3648f.m7392n0(value).toString();
                checkName(string);
                checkValue(string2, string);
                strArr[i6] = string;
                strArr[i6 + 1] = string2;
                i6 += 2;
            }
            return new Headers(strArr, null);
        }
    }

    public Headers(String[] strArr, AbstractC2793f abstractC2793f) {
        this(strArr);
    }

    public static final Headers m6637of(Map<String, String> map) {
        return Companion.m6639of(map);
    }

    public final int m8470deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        int length2 = strArr.length;
        for (int i6 = 0; i6 < length2; i6++) {
            length += (long) this.namesAndValues[i6].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    public final String get(String str) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        return Companion.get(this.namesAndValues, str);
    }

    public final Date getDate(String str) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        String str2 = get(str);
        if (str2 != null) {
            return DatesKt.toHttpDateOrNull(str2);
        }
        return null;
    }

    @IgnoreJRERequirement
    public final Instant getInstant(String str) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        Date date = getDate(str);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override
    public Iterator<C4064f> iterator() {
        int size = size();
        C4064f[] c4064fArr = new C4064f[size];
        for (int i6 = 0; i6 < size; i6++) {
            c4064fArr[i6] = new C4064f(name(i6), value(i6));
        }
        return new C2788a(c4064fArr);
    }

    public final String name(int i6) {
        return this.namesAndValues[i6 * 2];
    }

    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(AbstractC3656n.m7399Q());
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            treeSet.add(name(i6));
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        AbstractC2796i.m5784e(setUnmodifiableSet, "unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        List<String> namesAndValues$okhttp = builder.getNamesAndValues$okhttp();
        String[] strArr = this.namesAndValues;
        AbstractC2796i.m5785f(namesAndValues$okhttp, "<this>");
        AbstractC2796i.m5785f(strArr, "elements");
        List listAsList = Arrays.asList(strArr);
        AbstractC2796i.m5784e(listAsList, "asList(...)");
        namesAndValues$okhttp.addAll(listAsList);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(AbstractC3656n.m7399Q());
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            String strName = name(i6);
            Locale locale = Locale.US;
            AbstractC2796i.m5784e(locale, "US");
            String lowerCase = strName.toLowerCase(locale);
            AbstractC2796i.m5784e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(value(i6));
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            String strName = name(i6);
            String strValue = value(i6);
            sb.append(strName);
            sb.append(": ");
            if (Util.isSensitiveHeader(strName)) {
                strValue = "██";
            }
            sb.append(strValue);
            sb.append("\n");
        }
        String string = sb.toString();
        AbstractC2796i.m5784e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String value(int i6) {
        return this.namesAndValues[(i6 * 2) + 1];
    }

    public final List<String> values(String str) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        int size = size();
        ArrayList arrayList = null;
        for (int i6 = 0; i6 < size; i6++) {
            if (str.equalsIgnoreCase(name(i6))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i6));
            }
        }
        if (arrayList == null) {
            return C4155r.f14074a;
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        AbstractC2796i.m5784e(listUnmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return listUnmodifiableList;
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public static final Headers m6638of(String... strArr) {
        return Companion.m6640of(strArr);
    }
}
