package p192r9;

import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2796i;
import p156o9.AbstractC3280d;
import p156o9.C3284h;
import p181q9.C3551i;
import p253x8.AbstractC4146i;
import p253x8.AbstractC4149l;

public abstract class AbstractC3648f extends AbstractC3656n {
    public static boolean m7375W(CharSequence charSequence, char c5) {
        AbstractC2796i.m5785f(charSequence, "<this>");
        return m7380b0(charSequence, c5, 0, false, 2) >= 0;
    }

    public static boolean m7376X(String str, String str2) {
        AbstractC2796i.m5785f(str, "<this>");
        return m7381c0(str, str2, 0, false, 2) >= 0;
    }

    public static boolean m7377Y(String str, char c5) {
        return str.length() > 0 && AbstractC3280d.m6592j(str.charAt(m7378Z(str)), c5, false);
    }

    public static final int m7378Z(CharSequence charSequence) {
        AbstractC2796i.m5785f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int m7379a0(String str, int i6, String str2, boolean z7) {
        AbstractC2796i.m5785f(str, "<this>");
        AbstractC2796i.m5785f(str2, "string");
        if (!z7) {
            return str.indexOf(str2, i6);
        }
        int length = str.length();
        if (i6 < 0) {
            i6 = 0;
        }
        int length2 = str.length();
        if (length > length2) {
            length = length2;
        }
        C3284h c3284h = new C3284h(i6, length, 1);
        boolean z10 = str instanceof String;
        int i10 = c3284h.f10991c;
        int i11 = c3284h.f10990b;
        int i12 = c3284h.f10989a;
        if (z10 && (str2 instanceof String)) {
            if ((i10 > 0 && i12 <= i11) || (i10 < 0 && i11 <= i12)) {
                while (!AbstractC3656n.m7400R(str2, str, 0, i12, str2.length(), z7)) {
                    if (i12 != i11) {
                        i12 += i10;
                    }
                }
                return i12;
            }
            return -1;
        }
        if ((i10 > 0 && i12 <= i11) || (i10 < 0 && i11 <= i12)) {
            while (true) {
                int length3 = str2.length();
                AbstractC2796i.m5785f(str2, "<this>");
                AbstractC2796i.m5785f(str, "other");
                boolean z11 = false;
                if (i12 >= 0 && str2.length() - length3 >= 0 && i12 <= str.length() - length3) {
                    int i13 = 0;
                    while (true) {
                        if (i13 >= length3) {
                            z11 = true;
                            break;
                        }
                        if (!AbstractC3280d.m6592j(str2.charAt(0 + i13), str.charAt(i12 + i13), z7)) {
                            break;
                        }
                        i13++;
                    }
                }
                if (z11) {
                    break;
                }
                if (i12 != i11) {
                    i12 += i10;
                }
            }
            return i12;
        }
        return -1;
    }

    public static int m7380b0(CharSequence charSequence, char c5, int i6, boolean z7, int i10) {
        if ((i10 & 2) != 0) {
            i6 = 0;
        }
        if ((i10 & 4) != 0) {
            z7 = false;
        }
        AbstractC2796i.m5785f(charSequence, "<this>");
        return (z7 || !(charSequence instanceof String)) ? m7382d0(charSequence, new char[]{c5}, i6, z7) : ((String) charSequence).indexOf(c5, i6);
    }

    public static int m7381c0(String str, String str2, int i6, boolean z7, int i10) {
        if ((i10 & 2) != 0) {
            i6 = 0;
        }
        if ((i10 & 4) != 0) {
            z7 = false;
        }
        return m7379a0(str, i6, str2, z7);
    }

    public static final int m7382d0(CharSequence charSequence, char[] cArr, int i6, boolean z7) {
        AbstractC2796i.m5785f(charSequence, "<this>");
        if (!z7 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(AbstractC4146i.m8178K(cArr), i6);
        }
        if (i6 < 0) {
            i6 = 0;
        }
        int iM7378Z = m7378Z(charSequence);
        if (i6 > iM7378Z) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i6);
            for (char c5 : cArr) {
                if (AbstractC3280d.m6592j(c5, cCharAt, z7)) {
                    return i6;
                }
            }
            if (i6 == iM7378Z) {
                return -1;
            }
            i6++;
        }
    }

    public static boolean m7383e0(String str) {
        AbstractC2796i.m5785f(str, "<this>");
        for (int i6 = 0; i6 < str.length(); i6++) {
            char cCharAt = str.charAt(i6);
            if (!Character.isWhitespace(cCharAt) && !Character.isSpaceChar(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public static int m7384f0(CharSequence charSequence, char c5, int i6, int i10) {
        if ((i10 & 2) != 0) {
            i6 = m7378Z(charSequence);
        }
        AbstractC2796i.m5785f(charSequence, "<this>");
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(c5, i6);
        }
        char[] cArr = {c5};
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(AbstractC4146i.m8178K(cArr), i6);
        }
        int iM7378Z = m7378Z(charSequence);
        if (i6 > iM7378Z) {
            i6 = iM7378Z;
        }
        while (-1 < i6) {
            if (AbstractC3280d.m6592j(cArr[0], charSequence.charAt(i6), false)) {
                return i6;
            }
            i6--;
        }
        return -1;
    }

    public static String m7385g0(String str, String str2) {
        AbstractC2796i.m5785f(str, "<this>");
        AbstractC2796i.m5785f(str2, "prefix");
        if (!m7387i0(str, str2)) {
            return str;
        }
        String strSubstring = str.substring(str2.length());
        AbstractC2796i.m5784e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static List m7386h0(String str, char[] cArr) {
        AbstractC2796i.m5785f(str, "<this>");
        if (cArr.length == 1) {
            String strValueOf = String.valueOf(cArr[0]);
            int iM7379a0 = m7379a0(str, 0, strValueOf, false);
            if (iM7379a0 == -1) {
                return AbstractC0032a.m154F(str.toString());
            }
            ArrayList arrayList = new ArrayList(10);
            int length = 0;
            do {
                arrayList.add(str.subSequence(length, iM7379a0).toString());
                length = strValueOf.length() + iM7379a0;
                iM7379a0 = m7379a0(str, length, strValueOf, false);
            } while (iM7379a0 != -1);
            arrayList.add(str.subSequence(length, str.length()).toString());
            return arrayList;
        }
        C3551i c3551i = new C3551i(new C3645c(str, 0, 0, new C3657o(cArr, false)));
        ArrayList arrayList2 = new ArrayList(AbstractC4149l.m8193Q(c3551i));
        Iterator it = c3551i.iterator();
        while (true) {
            C3644b c3644b = (C3644b) it;
            if (!c3644b.hasNext()) {
                return arrayList2;
            }
            C3284h c3284h = (C3284h) c3644b.next();
            AbstractC2796i.m5785f(c3284h, SessionDescription.ATTR_RANGE);
            arrayList2.add(str.subSequence(c3284h.f10989a, c3284h.f10990b + 1).toString());
        }
    }

    public static boolean m7387i0(String str, String str2) {
        AbstractC2796i.m5785f(str, "<this>");
        AbstractC2796i.m5785f(str2, "prefix");
        return AbstractC3656n.m7404V(str, str2, false);
    }

    public static String m7388j0(String str, String str2) {
        AbstractC2796i.m5785f(str2, TtmlNode.RUBY_DELIMITER);
        int iM7381c0 = m7381c0(str, str2, 0, false, 6);
        if (iM7381c0 == -1) {
            return str;
        }
        String strSubstring = str.substring(str2.length() + iM7381c0, str.length());
        AbstractC2796i.m5784e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String m7389k0(char c5, String str, String str2) {
        AbstractC2796i.m5785f(str2, "missingDelimiterValue");
        int iM7384f0 = m7384f0(str, c5, 0, 6);
        if (iM7384f0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iM7384f0 + 1, str.length());
        AbstractC2796i.m5784e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String m7390l0(String str, char c5) {
        AbstractC2796i.m5785f(str, "<this>");
        AbstractC2796i.m5785f(str, "missingDelimiterValue");
        int iM7384f0 = m7384f0(str, c5, 0, 6);
        if (iM7384f0 == -1) {
            return str;
        }
        String strSubstring = str.substring(0, iM7384f0);
        AbstractC2796i.m5784e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String m7391m0(int i6, String str) {
        AbstractC2796i.m5785f(str, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC2460q.m5492f(i6, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i6 > length) {
            i6 = length;
        }
        String strSubstring = str.substring(0, i6);
        AbstractC2796i.m5784e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence m7392n0(String str) {
        AbstractC2796i.m5785f(str, "<this>");
        int length = str.length() - 1;
        int i6 = 0;
        boolean z7 = false;
        while (i6 <= length) {
            char cCharAt = str.charAt(!z7 ? i6 : length);
            boolean z10 = Character.isWhitespace(cCharAt) || Character.isSpaceChar(cCharAt);
            if (z7) {
                if (!z10) {
                    break;
                }
                length--;
            } else if (z10) {
                i6++;
            } else {
                z7 = true;
            }
        }
        return str.subSequence(i6, length + 1);
    }
}
