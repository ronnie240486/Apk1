package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import p020b7.AbstractC1332b;

@ElementTypesAreNonnullByDefault
public final class Monitor {
    private Guard activeGuards;
    private final boolean fair;
    private final ReentrantLock lock;

    public static abstract class Guard {
        final Condition condition;
        final Monitor monitor;
        Guard next;
        int waiterCount = 0;

        public Guard(Monitor monitor) {
            AbstractC1332b.m3219j(monitor, "monitor");
            this.monitor = monitor;
            this.condition = monitor.lock.newCondition();
        }

        public abstract boolean isSatisfied();
    }

    public Monitor() {
        this(false);
    }

    private void await(Guard guard, boolean z7) throws InterruptedException {
        if (z7) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.await();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    private boolean awaitNanos(Guard guard, long j10, boolean z7) throws InterruptedException {
        boolean z10 = true;
        while (j10 > 0) {
            if (z10) {
                if (z7) {
                    try {
                        signalNextWaiter();
                    } catch (Throwable th) {
                        if (!z10) {
                            endWaitingFor(guard);
                        }
                        throw th;
                    }
                }
                beginWaitingFor(guard);
                z10 = false;
            }
            j10 = guard.condition.awaitNanos(j10);
            if (guard.isSatisfied()) {
                if (!z10) {
                    endWaitingFor(guard);
                }
                return true;
            }
        }
        if (!z10) {
            endWaitingFor(guard);
        }
        return false;
    }

    private void awaitUninterruptibly(Guard guard, boolean z7) {
        if (z7) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.awaitUninterruptibly();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    private void beginWaitingFor(Guard guard) {
        int i6 = guard.waiterCount;
        guard.waiterCount = i6 + 1;
        if (i6 == 0) {
            guard.next = this.activeGuards;
            this.activeGuards = guard;
        }
    }

    private void endWaitingFor(Guard guard) {
        int i6 = guard.waiterCount - 1;
        guard.waiterCount = i6;
        if (i6 == 0) {
            Guard guard2 = this.activeGuards;
            Guard guard3 = null;
            while (guard2 != guard) {
                guard3 = guard2;
                guard2 = guard2.next;
            }
            if (guard3 == null) {
                this.activeGuards = guard2.next;
            } else {
                guard3.next = guard2.next;
            }
            guard2.next = null;
        }
    }

    private static long initNanoTime(long j10) {
        if (j10 <= 0) {
            return 0L;
        }
        long jNanoTime = System.nanoTime();
        if (jNanoTime == 0) {
            return 1L;
        }
        return jNanoTime;
    }

    private boolean isSatisfied(Guard guard) {
        try {
            return guard.isSatisfied();
        } catch (Throwable th) {
            signalAllWaiters();
            throw th;
        }
    }

    private static long remainingNanos(long j10, long j11) {
        if (j11 <= 0) {
            return 0L;
        }
        return j11 - (System.nanoTime() - j10);
    }

    private void signalAllWaiters() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            guard.condition.signalAll();
        }
    }

