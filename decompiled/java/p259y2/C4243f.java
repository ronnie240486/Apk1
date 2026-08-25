package p259y2;

import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;
import p124l6.C2982h;
import p186r3.AbstractC3602f;

public final class C4243f {

    public final C2982h f14406a = new C2982h(13);

    public final C4242e f14407b = new C4242e(0);

    public final HashMap f14408c = new HashMap();

    public final HashMap f14409d = new HashMap();

    public final int f14410e;

    public int f14411f;

    public C4243f(int i6) {
        this.f14410e = i6;
    }

    public final synchronized void m8284a() {
        m8286c(0);
    }

    public final void m8285b(int i6, Class cls) {
        NavigableMap navigableMapM8290g = m8290g(cls);
        Integer num = (Integer) navigableMapM8290g.get(Integer.valueOf(i6));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapM8290g.remove(Integer.valueOf(i6));
                return;
            } else {
                navigableMapM8290g.put(Integer.valueOf(i6), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i6 + ", this: " + this);
    }

    public final void m8286c(int i6) {
        while (this.f14411f > i6) {
            Object objM6038A = this.f14406a.m6038A();
            AbstractC3602f.m7224b(objM6038A);
            C4239b c4239bM8288e = m8288e(objM6038A.getClass());
            this.f14411f -= c4239bM8288e.m8280b() * c4239bM8288e.m8279a(objM6038A);
            m8285b(c4239bM8288e.m8279a(objM6038A), objM6038A.getClass());
            if (Log.isLoggable(c4239bM8288e.m8281c(), 2)) {
                Log.v(c4239bM8288e.m8281c(), "evicted: " + c4239bM8288e.m8279a(objM6038A));
            }
        }
    }

    public final synchronized Object m8287d(int i6, Class cls) {
        C4241d c4241d;
        int i10;
        try {
            Integer num = (Integer) m8290g(cls).ceilingKey(Integer.valueOf(i6));
            if (num == null || ((i10 = this.f14411f) != 0 && this.f14410e / i10 < 2 && num.intValue() > i6 * 8)) {
                C4242e c4242e = this.f14407b;
                InterfaceC4245h interfaceC4245hM8283e = (InterfaceC4245h) ((ArrayDeque) c4242e.f7850a).poll();
                if (interfaceC4245hM8283e == null) {
                    interfaceC4245hM8283e = c4242e.m8283e();
                }
                c4241d = (C4241d) interfaceC4245hM8283e;
                c4241d.f14403b = i6;
                c4241d.f14404c = cls;
            } else {
                C4242e c4242e2 = this.f14407b;
                int iIntValue = num.intValue();
                InterfaceC4245h interfaceC4245hM8283e2 = (InterfaceC4245h) ((ArrayDeque) c4242e2.f7850a).poll();
                if (interfaceC4245hM8283e2 == null) {
                    interfaceC4245hM8283e2 = c4242e2.m8283e();
                }
                c4241d = (C4241d) interfaceC4245hM8283e2;
                c4241d.f14403b = iIntValue;
                c4241d.f14404c = cls;
            }
        } catch (Throwable th) {
            throw th;
        }
        return m8289f(c4241d, cls);
    }

    public final C4239b m8288e(Class cls) {
        HashMap map = this.f14409d;
        C4239b c4239b = (C4239b) map.get(cls);
        if (c4239b == null) {
            if (cls.equals(int[].class)) {
                c4239b = new C4239b(1);
            } else {
                if (!cls.equals(byte[].class)) {
                    throw new IllegalArgumentException("No array pool found for: ".concat(cls.getSimpleName()));
                }
                c4239b = new C4239b(0);
            }
            map.put(cls, c4239b);
        }
        return c4239b;
    }

    public final Object m8289f(C4241d c4241d, Class cls) {
        Object obj;
        C4239b c4239bM8288e = m8288e(cls);
        Object objM6044q = this.f14406a.m6044q(c4241d);
        if (objM6044q != null) {
            this.f14411f -= c4239bM8288e.m8280b() * c4239bM8288e.m8279a(objM6044q);
            m8285b(c4239bM8288e.m8279a(objM6044q), cls);
        }
        if (objM6044q != null) {
            return objM6044q;
        }
        if (Log.isLoggable(c4239bM8288e.m8281c(), 2)) {
            Log.v(c4239bM8288e.m8281c(), "Allocated " + c4241d.f14403b + " bytes");
        }
        int i6 = c4241d.f14403b;
        switch (c4239bM8288e.f14397a) {
            case 0:
                obj = new byte[i6];
                break;
            default:
                obj = new int[i6];
                break;
        }
        return obj;
    }

    public final NavigableMap m8290g(Class cls) {
        HashMap map = this.f14408c;
        NavigableMap navigableMap = (NavigableMap) map.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(cls, treeMap);
        return treeMap;
    }

    public final synchronized void m8291h(Object obj) {
        Class<?> cls = obj.getClass();
        C4239b c4239bM8288e = m8288e(cls);
        int iM8279a = c4239bM8288e.m8279a(obj);
        int iM8280b = c4239bM8288e.m8280b() * iM8279a;
        if (iM8280b <= this.f14410e / 2) {
            C4242e c4242e = this.f14407b;
            InterfaceC4245h interfaceC4245hM8283e = (InterfaceC4245h) ((ArrayDeque) c4242e.f7850a).poll();
            if (interfaceC4245hM8283e == null) {
                interfaceC4245hM8283e = c4242e.m8283e();
            }
            C4241d c4241d = (C4241d) interfaceC4245hM8283e;
            c4241d.f14403b = iM8279a;
            c4241d.f14404c = cls;
            this.f14406a.m6052y(c4241d, obj);
            NavigableMap navigableMapM8290g = m8290g(cls);
            Integer num = (Integer) navigableMapM8290g.get(Integer.valueOf(c4241d.f14403b));
            Integer numValueOf = Integer.valueOf(c4241d.f14403b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapM8290g.put(numValueOf, Integer.valueOf(iIntValue));
            this.f14411f += iM8280b;
            m8286c(this.f14410e);
        }
    }

    public final synchronized void m8292i(int i6) {
        try {
            if (i6 >= 40) {
                m8284a();
            } else if (i6 >= 20 || i6 == 15) {
                m8286c(this.f14410e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
