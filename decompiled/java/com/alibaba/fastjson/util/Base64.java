package com.alibaba.fastjson.util;

import java.util.Arrays;

public class Base64 {

    public static final char[] f4400CA;

    public static final int[] f4401IA;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f4400CA = charArray;
        int[] iArr = new int[256];
        f4401IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i6 = 0; i6 < length; i6++) {
            f4401IA[f4400CA[i6]] = i6;
        }
        f4401IA[61] = 0;
    }

    public static byte[] decodeFast(char[] cArr, int i6, int i10) {
        int i11;
        int i12;
        int i13 = 0;
        if (i10 == 0) {
            return new byte[0];
        }
        int i14 = (i6 + i10) - 1;
        int i15 = i6;
        while (i15 < i14 && f4401IA[cArr[i15]] < 0) {
            i15++;
        }
        while (i14 > 0 && f4401IA[cArr[i14]] < 0) {
            i14--;
        }
        if (cArr[i14] == '=') {
            i11 = cArr[i14 + (-1)] == '=' ? 2 : 1;
        } else {
            i11 = 0;
        }
        int i16 = (i14 - i15) + 1;
        if (i10 > 76) {
            i12 = (cArr[76] == '\r' ? i16 / 78 : 0) << 1;
        } else {
            i12 = 0;
        }
        int i17 = (((i16 - i12) * 6) >> 3) - i11;
        byte[] bArr = new byte[i17];
        int i18 = (i17 / 3) * 3;
        int i19 = 0;
        loop2: while (true) {
            int i20 = 0;
            while (true) {
                if (i19 >= i18) {
                    break loop2;
                }
                int[] iArr = f4401IA;
                int i21 = i15 + 4;
                int i22 = iArr[cArr[i15 + 3]] | (iArr[cArr[i15 + 1]] << 12) | (iArr[cArr[i15]] << 18) | (iArr[cArr[i15 + 2]] << 6);
                bArr[i19] = (byte) (i22 >> 16);
                int i23 = i19 + 2;
                bArr[i19 + 1] = (byte) (i22 >> 8);
                i19 += 3;
                bArr[i23] = (byte) i22;
                if (i12 <= 0 || (i20 = i20 + 1) != 19) {
                    i15 = i21;
                }
            }
            i15 += 6;
        }
        if (i19 < i17) {
            int i24 = 0;
            while (i15 <= i14 - i11) {
                i13 |= f4401IA[cArr[i15]] << (18 - (i24 * 6));
                i24++;
                i15++;
            }
            int i25 = 16;
            while (i19 < i17) {
                bArr[i19] = (byte) (i13 >> i25);
                i25 -= 8;
                i19++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str, int i6, int i10) {
        int i11;
        int i12;
        if (i10 == 0) {
            return new byte[0];
        }
        int i13 = (i6 + i10) - 1;
        int i14 = i6;
        while (i14 < i13 && f4401IA[str.charAt(i14)] < 0) {
            i14++;
        }
        while (i13 > 0 && f4401IA[str.charAt(i13)] < 0) {
            i13--;
        }
        if (str.charAt(i13) == '=') {
            i11 = str.charAt(i13 + (-1)) == '=' ? 2 : 1;
        } else {
            i11 = 0;
        }
        int i15 = (i13 - i14) + 1;
        if (i10 > 76) {
            i12 = (str.charAt(76) == '\r' ? i15 / 78 : 0) << 1;
        } else {
            i12 = 0;
        }
        int i16 = (((i15 - i12) * 6) >> 3) - i11;
        byte[] bArr = new byte[i16];
        int i17 = (i16 / 3) * 3;
        int i18 = 0;
        int i19 = 0;
        while (i18 < i17) {
            int[] iArr = f4401IA;
            int i20 = i14 + 4;
            int i21 = iArr[str.charAt(i14 + 3)] | (iArr[str.charAt(i14 + 1)] << 12) | (iArr[str.charAt(i14)] << 18) | (iArr[str.charAt(i14 + 2)] << 6);
            bArr[i18] = (byte) (i21 >> 16);
            int i22 = i18 + 2;
            bArr[i18 + 1] = (byte) (i21 >> 8);
            i18 += 3;
            bArr[i22] = (byte) i21;
            if (i12 <= 0 || (i19 = i19 + 1) != 19) {
                i14 = i20;
            } else {
                i14 += 6;
                i19 = 0;
            }
        }
        if (i18 < i16) {
            int i23 = 0;
            int i24 = 0;
            while (i14 <= i13 - i11) {
                i23 |= f4401IA[str.charAt(i14)] << (18 - (i24 * 6));
                i24++;
                i14++;
            }
            int i25 = 16;
            while (i18 < i16) {
                bArr[i18] = (byte) (i23 >> i25);
                i25 -= 8;
                i18++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str) {
        int i6;
        int i10;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i11 = length - 1;
        int i12 = 0;
        while (i12 < i11 && f4401IA[str.charAt(i12) & 255] < 0) {
            i12++;
        }
        while (i11 > 0 && f4401IA[str.charAt(i11) & 255] < 0) {
            i11--;
        }
        if (str.charAt(i11) == '=') {
            i6 = str.charAt(i11 + (-1)) == '=' ? 2 : 1;
        } else {
            i6 = 0;
        }
        int i13 = (i11 - i12) + 1;
        if (length > 76) {
            i10 = (str.charAt(76) == '\r' ? i13 / 78 : 0) << 1;
        } else {
            i10 = 0;
        }
        int i14 = (((i13 - i10) * 6) >> 3) - i6;
        byte[] bArr = new byte[i14];
        int i15 = (i14 / 3) * 3;
        int i16 = 0;
        int i17 = 0;
        while (i16 < i15) {
            int[] iArr = f4401IA;
            int i18 = i12 + 4;
            int i19 = iArr[str.charAt(i12 + 3)] | (iArr[str.charAt(i12 + 1)] << 12) | (iArr[str.charAt(i12)] << 18) | (iArr[str.charAt(i12 + 2)] << 6);
            bArr[i16] = (byte) (i19 >> 16);
            int i20 = i16 + 2;
            bArr[i16 + 1] = (byte) (i19 >> 8);
            i16 += 3;
            bArr[i20] = (byte) i19;
            if (i10 <= 0 || (i17 = i17 + 1) != 19) {
                i12 = i18;
            } else {
                i12 += 6;
                i17 = 0;
            }
        }
        if (i16 < i14) {
            int i21 = 0;
            int i22 = 0;
            while (i12 <= i11 - i6) {
                i21 |= f4401IA[str.charAt(i12)] << (18 - (i22 * 6));
                i22++;
                i12++;
            }
            int i23 = 16;
            while (i16 < i14) {
                bArr[i16] = (byte) (i21 >> i23);
                i23 -= 8;
                i16++;
            }
        }
        return bArr;
    }
}
