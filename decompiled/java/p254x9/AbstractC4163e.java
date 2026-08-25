package p254x9;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import p103j9.AbstractC2796i;
import p181q9.AbstractC3548f;
import p181q9.C3543a;
import p181q9.C3549g;
import p224u9.C3937b;

public abstract class AbstractC4163e {

    public static final List f14087a;

    static {
        try {
            Iterator it = Arrays.asList(new C3937b()).iterator();
            AbstractC2796i.m5785f(it, "<this>");
            f14087a = AbstractC3548f.m7172p(new C3543a(new C3549g(1, it)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
