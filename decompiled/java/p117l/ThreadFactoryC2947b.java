package p117l;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class ThreadFactoryC2947b implements ThreadFactory {

    public final int f10116a;

    public final AtomicInteger f10117b;

    public ThreadFactoryC2947b(int i6) {
        this.f10116a = i6;
        switch (i6) {
            case 1:
                this.f10117b = new AtomicInteger(1);
                break;
            default:
                this.f10117b = new AtomicInteger(0);
                break;
        }
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        switch (this.f10116a) {
            case 0:
                Thread thread = new Thread(runnable);
                thread.setName("arch_disk_io_" + this.f10117b.getAndIncrement());
                return thread;
            default:
                return new Thread(runnable, "ModernAsyncTask #" + this.f10117b.getAndIncrement());
        }
    }
}
