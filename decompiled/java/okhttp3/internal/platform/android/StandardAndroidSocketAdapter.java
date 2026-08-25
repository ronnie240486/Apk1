package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;

public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {
    public static final Companion Companion = new Companion(null);
    private final Class<?> paramClass;
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public static SocketAdapter buildIfSupported$default(Companion companion, String str, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return companion.buildIfSupported(str);
        }

        public final SocketAdapter buildIfSupported(String str) {
            AbstractC2796i.m5785f(str, "packageName");
            try {
                return new StandardAndroidSocketAdapter(Class.forName(str.concat(".OpenSSLSocketImpl")), Class.forName(str.concat(".OpenSSLSocketFactoryImpl")), Class.forName(str.concat(".SSLParametersImpl")));
            } catch (Exception e5) {
                Platform.Companion.get().log("unable to load android socket classes", 5, e5);
                return null;
            }
        }

        private Companion() {
        }
    }

    public StandardAndroidSocketAdapter(Class<? super SSLSocket> cls, Class<? super SSLSocketFactory> cls2, Class<?> cls3) {
        super(cls);
        AbstractC2796i.m5785f(cls, "sslSocketClass");
        AbstractC2796i.m5785f(cls2, "sslSocketFactoryClass");
        AbstractC2796i.m5785f(cls3, "paramClass");
        this.sslSocketFactoryClass = cls2;
        this.paramClass = cls3;
    }

    @Override
    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        AbstractC2796i.m5785f(sSLSocketFactory, "sslSocketFactory");
        return this.sslSocketFactoryClass.isInstance(sSLSocketFactory);
    }

    @Override
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) throws IllegalAccessException {
        AbstractC2796i.m5785f(sSLSocketFactory, "sslSocketFactory");
        Object fieldOrNull = Util.readFieldOrNull(sSLSocketFactory, this.paramClass, "sslParameters");
        AbstractC2796i.m5782c(fieldOrNull);
        X509TrustManager x509TrustManager = (X509TrustManager) Util.readFieldOrNull(fieldOrNull, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager == null ? (X509TrustManager) Util.readFieldOrNull(fieldOrNull, X509TrustManager.class, "trustManager") : x509TrustManager;
    }
}
