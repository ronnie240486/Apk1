package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p018b5.AbstractBinderC1301a;
import p018b5.AbstractC1312l;
import p018b5.C1324x;
import p018b5.InterfaceC1303c;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new C4043d(9);

    public final int f5097a;

    public final IBinder f5098b;

    public final ConnectionResult f5099c;

    public final boolean f5100d;

    public final boolean f5101e;

    public zav(int i6, IBinder iBinder, ConnectionResult connectionResult, boolean z7, boolean z10) {
        this.f5097a = i6;
        this.f5098b = iBinder;
        this.f5099c = connectionResult;
        this.f5100d = z7;
        this.f5101e = z10;
    }

    public final boolean equals(Object obj) {
        Object c1324x;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zavVar = (zav) obj;
        if (this.f5099c.equals(zavVar.f5099c)) {
            Object c1324x2 = null;
            IBinder iBinder = this.f5098b;
            if (iBinder == null) {
                c1324x = null;
            } else {
                int i6 = AbstractBinderC1301a.f4080d;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                c1324x = iInterfaceQueryLocalInterface instanceof InterfaceC1303c ? (InterfaceC1303c) iInterfaceQueryLocalInterface : new C1324x(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 2);
            }
            IBinder iBinder2 = zavVar.f5098b;
            if (iBinder2 != null) {
                int i10 = AbstractBinderC1301a.f4080d;
                IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                c1324x2 = iInterfaceQueryLocalInterface2 instanceof InterfaceC1303c ? (InterfaceC1303c) iInterfaceQueryLocalInterface2 : new C1324x(iBinder2, "com.google.android.gms.common.internal.IAccountAccessor", 2);
            }
            if (AbstractC1312l.m3201h(c1324x, c1324x2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5097a);
        AbstractC3280d.m6575N(parcel, 2, this.f5098b);
        AbstractC3280d.m6578Q(parcel, 3, this.f5099c, i6);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f5100d ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 5, 4);
        parcel.writeInt(this.f5101e ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
