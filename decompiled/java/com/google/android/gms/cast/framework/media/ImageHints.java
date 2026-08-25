package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p165p4.C3371p;

public class ImageHints extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ImageHints> CREATOR = new C3371p(8);

    public final int f4839a;

    public final int f4840b;

    public final int f4841c;

    public ImageHints(int i6, int i10, int i11) {
        this.f4839a = i6;
        this.f4840b = i10;
        this.f4841c = i11;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f4839a);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f4840b);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f4841c);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
