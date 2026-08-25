package okhttp3;

import java.io.IOException;
import okhttp3.internal.authenticator.JavaNetAuthenticator;
import p103j9.AbstractC2796i;

public interface Authenticator {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final Authenticator NONE = new Companion.AuthenticatorNone();
    public static final Authenticator JAVA_NET_AUTHENTICATOR = new JavaNetAuthenticator(null, 1, 0 == true ? 1 : 0);

    public static final class Companion {
        static final Companion $$INSTANCE = new Companion();

        public static final class AuthenticatorNone implements Authenticator {
            @Override
            public Request authenticate(Route route, Response response) {
                AbstractC2796i.m5785f(response, "response");
                return null;
            }
        }

        private Companion() {
        }
    }

    Request authenticate(Route route, Response response) throws IOException;
}
