package okhttp3.internal.platform;

import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3655m;

public class Jdk9Platform extends Platform {
    public static final Companion Companion = new Companion(null);
    private static final boolean isAvailable;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final Jdk9Platform buildIfSupported() {
            if (isAvailable()) {
                return new Jdk9Platform();
            }
            return null;
        }

        public final boolean isAvailable() {
            return Jdk9Platform.isAvailable;
        }

        private Companion() {
        }
    }

    static {
        String property = System.getProperty("java.specification.version");
        Integer numM7394L = property != null ? AbstractC3655m.m7394L(property) : null;
        boolean z7 = false;
        if (numM7394L == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", null);
                z7 = true;
            } catch (NoSuchMethodException unused) {
            }
        } else if (numM7394L.intValue() >= 9) {
            z7 = true;
        }
        isAvailable = z7;
    }

    @Override
    @SuppressSignatureCheck
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        AbstractC2796i.m5785f(sSLSocket, "sslSocket");
        AbstractC2796i.m5785f(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        sSLParameters.setApplicationProtocols((String[]) Platform.Companion.alpnProtocolNames(list).toArray(new String[0]));
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override
    @SuppressSignatureCheck
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        AbstractC2796i.m5785f(sSLSocket, "sslSocket");
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    @Override
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        AbstractC2796i.m5785f(sSLSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
