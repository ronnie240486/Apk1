package p233v7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import p055ea.AbstractC2460q;
import p187r4.C3624n;
import p222u7.C3926b;
import p222u7.C3930f;
import p222u7.InterfaceC3927c;

public abstract class AbstractC4017d implements InterfaceC3927c {

    public static final ScheduledExecutorService f13621d = Executors.newSingleThreadScheduledExecutor();

    public static final ExecutorService f13622e = Executors.newCachedThreadPool();

    public final String[] f13623a;

    public final ExecutorService f13624b;

    public final int f13625c;

    public AbstractC4017d(String[] strArr) {
        ExecutorService executorService = (strArr == null || strArr.length <= 1) ? null : f13622e;
        this.f13625c = 3;
        this.f13623a = strArr;
        this.f13624b = executorService;
    }

    public abstract C4019f mo8006a(C3624n c3624n, String str, String str2);

    public final C3930f[] m8007b(C3926b c3926b) throws IOException {
        C4019f c4019fMo8006a;
        ExecutorService executorService;
        String[] strArr = this.f13623a;
        if (strArr == null || strArr.length == 0) {
            throw new IOException("server can not empty");
        }
        final String str = c3926b.f13220b;
        if (str == null || str.isEmpty()) {
            throw new IOException("host can not empty");
        }
        final C3624n c3624n = new C3624n(6);
        c3624n.f12182b = new ConcurrentLinkedQueue();
        if (strArr.length != 1 && (executorService = this.f13624b) != null) {
            ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(executorService);
            ArrayList<Future> arrayList = new ArrayList();
            for (final String str2 : strArr) {
                arrayList.add(executorCompletionService.submit(new Callable() {
                    @Override
                    public final Object call() throws IOException {
                        C3624n c3624n2 = c3624n;
                        String str3 = str2;
                        try {
                            return this.f13617a.mo8006a(c3624n2, str3, str);
                        } catch (Exception e5) {
                            throw new IOException(AbstractC2460q.m5501o("resolver failed:", str3), e5);
                        }
                    }
                }));
            }
            long nanos = TimeUnit.SECONDS.toNanos(this.f13625c) + System.nanoTime();
            IOException iOException = null;
            int i6 = 0;
            while (true) {
                if (i6 < strArr.length) {
                    long jNanoTime = nanos - System.nanoTime();
                    if (jNanoTime > 0) {
                        try {
                            Future futurePoll = executorCompletionService.poll(jNanoTime, TimeUnit.NANOSECONDS);
                            if (futurePoll != null) {
                                try {
                                    c4019fMo8006a = (C4019f) futurePoll.get();
                                    if (c4019fMo8006a == null) {
                                        iOException = new IOException("resolver returned null");
                                        i6++;
                                    } else {
                                        for (Future future : arrayList) {
                                            if (!future.isDone()) {
                                                future.cancel(true);
                                            }
                                        }
                                        c3624n.m7340e();
                                    }
                                } catch (InterruptedException e5) {
                                    Thread.currentThread().interrupt();
                                    throw new IOException("resolver interrupted", e5);
                                } catch (ExecutionException e10) {
                                    Throwable cause = e10.getCause();
                                    iOException = cause instanceof IOException ? (IOException) cause : new IOException("resolver failed", cause);
                                }
                            }
                        } catch (InterruptedException e11) {
                            c3624n.m7340e();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((Future) it.next()).cancel(true);
                            }
                            Thread.currentThread().interrupt();
                            throw new IOException("resolver interrupted", e11);
                        }
                    }
                }
                c3624n.m7340e();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((Future) it2.next()).cancel(true);
                }
                if (iOException != null) {
                    throw iOException;
                }
                throw new IOException("resolver timeout");
            }
        }
        try {
            int length = strArr.length;
            Exception e12 = null;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    throw new IOException("All resolvers failed", e12);
                }
                try {
                    c4019fMo8006a = mo8006a(c3624n, strArr[i10], str);
                    c3624n.m7340e();
                    break;
                } catch (Exception e13) {
                    e12 = e13;
                    i10++;
                }
            }
        } catch (Throwable th) {
            c3624n.m7340e();
            throw th;
        }
        ArrayList<C3930f> arrayList2 = c4019fMo8006a.f13638l;
        if (arrayList2 == null || arrayList2.size() == 0) {
            return null;
        }
        ArrayList arrayList3 = new ArrayList();
        for (C3930f c3930f : arrayList2) {
            int i11 = c3930f.f13224b;
            if (i11 == 1 || i11 == 5 || i11 == 28 || i11 == 1) {
                arrayList3.add(c3930f);
            }
        }
        return (C3930f[]) arrayList3.toArray(new C3930f[0]);
    }
}
