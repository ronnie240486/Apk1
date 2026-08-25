package p004a3;

import java.util.concurrent.ThreadFactory;

public final class ThreadFactoryC0037b implements ThreadFactory {
    @Override
    public final Thread newThread(Runnable runnable) {
        return new C0036a(runnable);
    }
}
