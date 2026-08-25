package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;

public interface Interceptor {
    public static final Companion Companion = Companion.$$INSTANCE;

    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        Connection connection();

        Response proceed(Request request) throws IOException;

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int i6, TimeUnit timeUnit);

        Chain withReadTimeout(int i6, TimeUnit timeUnit);

        Chain withWriteTimeout(int i6, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    public static final class Companion {
        static final Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final Interceptor invoke(final InterfaceC2724l interfaceC2724l) {
            AbstractC2796i.m5785f(interfaceC2724l, "block");
            return new Interceptor() {
                @Override
                public final Response intercept(Interceptor.Chain chain) {
                    AbstractC2796i.m5785f(chain, "it");
                    return (Response) interfaceC2724l.invoke(chain);
                }
            };
        }
    }

    Response intercept(Chain chain) throws IOException;
}
