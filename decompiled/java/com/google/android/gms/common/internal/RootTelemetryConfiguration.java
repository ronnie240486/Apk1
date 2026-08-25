package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new C4043d(11);

    public final int f5061a;

    public final boolean f5062b;

    public final boolean f5063c;

    public final int f5064d;

    public final int f5065e;

    public RootTelemetryConfiguration(int i6, boolean z7, boolean z10, int i10, int i11) {
        this.f5061a = i6;
        this.f5062b = z7;
        this.f5063c = z10;
        this.f5064d = i10;
        this.f5065e = i11;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5061a);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5062b ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5063c ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f5064d);
        AbstractC3280d.m6585X(parcel, 5, 4);
        parcel.writeInt(this.f5065e);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
