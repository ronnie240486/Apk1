package p041d7;

import androidx.media3.common.C0565C;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p020b7.AbstractC1332b;
import p020b7.AbstractC1344h;
import p029c7.C1427w;
import p109k3.C2888t;
import p187r4.AbstractC3612b;

public final class ConcurrentMapC2179c4 extends AbstractMap implements ConcurrentMap, Serializable {

    public static final C2164a3 f7852j = new C2164a3();

    public final transient int f7853a;

    public final transient int f7854b;

    public final transient AbstractC2213h3[] f7855c;

    public final int f7856d;

    public final AbstractC1344h f7857e;

    public final transient InterfaceC2206g3 f7858f;

    public transient C2192e3 f7859g;

    public transient C1427w f7860h;

    public transient C2192e3 f7861i;

    public ConcurrentMapC2179c4(C2888t c2888t, InterfaceC2206g3 interfaceC2206g3) {
        c2888t.getClass();
        this.f7856d = Math.min(4, C0565C.DEFAULT_BUFFER_SEGMENT_SIZE);
        this.f7857e = (AbstractC1344h) AbstractC1332b.m3227r(null, ((EnumC2234k3) AbstractC1332b.m3227r((C2227j3) c2888t.f9832c, EnumC2234k3.f7974a)).mo5220a());
        this.f7858f = interfaceC2206g3;
        int iMin = Math.min(16, 1073741824);
        int i6 = 1;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i11 < this.f7856d) {
            i12++;
            i11 <<= 1;
        }
        this.f7854b = 32 - i12;
        this.f7853a = i11 - 1;
        this.f7855c = new AbstractC2213h3[i11];
        int i13 = iMin / i11;
        while (i6 < (i11 * i13 < iMin ? i13 + 1 : i13)) {
            i6 <<= 1;
        }
        while (true) {
            AbstractC2213h3[] abstractC2213h3Arr = this.f7855c;
            if (i10 >= abstractC2213h3Arr.length) {
                return;
            }
            abstractC2213h3Arr[i10] = this.f7858f.mo5181b(this, i6);
            i10++;
        }
    }

    public final int m5121a(Object obj) {
        int iMo3237b;
        AbstractC1344h abstractC1344h = this.f7857e;
        if (obj == null) {
            abstractC1344h.getClass();
            iMo3237b = 0;
        } else {
            iMo3237b = abstractC1344h.mo3237b(obj);
        }
        int i6 = iMo3237b + ((iMo3237b << 15) ^ (-12931));
        int i10 = i6 ^ (i6 >>> 10);
        int i11 = i10 + (i10 << 3);
        int i12 = i11 ^ (i11 >>> 6);
        int i13 = (i12 << 2) + (i12 << 14) + i12;
        return (i13 >>> 16) ^ i13;
    }

    public final AbstractC2213h3 m5122b(int i6) {
        return this.f7855c[(i6 >>> this.f7854b) & this.f7853a];
    }

    @Override
    public final void clear() {
        for (AbstractC2213h3 abstractC2213h3 : this.f7855c) {
            if (abstractC2213h3.f7922b != 0) {
                abstractC2213h3.lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = abstractC2213h3.f7925e;
                    for (int i6 = 0; i6 < atomicReferenceArray.length(); i6++) {
                        atomicReferenceArray.set(i6, null);
                    }
                    abstractC2213h3.mo5196e();
                    abstractC2213h3.f7926f.set(0);
                    abstractC2213h3.f7923c++;
                    abstractC2213h3.f7922b = 0;
                    abstractC2213h3.unlock();
                } catch (Throwable th) {
                    abstractC2213h3.unlock();
                    throw th;
                }
            }
        }
    }

    @Override
    public final boolean containsKey(Object obj) {
        InterfaceC2199f3 interfaceC2199f3M5195d;
        boolean z7 = false;
        if (obj == null) {
            return false;
        }
        int iM5121a = m5121a(obj);
        AbstractC2213h3 abstractC2213h3M5122b = m5122b(iM5121a);
        abstractC2213h3M5122b.getClass();
        try {
            if (abstractC2213h3M5122b.f7922b != 0 && (interfaceC2199f3M5195d = abstractC2213h3M5122b.m5195d(iM5121a, obj)) != null && interfaceC2199f3M5195d.getValue() != null) {
                z7 = true;
            }
            return z7;
        } finally {
            abstractC2213h3M5122b.m5198g();
        }
    }

    @Override
    public final boolean containsValue(Object obj) {
        Object value;
        if (obj == null) {
            return false;
        }
        AbstractC2213h3[] abstractC2213h3Arr = this.f7855c;
        long j10 = -1;
        int i6 = 0;
        while (i6 < 3) {
            int length = abstractC2213h3Arr.length;
            long j11 = 0;
            for (int i10 = 0; i10 < length; i10++) {
                AbstractC2213h3 abstractC2213h3 = abstractC2213h3Arr[i10];
                int i11 = abstractC2213h3.f7922b;
                AtomicReferenceArray atomicReferenceArray = abstractC2213h3.f7925e;
                for (int i12 = 0; i12 < atomicReferenceArray.length(); i12++) {
                    for (InterfaceC2199f3 interfaceC2199f3Mo5106b = (InterfaceC2199f3) atomicReferenceArray.get(i12); interfaceC2199f3Mo5106b != null; interfaceC2199f3Mo5106b = interfaceC2199f3Mo5106b.mo5106b()) {
                        if (interfaceC2199f3Mo5106b.getKey() == null || (value = interfaceC2199f3Mo5106b.getValue()) == null) {
                            abstractC2213h3.m5204m();
                            value = null;
                        }
                        if (value != null && this.f7858f.mo5183d().mo5220a().m3238c(obj, value)) {
                            return true;
                        }
                    }
                }
                j11 += (long) abstractC2213h3.f7923c;
            }
            if (j11 == j10) {
                return false;
            }
            i6++;
            j10 = j11;
        }
        return false;
    }

    @Override
    public final Set entrySet() {
        C2192e3 c2192e3 = this.f7861i;
        if (c2192e3 != null) {
            return c2192e3;
        }
        C2192e3 c2192e4 = new C2192e3(this, 0);
        this.f7861i = c2192e4;
        return c2192e4;
    }

    @Override
    public final Object get(Object obj) {
        Object value = null;
        if (obj == null) {
            return null;
        }
        int iM5121a = m5121a(obj);
        AbstractC2213h3 abstractC2213h3M5122b = m5122b(iM5121a);
        abstractC2213h3M5122b.getClass();
        try {
            InterfaceC2199f3 interfaceC2199f3M5195d = abstractC2213h3M5122b.m5195d(iM5121a, obj);
            if (interfaceC2199f3M5195d != null && (value = interfaceC2199f3M5195d.getValue()) == null) {
                abstractC2213h3M5122b.m5204m();
            }
            return value;
        } finally {
            abstractC2213h3M5122b.m5198g();
        }
    }

    @Override
    public final boolean isEmpty() {
        AbstractC2213h3[] abstractC2213h3Arr = this.f7855c;
        long j10 = 0;
        for (int i6 = 0; i6 < abstractC2213h3Arr.length; i6++) {
            if (abstractC2213h3Arr[i6].f7922b != 0) {
                return false;
            }
            j10 += (long) abstractC2213h3Arr[i6].f7923c;
        }
        if (j10 == 0) {
            return true;
        }
        for (int i10 = 0; i10 < abstractC2213h3Arr.length; i10++) {
            if (abstractC2213h3Arr[i10].f7922b != 0) {
                return false;
            }
            j10 -= (long) abstractC2213h3Arr[i10].f7923c;
        }
        return j10 == 0;
    }

    @Override
    public final Set keySet() {
        C2192e3 c2192e3 = this.f7859g;
        if (c2192e3 != null) {
            return c2192e3;
        }
        C2192e3 c2192e4 = new C2192e3(this, 1);
        this.f7859g = c2192e4;
        return c2192e4;
    }

    @Override
    public final Object put(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iM5121a = m5121a(obj);
        return m5122b(iM5121a).m5199h(iM5121a, obj, obj2, false);
    }

    @Override
    public final void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public final Object putIfAbsent(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iM5121a = m5121a(obj);
        return m5122b(iM5121a).m5199h(iM5121a, obj, obj2, true);
    }

    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int iM5121a = m5121a(obj);
        AbstractC2213h3 abstractC2213h3M5122b = m5122b(iM5121a);
        abstractC2213h3M5122b.lock();
        try {
            abstractC2213h3M5122b.m5201j();
            AtomicReferenceArray atomicReferenceArray = abstractC2213h3M5122b.f7925e;
            int length = (atomicReferenceArray.length() - 1) & iM5121a;
            InterfaceC2199f3 interfaceC2199f3 = (InterfaceC2199f3) atomicReferenceArray.get(length);
            InterfaceC2199f3 interfaceC2199f3Mo5106b = interfaceC2199f3;
            while (interfaceC2199f3Mo5106b != null) {
                Object key = interfaceC2199f3Mo5106b.getKey();
                if (interfaceC2199f3Mo5106b.mo5107c() == iM5121a && key != null && abstractC2213h3M5122b.f7921a.f7857e.m3238c(obj, key)) {
                    Object value = interfaceC2199f3Mo5106b.getValue();
                    if (value == null) {
                    }
                    abstractC2213h3M5122b.f7923c++;
                    InterfaceC2199f3 interfaceC2199f3M5200i = abstractC2213h3M5122b.m5200i(interfaceC2199f3, interfaceC2199f3Mo5106b);
                    int i6 = abstractC2213h3M5122b.f7922b - 1;
                    atomicReferenceArray.set(length, interfaceC2199f3M5200i);
                    abstractC2213h3M5122b.f7922b = i6;
                    return value;
                }
                interfaceC2199f3Mo5106b = interfaceC2199f3Mo5106b.mo5106b();
            }
            return null;
        } finally {
            abstractC2213h3M5122b.unlock();
        }
    }

    @Override
    public final Object replace(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iM5121a = m5121a(obj);
        AbstractC2213h3 abstractC2213h3M5122b = m5122b(iM5121a);
        abstractC2213h3M5122b.lock();
        try {
            abstractC2213h3M5122b.m5201j();
            AtomicReferenceArray atomicReferenceArray = abstractC2213h3M5122b.f7925e;
            int length = (atomicReferenceArray.length() - 1) & iM5121a;
            InterfaceC2199f3 interfaceC2199f3 = (InterfaceC2199f3) atomicReferenceArray.get(length);
            for (InterfaceC2199f3 interfaceC2199f3Mo5106b = interfaceC2199f3; interfaceC2199f3Mo5106b != null; interfaceC2199f3Mo5106b = interfaceC2199f3Mo5106b.mo5106b()) {
                Object key = interfaceC2199f3Mo5106b.getKey();
                if (interfaceC2199f3Mo5106b.mo5107c() == iM5121a && key != null && abstractC2213h3M5122b.f7921a.f7857e.m3238c(obj, key)) {
                    Object value = interfaceC2199f3Mo5106b.getValue();
                    if (value != null) {
                        abstractC2213h3M5122b.f7923c++;
                        abstractC2213h3M5122b.m5203l(interfaceC2199f3Mo5106b, obj2);
                        return value;
                    }
                    if (interfaceC2199f3Mo5106b.getValue() != null) {
                        break;
                    }
                    abstractC2213h3M5122b.f7923c++;
                    InterfaceC2199f3 interfaceC2199f3M5200i = abstractC2213h3M5122b.m5200i(interfaceC2199f3, interfaceC2199f3Mo5106b);
                    int i6 = abstractC2213h3M5122b.f7922b - 1;
                    atomicReferenceArray.set(length, interfaceC2199f3M5200i);
                    abstractC2213h3M5122b.f7922b = i6;
                    break;
                }
            }
            return null;
        } finally {
            abstractC2213h3M5122b.unlock();
        }
    }

    @Override
    public final int size() {
        long j10 = 0;
        for (AbstractC2213h3 abstractC2213h3 : this.f7855c) {
            j10 += (long) abstractC2213h3.f7922b;
        }
        return AbstractC3612b.m7255K(j10);
    }

    @Override
    public final Collection values() {
        C1427w c1427w = this.f7860h;
        if (c1427w != null) {
            return c1427w;
        }
        C1427w c1427w2 = new C1427w(this, 3);
        this.f7860h = c1427w2;
        return c1427w2;
    }

    @Override
    public final boolean remove(Object obj, Object obj2) {
        boolean z7 = false;
        if (obj == null || obj2 == null) {
            return false;
        }
        int iM5121a = m5121a(obj);
        AbstractC2213h3 abstractC2213h3M5122b = m5122b(iM5121a);
        abstractC2213h3M5122b.lock();
        try {
            abstractC2213h3M5122b.m5201j();
            AtomicReferenceArray atomicReferenceArray = abstractC2213h3M5122b.f7925e;
            int length = (atomicReferenceArray.length() - 1) & iM5121a;
            InterfaceC2199f3 interfaceC2199f3 = (InterfaceC2199f3) atomicReferenceArray.get(length);
            for (InterfaceC2199f3 interfaceC2199f3Mo5106b = interfaceC2199f3; interfaceC2199f3Mo5106b != null; interfaceC2199f3Mo5106b = interfaceC2199f3Mo5106b.mo5106b()) {
                Object key = interfaceC2199f3Mo5106b.getKey();
                if (interfaceC2199f3Mo5106b.mo5107c() == iM5121a && key != null && abstractC2213h3M5122b.f7921a.f7857e.m3238c(obj, key)) {
                    if (!abstractC2213h3M5122b.f7921a.f7858f.mo5183d().mo5220a().m3238c(obj2, interfaceC2199f3Mo5106b.getValue())) {
                        if (interfaceC2199f3Mo5106b.getValue() != null) {
                            break;
                        }
                        break;
                    }
                    z7 = true;
                    abstractC2213h3M5122b.f7923c++;
                    InterfaceC2199f3 interfaceC2199f3M5200i = abstractC2213h3M5122b.m5200i(interfaceC2199f3, interfaceC2199f3Mo5106b);
                    int i6 = abstractC2213h3M5122b.f7922b - 1;
                    atomicReferenceArray.set(length, interfaceC2199f3M5200i);
                    abstractC2213h3M5122b.f7922b = i6;
                    break;
                }
            }
            return z7;
        } finally {
            abstractC2213h3M5122b.unlock();
        }
    }

    @Override
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        obj.getClass();
        obj3.getClass();
        if (obj2 == null) {
            return false;
        }
        int iM5121a = m5121a(obj);
        AbstractC2213h3 abstractC2213h3M5122b = m5122b(iM5121a);
        abstractC2213h3M5122b.lock();
        try {
            abstractC2213h3M5122b.m5201j();
            AtomicReferenceArray atomicReferenceArray = abstractC2213h3M5122b.f7925e;
            int length = (atomicReferenceArray.length() - 1) & iM5121a;
            InterfaceC2199f3 interfaceC2199f3 = (InterfaceC2199f3) atomicReferenceArray.get(length);
            for (InterfaceC2199f3 interfaceC2199f3Mo5106b = interfaceC2199f3; interfaceC2199f3Mo5106b != null; interfaceC2199f3Mo5106b = interfaceC2199f3Mo5106b.mo5106b()) {
                Object key = interfaceC2199f3Mo5106b.getKey();
                if (interfaceC2199f3Mo5106b.mo5107c() == iM5121a && key != null && abstractC2213h3M5122b.f7921a.f7857e.m3238c(obj, key)) {
                    Object value = interfaceC2199f3Mo5106b.getValue();
                    if (value == null) {
                        if (interfaceC2199f3Mo5106b.getValue() != null) {
                            break;
                        }
                        abstractC2213h3M5122b.f7923c++;
                        InterfaceC2199f3 interfaceC2199f3M5200i = abstractC2213h3M5122b.m5200i(interfaceC2199f3, interfaceC2199f3Mo5106b);
                        int i6 = abstractC2213h3M5122b.f7922b - 1;
                        atomicReferenceArray.set(length, interfaceC2199f3M5200i);
                        abstractC2213h3M5122b.f7922b = i6;
                        break;
                    }
                    if (!abstractC2213h3M5122b.f7921a.f7858f.mo5183d().mo5220a().m3238c(obj2, value)) {
                        break;
                    }
                    abstractC2213h3M5122b.f7923c++;
                    abstractC2213h3M5122b.m5203l(interfaceC2199f3Mo5106b, obj3);
                    return true;
                }
            }
            return false;
        } finally {
            abstractC2213h3M5122b.unlock();
        }
    }
}
