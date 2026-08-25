package p041d7;

import java.util.NoSuchElementException;
import java.util.Queue;

public abstract class AbstractC2246m1 extends AbstractC2218i1 implements Queue {
    @Override
    public abstract Queue delegate();

    @Override
    public Object element() {
        return delegate().element();
    }

    @Override
    public boolean offer(Object obj) {
        return delegate().offer(obj);
    }

    @Override
    public Object peek() {
        return delegate().peek();
    }

    @Override
    public Object poll() {
        return delegate().poll();
    }

    @Override
    public Object remove() {
        return delegate().remove();
    }

    public boolean standardOffer(Object obj) {
        try {
            return add(obj);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public Object standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    public Object standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
