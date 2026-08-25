package okhttp3.internal.http;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import p103j9.AbstractC2796i;

public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final BufferedSource source;

    public RealResponseBody(String str, long j10, BufferedSource bufferedSource) {
        AbstractC2796i.m5785f(bufferedSource, "source");
        this.contentTypeString = str;
        this.contentLength = j10;
        this.source = bufferedSource;
    }

    @Override
    public long contentLength() {
        return this.contentLength;
    }

    @Override
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }

    @Override
    public BufferedSource source() {
        return this.source;
    }
}