    private void signalNextWaiter() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            if (isSatisfied(guard)) {
                guard.condition.signal();
                return;
            }
        }
    }

    private static long toSafeNanos(long j10, TimeUnit timeUnit) {
        return Math.min(Math.max(timeUnit.toNanos(j10), 0L), 6917529027641081853L);
    }

    public void enter() {
        this.lock.lock();
    }

    public boolean enterIf(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean zIsSatisfied = guard.isSatisfied();
            if (!zIsSatisfied) {
                reentrantLock.unlock();
            }
            return zIsSatisfied;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public boolean enterIfInterruptibly(Guard guard) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        try {
            boolean zIsSatisfied = guard.isSatisfied();
            if (!zIsSatisfied) {
                reentrantLock.unlock();
            }
            return zIsSatisfied;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void enterInterruptibly() throws InterruptedException {
        this.lock.lockInterruptibly();
    }

    public void enterWhen(Guard guard) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lockInterruptibly();
        try {
            if (guard.isSatisfied()) {
                return;
            }
            await(guard, zIsHeldByCurrentThread);
        } catch (Throwable th) {
            leave();
            throw th;
        }
    }

    public void enterWhenUninterruptibly(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lock();
        try {
            if (guard.isSatisfied()) {
                return;
            }
            awaitUninterruptibly(guard, zIsHeldByCurrentThread);
        } catch (Throwable th) {
            leave();
            throw th;
        }
    }

    public int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }

    public int getQueueLength() {
        return this.lock.getQueueLength();
    }

    public int getWaitQueueLength(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        this.lock.lock();
        try {
            return guard.waiterCount;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean hasQueuedThread(Thread thread) {
        return this.lock.hasQueuedThread(thread);
    }

    public boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }

    public boolean hasWaiters(Guard guard) {
        return getWaitQueueLength(guard) > 0;
    }

    public boolean isFair() {
        return this.fair;
    }

    public boolean isOccupied() {
        return this.lock.isLocked();
    }

    public boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }

    public void leave() {
        ReentrantLock reentrantLock = this.lock;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                signalNextWaiter();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean tryEnter() {
        return this.lock.tryLock();
    }

    public boolean tryEnterIf(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        if (!reentrantLock.tryLock()) {
            return false;
        }
        try {
            boolean zIsSatisfied = guard.isSatisfied();
            if (!zIsSatisfied) {
                reentrantLock.unlock();
            }
            return zIsSatisfied;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void waitFor(Guard guard) throws InterruptedException {
        if (guard.monitor != this || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (guard.isSatisfied()) {
            return;
        }
        await(guard, true);
    }

    public void waitForUninterruptibly(Guard guard) {
        if (guard.monitor != this || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (guard.isSatisfied()) {
            return;
        }
        awaitUninterruptibly(guard, true);
    }

    public Monitor(boolean z7) {
        this.activeGuards = null;
        this.fair = z7;
        this.lock = new ReentrantLock(z7);
    }

    public boolean enter(long j10, TimeUnit timeUnit) throws Throwable {
        boolean zTryLock;
        long safeNanos = toSafeNanos(j10, timeUnit);
        ReentrantLock reentrantLock = this.lock;
        boolean z7 = true;
        if (!this.fair && reentrantLock.tryLock()) {
            return true;
        }
        boolean zInterrupted = Thread.interrupted();
        try {
            long jNanoTime = System.nanoTime();
            long jRemainingNanos = safeNanos;
            while (true) {
                try {
                    try {
                        zTryLock = reentrantLock.tryLock(jRemainingNanos, TimeUnit.NANOSECONDS);
                        break;
                    } catch (Throwable th) {
                        th = th;
                        if (z7) {
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    jRemainingNanos = remainingNanos(jNanoTime, safeNanos);
                    zInterrupted = true;
                }
            }
            if (zInterrupted) {
                Thread.currentThread().interrupt();
            }
            return zTryLock;
        } catch (Throwable th2) {
            th = th2;
            z7 = zInterrupted;
        }
    }

    public boolean enterInterruptibly(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.lock.tryLock(j10, timeUnit);
    }

    public boolean waitFor(Guard guard, long j10, TimeUnit timeUnit) throws InterruptedException {
        long safeNanos = toSafeNanos(j10, timeUnit);
        if (guard.monitor == this && this.lock.isHeldByCurrentThread()) {
            if (guard.isSatisfied()) {
                return true;
            }
            if (!Thread.interrupted()) {
                return awaitNanos(guard, safeNanos, true);
            }
            throw new InterruptedException();
        }
        throw new IllegalMonitorStateException();
    }

    public boolean waitForUninterruptibly(Guard guard, long j10, TimeUnit timeUnit) throws Throwable {
        long safeNanos = toSafeNanos(j10, timeUnit);
        if (guard.monitor == this && this.lock.isHeldByCurrentThread()) {
            boolean z7 = true;
            if (guard.isSatisfied()) {
                return true;
            }
            long jInitNanoTime = initNanoTime(safeNanos);
            boolean zInterrupted = Thread.interrupted();
            long jRemainingNanos = safeNanos;
            boolean z10 = true;
            while (true) {
                try {
                    try {
                        boolean zAwaitNanos = awaitNanos(guard, jRemainingNanos, z10);
                        if (zInterrupted) {
                            Thread.currentThread().interrupt();
                        }
                        return zAwaitNanos;
                    } catch (Throwable th) {
                        th = th;
                        if (z7) {
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    if (guard.isSatisfied()) {
                        Thread.currentThread().interrupt();
                        return true;
                    }
                    jRemainingNanos = remainingNanos(jInitNanoTime, safeNanos);
                    z10 = false;
                    zInterrupted = true;
                } catch (Throwable th2) {
                    th = th2;
                    z7 = zInterrupted;
                    if (z7) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean enterIf(Guard guard, long j10, TimeUnit timeUnit) {
        if (guard.monitor == this) {
            if (!enter(j10, timeUnit)) {
                return false;
            }
            try {
                boolean zIsSatisfied = guard.isSatisfied();
                if (!zIsSatisfied) {
                    this.lock.unlock();
                }
                return zIsSatisfied;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        throw new IllegalMonitorStateException();
    }

    public boolean enterIfInterruptibly(Guard guard, long j10, TimeUnit timeUnit) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            if (!reentrantLock.tryLock(j10, timeUnit)) {
                return false;
            }
            try {
                boolean zIsSatisfied = guard.isSatisfied();
                if (!zIsSatisfied) {
                    reentrantLock.unlock();
                }
                return zIsSatisfied;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        throw new IllegalMonitorStateException();
    }

    public boolean enterWhen(Guard guard, long j10, TimeUnit timeUnit) throws InterruptedException {
        long jInitNanoTime;
        boolean z7;
        long safeNanos = toSafeNanos(j10, timeUnit);
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            if (!this.fair) {
                if (!Thread.interrupted()) {
                    if (reentrantLock.tryLock()) {
                        jInitNanoTime = 0;
                    } else {
                        jInitNanoTime = initNanoTime(safeNanos);
                        if (!reentrantLock.tryLock(j10, timeUnit)) {
                            return false;
                        }
                    }
                } else {
                    throw new InterruptedException();
                }
            } else {
                jInitNanoTime = initNanoTime(safeNanos);
                if (!reentrantLock.tryLock(j10, timeUnit)) {
                    return false;
                }
            }
            try {
                if (!guard.isSatisfied()) {
                    if (jInitNanoTime != 0) {
                        safeNanos = remainingNanos(jInitNanoTime, safeNanos);
                    }
                    z7 = awaitNanos(guard, safeNanos, zIsHeldByCurrentThread);
                }
                if (!z7) {
                    reentrantLock.unlock();
                }
                return z7;
            } catch (Throwable th) {
                if (!zIsHeldByCurrentThread) {
                    try {
                        signalNextWaiter();
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                throw th;
            }
        }
        throw new IllegalMonitorStateException();
    }

    public boolean enterWhenUninterruptibly(Guard guard, long j10, TimeUnit timeUnit) throws Throwable {
        long jInitNanoTime;
        long jRemainingNanos;
        long safeNanos = toSafeNanos(j10, timeUnit);
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            boolean zInterrupted = Thread.interrupted();
            try {
                boolean zAwaitNanos = true;
                if (this.fair || !reentrantLock.tryLock()) {
                    jInitNanoTime = initNanoTime(safeNanos);
                    long jRemainingNanos2 = safeNanos;
                    while (true) {
                        try {
                            try {
                                break;
                            } catch (Throwable th) {
                                th = th;
                                zInterrupted = true;
                                if (zInterrupted) {
                                    Thread.currentThread().interrupt();
                                }
                                throw th;
                            }
                        } catch (InterruptedException unused) {
                            jRemainingNanos2 = remainingNanos(jInitNanoTime, safeNanos);
                            zInterrupted = true;
                        }
                    }
                    if (!reentrantLock.tryLock(jRemainingNanos2, TimeUnit.NANOSECONDS)) {
                        if (zInterrupted) {
                            Thread.currentThread().interrupt();
                        }
                        return false;
                    }
                } else {
                    jInitNanoTime = 0;
                }
                while (!guard.isSatisfied()) {
                    try {
                        if (jInitNanoTime == 0) {
                            jInitNanoTime = initNanoTime(safeNanos);
                            jRemainingNanos = safeNanos;
                        } else {
                            jRemainingNanos = remainingNanos(jInitNanoTime, safeNanos);
                        }
                        zAwaitNanos = awaitNanos(guard, jRemainingNanos, zIsHeldByCurrentThread);
                    } catch (InterruptedException unused2) {
                        zIsHeldByCurrentThread = false;
                        zInterrupted = true;
                    } catch (Throwable th2) {
                        reentrantLock.unlock();
                        throw th2;
                    }
                }
                if (!zAwaitNanos) {
                    reentrantLock.unlock();
                }
                if (zInterrupted) {
                    Thread.currentThread().interrupt();
                }
                return zAwaitNanos;
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }
}
