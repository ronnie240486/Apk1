package okhttp3.internal.concurrent;

import com.lzy.okgo.cookie.SerializableCookie;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;

public abstract class Task {
    private final boolean cancelable;
    private final String name;
    private long nextExecuteNanoTime;
    private TaskQueue queue;

    public Task(String str, boolean z7) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        this.name = str;
        this.cancelable = z7;
        this.nextExecuteNanoTime = -1L;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    public final String getName() {
        return this.name;
    }

    public final long getNextExecuteNanoTime$okhttp() {
        return this.nextExecuteNanoTime;
    }

    public final TaskQueue getQueue$okhttp() {
        return this.queue;
    }

    public final void initQueue$okhttp(TaskQueue taskQueue) {
        AbstractC2796i.m5785f(taskQueue, "queue");
        TaskQueue taskQueue2 = this.queue;
        if (taskQueue2 == taskQueue) {
            return;
        }
        if (taskQueue2 != null) {
            throw new IllegalStateException("task is in multiple queues");
        }
        this.queue = taskQueue;
    }

    public abstract long runOnce();

    public final void setNextExecuteNanoTime$okhttp(long j10) {
        this.nextExecuteNanoTime = j10;
    }

    public final void setQueue$okhttp(TaskQueue taskQueue) {
        this.queue = taskQueue;
    }

    public String toString() {
        return this.name;
    }

    public Task(String str, boolean z7, int i6, AbstractC2793f abstractC2793f) {
        this(str, (i6 & 2) != 0 ? true : z7);
    }
}
