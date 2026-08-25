package p041d7;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;

public abstract class AbstractC2274q1 extends AbstractCollection implements Serializable {

    public static final Object[] f8028a = new Object[0];

    @Override
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public AbstractC2301u1 mo5167c() {
        if (isEmpty()) {
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            return C2180c5.f7862e;
        }
        Object[] array = toArray(f8028a);
        C2204g1 c2204g2 = AbstractC2301u1.f8069b;
        return AbstractC2301u1.m5268j(array, array.length);
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract boolean contains(Object obj);

    public int mo5123d(Object[] objArr, int i6) {
        AbstractC2292s5 it = iterator();
        while (it.hasNext()) {
            objArr[i6] = it.next();
            i6++;
        }
        return i6;
    }

    public Object[] mo5124e() {
        return null;
    }

    public int mo5125f() {
        throw new UnsupportedOperationException();
    }

    public int mo5126g() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean mo5127h();

    @Override
    public abstract AbstractC2292s5 iterator();

    @Override
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Spliterator spliterator() {
        return Spliterators.spliterator(this, 1296);
    }

    @Override
    public final Object[] toArray() {
        return toArray(f8028a);
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int size = size();
        if (objArr.length < size) {
            Object[] objArrMo5124e = mo5124e();
            if (objArrMo5124e != null) {
                return Arrays.copyOfRange(objArrMo5124e, mo5126g(), mo5125f(), objArr.getClass());
            }
            if (objArr.length != 0) {
                objArr = Arrays.copyOf(objArr, 0);
            }
            objArr = Arrays.copyOf(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        mo5123d(objArr, 0);
        return objArr;
    }
}
