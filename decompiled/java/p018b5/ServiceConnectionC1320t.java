package p018b5;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import com.google.android.gms.common.ConnectionResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import p111k5.AbstractC2892b;

public final class ServiceConnectionC1320t implements ServiceConnection {

    public final HashMap f4114a = new HashMap();

    public int f4115b = 2;

    public boolean f4116c;

    public IBinder f4117d;

    public final C1319s f4118e;

    public ComponentName f4119f;

    public final C1322v f4120g;

    public ServiceConnectionC1320t(C1322v c1322v, C1319s c1319s) {
        this.f4120g = c1322v;
        this.f4118e = c1319s;
    }

    public static ConnectionResult m3204a(ServiceConnectionC1320t serviceConnectionC1320t, String str, Executor executor) {
        ConnectionResult connectionResult;
        try {
            Intent intentM3203a = serviceConnectionC1320t.f4118e.m3203a(serviceConnectionC1320t.f4120g.f4126b);
            serviceConnectionC1320t.f4115b = 3;
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            if (Build.VERSION.SDK_INT >= 31) {
                StrictMode.setVmPolicy(AbstractC2892b.m5896a(new StrictMode.VmPolicy.Builder(vmPolicy)).build());
            }
            try {
                C1322v c1322v = serviceConnectionC1320t.f4120g;
                boolean zM5748b = c1322v.f4128d.m5748b(c1322v.f4126b, str, intentM3203a, serviceConnectionC1320t, executor);
                serviceConnectionC1320t.f4116c = zM5748b;
                if (zM5748b) {
                    serviceConnectionC1320t.f4120g.f4127c.sendMessageDelayed(serviceConnectionC1320t.f4120g.f4127c.obtainMessage(1, serviceConnectionC1320t.f4118e), serviceConnectionC1320t.f4120g.f4130f);
                    connectionResult = ConnectionResult.f4969e;
                } else {
                    serviceConnectionC1320t.f4115b = 2;
                    try {
                        C1322v c1322v2 = serviceConnectionC1320t.f4120g;
                        c1322v2.f4128d.m5747a(c1322v2.f4126b, serviceConnectionC1320t);
                    } catch (IllegalArgumentException unused) {
                    }
                    connectionResult = new ConnectionResult(16);
                }
                return connectionResult;
            } finally {
                StrictMode.setVmPolicy(vmPolicy);
            }
        } catch (C1313m e5) {
            return e5.f4101a;
        }
    }

    @Override
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f4120g.f4125a) {
            try {
                this.f4120g.f4127c.removeMessages(1, this.f4118e);
                this.f4117d = iBinder;
                this.f4119f = componentName;
                Iterator it = this.f4114a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f4115b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f4120g.f4125a) {
            try {
                this.f4120g.f4127c.removeMessages(1, this.f4118e);
                this.f4117d = null;
                this.f4119f = componentName;
                Iterator it = this.f4114a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f4115b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
