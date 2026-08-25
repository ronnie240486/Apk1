package p119l1;

import android.os.Looper;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p082ha.AbstractC2676b;
import p117l.ThreadFactoryC2947b;

public final class RunnableC2960a implements Runnable {

    public static HandlerC1731y0 f10141d;

    public final AtomicBoolean f10142a = new AtomicBoolean();

    public final AtomicBoolean f10143b = new AtomicBoolean();

    public final CountDownLatch f10144c;

    static {
        ThreadFactoryC2947b threadFactoryC2947b = new ThreadFactoryC2947b(1);
        new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), threadFactoryC2947b);
    }

    public RunnableC2960a(AbstractC2676b abstractC2676b) {
        new C2962c(this, new CallableC2961b(0, this));
        this.f10144c = new CountDownLatch(1);
    }

    public final void m6003a(Object obj) {
        HandlerC1731y0 handlerC1731y0;
        boolean z7 = false;
        synchronized (RunnableC2960a.class) {
            try {
                if (f10141d == null) {
                    f10141d = new HandlerC1731y0(Looper.getMainLooper(), 2, z7);
                }
                handlerC1731y0 = f10141d;
            } catch (Throwable th) {
                throw th;
            }
        }
        handlerC1731y0.obtainMessage(1, new C2963d(this, obj)).sendToTarget();
    }

    @Override
    public final void run() {
        throw null;
    }
}
