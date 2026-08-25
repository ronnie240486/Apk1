package okhttp3.internal.p159ws;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.internal.Util;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3648f;
import p192r9.AbstractC3655m;
import p192r9.AbstractC3656n;

public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final WebSocketExtensions parse(Headers headers) throws IOException {
            String strTrimSubstring;
            AbstractC2796i.m5785f(headers, "responseHeaders");
            int size = headers.size();
            boolean z7 = false;
            Integer numM7394L = null;
            boolean z10 = false;
            Integer numM7394L2 = null;
            boolean z11 = false;
            boolean z12 = false;
            for (int i6 = 0; i6 < size; i6++) {
                if (AbstractC3656n.m7398P(headers.name(i6), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION)) {
                    String strValue = headers.value(i6);
                    int i10 = 0;
                    while (i10 < strValue.length()) {
                        int i11 = i10;
                        int iDelimiterOffset$default = Util.delimiterOffset$default(strValue, ',', i10, 0, 4, (Object) null);
                        char c5 = ';';
                        int iDelimiterOffset = Util.delimiterOffset(strValue, ';', i11, iDelimiterOffset$default);
                        String strTrimSubstring2 = Util.trimSubstring(strValue, i11, iDelimiterOffset);
                        int i12 = iDelimiterOffset + 1;
                        if (AbstractC3656n.m7398P(strTrimSubstring2, "permessage-deflate")) {
                            if (z7) {
                                z12 = true;
                            }
                            i10 = i12;
                            while (i10 < iDelimiterOffset$default) {
                                int iDelimiterOffset2 = Util.delimiterOffset(strValue, c5, i10, iDelimiterOffset$default);
                                int iDelimiterOffset3 = Util.delimiterOffset(strValue, '=', i10, iDelimiterOffset2);
                                String strTrimSubstring3 = Util.trimSubstring(strValue, i10, iDelimiterOffset3);
                                if (iDelimiterOffset3 < iDelimiterOffset2) {
                                    strTrimSubstring = Util.trimSubstring(strValue, iDelimiterOffset3 + 1, iDelimiterOffset2);
                                    AbstractC2796i.m5785f(strTrimSubstring, "<this>");
                                    if (strTrimSubstring.length() >= 2 && AbstractC3648f.m7387i0(strTrimSubstring, "\"") && AbstractC3656n.m7397O(strTrimSubstring, "\"", false)) {
                                        strTrimSubstring = strTrimSubstring.substring(1, strTrimSubstring.length() - 1);
                                        AbstractC2796i.m5784e(strTrimSubstring, "substring(...)");
                                    }
                                } else {
                                    strTrimSubstring = null;
                                }
                                i10 = iDelimiterOffset2 + 1;
                                if (AbstractC3656n.m7398P(strTrimSubstring3, "client_max_window_bits")) {
                                    if (numM7394L != null) {
                                        z12 = true;
                                    }
                                    numM7394L = strTrimSubstring != null ? AbstractC3655m.m7394L(strTrimSubstring) : null;
                                    if (numM7394L == null) {
                                        z12 = true;
                                    }
                                } else if (AbstractC3656n.m7398P(strTrimSubstring3, "client_no_context_takeover")) {
                                    if (z10) {
                                        z12 = true;
                                    }
                                    if (strTrimSubstring != null) {
                                        z12 = true;
                                    }
                                    z10 = true;
                                } else {
                                    if (AbstractC3656n.m7398P(strTrimSubstring3, "server_max_window_bits")) {
                                        if (numM7394L2 != null) {
                                            z12 = true;
                                        }
                                        numM7394L2 = strTrimSubstring != null ? AbstractC3655m.m7394L(strTrimSubstring) : null;
                                        if (numM7394L2 == null) {
                                        }
                                    } else if (AbstractC3656n.m7398P(strTrimSubstring3, "server_no_context_takeover")) {
                                        if (z11) {
                                            z12 = true;
                                        }
                                        if (strTrimSubstring != null) {
                                            z12 = true;
                                        }
                                        z11 = true;
                                    }
                                    z12 = true;
                                }
                                c5 = ';';
                            }
                            z7 = true;
                        } else {
                            i10 = i12;
                            z12 = true;
                        }
                    }
                }
            }
            return new WebSocketExtensions(z7, numM7394L, z10, numM7394L2, z11, z12);
        }

        private Companion() {
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public static WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z7, Integer num, boolean z10, Integer num2, boolean z11, boolean z12, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z7 = webSocketExtensions.perMessageDeflate;
        }
        if ((i6 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i6 & 4) != 0) {
            z10 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z13 = z10;
        if ((i6 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i6 & 16) != 0) {
            z11 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z14 = z11;
        if ((i6 & 32) != 0) {
            z12 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z7, num3, z13, num4, z14, z12);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z7, Integer num, boolean z10, Integer num2, boolean z11, boolean z12) {
        return new WebSocketExtensions(z7, num, z10, num2, z11, z12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && AbstractC2796i.m5780a(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && AbstractC2796i.m5780a(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    public int hashCode() {
        boolean z7 = this.perMessageDeflate;
        ?? r10 = z7;
        if (z7) {
            r10 = 1;
        }
        int i6 = r10 * 31;
        Integer num = this.clientMaxWindowBits;
        int iHashCode = (i6 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z10 = this.clientNoContextTakeover;
        ?? r11 = z10;
        if (z10) {
            r11 = 1;
        }
        int i10 = (iHashCode + r11) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int iHashCode2 = (i10 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z11 = this.serverNoContextTakeover;
        ?? r12 = z11;
        if (z11) {
            r12 = 1;
        }
        int i11 = (iHashCode2 + r12) * 31;
        boolean z12 = this.unknownValues;
        return i11 + (z12 ? 1 : z12);
    }

    public final boolean noContextTakeover(boolean z7) {
        return z7 ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    public WebSocketExtensions(boolean z7, Integer num, boolean z10, Integer num2, boolean z11, boolean z12) {
        this.perMessageDeflate = z7;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z10;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z11;
        this.unknownValues = z12;
    }

    public WebSocketExtensions(boolean z7, Integer num, boolean z10, Integer num2, boolean z11, boolean z12, int i6, AbstractC2793f abstractC2793f) {
        this((i6 & 1) != 0 ? false : z7, (i6 & 2) != 0 ? null : num, (i6 & 4) != 0 ? false : z10, (i6 & 8) == 0 ? num2 : null, (i6 & 16) != 0 ? false : z11, (i6 & 32) != 0 ? false : z12);
    }
}
