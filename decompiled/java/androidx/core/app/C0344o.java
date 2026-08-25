package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import p000a.AbstractC0004e;

public final class C0344o {

    public final IconCompat f1524a;

    public final CharSequence f1525b;

    public final PendingIntent f1526c;

    public final boolean f1527d;

    public final Bundle f1528e;

    public final ArrayList f1529f;

    public final boolean f1530g;

    public C0344o(int i6, String str, PendingIntent pendingIntent) {
        this(i6 != 0 ? IconCompat.m1087e(null, "", i6) : null, str, pendingIntent, new Bundle());
    }

    public final C0346p m996a() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = this.f1529f;
        if (arrayList3 != null) {
            Iterator it = arrayList3.iterator();
            if (it.hasNext()) {
                throw AbstractC0004e.m18l(it);
            }
        }
        return new C0346p(this.f1524a, this.f1525b, this.f1526c, this.f1528e, arrayList2.isEmpty() ? null : (AbstractC0321c1[]) arrayList2.toArray(new AbstractC0321c1[arrayList2.size()]), arrayList.isEmpty() ? null : (AbstractC0321c1[]) arrayList.toArray(new AbstractC0321c1[arrayList.size()]), this.f1527d, this.f1530g);
    }

    public C0344o(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        this.f1527d = true;
        this.f1530g = true;
        this.f1524a = iconCompat;
        this.f1525b = C0356u.m1024b(charSequence);
        this.f1526c = pendingIntent;
        this.f1528e = bundle;
        this.f1529f = null;
        this.f1527d = true;
        this.f1530g = true;
    }
}
