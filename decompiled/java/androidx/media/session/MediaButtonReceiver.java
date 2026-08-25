package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;
import java.util.List;
import p000a.AbstractC0004e;
import p034d0.AbstractC2117c;
import p149o1.C3245a;

public class MediaButtonReceiver extends BroadcastReceiver {

    public static final int f2576a = 0;

    public static ComponentName m1533a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        if (listQueryIntentServices.isEmpty()) {
            return null;
        }
        StringBuilder sbM30x = AbstractC0004e.m30x("Expected 1 service that handles ", str, ", found ");
        sbM30x.append(listQueryIntentServices.size());
        throw new IllegalStateException(sbM30x.toString());
    }

    @Override
    public final void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName componentNameM1533a = m1533a(context, "android.intent.action.MEDIA_BUTTON");
        if (componentNameM1533a != null) {
            intent.setComponent(componentNameM1533a);
            if (Build.VERSION.SDK_INT >= 26) {
                AbstractC2117c.m5075b(context, intent);
                return;
            } else {
                context.startService(intent);
                return;
            }
        }
        ComponentName componentNameM1533a2 = m1533a(context, "android.media.browse.MediaBrowserService");
        if (componentNameM1533a2 == null) {
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        Context applicationContext = context.getApplicationContext();
        C3245a c3245a = new C3245a(applicationContext, intent, pendingResultGoAsync);
        MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, componentNameM1533a2, c3245a, null);
        c3245a.f10868d = mediaBrowserCompat;
        mediaBrowserCompat.connect();
    }
}
