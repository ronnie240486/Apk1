package p099j5;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import p018b5.ServiceConnectionC1320t;
import p123l5.C2974b;

public final class C2777a {

    public static final Object f9490a = new Object();

    public static volatile C2777a f9491b;

    public final void m5747a(Context context, ServiceConnectionC1320t serviceConnectionC1320t) {
        try {
            context.unbindService(serviceConnectionC1320t);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    public final boolean m5748b(Context context, String str, Intent intent, ServiceConnectionC1320t serviceConnectionC1320t, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((C2974b.m6025a(context).f155b.getPackageManager().getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (executor == null) {
            executor = null;
        }
        return (Build.VERSION.SDK_INT < 29 || executor == null) ? context.bindService(intent, serviceConnectionC1320t, 4225) : context.bindService(intent, 4225, executor, serviceConnectionC1320t);
    }
}
