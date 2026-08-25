package com.google.common.util.concurrent;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import p020b7.AbstractC1332b;

@ElementTypesAreNonnullByDefault
final class ListenerCallQueue<L> {
    private static final LazyLogger logger = new LazyLogger(ListenerCallQueue.class);
    private final List<PerListenerQueue<L>> listeners = Collections.synchronizedList(new ArrayList());

    public interface Event<L> {
        void call(L l9);
    }

    public static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        boolean isThreadScheduled;
        final L listener;
        final Queue<Event<L>> waitQueue = new ArrayDeque();
        final Queue<Object> labelQueue = new ArrayDeque();

        public PerListenerQueue(L l9, Executor executor) {
            l9.getClass();
            this.listener = l9;
            executor.getClass();
            this.executor = executor;
        }

        public synchronized void add(Event<L> event, Object obj) {
            this.waitQueue.add(event);
            this.labelQueue.add(obj);
        }

        public void dispatch() throws Exception {
            boolean z7;
            synchronized (this) {
                try {
                    if (this.isThreadScheduled) {
                        z7 = false;
                    } else {
                        z7 = true;
                        this.isThreadScheduled = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z7) {
                try {
                    this.executor.execute(this);
                } catch (Exception e5) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        ListenerCallQueue.logger.get().log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, (Throwable) e5);
                        throw e5;
                    }
                }
            }
        }

        @Override
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws Throwable {
            Throwable th;
            boolean z7;
            while (true) {
                boolean z10 = true;
                try {
                    synchronized (this) {
                        try {
                            AbstractC1332b.m3224o(this.isThreadScheduled);
                            Event<L> eventPoll = this.waitQueue.poll();
                            Object objPoll = this.labelQueue.poll();
                            if (eventPoll == null) {
                                this.isThreadScheduled = false;
                                try {
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z7 = false;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            z7 = true;
                        }
                        while (true) {
                        }
                    }
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        boolean z11 = z7;
                        th = th4;
                        z10 = z11;
                        if (z10) {
                            synchronized (this) {
                                this.isThreadScheduled = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (z10) {
                        synchronized (this) {
                            this.isThreadScheduled = false;
                        }
                    }
                    throw th;
                }
            }
        }
    }

    private void enqueueHelper(Event<L> event, Object obj) {
        AbstractC1332b.m3219j(event, "event");
        AbstractC1332b.m3219j(obj, "label");
        synchronized (this.listeners) {
            try {
                Iterator<PerListenerQueue<L>> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().add(event, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addListener(L l9, Executor executor) {
        AbstractC1332b.m3219j(l9, "listener");
        AbstractC1332b.m3219j(executor, "executor");
        this.listeners.add(new PerListenerQueue<>(l9, executor));
    }

    public void dispatch() throws Exception {
        for (int i6 = 0; i6 < this.listeners.size(); i6++) {
            this.listeners.get(i6).dispatch();
        }
    }

    public void enqueue(Event<L> event) {
        enqueueHelper(event, event);
    }

    public void enqueue(Event<L> event, String str) {
        enqueueHelper(event, str);
    }
}
