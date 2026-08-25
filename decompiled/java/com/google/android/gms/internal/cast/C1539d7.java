package com.google.android.gms.internal.cast;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000a.AbstractC0004e;

public final class C1539d7 extends AbstractC1503a1 {

    public static final Logger f5247h = Logger.getLogger(C1539d7.class.getName());

    public static final boolean f5248i = AbstractC1600j8.f5376e;

    public C1675r7 f5249d;

    public final byte[] f5250e;

    public final int f5251f;

    public int f5252g;

    public C1539d7(byte[] bArr, int i6) {
        super(13);
        int length = bArr.length;
        if (((length - i6) | i6) < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(AbstractC0004e.m19m(length, i6, "Array range is invalid. Buffer.length=", ", offset=0, length="));
        }
        this.f5250e = bArr;
        this.f5252g = 0;
        this.f5251f = i6;
    }

    public static int m3786I(int i6, AbstractC1728x6 abstractC1728x6, InterfaceC1520b8 interfaceC1520b8) {
        int iM3789L = m3789L(i6 << 3);
        return abstractC1728x6.mo3866a(interfaceC1520b8) + iM3789L + iM3789L;
    }

    public static int m3787J(AbstractC1728x6 abstractC1728x6, InterfaceC1520b8 interfaceC1520b8) {
        int iMo3866a = abstractC1728x6.mo3866a(interfaceC1520b8);
        return m3789L(iMo3866a) + iMo3866a;
    }

    public static int m3788K(String str) {
        int length;
        try {
            length = AbstractC1620l8.m3929b(str);
        } catch (C1610k8 unused) {
            length = str.getBytes(AbstractC1639n7.f5472a).length;
        }
        return m3789L(length) + length;
    }

    public static int m3789L(int i6) {
        return (352 - (Integer.numberOfLeadingZeros(i6) * 9)) >>> 6;
    }

    public static int m3790t(long j10) {
        return (640 - (Long.numberOfLeadingZeros(j10) * 9)) >>> 6;
    }

    public final void m3791A(int i6, int i10) throws C1549e7 {
        m3796F(i6 << 3);
        m3792B(i10);
    }

    public final void m3792B(int i6) throws C1549e7 {
        if (i6 >= 0) {
            m3796F(i6);
        } else {
            m3798H(i6);
        }
    }

