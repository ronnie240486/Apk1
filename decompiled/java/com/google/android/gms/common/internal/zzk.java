package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new C4043d(14);

    public Bundle f5107a;

    public Feature[] f5108b;

    public int f5109c;

    public ConnectionTelemetryConfiguration f5110d;

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6574M(parcel, 1, this.f5107a);
        AbstractC3280d.m6581T(parcel, 2, this.f5108b, i6);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5109c);
        AbstractC3280d.m6578Q(parcel, 4, this.f5110d, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
