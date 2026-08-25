package okhttp3.logging;

import com.lzy.okgo.model.Progress;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;

public final class LoggingEventListener extends EventListener {
    private final HttpLoggingInterceptor.Logger logger;
    private long startNs;

    public static class Factory implements EventListener.Factory {
        private final HttpLoggingInterceptor.Logger logger;

        public Factory() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override
        public EventListener create(Call call) {
            AbstractC2796i.m5785f(call, "call");
            return new LoggingEventListener(this.logger, null);
        }

        public Factory(HttpLoggingInterceptor.Logger logger) {
            AbstractC2796i.m5785f(logger, "logger");
            this.logger = logger;
        }

        public Factory(HttpLoggingInterceptor.Logger logger, int i6, AbstractC2793f abstractC2793f) {
            this((i6 & 1) != 0 ? HttpLoggingInterceptor.Logger.DEFAULT : logger);
        }
    }

    public LoggingEventListener(HttpLoggingInterceptor.Logger logger, AbstractC2793f abstractC2793f) {
        this(logger);
    }

    private final void logWithTime(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
        this.logger.log("[" + millis + " ms] " + str);
    }

    @Override
    public void cacheConditionalHit(Call call, Response response) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(response, "cachedResponse");
        logWithTime(AbstractC2796i.m5790k(response, "cacheConditionalHit: "));
    }

    @Override
    public void cacheHit(Call call, Response response) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(response, "response");
        logWithTime(AbstractC2796i.m5790k(response, "cacheHit: "));
    }

    @Override
    public void cacheMiss(Call call) {
        AbstractC2796i.m5785f(call, "call");
        logWithTime("cacheMiss");
    }

    @Override
    public void callEnd(Call call) {
        AbstractC2796i.m5785f(call, "call");
        logWithTime("callEnd");
    }

    @Override
    public void callFailed(Call call, IOException iOException) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(iOException, "ioe");
        logWithTime(AbstractC2796i.m5790k(iOException, "callFailed: "));
    }

    @Override
    public void callStart(Call call) {
        AbstractC2796i.m5785f(call, "call");
        this.startNs = System.nanoTime();
        logWithTime(AbstractC2796i.m5790k(call.request(), "callStart: "));
    }

    @Override
    public void canceled(Call call) {
        AbstractC2796i.m5785f(call, "call");
        logWithTime("canceled");
    }

    @Override
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(inetSocketAddress, "inetSocketAddress");
        AbstractC2796i.m5785f(proxy, "proxy");
        logWithTime(AbstractC2796i.m5790k(protocol, "connectEnd: "));
    }

    @Override
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(inetSocketAddress, "inetSocketAddress");
        AbstractC2796i.m5785f(proxy, "proxy");
        AbstractC2796i.m5785f(iOException, "ioe");
        logWithTime("connectFailed: " + protocol + ' ' + iOException);
    }

    @Override
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(inetSocketAddress, "inetSocketAddress");
        AbstractC2796i.m5785f(proxy, "proxy");
        logWithTime("connectStart: " + inetSocketAddress + ' ' + proxy);
    }

    @Override
    public void connectionAcquired(Call call, Connection connection) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(connection, "connection");
        logWithTime(AbstractC2796i.m5790k(connection, "connectionAcquired: "));
    }

    @Override
    public void connectionReleased(Call call, Connection connection) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(connection, "connection");
        logWithTime("connectionReleased");
    }

    @Override
    public void dnsEnd(Call call, String str, List<? extends InetAddress> list) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(str, "domainName");
        AbstractC2796i.m5785f(list, "inetAddressList");
        logWithTime(AbstractC2796i.m5790k(list, "dnsEnd: "));
    }

    @Override
    public void dnsStart(Call call, String str) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(str, "domainName");
        logWithTime(AbstractC2796i.m5790k(str, "dnsStart: "));
    }

    @Override
    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<? extends Proxy> list) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(httpUrl, Progress.URL);
        AbstractC2796i.m5785f(list, "proxies");
        logWithTime(AbstractC2796i.m5790k(list, "proxySelectEnd: "));
    }

    @Override
    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(httpUrl, Progress.URL);
        logWithTime(AbstractC2796i.m5790k(httpUrl, "proxySelectStart: "));
    }

    @Override
    public void requestBodyEnd(Call call, long j10) {
        AbstractC2796i.m5785f(call, "call");
        logWithTime(AbstractC2796i.m5790k(Long.valueOf(j10), "requestBodyEnd: byteCount="));
    }

    @Override
    public void requestBodyStart(Call call) {
        AbstractC2796i.m5785f(call, "call");
        logWithTime("requestBodyStart");
    }

    @Override
    public void requestFailed(Call call, IOException iOException) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(iOException, "ioe");
        logWithTime(AbstractC2796i.m5790k(iOException, "requestFailed: "));
    }

    @Override
    public void requestHeadersEnd(Call call, Request request) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(request, Progress.REQUEST);
        logWithTime("requestHeadersEnd");
    }

    @Override
    public void requestHeadersStart(Call call) {
        AbstractC2796i.m5785f(call, "call");
        logWithTime("requestHeadersStart");
    }

    @Override
    public void responseBodyEnd(Call call, long j10) {
        AbstractC2796i.m5785f(call, "call");
        logWithTime(AbstractC2796i.m5790k(Long.valueOf(j10), "responseBodyEnd: byteCount="));
    }

    @Override
    public void responseBodyStart(Call call) {
        AbstractC2796i.m5785f(call, "call");
        logWithTime("responseBodyStart");
    }

    @Override
    public void responseFailed(Call call, IOException iOException) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(iOException, "ioe");
        logWithTime(AbstractC2796i.m5790k(iOException, "responseFailed: "));
    }

    @Override
    public void responseHeadersEnd(Call call, Response response) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(response, "response");
        logWithTime(AbstractC2796i.m5790k(response, "responseHeadersEnd: "));
    }

    @Override
    public void responseHeadersStart(Call call) {
        AbstractC2796i.m5785f(call, "call");
        logWithTime("responseHeadersStart");
    }

    @Override
    public void satisfactionFailure(Call call, Response response) {
        AbstractC2796i.m5785f(call, "call");
        AbstractC2796i.m5785f(response, "response");
        logWithTime(AbstractC2796i.m5790k(response, "satisfactionFailure: "));
    }

    @Override
    public void secureConnectEnd(Call call, Handshake handshake) {
        AbstractC2796i.m5785f(call, "call");
        logWithTime(AbstractC2796i.m5790k(handshake, "secureConnectEnd: "));
    }

    @Override
    public void secureConnectStart(Call call) {
        AbstractC2796i.m5785f(call, "call");
        logWithTime("secureConnectStart");
    }

    private LoggingEventListener(HttpLoggingInterceptor.Logger logger) {
        this.logger = logger;
    }
}
