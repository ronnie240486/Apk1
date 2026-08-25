package p199s4;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.C0344o;
import androidx.core.app.C0346p;
import androidx.core.app.C0356u;
import androidx.media3.common.C0565C;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import com.google.android.gms.cast.framework.media.NotificationAction;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.internal.cast.AbstractC1722x0;
import com.google.android.gms.internal.cast.C1670r2;
import com.google.android.gms.internal.cast.EnumC1679s2;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import p003a2.AbstractC0032a;
import p018b5.AbstractC1312l;
import p025c2.C1381b;
import p124l6.C2982h;
import p139n1.C3175b;
import p165p4.AbstractC3361f;
import p176q4.C3473b;
import p187r4.C3632v;
import p222u7.AbstractC3928d;
import p230v4.C3988b;

public final class C3713g {

    public static final C3988b f12424u = new C3988b("MediaNotificationProxy", null);

    public final Context f12425a;

    public final NotificationManager f12426b;

    public final NotificationOptions f12427c;

    public final ComponentName f12428d;

    public final ComponentName f12429e;

    public ArrayList f12430f = new ArrayList();

    public int[] f12431g;

    public final long f12432h;

    public final C1381b f12433i;

    public final Resources f12434j;

    public C3712f f12435k;

    public C2982h f12436l;

    public C0346p f12437m;

    public C0346p f12438n;

    public C0346p f12439o;

    public C0346p f12440p;

    public C0346p f12441q;

    public C0346p f12442r;

    public C0346p f12443s;

    public C0346p f12444t;

