package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new C4043d(29);

    public final int f5131a;

    public final StringToIntConverter f5132b;

    public zaa(int i6, StringToIntConverter stringToIntConverter) {
        this.f5131a = i6;
        this.f5132b = stringToIntConverter;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5131a);
        AbstractC3280d.m6578Q(parcel, 2, this.f5132b, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }

    public zaa(StringToIntConverter stringToIntConverter) {
        this.f5131a = 1;
        this.f5132b = stringToIntConverter;
    }
}
