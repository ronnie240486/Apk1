package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@ElementTypesAreNonnullByDefault
abstract class ForwardingLock implements Lock {
    public abstract Lock delegate();

    @Override
    public void lock() {
        delegate().lock();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        delegate().lockInterruptibly();
    }

    @Override
    public Condition newCondition() {
        return delegate().newCondition();
    }

    @Override
    public boolean tryLock() {
        return delegate().tryLock();
    }

    @Override
    public void unlock() {
        delegate().unlock();
    }

    @Override
    public boolean tryLock(long j10, TimeUnit timeUnit) throws InterruptedException {
        return delegate().tryLock(j10, timeUnit);
    }
}
