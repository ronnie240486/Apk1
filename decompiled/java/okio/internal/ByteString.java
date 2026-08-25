package okio.internal;

import java.util.Arrays;
import okio.Base64;
import okio.Buffer;
import okio.SegmentedByteString;
import okio._JvmPlatformKt;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3656n;
import p253x8.AbstractC4146i;

public final class ByteString {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int codePointIndexToCharIndex(byte[] bArr, int i6) {
        byte b8;
        int i10;
        int length = bArr.length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            byte b10 = bArr[i11];
            if (b10 >= 0) {
                int i14 = i13 + 1;
                if (i13 == i6) {
                    return i12;
                }
                if ((b10 != 10 && b10 != 13 && ((b10 >= 0 && b10 < 32) || (127 <= b10 && b10 < 160))) || b10 == 65533) {
                    return -1;
                }
                i12 += b10 < 65536 ? 1 : 2;
                i11++;
                while (true) {
                    i13 = i14;
                    if (i11 >= length || (b8 = bArr[i11]) < 0) {
                        break;
                    }
                    i11++;
                    i14 = i13 + 1;
                    if (i13 == i6) {
                        return i12;
                    }
                    if ((b8 != 10 && b8 != 13 && ((b8 >= 0 && b8 < 32) || (127 <= b8 && b8 < 160))) || b8 == 65533) {
                        return -1;
                    }
                    i12 += b8 < 65536 ? 1 : 2;
                }
            } else if ((b10 >> 5) == -2) {
                int i15 = i11 + 1;
                if (length <= i15) {
                    if (i13 == i6) {
                        return i12;
                    }
                    return -1;
                }
                byte b11 = bArr[i15];
                if ((b11 & 192) != 128) {
                    if (i13 == i6) {
                        return i12;
                    }
                    return -1;
                }
                int i16 = (b10 << 6) ^ (b11 ^ 3968);
                if (i16 < 128) {
                    if (i13 == i6) {
                        return i12;
                    }
                    return -1;
                }
                int i17 = i13 + 1;
                if (i13 == i6) {
                    return i12;
                }
                if ((i16 != 10 && i16 != 13 && ((i16 >= 0 && i16 < 32) || (127 <= i16 && i16 < 160))) || i16 == 65533) {
                    return -1;
                }
                i12 += i16 < 65536 ? 1 : 2;
                i11 += 2;
                i13 = i17;
            } else {
                if ((b10 >> 4) == -2) {
                    int i18 = i11 + 2;
                    if (length <= i18) {
                        if (i13 == i6) {
                            return i12;
                        }
                        return -1;
                    }
                    byte b12 = bArr[i11 + 1];
                    if ((b12 & 192) != 128) {
                        if (i13 == i6) {
                            return i12;
                        }
                        return -1;
                    }
                    byte b13 = bArr[i18];
                    if ((b13 & 192) != 128) {
                        if (i13 == i6) {
                            return i12;
                        }
                        return -1;
                    }
                    int i19 = (b10 << 12) ^ ((b13 ^ (-123008)) ^ (b12 << 6));
                    if (i19 < 2048) {
                        if (i13 == i6) {
                            return i12;
                        }
                        return -1;
                    }
                    if (55296 <= i19 && i19 < 57344) {
                        if (i13 == i6) {
                            return i12;
                        }
                        return -1;
                    }
                    i10 = i13 + 1;
                    if (i13 == i6) {
                        return i12;
                    }
                    if ((i19 != 10 && i19 != 13 && ((i19 >= 0 && i19 < 32) || (127 <= i19 && i19 < 160))) || i19 == 65533) {
                        return -1;
                    }
                    i12 += i19 < 65536 ? 1 : 2;
                    i11 += 3;
                } else {
                    if ((b10 >> 3) != -2) {
                        if (i13 == i6) {
                            return i12;
                        }
                        return -1;
                    }
                    int i20 = i11 + 3;
                    if (length <= i20) {
                        if (i13 == i6) {
                            return i12;
                        }
                        return -1;
                    }
                    byte b14 = bArr[i11 + 1];
                    if ((b14 & 192) != 128) {
                        if (i13 == i6) {
                            return i12;
                        }
                        return -1;
                    }
                    byte b15 = bArr[i11 + 2];
                    if ((b15 & 192) != 128) {
                        if (i13 == i6) {
                            return i12;
                        }
                        return -1;
                    }
                    byte b16 = bArr[i20];
                    if ((b16 & 192) != 128) {
                        if (i13 == i6) {
                            return i12;
                        }
                        return -1;
                    }
                    int i21 = (b10 << 18) ^ (((b16 ^ 3678080) ^ (b15 << 6)) ^ (b14 << 12));
                    if (i21 > 1114111) {
                        if (i13 == i6) {
                            return i12;
                        }
                        return -1;
                    }
                    if (55296 <= i21 && i21 < 57344) {
                        if (i13 == i6) {
                            return i12;
                        }
                        return -1;
                    }
                    if (i21 < 65536) {
                        if (i13 == i6) {
                            return i12;
                        }
                        return -1;
                    }
                    i10 = i13 + 1;
                    if (i13 == i6) {
                        return i12;
                    }
                    if ((i21 != 10 && i21 != 13 && ((i21 >= 0 && i21 < 32) || (127 <= i21 && i21 < 160))) || i21 == 65533) {
                        return -1;
                    }
                    i12 += i21 < 65536 ? 1 : 2;
                    i11 += 4;
                }
                i13 = i10;
            }
        }
        return i12;
    }

    public static final String commonBase64(okio.ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "<this>");
        return Base64.encodeBase64$default(byteString.getData$okio(), null, 1, null);
    }

    public static final String commonBase64Url(okio.ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "<this>");
        return Base64.encodeBase64(byteString.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(okio.ByteString byteString, okio.ByteString byteString2) {
        AbstractC2796i.m5785f(byteString, "<this>");
        AbstractC2796i.m5785f(byteString2, "other");
        int size = byteString.size();
        int size2 = byteString2.size();
        int iMin = Math.min(size, size2);
        for (int i6 = 0; i6 < iMin; i6++) {
            int i10 = byteString.getByte(i6) & 255;
            int i11 = byteString2.getByte(i6) & 255;
            if (i10 != i11) {
                return i10 < i11 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public static final void commonCopyInto(okio.ByteString byteString, int i6, byte[] bArr, int i10, int i11) {
        AbstractC2796i.m5785f(byteString, "<this>");
        AbstractC2796i.m5785f(bArr, "target");
        AbstractC4146i.m8172E(byteString.getData$okio(), i10, i6, bArr, i11 + i6);
    }

    public static final okio.ByteString commonDecodeBase64(String str) {
        AbstractC2796i.m5785f(str, "<this>");
        byte[] bArrDecodeBase64ToArray = Base64.decodeBase64ToArray(str);
        if (bArrDecodeBase64ToArray != null) {
            return new okio.ByteString(bArrDecodeBase64ToArray);
        }
        return null;
    }

    public static final okio.ByteString commonDecodeHex(String str) {
        AbstractC2796i.m5785f(str, "<this>");
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            int i10 = i6 * 2;
            bArr[i6] = (byte) (decodeHexDigit(str.charAt(i10 + 1)) + (decodeHexDigit(str.charAt(i10)) << 4));
        }
        return new okio.ByteString(bArr);
    }

    public static final okio.ByteString commonEncodeUtf8(String str) {
        AbstractC2796i.m5785f(str, "<this>");
        okio.ByteString byteString = new okio.ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(okio.ByteString byteString, okio.ByteString byteString2) {
        AbstractC2796i.m5785f(byteString, "<this>");
        AbstractC2796i.m5785f(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEquals(okio.ByteString byteString, Object obj) {
        AbstractC2796i.m5785f(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof okio.ByteString) {
            okio.ByteString byteString2 = (okio.ByteString) obj;
            if (byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(okio.ByteString byteString, int i6) {
        AbstractC2796i.m5785f(byteString, "<this>");
        return byteString.getData$okio()[i6];
    }

    public static final int commonGetSize(okio.ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "<this>");
        return byteString.getData$okio().length;
    }

    public static final int commonHashCode(okio.ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "<this>");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int iHashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(iHashCode);
        return iHashCode;
    }

    public static final String commonHex(okio.ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "<this>");
        char[] cArr = new char[byteString.getData$okio().length * 2];
        int i6 = 0;
        for (byte b8 : byteString.getData$okio()) {
            int i10 = i6 + 1;
            cArr[i6] = getHEX_DIGIT_CHARS()[(b8 >> 4) & 15];
            i6 += 2;
            cArr[i10] = getHEX_DIGIT_CHARS()[b8 & 15];
        }
        return new String(cArr);
    }

    public static final int commonIndexOf(okio.ByteString byteString, byte[] bArr, int i6) {
        AbstractC2796i.m5785f(byteString, "<this>");
        AbstractC2796i.m5785f(bArr, "other");
        int length = byteString.getData$okio().length - bArr.length;
        int iMax = Math.max(i6, 0);
        if (iMax > length) {
            return -1;
        }
        while (!SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), iMax, bArr, 0, bArr.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public static final byte[] commonInternalArray(okio.ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "<this>");
        return byteString.getData$okio();
    }

    public static final int commonLastIndexOf(okio.ByteString byteString, okio.ByteString byteString2, int i6) {
        AbstractC2796i.m5785f(byteString, "<this>");
        AbstractC2796i.m5785f(byteString2, "other");
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i6);
    }

    public static final okio.ByteString commonOf(byte[] bArr) {
        AbstractC2796i.m5785f(bArr, "data");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        AbstractC2796i.m5784e(bArrCopyOf, "copyOf(...)");
        return new okio.ByteString(bArrCopyOf);
    }

    public static final boolean commonRangeEquals(okio.ByteString byteString, int i6, okio.ByteString byteString2, int i10, int i11) {
        AbstractC2796i.m5785f(byteString, "<this>");
        AbstractC2796i.m5785f(byteString2, "other");
        return byteString2.rangeEquals(i10, byteString.getData$okio(), i6, i11);
    }

    public static final boolean commonStartsWith(okio.ByteString byteString, okio.ByteString byteString2) {
        AbstractC2796i.m5785f(byteString, "<this>");
        AbstractC2796i.m5785f(byteString2, "prefix");
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    public static final okio.ByteString commonSubstring(okio.ByteString byteString, int i6, int i10) {
        AbstractC2796i.m5785f(byteString, "<this>");
        int iResolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(byteString, i10);
        if (i6 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (iResolveDefaultParameter <= byteString.getData$okio().length) {
            if (iResolveDefaultParameter - i6 >= 0) {
                return (i6 == 0 && iResolveDefaultParameter == byteString.getData$okio().length) ? byteString : new okio.ByteString(AbstractC4146i.m8174G(byteString.getData$okio(), i6, iResolveDefaultParameter));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
    }

    public static final okio.ByteString commonToAsciiLowercase(okio.ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "<this>");
        for (int i6 = 0; i6 < byteString.getData$okio().length; i6++) {
            byte b8 = byteString.getData$okio()[i6];
            if (b8 >= 65 && b8 <= 90) {
                byte[] data$okio = byteString.getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                AbstractC2796i.m5784e(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i6] = (byte) (b8 + 32);
                for (int i10 = i6 + 1; i10 < bArrCopyOf.length; i10++) {
                    byte b10 = bArrCopyOf[i10];
                    if (b10 >= 65 && b10 <= 90) {
                        bArrCopyOf[i10] = (byte) (b10 + 32);
                    }
                }
                return new okio.ByteString(bArrCopyOf);
            }
        }
        return byteString;
    }

    public static final okio.ByteString commonToAsciiUppercase(okio.ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "<this>");
        for (int i6 = 0; i6 < byteString.getData$okio().length; i6++) {
            byte b8 = byteString.getData$okio()[i6];
            if (b8 >= 97 && b8 <= 122) {
                byte[] data$okio = byteString.getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                AbstractC2796i.m5784e(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i6] = (byte) (b8 - 32);
                for (int i10 = i6 + 1; i10 < bArrCopyOf.length; i10++) {
                    byte b10 = bArrCopyOf[i10];
                    if (b10 >= 97 && b10 <= 122) {
                        bArrCopyOf[i10] = (byte) (b10 - 32);
                    }
                }
                return new okio.ByteString(bArrCopyOf);
            }
        }
        return byteString;
    }

    public static final byte[] commonToByteArray(okio.ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "<this>");
        byte[] data$okio = byteString.getData$okio();
        byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
        AbstractC2796i.m5784e(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public static final okio.ByteString commonToByteString(byte[] bArr, int i6, int i10) {
        AbstractC2796i.m5785f(bArr, "<this>");
        int iResolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(bArr, i10);
        SegmentedByteString.checkOffsetAndCount(bArr.length, i6, iResolveDefaultParameter);
        return new okio.ByteString(AbstractC4146i.m8174G(bArr, i6, iResolveDefaultParameter + i6));
    }

    public static final String commonToString(okio.ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "<this>");
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int iCodePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (iCodePointIndexToCharIndex != -1) {
            String strUtf8 = byteString.utf8();
            String strSubstring = strUtf8.substring(0, iCodePointIndexToCharIndex);
            AbstractC2796i.m5784e(strSubstring, "substring(...)");
            String strM7402T = AbstractC3656n.m7402T(AbstractC3656n.m7402T(AbstractC3656n.m7402T(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (iCodePointIndexToCharIndex >= strUtf8.length()) {
                return "[text=" + strM7402T + ']';
            }
            return "[size=" + byteString.getData$okio().length + " text=" + strM7402T + "…]";
        }
        if (byteString.getData$okio().length <= 64) {
            return "[hex=" + byteString.hex() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(byteString.getData$okio().length);
        sb.append(" hex=");
        int iResolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(byteString, 64);
        if (iResolveDefaultParameter > byteString.getData$okio().length) {
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        }
        if (iResolveDefaultParameter < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (iResolveDefaultParameter != byteString.getData$okio().length) {
            byteString = new okio.ByteString(AbstractC4146i.m8174G(byteString.getData$okio(), 0, iResolveDefaultParameter));
        }
        sb.append(byteString.hex());
        sb.append("…]");
        return sb.toString();
    }

    public static final String commonUtf8(okio.ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "<this>");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(okio.ByteString byteString, Buffer buffer, int i6, int i10) {
        AbstractC2796i.m5785f(byteString, "<this>");
        AbstractC2796i.m5785f(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i6, i10);
    }

    public static final int decodeHexDigit(char c5) {
        if ('0' <= c5 && c5 < ':') {
            return c5 - '0';
        }
        if ('a' <= c5 && c5 < 'g') {
            return c5 - 'W';
        }
        if ('A' <= c5 && c5 < 'G') {
            return c5 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c5);
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final boolean commonEndsWith(okio.ByteString byteString, byte[] bArr) {
        AbstractC2796i.m5785f(byteString, "<this>");
        AbstractC2796i.m5785f(bArr, "suffix");
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final int commonLastIndexOf(okio.ByteString byteString, byte[] bArr, int i6) {
        AbstractC2796i.m5785f(byteString, "<this>");
        AbstractC2796i.m5785f(bArr, "other");
        for (int iMin = Math.min(SegmentedByteString.resolveDefaultParameter(byteString, i6), byteString.getData$okio().length - bArr.length); -1 < iMin; iMin--) {
            if (SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(okio.ByteString byteString, int i6, byte[] bArr, int i10, int i11) {
        AbstractC2796i.m5785f(byteString, "<this>");
        AbstractC2796i.m5785f(bArr, "other");
        return i6 >= 0 && i6 <= byteString.getData$okio().length - i11 && i10 >= 0 && i10 <= bArr.length - i11 && SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), i6, bArr, i10, i11);
    }

    public static final boolean commonStartsWith(okio.ByteString byteString, byte[] bArr) {
        AbstractC2796i.m5785f(byteString, "<this>");
        AbstractC2796i.m5785f(bArr, "prefix");
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }

    public static void getHEX_DIGIT_CHARS$annotations() {
    }
}
