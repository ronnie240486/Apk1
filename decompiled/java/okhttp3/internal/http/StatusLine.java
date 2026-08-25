package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;
import okhttp3.Response;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3656n;

public final class StatusLine {
    public static final Companion Companion = new Companion(null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final StatusLine get(Response response) {
            AbstractC2796i.m5785f(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String str) throws IOException {
            Protocol protocol;
            int i6;
            String strSubstring;
            AbstractC2796i.m5785f(str, "statusLine");
            if (AbstractC3656n.m7404V(str, "HTTP/1.", false)) {
                i6 = 9;
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                int iCharAt = str.charAt(7) - '0';
                if (iCharAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: ".concat(str));
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                if (!AbstractC3656n.m7404V(str, "ICY ", false)) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                protocol = Protocol.HTTP_1_0;
                i6 = 4;
            }
            int i10 = i6 + 3;
            if (str.length() < i10) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            try {
                String strSubstring2 = str.substring(i6, i10);
                AbstractC2796i.m5784e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                int i11 = Integer.parseInt(strSubstring2);
                if (str.length() <= i10) {
                    strSubstring = "";
                } else {
                    if (str.charAt(i10) != ' ') {
                        throw new ProtocolException("Unexpected status line: ".concat(str));
                    }
                    strSubstring = str.substring(i6 + 4);
                    AbstractC2796i.m5784e(strSubstring, "this as java.lang.String).substring(startIndex)");
                }
                return new StatusLine(protocol, i11, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
        }

        private Companion() {
        }
    }

    public StatusLine(Protocol protocol, int i6, String str) {
        AbstractC2796i.m5785f(protocol, "protocol");
        AbstractC2796i.m5785f(str, "message");
        this.protocol = protocol;
        this.code = i6;
        this.message = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.code);
        sb.append(' ');
        sb.append(this.message);
        String string = sb.toString();
        AbstractC2796i.m5784e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
