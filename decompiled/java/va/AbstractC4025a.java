package va;

import java.util.concurrent.atomic.AtomicReference;
import p055ea.AbstractC2460q;
import p255xa.C4182a;
import p255xa.C4183b;

public abstract class AbstractC4025a {
    static {
        Object objNewInstance;
        AtomicReference atomicReference = C4183b.f14126b.f14127a;
        if (atomicReference.get() == null) {
            String simpleName = C4182a.class.getSimpleName();
            String property = System.getProperty("rxjava.plugin." + simpleName + ".implementation");
            if (property != null) {
                try {
                    objNewInstance = Class.forName(property).asSubclass(C4182a.class).newInstance();
                } catch (ClassCastException unused) {
                    throw new RuntimeException(simpleName + " implementation is not an instance of " + simpleName + ": " + property);
                } catch (ClassNotFoundException e5) {
                    throw new RuntimeException(AbstractC2460q.m5495i(simpleName, " implementation class not found: ", property), e5);
                } catch (IllegalAccessException e10) {
                    throw new RuntimeException(AbstractC2460q.m5495i(simpleName, " implementation not able to be accessed: ", property), e10);
                } catch (InstantiationException e11) {
                    throw new RuntimeException(AbstractC2460q.m5495i(simpleName, " implementation not able to be instantiated: ", property), e11);
                }
            } else {
                objNewInstance = null;
            }
            if (objNewInstance == null) {
                C4182a c4182a = C4182a.f14125a;
                while (!atomicReference.compareAndSet(null, c4182a) && atomicReference.get() == null) {
                }
            } else {
                C4182a c4182a2 = (C4182a) objNewInstance;
                while (!atomicReference.compareAndSet(null, c4182a2) && atomicReference.get() == null) {
                }
            }
        }
    }
}
