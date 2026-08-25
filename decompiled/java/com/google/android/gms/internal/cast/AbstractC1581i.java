package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.cast.framework.CastOptions;
import java.util.HashMap;
import p132m5.BinderC3079b;
import p143n5.C3195a;
import p143n5.C3197c;
import p176q4.AbstractBinderC3487m;
import p176q4.C3479e;
import p176q4.C3486l;
import p176q4.InterfaceC3488n;
import p230v4.C3988b;

public abstract class AbstractC1581i {

    public static final C3988b f5339a = new C3988b("CastDynamiteModule", null);

    public static InterfaceC3488n m3842a(Context context, CastOptions castOptions, BinderC1703v binderC1703v, HashMap map) throws C3479e {
        InterfaceC3488n c3486l;
        C1601k c1601kM3843b = m3843b(context);
        BinderC3079b binderC3079b = new BinderC3079b(context.getApplicationContext());
        Parcel parcelM3687l = c1601kM3843b.m3687l();
        AbstractC1542e0.m3810d(parcelM3687l, binderC3079b);
        AbstractC1542e0.m3809c(parcelM3687l, castOptions);
        AbstractC1542e0.m3810d(parcelM3687l, binderC1703v);
        parcelM3687l.writeMap(map);
        Parcel parcelM3688w = c1601kM3843b.m3688w(parcelM3687l, 1);
        IBinder strongBinder = parcelM3688w.readStrongBinder();
        int i6 = AbstractBinderC3487m.f11784d;
        if (strongBinder == null) {
            c3486l = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.ICastContext");
            c3486l = iInterfaceQueryLocalInterface instanceof InterfaceC3488n ? (InterfaceC3488n) iInterfaceQueryLocalInterface : new C3486l(strongBinder, "com.google.android.gms.cast.framework.ICastContext", 0);
        }
        parcelM3688w.recycle();
        return c3486l;
    }

    public static C1601k m3843b(Context context) throws C3479e {
        try {
            try {
                IBinder iBinder = (IBinder) C3197c.m6420a(context, C3197c.f10755b).f10766a.getClassLoader().loadClass("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl").newInstance();
                if (iBinder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
                return iInterfaceQueryLocalInterface instanceof C1601k ? (C1601k) iInterfaceQueryLocalInterface : new C1601k(iBinder, "com.google.android.gms.cast.framework.internal.ICastDynamiteModule", 0);
            } catch (ClassNotFoundException e5) {
                e = e5;
                throw new C3195a("Failed to instantiate module class: ".concat("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl"), e);
            } catch (IllegalAccessException e10) {
                e = e10;
                throw new C3195a("Failed to instantiate module class: ".concat("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl"), e);
            } catch (InstantiationException e11) {
                e = e11;
                throw new C3195a("Failed to instantiate module class: ".concat("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl"), e);
            }
        } catch (C3195a e12) {
            throw new C3479e(e12);
        }
    }
}
