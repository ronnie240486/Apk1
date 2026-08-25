package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public class TelemetryData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TelemetryData> CREATOR = new C4043d(6);

    public final int f5066a;

    public List f5067b;

    public TelemetryData(int i6, List list) {
        this.f5066a = i6;
        this.f5067b = list;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5066a);
        AbstractC3280d.m6582U(parcel, 2, this.f5067b);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
