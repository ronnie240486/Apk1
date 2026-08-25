package p047e1;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class C2359c {

    public final int f8230a;

    public final int f8231b;

    public final long f8232c;

    public final byte[] f8233d;

    public C2359c(byte[] bArr, int i6, int i10) {
        this(-1L, bArr, i6, i10);
    }

    public static C2359c m5341a(long j10, ByteOrder byteOrder) {
        long[] jArr = {j10};
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C2363g.f8242C[4]]);
        byteBufferWrap.order(byteOrder);
        byteBufferWrap.putInt((int) jArr[0]);
        return new C2359c(byteBufferWrap.array(), 4, 1);
    }

    public static C2359c m5342b(C2361e c2361e, ByteOrder byteOrder) {
        C2361e[] c2361eArr = {c2361e};
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C2363g.f8242C[5]]);
        byteBufferWrap.order(byteOrder);
        C2361e c2361e2 = c2361eArr[0];
        byteBufferWrap.putInt((int) c2361e2.f8238a);
        byteBufferWrap.putInt((int) c2361e2.f8239b);
        return new C2359c(byteBufferWrap.array(), 5, 1);
    }

    public static C2359c m5343c(int i6, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C2363g.f8242C[3]]);
        byteBufferWrap.order(byteOrder);
        byteBufferWrap.putShort((short) new int[]{i6}[0]);
        return new C2359c(byteBufferWrap.array(), 3, 1);
    }

    public final double m5344d(ByteOrder byteOrder) throws Throwable {
        Object objM5347g = m5347g(byteOrder);
        if (objM5347g == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (objM5347g instanceof String) {
            return Double.parseDouble((String) objM5347g);
        }
        if (objM5347g instanceof long[]) {
            long[] jArr = (long[]) objM5347g;
            if (jArr.length == 1) {
                return jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objM5347g instanceof int[]) {
            int[] iArr = (int[]) objM5347g;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objM5347g instanceof double[]) {
            double[] dArr = (double[]) objM5347g;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objM5347g instanceof C2361e[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        C2361e[] c2361eArr = (C2361e[]) objM5347g;
        if (c2361eArr.length != 1) {
            throw new NumberFormatException("There are more than one component");
        }
        C2361e c2361e = c2361eArr[0];
        return c2361e.f8238a / c2361e.f8239b;
    }

    public final int m5345e(ByteOrder byteOrder) throws Throwable {
        Object objM5347g = m5347g(byteOrder);
        if (objM5347g == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (objM5347g instanceof String) {
            return Integer.parseInt((String) objM5347g);
        }
        if (objM5347g instanceof long[]) {
            long[] jArr = (long[]) objM5347g;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objM5347g instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) objM5347g;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    public final String m5346f(ByteOrder byteOrder) throws Throwable {
        Object objM5347g = m5347g(byteOrder);
        if (objM5347g == null) {
            return null;
        }
        if (objM5347g instanceof String) {
            return (String) objM5347g;
        }
        StringBuilder sb = new StringBuilder();
        int i6 = 0;
        if (objM5347g instanceof long[]) {
            long[] jArr = (long[]) objM5347g;
            while (i6 < jArr.length) {
                sb.append(jArr[i6]);
                i6++;
                if (i6 != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objM5347g instanceof int[]) {
            int[] iArr = (int[]) objM5347g;
            while (i6 < iArr.length) {
                sb.append(iArr[i6]);
                i6++;
                if (i6 != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objM5347g instanceof double[]) {
            double[] dArr = (double[]) objM5347g;
            while (i6 < dArr.length) {
                sb.append(dArr[i6]);
                i6++;
                if (i6 != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (!(objM5347g instanceof C2361e[])) {
            return null;
        }
        C2361e[] c2361eArr = (C2361e[]) objM5347g;
        while (i6 < c2361eArr.length) {
            sb.append(c2361eArr[i6].f8238a);
            sb.append('/');
            sb.append(c2361eArr[i6].f8239b);
            i6++;
            if (i6 != c2361eArr.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public final Serializable m5347g(ByteOrder byteOrder) throws Throwable {
        C2358b c2358b;
        InputStream inputStream;
        byte b8;
        int length = 0;
        byte[] bArr = this.f8233d;
        InputStream inputStream2 = null;
        try {
            try {
                c2358b = new C2358b(bArr);
                try {
                    c2358b.f8227c = byteOrder;
                    int i6 = this.f8230a;
                    int i10 = this.f8231b;
                    switch (i6) {
                        case 1:
                        case 6:
                            if (bArr.length != 1 || (b8 = bArr[0]) < 0 || b8 > 1) {
                                String str = new String(bArr, C2363g.f8251L);
                                try {
                                    c2358b.close();
                                    break;
                                } catch (IOException e5) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                                }
                                return str;
                            }
                            String str2 = new String(new char[]{(char) (b8 + 48)});
                            try {
                                c2358b.close();
                                break;
                            } catch (IOException e10) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (i10 >= C2363g.f8243D.length) {
                                int i11 = 0;
                                while (true) {
                                    byte[] bArr2 = C2363g.f8243D;
                                    if (i11 >= bArr2.length) {
                                        length = bArr2.length;
                                    } else if (bArr[i11] == bArr2[i11]) {
                                        i11++;
                                    }
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            try {
                                while (length < i10) {
                                    byte b10 = bArr[length];
                                    if (b10 == 0) {
                                        String string = sb.toString();
                                        c2358b.close();
                                        return string;
                                    }
                                    if (b10 >= 32) {
                                        sb.append((char) b10);
                                    } else {
                                        sb.append('?');
                                    }
                                    length++;
                                }
                                c2358b.close();
                                break;
                            } catch (IOException e11) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                            }
                            String string2 = sb.toString();
                            return string2;
                        case 3:
                            ?? r15 = new int[i10];
                            while (length < i10) {
                                r15[length] = c2358b.readUnsignedShort();
                                length++;
                            }
                            try {
                                c2358b.close();
                                break;
                            } catch (IOException e12) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                            }
                            return r15;
                        case 4:
                            ?? r16 = new long[i10];
                            while (length < i10) {
                                r16[length] = ((long) c2358b.readInt()) & 4294967295L;
                                length++;
                            }
                            try {
                                c2358b.close();
                                break;
                            } catch (IOException e13) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e13);
                            }
                            return r16;
                        case 5:
                            ?? r17 = new C2361e[i10];
                            while (length < i10) {
                                r17[length] = new C2361e(((long) c2358b.readInt()) & 4294967295L, ((long) c2358b.readInt()) & 4294967295L);
                                length++;
                            }
                            try {
                                c2358b.close();
                                break;
                            } catch (IOException e14) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e14);
                            }
                            return r17;
                        case 8:
                            ?? r18 = new int[i10];
                            while (length < i10) {
                                r18[length] = c2358b.readShort();
                                length++;
                            }
                            try {
                                c2358b.close();
                                break;
                            } catch (IOException e15) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e15);
                            }
                            return r18;
                        case 9:
                            ?? r19 = new int[i10];
                            while (length < i10) {
                                r19[length] = c2358b.readInt();
                                length++;
                            }
                            try {
                                c2358b.close();
                                break;
                            } catch (IOException e16) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e16);
                            }
                            return r19;
                        case 10:
                            ?? r110 = new C2361e[i10];
                            while (length < i10) {
                                r110[length] = new C2361e(c2358b.readInt(), c2358b.readInt());
                                length++;
                            }
                            try {
                                c2358b.close();
                                break;
                            } catch (IOException e17) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e17);
                            }
                            return r110;
                        case 11:
                            ?? r111 = new double[i10];
                            while (length < i10) {
                                r111[length] = c2358b.readFloat();
                                length++;
                            }
                            try {
                                c2358b.close();
                                break;
                            } catch (IOException e18) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e18);
                            }
                            return r111;
                        case 12:
                            ?? r112 = new double[i10];
                            while (length < i10) {
                                r112[length] = c2358b.readDouble();
                                length++;
                            }
                            try {
                                c2358b.close();
                                break;
                            } catch (IOException e19) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e19);
                            }
                            return r112;
                        default:
                            try {
                                c2358b.close();
                                break;
                            } catch (IOException e20) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e20);
                            }
                            return null;
                    }
                } catch (IOException e21) {
                    e = e21;
                    Log.w("ExifInterface", "IOException occurred during reading a value", e);
                    if (c2358b != null) {
                        try {
                            c2358b.close();
                        } catch (IOException e22) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e22);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e23) {
                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e23);
                    }
                }
                throw th;
            }
        } catch (IOException e24) {
            e = e24;
            c2358b = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            throw th;
        }
    }

    public final String toString() {
        return "(" + C2363g.f8241B[this.f8230a] + ", data length:" + this.f8233d.length + ")";
    }

    public C2359c(long j10, byte[] bArr, int i6, int i10) {
        this.f8230a = i6;
        this.f8231b = i10;
        this.f8232c = j10;
        this.f8233d = bArr;
    }
}
