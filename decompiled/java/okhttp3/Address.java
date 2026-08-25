package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.Util;
import p103j9.AbstractC2796i;

public final class Address {
    private final CertificatePinner certificatePinner;
    private final List<ConnectionSpec> connectionSpecs;
    private final Dns dns;
    private final HostnameVerifier hostnameVerifier;
    private final List<Protocol> protocols;
    private final Proxy proxy;
    private final Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactory;
    private final HttpUrl url;

    public Address(String str, int i6, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<? extends Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        AbstractC2796i.m5785f(str, "uriHost");
        AbstractC2796i.m5785f(dns, "dns");
        AbstractC2796i.m5785f(socketFactory, "socketFactory");
        AbstractC2796i.m5785f(authenticator, "proxyAuthenticator");
        AbstractC2796i.m5785f(list, "protocols");
        AbstractC2796i.m5785f(list2, "connectionSpecs");
        AbstractC2796i.m5785f(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = authenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i6).build();
        this.protocols = Util.toImmutableList(list);
        this.connectionSpecs = Util.toImmutableList(list2);
    }

    public final CertificatePinner m8422deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    public final List<ConnectionSpec> m8423deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    public final Dns m8424deprecated_dns() {
        return this.dns;
    }

    public final HostnameVerifier m8425deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<Protocol> m8426deprecated_protocols() {
        return this.protocols;
    }

    public final Proxy m8427deprecated_proxy() {
        return this.proxy;
    }

    public final Authenticator m8428deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector m8429deprecated_proxySelector() {
        return this.proxySelector;
    }

    public final SocketFactory m8430deprecated_socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory m8431deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public final HttpUrl m8432deprecated_url() {
        return this.url;
    }

    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public final Dns dns() {
        return this.dns;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (AbstractC2796i.m5780a(this.url, address.url) && equalsNonHost$okhttp(address)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equalsNonHost$okhttp(Address address) {
        AbstractC2796i.m5785f(address, "that");
        return AbstractC2796i.m5780a(this.dns, address.dns) && AbstractC2796i.m5780a(this.proxyAuthenticator, address.proxyAuthenticator) && AbstractC2796i.m5780a(this.protocols, address.protocols) && AbstractC2796i.m5780a(this.connectionSpecs, address.connectionSpecs) && AbstractC2796i.m5780a(this.proxySelector, address.proxySelector) && AbstractC2796i.m5780a(this.proxy, address.proxy) && AbstractC2796i.m5780a(this.sslSocketFactory, address.sslSocketFactory) && AbstractC2796i.m5780a(this.hostnameVerifier, address.hostnameVerifier) && AbstractC2796i.m5780a(this.certificatePinner, address.certificatePinner) && this.url.port() == address.url.port();
    }

    public int hashCode() {
        return Objects.hashCode(this.certificatePinner) + ((Objects.hashCode(this.hostnameVerifier) + ((Objects.hashCode(this.sslSocketFactory) + ((Objects.hashCode(this.proxy) + ((this.proxySelector.hashCode() + ((this.connectionSpecs.hashCode() + ((this.protocols.hashCode() + ((this.proxyAuthenticator.hashCode() + ((this.dns.hashCode() + ((this.url.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<Protocol> protocols() {
        return this.protocols;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder("Address{");
        sb2.append(this.url.host());
        sb2.append(':');
        sb2.append(this.url.port());
        sb2.append(", ");
        if (this.proxy != null) {
            sb = new StringBuilder("proxy=");
            obj = this.proxy;
        } else {
            sb = new StringBuilder("proxySelector=");
            obj = this.proxySelector;
        }
        sb.append(obj);
        sb2.append(sb.toString());
        sb2.append('}');
        return sb2.toString();
    }

    public final HttpUrl url() {
        return this.url;
    }
}
