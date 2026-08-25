package ua;

import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.C0423q;
import com.google.android.gms.internal.cast.C1613l1;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import org.bitspark.android.Spark;
import p124l6.C2982h;

public final class C3944e {

    public static volatile C3944e f13249o;

    public static final C3945f f13250p;

    public static final HashMap f13251q;

    public final C3952m f13259h;

    public final ExecutorService f13260i;

    public final boolean f13261j;

    public final boolean f13262k;

    public final boolean f13263l;

    public final boolean f13264m;

    public final boolean f13265n;

    public final C1613l1 f13255d = new C1613l1(3);

    public final HashMap f13252a = new HashMap();

    public final HashMap f13253b = new HashMap();

    public final ConcurrentHashMap f13254c = new ConcurrentHashMap();

    public final HandlerC3946g f13256e = new HandlerC3946g(this, Looper.getMainLooper());

    public final RunnableC3941b f13257f = new RunnableC3941b(this);

    public final RunnableC3940a f13258g = new RunnableC3940a(this);

    static {
        C3945f c3945f = new C3945f();
        c3945f.f13267a = C3945f.f13266b;
        f13250p = c3945f;
        f13251q = new HashMap();
    }

    public C3944e() {
        C3945f c3945f = f13250p;
        c3945f.getClass();
        this.f13259h = new C3952m();
        this.f13261j = true;
        this.f13262k = true;
        this.f13263l = true;
        this.f13264m = true;
        this.f13265n = true;
        this.f13260i = c3945f.f13267a;
    }

