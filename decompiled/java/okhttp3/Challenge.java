package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import p000a.AbstractC0004e;
import p103j9.AbstractC2796i;
import p253x8.AbstractC4158u;

public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    public Challenge(String str, Map<String, String> map) {
        String lowerCase;
        AbstractC2796i.m5785f(str, "scheme");
        AbstractC2796i.m5785f(map, "authParams");
        this.scheme = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale locale = Locale.US;
                AbstractC2796i.m5784e(locale, "US");
                lowerCase = key.toLowerCase(locale);
                AbstractC2796i.m5784e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, value);
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        AbstractC2796i.m5784e(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = mapUnmodifiableMap;
    }

    public final Map<String, String> m8444deprecated_authParams() {
        return this.authParams;
    }

    public final Charset m8445deprecated_charset() {
        return charset();
    }

    public final String m8446deprecated_realm() {
        return realm();
    }

    public final String m8447deprecated_scheme() {
        return this.scheme;
    }

    public final Map<String, String> authParams() {
        return this.authParams;
    }

    public final Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                Charset charsetForName = Charset.forName(str);
                AbstractC2796i.m5784e(charsetForName, "forName(charset)");
                return charsetForName;
            } catch (Exception unused) {
            }
        }
        Charset charset = StandardCharsets.ISO_8859_1;
        AbstractC2796i.m5784e(charset, "ISO_8859_1");
        return charset;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (AbstractC2796i.m5780a(challenge.scheme, this.scheme) && AbstractC2796i.m5780a(challenge.authParams, this.authParams)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.authParams.hashCode() + AbstractC0004e.m14h(899, 31, this.scheme);
    }

    public final String realm() {
        return this.authParams.get("realm");
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    public final Challenge withCharset(Charset charset) {
        AbstractC2796i.m5785f(charset, "charset");
        LinkedHashMap linkedHashMapM8199s = AbstractC4158u.m8199s(this.authParams);
        String strName = charset.name();
        AbstractC2796i.m5784e(strName, "charset.name()");
        linkedHashMapM8199s.put("charset", strName);
        return new Challenge(this.scheme, linkedHashMapM8199s);
    }

    public Challenge(String str, String str2) {
        AbstractC2796i.m5785f(str, "scheme");
        AbstractC2796i.m5785f(str2, "realm");
        Map mapSingletonMap = Collections.singletonMap("realm", str2);
        AbstractC2796i.m5784e(mapSingletonMap, "singletonMap(\"realm\", realm)");
        this(str, (Map<String, String>) mapSingletonMap);
    }
}
