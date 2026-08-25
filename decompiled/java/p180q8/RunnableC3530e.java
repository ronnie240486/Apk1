package p180q8;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import p102j8.C2786a;

public final class RunnableC3530e implements Runnable {

    public final long f11900a;

    public final ConcurrentLinkedQueue f11901b;

    public final C2786a f11902c;

    public final ScheduledExecutorService f11903d;

    public final ScheduledFuture f11904e;

    public final ThreadFactoryC3536k f11905f;

    public RunnableC3530e(long j10, TimeUnit timeUnit, ThreadFactoryC3536k threadFactoryC3536k) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
        ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
        long nanos = timeUnit != null ? timeUnit.toNanos(j10) : 0L;
        this.f11900a = nanos;
        this.f11901b = new ConcurrentLinkedQueue();
        this.f11902c = new C2786a(0);
        this.f11905f = threadFactoryC3536k;
        if (timeUnit != null) {
            scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, C3533h.f11912c);
            scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
        } else {
            scheduledExecutorServiceNewScheduledThreadPool = null;
            scheduledFutureScheduleWithFixedDelay = null;
        }
        this.f11903d = scheduledExecutorServiceNewScheduledThreadPool;
        this.f11904e = scheduledFutureScheduleWithFixedDelay;
    }

    @Override
    public final void run() {
        ConcurrentLinkedQueue<C3532g> concurrentLinkedQueue = this.f11901b;
        if (concurrentLinkedQueue.isEmpty()) {
            return;
        }
        long jNanoTime = System.nanoTime();
        for (C3532g c3532g : concurrentLinkedQueue) {
            if (c3532g.f11910c > jNanoTime) {
                return;
            }
            if (concurrentLinkedQueue.remove(c3532g)) {
                this.f11902c.m5775h(c3532g);
            }
        }
    }
}
