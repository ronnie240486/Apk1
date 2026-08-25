package p041d7;

import com.google.common.util.concurrent.ClosingFuture;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import p020b7.AbstractC1332b;
import p020b7.InterfaceC1346i;
import p187r4.AbstractC3612b;

public final class C2320x2 extends AbstractList implements Serializable, RandomAccess {

    public final int f8092a = 0;

    public final Object f8093b;

    public final Object f8094c;

    public C2320x2(ClosingFuture closingFuture, Object[] objArr) {
        this.f8093b = closingFuture;
        objArr.getClass();
        this.f8094c = objArr;
    }

    @Override
    public final Object get(int i6) {
        switch (this.f8092a) {
            case 0:
                AbstractC1332b.m3217h(i6, size());
                if (i6 == 0) {
                    return (ClosingFuture) this.f8093b;
                }
                return ((Object[]) this.f8094c)[i6 - 1];
            default:
                return ((InterfaceC1346i) this.f8094c).apply(((List) this.f8093b).get(i6));
        }
    }

    @Override
    public boolean isEmpty() {
        switch (this.f8092a) {
            case 1:
                return ((List) this.f8093b).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override
    public Iterator iterator() {
        switch (this.f8092a) {
            case 1:
                return listIterator();
            default:
                return super.iterator();
        }
    }

    @Override
    public ListIterator listIterator(int i6) {
        switch (this.f8092a) {
            case 1:
                return new C2326y2(this, ((List) this.f8093b).listIterator(i6), 0);
            default:
                return super.listIterator(i6);
        }
    }

    @Override
    public Object remove(int i6) {
        switch (this.f8092a) {
            case 1:
                return ((InterfaceC1346i) this.f8094c).apply(((List) this.f8093b).remove(i6));
            default:
                return super.remove(i6);
        }
    }

    @Override
    public void removeRange(int i6, int i10) {
        switch (this.f8092a) {
            case 1:
                ((List) this.f8093b).subList(i6, i10).clear();
                break;
            default:
                super.removeRange(i6, i10);
                break;
        }
    }

    @Override
    public final int size() {
        switch (this.f8092a) {
            case 0:
                return AbstractC3612b.m7255K(((long) ((Object[]) this.f8094c).length) + ((long) 1));
            default:
                return ((List) this.f8093b).size();
        }
    }

    public C2320x2(List list, InterfaceC1346i interfaceC1346i) {
        list.getClass();
        this.f8093b = list;
        this.f8094c = interfaceC1346i;
    }
}
