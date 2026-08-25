package okhttp3.internal.http2;

import com.lzy.okgo.model.Progress;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;

public final class Http2ExchangeCodec implements ExchangeCodec {
    private static final String HOST = "host";
    private static final String KEEP_ALIVE = "keep-alive";
    private volatile boolean canceled;
    private final RealInterceptorChain chain;
    private final RealConnection connection;
    private final Http2Connection http2Connection;
    private final Protocol protocol;
    private volatile Http2Stream stream;
    public static final Companion Companion = new Companion(null);
    private static final String CONNECTION = "connection";
    private static final String PROXY_CONNECTION = "proxy-connection";

    private static final String f10999TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String ENCODING = "encoding";
    private static final String UPGRADE = "upgrade";
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf(CONNECTION, "host", "keep-alive", PROXY_CONNECTION, f10999TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8);
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf(CONNECTION, "host", "keep-alive", PROXY_CONNECTION, f10999TE, TRANSFER_ENCODING, ENCODING, UPGRADE);

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final List<Header> http2HeadersList(Request request) {
            AbstractC2796i.m5785f(request, Progress.REQUEST);
            Headers headers = request.headers();
            ArrayList arrayList = new ArrayList(headers.size() + 4);
            arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
            arrayList.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(request.url())));
            String strHeader = request.header("Host");
            if (strHeader != null) {
                arrayList.add(new Header(Header.TARGET_AUTHORITY, strHeader));
            }
            arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
            int size = headers.size();
            for (int i6 = 0; i6 < size; i6++) {
                String strName = headers.name(i6);
                Locale locale = Locale.US;
                AbstractC2796i.m5784e(locale, "US");
                String lowerCase = strName.toLowerCase(locale);
                AbstractC2796i.m5784e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (!Http2ExchangeCodec.HTTP_2_SKIPPED_REQUEST_HEADERS.contains(lowerCase) || (lowerCase.equals(Http2ExchangeCodec.f10999TE) && AbstractC2796i.m5780a(headers.value(i6), "trailers"))) {
                    arrayList.add(new Header(lowerCase, headers.value(i6)));
                }
            }
            return arrayList;
        }

        public final Response.Builder readHttp2HeadersList(Headers headers, Protocol protocol) throws IOException {
            AbstractC2796i.m5785f(headers, "headerBlock");
            AbstractC2796i.m5785f(protocol, "protocol");
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            StatusLine statusLine = null;
            for (int i6 = 0; i6 < size; i6++) {
                String strName = headers.name(i6);
                String strValue = headers.value(i6);
                if (AbstractC2796i.m5780a(strName, Header.RESPONSE_STATUS_UTF8)) {
                    statusLine = StatusLine.Companion.parse("HTTP/1.1 " + strValue);
                } else if (!Http2ExchangeCodec.HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(strName)) {
                    builder.addLenient$okhttp(strName, strValue);
                }
            }
            if (statusLine != null) {
                return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }

        private Companion() {
        }
    }

    public Http2ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection, RealInterceptorChain realInterceptorChain, Http2Connection http2Connection) {
        AbstractC2796i.m5785f(okHttpClient, "client");
        AbstractC2796i.m5785f(realConnection, CONNECTION);
        AbstractC2796i.m5785f(realInterceptorChain, "chain");
        AbstractC2796i.m5785f(http2Connection, "http2Connection");
        this.connection = realConnection;
        this.chain = realInterceptorChain;
        this.http2Connection = http2Connection;
        List<Protocol> listProtocols = okHttpClient.protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = listProtocols.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override
    public void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Override
    public Sink createRequestBody(Request request, long j10) {
        AbstractC2796i.m5785f(request, Progress.REQUEST);
        Http2Stream http2Stream = this.stream;
        AbstractC2796i.m5782c(http2Stream);
        return http2Stream.getSink();
    }

    @Override
    public void finishRequest() throws IOException {
        Http2Stream http2Stream = this.stream;
        AbstractC2796i.m5782c(http2Stream);
        http2Stream.getSink().close();
    }

    @Override
    public void flushRequest() throws IOException {
        this.http2Connection.flush();
    }

    @Override
    public RealConnection getConnection() {
        return this.connection;
    }

    @Override
    public Source openResponseBodySource(Response response) {
        AbstractC2796i.m5785f(response, "response");
        Http2Stream http2Stream = this.stream;
        AbstractC2796i.m5782c(http2Stream);
        return http2Stream.getSource$okhttp();
    }

    @Override
    public Response.Builder readResponseHeaders(boolean z7) throws IOException {
        Http2Stream http2Stream = this.stream;
        if (http2Stream == null) {
            throw new IOException("stream wasn't created");
        }
        Response.Builder http2HeadersList = Companion.readHttp2HeadersList(http2Stream.takeHeaders(), this.protocol);
        if (z7 && http2HeadersList.getCode$okhttp() == 100) {
            return null;
        }
        return http2HeadersList;
    }

    @Override
    public long reportedContentLength(Response response) {
        AbstractC2796i.m5785f(response, "response");
        if (HttpHeaders.promisesBody(response)) {
            return Util.headersContentLength(response);
        }
        return 0L;
    }

    @Override
    public Headers trailers() {
        Http2Stream http2Stream = this.stream;
        AbstractC2796i.m5782c(http2Stream);
        return http2Stream.trailers();
    }

    @Override
    public void writeRequestHeaders(Request request) throws IOException {
        AbstractC2796i.m5785f(request, Progress.REQUEST);
        if (this.stream != null) {
            return;
        }
        this.stream = this.http2Connection.newStream(Companion.http2HeadersList(request), request.body() != null);
        if (this.canceled) {
            Http2Stream http2Stream = this.stream;
            AbstractC2796i.m5782c(http2Stream);
            http2Stream.closeLater(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        Http2Stream http2Stream2 = this.stream;
        AbstractC2796i.m5782c(http2Stream2);
        Timeout timeout = http2Stream2.readTimeout();
        long readTimeoutMillis$okhttp = this.chain.getReadTimeoutMillis$okhttp();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(readTimeoutMillis$okhttp, timeUnit);
        Http2Stream http2Stream3 = this.stream;
        AbstractC2796i.m5782c(http2Stream3);
        http2Stream3.writeTimeout().timeout(this.chain.getWriteTimeoutMillis$okhttp(), timeUnit);
    }
}
