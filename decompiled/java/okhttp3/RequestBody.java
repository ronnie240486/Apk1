package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3643a;

public abstract class RequestBody {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public static RequestBody create$default(Companion companion, String str, MediaType mediaType, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr) {
            AbstractC2796i.m5785f(bArr, "content");
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        private Companion() {
        }

        public static RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i6) {
            AbstractC2796i.m5785f(bArr, "content");
            return create$default(this, mediaType, bArr, i6, 0, 8, (Object) null);
        }

        public static RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i6, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                mediaType = null;
            }
            if ((i11 & 2) != 0) {
                i6 = 0;
            }
            if ((i11 & 4) != 0) {
                i10 = bArr.length;
            }
            return companion.create(bArr, mediaType, i6, i10);
        }

        public final RequestBody create(byte[] bArr) {
            AbstractC2796i.m5785f(bArr, "<this>");
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType) {
            AbstractC2796i.m5785f(bArr, "<this>");
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public static RequestBody create$default(Companion companion, File file, MediaType mediaType, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType, int i6) {
            AbstractC2796i.m5785f(bArr, "<this>");
            return create$default(this, bArr, mediaType, i6, 0, 4, (Object) null);
        }

        public static RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i6, int i10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                i6 = 0;
            }
            if ((i11 & 8) != 0) {
                i10 = bArr.length;
            }
            return companion.create(mediaType, bArr, i6, i10);
        }

        public final RequestBody create(String str, MediaType mediaType) {
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
            byte[] bytes = str.getBytes(charset);
            AbstractC2796i.m5784e(bytes, "this as java.lang.String).getBytes(charset)");
            return create(bytes, mediaType, 0, bytes.length);
        }

        public final RequestBody create(final ByteString byteString, final MediaType mediaType) {
            AbstractC2796i.m5785f(byteString, "<this>");
            return new RequestBody() {
                @Override
                public long contentLength() {
                    return byteString.size();
                }

                @Override
                public MediaType contentType() {
                    return mediaType;
                }

                @Override
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    AbstractC2796i.m5785f(bufferedSink, "sink");
                    bufferedSink.write(byteString);
                }
            };
        }

        public final RequestBody create(final byte[] bArr, final MediaType mediaType, final int i6, final int i10) {
            AbstractC2796i.m5785f(bArr, "<this>");
            Util.checkOffsetAndCount(bArr.length, i6, i10);
            return new RequestBody() {
                @Override
                public long contentLength() {
                    return i10;
                }

                @Override
                public MediaType contentType() {
                    return mediaType;
                }

                @Override
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    AbstractC2796i.m5785f(bufferedSink, "sink");
                    bufferedSink.write(bArr, i6, i10);
                }
            };
        }

        public final RequestBody create(final File file, final MediaType mediaType) {
            AbstractC2796i.m5785f(file, "<this>");
            return new RequestBody() {
                @Override
                public long contentLength() {
                    return file.length();
                }

                @Override
                public MediaType contentType() {
                    return mediaType;
                }

                @Override
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    AbstractC2796i.m5785f(bufferedSink, "sink");
                    Source source = Okio.source(file);
                    try {
                        bufferedSink.writeAll(source);
                        AbstractC0032a.m164r(source, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            AbstractC0032a.m164r(source, th);
                            throw th2;
                        }
                    }
                }
            };
        }

        public final RequestBody create(MediaType mediaType, String str) {
            AbstractC2796i.m5785f(str, "content");
            return create(str, mediaType);
        }

        public final RequestBody create(MediaType mediaType, ByteString byteString) {
            AbstractC2796i.m5785f(byteString, "content");
            return create(byteString, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i6, int i10) {
            AbstractC2796i.m5785f(bArr, "content");
            return create(bArr, mediaType, i6, i10);
        }

        public final RequestBody create(MediaType mediaType, File file) {
            AbstractC2796i.m5785f(file, "file");
            return create(file, mediaType);
        }
    }

    public static final RequestBody create(File file, MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static final RequestBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, File file) {
        return Companion.create(mediaType, file);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final RequestBody create(MediaType mediaType, ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i6) {
        return Companion.create(mediaType, bArr, i6);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i6, int i10) {
        return Companion.create(mediaType, bArr, i6, i10);
    }

    public static final RequestBody create(ByteString byteString, MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    public static final RequestBody create(byte[] bArr) {
        return Companion.create(bArr);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i6) {
        return Companion.create(bArr, mediaType, i6);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i6, int i10) {
        return Companion.create(bArr, mediaType, i6, i10);
    }
}
