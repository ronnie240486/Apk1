package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;

public final class C2090n {

    private static final byte[] f7650a;

    private static final byte[] f7651b;

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i6 = 0; i6 < 256; i6++) {
            bArr2[i6] = bArr[i6 >>> 4];
            bArr3[i6] = bArr[i6 & 15];
        }
        f7650a = bArr2;
        f7651b = bArr3;
    }

    public static boolean m4940a(int i6, int i10) {
        return i6 == i10;
    }

    public static boolean m4941a(long j10, long j11) {
        return j10 == j11;
    }

    public static boolean m4943a(boolean z7, boolean z10) {
        return z7 == z10;
    }

    public static boolean m4942a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static byte[] m4944a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        byte[] bArr = new byte[iPosition];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, iPosition);
        return bArr;
    }
}
