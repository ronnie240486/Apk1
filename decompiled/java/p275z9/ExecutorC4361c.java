package p275z9;

import java.util.concurrent.Executor;
import p008a9.C0080j;
import p008a9.InterfaceC0079i;
import p213t9.AbstractC3837h0;
import p213t9.AbstractC3855p;
import p254x9.AbstractC4159a;
import p254x9.AbstractC4178t;

public final class ExecutorC4361c extends AbstractC3837h0 implements Executor {

    public static final ExecutorC4361c f14822c = new ExecutorC4361c();

    public static final AbstractC3855p f14823d;

    static {
        C4369k c4369k = C4369k.f14838c;
        int i6 = AbstractC4178t.f14117a;
        if (64 >= i6) {
            i6 = 64;
        }
        f14823d = c4369k.m8415h(AbstractC4159a.m8208i("kotlinx.coroutines.io.parallelism", i6, 0, 0, 12));
    }

    @Override
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override
    public final void mo7665d(InterfaceC0079i interfaceC0079i, Runnable runnable) {
        f14823d.mo7665d(interfaceC0079i, runnable);
    }

    @Override
    public final void execute(Runnable runnable) {
        mo7665d(C0080j.f206a, runnable);
    }

    @Override
    public final String toString() {
        return "Dispatchers.IO";
    }
}
