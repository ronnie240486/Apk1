package p041d7;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class C2296t2 implements Iterator {

    public Iterator f8060a;

    public Iterator f8061b;

    public Iterator f8062c;

    public ArrayDeque f8063d;

    @Override
    public final boolean hasNext() {
        Iterator it;
        while (true) {
            Iterator it2 = this.f8061b;
            it2.getClass();
            if (it2.hasNext()) {
                return true;
            }
            while (true) {
                Iterator it3 = this.f8062c;
                if (it3 != null && it3.hasNext()) {
                    it = this.f8062c;
                    break;
                }
                ArrayDeque arrayDeque = this.f8063d;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    it = null;
                    break;
                }
                this.f8062c = (Iterator) this.f8063d.removeFirst();
            }
            this.f8062c = it;
            if (it == null) {
                return false;
            }
            Iterator it4 = (Iterator) it.next();
            this.f8061b = it4;
            if (it4 instanceof C2296t2) {
                C2296t2 c2296t2 = (C2296t2) it4;
                this.f8061b = c2296t2.f8061b;
                if (this.f8063d == null) {
                    this.f8063d = new ArrayDeque();
                }
                this.f8063d.addFirst(this.f8062c);
                if (c2296t2.f8063d != null) {
                    while (!c2296t2.f8063d.isEmpty()) {
                        this.f8063d.addFirst((Iterator) c2296t2.f8063d.removeLast());
                    }
                }
                this.f8062c = c2296t2.f8062c;
            }
        }
    }

    @Override
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Iterator it = this.f8061b;
        this.f8060a = it;
        return it.next();
    }

    @Override
    public final void remove() {
        Iterator it = this.f8060a;
        if (it == null) {
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
        it.remove();
        this.f8060a = null;
    }
}
