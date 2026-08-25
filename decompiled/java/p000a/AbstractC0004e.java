package p000a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.common.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.JSONScanner;
import com.google.android.gms.internal.cast.C1510a8;
import com.google.android.gms.internal.cast.C1539d7;
import com.lzy.okgo.p031db.ColumnEntity;
import com.lzy.okgo.p031db.TableEntity;
import com.lzy.okgo.utils.OkLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p215u.AbstractC3885h;

public abstract class AbstractC0004e {
    public static void m1A(long j10, StringBuilder sb, String str, String str2) {
        sb.append(System.currentTimeMillis() - j10);
        sb.append(str);
        OkLogger.m4466v(str2, sb.toString());
    }

    public static void m2B(C1510a8 c1510a8) {
        if (c1510a8 != null) {
            throw new ClassCastException();
        }
    }

    public static void m3C(Object obj) {
        throw new ClassCastException();
    }

    public static void m4D(String str, String str2, String str3) {
        Log.m1719w(str3, str + str2);
    }

    public static String m5E(int i6) {
        if (i6 == 1) {
            return "NONE";
        }
        if (i6 != 2) {
            return i6 != 3 ? "null" : "REMOVING";
        }
        return "ADDING";
    }

    public static String m6F(int i6) {
        if (i6 == 1) {
            return "REMOVED";
        }
        if (i6 == 2) {
            return "VISIBLE";
        }
        if (i6 != 3) {
            return i6 != 4 ? "null" : "INVISIBLE";
        }
        return "GONE";
    }

    public static final void m7a(int i6, View view) {
        int iM7785a = AbstractC3885h.m7785a(i6);
        if (iM7785a == 0) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (android.util.Log.isLoggable("FragmentManager", 2)) {
                    android.util.Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        if (iM7785a == 1) {
            if (android.util.Log.isLoggable("FragmentManager", 2)) {
                android.util.Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            view.setVisibility(0);
            return;
        }
        if (iM7785a == 2) {
            if (android.util.Log.isLoggable("FragmentManager", 2)) {
                android.util.Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
            }
            view.setVisibility(8);
            return;
        }
        if (iM7785a != 3) {
            return;
        }
        if (android.util.Log.isLoggable("FragmentManager", 2)) {
            android.util.Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
        }
        view.setVisibility(4);
    }

    public static int m8b(int i6) {
        if (i6 == 0) {
            return 2;
        }
        if (i6 == 4) {
            return 4;
        }
        if (i6 == 8) {
            return 3;
        }
        throw new IllegalArgumentException(m20n(i6, "Unknown visibility "));
    }

    public static int m9c(View view) {
        if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
            return 4;
        }
        return m8b(view.getVisibility());
    }

    public static char m10d(int i6, int i10, int i11, JSONLexerBase jSONLexerBase) {
        return jSONLexerBase.charAt(i6 + i10 + i11);
    }

    public static char m11e(int i6, int i10, int i11, JSONScanner jSONScanner) {
        return jSONScanner.charAt(i6 + i10 + i11);
    }

    public static int m12f(int i6, int i10, int i11) {
        return C1539d7.m3789L(i6) + i10 + i11;
    }

    public static int m13g(int i6, int i10, int i11, int i12) {
        return ((i6 + i10) - i11) - i12;
    }

    public static int m14h(int i6, int i10, String str) {
        return (str.hashCode() + i6) * i10;
    }

    public static View m15i(ViewGroup viewGroup, int i6, ViewGroup viewGroup2, boolean z7) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i6, viewGroup2, z7);
    }

    public static TableEntity m16j(String str, String str2, TableEntity tableEntity) {
        return tableEntity.addColumn(new ColumnEntity(str, str2));
    }

    public static ClassCastException m17k(int i6, ArrayList arrayList) {
        arrayList.get(i6).getClass();
        return new ClassCastException();
    }

    public static ClassCastException m18l(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }

    public static String m19m(int i6, int i10, String str, String str2) {
        return str + i6 + str2 + i10;
    }

    public static String m20n(int i6, String str) {
        return str + i6;
    }

    public static String m21o(long j10, String str) {
        return str + j10;
    }

    public static String m22p(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String m23q(Class cls, String str) {
        return str + cls;
    }

    public static String m24r(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String m25s(StringBuilder sb, long j10, String str) {
        sb.append(j10);
        sb.append(str);
        return sb.toString();
    }

    public static String m26t(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder m27u(int i6, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i6);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder m28v(String str, int i6, String str2, int i10, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i6);
        sb.append(str2);
        sb.append(i10);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder m29w(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder m30x(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static void m31y(int i6, String str, String str2) {
        Log.m1719w(str2, str + i6);
    }

    public static void m32z(int i6, HashMap map, String str, int i10, String str2) {
        map.put(str, Integer.valueOf(i6));
        map.put(str2, Integer.valueOf(i10));
    }
}
