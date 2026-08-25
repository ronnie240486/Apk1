package p018b5;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import p099j5.C2777a;

public final class C1322v {

    public static final Object f4122g = new Object();

    public static C1322v f4123h;

    public static HandlerThread f4124i;

    public final HashMap f4125a = new HashMap();

    public final Context f4126b;

    public volatile HandlerC1731y0 f4127c;

    public final C2777a f4128d;

    public final long f4129e;

    public final long f4130f;

    public C1322v(Context context, Looper looper) {
        C1321u c1321u = new C1321u(this);
        this.f4126b = context.getApplicationContext();
        HandlerC1731y0 handlerC1731y0 = new HandlerC1731y0(looper, c1321u, 5);
        Looper.getMainLooper();
        this.f4127c = handlerC1731y0;
        if (C2777a.f9491b == null) {
            synchronized (C2777a.f9490a) {
                try {
                    if (C2777a.f9491b == null) {
                        C2777a c2777a = new C2777a();
                        new ConcurrentHashMap();
                        C2777a.f9491b = c2777a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        C2777a c2777a2 = C2777a.f9491b;
        AbstractC1312l.m3198e(c2777a2);
        this.f4128d = c2777a2;
        this.f4129e = 5000L;
        this.f4130f = 300000L;
    }

    public static HandlerThread m3205a() {
        synchronized (f4122g) {
            try {
                HandlerThread handlerThread = f4124i;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                f4124i = handlerThread2;
                handlerThread2.start();
                return f4124i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ConnectionResult m3206b(C1319s c1319s, ServiceConnectionC1316p serviceConnectionC1316p, String str) {
        synchronized (this.f4125a) {
            try {
                ServiceConnectionC1320t serviceConnectionC1320t = (ServiceConnectionC1320t) this.f4125a.get(c1319s);
                ConnectionResult connectionResultM3204a = null;
                if (serviceConnectionC1320t == null) {
                    serviceConnectionC1320t = new ServiceConnectionC1320t(this, c1319s);
                    serviceConnectionC1320t.f4114a.put(serviceConnectionC1316p, serviceConnectionC1316p);
                    connectionResultM3204a = ServiceConnectionC1320t.m3204a(serviceConnectionC1320t, str, null);
                    this.f4125a.put(c1319s, serviceConnectionC1320t);
                } else {
                    this.f4127c.removeMessages(0, c1319s);
                    if (serviceConnectionC1320t.f4114a.containsKey(serviceConnectionC1316p)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(c1319s.toString()));
                    }
                    serviceConnectionC1320t.f4114a.put(serviceConnectionC1316p, serviceConnectionC1316p);
                    int i6 = serviceConnectionC1320t.f4115b;
                    if (i6 == 1) {
                        serviceConnectionC1316p.onServiceConnected(serviceConnectionC1320t.f4119f, serviceConnectionC1320t.f4117d);
                    } else if (i6 == 2) {
                        connectionResultM3204a = ServiceConnectionC1320t.m3204a(serviceConnectionC1320t, str, null);
                    }
                }
                if (serviceConnectionC1320t.f4116c) {
                    return ConnectionResult.f4969e;
                }
                if (connectionResultM3204a == null) {
                    connectionResultM3204a = new ConnectionResult(-1);
                }
                return connectionResultM3204a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m3207c(String str, ServiceConnection serviceConnection, boolean z7) {
        C1319s c1319s = new C1319s(str, z7);
        AbstractC1312l.m3199f(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f4125a) {
            try {
                ServiceConnectionC1320t serviceConnectionC1320t = (ServiceConnectionC1320t) this.f4125a.get(c1319s);
                if (serviceConnectionC1320t == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(c1319s.toString()));
                }
                if (!serviceConnectionC1320t.f4114a.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(c1319s.toString()));
                }
                serviceConnectionC1320t.f4114a.remove(serviceConnection);
                if (serviceConnectionC1320t.f4114a.isEmpty()) {
                    this.f4127c.sendMessageDelayed(this.f4127c.obtainMessage(0, c1319s), this.f4129e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
