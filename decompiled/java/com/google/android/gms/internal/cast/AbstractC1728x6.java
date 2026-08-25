package com.google.android.gms.internal.cast;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p055ea.AbstractC2460q;

public abstract class AbstractC1728x6 {
    protected int zza;

    public static void m4054b(ArrayList arrayList, List list) {
        Charset charset = AbstractC1639n7.f5472a;
        int size = arrayList.size();
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + size);
        } else if (list instanceof C1747z7) {
            C1747z7 c1747z7 = (C1747z7) list;
            int i6 = ((C1747z7) list).f5749c + size;
            int length = c1747z7.f5748b.length;
            if (i6 > length) {
                if (length != 0) {
                    while (length < i6) {
                        length = Math.max(((length * 3) / 2) + 1, 10);
                    }
                    c1747z7.f5748b = Arrays.copyOf(c1747z7.f5748b, length);
                } else {
                    c1747z7.f5748b = new Object[Math.max(i6, 10)];
                }
            }
        }
        int size2 = list.size();
        int size3 = arrayList.size();
        for (int i10 = 0; i10 < size3; i10++) {
            Object obj = arrayList.get(i10);
            if (obj == null) {
                String strM5492f = AbstractC2460q.m5492f(list.size() - size2, "Element at index ", " is null.");
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size2) {
                        throw new NullPointerException(strM5492f);
                    }
                    list.remove(size4);
                }
            } else {
                list.add(obj);
            }
        }
    }

    public abstract int mo3866a(InterfaceC1520b8 interfaceC1520b8);
}
