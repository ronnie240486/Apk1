package p041d7;

import java.util.Arrays;
import java.util.Objects;
import p020b7.AbstractC1332b;

public final class C2215h5 extends AbstractC2331z1 {

    public static final C2215h5 f7927g = new C2215h5(null, new Object[0], 0);

    public final transient Object f7928d;

    public final transient Object[] f7929e;

    public final transient int f7930f;

    public C2215h5(Object obj, Object[] objArr, int i6) {
        this.f7928d = obj;
        this.f7929e = objArr;
        this.f7930f = i6;
    }

    public static C2215h5 m5205g(int i6, Object[] objArr, C2325y1 c2325y1) {
        short[] sArr;
        char c5;
        ?? r10;
        byte[] bArr;
        boolean z7;
        ?? r11;
        Object[] objArr2;
        C2319x1 c2319x1;
        int i10 = i6;
        Object[] objArrCopyOf = objArr;
        if (i10 == 0) {
            return f7927g;
        }
        int i11 = 1;
        C2319x1 c2319x2 = null;
        ?? r12 = 0;
        C2319x1 c2319x3 = null;
        C2319x1 c2319x4 = null;
        if (i10 == 1) {
            Objects.requireNonNull(objArrCopyOf[0]);
            Objects.requireNonNull(objArrCopyOf[1]);
            return new C2215h5(null, objArrCopyOf, 1);
        }
        AbstractC1332b.m3220k(i10, objArrCopyOf.length >> 1);
        int iM5234j = AbstractC2233k2.m5234j(i6);
        if (i10 != 1) {
            int i12 = iM5234j - 1;
            byte b8 = -1;
            if (iM5234j <= 128) {
                bArr = new byte[iM5234j];
                Arrays.fill(bArr, (byte) -1);
                int i13 = 0;
                int i14 = 0;
                while (i13 < i10) {
                    int i15 = i13 * 2;
                    int i16 = i14 * 2;
                    Object obj = objArrCopyOf[i15];
                    Objects.requireNonNull(obj);
                    Object obj2 = objArrCopyOf[i15 ^ i11];
                    Objects.requireNonNull(obj2);
                    int iM5129A = AbstractC2182d0.m5129A(obj.hashCode());
                    while (true) {
                        int i17 = iM5129A & i12;
                        int i18 = bArr[i17] & 255;
                        if (i18 == 255) {
                            bArr[i17] = (byte) i16;
                            if (i14 < i13) {
                                objArrCopyOf[i16] = obj;
                                objArrCopyOf[i16 ^ 1] = obj2;
                            }
                            i14++;
                            break;
                        }
                        if (obj.equals(objArrCopyOf[i18 == true ? 1 : 0])) {
                            int i19 = ~i18;
                            Object obj3 = objArrCopyOf[i19 == true ? 1 : 0];
                            Objects.requireNonNull(obj3);
                            C2319x1 c2319x5 = new C2319x1(obj, obj2, obj3);
                            objArrCopyOf[i19 == true ? 1 : 0] = obj2;
                            c2319x3 = c2319x5;
                            break;
                        }
                        iM5129A = i17 + 1;
                    }
                    i13++;
                    i11 = 1;
                }
                if (i14 == i10) {
                    r12 = bArr;
                } else {
                    sArr = new Object[]{bArr, Integer.valueOf(i14), c2319x3};
                    r12 = sArr;
                }
            } else {
                if (iM5234j <= 32768) {
                    sArr = new short[iM5234j];
                    Arrays.fill(sArr, (short) -1);
                    int i20 = 0;
                    for (int i21 = 0; i21 < i10; i21++) {
                        int i22 = i21 * 2;
                        int i23 = i20 * 2;
                        Object obj4 = objArrCopyOf[i22];
                        Objects.requireNonNull(obj4);
                        Object obj5 = objArrCopyOf[i22 ^ 1];
                        Objects.requireNonNull(obj5);
                        int iM5129A2 = AbstractC2182d0.m5129A(obj4.hashCode());
                        while (true) {
                            int i24 = iM5129A2 & i12;
                            int i25 = sArr[i24] & 65535;
                            if (i25 == 65535) {
                                sArr[i24] = (short) i23;
                                if (i20 < i21) {
                                    objArrCopyOf[i23] = obj4;
                                    objArrCopyOf[i23 ^ 1] = obj5;
                                }
                                i20++;
                                break;
                            }
                            if (obj4.equals(objArrCopyOf[i25 == true ? 1 : 0])) {
                                int i26 = ~i25;
                                Object obj6 = objArrCopyOf[i26 == true ? 1 : 0];
                                Objects.requireNonNull(obj6);
                                c2319x4 = new C2319x1(obj4, obj5, obj6);
                                objArrCopyOf[i26 == true ? 1 : 0] = obj5;
                                break;
                            }
                            iM5129A2 = i24 + 1;
                        }
                    }
                    if (i20 != i10) {
                        bArr = new Object[]{sArr, Integer.valueOf(i20), c2319x4};
                        r12 = bArr;
                    }
                } else {
                    sArr = new int[iM5234j];
                    Arrays.fill((int[]) sArr, -1);
                    int i27 = 0;
                    int i28 = 0;
                    while (i27 < i10) {
                        int i29 = i27 * 2;
                        int i30 = i28 * 2;
                        Object obj7 = objArrCopyOf[i29];
                        Objects.requireNonNull(obj7);
                        Object obj8 = objArrCopyOf[i29 ^ 1];
                        Objects.requireNonNull(obj8);
                        int iM5129A3 = AbstractC2182d0.m5129A(obj7.hashCode());
                        while (true) {
                            int i31 = iM5129A3 & i12;
                            ?? r15 = sArr[i31];
                            if (r15 == b8) {
                                sArr[i31] = i30;
                                if (i28 < i27) {
                                    objArrCopyOf[i30] = obj7;
                                    objArrCopyOf[i30 ^ 1] = obj8;
                                }
                                i28++;
                                break;
                            }
                            if (obj7.equals(objArrCopyOf[r15])) {
                                int i32 = r15 ^ 1;
                                Object obj9 = objArrCopyOf[i32 == true ? 1 : 0];
                                Objects.requireNonNull(obj9);
                                c2319x2 = new C2319x1(obj7, obj8, obj9);
                                objArrCopyOf[i32 == true ? 1 : 0] = obj8;
                                break;
                            }
                            iM5129A3 = i31 + 1;
                            b8 = -1;
                        }
                        i27++;
                        b8 = -1;
                    }
                    if (i28 != i10) {
                        c5 = 2;
                        r10 = new Object[]{sArr, Integer.valueOf(i28), c2319x2};
                    }
                }
                r12 = sArr;
            }
            z7 = r10 instanceof Object[];
            r11 = r10;
            if (z7) {
                objArr2 = (Object[]) r10;
                c2319x1 = (C2319x1) objArr2[c5];
                if (c2325y1 != null) {
                    throw c2319x1.m5288a();
                }
                c2325y1.f8104c = c2319x1;
                Object obj10 = objArr2[0];
                int iIntValue = ((Integer) objArr2[1]).intValue();
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue * 2);
                r11 = obj10;
                i10 = iIntValue;
            }
            return new C2215h5(r11, objArrCopyOf, i10);
        }
        Objects.requireNonNull(objArrCopyOf[0]);
        Objects.requireNonNull(objArrCopyOf[1]);
        c5 = 2;
        r10 = r12;
        z7 = r10 instanceof Object[];
        r11 = r10;
        if (z7) {
            objArr2 = (Object[]) r10;
            c2319x1 = (C2319x1) objArr2[c5];
            if (c2325y1 != null) {
                throw c2319x1.m5288a();
            }
            c2325y1.f8104c = c2319x1;
            Object obj11 = objArr2[0];
            int iIntValue2 = ((Integer) objArr2[1]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue2 * 2);
            r11 = obj11;
            i10 = iIntValue2;
        }
        return new C2215h5(r11, objArrCopyOf, i10);
    }

    @Override
    public final Object get(Object obj) {
        Object obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            Object[] objArr = this.f7929e;
            if (this.f7930f == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                if (obj3.equals(obj)) {
                    obj2 = objArr[1];
                    Objects.requireNonNull(obj2);
                } else {
                    obj2 = null;
                }
            } else {
                Object obj4 = this.f7928d;
                if (obj4 == null) {
                    obj2 = null;
                } else if (obj4 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj4;
                    int length = bArr.length - 1;
                    int iM5129A = AbstractC2182d0.m5129A(obj.hashCode());
                    while (true) {
                        int i6 = iM5129A & length;
                        int i10 = bArr[i6] & 255;
                        if (i10 == 255) {
                            break;
                        }
                        if (obj.equals(objArr[i10])) {
                            obj2 = objArr[i10 ^ 1];
                        } else {
                            iM5129A = i6 + 1;
                        }
                    }
                    obj2 = null;
                } else if (obj4 instanceof short[]) {
                    short[] sArr = (short[]) obj4;
                    int length2 = sArr.length - 1;
                    int iM5129A2 = AbstractC2182d0.m5129A(obj.hashCode());
                    while (true) {
                        int i11 = iM5129A2 & length2;
                        int i12 = sArr[i11] & 65535;
                        if (i12 == 65535) {
                            break;
                        }
                        if (obj.equals(objArr[i12])) {
                            obj2 = objArr[i12 ^ 1];
                        } else {
                            iM5129A2 = i11 + 1;
                        }
                    }
                    obj2 = null;
                } else {
                    int[] iArr = (int[]) obj4;
                    int length3 = iArr.length - 1;
                    int iM5129A3 = AbstractC2182d0.m5129A(obj.hashCode());
                    while (true) {
                        int i13 = iM5129A3 & length3;
                        int i14 = iArr[i13];
                        if (i14 == -1) {
                            break;
                        }
                        if (obj.equals(objArr[i14])) {
                            obj2 = objArr[i14 ^ 1];
                        } else {
                            iM5129A3 = i13 + 1;
                        }
                    }
                    obj2 = null;
                }
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override
    public final int size() {
        return this.f7930f;
    }
}
