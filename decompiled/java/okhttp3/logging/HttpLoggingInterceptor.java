package okhttp3.logging;

import com.lzy.okgo.cookie.SerializableCookie;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3656n;
import p253x8.AbstractC4153p;
import p253x8.C4157t;

public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        public static final class Companion {
            static final Companion $$INSTANCE = new Companion();

            public static final class DefaultLogger implements Logger {
                @Override
                public void log(String str) {
                    AbstractC2796i.m5785f(str, "message");
                    Platform.log$default(Platform.Companion.get(), str, 0, null, 6, null);
                }
            }

            private Companion() {
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || str.equalsIgnoreCase("identity") || str.equalsIgnoreCase("gzip")) ? false : true;
    }

    private final void logHeader(Headers headers, int i6) {
        String strValue = this.headersToRedact.contains(headers.name(i6)) ? "██" : headers.value(i6);
        this.logger.log(headers.name(i6) + ": " + strValue);
    }

    public final Level m8557deprecated_level() {
        return this.level;
    }

    public final Level getLevel() {
        return this.level;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws Exception {
        Charset charset;
        Long lValueOf;
        AbstractC2796i.m5785f(chain, "chain");
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z7 = true;
        boolean z10 = level == Level.BODY;
        if (!z10 && level != Level.HEADERS) {
            z7 = false;
        }
        RequestBody requestBodyBody = request.body();
        Connection connection = chain.connection();
        StringBuilder sb = new StringBuilder("--> ");
        sb.append(request.method());
        sb.append(' ');
        sb.append(request.url());
        sb.append(connection != null ? AbstractC2796i.m5790k(connection.protocol(), " ") : "");
        String string = sb.toString();
        if (!z7 && requestBodyBody != null) {
            StringBuilder sbM29w = AbstractC0004e.m29w(string, " (");
            sbM29w.append(requestBodyBody.contentLength());
            sbM29w.append("-byte body)");
            string = sbM29w.toString();
        }
        this.logger.log(string);
        if (z7) {
            Headers headers = request.headers();
            if (requestBodyBody != null) {
                MediaType mediaTypeContentType = requestBodyBody.contentType();
                if (mediaTypeContentType != null && headers.get("Content-Type") == null) {
                    this.logger.log(AbstractC2796i.m5790k(mediaTypeContentType, "Content-Type: "));
                }
                if (requestBodyBody.contentLength() != -1 && headers.get("Content-Length") == null) {
                    this.logger.log(AbstractC2796i.m5790k(Long.valueOf(requestBodyBody.contentLength()), "Content-Length: "));
                }
            }
            int size = headers.size();
            for (int i6 = 0; i6 < size; i6++) {
                logHeader(headers, i6);
            }
            if (!z10 || requestBodyBody == null) {
                z10 = z10;
                this.logger.log(AbstractC2796i.m5790k(request.method(), "--> END "));
            } else if (bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else if (requestBodyBody.isDuplex()) {
                this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
            } else if (requestBodyBody.isOneShot()) {
                this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
            } else {
                Buffer buffer = new Buffer();
                requestBodyBody.writeTo(buffer);
                MediaType mediaTypeContentType2 = requestBodyBody.contentType();
                Charset charset2 = mediaTypeContentType2 == null ? null : mediaTypeContentType2.charset(StandardCharsets.UTF_8);
                if (charset2 == null) {
                    charset2 = StandardCharsets.UTF_8;
                    AbstractC2796i.m5784e(charset2, "UTF_8");
                }
                this.logger.log("");
                if (Utf8Kt.isProbablyUtf8(buffer)) {
                    this.logger.log(buffer.readString(charset2));
                    this.logger.log("--> END " + request.method() + " (" + requestBodyBody.contentLength() + "-byte body)");
                } else {
                    z10 = z10;
                    this.logger.log("--> END " + request.method() + " (binary " + requestBodyBody.contentLength() + "-byte body omitted)");
                }
            }
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseProceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBodyBody = responseProceed.body();
            AbstractC2796i.m5782c(responseBodyBody);
            long jContentLength = responseBodyBody.contentLength();
            String str = jContentLength != -1 ? jContentLength + "-byte" : "unknown-length";
            Logger logger = this.logger;
            StringBuilder sb2 = new StringBuilder("<-- ");
            sb2.append(responseProceed.code());
            sb2.append(responseProceed.message().length() == 0 ? "" : AbstractC2460q.m5501o(" ", responseProceed.message()));
            sb2.append(' ');
            sb2.append(responseProceed.request().url());
            sb2.append(" (");
            sb2.append(millis);
            sb2.append("ms");
            sb2.append(!z7 ? AbstractC0004e.m24r(", ", str, " body") : "");
            sb2.append(')');
            logger.log(sb2.toString());
            if (z7) {
                Headers headers2 = responseProceed.headers();
                int size2 = headers2.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    logHeader(headers2, i10);
                }
                if (!z10 || !HttpHeaders.promisesBody(responseProceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyHasUnknownEncoding(responseProceed.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource bufferedSourceSource = responseBodyBody.source();
                    bufferedSourceSource.request(Long.MAX_VALUE);
                    Buffer buffer2 = bufferedSourceSource.getBuffer();
                    if ("gzip".equalsIgnoreCase(headers2.get("Content-Encoding"))) {
                        lValueOf = Long.valueOf(buffer2.size());
                        GzipSource gzipSource = new GzipSource(buffer2.clone());
                        try {
                            buffer2 = new Buffer();
                            buffer2.writeAll(gzipSource);
                            charset = null;
                            AbstractC0032a.m164r(gzipSource, null);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                AbstractC0032a.m164r(gzipSource, th);
                                throw th2;
                            }
                        }
                    } else {
                        charset = null;
                        lValueOf = null;
                    }
                    MediaType mediaTypeContentType3 = responseBodyBody.contentType();
                    Charset charset3 = mediaTypeContentType3 == null ? charset : mediaTypeContentType3.charset(StandardCharsets.UTF_8);
                    if (charset3 == null) {
                        charset3 = StandardCharsets.UTF_8;
                        AbstractC2796i.m5784e(charset3, "UTF_8");
                    }
                    if (!Utf8Kt.isProbablyUtf8(buffer2)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + buffer2.size() + "-byte body omitted)");
                        return responseProceed;
                    }
                    if (jContentLength != 0) {
                        this.logger.log("");
                        this.logger.log(buffer2.clone().readString(charset3));
                    }
                    if (lValueOf != null) {
                        this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte, " + lValueOf + "-gzipped-byte body)");
                    } else {
                        this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                    }
                }
            }
            return responseProceed;
        } catch (Exception e5) {
            this.logger.log(AbstractC2796i.m5790k(e5, "<-- HTTP FAILED: "));
            throw e5;
        }
    }

    public final void level(Level level) {
        AbstractC2796i.m5785f(level, "<set-?>");
        this.level = level;
    }

    public final void redactHeader(String str) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        TreeSet treeSet = new TreeSet(AbstractC3656n.m7399Q());
        AbstractC4153p.m8195S(treeSet, this.headersToRedact);
        treeSet.add(str);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        AbstractC2796i.m5785f(level, "level");
        level(level);
        return this;
    }

    public HttpLoggingInterceptor(Logger logger) {
        AbstractC2796i.m5785f(logger, "logger");
        this.logger = logger;
        this.headersToRedact = C4157t.f14076a;
        this.level = Level.NONE;
    }

    public HttpLoggingInterceptor(Logger logger, int i6, AbstractC2793f abstractC2793f) {
        this((i6 & 1) != 0 ? Logger.DEFAULT : logger);
    }
}
