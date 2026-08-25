package p041d7;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

public abstract class AbstractC2260o1 extends AbstractC2253n1 implements SortedSet {
    @Override
    public final Comparator comparator() {
        return ((C2278q5) this).f8034b.comparator();
    }

    @Override
    public final Object first() {
        return ((C2278q5) this).f8034b.first();
    }

    @Override
    public final SortedSet headSet(Object obj) {
        return ((C2278q5) this).f8034b.headSet(obj);
    }

    @Override
    public final Object last() {
        return ((C2278q5) this).f8034b.last();
    }

    @Override
    public final boolean standardContains(Object obj) {
        try {
            Object objFirst = tailSet(obj).first();
            Comparator comparator = comparator();
            return (comparator == null ? ((Comparable) objFirst).compareTo(obj) : comparator.compare(objFirst, obj)) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override
    public final boolean standardRemove(Object obj) {
        try {
            Iterator it = tailSet(obj).iterator();
            if (it.hasNext()) {
                Object next = it.next();
                Comparator comparator = comparator();
                if ((comparator == null ? ((Comparable) next).compareTo(obj) : comparator.compare(next, obj)) == 0) {
                    it.remove();
                    return true;
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    @Override
    public final SortedSet subSet(Object obj, Object obj2) {
        return ((C2278q5) this).f8034b.subSet(obj, obj2);
    }

    @Override
    public final SortedSet tailSet(Object obj) {
        return ((C2278q5) this).f8034b.tailSet(obj);
    }
}
