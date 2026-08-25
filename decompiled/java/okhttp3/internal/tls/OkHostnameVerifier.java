package okhttp3.internal.tls;

import com.lzy.okgo.cookie.SerializableCookie;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3648f;
import p192r9.AbstractC3656n;
import p253x8.AbstractC4147j;
import p253x8.C4155r;

public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (!isAscii(str)) {
            return str;
        }
        Locale locale = Locale.US;
        AbstractC2796i.m5784e(locale, "US");
        String lowerCase = str.toLowerCase(locale);
        AbstractC2796i.m5784e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i6) {
        Object obj;
        C4155r c4155r = C4155r.f14074a;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return c4155r;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && AbstractC2796i.m5780a(list.get(0), Integer.valueOf(i6)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return c4155r;
        }
    }

    private final boolean isAscii(String str) {
        return str.length() == ((int) Utf8.size$default(str, 0, 0, 3, null));
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        String strAsciiToLowercase = asciiToLowercase(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (INSTANCE.verifyHostname(strAsciiToLowercase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (AbstractC2796i.m5780a(canonicalHost, HostnamesKt.toCanonicalHost((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate x509Certificate) {
        AbstractC2796i.m5785f(x509Certificate, "certificate");
        return AbstractC4147j.m8186Z(getSubjectAltNames(x509Certificate, 7), getSubjectAltNames(x509Certificate, 2));
    }

    @Override
    public boolean verify(String str, SSLSession sSLSession) {
        AbstractC2796i.m5785f(str, SerializableCookie.HOST);
        AbstractC2796i.m5785f(sSLSession, "session");
        if (!isAscii(str)) {
            return false;
        }
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            AbstractC2796i.m5783d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return verify(str, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }

    public final boolean verify(String str, X509Certificate x509Certificate) {
        AbstractC2796i.m5785f(str, SerializableCookie.HOST);
        AbstractC2796i.m5785f(x509Certificate, "certificate");
        return Util.canParseAsIpAddress(str) ? verifyIpAddress(str, x509Certificate) : verifyHostname(str, x509Certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        if (str != null && str.length() != 0 && !AbstractC3656n.m7404V(str, ".", false) && !AbstractC3656n.m7397O(str, "..", false) && str2 != null && str2.length() != 0 && !AbstractC3656n.m7404V(str2, ".", false) && !AbstractC3656n.m7397O(str2, "..", false)) {
            if (!AbstractC3656n.m7397O(str, ".", false)) {
                str = str.concat(".");
            }
            if (!AbstractC3656n.m7397O(str2, ".", false)) {
                str2 = str2.concat(".");
            }
            String strAsciiToLowercase = asciiToLowercase(str2);
            if (!AbstractC3648f.m7376X(strAsciiToLowercase, "*")) {
                return AbstractC2796i.m5780a(str, strAsciiToLowercase);
            }
            if (!AbstractC3656n.m7404V(strAsciiToLowercase, "*.", false) || AbstractC3648f.m7380b0(strAsciiToLowercase, '*', 1, false, 4) != -1 || str.length() < strAsciiToLowercase.length() || "*.".equals(strAsciiToLowercase)) {
                return false;
            }
            String strSubstring = strAsciiToLowercase.substring(1);
            AbstractC2796i.m5784e(strSubstring, "this as java.lang.String).substring(startIndex)");
            if (!AbstractC3656n.m7397O(str, strSubstring, false)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || AbstractC3648f.m7384f0(str, '.', length - 1, 4) == -1;
        }
        return false;
    }
}
