package p041d7;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import p020b7.InterfaceC1354n;

public final class C2264o5 extends C2257n5 implements SortedSet {
    @Override
    public final Comparator comparator() {
        return ((SortedSet) this.f7876a).comparator();
    }

    @Override
    public final Object first() {
        Iterator it = this.f7876a.iterator();
        it.getClass();
        InterfaceC1354n interfaceC1354n = this.f7877b;
        interfaceC1354n.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            if (interfaceC1354n.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public final SortedSet headSet(Object obj) {
        return new C2264o5(((SortedSet) this.f7876a).headSet(obj), this.f7877b);
    }

    @Override
    public final Object last() {
        SortedSet sortedSetHeadSet = (SortedSet) this.f7876a;
        while (true) {
            Object objLast = sortedSetHeadSet.last();
            if (this.f7877b.apply(objLast)) {
                return objLast;
            }
            sortedSetHeadSet = sortedSetHeadSet.headSet(objLast);
        }
    }

    @Override
    public final SortedSet subSet(Object obj, Object obj2) {
        return new C2264o5(((SortedSet) this.f7876a).subSet(obj, obj2), this.f7877b);
    }

    @Override
    public final SortedSet tailSet(Object obj) {
        return new C2264o5(((SortedSet) this.f7876a).tailSet(obj), this.f7877b);
    }
}
