package p103j9;

import androidx.fragment.app.C0423q;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import p000a.AbstractC0004e;

public abstract class AbstractC2796i {

    public static final Object[] f9536a = new Object[0];

    public static boolean m5780a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void m5781b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str.concat(" must not be null"));
        m5789j(illegalStateException, AbstractC2796i.class.getName());
        throw illegalStateException;
    }

    public static void m5782c(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        m5789j(nullPointerException, AbstractC2796i.class.getName());
        throw nullPointerException;
    }

    public static void m5783d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str);
        m5789j(nullPointerException, AbstractC2796i.class.getName());
        throw nullPointerException;
    }

    public static void m5784e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        m5789j(nullPointerException, AbstractC2796i.class.getName());
        throw nullPointerException;
    }

    public static void m5785f(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(m5788i(str));
        m5789j(nullPointerException, AbstractC2796i.class.getName());
        throw nullPointerException;
    }

    public static void m5786g(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(m5788i(str));
        m5789j(illegalArgumentException, AbstractC2796i.class.getName());
        throw illegalArgumentException;
    }

    public static int m5787h(int i6, int i10) {
        if (i6 < i10) {
            return -1;
        }
        return i6 == i10 ? 0 : 1;
    }

    public static String m5788i(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = AbstractC2796i.class.getName();
        int i6 = 0;
        while (!stackTrace[i6].getClassName().equals(name)) {
            i6++;
        }
        while (stackTrace[i6].getClassName().equals(name)) {
            i6++;
        }
        StackTraceElement stackTraceElement = stackTrace[i6];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void m5789j(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i6 = -1;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(stackTrace[i10].getClassName())) {
                i6 = i10;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i6 + 1, length));
    }

    public static String m5790k(Object obj, String str) {
        return str + obj;
    }

    public static void m5791l(String str) {
        C0423q c0423q = new C0423q(AbstractC0004e.m24r("lateinit property ", str, " has not been initialized"), 14);
        m5789j(c0423q, AbstractC2796i.class.getName());
        throw c0423q;
    }

    public static final Object[] m5792m(Collection collection) {
        int size = collection.size();
        Object[] objArr = f9536a;
        if (size == 0) {
            return objArr;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return objArr;
        }
        Object[] objArrCopyOf = new Object[size];
        int i6 = 0;
        while (true) {
            int i10 = i6 + 1;
            objArrCopyOf[i6] = it.next();
            if (i10 >= objArrCopyOf.length) {
                if (!it.hasNext()) {
                    return objArrCopyOf;
                }
                int i11 = ((i10 * 3) + 1) >>> 1;
                if (i11 <= i10) {
                    i11 = 2147483645;
                    if (i10 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i11);
            } else if (!it.hasNext()) {
                Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i10);
                m5784e(objArrCopyOf2, "copyOf(...)");
                return objArrCopyOf2;
            }
            i6 = i10;
        }
    }

    public static final Object[] m5793n(Collection collection, Object[] objArr) {
        Object[] objArrCopyOf;
        objArr.getClass();
        int size = collection.size();
        int i6 = 0;
        if (size == 0) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        if (size <= objArr.length) {
            objArrCopyOf = objArr;
        } else {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            m5783d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrCopyOf = (Object[]) objNewInstance;
        }
        while (true) {
            int i10 = i6 + 1;
            objArrCopyOf[i6] = it.next();
            if (i10 >= objArrCopyOf.length) {
                if (!it.hasNext()) {
                    return objArrCopyOf;
                }
                int i11 = ((i10 * 3) + 1) >>> 1;
                if (i11 <= i10) {
                    i11 = 2147483645;
                    if (i10 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i11);
            } else if (!it.hasNext()) {
                if (objArrCopyOf == objArr) {
                    objArr[i10] = null;
                    return objArr;
                }
                Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i10);
                m5784e(objArrCopyOf2, "copyOf(...)");
                return objArrCopyOf2;
            }
            i6 = i10;
        }
    }
}
