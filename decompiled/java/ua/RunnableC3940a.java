package ua;

import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.internal.zza;
import com.google.android.gms.cast.internal.zzac;
import com.google.android.gms.cast.zzat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.internal.cast.C1602k0;
import com.google.android.gms.signin.internal.zak;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import p000a.C0016q;
import p008a9.C0080j;
import p018b5.AbstractBinderC1301a;
import p018b5.AbstractC1312l;
import p018b5.C1324x;
import p018b5.InterfaceC1303c;
import p124l6.C2982h;
import p176q4.C3477d;
import p213t9.AbstractC3855p;
import p213t9.AbstractC3865u;
import p230v4.AbstractC3987a;
import p230v4.C3988b;
import p230v4.C4008v;
import p242w5.C4058f;
import p242w5.InterfaceC4053a;
import p242w5.InterfaceC4054b;
import p242w5.InterfaceC4055c;
import p254x9.C4166h;
import p261y4.InterfaceC4255c;
import p271z4.BinderC4352w;
import p271z4.C4331b;
import p271z4.C4334e;
import p271z4.C4343n;

public final class RunnableC3940a implements Runnable {

    public final int f13238a;

    public Object f13239b;

    public final Object f13240c;

    public RunnableC3940a(int i6, Object obj, Object obj2, boolean z7) {
        this.f13238a = i6;
        this.f13240c = obj;
        this.f13239b = obj2;
    }

    private final void m7864a() {
        synchronized (((C4058f) this.f13240c).f13723b) {
            InterfaceC4054b interfaceC4054b = (InterfaceC4054b) ((C4058f) this.f13240c).f13725d;
            Exception excM7130c = ((C3477d) this.f13239b).m7130c();
            AbstractC1312l.m3198e(excM7130c);
            interfaceC4054b.mo2899a(excM7130c);
        }
    }

    private final void m7865b() {
        synchronized (((C4058f) this.f13240c).f13723b) {
            ((InterfaceC4055c) ((C4058f) this.f13240c).f13725d).onSuccess(((C3477d) this.f13239b).m7131d());
        }
    }

