package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;

public final class RunnableC1959c implements Runnable {

    public final int f6966a;

    public final Object f6967b;

    public RunnableC1959c(int i6, Object obj) {
        this.f6966a = i6;
        this.f6967b = obj;
    }

    @Override
    public final void run() {
        switch (this.f6966a) {
            case 0:
                ((AbstractExecutionThreadService.C18941) this.f6967b).lambda$doStart$1();
                break;
            case 1:
                ((JdkFutureAdapters.ListenableFutureAdapter) this.f6967b).lambda$addListener$0();
                break;
            case 2:
                WrappingExecutorService.lambda$wrapTask$0((Callable) this.f6967b);
                break;
            case 3:
                ClosingFuture.lambda$closeQuietly$0((AutoCloseable) this.f6967b);
                break;
            default:
                ((ScheduledFuture) this.f6967b).cancel(false);
                break;
        }
    }
}
