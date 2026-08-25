package p041d7;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p020b7.AbstractC1332b;
import p029c7.C1427w;
import p187r4.AbstractC3612b;

public final class C2217i0 extends AbstractMap implements Serializable {

    public static final Object f7932j = new Object();

    public transient Object f7933a;

    public transient int[] f7934b;

    public transient Object[] f7935c;

    public transient Object[] f7936d;

    public transient int f7937e;

    public transient int f7938f;

    public transient C2203g0 f7939g;

    public transient C2203g0 f7940h;

    public transient C1427w f7941i;

    public static C2217i0 m5208a() {
        C2217i0 c2217i0 = new C2217i0();
        c2217i0.f7937e = AbstractC3612b.m7267i(3, 1);
        return c2217i0;
    }

    public static C2217i0 m5209b(int i6) {
        C2217i0 c2217i0 = new C2217i0();
        AbstractC1332b.m3214e("Expected size must be >= 0", i6 >= 0);
        c2217i0.f7937e = AbstractC3612b.m7267i(i6, 1);
        return c2217i0;
    }

    public final Map m5210c() {
        Object obj = this.f7933a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override
    public final void clear() {
        if (m5214g()) {
            return;
        }
        this.f7937e += 32;
        Map mapM5210c = m5210c();
        if (mapM5210c != null) {
            this.f7937e = AbstractC3612b.m7267i(size(), 3);
            mapM5210c.clear();
            this.f7933a = null;
            this.f7938f = 0;
            return;
        }
        Arrays.fill(m5217j(), 0, this.f7938f, (Object) null);
        Arrays.fill(m5218k(), 0, this.f7938f, (Object) null);
        Object obj = this.f7933a;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(m5216i(), 0, this.f7938f, 0);
        this.f7938f = 0;
    }

    @Override
    public final boolean containsKey(Object obj) {
        Map mapM5210c = m5210c();
        if (mapM5210c != null) {
            return mapM5210c.containsKey(obj);
        }
        return m5212e(obj) != -1;
    }

    @Override
    public final boolean containsValue(Object obj) {
        Map mapM5210c = m5210c();
        if (mapM5210c != null) {
            return mapM5210c.containsValue(obj);
        }
        for (int i6 = 0; i6 < this.f7938f; i6++) {
            if (AbstractC1332b.m3225p(obj, m5218k()[i6])) {
                return true;
            }
        }
        return false;
    }

    public final int m5211d() {
        return (1 << (this.f7937e & 31)) - 1;
    }

    public final int m5212e(Object obj) {
        if (m5214g()) {
            return -1;
        }
        int iM5130B = AbstractC2182d0.m5130B(obj);
        int iM5211d = m5211d();
        Object obj2 = this.f7933a;
        Objects.requireNonNull(obj2);
        int iM5131C = AbstractC2182d0.m5131C(iM5130B & iM5211d, obj2);
        if (iM5131C == 0) {
            return -1;
        }
        int i6 = ~iM5211d;
        int i10 = iM5130B & i6;
        do {
            int i11 = iM5131C - 1;
            int i12 = m5216i()[i11];
            if ((i12 & i6) == i10 && AbstractC1332b.m3225p(obj, m5217j()[i11])) {
                return i11;
            }
            iM5131C = i12 & iM5211d;
        } while (iM5131C != 0);
        return -1;
    }

    @Override
    public final Set entrySet() {
        C2203g0 c2203g0 = this.f7940h;
        if (c2203g0 != null) {
            return c2203g0;
        }
        C2203g0 c2203g1 = new C2203g0(this, 0);
        this.f7940h = c2203g1;
        return c2203g1;
    }

    public final void m5213f(int i6, int i10) {
        Object obj = this.f7933a;
        Objects.requireNonNull(obj);
        int[] iArrM5216i = m5216i();
        Object[] objArrM5217j = m5217j();
        Object[] objArrM5218k = m5218k();
        int size = size();
        int i11 = size - 1;
        if (i6 >= i11) {
            objArrM5217j[i6] = null;
            objArrM5218k[i6] = null;
            iArrM5216i[i6] = 0;
            return;
        }
        Object obj2 = objArrM5217j[i11];
        objArrM5217j[i6] = obj2;
        objArrM5218k[i6] = objArrM5218k[i11];
        objArrM5217j[i11] = null;
        objArrM5218k[i11] = null;
        iArrM5216i[i6] = iArrM5216i[i11];
        iArrM5216i[i11] = 0;
        int iM5130B = AbstractC2182d0.m5130B(obj2) & i10;
        int iM5131C = AbstractC2182d0.m5131C(iM5130B, obj);
        if (iM5131C == size) {
            AbstractC2182d0.m5132D(iM5130B, i6 + 1, obj);
            return;
        }
        while (true) {
            int i12 = iM5131C - 1;
            int i13 = iArrM5216i[i12];
            int i14 = i13 & i10;
            if (i14 == size) {
                iArrM5216i[i12] = AbstractC2182d0.m5155r(i13, i6 + 1, i10);
                return;
            }
            iM5131C = i14;
        }
    }

    public final boolean m5214g() {
        return this.f7933a == null;
    }

    @Override
    public final Object get(Object obj) {
        Map mapM5210c = m5210c();
        if (mapM5210c != null) {
            return mapM5210c.get(obj);
        }
        int iM5212e = m5212e(obj);
        if (iM5212e == -1) {
            return null;
        }
        return m5218k()[iM5212e];
    }

    public final Object m5215h(Object obj) {
        boolean zM5214g = m5214g();
        Object obj2 = f7932j;
        if (zM5214g) {
            return obj2;
        }
        int iM5211d = m5211d();
        Object obj3 = this.f7933a;
        Objects.requireNonNull(obj3);
        int iM5160w = AbstractC2182d0.m5160w(obj, null, iM5211d, obj3, m5216i(), m5217j(), null);
        if (iM5160w == -1) {
            return obj2;
        }
        Object obj4 = m5218k()[iM5160w];
        m5213f(iM5160w, iM5211d);
        this.f7938f--;
        this.f7937e += 32;
        return obj4;
    }

    public final int[] m5216i() {
        int[] iArr = this.f7934b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    @Override
    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Object[] m5217j() {
        Object[] objArr = this.f7935c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object[] m5218k() {
        Object[] objArr = this.f7936d;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override
    public final Set keySet() {
        C2203g0 c2203g0 = this.f7939g;
        if (c2203g0 != null) {
            return c2203g0;
        }
        C2203g0 c2203g1 = new C2203g0(this, 1);
        this.f7939g = c2203g1;
        return c2203g1;
    }

    public final int m5219l(int i6, int i10, int i11, int i12) {
        Object objM5144g = AbstractC2182d0.m5144g(i10);
        int i13 = i10 - 1;
        if (i12 != 0) {
            AbstractC2182d0.m5132D(i11 & i13, i12 + 1, objM5144g);
        }
        Object obj = this.f7933a;
        Objects.requireNonNull(obj);
        int[] iArrM5216i = m5216i();
        for (int i14 = 0; i14 <= i6; i14++) {
            int iM5131C = AbstractC2182d0.m5131C(i14, obj);
            while (iM5131C != 0) {
                int i15 = iM5131C - 1;
                int i16 = iArrM5216i[i15];
                int i17 = ((~i6) & i16) | i14;
                int i18 = i17 & i13;
                int iM5131C2 = AbstractC2182d0.m5131C(i18, objM5144g);
                AbstractC2182d0.m5132D(i18, iM5131C, objM5144g);
                iArrM5216i[i15] = AbstractC2182d0.m5155r(i17, iM5131C2, i13);
                iM5131C = i16 & i6;
            }
        }
        this.f7933a = objM5144g;
        this.f7937e = AbstractC2182d0.m5155r(this.f7937e, 32 - Integer.numberOfLeadingZeros(i13), 31);
        return i13;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:25:0x00aa
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override
    public final java.lang.Object put(java.lang.Object r19, java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p041d7.C2217i0.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override
    public final Object remove(Object obj) {
        Map mapM5210c = m5210c();
        if (mapM5210c != null) {
            return mapM5210c.remove(obj);
        }
        Object objM5215h = m5215h(obj);
        if (objM5215h == f7932j) {
            return null;
        }
        return objM5215h;
    }

    @Override
    public final int size() {
        Map mapM5210c = m5210c();
        return mapM5210c != null ? mapM5210c.size() : this.f7938f;
    }

    @Override
    public final Collection values() {
        C1427w c1427w = this.f7941i;
        if (c1427w != null) {
            return c1427w;
        }
        C1427w c1427w2 = new C1427w(this, 1);
        this.f7941i = c1427w2;
        return c1427w2;
    }
}
