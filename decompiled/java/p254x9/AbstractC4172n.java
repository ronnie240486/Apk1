package p254x9;

import android.os.Looper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import p103j9.AbstractC2796i;
import p181q9.AbstractC3548f;
import p181q9.C3543a;
import p181q9.C3549g;
import p224u9.AbstractC3939d;
import p224u9.C3936a;
import p224u9.C3938c;

public abstract class AbstractC4172n {

    public static final C3938c f14112a;

    static {
        String property;
        int i6 = AbstractC4178t.f14117a;
        Object next = null;
        try {
            property = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null) {
            Boolean.parseBoolean(property);
        }
        try {
            Iterator it = Arrays.asList(new C3936a()).iterator();
            AbstractC2796i.m5785f(it, "<this>");
            Iterator it2 = AbstractC3548f.m7172p(new C3543a(new C3549g(1, it))).iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    int iM7862a = ((C3936a) next).m7862a();
                    do {
                        Object next2 = it2.next();
                        int iM7862a2 = ((C3936a) next2).m7862a();
                        if (iM7862a < iM7862a2) {
                            next = next2;
                            iM7862a = iM7862a2;
                        }
                    } while (it2.hasNext());
                }
            }
            C3936a c3936a = (C3936a) next;
            if (c3936a == null) {
                throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
            }
            try {
                c3936a.getClass();
                Looper mainLooper = Looper.getMainLooper();
                if (mainLooper == null) {
                    throw new IllegalStateException("The main looper is not available");
                }
                f14112a = new C3938c(AbstractC3939d.m7863a(mainLooper));
            } catch (Throwable th) {
                c3936a.getClass();
                throw th;
            }
        } catch (Throwable th2) {
            throw new ServiceConfigurationError(th2.getMessage(), th2);
        }
    }
}
