package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

@Deprecated
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new C4043d(12);

    public final int f5106a;

    public zzal(int i6) {
        this.f5106a = i6;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5106a);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
