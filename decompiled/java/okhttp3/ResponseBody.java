package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3643a;
import p243w8.C4070l;

public abstract class ResponseBody implements Closeable {
    public static final Companion Companion = new Companion(null);
    private Reader reader;

    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final BufferedSource source;

        public BomAwareReader(BufferedSource bufferedSource, Charset charset) {
            AbstractC2796i.m5785f(bufferedSource, "source");
            AbstractC2796i.m5785f(charset, "charset");
            this.source = bufferedSource;
            this.charset = charset;
        }

        @Override
        public void close() throws IOException {
            C4070l c4070l;
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
                c4070l = C4070l.f13734a;
            } else {
                c4070l = null;
            }
            if (c4070l == null) {
                this.source.close();
            }
        }

        @Override
        public int read(char[] cArr, int i6, int i10) throws IOException {
            AbstractC2796i.m5785f(cArr, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.delegate;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
                this.delegate = inputStreamReader;
            }
            return inputStreamReader.read(cArr, i6, i10);
        }
    }

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public static ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final ResponseBody create(String str, MediaType mediaType) {
            AbstractC2796i.m5785f(str, "<this>");
            Charset charset = AbstractC3643a.f12236a;
            if (mediaType != null) {
                Charset charsetCharset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charsetCharset$default == null) {
                    mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetCharset$default;
                }
            }
            Buffer bufferWriteString = new Buffer().writeString(str, charset);
            return create(bufferWriteString, mediaType, bufferWriteString.size());
        }

        private Companion() {
        }

        public static ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static ResponseBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public static ResponseBody create$default(Companion companion, BufferedSource bufferedSource, MediaType mediaType, long j10, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            if ((i6 & 2) != 0) {
                j10 = -1;
            }
            return companion.create(bufferedSource, mediaType, j10);
        }

        public final ResponseBody create(byte[] bArr, MediaType mediaType) {
            AbstractC2796i.m5785f(bArr, "<this>");
            return create(new Buffer().write(bArr), mediaType, bArr.length);
        }

        public final ResponseBody create(ByteString byteString, MediaType mediaType) {
            AbstractC2796i.m5785f(byteString, "<this>");
            return create(new Buffer().write(byteString), mediaType, byteString.size());
        }

        public final ResponseBody create(final BufferedSource bufferedSource, final MediaType mediaType, final long j10) {
            AbstractC2796i.m5785f(bufferedSource, "<this>");
            return new ResponseBody() {
                @Override
                public long contentLength() {
                    return j10;
                }

                @Override
                public MediaType contentType() {
                    return mediaType;
                }

                @Override
                public BufferedSource source() {
                    return bufferedSource;
                }
            };
        }

        public final ResponseBody create(MediaType mediaType, String str) {
            AbstractC2796i.m5785f(str, "content");
            return create(str, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, byte[] bArr) {
            AbstractC2796i.m5785f(bArr, "content");
            return create(bArr, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, ByteString byteString) {
            AbstractC2796i.m5785f(byteString, "content");
            return create(byteString, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, long j10, BufferedSource bufferedSource) {
            AbstractC2796i.m5785f(bufferedSource, "content");
            return create(bufferedSource, mediaType, j10);
        }
    }

    private final Charset charset() {
        Charset charset;
        MediaType mediaTypeContentType = contentType();
        return (mediaTypeContentType == null || (charset = mediaTypeContentType.charset(AbstractC3643a.f12236a)) == null) ? AbstractC3643a.f12236a : charset;
    }

    private final <T> T consumeSource(InterfaceC2724l interfaceC2724l, InterfaceC2724l interfaceC2724l2) throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(AbstractC0004e.m21o(jContentLength, "Cannot buffer entire body for content length: "));
        }
        BufferedSource bufferedSourceSource = source();
        try {
            T t5 = (T) interfaceC2724l.invoke(bufferedSourceSource);
            AbstractC0032a.m164r(bufferedSourceSource, null);
            int iIntValue = ((Number) interfaceC2724l2.invoke(t5)).intValue();
            if (jContentLength == -1 || jContentLength == iIntValue) {
                return t5;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iIntValue + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AbstractC0032a.m164r(bufferedSourceSource, th);
                throw th2;
            }
        }
    }

    public static final ResponseBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    public final ByteString byteString() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(AbstractC0004e.m21o(jContentLength, "Cannot buffer entire body for content length: "));
        }
        BufferedSource bufferedSourceSource = source();
        try {
            ByteString byteString = bufferedSourceSource.readByteString();
            AbstractC0032a.m164r(bufferedSourceSource, null);
            int size = byteString.size();
            if (jContentLength == -1 || jContentLength == size) {
                return byteString;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + size + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AbstractC0032a.m164r(bufferedSourceSource, th);
                throw th2;
            }
        }
    }

    public final byte[] bytes() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(AbstractC0004e.m21o(jContentLength, "Cannot buffer entire body for content length: "));
        }
        BufferedSource bufferedSourceSource = source();
        try {
            byte[] byteArray = bufferedSourceSource.readByteArray();
            AbstractC0032a.m164r(bufferedSourceSource, null);
            int length = byteArray.length;
            if (jContentLength == -1 || jContentLength == length) {
                return byteArray;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + length + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AbstractC0032a.m164r(bufferedSourceSource, th);
                throw th2;
            }
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    @Override
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final String string() throws IOException {
        BufferedSource bufferedSourceSource = source();
        try {
            String string = bufferedSourceSource.readString(Util.readBomAsCharset(bufferedSourceSource, charset()));
            AbstractC0032a.m164r(bufferedSourceSource, null);
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AbstractC0032a.m164r(bufferedSourceSource, th);
                throw th2;
            }
        }
    }

    public static final ResponseBody create(MediaType mediaType, long j10, BufferedSource bufferedSource) {
        return Companion.create(mediaType, j10, bufferedSource);
    }

    public static final ResponseBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final ResponseBody create(MediaType mediaType, ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    public static final ResponseBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    public static final ResponseBody create(BufferedSource bufferedSource, MediaType mediaType, long j10) {
        return Companion.create(bufferedSource, mediaType, j10);
    }

    public static final ResponseBody create(ByteString byteString, MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    public static final ResponseBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }
}
