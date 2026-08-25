package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;

public final class C0356u {

    public final boolean f1549A;

    public final Notification f1550B;

    public final ArrayList f1551C;

    public final Context f1552a;

    public CharSequence f1556e;

    public CharSequence f1557f;

    public PendingIntent f1558g;

    public IconCompat f1559h;

    public int f1560i;

    public boolean f1562k;

    public AbstractC0337k0 f1563l;

    public CharSequence f1564m;

    public int f1565n;

    public int f1566o;

    public boolean f1567p;

    public String f1568q;

    public boolean f1570s;

    public boolean f1571t;

    public Bundle f1572u;

    public String f1575x;

    public final ArrayList f1553b = new ArrayList();

    public final ArrayList f1554c = new ArrayList();

    public final ArrayList f1555d = new ArrayList();

    public boolean f1561j = true;

    public boolean f1569r = false;

    public int f1573v = 0;

    public int f1574w = 0;

    public int f1576y = 0;

    public int f1577z = 0;

    public C0356u(Context context, String str) {
        Notification notification = new Notification();
        this.f1550B = notification;
        this.f1552a = context;
        this.f1575x = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f1560i = 0;
        this.f1551C = new ArrayList();
        this.f1549A = true;
    }

    public static CharSequence m1024b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final Notification m1025a() {
        Notification notificationBuild;
        Bundle bundle;
        RemoteViews remoteViewsMakeHeadsUpContentView;
        RemoteViews remoteViewsMakeBigContentView;
        C0355t0 c0355t0 = new C0355t0(this);
        C0356u c0356u = c0355t0.f1547c;
        AbstractC0337k0 abstractC0337k0 = c0356u.f1563l;
        if (abstractC0337k0 != null) {
            abstractC0337k0.apply(c0355t0);
        }
        RemoteViews remoteViewsMakeContentView = abstractC0337k0 != null ? abstractC0337k0.makeContentView(c0355t0) : null;
        int i6 = Build.VERSION.SDK_INT;
        Notification.Builder builder = c0355t0.f1546b;
        if (i6 < 26 && i6 < 24) {
            builder.setExtras(c0355t0.f1548d);
            notificationBuild = builder.build();
        } else {
            notificationBuild = builder.build();
        }
        if (remoteViewsMakeContentView != null) {
            notificationBuild.contentView = remoteViewsMakeContentView;
        }
        if (abstractC0337k0 != null && (remoteViewsMakeBigContentView = abstractC0337k0.makeBigContentView(c0355t0)) != null) {
            notificationBuild.bigContentView = remoteViewsMakeBigContentView;
        }
        if (abstractC0337k0 != null && (remoteViewsMakeHeadsUpContentView = c0356u.f1563l.makeHeadsUpContentView(c0355t0)) != null) {
            notificationBuild.headsUpContentView = remoteViewsMakeHeadsUpContentView;
        }
        if (abstractC0337k0 != null && (bundle = notificationBuild.extras) != null) {
            abstractC0337k0.addCompatExtras(bundle);
        }
        return notificationBuild;
    }

    public final void m1026c(int i6, boolean z7) {
        Notification notification = this.f1550B;
        if (z7) {
            notification.flags = i6 | notification.flags;
        } else {
            notification.flags = (~i6) & notification.flags;
        }
    }

    public final void m1027d(Bitmap bitmap) {
        IconCompat iconCompat;
        if (bitmap == null) {
            iconCompat = null;
        } else {
            if (Build.VERSION.SDK_INT < 27) {
                Resources resources = this.f1552a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
                }
            }
            PorterDuff.Mode mode = IconCompat.f1606k;
            bitmap.getClass();
            IconCompat iconCompat2 = new IconCompat(1);
            iconCompat2.f1608b = bitmap;
            iconCompat = iconCompat2;
        }
        this.f1559h = iconCompat;
    }

    public final void m1028e(AbstractC0337k0 abstractC0337k0) {
        if (this.f1563l != abstractC0337k0) {
            this.f1563l = abstractC0337k0;
            if (abstractC0337k0 != null) {
                abstractC0337k0.setBuilder(this);
            }
        }
    }
}
