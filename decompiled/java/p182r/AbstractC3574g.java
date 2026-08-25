package p182r;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.bumptech.glide.AbstractC1466d;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import p055ea.AbstractC2460q;

public abstract class AbstractC3574g implements ListenableFuture {

    public static final boolean f12039d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    public static final Logger f12040e = Logger.getLogger(AbstractC3574g.class.getName());

    public static final AbstractC1466d f12041f;

    public static final Object f12042g;

    public volatile Object f12043a;

    public volatile C3570c f12044b;

    public volatile C3573f f12045c;

    static {
        AbstractC1466d c3572e;
        try {
            c3572e = new C3571d(AtomicReferenceFieldUpdater.newUpdater(C3573f.class, Thread.class, CmcdData.OBJECT_TYPE_AUDIO_ONLY), AtomicReferenceFieldUpdater.newUpdater(C3573f.class, C3573f.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractC3574g.class, C3573f.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractC3574g.class, C3570c.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractC3574g.class, Object.class, CmcdData.OBJECT_TYPE_AUDIO_ONLY));
            th = null;
        } catch (Throwable th) {
            th = th;
            c3572e = new C3572e();
        }
        f12041f = c3572e;
        if (th != null) {
            f12040e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f12042g = new Object();
    }

    public static void m7187b(AbstractC3574g abstractC3574g) {
        C3573f c3573f;
        C3570c c3570c;
        C3570c c3570c2;
        C3570c c3570c3;
        do {
            c3573f = abstractC3574g.f12045c;
        } while (!f12041f.mo3514d(abstractC3574g, c3573f, C3573f.f12036c));
        while (true) {
            c3570c = null;
            if (c3573f == null) {
                break;
            }
            Thread thread = c3573f.f12037a;
            if (thread != null) {
                c3573f.f12037a = null;
                LockSupport.unpark(thread);
            }
            c3573f = c3573f.f12038b;
        }
        do {
            c3570c2 = abstractC3574g.f12044b;
        } while (!f12041f.mo3512b(abstractC3574g, c3570c2, C3570c.f12027d));
        while (true) {
            c3570c3 = c3570c;
            c3570c = c3570c2;
            if (c3570c == null) {
                break;
            }
            c3570c2 = c3570c.f12030c;
            c3570c.f12030c = c3570c3;
        }
        while (c3570c3 != null) {
            C3570c c3570c4 = c3570c3.f12030c;
            m7188c(c3570c3.f12028a, c3570c3.f12029b);
            c3570c3 = c3570c4;
        }
    }

    public static void m7188c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e5) {
            f12040e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e5);
        }
    }

    public static Object m7189d(Object obj) throws ExecutionException {
        if (obj instanceof C3568a) {
            CancellationException cancellationException = ((C3568a) obj).f12026a;
            CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
            cancellationException2.initCause(cancellationException);
            throw cancellationException2;
        }
        if (obj instanceof AbstractC3569b) {
            ((AbstractC3569b) obj).getClass();
            throw new ExecutionException((Throwable) null);
        }
        if (obj == f12042g) {
            return null;
        }
        return obj;
    }

    public static Object m7190e(AbstractC3574g abstractC3574g) {
        Object obj;
        boolean z7 = false;
        while (true) {
            try {
                obj = abstractC3574g.get();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void m7191a(StringBuilder sb) {
        try {
            Object objM7190e = m7190e(this);
            sb.append("SUCCESS, result=[");
            sb.append(objM7190e == this ? "this future" : String.valueOf(objM7190e));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e5) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e5.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e10) {
            sb.append("FAILURE, cause=[");
            sb.append(e10.getCause());
            sb.append("]");
        }
    }

    @Override
    public final void addListener(Runnable runnable, Executor executor) {
        runnable.getClass();
        executor.getClass();
        C3570c c3570c = this.f12044b;
        C3570c c3570c2 = C3570c.f12027d;
        if (c3570c != c3570c2) {
            C3570c c3570c3 = new C3570c(runnable, executor);
            do {
                c3570c3.f12030c = c3570c;
                if (f12041f.mo3512b(this, c3570c, c3570c3)) {
                    return;
                } else {
                    c3570c = this.f12044b;
                }
            } while (c3570c != c3570c2);
        }
        m7188c(runnable, executor);
    }

    @Override
    public final boolean cancel(boolean z7) {
        C3568a c3568a;
        Object obj = this.f12043a;
        if (obj != null) {
            return false;
        }
        if (f12039d) {
            c3568a = new C3568a(z7, new CancellationException("Future.cancel() was called."));
        } else {
            c3568a = z7 ? C3568a.f12024b : C3568a.f12025c;
        }
        if (!f12041f.mo3513c(this, obj, c3568a)) {
            return false;
        }
        m7187b(this);
        return true;
    }

    public final void m7192f(C3573f c3573f) {
        c3573f.f12037a = null;
        while (true) {
            C3573f c3573f2 = this.f12045c;
            if (c3573f2 == C3573f.f12036c) {
                return;
            }
            C3573f c3573f3 = null;
            while (c3573f2 != null) {
                C3573f c3573f4 = c3573f2.f12038b;
                if (c3573f2.f12037a != null) {
                    c3573f3 = c3573f2;
                } else if (c3573f3 != null) {
                    c3573f3.f12038b = c3573f4;
                    if (c3573f3.f12037a == null) {
                    }
                } else if (!f12041f.mo3514d(this, c3573f2, c3573f4)) {
                }
                c3573f2 = c3573f4;
            }
            return;
        }
    }

    @Override
    public final Object get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f12043a;
        if (obj != null) {
            return m7189d(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            C3573f c3573f = this.f12045c;
            C3573f c3573f2 = C3573f.f12036c;
            if (c3573f != c3573f2) {
                C3573f c3573f3 = new C3573f();
                while (true) {
                    AbstractC1466d abstractC1466d = f12041f;
                    abstractC1466d.mo3507B(c3573f3, c3573f);
                    if (abstractC1466d.mo3514d(this, c3573f, c3573f3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                m7192f(c3573f3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f12043a;
                            if (obj2 != null) {
                                return m7189d(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        m7192f(c3573f3);
                        break;
                    }
                    c3573f = this.f12045c;
                    if (c3573f == c3573f2) {
                    }
                }
            }
            return m7189d(this.f12043a);
        }
        while (nanos > 0) {
            Object obj3 = this.f12043a;
            if (obj3 != null) {
                return m7189d(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strM5494h = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strM5494h2 = AbstractC2460q.m5494h(strM5494h, " (plus ");
            long j11 = -nanos;
            long jConvert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
            long nanos2 = j11 - timeUnit.toNanos(jConvert);
            boolean z7 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strM5494h3 = strM5494h2 + jConvert + " " + lowerCase;
                if (z7) {
                    strM5494h3 = AbstractC2460q.m5494h(strM5494h3, ",");
                }
                strM5494h2 = AbstractC2460q.m5494h(strM5494h3, " ");
            }
            if (z7) {
                strM5494h2 = strM5494h2 + nanos2 + " nanoseconds ";
            }
            strM5494h = AbstractC2460q.m5494h(strM5494h2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(AbstractC2460q.m5494h(strM5494h, " but future completed as timeout expired"));
        }
        throw new TimeoutException(AbstractC2460q.m5495i(strM5494h, " for ", string));
    }

    @Override
    public final boolean isCancelled() {
        return this.f12043a instanceof C3568a;
    }

    @Override
    public final boolean isDone() {
        return this.f12043a != null;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f12043a instanceof C3568a) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            m7191a(sb);
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                } else {
                    str = null;
                }
            } catch (RuntimeException e5) {
                str = "Exception thrown from implementation: " + e5.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                m7191a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f12043a;
            if (obj2 != null) {
                return m7189d(obj2);
            }
            C3573f c3573f = this.f12045c;
            C3573f c3573f2 = C3573f.f12036c;
            if (c3573f != c3573f2) {
                C3573f c3573f3 = new C3573f();
                do {
                    AbstractC1466d abstractC1466d = f12041f;
                    abstractC1466d.mo3507B(c3573f3, c3573f);
                    if (abstractC1466d.mo3514d(this, c3573f, c3573f3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f12043a;
                            } else {
                                m7192f(c3573f3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return m7189d(obj);
                    }
                    c3573f = this.f12045c;
                } while (c3573f != c3573f2);
            }
            return m7189d(this.f12043a);
        }
        throw new InterruptedException();
    }
}
