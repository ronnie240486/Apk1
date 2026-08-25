package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p165p4.C3371p;

public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new C3371p(5);

    public final int f4945a;

    public zzl(int i6) {
        this.f4945a = i6;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f4945a);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
