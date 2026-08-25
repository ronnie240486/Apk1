package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p078h5.C2661a;
import p156o9.AbstractC3280d;

public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new C2661a(9);

    public final int f4561a;

    public final int f4562b;

    public final Bundle f4563c;

    public GoogleSignInOptionsExtensionParcelable(int i6, int i10, Bundle bundle) {
        this.f4561a = i6;
        this.f4562b = i10;
        this.f4563c = bundle;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f4561a);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f4562b);
        AbstractC3280d.m6574M(parcel, 3, this.f4563c);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
