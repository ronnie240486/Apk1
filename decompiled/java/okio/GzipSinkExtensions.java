package okio;

import p103j9.AbstractC2796i;

public final class GzipSinkExtensions {
    public static final GzipSink gzip(Sink sink) {
        AbstractC2796i.m5785f(sink, "<this>");
        return new GzipSink(sink);
    }
}
