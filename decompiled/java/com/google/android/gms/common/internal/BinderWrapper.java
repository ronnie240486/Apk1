package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import p230v4.BinderC4007u;
import p237w0.C4043d;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new C4043d(13);

    public final IBinder f5027a;

    public BinderWrapper(BinderC4007u binderC4007u) {
        this.f5027a = binderC4007u;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeStrongBinder(this.f5027a);
    }

    public BinderWrapper(Parcel parcel) {
        this.f5027a = parcel.readStrongBinder();
    }
}
