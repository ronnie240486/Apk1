package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p018b5.AbstractC1312l;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new C4043d(2);

    public final int f5011a;

    public ParcelFileDescriptor f5012b;

    public final int f5013c;

    public BitmapTeleporter(int i6, ParcelFileDescriptor parcelFileDescriptor, int i10) {
        this.f5011a = i6;
        this.f5012b = parcelFileDescriptor;
        this.f5013c = i10;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        if (this.f5012b == null) {
            AbstractC1312l.m3198e(null);
            throw null;
        }
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5011a);
        AbstractC3280d.m6578Q(parcel, 2, this.f5012b, i6 | 1);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5013c);
        AbstractC3280d.m6584W(parcel, iM6583V);
        this.f5012b = null;
    }
}
