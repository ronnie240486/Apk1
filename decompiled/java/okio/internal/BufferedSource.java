package okio.internal;

import java.io.IOException;
import okio.TypedOptions;
import p103j9.AbstractC2796i;

public final class BufferedSource {
    public static final <T> T commonSelect(okio.BufferedSource bufferedSource, TypedOptions<T> typedOptions) throws IOException {
        AbstractC2796i.m5785f(bufferedSource, "<this>");
        AbstractC2796i.m5785f(typedOptions, "options");
        int iSelect = bufferedSource.select(typedOptions.getOptions$okio());
        if (iSelect == -1) {
            return null;
        }
        return typedOptions.get(iSelect);
    }
}
