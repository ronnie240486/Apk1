package com.google.android.gms.internal.cast;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.cast.framework.CastOptions;
import p132m5.BinderC3079b;
import p132m5.InterfaceC3078a;
import p176q4.AbstractBinderC3490p;
import p176q4.AbstractBinderC3494t;
import p176q4.AbstractBinderC3497w;
import p176q4.BinderC3484j;
import p176q4.C3489o;
import p176q4.C3493s;
import p176q4.C3496v;
import p176q4.InterfaceC3491q;
import p176q4.InterfaceC3495u;
import p176q4.InterfaceC3498x;
import p199s4.AbstractBinderC3710d;
import p199s4.C3709c;
import p199s4.InterfaceC3711e;

public final class C1601k extends AbstractC1501a {
    public final InterfaceC3495u m3899A(BinderC3079b binderC3079b, InterfaceC3078a interfaceC3078a, InterfaceC3078a interfaceC3078a2) {
        InterfaceC3495u c3493s;
        Parcel parcelM3687l = m3687l();
        AbstractC1542e0.m3810d(parcelM3687l, binderC3079b);
        AbstractC1542e0.m3810d(parcelM3687l, interfaceC3078a);
        AbstractC1542e0.m3810d(parcelM3687l, interfaceC3078a2);
        Parcel parcelM3688w = m3688w(parcelM3687l, 5);
        IBinder strongBinder = parcelM3688w.readStrongBinder();
        int i6 = AbstractBinderC3494t.f11786d;
        if (strongBinder == null) {
            c3493s = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.IReconnectionService");
            c3493s = iInterfaceQueryLocalInterface instanceof InterfaceC3495u ? (InterfaceC3495u) iInterfaceQueryLocalInterface : new C3493s(strongBinder, "com.google.android.gms.cast.framework.IReconnectionService", 0);
        }
        parcelM3688w.recycle();
        return c3493s;
    }

    public final InterfaceC3498x m3900B(String str, String str2, BinderC3484j binderC3484j) {
        InterfaceC3498x c3496v;
        Parcel parcelM3687l = m3687l();
        parcelM3687l.writeString(str);
        parcelM3687l.writeString(str2);
        AbstractC1542e0.m3810d(parcelM3687l, binderC3484j);
        Parcel parcelM3688w = m3688w(parcelM3687l, 2);
        IBinder strongBinder = parcelM3688w.readStrongBinder();
        int i6 = AbstractBinderC3497w.f11787d;
        if (strongBinder == null) {
            c3496v = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.ISession");
            c3496v = iInterfaceQueryLocalInterface instanceof InterfaceC3498x ? (InterfaceC3498x) iInterfaceQueryLocalInterface : new C3496v(strongBinder, "com.google.android.gms.cast.framework.ISession", 0);
        }
        parcelM3688w.recycle();
        return c3496v;
    }

    public final InterfaceC3711e m3901C(BinderC3079b binderC3079b, BinderC3484j binderC3484j, int i6, int i10) {
        InterfaceC3711e c3709c;
        Parcel parcelM3687l = m3687l();
        AbstractC1542e0.m3810d(parcelM3687l, binderC3079b);
        AbstractC1542e0.m3810d(parcelM3687l, binderC3484j);
        parcelM3687l.writeInt(i6);
        parcelM3687l.writeInt(i10);
        parcelM3687l.writeInt(0);
        parcelM3687l.writeLong(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        parcelM3687l.writeInt(5);
        parcelM3687l.writeInt(333);
        parcelM3687l.writeInt(10000);
        Parcel parcelM3688w = m3688w(parcelM3687l, 6);
        IBinder strongBinder = parcelM3688w.readStrongBinder();
        int i11 = AbstractBinderC3710d.f12416d;
        if (strongBinder == null) {
            c3709c = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask");
            c3709c = iInterfaceQueryLocalInterface instanceof InterfaceC3711e ? (InterfaceC3711e) iInterfaceQueryLocalInterface : new C3709c(strongBinder, "com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask", 0);
        }
        parcelM3688w.recycle();
        return c3709c;
    }

    public final InterfaceC3711e m3902D(BinderC3079b binderC3079b, BinderC3079b binderC3079b2, BinderC3484j binderC3484j, int i6, int i10) {
        InterfaceC3711e c3709c;
        Parcel parcelM3687l = m3687l();
        AbstractC1542e0.m3810d(parcelM3687l, binderC3079b);
        AbstractC1542e0.m3810d(parcelM3687l, binderC3079b2);
        AbstractC1542e0.m3810d(parcelM3687l, binderC3484j);
        parcelM3687l.writeInt(i6);
        parcelM3687l.writeInt(i10);
        parcelM3687l.writeInt(0);
        parcelM3687l.writeLong(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        parcelM3687l.writeInt(5);
        parcelM3687l.writeInt(333);
        parcelM3687l.writeInt(10000);
        Parcel parcelM3688w = m3688w(parcelM3687l, 7);
        IBinder strongBinder = parcelM3688w.readStrongBinder();
        int i11 = AbstractBinderC3710d.f12416d;
        if (strongBinder == null) {
            c3709c = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask");
            c3709c = iInterfaceQueryLocalInterface instanceof InterfaceC3711e ? (InterfaceC3711e) iInterfaceQueryLocalInterface : new C3709c(strongBinder, "com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask", 0);
        }
        parcelM3688w.recycle();
        return c3709c;
    }

    public final InterfaceC3491q m3903z(CastOptions castOptions, InterfaceC3078a interfaceC3078a, BinderC3484j binderC3484j) {
        InterfaceC3491q c3489o;
        Parcel parcelM3687l = m3687l();
        AbstractC1542e0.m3809c(parcelM3687l, castOptions);
        AbstractC1542e0.m3810d(parcelM3687l, interfaceC3078a);
        AbstractC1542e0.m3810d(parcelM3687l, binderC3484j);
        Parcel parcelM3688w = m3688w(parcelM3687l, 3);
        IBinder strongBinder = parcelM3688w.readStrongBinder();
        int i6 = AbstractBinderC3490p.f11785d;
        if (strongBinder == null) {
            c3489o = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.ICastSession");
            c3489o = iInterfaceQueryLocalInterface instanceof InterfaceC3491q ? (InterfaceC3491q) iInterfaceQueryLocalInterface : new C3489o(strongBinder, "com.google.android.gms.cast.framework.ICastSession", 0);
        }
        parcelM3688w.recycle();
        return c3489o;
    }
}
