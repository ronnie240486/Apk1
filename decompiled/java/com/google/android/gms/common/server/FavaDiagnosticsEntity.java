package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new C4043d(28);

    public final int f5125a;

    public final String f5126b;

    public final int f5127c;

    public FavaDiagnosticsEntity(int i6, int i10, String str) {
        this.f5125a = i6;
        this.f5126b = str;
        this.f5127c = i10;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5125a);
        AbstractC3280d.m6579R(parcel, 2, this.f5126b);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5127c);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
