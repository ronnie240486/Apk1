package p041d7;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import p020b7.AbstractC1332b;

public abstract class AbstractC2301u1 extends AbstractC2274q1 implements List, RandomAccess {

    public static final C2204g1 f8069b = new C2204g1(C2180c5.f7862e, 0);

    public static C2180c5 m5268j(Object[] objArr, int i6) {
        return i6 == 0 ? C2180c5.f7862e : new C2180c5(objArr, i6);
    }

    public static C2288s1 m5269k() {
        return new C2288s1(4);
    }

    public static C2288s1 m5270l(int i6) {
        AbstractC2182d0.m5141d(i6, "expectedSize");
        return new C2288s1(i6);
    }

    public static AbstractC2301u1 m5271m(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return m5272n((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return C2180c5.f7862e;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return m5275r(next);
        }
        C2288s1 c2288s1 = new C2288s1(4);
        c2288s1.m5255a(next);
        while (it.hasNext()) {
            c2288s1.m5255a(it.next());
        }
        return c2288s1.m5262g();
    }

    public static AbstractC2301u1 m5272n(Collection collection) {
        if (!(collection instanceof AbstractC2274q1)) {
            Object[] array = collection.toArray();
            AbstractC2182d0.m5139b(array, array.length);
            return m5268j(array, array.length);
        }
        AbstractC2301u1 abstractC2301u1Mo5167c = ((AbstractC2274q1) collection).mo5167c();
        if (!abstractC2301u1Mo5167c.mo5127h()) {
            return abstractC2301u1Mo5167c;
        }
        Object[] array2 = abstractC2301u1Mo5167c.toArray(AbstractC2274q1.f8028a);
        return m5268j(array2, array2.length);
    }

    public static C2180c5 m5273o(Object[] objArr) {
        if (objArr.length == 0) {
            return C2180c5.f7862e;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        AbstractC2182d0.m5139b(objArr2, objArr2.length);
        return m5268j(objArr2, objArr2.length);
    }

    public static C2180c5 m5274q() {
        return C2180c5.f7862e;
    }

    public static C2180c5 m5275r(Object obj) {
        Object[] objArr = {obj};
        AbstractC2182d0.m5139b(objArr, 1);
        return m5268j(objArr, 1);
    }

    public static C2180c5 m5276s(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        AbstractC2182d0.m5139b(objArr, 2);
        return m5268j(objArr, 2);
    }

    public static C2180c5 m5277t(Object obj, Object obj2, Object obj3) {
        Object[] objArr = {obj, obj2, obj3};
        AbstractC2182d0.m5139b(objArr, 3);
        return m5268j(objArr, 3);
    }

    public static C2180c5 m5278u(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5};
        AbstractC2182d0.m5139b(objArr, 5);
        return m5268j(objArr, 5);
    }

    public static C2180c5 m5279v(AbstractC2173b5 abstractC2173b5, List list) {
        abstractC2173b5.getClass();
        if (!(list instanceof Collection)) {
            list = AbstractC2182d0.m5156s(list.iterator());
        }
        Object[] array = list.toArray();
        AbstractC2182d0.m5139b(array, array.length);
        Arrays.sort(array, abstractC2173b5);
        return m5268j(array, array.length);
    }

    @Override
    public final void add(int i6, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(int i6, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override
    public int mo5123d(Object[] objArr, int i6) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            objArr[i6 + i10] = get(i10);
        }
        return i6 + size;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i6 = 0; i6 < size; i6++) {
                        if (AbstractC1332b.m3225p(get(i6), list.get(i6))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (it.hasNext()) {
                    if (it2.hasNext() && AbstractC1332b.m3225p(it.next(), it2.next())) {
                    }
                }
                return !it2.hasNext();
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int size = size();
        int i6 = 1;
        for (int i10 = 0; i10 < size; i10++) {
            i6 = ~(~(get(i10).hashCode() + (i6 * 31)));
        }
        return i6;
    }

    @Override
    public final AbstractC2292s5 iterator() {
        return listIterator(0);
    }

    @Override
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            if (obj.equals(get(i6))) {
                return i6;
            }
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override
    public final C2204g1 listIterator(int i6) {
        AbstractC1332b.m3220k(i6, size());
        return isEmpty() ? f8069b : new C2204g1(this, i6);
    }

    @Override
    public final Object remove(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Object set(int i6, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AbstractC2301u1 subList(int i6, int i10) {
        AbstractC1332b.m3221l(i6, i10, size());
        int i11 = i10 - i6;
        if (i11 == size()) {
            return this;
        }
        return i11 == 0 ? C2180c5.f7862e : new C2295t1(this, i6, i11);
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override
    public final AbstractC2301u1 mo5167c() {
        return this;
    }
}
