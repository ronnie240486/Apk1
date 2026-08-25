package p230v4;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.internal.AbstractC1500a;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import p005a4.C0049h;
import p165p4.AbstractC3365j;
import p271z4.C4343n;

public final class C4009w extends AbstractC1500a {

    public static final C3988b f13595D = new C3988b("CastClientImplCxless", null);

    public final long f13596A;

    public final Bundle f13597B;

    public final String f13598C;

    public final CastDevice f13599z;

    public C4009w(Context context, Looper looper, C0049h c0049h, CastDevice castDevice, long j10, Bundle bundle, String str, C4343n c4343n, C4343n c4343n2) {
        super(context, looper, 10, c0049h, c4343n, c4343n2);
        this.f13599z = castDevice;
        this.f13596A = j10;
        this.f13597B = bundle;
        this.f13598C = str;
    }

    @Override
    public final int mo3875d() {
        return 19390000;
    }

    @Override
    public final void disconnect() {
        try {
            try {
                C3990d c3990d = (C3990d) m3663p();
                ApiMetadata apiMetadata = new ApiMetadata(new ComplianceOptions(-1, -1, 0, true));
                Parcel parcelM3687l = c3990d.m3687l();
                AbstractC1542e0.m3809c(parcelM3687l, apiMetadata);
                c3990d.m3690y(parcelM3687l, 1);
            } finally {
                super.disconnect();
            }
        } catch (RemoteException | IllegalStateException e5) {
            f13595D.m7974a(e5, "Error while disconnecting the controller interface", new Object[0]);
        }
    }

    @Override
    public final IInterface mo3659l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        return iInterfaceQueryLocalInterface instanceof C3990d ? (C3990d) iInterfaceQueryLocalInterface : new C3990d(iBinder);
    }

    @Override
    public final Feature[] mo3660m() {
        return AbstractC3365j.f11360e;
    }

    @Override
    public final Bundle mo3662o() {
        Bundle bundle = new Bundle();
        f13595D.m7975b("getRemoteService()", new Object[0]);
        CastDevice castDevice = this.f13599z;
        castDevice.getClass();
        bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", castDevice);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.f13596A);
        bundle.putString("connectionless_client_record_id", this.f13598C);
        Bundle bundle2 = this.f13597B;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        return bundle;
    }

    @Override
    public final String mo3664q() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    @Override
    public final String mo3665r() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    @Override
    public final boolean mo3669v() {
        return true;
    }
}
