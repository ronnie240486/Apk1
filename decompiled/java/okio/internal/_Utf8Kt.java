package okio.internal;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.extractor.p010ts.PsExtractor;
import java.util.Arrays;
import okio.Utf8;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3656n;

public final class _Utf8Kt {
    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i6;
        char cCharAt;
        AbstractC2796i.m5785f(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            char cCharAt2 = str.charAt(i10);
            if (AbstractC2796i.m5787h(cCharAt2, 128) >= 0) {
                int length2 = str.length();
                int i11 = i10;
                while (i10 < length2) {
                    char cCharAt3 = str.charAt(i10);
                    if (AbstractC2796i.m5787h(cCharAt3, 128) < 0) {
                        int i12 = i11 + 1;
                        bArr[i11] = (byte) cCharAt3;
                        i10++;
                        while (true) {
                            i11 = i12;
                            if (i10 >= length2 || AbstractC2796i.m5787h(str.charAt(i10), 128) >= 0) {
                                break;
                            }
                            i12 = i11 + 1;
                            bArr[i11] = (byte) str.charAt(i10);
                            i10++;
                        }
                    } else {
                        if (AbstractC2796i.m5787h(cCharAt3, 2048) < 0) {
                            bArr[i11] = (byte) ((cCharAt3 >> 6) | 192);
                            i11 += 2;
                            bArr[i11 + 1] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (55296 > cCharAt3 || cCharAt3 >= 57344) {
                            bArr[i11] = (byte) ((cCharAt3 >> '\f') | 224);
                            bArr[i11 + 1] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            i11 += 3;
                            bArr[i11 + 2] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (AbstractC2796i.m5787h(cCharAt3, 56319) > 0 || length2 <= (i6 = i10 + 1) || 56320 > (cCharAt = str.charAt(i6)) || cCharAt >= 57344) {
                            bArr[i11] = Utf8.REPLACEMENT_BYTE;
                            i10++;
                            i11++;
                        } else {
                            int iCharAt = (str.charAt(i6) + (cCharAt3 << '\n')) - 56613888;
                            bArr[i11] = (byte) ((iCharAt >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                            bArr[i11 + 1] = (byte) (((iCharAt >> 12) & 63) | 128);
                            bArr[i11 + 2] = (byte) (((iCharAt >> 6) & 63) | 128);
                            i11 += 4;
                            bArr[i11 + 3] = (byte) ((iCharAt & 63) | 128);
                            i10 += 2;
                        }
                        i10++;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i11);
                AbstractC2796i.m5784e(bArrCopyOf, "copyOf(...)");
                return bArrCopyOf;
            }
            bArr[i10] = (byte) cCharAt2;
            i10++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, str.length());
        AbstractC2796i.m5784e(bArrCopyOf2, "copyOf(...)");
        return bArrCopyOf2;
    }

    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String commonToUtf8String(byte[] bArr, int i6, int i10) {
        byte b8;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = i6;
        AbstractC2796i.m5785f(bArr, "<this>");
        if (i16 < 0 || i10 > bArr.length || i16 > i10) {
            throw new ArrayIndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i16 + " endIndex=" + i10);
        }
        char[] cArr = new char[i10 - i16];
        int i17 = 0;
        while (i16 < i10) {
            byte b10 = bArr[i16];
            if (b10 >= 0) {
                int i18 = i17 + 1;
                cArr[i17] = (char) b10;
                i16++;
                while (true) {
                    i17 = i18;
                    if (i16 >= i10 || (b8 = bArr[i16]) < 0) {
                        break;
                    }
                    i16++;
                    i18 = i17 + 1;
                    cArr[i17] = (char) b8;
                }
            } else if ((b10 >> 5) == -2) {
                int i19 = i16 + 1;
                if (i10 <= i19) {
                    i11 = i17 + 1;
                    cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                } else {
                    byte b11 = bArr[i19];
                    if ((b11 & 192) == 128) {
                        int i20 = (b10 << 6) ^ (b11 ^ 3968);
                        if (i20 < 128) {
                            i11 = i17 + 1;
                            cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        } else {
                            i11 = i17 + 1;
                            cArr[i17] = (char) i20;
                        }
                        i17 = i11;
                        i12 = 2;
                        i16 += i12;
                    } else {
                        i11 = i17 + 1;
                        cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                i17 = i11;
                i12 = 1;
                i16 += i12;
            } else {
                if ((b10 >> 4) == -2) {
                    int i21 = i16 + 2;
                    if (i10 <= i21) {
                        i11 = i17 + 1;
                        cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        int i22 = i16 + 1;
                        if (i10 > i22) {
                        }
                        i17 = i11;
                        i12 = 1;
                    } else {
                        byte b12 = bArr[i16 + 1];
                        if ((b12 & 192) == 128) {
                            byte b13 = bArr[i21];
                            if ((b13 & 192) == 128) {
                                int i23 = (b10 << 12) ^ ((b13 ^ (-123008)) ^ (b12 << 6));
                                if (i23 < 2048) {
                                    i13 = i17 + 1;
                                    cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                } else if (55296 > i23 || i23 >= 57344) {
                                    i13 = i17 + 1;
                                    cArr[i17] = (char) i23;
                                } else {
                                    i13 = i17 + 1;
                                    cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                }
                                i17 = i13;
                            } else {
                                i11 = i17 + 1;
                                cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                i17 = i11;
                                i12 = 2;
                            }
                        } else {
                            i11 = i17 + 1;
                            cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            i17 = i11;
                            i12 = 1;
                        }
                    }
                    i16 += i12;
                } else if ((b10 >> 3) == -2) {
                    int i24 = i16 + 3;
                    if (i10 <= i24) {
                        i14 = i17 + 1;
                        cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                        int i25 = i16 + 1;
                        if (i10 > i25 && (bArr[i25] & 192) == 128) {
                            int i26 = i16 + 2;
                            if (i10 > i26) {
                            }
                            i17 = i14;
                            i12 = 2;
                        }
                        i17 = i14;
                        i12 = 1;
                    } else {
                        byte b14 = bArr[i16 + 1];
                        if ((b14 & 192) == 128) {
                            byte b15 = bArr[i16 + 2];
                            if ((b15 & 192) == 128) {
                                byte b16 = bArr[i24];
                                if ((b16 & 192) == 128) {
                                    int i27 = (b10 << 18) ^ (((b16 ^ 3678080) ^ (b15 << 6)) ^ (b14 << 12));
                                    if (i27 > 1114111) {
                                        i15 = i17 + 1;
                                        cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                                    } else if ((55296 > i27 || i27 >= 57344) && i27 >= 65536 && i27 != 65533) {
                                        cArr[i17] = (char) ((i27 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                        cArr[i17 + 1] = (char) ((i27 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) + Utf8.LOG_SURROGATE_HEADER);
                                        i15 = i17 + 2;
                                    } else {
                                        i15 = i17 + 1;
                                        cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                                    }
                                    i12 = 4;
                                    i17 = i15;
                                } else {
                                    i14 = i17 + 1;
                                    cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                                    i17 = i14;
                                }
                            } else {
                                i14 = i17 + 1;
                                cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                                i17 = i14;
                                i12 = 2;
                            }
                        } else {
                            i14 = i17 + 1;
                            cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                            i17 = i14;
                            i12 = 1;
                        }
                    }
                    i16 += i12;
                } else {
                    cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                    i16++;
                    i17++;
                }
                i12 = 3;
                i16 += i12;
            }
        }
        return AbstractC3656n.m7396N(cArr, 0, i17);
    }

    public static String commonToUtf8String$default(byte[] bArr, int i6, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i6 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = bArr.length;
        }
        return commonToUtf8String(bArr, i6, i10);
    }
}
