package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Iterator;
import p160p.C3342f;

public final class C0355t0 implements InterfaceC0342n {

    public final Context f1545a;

    public final Notification.Builder f1546b;

    public final C0356u f1547c;

    public final Bundle f1548d;

    public C0355t0(C0356u c0356u) {
        String str;
        int i6;
        Bundle[] bundleArr;
        ArrayList arrayList;
        C0346p c0346pM944c;
        new ArrayList();
        this.f1548d = new Bundle();
        this.f1547c = c0356u;
        Context context = c0356u.f1552a;
        this.f1545a = context;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            this.f1546b = AbstractC0347p0.m1003a(context, c0356u.f1575x);
        } else {
            this.f1546b = new Notification.Builder(c0356u.f1552a);
        }
        Notification notification = c0356u.f1550B;
        int i11 = 2;
        this.f1546b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(c0356u.f1556e).setContentText(c0356u.f1557f).setContentInfo(null).setContentIntent(c0356u.f1558g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(0).setProgress(c0356u.f1565n, c0356u.f1566o, c0356u.f1567p);
        if (i10 < 23) {
            Notification.Builder builder = this.f1546b;
            IconCompat iconCompat = c0356u.f1559h;
            builder.setLargeIcon(iconCompat == null ? null : iconCompat.m1089f());
        } else {
            Notification.Builder builder2 = this.f1546b;
            IconCompat iconCompat2 = c0356u.f1559h;
            AbstractC0343n0.m994b(builder2, iconCompat2 == null ? null : iconCompat2.m1096n(context));
        }
        this.f1546b.setSubText(c0356u.f1564m).setUsesChronometer(c0356u.f1562k).setPriority(c0356u.f1560i);
        AbstractC0337k0 abstractC0337k0 = c0356u.f1563l;
        if (abstractC0337k0 instanceof C0314a0) {
            C0314a0 c0314a0 = (C0314a0) abstractC0337k0;
            PendingIntent pendingIntent = c0314a0.f1474d;
            C0346p c0346pM944c2 = pendingIntent == null ? c0314a0.m944c(R.drawable.ic_call_decline, R.string.call_notification_hang_up_action, c0314a0.f1478h, R.color.call_notification_decline_color, c0314a0.f1475e) : c0314a0.m944c(R.drawable.ic_call_decline, R.string.call_notification_decline_action, c0314a0.f1478h, R.color.call_notification_decline_color, pendingIntent);
            PendingIntent pendingIntent2 = c0314a0.f1473c;
            if (pendingIntent2 == null) {
                c0346pM944c = null;
            } else {
                boolean z7 = c0314a0.f1476f;
                c0346pM944c = c0314a0.m944c(z7 ? R.drawable.ic_call_answer_video : R.drawable.ic_call_answer, z7 ? R.string.call_notification_answer_video_action : R.string.call_notification_answer_action, c0314a0.f1477g, R.color.call_notification_answer_color, pendingIntent2);
            }
            ArrayList arrayList2 = new ArrayList(3);
            arrayList2.add(c0346pM944c2);
            ArrayList<C0346p> arrayList3 = c0314a0.mBuilder.f1553b;
            if (arrayList3 != null) {
                for (C0346p c0346p : arrayList3) {
                    c0346p.getClass();
                    if (!c0346p.f1531a.getBoolean("key_action_priority") && i11 > 1) {
                        arrayList2.add(c0346p);
                        i11--;
                    }
                    if (c0346pM944c != null && i11 == 1) {
                        arrayList2.add(c0346pM944c);
                        i11--;
                    }
                }
            }
            if (c0346pM944c != null && i11 >= 1) {
                arrayList2.add(c0346pM944c);
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                m1023a((C0346p) it.next());
            }
        } else {
            Iterator it2 = c0356u.f1553b.iterator();
            while (it2.hasNext()) {
                m1023a((C0346p) it2.next());
            }
        }
        Bundle bundle = c0356u.f1572u;
        if (bundle != null) {
            this.f1548d.putAll(bundle);
        }
        int i12 = Build.VERSION.SDK_INT;
        this.f1546b.setShowWhen(c0356u.f1561j);
        AbstractC0339l0.m984i(this.f1546b, c0356u.f1569r);
        AbstractC0339l0.m982g(this.f1546b, c0356u.f1568q);
        AbstractC0339l0.m985j(this.f1546b, null);
        AbstractC0339l0.m983h(this.f1546b, false);
        AbstractC0341m0.m988b(this.f1546b, null);
        AbstractC0341m0.m989c(this.f1546b, c0356u.f1573v);
        AbstractC0341m0.m992f(this.f1546b, c0356u.f1574w);
        AbstractC0341m0.m990d(this.f1546b, null);
        AbstractC0341m0.m991e(this.f1546b, notification.sound, notification.audioAttributes);
        ArrayList arrayList4 = c0356u.f1551C;
        ArrayList<C0318b1> arrayList5 = c0356u.f1554c;
        if (i12 < 28) {
            if (arrayList5 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList5.size());
                for (C0318b1 c0318b1 : arrayList5) {
                    String str2 = c0318b1.f1483c;
                    if (str2 == null) {
                        CharSequence charSequence = c0318b1.f1481a;
                        str2 = charSequence != null ? "name:" + ((Object) charSequence) : "";
                    }
                    arrayList.add(str2);
                }
            }
            if (arrayList != null) {
                if (arrayList4 == null) {
                    arrayList4 = arrayList;
                } else {
                    C3342f c3342f = new C3342f(arrayList4.size() + arrayList.size());
                    c3342f.addAll(arrayList);
                    c3342f.addAll(arrayList4);
                    arrayList4 = new ArrayList(c3342f);
                }
            }
        }
        if (arrayList4 != null && !arrayList4.isEmpty()) {
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                AbstractC0341m0.m987a(this.f1546b, (String) it3.next());
            }
        }
        ArrayList arrayList6 = c0356u.f1555d;
        if (arrayList6.size() > 0) {
            if (c0356u.f1572u == null) {
                c0356u.f1572u = new Bundle();
            }
            Bundle bundle2 = c0356u.f1572u.getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i13 = 0; i13 < arrayList6.size(); i13++) {
                String string = Integer.toString(i13);
                C0346p c0346p2 = (C0346p) arrayList6.get(i13);
                Bundle bundle5 = new Bundle();
                IconCompat iconCompatM1002a = c0346p2.m1002a();
                bundle5.putInt("icon", iconCompatM1002a != null ? iconCompatM1002a.m1090g() : 0);
                bundle5.putCharSequence("title", c0346p2.f1537g);
                bundle5.putParcelable("actionIntent", c0346p2.f1538h);
                Bundle bundle6 = c0346p2.f1531a;
                Bundle bundle7 = bundle6 != null ? new Bundle(bundle6) : new Bundle();
                bundle7.putBoolean("android.support.allowGeneratedReplies", c0346p2.f1534d);
                bundle5.putBundle("extras", bundle7);
                AbstractC0321c1[] abstractC0321c1Arr = c0346p2.f1533c;
                if (abstractC0321c1Arr == null) {
                    bundleArr = null;
                } else {
                    bundleArr = new Bundle[abstractC0321c1Arr.length];
                    if (abstractC0321c1Arr.length > 0) {
                        AbstractC0321c1 abstractC0321c1 = abstractC0321c1Arr[0];
                        new Bundle();
                        throw null;
                    }
                }
                bundle5.putParcelableArray("remoteInputs", bundleArr);
                bundle5.putBoolean("showsUserInterface", c0346p2.f1535e);
                bundle5.putInt("semanticAction", 0);
                bundle4.putBundle(string, bundle5);
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            if (c0356u.f1572u == null) {
                c0356u.f1572u = new Bundle();
            }
            c0356u.f1572u.putBundle("android.car.EXTENSIONS", bundle2);
            this.f1548d.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 24) {
            this.f1546b.setExtras(c0356u.f1572u);
            str = null;
            AbstractC0345o0.m1001e(this.f1546b, null);
        } else {
            str = null;
        }
        if (i14 >= 26) {
            AbstractC0347p0.m1004b(this.f1546b, c0356u.f1576y);
            AbstractC0347p0.m1007e(this.f1546b, str);
            AbstractC0347p0.m1008f(this.f1546b, str);
            AbstractC0347p0.m1009g(this.f1546b, 0L);
            AbstractC0347p0.m1006d(this.f1546b, 0);
            if (c0356u.f1571t) {
                AbstractC0347p0.m1005c(this.f1546b, c0356u.f1570s);
            }
            if (!TextUtils.isEmpty(c0356u.f1575x)) {
                this.f1546b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i14 >= 28) {
            for (C0318b1 c0318b2 : arrayList5) {
                Notification.Builder builder3 = this.f1546b;
                c0318b2.getClass();
                AbstractC0349q0.m1011a(builder3, AbstractC0315a1.m946b(c0318b2));
            }
        }
        int i15 = Build.VERSION.SDK_INT;
        if (i15 >= 29) {
            AbstractC0351r0.m1016a(this.f1546b, c0356u.f1549A);
            AbstractC0351r0.m1017b(this.f1546b, null);
        }
        if (i15 < 31 || (i6 = c0356u.f1577z) == 0) {
            return;
        }
        AbstractC0353s0.m1022b(this.f1546b, i6);
    }

    public final void m1023a(C0346p c0346p) {
        int i6 = Build.VERSION.SDK_INT;
        IconCompat iconCompatM1002a = c0346p.m1002a();
        PendingIntent pendingIntent = c0346p.f1538h;
        CharSequence charSequence = c0346p.f1537g;
        Notification.Action.Builder builderM993a = i6 >= 23 ? AbstractC0343n0.m993a(iconCompatM1002a != null ? iconCompatM1002a.m1096n(null) : null, charSequence, pendingIntent) : AbstractC0339l0.m980e(iconCompatM1002a != null ? iconCompatM1002a.m1090g() : 0, charSequence, pendingIntent);
        AbstractC0321c1[] abstractC0321c1Arr = c0346p.f1533c;
        if (abstractC0321c1Arr != null) {
            RemoteInput[] remoteInputArr = new RemoteInput[abstractC0321c1Arr.length];
            if (abstractC0321c1Arr.length > 0) {
                AbstractC0321c1 abstractC0321c1 = abstractC0321c1Arr[0];
                throw null;
            }
            for (RemoteInput remoteInput : remoteInputArr) {
                AbstractC0339l0.m978c(builderM993a, remoteInput);
            }
        }
        Bundle bundle = c0346p.f1531a;
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        boolean z7 = c0346p.f1534d;
        bundle2.putBoolean("android.support.allowGeneratedReplies", z7);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            AbstractC0345o0.m997a(builderM993a, z7);
        }
        bundle2.putInt("android.support.action.semanticAction", 0);
        if (i10 >= 28) {
            AbstractC0349q0.m1012b(builderM993a, 0);
        }
        if (i10 >= 29) {
            AbstractC0351r0.m1018c(builderM993a, false);
        }
        if (i10 >= 31) {
            AbstractC0353s0.m1021a(builderM993a, false);
        }
        bundle2.putBoolean("android.support.action.showsUserInterface", c0346p.f1535e);
        AbstractC0339l0.m977b(builderM993a, bundle2);
        AbstractC0339l0.m976a(this.f1546b, AbstractC0339l0.m979d(builderM993a));
    }
}
