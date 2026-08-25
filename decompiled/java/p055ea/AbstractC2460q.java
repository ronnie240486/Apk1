package p055ea;

import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import okio.Path;
import p003a2.AbstractC0032a;
import p140n2.C3176a;
import p140n2.C3177b;
import p140n2.C3181f;
import p140n2.C3183h;
import p187r4.AbstractC3612b;

public abstract class AbstractC2460q {
    public static AbstractC3612b m5487a(int i6, int i10, int i11) {
        if (i6 == -2) {
            return C3177b.f10668c;
        }
        int i12 = i6 - i11;
        if (i12 > 0) {
            return new C3176a(i12);
        }
        int i13 = i10 - i11;
        if (i13 > 0) {
            return new C3176a(i13);
        }
        return null;
    }

    public static C3183h m5488b(C3181f c3181f) {
        int paddingRight;
        ViewGroup.LayoutParams layoutParams = c3181f.f10672a.getLayoutParams();
        int i6 = layoutParams != null ? layoutParams.width : -1;
        ImageView imageView = c3181f.f10672a;
        int width = imageView.getWidth();
        boolean z7 = c3181f.f10673b;
        if (z7) {
            paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
        } else {
            paddingRight = 0;
        }
        AbstractC3612b abstractC3612bM5487a = m5487a(i6, width, paddingRight);
        if (abstractC3612bM5487a == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        AbstractC3612b abstractC3612bM5487a2 = m5487a(layoutParams2 != null ? layoutParams2.height : -1, imageView.getHeight(), z7 ? imageView.getPaddingBottom() + imageView.getPaddingTop() : 0);
        if (abstractC3612bM5487a2 == null) {
            return null;
        }
        return new C3183h(abstractC3612bM5487a, abstractC3612bM5487a2);
    }

    public static boolean m5489c(int i6) {
        if (i6 == 1 || i6 == 2 || i6 == 3) {
            return false;
        }
        if (i6 == 4 || i6 == 5) {
            return true;
        }
        throw null;
    }

    public static float m5490d(float f, float f3, float f4, float f5) {
        return ((f - f3) * f4) + f5;
    }

    public static Object m5491e(int i6, ArrayList arrayList) {
        return arrayList.get(arrayList.size() - i6);
    }

    public static String m5492f(int i6, String str, String str2) {
        return str + i6 + str2;
    }

    public static String m5493g(Object obj, String str) {
        return str + obj;
    }

    public static String m5494h(String str, String str2) {
        return str + str2;
    }

    public static String m5495i(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String m5496j(String str, String str2, StringBuilder sb, String str3) {
        sb.append(AbstractC0032a.m165s(str, str2));
        sb.append(str3);
        return sb.toString();
    }

    public static String m5497k(Path path, String str) {
        return str + path;
    }

    public static StringBuilder m5498l(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static void m5499m(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void m5500n(StringBuilder sb, String str, char c5, String str2, String str3) {
        sb.append(str);
        sb.append(c5);
        sb.append(AbstractC0032a.m165s(str2, str3));
    }

    public static String m5501o(String str, String str2) {
        return str + str2;
    }

    public static String m5502p(int i6) {
        switch (i6) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case 3:
                return "TOP";
            case 4:
                return "RIGHT";
            case 5:
                return "BOTTOM";
            case 6:
                return "BASELINE";
            case 7:
                return "CENTER";
            case 8:
                return "CENTER_X";
            case 9:
                return "CENTER_Y";
            default:
                throw null;
        }
    }

    public static String m5503q(int i6) {
        switch (i6) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case 4:
                return "END_OBJECT";
            case 5:
                return "NAME";
            case 6:
                return "STRING";
            case 7:
                return "NUMBER";
            case 8:
                return "BOOLEAN";
            case 9:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }

    public static String m5504r(int i6) {
        if (i6 == 1) {
            return "LOCAL";
        }
        if (i6 == 2) {
            return "REMOTE";
        }
        if (i6 == 3) {
            return "DATA_DISK_CACHE";
        }
        if (i6 != 4) {
            return i6 != 5 ? "null" : "MEMORY_CACHE";
        }
        return "RESOURCE_DISK_CACHE";
    }

    public static String m5505s(int i6) {
        switch (i6) {
            case 1:
                return "INITIALIZE";
            case 2:
                return "RESOURCE_CACHE";
            case 3:
                return "DATA_CACHE";
            case 4:
                return "SOURCE";
            case 5:
                return "ENCODE";
            case 6:
                return "FINISHED";
            default:
                return "null";
        }
    }
}
