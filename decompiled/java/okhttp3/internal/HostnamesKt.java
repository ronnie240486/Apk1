package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import okio.Buffer;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3648f;
import p192r9.AbstractC3656n;

public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt = str.charAt(i6);
            if (AbstractC2796i.m5787h(cCharAt, 31) <= 0 || AbstractC2796i.m5787h(cCharAt, 127) >= 0 || AbstractC3648f.m7380b0(" #%/:?@[\\]", cCharAt, 0, false, 6) != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i6, int i10, byte[] bArr, int i11) {
        int i12 = i11;
        while (i6 < i10) {
            if (i12 == bArr.length) {
                return false;
            }
            if (i12 != i11) {
                if (str.charAt(i6) != '.') {
                    return false;
                }
                i6++;
            }
            int i13 = i6;
            int i14 = 0;
            while (i13 < i10) {
                char cCharAt = str.charAt(i13);
                if (AbstractC2796i.m5787h(cCharAt, 48) < 0 || AbstractC2796i.m5787h(cCharAt, 57) > 0) {
                    break;
                }
                if ((i14 == 0 && i6 != i13) || (i14 = ((i14 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i13++;
            }
            if (i13 - i6 == 0) {
                return false;
            }
            bArr[i12] = (byte) i14;
            i12++;
            i6 = i13;
        }
        return i12 == i11 + 4;
    }

    private static final InetAddress decodeIpv6(String str, int i6, int i10) {
        int i11;
        int i12;
        int hexDigit;
        byte[] bArr = new byte[16];
        int i13 = 0;
        int i14 = -1;
        int i15 = -1;
        while (i6 < i10) {
            if (i13 == 16) {
                return null;
            }
            int i16 = i6 + 2;
            if (i16 <= i10 && AbstractC3656n.m7403U(str, i6, "::", false)) {
                if (i14 != -1) {
                    return null;
                }
                i13 += 2;
                i14 = i13;
                if (i16 == i10) {
                    break;
                }
                i15 = i16;
                i6 = i15;
                i11 = 0;
                while (i6 < i10) {
                    hexDigit = Util.parseHexDigit(str.charAt(i6));
                    if (hexDigit != -1) {
                        break;
                        break;
                    }
                    i11 = (i11 << 4) + hexDigit;
                    i6++;
                }
                i12 = i6 - i15;
                if (i12 != 0) {
                }
                return null;
            }
            if (i13 != 0) {
                if (!AbstractC3656n.m7403U(str, i6, ":", false)) {
                    if (!AbstractC3656n.m7403U(str, i6, ".", false) || !decodeIpv4Suffix(str, i15, i10, bArr, i13 - 2)) {
                        return null;
                    }
                    i13 += 2;
                    break;
                }
                i6++;
            }
            i15 = i6;
            i6 = i15;
            i11 = 0;
            while (i6 < i10) {
                hexDigit = Util.parseHexDigit(str.charAt(i6));
                if (hexDigit != -1) {
                    break;
                }
                i11 = (i11 << 4) + hexDigit;
                i6++;
            }
            i12 = i6 - i15;
            if (i12 != 0 || i12 > 4) {
                return null;
            }
            int i17 = i13 + 1;
            bArr[i13] = (byte) ((i11 >>> 8) & 255);
            i13 += 2;
            bArr[i17] = (byte) (i11 & 255);
        }
        if (i13 != 16) {
            if (i14 == -1) {
                return null;
            }
            int i18 = i13 - i14;
            System.arraycopy(bArr, i14, bArr, 16 - i18, i18);
            Arrays.fill(bArr, i14, (16 - i13) + i14, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i6 = -1;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i11 < bArr.length) {
            int i13 = i11;
            while (i13 < 16 && bArr[i13] == 0 && bArr[i13 + 1] == 0) {
                i13 += 2;
            }
            int i14 = i13 - i11;
            if (i14 > i12 && i14 >= 4) {
                i6 = i11;
                i12 = i14;
            }
            i11 = i13 + 2;
        }
        Buffer buffer = new Buffer();
        while (i10 < bArr.length) {
            if (i10 == i6) {
                buffer.writeByte(58);
                i10 += i12;
                if (i10 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i10 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((Util.and(bArr[i10], 255) << 8) | Util.and(bArr[i10 + 1], 255));
                i10 += 2;
            }
        }
        return buffer.readUtf8();
    }

    public static final String toCanonicalHost(String str) {
        AbstractC2796i.m5785f(str, "<this>");
        if (!AbstractC3648f.m7376X(str, ":")) {
            try {
                String ascii = IDN.toASCII(str);
                AbstractC2796i.m5784e(ascii, "toASCII(host)");
                Locale locale = Locale.US;
                AbstractC2796i.m5784e(locale, "US");
                String lowerCase = ascii.toLowerCase(locale);
                AbstractC2796i.m5784e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0 || containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressDecodeIpv6 = (AbstractC3656n.m7404V(str, "[", false) && AbstractC3656n.m7397O(str, "]", false)) ? decodeIpv6(str, 1, str.length() - 1) : decodeIpv6(str, 0, str.length());
        if (inetAddressDecodeIpv6 == null) {
            return null;
        }
        byte[] address = inetAddressDecodeIpv6.getAddress();
        if (address.length == 16) {
            return inet6AddressToAscii(address);
        }
        if (address.length == 4) {
            return inetAddressDecodeIpv6.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
    }
}
