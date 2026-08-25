package com.google.android.gms.internal.cast;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.mediarouter.app.AbstractC1115t0;
import com.google.android.gms.cast.CastDevice;
import java.util.ArrayList;
import java.util.Collections;
import p018b5.AbstractC1312l;
import p101j7.C2782c;
import p173q1.AbstractC3427m0;
import p173q1.C3435p;
import p173q1.C3440q1;
import p173q1.C3443r1;
import p173q1.C3445s0;
import p173q1.C3446s1;
import p173q1.C3451u0;
import p176q4.C3475c;
import p176q4.C3482h;
import p230v4.AbstractC3987a;
import p230v4.C3988b;

public final class C1649p extends AbstractC3427m0 {

    public static final C3988b f5528d = new C3988b("MediaRouterCallback", null);

    public final C1621m f5529a;

    public final BinderC1703v f5530b;

    public final C1730y f5531c;

    public C1649p(C1621m c1621m, BinderC1703v binderC1703v, C1730y c1730y) {
        AbstractC1312l.m3198e(c1621m);
        this.f5529a = c1621m;
        this.f5530b = binderC1703v;
        this.f5531c = c1730y;
    }

    @Override
    public final void mo2753d(C3451u0 c3451u0, C3445s0 c3445s0) {
        try {
            C1621m c1621m = this.f5529a;
            String str = c3445s0.f11654c;
            Bundle bundle = c3445s0.f11670s;
            Parcel parcelM3687l = c1621m.m3687l();
            parcelM3687l.writeString(str);
            AbstractC1542e0.m3809c(parcelM3687l, bundle);
            c1621m.m3689x(parcelM3687l, 1);
        } catch (RemoteException e5) {
            f5528d.m7974a(e5, "Unable to call %s on %s.", "onRouteAdded", C1621m.class.getSimpleName());
        }
        m3967o(c3451u0);
    }

    @Override
    public final void mo2754e(C3451u0 c3451u0, C3445s0 c3445s0) {
        if (c3445s0.m7024g()) {
            try {
                C1621m c1621m = this.f5529a;
                String str = c3445s0.f11654c;
                Bundle bundle = c3445s0.f11670s;
                Parcel parcelM3687l = c1621m.m3687l();
                parcelM3687l.writeString(str);
                AbstractC1542e0.m3809c(parcelM3687l, bundle);
                c1621m.m3689x(parcelM3687l, 2);
            } catch (RemoteException e5) {
                f5528d.m7974a(e5, "Unable to call %s on %s.", "onRouteChanged", C1621m.class.getSimpleName());
            }
            m3967o(c3451u0);
        }
    }

    @Override
    public final void mo3963f(C3445s0 c3445s0, C3445s0 c3445s1) {
        int i6 = c3445s0.f11663l;
        C3988b c3988b = f5528d;
        String str = c3445s0.f11654c;
        if (i6 != 1) {
            Log.i(c3988b.f13521a, c3988b.m7977d("ignore onRouteConnected for non-remote connected routeId: %s", str));
            return;
        }
        Log.i(c3988b.f13521a, c3988b.m7977d("onRouteConnected with connectedRouteId = %s", str));
        this.f5530b.f5698k = true;
        try {
            C1621m c1621m = this.f5529a;
            Parcel parcelM3688w = c1621m.m3688w(c1621m.m3687l(), 7);
            int i10 = parcelM3688w.readInt();
            parcelM3688w.recycle();
            String str2 = c3445s1.f11654c;
            if (i10 >= 251600000) {
                Bundle bundle = c3445s0.f11670s;
                Parcel parcelM3687l = c1621m.m3687l();
                parcelM3687l.writeString(str2);
                parcelM3687l.writeString(str);
                AbstractC1542e0.m3809c(parcelM3687l, bundle);
                c1621m.m3689x(parcelM3687l, 9);
                return;
            }
            Bundle bundle2 = c3445s0.f11670s;
            Parcel parcelM3687l2 = c1621m.m3687l();
            parcelM3687l2.writeString(str2);
            parcelM3687l2.writeString(str);
            AbstractC1542e0.m3809c(parcelM3687l2, bundle2);
            c1621m.m3689x(parcelM3687l2, 8);
        } catch (RemoteException e5) {
            c3988b.m7974a(e5, "Unable to call %s on %s.", "onRouteConnected", C1621m.class.getSimpleName());
        }
    }

