package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.util.Log;
import androidx.appcompat.widget.RunnableC0261r0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p132m5.BinderC3079b;
import p173q1.AbstractC3427m0;
import p173q1.C3411h;
import p173q1.C3424l0;
import p173q1.C3445s0;
import p173q1.C3451u0;
import p173q1.C3457x0;
import p230v4.C3988b;

public abstract class AbstractBinderC1611l extends AbstractBinderC1694u {

    public final int f5394d;

    public AbstractBinderC1611l(String str, int i6) {
        super(str, 0);
        this.f5394d = i6;
    }

    @Override
    public final boolean mo3202w(int i6, Parcel parcel, Parcel parcel2) {
        int i10 = 3;
        int i11 = 2;
        int i12 = 0;
        switch (this.f5394d) {
            case 0:
                C1621m c1621m = null;
                Bundle bundle = null;
                switch (i6) {
                    case 1:
                        Bundle bundle2 = (Bundle) AbstractC1542e0.m3807a(parcel, Bundle.CREATOR);
                        IBinder strongBinder = parcel.readStrongBinder();
                        if (strongBinder != null) {
                            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.internal.IMediaRouterCallback");
                            c1621m = iInterfaceQueryLocalInterface instanceof C1621m ? (C1621m) iInterfaceQueryLocalInterface : new C1621m(strongBinder, "com.google.android.gms.cast.framework.internal.IMediaRouterCallback", 0);
                        }
                        AbstractC1542e0.m3808b(parcel);
                        BinderC1703v binderC1703v = (BinderC1703v) this;
                        C3424l0 c3424l0M6999b = C3424l0.m6999b(bundle2);
                        if (c3424l0M6999b != null) {
                            HashMap map = binderC1703v.f5694g;
                            if (!map.containsKey(c3424l0M6999b)) {
                                map.put(c3424l0M6999b, new HashSet());
                            }
                            ((Set) map.get(c3424l0M6999b)).add(new C1649p(c1621m, binderC1703v, binderC1703v.f5695h));
                        }
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        Bundle bundle3 = (Bundle) AbstractC1542e0.m3807a(parcel, Bundle.CREATOR);
                        int i13 = parcel.readInt();
                        AbstractC1542e0.m3808b(parcel);
                        BinderC1703v binderC1703v2 = (BinderC1703v) this;
                        C3424l0 c3424l0M6999b2 = C3424l0.m6999b(bundle3);
                        if (c3424l0M6999b2 != null) {
                            if (Looper.myLooper() == Looper.getMainLooper()) {
                                binderC1703v2.m4031z(c3424l0M6999b2, i13);
                            } else {
                                new HandlerC1731y0(Looper.getMainLooper(), 0).post(new RunnableC0261r0(binderC1703v2, c3424l0M6999b2, i13, i10));
                            }
                        }
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        Bundle bundle4 = (Bundle) AbstractC1542e0.m3807a(parcel, Bundle.CREATOR);
                        AbstractC1542e0.m3808b(parcel);
                        BinderC1703v binderC1703v3 = (BinderC1703v) this;
                        C3424l0 c3424l0M6999b3 = C3424l0.m6999b(bundle4);
                        if (c3424l0M6999b3 != null) {
                            if (Looper.myLooper() == Looper.getMainLooper()) {
                                binderC1703v3.m4028A(c3424l0M6999b3);
                            } else {
                                new HandlerC1731y0(Looper.getMainLooper(), 0).post(new RunnableC1631n(binderC1703v3, i11, c3424l0M6999b3));
                            }
                        }
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        Bundle bundle5 = (Bundle) AbstractC1542e0.m3807a(parcel, Bundle.CREATOR);
                        int i14 = parcel.readInt();
                        AbstractC1542e0.m3808b(parcel);
                        BinderC1703v binderC1703v4 = (BinderC1703v) this;
                        C3424l0 c3424l0M6999b4 = C3424l0.m6999b(bundle5);
                        if (c3424l0M6999b4 != null) {
                            binderC1703v4.f5692e.getClass();
                            C3451u0.m7067b();
                            C3411h c3411hM7068c = C3451u0.m7068c();
                            c3411hM7068c.getClass();
                            if (!c3424l0M6999b4.m7002d()) {
                                if ((i14 & 2) == 0 && c3411hM7068c.f11503p) {
                                    i12 = 1;
                                } else {
                                    C3457x0 c3457x0 = c3411hM7068c.f11508u;
                                    boolean z7 = c3457x0 != null && c3457x0.f11709b && c3411hM7068c.m6941h();
                                    ArrayList arrayList = c3411hM7068c.f11496i;
                                    int size = arrayList.size();
                                    for (int i15 = 0; i15 < size; i15++) {
                                        C3445s0 c3445s0 = (C3445s0) arrayList.get(i15);
                                        if (((i14 & 1) == 0 || !c3445s0.m7021d()) && ((!z7 || c3445s0.m7021d() || c3445s0.m7020c() == c3411hM7068c.f11505r) && c3445s0.m7025h(c3424l0M6999b4))) {
                                            i12 = 1;
                                        }
                                    }
                                }
                            }
                        }
                        parcel2.writeNoException();
                        parcel2.writeInt(i12);
                        return true;
                    case 5:
                        String string = parcel.readString();
                        AbstractC1542e0.m3808b(parcel);
                        C3988b c3988b = BinderC1703v.f5691l;
                        c3988b.m7975b("select route with routeId = %s", string);
                        ((BinderC1703v) this).f5692e.getClass();
                        C3451u0.m7067b();
                        for (C3445s0 c3445s1 : C3451u0.m7068c().f11496i) {
                            if (c3445s1.f11654c.equals(string)) {
                                c3988b.m7975b("media route is found and selected", new Object[0]);
                                c3445s1.m7029l(true);
                                parcel2.writeNoException();
                                return true;
                            }
                        }
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        ((BinderC1703v) this).f5692e.getClass();
                        C3451u0.m7067b();
                        C3445s0 c3445s2 = C3451u0.m7068c().f11509v;
                        if (c3445s2 == null) {
                            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
                        }
                        c3445s2.m7029l(true);
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        ((BinderC1703v) this).f5692e.getClass();
                        C3451u0.m7067b();
                        C3445s0 c3445s3 = C3451u0.m7068c().f11509v;
                        if (c3445s3 == null) {
                            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
                        }
                        boolean zEquals = C3451u0.m7071f().f11654c.equals(c3445s3.f11654c);
                        parcel2.writeNoException();
                        int i16 = AbstractC1542e0.f5277a;
                        parcel2.writeInt(zEquals ? 1 : 0);
                        return true;
                    case 8:
                        String string2 = parcel.readString();
                        AbstractC1542e0.m3808b(parcel);
                        ((BinderC1703v) this).f5692e.getClass();
                        C3451u0.m7067b();
                        for (C3445s0 c3445s4 : C3451u0.m7068c().f11496i) {
                            if (c3445s4.f11654c.equals(string2)) {
                                bundle = c3445s4.f11670s;
                                parcel2.writeNoException();
                                if (bundle == null) {
                                    parcel2.writeInt(0);
                                    return true;
                                }
                                parcel2.writeInt(1);
                                bundle.writeToParcel(parcel2, 1);
                                return true;
                            }
                        }
                        parcel2.writeNoException();
                        if (bundle == null) {
                            parcel2.writeInt(0);
                            return true;
                        }
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                        return true;
                    case 9:
                        ((BinderC1703v) this).f5692e.getClass();
                        String str = C3451u0.m7071f().f11654c;
                        parcel2.writeNoException();
                        parcel2.writeString(str);
                        return true;
                    case 10:
                        parcel2.writeNoException();
                        parcel2.writeInt(12451000);
                        return true;
                    case 11:
                        BinderC1703v binderC1703v5 = (BinderC1703v) this;
                        HashMap map2 = binderC1703v5.f5694g;
                        Iterator it = map2.values().iterator();
                        while (it.hasNext()) {
                            Iterator it2 = ((Set) it.next()).iterator();
                            while (it2.hasNext()) {
                                binderC1703v5.f5692e.m7075h((AbstractC3427m0) it2.next());
                            }
                        }
                        map2.clear();
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        ((BinderC1703v) this).f5692e.getClass();
                        C3451u0.m7067b();
                        C3445s0 c3445s5 = C3451u0.m7068c().f11510w;
                        if (c3445s5 != null && C3451u0.m7071f().f11654c.equals(c3445s5.f11654c)) {
                            i12 = 1;
                        }
                        parcel2.writeNoException();
                        int i17 = AbstractC1542e0.f5277a;
                        parcel2.writeInt(i12);
                        return true;
                    case 13:
                        int i18 = parcel.readInt();
                        AbstractC1542e0.m3808b(parcel);
                        ((BinderC1703v) this).f5692e.getClass();
                        C3451u0.m7073i(i18);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return false;
                }
            default:
                if (i6 == 1) {
                    BinderC3079b binderC3079b = new BinderC3079b((BinderC1571h) this);
                    parcel2.writeNoException();
                    AbstractC1542e0.m3810d(parcel2, binderC3079b);
                    return true;
                }
                if (i6 == 2) {
                    BinderC1571h binderC1571h = (BinderC1571h) this;
                    C3988b c3988b2 = BinderC1571h.f5329g;
                    Log.i(c3988b2.f13521a, c3988b2.m7977d("onAppEnteredForeground", new Object[0]));
                    binderC1571h.f5332f = 1;
                    Iterator it3 = binderC1571h.f5331e.iterator();
                    while (it3.hasNext()) {
                        ((C1676s) it3.next()).f5591a.m4021o();
                    }
                    parcel2.writeNoException();
                    return true;
                }
                if (i6 != 3) {
                    if (i6 != 4) {
                        return false;
                    }
                    parcel2.writeNoException();
                    parcel2.writeInt(12451000);
                    return true;
                }
                BinderC1571h binderC1571h2 = (BinderC1571h) this;
                C3988b c3988b3 = BinderC1571h.f5329g;
                Log.i(c3988b3.f13521a, c3988b3.m7977d("onAppEnteredBackground", new Object[0]));
                binderC1571h2.f5332f = 2;
                Iterator it4 = binderC1571h2.f5331e.iterator();
                while (it4.hasNext()) {
                    C1685t c1685t = ((C1676s) it4.next()).f5591a;
                    c1685t.getClass();
                    C1685t.f5676f.m7975b("Stopping RouteDiscovery.", new Object[0]);
                    c1685t.f5679c.clear();
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        C1712w c1712w = c1685t.f5681e;
                        if (((C3451u0) c1712w.f5715b) == null) {
                            c1712w.f5715b = C3451u0.m7069d((Context) c1712w.f5714a);
                        }
                        C3451u0 c3451u0 = (C3451u0) c1712w.f5715b;
                        if (c3451u0 != null) {
                            c3451u0.m7075h(c1685t);
                        }
                    } else {
                        new HandlerC1731y0(Looper.getMainLooper(), 0).post(new RunnableC1658q(c1685t, i12));
                    }
                }
                parcel2.writeNoException();
                return true;
        }
    }
}
