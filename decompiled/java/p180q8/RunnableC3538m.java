package p180q8;

import com.bumptech.glide.AbstractC1466d;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p055ea.AbstractC2460q;
import p102j8.C2786a;
import p102j8.InterfaceC2787b;

public final class RunnableC3538m extends AtomicReferenceArray implements Runnable, Callable, InterfaceC2787b {

    public static final Object f11931b = new Object();

    public static final Object f11932c = new Object();

    public static final Object f11933d = new Object();

    public static final Object f11934e = new Object();

    public final Object f11935a;

    public RunnableC3538m(Runnable runnable, C2786a c2786a) {
        super(3);
        this.f11935a = runnable;
        lazySet(0, c2786a);
    }

    @Override
    public final void mo5675a() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        while (true) {
            Object obj6 = get(1);
            obj = f11934e;
            if (obj6 == obj || obj6 == (obj4 = f11932c) || obj6 == (obj5 = f11933d)) {
                break;
            }
            boolean z7 = get(2) != Thread.currentThread();
            if (z7) {
                obj4 = obj5;
            }
            if (compareAndSet(1, obj6, obj4)) {
                if (obj6 == null) {
                    break;
                }
                ((Future) obj6).cancel(z7);
                break;
            }
        }
        do {
            obj2 = get(0);
            if (obj2 == obj || obj2 == (obj3 = f11931b) || obj2 == null) {
                return;
            }
        } while (!compareAndSet(0, obj2, obj3));
        ((C2786a) obj2).m5774d(this);
    }

    public final void m7170b(Future future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f11934e) {
                return;
            }
            if (obj == f11932c) {
                future.cancel(false);
                return;
            } else if (obj == f11933d) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override
    public final Object call() {
        run();
        return null;
    }

    @Override
    public final void run() {
        Object obj;
        Object obj2;
        Object obj3 = f11933d;
        Object obj4 = f11932c;
        Object obj5 = f11931b;
        Object obj6 = f11934e;
        lazySet(2, Thread.currentThread());
        try {
            this.f11935a.run();
            Object obj7 = get(0);
            if (obj7 != obj5 && compareAndSet(0, obj7, obj6) && obj7 != null) {
                ((C2786a) obj7).m5774d(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == obj4 || obj2 == obj3) {
                    break;
                }
            } while (!compareAndSet(1, obj2, obj6));
            lazySet(2, null);
        } catch (Throwable th) {
            try {
                AbstractC1466d.m3505y(th);
                throw th;
            } catch (Throwable th2) {
                Object obj8 = get(0);
                if (obj8 != obj5 && compareAndSet(0, obj8, obj6) && obj8 != null) {
                    ((C2786a) obj8).m5774d(this);
                }
                do {
                    obj = get(1);
                    if (obj == obj4 || obj == obj3) {
                        break;
                    }
                } while (!compareAndSet(1, obj, obj6));
                lazySet(2, null);
                throw th2;
            }
        }
    }

    @Override
    public final String toString() {
        String strM5493g;
        Object obj = get(1);
        if (obj == f11934e) {
            strM5493g = "Finished";
        } else if (obj == f11932c) {
            strM5493g = "Disposed(Sync)";
        } else if (obj == f11933d) {
            strM5493g = "Disposed(Async)";
        } else {
            Object obj2 = get(2);
            strM5493g = obj2 == null ? "Waiting" : AbstractC2460q.m5493g(obj2, "Running on ");
        }
        return RunnableC3538m.class.getSimpleName() + "[" + strM5493g + "]";
    }
}
