package com.google.common.util.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

@ElementTypesAreNonnullByDefault
abstract class ForwardingCondition implements Condition {
    @Override
    public void await() throws InterruptedException {
        delegate().await();
    }

    @Override
    public long awaitNanos(long j10) throws InterruptedException {
        return delegate().awaitNanos(j10);
    }

    @Override
    public void awaitUninterruptibly() {
        delegate().awaitUninterruptibly();
    }

    @Override
    public boolean awaitUntil(Date date) throws InterruptedException {
        return delegate().awaitUntil(date);
    }

    public abstract Condition delegate();

    @Override
    public void signal() {
        delegate().signal();
    }

    @Override
    public void signalAll() {
        delegate().signalAll();
    }

    @Override
    public boolean await(long j10, TimeUnit timeUnit) throws InterruptedException {
        return delegate().await(j10, timeUnit);
    }
}
