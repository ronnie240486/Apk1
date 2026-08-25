package com.google.android.gms.internal.cast;

import android.os.Parcel;

public final class BinderC1686t0 extends AbstractBinderC1694u {
    @Override
    public final boolean mo3202w(int i6, Parcel parcel, Parcel parcel2) {
        if (i6 != 1) {
            return false;
        }
        parcel.readInt();
        AbstractC1542e0.m3808b(parcel);
        C1695u0.f5685a.m7975b("onRemoteDisplayEnded", new Object[0]);
        return true;
    }
}
