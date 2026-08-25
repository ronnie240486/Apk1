package p043d9;

import java.lang.reflect.Method;
import p103j9.AbstractC2796i;

public abstract class AbstractC2337a {

    public static final Method f8137a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        AbstractC2796i.m5782c(methods);
        int length = methods.length;
        int i6 = 0;
        while (true) {
            method = null;
            if (i6 >= length) {
                break;
            }
            Method method2 = methods[i6];
            if (AbstractC2796i.m5780a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                AbstractC2796i.m5784e(parameterTypes, "getParameterTypes(...)");
                if (AbstractC2796i.m5780a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i6++;
        }
        f8137a = method;
        int length2 = methods.length;
        for (int i10 = 0; i10 < length2 && !AbstractC2796i.m5780a(methods[i10].getName(), "getSuppressed"); i10++) {
        }
    }
}
