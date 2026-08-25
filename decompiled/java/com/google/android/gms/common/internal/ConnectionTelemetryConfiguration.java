package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new C4043d(15);

    public final RootTelemetryConfiguration f5030a;

    public final boolean f5031b;

    public final boolean f5032c;

    public final int[] f5033d;

    public final int f5034e;

    public final int[] f5035f;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z7, boolean z10, int[] iArr, int i6, int[] iArr2) {
        this.f5030a = rootTelemetryConfiguration;
        this.f5031b = z7;
        this.f5032c = z10;
        this.f5033d = iArr;
        this.f5034e = i6;
        this.f5035f = iArr2;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6578Q(parcel, 1, this.f5030a, i6);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5031b ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5032c ? 1 : 0);
        AbstractC3280d.m6576O(parcel, 4, this.f5033d);
        AbstractC3280d.m6585X(parcel, 5, 4);
        parcel.writeInt(this.f5034e);
        AbstractC3280d.m6576O(parcel, 6, this.f5035f);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
