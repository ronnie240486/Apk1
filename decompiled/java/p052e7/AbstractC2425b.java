package p052e7;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import p187r4.AbstractC3612b;

public abstract class AbstractC2425b {
    static {
        new C2424a();
    }

    public static byte[] m5480a(ArrayDeque arrayDeque, int i6) {
        if (arrayDeque.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) arrayDeque.remove();
        if (bArr.length == i6) {
            return bArr;
        }
        int length = i6 - bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i6);
        while (length > 0) {
            byte[] bArr2 = (byte[]) arrayDeque.remove();
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i6 - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static byte[] m5481b(InputStream inputStream) throws IOException {
        inputStream.getClass();
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int iMin = Math.min(8192, Math.max(128, Integer.highestOneBit(0) * 2));
        int i6 = 0;
        while (i6 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i6);
            byte[] bArr = new byte[iMin2];
            arrayDeque.add(bArr);
            int i10 = 0;
            while (i10 < iMin2) {
                int i11 = inputStream.read(bArr, i10, iMin2 - i10);
                if (i11 == -1) {
                    return m5480a(arrayDeque, i6);
                }
                i10 += i11;
                i6 += i11;
            }
            iMin = AbstractC3612b.m7255K(((long) iMin) * ((long) (iMin < 4096 ? 4 : 2)));
        }
        if (inputStream.read() == -1) {
            return m5480a(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
