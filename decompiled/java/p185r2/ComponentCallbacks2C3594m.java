package p185r2;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import java.lang.ref.WeakReference;
import p002a1.C0026b;
import p025c2.C1391l;
import p108k2.C2864b;
import p120l2.InterfaceC2970g;
import p222u7.AbstractC3928d;
import p243w8.C4070l;
import p249x4.C4112e;

public final class ComponentCallbacks2C3594m implements ComponentCallbacks2 {

    public final WeakReference f12083a;

    public Context f12084b;

    public InterfaceC2970g f12085c;

    public boolean f12086d;

    public boolean f12087e = true;

    public ComponentCallbacks2C3594m(C1391l c1391l) {
        this.f12083a = new WeakReference(c1391l);
    }

    public final synchronized void m7215a() {
        C4070l c4070l;
        InterfaceC2970g c4112e;
        try {
            C1391l c1391l = (C1391l) this.f12083a.get();
            if (c1391l != null) {
                if (this.f12085c == null) {
                    if (c1391l.f4236d.f12076b) {
                        Context context = c1391l.f4233a;
                        ConnectivityManager connectivityManager = (ConnectivityManager) AbstractC3928d.m7851o(context, ConnectivityManager.class);
                        if (connectivityManager == null || AbstractC3928d.m7841b(context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
                            c4112e = new C4112e(20);
                        } else {
                            try {
                                c4112e = new C0026b(connectivityManager, this);
                            } catch (Exception unused) {
                                c4112e = new C4112e(20);
                            }
                        }
                    } else {
                        c4112e = new C4112e(20);
                    }
                    this.f12085c = c4112e;
                    this.f12087e = c4112e.mo126b();
                }
                c4070l = C4070l.f13734a;
            } else {
                c4070l = null;
            }
            if (c4070l == null) {
                m7216b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void m7216b() {
        try {
            if (this.f12086d) {
                return;
            }
            this.f12086d = true;
            Context context = this.f12084b;
            if (context != null) {
                context.unregisterComponentCallbacks(this);
            }
            InterfaceC2970g interfaceC2970g = this.f12085c;
            if (interfaceC2970g != null) {
                interfaceC2970g.shutdown();
            }
            this.f12083a.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public final synchronized void onConfigurationChanged(Configuration configuration) {
        try {
            if ((((C1391l) this.f12083a.get()) != null ? C4070l.f13734a : null) == null) {
                m7216b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public final synchronized void onLowMemory() {
        onTrimMemory(80);
    }

    @Override
    public final synchronized void onTrimMemory(int i6) {
        C4070l c4070l;
        try {
            C1391l c1391l = (C1391l) this.f12083a.get();
            if (c1391l != null) {
                C2864b c2864b = (C2864b) c1391l.f4235c.getValue();
                if (c2864b != null) {
                    c2864b.f9792a.mo226a(i6);
                    c2864b.f9793b.m3272d(i6);
                }
                c4070l = C4070l.f13734a;
            } else {
                c4070l = null;
            }
            if (c4070l == null) {
                m7216b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
