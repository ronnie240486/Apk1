package p014b1;

import java.util.concurrent.ThreadFactory;

public final class ThreadFactoryC1227a implements ThreadFactory {

    public final String f3915a;

    @Override
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f3915a);
        thread.setPriority(10);
        return thread;
    }
}
