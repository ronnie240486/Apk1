package p041d7;

import java.util.Deque;
import java.util.Iterator;

public abstract class AbstractC2225j1 extends AbstractC2246m1 implements Deque {
    @Override
    public void addFirst(Object obj) {
        delegate().addFirst(obj);
    }

    @Override
    public void addLast(Object obj) {
        delegate().addLast(obj);
    }

    @Override
    public abstract Deque delegate();

    @Override
    public Iterator<Object> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override
    public Object getFirst() {
        return delegate().getFirst();
    }

    @Override
    public Object getLast() {
        return delegate().getLast();
    }

    @Override
    public boolean offerFirst(Object obj) {
        return delegate().offerFirst(obj);
    }

    @Override
    public boolean offerLast(Object obj) {
        return delegate().offerLast(obj);
    }

    @Override
    public Object peekFirst() {
        return delegate().peekFirst();
    }

    @Override
    public Object peekLast() {
        return delegate().peekLast();
    }

    @Override
    public Object pollFirst() {
        return delegate().pollFirst();
    }

    @Override
    public Object pollLast() {
        return delegate().pollLast();
    }

    @Override
    public Object pop() {
        return delegate().pop();
    }

    @Override
    public void push(Object obj) {
        delegate().push(obj);
    }

    @Override
    public Object removeFirst() {
        return delegate().removeFirst();
    }

    @Override
    public boolean removeFirstOccurrence(Object obj) {
        return delegate().removeFirstOccurrence(obj);
    }

    @Override
    public Object removeLast() {
        return delegate().removeLast();
    }

    @Override
    public boolean removeLastOccurrence(Object obj) {
        return delegate().removeLastOccurrence(obj);
    }
}
