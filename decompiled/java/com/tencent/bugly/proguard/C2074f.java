package com.tencent.bugly.proguard;

public final class C2074f {

    private static final char[] f7606b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static final byte[] f7605a = new byte[0];

    public static String m4864a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i6 = 0; i6 < bArr.length; i6++) {
            byte b8 = bArr[i6];
            int i10 = i6 * 2;
            char[] cArr2 = f7606b;
            cArr[i10 + 1] = cArr2[b8 & 15];
            cArr[i10] = cArr2[((byte) (b8 >>> 4)) & 15];
        }
        return new String(cArr);
    }
}
