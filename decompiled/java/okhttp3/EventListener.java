package okhttp3;

import com.lzy.okgo.model.Progress;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;

public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() {
    };

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        private Companion() {
        }
    }

    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response response) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(response, "cachedResponse");
    }

    public void cacheHit(Call call, Response response) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(response, "response");
    }

    public void cacheMiss(Call call) {
        AbstractC2796i.m5785f(call, "call");
    }

    public void callEnd(Call call) {
        AbstractC2796i.m5785f(call, "call");
    }

    public void callFailed(Call call, IOException iOException) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(iOException, "ioe");
    }

    public void callStart(Call call) {
        AbstractC2796i.m5785f(call, "call");
    }

    public void canceled(Call call) {
        AbstractC2796i.m5785f(call, "call");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(inetSocketAddress, "inetSocketAddress");
        AbstractC2796i.m5785f(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(inetSocketAddress, "inetSocketAddress");
        AbstractC2796i.m5785f(proxy, "proxy");
        AbstractC2796i.m5785f(iOException, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(inetSocketAddress, "inetSocketAddress");
        AbstractC2796i.m5785f(proxy, "proxy");
    }

    public void connectionAcquired(Call call, Connection connection) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(connection, "connection");
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(str, "domainName");
        AbstractC2796i.m5785f(list, "inetAddressList");
    }

    public void dnsStart(Call call, String str) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(str, "domainName");
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(httpUrl, Progress.URL);
        AbstractC2796i.m5785f(list, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(httpUrl, Progress.URL);
    }

    public void requestBodyEnd(Call call, long j10) {
        AbstractC2796i.m5785f(call, "call");
    }

    public void requestBodyStart(Call call) {
        AbstractC2796i.m5785f(call, "call");
    }

    public void requestFailed(Call call, IOException iOException) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(iOException, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(request, Progress.REQUEST);
    }

    public void requestHeadersStart(Call call) {
        AbstractC2796i.m5785f(call, "call");
    }

    public void responseBodyEnd(Call call, long j10) {
        AbstractC2796i.m5785f(call, "call");
    }

    public void responseBodyStart(Call call) {
        AbstractC2796i.m5785f(call, "call");
    }

    public void responseFailed(Call call, IOException iOException) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(iOException, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(response, "response");
    }

    public void responseHeadersStart(Call call) {
        AbstractC2796i.m5785f(call, "call");
    }

    public void satisfactionFailure(Call call, Response response) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(response, "response");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        AbstractC2796i.m5785f(call, "call");
    }

    public void secureConnectStart(Call call) {
        AbstractC2796i.m5785f(call, "call");
    }
}
