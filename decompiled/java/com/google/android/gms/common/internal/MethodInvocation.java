package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new C4043d(7);

    public final int f5052a;

    public final int f5053b;

    public final int f5054c;

    public final long f5055d;

    public final long f5056e;

    public final String f5057f;

    public final String f5058g;

    public final int f5059h;

    public final int f5060i;

    public MethodInvocation(int i6, int i10, int i11, long j10, long j11, String str, String str2, int i12, int i13) {
        this.f5052a = i6;
        this.f5053b = i10;
        this.f5054c = i11;
        this.f5055d = j10;
        this.f5056e = j11;
        this.f5057f = str;
        this.f5058g = str2;
        this.f5059h = i12;
        this.f5060i = i13;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5052a);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5053b);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5054c);
        AbstractC3280d.m6585X(parcel, 4, 8);
        parcel.writeLong(this.f5055d);
        AbstractC3280d.m6585X(parcel, 5, 8);
        parcel.writeLong(this.f5056e);
        AbstractC3280d.m6579R(parcel, 6, this.f5057f);
        AbstractC3280d.m6579R(parcel, 7, this.f5058g);
        AbstractC3280d.m6585X(parcel, 8, 4);
        parcel.writeInt(this.f5059h);
        AbstractC3280d.m6585X(parcel, 9, 4);
        parcel.writeInt(this.f5060i);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
