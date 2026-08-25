package okio;

import p103j9.AbstractC2796i;

public final class DeprecatedUtf8 {
    public static final DeprecatedUtf8 INSTANCE = new DeprecatedUtf8();

    private DeprecatedUtf8() {
    }

    public final long size(String str) {
        AbstractC2796i.m5785f(str, "string");
        return Utf8.size$default(str, 0, 0, 3, null);
    }

    public final long size(String str, int i6, int i10) {
        AbstractC2796i.m5785f(str, "string");
        return Utf8.size(str, i6, i10);
    }
}
