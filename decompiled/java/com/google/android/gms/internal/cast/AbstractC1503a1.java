package com.google.android.gms.internal.cast;

import android.os.Bundle;
import com.google.android.gms.common.Feature;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p124l6.C2982h;
import p261y4.C4256d;

public abstract class AbstractC1503a1 {

    public static final Feature[] f5199b = {new Feature("usage_and_diagnostics_listener"), new Feature("usage_and_diagnostics_consents"), new Feature("usage_and_diagnostics_check_consents"), new Feature("usage_and_diagnostics_settings_access"), new Feature("el_capitan")};

    public static final C2982h f5200c = new C2982h("UsageReporting.API", new C1543e1(0), new C4256d());

    public final int f5201a;

    public AbstractC1503a1(int i6) {
        this.f5201a = i6;
    }

    public static float m3691a(float f, float f3, float f4, float f5) {
        return (float) Math.hypot(f4 - f, f5 - f3);
    }

    public static int m3692b(int i6) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i6) * (-862048943)), 15)) * 461845907);
    }

    public static int m3693c(int i6, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if (i10 <= i6) {
            return i6;
        }
        int i11 = i6 + (i6 >> 1) + 1;
        if (i11 < i10) {
            int iHighestOneBit = Integer.highestOneBit(i10 - 1);
            i11 = iHighestOneBit + iHighestOneBit;
        }
        if (i11 < 0) {
            return Integer.MAX_VALUE;
        }
        return i11;
    }

    public static String m3694e(C1529c7 c1529c7) {
        StringBuilder sb = new StringBuilder(c1529c7.mo3734e());
        for (int i6 = 0; i6 < c1529c7.mo3734e(); i6++) {
            byte bMo3732c = c1529c7.mo3732c(i6);
            if (bMo3732c == 34) {
                sb.append("\\\"");
            } else if (bMo3732c == 39) {
                sb.append("\\'");
            } else if (bMo3732c != 92) {
                switch (bMo3732c) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bMo3732c < 32 || bMo3732c > 126) {
                            sb.append('\\');
                            sb.append((char) (((bMo3732c >>> 6) & 3) + 48));
                            sb.append((char) (((bMo3732c >>> 3) & 7) + 48));
                            sb.append((char) ((bMo3732c & 7) + 48));
                        } else {
                            sb.append((char) bMo3732c);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static String m3695f(String str) {
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

    public static String m3696g(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i6 = 0;
        int i10 = 0;
        while (true) {
            length = objArr.length;
            if (i10 >= length) {
                break;
            }
            Object obj = objArr[i10];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e5) {
                    String strM5495i = AbstractC2460q.m5495i(obj.getClass().getName(), "@", Integer.toHexString(System.identityHashCode(obj)));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(strM5495i), (Throwable) e5);
                    string = "<" + strM5495i + " threw " + e5.getClass().getName() + ">";
                }
            }
            objArr[i10] = string;
            i10++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i11 = 0;
        while (true) {
            length2 = objArr.length;
            if (i6 >= length2 || (iIndexOf = str.indexOf("%s", i11)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i11, iIndexOf);
            sb.append(objArr[i6]);
            i11 = iIndexOf + 2;
            i6++;
        }
        sb.append((CharSequence) str, i11, str.length());
        if (i6 < length2) {
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

    public static Map m3697h(String str, Bundle bundle) {
        Map map = (Map) bundle.getSerializable(str);
        if (map == null) {
            return C1554f2.f5294g;
        }
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                map2.put((Integer) entry.getKey(), (Integer) entry.getValue());
            }
        }
        return Collections.unmodifiableMap(map2);
    }

    public static void m3698i(int i6, int i10) {
        String strM3696g;
        if (i6 < 0 || i6 >= i10) {
            if (i6 < 0) {
                strM3696g = m3696g("%s (%s) must not be negative", "index", Integer.valueOf(i6));
            } else {
                if (i10 < 0) {
                    throw new IllegalArgumentException(AbstractC0004e.m20n(i10, "negative size: "));
                }
                strM3696g = m3696g("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i6), Integer.valueOf(i10));
            }
            throw new IndexOutOfBoundsException(strM3696g);
        }
    }

    public static boolean m3699j(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AbstractC1608k6 abstractC1608k6, Object obj, Object obj2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(abstractC1608k6, obj, obj2)) {
            if (atomicReferenceFieldUpdater.get(abstractC1608k6) != obj && atomicReferenceFieldUpdater.get(abstractC1608k6) != obj) {
                return false;
            }
        }
        return true;
    }

    public static void m3700l(int i6, int i10) {
        if (i6 < 0 || i6 > i10) {
            throw new IndexOutOfBoundsException(m3702p(i6, i10, "index"));
        }
    }

    public static void m3701n(int i6, int i10, int i11) {
        String strM3702p;
        if (i6 < 0 || i10 < i6 || i10 > i11) {
            if (i6 < 0 || i6 > i11) {
                strM3702p = m3702p(i6, i11, "start index");
            } else {
                strM3702p = (i10 < 0 || i10 > i11) ? m3702p(i10, i11, "end index") : m3696g("end index (%s) must not be less than start index (%s)", Integer.valueOf(i10), Integer.valueOf(i6));
            }
            throw new IndexOutOfBoundsException(strM3702p);
        }
    }

    public static String m3702p(int i6, int i10, String str) {
        if (i6 < 0) {
            return m3696g("%s (%s) must not be negative", str, Integer.valueOf(i6));
        }
        if (i10 >= 0) {
            return m3696g("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i6), Integer.valueOf(i10));
        }
        throw new IllegalArgumentException(AbstractC0004e.m20n(i10, "negative size: "));
    }

    public abstract C1548e6 mo3703d(AbstractC1558f6 abstractC1558f6);

    public abstract C1598j6 mo3704k(AbstractC1558f6 abstractC1558f6);

    public abstract void mo3705m(C1598j6 c1598j6, C1598j6 c1598j7);

    public abstract void mo3706o(C1598j6 c1598j6, Thread thread);

    public abstract boolean mo3707q(AbstractC1558f6 abstractC1558f6, C1548e6 c1548e6, C1548e6 c1548e7);

    public abstract boolean mo3708r(AbstractC1608k6 abstractC1608k6, Object obj, Object obj2);

    public abstract boolean mo3709s(AbstractC1608k6 abstractC1608k6, C1598j6 c1598j6, C1598j6 c1598j7);

    public String toString() {
        switch (this.f5201a) {
            case 7:
                return ((ScheduledFutureC1683s6) this).f5673d.toString();
            default:
                return super.toString();
        }
    }
}
