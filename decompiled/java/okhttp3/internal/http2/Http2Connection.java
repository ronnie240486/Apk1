package okhttp3.internal.http2;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.lzy.okgo.cookie.SerializableCookie;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p103j9.C2801n;
import p243w8.C4070l;

public final class Http2Connection implements Closeable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = new Companion(null);
    private static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextStreamId;
    private final Settings okHttpSettings;
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;
    private final Socket socket;
    private final Map<Integer, Http2Stream> streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    public static final class Builder {
        private boolean client;
        public String connectionName;
        private Listener listener;
        private int pingIntervalMillis;
        private PushObserver pushObserver;
        public BufferedSink sink;
        public Socket socket;
        public BufferedSource source;
        private final TaskRunner taskRunner;

        public Builder(boolean z7, TaskRunner taskRunner) {
            AbstractC2796i.m5785f(taskRunner, "taskRunner");
            this.client = z7;
            this.taskRunner = taskRunner;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        public static Builder socket$default(Builder builder, Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink, int i6, Object obj) throws IOException {
            if ((i6 & 2) != 0) {
                str = Util.peerName(socket);
            }
            if ((i6 & 4) != 0) {
                bufferedSource = Okio.buffer(Okio.source(socket));
            }
            if ((i6 & 8) != 0) {
                bufferedSink = Okio.buffer(Okio.sink(socket));
            }
            return builder.socket(socket, str, bufferedSource, bufferedSink);
        }

        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            AbstractC2796i.m5791l("connectionName");
            throw null;
        }

        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final BufferedSink getSink$okhttp() {
            BufferedSink bufferedSink = this.sink;
            if (bufferedSink != null) {
                return bufferedSink;
            }
            AbstractC2796i.m5791l("sink");
            throw null;
        }

        public final Socket getSocket$okhttp() {
            Socket socket = this.socket;
            if (socket != null) {
                return socket;
            }
            AbstractC2796i.m5791l("socket");
            throw null;
        }

        public final BufferedSource getSource$okhttp() {
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            AbstractC2796i.m5791l("source");
            throw null;
        }

        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final Builder listener(Listener listener) {
            AbstractC2796i.m5785f(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final Builder pingIntervalMillis(int i6) {
            this.pingIntervalMillis = i6;
            return this;
        }

        public final Builder pushObserver(PushObserver pushObserver) {
            AbstractC2796i.m5785f(pushObserver, "pushObserver");
            this.pushObserver = pushObserver;
            return this;
        }

        public final void setClient$okhttp(boolean z7) {
            this.client = z7;
        }

        public final void setConnectionName$okhttp(String str) {
            AbstractC2796i.m5785f(str, "<set-?>");
            this.connectionName = str;
        }

        public final void setListener$okhttp(Listener listener) {
            AbstractC2796i.m5785f(listener, "<set-?>");
            this.listener = listener;
        }

        public final void setPingIntervalMillis$okhttp(int i6) {
            this.pingIntervalMillis = i6;
        }

        public final void setPushObserver$okhttp(PushObserver pushObserver) {
            AbstractC2796i.m5785f(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final void setSink$okhttp(BufferedSink bufferedSink) {
            AbstractC2796i.m5785f(bufferedSink, "<set-?>");
            this.sink = bufferedSink;
        }

        public final void setSocket$okhttp(Socket socket) {
            AbstractC2796i.m5785f(socket, "<set-?>");
            this.socket = socket;
        }

        public final void setSource$okhttp(BufferedSource bufferedSource) {
            AbstractC2796i.m5785f(bufferedSource, "<set-?>");
            this.source = bufferedSource;
        }

        public final Builder socket(Socket socket) throws IOException {
            AbstractC2796i.m5785f(socket, "socket");
            return socket$default(this, socket, null, null, null, 14, null);
        }

        public final Builder socket(Socket socket, String str) throws IOException {
            AbstractC2796i.m5785f(socket, "socket");
            AbstractC2796i.m5785f(str, "peerName");
            return socket$default(this, socket, str, null, null, 12, null);
        }

        public final Builder socket(Socket socket, String str, BufferedSource bufferedSource) throws IOException {
            AbstractC2796i.m5785f(socket, "socket");
            AbstractC2796i.m5785f(str, "peerName");
            AbstractC2796i.m5785f(bufferedSource, "source");
            return socket$default(this, socket, str, bufferedSource, null, 8, null);
        }

        public final Builder socket(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) throws IOException {
            String strConcat;
            AbstractC2796i.m5785f(socket, "socket");
            AbstractC2796i.m5785f(str, "peerName");
            AbstractC2796i.m5785f(bufferedSource, "source");
            AbstractC2796i.m5785f(bufferedSink, "sink");
            setSocket$okhttp(socket);
            if (this.client) {
                strConcat = Util.okHttpName + ' ' + str;
            } else {
                strConcat = "MockWebServer ".concat(str);
            }
            setConnectionName$okhttp(strConcat);
            setSource$okhttp(bufferedSource);
            setSink$okhttp(bufferedSink);
            return this;
        }
    }

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }

        private Companion() {
        }
    }

    public static abstract class Listener {
        public static final Companion Companion = new Companion(null);
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
            @Override
            public void onStream(Http2Stream http2Stream) throws IOException {
                AbstractC2796i.m5785f(http2Stream, "stream");
                http2Stream.close(ErrorCode.REFUSED_STREAM, null);
            }
        };

        public static final class Companion {
            public Companion(AbstractC2793f abstractC2793f) {
                this();
            }

            private Companion() {
            }
        }

        public void onSettings(Http2Connection http2Connection, Settings settings) {
            AbstractC2796i.m5785f(http2Connection, "connection");
            AbstractC2796i.m5785f(settings, "settings");
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    public final class ReaderRunnable implements Http2Reader.Handler, InterfaceC2713a {
        private final Http2Reader reader;
        final Http2Connection this$0;

        public ReaderRunnable(Http2Connection http2Connection, Http2Reader http2Reader) {
            AbstractC2796i.m5785f(http2Reader, "reader");
            this.this$0 = http2Connection;
            this.reader = http2Reader;
        }

        @Override
        public void alternateService(int i6, String str, ByteString byteString, String str2, int i10, long j10) {
            AbstractC2796i.m5785f(str, TtmlNode.ATTR_TTS_ORIGIN);
            AbstractC2796i.m5785f(byteString, "protocol");
            AbstractC2796i.m5785f(str2, SerializableCookie.HOST);
        }

        public final void applyAndAckSettings(boolean z7, Settings settings) {
            long initialWindowSize;
            int i6;
            Http2Stream[] http2StreamArr;
            AbstractC2796i.m5785f(settings, "settings");
            final C2801n c2801n = new C2801n();
            Http2Writer writer = this.this$0.getWriter();
            final Http2Connection http2Connection = this.this$0;
            synchronized (writer) {
                synchronized (http2Connection) {
                    try {
                        Settings peerSettings = http2Connection.getPeerSettings();
                        if (!z7) {
                            Settings settings2 = new Settings();
                            settings2.merge(peerSettings);
                            settings2.merge(settings);
                            settings = settings2;
                        }
                        c2801n.f9540a = settings;
                        initialWindowSize = ((long) settings.getInitialWindowSize()) - ((long) peerSettings.getInitialWindowSize());
                        http2StreamArr = (initialWindowSize == 0 || http2Connection.getStreams$okhttp().isEmpty()) ? null : (Http2Stream[]) http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                        http2Connection.setPeerSettings((Settings) c2801n.f9540a);
                        TaskQueue taskQueue = http2Connection.settingsListenerQueue;
                        final String str = http2Connection.getConnectionName$okhttp() + " onSettings";
                        final boolean z10 = true;
                        taskQueue.schedule(new Task(str, z10) {
                            @Override
                            public long runOnce() {
                                http2Connection.getListener$okhttp().onSettings(http2Connection, (Settings) c2801n.f9540a);
                                return -1L;
                            }
                        }, 0L);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                try {
                    http2Connection.getWriter().applyAndAckSettings((Settings) c2801n.f9540a);
                } catch (IOException e5) {
                    http2Connection.failConnection(e5);
                }
            }
            if (http2StreamArr != null) {
                for (Http2Stream http2Stream : http2StreamArr) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(initialWindowSize);
                    }
                }
            }
        }

        @Override
        public void data(boolean z7, int i6, BufferedSource bufferedSource, int i10) throws IOException {
            AbstractC2796i.m5785f(bufferedSource, "source");
            if (this.this$0.pushedStream$okhttp(i6)) {
                this.this$0.pushDataLater$okhttp(i6, bufferedSource, i10, z7);
                return;
            }
            Http2Stream stream = this.this$0.getStream(i6);
            if (stream == null) {
                this.this$0.writeSynResetLater$okhttp(i6, ErrorCode.PROTOCOL_ERROR);
                long j10 = i10;
                this.this$0.updateConnectionFlowControl$okhttp(j10);
                bufferedSource.skip(j10);
                return;
            }
            stream.receiveData(bufferedSource, i10);
            if (z7) {
                stream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override
        public void goAway(int i6, ErrorCode errorCode, ByteString byteString) {
            int i10;
            Object[] array;
            AbstractC2796i.m5785f(errorCode, "errorCode");
            AbstractC2796i.m5785f(byteString, "debugData");
            byteString.size();
            Http2Connection http2Connection = this.this$0;
            synchronized (http2Connection) {
                array = http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                http2Connection.isShutdown = true;
            }
            for (Http2Stream http2Stream : (Http2Stream[]) array) {
                if (http2Stream.getId() > i6 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        @Override
        public void headers(boolean z7, int i6, int i10, List<Header> list) {
            AbstractC2796i.m5785f(list, "headerBlock");
            if (this.this$0.pushedStream$okhttp(i6)) {
                this.this$0.pushHeadersLater$okhttp(i6, list, z7);
                return;
            }
            final Http2Connection http2Connection = this.this$0;
            synchronized (http2Connection) {
                Http2Stream stream = http2Connection.getStream(i6);
                if (stream != null) {
                    stream.receiveHeaders(Util.toHeaders(list), z7);
                    return;
                }
                if (http2Connection.isShutdown) {
                    return;
                }
                if (i6 <= http2Connection.getLastGoodStreamId$okhttp()) {
                    return;
                }
                if (i6 % 2 == http2Connection.getNextStreamId$okhttp() % 2) {
                    return;
                }
                final Http2Stream http2Stream = new Http2Stream(i6, http2Connection, false, z7, Util.toHeaders(list));
                http2Connection.setLastGoodStreamId$okhttp(i6);
                http2Connection.getStreams$okhttp().put(Integer.valueOf(i6), http2Stream);
                TaskQueue taskQueueNewQueue = http2Connection.taskRunner.newQueue();
                final String str = http2Connection.getConnectionName$okhttp() + '[' + i6 + "] onStream";
                final boolean z10 = true;
                taskQueueNewQueue.schedule(new Task(str, z10) {
                    @Override
                    public long runOnce() {
                        try {
                            http2Connection.getListener$okhttp().onStream(http2Stream);
                            return -1L;
                        } catch (IOException e5) {
                            Platform.Companion.get().log("Http2Connection.Listener failure for " + http2Connection.getConnectionName$okhttp(), 4, e5);
                            try {
                                http2Stream.close(ErrorCode.PROTOCOL_ERROR, e5);
                                return -1L;
                            } catch (IOException unused) {
                                return -1L;
                            }
                        }
                    }
                }, 0L);
            }
        }

        @Override
        public Object invoke() throws Throwable {
            m8556invoke();
            return C4070l.f13734a;
        }

        @Override
        public void ping(boolean z7, final int i6, final int i10) {
            if (!z7) {
                TaskQueue taskQueue = this.this$0.writerQueue;
                final String str = this.this$0.getConnectionName$okhttp() + " ping";
                final Http2Connection http2Connection = this.this$0;
                final boolean z10 = true;
                taskQueue.schedule(new Task(str, z10) {
                    @Override
                    public long runOnce() {
                        http2Connection.writePing(true, i6, i10);
                        return -1L;
                    }
                }, 0L);
                return;
            }
            Http2Connection http2Connection2 = this.this$0;
            synchronized (http2Connection2) {
                try {
                    if (i6 == 1) {
                        http2Connection2.intervalPongsReceived++;
                    } else if (i6 == 2) {
                        http2Connection2.degradedPongsReceived++;
                    } else if (i6 == 3) {
                        http2Connection2.awaitPongsReceived++;
                        AbstractC2796i.m5783d(http2Connection2, "null cannot be cast to non-null type java.lang.Object");
                        http2Connection2.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override
        public void pushPromise(int i6, int i10, List<Header> list) {
            AbstractC2796i.m5785f(list, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(i10, list);
        }

        @Override
        public void rstStream(int i6, ErrorCode errorCode) {
            AbstractC2796i.m5785f(errorCode, "errorCode");
            if (this.this$0.pushedStream$okhttp(i6)) {
                this.this$0.pushResetLater$okhttp(i6, errorCode);
                return;
            }
            Http2Stream http2StreamRemoveStream$okhttp = this.this$0.removeStream$okhttp(i6);
            if (http2StreamRemoveStream$okhttp != null) {
                http2StreamRemoveStream$okhttp.receiveRstStream(errorCode);
            }
        }

        @Override
        public void settings(final boolean z7, final Settings settings) {
            AbstractC2796i.m5785f(settings, "settings");
            TaskQueue taskQueue = this.this$0.writerQueue;
            final String str = this.this$0.getConnectionName$okhttp() + " applyAndAckSettings";
            final boolean z10 = true;
            taskQueue.schedule(new Task(str, z10) {
                @Override
                public long runOnce() {
                    this.applyAndAckSettings(z7, settings);
                    return -1L;
                }
            }, 0L);
        }

        @Override
        public void windowUpdate(int i6, long j10) {
            if (i6 == 0) {
                Http2Connection http2Connection = this.this$0;
                synchronized (http2Connection) {
                    http2Connection.writeBytesMaximum = http2Connection.getWriteBytesMaximum() + j10;
                    http2Connection.notifyAll();
                }
                return;
            }
            Http2Stream stream = this.this$0.getStream(i6);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j10);
                }
            }
        }

        public void m8556invoke() throws Throwable {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e5 = null;
            try {
                try {
                    this.reader.readConnectionPreface(this);
                    while (this.reader.nextFrame(false, this)) {
                    }
                    ErrorCode errorCode3 = ErrorCode.NO_ERROR;
                    try {
                        this.this$0.close$okhttp(errorCode3, ErrorCode.CANCEL, null);
                        errorCode = errorCode3;
                    } catch (IOException e10) {
                        e5 = e10;
                        ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                        Http2Connection http2Connection = this.this$0;
                        http2Connection.close$okhttp(errorCode4, errorCode4, e5);
                        errorCode = http2Connection;
                    }
                } catch (Throwable th) {
                    th = th;
                    this.this$0.close$okhttp(errorCode, errorCode2, e5);
                    Util.closeQuietly(this.reader);
                    throw th;
                }
            } catch (IOException e11) {
                e5 = e11;
            } catch (Throwable th2) {
                th = th2;
                errorCode = errorCode2;
                this.this$0.close$okhttp(errorCode, errorCode2, e5);
                Util.closeQuietly(this.reader);
                throw th;
            }
            errorCode2 = this.reader;
            Util.closeQuietly((Closeable) errorCode2);
        }

        @Override
        public void ackSettings() {
        }

        @Override
        public void priority(int i6, int i10, int i11, boolean z7) {
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(7, 65535);
        settings.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(Builder builder) {
        AbstractC2796i.m5785f(builder, "builder");
        boolean client$okhttp = builder.getClient$okhttp();
        this.client = client$okhttp;
        this.listener = builder.getListener$okhttp();
        this.streams = new LinkedHashMap();
        String connectionName$okhttp = builder.getConnectionName$okhttp();
        this.connectionName = connectionName$okhttp;
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp;
        TaskQueue taskQueueNewQueue = taskRunner$okhttp.newQueue();
        this.writerQueue = taskQueueNewQueue;
        this.pushQueue = taskRunner$okhttp.newQueue();
        this.settingsListenerQueue = taskRunner$okhttp.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings = new Settings();
        if (builder.getClient$okhttp()) {
            settings.set(7, OKHTTP_CLIENT_WINDOW_SIZE);
        }
        this.okHttpSettings = settings;
        Settings settings2 = DEFAULT_SETTINGS;
        this.peerSettings = settings2;
        this.writeBytesMaximum = settings2.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), client$okhttp);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.getSource$okhttp(), client$okhttp));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            final long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis$okhttp());
            final String strM5494h = AbstractC2460q.m5494h(connectionName$okhttp, " ping");
            taskQueueNewQueue.schedule(new Task(strM5494h) {
                @Override
                public long runOnce() {
                    boolean z7;
                    synchronized (this) {
                        if (this.intervalPongsReceived < this.intervalPingsSent) {
                            z7 = true;
                        } else {
                            this.intervalPingsSent++;
                            z7 = false;
                        }
                    }
                    if (z7) {
                        this.failConnection(null);
                        return -1L;
                    }
                    this.writePing(false, 1, 0);
                    return nanos;
                }
            }, nanos);
        }
    }

    public final void failConnection(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(errorCode, errorCode, iOException);
    }

    public static void start$default(Http2Connection http2Connection, boolean z7, TaskRunner taskRunner, int i6, Object obj) throws IOException {
        if ((i6 & 1) != 0) {
            z7 = true;
        }
        if ((i6 & 2) != 0) {
            taskRunner = TaskRunner.INSTANCE;
        }
        http2Connection.start(z7, taskRunner);
    }

    public final synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    @Override
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(ErrorCode errorCode, ErrorCode errorCode2, IOException iOException) {
        int i6;
        Object[] array;
        AbstractC2796i.m5785f(errorCode, "connectionCode");
        AbstractC2796i.m5785f(errorCode2, "streamCode");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        try {
            shutdown(errorCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (this.streams.isEmpty()) {
                array = null;
            } else {
                array = this.streams.values().toArray(new Http2Stream[0]);
                this.streams.clear();
            }
        }
        Http2Stream[] http2StreamArr = (Http2Stream[]) array;
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(errorCode2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final synchronized Http2Stream getStream(int i6) {
        return this.streams.get(Integer.valueOf(i6));
    }

    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final synchronized boolean isHealthy(long j10) {
        if (this.isShutdown) {
            return false;
        }
        return this.degradedPongsReceived >= this.degradedPingsSent || j10 < this.degradedPongDeadlineNs;
    }

    public final Http2Stream newStream(List<Header> list, boolean z7) throws IOException {
        AbstractC2796i.m5785f(list, "requestHeaders");
        return newStream(0, list, z7);
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    public final void pushDataLater$okhttp(final int i6, BufferedSource bufferedSource, final int i10, final boolean z7) throws IOException {
        AbstractC2796i.m5785f(bufferedSource, "source");
        final Buffer buffer = new Buffer();
        long j10 = i10;
        bufferedSource.require(j10);
        bufferedSource.read(buffer, j10);
        TaskQueue taskQueue = this.pushQueue;
        final String str = this.connectionName + '[' + i6 + "] onData";
        final boolean z10 = true;
        taskQueue.schedule(new Task(str, z10) {
            @Override
            public long runOnce() {
                try {
                    boolean zOnData = this.pushObserver.onData(i6, buffer, i10, z7);
                    if (zOnData) {
                        this.getWriter().rstStream(i6, ErrorCode.CANCEL);
                    }
                    if (!zOnData && !z7) {
                        return -1L;
                    }
                    synchronized (this) {
                        this.currentPushRequests.remove(Integer.valueOf(i6));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void pushHeadersLater$okhttp(final int i6, final List<Header> list, final boolean z7) {
        AbstractC2796i.m5785f(list, "requestHeaders");
        TaskQueue taskQueue = this.pushQueue;
        final String str = this.connectionName + '[' + i6 + "] onHeaders";
        final boolean z10 = true;
        taskQueue.schedule(new Task(str, z10) {
            @Override
            public long runOnce() {
                boolean zOnHeaders = this.pushObserver.onHeaders(i6, list, z7);
                if (zOnHeaders) {
                    try {
                        this.getWriter().rstStream(i6, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
                if (!zOnHeaders && !z7) {
                    return -1L;
                }
                synchronized (this) {
                    this.currentPushRequests.remove(Integer.valueOf(i6));
                }
                return -1L;
            }
        }, 0L);
    }

    public final void pushRequestLater$okhttp(final int i6, final List<Header> list) {
        AbstractC2796i.m5785f(list, "requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i6))) {
                writeSynResetLater$okhttp(i6, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i6));
            TaskQueue taskQueue = this.pushQueue;
            final String str = this.connectionName + '[' + i6 + "] onRequest";
            final boolean z7 = true;
            taskQueue.schedule(new Task(str, z7) {
                @Override
                public long runOnce() {
                    if (!this.pushObserver.onRequest(i6, list)) {
                        return -1L;
                    }
                    try {
                        this.getWriter().rstStream(i6, ErrorCode.CANCEL);
                        synchronized (this) {
                            this.currentPushRequests.remove(Integer.valueOf(i6));
                        }
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }, 0L);
        }
    }

    public final void pushResetLater$okhttp(final int i6, final ErrorCode errorCode) {
        AbstractC2796i.m5785f(errorCode, "errorCode");
        TaskQueue taskQueue = this.pushQueue;
        final String str = this.connectionName + '[' + i6 + "] onReset";
        final boolean z7 = true;
        taskQueue.schedule(new Task(str, z7) {
            @Override
            public long runOnce() {
                this.pushObserver.onReset(i6, errorCode);
                synchronized (this) {
                    this.currentPushRequests.remove(Integer.valueOf(i6));
                }
                return -1L;
            }
        }, 0L);
    }

    public final Http2Stream pushStream(int i6, List<Header> list, boolean z7) throws IOException {
        AbstractC2796i.m5785f(list, "requestHeaders");
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        return newStream(i6, list, z7);
    }

    public final boolean pushedStream$okhttp(int i6) {
        return i6 != 0 && (i6 & 1) == 0;
    }

    public final synchronized Http2Stream removeStream$okhttp(int i6) {
        Http2Stream http2StreamRemove;
        http2StreamRemove = this.streams.remove(Integer.valueOf(i6));
        notifyAll();
        return http2StreamRemove;
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            long j10 = this.degradedPongsReceived;
            long j11 = this.degradedPingsSent;
            if (j10 < j11) {
                return;
            }
            this.degradedPingsSent = j11 + 1;
            this.degradedPongDeadlineNs = System.nanoTime() + ((long) DEGRADED_PONG_TIMEOUT_NS);
            TaskQueue taskQueue = this.writerQueue;
            final String strM26t = AbstractC0004e.m26t(new StringBuilder(), this.connectionName, " ping");
            final boolean z7 = true;
            taskQueue.schedule(new Task(strM26t, z7) {
                @Override
                public long runOnce() {
                    this.writePing(false, 2, 0);
                    return -1L;
                }
            }, 0L);
        }
    }

    public final void setLastGoodStreamId$okhttp(int i6) {
        this.lastGoodStreamId = i6;
    }

    public final void setNextStreamId$okhttp(int i6) {
        this.nextStreamId = i6;
    }

    public final void setPeerSettings(Settings settings) {
        AbstractC2796i.m5785f(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final void setSettings(Settings settings) throws IOException {
        AbstractC2796i.m5785f(settings, "settings");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
            }
            this.writer.settings(settings);
        }
    }

    public final void shutdown(ErrorCode errorCode) throws IOException {
        AbstractC2796i.m5785f(errorCode, "statusCode");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                this.writer.goAway(this.lastGoodStreamId, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public final void start() throws IOException {
        start$default(this, false, null, 3, null);
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j10) {
        long j11 = this.readBytesTotal + j10;
        this.readBytesTotal = j11;
        long j12 = j11 - this.readBytesAcknowledged;
        if (j12 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater$okhttp(0, j12);
            this.readBytesAcknowledged += j12;
        }
    }

    public final void writeData(int i6, boolean z7, Buffer buffer, long j10) throws IOException {
        long j11;
        long j12;
        int iMin;
        long j13;
        if (j10 == 0) {
            this.writer.data(z7, i6, buffer, 0);
            return;
        }
        while (j10 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j11 = this.writeBytesTotal;
                            j12 = this.writeBytesMaximum;
                            if (j11 >= j12) {
                                if (!this.streams.containsKey(Integer.valueOf(i6))) {
                                    throw new IOException("stream closed");
                                }
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                iMin = Math.min((int) Math.min(j10, j12 - j11), this.writer.maxDataLength());
                j13 = iMin;
                this.writeBytesTotal += j13;
            }
            j10 -= j13;
            this.writer.data(z7 && j10 == 0, i6, buffer, iMin);
        }
    }

    public final void writeHeaders$okhttp(int i6, boolean z7, List<Header> list) throws IOException {
        AbstractC2796i.m5785f(list, "alternating");
        this.writer.headers(z7, i6, list);
    }

    public final void writePing(boolean z7, int i6, int i10) {
        try {
            this.writer.ping(z7, i6, i10);
        } catch (IOException e5) {
            failConnection(e5);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public final void writeSynReset$okhttp(int i6, ErrorCode errorCode) throws IOException {
        AbstractC2796i.m5785f(errorCode, "statusCode");
        this.writer.rstStream(i6, errorCode);
    }

    public final void writeSynResetLater$okhttp(final int i6, final ErrorCode errorCode) {
        AbstractC2796i.m5785f(errorCode, "errorCode");
        TaskQueue taskQueue = this.writerQueue;
        final String str = this.connectionName + '[' + i6 + "] writeSynReset";
        final boolean z7 = true;
        taskQueue.schedule(new Task(str, z7) {
            @Override
            public long runOnce() {
                try {
                    this.writeSynReset$okhttp(i6, errorCode);
                    return -1L;
                } catch (IOException e5) {
                    this.failConnection(e5);
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void writeWindowUpdateLater$okhttp(final int i6, final long j10) {
        TaskQueue taskQueue = this.writerQueue;
        final String str = this.connectionName + '[' + i6 + "] windowUpdate";
        final boolean z7 = true;
        taskQueue.schedule(new Task(str, z7) {
            @Override
            public long runOnce() {
                try {
                    this.getWriter().windowUpdate(i6, j10);
                    return -1L;
                } catch (IOException e5) {
                    this.failConnection(e5);
                    return -1L;
                }
            }
        }, 0L);
    }

    private final Http2Stream newStream(int i6, List<Header> list, boolean z7) throws IOException {
        int i10;
        Http2Stream http2Stream;
        boolean z10;
        boolean z11 = !z7;
        synchronized (this.writer) {
            try {
                synchronized (this) {
                    try {
                        if (this.nextStreamId > 1073741823) {
                            shutdown(ErrorCode.REFUSED_STREAM);
                        }
                        if (this.isShutdown) {
                            throw new ConnectionShutdownException();
                        }
                        i10 = this.nextStreamId;
                        this.nextStreamId = i10 + 2;
                        http2Stream = new Http2Stream(i10, this, z11, false, null);
                        z10 = !z7 || this.writeBytesTotal >= this.writeBytesMaximum || http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum();
                        if (http2Stream.isOpen()) {
                            this.streams.put(Integer.valueOf(i10), http2Stream);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i6 == 0) {
                    this.writer.headers(z11, i10, list);
                } else {
                    if (this.client) {
                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                    }
                    this.writer.pushPromise(i6, i10, list);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            this.writer.flush();
        }
        return http2Stream;
    }

    public final void start(boolean z7) throws IOException {
        start$default(this, z7, null, 2, null);
    }

    public final void start(boolean z7, TaskRunner taskRunner) throws IOException {
        AbstractC2796i.m5785f(taskRunner, "taskRunner");
        if (z7) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.windowUpdate(0, initialWindowSize - 65535);
            }
        }
        taskRunner.newQueue().schedule(new TaskQueue.C32931(this.connectionName, true, this.readerRunnable), 0L);
    }

    public final void writePing() throws InterruptedException {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }
}
