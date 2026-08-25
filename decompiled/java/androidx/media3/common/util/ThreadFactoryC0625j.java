package androidx.media3.common.util;

import java.util.concurrent.ThreadFactory;

public final class ThreadFactoryC0625j implements ThreadFactory {

    public final int f2653a;

    public final String f2654b;

    public ThreadFactoryC0625j(String str, int i6) {
        this.f2653a = i6;
        this.f2654b = str;
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        switch (this.f2653a) {
            case 0:
                return Util.lambda$newSingleThreadExecutor$3(this.f2654b, runnable);
            default:
                return Util.lambda$newSingleThreadScheduledExecutor$4(this.f2654b, runnable);
        }
    }
}