    public C3713g(Context context) {
        this.f12425a = context;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        this.f12426b = notificationManager;
        C3988b c3988b = C3473b.f11740k;
        AbstractC1312l.m3195b("Must be called from the main thread.");
        C3473b c3473b = C3473b.f11742m;
        AbstractC1312l.m3198e(c3473b);
        AbstractC1312l.m3195b("Must be called from the main thread.");
        CastOptions castOptions = c3473b.f11747e;
        AbstractC1312l.m3198e(castOptions);
        CastMediaOptions castMediaOptions = castOptions.f4768f;
        AbstractC1312l.m3198e(castMediaOptions);
        NotificationOptions notificationOptions = castMediaOptions.f4836d;
        AbstractC1312l.m3198e(notificationOptions);
        this.f12427c = notificationOptions;
        castMediaOptions.m3622j();
        Resources resources = context.getResources();
        this.f12434j = resources;
        this.f12428d = new ComponentName(context.getApplicationContext(), castMediaOptions.f4833a);
        String str = notificationOptions.f4858d;
        if (TextUtils.isEmpty(str)) {
            this.f12429e = null;
        } else {
            this.f12429e = new ComponentName(context.getApplicationContext(), str);
        }
        this.f12432h = notificationOptions.f4857c;
        int dimensionPixelSize = resources.getDimensionPixelSize(notificationOptions.f4872r);
        this.f12433i = new C1381b(context.getApplicationContext(), new ImageHints(1, dimensionPixelSize, dimensionPixelSize));
        if (AbstractC3928d.m7856t() && notificationManager != null) {
            NotificationChannel notificationChannelM6838n = AbstractC3361f.m6838n(context.getResources().getString(R.string.media_notification_channel_name));
            notificationChannelM6838n.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannelM6838n);
        }
        C1670r2.m3989a(EnumC1679s2.CAF_MEDIA_NOTIFICATION_PROXY);
    }

    public final C0346p m7470a(String str) {
        byte b8;
        C0346p c0346p;
        int i6;
        int i10;
        long j10;
        long j11;
        switch (str) {
            case "com.google.android.gms.cast.framework.action.REWIND":
                b8 = 4;
                break;
            case "com.google.android.gms.cast.framework.action.SKIP_NEXT":
                b8 = 1;
                break;
            case "com.google.android.gms.cast.framework.action.SKIP_PREV":
                b8 = 2;
                break;
            case "com.google.android.gms.cast.framework.action.STOP_CASTING":
                b8 = 5;
                break;
            case "com.google.android.gms.cast.framework.action.DISCONNECT":
                b8 = 6;
                break;
            case "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK":
                b8 = 0;
                break;
            case "com.google.android.gms.cast.framework.action.FORWARD":
                b8 = 3;
                break;
            default:
                b8 = -1;
                break;
        }
        long j12 = this.f12432h;
        PendingIntent broadcast = null;
        Resources resources = this.f12434j;
        Context context = this.f12425a;
        ComponentName componentName = this.f12428d;
        NotificationOptions notificationOptions = this.f12427c;
        switch (b8) {
            case 0:
                C3712f c3712f = this.f12435k;
                int i11 = c3712f.f12419c;
                if (!c3712f.f12418b) {
                    if (this.f12437m == null) {
                        Intent intent = new Intent(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK);
                        intent.setComponent(componentName);
                        this.f12437m = new C0344o(notificationOptions.f4862h, resources.getString(notificationOptions.f4876v), PendingIntent.getBroadcast(context, 0, intent, AbstractC1722x0.f5722a)).m996a();
                    }
                    c0346p = this.f12437m;
                } else {
                    if (this.f12438n == null) {
                        if (i11 == 2) {
                            i6 = notificationOptions.f4860f;
                            i10 = notificationOptions.f4874t;
                        } else {
                            i6 = notificationOptions.f4861g;
                            i10 = notificationOptions.f4875u;
                        }
                        Intent intent2 = new Intent(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK);
                        intent2.setComponent(componentName);
                        this.f12438n = new C0344o(i6, resources.getString(i10), PendingIntent.getBroadcast(context, 0, intent2, AbstractC1722x0.f5722a)).m996a();
                    }
                    c0346p = this.f12438n;
                }
                break;
            case 1:
                boolean z7 = this.f12435k.f12422f;
                if (this.f12439o == null) {
                    if (z7) {
                        Intent intent3 = new Intent(MediaIntentReceiver.ACTION_SKIP_NEXT);
                        intent3.setComponent(componentName);
                        broadcast = PendingIntent.getBroadcast(context, 0, intent3, AbstractC1722x0.f5722a);
                    }
                    this.f12439o = new C0344o(notificationOptions.f4863i, resources.getString(notificationOptions.f4877w), broadcast).m996a();
                }
                c0346p = this.f12439o;
                break;
            case 2:
                boolean z10 = this.f12435k.f12423g;
                if (this.f12440p == null) {
                    if (z10) {
                        Intent intent4 = new Intent(MediaIntentReceiver.ACTION_SKIP_PREV);
                        intent4.setComponent(componentName);
                        broadcast = PendingIntent.getBroadcast(context, 0, intent4, AbstractC1722x0.f5722a);
                    }
                    this.f12440p = new C0344o(notificationOptions.f4864j, resources.getString(notificationOptions.f4878x), broadcast).m996a();
                }
                c0346p = this.f12440p;
                break;
            case 3:
                if (this.f12441q == null) {
                    Intent intent5 = new Intent(MediaIntentReceiver.ACTION_FORWARD);
                    intent5.setComponent(componentName);
                    intent5.putExtra(MediaIntentReceiver.EXTRA_SKIP_STEP_MS, j12);
                    PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 0, intent5, AbstractC1722x0.f5722a | C0565C.BUFFER_FLAG_FIRST_SAMPLE);
                    C3988b c3988b = AbstractC3717k.f12470a;
                    int i12 = notificationOptions.f4865k;
                    if (j12 == Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
                        i12 = notificationOptions.f4866l;
                        j10 = SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS;
                    } else {
                        j10 = SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS;
                        if (j12 == SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS) {
                            i12 = notificationOptions.f4867m;
                        }
                    }
                    this.f12441q = new C0344o(i12, resources.getString(j12 == Renderer.DEFAULT_DURATION_TO_PROGRESS_US ? notificationOptions.f4880z : j12 != j10 ? notificationOptions.f4879y : notificationOptions.f4847A), broadcast2).m996a();
                }
                c0346p = this.f12441q;
                break;
            case 4:
                if (this.f12442r == null) {
                    Intent intent6 = new Intent(MediaIntentReceiver.ACTION_REWIND);
                    intent6.setComponent(componentName);
                    intent6.putExtra(MediaIntentReceiver.EXTRA_SKIP_STEP_MS, j12);
                    PendingIntent broadcast3 = PendingIntent.getBroadcast(context, 0, intent6, AbstractC1722x0.f5722a | C0565C.BUFFER_FLAG_FIRST_SAMPLE);
                    C3988b c3988b2 = AbstractC3717k.f12470a;
                    int i13 = notificationOptions.f4868n;
                    if (j12 == Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
                        i13 = notificationOptions.f4869o;
                        j11 = SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS;
                    } else {
                        j11 = SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS;
                        if (j12 == SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS) {
                            i13 = notificationOptions.f4870p;
                        }
                    }
                    this.f12442r = new C0344o(i13, resources.getString(j12 == Renderer.DEFAULT_DURATION_TO_PROGRESS_US ? notificationOptions.f4849C : j12 != j11 ? notificationOptions.f4848B : notificationOptions.f4850D), broadcast3).m996a();
                }
                c0346p = this.f12442r;
                break;
            case 5:
                if (this.f12444t == null) {
                    Intent intent7 = new Intent(MediaIntentReceiver.ACTION_STOP_CASTING);
                    intent7.setComponent(componentName);
                    this.f12444t = new C0344o(notificationOptions.f4871q, resources.getString(notificationOptions.f4851E), PendingIntent.getBroadcast(context, 0, intent7, AbstractC1722x0.f5722a)).m996a();
                }
                c0346p = this.f12444t;
                break;
            case 6:
                if (this.f12443s == null) {
                    Intent intent8 = new Intent(MediaIntentReceiver.ACTION_DISCONNECT);
                    intent8.setComponent(componentName);
                    this.f12443s = new C0344o(notificationOptions.f4871q, resources.getString(notificationOptions.f4851E, ""), PendingIntent.getBroadcast(context, 0, intent8, AbstractC1722x0.f5722a)).m996a();
                }
                c0346p = this.f12443s;
                break;
            default:
                C3988b c3988b3 = f12424u;
                Log.e(c3988b3.f13521a, c3988b3.m7977d("Action: %s is not a pre-defined action.", str));
                return null;
        }
        return c0346p;
    }

    public final void m7471b() {
        Bitmap bitmap;
        PendingIntent activities;
        C0346p c0346pM7470a;
        NotificationManager notificationManager = this.f12426b;
        if (notificationManager == null || this.f12435k == null) {
            return;
        }
        C2982h c2982h = this.f12436l;
        if (c2982h == null || (bitmap = (Bitmap) c2982h.f10226c) == null || bitmap.getWidth() <= 1 || bitmap.getHeight() <= 1) {
            bitmap = null;
        }
        Context context = this.f12425a;
        C0356u c0356u = new C0356u(context, "cast_media_notification");
        c0356u.m1027d(bitmap);
        NotificationOptions notificationOptions = this.f12427c;
        c0356u.f1550B.icon = notificationOptions.f4859e;
        c0356u.f1556e = C0356u.m1024b(this.f12435k.f12420d);
        c0356u.f1557f = C0356u.m1024b(this.f12434j.getString(notificationOptions.f4873s, this.f12435k.f12421e));
        c0356u.m1026c(2, true);
        c0356u.f1561j = false;
        c0356u.f1574w = 1;
        ComponentName componentName = this.f12429e;
        if (componentName == null) {
            activities = null;
        } else {
            Intent intent = new Intent();
            intent.putExtra("targetActivity", componentName);
            intent.setAction(componentName.flattenToString());
            intent.setComponent(componentName);
            ArrayList arrayList = new ArrayList();
            ComponentName component = intent.getComponent();
            if (component == null) {
                component = intent.resolveActivity(context.getPackageManager());
            }
            if (component != null) {
                int size = arrayList.size();
                try {
                    for (Intent intentM172z = AbstractC0032a.m172z(context, component); intentM172z != null; intentM172z = AbstractC0032a.m172z(context, intentM172z.getComponent())) {
                        arrayList.add(size, intentM172z);
                    }
                } catch (PackageManager.NameNotFoundException e5) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(e5);
                }
            }
            arrayList.add(intent);
            int i6 = AbstractC1722x0.f5722a | C0565C.BUFFER_FLAG_FIRST_SAMPLE;
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
            }
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            activities = PendingIntent.getActivities(context, 1, intentArr, i6, null);
        }
        if (activities != null) {
            c0356u.f1558g = activities;
        }
        C3988b c3988b = f12424u;
        C3632v c3632v = notificationOptions.f4852F;
        if (c3632v != null) {
            c3988b.m7975b("actionsProvider != null", new Object[0]);
            int[] iArrM7483b = AbstractC3717k.m7483b(c3632v);
            this.f12431g = iArrM7483b == null ? null : (int[]) iArrM7483b.clone();
            ArrayList<NotificationAction> arrayListM7482a = AbstractC3717k.m7482a(c3632v);
            this.f12430f = new ArrayList();
            if (arrayListM7482a != null) {
                for (NotificationAction notificationAction : arrayListM7482a) {
                    String str = notificationAction.f4842a;
                    boolean zEquals = str.equals(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK);
                    String str2 = notificationAction.f4842a;
                    if (zEquals || str.equals(MediaIntentReceiver.ACTION_SKIP_NEXT) || str.equals(MediaIntentReceiver.ACTION_SKIP_PREV) || str.equals(MediaIntentReceiver.ACTION_FORWARD) || str.equals(MediaIntentReceiver.ACTION_REWIND) || str.equals(MediaIntentReceiver.ACTION_STOP_CASTING) || str.equals(MediaIntentReceiver.ACTION_DISCONNECT)) {
                        c0346pM7470a = m7470a(str2);
                    } else {
                        Intent intent2 = new Intent(str2);
                        intent2.setComponent(this.f12428d);
                        c0346pM7470a = new C0344o(notificationAction.f4843b, notificationAction.f4844c, PendingIntent.getBroadcast(context, 0, intent2, AbstractC1722x0.f5722a)).m996a();
                    }
                    if (c0346pM7470a != null) {
                        this.f12430f.add(c0346pM7470a);
                    }
                }
            }
        } else {
            c3988b.m7975b("actionsProvider == null", new Object[0]);
            this.f12430f = new ArrayList();
            Iterator it = notificationOptions.f4855a.iterator();
            while (it.hasNext()) {
                C0346p c0346pM7470a2 = m7470a((String) it.next());
                if (c0346pM7470a2 != null) {
                    this.f12430f.add(c0346pM7470a2);
                }
            }
            int[] iArr = notificationOptions.f4856b;
            this.f12431g = (int[]) Arrays.copyOf(iArr, iArr.length).clone();
        }
        for (C0346p c0346p : this.f12430f) {
            if (c0346p != null) {
                c0356u.f1553b.add(c0346p);
            }
        }
        C3175b c3175b = new C3175b();
        c3175b.f10665a = null;
        int[] iArr2 = this.f12431g;
        if (iArr2 != null) {
            c3175b.f10665a = iArr2;
        }
        MediaSessionCompat.Token token = this.f12435k.f12417a;
        if (token != null) {
            c3175b.f10666b = token;
        }
        c0356u.m1028e(c3175b);
        notificationManager.notify("castMediaNotification", 1, c0356u.m1025a());
    }
}
