package com.google.android.gms.internal.cast;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import p055ea.AbstractC2460q;

public abstract class AbstractC1558f6 extends AbstractC1608k6 {
    public static void m3817A(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e5) {
            AbstractC1608k6.f5388h.m3973b().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e5);
        }
    }

    public static Object m3818u(Object obj) throws ExecutionException {
        if (obj instanceof C1518b6) {
            RuntimeException runtimeException = ((C1518b6) obj).f5222b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(runtimeException);
            throw cancellationException;
        }
        if (obj instanceof C1538d6) {
            throw new ExecutionException(((C1538d6) obj).f5246a);
        }
        if (obj == AbstractC1608k6.f5387g) {
            return null;
        }
        return obj;
    }

    public static Object m3819x(AbstractC1558f6 abstractC1558f6) {
        Object obj;
        boolean z7 = false;
        while (true) {
            try {
                obj = abstractC1558f6.get();
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

    public static void m3820z(AbstractC1558f6 abstractC1558f6) {
        abstractC1558f6.getClass();
        for (C1598j6 c1598j6Mo3704k = AbstractC1608k6.f5390j.mo3704k(abstractC1558f6); c1598j6Mo3704k != null; c1598j6Mo3704k = c1598j6Mo3704k.f5367b) {
            Thread thread = c1598j6Mo3704k.f5366a;
            if (thread != null) {
                c1598j6Mo3704k.f5366a = null;
                LockSupport.unpark(thread);
            }
        }
        abstractC1558f6.mo3822w();
        C1548e6 c1548e6Mo3703d = AbstractC1608k6.f5390j.mo3703d(abstractC1558f6);
        C1548e6 c1548e6 = null;
        while (c1548e6Mo3703d != null) {
            C1548e6 c1548e7 = c1548e6Mo3703d.f5285c;
            c1548e6Mo3703d.f5285c = c1548e6;
            c1548e6 = c1548e6Mo3703d;
            c1548e6Mo3703d = c1548e7;
        }
        while (c1548e6 != null) {
            Runnable runnable = c1548e6.f5283a;
            C1548e6 c1548e8 = c1548e6.f5285c;
            Objects.requireNonNull(runnable);
            Executor executor = c1548e6.f5284b;
            Objects.requireNonNull(executor);
            m3817A(runnable, executor);
            c1548e6 = c1548e8;
        }
    }

    @Override
    public final void addListener(Runnable runnable, Executor executor) {
        C1548e6 c1548e6;
        C1548e6 c1548e7;
        if (runnable == null) {
            throw new NullPointerException("Runnable was null.");
        }
        if (executor == null) {
            throw new NullPointerException("Executor was null.");
        }
        if (!isDone() && (c1548e6 = this.f5392e) != (c1548e7 = C1548e6.f5282d)) {
            C1548e6 c1548e8 = new C1548e6(runnable, executor);
            do {
                c1548e8.f5285c = c1548e6;
                if (AbstractC1608k6.f5390j.mo3707q(this, c1548e6, c1548e8)) {
                    return;
                } else {
                    c1548e6 = this.f5392e;
                }
            } while (c1548e6 != c1548e7);
        }
        m3817A(runnable, executor);
    }

    @Override
    public final boolean cancel(boolean z7) {
        C1518b6 c1518b6;
        Object obj = this.f5391d;
        if (obj != null) {
            return false;
        }
        if (AbstractC1608k6.f5389i) {
            c1518b6 = new C1518b6(z7, new CancellationException("Future.cancel() was called."));
        } else {
            c1518b6 = z7 ? C1518b6.f5219c : C1518b6.f5220d;
            Objects.requireNonNull(c1518b6);
        }
        if (!AbstractC1608k6.f5390j.mo3708r(this, obj, c1518b6)) {
            return false;
        }
        m3820z(this);
        return true;
    }

    @Override
    public final Object get() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f5391d;
        if (obj2 != null) {
            return m3818u(obj2);
        }
        C1598j6 c1598j6 = this.f5393f;
        C1598j6 c1598j7 = C1598j6.f5365c;
        if (c1598j6 != c1598j7) {
            C1598j6 c1598j8 = new C1598j6();
            do {
                AbstractC1503a1 abstractC1503a1 = AbstractC1608k6.f5390j;
                abstractC1503a1.mo3705m(c1598j8, c1598j6);
                if (abstractC1503a1.mo3709s(this, c1598j6, c1598j8)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            m3923t(c1598j8);
                            throw new InterruptedException();
                        }
                        obj = this.f5391d;
                    } while (obj == null);
                    return m3818u(obj);
                }
                c1598j6 = this.f5393f;
            } while (c1598j6 != c1598j7);
        }
        Object obj3 = this.f5391d;
        Objects.requireNonNull(obj3);
        return m3818u(obj3);
    }

    @Override
    public final boolean isCancelled() {
        return this.f5391d instanceof C1518b6;
    }

    @Override
    public final boolean isDone() {
        return this.f5391d != null;
    }

    @Override
    public final String toString() {
        String strConcat;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.f5391d instanceof C1518b6) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            m3823y(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            try {
                strConcat = mo3821v();
                if (strConcat == null || strConcat.isEmpty()) {
                    strConcat = null;
                }
            } catch (Throwable th) {
                if ((th instanceof Error) && !(th instanceof StackOverflowError)) {
                    throw th;
                }
                strConcat = "Exception thrown from implementation: ".concat(String.valueOf(th.getClass()));
            }
            if (strConcat != null) {
                sb.append(", info=[");
                sb.append(strConcat);
                sb.append("]");
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                m3823y(sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public abstract String mo3821v();

    public final void m3823y(StringBuilder sb) {
        try {
            Object objM3819x = m3819x(this);
            sb.append("SUCCESS, result=[");
            if (objM3819x == null) {
                sb.append("null");
            } else if (objM3819x == this) {
                sb.append("this future");
            } else {
                sb.append(objM3819x.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objM3819x)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e5) {
            sb.append("FAILURE, cause=[");
            sb.append(e5.getCause());
            sb.append("]");
        } catch (Exception e10) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e10.getClass());
            sb.append(" thrown from get()]");
        }
    }

    @Override
    public final Object get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        if (!Thread.interrupted()) {
            Object obj = this.f5391d;
            if (obj != null) {
                return m3818u(obj);
            }
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                C1598j6 c1598j6 = this.f5393f;
                C1598j6 c1598j7 = C1598j6.f5365c;
                if (c1598j6 != c1598j7) {
                    C1598j6 c1598j8 = new C1598j6();
                    while (true) {
                        AbstractC1503a1 abstractC1503a1 = AbstractC1608k6.f5390j;
                        abstractC1503a1.mo3705m(c1598j8, c1598j6);
                        if (abstractC1503a1.mo3709s(this, c1598j6, c1598j8)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f5391d;
                                    if (obj2 != null) {
                                        return m3818u(obj2);
                                    }
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    m3923t(c1598j8);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            m3923t(c1598j8);
                            break;
                        }
                        c1598j6 = this.f5393f;
                        if (c1598j6 == c1598j7) {
                        }
                    }
                }
                Object obj3 = this.f5391d;
                Objects.requireNonNull(obj3);
                return m3818u(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.f5391d;
                if (obj4 != null) {
                    return m3818u(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = jNanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String string = toString();
            String string2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = string2.toLowerCase(locale);
            String strConcat = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String strConcat2 = strConcat.concat(" (plus ");
                long j11 = -nanos;
                long jConvert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
                long nanos2 = j11 - timeUnit.toNanos(jConvert);
                boolean z7 = true;
                if (jConvert != 0 && nanos2 <= 1000) {
                    z7 = false;
                }
                if (jConvert > 0) {
                    String strConcat3 = strConcat2 + jConvert + " " + lowerCase;
                    if (z7) {
                        strConcat3 = strConcat3.concat(",");
                    }
                    strConcat2 = strConcat3.concat(" ");
                }
                if (z7) {
                    strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
                }
                strConcat = strConcat2.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(AbstractC2460q.m5495i(strConcat, " for ", string));
        }
        throw new InterruptedException();
    }

    public void mo3822w() {
    }
}
