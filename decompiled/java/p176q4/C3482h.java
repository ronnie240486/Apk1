package p176q4;

import android.content.Context;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import p018b5.AbstractC1312l;
import p132m5.BinderC3079b;
import p132m5.InterfaceC3078a;
import p230v4.C3988b;

public final class C3482h {

    public static final C3988b f11777c = new C3988b("SessionManager", null);

    public final C3499y f11778a;

    public final Context f11779b;

    public C3482h(C3499y c3499y, Context context) {
        this.f11778a = c3499y;
        this.f11779b = context;
    }

    public final void m7140a(InterfaceC3483i interfaceC3483i) {
        if (interfaceC3483i == null) {
            throw new NullPointerException("SessionManagerListener can't be null");
        }
        AbstractC1312l.m3195b("Must be called from the main thread.");
        try {
            C3499y c3499y = this.f11778a;
            BinderC3500z binderC3500z = new BinderC3500z(interfaceC3483i);
            Parcel parcelM3687l = c3499y.m3687l();
            AbstractC1542e0.m3810d(parcelM3687l, binderC3500z);
            c3499y.m3689x(parcelM3687l, 2);
        } catch (RemoteException e5) {
            f11777c.m7974a(e5, "Unable to call %s on %s.", "addSessionManagerListener", C3499y.class.getSimpleName());
        }
    }

    public final void m7141b(boolean z7) {
        C3988b c3988b = f11777c;
        AbstractC1312l.m3195b("Must be called from the main thread.");
        try {
            Log.i(c3988b.f13521a, c3988b.m7977d("End session for %s", this.f11779b.getPackageName()));
            C3499y c3499y = this.f11778a;
            Parcel parcelM3687l = c3499y.m3687l();
            int i6 = AbstractC1542e0.f5277a;
            parcelM3687l.writeInt(1);
            parcelM3687l.writeInt(z7 ? 1 : 0);
            c3499y.m3689x(parcelM3687l, 6);
        } catch (RemoteException e5) {
            c3988b.m7974a(e5, "Unable to call %s on %s.", "endCurrentSession", C3499y.class.getSimpleName());
        }
    }

    public final C3475c m7142c() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        AbstractC3481g abstractC3481gM7143d = m7143d();
        if (abstractC3481gM7143d == null || !(abstractC3481gM7143d instanceof C3475c)) {
            return null;
        }
        return (C3475c) abstractC3481gM7143d;
    }

    public final AbstractC3481g m7143d() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        try {
            C3499y c3499y = this.f11778a;
            Parcel parcelM3688w = c3499y.m3688w(c3499y.m3687l(), 1);
            InterfaceC3078a interfaceC3078aM6111x = BinderC3079b.m6111x(parcelM3688w.readStrongBinder());
            parcelM3688w.recycle();
            return (AbstractC3481g) BinderC3079b.m6112y(interfaceC3078aM6111x);
        } catch (RemoteException e5) {
            f11777c.m7974a(e5, "Unable to call %s on %s.", "getWrappedCurrentSession", C3499y.class.getSimpleName());
            return null;
        }
    }

    public final void m7144e(InterfaceC3483i interfaceC3483i) {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        if (interfaceC3483i == null) {
            return;
        }
        try {
            C3499y c3499y = this.f11778a;
            BinderC3500z binderC3500z = new BinderC3500z(interfaceC3483i);
            Parcel parcelM3687l = c3499y.m3687l();
            AbstractC1542e0.m3810d(parcelM3687l, binderC3500z);
            c3499y.m3689x(parcelM3687l, 3);
        } catch (RemoteException e5) {
            f11777c.m7974a(e5, "Unable to call %s on %s.", "removeSessionManagerListener", C3499y.class.getSimpleName());
        }
    }
}
