package ua;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import p000a.C0016q;

public final class C3952m {

    public static final ConcurrentHashMap f13287a = new ConcurrentHashMap();

    public static final C0016q[] f13288b = new C0016q[4];

    public static void m7879a(C0016q c0016q) {
        Method[] methods;
        InterfaceC3949j interfaceC3949j;
        boolean zM49b;
        try {
            methods = ((Class) c0016q.f36f).getDeclaredMethods();
        } catch (Throwable unused) {
            methods = ((Class) c0016q.f36f).getMethods();
            c0016q.f31a = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && (interfaceC3949j = (InterfaceC3949j) method.getAnnotation(InterfaceC3949j.class)) != null) {
                    Class<?> cls = parameterTypes[0];
                    HashMap map = (HashMap) c0016q.f33c;
                    Object objPut = map.put(cls, method);
                    if (objPut == null) {
                        zM49b = true;
                    } else {
                        if (objPut instanceof Method) {
                            if (!c0016q.m49b((Method) objPut, cls)) {
                                throw new IllegalStateException();
                            }
                            map.put(cls, c0016q);
                        }
                        zM49b = c0016q.m49b(method, cls);
                    }
                    if (zM49b) {
                        ((ArrayList) c0016q.f32b).add(new C3951l(method, cls, interfaceC3949j.threadMode(), interfaceC3949j.priority(), interfaceC3949j.sticky()));
                    }
                }
            }
        }
    }

    public static ArrayList m7880b(C0016q c0016q) {
        ArrayList arrayList = new ArrayList((ArrayList) c0016q.f32b);
        ((ArrayList) c0016q.f32b).clear();
        ((HashMap) c0016q.f33c).clear();
        ((HashMap) c0016q.f34d).clear();
        ((StringBuilder) c0016q.f35e).setLength(0);
        c0016q.f36f = null;
        c0016q.f31a = false;
        synchronized (f13288b) {
            for (int i6 = 0; i6 < 4; i6++) {
                try {
                    C0016q[] c0016qArr = f13288b;
                    if (c0016qArr[i6] == null) {
                        c0016qArr[i6] = c0016q;
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    public static C0016q m7881c() {
        synchronized (f13288b) {
            for (int i6 = 0; i6 < 4; i6++) {
                try {
                    C0016q[] c0016qArr = f13288b;
                    C0016q c0016q = c0016qArr[i6];
                    if (c0016q != null) {
                        c0016qArr[i6] = null;
                        return c0016q;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new C0016q();
        }
    }
}
