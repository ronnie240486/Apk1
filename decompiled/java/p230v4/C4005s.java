package p230v4;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.AbstractC1500a;
import p165p4.AbstractC3365j;

public final class C4005s extends AbstractC1500a {
    @Override
    public final int mo3875d() {
        return 12451000;
    }

    @Override
    public final IInterface mo3659l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastService");
        return iInterfaceQueryLocalInterface instanceof C3993g ? (C3993g) iInterfaceQueryLocalInterface : new C3993g(iBinder, "com.google.android.gms.cast.internal.ICastService", 0);
    }

    @Override
    public final Feature[] mo3660m() {
        return AbstractC3365j.f11360e;
    }

    @Override
    public final String mo3664q() {
        return "com.google.android.gms.cast.internal.ICastService";
    }

    @Override
    public final String mo3665r() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }
}
