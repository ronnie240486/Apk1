package p041d7;

import java.util.Iterator;

public abstract class AbstractC2285r5 implements Iterator {

    public final Iterator f8044a;

    public AbstractC2285r5(Iterator it) {
        it.getClass();
        this.f8044a = it;
    }

    public abstract Object mo5172a(Object obj);

    @Override
    public final boolean hasNext() {
        return this.f8044a.hasNext();
    }

    @Override
    public final Object next() {
        return mo5172a(this.f8044a.next());
    }

    @Override
    public final void remove() {
        this.f8044a.remove();
    }
}