    @Override
    public final void run() {
        boolean z7;
        boolean z10;
        boolean z11;
        boolean z12;
        InterfaceC1303c interfaceC1303c;
        Set set;
        InterfaceC1303c c1324x = null;
        int i6 = 0;
        switch (this.f13238a) {
            case 0:
                C3948i c3948iM6049v = ((C2982h) this.f13239b).m6049v();
                if (c3948iM6049v == null) {
                    throw new IllegalStateException("No pending post available");
                }
                ((C3944e) this.f13240c).m7868c(c3948iM6049v);
                return;
            case 1:
                C3988b c3988b = C4008v.f13573S;
                zzac zzacVar = (zzac) this.f13240c;
                ApplicationMetadata applicationMetadata = zzacVar.f4959d;
                C4008v c4008v = (C4008v) this.f13239b;
                boolean zM7972e = AbstractC3987a.m7972e(applicationMetadata, c4008v.f13594z);
                C1602k0 c1602k0 = c4008v.f13577B;
                if (!zM7972e) {
                    c4008v.f13594z = applicationMetadata;
                    c1602k0.m3908e(applicationMetadata);
                }
                double d = zzacVar.f4956a;
                if (Double.isNaN(d) || Math.abs(d - c4008v.f13586K) <= 1.0E-7d) {
                    z7 = false;
                } else {
                    c4008v.f13586K = d;
                    z7 = true;
                }
                boolean z13 = c4008v.f13583H;
                boolean z14 = zzacVar.f4957b;
                if (z14 != z13) {
                    c4008v.f13583H = z14;
                    z7 = true;
                }
                Double.isNaN(zzacVar.f4962g);
                Object[] objArr = {Boolean.valueOf(z7), Boolean.valueOf(c4008v.f13585J)};
                C3988b c3988b2 = C4008v.f13573S;
                c3988b2.m7975b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", objArr);
                if (c1602k0 != null && (z7 || c4008v.f13585J)) {
                    c1602k0.m3915l();
                }
                int i10 = c4008v.f13588M;
                int i11 = zzacVar.f4958c;
                if (i11 != i10) {
                    c4008v.f13588M = i11;
                    z10 = true;
                } else {
                    z10 = false;
                }
                c3988b2.m7975b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z10), Boolean.valueOf(c4008v.f13585J));
                if (c1602k0 != null && (z10 || c4008v.f13585J)) {
                    c1602k0.m3904a(c4008v.f13588M);
                }
                int i12 = c4008v.f13589N;
                int i13 = zzacVar.f4960e;
                if (i13 != i12) {
                    c4008v.f13589N = i13;
                    z11 = true;
                } else {
                    z11 = false;
                }
                c3988b2.m7975b("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z11), Boolean.valueOf(c4008v.f13585J));
                if (c1602k0 != null && (z11 || c4008v.f13585J)) {
                    c1602k0.m3913j(c4008v.f13589N);
                }
                zzat zzatVar = c4008v.f13587L;
                zzat zzatVar2 = zzacVar.f4961f;
                if (!AbstractC3987a.m7972e(zzatVar, zzatVar2)) {
                    c4008v.f13587L = zzatVar2;
                }
                c4008v.f13585J = false;
                return;
            case 2:
                C3988b c3988b3 = C4008v.f13573S;
                String str = ((zza) this.f13240c).f4946a;
                C4008v c4008v2 = (C4008v) this.f13239b;
                if (AbstractC3987a.m7972e(str, c4008v2.f13582G)) {
                    z12 = false;
                } else {
                    c4008v2.f13582G = str;
                    z12 = true;
                }
                C4008v.f13573S.m7975b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z12), Boolean.valueOf(c4008v2.f13584I));
                C1602k0 c1602k1 = c4008v2.f13577B;
                if (c1602k1 != null && (z12 || c4008v2.f13584I)) {
                    c1602k1.m3910g();
                }
                c4008v2.f13584I = false;
                return;
            case 3:
                try {
                    ((HttpsURLConnection) this.f13239b).disconnect();
                    break;
                } catch (Exception unused) {
                }
                try {
                    ((DataOutputStream) this.f13240c).close();
                    return;
                } catch (IOException unused2) {
                    return;
                }
            case 4:
                synchronized (((C4058f) this.f13240c).f13723b) {
                    ((InterfaceC4053a) ((C4058f) this.f13240c).f13725d).mo3998b((C3477d) this.f13239b);
                    break;
                }
                return;
            case 5:
                m7864a();
                return;
            case 6:
                m7865b();
                return;
            case 7:
                break;
            case 8:
                C0016q c0016q = (C0016q) this.f13240c;
                C4343n c4343n = (C4343n) ((C4334e) c0016q.f36f).f14707j.get((C4331b) c0016q.f33c);
                if (c4343n == null) {
                    return;
                }
                ConnectionResult connectionResult = (ConnectionResult) this.f13239b;
                if ((connectionResult.f4971b == 0 ? 1 : 0) == 0) {
                    c4343n.m8379o(connectionResult, null);
                    return;
                }
                c0016q.f31a = true;
                InterfaceC4255c interfaceC4255c = (InterfaceC4255c) c0016q.f32b;
                if (interfaceC4255c.mo3658k()) {
                    if (!c0016q.f31a || (interfaceC1303c = (InterfaceC1303c) c0016q.f34d) == null) {
                        return;
                    }
                    interfaceC4255c.mo3650b(interfaceC1303c, (Set) c0016q.f35e);
                    return;
                }
                try {
                    interfaceC4255c.mo3650b(null, interfaceC4255c.mo3649a());
                    return;
                } catch (SecurityException e5) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e5);
                    interfaceC4255c.mo3651c("Failed to get service from broker.");
                    c4343n.m8379o(new ConnectionResult(10), null);
                    return;
                }
            default:
                zak zakVar = (zak) this.f13239b;
                ConnectionResult connectionResult2 = zakVar.f5775b;
                i6 = connectionResult2.f4971b == 0 ? 1 : 0;
                BinderC4352w binderC4352w = (BinderC4352w) this.f13240c;
                if (i6 != 0) {
                    zav zavVar = zakVar.f5776c;
                    AbstractC1312l.m3198e(zavVar);
                    ConnectionResult connectionResult3 = zavVar.f5099c;
                    if (connectionResult3.f4971b != 0) {
                        Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(connectionResult3)), new Exception());
                        binderC4352w.f14758j.m52e(connectionResult3);
                        binderC4352w.f14757i.disconnect();
                        return;
                    }
                    C0016q c0016q2 = binderC4352w.f14758j;
                    IBinder iBinder = zavVar.f5098b;
                    if (iBinder != null) {
                        int i14 = AbstractBinderC1301a.f4080d;
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                        c1324x = iInterfaceQueryLocalInterface instanceof InterfaceC1303c ? (InterfaceC1303c) iInterfaceQueryLocalInterface : new C1324x(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 2);
                    }
                    c0016q2.getClass();
                    if (c1324x == null || (set = binderC4352w.f14755g) == null) {
                        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                        c0016q2.m52e(new ConnectionResult(4));
                    } else {
                        c0016q2.f34d = c1324x;
                        c0016q2.f35e = set;
                        if (c0016q2.f31a) {
                            ((InterfaceC4255c) c0016q2.f32b).mo3650b(c1324x, set);
                        }
                    }
                } else {
                    binderC4352w.f14758j.m52e(connectionResult2);
                }
                binderC4352w.f14757i.disconnect();
                return;
        }
        while (true) {
            try {
                ((Runnable) this.f13239b).run();
            } catch (Throwable th) {
                AbstractC3865u.m7693h(C0080j.f206a, th);
            }
            C4166h c4166h = (C4166h) this.f13240c;
            Runnable runnableM8213h = c4166h.m8213h();
            if (runnableM8213h == null) {
                return;
            }
            this.f13239b = runnableM8213h;
            i6++;
            if (i6 >= 16) {
                AbstractC3855p abstractC3855p = c4166h.f14095c;
                if (abstractC3855p.mo7683g()) {
                    abstractC3855p.mo7665d(c4166h, this);
                    return;
                }
            }
        }
    }

    public RunnableC3940a(Object obj, int i6, Object obj2) {
        this.f13238a = i6;
        this.f13239b = obj;
        this.f13240c = obj2;
    }

    public RunnableC3940a(C3944e c3944e) {
        this.f13238a = 0;
        this.f13240c = c3944e;
        this.f13239b = new C2982h(11);
    }
}
