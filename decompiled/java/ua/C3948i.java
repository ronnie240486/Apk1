package ua;

import java.util.ArrayList;

public final class C3948i {

    public static final ArrayList f13274d = new ArrayList();

    public Object f13275a;

    public C3953n f13276b;

    public C3948i f13277c;

    public static C3948i m7877a(C3953n c3953n, Object obj) {
        ArrayList arrayList = f13274d;
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                if (size <= 0) {
                    C3948i c3948i = new C3948i();
                    c3948i.f13275a = obj;
                    c3948i.f13276b = c3953n;
                    return c3948i;
                }
                C3948i c3948i2 = (C3948i) arrayList.remove(size - 1);
                c3948i2.f13275a = obj;
                c3948i2.f13276b = c3953n;
                c3948i2.f13277c = null;
                return c3948i2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
