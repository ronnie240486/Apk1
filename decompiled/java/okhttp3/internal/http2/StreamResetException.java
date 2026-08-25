package okhttp3.internal.http2;

import java.io.IOException;
import p103j9.AbstractC2796i;

public final class StreamResetException extends IOException {
    public final ErrorCode errorCode;

    public StreamResetException(ErrorCode errorCode) {
        super("stream was reset: " + errorCode);
        AbstractC2796i.m5785f(errorCode, "errorCode");
        this.errorCode = errorCode;
    }
}
