package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p018b5.AbstractC1312l;
import p078h5.C2661a;
import p156o9.AbstractC3280d;

public class CredentialsData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialsData> CREATOR = new C2661a(11);

    public final String f4625a;

    public final String f4626b;

    public CredentialsData(String str, String str2) {
        this.f4625a = str;
        this.f4626b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CredentialsData)) {
            return false;
        }
        CredentialsData credentialsData = (CredentialsData) obj;
        return AbstractC1312l.m3201h(this.f4625a, credentialsData.f4625a) && AbstractC1312l.m3201h(this.f4626b, credentialsData.f4626b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4625a, this.f4626b});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 1, this.f4625a);
        AbstractC3280d.m6579R(parcel, 2, this.f4626b);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
