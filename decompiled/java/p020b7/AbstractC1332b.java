package p020b7;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000a.AbstractC0004e;
import p002a1.C0026b;

public abstract class AbstractC1332b {
    public static C1355o m3210a(InterfaceC1354n interfaceC1354n, InterfaceC1354n interfaceC1354n2) {
        interfaceC1354n.getClass();
        interfaceC1354n2.getClass();
        return new C1355o(Arrays.asList(interfaceC1354n, interfaceC1354n2));
    }

    public static String m3211b(int i6, int i10, String str) {
        if (i6 < 0) {
            return m3228s("%s (%s) must not be negative", str, Integer.valueOf(i6));
        }
        if (i10 >= 0) {
            return m3228s("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i6), Integer.valueOf(i10));
        }
        throw new IllegalArgumentException(AbstractC0004e.m20n(i10, "negative size: "));
    }

    public static void m3212c(Object obj, String str, boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException(m3228s(str, obj));
        }
    }

    public static void m3213d(String str, int i6, int i10, boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException(m3228s(str, Integer.valueOf(i6), Integer.valueOf(i10)));
        }
    }

    public static void m3214e(String str, boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void m3215f(boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException();
        }
    }

    public static void m3216g(boolean z7, String str, long j10) {
        if (!z7) {
            throw new IllegalArgumentException(m3228s(str, Long.valueOf(j10)));
        }
    }

    public static void m3217h(int i6, int i10) {
        String strM3228s;
        if (i6 < 0 || i6 >= i10) {
            if (i6 < 0) {
                strM3228s = m3228s("%s (%s) must not be negative", "index", Integer.valueOf(i6));
            } else {
                if (i10 < 0) {
                    throw new IllegalArgumentException(AbstractC0004e.m20n(i10, "negative size: "));
                }
                strM3228s = m3228s("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i6), Integer.valueOf(i10));
            }
            throw new IndexOutOfBoundsException(strM3228s);
        }
    }

    public static void m3218i(ListenableFuture listenableFuture, String str, Object obj) {
        if (listenableFuture == null) {
            throw new NullPointerException(m3228s(str, obj));
        }
    }

    public static void m3219j(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void m3220k(int i6, int i10) {
        if (i6 < 0 || i6 > i10) {
            throw new IndexOutOfBoundsException(m3211b(i6, i10, "index"));
        }
    }

    public static void m3221l(int i6, int i10, int i11) {
        String strM3211b;
        if (i6 < 0 || i10 < i6 || i10 > i11) {
            if (i6 < 0 || i6 > i11) {
                strM3211b = m3211b(i6, i11, "start index");
            } else {
                strM3211b = (i10 < 0 || i10 > i11) ? m3211b(i10, i11, "end index") : m3228s("end index (%s) must not be less than start index (%s)", Integer.valueOf(i10), Integer.valueOf(i6));
            }
            throw new IndexOutOfBoundsException(strM3211b);
        }
    }

    public static void m3222m(Object obj, String str, boolean z7) {
        if (!z7) {
            throw new IllegalStateException(m3228s(str, obj));
        }
    }

    public static void m3223n(String str, boolean z7) {
        if (!z7) {
            throw new IllegalStateException(str);
        }
    }

    public static void m3224o(boolean z7) {
        if (!z7) {
            throw new IllegalStateException();
        }
    }

    public static boolean m3225p(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean m3226q(String str, String str2) {
        char c5;
        int length = str.length();
        if (str == str2) {
            return true;
        }
        if (length != str2.length()) {
            return false;
        }
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt = str.charAt(i6);
            char cCharAt2 = str2.charAt(i6);
            if (cCharAt != cCharAt2 && ((c5 = (char) ((cCharAt | ' ') - 97)) >= 26 || c5 != ((char) ((cCharAt2 | ' ') - 97)))) {
                return false;
            }
        }
        return true;
    }

    public static Object m3227r(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        if (obj2 != null) {
            return obj2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static String m3228s(String str, Object... objArr) {
        int iIndexOf;
        String string;
        String strValueOf = String.valueOf(str);
        int i6 = 0;
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e5) {
                    String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str2, (Throwable) e5);
                    StringBuilder sbM30x = AbstractC0004e.m30x("<", str2, " threw ");
                    sbM30x.append(e5.getClass().getName());
                    sbM30x.append(">");
                    string = sbM30x.toString();
                }
            }
            objArr[i10] = string;
        }
        StringBuilder sb = new StringBuilder((objArr.length * 16) + strValueOf.length());
        int i11 = 0;
        while (i6 < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i11)) != -1) {
            sb.append((CharSequence) strValueOf, i11, iIndexOf);
            sb.append(objArr[i6]);
            i11 = iIndexOf + 2;
            i6++;
        }
        sb.append((CharSequence) strValueOf, i11, strValueOf.length());
        if (i6 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i6]);
            for (int i12 = i6 + 1; i12 < objArr.length; i12++) {
                sb.append(", ");
                sb.append(objArr[i12]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static InterfaceC1339e0 m3229t(InterfaceC1339e0 interfaceC1339e0) {
        if ((interfaceC1339e0 instanceof C1343g0) || (interfaceC1339e0 instanceof C1341f0)) {
            return interfaceC1339e0;
        }
        return interfaceC1339e0 instanceof Serializable ? new C1341f0(interfaceC1339e0) : new C1343g0(interfaceC1339e0);
    }

    public static String m3230u(String str) {
        return str == null ? "" : str;
    }

    public static String m3231v(String str) {
        int length = str.length();
        int i6 = 0;
        while (i6 < length) {
            char cCharAt = str.charAt(i6);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                char[] charArray = str.toCharArray();
                while (i6 < length) {
                    char c5 = charArray[i6];
                    if (c5 >= 'A' && c5 <= 'Z') {
                        charArray[i6] = (char) (c5 ^ ' ');
                    }
                    i6++;
                }
                return String.valueOf(charArray);
            }
            i6++;
        }
        return str;
    }

    public static C0026b m3232w(Object obj) {
        return new C0026b(obj.getClass().getSimpleName());
    }

    public static String m3233x(String str) {
        int length = str.length();
        int i6 = 0;
        while (i6 < length) {
            char cCharAt = str.charAt(i6);
            if (cCharAt >= 'a' && cCharAt <= 'z') {
                char[] charArray = str.toCharArray();
                while (i6 < length) {
                    char c5 = charArray[i6];
                    if (c5 >= 'a' && c5 <= 'z') {
                        charArray[i6] = (char) (c5 ^ ' ');
                    }
                    i6++;
                }
                return String.valueOf(charArray);
            }
            i6++;
        }
        return str;
    }
}
