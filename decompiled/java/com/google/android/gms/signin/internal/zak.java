package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zav;
import p156o9.AbstractC3280d;
import p165p4.C3371p;

public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new C3371p(17);

    public final int f5774a;

    public final ConnectionResult f5775b;

    public final zav f5776c;

    public zak(int i6, ConnectionResult connectionResult, zav zavVar) {
        this.f5774a = i6;
        this.f5775b = connectionResult;
        this.f5776c = zavVar;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5774a);
        AbstractC3280d.m6578Q(parcel, 2, this.f5775b, i6);
        AbstractC3280d.m6578Q(parcel, 3, this.f5776c, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