    @Override
    public final void mo3964g(C3445s0 c3445s0, C3445s0 c3445s1, int i6) {
        C3988b c3988b = f5528d;
        if (c3445s0 == null || c3445s0.f11663l != 1) {
            Log.i(c3988b.f13521a, c3988b.m7977d("ignore onRouteDisconnected for invalid or non-remote disconnected route", new Object[0]));
            return;
        }
        Integer numValueOf = Integer.valueOf(i6);
        String str = c3445s0.f11654c;
        String str2 = c3445s1.f11654c;
        Log.i(c3988b.f13521a, c3988b.m7977d("onRouteDisconnected with disconnectedRouteId = %s, requestedRouteId = %s, reason = %d", str, str2, numValueOf));
        this.f5530b.f5698k = false;
        try {
            C1621m c1621m = this.f5529a;
            Parcel parcelM3688w = c1621m.m3688w(c1621m.m3687l(), 7);
            int i10 = parcelM3688w.readInt();
            parcelM3688w.recycle();
            if (i10 < 251600000) {
                Bundle bundle = c3445s0.f11670s;
                Parcel parcelM3687l = c1621m.m3687l();
                parcelM3687l.writeString(str);
                AbstractC1542e0.m3809c(parcelM3687l, bundle);
                parcelM3687l.writeInt(i6);
                c1621m.m3689x(parcelM3687l, 6);
                return;
            }
            Bundle bundle2 = c3445s0.f11670s;
            Parcel parcelM3687l2 = c1621m.m3687l();
            parcelM3687l2.writeString(str2);
            parcelM3687l2.writeString(str);
            AbstractC1542e0.m3809c(parcelM3687l2, bundle2);
            parcelM3687l2.writeInt(i6);
            c1621m.m3689x(parcelM3687l2, 10);
        } catch (RemoteException e5) {
            c3988b.m7974a(e5, "Unable to call %s on %s.", "onRouteDisconnected", C1621m.class.getSimpleName());
        }
    }

    @Override
    public final void mo2755h(C3451u0 c3451u0, C3445s0 c3445s0) {
        try {
            C1621m c1621m = this.f5529a;
            String str = c3445s0.f11654c;
            Bundle bundle = c3445s0.f11670s;
            Parcel parcelM3687l = c1621m.m3687l();
            parcelM3687l.writeString(str);
            AbstractC1542e0.m3809c(parcelM3687l, bundle);
            c1621m.m3689x(parcelM3687l, 3);
        } catch (RemoteException e5) {
            f5528d.m7974a(e5, "Unable to call %s on %s.", "onRouteRemoved", C1621m.class.getSimpleName());
        }
        m3967o(c3451u0);
    }

    @Override
    public final void mo3965j(C3451u0 c3451u0, C3445s0 c3445s0, int i6, C3445s0 c3445s1) {
        int i10 = c3445s0.f11663l;
        C3988b c3988b = f5528d;
        String str = c3445s0.f11654c;
        if (i10 != 1) {
            Log.i(c3988b.f13521a, c3988b.m7977d("ignore onRouteSelected for non-remote selected routeId: %s", str));
            return;
        }
        Log.i(c3988b.f13521a, c3988b.m7977d("onRouteSelected with reason = %d, routeId = %s", Integer.valueOf(i6), str));
        try {
            C1621m c1621m = this.f5529a;
            Parcel parcelM3688w = c1621m.m3688w(c1621m.m3687l(), 7);
            int i11 = parcelM3688w.readInt();
            parcelM3688w.recycle();
            if (i11 >= 220400000) {
                String str2 = c3445s1.f11654c;
                Bundle bundle = c3445s0.f11670s;
                Parcel parcelM3687l = c1621m.m3687l();
                parcelM3687l.writeString(str2);
                parcelM3687l.writeString(str);
                AbstractC1542e0.m3809c(parcelM3687l, bundle);
                c1621m.m3689x(parcelM3687l, 8);
            } else {
                String str3 = c3445s1.f11654c;
                Bundle bundle2 = c3445s0.f11670s;
                Parcel parcelM3687l2 = c1621m.m3687l();
                parcelM3687l2.writeString(str3);
                AbstractC1542e0.m3809c(parcelM3687l2, bundle2);
                c1621m.m3689x(parcelM3687l2, 4);
            }
        } catch (RemoteException e5) {
            c3988b.m7974a(e5, "Unable to call %s on %s.", "onRouteSelected", C1621m.class.getSimpleName());
        }
        m3967o(c3451u0);
    }

