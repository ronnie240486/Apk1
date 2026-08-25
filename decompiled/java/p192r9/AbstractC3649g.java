package p192r9;

import java.util.ArrayList;
import java.util.List;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2796i;
import p156o9.AbstractC3281e;
import p253x8.AbstractC4147j;
import p253x8.AbstractC4148k;
import p253x8.C4155r;

public abstract class AbstractC3649g extends AbstractC3281e {
    public static String m7393K(String str) {
        List listM154F;
        AbstractC2796i.m5785f(str, "<this>");
        if (AbstractC3648f.m7383e0("|")) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        C3646d c3646d = new C3646d(str);
        if (c3646d.hasNext()) {
            Object next = c3646d.next();
            if (c3646d.hasNext()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                while (c3646d.hasNext()) {
                    arrayList.add(c3646d.next());
                }
                listM154F = arrayList;
            } else {
                listM154F = AbstractC0032a.m154F(next);
            }
        } else {
            listM154F = C4155r.f14074a;
        }
        int length = str.length();
        listM154F.size();
        int iM8191O = AbstractC4148k.m8191O(listM154F);
        ArrayList arrayList2 = new ArrayList();
        int i6 = 0;
        for (Object obj : listM154F) {
            int i10 = i6 + 1;
            String strSubstring = null;
            if (i6 < 0) {
                AbstractC4148k.m8192P();
                throw null;
            }
            String str2 = (String) obj;
            if ((i6 != 0 && i6 != iM8191O) || !AbstractC3648f.m7383e0(str2)) {
                int length2 = str2.length();
                int i11 = 0;
                while (true) {
                    if (i11 >= length2) {
                        i11 = -1;
                        break;
                    }
                    char cCharAt = str2.charAt(i11);
                    if (!Character.isWhitespace(cCharAt) && !Character.isSpaceChar(cCharAt)) {
                        break;
                    }
                    i11++;
                }
                if (i11 != -1 && AbstractC3656n.m7403U(str2, i11, "|", false)) {
                    strSubstring = str2.substring(1 + i11);
                    AbstractC2796i.m5784e(strSubstring, "substring(...)");
                }
                if (strSubstring == null) {
                    strSubstring = str2;
                }
            }
            if (strSubstring != null) {
                arrayList2.add(strSubstring);
            }
            i6 = i10;
        }
        StringBuilder sb = new StringBuilder(length);
        AbstractC4147j.m8183W(arrayList2, sb, "\n", "", "", -1, "...", null);
        return sb.toString();
    }
}
