package p230v4;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.internal.cast.AbstractBinderC1694u;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import p242w5.C4056d;

public final class BinderC4003q extends AbstractBinderC1694u implements InterfaceC3989c {

    public final int f13563d;

    public final C4056d f13564e;

    public BinderC4003q(int i6, C4056d c4056d) {
        super("com.google.android.gms.cast.internal.IBundleCallback", 0);
        this.f13563d = i6;
        this.f13564e = c4056d;
    }

    @Override
    public final void mo7978i(Bundle bundle) {
        switch (this.f13563d) {
            case 0:
                this.f13564e.m8059b(bundle);
                break;
            case 1:
                this.f13564e.m8059b(bundle);
                break;
            default:
                this.f13564e.m8059b(bundle);
                break;
        }
    }

    @Override
    public final boolean mo3202w(int i6, Parcel parcel, Parcel parcel2) {
        if (i6 != 1) {
            return false;
        }
        Bundle bundle = (Bundle) AbstractC1542e0.m3807a(parcel, Bundle.CREATOR);
        AbstractC1542e0.m3808b(parcel);
        mo7978i(bundle);
        return true;
    }
}
