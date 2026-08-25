package p197s2;

import java.util.concurrent.ThreadFactory;

public final class ThreadFactoryC3697a implements ThreadFactory {
    @Override
    public final synchronized Thread newThread(Runnable runnable) {
        Thread thread;
        thread = new Thread(runnable, "glide-disk-lru-cache-thread");
        thread.setPriority(1);
        return thread;
    }
}
