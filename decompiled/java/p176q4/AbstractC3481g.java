package p176q4;

import android.content.Context;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.media3.exoplayer.rtsp.RtspHeaders;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.google.android.gms.internal.cast.AbstractC1581i;
import com.google.android.gms.internal.cast.C1601k;
import p018b5.AbstractC1312l;
import p132m5.BinderC3079b;
import p132m5.InterfaceC3078a;
import p230v4.C3988b;

public abstract class AbstractC3481g {

    public static final C3988b f11775b = new C3988b(RtspHeaders.SESSION, null);

    public final InterfaceC3498x f11776a;

    public AbstractC3481g(Context context, String str, String str2) {
        InterfaceC3498x interfaceC3498xM3900B;
        try {
            interfaceC3498xM3900B = AbstractC1581i.m3843b(context).m3900B(str, str2, new BinderC3484j(this));
        } catch (RemoteException | C3479e e5) {
            AbstractC1581i.f5339a.m7974a(e5, "Unable to call %s on %s.", "newSessionImpl", C1601k.class.getSimpleName());
            interfaceC3498xM3900B = null;
        }
        this.f11776a = interfaceC3498xM3900B;
    }

    public final boolean m7136a() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        InterfaceC3498x interfaceC3498x = this.f11776a;
        if (interfaceC3498x != null) {
            try {
                C3496v c3496v = (C3496v) interfaceC3498x;
                Parcel parcelM3688w = c3496v.m3688w(c3496v.m3687l(), 5);
                int i6 = AbstractC1542e0.f5277a;
                boolean z7 = parcelM3688w.readInt() != 0;
                parcelM3688w.recycle();
                return z7;
            } catch (RemoteException e5) {
                f11775b.m7974a(e5, "Unable to call %s on %s.", "isConnected", InterfaceC3498x.class.getSimpleName());
            }
        }
        return false;
    }

    public final void m7137b(int i6) {
        InterfaceC3498x interfaceC3498x = this.f11776a;
        if (interfaceC3498x == null) {
            return;
        }
        try {
            C3496v c3496v = (C3496v) interfaceC3498x;
            Parcel parcelM3687l = c3496v.m3687l();
            parcelM3687l.writeInt(i6);
            c3496v.m3689x(parcelM3687l, 13);
        } catch (RemoteException e5) {
            f11775b.m7974a(e5, "Unable to call %s on %s.", "notifySessionEnded", InterfaceC3498x.class.getSimpleName());
        }
    }

    public final int m7138c() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        InterfaceC3498x interfaceC3498x = this.f11776a;
        if (interfaceC3498x != null) {
            try {
                C3496v c3496v = (C3496v) interfaceC3498x;
                Parcel parcelM3688w = c3496v.m3688w(c3496v.m3687l(), 17);
                int i6 = parcelM3688w.readInt();
                parcelM3688w.recycle();
                if (i6 >= 211100000) {
                    C3496v c3496v2 = (C3496v) interfaceC3498x;
                    Parcel parcelM3688w2 = c3496v2.m3688w(c3496v2.m3687l(), 18);
                    int i10 = parcelM3688w2.readInt();
                    parcelM3688w2.recycle();
                    return i10;
                }
            } catch (RemoteException e5) {
                f11775b.m7974a(e5, "Unable to call %s on %s.", "getSessionStartType", InterfaceC3498x.class.getSimpleName());
            }
        }
        return 0;
    }

    public final InterfaceC3078a m7139d() {
        InterfaceC3498x interfaceC3498x = this.f11776a;
        if (interfaceC3498x != null) {
            try {
                C3496v c3496v = (C3496v) interfaceC3498x;
                Parcel parcelM3688w = c3496v.m3688w(c3496v.m3687l(), 1);
                InterfaceC3078a interfaceC3078aM6111x = BinderC3079b.m6111x(parcelM3688w.readStrongBinder());
                parcelM3688w.recycle();
                return interfaceC3078aM6111x;
            } catch (RemoteException e5) {
                f11775b.m7974a(e5, "Unable to call %s on %s.", "getWrappedObject", InterfaceC3498x.class.getSimpleName());
            }
        }
        return null;
    }
}
