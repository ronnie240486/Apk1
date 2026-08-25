package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zat;
import p156o9.AbstractC3280d;
import p165p4.C3371p;

public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new C3371p(16);

    public final int f5772a;

    public final zat f5773b;

    public zai(int i6, zat zatVar) {
        this.f5772a = i6;
        this.f5773b = zatVar;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5772a);
        AbstractC3280d.m6578Q(parcel, 2, this.f5773b, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
