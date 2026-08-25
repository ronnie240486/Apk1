package com.google.common.util.concurrent;

@ElementTypesAreNonnullByDefault
final class Platform {
    private Platform() {
    }

    public static boolean isInstanceOfThrowableClass(Throwable th, Class<? extends Throwable> cls) {
        return cls.isInstance(th);
    }

    public static void restoreInterruptIfIsInterruptedException(Throwable th) {
        th.getClass();
        if (th instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}
