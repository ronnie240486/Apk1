package androidx.core.app;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.AbstractC0108b;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import com.p2serv.android.p032ds.R;
import java.io.InputStream;
import p046e0.AbstractC2350i;
import p046e0.AbstractC2355n;
import p065g0.AbstractC2581a;
import p065g0.AbstractC2583c;
import p065g0.AbstractC2584d;

public abstract class AbstractC0337k0 {
    CharSequence mBigContentTitle;
    protected C0356u mBuilder;
    CharSequence mSummaryText;
    boolean mSummaryTextSet = false;

    public static AbstractC0337k0 constructCompatStyleByName(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle":
                return new C0320c0();
            case "androidx.core.app.NotificationCompat$BigPictureStyle":
                return new C0352s();
            case "androidx.core.app.NotificationCompat$CallStyle":
                return new C0314a0();
            case "androidx.core.app.NotificationCompat$InboxStyle":
                return new C0354t(1);
            case "androidx.core.app.NotificationCompat$BigTextStyle":
                return new C0354t(0);
            case "androidx.core.app.NotificationCompat$MessagingStyle":
                return new C0335j0();
            default:
                return null;
        }
    }

    public static AbstractC0337k0 constructCompatStyleForBundle(Bundle bundle) {
        AbstractC0337k0 abstractC0337k0ConstructCompatStyleByName = constructCompatStyleByName(bundle.getString("androidx.core.app.extra.COMPAT_TEMPLATE"));
        if (abstractC0337k0ConstructCompatStyleByName != null) {
            return abstractC0337k0ConstructCompatStyleByName;
        }
        if (bundle.containsKey("android.selfDisplayName") || bundle.containsKey("android.messagingStyleUser")) {
            return new C0335j0();
        }
        if (bundle.containsKey("android.picture") || bundle.containsKey("android.pictureIcon")) {
            return new C0352s();
        }
        if (bundle.containsKey("android.bigText")) {
            return new C0354t(0);
        }
        if (bundle.containsKey("android.textLines")) {
            return new C0354t(1);
        }
        if (bundle.containsKey("android.callType")) {
            return new C0314a0();
        }
        String string = bundle.getString("android.template");
        if (string == null) {
            return null;
        }
        if (string.equals(Notification.BigPictureStyle.class.getName())) {
            return new C0352s();
        }
        if (string.equals(Notification.BigTextStyle.class.getName())) {
            return new C0354t(0);
        }
        if (string.equals(Notification.InboxStyle.class.getName())) {
            return new C0354t(1);
        }
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        if (string.equals(AbstractC0108b.m299h().getName())) {
            return new C0335j0();
        }
        if (string.equals(AbstractC0108b.m290C().getName())) {
            return new C0320c0();
        }
        return null;
    }

    public static AbstractC0337k0 constructStyleForExtras(Bundle bundle) {
        AbstractC0337k0 abstractC0337k0ConstructCompatStyleForBundle = constructCompatStyleForBundle(bundle);
        if (abstractC0337k0ConstructCompatStyleForBundle == null) {
            return null;
        }
        try {
            abstractC0337k0ConstructCompatStyleForBundle.restoreFromCompatExtras(bundle);
            return abstractC0337k0ConstructCompatStyleForBundle;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public static AbstractC0337k0 extractStyleFromNotification(Notification notification) {
        Bundle bundle = notification.extras;
        if (bundle == null) {
            return null;
        }
        return constructStyleForExtras(bundle);
    }

    public final Bitmap m974a(IconCompat iconCompat, int i6, int i10) {
        Drawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        Drawable drawableM5594e;
        Object obj;
        Context context = this.mBuilder.f1552a;
        if (iconCompat.f1607a == 2 && (obj = iconCompat.f1608b) != null) {
            String str = (String) obj;
            if (str.contains(":")) {
                String str2 = str.split(":", -1)[1];
                String str3 = str2.split("/", -1)[0];
                String str4 = str2.split("/", -1)[1];
                String str5 = str.split(":", -1)[0];
                if ("0_resource_name_obfuscated".equals(str4)) {
                    Log.i("IconCompat", "Found obfuscated resource, not trying to update resource id for it");
                } else {
                    String strM1091h = iconCompat.m1091h();
                    int identifier = IconCompat.m1088i(context, strM1091h).getIdentifier(str4, str3, str5);
                    if (iconCompat.f1611e != identifier) {
                        Log.i("IconCompat", "Id has changed for " + strM1091h + " " + str);
                        iconCompat.f1611e = identifier;
                    }
                }
            }
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            drawableM5594e = AbstractC2583c.m5594e(iconCompat.m1096n(context), context);
        } else {
            switch (iconCompat.f1607a) {
                case 1:
                    bitmapDrawable = new BitmapDrawable(context.getResources(), (Bitmap) iconCompat.f1608b);
                    break;
                case 2:
                    String strM1091h2 = iconCompat.m1091h();
                    if (TextUtils.isEmpty(strM1091h2)) {
                        strM1091h2 = context.getPackageName();
                    }
                    Resources resourcesM1088i = IconCompat.m1088i(context, strM1091h2);
                    try {
                        int i12 = iconCompat.f1611e;
                        Resources.Theme theme = context.getTheme();
                        ThreadLocal threadLocal = AbstractC2355n.f8209a;
                        bitmapDrawable = AbstractC2350i.m5332a(resourcesM1088i, i12, theme);
                    } catch (RuntimeException e5) {
                        Log.e("IconCompat", String.format("Unable to load resource 0x%08x from pkg=%s", Integer.valueOf(iconCompat.f1611e), iconCompat.f1608b), e5);
                        bitmapDrawable = null;
                    }
                    break;
                case 3:
                    bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) iconCompat.f1608b, iconCompat.f1611e, iconCompat.f1612f));
                    break;
                case 4:
                    InputStream inputStreamM1094l = iconCompat.m1094l(context);
                    if (inputStreamM1094l == null) {
                        bitmapDrawable = null;
                    } else {
                        bitmapDrawable2 = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(inputStreamM1094l));
                        bitmapDrawable = bitmapDrawable2;
                    }
                    break;
                case 5:
                    bitmapDrawable = new BitmapDrawable(context.getResources(), IconCompat.m1086d((Bitmap) iconCompat.f1608b, false));
                    break;
                case 6:
                    InputStream inputStreamM1094l2 = iconCompat.m1094l(context);
                    if (inputStreamM1094l2 == null) {
                        bitmapDrawable = null;
                    } else if (i11 < 26) {
                        bitmapDrawable2 = new BitmapDrawable(context.getResources(), IconCompat.m1086d(BitmapFactory.decodeStream(inputStreamM1094l2), false));
                        bitmapDrawable = bitmapDrawable2;
                    } else {
                        bitmapDrawable = AbstractC2584d.m5596a(null, new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(inputStreamM1094l2)));
                    }
                    break;
                default:
                    bitmapDrawable = null;
                    break;
            }
            if (bitmapDrawable != null && (iconCompat.f1613g != null || iconCompat.f1614h != IconCompat.f1606k)) {
                bitmapDrawable.mutate();
                AbstractC2581a.m5586h(bitmapDrawable, iconCompat.f1613g);
                AbstractC2581a.m5587i(bitmapDrawable, iconCompat.f1614h);
            }
            drawableM5594e = bitmapDrawable;
        }
        int intrinsicWidth = i10 == 0 ? drawableM5594e.getIntrinsicWidth() : i10;
        if (i10 == 0) {
            i10 = drawableM5594e.getIntrinsicHeight();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, i10, Bitmap.Config.ARGB_8888);
        drawableM5594e.setBounds(0, 0, intrinsicWidth, i10);
        if (i6 != 0) {
            drawableM5594e.mutate().setColorFilter(new PorterDuffColorFilter(i6, PorterDuff.Mode.SRC_IN));
        }
        drawableM5594e.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public void addCompatExtras(Bundle bundle) {
        if (this.mSummaryTextSet) {
            bundle.putCharSequence("android.summaryText", this.mSummaryText);
        }
        CharSequence charSequence = this.mBigContentTitle;
        if (charSequence != null) {
            bundle.putCharSequence("android.title.big", charSequence);
        }
        String className = getClassName();
        if (className != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", className);
        }
    }

    public abstract void apply(InterfaceC0342n interfaceC0342n);

    public RemoteViews applyStandardTemplate(boolean z7, int i6, boolean z10) {
        boolean z11;
        int i10;
        Resources resources = this.mBuilder.f1552a.getResources();
        RemoteViews remoteViews = new RemoteViews(this.mBuilder.f1552a.getPackageName(), i6);
        C0356u c0356u = this.mBuilder;
        int i11 = c0356u.f1560i;
        if (c0356u.f1559h != null) {
            remoteViews.setViewVisibility(R.id.icon, 0);
            remoteViews.setImageViewBitmap(R.id.icon, createColoredBitmap(this.mBuilder.f1559h, 0));
            if (z7 && this.mBuilder.f1550B.icon != 0) {
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
                int dimensionPixelSize2 = dimensionPixelSize - (resources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding) * 2);
                C0356u c0356u2 = this.mBuilder;
                remoteViews.setImageViewBitmap(R.id.right_icon, m975b(c0356u2.f1550B.icon, dimensionPixelSize, dimensionPixelSize2, c0356u2.f1573v));
                remoteViews.setViewVisibility(R.id.right_icon, 0);
            }
        } else if (z7 && c0356u.f1550B.icon != 0) {
            remoteViews.setViewVisibility(R.id.icon, 0);
            int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.notification_large_icon_width) - resources.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
            int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
            C0356u c0356u3 = this.mBuilder;
            remoteViews.setImageViewBitmap(R.id.icon, m975b(c0356u3.f1550B.icon, dimensionPixelSize3, dimensionPixelSize4, c0356u3.f1573v));
        }
        CharSequence charSequence = this.mBuilder.f1556e;
        if (charSequence != null) {
            remoteViews.setTextViewText(R.id.title, charSequence);
        }
        CharSequence charSequence2 = this.mBuilder.f1557f;
        if (charSequence2 != null) {
            remoteViews.setTextViewText(R.id.text, charSequence2);
            z11 = true;
        } else {
            z11 = false;
        }
        this.mBuilder.getClass();
        this.mBuilder.getClass();
        remoteViews.setViewVisibility(R.id.info, 8);
        CharSequence charSequence3 = this.mBuilder.f1564m;
        if (charSequence3 != null) {
            remoteViews.setTextViewText(R.id.text, charSequence3);
            CharSequence charSequence4 = this.mBuilder.f1557f;
            if (charSequence4 != null) {
                remoteViews.setTextViewText(R.id.text2, charSequence4);
                remoteViews.setViewVisibility(R.id.text2, 0);
                if (z10) {
                    remoteViews.setTextViewTextSize(R.id.text, 0, resources.getDimensionPixelSize(R.dimen.notification_subtext_size));
                }
                remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
            } else {
                remoteViews.setViewVisibility(R.id.text2, 8);
            }
        }
        C0356u c0356u4 = this.mBuilder;
        if ((c0356u4.f1561j ? c0356u4.f1550B.when : 0L) != 0) {
            if (c0356u4.f1562k) {
                remoteViews.setViewVisibility(R.id.chronometer, 0);
                C0356u c0356u5 = this.mBuilder;
                remoteViews.setLong(R.id.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + (c0356u5.f1561j ? c0356u5.f1550B.when : 0L));
                remoteViews.setBoolean(R.id.chronometer, "setStarted", true);
                this.mBuilder.getClass();
            } else {
                remoteViews.setViewVisibility(R.id.time, 0);
                C0356u c0356u6 = this.mBuilder;
                remoteViews.setLong(R.id.time, "setTime", c0356u6.f1561j ? c0356u6.f1550B.when : 0L);
            }
            i10 = 0;
        } else {
            i10 = 8;
        }
        remoteViews.setViewVisibility(R.id.right_side, i10);
        remoteViews.setViewVisibility(R.id.line3, z11 ? 0 : 8);
        return remoteViews;
    }

    public final Bitmap m975b(int i6, int i10, int i11, int i12) {
        if (i12 == 0) {
            i12 = 0;
        }
        Context context = this.mBuilder.f1552a;
        PorterDuff.Mode mode = IconCompat.f1606k;
        context.getClass();
        Bitmap bitmapM974a = m974a(IconCompat.m1087e(context.getResources(), context.getPackageName(), R.drawable.notification_icon_background), i12, i10);
        Canvas canvas = new Canvas(bitmapM974a);
        Drawable drawableMutate = this.mBuilder.f1552a.getResources().getDrawable(i6).mutate();
        drawableMutate.setFilterBitmap(true);
        int i13 = (i10 - i11) / 2;
        int i14 = i11 + i13;
        drawableMutate.setBounds(i13, i13, i14, i14);
        drawableMutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        drawableMutate.draw(canvas);
        return bitmapM974a;
    }

    public Notification build() {
        C0356u c0356u = this.mBuilder;
        if (c0356u != null) {
            return c0356u.m1025a();
        }
        return null;
    }

    public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
        remoteViews.setViewVisibility(R.id.title, 8);
        remoteViews.setViewVisibility(R.id.text2, 8);
        remoteViews.setViewVisibility(R.id.text, 8);
        remoteViews.removeAllViews(R.id.notification_main_column);
        remoteViews.addView(R.id.notification_main_column, remoteViews2.clone());
        remoteViews.setViewVisibility(R.id.notification_main_column, 0);
        Resources resources = this.mBuilder.f1552a.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
        float f = resources.getConfiguration().fontScale;
        if (f < 1.0f) {
            f = 1.0f;
        } else if (f > 1.3f) {
            f = 1.3f;
        }
        float f3 = (f - 1.0f) / 0.29999995f;
        remoteViews.setViewPadding(R.id.notification_main_column_container, 0, Math.round((f3 * dimensionPixelSize2) + ((1.0f - f3) * dimensionPixelSize)), 0, 0);
    }

    public void clearCompatExtraKeys(Bundle bundle) {
        bundle.remove("android.summaryText");
        bundle.remove("android.title.big");
        bundle.remove("androidx.core.app.extra.COMPAT_TEMPLATE");
    }

    public Bitmap createColoredBitmap(IconCompat iconCompat, int i6) {
        return m974a(iconCompat, i6, 0);
    }

    public boolean displayCustomViewInline() {
        return false;
    }

    public String getClassName() {
        return null;
    }

    public RemoteViews makeBigContentView(InterfaceC0342n interfaceC0342n) {
        return null;
    }

    public RemoteViews makeContentView(InterfaceC0342n interfaceC0342n) {
        return null;
    }

    public RemoteViews makeHeadsUpContentView(InterfaceC0342n interfaceC0342n) {
        return null;
    }

    public void restoreFromCompatExtras(Bundle bundle) {
        if (bundle.containsKey("android.summaryText")) {
            this.mSummaryText = bundle.getCharSequence("android.summaryText");
            this.mSummaryTextSet = true;
        }
        this.mBigContentTitle = bundle.getCharSequence("android.title.big");
    }

    public void setBuilder(C0356u c0356u) {
        if (this.mBuilder != c0356u) {
            this.mBuilder = c0356u;
            if (c0356u != null) {
                c0356u.m1028e(this);
            }
        }
    }

    public Bitmap createColoredBitmap(int i6, int i10) {
        Context context = this.mBuilder.f1552a;
        PorterDuff.Mode mode = IconCompat.f1606k;
        context.getClass();
        return m974a(IconCompat.m1087e(context.getResources(), context.getPackageName(), i6), i10, 0);
    }
}
