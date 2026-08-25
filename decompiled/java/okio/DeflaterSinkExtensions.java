package okio;

import java.util.zip.Deflater;
import p103j9.AbstractC2796i;

public final class DeflaterSinkExtensions {
    public static final DeflaterSink deflate(Sink sink, Deflater deflater) {
        AbstractC2796i.m5785f(sink, "<this>");
        AbstractC2796i.m5785f(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }

    public static DeflaterSink deflate$default(Sink sink, Deflater deflater, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            deflater = new Deflater();
        }
        AbstractC2796i.m5785f(sink, "<this>");
        AbstractC2796i.m5785f(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }
}
