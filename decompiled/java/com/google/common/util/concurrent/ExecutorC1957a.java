package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

public final class ExecutorC1957a implements Executor {

    public final int f6962a;

    public final Service f6963b;

    public ExecutorC1957a(Service service, int i6) {
        this.f6962a = i6;
        this.f6963b = service;
    }

    @Override
    public final void execute(Runnable runnable) {
        switch (this.f6962a) {
            case 0:
                ((AbstractExecutionThreadService) this.f6963b).lambda$executor$0(runnable);
                break;
            default:
                ((AbstractIdleService) this.f6963b).lambda$executor$0(runnable);
                break;
        }
    }
}
