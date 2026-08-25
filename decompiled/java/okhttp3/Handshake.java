package okhttp3;

import androidx.media3.exoplayer.rtsp.SessionDescription;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2797j;
import p243w8.C4067i;
import p243w8.InterfaceC4061c;
import p253x8.AbstractC4147j;
import p253x8.AbstractC4149l;
import p253x8.C4155r;

public final class Handshake {
    public static final Companion Companion = new Companion(null);
    private final CipherSuite cipherSuite;
    private final List<Certificate> localCertificates;
    private final InterfaceC4061c peerCertificates$delegate;
    private final TlsVersion tlsVersion;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        private final List<Certificate> toImmutableList(Certificate[] certificateArr) {
            return certificateArr != null ? Util.immutableListOf(Arrays.copyOf(certificateArr, certificateArr.length)) : C4155r.f14074a;
        }

        public final Handshake m8469deprecated_get(SSLSession sSLSession) throws IOException {
            AbstractC2796i.m5785f(sSLSession, "sslSession");
            return get(sSLSession);
        }

        public final Handshake get(SSLSession sSLSession) throws IOException {
            List<Certificate> immutableList;
            AbstractC2796i.m5785f(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null");
            }
            if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") ? true : cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == ".concat(cipherSuite));
            }
            CipherSuite cipherSuiteForJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            }
            if ("NONE".equals(protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion tlsVersionForJavaName = TlsVersion.Companion.forJavaName(protocol);
            try {
                immutableList = toImmutableList(sSLSession.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                immutableList = C4155r.f14074a;
            }
            return new Handshake(tlsVersionForJavaName, cipherSuiteForJavaName, toImmutableList(sSLSession.getLocalCertificates()), new Handshake$Companion$handshake$1(immutableList));
        }

        private Companion() {
        }

        public final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, List<? extends Certificate> list2) {
            AbstractC2796i.m5785f(tlsVersion, "tlsVersion");
            AbstractC2796i.m5785f(cipherSuite, "cipherSuite");
            AbstractC2796i.m5785f(list, "peerCertificates");
            AbstractC2796i.m5785f(list2, "localCertificates");
            return new Handshake(tlsVersion, cipherSuite, Util.toImmutableList(list2), new Handshake$Companion$get$1(Util.toImmutableList(list)));
        }
    }

    public static final class C32912 extends AbstractC2797j implements InterfaceC2713a {
        final InterfaceC2713a $peerCertificatesFn;

        public C32912(InterfaceC2713a interfaceC2713a) {
            super(0);
            this.$peerCertificatesFn = interfaceC2713a;
        }

        @Override
        public final List<Certificate> invoke() {
            try {
                return (List) this.$peerCertificatesFn.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return C4155r.f14074a;
            }
        }
    }

    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, InterfaceC2713a interfaceC2713a) {
        AbstractC2796i.m5785f(tlsVersion, "tlsVersion");
        AbstractC2796i.m5785f(cipherSuite, "cipherSuite");
        AbstractC2796i.m5785f(list, "localCertificates");
        AbstractC2796i.m5785f(interfaceC2713a, "peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = list;
        this.peerCertificates$delegate = new C4067i(new C32912(interfaceC2713a));
    }

    public static final Handshake get(SSLSession sSLSession) throws IOException {
        return Companion.get(sSLSession);
    }

    private final String getName(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        AbstractC2796i.m5784e(type, SessionDescription.ATTR_TYPE);
        return type;
    }

    public final CipherSuite m8463deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    public final List<Certificate> m8464deprecated_localCertificates() {
        return this.localCertificates;
    }

    public final Principal m8465deprecated_localPrincipal() {
        return localPrincipal();
    }

    public final List<Certificate> m8466deprecated_peerCertificates() {
        return peerCertificates();
    }

    public final Principal m8467deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    public final TlsVersion m8468deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.tlsVersion == this.tlsVersion && AbstractC2796i.m5780a(handshake.cipherSuite, this.cipherSuite) && AbstractC2796i.m5780a(handshake.peerCertificates(), peerCertificates()) && AbstractC2796i.m5780a(handshake.localCertificates, this.localCertificates)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.localCertificates.hashCode() + ((peerCertificates().hashCode() + ((this.cipherSuite.hashCode() + ((this.tlsVersion.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    public final Principal localPrincipal() {
        Object objM8182V = AbstractC4147j.m8182V(this.localCertificates);
        X509Certificate x509Certificate = objM8182V instanceof X509Certificate ? (X509Certificate) objM8182V : null;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    public final Principal peerPrincipal() {
        Object objM8182V = AbstractC4147j.m8182V(peerCertificates());
        X509Certificate x509Certificate = objM8182V instanceof X509Certificate ? (X509Certificate) objM8182V : null;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public String toString() {
        List<Certificate> listPeerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(AbstractC4149l.m8193Q(listPeerCertificates));
        Iterator<T> it = listPeerCertificates.iterator();
        while (it.hasNext()) {
            arrayList.add(getName((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.tlsVersion);
        sb.append(" cipherSuite=");
        sb.append(this.cipherSuite);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(AbstractC4149l.m8193Q(list));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(getName((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }

    public static final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, List<? extends Certificate> list2) {
        return Companion.get(tlsVersion, cipherSuite, list, list2);
    }
}
