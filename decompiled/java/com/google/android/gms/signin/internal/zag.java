package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import p156o9.AbstractC3280d;
import p165p4.C3371p;
import p261y4.InterfaceC4264l;

public final class zag extends AbstractSafeParcelable implements InterfaceC4264l {
    public static final Parcelable.Creator<zag> CREATOR = new C3371p(15);

    public final ArrayList f5770a;

    public final String f5771b;

    public zag(ArrayList arrayList, String str) {
        this.f5770a = arrayList;
        this.f5771b = str;
    }

    @Override
    public final Status mo3637h() {
        return this.f5771b != null ? Status.f4991e : Status.f4993g;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6580S(parcel, 1, this.f5770a);
        AbstractC3280d.m6579R(parcel, 2, this.f5771b);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
