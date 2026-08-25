package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import p156o9.AbstractC3280d;

public final class zzfk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfk> CREATOR = new C1740z0(4);

    public final int f5761a;

    public final boolean f5762b;

    public final ArrayList f5763c;

    public final int f5764d;

    public final String f5765e;

    public final boolean f5766f;

    public zzfk(int i6, boolean z7, ArrayList arrayList, int i10, String str, boolean z10) {
        ArrayList arrayList2 = new ArrayList();
        this.f5763c = arrayList2;
        this.f5761a = i6;
        this.f5762b = z7;
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        this.f5764d = i10;
        this.f5765e = str;
        this.f5766f = z10;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5761a);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5762b ? 1 : 0);
        AbstractC3280d.m6580S(parcel, 4, this.f5763c);
        AbstractC3280d.m6585X(parcel, 5, 4);
        parcel.writeInt(this.f5764d);
        AbstractC3280d.m6579R(parcel, 6, this.f5765e);
        AbstractC3280d.m6585X(parcel, 7, 4);
        parcel.writeInt(this.f5766f ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
