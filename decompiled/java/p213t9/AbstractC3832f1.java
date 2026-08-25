package p213t9;

public abstract class AbstractC3832f1 {

    public static final ThreadLocal f12914a = new ThreadLocal();

    public static AbstractC3834g0 m7670a() {
        ThreadLocal threadLocal = f12914a;
        AbstractC3834g0 abstractC3834g0 = (AbstractC3834g0) threadLocal.get();
        if (abstractC3834g0 != null) {
            return abstractC3834g0;
        }
        C3821c c3821c = new C3821c(Thread.currentThread());
        threadLocal.set(c3821c);
        return c3821c;
    }
}
