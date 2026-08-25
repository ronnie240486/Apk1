package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p132m5.BinderC3079b;
import p156o9.AbstractC3280d;
import p165p4.C3371p;

public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new C3371p(28);

    public final String f5178a;

    public final boolean f5179b;

    public final boolean f5180c;

    public final Context f5181d;

    public final boolean f5182e;

    public final boolean f5183f;

    public zzo(String str, boolean z7, boolean z10, IBinder iBinder, boolean z11, boolean z12) {
        this.f5178a = str;
        this.f5179b = z7;
        this.f5180c = z10;
        this.f5181d = (Context) BinderC3079b.m6112y(BinderC3079b.m6111x(iBinder));
        this.f5182e = z11;
        this.f5183f = z12;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 1, this.f5178a);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5179b ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5180c ? 1 : 0);
        AbstractC3280d.m6575N(parcel, 4, new BinderC3079b(this.f5181d));
        AbstractC3280d.m6585X(parcel, 5, 4);
        parcel.writeInt(this.f5182e ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 6, 4);
        parcel.writeInt(this.f5183f ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
