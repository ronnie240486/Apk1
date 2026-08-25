package okhttp3.internal.platform.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;
import p000a.AbstractC0004e;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3643a;
import p192r9.AbstractC3656n;

public class AndroidSocketAdapter implements SocketAdapter {
    public static final Companion Companion;
    private static final DeferredSocketAdapter.Factory playProviderFactory;
    private final Method getAlpnSelectedProtocol;
    private final Method setAlpnProtocols;
    private final Method setHostname;
    private final Method setUseSessionTickets;
    private final Class<? super SSLSocket> sslSocketClass;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final AndroidSocketAdapter build(Class<? super SSLSocket> cls) {
            Class<? super SSLSocket> superclass = cls;
            while (superclass != null && !superclass.getSimpleName().equals("OpenSSLSocketImpl")) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    throw new AssertionError(AbstractC0004e.m23q(cls, "No OpenSSLSocketImpl superclass of socket of type "));
                }
            }
            AbstractC2796i.m5782c(superclass);
            return new AndroidSocketAdapter(superclass);
        }

        public final DeferredSocketAdapter.Factory factory(final String str) {
            AbstractC2796i.m5785f(str, "packageName");
            return new DeferredSocketAdapter.Factory() {
                @Override
                public SocketAdapter create(SSLSocket sSLSocket) {
                    AbstractC2796i.m5785f(sSLSocket, "sslSocket");
                    return AndroidSocketAdapter.Companion.build(sSLSocket.getClass());
                }

                @Override
                public boolean matchesSocket(SSLSocket sSLSocket) {
                    AbstractC2796i.m5785f(sSLSocket, "sslSocket");
                    return AbstractC3656n.m7404V(sSLSocket.getClass().getName(), str + '.', false);
                }
            };
        }

        public final DeferredSocketAdapter.Factory getPlayProviderFactory() {
            return AndroidSocketAdapter.playProviderFactory;
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        playProviderFactory = companion.factory("com.google.android.gms.org.conscrypt");
    }

    public AndroidSocketAdapter(Class<? super SSLSocket> cls) throws NoSuchMethodException {
        AbstractC2796i.m5785f(cls, "sslSocketClass");
        this.sslSocketClass = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        AbstractC2796i.m5784e(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.setUseSessionTickets = declaredMethod;
        this.setHostname = cls.getMethod("setHostname", String.class);
        this.getAlpnSelectedProtocol = cls.getMethod("getAlpnSelectedProtocol", null);
        this.setAlpnProtocols = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        AbstractC2796i.m5785f(sSLSocket, "sslSocket");
        AbstractC2796i.m5785f(list, "protocols");
        if (matchesSocket(sSLSocket)) {
            try {
                this.setUseSessionTickets.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.setHostname.invoke(sSLSocket, str);
                }
                this.setAlpnProtocols.invoke(sSLSocket, Platform.Companion.concatLengthPrefixed(list));
            } catch (IllegalAccessException e5) {
                throw new AssertionError(e5);
            } catch (InvocationTargetException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    @Override
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        AbstractC2796i.m5785f(sSLSocket, "sslSocket");
        if (!matchesSocket(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.getAlpnSelectedProtocol.invoke(sSLSocket, null);
            if (bArr != null) {
                return new String(bArr, AbstractC3643a.f12236a);
            }
            return null;
        } catch (IllegalAccessException e5) {
            throw new AssertionError(e5);
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if ((cause instanceof NullPointerException) && AbstractC2796i.m5780a(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e10);
        }
    }

    @Override
    public boolean isSupported() {
        return AndroidPlatform.Companion.isSupported();
    }

    @Override
    public boolean matchesSocket(SSLSocket sSLSocket) {
        AbstractC2796i.m5785f(sSLSocket, "sslSocket");
        return this.sslSocketClass.isInstance(sSLSocket);
    }

    @Override
    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.matchesSocketFactory(this, sSLSocketFactory);
    }

    @Override
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.trustManager(this, sSLSocketFactory);
    }
}
