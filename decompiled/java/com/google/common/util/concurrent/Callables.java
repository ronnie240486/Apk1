package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import p020b7.InterfaceC1339e0;

@ElementTypesAreNonnullByDefault
public final class Callables {
    private Callables() {
    }

    public static <T> AsyncCallable<T> asAsyncCallable(final Callable<T> callable, final ListeningExecutorService listeningExecutorService) {
        callable.getClass();
        listeningExecutorService.getClass();
        return new AsyncCallable() {
            @Override
            public final ListenableFuture call() {
                return listeningExecutorService.submit(callable);
            }
        };
    }

    public static Object lambda$threadRenaming$2(InterfaceC1339e0 interfaceC1339e0, Callable callable) throws Exception {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        boolean zTrySetName = trySetName((String) interfaceC1339e0.get(), threadCurrentThread);
        try {
            return callable.call();
        } finally {
            if (zTrySetName) {
                trySetName(name, threadCurrentThread);
            }
        }
    }

    public static void lambda$threadRenaming$3(InterfaceC1339e0 interfaceC1339e0, Runnable runnable) {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        boolean zTrySetName = trySetName((String) interfaceC1339e0.get(), threadCurrentThread);
        try {
            runnable.run();
        } finally {
            if (zTrySetName) {
                trySetName(name, threadCurrentThread);
            }
        }
    }

    public static <T> Callable<T> returning(@ParametricNullness final T t5) {
        return new Callable() {
            @Override
            public final Object call() {
                return Callables.lambda$returning$0(t5);
            }
        };
    }

    public static Runnable threadRenaming(Runnable runnable, InterfaceC1339e0 interfaceC1339e0) {
        interfaceC1339e0.getClass();
        runnable.getClass();
        return new RunnableC1964h(interfaceC1339e0, 1, runnable);
    }

    private static boolean trySetName(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static <T> Callable<T> threadRenaming(final Callable<T> callable, final InterfaceC1339e0 interfaceC1339e0) {
        interfaceC1339e0.getClass();
        callable.getClass();
        return new Callable() {
            @Override
            public final Object call() {
                return Callables.lambda$threadRenaming$2(interfaceC1339e0, callable);
            }
        };
    }

    public static Object lambda$returning$0(Object obj) throws Exception {
        return obj;
    }
}
