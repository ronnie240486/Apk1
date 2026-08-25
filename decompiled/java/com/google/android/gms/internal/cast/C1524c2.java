package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map;

public final class C1524c2 extends AbstractC1732y1 {

    public final transient C1554f2 f5229d;

    public final transient Object[] f5230e;

    public final transient int f5231f;

    public C1524c2(C1554f2 c1554f2, Object[] objArr, int i6) {
        this.f5229d = c1554f2;
        this.f5230e = objArr;
        this.f5231f = i6;
    }

    @Override
    public final int mo3710c(Object[] objArr) {
        AbstractC1714w1 abstractC1714w1M3743i = this.f5736b;
        if (abstractC1714w1M3743i == null) {
            abstractC1714w1M3743i = m3743i();
            this.f5736b = abstractC1714w1M3743i;
        }
        return abstractC1714w1M3743i.mo3710c(objArr);
    }

    @Override
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f5229d.get(key))) {
                return true;
            }
        }
        return false;
    }

    public final AbstractC1714w1 m3743i() {
        return new C1514b2(this);
    }

    @Override
    public final Iterator iterator() {
        AbstractC1714w1 abstractC1714w1M3743i = this.f5736b;
        if (abstractC1714w1M3743i == null) {
            abstractC1714w1M3743i = m3743i();
            this.f5736b = abstractC1714w1M3743i;
        }
        return abstractC1714w1M3743i.listIterator(0);
    }

    @Override
    public final int size() {
        return this.f5231f;
    }
}
