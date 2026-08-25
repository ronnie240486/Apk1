package p173q1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.appcompat.app.C0157r0;
import androidx.media3.common.C0628x;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.ArrayList;
import java.util.List;
import p101j7.C2782c;

public final class ServiceConnectionC3428m1 extends AbstractC3403e0 implements ServiceConnection {

    public static final int f11581q = 0;

    public final ComponentName f11582i;

    public final HandlerC1731y0 f11583j;

    public final ArrayList f11584k;

    public boolean f11585l;

    public boolean f11586m;

    public C3413h1 f11587n;

    public boolean f11588o;

    public C0628x f11589p;

    static {
        Log.isLoggable("MediaRouteProviderProxy", 3);
    }

    public ServiceConnectionC3428m1(Context context, ComponentName componentName) {
        super(context, new C2782c(27, componentName));
        this.f11584k = new ArrayList();
        this.f11582i = componentName;
        this.f11583j = new HandlerC1731y0();
    }

    @Override
    public final AbstractC3394b0 mo6902a(String str, C3400d0 c3400d0) {
        if (str == null) {
            throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
        }
        C0157r0 c0157r0 = this.f11456g;
        if (c0157r0 != null) {
            List list = (List) c0157r0.f429c;
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                if (((C3454w) list.get(i6)).m7089f().equals(str)) {
                    C3422k1 c3422k1 = new C3422k1(this, str, c3400d0);
                    this.f11584k.add(c3422k1);
                    if (this.f11588o) {
                        c3422k1.mo6962b(this.f11587n);
                    }
                    m7007l();
                    return c3422k1;
                }
            }
        }
        return null;
    }

    @Override
    public final AbstractC3397c0 mo6904c(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        if (str2 != null) {
            return m7004i(str, str2, C3400d0.f11443b);
        }
        throw new IllegalArgumentException("routeGroupId cannot be null");
    }

    @Override
    public final AbstractC3397c0 mo6905d(String str, C3400d0 c3400d0) {
        if (str != null) {
            return m7004i(str, null, c3400d0);
        }
        throw new IllegalArgumentException("routeId cannot be null");
    }

    @Override
    public final void mo6906e(C3456x c3456x) {
        if (this.f11588o) {
            C3413h1 c3413h1 = this.f11587n;
            int i6 = c3413h1.f11519d;
            c3413h1.f11519d = i6 + 1;
            c3413h1.m6955b(10, i6, 0, c3456x != null ? c3456x.f11706a : null, null);
        }
        m7007l();
    }

    public final void m7003h() {
        if (this.f11586m) {
            return;
        }
        Intent intent = new Intent("android.media.MediaRouteProviderService");
        intent.setComponent(this.f11582i);
        try {
            this.f11586m = this.f11450a.bindService(intent, this, Build.VERSION.SDK_INT >= 29 ? 4097 : 1);
        } catch (SecurityException unused) {
        }
    }

    public final C3425l1 m7004i(String str, String str2, C3400d0 c3400d0) {
        C0157r0 c0157r0 = this.f11456g;
        if (c0157r0 == null) {
            return null;
        }
        List list = (List) c0157r0.f429c;
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (((C3454w) list.get(i6)).m7089f().equals(str)) {
                C3425l1 c3425l1 = new C3425l1(this, str, str2, c3400d0);
                this.f11584k.add(c3425l1);
                if (this.f11588o) {
                    c3425l1.mo6962b(this.f11587n);
                }
                m7007l();
                return c3425l1;
            }
        }
        return null;
    }

    public final void m7005j() {
        if (this.f11587n != null) {
            m6907f(null);
            this.f11588o = false;
            ArrayList arrayList = this.f11584k;
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((InterfaceC3416i1) arrayList.get(i6)).mo6963c();
            }
            C3413h1 c3413h1 = this.f11587n;
            c3413h1.m6955b(2, 0, 0, null, null);
            c3413h1.f11517b.f285b.clear();
            c3413h1.f11516a.getBinder().unlinkToDeath(c3413h1, 0);
            c3413h1.f11524i.f11583j.post(new RunnableC3410g1(c3413h1, 0));
            this.f11587n = null;
        }
    }

    public final void m7006k() {
        if (this.f11586m) {
            this.f11586m = false;
            m7005j();
            try {
                this.f11450a.unbindService(this);
            } catch (IllegalArgumentException e5) {
                Log.e("MediaRouteProviderProxy", this + ": unbindService failed", e5);
            }
        }
    }

    public final void m7007l() {
        if (!this.f11585l || (this.f11454e == null && this.f11584k.isEmpty())) {
            m7006k();
        } else {
            m7003h();
        }
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f11586m) {
            m7005j();
            Messenger messenger = iBinder != null ? new Messenger(iBinder) : null;
            if (messenger != null) {
                try {
                    if (messenger.getBinder() != null) {
                        C3413h1 c3413h1 = new C3413h1(this, messenger);
                        int i6 = c3413h1.f11519d;
                        c3413h1.f11519d = i6 + 1;
                        c3413h1.f11522g = i6;
                        if (c3413h1.m6955b(1, i6, 4, null, null)) {
                            try {
                                c3413h1.f11516a.getBinder().linkToDeath(c3413h1, 0);
                                this.f11587n = c3413h1;
                                return;
                            } catch (RemoteException unused) {
                                c3413h1.binderDied();
                                return;
                            }
                        }
                        return;
                    }
                } catch (NullPointerException unused2) {
                }
            }
            Log.e("MediaRouteProviderProxy", this + ": Service returned invalid messenger binder");
        }
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
        m7005j();
    }

    public final String toString() {
        return "Service connection " + this.f11582i.flattenToShortString();
    }
}
