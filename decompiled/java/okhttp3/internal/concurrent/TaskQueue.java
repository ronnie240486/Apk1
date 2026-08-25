package okhttp3.internal.concurrent;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import okhttp3.internal.Util;
import p000a.AbstractC0004e;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2796i;
import p253x8.AbstractC4147j;

public final class TaskQueue {
    private Task activeTask;
    private boolean cancelActiveTask;
    private final List<Task> futureTasks;
    private final String name;
    private boolean shutdown;
    private final TaskRunner taskRunner;

    public static final class AwaitIdleTask extends Task {
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super(AbstractC0004e.m26t(new StringBuilder(), Util.okHttpName, " awaitIdle"), false);
            this.latch = new CountDownLatch(1);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override
        public long runOnce() {
            this.latch.countDown();
            return -1L;
        }
    }

    public static final class C32931 extends Task {
        final InterfaceC2713a $block;

        public C32931(String str, boolean z7, InterfaceC2713a interfaceC2713a) {
            super(str, z7);
            this.$block = interfaceC2713a;
        }

        @Override
        public long runOnce() {
            this.$block.invoke();
            return -1L;
        }
    }

    public static final class C32942 extends Task {
        final InterfaceC2713a $block;

        public C32942(String str, InterfaceC2713a interfaceC2713a) {
            super(str, false, 2, null);
            this.$block = interfaceC2713a;
        }

        @Override
        public long runOnce() {
            return ((Number) this.$block.invoke()).longValue();
        }
    }

    public TaskQueue(TaskRunner taskRunner, String str) {
        AbstractC2796i.m5785f(taskRunner, "taskRunner");
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        this.taskRunner = taskRunner;
        this.name = str;
        this.futureTasks = new ArrayList();
    }

    public static void execute$default(TaskQueue taskQueue, String str, long j10, boolean z7, InterfaceC2713a interfaceC2713a, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j10 = 0;
        }
        if ((i6 & 4) != 0) {
            z7 = true;
        }
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        AbstractC2796i.m5785f(interfaceC2713a, "block");
        taskQueue.schedule(new C32931(str, z7, interfaceC2713a), j10);
    }

    public static void schedule$default(TaskQueue taskQueue, Task task, long j10, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j10 = 0;
        }
        taskQueue.schedule(task, j10);
    }

    public final void cancelAll() {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this.taskRunner) {
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null) {
            AbstractC2796i.m5782c(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean z7 = false;
        for (int size = this.futureTasks.size() - 1; -1 < size; size--) {
            if (this.futureTasks.get(size).getCancelable()) {
                Task task2 = this.futureTasks.get(size);
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task2, this, "canceled");
                }
                this.futureTasks.remove(size);
                z7 = true;
            }
        }
        return z7;
    }

    public final void execute(String str, long j10, boolean z7, InterfaceC2713a interfaceC2713a) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        AbstractC2796i.m5785f(interfaceC2713a, "block");
        schedule(new C32931(str, z7, interfaceC2713a), j10);
    }

    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final String getName$okhttp() {
        return this.name;
    }

    public final List<Task> getScheduledTasks() {
        List<Task> listM8189c0;
        synchronized (this.taskRunner) {
            listM8189c0 = AbstractC4147j.m8189c0(this.futureTasks);
        }
        return listM8189c0;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (this.activeTask == null && this.futureTasks.isEmpty()) {
                return new CountDownLatch(0);
            }
            Task task = this.activeTask;
            if (task instanceof AwaitIdleTask) {
                return ((AwaitIdleTask) task).getLatch();
            }
            for (Task task2 : this.futureTasks) {
                if (task2 instanceof AwaitIdleTask) {
                    return ((AwaitIdleTask) task2).getLatch();
                }
            }
            AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
            if (scheduleAndDecide$okhttp(awaitIdleTask, 0L, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            return awaitIdleTask.getLatch();
        }
    }

    public final void schedule(Task task, long j10) {
        AbstractC2796i.m5785f(task, "task");
        synchronized (this.taskRunner) {
            if (!this.shutdown) {
                if (scheduleAndDecide$okhttp(task, j10, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
            } else if (task.getCancelable()) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean scheduleAndDecide$okhttp(Task task, long j10, boolean z7) {
        String str;
        AbstractC2796i.m5785f(task, "task");
        task.initQueue$okhttp(this);
        long jNanoTime = this.taskRunner.getBackend().nanoTime();
        long j11 = jNanoTime + j10;
        int iIndexOf = this.futureTasks.indexOf(task);
        if (iIndexOf != -1) {
            if (task.getNextExecuteNanoTime$okhttp() <= j11) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(iIndexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j11);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            if (z7) {
                str = "run again after " + TaskLoggerKt.formatDuration(j11 - jNanoTime);
            } else {
                str = "scheduled after " + TaskLoggerKt.formatDuration(j11 - jNanoTime);
            }
            TaskLoggerKt.log(task, this, str);
        }
        Iterator<Task> it = this.futureTasks.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (it.next().getNextExecuteNanoTime$okhttp() - jNanoTime > j10) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.futureTasks.size();
        }
        this.futureTasks.add(size, task);
        return size == 0;
    }

    public final void setActiveTask$okhttp(Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z7) {
        this.cancelActiveTask = z7;
    }

    public final void setShutdown$okhttp(boolean z7) {
        this.shutdown = z7;
    }

    public final void shutdown() {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this.taskRunner) {
            this.shutdown = true;
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    public String toString() {
        return this.name;
    }

    public static void schedule$default(TaskQueue taskQueue, String str, long j10, InterfaceC2713a interfaceC2713a, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j10 = 0;
        }
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        AbstractC2796i.m5785f(interfaceC2713a, "block");
        taskQueue.schedule(new C32942(str, interfaceC2713a), j10);
    }

    public final void schedule(String str, long j10, InterfaceC2713a interfaceC2713a) {
        AbstractC2796i.m5785f(str, SerializableCookie.NAME);
        AbstractC2796i.m5785f(interfaceC2713a, "block");
        schedule(new C32942(str, interfaceC2713a), j10);
    }
}
