package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.AbstractC1500a;
import java.util.concurrent.atomic.AtomicReference;
import p005a4.C0049h;
import p271z4.C4343n;

public final class C1593j1 extends AbstractC1500a {

    public final AtomicReference f5362z;

    public C1593j1(Context context, Looper looper, C0049h c0049h, C4343n c4343n, C4343n c4343n2) {
        super(context, looper, 41, c0049h, c4343n, c4343n2);
        this.f5362z = new AtomicReference();
    }

    @Override
    public final int mo3875d() {
        return 12600000;
    }

    @Override
    public final void disconnect() {
        try {
            if (this.f5362z.getAndSet(null) != null) {
                throw new ClassCastException();
            }
        } catch (RemoteException e5) {
            Log.e("UsageReportingClientImp", "disconnect(): Could not unregister listener from remote:", e5);
        }
        super.disconnect();
    }

    @Override
    public final IInterface mo3659l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.usagereporting.internal.IUsageReportingService");
        return iInterfaceQueryLocalInterface instanceof C1573h1 ? (C1573h1) iInterfaceQueryLocalInterface : new C1573h1(iBinder, "com.google.android.gms.usagereporting.internal.IUsageReportingService", 0);
    }

    @Override
    public final Feature[] mo3660m() {
        return AbstractC1503a1.f5199b;
    }

    @Override
    public final String mo3664q() {
        return "com.google.android.gms.usagereporting.internal.IUsageReportingService";
    }

    @Override
    public final String mo3665r() {
        return "com.google.android.gms.usagereporting.service.START";
    }

    @Override
    public final boolean mo3669v() {
        return true;
    }
}
