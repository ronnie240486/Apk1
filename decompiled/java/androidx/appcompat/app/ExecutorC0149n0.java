package androidx.appcompat.app;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public final class ExecutorC0149n0 implements Executor {

    public final Object f411a = new Object();

    public final ArrayDeque f412b = new ArrayDeque();

    public final ExecutorC0151o0 f413c;

    public Runnable f414d;

    public ExecutorC0149n0(ExecutorC0151o0 executorC0151o0) {
        this.f413c = executorC0151o0;
    }

    public final void m432a() {
        synchronized (this.f411a) {
            try {
                Runnable runnable = (Runnable) this.f412b.poll();
                this.f414d = runnable;
                if (runnable != null) {
                    this.f413c.execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void execute(Runnable runnable) {
        synchronized (this.f411a) {
            try {
                this.f412b.add(new RunnableC0147m0(this, 0, runnable));
                if (this.f414d == null) {
                    m432a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
