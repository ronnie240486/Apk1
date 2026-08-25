package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public class ModuleAvailabilityResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleAvailabilityResponse> CREATOR = new C4043d(23);

    public final boolean f5111a;

    public final int f5112b;

    public ModuleAvailabilityResponse(boolean z7, int i6) {
        this.f5111a = z7;
        this.f5112b = i6;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5111a ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5112b);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
