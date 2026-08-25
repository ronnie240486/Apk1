package p275z9;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import p008a9.InterfaceC0079i;
import p213t9.AbstractC3837h0;

public abstract class AbstractC4365g extends AbstractC3837h0 {

    public ExecutorC4360b f14826c;

    @Override
    public final void mo7665d(InterfaceC0079i interfaceC0079i, Runnable runnable) {
        ExecutorC4360b executorC4360b = this.f14826c;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ExecutorC4360b.f14811h;
        executorC4360b.m8411b(runnable, AbstractC4368j.f14836g, false);
    }
}
