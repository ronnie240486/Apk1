package p039d5;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.AbstractC1500a;
import p005a4.C0049h;
import p018b5.C1305e;
import p177q5.AbstractC3502b;
import p271z4.C4343n;

public final class C2156c extends AbstractC1500a {

    public final C1305e f7800z;

    public C2156c(Context context, Looper looper, C0049h c0049h, C1305e c1305e, C4343n c4343n, C4343n c4343n2) {
        super(context, looper, 270, c0049h, c4343n, c4343n2);
        this.f7800z = c1305e;
    }

    @Override
    public final int mo3875d() {
        return 203400000;
    }

    @Override
    public final IInterface mo3659l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof C2154a ? (C2154a) iInterfaceQueryLocalInterface : new C2154a(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService", 1);
    }

    @Override
    public final Feature[] mo3660m() {
        return AbstractC3502b.f11792b;
    }

    @Override
    public final Bundle mo3662o() {
        this.f7800z.getClass();
        return new Bundle();
    }

    @Override
    public final String mo3664q() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override
    public final String mo3665r() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override
    public final boolean mo3666s() {
        return true;
    }
}
