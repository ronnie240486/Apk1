package p253x8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2796i;
import p222u7.AbstractC3928d;

public abstract class AbstractC4146i extends AbstractC3928d {
    public static boolean m8169B(Object[] objArr, Object obj) {
        int i6;
        AbstractC2796i.m5785f(objArr, "<this>");
        if (obj == null) {
            int length = objArr.length;
            i6 = 0;
            while (i6 < length) {
                if (objArr[i6] != null) {
                    i6++;
                }
            }
            i6 = -1;
        } else {
            int length2 = objArr.length;
            for (int i10 = 0; i10 < length2; i10++) {
                if (obj.equals(objArr[i10])) {
                    i6 = i10;
                }
            }
            i6 = -1;
        }
        return i6 >= 0;
    }

    public static void m8170C(int i6, int i10, int i11, int[] iArr, int[] iArr2) {
        AbstractC2796i.m5785f(iArr, "<this>");
        AbstractC2796i.m5785f(iArr2, "destination");
        System.arraycopy(iArr, i10, iArr2, i6, i11 - i10);
    }

    public static void m8171D(int i6, int i10, int i11, Object[] objArr, Object[] objArr2) {
        AbstractC2796i.m5785f(objArr, "<this>");
        AbstractC2796i.m5785f(objArr2, "destination");
        System.arraycopy(objArr, i10, objArr2, i6, i11 - i10);
    }

    public static void m8172E(byte[] bArr, int i6, int i10, byte[] bArr2, int i11) {
        AbstractC2796i.m5785f(bArr, "<this>");
        AbstractC2796i.m5785f(bArr2, "destination");
        System.arraycopy(bArr, i10, bArr2, i6, i11 - i10);
    }

    public static void m8173F(int i6, int i10, int i11, Object[] objArr, Object[] objArr2) {
        if ((i11 & 4) != 0) {
            i6 = 0;
        }
        m8171D(0, i6, i10, objArr, objArr2);
    }

    public static byte[] m8174G(byte[] bArr, int i6, int i10) {
        AbstractC2796i.m5785f(bArr, "<this>");
        AbstractC3928d.m7844e(i10, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i6, i10);
        AbstractC2796i.m5784e(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static Object[] m8175H(Object[] objArr, int i6, int i10) {
        AbstractC2796i.m5785f(objArr, "<this>");
        AbstractC3928d.m7844e(i10, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i6, i10);
        AbstractC2796i.m5784e(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static void m8176I(Object[] objArr, int i6, int i10) {
        AbstractC2796i.m5785f(objArr, "<this>");
        Arrays.fill(objArr, i6, i10, (Object) null);
    }

    public static ArrayList m8177J(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static char m8178K(char[] cArr) {
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static List m8179L(Object[] objArr) {
        AbstractC2796i.m5785f(objArr, "<this>");
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? new ArrayList(new C4144g(objArr, false)) : AbstractC0032a.m154F(objArr[0]);
        }
        return C4155r.f14074a;
    }
}
