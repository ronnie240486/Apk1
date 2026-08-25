package okhttp3.internal.proxy;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import p003a2.AbstractC0032a;

public final class NullProxySelector extends ProxySelector {
    public static final NullProxySelector INSTANCE = new NullProxySelector();

    private NullProxySelector() {
    }

    @Override
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return AbstractC0032a.m154F(Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException("uri must not be null");
    }

    @Override
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
    }
}
