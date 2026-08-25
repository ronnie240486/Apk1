package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new C4043d(10);

    public final int f5102a;

    public final int f5103b;

    public final int f5104c;

    public final Scope[] f5105d;

    public zax(int i6, int i10, int i11, Scope[] scopeArr) {
        this.f5102a = i6;
        this.f5103b = i10;
        this.f5104c = i11;
        this.f5105d = scopeArr;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5102a);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5103b);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5104c);
        AbstractC3280d.m6581T(parcel, 4, this.f5105d, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
