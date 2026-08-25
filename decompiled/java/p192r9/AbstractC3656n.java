package p192r9;

import java.util.Comparator;
import p000a.AbstractC0004e;
import p103j9.AbstractC2796i;
import p253x8.AbstractC4142e;
import p253x8.C4139b;

public abstract class AbstractC3656n extends AbstractC3655m {
    public static String m7396N(char[] cArr, int i6, int i10) {
        C4139b c4139b = AbstractC4142e.Companion;
        int length = cArr.length;
        c4139b.getClass();
        if (i6 < 0 || i10 > length) {
            StringBuilder sbM28v = AbstractC0004e.m28v("startIndex: ", i6, ", endIndex: ", i10, ", size: ");
            sbM28v.append(length);
            throw new IndexOutOfBoundsException(sbM28v.toString());
        }
        if (i6 <= i10) {
            return new String(cArr, i6, i10 - i6);
        }
        throw new IllegalArgumentException(AbstractC0004e.m19m(i6, i10, "startIndex: ", " > endIndex: "));
    }

    public static boolean m7397O(String str, String str2, boolean z7) {
        AbstractC2796i.m5785f(str, "<this>");
        AbstractC2796i.m5785f(str2, "suffix");
        return !z7 ? str.endsWith(str2) : m7400R(str, str2, str.length() - str2.length(), 0, str2.length(), true);
    }

    public static boolean m7398P(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static Comparator m7399Q() {
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        AbstractC2796i.m5784e(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    public static final boolean m7400R(String str, String str2, int i6, int i10, int i11, boolean z7) {
        AbstractC2796i.m5785f(str, "<this>");
        AbstractC2796i.m5785f(str2, "other");
        return !z7 ? str.regionMatches(i6, str2, i10, i11) : str.regionMatches(z7, i6, str2, i10, i11);
    }

    public static String m7401S(char c5, String str, char c8) {
        AbstractC2796i.m5785f(str, "<this>");
        String strReplace = str.replace(c5, c8);
        AbstractC2796i.m5784e(strReplace, "replace(...)");
        return strReplace;
    }

    public static String m7402T(String str, String str2, String str3) {
        AbstractC2796i.m5785f(str, "<this>");
        int iM7379a0 = AbstractC3648f.m7379a0(str, 0, str2, false);
        if (iM7379a0 < 0) {
            return str;
        }
        int length = str2.length();
        int i6 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i10 = 0;
        do {
            sb.append((CharSequence) str, i10, iM7379a0);
            sb.append(str3);
            i10 = iM7379a0 + length;
            if (iM7379a0 >= str.length()) {
                break;
            }
            iM7379a0 = AbstractC3648f.m7379a0(str, iM7379a0 + i6, str2, false);
        } while (iM7379a0 > 0);
        sb.append((CharSequence) str, i10, str.length());
        String string = sb.toString();
        AbstractC2796i.m5784e(string, "toString(...)");
        return string;
    }

    public static boolean m7403U(String str, int i6, String str2, boolean z7) {
        AbstractC2796i.m5785f(str, "<this>");
        return !z7 ? str.startsWith(str2, i6) : m7400R(str, str2, i6, 0, str2.length(), z7);
    }

    public static boolean m7404V(String str, String str2, boolean z7) {
        AbstractC2796i.m5785f(str, "<this>");
        AbstractC2796i.m5785f(str2, "prefix");
        return !z7 ? str.startsWith(str2) : m7400R(str, str2, 0, 0, str2.length(), z7);
    }
}
