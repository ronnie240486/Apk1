package p090i8;

import java.util.concurrent.TimeUnit;
import p102j8.InterfaceC2787b;
import p169p8.RunnableC3379d;

public abstract class AbstractC2711e implements InterfaceC2787b {
    public abstract InterfaceC2787b mo5676b(Runnable runnable, TimeUnit timeUnit);

    public void mo5706c(RunnableC3379d runnableC3379d) {
        mo5676b(runnableC3379d, TimeUnit.NANOSECONDS);
    }
}