    public static void m7866a(ArrayList arrayList, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!arrayList.contains(cls)) {
                arrayList.add(cls);
                m7866a(arrayList, cls.getInterfaces());
            }
        }
    }

    public static C3944e m7867b() {
        if (f13249o == null) {
            synchronized (C3944e.class) {
                try {
                    if (f13249o == null) {
                        f13249o = new C3944e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f13249o;
    }

    public final void m7868c(C3948i c3948i) {
        Object obj = c3948i.f13275a;
        C3953n c3953n = c3948i.f13276b;
        c3948i.f13275a = null;
        c3948i.f13276b = null;
        c3948i.f13277c = null;
        ArrayList arrayList = C3948i.f13274d;
        synchronized (arrayList) {
            if (arrayList.size() < 10000) {
                arrayList.add(c3948i);
            }
        }
        if (c3953n.f13291c) {
            m7869d(c3953n, obj);
        }
    }

    public final void m7869d(C3953n c3953n, Object obj) {
        try {
            c3953n.f13290b.f13281a.invoke(c3953n.f13289a, obj);
        } catch (IllegalAccessException e5) {
            throw new IllegalStateException("Unexpected exception", e5);
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            boolean z7 = obj instanceof C3950k;
            boolean z10 = this.f13261j;
            if (!z7) {
                if (z10) {
                    Log.e("EventBus", "Could not dispatch event: " + obj.getClass() + " to subscribing class " + c3953n.f13289a.getClass(), cause);
                }
                if (this.f13263l) {
                    m7870e(new C3950k(cause, obj, c3953n.f13289a));
                    return;
                }
                return;
            }
            if (z10) {
                Log.e("EventBus", "SubscriberExceptionEvent subscriber " + c3953n.f13289a.getClass() + " threw an exception", cause);
                C3950k c3950k = (C3950k) obj;
                Log.e("EventBus", "Initial event " + c3950k.f13279b + " caused exception in " + c3950k.f13280c, c3950k.f13278a);
            }
        }
    }

    public final void m7870e(Object obj) {
        C3943d c3943d = (C3943d) this.f13255d.get();
        ArrayList arrayList = c3943d.f13245a;
        arrayList.add(obj);
        if (c3943d.f13246b) {
            return;
        }
        c3943d.f13247c = Looper.getMainLooper() == Looper.myLooper();
        c3943d.f13246b = true;
        while (!arrayList.isEmpty()) {
            try {
                m7871f(arrayList.remove(0), c3943d);
            } catch (Throwable th) {
                c3943d.f13246b = false;
                c3943d.f13247c = false;
                throw th;
            }
        }
        c3943d.f13246b = false;
        c3943d.f13247c = false;
    }

    public final void m7871f(Object obj, C3943d c3943d) {
        boolean zM7872g;
        List list;
        Class<?> cls = obj.getClass();
        if (this.f13265n) {
            HashMap map = f13251q;
            synchronized (map) {
                try {
                    List list2 = (List) map.get(cls);
                    list = list2;
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                            arrayList.add(superclass);
                            m7866a(arrayList, superclass.getInterfaces());
                        }
                        f13251q.put(cls, arrayList);
                        list = arrayList;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int size = list.size();
            zM7872g = false;
            for (int i6 = 0; i6 < size; i6++) {
                zM7872g |= m7872g(obj, c3943d, (Class) list.get(i6));
            }
        } else {
            zM7872g = m7872g(obj, c3943d, cls);
        }
        if (zM7872g) {
            return;
        }
        if (this.f13262k) {
            Log.d("EventBus", "No subscribers registered for event " + cls);
        }
        if (!this.f13264m || cls == C3947h.class || cls == C3950k.class) {
            return;
        }
        m7870e(new C3947h(obj));
    }

    public final boolean m7872g(Object obj, C3943d c3943d, Class cls) {
        CopyOnWriteArrayList<C3953n> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.f13252a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (C3953n c3953n : copyOnWriteArrayList) {
            c3943d.f13248d = obj;
            m7873h(c3953n, obj, c3943d.f13247c);
        }
        return true;
    }

    public final void m7873h(C3953n c3953n, Object obj, boolean z7) {
        int i6 = AbstractC3942c.f13244a[c3953n.f13290b.f13282b.ordinal()];
        if (i6 == 1) {
            m7869d(c3953n, obj);
            return;
        }
        if (i6 == 2) {
            if (z7) {
                m7869d(c3953n, obj);
                return;
            } else {
                this.f13256e.m7875a(c3953n, obj);
                return;
            }
        }
        if (i6 != 3) {
            if (i6 != 4) {
                throw new IllegalStateException("Unknown thread mode: " + c3953n.f13290b.f13282b);
            }
            RunnableC3940a runnableC3940a = this.f13258g;
            runnableC3940a.getClass();
            ((C2982h) runnableC3940a.f13239b).m6043p(C3948i.m7877a(c3953n, obj));
            ((C3944e) runnableC3940a.f13240c).f13260i.execute(runnableC3940a);
            return;
        }
        if (!z7) {
            m7869d(c3953n, obj);
            return;
        }
        RunnableC3941b runnableC3941b = this.f13257f;
        runnableC3941b.getClass();
        C3948i c3948iM7877a = C3948i.m7877a(c3953n, obj);
        synchronized (runnableC3941b) {
            try {
                runnableC3941b.f13241a.m6043p(c3948iM7877a);
                if (!runnableC3941b.f13243c) {
                    runnableC3941b.f13243c = true;
                    runnableC3941b.f13242b.f13260i.execute(runnableC3941b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m7874i(Spark spark, C3951l c3951l) {
        Object value;
        Class cls = c3951l.f13283c;
        C3953n c3953n = new C3953n(spark, c3951l);
        HashMap map = this.f13252a;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) map.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            map.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(c3953n)) {
            throw new C0423q("Subscriber " + spark.getClass() + " already registered to event " + cls, 9);
        }
        int size = copyOnWriteArrayList.size();
        for (int i6 = 0; i6 <= size; i6++) {
            if (i6 != size) {
                if (c3951l.f13284d <= ((C3953n) copyOnWriteArrayList.get(i6)).f13290b.f13284d) {
                }
            }
            copyOnWriteArrayList.add(i6, c3953n);
            break;
        }
        HashMap map2 = this.f13253b;
        List arrayList = (List) map2.get(spark);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map2.put(spark, arrayList);
        }
        arrayList.add(cls);
        if (c3951l.f13285e) {
            ConcurrentHashMap concurrentHashMap = this.f13254c;
            if (!this.f13265n) {
                Object obj = concurrentHashMap.get(cls);
                if (obj != null) {
                    m7873h(c3953n, obj, Looper.getMainLooper() == Looper.myLooper());
                    return;
                }
                return;
            }
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey()) && (value = entry.getValue()) != null) {
                    m7873h(c3953n, value, Looper.getMainLooper() == Looper.myLooper());
                }
            }
        }
    }

    public final String toString() {
        return "EventBus[indexCount=0, eventInheritance=" + this.f13265n + "]";
    }
}
