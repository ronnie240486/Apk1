package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p020b7.InterfaceC1339e0;

@ElementTypesAreNonnullByDefault
public abstract class AbstractIdleService implements Service {
    private final Service delegate;
    private final InterfaceC1339e0 threadNameSupplier;

    public final class DelegateService extends AbstractService {
        private DelegateService() {
        }

        public void lambda$doStart$0() {
            try {
                AbstractIdleService.this.startUp();
                notifyStarted();
            } catch (Throwable th) {
                Platform.restoreInterruptIfIsInterruptedException(th);
                notifyFailed(th);
            }
        }

        public void lambda$doStop$1() {
            try {
                AbstractIdleService.this.shutDown();
                notifyStopped();
            } catch (Throwable th) {
                Platform.restoreInterruptIfIsInterruptedException(th);
                notifyFailed(th);
            }
        }

        @Override
        public final void doStart() {
            MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), AbstractIdleService.this.threadNameSupplier).execute(new RunnableC1961e(this, 1));
        }

        @Override
        public final void doStop() {
            MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), AbstractIdleService.this.threadNameSupplier).execute(new RunnableC1961e(this, 0));
        }

        @Override
        public String toString() {
            return AbstractIdleService.this.toString();
        }
    }

    public final class ThreadNameSupplier implements InterfaceC1339e0 {
        private ThreadNameSupplier() {
        }

        @Override
        public String get() {
            return AbstractIdleService.this.serviceName() + " " + AbstractIdleService.this.state();
        }
    }

    public AbstractIdleService() {
        this.threadNameSupplier = new ThreadNameSupplier();
        this.delegate = new DelegateService();
    }

    public void lambda$executor$0(Runnable runnable) {
        MoreExecutors.newThread((String) this.threadNameSupplier.get(), runnable).start();
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

    public Executor executor() {
        return new ExecutorC1957a(this, 1);
    }

    @Override
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public abstract void shutDown() throws Exception;

    @Override
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    public abstract void startUp() throws Exception;

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
}
