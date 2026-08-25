package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;

public final class zzff extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzff> CREATOR = new C1740z0(3);

    public final boolean f5758a;

    public final boolean f5759b;

    public final int f5760c;

    public zzff(int i6, boolean z7, boolean z10) {
        this.f5758a = z7;
        this.f5759b = z10;
        this.f5760c = i6;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5758a ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5759b ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f5760c);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
