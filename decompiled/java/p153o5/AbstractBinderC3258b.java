package p153o5;

import android.os.IBinder;
import android.os.IInterface;
import p200s5.AbstractBinderC3718a;

public abstract class AbstractBinderC3258b extends AbstractBinderC3718a implements InterfaceC3259c {
    public static InterfaceC3259c asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
        return iInterfaceQueryLocalInterface instanceof InterfaceC3259c ? (InterfaceC3259c) iInterfaceQueryLocalInterface : new C3257a(iBinder);
    }
}
