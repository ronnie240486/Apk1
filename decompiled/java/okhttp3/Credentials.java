package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import okio.ByteString;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2796i;

public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    public static final String basic(String str, String str2) {
        AbstractC2796i.m5785f(str, "username");
        AbstractC2796i.m5785f(str2, "password");
        return basic$default(str, str2, null, 4, null);
    }

    public static String basic$default(String str, String str2, Charset charset, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            charset = StandardCharsets.ISO_8859_1;
            AbstractC2796i.m5784e(charset, "ISO_8859_1");
        }
        return basic(str, str2, charset);
    }

    public static final String basic(String str, String str2, Charset charset) {
        AbstractC2796i.m5785f(str, "username");
        AbstractC2796i.m5785f(str2, "password");
        AbstractC2796i.m5785f(charset, "charset");
        return AbstractC2460q.m5501o("Basic ", ByteString.Companion.encodeString(str + ':' + str2, charset).base64());
    }
}
