package p041d7;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;
import p000a.AbstractC0004e;
import p020b7.AbstractC1332b;
import p020b7.C1356p;
import p020b7.InterfaceC1346i;
import p020b7.InterfaceC1354n;
import p055ea.AbstractC2460q;

public abstract class AbstractC2182d0 {
    public static int m5129A(int i6) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i6) * (-862048943)), 15)) * 461845907);
    }

    public static int m5130B(Object obj) {
        return m5129A(obj == null ? 0 : obj.hashCode());
    }

    public static int m5131C(int i6, Object obj) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i6] & 255;
        }
        return obj instanceof short[] ? ((short[]) obj)[i6] & 65535 : ((int[]) obj)[i6];
    }

    public static void m5132D(int i6, int i10, Object obj) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i6] = (byte) i10;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i6] = (short) i10;
        } else {
            ((int[]) obj)[i6] = i10;
        }
    }

    public static int m5133E(int i6) {
        int iMax = Math.max(i6 + 1, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax > ((int) (1.0d * ((double) iHighestOneBit)))) {
            int i10 = iHighestOneBit << 1;
            iHighestOneBit = i10 > 0 ? i10 : 1073741824;
        }
        return Math.max(4, iHighestOneBit);
    }

    public static String m5134F(Iterable iterable) {
        Iterator it = iterable.iterator();
        StringBuilder sb = new StringBuilder("[");
        boolean z7 = true;
        while (it.hasNext()) {
            if (!z7) {
                sb.append(", ");
            }
            sb.append(it.next());
            z7 = false;
        }
        sb.append(']');
        return sb.toString();
    }

    public static String m5135G(Map map) {
        int size = map.size();
        m5141d(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('{');
        boolean z7 = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z7) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z7 = false;
        }
        sb.append('}');
        return sb.toString();
    }

    public static AbstractList m5136H(List list, InterfaceC1346i interfaceC1346i) {
        return list instanceof RandomAccess ? new C2320x2(list, interfaceC1346i) : new C2332z2(list, interfaceC1346i);
    }

    public static NavigableSet m5137I(NavigableSet navigableSet) {
        return ((navigableSet instanceof AbstractC2274q1) || (navigableSet instanceof C2278q5)) ? navigableSet : new C2278q5(navigableSet);
    }

    public static boolean m5138a(Collection collection, Iterator it) {
        collection.getClass();
        it.getClass();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static void m5139b(Object[] objArr, int i6) {
        for (int i10 = 0; i10 < i6; i10++) {
            if (objArr[i10] == null) {
                throw new NullPointerException(AbstractC0004e.m20n(i10, "at index "));
            }
        }
    }

    public static void m5140c(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException(AbstractC2460q.m5493g(obj2, "null key in entry: null="));
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    public static void m5141d(int i6, String str) {
        if (i6 >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i6);
    }

    public static void m5142e(Iterator it) {
        it.getClass();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static boolean m5143f(Iterator it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static Object m5144g(int i6) {
        if (i6 < 2 || i6 > 1073741824 || Integer.highestOneBit(i6) != i6) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "must be power of 2 between 2^1 and 2^30: "));
        }
        if (i6 <= 256) {
            return new byte[i6];
        }
        return i6 <= 65536 ? new short[i6] : new int[i6];
    }

    public static boolean m5145h(InterfaceC2310v4 interfaceC2310v4, Object obj) {
        if (obj == interfaceC2310v4) {
            return true;
        }
        if (obj instanceof InterfaceC2310v4) {
            InterfaceC2310v4 interfaceC2310v5 = (InterfaceC2310v4) obj;
            if (interfaceC2310v4.size() == interfaceC2310v5.size() && interfaceC2310v4.entrySet().size() == interfaceC2310v5.entrySet().size()) {
                for (AbstractC2316w4 abstractC2316w4 : interfaceC2310v5.entrySet()) {
                    if (interfaceC2310v4.count(abstractC2316w4.mo5265b()) != abstractC2316w4.mo5264a()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean m5146i(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static boolean m5147j(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static C2189e0 m5148k(Collection collection, InterfaceC1354n interfaceC1354n) {
        if (!(collection instanceof C2189e0)) {
            collection.getClass();
            return new C2189e0(collection, interfaceC1354n);
        }
        C2189e0 c2189e0 = (C2189e0) collection;
        return new C2189e0(c2189e0.f7876a, AbstractC1332b.m3210a(c2189e0.f7877b, interfaceC1354n));
    }

    public static C2257n5 m5149l(Set set, InterfaceC1354n interfaceC1354n) {
        if (!(set instanceof SortedSet)) {
            if (set instanceof C2257n5) {
                C2257n5 c2257n5 = (C2257n5) set;
                return new C2257n5((Set) c2257n5.f7876a, AbstractC1332b.m3210a(c2257n5.f7877b, interfaceC1354n));
            }
            set.getClass();
            interfaceC1354n.getClass();
            return new C2257n5(set, interfaceC1354n);
        }
        Collection collection = (SortedSet) set;
        if (collection instanceof C2257n5) {
            C2257n5 c2257n6 = (C2257n5) collection;
            return new C2264o5((SortedSet) c2257n6.f7876a, AbstractC1332b.m3210a(c2257n6.f7877b, interfaceC1354n));
        }
        collection.getClass();
        interfaceC1354n.getClass();
        return new C2264o5(collection, interfaceC1354n);
    }

    public static InterfaceC2243l5 m5150m(InterfaceC2243l5 interfaceC2243l5, InterfaceC1354n interfaceC1354n) {
        if (interfaceC2243l5 instanceof C2176c1) {
            C2176c1 c2176c1 = (C2176c1) interfaceC2243l5;
            return new C2176c1(c2176c1.f7848f, AbstractC1332b.m3210a(c2176c1.f7849g, interfaceC1354n));
        }
        if (!(interfaceC2243l5 instanceof InterfaceC2190e1)) {
            return new C2176c1(interfaceC2243l5, interfaceC1354n);
        }
        InterfaceC2190e1 interfaceC2190e1 = (InterfaceC2190e1) interfaceC2243l5;
        return new C2324y0(interfaceC2190e1.mo5109b(), AbstractC1332b.m3210a(interfaceC2190e1.mo5110c(), new C1356p(interfaceC1354n, EnumC2221i4.f7943a)));
    }

    public static Object m5151n(Iterable iterable) {
        Object next;
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                throw new NoSuchElementException();
            }
            return list.get(list.size() - 1);
        }
        Iterator it = iterable.iterator();
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static Object m5152o(Iterable iterable) {
        Object next = null;
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return null;
            }
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.get(list.size() - 1);
            }
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            do {
                next = it.next();
            } while (it.hasNext());
        }
        return next;
    }

    public static int m5153p(Set set) {
        Iterator it = set.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i6 = ~(~(i6 + (next != null ? next.hashCode() : 0)));
        }
        return i6;
    }

    public static C2250m5 m5154q(AbstractC2233k2 abstractC2233k2, AbstractC2233k2 abstractC2233k3) {
        AbstractC1332b.m3219j(abstractC2233k2, "set1");
        AbstractC1332b.m3219j(abstractC2233k3, "set2");
        return new C2250m5(abstractC2233k2, abstractC2233k3);
    }

    public static int m5155r(int i6, int i10, int i11) {
        return (i6 & (~i11)) | (i10 & i11);
    }

    public static ArrayList m5156s(Iterator it) {
        ArrayList arrayList = new ArrayList();
        m5138a(arrayList, it);
        return arrayList;
    }

    public static ArrayList m5157t(int i6) {
        m5141d(i6, "initialArraySize");
        return new ArrayList(i6);
    }

    public static int m5158u(int i6) {
        return (i6 + 1) * (i6 < 32 ? 4 : 2);
    }

    public static Object m5159v(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        it.remove();
        return next;
    }

    public static int m5160w(Object obj, Object obj2, int i6, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int iM5130B = m5130B(obj);
        int i10 = iM5130B & i6;
        int iM5131C = m5131C(i10, obj3);
        if (iM5131C == 0) {
            return -1;
        }
        int i11 = ~i6;
        int i12 = iM5130B & i11;
        int i13 = -1;
        while (true) {
            int i14 = iM5131C - 1;
            int i15 = iArr[i14];
            if ((i15 & i11) == i12 && AbstractC1332b.m3225p(obj, objArr[i14]) && (objArr2 == null || AbstractC1332b.m3225p(obj2, objArr2[i14]))) {
                int i16 = i15 & i6;
                if (i13 == -1) {
                    m5132D(i10, i16, obj3);
                } else {
                    iArr[i13] = m5155r(iArr[i13], i16, i6);
                }
                return i14;
            }
            int i17 = i15 & i6;
            if (i17 == 0) {
                return -1;
            }
            i13 = i14;
            iM5131C = i17;
        }
    }

    public static boolean m5161x(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof InterfaceC2310v4) {
            collection = ((InterfaceC2310v4) collection).elementSet();
        }
        boolean zRemove = false;
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                zRemove |= set.remove(it.next());
            }
            return zRemove;
        }
        Iterator it2 = set.iterator();
        collection.getClass();
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                zRemove = true;
            }
        }
        return zRemove;
    }

    public static boolean m5162y(Iterable iterable, InterfaceC1354n interfaceC1354n) {
        boolean z7 = false;
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            interfaceC1354n.getClass();
            while (it.hasNext()) {
                if (interfaceC1354n.apply(it.next())) {
                    it.remove();
                    z7 = true;
                }
            }
            return z7;
        }
        List list = (List) iterable;
        interfaceC1354n.getClass();
        int i6 = 0;
        int i10 = 0;
        while (i6 < list.size()) {
            Object obj = list.get(i6);
            if (!interfaceC1354n.apply(obj)) {
                if (i6 > i10) {
                    try {
                        list.set(i10, obj);
                    } catch (IllegalArgumentException unused) {
                        m5163z(list, interfaceC1354n, i10, i6);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        m5163z(list, interfaceC1354n, i10, i6);
                        return true;
                    }
                }
                i10++;
            }
            i6++;
        }
        list.subList(i10, list.size()).clear();
        return i6 != i10;
    }

    public static void m5163z(List list, InterfaceC1354n interfaceC1354n, int i6, int i10) {
        for (int size = list.size() - 1; size > i10; size--) {
            if (interfaceC1354n.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i11 = i10 - 1; i11 >= i6; i11--) {
            list.remove(i11);
        }
    }
}
