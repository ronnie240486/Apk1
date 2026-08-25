package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p165p4.C3371p;

public class NotificationAction extends AbstractSafeParcelable {
    public static final Parcelable.Creator<NotificationAction> CREATOR = new C3371p(9);

    public final String f4842a;

    public final int f4843b;

    public final String f4844c;

    public NotificationAction(String str, int i6, String str2) {
        this.f4842a = str;
        this.f4843b = i6;
        this.f4844c = str2;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 2, this.f4842a);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f4843b);
        AbstractC3280d.m6579R(parcel, 4, this.f4844c);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
