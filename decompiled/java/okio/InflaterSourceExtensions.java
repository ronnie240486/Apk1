package okio;

import java.util.zip.Inflater;
import p103j9.AbstractC2796i;

public final class InflaterSourceExtensions {
    public static final InflaterSource inflate(Source source, Inflater inflater) {
        AbstractC2796i.m5785f(source, "<this>");
        AbstractC2796i.m5785f(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }

    public static InflaterSource inflate$default(Source source, Inflater inflater, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            inflater = new Inflater();
        }
        AbstractC2796i.m5785f(source, "<this>");
        AbstractC2796i.m5785f(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }
}