    @Override
    public final void mo3966l(C3451u0 c3451u0, C3445s0 c3445s0, int i6) {
        int i10 = c3445s0.f11663l;
        C3988b c3988b = f5528d;
        String str = c3445s0.f11654c;
        if (i10 != 1) {
            Log.i(c3988b.f13521a, c3988b.m7977d("ignore onRouteUnselected for non-remote routeId: %s", str));
            return;
        }
        Log.i(c3988b.f13521a, c3988b.m7977d("onRouteUnselected with reason = %d, routeId = %s", Integer.valueOf(i6), str));
        try {
            C1621m c1621m = this.f5529a;
            Bundle bundle = c3445s0.f11670s;
            Parcel parcelM3687l = c1621m.m3687l();
            parcelM3687l.writeString(str);
            AbstractC1542e0.m3809c(parcelM3687l, bundle);
            parcelM3687l.writeInt(i6);
            c1621m.m3689x(parcelM3687l, 6);
        } catch (RemoteException e5) {
            c3988b.m7974a(e5, "Unable to call %s on %s.", "onRouteUnselected", C1621m.class.getSimpleName());
        }
        m3967o(c3451u0);
    }

    public final void m3967o(C3451u0 c3451u0) {
        boolean zM7972e;
        C1730y c1730y = this.f5531c;
        if (c1730y != null && c1730y.f5732e && c1730y.f5728a.f4779q) {
            C3482h c3482h = c1730y.f5733f;
            C3475c c3475cM7142c = c3482h != null ? c3482h.m7142c() : null;
            CastDevice castDeviceM7124e = c3475cM7142c != null ? c3475cM7142c.m7124e() : null;
            if (castDeviceM7124e != null) {
                ArrayList arrayList = new ArrayList();
                c3451u0.getClass();
                C3451u0.m7067b();
                for (C3445s0 c3445s0 : C3451u0.m7068c().f11496i) {
                    CastDevice castDeviceM3584l = CastDevice.m3584l(c3445s0.f11670s);
                    if (castDeviceM3584l != null) {
                        if (TextUtils.isEmpty(castDeviceM3584l.m3585j()) || castDeviceM3584l.m3585j().startsWith("__cast_ble__") || TextUtils.isEmpty(castDeviceM7124e.m3585j()) || castDeviceM7124e.m3585j().startsWith("__cast_ble__")) {
                            String str = castDeviceM3584l.f4613n;
                            if (TextUtils.isEmpty(str)) {
                                zM7972e = false;
                            } else {
                                String str2 = castDeviceM7124e.f4613n;
                                if (TextUtils.isEmpty(str2)) {
                                    zM7972e = false;
                                } else {
                                    zM7972e = AbstractC3987a.m7972e(str, str2);
                                }
                            }
                        } else {
                            zM7972e = AbstractC3987a.m7972e(castDeviceM3584l.m3585j(), castDeviceM7124e.m3585j());
                        }
                        if (zM7972e) {
                            continue;
                        } else {
                            String str3 = c3445s0.f11654c;
                            C3440q1 c3440q1 = new C3440q1();
                            if (TextUtils.isEmpty(str3)) {
                                throw new IllegalArgumentException();
                            }
                            c3440q1.f11640b = str3;
                            c3440q1.f11639a = 1;
                            arrayList.add(new C3443r1(c3440q1));
                        }
                    }
                }
                C1730y.f5727g.m7975b("updateRouteListingPreference with %d available routes", Integer.valueOf(arrayList.size()));
                C2782c c2782c = new C2782c(29, false);
                c2782c.f9501b = Collections.emptyList();
                c2782c.f9501b = Collections.unmodifiableList(new ArrayList(arrayList));
                C3446s1 c3446s1 = new C3446s1(c2782c);
                C3451u0.m7067b();
                C3435p c3435p = C3451u0.m7068c().f11505r;
                if (c3435p == null || Build.VERSION.SDK_INT < 34) {
                    return;
                }
                AbstractC1115t0.m2787f(c3435p.f11610i, AbstractC1115t0.m2789h(c3446s1));
            }
        }
    }
}
