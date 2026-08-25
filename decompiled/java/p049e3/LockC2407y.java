package p049e3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class LockC2407y implements Lock {
    @Override
    public final Condition newCondition() {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override
    public final boolean tryLock() {
        return true;
    }

    @Override
    public final boolean tryLock(long j10, TimeUnit timeUnit) {
        return true;
    }

    @Override
    public final void lock() {
    }

    @Override
    public final void lockInterruptibly() {
    }

    @Override
    public final void unlock() {
    }
}
