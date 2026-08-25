package com.google.android.gms.common.moduleinstall;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public class ModuleInstallIntentResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallIntentResponse> CREATOR = new C4043d(24);

    public final PendingIntent f5113a;

    public ModuleInstallIntentResponse(PendingIntent pendingIntent) {
        this.f5113a = pendingIntent;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6578Q(parcel, 1, this.f5113a, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
