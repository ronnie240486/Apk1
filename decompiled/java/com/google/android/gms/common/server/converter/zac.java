package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p078h5.C2661a;
import p156o9.AbstractC3280d;

public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new C2661a(1);

    public final int f5133a;

    public final String f5134b;

    public final int f5135c;

    public zac(int i6, int i10, String str) {
        this.f5133a = i6;
        this.f5134b = str;
        this.f5135c = i10;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5133a);
        AbstractC3280d.m6579R(parcel, 2, this.f5134b);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5135c);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }

    public zac(String str, int i6) {
        this.f5133a = 1;
        this.f5134b = str;
        this.f5135c = i6;
    }
}
