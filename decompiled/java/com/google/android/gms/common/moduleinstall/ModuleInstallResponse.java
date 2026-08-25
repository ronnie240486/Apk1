package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public class ModuleInstallResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallResponse> CREATOR = new C4043d(25);

    public final int f5114a;

    public final boolean f5115b;

    public ModuleInstallResponse(int i6, boolean z7) {
        this.f5114a = i6;
        this.f5115b = z7;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5114a);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5115b ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
