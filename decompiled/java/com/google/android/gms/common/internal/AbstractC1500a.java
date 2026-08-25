package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.appcompat.app.C0157r0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.cast.AbstractC1501a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import p005a4.C0049h;
import p018b5.AbstractC1309i;
import p018b5.AbstractC1312l;
import p018b5.BinderC1315o;
import p018b5.C1304d;
import p018b5.C1311k;
import p018b5.C1317q;
import p018b5.C1318r;
import p018b5.C1319s;
import p018b5.C1322v;
import p018b5.HandlerC1314n;
import p018b5.InterfaceC1302b;
import p018b5.InterfaceC1303c;
import p018b5.ServiceConnectionC1316p;
import p173q1.RunnableC3431n1;
import p187r4.C3624n;
import p230v4.C4005s;
import p249x4.C4109b;
import p249x4.C4110c;
import p261y4.InterfaceC4255c;
import p261y4.InterfaceC4260h;
import p261y4.InterfaceC4261i;
import p271z4.C4343n;

public abstract class AbstractC1500a implements InterfaceC4255c {

    public static final Feature[] f5068y = new Feature[0];

    public volatile String f5069a;

    public C0157r0 f5070b;

    public final Context f5071c;

    public final Looper f5072d;

    public final C1322v f5073e;

    public final HandlerC1314n f5074f;

    public final Object f5075g;

    public final Object f5076h;

    public C1311k f5077i;

    public InterfaceC1302b f5078j;

    public IInterface f5079k;

    public final ArrayList f5080l;

    public ServiceConnectionC1316p f5081m;

    public int f5082n;

    public final C1304d f5083o;

    public final C1304d f5084p;

    public final int f5085q;

    public final String f5086r;

    public volatile String f5087s;

    public ConnectionResult f5088t;

    public boolean f5089u;

    public volatile zzk f5090v;

    public final AtomicInteger f5091w;

    public final Set f5092x;

