package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import androidx.leanback.widget.RunnableC0485n0;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import p004a3.RunnableC0038c;

public final class C2026ai {

    private static C2026ai f7280b;

    public InterfaceC2025ah f7281a;

    private final Context f7283d;

    private long f7285f;

    private long f7286g;

    private Map<Integer, Long> f7284e = new HashMap();

    private LinkedBlockingQueue<Runnable> f7287h = new LinkedBlockingQueue<>();

    private LinkedBlockingQueue<Runnable> f7288i = new LinkedBlockingQueue<>();

    private final Object f7289j = new Object();

    private long f7290k = 0;

    private int f7291l = 0;

    private final C2103w f7282c = C2103w.m5011a();

    private C2026ai(Context context) {
        this.f7283d = context;
    }

    public static int m4614b(C2026ai c2026ai) {
        int i6 = c2026ai.f7291l - 1;
        c2026ai.f7291l = i6;
        return i6;
    }

    public static synchronized C2026ai m4606a(Context context) {
        try {
            if (f7280b == null) {
                f7280b = new C2026ai(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7280b;
    }

    public final boolean m4622b(int i6) {
        if (C2094p.f7657c) {
            C2029al.m4644c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - m4616a(i6);
        C2029al.m4644c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(jCurrentTimeMillis / 1000), Integer.valueOf(i6));
        if (jCurrentTimeMillis >= SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS) {
            return true;
        }
        C2029al.m4640a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    public static synchronized C2026ai m4605a() {
        return f7280b;
    }

    public final void m4619a(int i6, C2062bq c2062bq, String str, String str2, InterfaceC2025ah interfaceC2025ah, long j10, boolean z7) {
        try {
            try {
                m4611a(new RunnableC2027aj(this.f7283d, i6, c2062bq.f7530g, C2022ae.m4589a((Object) c2062bq), str, str2, interfaceC2025ah, z7), true, true, j10);
            } catch (Throwable th) {
                th = th;
                if (C2029al.m4641a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void m4615b() {
        C2028ak c2028akM4631a = C2028ak.m4631a();
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.f7289j) {
            try {
                C2029al.m4644c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                int size = this.f7287h.size();
                int size2 = this.f7288i.size();
                if (size == 0 && size2 == 0) {
                    C2029al.m4644c("[UploadManager] There is no upload task in queue.", new Object[0]);
                    return;
                }
                if (c2028akM4631a == null || !c2028akM4631a.m4636c()) {
                    size2 = 0;
                }
                m4612a(this.f7287h, linkedBlockingQueue, size);
                m4612a(this.f7288i, linkedBlockingQueue2, size2);
                m4609a(size, linkedBlockingQueue);
                if (size2 > 0) {
                    C2029al.m4644c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                }
                C2028ak c2028akM4631a2 = C2028ak.m4631a();
                if (c2028akM4631a2 != null) {
                    c2028akM4631a2.m4633a(new RunnableC0485n0(size2, linkedBlockingQueue2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void m4608a(int i6, int i10, byte[] bArr, String str, String str2, InterfaceC2025ah interfaceC2025ah, boolean z7) {
        try {
            try {
                m4611a(new RunnableC2027aj(this.f7283d, i6, i10, bArr, str, str2, interfaceC2025ah, 0, 0, false), z7, false, 0L);
            } catch (Throwable th) {
                th = th;
                if (C2029al.m4641a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void m4620a(int i6, C2062bq c2062bq, String str, String str2, InterfaceC2025ah interfaceC2025ah, boolean z7) {
        m4608a(i6, c2062bq.f7530g, C2022ae.m4589a((Object) c2062bq), str, str2, interfaceC2025ah, z7);
    }

    public final long m4617a(boolean z7) {
        long jM4709d;
        long jM4695b = C2033ap.m4695b();
        int i6 = z7 ? 5 : 3;
        List<C2105y> listM5028a = this.f7282c.m5028a(i6);
        if (listM5028a != null && listM5028a.size() > 0) {
            jM4709d = 0;
            try {
                C2105y c2105y = listM5028a.get(0);
                if (c2105y.f7710e >= jM4695b) {
                    jM4709d = C2033ap.m4709d(c2105y.f7712g);
                    if (i6 == 3) {
                        this.f7285f = jM4709d;
                    } else {
                        this.f7286g = jM4709d;
                    }
                    listM5028a.remove(c2105y);
                }
            } catch (Throwable th) {
                C2029al.m4641a(th);
            }
            if (listM5028a.size() > 0) {
                this.f7282c.m5030a(listM5028a);
            }
        } else {
            jM4709d = z7 ? this.f7286g : this.f7285f;
        }
        C2029al.m4644c("[UploadManager] Local network consume: %d KB", Long.valueOf(jM4709d / 1024));
        return jM4709d;
    }

    public final synchronized void m4621a(long j10, boolean z7) {
        int i6 = z7 ? 5 : 3;
        try {
            C2105y c2105y = new C2105y();
            c2105y.f7707b = i6;
            c2105y.f7710e = C2033ap.m4695b();
            c2105y.f7708c = "";
            c2105y.f7709d = "";
            c2105y.f7712g = C2033ap.m4708c(j10);
            this.f7282c.m5033b(i6);
            this.f7282c.m5032a(c2105y);
            if (z7) {
                this.f7286g = j10;
            } else {
                this.f7285f = j10;
            }
            C2029al.m4644c("[UploadManager] Network total consume: %d KB", Long.valueOf(j10 / 1024));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void m4618a(int i6, long j10) {
        try {
            if (i6 >= 0) {
                this.f7284e.put(Integer.valueOf(i6), Long.valueOf(j10));
                C2105y c2105y = new C2105y();
                c2105y.f7707b = i6;
                c2105y.f7710e = j10;
                c2105y.f7708c = "";
                c2105y.f7709d = "";
                c2105y.f7712g = new byte[0];
                this.f7282c.m5033b(i6);
                this.f7282c.m5032a(c2105y);
                C2029al.m4644c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i6), C2033ap.m4677a(j10));
                return;
            }
            C2029al.m4646e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i6));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long m4616a(int i6) {
        try {
            if (i6 >= 0) {
                Long l9 = this.f7284e.get(Integer.valueOf(i6));
                if (l9 != null) {
                    return l9.longValue();
                }
            } else {
                C2029al.m4646e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i6));
            }
            return 0L;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static void m4612a(LinkedBlockingQueue<Runnable> linkedBlockingQueue, LinkedBlockingQueue<Runnable> linkedBlockingQueue2, int i6) {
        for (int i10 = 0; i10 < i6; i10++) {
            Runnable runnablePeek = linkedBlockingQueue.peek();
            if (runnablePeek == null) {
                return;
            }
            try {
                linkedBlockingQueue2.put(runnablePeek);
                linkedBlockingQueue.poll();
            } catch (Throwable th) {
                C2029al.m4646e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
            }
        }
    }

    private void m4609a(int i6, LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        C2028ak c2028akM4631a = C2028ak.m4631a();
        if (i6 > 0) {
            C2029al.m4644c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(i6), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        }
        for (int i10 = 0; i10 < i6; i10++) {
            Runnable runnablePoll = linkedBlockingQueue.poll();
            if (runnablePoll == null) {
                return;
            }
            synchronized (this.f7289j) {
                try {
                    if (this.f7291l >= 2 && c2028akM4631a != null) {
                        c2028akM4631a.m4633a(runnablePoll);
                    } else {
                        C2029al.m4640a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                        if (C2033ap.m4683a(new RunnableC0038c(this, 9, runnablePoll), "BUGLY_ASYNC_UPLOAD") != null) {
                            synchronized (this.f7289j) {
                                this.f7291l++;
                            }
                        } else {
                            C2029al.m4645d("[UploadManager] Failed to start a thread to execute asynchronous upload task,will try again next time.", new Object[0]);
                            m4613a(runnablePoll, true);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private boolean m4613a(Runnable runnable, boolean z7) {
        if (runnable == null) {
            C2029al.m4640a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            C2029al.m4644c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f7289j) {
                try {
                    if (z7) {
                        this.f7287h.put(runnable);
                    } else {
                        this.f7288i.put(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        } catch (Throwable th2) {
            C2029al.m4646e("[UploadManager] Failed to add upload task to queue: %s", th2.getMessage());
            return false;
        }
    }

    private void m4610a(Runnable runnable, long j10) {
        if (runnable == null) {
            C2029al.m4645d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        C2029al.m4644c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread threadM4683a = C2033ap.m4683a(runnable, "BUGLY_SYNC_UPLOAD");
        if (threadM4683a == null) {
            C2029al.m4646e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            m4613a(runnable, true);
            return;
        }
        try {
            threadM4683a.join(j10);
        } catch (Throwable th) {
            C2029al.m4646e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            m4613a(runnable, true);
            m4615b();
        }
    }

    private void m4611a(Runnable runnable, boolean z7, boolean z10, long j10) {
        C2029al.m4644c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z10) {
            m4610a(runnable, j10);
        } else {
            m4613a(runnable, z7);
            m4615b();
        }
    }
}
