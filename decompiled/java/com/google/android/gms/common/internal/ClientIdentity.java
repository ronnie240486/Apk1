package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p018b5.AbstractC1312l;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public class ClientIdentity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new C4043d(5);

    public final int f5028a;

    public final String f5029b;

    public ClientIdentity(int i6, String str) {
        this.f5028a = i6;
        this.f5029b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f5028a == this.f5028a && AbstractC1312l.m3201h(clientIdentity.f5029b, this.f5029b);
    }

    public final int hashCode() {
        return this.f5028a;
    }

    public final String toString() {
        return this.f5028a + ":" + this.f5029b;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5028a);
        AbstractC3280d.m6579R(parcel, 2, this.f5029b);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