    public AbstractC1500a(Context context, Looper looper, int i6, C0049h c0049h, InterfaceC4260h interfaceC4260h, InterfaceC4261i interfaceC4261i) {
        synchronized (C1322v.f4122g) {
            try {
                if (C1322v.f4123h == null) {
                    C1322v.f4123h = new C1322v(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C1322v c1322v = C1322v.f4123h;
        Object obj = C4109b.f13932c;
        AbstractC1312l.m3198e(interfaceC4260h);
        AbstractC1312l.m3198e(interfaceC4261i);
        C1304d c1304d = new C1304d(interfaceC4260h);
        C1304d c1304d2 = new C1304d(interfaceC4261i);
        String str = (String) c0049h.f143e;
        this.f5069a = null;
        this.f5075g = new Object();
        this.f5076h = new Object();
        this.f5080l = new ArrayList();
        this.f5082n = 1;
        this.f5088t = null;
        this.f5089u = false;
        this.f5090v = null;
        this.f5091w = new AtomicInteger(0);
        AbstractC1312l.m3199f(context, "Context must not be null");
        this.f5071c = context;
        AbstractC1312l.m3199f(looper, "Looper must not be null");
        this.f5072d = looper;
        AbstractC1312l.m3199f(c1322v, "Supervisor must not be null");
        this.f5073e = c1322v;
        this.f5074f = new HandlerC1314n(this, looper);
        this.f5085q = i6;
        this.f5083o = c1304d;
        this.f5084p = c1304d2;
        this.f5086r = str;
        Set set = (Set) c0049h.f142d;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f5092x = set;
    }

    public static void m3647w(AbstractC1500a abstractC1500a) {
        int i6;
        int i10;
        synchronized (abstractC1500a.f5075g) {
            i6 = abstractC1500a.f5082n;
        }
        if (i6 == 3) {
            abstractC1500a.f5089u = true;
            i10 = 5;
        } else {
            i10 = 4;
        }
        HandlerC1314n handlerC1314n = abstractC1500a.f5074f;
        handlerC1314n.sendMessage(handlerC1314n.obtainMessage(i10, abstractC1500a.f5091w.get(), 16));
    }

    public static boolean m3648x(AbstractC1500a abstractC1500a, int i6, int i10, IInterface iInterface) {
        synchronized (abstractC1500a.f5075g) {
            try {
                if (abstractC1500a.f5082n != i6) {
                    return false;
                }
                abstractC1500a.m3670y(i10, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final Set mo3649a() {
        return mo3658k() ? this.f5092x : Collections.emptySet();
    }

    @Override
    public final void mo3650b(InterfaceC1303c interfaceC1303c, Set set) {
        Bundle bundleMo3662o = mo3662o();
        String str = Build.VERSION.SDK_INT < 31 ? this.f5087s : this.f5087s;
        int i6 = this.f5085q;
        int i10 = C4110c.f13934a;
        Scope[] scopeArr = GetServiceRequest.f5036o;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f5037p;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i6, i10, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.f5041d = this.f5071c.getPackageName();
        getServiceRequest.f5044g = bundleMo3662o;
        if (set != null) {
            getServiceRequest.f5043f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (mo3658k()) {
            getServiceRequest.f5045h = new Account("<<default account>>", "com.google");
            if (interfaceC1303c != 0) {
                getServiceRequest.f5042e = ((AbstractC1501a) interfaceC1303c).f5195d;
            }
        }
        getServiceRequest.f5046i = f5068y;
        getServiceRequest.f5047j = mo3660m();
        if (mo3669v()) {
            getServiceRequest.f5050m = true;
        }
        try {
            synchronized (this.f5076h) {
                try {
                    C1311k c1311k = this.f5077i;
                    if (c1311k != null) {
                        c1311k.m3193g(new BinderC1315o(this, this.f5091w.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (DeadObjectException e5) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e5);
            int i11 = this.f5091w.get();
            HandlerC1314n handlerC1314n = this.f5074f;
            handlerC1314n.sendMessage(handlerC1314n.obtainMessage(6, i11, 3));
        } catch (RemoteException e10) {
            e = e10;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            mo3668u(8, null, null, this.f5091w.get());
        } catch (SecurityException e11) {
            throw e11;
        } catch (RuntimeException e12) {
            e = e12;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            mo3668u(8, null, null, this.f5091w.get());
        }
    }

    @Override
    public final void mo3651c(String str) {
        this.f5069a = str;
        disconnect();
    }

    @Override
    public void disconnect() {
        this.f5091w.incrementAndGet();
        synchronized (this.f5080l) {
            try {
                int size = this.f5080l.size();
                for (int i6 = 0; i6 < size; i6++) {
                    ((AbstractC1309i) this.f5080l.get(i6)).m3189c();
                }
                this.f5080l.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f5076h) {
            this.f5077i = null;
        }
        m3670y(1, null);
    }

    @Override
    public final boolean mo3652e() {
        boolean z7;
        synchronized (this.f5075g) {
            int i6 = this.f5082n;
            z7 = true;
            if (i6 != 2 && i6 != 3) {
                z7 = false;
            }
        }
        return z7;
    }

    @Override
    public final Feature[] mo3653f() {
        zzk zzkVar = this.f5090v;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.f5108b;
    }

    @Override
    public final void mo3654g() {
        if (!isConnected() || this.f5070b == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
    }

    @Override
    public final String mo3655h() {
        return this.f5069a;
    }

    @Override
    public final void mo3656i(C3624n c3624n) {
        ((C4343n) c3624n.f12182b).f14732o.f14710m.post(new RunnableC3431n1(10, c3624n));
    }

    @Override
    public final boolean isConnected() {
        boolean z7;
        synchronized (this.f5075g) {
            z7 = this.f5082n == 4;
        }
        return z7;
    }

    @Override
    public final void mo3657j(InterfaceC1302b interfaceC1302b) {
        this.f5078j = interfaceC1302b;
        m3670y(2, null);
    }

    @Override
    public boolean mo3658k() {
        return false;
    }

    public abstract IInterface mo3659l(IBinder iBinder);

    public Feature[] mo3660m() {
        return f5068y;
    }

    public Bundle mo3661n() {
        return null;
    }

    public Bundle mo3662o() {
        return new Bundle();
    }

    public final IInterface m3663p() {
        IInterface iInterface;
        synchronized (this.f5075g) {
            try {
                if (this.f5082n == 5) {
                    throw new DeadObjectException();
                }
                if (!isConnected()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                iInterface = this.f5079k;
                AbstractC1312l.m3199f(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String mo3664q();

    public abstract String mo3665r();

    public boolean mo3666s() {
        return mo3875d() >= 211700000;
    }

    public void mo3667t(ConnectionResult connectionResult) {
        connectionResult.getClass();
        System.currentTimeMillis();
    }

    public void mo3668u(int i6, IBinder iBinder, Bundle bundle, int i10) {
        C1317q c1317q = new C1317q(this, i6, iBinder, bundle);
        HandlerC1314n handlerC1314n = this.f5074f;
        handlerC1314n.sendMessage(handlerC1314n.obtainMessage(1, i10, -1, c1317q));
    }

    public boolean mo3669v() {
        return this instanceof C4005s;
    }

    public final void m3670y(int i6, IInterface iInterface) {
        C0157r0 c0157r0;
        if ((i6 == 4) != (iInterface != null)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.f5075g) {
            try {
                this.f5082n = i6;
                this.f5079k = iInterface;
                Bundle bundle = null;
                if (i6 == 1) {
                    ServiceConnectionC1316p serviceConnectionC1316p = this.f5081m;
                    if (serviceConnectionC1316p != null) {
                        C1322v c1322v = this.f5073e;
                        String str = (String) this.f5070b.f429c;
                        AbstractC1312l.m3198e(str);
                        this.f5070b.getClass();
                        if (this.f5086r == null) {
                            this.f5071c.getClass();
                        }
                        c1322v.m3207c(str, serviceConnectionC1316p, this.f5070b.f428b);
                        this.f5081m = null;
                    }
                } else if (i6 == 2 || i6 == 3) {
                    ServiceConnectionC1316p serviceConnectionC1316p2 = this.f5081m;
                    if (serviceConnectionC1316p2 != null && (c0157r0 = this.f5070b) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + ((String) c0157r0.f429c) + " on com.google.android.gms");
                        C1322v c1322v2 = this.f5073e;
                        String str2 = (String) this.f5070b.f429c;
                        AbstractC1312l.m3198e(str2);
                        this.f5070b.getClass();
                        if (this.f5086r == null) {
                            this.f5071c.getClass();
                        }
                        c1322v2.m3207c(str2, serviceConnectionC1316p2, this.f5070b.f428b);
                        this.f5091w.incrementAndGet();
                    }
                    ServiceConnectionC1316p serviceConnectionC1316p3 = new ServiceConnectionC1316p(this, this.f5091w.get());
                    this.f5081m = serviceConnectionC1316p3;
                    String strMo3665r = mo3665r();
                    boolean zMo3666s = mo3666s();
                    this.f5070b = new C0157r0(1, strMo3665r, zMo3666s);
                    if (zMo3666s && mo3875d() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf((String) this.f5070b.f429c)));
                    }
                    C1322v c1322v3 = this.f5073e;
                    String str3 = (String) this.f5070b.f429c;
                    AbstractC1312l.m3198e(str3);
                    this.f5070b.getClass();
                    String name = this.f5086r;
                    if (name == null) {
                        name = this.f5071c.getClass().getName();
                    }
                    ConnectionResult connectionResultM3206b = c1322v3.m3206b(new C1319s(str3, this.f5070b.f428b), serviceConnectionC1316p3, name);
                    if (!(connectionResultM3206b.f4971b == 0)) {
                        Log.w("GmsClient", "unable to connect to service: " + ((String) this.f5070b.f429c) + " on com.google.android.gms");
                        int i10 = connectionResultM3206b.f4971b;
                        if (i10 == -1) {
                            i10 = 16;
                        }
                        if (connectionResultM3206b.f4972c != null) {
                            bundle = new Bundle();
                            bundle.putParcelable("pendingIntent", connectionResultM3206b.f4972c);
                        }
                        int i11 = this.f5091w.get();
                        C1318r c1318r = new C1318r(this, i10, bundle);
                        HandlerC1314n handlerC1314n = this.f5074f;
                        handlerC1314n.sendMessage(handlerC1314n.obtainMessage(7, i11, -1, c1318r));
                    }
                } else if (i6 == 4) {
                    AbstractC1312l.m3198e(iInterface);
                    System.currentTimeMillis();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
