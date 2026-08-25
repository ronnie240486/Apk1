package androidx.core.app;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.AbstractC0107a;
import androidx.core.graphics.drawable.IconCompat;

public final class C0352s extends AbstractC0337k0 {

    public IconCompat f1539a;

    public IconCompat f1540b;

    public boolean f1541c;

    public boolean f1542d;

    public static IconCompat m1020c(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 23 && AbstractC0107a.m284w(parcelable)) {
            return IconCompat.m1085c(AbstractC0107a.m268g(parcelable));
        }
        if (!(parcelable instanceof Bitmap)) {
            return null;
        }
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f1608b = (Bitmap) parcelable;
        return iconCompat;
    }

    @Override
    public final void apply(InterfaceC0342n interfaceC0342n) {
        Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(((C0355t0) interfaceC0342n).f1546b).setBigContentTitle(this.mBigContentTitle);
        IconCompat iconCompat = this.f1539a;
        if (iconCompat != null) {
            if (Build.VERSION.SDK_INT >= 31) {
                AbstractC0350r.m1013a(bigContentTitle, iconCompat.m1096n(((C0355t0) interfaceC0342n).f1545a));
            } else if (iconCompat.m1092j() == 1) {
                bigContentTitle = bigContentTitle.bigPicture(this.f1539a.m1089f());
            }
        }
        if (this.f1541c) {
            IconCompat iconCompat2 = this.f1540b;
            if (iconCompat2 == null) {
                bigContentTitle.bigLargeIcon((Bitmap) null);
            } else if (Build.VERSION.SDK_INT >= 23) {
                AbstractC0348q.m1010a(bigContentTitle, iconCompat2.m1096n(((C0355t0) interfaceC0342n).f1545a));
            } else if (iconCompat2.m1092j() == 1) {
                bigContentTitle.bigLargeIcon(this.f1540b.m1089f());
            } else {
                bigContentTitle.bigLargeIcon((Bitmap) null);
            }
        }
        if (this.mSummaryTextSet) {
            bigContentTitle.setSummaryText(this.mSummaryText);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            AbstractC0350r.m1015c(bigContentTitle, this.f1542d);
            AbstractC0350r.m1014b(bigContentTitle, null);
        }
    }

    @Override
    public final void clearCompatExtraKeys(Bundle bundle) {
        super.clearCompatExtraKeys(bundle);
        bundle.remove("android.largeIcon.big");
        bundle.remove("android.picture");
        bundle.remove("android.pictureIcon");
        bundle.remove("android.showBigPictureWhenCollapsed");
    }

    @Override
    public final String getClassName() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }

    @Override
    public final void restoreFromCompatExtras(Bundle bundle) {
        super.restoreFromCompatExtras(bundle);
        if (bundle.containsKey("android.largeIcon.big")) {
            this.f1540b = m1020c(bundle.getParcelable("android.largeIcon.big"));
            this.f1541c = true;
        }
        Parcelable parcelable = bundle.getParcelable("android.picture");
        this.f1539a = parcelable != null ? m1020c(parcelable) : m1020c(bundle.getParcelable("android.pictureIcon"));
        this.f1542d = bundle.getBoolean("android.showBigPictureWhenCollapsed");
    }
}
