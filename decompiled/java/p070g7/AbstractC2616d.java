package p070g7;

import java.util.Arrays;

public abstract class AbstractC2616d {

    public static final byte[] f9099a;

    static {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i6 = 0; i6 < 10; i6++) {
            bArr[i6 + 48] = (byte) i6;
        }
        for (int i10 = 0; i10 < 26; i10++) {
            byte b8 = (byte) (i10 + 10);
            bArr[i10 + 65] = b8;
            bArr[i10 + 97] = b8;
        }
        f9099a = bArr;
    }
}
