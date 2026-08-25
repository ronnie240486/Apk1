package com.google.android.gms.internal.cast;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.AbstractC1500a;

public final class C1704v0 extends AbstractC1500a {
    @Override
    public final int mo3875d() {
        return 12451000;
    }

    @Override
    public final IInterface mo3659l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
        return iInterfaceQueryLocalInterface instanceof C1713w0 ? (C1713w0) iInterfaceQueryLocalInterface : new C1713w0(iBinder, "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService", 0);
    }

    @Override
    public final String mo3664q() {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }

    @Override
    public final String mo3665r() {
        return "com.google.android.gms.cast.remote_display.service.START";
    }
}
