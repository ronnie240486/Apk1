package okhttp3.internal.p159ws;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.lzy.okgo.cookie.SerializableCookie;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p156o9.C3284h;

public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;
    private String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;
    public static final Companion Companion = new Companion(null);
    private static final List<Protocol> ONLY_HTTP1 = AbstractC0032a.m154F(Protocol.HTTP_1_1);

    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public Close(int i6, ByteString byteString, long j10) {
            this.code = i6;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j10;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }
    }

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        private Companion() {
        }
    }

    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public Message(int i6, ByteString byteString) {
            AbstractC2796i.m5785f(byteString, "data");
            this.formatOpcode = i6;
            this.data = byteString;
        }

        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final BufferedSink sink;
        private final BufferedSource source;

        public Streams(boolean z7, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            AbstractC2796i.m5785f(bufferedSource, "source");
            AbstractC2796i.m5785f(bufferedSink, "sink");
            this.client = z7;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }

        public final boolean getClient() {
            return this.client;
        }

        public final BufferedSink getSink() {
            return this.sink;
        }

        public final BufferedSource getSource() {
            return this.source;
        }
    }

    public final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, null);
        }

        @Override
        public long runOnce() {
            try {
                return RealWebSocket.this.writeOneFrame$okhttp() ? 0L : -1L;
            } catch (IOException e5) {
                RealWebSocket.this.failWebSocket(e5, null);
                return -1L;
            }
        }
    }

    public RealWebSocket(TaskRunner taskRunner, Request request, WebSocketListener webSocketListener, Random random, long j10, WebSocketExtensions webSocketExtensions, long j11) {
        AbstractC2796i.m5785f(taskRunner, "taskRunner");
        AbstractC2796i.m5785f(request, "originalRequest");
        AbstractC2796i.m5785f(webSocketListener, "listener");
        AbstractC2796i.m5785f(random, "random");
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random;
        this.pingIntervalMillis = j10;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j11;
        this.taskQueue = taskRunner.newQueue();
        this.pongQueue = new ArrayDeque<>();
        this.messageAndCloseQueue = new ArrayDeque<>();
        this.receivedCloseCode = -1;
        if (!"GET".equals(request.method())) {
            throw new IllegalArgumentException(("Request must be GET: " + request.method()).toString());
        }
        ByteString.Companion companion = ByteString.Companion;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = ByteString.Companion.of$default(companion, bArr, 0, 0, 3, null).base64();
    }

    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        if (webSocketExtensions.serverMaxWindowBits != null) {
            C3284h c3284h = new C3284h(8, 15, 1);
            int iIntValue = webSocketExtensions.serverMaxWindowBits.intValue();
            if (8 > iIntValue || iIntValue > c3284h.f10990b) {
                return false;
            }
        }
        return true;
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0L, 2, null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final void awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        AbstractC2796i.m5785f(timeUnit, "timeUnit");
        this.taskQueue.idleLatch().await(j10, timeUnit);
    }

    @Override
    public void cancel() {
        Call call = this.call;
        AbstractC2796i.m5782c(call);
        call.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(Response response, Exchange exchange) throws IOException {
        AbstractC2796i.m5785f(response, "response");
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
        String strHeader$default = Response.header$default(response, "Connection", null, 2, null);
        if (!"Upgrade".equalsIgnoreCase(strHeader$default)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strHeader$default + '\'');
        }
        String strHeader$default2 = Response.header$default(response, "Upgrade", null, 2, null);
        if (!"websocket".equalsIgnoreCase(strHeader$default2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strHeader$default2 + '\'');
        }
        String strHeader$default3 = Response.header$default(response, "Sec-WebSocket-Accept", null, 2, null);
        String strBase64 = ByteString.Companion.encodeUtf8(this.key + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
        if (AbstractC2796i.m5780a(strBase64, strHeader$default3)) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strBase64 + "' but was '" + strHeader$default3 + '\'');
    }

    @Override
    public boolean close(int i6, String str) {
        return close(i6, str, 60000L);
    }

    public final void connect(OkHttpClient okHttpClient) {
        AbstractC2796i.m5785f(okHttpClient, "client");
        if (this.originalRequest.header("Sec-WebSocket-Extensions") != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        OkHttpClient okHttpClientBuild = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request requestBuild = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        RealCall realCall = new RealCall(okHttpClientBuild, requestBuild, true);
        this.call = realCall;
        realCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException iOException) {
                AbstractC2796i.m5785f(call, "call");
                AbstractC2796i.m5785f(iOException, "e");
                RealWebSocket.this.failWebSocket(iOException, null);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                AbstractC2796i.m5785f(call, "call");
                AbstractC2796i.m5785f(response, "response");
                Exchange exchange = response.exchange();
                try {
                    RealWebSocket.this.checkUpgradeSuccess$okhttp(response, exchange);
                    AbstractC2796i.m5782c(exchange);
                    Streams streamsNewWebSocketStreams = exchange.newWebSocketStreams();
                    WebSocketExtensions webSocketExtensions = WebSocketExtensions.Companion.parse(response.headers());
                    RealWebSocket.this.extensions = webSocketExtensions;
                    if (!RealWebSocket.this.isValid(webSocketExtensions)) {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        synchronized (realWebSocket) {
                            realWebSocket.messageAndCloseQueue.clear();
                            realWebSocket.close(AnalyticsListener.EVENT_AUDIO_POSITION_ADVANCING, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    try {
                        RealWebSocket.this.initReaderAndWriter(Util.okHttpName + " WebSocket " + requestBuild.url().redact(), streamsNewWebSocketStreams);
                        RealWebSocket.this.getListener$okhttp().onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e5) {
                        RealWebSocket.this.failWebSocket(e5, null);
                    }
                } catch (IOException e10) {
                    RealWebSocket.this.failWebSocket(e10, response);
                    Util.closeQuietly(response);
                    if (exchange != null) {
                        exchange.webSocketUpgradeFailed();
                    }
                }
            }
        });
    }

    public final void failWebSocket(Exception exc, Response response) {
        AbstractC2796i.m5785f(exc, "e");
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            Streams streams = this.streams;
            this.streams = null;
            WebSocketReader webSocketReader = this.reader;
            this.reader = null;
            WebSocketWriter webSocketWriter = this.writer;
            this.writer = null;
            this.taskQueue.shutdown();
            try {
                this.listener.onFailure(this, exc, response);
            } finally {
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
                if (webSocketReader != null) {
                    Util.closeQuietly(webSocketReader);
                }
                if (webSocketWriter != null) {
                    Util.closeQuietly(webSocketWriter);
                }
            }
        }
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(String str, Streams streams) throws IOException {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        AbstractC2796i.m5785f(streams, "streams");
        WebSocketExtensions webSocketExtensions = this.extensions;
        AbstractC2796i.m5782c(webSocketExtensions);
        synchronized (this) {
            try {
                this.name = str;
                this.streams = streams;
                this.writer = new WebSocketWriter(streams.getClient(), streams.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams.getClient()), this.minimumDeflateSize);
                this.writerTask = new WriterTask();
                long j10 = this.pingIntervalMillis;
                if (j10 != 0) {
                    final long nanos = TimeUnit.MILLISECONDS.toNanos(j10);
                    TaskQueue taskQueue = this.taskQueue;
                    final String strConcat = str.concat(" ping");
                    taskQueue.schedule(new Task(strConcat) {
                        @Override
                        public long runOnce() {
                            this.writePingFrame$okhttp();
                            return nanos;
                        }
                    }, nanos);
                }
                if (!this.messageAndCloseQueue.isEmpty()) {
                    runWriter();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.reader = new WebSocketReader(streams.getClient(), streams.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams.getClient()));
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            AbstractC2796i.m5782c(webSocketReader);
            webSocketReader.processNextFrame();
        }
    }

    @Override
    public void onReadClose(int i6, String str) {
        Streams streams;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        AbstractC2796i.m5785f(str, "reason");
        if (i6 == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                throw new IllegalStateException("already closed");
            }
            this.receivedCloseCode = i6;
            this.receivedCloseReason = str;
            streams = null;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                Streams streams2 = this.streams;
                this.streams = null;
                webSocketReader = this.reader;
                this.reader = null;
                webSocketWriter = this.writer;
                this.writer = null;
                this.taskQueue.shutdown();
                streams = streams2;
            } else {
                webSocketReader = null;
                webSocketWriter = null;
            }
        }
        try {
            this.listener.onClosing(this, i6, str);
            if (streams != null) {
                this.listener.onClosed(this, i6, str);
            }
        } finally {
            if (streams != null) {
                Util.closeQuietly(streams);
            }
            if (webSocketReader != null) {
                Util.closeQuietly(webSocketReader);
            }
            if (webSocketWriter != null) {
                Util.closeQuietly(webSocketWriter);
            }
        }
    }

    @Override
    public void onReadMessage(String str) throws IOException {
        AbstractC2796i.m5785f(str, "text");
        this.listener.onMessage(this, str);
    }

    @Override
    public synchronized void onReadPing(ByteString byteString) {
        try {
            AbstractC2796i.m5785f(byteString, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(byteString);
                runWriter();
                this.receivedPingCount++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public synchronized void onReadPong(ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final synchronized boolean pong(ByteString byteString) {
        try {
            AbstractC2796i.m5785f(byteString, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(byteString);
                runWriter();
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            AbstractC2796i.m5782c(webSocketReader);
            webSocketReader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e5) {
            failWebSocket(e5, null);
            return false;
        }
    }

    @Override
    public synchronized long queueSize() {
        return this.queueSize;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override
    public Request request() {
        return this.originalRequest;
    }

    @Override
    public boolean send(String str) {
        AbstractC2796i.m5785f(str, "text");
        return send(ByteString.Companion.encodeUtf8(str), 1);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    public final boolean writeOneFrame$okhttp() throws IOException {
        Streams streams;
        String str;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        int i6;
        Message message;
        synchronized (this) {
            try {
                if (this.failed) {
                    return false;
                }
                WebSocketWriter webSocketWriter2 = this.writer;
                ByteString byteStringPoll = this.pongQueue.poll();
                final boolean z7 = true;
                Object obj = null;
                try {
                    if (byteStringPoll == null) {
                        Object objPoll = this.messageAndCloseQueue.poll();
                        if (objPoll instanceof Close) {
                            i6 = this.receivedCloseCode;
                            str = this.receivedCloseReason;
                            if (i6 != -1) {
                                streams = this.streams;
                                this.streams = null;
                                webSocketReader = this.reader;
                                this.reader = null;
                                webSocketWriter = this.writer;
                                this.writer = null;
                                this.taskQueue.shutdown();
                            } else {
                                long cancelAfterCloseMillis = ((Close) objPoll).getCancelAfterCloseMillis();
                                TaskQueue taskQueue = this.taskQueue;
                                final String str2 = this.name + " cancel";
                                taskQueue.schedule(new Task(str2, z7) {
                                    @Override
                                    public long runOnce() {
                                        this.cancel();
                                        return -1L;
                                    }
                                }, TimeUnit.MILLISECONDS.toNanos(cancelAfterCloseMillis));
                                streams = null;
                                webSocketReader = null;
                                webSocketWriter = null;
                            }
                            obj = objPoll;
                        } else {
                            if (objPoll == null) {
                                return false;
                            }
                            streams = null;
                            str = null;
                            webSocketReader = null;
                            webSocketWriter = null;
                            obj = objPoll;
                        }
                        if (byteStringPoll != null) {
                            AbstractC2796i.m5782c(webSocketWriter2);
                            webSocketWriter2.writePong(byteStringPoll);
                        } else if (obj instanceof Message) {
                            message = (Message) obj;
                            AbstractC2796i.m5782c(webSocketWriter2);
                            webSocketWriter2.writeMessageFrame(message.getFormatOpcode(), message.getData());
                            synchronized (this) {
                                this.queueSize -= (long) message.getData().size();
                            }
                        } else {
                            if (obj instanceof Close) {
                                throw new AssertionError();
                            }
                            Close close = (Close) obj;
                            AbstractC2796i.m5782c(webSocketWriter2);
                            webSocketWriter2.writeClose(close.getCode(), close.getReason());
                            if (streams != null) {
                                WebSocketListener webSocketListener = this.listener;
                                AbstractC2796i.m5782c(str);
                                webSocketListener.onClosed(this, i6, str);
                            }
                        }
                        if (streams != null) {
                            Util.closeQuietly(streams);
                        }
                        if (webSocketReader != null) {
                            Util.closeQuietly(webSocketReader);
                        }
                        if (webSocketWriter != null) {
                            Util.closeQuietly(webSocketWriter);
                        }
                        return true;
                    }
                    streams = null;
                    str = null;
                    webSocketReader = null;
                    webSocketWriter = null;
                    if (byteStringPoll != null) {
                        AbstractC2796i.m5782c(webSocketWriter2);
                        webSocketWriter2.writePong(byteStringPoll);
                    } else if (obj instanceof Message) {
                        message = (Message) obj;
                        AbstractC2796i.m5782c(webSocketWriter2);
                        webSocketWriter2.writeMessageFrame(message.getFormatOpcode(), message.getData());
                        synchronized (this) {
                            this.queueSize -= (long) message.getData().size();
                        }
                    } else {
                        if (obj instanceof Close) {
                            throw new AssertionError();
                        }
                        Close close2 = (Close) obj;
                        AbstractC2796i.m5782c(webSocketWriter2);
                        webSocketWriter2.writeClose(close2.getCode(), close2.getReason());
                        if (streams != null) {
                            WebSocketListener webSocketListener2 = this.listener;
                            AbstractC2796i.m5782c(str);
                            webSocketListener2.onClosed(this, i6, str);
                        }
                    }
                    if (streams != null) {
                        Util.closeQuietly(streams);
                    }
                    if (webSocketReader != null) {
                        Util.closeQuietly(webSocketReader);
                    }
                    if (webSocketWriter != null) {
                        Util.closeQuietly(webSocketWriter);
                    }
                    return true;
                } catch (Throwable th) {
                    if (streams != null) {
                        Util.closeQuietly(streams);
                    }
                    if (webSocketReader != null) {
                        Util.closeQuietly(webSocketReader);
                    }
                    if (webSocketWriter != null) {
                        Util.closeQuietly(webSocketWriter);
                    }
                    throw th;
                }
                i6 = -1;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void writePingFrame$okhttp() {
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                WebSocketWriter webSocketWriter = this.writer;
                if (webSocketWriter == null) {
                    return;
                }
                int i6 = this.awaitingPong ? this.sentPingCount : -1;
                this.sentPingCount++;
                this.awaitingPong = true;
                if (i6 == -1) {
                    try {
                        webSocketWriter.writePing(ByteString.EMPTY);
                        return;
                    } catch (IOException e5) {
                        failWebSocket(e5, null);
                        return;
                    }
                }
                failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i6 - 1) + " successful ping/pongs)"), null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized boolean close(int i6, String str, long j10) {
        ByteString byteStringEncodeUtf8;
        try {
            WebSocketProtocol.INSTANCE.validateCloseCode(i6);
            if (str != null) {
                byteStringEncodeUtf8 = ByteString.Companion.encodeUtf8(str);
                if (byteStringEncodeUtf8.size() > 123) {
                    throw new IllegalArgumentException("reason.size() > 123: ".concat(str).toString());
                }
            } else {
                byteStringEncodeUtf8 = null;
            }
            if (!this.failed && !this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i6, byteStringEncodeUtf8, j10));
                runWriter();
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public void onReadMessage(ByteString byteString) throws IOException {
        AbstractC2796i.m5785f(byteString, "bytes");
        this.listener.onMessage(this, byteString);
    }

    @Override
    public boolean send(ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "bytes");
        return send(byteString, 2);
    }

    private final synchronized boolean send(ByteString byteString, int i6) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + ((long) byteString.size()) > MAX_QUEUE_SIZE) {
                close(1001, null);
                return false;
            }
            this.queueSize += (long) byteString.size();
            this.messageAndCloseQueue.add(new Message(i6, byteString));
            runWriter();
            return true;
        }
        return false;
    }
}
