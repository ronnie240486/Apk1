package p018b5;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1500a;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.cast.AbstractBinderC1694u;
import p188r5.AbstractC3635a;

public final class BinderC1315o extends AbstractBinderC1694u {

    public AbstractC1500a f4103d;

    public final int f4104e;

    public BinderC1315o(AbstractC1500a abstractC1500a, int i6) {
        super("com.google.android.gms.common.internal.IGmsCallbacks", 1);
        this.f4103d = abstractC1500a;
        this.f4104e = i6;
    }

    @Override
    public final boolean mo3202w(int i6, Parcel parcel, Parcel parcel2) {
        if (i6 == 1) {
            int i10 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) AbstractC3635a.m7360a(parcel, Bundle.CREATOR);
            AbstractC3635a.m7361b(parcel);
            AbstractC1312l.m3199f(this.f4103d, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f4103d.mo3668u(i10, strongBinder, bundle, this.f4104e);
            this.f4103d = null;
        } else if (i6 == 2) {
            parcel.readInt();
            AbstractC3635a.m7361b(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i6 != 3) {
                return false;
            }
            int i11 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzk zzkVar = (zzk) AbstractC3635a.m7360a(parcel, zzk.CREATOR);
            AbstractC3635a.m7361b(parcel);
            AbstractC1500a abstractC1500a = this.f4103d;
            AbstractC1312l.m3199f(abstractC1500a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            AbstractC1312l.m3198e(zzkVar);
            abstractC1500a.f5090v = zzkVar;
            if (abstractC1500a.mo3669v()) {
                ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzkVar.f5110d;
                C1304d c1304dM3176b = C1304d.m3176b();
                RootTelemetryConfiguration rootTelemetryConfiguration = connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.f5030a;
                synchronized (c1304dM3176b) {
                    try {
                        if (rootTelemetryConfiguration == null) {
                            rootTelemetryConfiguration = C1304d.f4082c;
                        } else {
                            RootTelemetryConfiguration rootTelemetryConfiguration2 = (RootTelemetryConfiguration) c1304dM3176b.f4084a;
                            if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.f5061a < rootTelemetryConfiguration.f5061a) {
                            }
                        }
                        c1304dM3176b.f4084a = rootTelemetryConfiguration;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            Bundle bundle2 = zzkVar.f5107a;
            AbstractC1312l.m3199f(this.f4103d, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f4103d.mo3668u(i11, strongBinder2, bundle2, this.f4104e);
            this.f4103d = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
