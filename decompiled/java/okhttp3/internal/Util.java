package okhttp3.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.common.C0628x;
import androidx.media3.exoplayer.rtsp.RtspHeaders;
import com.bumptech.glide.AbstractC1465c;
import com.lzy.okgo.cookie.SerializableCookie;
import com.lzy.okgo.model.HttpHeaders;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okhttp3.internal.p158io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;
import p003a2.AbstractC0032a;
import p091i9.InterfaceC2713a;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2804q;
import p123l5.AbstractC2973a;
import p156o9.C3283g;
import p156o9.C3284h;
import p192r9.AbstractC3643a;
import p192r9.AbstractC3648f;
import p192r9.AbstractC3656n;
import p192r9.C3647e;
import p253x8.AbstractC4147j;
import p253x8.AbstractC4149l;
import p253x8.C4155r;
import p253x8.C4156s;

public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.Companion.m6640of(new String[0]);
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    private static final Options UNICODE_BOMS;
    public static final TimeZone UTC;
    private static final C3647e VERIFY_AS_IP_ADDRESS;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;
    public static final String userAgent = "okhttp/4.12.0";

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        Options.Companion companion = Options.Companion;
        ByteString.Companion companion2 = ByteString.Companion;
        UNICODE_BOMS = companion.m6650of(companion2.decodeHex("efbbbf"), companion2.decodeHex("feff"), companion2.decodeHex("fffe"), companion2.decodeHex("0000ffff"), companion2.decodeHex("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        AbstractC2796i.m5782c(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new C3647e("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String strM7385g0 = AbstractC3648f.m7385g0(OkHttpClient.class.getName(), "okhttp3.");
        if (AbstractC3656n.m7397O(strM7385g0, "Client", false)) {
            strM7385g0 = strM7385g0.substring(0, strM7385g0.length() - 6);
            AbstractC2796i.m5784e(strM7385g0, "substring(...)");
        }
        okHttpName = strM7385g0;
    }

    public static final <E> void addIfAbsent(List<E> list, E e5) {
        AbstractC2796i.m5785f(list, "<this>");
        if (list.contains(e5)) {
            return;
        }
        list.add(e5);
    }

    public static final int and(byte b8, int i6) {
        return b8 & i6;
    }

    public static final EventListener.Factory asFactory(EventListener eventListener) {
        AbstractC2796i.m5785f(eventListener, "<this>");
        return new C0628x(10, eventListener);
    }

    public static final EventListener asFactory$lambda$8(EventListener eventListener, Call call) {
        AbstractC2796i.m5785f(eventListener, "$this_asFactory");
        AbstractC2796i.m5785f(call, "it");
        return eventListener;
    }

    public static final void assertThreadDoesntHoldLock(Object obj) {
        AbstractC2796i.m5785f(obj, "<this>");
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + obj);
        }
    }

    public static final void assertThreadHoldsLock(Object obj) {
        AbstractC2796i.m5785f(obj, "<this>");
        if (!assertionsEnabled || Thread.holdsLock(obj)) {
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + obj);
    }

    public static final boolean canParseAsIpAddress(String str) {
        AbstractC2796i.m5785f(str, "<this>");
        C3647e c3647e = VERIFY_AS_IP_ADDRESS;
        c3647e.getClass();
        return c3647e.f12254a.matcher(str).matches();
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        AbstractC2796i.m5785f(httpUrl, "<this>");
        AbstractC2796i.m5785f(httpUrl2, "other");
        return AbstractC2796i.m5780a(httpUrl.host(), httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && AbstractC2796i.m5780a(httpUrl.scheme(), httpUrl2.scheme());
    }

    public static final int checkDuration(String str, long j10, TimeUnit timeUnit) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        if (j10 < 0) {
            throw new IllegalStateException(str.concat(" < 0").toString());
        }
        if (timeUnit == null) {
            throw new IllegalStateException("unit == null");
        }
        long millis = timeUnit.toMillis(j10);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str.concat(" too large.").toString());
        }
        if (millis != 0 || j10 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str.concat(" too small.").toString());
    }

    public static final void checkOffsetAndCount(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        AbstractC2796i.m5785f(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e5) {
            throw e5;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] strArr, String str) {
        AbstractC2796i.m5785f(strArr, "<this>");
        AbstractC2796i.m5785f(str, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        AbstractC2796i.m5784e(objArrCopyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static final int delimiterOffset(String str, String str2, int i6, int i10) {
        AbstractC2796i.m5785f(str, "<this>");
        AbstractC2796i.m5785f(str2, "delimiters");
        while (i6 < i10) {
            if (AbstractC3648f.m7375W(str2, str.charAt(i6))) {
                return i6;
            }
            i6++;
        }
        return i10;
    }

    public static int delimiterOffset$default(String str, String str2, int i6, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i6 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = str.length();
        }
        return delimiterOffset(str, str2, i6, i10);
    }

    public static final boolean discard(Source source, int i6, TimeUnit timeUnit) {
        AbstractC2796i.m5785f(source, "<this>");
        AbstractC2796i.m5785f(timeUnit, "timeUnit");
        try {
            return skipAll(source, i6, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, InterfaceC2724l interfaceC2724l) {
        AbstractC2796i.m5785f(iterable, "<this>");
        AbstractC2796i.m5785f(interfaceC2724l, "predicate");
        ArrayList arrayList = C4155r.f14074a;
        for (T t5 : iterable) {
            if (((Boolean) interfaceC2724l.invoke(t5)).booleanValue()) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList();
                }
                AbstractC2804q.m5796a(arrayList).add(t5);
            }
        }
        return arrayList;
    }

    public static final String format(String str, Object... objArr) {
        AbstractC2796i.m5785f(str, "format");
        AbstractC2796i.m5785f(objArr, "args");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        AbstractC2796i.m5785f(strArr, "<this>");
        AbstractC2796i.m5785f(comparator, "comparator");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                int i6 = 0;
                while (true) {
                    if (i6 < strArr2.length) {
                        int i10 = i6 + 1;
                        try {
                            if (comparator.compare(str, strArr2[i6]) == 0) {
                                return true;
                            }
                            i6 = i10;
                        } catch (ArrayIndexOutOfBoundsException e5) {
                            throw new NoSuchElementException(e5.getMessage());
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(Response response) {
        AbstractC2796i.m5785f(response, "<this>");
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final void ignoreIoExceptions(InterfaceC2713a interfaceC2713a) {
        AbstractC2796i.m5785f(interfaceC2713a, "block");
        try {
            interfaceC2713a.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... tArr) {
        List listAsList;
        AbstractC2796i.m5785f(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC2796i.m5785f(objArrCopyOf, "elements");
        if (objArrCopyOf.length > 0) {
            listAsList = Arrays.asList(objArrCopyOf);
            AbstractC2796i.m5784e(listAsList, "asList(...)");
        } else {
            listAsList = C4155r.f14074a;
        }
        List<T> listUnmodifiableList = Collections.unmodifiableList(listAsList);
        AbstractC2796i.m5784e(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int indexOf(String[] strArr, String str, Comparator<String> comparator) {
        AbstractC2796i.m5785f(strArr, "<this>");
        AbstractC2796i.m5785f(str, "value");
        AbstractC2796i.m5785f(comparator, "comparator");
        int length = strArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (comparator.compare(strArr[i6], str) == 0) {
                return i6;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        AbstractC2796i.m5785f(str, "<this>");
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt = str.charAt(i6);
            if (AbstractC2796i.m5787h(cCharAt, 31) <= 0 || AbstractC2796i.m5787h(cCharAt, 127) >= 0) {
                return i6;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i6, int i10) {
        AbstractC2796i.m5785f(str, "<this>");
        while (i6 < i10) {
            char cCharAt = str.charAt(i6);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i6;
            }
            i6++;
        }
        return i10;
    }

    public static int indexOfFirstNonAsciiWhitespace$default(String str, int i6, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i6 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i6, i10);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i6, int i10) {
        AbstractC2796i.m5785f(str, "<this>");
        int i11 = i10 - 1;
        if (i6 <= i11) {
            while (true) {
                char cCharAt = str.charAt(i11);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i11 + 1;
                }
                if (i11 != i6) {
                    i11--;
                }
            }
        }
        return i6;
    }

    public static int indexOfLastNonAsciiWhitespace$default(String str, int i6, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i6 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i6, i10);
    }

    public static final int indexOfNonWhitespace(String str, int i6) {
        AbstractC2796i.m5785f(str, "<this>");
        int length = str.length();
        while (i6 < length) {
            char cCharAt = str.charAt(i6);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i6;
            }
            i6++;
        }
        return str.length();
    }

    public static int indexOfNonWhitespace$default(String str, int i6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i6 = 0;
        }
        return indexOfNonWhitespace(str, i6);
    }

    public static final String[] intersect(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        AbstractC2796i.m5785f(strArr, "<this>");
        AbstractC2796i.m5785f(strArr2, "other");
        AbstractC2796i.m5785f(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean isCivilized(FileSystem fileSystem, File file) throws IOException {
        AbstractC2796i.m5785f(fileSystem, "<this>");
        AbstractC2796i.m5785f(file, "file");
        Sink sink = fileSystem.sink(file);
        try {
            fileSystem.delete(file);
            AbstractC0032a.m164r(sink, null);
            return true;
        } catch (IOException unused) {
            AbstractC0032a.m164r(sink, null);
            fileSystem.delete(file);
            return false;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AbstractC0032a.m164r(sink, th);
                throw th2;
            }
        }
    }

    public static final boolean isHealthy(Socket socket, BufferedSource bufferedSource) {
        AbstractC2796i.m5785f(socket, "<this>");
        AbstractC2796i.m5785f(bufferedSource, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !bufferedSource.exhausted();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean isSensitiveHeader(String str) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        return str.equalsIgnoreCase(RtspHeaders.AUTHORIZATION) || str.equalsIgnoreCase(HttpHeaders.HEAD_KEY_COOKIE) || str.equalsIgnoreCase("Proxy-Authorization") || str.equalsIgnoreCase(HttpHeaders.HEAD_KEY_SET_COOKIE);
    }

    public static final void notify(Object obj) {
        AbstractC2796i.m5785f(obj, "<this>");
        obj.notify();
    }

    public static final void notifyAll(Object obj) {
        AbstractC2796i.m5785f(obj, "<this>");
        obj.notifyAll();
    }

    public static final int parseHexDigit(char c5) {
        if ('0' <= c5 && c5 < ':') {
            return c5 - '0';
        }
        if ('a' <= c5 && c5 < 'g') {
            return c5 - 'W';
        }
        if ('A' > c5 || c5 >= 'G') {
            return -1;
        }
        return c5 - '7';
    }

    public static final String peerName(Socket socket) {
        AbstractC2796i.m5785f(socket, "<this>");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
        AbstractC2796i.m5784e(hostName, "address.hostName");
        return hostName;
    }

    public static final Charset readBomAsCharset(BufferedSource bufferedSource, Charset charset) throws IOException {
        Charset charsetForName;
        AbstractC2796i.m5785f(bufferedSource, "<this>");
        AbstractC2796i.m5785f(charset, "default");
        int iSelect = bufferedSource.select(UNICODE_BOMS);
        if (iSelect == -1) {
            return charset;
        }
        if (iSelect == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            AbstractC2796i.m5784e(charset2, "UTF_8");
            return charset2;
        }
        if (iSelect == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            AbstractC2796i.m5784e(charset3, "UTF_16BE");
            return charset3;
        }
        if (iSelect == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            AbstractC2796i.m5784e(charset4, "UTF_16LE");
            return charset4;
        }
        if (iSelect == 3) {
            Charset charset5 = AbstractC3643a.f12236a;
            charsetForName = AbstractC3643a.f12238c;
            if (charsetForName == null) {
                charsetForName = Charset.forName("UTF-32BE");
                AbstractC2796i.m5784e(charsetForName, "forName(...)");
                AbstractC3643a.f12238c = charsetForName;
            }
        } else {
            if (iSelect != 4) {
                throw new AssertionError();
            }
            Charset charset6 = AbstractC3643a.f12236a;
            charsetForName = AbstractC3643a.f12237b;
            if (charsetForName == null) {
                charsetForName = Charset.forName("UTF-32LE");
                AbstractC2796i.m5784e(charsetForName, "forName(...)");
                AbstractC3643a.f12237b = charsetForName;
            }
        }
        return charsetForName;
    }

    public static final <T> T readFieldOrNull(Object obj, Class<T> cls, String str) throws IllegalAccessException {
        Object fieldOrNull;
        AbstractC2796i.m5785f(obj, "instance");
        AbstractC2796i.m5785f(cls, "fieldType");
        AbstractC2796i.m5785f(str, "fieldName");
        Class<?> superclass = obj.getClass();
        while (true) {
            T tCast = null;
            if (superclass.equals(Object.class)) {
                if (str.equals("delegate") || (fieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(fieldOrNull, cls, str);
            }
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (cls.isInstance(obj2)) {
                    tCast = cls.cast(obj2);
                }
                return tCast;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
                AbstractC2796i.m5784e(superclass, "c.superclass");
            }
        }
    }

    public static final int readMedium(BufferedSource bufferedSource) throws IOException {
        AbstractC2796i.m5785f(bufferedSource, "<this>");
        return and(bufferedSource.readByte(), 255) | (and(bufferedSource.readByte(), 255) << 16) | (and(bufferedSource.readByte(), 255) << 8);
    }

    public static final boolean skipAll(Source source, int i6, TimeUnit timeUnit) throws IOException {
        AbstractC2796i.m5785f(source, "<this>");
        AbstractC2796i.m5785f(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jDeadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - jNanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(jDeadlineNanoTime, timeUnit.toNanos(i6)) + jNanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                buffer.clear();
            }
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th;
        }
    }

    public static final ThreadFactory threadFactory(final String str, final boolean z7) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        return new ThreadFactory() {
            @Override
            public final Thread newThread(Runnable runnable) {
                return Util.threadFactory$lambda$1(str, z7, runnable);
            }
        };
    }

    public static final Thread threadFactory$lambda$1(String str, boolean z7, Runnable runnable) {
        AbstractC2796i.m5785f(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z7);
        return thread;
    }

    public static final void threadName(String str, InterfaceC2713a interfaceC2713a) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        AbstractC2796i.m5785f(interfaceC2713a, "block");
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(str);
        try {
            interfaceC2713a.invoke();
        } finally {
            threadCurrentThread.setName(name);
        }
    }

    public static final List<Header> toHeaderList(Headers headers) {
        AbstractC2796i.m5785f(headers, "<this>");
        C3284h c3284hM3480o = AbstractC1465c.m3480o(0, headers.size());
        ArrayList arrayList = new ArrayList(AbstractC4149l.m8193Q(c3284hM3480o));
        Iterator it = c3284hM3480o.iterator();
        while (((C3283g) it).f10994c) {
            C3283g c3283g = (C3283g) it;
            int i6 = c3283g.f10995d;
            if (i6 != c3283g.f10993b) {
                c3283g.f10995d = c3283g.f10992a + i6;
            } else {
                if (!c3283g.f10994c) {
                    throw new NoSuchElementException();
                }
                c3283g.f10994c = false;
            }
            arrayList.add(new Header(headers.name(i6), headers.value(i6)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> list) {
        AbstractC2796i.m5785f(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().utf8(), header.component2().utf8());
        }
        return builder.build();
    }

    public static final String toHexString(long j10) {
        String hexString = Long.toHexString(j10);
        AbstractC2796i.m5784e(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z7) {
        String strHost;
        AbstractC2796i.m5785f(httpUrl, "<this>");
        if (AbstractC3648f.m7376X(httpUrl.host(), ":")) {
            strHost = "[" + httpUrl.host() + ']';
        } else {
            strHost = httpUrl.host();
        }
        if (!z7 && httpUrl.port() == HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return strHost;
        }
        return strHost + ':' + httpUrl.port();
    }

    public static String toHostHeader$default(HttpUrl httpUrl, boolean z7, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z7 = false;
        }
        return toHostHeader(httpUrl, z7);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        AbstractC2796i.m5785f(list, "<this>");
        List<T> listUnmodifiableList = Collections.unmodifiableList(AbstractC4147j.m8190d0(list));
        AbstractC2796i.m5784e(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        AbstractC2796i.m5785f(map, "<this>");
        if (map.isEmpty()) {
            return C4156s.f14075a;
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        AbstractC2796i.m5784e(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return mapUnmodifiableMap;
    }

    public static final long toLongOrDefault(String str, long j10) {
        AbstractC2796i.m5785f(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    public static final int toNonNegativeInt(String str, int i6) {
        if (str != null) {
            try {
                long j10 = Long.parseLong(str);
                if (j10 > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (j10 < 0) {
                    return 0;
                }
                return (int) j10;
            } catch (NumberFormatException unused) {
            }
        }
        return i6;
    }

    public static final String trimSubstring(String str, int i6, int i10) {
        AbstractC2796i.m5785f(str, "<this>");
        int iIndexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i6, i10);
        String strSubstring = str.substring(iIndexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, iIndexOfFirstNonAsciiWhitespace, i10));
        AbstractC2796i.m5784e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String trimSubstring$default(String str, int i6, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i6 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = str.length();
        }
        return trimSubstring(str, i6, i10);
    }

    public static final void wait(Object obj) throws InterruptedException {
        AbstractC2796i.m5785f(obj, "<this>");
        obj.wait();
    }

    public static final Throwable withSuppressed(Exception exc, List<? extends Exception> list) {
        AbstractC2796i.m5785f(exc, "<this>");
        AbstractC2796i.m5785f(list, "suppressed");
        Iterator<? extends Exception> it = list.iterator();
        while (it.hasNext()) {
            AbstractC2973a.m6013a(exc, it.next());
        }
        return exc;
    }

    public static final void writeMedium(BufferedSink bufferedSink, int i6) throws IOException {
        AbstractC2796i.m5785f(bufferedSink, "<this>");
        bufferedSink.writeByte((i6 >>> 16) & 255);
        bufferedSink.writeByte((i6 >>> 8) & 255);
        bufferedSink.writeByte(i6 & 255);
    }

    public static final int and(short s10, int i6) {
        return s10 & i6;
    }

    public static final int delimiterOffset(String str, char c5, int i6, int i10) {
        AbstractC2796i.m5785f(str, "<this>");
        while (i6 < i10) {
            if (str.charAt(i6) == c5) {
                return i6;
            }
            i6++;
        }
        return i10;
    }

    public static int delimiterOffset$default(String str, char c5, int i6, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i6 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = str.length();
        }
        return delimiterOffset(str, c5, i6, i10);
    }

    public static final String toHexString(int i6) {
        String hexString = Integer.toHexString(i6);
        AbstractC2796i.m5784e(hexString, "toHexString(this)");
        return hexString;
    }

    public static final long and(int i6, long j10) {
        return ((long) i6) & j10;
    }

    public static final void closeQuietly(Socket socket) {
        AbstractC2796i.m5785f(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e5) {
            throw e5;
        } catch (RuntimeException e10) {
            if (!AbstractC2796i.m5780a(e10.getMessage(), "bio == null")) {
                throw e10;
            }
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(ServerSocket serverSocket) {
        AbstractC2796i.m5785f(serverSocket, "<this>");
        try {
            serverSocket.close();
        } catch (RuntimeException e5) {
            throw e5;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(Buffer buffer, byte b8) throws EOFException {
        AbstractC2796i.m5785f(buffer, "<this>");
        int i6 = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b8) {
            i6++;
            buffer.readByte();
        }
        return i6;
    }
}
