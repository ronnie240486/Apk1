package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p165p4.C3371p;

public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new C3371p(4);

    public final boolean f4944a;

    public zzj(boolean z7) {
        this.f4944a = z7;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f4944a ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
