package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new C4043d(26);

    public final int f5116a;

    public final int f5117b;

    public final Long f5118c;

    public final Long f5119d;

    public final int f5120e;

    public ModuleInstallStatusUpdate(int i6, int i10, Long l9, Long l10, int i11) {
        this.f5116a = i6;
        this.f5117b = i10;
        this.f5118c = l9;
        this.f5119d = l10;
        this.f5120e = i11;
        if (l9 != null && l10 != null && l10.longValue() != 0 && l10.longValue() == 0) {
            throw new IllegalArgumentException("Given Long is zero");
        }
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5116a);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5117b);
        Long l9 = this.f5118c;
        if (l9 != null) {
            AbstractC3280d.m6585X(parcel, 3, 8);
            parcel.writeLong(l9.longValue());
        }
        Long l10 = this.f5119d;
        if (l10 != null) {
            AbstractC3280d.m6585X(parcel, 4, 8);
            parcel.writeLong(l10.longValue());
        }
        AbstractC3280d.m6585X(parcel, 5, 4);
        parcel.writeInt(this.f5120e);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
