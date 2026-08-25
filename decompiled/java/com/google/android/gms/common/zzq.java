package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p165p4.C3371p;

public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new C3371p(29);

    public final boolean f5184a;

    public final String f5185b;

    public final int f5186c;

    public final int f5187d;

    public zzq(String str, int i6, int i10, boolean z7) {
        int i11;
        int i12 = 1;
        this.f5184a = z7;
        this.f5185b = str;
        int[] iArr = {1, 2, 3, 4, 5, 6};
        int i13 = 0;
        while (true) {
            if (i13 >= 6) {
                i11 = 1;
                break;
            }
            i11 = iArr[i13];
            int i14 = i11 - 1;
            if (i11 == 0) {
                throw null;
            }
            if (i14 == i6) {
                break;
            } else {
                i13++;
            }
        }
        this.f5186c = i11 - 1;
        int[] iArr2 = {1, 2, 3};
        for (int i15 = 0; i15 < 3; i15++) {
            int i16 = iArr2[i15];
            int i17 = i16 - 1;
            if (i16 == 0) {
                throw null;
            }
            if (i17 == i10) {
                i12 = i16;
                break;
            }
        }
        this.f5187d = i12 - 1;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5184a ? 1 : 0);
        AbstractC3280d.m6579R(parcel, 2, this.f5185b);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5186c);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f5187d);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
