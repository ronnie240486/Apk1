package com.google.android.gms.internal.cast;

import androidx.media3.common.C0565C;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.flac.FlacConstants;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.alibaba.fastjson.asm.Opcodes;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import me.jessyan.autosize.BuildConfig;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import sun.misc.Unsafe;

public final class C1711v7 implements InterfaceC1520b8 {

    public static final int[] f5706g = new int[0];

    public static final Unsafe f5707h = AbstractC1600j8.m3890j();

    public final int[] f5708a;

    public final Object[] f5709b;

    public final AbstractC1728x6 f5710c;

    public final int[] f5711d;

    public final int f5712e;

    public final C1661q2 f5713f;

    public C1711v7(int[] iArr, Object[] objArr, AbstractC1728x6 abstractC1728x6, int[] iArr2, int i6, C1661q2 c1661q2, C1661q2 c1661q3) {
        this.f5708a = iArr;
        this.f5709b = objArr;
        this.f5711d = iArr2;
        this.f5712e = i6;
        this.f5713f = c1661q2;
        this.f5710c = abstractC1728x6;
    }

    public static boolean m4037i(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof AbstractC1589i7) {
            return ((AbstractC1589i7) obj).m3869g();
        }
        return true;
    }

    public static C1711v7 m4038k(C1510a8 c1510a8, C1661q2 c1661q2, C1661q2 c1661q3) {
        int i6;
        int iCharAt;
        int iCharAt2;
        int i10;
        int i11;
        int i12;
        int[] iArr;
        int i13;
        char cCharAt;
        int i14;
        char cCharAt2;
        int i15;
        char cCharAt3;
        int i16;
        char cCharAt4;
        int i17;
        int i18;
        int i19;
        char cCharAt5;
        int i20;
        char cCharAt6;
        int i21;
        int i22;
        int i23;
        int[] iArr2;
        int iObjectFieldOffset;
        int i24;
        int i25;
        int i26;
        int iObjectFieldOffset2;
        Field fieldM4042q;
        char cCharAt7;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        Object obj;
        Field fieldM4042q2;
        int i32;
        Object obj2;
        Field fieldM4042q3;
        int i33;
        char cCharAt8;
        int i34;
        char cCharAt9;
        int i35;
        char cCharAt10;
        int i36;
        char cCharAt11;
        if (!(c1510a8 instanceof C1510a8)) {
            AbstractC0004e.m2B(c1510a8);
            throw null;
        }
        String strM3728c = c1510a8.m3728c();
        int length = strM3728c.length();
        char c5 = 55296;
        if (strM3728c.charAt(0) >= 55296) {
            int i37 = 1;
            while (true) {
                i6 = i37 + 1;
                if (strM3728c.charAt(i37) < 55296) {
                    break;
                }
                i37 = i6;
            }
        } else {
            i6 = 1;
        }
        int i38 = i6 + 1;
        int iCharAt3 = strM3728c.charAt(i6);
        if (iCharAt3 >= 55296) {
            int i39 = iCharAt3 & 8191;
            int i40 = 13;
            while (true) {
                i36 = i38 + 1;
                cCharAt11 = strM3728c.charAt(i38);
                if (cCharAt11 < 55296) {
                    break;
                }
                i39 |= (cCharAt11 & 8191) << i40;
                i40 += 13;
                i38 = i36;
            }
            iCharAt3 = i39 | (cCharAt11 << i40);
            i38 = i36;
        }
        if (iCharAt3 == 0) {
            iArr = f5706g;
            i12 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i10 = 0;
            i11 = 0;
        } else {
            int i41 = i38 + 1;
            int iCharAt4 = strM3728c.charAt(i38);
            if (iCharAt4 >= 55296) {
                int i42 = iCharAt4 & 8191;
                int i43 = 13;
                while (true) {
                    i20 = i41 + 1;
                    cCharAt6 = strM3728c.charAt(i41);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt6 & 8191) << i43;
                    i43 += 13;
                    i41 = i20;
                }
                iCharAt4 = i42 | (cCharAt6 << i43);
                i41 = i20;
            }
            int i44 = i41 + 1;
            int iCharAt5 = strM3728c.charAt(i41);
            if (iCharAt5 >= 55296) {
                int i45 = iCharAt5 & 8191;
                int i46 = 13;
                while (true) {
                    i19 = i44 + 1;
                    cCharAt5 = strM3728c.charAt(i44);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt5 & 8191) << i46;
                    i46 += 13;
                    i44 = i19;
                }
                iCharAt5 = i45 | (cCharAt5 << i46);
                i44 = i19;
            }
            int i47 = i44 + 1;
            if (strM3728c.charAt(i44) >= 55296) {
                while (true) {
                    i18 = i47 + 1;
                    if (strM3728c.charAt(i47) < 55296) {
                        break;
                    }
                    i47 = i18;
                }
                i47 = i18;
            }
            int i48 = i47 + 1;
            if (strM3728c.charAt(i47) >= 55296) {
                while (true) {
                    i17 = i48 + 1;
                    if (strM3728c.charAt(i48) < 55296) {
                        break;
                    }
                    i48 = i17;
                }
                i48 = i17;
            }
            int i49 = i48 + 1;
            iCharAt = strM3728c.charAt(i48);
            if (iCharAt >= 55296) {
                int i50 = iCharAt & 8191;
                int i51 = 13;
                while (true) {
                    i16 = i49 + 1;
                    cCharAt4 = strM3728c.charAt(i49);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt4 & 8191) << i51;
                    i51 += 13;
                    i49 = i16;
                }
                iCharAt = i50 | (cCharAt4 << i51);
                i49 = i16;
            }
            int i52 = i49 + 1;
            iCharAt2 = strM3728c.charAt(i49);
            if (iCharAt2 >= 55296) {
                int i53 = iCharAt2 & 8191;
                int i54 = 13;
                while (true) {
                    i15 = i52 + 1;
                    cCharAt3 = strM3728c.charAt(i52);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt3 & 8191) << i54;
                    i54 += 13;
                    i52 = i15;
                }
                iCharAt2 = i53 | (cCharAt3 << i54);
                i52 = i15;
            }
            int i55 = i52 + 1;
            int iCharAt6 = strM3728c.charAt(i52);
            if (iCharAt6 >= 55296) {
                int i56 = iCharAt6 & 8191;
                int i57 = 13;
                while (true) {
                    i14 = i55 + 1;
                    cCharAt2 = strM3728c.charAt(i55);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt2 & 8191) << i57;
                    i57 += 13;
                    i55 = i14;
                }
                iCharAt6 = i56 | (cCharAt2 << i57);
                i55 = i14;
            }
            int i58 = i55 + 1;
            int iCharAt7 = strM3728c.charAt(i55);
            if (iCharAt7 >= 55296) {
                int i59 = iCharAt7 & 8191;
                int i60 = 13;
                while (true) {
                    i13 = i58 + 1;
                    cCharAt = strM3728c.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i58 = i13;
                }
                iCharAt7 = i59 | (cCharAt << i60);
                i58 = i13;
            }
            int i61 = iCharAt7 + iCharAt2 + iCharAt6;
            i10 = iCharAt4 + iCharAt4 + iCharAt5;
            int[] iArr3 = new int[i61];
            i11 = iCharAt7;
            i12 = iCharAt4;
            i38 = i58;
            iArr = iArr3;
        }
        Unsafe unsafe = f5707h;
        Object[] objArrM3729d = c1510a8.m3729d();
        Class<?> cls = c1510a8.m3726a().getClass();
        int i62 = iCharAt2 + i11;
        int i63 = iCharAt + iCharAt;
        int[] iArr4 = new int[iCharAt * 3];
        Object[] objArr = new Object[i63];
        int i64 = i11;
        int i65 = 0;
        int i66 = 0;
        while (i38 < length) {
            int i67 = i38 + 1;
            int iCharAt8 = strM3728c.charAt(i38);
            if (iCharAt8 >= c5) {
                int i68 = iCharAt8 & 8191;
                int i69 = i67;
                int i70 = 13;
                while (true) {
                    i35 = i69 + 1;
                    cCharAt10 = strM3728c.charAt(i69);
                    if (cCharAt10 < c5) {
                        break;
                    }
                    i68 |= (cCharAt10 & 8191) << i70;
                    i70 += 13;
                    i69 = i35;
                }
                iCharAt8 = i68 | (cCharAt10 << i70);
                i21 = i35;
            } else {
                i21 = i67;
            }
            int i71 = i21 + 1;
            int iCharAt9 = strM3728c.charAt(i21);
            if (iCharAt9 >= c5) {
                int i72 = iCharAt9 & 8191;
                int i73 = i71;
                int i74 = 13;
                while (true) {
                    i34 = i73 + 1;
                    cCharAt9 = strM3728c.charAt(i73);
                    if (cCharAt9 < 55296) {
                        break;
                    }
                    i72 |= (cCharAt9 & 8191) << i74;
                    i74 += 13;
                    i73 = i34;
                }
                iCharAt9 = i72 | (cCharAt9 << i74);
                i22 = i34;
            } else {
                i22 = i71;
            }
            if ((iCharAt9 & 1024) != 0) {
                iArr[i65] = i66;
                i65++;
            }
            int i75 = iCharAt9 & 255;
            int i76 = length;
            int i77 = iCharAt9 & 2048;
            int i78 = i11;
            if (i75 >= 51) {
                int i79 = i22 + 1;
                int iCharAt10 = strM3728c.charAt(i22);
                if (iCharAt10 >= 55296) {
                    int i80 = iCharAt10 & 8191;
                    int i81 = i79;
                    int i82 = 13;
                    while (true) {
                        i33 = i81 + 1;
                        cCharAt8 = strM3728c.charAt(i81);
                        i23 = iCharAt8;
                        if (cCharAt8 < 55296) {
                            break;
                        }
                        i80 |= (cCharAt8 & 8191) << i82;
                        i82 += 13;
                        i81 = i33;
                        iCharAt8 = i23;
                    }
                    iCharAt10 = i80 | (cCharAt8 << i82);
                    i29 = i33;
                } else {
                    i23 = iCharAt8;
                    i29 = i79;
                }
                int i83 = i75 - 51;
                int i84 = i29;
                if (i83 == 9 || i83 == 17) {
                    i30 = i10 + 1;
                    int i85 = i66 / 3;
                    objArr[i85 + i85 + 1] = objArrM3729d[i10];
                } else {
                    if (i83 == 12) {
                        if (c1510a8.m3727b() == 1 || i77 != 0) {
                            i30 = i10 + 1;
                            int i86 = i66 / 3;
                            objArr[i86 + i86 + 1] = objArrM3729d[i10];
                        } else {
                            i77 = 0;
                        }
                    }
                    i31 = iCharAt10 + iCharAt10;
                    obj = objArrM3729d[i31];
                    if (obj instanceof Field) {
                        fieldM4042q2 = (Field) obj;
                    } else {
                        fieldM4042q2 = m4042q(cls, (String) obj);
                        objArrM3729d[i31] = fieldM4042q2;
                    }
                    int[] iArr5 = iArr4;
                    int i87 = i62;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldM4042q2);
                    i32 = i31 + 1;
                    obj2 = objArrM3729d[i32];
                    if (obj2 instanceof Field) {
                        fieldM4042q3 = (Field) obj2;
                    } else {
                        fieldM4042q3 = m4042q(cls, (String) obj2);
                        objArrM3729d[i32] = fieldM4042q3;
                    }
                    iArr2 = iArr5;
                    objArrM3729d = objArrM3729d;
                    i24 = i84;
                    i62 = i87;
                    i26 = i10;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldM4042q3);
                    i25 = 0;
                }
                i10 = i30;
                i31 = iCharAt10 + iCharAt10;
                obj = objArrM3729d[i31];
                if (obj instanceof Field) {
                    fieldM4042q2 = (Field) obj;
                } else {
                    fieldM4042q2 = m4042q(cls, (String) obj);
                    objArrM3729d[i31] = fieldM4042q2;
                }
                int[] iArr6 = iArr4;
                int i88 = i62;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldM4042q2);
                i32 = i31 + 1;
                obj2 = objArrM3729d[i32];
                if (obj2 instanceof Field) {
                    fieldM4042q3 = (Field) obj2;
                } else {
                    fieldM4042q3 = m4042q(cls, (String) obj2);
                    objArrM3729d[i32] = fieldM4042q3;
                }
                iArr2 = iArr6;
                objArrM3729d = objArrM3729d;
                i24 = i84;
                i62 = i88;
                i26 = i10;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldM4042q3);
                i25 = 0;
            } else {
                i23 = iCharAt8;
                iArr2 = iArr4;
                int i89 = i62;
                int i90 = i10 + 1;
                Field fieldM4042q4 = m4042q(cls, (String) objArrM3729d[i10]);
                if (i75 == 9 || i75 == 17) {
                    iArr2 = iArr2;
                    int i91 = i66 / 3;
                    objArr[i91 + i91 + 1] = fieldM4042q4.getType();
                } else {
                    if (i75 == 27) {
                        i27 = 1;
                        i28 = i10 + 2;
                    } else if (i75 == 49) {
                        i28 = i10 + 2;
                        i27 = 1;
                    } else if (i75 == 12 || i75 == 30 || i75 == 44) {
                        iArr2 = iArr2;
                        if (c1510a8.m3727b() == 1 || i77 != 0) {
                            i28 = i10 + 2;
                            int i92 = i66 / 3;
                            objArr[i92 + i92 + 1] = objArrM3729d[i90];
                            i90 = i28;
                        } else {
                            i77 = 0;
                        }
                    } else {
                        if (i75 == 50) {
                            int i93 = i10 + 2;
                            int i94 = i64 + 1;
                            iArr[i64] = i66;
                            int i95 = i66 / 3;
                            int i96 = i95 + i95;
                            objArr[i96] = objArrM3729d[i90];
                            if (i77 != 0) {
                                i90 = i10 + 3;
                                objArr[i96 + 1] = objArrM3729d[i93];
                                i64 = i94;
                            } else {
                                i90 = i93;
                                i64 = i94;
                                i77 = 0;
                            }
                        }
                        iArr2 = iArr2;
                    }
                    int i97 = i66 / 3;
                    objArr[i97 + i97 + i27] = objArrM3729d[i90];
                    i90 = i28;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldM4042q4);
                iObjectFieldOffset = 1048575;
                if ((iCharAt9 & 4096) == 0 || i75 > 17) {
                    i24 = i22;
                    i25 = 0;
                } else {
                    int i98 = i22 + 1;
                    int iCharAt11 = strM3728c.charAt(i22);
                    if (iCharAt11 >= 55296) {
                        int i99 = iCharAt11 & 8191;
                        int i100 = 13;
                        while (true) {
                            i24 = i98 + 1;
                            cCharAt7 = strM3728c.charAt(i98);
                            if (cCharAt7 < 55296) {
                                break;
                            }
                            i99 |= (cCharAt7 & 8191) << i100;
                            i100 += 13;
                            i98 = i24;
                        }
                        iCharAt11 = i99 | (cCharAt7 << i100);
                    } else {
                        i24 = i98;
                    }
                    int i101 = (iCharAt11 / 32) + i12 + i12;
                    Object obj3 = objArrM3729d[i101];
                    if (obj3 instanceof Field) {
                        fieldM4042q = (Field) obj3;
                    } else {
                        fieldM4042q = m4042q(cls, (String) obj3);
                        objArrM3729d[i101] = fieldM4042q;
                    }
                    i25 = iCharAt11 % 32;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldM4042q);
                }
                if (i75 < 18 || i75 > 49) {
                    i26 = i90;
                    iObjectFieldOffset2 = iObjectFieldOffset3;
                    i62 = i89;
                } else {
                    iArr[i89] = iObjectFieldOffset3;
                    i26 = i90;
                    iObjectFieldOffset2 = iObjectFieldOffset3;
                    i62 = i89 + 1;
                }
            }
            int i102 = i66 + 1;
            iArr2[i66] = i23;
            int i103 = i66 + 2;
            iArr2[i102] = (i77 != 0 ? Integer.MIN_VALUE : 0) | ((iCharAt9 & 256) != 0 ? 268435456 : 0) | ((iCharAt9 & 512) != 0 ? C0565C.BUFFER_FLAG_LAST_SAMPLE : 0) | (i75 << 20) | iObjectFieldOffset2;
            i66 += 3;
            iArr2[i103] = (i25 << 20) | iObjectFieldOffset;
            i10 = i26;
            length = i76;
            objArrM3729d = objArrM3729d;
            i38 = i24;
            i11 = i78;
            iArr4 = iArr2;
            c5 = 55296;
        }
        return new C1711v7(iArr4, objArr, c1510a8.m3726a(), iArr, i11, c1661q2, c1661q3);
    }

    public static int m4039l(long j10, Object obj) {
        return ((Integer) AbstractC1600j8.m3889i(j10, obj)).intValue();
    }

    public static int m4040m(int i6) {
        return (i6 >>> 20) & 255;
    }

    public static long m4041o(long j10, Object obj) {
        return ((Long) AbstractC1600j8.m3889i(j10, obj)).longValue();
    }

    public static Field m4042q(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e5) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e5);
        }
    }

    @Override
    public final void mo3735a(Object obj, C1675r7 c1675r7) throws C1549e7 {
        int i6;
        int i10;
        int i11;
        Unsafe unsafe = f5707h;
        int i12 = 1048575;
        boolean z7 = false;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            int[] iArr = this.f5708a;
            if (i15 >= iArr.length) {
                C1550e8 c1550e8 = ((AbstractC1589i7) obj).zzc;
                return;
            }
            int iM4044n = m4044n(i15);
            int iM4040m = m4040m(iM4044n);
            int i16 = iArr[i15];
            if (iM4040m <= 17) {
                int i17 = iArr[i15 + 2];
                int i18 = i17 & i12;
                if (i18 != i13) {
                    i14 = i18 == i12 ? 0 : unsafe.getInt(obj, i18);
                    i13 = i18;
                }
                i11 = 1 << (i17 >>> 20);
                i6 = i13;
                i10 = i14;
            } else {
                i6 = i13;
                i10 = i14;
                i11 = 0;
            }
            long j10 = iM4044n & i12;
            switch (iM4040m) {
                case 0:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m4008v(i16, AbstractC1600j8.m3884d(j10, obj));
                    }
                    break;
                case 1:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m4012z(i16, AbstractC1600j8.m3885e(j10, obj));
                    }
                    break;
                case 2:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m3994C(i16, unsafe.getLong(obj, j10));
                    }
                    break;
                case 3:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m4004r(i16, unsafe.getLong(obj, j10));
                    }
                    break;
                case 4:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m3993B(i16, unsafe.getInt(obj, j10));
                    }
                    break;
                case 5:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m4011y(i16, unsafe.getLong(obj, j10));
                    }
                    break;
                case 6:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m4010x(i16, unsafe.getInt(obj, j10));
                    }
                    break;
                case 7:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m4005s(i16, AbstractC1600j8.m3897q(j10, obj));
                    }
                    break;
                case 8:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        Object object = unsafe.getObject(obj, j10);
                        if (object instanceof String) {
                            ((C1539d7) c1675r7.f5590b).m3793C(i16, (String) object);
                        } else {
                            c1675r7.m4006t(i16, (C1529c7) object);
                        }
                    }
                    break;
                case 9:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m3995D(i16, unsafe.getObject(obj, j10), m4045p(i15));
                    }
                    break;
                case 10:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m4006t(i16, (C1529c7) unsafe.getObject(obj, j10));
                    }
                    break;
                case 11:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m4003q(i16, unsafe.getInt(obj, j10));
                    }
                    break;
                case 12:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m4009w(i16, unsafe.getInt(obj, j10));
                    }
                    break;
                case 13:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m3996E(i16, unsafe.getInt(obj, j10));
                    }
                    break;
                case 14:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m3997F(i16, unsafe.getLong(obj, j10));
                    }
                    break;
                case 15:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m4000j(i16, unsafe.getInt(obj, j10));
                    }
                    break;
                case 16:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m4001o(i16, unsafe.getLong(obj, j10));
                    }
                    break;
                case 17:
                    if (m4051w(obj, i15, i6, i10, i11)) {
                        c1675r7.m3992A(i16, unsafe.getObject(obj, j10), m4045p(i15));
                    }
                    break;
                case 18:
                    AbstractC1530c8.m3778s(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, z7);
                    break;
                case 19:
                    AbstractC1530c8.m3782w(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, z7);
                    break;
                case 20:
                    AbstractC1530c8.m3784y(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, z7);
                    break;
                case 21:
                    AbstractC1530c8.m3762c(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, z7);
                    break;
                case 22:
                    AbstractC1530c8.m3783x(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, z7);
                    break;
                case 23:
                    AbstractC1530c8.m3781v(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, z7);
                    break;
                case 24:
                    AbstractC1530c8.m3780u(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, z7);
                    break;
                case 25:
                    AbstractC1530c8.m3777r(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, z7);
                    break;
                case 26:
                    int i19 = iArr[i15];
                    List list = (List) unsafe.getObject(obj, j10);
                    C1661q2 c1661q2 = AbstractC1530c8.f5236a;
                    if (list != null && !list.isEmpty()) {
                        c1675r7.m4002p(i19, list);
                    }
                    break;
                case 27:
                    int i20 = iArr[i15];
                    List list2 = (List) unsafe.getObject(obj, j10);
                    InterfaceC1520b8 interfaceC1520b8M4045p = m4045p(i15);
                    C1661q2 c1661q3 = AbstractC1530c8.f5236a;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i21 = 0; i21 < list2.size(); i21++) {
                            c1675r7.m3995D(i20, list2.get(i21), interfaceC1520b8M4045p);
                        }
                    }
                    break;
                case 28:
                    int i22 = iArr[i15];
                    List list3 = (List) unsafe.getObject(obj, j10);
                    C1661q2 c1661q4 = AbstractC1530c8.f5236a;
                    if (list3 != null && !list3.isEmpty()) {
                        c1675r7.m4007u(i22, list3);
                    }
                    break;
                case 29:
                    AbstractC1530c8.m3761b(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, z7);
                    break;
                case 30:
                    AbstractC1530c8.m3779t(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, z7);
                    break;
                case 31:
                    AbstractC1530c8.m3785z(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, z7);
                    break;
                case 32:
                    AbstractC1530c8.m3758A(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, z7);
                    break;
                case 33:
                    AbstractC1530c8.m3759B(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, z7);
                    break;
                case 34:
                    AbstractC1530c8.m3760a(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, z7);
                    break;
                case 35:
                    AbstractC1530c8.m3778s(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, true);
                    break;
                case TsExtractor.TS_STREAM_TYPE_H265:
                    AbstractC1530c8.m3782w(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, true);
                    break;
                case 37:
                    AbstractC1530c8.m3784y(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, true);
                    break;
                case FlacConstants.STREAM_INFO_BLOCK_SIZE:
                    AbstractC1530c8.m3762c(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, true);
                    break;
                case NalUnitUtil.H265_NAL_UNIT_TYPE_PREFIX_SEI:
                    AbstractC1530c8.m3783x(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, true);
                    break;
                case NalUnitUtil.H265_NAL_UNIT_TYPE_SUFFIX_SEI:
                    AbstractC1530c8.m3781v(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, true);
                    break;
                case BuildConfig.VERSION_CODE:
                    AbstractC1530c8.m3780u(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, true);
                    break;
                case AacUtil.AUDIO_OBJECT_TYPE_AAC_XHE:
                    AbstractC1530c8.m3777r(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, true);
                    break;
                case 43:
                    AbstractC1530c8.m3761b(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, true);
                    break;
                case 44:
                    AbstractC1530c8.m3779t(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, true);
                    break;
                case TsExtractor.TS_STREAM_TYPE_MHAS:
                    AbstractC1530c8.m3785z(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, true);
                    break;
                case 46:
                    AbstractC1530c8.m3758A(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, true);
                    break;
                case 47:
                    AbstractC1530c8.m3759B(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, true);
                    break;
                case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                    AbstractC1530c8.m3760a(iArr[i15], (List) unsafe.getObject(obj, j10), c1675r7, true);
                    break;
                case Opcodes.V1_5:
                    int i23 = iArr[i15];
                    List list4 = (List) unsafe.getObject(obj, j10);
                    InterfaceC1520b8 interfaceC1520b8M4045p2 = m4045p(i15);
                    C1661q2 c1661q5 = AbstractC1530c8.f5236a;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i24 = 0; i24 < list4.size(); i24++) {
                            c1675r7.m3992A(i23, list4.get(i24), interfaceC1520b8M4045p2);
                        }
                    }
                    break;
                case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                    if (unsafe.getObject(obj, j10) != null) {
                        int i25 = i15 / 3;
                        AbstractC2460q.m5499m(this.f5709b[i25 + i25]);
                        throw null;
                    }
                    break;
                    break;
                case 51:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m4008v(i16, ((Double) AbstractC1600j8.m3889i(j10, obj)).doubleValue());
                    }
                    break;
                case 52:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m4012z(i16, ((Float) AbstractC1600j8.m3889i(j10, obj)).floatValue());
                    }
                    break;
                case 53:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m3994C(i16, m4041o(j10, obj));
                    }
                    break;
                case Opcodes.ISTORE:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m4004r(i16, m4041o(j10, obj));
                    }
                    break;
                case Opcodes.LSTORE:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m3993B(i16, m4039l(j10, obj));
                    }
                    break;
                case Opcodes.FSTORE:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m4011y(i16, m4041o(j10, obj));
                    }
                    break;
                case Opcodes.DSTORE:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m4010x(i16, m4039l(j10, obj));
                    }
                    break;
                case Opcodes.ASTORE:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m4005s(i16, ((Boolean) AbstractC1600j8.m3889i(j10, obj)).booleanValue());
                    }
                    break;
                case 59:
                    if (m4043j(i16, i15, obj)) {
                        Object object2 = unsafe.getObject(obj, j10);
                        if (object2 instanceof String) {
                            ((C1539d7) c1675r7.f5590b).m3793C(i16, (String) object2);
                        } else {
                            c1675r7.m4006t(i16, (C1529c7) object2);
                        }
                    }
                    break;
                case 60:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m3995D(i16, unsafe.getObject(obj, j10), m4045p(i15));
                    }
                    break;
                case 61:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m4006t(i16, (C1529c7) unsafe.getObject(obj, j10));
                    }
                    break;
                case 62:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m4003q(i16, m4039l(j10, obj));
                    }
                    break;
                case 63:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m4009w(i16, m4039l(j10, obj));
                    }
                    break;
                case 64:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m3996E(i16, m4039l(j10, obj));
                    }
                    break;
                case 65:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m3997F(i16, m4041o(j10, obj));
                    }
                    break;
                case 66:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m4000j(i16, m4039l(j10, obj));
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m4001o(i16, m4041o(j10, obj));
                    }
                    break;
                case 68:
                    if (m4043j(i16, i15, obj)) {
                        c1675r7.m3992A(i16, unsafe.getObject(obj, j10), m4045p(i15));
                    }
                    break;
            }
            i15 += 3;
            i13 = i6;
            i14 = i10;
            i12 = 1048575;
            z7 = false;
        }
    }

    @Override
    public final AbstractC1589i7 mo3736b() {
        return (AbstractC1589i7) ((AbstractC1589i7) this.f5710c).mo3714h(4, null);
    }

    @Override
    public final boolean mo3737c(AbstractC1589i7 abstractC1589i7, Object obj) {
        boolean zM3763d;
        int i6 = 0;
        while (true) {
            int[] iArr = this.f5708a;
            if (i6 >= iArr.length) {
                return abstractC1589i7.zzc.equals(((AbstractC1589i7) obj).zzc);
            }
            int iM4044n = m4044n(i6);
            long j10 = iM4044n & 1048575;
            switch (m4040m(iM4044n)) {
                case 0:
                    if (m4049u(abstractC1589i7, obj, i6)) {
                        AbstractC1590i8 abstractC1590i8 = AbstractC1600j8.f5374c;
                        if (Double.doubleToLongBits(abstractC1590i8.mo3825a(j10, abstractC1589i7)) == Double.doubleToLongBits(abstractC1590i8.mo3825a(j10, obj))) {
                            continue;
                            i6 += 3;
                            break;
                        }
                    }
                    return false;
                case 1:
                    if (m4049u(abstractC1589i7, obj, i6)) {
                        AbstractC1590i8 abstractC1590i9 = AbstractC1600j8.f5374c;
                        if (Float.floatToIntBits(abstractC1590i9.mo3826b(j10, abstractC1589i7)) == Float.floatToIntBits(abstractC1590i9.mo3826b(j10, obj))) {
                            continue;
                            i6 += 3;
                            break;
                        }
                    }
                    return false;
                case 2:
                    if (!m4049u(abstractC1589i7, obj, i6) || AbstractC1600j8.m3887g(j10, abstractC1589i7) != AbstractC1600j8.m3887g(j10, obj)) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 3:
                    if (!m4049u(abstractC1589i7, obj, i6) || AbstractC1600j8.m3887g(j10, abstractC1589i7) != AbstractC1600j8.m3887g(j10, obj)) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 4:
                    if (!m4049u(abstractC1589i7, obj, i6) || AbstractC1600j8.m3886f(j10, abstractC1589i7) != AbstractC1600j8.m3886f(j10, obj)) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 5:
                    if (!m4049u(abstractC1589i7, obj, i6) || AbstractC1600j8.m3887g(j10, abstractC1589i7) != AbstractC1600j8.m3887g(j10, obj)) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 6:
                    if (!m4049u(abstractC1589i7, obj, i6) || AbstractC1600j8.m3886f(j10, abstractC1589i7) != AbstractC1600j8.m3886f(j10, obj)) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 7:
                    if (m4049u(abstractC1589i7, obj, i6)) {
                        AbstractC1590i8 abstractC1590i10 = AbstractC1600j8.f5374c;
                        if (abstractC1590i10.mo3831g(j10, abstractC1589i7) == abstractC1590i10.mo3831g(j10, obj)) {
                            continue;
                            i6 += 3;
                            break;
                        }
                    }
                    return false;
                case 8:
                    if (!m4049u(abstractC1589i7, obj, i6) || !AbstractC1530c8.m3763d(AbstractC1600j8.m3889i(j10, abstractC1589i7), AbstractC1600j8.m3889i(j10, obj))) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 9:
                    if (!m4049u(abstractC1589i7, obj, i6) || !AbstractC1530c8.m3763d(AbstractC1600j8.m3889i(j10, abstractC1589i7), AbstractC1600j8.m3889i(j10, obj))) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 10:
                    if (!m4049u(abstractC1589i7, obj, i6) || !AbstractC1530c8.m3763d(AbstractC1600j8.m3889i(j10, abstractC1589i7), AbstractC1600j8.m3889i(j10, obj))) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 11:
                    if (!m4049u(abstractC1589i7, obj, i6) || AbstractC1600j8.m3886f(j10, abstractC1589i7) != AbstractC1600j8.m3886f(j10, obj)) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 12:
                    if (!m4049u(abstractC1589i7, obj, i6) || AbstractC1600j8.m3886f(j10, abstractC1589i7) != AbstractC1600j8.m3886f(j10, obj)) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 13:
                    if (!m4049u(abstractC1589i7, obj, i6) || AbstractC1600j8.m3886f(j10, abstractC1589i7) != AbstractC1600j8.m3886f(j10, obj)) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 14:
                    if (!m4049u(abstractC1589i7, obj, i6) || AbstractC1600j8.m3887g(j10, abstractC1589i7) != AbstractC1600j8.m3887g(j10, obj)) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 15:
                    if (!m4049u(abstractC1589i7, obj, i6) || AbstractC1600j8.m3886f(j10, abstractC1589i7) != AbstractC1600j8.m3886f(j10, obj)) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 16:
                    if (!m4049u(abstractC1589i7, obj, i6) || AbstractC1600j8.m3887g(j10, abstractC1589i7) != AbstractC1600j8.m3887g(j10, obj)) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 17:
                    if (!m4049u(abstractC1589i7, obj, i6) || !AbstractC1530c8.m3763d(AbstractC1600j8.m3889i(j10, abstractC1589i7), AbstractC1600j8.m3889i(j10, obj))) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case TsExtractor.TS_STREAM_TYPE_H265:
                case 37:
                case FlacConstants.STREAM_INFO_BLOCK_SIZE:
                case NalUnitUtil.H265_NAL_UNIT_TYPE_PREFIX_SEI:
                case NalUnitUtil.H265_NAL_UNIT_TYPE_SUFFIX_SEI:
                case BuildConfig.VERSION_CODE:
                case AacUtil.AUDIO_OBJECT_TYPE_AAC_XHE:
                case 43:
                case 44:
                case TsExtractor.TS_STREAM_TYPE_MHAS:
                case 46:
                case 47:
                case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                case Opcodes.V1_5:
                    zM3763d = AbstractC1530c8.m3763d(AbstractC1600j8.m3889i(j10, abstractC1589i7), AbstractC1600j8.m3889i(j10, obj));
                    break;
                case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                    zM3763d = AbstractC1530c8.m3763d(AbstractC1600j8.m3889i(j10, abstractC1589i7), AbstractC1600j8.m3889i(j10, obj));
                    break;
                case 51:
                case 52:
                case 53:
                case Opcodes.ISTORE:
                case Opcodes.LSTORE:
                case Opcodes.FSTORE:
                case Opcodes.DSTORE:
                case Opcodes.ASTORE:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32:
                case 68:
                    long j11 = iArr[i6 + 2] & 1048575;
                    if (AbstractC1600j8.m3886f(j11, abstractC1589i7) != AbstractC1600j8.m3886f(j11, obj) || !AbstractC1530c8.m3763d(AbstractC1600j8.m3889i(j10, abstractC1589i7), AbstractC1600j8.m3889i(j10, obj))) {
                        return false;
                    }
                    continue;
                    i6 += 3;
                    break;
                    break;
                default:
                    continue;
                    i6 += 3;
                    break;
            }
            if (!zM3763d) {
                return false;
            }
            i6 += 3;
        }
    }

    @Override
    public final void mo3738d(Object obj) {
        if (!m4037i(obj)) {
            return;
        }
        int i6 = 0;
        if (obj instanceof AbstractC1589i7) {
            AbstractC1589i7 abstractC1589i7 = (AbstractC1589i7) obj;
            abstractC1589i7.m3868f();
            abstractC1589i7.zza = 0;
            abstractC1589i7.m3867d();
        }
        while (true) {
            int[] iArr = this.f5708a;
            if (i6 >= iArr.length) {
                this.f5713f.getClass();
                C1661q2.m3974b(obj);
                return;
            }
            int iM4044n = m4044n(i6);
            int i10 = 1048575 & iM4044n;
            int iM4040m = m4040m(iM4044n);
            long j10 = i10;
            if (iM4040m != 9) {
                if (iM4040m != 60 && iM4040m != 68) {
                    switch (iM4040m) {
                        case 17:
                            if (m4050v(i6, obj)) {
                                m4045p(i6).mo3738d(f5707h.getObject(obj, j10));
                            }
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case TsExtractor.TS_STREAM_TYPE_H265:
                        case 37:
                        case FlacConstants.STREAM_INFO_BLOCK_SIZE:
                        case NalUnitUtil.H265_NAL_UNIT_TYPE_PREFIX_SEI:
                        case NalUnitUtil.H265_NAL_UNIT_TYPE_SUFFIX_SEI:
                        case BuildConfig.VERSION_CODE:
                        case AacUtil.AUDIO_OBJECT_TYPE_AAC_XHE:
                        case 43:
                        case 44:
                        case TsExtractor.TS_STREAM_TYPE_MHAS:
                        case 46:
                        case 47:
                        case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                        case Opcodes.V1_5:
                            ((AbstractC1737y6) ((InterfaceC1629m7) AbstractC1600j8.m3889i(j10, obj))).m4059d();
                            break;
                        case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                            Object object = f5707h.getObject(obj, j10);
                            if (object != null) {
                                AbstractC0004e.m3C(object);
                                throw null;
                            }
                            break;
                            break;
                    }
                } else if (m4043j(iArr[i6], i6, obj)) {
                    m4045p(i6).mo3738d(f5707h.getObject(obj, j10));
                }
            } else if (m4050v(i6, obj)) {
                m4045p(i6).mo3738d(f5707h.getObject(obj, j10));
            }
            i6 += 3;
        }
    }

    @Override
    public final int mo3739e(AbstractC1589i7 abstractC1589i7) {
        int i6;
        int i10;
        int i11;
        int iM3789L;
        int iM3790t;
        int iM3789L2;
        int iMo3734e;
        int iM3789L3;
        int iM3771l;
        int iM3789L4;
        int size;
        int iM3775p;
        int iM3789L5;
        int iM3789L6;
        int iM3789L7;
        int iM3786I;
        Unsafe unsafe = f5707h;
        int i12 = 1048575;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        int iM12f = 0;
        while (true) {
            int[] iArr = this.f5708a;
            if (i15 >= iArr.length) {
                return abstractC1589i7.zzc.m3813a() + iM12f;
            }
            int iM4044n = m4044n(i15);
            int iM4040m = m4040m(iM4044n);
            int i16 = iArr[i15];
            int i17 = iArr[i15 + 2];
            int i18 = i17 & i12;
            if (iM4040m <= 17) {
                if (i18 != i13) {
                    i14 = i18 == i12 ? 0 : unsafe.getInt(abstractC1589i7, i18);
                    i13 = i18;
                }
                i6 = i13;
                i10 = i14;
                i11 = 1 << (i17 >>> 20);
            } else {
                i6 = i13;
                i10 = i14;
                i11 = 0;
            }
            int i19 = iM4044n & i12;
            if (iM4040m >= EnumC1569g7.f5324b.m3824a()) {
                EnumC1569g7.f5325c.getClass();
            }
            long j10 = i19;
            switch (iM4040m) {
                case 0:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        iM12f = AbstractC0004e.m12f(i16 << 3, 8, iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 1:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        iM12f = AbstractC0004e.m12f(i16 << 3, 4, iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 2:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        long j11 = unsafe.getLong(abstractC1589i7, j10);
                        iM3789L = C1539d7.m3789L(i16 << 3);
                        iM3790t = C1539d7.m3790t(j11);
                        iM12f += iM3790t + iM3789L;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 3:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        long j12 = unsafe.getLong(abstractC1589i7, j10);
                        iM3789L = C1539d7.m3789L(i16 << 3);
                        iM3790t = C1539d7.m3790t(j12);
                        iM12f += iM3790t + iM3789L;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 4:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        long j13 = unsafe.getInt(abstractC1589i7, j10);
                        iM3789L = C1539d7.m3789L(i16 << 3);
                        iM3790t = C1539d7.m3790t(j13);
                        iM12f += iM3790t + iM3789L;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 5:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        iM12f = AbstractC0004e.m12f(i16 << 3, 8, iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 6:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        iM12f = AbstractC0004e.m12f(i16 << 3, 4, iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 7:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        iM12f = AbstractC0004e.m12f(i16 << 3, 1, iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 8:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        int i20 = i16 << 3;
                        Object object = unsafe.getObject(abstractC1589i7, j10);
                        if (object instanceof C1529c7) {
                            iM3789L2 = C1539d7.m3789L(i20);
                            iMo3734e = ((C1529c7) object).mo3734e();
                            iM3789L3 = C1539d7.m3789L(iMo3734e);
                            iM12f += iM3789L3 + iMo3734e + iM3789L2;
                        } else {
                            iM3789L = C1539d7.m3789L(i20);
                            iM3790t = C1539d7.m3788K((String) object);
                            iM12f += iM3790t + iM3789L;
                        }
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 9:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        iM3771l = AbstractC1530c8.m3771l(i16, unsafe.getObject(abstractC1589i7, j10), m4045p(i15));
                        iM12f += iM3771l;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 10:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        C1529c7 c1529c7 = (C1529c7) unsafe.getObject(abstractC1589i7, j10);
                        iM3789L2 = C1539d7.m3789L(i16 << 3);
                        iMo3734e = c1529c7.mo3734e();
                        iM3789L3 = C1539d7.m3789L(iMo3734e);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 11:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        iM12f = AbstractC0004e.m12f(unsafe.getInt(abstractC1589i7, j10), C1539d7.m3789L(i16 << 3), iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 12:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        long j14 = unsafe.getInt(abstractC1589i7, j10);
                        iM3789L = C1539d7.m3789L(i16 << 3);
                        iM3790t = C1539d7.m3790t(j14);
                        iM12f += iM3790t + iM3789L;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 13:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        iM12f = AbstractC0004e.m12f(i16 << 3, 4, iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 14:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        iM12f = AbstractC0004e.m12f(i16 << 3, 8, iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 15:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        int i21 = unsafe.getInt(abstractC1589i7, j10);
                        iM12f = AbstractC0004e.m12f((i21 >> 31) ^ (i21 + i21), C1539d7.m3789L(i16 << 3), iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 16:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        long j15 = unsafe.getLong(abstractC1589i7, j10);
                        iM3789L = C1539d7.m3789L(i16 << 3);
                        iM3790t = C1539d7.m3790t((j15 >> 63) ^ (j15 + j15));
                        iM12f += iM3790t + iM3789L;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 17:
                    if (m4051w(abstractC1589i7, i15, i6, i10, i11)) {
                        iM3771l = C1539d7.m3786I(i16, (AbstractC1728x6) unsafe.getObject(abstractC1589i7, j10), m4045p(i15));
                        iM12f += iM3771l;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 18:
                    iM3771l = AbstractC1530c8.m3767h(i16, (List) unsafe.getObject(abstractC1589i7, j10));
                    iM12f += iM3771l;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 19:
                    iM3771l = AbstractC1530c8.m3765f(i16, (List) unsafe.getObject(abstractC1589i7, j10));
                    iM12f += iM3771l;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(abstractC1589i7, j10);
                    C1661q2 c1661q2 = AbstractC1530c8.f5236a;
                    if (list.size() == 0) {
                        iM3789L4 = 0;
                    } else {
                        iM3789L4 = (C1539d7.m3789L(i16 << 3) * list.size()) + AbstractC1530c8.m3770k(list);
                    }
                    iM12f += iM3789L4;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(abstractC1589i7, j10);
                    C1661q2 c1661q3 = AbstractC1530c8.f5236a;
                    size = list2.size();
                    if (size == 0) {
                        iM3789L6 = 0;
                    } else {
                        iM3775p = AbstractC1530c8.m3775p(list2);
                        iM3789L5 = C1539d7.m3789L(i16 << 3);
                        iM3789L6 = (iM3789L5 * size) + iM3775p;
                    }
                    iM12f += iM3789L6;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(abstractC1589i7, j10);
                    C1661q2 c1661q4 = AbstractC1530c8.f5236a;
                    size = list3.size();
                    if (size == 0) {
                        iM3789L6 = 0;
                    } else {
                        iM3775p = AbstractC1530c8.m3769j(list3);
                        iM3789L5 = C1539d7.m3789L(i16 << 3);
                        iM3789L6 = (iM3789L5 * size) + iM3775p;
                    }
                    iM12f += iM3789L6;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 23:
                    iM3771l = AbstractC1530c8.m3767h(i16, (List) unsafe.getObject(abstractC1589i7, j10));
                    iM12f += iM3771l;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 24:
                    iM3771l = AbstractC1530c8.m3765f(i16, (List) unsafe.getObject(abstractC1589i7, j10));
                    iM12f += iM3771l;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(abstractC1589i7, j10);
                    C1661q2 c1661q5 = AbstractC1530c8.f5236a;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iM3789L4 = 0;
                    } else {
                        iM3789L4 = (C1539d7.m3789L(i16 << 3) + 1) * size2;
                    }
                    iM12f += iM3789L4;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(abstractC1589i7, j10);
                    C1661q2 c1661q6 = AbstractC1530c8.f5236a;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iM3789L6 = 0;
                    } else {
                        iM3789L6 = C1539d7.m3789L(i16 << 3) * size3;
                        for (int i22 = 0; i22 < size3; i22++) {
                            Object obj = list5.get(i22);
                            if (obj instanceof C1529c7) {
                                int iMo3734e2 = ((C1529c7) obj).mo3734e();
                                iM3789L6 = AbstractC0004e.m12f(iMo3734e2, iMo3734e2, iM3789L6);
                            } else {
                                iM3789L6 = C1539d7.m3788K((String) obj) + iM3789L6;
                            }
                        }
                    }
                    iM12f += iM3789L6;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(abstractC1589i7, j10);
                    InterfaceC1520b8 interfaceC1520b8M4045p = m4045p(i15);
                    C1661q2 c1661q7 = AbstractC1530c8.f5236a;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iM3789L7 = 0;
                    } else {
                        iM3789L7 = C1539d7.m3789L(i16 << 3) * size4;
                        for (int i23 = 0; i23 < size4; i23++) {
                            iM3789L7 += C1539d7.m3787J((AbstractC1728x6) list6.get(i23), interfaceC1520b8M4045p);
                        }
                    }
                    iM12f += iM3789L7;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(abstractC1589i7, j10);
                    C1661q2 c1661q8 = AbstractC1530c8.f5236a;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iM3789L6 = 0;
                    } else {
                        iM3789L6 = C1539d7.m3789L(i16 << 3) * size5;
                        for (int i24 = 0; i24 < list7.size(); i24++) {
                            int iMo3734e3 = ((C1529c7) list7.get(i24)).mo3734e();
                            iM3789L6 = AbstractC0004e.m12f(iMo3734e3, iMo3734e3, iM3789L6);
                        }
                    }
                    iM12f += iM3789L6;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(abstractC1589i7, j10);
                    C1661q2 c1661q9 = AbstractC1530c8.f5236a;
                    size = list8.size();
                    if (size == 0) {
                        iM3789L6 = 0;
                    } else {
                        iM3775p = AbstractC1530c8.m3774o(list8);
                        iM3789L5 = C1539d7.m3789L(i16 << 3);
                        iM3789L6 = (iM3789L5 * size) + iM3775p;
                    }
                    iM12f += iM3789L6;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(abstractC1589i7, j10);
                    C1661q2 c1661q10 = AbstractC1530c8.f5236a;
                    size = list9.size();
                    if (size == 0) {
                        iM3789L6 = 0;
                    } else {
                        iM3775p = AbstractC1530c8.m3764e(list9);
                        iM3789L5 = C1539d7.m3789L(i16 << 3);
                        iM3789L6 = (iM3789L5 * size) + iM3775p;
                    }
                    iM12f += iM3789L6;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 31:
                    iM3771l = AbstractC1530c8.m3765f(i16, (List) unsafe.getObject(abstractC1589i7, j10));
                    iM12f += iM3771l;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 32:
                    iM3771l = AbstractC1530c8.m3767h(i16, (List) unsafe.getObject(abstractC1589i7, j10));
                    iM12f += iM3771l;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(abstractC1589i7, j10);
                    C1661q2 c1661q11 = AbstractC1530c8.f5236a;
                    size = list10.size();
                    if (size == 0) {
                        iM3789L6 = 0;
                    } else {
                        iM3775p = AbstractC1530c8.m3772m(list10);
                        iM3789L5 = C1539d7.m3789L(i16 << 3);
                        iM3789L6 = (iM3789L5 * size) + iM3775p;
                    }
                    iM12f += iM3789L6;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(abstractC1589i7, j10);
                    C1661q2 c1661q12 = AbstractC1530c8.f5236a;
                    size = list11.size();
                    if (size == 0) {
                        iM3789L6 = 0;
                    } else {
                        iM3775p = AbstractC1530c8.m3773n(list11);
                        iM3789L5 = C1539d7.m3789L(i16 << 3);
                        iM3789L6 = (iM3789L5 * size) + iM3775p;
                    }
                    iM12f += iM3789L6;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 35:
                    iM3789L2 = AbstractC1530c8.m3768i((List) unsafe.getObject(abstractC1589i7, j10));
                    if (iM3789L2 > 0) {
                        iMo3734e = C1539d7.m3789L(i16 << 3);
                        iM3789L3 = C1539d7.m3789L(iM3789L2);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case TsExtractor.TS_STREAM_TYPE_H265:
                    iM3789L2 = AbstractC1530c8.m3766g((List) unsafe.getObject(abstractC1589i7, j10));
                    if (iM3789L2 > 0) {
                        iMo3734e = C1539d7.m3789L(i16 << 3);
                        iM3789L3 = C1539d7.m3789L(iM3789L2);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 37:
                    iM3789L2 = AbstractC1530c8.m3770k((List) unsafe.getObject(abstractC1589i7, j10));
                    if (iM3789L2 > 0) {
                        iMo3734e = C1539d7.m3789L(i16 << 3);
                        iM3789L3 = C1539d7.m3789L(iM3789L2);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case FlacConstants.STREAM_INFO_BLOCK_SIZE:
                    iM3789L2 = AbstractC1530c8.m3775p((List) unsafe.getObject(abstractC1589i7, j10));
                    if (iM3789L2 > 0) {
                        iMo3734e = C1539d7.m3789L(i16 << 3);
                        iM3789L3 = C1539d7.m3789L(iM3789L2);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case NalUnitUtil.H265_NAL_UNIT_TYPE_PREFIX_SEI:
                    iM3789L2 = AbstractC1530c8.m3769j((List) unsafe.getObject(abstractC1589i7, j10));
                    if (iM3789L2 > 0) {
                        iMo3734e = C1539d7.m3789L(i16 << 3);
                        iM3789L3 = C1539d7.m3789L(iM3789L2);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case NalUnitUtil.H265_NAL_UNIT_TYPE_SUFFIX_SEI:
                    iM3789L2 = AbstractC1530c8.m3768i((List) unsafe.getObject(abstractC1589i7, j10));
                    if (iM3789L2 > 0) {
                        iMo3734e = C1539d7.m3789L(i16 << 3);
                        iM3789L3 = C1539d7.m3789L(iM3789L2);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case BuildConfig.VERSION_CODE:
                    iM3789L2 = AbstractC1530c8.m3766g((List) unsafe.getObject(abstractC1589i7, j10));
                    if (iM3789L2 > 0) {
                        iMo3734e = C1539d7.m3789L(i16 << 3);
                        iM3789L3 = C1539d7.m3789L(iM3789L2);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case AacUtil.AUDIO_OBJECT_TYPE_AAC_XHE:
                    List list12 = (List) unsafe.getObject(abstractC1589i7, j10);
                    C1661q2 c1661q13 = AbstractC1530c8.f5236a;
                    iM3789L2 = list12.size();
                    if (iM3789L2 > 0) {
                        iMo3734e = C1539d7.m3789L(i16 << 3);
                        iM3789L3 = C1539d7.m3789L(iM3789L2);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 43:
                    iM3789L2 = AbstractC1530c8.m3774o((List) unsafe.getObject(abstractC1589i7, j10));
                    if (iM3789L2 > 0) {
                        iMo3734e = C1539d7.m3789L(i16 << 3);
                        iM3789L3 = C1539d7.m3789L(iM3789L2);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 44:
                    iM3789L2 = AbstractC1530c8.m3764e((List) unsafe.getObject(abstractC1589i7, j10));
                    if (iM3789L2 > 0) {
                        iMo3734e = C1539d7.m3789L(i16 << 3);
                        iM3789L3 = C1539d7.m3789L(iM3789L2);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case TsExtractor.TS_STREAM_TYPE_MHAS:
                    iM3789L2 = AbstractC1530c8.m3766g((List) unsafe.getObject(abstractC1589i7, j10));
                    if (iM3789L2 > 0) {
                        iMo3734e = C1539d7.m3789L(i16 << 3);
                        iM3789L3 = C1539d7.m3789L(iM3789L2);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 46:
                    iM3789L2 = AbstractC1530c8.m3768i((List) unsafe.getObject(abstractC1589i7, j10));
                    if (iM3789L2 > 0) {
                        iMo3734e = C1539d7.m3789L(i16 << 3);
                        iM3789L3 = C1539d7.m3789L(iM3789L2);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 47:
                    iM3789L2 = AbstractC1530c8.m3772m((List) unsafe.getObject(abstractC1589i7, j10));
                    if (iM3789L2 > 0) {
                        iMo3734e = C1539d7.m3789L(i16 << 3);
                        iM3789L3 = C1539d7.m3789L(iM3789L2);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                    iM3789L2 = AbstractC1530c8.m3773n((List) unsafe.getObject(abstractC1589i7, j10));
                    if (iM3789L2 > 0) {
                        iMo3734e = C1539d7.m3789L(i16 << 3);
                        iM3789L3 = C1539d7.m3789L(iM3789L2);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case Opcodes.V1_5:
                    List list13 = (List) unsafe.getObject(abstractC1589i7, j10);
                    InterfaceC1520b8 interfaceC1520b8M4045p2 = m4045p(i15);
                    C1661q2 c1661q14 = AbstractC1530c8.f5236a;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iM3786I = 0;
                    } else {
                        iM3786I = 0;
                        for (int i25 = 0; i25 < size6; i25++) {
                            iM3786I += C1539d7.m3786I(i16, (AbstractC1728x6) list13.get(i25), interfaceC1520b8M4045p2);
                        }
                    }
                    iM12f += iM3786I;
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                    Object object2 = unsafe.getObject(abstractC1589i7, j10);
                    int i26 = i15 / 3;
                    Object obj2 = this.f5709b[i26 + i26];
                    AbstractC2460q.m5499m(object2);
                    AbstractC2460q.m5499m(obj2);
                    throw null;
                case 51:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        iM12f = AbstractC0004e.m12f(i16 << 3, 8, iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 52:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        iM12f = AbstractC0004e.m12f(i16 << 3, 4, iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 53:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        long jM4041o = m4041o(j10, abstractC1589i7);
                        iM3789L = C1539d7.m3789L(i16 << 3);
                        iM3790t = C1539d7.m3790t(jM4041o);
                        iM12f += iM3790t + iM3789L;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case Opcodes.ISTORE:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        long jM4041o2 = m4041o(j10, abstractC1589i7);
                        iM3789L = C1539d7.m3789L(i16 << 3);
                        iM3790t = C1539d7.m3790t(jM4041o2);
                        iM12f += iM3790t + iM3789L;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case Opcodes.LSTORE:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        long jM4039l = m4039l(j10, abstractC1589i7);
                        iM3789L = C1539d7.m3789L(i16 << 3);
                        iM3790t = C1539d7.m3790t(jM4039l);
                        iM12f += iM3790t + iM3789L;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case Opcodes.FSTORE:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        iM12f = AbstractC0004e.m12f(i16 << 3, 8, iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case Opcodes.DSTORE:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        iM12f = AbstractC0004e.m12f(i16 << 3, 4, iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case Opcodes.ASTORE:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        iM12f = AbstractC0004e.m12f(i16 << 3, 1, iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 59:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        int i27 = i16 << 3;
                        Object object3 = unsafe.getObject(abstractC1589i7, j10);
                        if (object3 instanceof C1529c7) {
                            iM3789L2 = C1539d7.m3789L(i27);
                            iMo3734e = ((C1529c7) object3).mo3734e();
                            iM3789L3 = C1539d7.m3789L(iMo3734e);
                            iM12f += iM3789L3 + iMo3734e + iM3789L2;
                        } else {
                            iM3789L = C1539d7.m3789L(i27);
                            iM3790t = C1539d7.m3788K((String) object3);
                            iM12f += iM3790t + iM3789L;
                        }
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 60:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        iM3771l = AbstractC1530c8.m3771l(i16, unsafe.getObject(abstractC1589i7, j10), m4045p(i15));
                        iM12f += iM3771l;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 61:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        C1529c7 c1529c8 = (C1529c7) unsafe.getObject(abstractC1589i7, j10);
                        iM3789L2 = C1539d7.m3789L(i16 << 3);
                        iMo3734e = c1529c8.mo3734e();
                        iM3789L3 = C1539d7.m3789L(iMo3734e);
                        iM12f += iM3789L3 + iMo3734e + iM3789L2;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 62:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        iM12f = AbstractC0004e.m12f(m4039l(j10, abstractC1589i7), C1539d7.m3789L(i16 << 3), iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 63:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        long jM4039l2 = m4039l(j10, abstractC1589i7);
                        iM3789L = C1539d7.m3789L(i16 << 3);
                        iM3790t = C1539d7.m3790t(jM4039l2);
                        iM12f += iM3790t + iM3789L;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 64:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        iM12f = AbstractC0004e.m12f(i16 << 3, 4, iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 65:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        iM12f = AbstractC0004e.m12f(i16 << 3, 8, iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 66:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        int iM4039l = m4039l(j10, abstractC1589i7);
                        iM12f = AbstractC0004e.m12f((iM4039l >> 31) ^ (iM4039l + iM4039l), C1539d7.m3789L(i16 << 3), iM12f);
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        long jM4041o3 = m4041o(j10, abstractC1589i7);
                        iM3789L = C1539d7.m3789L(i16 << 3);
                        iM3790t = C1539d7.m3790t((jM4041o3 >> 63) ^ (jM4041o3 + jM4041o3));
                        iM12f += iM3790t + iM3789L;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                case 68:
                    if (m4043j(i16, i15, abstractC1589i7)) {
                        iM3771l = C1539d7.m3786I(i16, (AbstractC1728x6) unsafe.getObject(abstractC1589i7, j10), m4045p(i15));
                        iM12f += iM3771l;
                    }
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
                default:
                    i15 += 3;
                    i13 = i6;
                    i14 = i10;
                    i12 = 1048575;
                    break;
            }
        }
    }

    @Override
    public final boolean mo3740f(Object obj) {
        int i6;
        int i10;
        List list;
        InterfaceC1520b8 interfaceC1520b8M4045p;
        int i11;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.f5712e) {
            int i15 = this.f5711d[i14];
            int[] iArr = this.f5708a;
            int i16 = iArr[i15];
            int iM4044n = m4044n(i15);
            int i17 = iArr[i15 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i12) {
                if (i18 != 1048575) {
                    i13 = f5707h.getInt(obj, i18);
                }
                i10 = i13;
                i6 = i18;
            } else {
                i6 = i12;
                i10 = i13;
            }
            if ((268435456 & iM4044n) != 0 && !m4051w(obj, i15, i6, i10, i19)) {
                return false;
            }
            int iM4040m = m4040m(iM4044n);
            if (iM4040m == 9 || iM4040m == 17) {
                if (m4051w(obj, i15, i6, i10, i19) && !m4045p(i15).mo3740f(AbstractC1600j8.m3889i(iM4044n & 1048575, obj))) {
                    return false;
                }
            } else if (iM4040m == 27) {
                list = (List) AbstractC1600j8.m3889i(iM4044n & 1048575, obj);
                if (list.isEmpty()) {
                    continue;
                } else {
                    interfaceC1520b8M4045p = m4045p(i15);
                    for (i11 = 0; i11 < list.size(); i11++) {
                        if (!interfaceC1520b8M4045p.mo3740f(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (iM4040m == 60 || iM4040m == 68) {
                if (m4043j(i16, i15, obj) && !m4045p(i15).mo3740f(AbstractC1600j8.m3889i(iM4044n & 1048575, obj))) {
                    return false;
                }
            } else if (iM4040m == 49) {
                list = (List) AbstractC1600j8.m3889i(iM4044n & 1048575, obj);
                if (list.isEmpty()) {
                    interfaceC1520b8M4045p = m4045p(i15);
                    while (i11 < list.size()) {
                        if (!interfaceC1520b8M4045p.mo3740f(list.get(i11))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iM4040m == 50) {
                AbstractC2460q.m5499m(AbstractC1600j8.m3889i(iM4044n & 1048575, obj));
                throw null;
            }
            i14++;
            i12 = i6;
            i13 = i10;
        }
        return true;
    }

    @Override
    public final void mo3741g(Object obj, Object obj2) {
        if (!m4037i(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
        obj2.getClass();
        int i6 = 0;
        while (true) {
            int[] iArr = this.f5708a;
            if (i6 >= iArr.length) {
                AbstractC1530c8.m3776q(obj, obj2);
                return;
            }
            int iM4044n = m4044n(i6);
            int i10 = iM4044n & 1048575;
            int iM4040m = m4040m(iM4044n);
            int i11 = iArr[i6];
            long j10 = i10;
            switch (iM4040m) {
                case 0:
                    if (m4050v(i6, obj2)) {
                        AbstractC1590i8 abstractC1590i8 = AbstractC1600j8.f5374c;
                        abstractC1590i8.mo3829e(obj, j10, abstractC1590i8.mo3825a(j10, obj2));
                        m4048t(i6, obj);
                    }
                    break;
                case 1:
                    if (m4050v(i6, obj2)) {
                        AbstractC1590i8 abstractC1590i9 = AbstractC1600j8.f5374c;
                        abstractC1590i9.mo3830f(obj, j10, abstractC1590i9.mo3826b(j10, obj2));
                        m4048t(i6, obj);
                    }
                    break;
                case 2:
                    if (m4050v(i6, obj2)) {
                        AbstractC1600j8.m3892l(obj, j10, AbstractC1600j8.m3887g(j10, obj2));
                        m4048t(i6, obj);
                    }
                    break;
                case 3:
                    if (m4050v(i6, obj2)) {
                        AbstractC1600j8.m3892l(obj, j10, AbstractC1600j8.m3887g(j10, obj2));
                        m4048t(i6, obj);
                    }
                    break;
                case 4:
                    if (m4050v(i6, obj2)) {
                        AbstractC1600j8.m3891k(AbstractC1600j8.m3886f(j10, obj2), j10, obj);
                        m4048t(i6, obj);
                    }
                    break;
                case 5:
                    if (m4050v(i6, obj2)) {
                        AbstractC1600j8.m3892l(obj, j10, AbstractC1600j8.m3887g(j10, obj2));
                        m4048t(i6, obj);
                    }
                    break;
                case 6:
                    if (m4050v(i6, obj2)) {
                        AbstractC1600j8.m3891k(AbstractC1600j8.m3886f(j10, obj2), j10, obj);
                        m4048t(i6, obj);
                    }
                    break;
                case 7:
                    if (m4050v(i6, obj2)) {
                        AbstractC1590i8 abstractC1590i10 = AbstractC1600j8.f5374c;
                        abstractC1590i10.mo3827c(obj, j10, abstractC1590i10.mo3831g(j10, obj2));
                        m4048t(i6, obj);
                    }
                    break;
                case 8:
                    if (m4050v(i6, obj2)) {
                        AbstractC1600j8.m3893m(j10, obj, AbstractC1600j8.m3889i(j10, obj2));
                        m4048t(i6, obj);
                    }
                    break;
                case 9:
                    m4046r(obj, i6, obj2);
                    break;
                case 10:
                    if (m4050v(i6, obj2)) {
                        AbstractC1600j8.m3893m(j10, obj, AbstractC1600j8.m3889i(j10, obj2));
                        m4048t(i6, obj);
                    }
                    break;
                case 11:
                    if (m4050v(i6, obj2)) {
                        AbstractC1600j8.m3891k(AbstractC1600j8.m3886f(j10, obj2), j10, obj);
                        m4048t(i6, obj);
                    }
                    break;
                case 12:
                    if (m4050v(i6, obj2)) {
                        AbstractC1600j8.m3891k(AbstractC1600j8.m3886f(j10, obj2), j10, obj);
                        m4048t(i6, obj);
                    }
                    break;
                case 13:
                    if (m4050v(i6, obj2)) {
                        AbstractC1600j8.m3891k(AbstractC1600j8.m3886f(j10, obj2), j10, obj);
                        m4048t(i6, obj);
                    }
                    break;
                case 14:
                    if (m4050v(i6, obj2)) {
                        AbstractC1600j8.m3892l(obj, j10, AbstractC1600j8.m3887g(j10, obj2));
                        m4048t(i6, obj);
                    }
                    break;
                case 15:
                    if (m4050v(i6, obj2)) {
                        AbstractC1600j8.m3891k(AbstractC1600j8.m3886f(j10, obj2), j10, obj);
                        m4048t(i6, obj);
                    }
                    break;
                case 16:
                    if (m4050v(i6, obj2)) {
                        AbstractC1600j8.m3892l(obj, j10, AbstractC1600j8.m3887g(j10, obj2));
                        m4048t(i6, obj);
                    }
                    break;
                case 17:
                    m4046r(obj, i6, obj2);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case TsExtractor.TS_STREAM_TYPE_H265:
                case 37:
                case FlacConstants.STREAM_INFO_BLOCK_SIZE:
                case NalUnitUtil.H265_NAL_UNIT_TYPE_PREFIX_SEI:
                case NalUnitUtil.H265_NAL_UNIT_TYPE_SUFFIX_SEI:
                case BuildConfig.VERSION_CODE:
                case AacUtil.AUDIO_OBJECT_TYPE_AAC_XHE:
                case 43:
                case 44:
                case TsExtractor.TS_STREAM_TYPE_MHAS:
                case 46:
                case 47:
                case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                case Opcodes.V1_5:
                    InterfaceC1629m7 interfaceC1629m7Mo3876a = (InterfaceC1629m7) AbstractC1600j8.m3889i(j10, obj);
                    InterfaceC1629m7 interfaceC1629m7 = (InterfaceC1629m7) AbstractC1600j8.m3889i(j10, obj2);
                    int size = interfaceC1629m7Mo3876a.size();
                    int size2 = interfaceC1629m7.size();
                    if (size > 0 && size2 > 0) {
                        if (!((AbstractC1737y6) interfaceC1629m7Mo3876a).f5737a) {
                            interfaceC1629m7Mo3876a = interfaceC1629m7Mo3876a.mo3876a(size2 + size);
                        }
                        interfaceC1629m7Mo3876a.addAll(interfaceC1629m7);
                    }
                    if (size > 0) {
                        interfaceC1629m7 = interfaceC1629m7Mo3876a;
                    }
                    AbstractC1600j8.m3893m(j10, obj, interfaceC1629m7);
                    break;
                case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                    C1661q2 c1661q2 = AbstractC1530c8.f5236a;
                    Object objM3889i = AbstractC1600j8.m3889i(j10, obj);
                    Object objM3889i2 = AbstractC1600j8.m3889i(j10, obj2);
                    if (objM3889i != null) {
                        throw new ClassCastException();
                    }
                    objM3889i2.getClass();
                    throw new ClassCastException();
                case 51:
                case 52:
                case 53:
                case Opcodes.ISTORE:
                case Opcodes.LSTORE:
                case Opcodes.FSTORE:
                case Opcodes.DSTORE:
                case Opcodes.ASTORE:
                case 59:
                    if (m4043j(i11, i6, obj2)) {
                        AbstractC1600j8.m3893m(j10, obj, AbstractC1600j8.m3889i(j10, obj2));
                        AbstractC1600j8.m3891k(i11, iArr[i6 + 2] & 1048575, obj);
                    }
                    break;
                case 60:
                    m4047s(obj, i6, obj2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32:
                    if (m4043j(i11, i6, obj2)) {
                        AbstractC1600j8.m3893m(j10, obj, AbstractC1600j8.m3889i(j10, obj2));
                        AbstractC1600j8.m3891k(i11, iArr[i6 + 2] & 1048575, obj);
                    }
                    break;
                case 68:
                    m4047s(obj, i6, obj2);
                    break;
            }
            i6 += 3;
        }
    }

    @Override
    public final int mo3742h(AbstractC1589i7 abstractC1589i7) {
        int i6;
        long jDoubleToLongBits;
        int i10;
        int iFloatToIntBits;
        int i11;
        int i12;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int[] iArr = this.f5708a;
            if (i13 >= iArr.length) {
                abstractC1589i7.zzc.getClass();
                return (i14 * 53) + 506991;
            }
            int iM4044n = m4044n(i13);
            int i15 = 1048575 & iM4044n;
            int iM4040m = m4040m(iM4044n);
            int i16 = iArr[i13];
            long j10 = i15;
            int i17 = 1237;
            int iHashCode = 37;
            switch (iM4040m) {
                case 0:
                    i6 = i14 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(AbstractC1600j8.f5374c.mo3825a(j10, abstractC1589i7));
                    Charset charset = AbstractC1639n7.f5472a;
                    i14 = i6 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 1:
                    i10 = i14 * 53;
                    iFloatToIntBits = Float.floatToIntBits(AbstractC1600j8.f5374c.mo3826b(j10, abstractC1589i7));
                    i14 = iFloatToIntBits + i10;
                    break;
                case 2:
                    i6 = i14 * 53;
                    jDoubleToLongBits = AbstractC1600j8.m3887g(j10, abstractC1589i7);
                    Charset charset2 = AbstractC1639n7.f5472a;
                    i14 = i6 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 3:
                    i6 = i14 * 53;
                    jDoubleToLongBits = AbstractC1600j8.m3887g(j10, abstractC1589i7);
                    Charset charset3 = AbstractC1639n7.f5472a;
                    i14 = i6 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 4:
                    i10 = i14 * 53;
                    iFloatToIntBits = AbstractC1600j8.m3886f(j10, abstractC1589i7);
                    i14 = iFloatToIntBits + i10;
                    break;
                case 5:
                    i6 = i14 * 53;
                    jDoubleToLongBits = AbstractC1600j8.m3887g(j10, abstractC1589i7);
                    Charset charset4 = AbstractC1639n7.f5472a;
                    i14 = i6 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 6:
                    i10 = i14 * 53;
                    iFloatToIntBits = AbstractC1600j8.m3886f(j10, abstractC1589i7);
                    i14 = iFloatToIntBits + i10;
                    break;
                case 7:
                    i11 = i14 * 53;
                    boolean zMo3831g = AbstractC1600j8.f5374c.mo3831g(j10, abstractC1589i7);
                    Charset charset5 = AbstractC1639n7.f5472a;
                    if (zMo3831g) {
                        i17 = 1231;
                    }
                    i14 = i17 + i11;
                    break;
                case 8:
                    i10 = i14 * 53;
                    iFloatToIntBits = ((String) AbstractC1600j8.m3889i(j10, abstractC1589i7)).hashCode();
                    i14 = iFloatToIntBits + i10;
                    break;
                case 9:
                    i12 = i14 * 53;
                    Object objM3889i = AbstractC1600j8.m3889i(j10, abstractC1589i7);
                    if (objM3889i != null) {
                        iHashCode = objM3889i.hashCode();
                    }
                    i14 = i12 + iHashCode;
                    break;
                case 10:
                    i10 = i14 * 53;
                    iFloatToIntBits = AbstractC1600j8.m3889i(j10, abstractC1589i7).hashCode();
                    i14 = iFloatToIntBits + i10;
                    break;
                case 11:
                    i10 = i14 * 53;
                    iFloatToIntBits = AbstractC1600j8.m3886f(j10, abstractC1589i7);
                    i14 = iFloatToIntBits + i10;
                    break;
                case 12:
                    i10 = i14 * 53;
                    iFloatToIntBits = AbstractC1600j8.m3886f(j10, abstractC1589i7);
                    i14 = iFloatToIntBits + i10;
                    break;
                case 13:
                    i10 = i14 * 53;
                    iFloatToIntBits = AbstractC1600j8.m3886f(j10, abstractC1589i7);
                    i14 = iFloatToIntBits + i10;
                    break;
                case 14:
                    i6 = i14 * 53;
                    jDoubleToLongBits = AbstractC1600j8.m3887g(j10, abstractC1589i7);
                    Charset charset6 = AbstractC1639n7.f5472a;
                    i14 = i6 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 15:
                    i10 = i14 * 53;
                    iFloatToIntBits = AbstractC1600j8.m3886f(j10, abstractC1589i7);
                    i14 = iFloatToIntBits + i10;
                    break;
                case 16:
                    i6 = i14 * 53;
                    jDoubleToLongBits = AbstractC1600j8.m3887g(j10, abstractC1589i7);
                    Charset charset7 = AbstractC1639n7.f5472a;
                    i14 = i6 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 17:
                    i12 = i14 * 53;
                    Object objM3889i2 = AbstractC1600j8.m3889i(j10, abstractC1589i7);
                    if (objM3889i2 != null) {
                        iHashCode = objM3889i2.hashCode();
                    }
                    i14 = i12 + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case TsExtractor.TS_STREAM_TYPE_H265:
                case 37:
                case FlacConstants.STREAM_INFO_BLOCK_SIZE:
                case NalUnitUtil.H265_NAL_UNIT_TYPE_PREFIX_SEI:
                case NalUnitUtil.H265_NAL_UNIT_TYPE_SUFFIX_SEI:
                case BuildConfig.VERSION_CODE:
                case AacUtil.AUDIO_OBJECT_TYPE_AAC_XHE:
                case 43:
                case 44:
                case TsExtractor.TS_STREAM_TYPE_MHAS:
                case 46:
                case 47:
                case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                case Opcodes.V1_5:
                    i10 = i14 * 53;
                    iFloatToIntBits = AbstractC1600j8.m3889i(j10, abstractC1589i7).hashCode();
                    i14 = iFloatToIntBits + i10;
                    break;
                case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                    i10 = i14 * 53;
                    iFloatToIntBits = AbstractC1600j8.m3889i(j10, abstractC1589i7).hashCode();
                    i14 = iFloatToIntBits + i10;
                    break;
                case 51:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i6 = i14 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(((Double) AbstractC1600j8.m3889i(j10, abstractC1589i7)).doubleValue());
                        Charset charset8 = AbstractC1639n7.f5472a;
                        i14 = i6 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 52:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i10 = i14 * 53;
                        iFloatToIntBits = Float.floatToIntBits(((Float) AbstractC1600j8.m3889i(j10, abstractC1589i7)).floatValue());
                        i14 = iFloatToIntBits + i10;
                    }
                    break;
                case 53:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i6 = i14 * 53;
                        jDoubleToLongBits = m4041o(j10, abstractC1589i7);
                        Charset charset9 = AbstractC1639n7.f5472a;
                        i14 = i6 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case Opcodes.ISTORE:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i6 = i14 * 53;
                        jDoubleToLongBits = m4041o(j10, abstractC1589i7);
                        Charset charset10 = AbstractC1639n7.f5472a;
                        i14 = i6 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case Opcodes.LSTORE:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i10 = i14 * 53;
                        iFloatToIntBits = m4039l(j10, abstractC1589i7);
                        i14 = iFloatToIntBits + i10;
                    }
                    break;
                case Opcodes.FSTORE:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i6 = i14 * 53;
                        jDoubleToLongBits = m4041o(j10, abstractC1589i7);
                        Charset charset11 = AbstractC1639n7.f5472a;
                        i14 = i6 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case Opcodes.DSTORE:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i10 = i14 * 53;
                        iFloatToIntBits = m4039l(j10, abstractC1589i7);
                        i14 = iFloatToIntBits + i10;
                    }
                    break;
                case Opcodes.ASTORE:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i11 = i14 * 53;
                        boolean zBooleanValue = ((Boolean) AbstractC1600j8.m3889i(j10, abstractC1589i7)).booleanValue();
                        Charset charset12 = AbstractC1639n7.f5472a;
                        if (zBooleanValue) {
                            i17 = 1231;
                        }
                        i14 = i17 + i11;
                    }
                    break;
                case 59:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i10 = i14 * 53;
                        iFloatToIntBits = ((String) AbstractC1600j8.m3889i(j10, abstractC1589i7)).hashCode();
                        i14 = iFloatToIntBits + i10;
                    }
                    break;
                case 60:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i10 = i14 * 53;
                        iFloatToIntBits = AbstractC1600j8.m3889i(j10, abstractC1589i7).hashCode();
                        i14 = iFloatToIntBits + i10;
                    }
                    break;
                case 61:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i10 = i14 * 53;
                        iFloatToIntBits = AbstractC1600j8.m3889i(j10, abstractC1589i7).hashCode();
                        i14 = iFloatToIntBits + i10;
                    }
                    break;
                case 62:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i10 = i14 * 53;
                        iFloatToIntBits = m4039l(j10, abstractC1589i7);
                        i14 = iFloatToIntBits + i10;
                    }
                    break;
                case 63:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i10 = i14 * 53;
                        iFloatToIntBits = m4039l(j10, abstractC1589i7);
                        i14 = iFloatToIntBits + i10;
                    }
                    break;
                case 64:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i10 = i14 * 53;
                        iFloatToIntBits = m4039l(j10, abstractC1589i7);
                        i14 = iFloatToIntBits + i10;
                    }
                    break;
                case 65:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i6 = i14 * 53;
                        jDoubleToLongBits = m4041o(j10, abstractC1589i7);
                        Charset charset13 = AbstractC1639n7.f5472a;
                        i14 = i6 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 66:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i10 = i14 * 53;
                        iFloatToIntBits = m4039l(j10, abstractC1589i7);
                        i14 = iFloatToIntBits + i10;
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i6 = i14 * 53;
                        jDoubleToLongBits = m4041o(j10, abstractC1589i7);
                        Charset charset14 = AbstractC1639n7.f5472a;
                        i14 = i6 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 68:
                    if (m4043j(i16, i13, abstractC1589i7)) {
                        i10 = i14 * 53;
                        iFloatToIntBits = AbstractC1600j8.m3889i(j10, abstractC1589i7).hashCode();
                        i14 = iFloatToIntBits + i10;
                    }
                    break;
            }
            i13 += 3;
        }
    }

    public final boolean m4043j(int i6, int i10, Object obj) {
        return AbstractC1600j8.m3886f((long) (this.f5708a[i10 + 2] & 1048575), obj) == i6;
    }

    public final int m4044n(int i6) {
        return this.f5708a[i6 + 1];
    }

    public final InterfaceC1520b8 m4045p(int i6) {
        int i10 = i6 / 3;
        int i11 = i10 + i10;
        Object[] objArr = this.f5709b;
        InterfaceC1520b8 interfaceC1520b8 = (InterfaceC1520b8) objArr[i11];
        if (interfaceC1520b8 != null) {
            return interfaceC1520b8;
        }
        InterfaceC1520b8 interfaceC1520b8M4060a = C1738y7.f5738c.m4060a((Class) objArr[i11 + 1]);
        objArr[i11] = interfaceC1520b8M4060a;
        return interfaceC1520b8M4060a;
    }

    public final void m4046r(Object obj, int i6, Object obj2) {
        if (m4050v(i6, obj2)) {
            int iM4044n = m4044n(i6) & 1048575;
            Unsafe unsafe = f5707h;
            long j10 = iM4044n;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f5708a[i6] + " is present but null: " + obj2.toString());
            }
            InterfaceC1520b8 interfaceC1520b8M4045p = m4045p(i6);
            if (!m4050v(i6, obj)) {
                if (m4037i(object)) {
                    AbstractC1589i7 abstractC1589i7Mo3736b = interfaceC1520b8M4045p.mo3736b();
                    interfaceC1520b8M4045p.mo3741g(abstractC1589i7Mo3736b, object);
                    unsafe.putObject(obj, j10, abstractC1589i7Mo3736b);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                m4048t(i6, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!m4037i(object2)) {
                AbstractC1589i7 abstractC1589i7Mo3736b2 = interfaceC1520b8M4045p.mo3736b();
                interfaceC1520b8M4045p.mo3741g(abstractC1589i7Mo3736b2, object2);
                unsafe.putObject(obj, j10, abstractC1589i7Mo3736b2);
                object2 = abstractC1589i7Mo3736b2;
            }
            interfaceC1520b8M4045p.mo3741g(object2, object);
        }
    }

    public final void m4047s(Object obj, int i6, Object obj2) {
        int[] iArr = this.f5708a;
        int i10 = iArr[i6];
        if (m4043j(i10, i6, obj2)) {
            int iM4044n = m4044n(i6) & 1048575;
            Unsafe unsafe = f5707h;
            long j10 = iM4044n;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i6] + " is present but null: " + obj2.toString());
            }
            InterfaceC1520b8 interfaceC1520b8M4045p = m4045p(i6);
            if (!m4043j(i10, i6, obj)) {
                if (m4037i(object)) {
                    AbstractC1589i7 abstractC1589i7Mo3736b = interfaceC1520b8M4045p.mo3736b();
                    interfaceC1520b8M4045p.mo3741g(abstractC1589i7Mo3736b, object);
                    unsafe.putObject(obj, j10, abstractC1589i7Mo3736b);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                AbstractC1600j8.m3891k(i10, iArr[i6 + 2] & 1048575, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!m4037i(object2)) {
                AbstractC1589i7 abstractC1589i7Mo3736b2 = interfaceC1520b8M4045p.mo3736b();
                interfaceC1520b8M4045p.mo3741g(abstractC1589i7Mo3736b2, object2);
                unsafe.putObject(obj, j10, abstractC1589i7Mo3736b2);
                object2 = abstractC1589i7Mo3736b2;
            }
            interfaceC1520b8M4045p.mo3741g(object2, object);
        }
    }

    public final void m4048t(int i6, Object obj) {
        int i10 = this.f5708a[i6 + 2];
        long j10 = 1048575 & i10;
        if (j10 == 1048575) {
            return;
        }
        AbstractC1600j8.m3891k((1 << (i10 >>> 20)) | AbstractC1600j8.m3886f(j10, obj), j10, obj);
    }

    public final boolean m4049u(AbstractC1589i7 abstractC1589i7, Object obj, int i6) {
        return m4050v(i6, abstractC1589i7) == m4050v(i6, obj);
    }

    public final boolean m4050v(int i6, Object obj) {
        int i10 = this.f5708a[i6 + 2];
        long j10 = i10 & 1048575;
        if (j10 != 1048575) {
            return ((1 << (i10 >>> 20)) & AbstractC1600j8.m3886f(j10, obj)) != 0;
        }
        int iM4044n = m4044n(i6);
        long j11 = iM4044n & 1048575;
        switch (m4040m(iM4044n)) {
            case 0:
                return Double.doubleToRawLongBits(AbstractC1600j8.f5374c.mo3825a(j11, obj)) != 0;
            case 1:
                return Float.floatToRawIntBits(AbstractC1600j8.f5374c.mo3826b(j11, obj)) != 0;
            case 2:
                return AbstractC1600j8.m3887g(j11, obj) != 0;
            case 3:
                return AbstractC1600j8.m3887g(j11, obj) != 0;
            case 4:
                return AbstractC1600j8.m3886f(j11, obj) != 0;
            case 5:
                return AbstractC1600j8.m3887g(j11, obj) != 0;
            case 6:
                return AbstractC1600j8.m3886f(j11, obj) != 0;
            case 7:
                return AbstractC1600j8.f5374c.mo3831g(j11, obj);
            case 8:
                Object objM3889i = AbstractC1600j8.m3889i(j11, obj);
                if (objM3889i instanceof String) {
                    return !((String) objM3889i).isEmpty();
                }
                if (objM3889i instanceof C1529c7) {
                    return !C1529c7.f5233c.equals(objM3889i);
                }
                throw new IllegalArgumentException();
            case 9:
                return AbstractC1600j8.m3889i(j11, obj) != null;
            case 10:
                return !C1529c7.f5233c.equals(AbstractC1600j8.m3889i(j11, obj));
            case 11:
                return AbstractC1600j8.m3886f(j11, obj) != 0;
            case 12:
                return AbstractC1600j8.m3886f(j11, obj) != 0;
            case 13:
                return AbstractC1600j8.m3886f(j11, obj) != 0;
            case 14:
                return AbstractC1600j8.m3887g(j11, obj) != 0;
            case 15:
                return AbstractC1600j8.m3886f(j11, obj) != 0;
            case 16:
                return AbstractC1600j8.m3887g(j11, obj) != 0;
            case 17:
                return AbstractC1600j8.m3889i(j11, obj) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean m4051w(Object obj, int i6, int i10, int i11, int i12) {
        if (i10 == 1048575) {
            return m4050v(i6, obj);
        }
        return (i11 & i12) != 0;
    }
}
