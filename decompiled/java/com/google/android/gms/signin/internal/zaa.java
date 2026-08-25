package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p165p4.C3371p;
import p261y4.InterfaceC4264l;

public final class zaa extends AbstractSafeParcelable implements InterfaceC4264l {
    public static final Parcelable.Creator<zaa> CREATOR = new C3371p(14);

    public final int f5767a;

    public final int f5768b;

    public final Intent f5769c;

    public zaa(int i6, int i10, Intent intent) {
        this.f5767a = i6;
        this.f5768b = i10;
        this.f5769c = intent;
    }

    @Override
    public final Status mo3637h() {
        return this.f5768b == 0 ? Status.f4991e : Status.f4993g;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5767a);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5768b);
        AbstractC3280d.m6578Q(parcel, 3, this.f5769c, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
