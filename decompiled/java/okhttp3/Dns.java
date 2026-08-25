package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import p103j9.AbstractC2796i;
import p253x8.AbstractC4146i;

public interface Dns {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final Dns SYSTEM = new Companion.DnsSystem();

    public static final class Companion {
        static final Companion $$INSTANCE = new Companion();

        public static final class DnsSystem implements Dns {
            @Override
            public List<InetAddress> lookup(String str) throws UnknownHostException {
                AbstractC2796i.m5785f(str, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    AbstractC2796i.m5784e(allByName, "getAllByName(hostname)");
                    return AbstractC4146i.m8179L(allByName);
                } catch (NullPointerException e5) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(str));
                    unknownHostException.initCause(e5);
                    throw unknownHostException;
                }
            }
        }

        private Companion() {
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
