package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import p000a.AbstractC0004e;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2797j;
import p103j9.AbstractC2804q;
import p192r9.AbstractC3648f;
import p192r9.AbstractC3656n;
import p253x8.AbstractC4146i;
import p253x8.AbstractC4147j;
import p253x8.AbstractC4149l;
import p253x8.AbstractC4158u;
import p253x8.C4155r;
import p253x8.C4157t;

public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final Builder add(String str, String... strArr) {
            AbstractC2796i.m5785f(str, "pattern");
            AbstractC2796i.m5785f(strArr, "pins");
            for (String str2 : strArr) {
                this.pins.add(new Pin(str, str2));
            }
            return this;
        }

        public final CertificatePinner build() {
            Set set;
            List<Pin> list = this.pins;
            AbstractC2796i.m5785f(list, "<this>");
            boolean z7 = list instanceof Collection;
            C4157t c4157t = C4157t.f14076a;
            if (z7) {
                List<Pin> list2 = list;
                int size = list2.size();
                if (size != 0) {
                    if (size != 1) {
                        LinkedHashSet linkedHashSet = new LinkedHashSet(AbstractC4158u.m8196p(list2.size()));
                        AbstractC4147j.m8188b0(list, linkedHashSet);
                        set = linkedHashSet;
                    } else {
                        Set setSingleton = Collections.singleton(list instanceof List ? list.get(0) : list2.iterator().next());
                        AbstractC2796i.m5784e(setSingleton, "singleton(...)");
                        set = setSingleton;
                    }
                }
            } else {
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                AbstractC4147j.m8188b0(list, linkedHashSet2);
                int size2 = linkedHashSet2.size();
                if (size2 != 0) {
                    if (size2 != 1) {
                        set = linkedHashSet2;
                    } else {
                        Set setSingleton2 = Collections.singleton(linkedHashSet2.iterator().next());
                        AbstractC2796i.m5784e(setSingleton2, "singleton(...)");
                        set = setSingleton2;
                    }
                }
            }
            set = c4157t;
            set = c4157t;
            return new CertificatePinner(set, null, 2, false ? 1 : 0);
        }

        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final String pin(Certificate certificate) {
            AbstractC2796i.m5785f(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
            }
            return "sha256/" + sha256Hash((X509Certificate) certificate).base64();
        }

        public final ByteString sha1Hash(X509Certificate x509Certificate) {
            AbstractC2796i.m5785f(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            AbstractC2796i.m5784e(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha1();
        }

        public final ByteString sha256Hash(X509Certificate x509Certificate) {
            AbstractC2796i.m5785f(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            AbstractC2796i.m5784e(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha256();
        }

        private Companion() {
        }
    }

    public static final class Pin {
        private final ByteString hash;
        private final String hashAlgorithm;
        private final String pattern;

        public Pin(String str, String str2) {
            AbstractC2796i.m5785f(str, "pattern");
            AbstractC2796i.m5785f(str2, "pin");
            if ((!AbstractC3656n.m7404V(str, "*.", false) || AbstractC3648f.m7381c0(str, "*", 1, false, 4) != -1) && ((!AbstractC3656n.m7404V(str, "**.", false) || AbstractC3648f.m7381c0(str, "*", 2, false, 4) != -1) && AbstractC3648f.m7381c0(str, "*", 0, false, 6) != -1)) {
                throw new IllegalArgumentException("Unexpected pattern: ".concat(str).toString());
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException("Invalid pattern: ".concat(str));
            }
            this.pattern = canonicalHost;
            if (AbstractC3656n.m7404V(str2, "sha1/", false)) {
                this.hashAlgorithm = "sha1";
                ByteString.Companion companion = ByteString.Companion;
                String strSubstring = str2.substring(5);
                AbstractC2796i.m5784e(strSubstring, "this as java.lang.String).substring(startIndex)");
                ByteString byteStringDecodeBase64 = companion.decodeBase64(strSubstring);
                if (byteStringDecodeBase64 == null) {
                    throw new IllegalArgumentException("Invalid pin hash: ".concat(str2));
                }
                this.hash = byteStringDecodeBase64;
                return;
            }
            if (!AbstractC3656n.m7404V(str2, "sha256/", false)) {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': ".concat(str2));
            }
            this.hashAlgorithm = "sha256";
            ByteString.Companion companion2 = ByteString.Companion;
            String strSubstring2 = str2.substring(7);
            AbstractC2796i.m5784e(strSubstring2, "this as java.lang.String).substring(startIndex)");
            ByteString byteStringDecodeBase65 = companion2.decodeBase64(strSubstring2);
            if (byteStringDecodeBase65 == null) {
                throw new IllegalArgumentException("Invalid pin hash: ".concat(str2));
            }
            this.hash = byteStringDecodeBase65;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return AbstractC2796i.m5780a(this.pattern, pin.pattern) && AbstractC2796i.m5780a(this.hashAlgorithm, pin.hashAlgorithm) && AbstractC2796i.m5780a(this.hash, pin.hash);
        }

        public final ByteString getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return this.hash.hashCode() + AbstractC0004e.m14h(this.pattern.hashCode() * 31, 31, this.hashAlgorithm);
        }

        public final boolean matchesCertificate(X509Certificate x509Certificate) {
            AbstractC2796i.m5785f(x509Certificate, "certificate");
            String str = this.hashAlgorithm;
            if (AbstractC2796i.m5780a(str, "sha256")) {
                return AbstractC2796i.m5780a(this.hash, CertificatePinner.Companion.sha256Hash(x509Certificate));
            }
            if (AbstractC2796i.m5780a(str, "sha1")) {
                return AbstractC2796i.m5780a(this.hash, CertificatePinner.Companion.sha1Hash(x509Certificate));
            }
            return false;
        }

        public final boolean matchesHostname(String str) {
            AbstractC2796i.m5785f(str, "hostname");
            if (AbstractC3656n.m7404V(this.pattern, "**.", false)) {
                int length = this.pattern.length() - 3;
                int length2 = str.length() - length;
                if (!AbstractC3656n.m7400R(str, this.pattern, str.length() - length, 3, length, false)) {
                    return false;
                }
                if (length2 != 0 && str.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                if (!AbstractC3656n.m7404V(this.pattern, "*.", false)) {
                    return str.equals(this.pattern);
                }
                int length3 = this.pattern.length() - 1;
                int length4 = str.length() - length3;
                if (!AbstractC3656n.m7400R(str, this.pattern, str.length() - length3, 1, length3, false) || AbstractC3648f.m7384f0(str, '.', length4 - 1, 4) != -1) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }
    }

    public static final class C32901 extends AbstractC2797j implements InterfaceC2713a {
        final String $hostname;
        final List<Certificate> $peerCertificates;

        public C32901(List<? extends Certificate> list, String str) {
            super(0);
            this.$peerCertificates = list;
            this.$hostname = str;
        }

        @Override
        public final List<X509Certificate> invoke() {
            List<Certificate> listClean;
            CertificateChainCleaner certificateChainCleaner$okhttp = CertificatePinner.this.getCertificateChainCleaner$okhttp();
            if (certificateChainCleaner$okhttp == null || (listClean = certificateChainCleaner$okhttp.clean(this.$peerCertificates, this.$hostname)) == null) {
                listClean = this.$peerCertificates;
            }
            ArrayList arrayList = new ArrayList(AbstractC4149l.m8193Q(listClean));
            for (Certificate certificate : listClean) {
                AbstractC2796i.m5783d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        AbstractC2796i.m5785f(set, "pins");
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    public static final ByteString sha1Hash(X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    public static final ByteString sha256Hash(X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(String str, List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        AbstractC2796i.m5785f(str, "hostname");
        AbstractC2796i.m5785f(list, "peerCertificates");
        check$okhttp(str, new C32901(list, str));
    }

    public final void check$okhttp(String str, InterfaceC2713a interfaceC2713a) throws SSLPeerUnverifiedException {
        AbstractC2796i.m5785f(str, "hostname");
        AbstractC2796i.m5785f(interfaceC2713a, "cleanedPeerCertificatesFn");
        List<Pin> listFindMatchingPins = findMatchingPins(str);
        if (listFindMatchingPins.isEmpty()) {
            return;
        }
        List<X509Certificate> list = (List) interfaceC2713a.invoke();
        for (X509Certificate x509Certificate : list) {
            ByteString byteStringSha256Hash = null;
            ByteString byteStringSha1Hash = null;
            for (Pin pin : listFindMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                if (AbstractC2796i.m5780a(hashAlgorithm, "sha256")) {
                    if (byteStringSha256Hash == null) {
                        byteStringSha256Hash = Companion.sha256Hash(x509Certificate);
                    }
                    if (AbstractC2796i.m5780a(pin.getHash(), byteStringSha256Hash)) {
                        return;
                    }
                } else {
                    if (!AbstractC2796i.m5780a(hashAlgorithm, "sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                    }
                    if (byteStringSha1Hash == null) {
                        byteStringSha1Hash = Companion.sha1Hash(x509Certificate);
                    }
                    if (AbstractC2796i.m5780a(pin.getHash(), byteStringSha1Hash)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : list) {
            sb.append("\n    ");
            sb.append(Companion.pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        for (Pin pin2 : listFindMatchingPins) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        String string = sb.toString();
        AbstractC2796i.m5784e(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (AbstractC2796i.m5780a(certificatePinner.pins, this.pins) && AbstractC2796i.m5780a(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    public final List<Pin> findMatchingPins(String str) {
        AbstractC2796i.m5785f(str, "hostname");
        Set<Pin> set = this.pins;
        List arrayList = C4155r.f14074a;
        for (Object obj : set) {
            if (((Pin) obj).matchesHostname(str)) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList();
                }
                AbstractC2804q.m5796a(arrayList).add(obj);
            }
        }
        return arrayList;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int iHashCode = (this.pins.hashCode() + 1517) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return iHashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        AbstractC2796i.m5785f(certificateChainCleaner, "certificateChainCleaner");
        return AbstractC2796i.m5780a(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public final void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        AbstractC2796i.m5785f(str, "hostname");
        AbstractC2796i.m5785f(certificateArr, "peerCertificates");
        check(str, AbstractC4146i.m8179L(certificateArr));
    }

    public CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i6, AbstractC2793f abstractC2793f) {
        this(set, (i6 & 2) != 0 ? null : certificateChainCleaner);
    }
}
