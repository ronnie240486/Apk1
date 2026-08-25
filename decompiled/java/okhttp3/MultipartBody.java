package okhttp3;

import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cookie.SerializableCookie;
import com.lzy.okgo.model.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;

public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    public static final Companion Companion = new Companion(null);
    private static final byte[] DASHDASH;
    public static final MediaType DIGEST;
    public static final MediaType FORM;
    public static final MediaType MIXED;
    public static final MediaType PARALLEL;
    private final ByteString boundaryByteString;
    private long contentLength;
    private final MediaType contentType;
    private final List<Part> parts;
    private final MediaType type;

    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final Builder addFormDataPart(String str, String str2) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            AbstractC2796i.m5785f(str2, "value");
            addPart(Part.Companion.createFormData(str, str2));
            return this;
        }

        public final Builder addPart(RequestBody requestBody) {
            AbstractC2796i.m5785f(requestBody, TtmlNode.TAG_BODY);
            addPart(Part.Companion.create(requestBody));
            return this;
        }

        public final MultipartBody build() {
            if (this.parts.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
        }

        public final Builder setType(MediaType mediaType) {
            AbstractC2796i.m5785f(mediaType, SessionDescription.ATTR_TYPE);
            if (AbstractC2796i.m5780a(mediaType.type(), "multipart")) {
                this.type = mediaType;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + mediaType).toString());
        }

        public Builder(String str) {
            AbstractC2796i.m5785f(str, "boundary");
            this.boundary = ByteString.Companion.encodeUtf8(str);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        public final Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            AbstractC2796i.m5785f(str, SerializableCookie.NAME);
            AbstractC2796i.m5785f(requestBody, TtmlNode.TAG_BODY);
            addPart(Part.Companion.createFormData(str, str2, requestBody));
            return this;
        }

        public final Builder addPart(Headers headers, RequestBody requestBody) {
            AbstractC2796i.m5785f(requestBody, TtmlNode.TAG_BODY);
            addPart(Part.Companion.create(headers, requestBody));
            return this;
        }

        public final Builder addPart(Part part) {
            AbstractC2796i.m5785f(part, "part");
            this.parts.add(part);
            return this;
        }

        public Builder(String str, int i6, AbstractC2793f abstractC2793f) {
            if ((i6 & 1) != 0) {
                str = UUID.randomUUID().toString();
                AbstractC2796i.m5784e(str, "randomUUID().toString()");
            }
            this(str);
        }
    }

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final void appendQuotedString$okhttp(StringBuilder sb, String str) {
            AbstractC2796i.m5785f(sb, "<this>");
            AbstractC2796i.m5785f(str, CacheEntity.KEY);
            sb.append('\"');
            int length = str.length();
            for (int i6 = 0; i6 < length; i6++) {
                char cCharAt = str.charAt(i6);
                if (cCharAt == '\n') {
                    sb.append("%0A");
                } else if (cCharAt == '\r') {
                    sb.append("%0D");
                } else if (cCharAt == '\"') {
                    sb.append("%22");
                } else {
                    sb.append(cCharAt);
                }
            }
            sb.append('\"');
        }

        private Companion() {
        }
    }

    public static final class Part {
        public static final Companion Companion = new Companion(null);
        private final RequestBody body;
        private final Headers headers;

        public static final class Companion {
            public Companion(AbstractC2793f abstractC2793f) {
                this();
            }

            public final Part create(RequestBody requestBody) {
                AbstractC2796i.m5785f(requestBody, TtmlNode.TAG_BODY);
                return create(null, requestBody);
            }

            public final Part createFormData(String str, String str2) {
                AbstractC2796i.m5785f(str, SerializableCookie.NAME);
                AbstractC2796i.m5785f(str2, "value");
                return createFormData(str, null, RequestBody.Companion.create$default(RequestBody.Companion, str2, (MediaType) null, 1, (Object) null));
            }

            private Companion() {
            }

            public final Part create(Headers headers, RequestBody requestBody) {
                AbstractC2796i.m5785f(requestBody, TtmlNode.TAG_BODY);
                AbstractC2793f abstractC2793f = null;
                if ((headers != null ? headers.get("Content-Type") : null) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if ((headers != null ? headers.get("Content-Length") : null) == null) {
                    return new Part(headers, requestBody, abstractC2793f);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }

            public final Part createFormData(String str, String str2, RequestBody requestBody) {
                AbstractC2796i.m5785f(str, SerializableCookie.NAME);
                AbstractC2796i.m5785f(requestBody, TtmlNode.TAG_BODY);
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                Companion companion = MultipartBody.Companion;
                companion.appendQuotedString$okhttp(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    companion.appendQuotedString$okhttp(sb, str2);
                }
                String string = sb.toString();
                AbstractC2796i.m5784e(string, "StringBuilder().apply(builderAction).toString()");
                return create(new Headers.Builder().addUnsafeNonAscii(HttpHeaders.HEAD_KEY_CONTENT_DISPOSITION, string).build(), requestBody);
            }
        }

        public Part(Headers headers, RequestBody requestBody, AbstractC2793f abstractC2793f) {
            this(headers, requestBody);
        }

        public static final Part create(Headers headers, RequestBody requestBody) {
            return Companion.create(headers, requestBody);
        }

        public static final Part createFormData(String str, String str2) {
            return Companion.createFormData(str, str2);
        }

        public final RequestBody m8504deprecated_body() {
            return this.body;
        }

        public final Headers m8505deprecated_headers() {
            return this.headers;
        }

        public final RequestBody body() {
            return this.body;
        }

        public final Headers headers() {
            return this.headers;
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public static final Part create(RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        public static final Part createFormData(String str, String str2, RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }
    }

    static {
        MediaType.Companion companion = MediaType.Companion;
        MIXED = companion.get("multipart/mixed");
        ALTERNATIVE = companion.get("multipart/alternative");
        DIGEST = companion.get("multipart/digest");
        PARALLEL = companion.get("multipart/parallel");
        FORM = companion.get("multipart/form-data");
        COLONSPACE = new byte[]{58, 32};
        CRLF = new byte[]{13, 10};
        DASHDASH = new byte[]{45, 45};
    }

    public MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        AbstractC2796i.m5785f(byteString, "boundaryByteString");
        AbstractC2796i.m5785f(mediaType, SessionDescription.ATTR_TYPE);
        AbstractC2796i.m5785f(list, "parts");
        this.boundaryByteString = byteString;
        this.type = mediaType;
        this.parts = list;
        this.contentType = MediaType.Companion.get(mediaType + "; boundary=" + boundary());
        this.contentLength = -1L;
    }

    private final long writeOrCountBytes(BufferedSink bufferedSink, boolean z7) throws IOException {
        Buffer buffer;
        if (z7) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.parts.size();
        long j10 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Part part = this.parts.get(i6);
            Headers headers = part.headers();
            RequestBody requestBodyBody = part.body();
            AbstractC2796i.m5782c(bufferedSink);
            bufferedSink.write(DASHDASH);
            bufferedSink.write(this.boundaryByteString);
            bufferedSink.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    bufferedSink.writeUtf8(headers.name(i10)).write(COLONSPACE).writeUtf8(headers.value(i10)).write(CRLF);
                }
            }
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(mediaTypeContentType.toString()).write(CRLF);
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(jContentLength).write(CRLF);
            } else if (z7) {
                AbstractC2796i.m5782c(buffer);
                buffer.clear();
                return -1L;
            }
            byte[] bArr = CRLF;
            bufferedSink.write(bArr);
            if (z7) {
                j10 += jContentLength;
            } else {
                requestBodyBody.writeTo(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        AbstractC2796i.m5782c(bufferedSink);
        byte[] bArr2 = DASHDASH;
        bufferedSink.write(bArr2);
        bufferedSink.write(this.boundaryByteString);
        bufferedSink.write(bArr2);
        bufferedSink.write(CRLF);
        if (!z7) {
            return j10;
        }
        AbstractC2796i.m5782c(buffer);
        long size3 = j10 + buffer.size();
        buffer.clear();
        return size3;
    }

    public final String m8500deprecated_boundary() {
        return boundary();
    }

    public final List<Part> m8501deprecated_parts() {
        return this.parts;
    }

    public final int m8502deprecated_size() {
        return size();
    }

    public final MediaType m8503deprecated_type() {
        return this.type;
    }

    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    @Override
    public long contentLength() throws IOException {
        long j10 = this.contentLength;
        if (j10 != -1) {
            return j10;
        }
        long jWriteOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = jWriteOrCountBytes;
        return jWriteOrCountBytes;
    }

    @Override
    public MediaType contentType() {
        return this.contentType;
    }

    public final Part part(int i6) {
        return this.parts.get(i6);
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    public final MediaType type() {
        return this.type;
    }

    @Override
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        AbstractC2796i.m5785f(bufferedSink, "sink");
        writeOrCountBytes(bufferedSink, false);
    }
}
