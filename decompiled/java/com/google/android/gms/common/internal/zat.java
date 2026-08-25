package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new C4043d(8);

    public final int f5093a;

    public final Account f5094b;

    public final int f5095c;

    public final GoogleSignInAccount f5096d;

    public zat(int i6, Account account, int i10, GoogleSignInAccount googleSignInAccount) {
        this.f5093a = i6;
        this.f5094b = account;
        this.f5095c = i10;
        this.f5096d = googleSignInAccount;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5093a);
        AbstractC3280d.m6578Q(parcel, 2, this.f5094b, i6);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5095c);
        AbstractC3280d.m6578Q(parcel, 4, this.f5096d, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
