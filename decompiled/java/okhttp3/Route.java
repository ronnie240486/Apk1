package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import p103j9.AbstractC2796i;

public final class Route {
    private final Address address;
    private final Proxy proxy;
    private final InetSocketAddress socketAddress;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        AbstractC2796i.m5785f(address, "address");
        AbstractC2796i.m5785f(proxy, "proxy");
        AbstractC2796i.m5785f(inetSocketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = inetSocketAddress;
    }

    public final Address m8552deprecated_address() {
        return this.address;
    }

    public final Proxy m8553deprecated_proxy() {
        return this.proxy;
    }

    public final InetSocketAddress m8554deprecated_socketAddress() {
        return this.socketAddress;
    }

    public final Address address() {
        return this.address;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (AbstractC2796i.m5780a(route.address, this.address) && AbstractC2796i.m5780a(route.proxy, this.proxy) && AbstractC2796i.m5780a(route.socketAddress, this.socketAddress)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.socketAddress.hashCode() + ((this.proxy.hashCode() + ((this.address.hashCode() + 527) * 31)) * 31);
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        return this.address.sslSocketFactory() != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    public String toString() {
        return "Route{" + this.socketAddress + '}';
    }
}
