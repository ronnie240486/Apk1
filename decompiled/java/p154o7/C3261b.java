package p154o7;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import p125l7.AbstractC3011r;
import p125l7.C3004k;
import p125l7.C3007n;
import p134m7.InterfaceC3084b;
import p144n7.InterfaceC3215m;
import p212t7.C3812a;
import p212t7.C3813b;

public final class C3261b extends AbstractC3011r {

    public static final C3260a f10894d = new C3260a(0);

    public final int f10895a;

    public final Object f10896b;

    public final Object f10897c;

    public C3261b(Class cls) {
        this.f10895a = 3;
        this.f10897c = new HashMap();
        this.f10896b = new HashMap();
        try {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isEnumConstant()) {
                    AccessController.doPrivileged(new C3274o(field));
                    Enum r10 = (Enum) field.get(null);
                    String strName = r10.name();
                    InterfaceC3084b interfaceC3084b = (InterfaceC3084b) field.getAnnotation(InterfaceC3084b.class);
                    if (interfaceC3084b != null) {
                        strName = interfaceC3084b.value();
                        for (String str : interfaceC3084b.alternate()) {
                            ((HashMap) this.f10897c).put(str, r10);
                        }
                    }
                    ((HashMap) this.f10897c).put(strName, r10);
                    ((HashMap) this.f10896b).put(r10, strName);
                }
            }
        } catch (IllegalAccessException e5) {
            throw new AssertionError(e5);
        }
    }

    @Override
    public final Object mo6077a(C3812a c3812a) throws IOException {
        switch (this.f10895a) {
            case 0:
                if (c3812a.m7612u() == 9) {
                    c3812a.m7608q();
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                c3812a.m7592a();
                while (c3812a.m7599h()) {
                    arrayList.add(((C3271l) this.f10896b).f10929b.mo6077a(c3812a));
                }
                c3812a.m7596e();
                int size = arrayList.size();
                Object objNewInstance = Array.newInstance((Class<?>) this.f10897c, size);
                for (int i6 = 0; i6 < size; i6++) {
                    Array.set(objNewInstance, i6, arrayList.get(i6));
                }
                return objNewInstance;
            case 1:
                if (c3812a.m7612u() == 9) {
                    c3812a.m7608q();
                    return null;
                }
                Collection collection = (Collection) ((InterfaceC3215m) this.f10897c).mo135n();
                c3812a.m7592a();
                while (c3812a.m7599h()) {
                    collection.add(((C3271l) this.f10896b).f10929b.mo6077a(c3812a));
                }
                c3812a.m7596e();
                return collection;
            case 2:
                Object objMo6077a = ((C3272m) this.f10896b).f10933c.mo6077a(c3812a);
                if (objMo6077a != null) {
                    Class cls = (Class) this.f10897c;
                    if (!cls.isInstance(objMo6077a)) {
                        throw new C3007n("Expected a " + cls.getName() + " but was " + objMo6077a.getClass().getName());
                    }
                }
                return objMo6077a;
            default:
                if (c3812a.m7612u() != 9) {
                    return (Enum) ((HashMap) this.f10897c).get(c3812a.m7610s());
                }
                c3812a.m7608q();
                return null;
        }
    }

    @Override
    public final void mo6078b(C3813b c3813b, Object obj) throws IOException {
        switch (this.f10895a) {
            case 0:
                if (obj == null) {
                    c3813b.m7626i();
                } else {
                    c3813b.m7619b();
                    int length = Array.getLength(obj);
                    for (int i6 = 0; i6 < length; i6++) {
                        ((C3271l) this.f10896b).mo6078b(c3813b, Array.get(obj, i6));
                    }
                    c3813b.m7622e();
                }
                break;
            case 1:
                Collection collection = (Collection) obj;
                if (collection == null) {
                    c3813b.m7626i();
                } else {
                    c3813b.m7619b();
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        ((C3271l) this.f10896b).mo6078b(c3813b, it.next());
                    }
                    c3813b.m7622e();
                }
                break;
            case 2:
                ((C3272m) this.f10896b).f10933c.mo6078b(c3813b, obj);
                break;
            default:
                Enum r10 = (Enum) obj;
                c3813b.m7631n(r10 == null ? null : (String) ((HashMap) this.f10896b).get(r10));
                break;
        }
    }

    public C3261b(C3004k c3004k, Type type, AbstractC3011r abstractC3011r, InterfaceC3215m interfaceC3215m) {
        this.f10895a = 1;
        this.f10896b = new C3271l(c3004k, abstractC3011r, type);
        this.f10897c = interfaceC3215m;
    }

    public C3261b(C3004k c3004k, AbstractC3011r abstractC3011r, Class cls) {
        this.f10895a = 0;
        this.f10896b = new C3271l(c3004k, abstractC3011r, cls);
        this.f10897c = cls;
    }

    public C3261b(C3272m c3272m, Class cls) {
        this.f10895a = 2;
        this.f10896b = c3272m;
        this.f10897c = cls;
    }
}
