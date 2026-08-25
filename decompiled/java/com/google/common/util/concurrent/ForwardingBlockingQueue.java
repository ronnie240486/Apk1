package com.google.common.util.concurrent;

import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import p041d7.AbstractC2246m1;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingBlockingQueue<E> extends AbstractC2246m1 implements BlockingQueue<E> {
    @Override
    public abstract BlockingQueue<E> delegate();

    @Override
    public int drainTo(Collection<? super E> collection, int i6) {
        return delegate().drainTo(collection, i6);
    }

    @Override
    public boolean offer(E e5, long j10, TimeUnit timeUnit) throws InterruptedException {
        return delegate().offer(e5, j10, timeUnit);
    }

    @Override
    public E poll(long j10, TimeUnit timeUnit) throws InterruptedException {
        return delegate().poll(j10, timeUnit);
    }

    @Override
    public void put(E e5) throws InterruptedException {
        delegate().put(e5);
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
    public int drainTo(Collection<? super E> collection) {
        return delegate().drainTo(collection);
    }
}
