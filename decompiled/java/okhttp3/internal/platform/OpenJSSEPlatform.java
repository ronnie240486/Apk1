package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import org.openjsse.net.ssl.OpenJSSE;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;

public final class OpenJSSEPlatform extends Platform {
    public static final Companion Companion;
    private static final boolean isSupported;
    private final Provider provider;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final OpenJSSEPlatform buildIfSupported() {
            AbstractC2793f abstractC2793f = null;
            if (isSupported()) {
                return new OpenJSSEPlatform(abstractC2793f);
            }
            return null;
        }

        public final boolean isSupported() {
            return OpenJSSEPlatform.isSupported;
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        boolean z7 = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, companion.getClass().getClassLoader());
            z7 = true;
        } catch (ClassNotFoundException unused) {
        }
        isSupported = z7;
    }

    public OpenJSSEPlatform(AbstractC2793f abstractC2793f) {
        this();
    }

    @Override
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        AbstractC2796i.m5785f(sSLSocket, "sslSocket");
        AbstractC2796i.m5785f(list, "protocols");
        super.configureTlsExtensions(sSLSocket, str, list);
    }

    @Override
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        AbstractC2796i.m5785f(sSLSocket, "sslSocket");
        return super.getSelectedProtocol(sSLSocket);
    }

    @Override
    public SSLContext newSSLContext() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.provider);
        AbstractC2796i.m5784e(sSLContext, "getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @Override
    public X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.provider);
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        AbstractC2796i.m5782c(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                AbstractC2796i.m5783d(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                return (X509TrustManager) trustManager;
            }
        }
        String string = Arrays.toString(trustManagers);
        AbstractC2796i.m5784e(string, "toString(this)");
        throw new IllegalStateException("Unexpected default trust managers: ".concat(string).toString());
    }

    @Override
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        AbstractC2796i.m5785f(sSLSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with OpenJSSE");
    }

    private OpenJSSEPlatform() {
        this.provider = new OpenJSSE();
    }
}
