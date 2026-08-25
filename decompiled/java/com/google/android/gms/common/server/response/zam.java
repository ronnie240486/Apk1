package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p078h5.C2661a;
import p156o9.AbstractC3280d;

public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new C2661a(2);

    public final int f5157a;

    public final String f5158b;

    public final FastJsonResponse$Field f5159c;

    public zam(int i6, String str, FastJsonResponse$Field fastJsonResponse$Field) {
        this.f5157a = i6;
        this.f5158b = str;
        this.f5159c = fastJsonResponse$Field;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5157a);
        AbstractC3280d.m6579R(parcel, 2, this.f5158b);
        AbstractC3280d.m6578Q(parcel, 3, this.f5159c, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }

    public zam(String str, FastJsonResponse$Field fastJsonResponse$Field) {
        this.f5157a = 1;
        this.f5158b = str;
        this.f5159c = fastJsonResponse$Field;
    }
}
