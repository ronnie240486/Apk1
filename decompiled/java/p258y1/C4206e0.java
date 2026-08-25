package p258y1;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;

public final class C4206e0 {

    public final View f14293b;

    public final HashMap f14292a = new HashMap();

    public final ArrayList f14294c = new ArrayList();

    public C4206e0(View view) {
        this.f14293b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C4206e0)) {
            return false;
        }
        C4206e0 c4206e0 = (C4206e0) obj;
        return this.f14293b == c4206e0.f14293b && this.f14292a.equals(c4206e0.f14292a);
    }

    public final int hashCode() {
        return this.f14292a.hashCode() + (this.f14293b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sbM29w = AbstractC0004e.m29w("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbM29w.append(this.f14293b);
        sbM29w.append("\n");
        String strM5494h = AbstractC2460q.m5494h(sbM29w.toString(), "    values:");
        HashMap map = this.f14292a;
        for (String str : map.keySet()) {
            strM5494h = strM5494h + "    " + str + ": " + map.get(str) + "\n";
        }
        return strM5494h;
    }
}
