package com.google.common.util.concurrent;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import p020b7.AbstractC1332b;
import p020b7.InterfaceC1339e0;

@ElementTypesAreNonnullByDefault
public abstract class AbstractScheduledService implements Service {
    private static final LazyLogger logger = new LazyLogger(AbstractScheduledService.class);
    private final AbstractService delegate = new ServiceDelegate();

    public interface Cancellable {
        void cancel(boolean z7);

        boolean isCancelled();
    }

    public static abstract class CustomScheduler extends Scheduler {

        public final class ReschedulableCallable implements Callable<Void> {
            private SupplantableFuture cancellationDelegate;
            private final ScheduledExecutorService executor;
            private final ReentrantLock lock = new ReentrantLock();
            private final AbstractService service;
            private final Runnable wrappedRunnable;

            public ReschedulableCallable(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                this.wrappedRunnable = runnable;
                this.executor = scheduledExecutorService;
                this.service = abstractService;
            }

            private Cancellable initializeOrUpdateCancellationDelegate(Schedule schedule) {
                SupplantableFuture supplantableFuture = this.cancellationDelegate;
                if (supplantableFuture == null) {
                    SupplantableFuture supplantableFuture2 = new SupplantableFuture(this.lock, submitToExecutor(schedule));
                    this.cancellationDelegate = supplantableFuture2;
                    return supplantableFuture2;
                }
                if (!supplantableFuture.currentFuture.isCancelled()) {
                    this.cancellationDelegate.currentFuture = submitToExecutor(schedule);
                }
                return this.cancellationDelegate;
            }

            private ScheduledFuture<Void> submitToExecutor(Schedule schedule) {
                return this.executor.schedule(this, schedule.delay, schedule.unit);
            }

            public Cancellable reschedule() {
                Cancellable futureAsCancellable;
                try {
                    Schedule nextSchedule = CustomScheduler.this.getNextSchedule();
                    this.lock.lock();
                    try {
                        futureAsCancellable = initializeOrUpdateCancellationDelegate(nextSchedule);
                        this.lock.unlock();
                        th = null;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            futureAsCancellable = new FutureAsCancellable(Futures.immediateCancelledFuture());
                            this.lock.unlock();
                        } catch (Throwable th2) {
                            this.lock.unlock();
                            throw th2;
                        }
                    }
                    if (th != null) {
                        this.service.notifyFailed(th);
                    }
                    return futureAsCancellable;
                } catch (Throwable th3) {
                    Platform.restoreInterruptIfIsInterruptedException(th3);
                    this.service.notifyFailed(th3);
                    return new FutureAsCancellable(Futures.immediateCancelledFuture());
                }
            }

            @Override
            public Void call() throws Exception {
                this.wrappedRunnable.run();
                reschedule();
                return null;
            }
        }

        public static final class Schedule {
            private final long delay;
            private final TimeUnit unit;

            public Schedule(long j10, TimeUnit timeUnit) {
                this.delay = j10;
                timeUnit.getClass();
                this.unit = timeUnit;
            }
        }

        public static final class SupplantableFuture implements Cancellable {
            private Future<Void> currentFuture;
            private final ReentrantLock lock;

            public SupplantableFuture(ReentrantLock reentrantLock, Future<Void> future) {
                this.lock = reentrantLock;
                this.currentFuture = future;
            }

            @Override
            public void cancel(boolean z7) {
                this.lock.lock();
                try {
                    this.currentFuture.cancel(z7);
                } finally {
                    this.lock.unlock();
                }
            }

            @Override
            public boolean isCancelled() {
                this.lock.lock();
                try {
                    return this.currentFuture.isCancelled();
                } finally {
                    this.lock.unlock();
                }
            }
        }

        public CustomScheduler() {
            super();
        }

        public abstract Schedule getNextSchedule() throws Exception;

