package okhttp3.internal.concurrent;

import androidx.media3.common.PlaybackException;
import java.util.Arrays;
import java.util.logging.Level;
import okhttp3.internal.http2.Http2Connection;
import p000a.AbstractC0004e;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2796i;

public final class TaskLoggerKt {
    public static final String formatDuration(long j10) {
        String strM25s;
        if (j10 <= -999500000) {
            strM25s = AbstractC0004e.m25s(new StringBuilder(), (j10 - ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS), " s ");
        } else if (j10 <= -999500) {
            strM25s = AbstractC0004e.m25s(new StringBuilder(), (j10 - ((long) 500000)) / ((long) PlaybackException.CUSTOM_ERROR_CODE_BASE), " ms");
        } else if (j10 <= 0) {
            strM25s = AbstractC0004e.m25s(new StringBuilder(), (j10 - ((long) 500)) / ((long) 1000), " µs");
        } else if (j10 < 999500) {
            strM25s = AbstractC0004e.m25s(new StringBuilder(), (j10 + ((long) 500)) / ((long) 1000), " µs");
        } else {
            strM25s = j10 < 999500000 ? AbstractC0004e.m25s(new StringBuilder(), (j10 + ((long) 500000)) / ((long) PlaybackException.CUSTOM_ERROR_CODE_BASE), " ms") : AbstractC0004e.m25s(new StringBuilder(), (j10 + ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS), " s ");
        }
        return String.format("%6s", Arrays.copyOf(new Object[]{strM25s}, 1));
    }

    public static final void log(Task task, TaskQueue taskQueue, String str) {
        TaskRunner.Companion.getLogger().fine(taskQueue.getName$okhttp() + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + task.getName());
    }

    public static final <T> T logElapsed(Task task, TaskQueue taskQueue, InterfaceC2713a interfaceC2713a) {
        long jNanoTime;
        AbstractC2796i.m5785f(task, "task");
        AbstractC2796i.m5785f(taskQueue, "queue");
        AbstractC2796i.m5785f(interfaceC2713a, "block");
        boolean zIsLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (zIsLoggable) {
            jNanoTime = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, taskQueue, "starting");
        } else {
            jNanoTime = -1;
        }
        try {
            T t5 = (T) interfaceC2713a.invoke();
            if (zIsLoggable) {
                long jNanoTime2 = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - jNanoTime;
                StringBuilder sb = new StringBuilder("finished run in ");
            }
            return t5;
        } finally {
            if (zIsLoggable) {
                log(task, taskQueue, "failed a run in " + formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - jNanoTime));
            }
        }
    }

    public static final void taskLog(Task task, TaskQueue taskQueue, InterfaceC2713a interfaceC2713a) {
        AbstractC2796i.m5785f(task, "task");
        AbstractC2796i.m5785f(taskQueue, "queue");
        AbstractC2796i.m5785f(interfaceC2713a, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, taskQueue, (String) interfaceC2713a.invoke());
        }
    }
}
