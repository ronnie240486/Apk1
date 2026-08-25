package p004a3;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ExecutorServiceC0041f implements ExecutorService {

    public static final long f116b = TimeUnit.SECONDS.toMillis(10);

    public static volatile int f117c;

    public final ThreadPoolExecutor f118a;

    public ExecutorServiceC0041f(ThreadPoolExecutor threadPoolExecutor) {
        this.f118a = threadPoolExecutor;
    }

    @Override
    public final boolean awaitTermination(long j10, TimeUnit timeUnit) {
        return this.f118a.awaitTermination(j10, timeUnit);
    }

    @Override
    public final void execute(Runnable runnable) {
        this.f118a.execute(runnable);
    }

    @Override
    public final List invokeAll(Collection collection) {
        return this.f118a.invokeAll(collection);
    }

    @Override
    public final Object invokeAny(Collection collection) {
        return this.f118a.invokeAny(collection);
    }

    @Override
    public final boolean isShutdown() {
        return this.f118a.isShutdown();
    }

    @Override
    public final boolean isTerminated() {
        return this.f118a.isTerminated();
    }

    @Override
    public final void shutdown() {
        this.f118a.shutdown();
    }

    @Override
    public final List shutdownNow() {
        return this.f118a.shutdownNow();
    }

    @Override
    public final Future submit(Runnable runnable) {
        return this.f118a.submit(runnable);
    }

    public final String toString() {
        return this.f118a.toString();
    }

    @Override
    public final List invokeAll(Collection collection, long j10, TimeUnit timeUnit) {
        return this.f118a.invokeAll(collection, j10, timeUnit);
    }

    @Override
    public final Object invokeAny(Collection collection, long j10, TimeUnit timeUnit) {
        return this.f118a.invokeAny(collection, j10, timeUnit);
    }

    @Override
    public final Future submit(Runnable runnable, Object obj) {
        return this.f118a.submit(runnable, obj);
    }

    @Override
    public final Future submit(Callable callable) {
        return this.f118a.submit(callable);
    }
}