        @Override
        public final Cancellable schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            return new ReschedulableCallable(abstractService, scheduledExecutorService, runnable).reschedule();
        }
    }

    public static final class FutureAsCancellable implements Cancellable {
        private final Future<?> delegate;

        public FutureAsCancellable(Future<?> future) {
            this.delegate = future;
        }

        @Override
        public void cancel(boolean z7) {
            this.delegate.cancel(z7);
        }

        @Override
        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }
    }

    public static abstract class Scheduler {
        public static Scheduler newFixedDelaySchedule(final long j10, final long j11, final TimeUnit timeUnit) {
            timeUnit.getClass();
            AbstractC1332b.m3216g(j11 > 0, "delay must be > 0, found %s", j11);
            return new Scheduler() {
                {
                    super();
                }

                @Override
                public Cancellable schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return new FutureAsCancellable(scheduledExecutorService.scheduleWithFixedDelay(runnable, j10, j11, timeUnit));
                }
            };
        }

        public static Scheduler newFixedRateSchedule(final long j10, final long j11, final TimeUnit timeUnit) {
            timeUnit.getClass();
            AbstractC1332b.m3216g(j11 > 0, "period must be > 0, found %s", j11);
            return new Scheduler() {
                {
                    super();
                }

                @Override
                public Cancellable schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return new FutureAsCancellable(scheduledExecutorService.scheduleAtFixedRate(runnable, j10, j11, timeUnit));
                }
            };
        }

        public abstract Cancellable schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable);

        private Scheduler() {
        }
    }

    public final class ServiceDelegate extends AbstractService {
        private volatile ScheduledExecutorService executorService;
        private final ReentrantLock lock;
        private volatile Cancellable runningTask;
        private final Runnable task;

        public class Task implements Runnable {
            public Task() {
            }

            @Override
            public void run() {
                ServiceDelegate.this.lock.lock();
                try {
                    Cancellable cancellable = ServiceDelegate.this.runningTask;
                    Objects.requireNonNull(cancellable);
                    if (cancellable.isCancelled()) {
                        ServiceDelegate.this.lock.unlock();
                        return;
                    }
                    AbstractScheduledService.this.runOneIteration();
                } catch (Throwable th) {
                    try {
                        Platform.restoreInterruptIfIsInterruptedException(th);
                        try {
                            AbstractScheduledService.this.shutDown();
                        } catch (Exception e5) {
                            Platform.restoreInterruptIfIsInterruptedException(e5);
                            AbstractScheduledService.logger.get().log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e5);
                        }
                        ServiceDelegate.this.notifyFailed(th);
                        Cancellable cancellable2 = ServiceDelegate.this.runningTask;
                        Objects.requireNonNull(cancellable2);
                        cancellable2.cancel(false);
                    } catch (Throwable th2) {
                        ServiceDelegate.this.lock.unlock();
                        throw th2;
                    }
                }
                ServiceDelegate.this.lock.unlock();
            }
        }

        private ServiceDelegate() {
            this.lock = new ReentrantLock();
            this.task = new Task();
        }

        public String lambda$doStart$0() {
            return AbstractScheduledService.this.serviceName() + " " + state();
        }

        public void lambda$doStart$1() {
            this.lock.lock();
            try {
                AbstractScheduledService.this.startUp();
                Objects.requireNonNull(this.executorService);
                this.runningTask = AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, this.executorService, this.task);
                notifyStarted();
            } catch (Throwable th) {
                try {
                    Platform.restoreInterruptIfIsInterruptedException(th);
                    notifyFailed(th);
                    if (this.runningTask != null) {
                        this.runningTask.cancel(false);
                    }
                } finally {
                    this.lock.unlock();
                }
            }
        }

        public void lambda$doStop$2() {
            try {
                this.lock.lock();
                try {
                    if (state() != Service.State.STOPPING) {
                        this.lock.unlock();
                        return;
                    }
                    AbstractScheduledService.this.shutDown();
                    this.lock.unlock();
                    notifyStopped();
                } catch (Throwable th) {
                    this.lock.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                Platform.restoreInterruptIfIsInterruptedException(th2);
                notifyFailed(th2);
            }
        }

        @Override
        public final void doStart() {
            this.executorService = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), (InterfaceC1339e0) new C1958b(this, 1));
            this.executorService.execute(new RunnableC1962f(this, 0));
        }

        @Override
        public final void doStop() {
            Objects.requireNonNull(this.runningTask);
            Objects.requireNonNull(this.executorService);
            this.runningTask.cancel(false);
            this.executorService.execute(new RunnableC1962f(this, 1));
        }

        @Override
        public String toString() {
            return AbstractScheduledService.this.toString();
        }
    }

    @Override
    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    @Override
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public ScheduledExecutorService executor() {
        final ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                return MoreExecutors.newThread(AbstractScheduledService.this.serviceName(), runnable);
            }
        });
        addListener(new Service.Listener(this) {
            final AbstractScheduledService this$0;

            {
                this.this$0 = this;
            }

            @Override
            public void failed(Service.State state, Throwable th) {
                scheduledExecutorServiceNewSingleThreadScheduledExecutor.shutdown();
            }

            @Override
            public void terminated(Service.State state) {
                scheduledExecutorServiceNewSingleThreadScheduledExecutor.shutdown();
            }
        }, MoreExecutors.directExecutor());
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    @Override
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public abstract void runOneIteration() throws Exception;

    public abstract Scheduler scheduler();

    public String serviceName() {
        return getClass().getSimpleName();
    }

    @Override
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    @Override
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    @Override
    public final void awaitRunning(long j10, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitRunning(j10, timeUnit);
    }

    @Override
    public final void awaitTerminated(long j10, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitTerminated(j10, timeUnit);
    }

    public void shutDown() throws Exception {
    }

    public void startUp() throws Exception {
    }
}
