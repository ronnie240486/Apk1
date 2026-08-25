package p238w1;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import androidx.fragment.app.C0423q;
import com.p2serv.android.p032ds.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p187r4.AbstractC3612b;

public final class C4046a {

    public static volatile C4046a f13703d;

    public static final Object f13704e = new Object();

    public final Context f13707c;

    public final HashSet f13706b = new HashSet();

    public final HashMap f13705a = new HashMap();

    public C4046a(Context context) {
        this.f13707c = context.getApplicationContext();
    }

    public static C4046a m8050c(Context context) {
        if (f13703d == null) {
            synchronized (f13704e) {
                try {
                    if (f13703d == null) {
                        f13703d = new C4046a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f13703d;
    }

    public final void m8051a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f13707c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    hashSet = this.f13706b;
                    if (!zHasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (InterfaceC4047b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    m8052b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e5) {
                throw new C0423q(e5, 10);
            }
        }
    }

    public final Object m8052b(Class cls, HashSet hashSet) {
        Object objMo1181b;
        if (AbstractC3612b.m7252B()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        HashMap map = this.f13705a;
        if (map.containsKey(cls)) {
            objMo1181b = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                InterfaceC4047b interfaceC4047b = (InterfaceC4047b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listMo1180a = interfaceC4047b.mo1180a();
                if (!listMo1180a.isEmpty()) {
                    for (Class cls2 : listMo1180a) {
                        if (!map.containsKey(cls2)) {
                            m8052b(cls2, hashSet);
                        }
                    }
                }
                objMo1181b = interfaceC4047b.mo1181b(this.f13707c);
                hashSet.remove(cls);
                map.put(cls, objMo1181b);
            } catch (Throwable th2) {
                throw new C0423q(th2, 10);
            }
        }
        Trace.endSection();
        return objMo1181b;
    }
}
