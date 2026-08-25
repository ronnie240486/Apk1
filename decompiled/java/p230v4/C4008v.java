package p230v4;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.leanback.widget.C0486o;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.zzat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.internal.AbstractC1500a;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.google.android.gms.internal.cast.C1602k0;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import p005a4.C0049h;
import p018b5.AbstractC1312l;
import p271z4.C4343n;

public final class C4008v extends AbstractC1500a {

    public static final C3988b f13573S = new C3988b("CastClientImpl", null);

    public static final Object f13574T = new Object();

    public static final Object f13575U = new Object();

    public final CastDevice f13576A;

    public final C1602k0 f13577B;

    public final HashMap f13578C;

    public final long f13579D;

    public final Bundle f13580E;

    public BinderC4007u f13581F;

    public String f13582G;

    public boolean f13583H;

    public boolean f13584I;

    public boolean f13585J;

    public double f13586K;

    public zzat f13587L;

    public int f13588M;

    public int f13589N;

    public String f13590O;

    public String f13591P;

    public Bundle f13592Q;

    public final HashMap f13593R;

    public ApplicationMetadata f13594z;

    public C4008v(Context context, Looper looper, C0049h c0049h, CastDevice castDevice, long j10, C1602k0 c1602k0, Bundle bundle, C4343n c4343n, C4343n c4343n2) {
        super(context, looper, 10, c0049h, c4343n, c4343n2);
        this.f13576A = castDevice;
        this.f13577B = c1602k0;
        this.f13579D = j10;
        this.f13580E = bundle;
        this.f13578C = new HashMap();
        new AtomicLong(0L);
        this.f13593R = new HashMap();
        this.f13588M = -1;
        this.f13589N = -1;
        this.f13594z = null;
        this.f13582G = null;
        this.f13586K = 0.0d;
        m8004B();
        this.f13583H = false;
        this.f13587L = null;
        m8004B();
    }

    public static void m8002z(C4008v c4008v, long j10) {
        HashMap map = c4008v.f13593R;
        synchronized (map) {
            try {
                if (map.remove(Long.valueOf(j10)) != null) {
                    throw new ClassCastException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m8003A() {
        f13573S.m7975b("removing all MessageReceivedCallbacks", new Object[0]);
        HashMap map = this.f13578C;
        synchronized (map) {
            map.clear();
        }
    }

    public final void m8004B() {
        CastDevice castDevice = this.f13576A;
        AbstractC1312l.m3199f(castDevice, "device should not be null");
        C0486o c0486o = castDevice.f4608i;
        if (c0486o.m1446a(2048) || !c0486o.m1446a(4) || c0486o.m1446a(1)) {
            return;
        }
        "Chromecast Audio".equals(castDevice.f4604e);
    }

    @Override
    public final int mo3875d() {
        return 12800000;
    }

    @Override
    public final void disconnect() {
        Object[] objArr = {this.f13581F, Boolean.valueOf(isConnected())};
        C3988b c3988b = f13573S;
        c3988b.m7975b("disconnect(); ServiceListener=%s, isConnected=%b", objArr);
        BinderC4007u binderC4007u = this.f13581F;
        C4008v c4008v = null;
        this.f13581F = null;
        if (binderC4007u != null) {
            C4008v c4008v2 = (C4008v) binderC4007u.f13571d.getAndSet(null);
            if (c4008v2 != null) {
                c4008v2.f13588M = -1;
                c4008v2.f13589N = -1;
                c4008v2.f13594z = null;
                c4008v2.f13582G = null;
                c4008v2.f13586K = 0.0d;
                c4008v2.m8004B();
                c4008v2.f13583H = false;
                c4008v2.f13587L = null;
                c4008v = c4008v2;
            }
            if (c4008v != null) {
                m8003A();
                try {
                    try {
                        C3990d c3990d = (C3990d) m3663p();
                        ApiMetadata apiMetadata = new ApiMetadata(new ComplianceOptions(-1, -1, 0, true));
                        Parcel parcelM3687l = c3990d.m3687l();
                        AbstractC1542e0.m3809c(parcelM3687l, apiMetadata);
                        c3990d.m3690y(parcelM3687l, 1);
                    } finally {
                        super.disconnect();
                    }
                } catch (RemoteException | IllegalStateException e5) {
                    c3988b.m7974a(e5, "Error while disconnecting the controller interface", new Object[0]);
                }
                return;
            }
        }
        c3988b.m7975b("already disposed, so short-circuiting", new Object[0]);
    }

    @Override
    public final IInterface mo3659l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        return iInterfaceQueryLocalInterface instanceof C3990d ? (C3990d) iInterfaceQueryLocalInterface : new C3990d(iBinder);
    }

    @Override
    public final Bundle mo3661n() {
        Bundle bundle = this.f13592Q;
        if (bundle == null) {
            return null;
        }
        this.f13592Q = null;
        return bundle;
    }

    @Override
    public final Bundle mo3662o() {
        Bundle bundle = new Bundle();
        f13573S.m7975b("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.f13590O, this.f13591P);
        CastDevice castDevice = this.f13576A;
        castDevice.getClass();
        bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", castDevice);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.f13579D);
        Bundle bundle2 = this.f13580E;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        BinderC4007u binderC4007u = new BinderC4007u(this);
        this.f13581F = binderC4007u;
        bundle.putParcelable("listener", new BinderWrapper(binderC4007u));
        String str = this.f13590O;
        if (str != null) {
            bundle.putString("last_application_id", str);
            String str2 = this.f13591P;
            if (str2 != null) {
                bundle.putString("last_session_id", str2);
            }
        }
        return bundle;
    }

    @Override
    public final String mo3664q() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    @Override
    public final String mo3665r() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    @Override
    public final void mo3667t(ConnectionResult connectionResult) {
        super.mo3667t(connectionResult);
        m8003A();
    }

    @Override
    public final void mo3668u(int i6, IBinder iBinder, Bundle bundle, int i10) {
        f13573S.m7975b("in onPostInitHandler; statusCode=%d", Integer.valueOf(i6));
        if (i6 == 0 || i6 == 2300) {
            this.f13584I = true;
            this.f13585J = true;
        }
        if (i6 == 2300) {
            Bundle bundle2 = new Bundle();
            this.f13592Q = bundle2;
            bundle2.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            i6 = 0;
        }
        super.mo3668u(i6, iBinder, bundle, i10);
    }
}
