package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

public final class C0346p {

    public final Bundle f1531a;

    public IconCompat f1532b;

    public final AbstractC0321c1[] f1533c;

    public final boolean f1534d;

    public final boolean f1535e;

    public final int f1536f;

    public final CharSequence f1537g;

    public final PendingIntent f1538h;

    public C0346p(int i6, String str, PendingIntent pendingIntent) {
        this(i6 != 0 ? IconCompat.m1087e(null, "", i6) : null, str, pendingIntent, new Bundle(), null, null, true, true);
    }

    public final IconCompat m1002a() {
        int i6;
        if (this.f1532b == null && (i6 = this.f1536f) != 0) {
            this.f1532b = IconCompat.m1087e(null, "", i6);
        }
        return this.f1532b;
    }

    public C0346p(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, AbstractC0321c1[] abstractC0321c1Arr, AbstractC0321c1[] abstractC0321c1Arr2, boolean z7, boolean z10) {
        this.f1535e = true;
        this.f1532b = iconCompat;
        if (iconCompat != null && iconCompat.m1092j() == 2) {
            this.f1536f = iconCompat.m1090g();
        }
        this.f1537g = C0356u.m1024b(charSequence);
        this.f1538h = pendingIntent;
        this.f1531a = bundle == null ? new Bundle() : bundle;
        this.f1533c = abstractC0321c1Arr;
        this.f1534d = z7;
        this.f1535e = z10;
    }
}
