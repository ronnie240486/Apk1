package p271z4;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import p124l6.C2982h;

public abstract class AbstractC4346q {

    public final int f14735a;

    public AbstractC4346q(int i6) {
        this.f14735a = i6;
    }

    public static Status m8382g(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage(), null, null);
    }

    public abstract boolean mo8383a(C4343n c4343n);

    public abstract Feature[] mo8384b(C4343n c4343n);

    public abstract void mo8385c(Status status);

    public abstract void mo8386d(RuntimeException runtimeException);

    public abstract void mo8387e(C4343n c4343n);

    public abstract void mo8388f(C2982h c2982h, boolean z7);
}
