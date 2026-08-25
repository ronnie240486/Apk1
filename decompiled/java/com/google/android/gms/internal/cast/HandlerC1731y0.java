package com.google.android.gms.internal.cast;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.CountDownLatch;
import p119l1.C2963d;
import p119l1.RunnableC2960a;

public class HandlerC1731y0 extends Handler {

    public final int f5734a;

    @Override
    public void handleMessage(Message message) {
        switch (this.f5734a) {
            case 1:
                int i6 = message.what;
                super.handleMessage(message);
                return;
            case 2:
                C2963d c2963d = (C2963d) message.obj;
                int i10 = message.what;
                if (i10 != 1) {
                    if (i10 != 2) {
                        return;
                    }
                    c2963d.f10148a.getClass();
                    return;
                }
                RunnableC2960a runnableC2960a = c2963d.f10148a;
                if (!runnableC2960a.f10142a.get()) {
                    try {
                        throw null;
                    } catch (Throwable th) {
                        runnableC2960a.f10144c.countDown();
                        throw th;
                    }
                } else {
                    CountDownLatch countDownLatch = runnableC2960a.f10144c;
                    try {
                        throw null;
                    } catch (Throwable th2) {
                        countDownLatch.countDown();
                        throw th2;
                    }
                }
            default:
                super.handleMessage(message);
                return;
        }
    }

    public HandlerC1731y0(Looper looper, int i6, boolean z7) {
        super(looper);
        this.f5734a = i6;
    }

    public HandlerC1731y0(Looper looper, Handler.Callback callback, int i6) {
        super(looper, callback);
        this.f5734a = i6;
    }

    public HandlerC1731y0(Looper looper, int i6) {
        super(looper);
        this.f5734a = i6;
        switch (i6) {
            case 4:
                super(looper);
                Looper.getMainLooper();
                break;
            case 5:
                super(looper);
                Looper.getMainLooper();
                break;
            default:
                Looper.getMainLooper();
                break;
        }
    }
}
