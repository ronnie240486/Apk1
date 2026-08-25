package p041d7;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import p020b7.AbstractC1332b;

public abstract class AbstractC2218i1 extends AbstractC2239l1 implements Collection {
    public boolean add(Object obj) {
        return delegate().add(obj);
    }

    public boolean addAll(Collection<Object> collection) {
        return delegate().addAll(collection);
    }

    @Override
    public void clear() {
        delegate().clear();
    }

    @Override
    public boolean contains(Object obj) {
        return delegate().contains(obj);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return delegate().containsAll(collection);
    }

    @Override
    public abstract Collection delegate();

    @Override
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Iterator<Object> iterator() {
        return delegate().iterator();
    }

    public boolean remove(Object obj) {
        return delegate().remove(obj);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return delegate().removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return delegate().retainAll(collection);
    }

    @Override
    public int size() {
        return delegate().size();
    }

    public boolean standardAddAll(Collection<Object> collection) {
        return AbstractC2182d0.m5138a(this, collection.iterator());
    }

    public void standardClear() {
        AbstractC2182d0.m5142e(iterator());
    }

    public boolean standardContains(Object obj) {
        return AbstractC2182d0.m5143f(iterator(), obj);
    }

    public boolean standardContainsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    public boolean standardRemove(Object obj) {
        Iterator<Object> it = iterator();
        while (it.hasNext()) {
            if (AbstractC1332b.m3225p(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean standardRemoveAll(Collection<?> collection) {
        Iterator<Object> it = iterator();
        collection.getClass();
        boolean z7 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    public boolean standardRetainAll(Collection<?> collection) {
        Iterator<Object> it = iterator();
        collection.getClass();
        boolean z7 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    public <T> T[] standardToArray(T[] tArr) {
        int size = size();
        int i6 = 0;
        if (tArr.length < size) {
            if (tArr.length != 0) {
                tArr = (T[]) Arrays.copyOf(tArr, 0);
            }
            tArr = (T[]) Arrays.copyOf(tArr, size);
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            tArr[i6] = it.next();
            i6++;
        }
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    public String standardToString() {
        int size = size();
        AbstractC2182d0.m5141d(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('[');
        boolean z7 = true;
        for (Object obj : this) {
            if (!z7) {
                sb.append(", ");
            }
            if (obj == this) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
            z7 = false;
        }
        sb.append(']');
        return sb.toString();
    }

    @Override
    public Object[] toArray() {
        return delegate().toArray();
    }

    @Override
    public <T> T[] toArray(T[] tArr) {
        return (T[]) delegate().toArray(tArr);
    }

    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }
}
