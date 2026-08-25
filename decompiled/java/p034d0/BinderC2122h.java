package p034d0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.core.content.UnusedAppRestrictionsBackportService;
import p023c0.C1374a;
import p023c0.InterfaceC1375b;
import p023c0.InterfaceC1376c;

public final class BinderC2122h extends Binder implements InterfaceC1376c {

    public final UnusedAppRestrictionsBackportService f7728c;

    public BinderC2122h(UnusedAppRestrictionsBackportService unusedAppRestrictionsBackportService) {
        this.f7728c = unusedAppRestrictionsBackportService;
        attachInterface(this, InterfaceC1376c.f4190b);
    }

    @Override
    public final boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i10) {
        InterfaceC1375b interfaceC1375b;
        String str = InterfaceC1376c.f4190b;
        if (i6 >= 1 && i6 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i6 == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        if (i6 != 1) {
            return super.onTransact(i6, parcel, parcel2, i10);
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            interfaceC1375b = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(InterfaceC1375b.f4189a);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC1375b)) {
                C1374a c1374a = new C1374a();
                c1374a.f4188c = strongBinder;
                interfaceC1375b = c1374a;
            } else {
                interfaceC1375b = (InterfaceC1375b) iInterfaceQueryLocalInterface;
            }
        }
        if (interfaceC1375b != null) {
            this.f7728c.m1083a();
        }
        return true;
    }

    @Override
    public final IBinder asBinder() {
        return this;
    }
}
