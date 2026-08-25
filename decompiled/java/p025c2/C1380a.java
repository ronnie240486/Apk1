package p025c2;

import android.content.Context;
import p123l5.AbstractC2973a;

public final class C1380a {

    public static final C1380a f4195a = new C1380a();

    public static C1391l f4196b;

    public static final C1391l m3249a(Context context) {
        C1391l c1391l = f4196b;
        if (c1391l != null) {
            return c1391l;
        }
        synchronized (f4195a) {
            C1391l c1391l2 = f4196b;
            if (c1391l2 != null) {
                return c1391l2;
            }
            context.getApplicationContext();
            C1391l c1391lM6018k = AbstractC2973a.m6018k(context);
            f4196b = c1391lM6018k;
            return c1391lM6018k;
        }
    }
}
