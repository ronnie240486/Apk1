package p249x4;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.app.C0346p;
import androidx.core.app.C0354t;
import androidx.core.app.C0356u;
import androidx.fragment.app.C0412k0;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.GoogleApiActivity;
import p000a.AbstractC0004e;
import p018b5.AbstractC1306f;
import p018b5.AbstractC1312l;
import p018b5.DialogInterfaceOnClickListenerC1307g;
import p055ea.AbstractC2460q;
import p156o9.AbstractC3281e;
import p165p4.AbstractC3361f;
import p222u7.AbstractC3928d;
import p271z4.InterfaceC4335f;

public final class C4109b extends C4110c {

    public static final Object f13932c = new Object();

    public static final C4109b f13933d = new C4109b();

    public static AlertDialog m8123d(Activity activity, int i6, DialogInterfaceOnClickListenerC1307g dialogInterfaceOnClickListenerC1307g, DialogInterface.OnCancelListener onCancelListener) {
        String string;
        if (i6 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(AbstractC1306f.m3181b(activity, i6));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        if (i6 == 1) {
            string = resources.getString(com.p2serv.android.p032ds.R.string.common_google_play_services_install_button);
        } else if (i6 != 2) {
            string = i6 != 3 ? resources.getString(R.string.ok) : resources.getString(com.p2serv.android.p032ds.R.string.common_google_play_services_enable_button);
        } else {
            string = resources.getString(com.p2serv.android.p032ds.R.string.common_google_play_services_update_button);
        }
        if (string != null) {
            builder.setPositiveButton(string, dialogInterfaceOnClickListenerC1307g);
        }
        String strM3182c = AbstractC1306f.m3182c(activity, i6);
        if (strM3182c != null) {
            builder.setTitle(strM3182c);
        }
        Log.w("GoogleApiAvailability", AbstractC0004e.m20n(i6, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    public static void m8124e(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                C0412k0 c0412k0M1184k = ((FragmentActivity) activity).m1184k();
                C4113f c4113f = new C4113f();
                AbstractC1312l.m3199f(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                c4113f.f13941k0 = alertDialog;
                if (onCancelListener != null) {
                    c4113f.f13942l0 = onCancelListener;
                }
                c4113f.m1276S(c0412k0M1184k, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        DialogFragmentC4108a dialogFragmentC4108a = new DialogFragmentC4108a();
        AbstractC1312l.m3199f(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        dialogFragmentC4108a.f13929a = alertDialog;
        if (onCancelListener != null) {
            dialogFragmentC4108a.f13930b = onCancelListener;
        }
        dialogFragmentC4108a.show(fragmentManager, str);
    }

    public final void m8125c(GoogleApiActivity googleApiActivity, int i6, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogM8123d = m8123d(googleApiActivity, i6, new DialogInterfaceOnClickListenerC1307g(super.m8128a(googleApiActivity, i6, "d"), googleApiActivity, 0), googleApiActivity2);
        if (alertDialogM8123d == null) {
            return;
        }
        m8124e(googleApiActivity, alertDialogM8123d, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void m8126f(Context context, int i6, PendingIntent pendingIntent) {
        int i10;
        Log.w("GoogleApiAvailability", AbstractC2460q.m5492f(i6, "GMS core API Availability. ConnectionResult=", ", tag=null"), new IllegalArgumentException());
        if (i6 == 18) {
            new HandlerC4114g(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i6 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strM3184e = i6 == 6 ? AbstractC1306f.m3184e(context, "common_google_play_services_resolution_required_title") : AbstractC1306f.m3182c(context, i6);
        if (strM3184e == null) {
            strM3184e = context.getResources().getString(com.p2serv.android.p032ds.R.string.common_google_play_services_notification_ticker);
        }
        String strM3183d = (i6 == 6 || i6 == 19) ? AbstractC1306f.m3183d(context, "common_google_play_services_resolution_required_text", AbstractC1306f.m3180a(context)) : AbstractC1306f.m3181b(context, i6);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        AbstractC1312l.m3198e(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        C0356u c0356u = new C0356u(context, null);
        c0356u.f1569r = true;
        c0356u.m1026c(16, true);
        c0356u.f1556e = C0356u.m1024b(strM3184e);
        C0354t c0354t = new C0354t(0);
        c0354t.f1544b = C0356u.m1024b(strM3183d);
        c0356u.m1028e(c0354t);
        if (AbstractC3281e.m6632v(context)) {
            c0356u.f1550B.icon = context.getApplicationInfo().icon;
            c0356u.f1560i = 2;
            if (AbstractC3281e.m6633w(context)) {
                c0356u.f1553b.add(new C0346p(com.p2serv.android.p032ds.R.drawable.common_full_open_on_phone, resources.getString(com.p2serv.android.p032ds.R.string.common_open_on_phone), pendingIntent));
            } else {
                c0356u.f1558g = pendingIntent;
            }
        } else {
            c0356u.f1550B.icon = R.drawable.stat_sys_warning;
            c0356u.f1550B.tickerText = C0356u.m1024b(resources.getString(com.p2serv.android.p032ds.R.string.common_google_play_services_notification_ticker));
            c0356u.f1550B.when = System.currentTimeMillis();
            c0356u.f1558g = pendingIntent;
            c0356u.f1557f = C0356u.m1024b(strM3183d);
        }
        if (AbstractC3928d.m7856t()) {
            if (!AbstractC3928d.m7856t()) {
                throw new IllegalStateException();
            }
            synchronized (f13932c) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String string = context.getResources().getString(com.p2serv.android.p032ds.R.string.common_google_play_services_notification_channel_name);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(AbstractC3361f.m6839o(string));
            } else if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            c0356u.f1575x = "com.google.android.gms.availability";
        }
        Notification notificationM1025a = c0356u.m1025a();
        if (i6 == 1 || i6 == 2 || i6 == 3) {
            AbstractC4111d.f13936a.set(false);
            i10 = 10436;
        } else {
            i10 = 39789;
        }
        notificationManager.notify(i10, notificationM1025a);
    }

    public final void m8127g(Activity activity, InterfaceC4335f interfaceC4335f, int i6, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogM8123d = m8123d(activity, i6, new DialogInterfaceOnClickListenerC1307g(super.m8128a(activity, i6, "d"), interfaceC4335f, 1), onCancelListener);
        if (alertDialogM8123d == null) {
            return;
        }
        m8124e(activity, alertDialogM8123d, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