    public final void m3793C(int i6, String str) throws C1549e7 {
        m3796F((i6 << 3) | 2);
        int i10 = this.f5252g;
        try {
            int iM3789L = m3789L(str.length() * 3);
            int iM3789L2 = m3789L(str.length());
            byte[] bArr = this.f5250e;
            int i11 = this.f5251f;
            if (iM3789L2 == iM3789L) {
                int i12 = i10 + iM3789L2;
                this.f5252g = i12;
                int iM3928a = AbstractC1620l8.m3928a(str, bArr, i12, i11 - i12);
                this.f5252g = i10;
                m3796F((iM3928a - i10) - iM3789L2);
                this.f5252g = iM3928a;
            } else {
                m3796F(AbstractC1620l8.m3929b(str));
                int i13 = this.f5252g;
                this.f5252g = AbstractC1620l8.m3928a(str, bArr, i13, i11 - i13);
            }
        } catch (C1610k8 e5) {
            this.f5252g = i10;
            f5247h.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e5);
            byte[] bytes = str.getBytes(AbstractC1639n7.f5472a);
            try {
                int length = bytes.length;
                m3796F(length);
                m3799u(bytes, length);
            } catch (IndexOutOfBoundsException e10) {
                throw new C1549e7(e10);
            }
        } catch (IndexOutOfBoundsException e11) {
            throw new C1549e7(e11);
        }
    }

    public final void m3794D(int i6, int i10) throws C1549e7 {
        m3796F((i6 << 3) | i10);
    }

    public final void m3795E(int i6, int i10) throws C1549e7 {
        m3796F(i6 << 3);
        m3796F(i10);
    }

    public final void m3796F(int i6) throws C1549e7 {
        int i10;
        int i11 = this.f5252g;
        while (true) {
            int i12 = i6 & (-128);
            byte[] bArr = this.f5250e;
            if (i12 == 0) {
                i10 = i11 + 1;
                bArr[i11] = (byte) i6;
                this.f5252g = i10;
                return;
            } else {
                i10 = i11 + 1;
                try {
                    bArr[i11] = (byte) (i6 | 128);
                    i6 >>>= 7;
                    i11 = i10;
                } catch (IndexOutOfBoundsException e5) {
                    throw new C1549e7(i10, this.f5251f, 1, e5);
                }
            }
            throw new C1549e7(i10, this.f5251f, 1, e5);
        }
    }

    public final void m3797G(int i6, long j10) throws C1549e7 {
        m3796F(i6 << 3);
        m3798H(j10);
    }

    public final void m3798H(long j10) throws C1549e7 {
        int i6;
        int i10 = this.f5252g;
        byte[] bArr = this.f5250e;
        boolean z7 = f5248i;
        int i11 = this.f5251f;
        if (!z7 || i11 - i10 < 10) {
            long j11 = j10;
            while ((j11 & (-128)) != 0) {
                i6 = i10 + 1;
                try {
                    bArr[i10] = (byte) (((int) j11) | 128);
                    j11 >>>= 7;
                    i10 = i6;
                } catch (IndexOutOfBoundsException e5) {
                    throw new C1549e7(i6, i11, 1, e5);
                }
            }
            i6 = i10 + 1;
            bArr[i10] = (byte) j11;
        } else {
            long j12 = j10;
            while ((j12 & (-128)) != 0) {
                AbstractC1600j8.f5374c.mo3828d(bArr, AbstractC1600j8.f5377f + ((long) i10), (byte) (((int) j12) | 128));
                j12 >>>= 7;
                i10++;
            }
            i6 = i10 + 1;
            AbstractC1600j8.f5374c.mo3828d(bArr, AbstractC1600j8.f5377f + ((long) i10), (byte) j12);
        }
        this.f5252g = i6;
    }

    public final void m3799u(byte[] bArr, int i6) throws C1549e7 {
        try {
            System.arraycopy(bArr, 0, this.f5250e, this.f5252g, i6);
            this.f5252g += i6;
        } catch (IndexOutOfBoundsException e5) {
            throw new C1549e7(this.f5252g, this.f5251f, i6, e5);
        }
    }

    public final void m3800v(int i6, C1529c7 c1529c7) throws C1549e7 {
        m3796F((i6 << 3) | 2);
        m3796F(c1529c7.mo3734e());
        m3799u(c1529c7.f5235b, c1529c7.mo3734e());
    }

    public final void m3801w(int i6, int i10) throws C1549e7 {
        m3796F((i6 << 3) | 5);
        m3802x(i10);
    }

    public final void m3802x(int i6) throws C1549e7 {
        int i10 = this.f5252g;
        try {
            byte[] bArr = this.f5250e;
            bArr[i10] = (byte) i6;
            bArr[i10 + 1] = (byte) (i6 >> 8);
            bArr[i10 + 2] = (byte) (i6 >> 16);
            bArr[i10 + 3] = (byte) (i6 >> 24);
            this.f5252g = i10 + 4;
        } catch (IndexOutOfBoundsException e5) {
            throw new C1549e7(i10, this.f5251f, 4, e5);
        }
    }

    public final void m3803y(int i6, long j10) throws C1549e7 {
        m3796F((i6 << 3) | 1);
        m3804z(j10);
    }

    public final void m3804z(long j10) throws C1549e7 {
        int i6 = this.f5252g;
        try {
            byte[] bArr = this.f5250e;
            bArr[i6] = (byte) j10;
            bArr[i6 + 1] = (byte) (j10 >> 8);
            bArr[i6 + 2] = (byte) (j10 >> 16);
            bArr[i6 + 3] = (byte) (j10 >> 24);
            bArr[i6 + 4] = (byte) (j10 >> 32);
            bArr[i6 + 5] = (byte) (j10 >> 40);
            bArr[i6 + 6] = (byte) (j10 >> 48);
            bArr[i6 + 7] = (byte) (j10 >> 56);
            this.f5252g = i6 + 8;
        } catch (IndexOutOfBoundsException e5) {
            throw new C1549e7(i6, this.f5251f, 8, e5);
        }
    }
}
