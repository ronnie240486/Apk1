package com.google.common.util.concurrent;

import androidx.fragment.app.C0423q;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@ElementTypesAreNonnullByDefault
public final class Uninterruptibles {
    private Uninterruptibles() {
    }

    public static void awaitTerminationUninterruptibly(ExecutorService executorService) {
        if (!awaitTerminationUninterruptibly(executorService, Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
            throw new C0423q(1);
        }
    }

    public static void awaitUninterruptibly(CountDownLatch countDownLatch) {
        boolean z7 = false;
        while (true) {
            try {
                countDownLatch.await();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
    }

    @ParametricNullness
    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v10;
        boolean z7 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    public static void joinUninterruptibly(Thread thread) {
        boolean z7 = false;
        while (true) {
            try {
                thread.join();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
    }

    public static <E> void putUninterruptibly(BlockingQueue<E> blockingQueue, E e5) {
        boolean z7 = false;
        while (true) {
            try {
                blockingQueue.put(e5);
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
    }

    public static void sleepUninterruptibly(long j10, TimeUnit timeUnit) {
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j10);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    TimeUnit.NANOSECONDS.sleep(nanos);
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
        } catch (Throwable th) {
            if (z7) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static <E> E takeUninterruptibly(BlockingQueue<E> blockingQueue) {
        E eTake;
        boolean z7 = false;
        while (true) {
            try {
                eTake = blockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
        return eTake;
    }

    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, long j10, TimeUnit timeUnit) {
        return tryAcquireUninterruptibly(semaphore, 1, j10, timeUnit);
    }

    public static boolean tryLockUninterruptibly(Lock lock, long j10, TimeUnit timeUnit) {
        boolean zTryLock;
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j10);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    zTryLock = lock.tryLock(nanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
            return zTryLock;
        } catch (Throwable th) {
            if (z7) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, int i6, long j10, TimeUnit timeUnit) {
        boolean zTryAcquire;
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j10);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    zTryAcquire = semaphore.tryAcquire(i6, nanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
            return zTryAcquire;
        } catch (Throwable th) {
            if (z7) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j10, TimeUnit timeUnit) {
        boolean zAwait;
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j10);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    zAwait = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
            return zAwait;
        } catch (Throwable th) {
            if (z7) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @ParametricNullness
    public static <V> V getUninterruptibly(Future<V> future, long j10, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        V v10;
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j10);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    v10 = future.get(nanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
            return v10;
        } catch (Throwable th) {
            if (z7) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static void joinUninterruptibly(Thread thread, long j10, TimeUnit timeUnit) {
        thread.getClass();
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j10);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    TimeUnit.NANOSECONDS.timedJoin(thread, nanos);
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
        } catch (Throwable th) {
            if (z7) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static boolean awaitTerminationUninterruptibly(ExecutorService executorService, long j10, TimeUnit timeUnit) {
        boolean zAwaitTermination;
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j10);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    zAwaitTermination = executorService.awaitTermination(nanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
            return zAwaitTermination;
        } catch (Throwable th) {
            if (z7) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static boolean awaitUninterruptibly(Condition condition, long j10, TimeUnit timeUnit) {
        boolean zAwait;
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j10);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    zAwait = condition.await(nanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
            return zAwait;
        } catch (Throwable th) {
            if (z7) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }
}
