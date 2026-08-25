package androidx.appcompat.app;

import java.util.concurrent.Executor;

public final class ExecutorC0151o0 implements Executor {
    @Override
    public final void execute(Runnable runnable) {
        new Thread(runnable).start();
    }
}
