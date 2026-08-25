package okhttp3;

import java.io.IOException;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;

public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    public static final Companion Companion = new Companion(null);
    private final String protocol;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final Protocol get(String str) throws IOException {
            AbstractC2796i.m5785f(str, "protocol");
            Protocol protocol = Protocol.HTTP_1_0;
            if (!str.equals(protocol.protocol)) {
                protocol = Protocol.HTTP_1_1;
                if (!str.equals(protocol.protocol)) {
                    protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!str.equals(protocol.protocol)) {
                        protocol = Protocol.HTTP_2;
                        if (!str.equals(protocol.protocol)) {
                            protocol = Protocol.SPDY_3;
                            if (!str.equals(protocol.protocol)) {
                                protocol = Protocol.QUIC;
                                if (!str.equals(protocol.protocol)) {
                                    throw new IOException("Unexpected protocol: ".concat(str));
                                }
                            }
                        }
                    }
                }
            }
            return protocol;
        }

        private Companion() {
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    public static final Protocol get(String str) throws IOException {
        return Companion.get(str);
    }

    @Override
    public String toString() {
        return this.protocol;
    }
}
