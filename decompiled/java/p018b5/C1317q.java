package p018b5;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.AbstractC1500a;
import p261y4.InterfaceC4260h;
import p261y4.InterfaceC4261i;

public final class C1317q extends AbstractC1309i {

    public final IBinder f4107g;

    public final AbstractC1500a f4108h;

    public C1317q(AbstractC1500a abstractC1500a, int i6, IBinder iBinder, Bundle bundle) {
        super(abstractC1500a, i6, bundle);
        this.f4108h = abstractC1500a;
        this.f4107g = iBinder;
    }

    @Override
    public final void mo3187a(ConnectionResult connectionResult) {
        AbstractC1500a abstractC1500a = this.f4108h;
        C1304d c1304d = abstractC1500a.f5084p;
        if (c1304d != null) {
            ((InterfaceC4261i) c1304d.f4084a).mo8308l(connectionResult);
        }
        abstractC1500a.mo3667t(connectionResult);
    }

    @Override
    public final boolean mo3188b() {
        IBinder iBinder = this.f4107g;
        try {
            AbstractC1312l.m3198e(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            AbstractC1500a abstractC1500a = this.f4108h;
            if (!abstractC1500a.mo3664q().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + abstractC1500a.mo3664q() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceMo3659l = abstractC1500a.mo3659l(iBinder);
            if (iInterfaceMo3659l == null || !(AbstractC1500a.m3648x(abstractC1500a, 2, 4, iInterfaceMo3659l) || AbstractC1500a.m3648x(abstractC1500a, 3, 4, iInterfaceMo3659l))) {
                return false;
            }
            abstractC1500a.f5088t = null;
            abstractC1500a.mo3661n();
            C1304d c1304d = abstractC1500a.f5083o;
            if (c1304d == null) {
                return true;
            }
            ((InterfaceC4260h) c1304d.f4084a).onConnected();
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
