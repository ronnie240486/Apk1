package p253x8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import p103j9.AbstractC2796i;
import p103j9.C2788a;
import p115k9.InterfaceC2905a;

public final class C4144g implements Collection, InterfaceC2905a {

    public final Object[] f14067a;

    public final boolean f14068b;

    public C4144g(Object[] objArr, boolean z7) {
        AbstractC2796i.m5785f(objArr, "values");
        this.f14067a = objArr;
        this.f14068b = z7;
    }

    @Override
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean contains(Object obj) {
        return AbstractC4146i.m8169B(this.f14067a, obj);
    }

    @Override
    public final boolean containsAll(Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!AbstractC4146i.m8169B(this.f14067a, it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final boolean isEmpty() {
        return this.f14067a.length == 0;
    }

    @Override
    public final Iterator iterator() {
        Object[] objArr = this.f14067a;
        AbstractC2796i.m5785f(objArr, "array");
        return new C2788a(objArr);
    }

    @Override
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return this.f14067a.length;
    }

    @Override
    public final Object[] toArray() {
        Object[] objArr = this.f14067a;
        AbstractC2796i.m5785f(objArr, "<this>");
        if (this.f14068b && objArr.getClass().equals(Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        AbstractC2796i.m5784e(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        AbstractC2796i.m5785f(objArr, "array");
        return AbstractC2796i.m5793n(this, objArr);
    }
}
