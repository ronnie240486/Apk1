package com.google.common.util.concurrent;

import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import p041d7.AbstractC2225j1;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingBlockingDeque<E> extends AbstractC2225j1 implements BlockingDeque<E> {
    @Override
    public abstract BlockingDeque<E> delegate();

    @Override
    public int drainTo(Collection<? super E> collection) {
        return delegate().drainTo(collection);
    }

    @Override
    public boolean offer(E e5, long j10, TimeUnit timeUnit) throws InterruptedException {
        return delegate().offer(e5, j10, timeUnit);
    }

    @Override
    public boolean offerFirst(E e5, long j10, TimeUnit timeUnit) throws InterruptedException {
        return delegate().offerFirst(e5, j10, timeUnit);
    }

    @Override
    public boolean offerLast(E e5, long j10, TimeUnit timeUnit) throws InterruptedException {
        return delegate().offerLast(e5, j10, timeUnit);
    }

    @Override
    public E poll(long j10, TimeUnit timeUnit) throws InterruptedException {
        return delegate().poll(j10, timeUnit);
    }

    @Override
    public E pollFirst(long j10, TimeUnit timeUnit) throws InterruptedException {
        return delegate().pollFirst(j10, timeUnit);
    }

    @Override
    public E pollLast(long j10, TimeUnit timeUnit) throws InterruptedException {
        return delegate().pollLast(j10, timeUnit);
    }

    @Override
    public void put(E e5) throws InterruptedException {
        delegate().put(e5);
    }

    @Override
    public void putFirst(E e5) throws InterruptedException {
        delegate().putFirst(e5);
    }

    @Override
    public void putLast(E e5) throws InterruptedException {
        delegate().putLast(e5);
    }

    @Override
    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    @Override
    public E take() throws InterruptedException {
        return delegate().take();
    }

    @Override
    public E takeFirst() throws InterruptedException {
        return delegate().takeFirst();
    }

    @Override
    public E takeLast() throws InterruptedException {
        return delegate().takeLast();
    }

    @Override
    public int drainTo(Collection<? super E> collection, int i6) {
        return delegate().drainTo(collection, i6);
    }
}
