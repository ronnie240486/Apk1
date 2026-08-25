package com.jakewharton.rxbinding.internal;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class MainThreadSubscription implements Runnable {

    @Keep
    private volatile int unsubscribed;

    static {
        new Handler(Looper.getMainLooper());
        AtomicIntegerFieldUpdater.newUpdater(MainThreadSubscription.class, "unsubscribed");
    }

    public abstract void m4458a();

    @Override
    public final void run() {
        m4458a();
    }
}
