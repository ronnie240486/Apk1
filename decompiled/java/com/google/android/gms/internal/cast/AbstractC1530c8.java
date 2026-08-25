package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractC1530c8 {

    public static final C1661q2 f5236a;

    static {
        C1738y7 c1738y7 = C1738y7.f5738c;
        f5236a = new C1661q2(15);
    }

    public static void m3758A(int i6, List list, C1675r7 c1675r7, boolean z7) throws C1549e7 {
        if (list == null || list.isEmpty()) {
            return;
        }
        c1675r7.getClass();
        boolean z10 = list instanceof C1666q7;
        C1539d7 c1539d7 = (C1539d7) c1675r7.f5590b;
        int i10 = 0;
        if (!z10) {
            if (!z7) {
                while (i10 < list.size()) {
                    c1539d7.m3803y(i6, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            c1539d7.m3794D(i6, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Long) list.get(i12)).getClass();
                i11 += 8;
            }
            c1539d7.m3796F(i11);
            while (i10 < list.size()) {
                c1539d7.m3804z(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        C1666q7 c1666q7 = (C1666q7) list;
        if (!z7) {
            while (i10 < c1666q7.f5571c) {
                c1539d7.m3803y(i6, c1666q7.m3986e(i10));
                i10++;
            }
            return;
        }
        c1539d7.m3794D(i6, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < c1666q7.f5571c; i14++) {
            c1666q7.m3986e(i14);
            i13 += 8;
        }
        c1539d7.m3796F(i13);
        while (i10 < c1666q7.f5571c) {
            c1539d7.m3804z(c1666q7.m3986e(i10));
            i10++;
        }
    }

    public static void m3759B(int i6, List list, C1675r7 c1675r7, boolean z7) throws C1549e7 {
        if (list == null || list.isEmpty()) {
            return;
        }
        c1675r7.getClass();
        boolean z10 = list instanceof C1599j7;
        C1539d7 c1539d7 = (C1539d7) c1675r7.f5590b;
        int i10 = 0;
        if (!z10) {
            if (!z7) {
                while (i10 < list.size()) {
                    int iIntValue = ((Integer) list.get(i10)).intValue();
                    c1539d7.m3795E(i6, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i10++;
                }
                return;
            }
            c1539d7.m3794D(i6, 2);
            int iM3789L = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                int iIntValue2 = ((Integer) list.get(i11)).intValue();
                iM3789L += C1539d7.m3789L((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            c1539d7.m3796F(iM3789L);
            while (i10 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i10)).intValue();
                c1539d7.m3796F((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i10++;
            }
            return;
        }
        C1599j7 c1599j7 = (C1599j7) list;
        if (!z7) {
            while (i10 < c1599j7.f5371c) {
                int iM3877e = c1599j7.m3877e(i10);
                c1539d7.m3795E(i6, (iM3877e >> 31) ^ (iM3877e + iM3877e));
                i10++;
            }
            return;
        }
        c1539d7.m3794D(i6, 2);
        int iM3789L2 = 0;
        for (int i12 = 0; i12 < c1599j7.f5371c; i12++) {
            int iM3877e2 = c1599j7.m3877e(i12);
            iM3789L2 += C1539d7.m3789L((iM3877e2 >> 31) ^ (iM3877e2 + iM3877e2));
        }
        c1539d7.m3796F(iM3789L2);
        while (i10 < c1599j7.f5371c) {
            int iM3877e3 = c1599j7.m3877e(i10);
            c1539d7.m3796F((iM3877e3 >> 31) ^ (iM3877e3 + iM3877e3));
            i10++;
        }
    }

    public static void m3760a(int i6, List list, C1675r7 c1675r7, boolean z7) throws C1549e7 {
        if (list == null || list.isEmpty()) {
            return;
        }
        c1675r7.getClass();
        boolean z10 = list instanceof C1666q7;
        C1539d7 c1539d7 = (C1539d7) c1675r7.f5590b;
        int i10 = 0;
        if (!z10) {
            if (!z7) {
                while (i10 < list.size()) {
                    long jLongValue = ((Long) list.get(i10)).longValue();
                    c1539d7.m3797G(i6, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i10++;
                }
                return;
            }
            c1539d7.m3794D(i6, 2);
            int iM3790t = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                long jLongValue2 = ((Long) list.get(i11)).longValue();
                iM3790t += C1539d7.m3790t((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            c1539d7.m3796F(iM3790t);
            while (i10 < list.size()) {
                long jLongValue3 = ((Long) list.get(i10)).longValue();
                c1539d7.m3798H((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i10++;
            }
            return;
        }
        C1666q7 c1666q7 = (C1666q7) list;
        if (!z7) {
            while (i10 < c1666q7.f5571c) {
                long jM3986e = c1666q7.m3986e(i10);
                c1539d7.m3797G(i6, (jM3986e >> 63) ^ (jM3986e + jM3986e));
                i10++;
            }
            return;
        }
        c1539d7.m3794D(i6, 2);
        int iM3790t2 = 0;
        for (int i12 = 0; i12 < c1666q7.f5571c; i12++) {
            long jM3986e2 = c1666q7.m3986e(i12);
            iM3790t2 += C1539d7.m3790t((jM3986e2 >> 63) ^ (jM3986e2 + jM3986e2));
        }
        c1539d7.m3796F(iM3790t2);
        while (i10 < c1666q7.f5571c) {
            long jM3986e3 = c1666q7.m3986e(i10);
            c1539d7.m3798H((jM3986e3 >> 63) ^ (jM3986e3 + jM3986e3));
            i10++;
        }
    }

    public static void m3761b(int i6, List list, C1675r7 c1675r7, boolean z7) throws C1549e7 {
        if (list == null || list.isEmpty()) {
            return;
        }
        c1675r7.getClass();
        boolean z10 = list instanceof C1599j7;
        C1539d7 c1539d7 = (C1539d7) c1675r7.f5590b;
        int i10 = 0;
        if (!z10) {
            if (!z7) {
                while (i10 < list.size()) {
                    c1539d7.m3795E(i6, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            c1539d7.m3794D(i6, 2);
            int iM3789L = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iM3789L += C1539d7.m3789L(((Integer) list.get(i11)).intValue());
            }
            c1539d7.m3796F(iM3789L);
            while (i10 < list.size()) {
                c1539d7.m3796F(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        C1599j7 c1599j7 = (C1599j7) list;
        if (!z7) {
            while (i10 < c1599j7.f5371c) {
                c1539d7.m3795E(i6, c1599j7.m3877e(i10));
                i10++;
            }
            return;
        }
        c1539d7.m3794D(i6, 2);
        int iM3789L2 = 0;
        for (int i12 = 0; i12 < c1599j7.f5371c; i12++) {
            iM3789L2 += C1539d7.m3789L(c1599j7.m3877e(i12));
        }
        c1539d7.m3796F(iM3789L2);
        while (i10 < c1599j7.f5371c) {
            c1539d7.m3796F(c1599j7.m3877e(i10));
            i10++;
        }
    }

    public static void m3762c(int i6, List list, C1675r7 c1675r7, boolean z7) throws C1549e7 {
        if (list == null || list.isEmpty()) {
            return;
        }
        c1675r7.getClass();
        boolean z10 = list instanceof C1666q7;
        C1539d7 c1539d7 = (C1539d7) c1675r7.f5590b;
        int i10 = 0;
        if (!z10) {
            if (!z7) {
                while (i10 < list.size()) {
                    c1539d7.m3797G(i6, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            c1539d7.m3794D(i6, 2);
            int iM3790t = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iM3790t += C1539d7.m3790t(((Long) list.get(i11)).longValue());
            }
            c1539d7.m3796F(iM3790t);
            while (i10 < list.size()) {
                c1539d7.m3798H(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        C1666q7 c1666q7 = (C1666q7) list;
        if (!z7) {
            while (i10 < c1666q7.f5571c) {
                c1539d7.m3797G(i6, c1666q7.m3986e(i10));
                i10++;
            }
            return;
        }
        c1539d7.m3794D(i6, 2);
        int iM3790t2 = 0;
        for (int i12 = 0; i12 < c1666q7.f5571c; i12++) {
            iM3790t2 += C1539d7.m3790t(c1666q7.m3986e(i12));
        }
        c1539d7.m3796F(iM3790t2);
        while (i10 < c1666q7.f5571c) {
            c1539d7.m3798H(c1666q7.m3986e(i10));
            i10++;
        }
    }

    public static boolean m3763d(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int m3764e(List list) {
        int iM3790t;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1599j7) {
            C1599j7 c1599j7 = (C1599j7) list;
            iM3790t = 0;
            while (i6 < size) {
                iM3790t += C1539d7.m3790t(c1599j7.m3877e(i6));
                i6++;
            }
        } else {
            iM3790t = 0;
            while (i6 < size) {
                iM3790t += C1539d7.m3790t(((Integer) list.get(i6)).intValue());
                i6++;
            }
        }
        return iM3790t;
    }

    public static int m3765f(int i6, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C1539d7.m3789L(i6 << 3) + 4) * size;
    }

    public static int m3766g(List list) {
        return list.size() * 4;
    }

    public static int m3767h(int i6, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C1539d7.m3789L(i6 << 3) + 8) * size;
    }

    public static int m3768i(List list) {
        return list.size() * 8;
    }

    public static int m3769j(List list) {
        int iM3790t;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1599j7) {
            C1599j7 c1599j7 = (C1599j7) list;
            iM3790t = 0;
            while (i6 < size) {
                iM3790t += C1539d7.m3790t(c1599j7.m3877e(i6));
                i6++;
            }
        } else {
            iM3790t = 0;
            while (i6 < size) {
                iM3790t += C1539d7.m3790t(((Integer) list.get(i6)).intValue());
                i6++;
            }
        }
        return iM3790t;
    }

    public static int m3770k(List list) {
        int iM3790t;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1666q7) {
            C1666q7 c1666q7 = (C1666q7) list;
            iM3790t = 0;
            while (i6 < size) {
                iM3790t += C1539d7.m3790t(c1666q7.m3986e(i6));
                i6++;
            }
        } else {
            iM3790t = 0;
            while (i6 < size) {
                iM3790t += C1539d7.m3790t(((Long) list.get(i6)).longValue());
                i6++;
            }
        }
        return iM3790t;
    }

    public static int m3771l(int i6, Object obj, InterfaceC1520b8 interfaceC1520b8) {
        return C1539d7.m3787J((AbstractC1728x6) obj, interfaceC1520b8) + C1539d7.m3789L(i6 << 3);
    }

    public static int m3772m(List list) {
        int iM3789L;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1599j7) {
            C1599j7 c1599j7 = (C1599j7) list;
            iM3789L = 0;
            while (i6 < size) {
                int iM3877e = c1599j7.m3877e(i6);
                iM3789L += C1539d7.m3789L((iM3877e >> 31) ^ (iM3877e + iM3877e));
                i6++;
            }
        } else {
            iM3789L = 0;
            while (i6 < size) {
                int iIntValue = ((Integer) list.get(i6)).intValue();
                iM3789L += C1539d7.m3789L((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i6++;
            }
        }
        return iM3789L;
    }

    public static int m3773n(List list) {
        int iM3790t;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1666q7) {
            C1666q7 c1666q7 = (C1666q7) list;
            iM3790t = 0;
            while (i6 < size) {
                long jM3986e = c1666q7.m3986e(i6);
                iM3790t += C1539d7.m3790t((jM3986e >> 63) ^ (jM3986e + jM3986e));
                i6++;
            }
        } else {
            iM3790t = 0;
            while (i6 < size) {
                long jLongValue = ((Long) list.get(i6)).longValue();
                iM3790t += C1539d7.m3790t((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i6++;
            }
        }
        return iM3790t;
    }

    public static int m3774o(List list) {
        int iM3789L;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1599j7) {
            C1599j7 c1599j7 = (C1599j7) list;
            iM3789L = 0;
            while (i6 < size) {
                iM3789L += C1539d7.m3789L(c1599j7.m3877e(i6));
                i6++;
            }
        } else {
            iM3789L = 0;
            while (i6 < size) {
                iM3789L += C1539d7.m3789L(((Integer) list.get(i6)).intValue());
                i6++;
            }
        }
        return iM3789L;
    }

    public static int m3775p(List list) {
        int iM3790t;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1666q7) {
            C1666q7 c1666q7 = (C1666q7) list;
            iM3790t = 0;
            while (i6 < size) {
                iM3790t += C1539d7.m3790t(c1666q7.m3986e(i6));
                i6++;
            }
        } else {
            iM3790t = 0;
            while (i6 < size) {
                iM3790t += C1539d7.m3790t(((Long) list.get(i6)).longValue());
                i6++;
            }
        }
        return iM3790t;
    }

    public static void m3776q(Object obj, Object obj2) {
        AbstractC1589i7 abstractC1589i7 = (AbstractC1589i7) obj;
        C1550e8 c1550e8 = abstractC1589i7.zzc;
        C1550e8 c1550e9 = ((AbstractC1589i7) obj2).zzc;
        C1550e8 c1550e10 = C1550e8.f5286e;
        if (!c1550e10.equals(c1550e9)) {
            if (c1550e10.equals(c1550e8)) {
                c1550e8.getClass();
                c1550e9.getClass();
                int[] iArrCopyOf = Arrays.copyOf(c1550e8.f5287a, 0);
                System.arraycopy(c1550e9.f5287a, 0, iArrCopyOf, 0, 0);
                Object[] objArrCopyOf = Arrays.copyOf(c1550e8.f5288b, 0);
                System.arraycopy(c1550e9.f5288b, 0, objArrCopyOf, 0, 0);
                c1550e8 = new C1550e8(iArrCopyOf, objArrCopyOf, true);
            } else {
                c1550e8.getClass();
                if (!c1550e9.equals(c1550e10)) {
                    if (!c1550e8.f5290d) {
                        throw new UnsupportedOperationException();
                    }
                    int[] iArr = c1550e8.f5287a;
                    int length = iArr.length;
                    System.arraycopy(c1550e9.f5287a, 0, iArr, 0, 0);
                    System.arraycopy(c1550e9.f5288b, 0, c1550e8.f5288b, 0, 0);
                }
            }
        }
        abstractC1589i7.zzc = c1550e8;
    }

    public static void m3777r(int i6, List list, C1675r7 c1675r7, boolean z7) throws C1549e7 {
        IndexOutOfBoundsException indexOutOfBoundsException;
        IndexOutOfBoundsException indexOutOfBoundsException2;
        if (list == null || list.isEmpty()) {
            return;
        }
        C1539d7 c1539d7 = (C1539d7) c1675r7.f5590b;
        int i10 = 0;
        if (!z7) {
            while (i10 < list.size()) {
                byte bBooleanValue = ((Boolean) list.get(i10)).booleanValue();
                c1539d7.m3796F(i6 << 3);
                int i11 = c1539d7.f5252g;
                try {
                    int i12 = i11 + 1;
                    try {
                        c1539d7.f5250e[i11] = bBooleanValue;
                        c1539d7.f5252g = i12;
                        i10++;
                    } catch (IndexOutOfBoundsException e5) {
                        indexOutOfBoundsException = e5;
                        i11 = i12;
                        throw new C1549e7(i11, c1539d7.f5251f, 1, indexOutOfBoundsException);
                    }
                } catch (IndexOutOfBoundsException e10) {
                    indexOutOfBoundsException = e10;
                }
            }
            return;
        }
        c1539d7.m3794D(i6, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            ((Boolean) list.get(i14)).getClass();
            i13++;
        }
        c1539d7.m3796F(i13);
        while (i10 < list.size()) {
            byte bBooleanValue2 = ((Boolean) list.get(i10)).booleanValue();
            int i15 = c1539d7.f5252g;
            try {
                int i16 = i15 + 1;
                try {
                    c1539d7.f5250e[i15] = bBooleanValue2;
                    c1539d7.f5252g = i16;
                    i10++;
                } catch (IndexOutOfBoundsException e11) {
                    indexOutOfBoundsException2 = e11;
                    i15 = i16;
                    throw new C1549e7(i15, c1539d7.f5251f, 1, indexOutOfBoundsException2);
                }
            } catch (IndexOutOfBoundsException e12) {
                indexOutOfBoundsException2 = e12;
            }
        }
    }

    public static void m3778s(int i6, List list, C1675r7 c1675r7, boolean z7) throws C1549e7 {
        if (list == null || list.isEmpty()) {
            return;
        }
        C1539d7 c1539d7 = (C1539d7) c1675r7.f5590b;
        int i10 = 0;
        if (!z7) {
            while (i10 < list.size()) {
                c1539d7.m3803y(i6, Double.doubleToRawLongBits(((Double) list.get(i10)).doubleValue()));
                i10++;
            }
            return;
        }
        c1539d7.m3794D(i6, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Double) list.get(i12)).getClass();
            i11 += 8;
        }
        c1539d7.m3796F(i11);
        while (i10 < list.size()) {
            c1539d7.m3804z(Double.doubleToRawLongBits(((Double) list.get(i10)).doubleValue()));
            i10++;
        }
    }

    public static void m3779t(int i6, List list, C1675r7 c1675r7, boolean z7) throws C1549e7 {
        if (list == null || list.isEmpty()) {
            return;
        }
        c1675r7.getClass();
        boolean z10 = list instanceof C1599j7;
        C1539d7 c1539d7 = (C1539d7) c1675r7.f5590b;
        int i10 = 0;
        if (!z10) {
            if (!z7) {
                while (i10 < list.size()) {
                    c1539d7.m3791A(i6, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            c1539d7.m3794D(i6, 2);
            int iM3790t = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iM3790t += C1539d7.m3790t(((Integer) list.get(i11)).intValue());
            }
            c1539d7.m3796F(iM3790t);
            while (i10 < list.size()) {
                c1539d7.m3792B(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        C1599j7 c1599j7 = (C1599j7) list;
        if (!z7) {
            while (i10 < c1599j7.f5371c) {
                c1539d7.m3791A(i6, c1599j7.m3877e(i10));
                i10++;
            }
            return;
        }
        c1539d7.m3794D(i6, 2);
        int iM3790t2 = 0;
        for (int i12 = 0; i12 < c1599j7.f5371c; i12++) {
            iM3790t2 += C1539d7.m3790t(c1599j7.m3877e(i12));
        }
        c1539d7.m3796F(iM3790t2);
        while (i10 < c1599j7.f5371c) {
            c1539d7.m3792B(c1599j7.m3877e(i10));
            i10++;
        }
    }

    public static void m3780u(int i6, List list, C1675r7 c1675r7, boolean z7) throws C1549e7 {
        if (list == null || list.isEmpty()) {
            return;
        }
        c1675r7.getClass();
        boolean z10 = list instanceof C1599j7;
        C1539d7 c1539d7 = (C1539d7) c1675r7.f5590b;
        int i10 = 0;
        if (!z10) {
            if (!z7) {
                while (i10 < list.size()) {
                    c1539d7.m3801w(i6, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            c1539d7.m3794D(i6, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Integer) list.get(i12)).getClass();
                i11 += 4;
            }
            c1539d7.m3796F(i11);
            while (i10 < list.size()) {
                c1539d7.m3802x(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        C1599j7 c1599j7 = (C1599j7) list;
        if (!z7) {
            while (i10 < c1599j7.f5371c) {
                c1539d7.m3801w(i6, c1599j7.m3877e(i10));
                i10++;
            }
            return;
        }
        c1539d7.m3794D(i6, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < c1599j7.f5371c; i14++) {
            c1599j7.m3877e(i14);
            i13 += 4;
        }
        c1539d7.m3796F(i13);
        while (i10 < c1599j7.f5371c) {
            c1539d7.m3802x(c1599j7.m3877e(i10));
            i10++;
        }
    }

    public static void m3781v(int i6, List list, C1675r7 c1675r7, boolean z7) throws C1549e7 {
        if (list == null || list.isEmpty()) {
            return;
        }
        c1675r7.getClass();
        boolean z10 = list instanceof C1666q7;
        C1539d7 c1539d7 = (C1539d7) c1675r7.f5590b;
        int i10 = 0;
        if (!z10) {
            if (!z7) {
                while (i10 < list.size()) {
                    c1539d7.m3803y(i6, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            c1539d7.m3794D(i6, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Long) list.get(i12)).getClass();
                i11 += 8;
            }
            c1539d7.m3796F(i11);
            while (i10 < list.size()) {
                c1539d7.m3804z(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        C1666q7 c1666q7 = (C1666q7) list;
        if (!z7) {
            while (i10 < c1666q7.f5571c) {
                c1539d7.m3803y(i6, c1666q7.m3986e(i10));
                i10++;
            }
            return;
        }
        c1539d7.m3794D(i6, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < c1666q7.f5571c; i14++) {
            c1666q7.m3986e(i14);
            i13 += 8;
        }
        c1539d7.m3796F(i13);
        while (i10 < c1666q7.f5571c) {
            c1539d7.m3804z(c1666q7.m3986e(i10));
            i10++;
        }
    }

    public static void m3782w(int i6, List list, C1675r7 c1675r7, boolean z7) throws C1549e7 {
        if (list == null || list.isEmpty()) {
            return;
        }
        C1539d7 c1539d7 = (C1539d7) c1675r7.f5590b;
        int i10 = 0;
        if (!z7) {
            while (i10 < list.size()) {
                c1539d7.m3801w(i6, Float.floatToRawIntBits(((Float) list.get(i10)).floatValue()));
                i10++;
            }
            return;
        }
        c1539d7.m3794D(i6, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Float) list.get(i12)).getClass();
            i11 += 4;
        }
        c1539d7.m3796F(i11);
        while (i10 < list.size()) {
            c1539d7.m3802x(Float.floatToRawIntBits(((Float) list.get(i10)).floatValue()));
            i10++;
        }
    }

    public static void m3783x(int i6, List list, C1675r7 c1675r7, boolean z7) throws C1549e7 {
        if (list == null || list.isEmpty()) {
            return;
        }
        c1675r7.getClass();
        boolean z10 = list instanceof C1599j7;
        C1539d7 c1539d7 = (C1539d7) c1675r7.f5590b;
        int i10 = 0;
        if (!z10) {
            if (!z7) {
                while (i10 < list.size()) {
                    c1539d7.m3791A(i6, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            c1539d7.m3794D(i6, 2);
            int iM3790t = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iM3790t += C1539d7.m3790t(((Integer) list.get(i11)).intValue());
            }
            c1539d7.m3796F(iM3790t);
            while (i10 < list.size()) {
                c1539d7.m3792B(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        C1599j7 c1599j7 = (C1599j7) list;
        if (!z7) {
            while (i10 < c1599j7.f5371c) {
                c1539d7.m3791A(i6, c1599j7.m3877e(i10));
                i10++;
            }
            return;
        }
        c1539d7.m3794D(i6, 2);
        int iM3790t2 = 0;
        for (int i12 = 0; i12 < c1599j7.f5371c; i12++) {
            iM3790t2 += C1539d7.m3790t(c1599j7.m3877e(i12));
        }
        c1539d7.m3796F(iM3790t2);
        while (i10 < c1599j7.f5371c) {
            c1539d7.m3792B(c1599j7.m3877e(i10));
            i10++;
        }
    }

    public static void m3784y(int i6, List list, C1675r7 c1675r7, boolean z7) throws C1549e7 {
        if (list == null || list.isEmpty()) {
            return;
        }
        c1675r7.getClass();
        boolean z10 = list instanceof C1666q7;
        C1539d7 c1539d7 = (C1539d7) c1675r7.f5590b;
        int i10 = 0;
        if (!z10) {
            if (!z7) {
                while (i10 < list.size()) {
                    c1539d7.m3797G(i6, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            c1539d7.m3794D(i6, 2);
            int iM3790t = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iM3790t += C1539d7.m3790t(((Long) list.get(i11)).longValue());
            }
            c1539d7.m3796F(iM3790t);
            while (i10 < list.size()) {
                c1539d7.m3798H(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        C1666q7 c1666q7 = (C1666q7) list;
        if (!z7) {
            while (i10 < c1666q7.f5571c) {
                c1539d7.m3797G(i6, c1666q7.m3986e(i10));
                i10++;
            }
            return;
        }
        c1539d7.m3794D(i6, 2);
        int iM3790t2 = 0;
        for (int i12 = 0; i12 < c1666q7.f5571c; i12++) {
            iM3790t2 += C1539d7.m3790t(c1666q7.m3986e(i12));
        }
        c1539d7.m3796F(iM3790t2);
        while (i10 < c1666q7.f5571c) {
            c1539d7.m3798H(c1666q7.m3986e(i10));
            i10++;
        }
    }

    public static void m3785z(int i6, List list, C1675r7 c1675r7, boolean z7) throws C1549e7 {
        if (list == null || list.isEmpty()) {
            return;
        }
        c1675r7.getClass();
        boolean z10 = list instanceof C1599j7;
        C1539d7 c1539d7 = (C1539d7) c1675r7.f5590b;
        int i10 = 0;
        if (!z10) {
            if (!z7) {
                while (i10 < list.size()) {
                    c1539d7.m3801w(i6, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            c1539d7.m3794D(i6, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Integer) list.get(i12)).getClass();
                i11 += 4;
            }
            c1539d7.m3796F(i11);
            while (i10 < list.size()) {
                c1539d7.m3802x(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        C1599j7 c1599j7 = (C1599j7) list;
        if (!z7) {
            while (i10 < c1599j7.f5371c) {
                c1539d7.m3801w(i6, c1599j7.m3877e(i10));
                i10++;
            }
            return;
        }
        c1539d7.m3794D(i6, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < c1599j7.f5371c; i14++) {
            c1599j7.m3877e(i14);
            i13 += 4;
        }
        c1539d7.m3796F(i13);
        while (i10 < c1599j7.f5371c) {
            c1539d7.m3802x(c1599j7.m3877e(i10));
            i10++;
        }
    }
}
