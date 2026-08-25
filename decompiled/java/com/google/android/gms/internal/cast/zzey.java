package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;

public final class zzey extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzey> CREATOR = new C1740z0(2);

    public final boolean f5756a;

    public final int f5757b;

    public zzey(boolean z7, int i6) {
        this.f5756a = z7;
        this.f5757b = i6;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5756a ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5757b);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
