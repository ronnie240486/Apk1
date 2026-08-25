package androidx.lifecycle;

import com.lzy.okgo.cookie.SerializableCookie;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3656n;

public abstract class AbstractC0561z {

    public static final HashMap f2560a = new HashMap();

    public static final HashMap f2561b = new HashMap();

    public static void m1525a(Constructor constructor, InterfaceC0553v interfaceC0553v) {
        try {
            AbstractC2796i.m5784e(constructor.newInstance(interfaceC0553v), "{\n            constructo…tance(`object`)\n        }");
            throw new ClassCastException();
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(e5);
        } catch (InstantiationException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static int m1526b(Class cls) {
        Constructor declaredConstructor;
        boolean zBooleanValue;
        Class<?>[] interfaces;
        int i6;
        boolean z7;
        int i10 = 1;
        HashMap map = f2560a;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r10 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = r10 != null ? r10.getName() : "";
                AbstractC2796i.m5784e(name, "fullPackage");
                if (name.length() != 0) {
                    AbstractC2796i.m5784e(canonicalName, SerializableCookie.NAME);
                    canonicalName = canonicalName.substring(name.length() + 1);
                    AbstractC2796i.m5784e(canonicalName, "this as java.lang.String).substring(startIndex)");
                }
                AbstractC2796i.m5784e(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
                String strConcat = AbstractC3656n.m7402T(canonicalName, ".", "_").concat("_LifecycleAdapter");
                if (name.length() != 0) {
                    strConcat = name + '.' + strConcat;
                }
                declaredConstructor = Class.forName(strConcat).getDeclaredConstructor(cls);
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                declaredConstructor = null;
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException(e5);
            }
            HashMap map2 = f2561b;
            if (declaredConstructor != null) {
                map2.put(cls, AbstractC0032a.m154F(declaredConstructor));
            } else {
                C0517d c0517d = C0517d.f2468c;
                HashMap map3 = c0517d.f2470b;
                Boolean bool = (Boolean) map3.get(cls);
                if (bool != null) {
                    zBooleanValue = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i11 = 0;
                        while (true) {
                            if (i11 >= length) {
                                map3.put(cls, Boolean.FALSE);
                                zBooleanValue = false;
                                break;
                            }
                            if (((InterfaceC0522f0) declaredMethods[i11].getAnnotation(InterfaceC0522f0.class)) != null) {
                                c0517d.m1480a(cls, declaredMethods);
                                zBooleanValue = true;
                                break;
                            }
                            i11++;
                        }
                    } catch (NoClassDefFoundError e10) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
                    }
                }
                if (!zBooleanValue) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && InterfaceC0553v.class.isAssignableFrom(superclass)) {
                        AbstractC2796i.m5784e(superclass, "superclass");
                        if (m1526b(superclass) != 1) {
                            Object obj = map2.get(superclass);
                            AbstractC2796i.m5782c(obj);
                            arrayList = new ArrayList((Collection) obj);
                            interfaces = cls.getInterfaces();
                            AbstractC2796i.m5784e(interfaces, "klass.interfaces");
                            for (Class<?> cls2 : interfaces) {
                                if (cls2 == null && InterfaceC0553v.class.isAssignableFrom(cls2)) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                if (!z7) {
                                    AbstractC2796i.m5784e(cls2, "intrface");
                                    if (m1526b(cls2) == 1) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        Object obj2 = map2.get(cls2);
                                        AbstractC2796i.m5782c(obj2);
                                        arrayList.addAll((Collection) obj2);
                                    }
                                }
                            }
                            if (arrayList != null) {
                                map2.put(cls, arrayList);
                            }
                        }
                    } else {
                        interfaces = cls.getInterfaces();
                        AbstractC2796i.m5784e(interfaces, "klass.interfaces");
                        while (i6 < r8) {
                            if (cls2 == null) {
                                z7 = false;
                            } else {
                                z7 = false;
                            }
                            if (!z7) {
                                AbstractC2796i.m5784e(cls2, "intrface");
                                if (m1526b(cls2) == 1) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    Object obj3 = map2.get(cls2);
                                    AbstractC2796i.m5782c(obj3);
                                    arrayList.addAll((Collection) obj3);
                                }
                            }
                        }
                        if (arrayList != null) {
                            map2.put(cls, arrayList);
                        }
                    }
                }
            }
            i10 = 2;
        }
        map.put(cls, Integer.valueOf(i10));
        return i10;
    }
}
