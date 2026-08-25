package p090i8;

import java.util.concurrent.TimeUnit;
import p004a3.RunnableC0038c;
import p102j8.InterfaceC2787b;

public abstract class AbstractC2712f {
    static {
        Boolean.getBoolean("rx3.scheduler.use-nanotime");
        long jLongValue = Long.getLong("rx3.scheduler.drift-tolerance", 15L).longValue();
        String property = System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes");
        if ("seconds".equalsIgnoreCase(property)) {
            TimeUnit.SECONDS.toNanos(jLongValue);
        } else if ("milliseconds".equalsIgnoreCase(property)) {
            TimeUnit.MILLISECONDS.toNanos(jLongValue);
        } else {
            TimeUnit.MINUTES.toNanos(jLongValue);
        }
    }

    public abstract AbstractC2711e mo5677a();

    public InterfaceC2787b mo5678b(RunnableC0038c runnableC0038c, TimeUnit timeUnit) {
        AbstractC2711e abstractC2711eMo5677a = mo5677a();
        RunnableC2710d runnableC2710d = new RunnableC2710d(runnableC0038c, abstractC2711eMo5677a);
        abstractC2711eMo5677a.mo5676b(runnableC2710d, timeUnit);
        return runnableC2710d;
    }
}
