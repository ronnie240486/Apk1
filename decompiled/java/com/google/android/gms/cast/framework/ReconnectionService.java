package com.google.android.gms.cast.framework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.google.android.gms.internal.cast.AbstractC1581i;
import com.google.android.gms.internal.cast.C1601k;
import p018b5.AbstractC1312l;
import p132m5.BinderC3079b;
import p132m5.InterfaceC3078a;
import p176q4.C3473b;
import p176q4.C3479e;
import p176q4.C3482h;
import p176q4.C3485k;
import p176q4.C3492r;
import p176q4.C3493s;
import p176q4.C3499y;
import p176q4.InterfaceC3495u;
import p230v4.C3988b;

public class ReconnectionService extends Service {

    public static final C3988b f4781b = new C3988b("ReconnectionService", null);

    public InterfaceC3495u f4782a;

    @Override
    public final IBinder onBind(Intent intent) {
        InterfaceC3495u interfaceC3495u = this.f4782a;
        if (interfaceC3495u != null) {
            try {
                C3493s c3493s = (C3493s) interfaceC3495u;
                Parcel parcelM3687l = c3493s.m3687l();
                AbstractC1542e0.m3809c(parcelM3687l, intent);
                Parcel parcelM3688w = c3493s.m3688w(parcelM3687l, 3);
                IBinder strongBinder = parcelM3688w.readStrongBinder();
                parcelM3688w.recycle();
                return strongBinder;
            } catch (RemoteException e5) {
                f4781b.m7974a(e5, "Unable to call %s on %s.", "onBind", InterfaceC3495u.class.getSimpleName());
            }
        }
        return null;
    }

    @Override
    public final void onCreate() {
        InterfaceC3078a interfaceC3078aM6111x;
        InterfaceC3078a interfaceC3078aM6111x2;
        C3473b c3473bM7099b = C3473b.m7099b(this);
        C3482h c3482hM7102a = c3473bM7099b.m7102a();
        c3482hM7102a.getClass();
        InterfaceC3495u interfaceC3495uM3899A = null;
        try {
            C3499y c3499y = c3482hM7102a.f11778a;
            Parcel parcelM3688w = c3499y.m3688w(c3499y.m3687l(), 7);
            interfaceC3078aM6111x = BinderC3079b.m6111x(parcelM3688w.readStrongBinder());
            parcelM3688w.recycle();
        } catch (RemoteException e5) {
            C3482h.f11777c.m7974a(e5, "Unable to call %s on %s.", "getWrappedThis", C3499y.class.getSimpleName());
            interfaceC3078aM6111x = null;
        }
        AbstractC1312l.m3195b("Must be called from the main thread.");
        C3485k c3485k = c3473bM7099b.f11746d;
        c3485k.getClass();
        try {
            C3492r c3492r = c3485k.f11783a;
            Parcel parcelM3688w2 = c3492r.m3688w(c3492r.m3687l(), 5);
            interfaceC3078aM6111x2 = BinderC3079b.m6111x(parcelM3688w2.readStrongBinder());
            parcelM3688w2.recycle();
        } catch (RemoteException e10) {
            C3485k.f11782b.m7974a(e10, "Unable to call %s on %s.", "getWrappedThis", C3492r.class.getSimpleName());
            interfaceC3078aM6111x2 = null;
        }
        C3988b c3988b = AbstractC1581i.f5339a;
        if (interfaceC3078aM6111x != null && interfaceC3078aM6111x2 != null) {
            try {
                interfaceC3495uM3899A = AbstractC1581i.m3843b(getApplicationContext()).m3899A(new BinderC3079b(this), interfaceC3078aM6111x, interfaceC3078aM6111x2);
            } catch (RemoteException | C3479e e11) {
                AbstractC1581i.f5339a.m7974a(e11, "Unable to call %s on %s.", "newReconnectionServiceImpl", C1601k.class.getSimpleName());
            }
        }
        this.f4782a = interfaceC3495uM3899A;
        if (interfaceC3495uM3899A != null) {
            try {
                C3493s c3493s = (C3493s) interfaceC3495uM3899A;
                c3493s.m3689x(c3493s.m3687l(), 1);
            } catch (RemoteException e12) {
                f4781b.m7974a(e12, "Unable to call %s on %s.", "onCreate", InterfaceC3495u.class.getSimpleName());
            }
            super.onCreate();
        }
    }

    @Override
    public final void onDestroy() {
        InterfaceC3495u interfaceC3495u = this.f4782a;
        if (interfaceC3495u != null) {
            try {
                C3493s c3493s = (C3493s) interfaceC3495u;
                c3493s.m3689x(c3493s.m3687l(), 4);
            } catch (RemoteException e5) {
                f4781b.m7974a(e5, "Unable to call %s on %s.", "onDestroy", InterfaceC3495u.class.getSimpleName());
            }
            super.onDestroy();
        }
    }

    @Override
    public final int onStartCommand(Intent intent, int i6, int i10) {
        InterfaceC3495u interfaceC3495u = this.f4782a;
        if (interfaceC3495u != null) {
            try {
                C3493s c3493s = (C3493s) interfaceC3495u;
                Parcel parcelM3687l = c3493s.m3687l();
                AbstractC1542e0.m3809c(parcelM3687l, intent);
                parcelM3687l.writeInt(i6);
                parcelM3687l.writeInt(i10);
                Parcel parcelM3688w = c3493s.m3688w(parcelM3687l, 2);
                int i11 = parcelM3688w.readInt();
                parcelM3688w.recycle();
                return i11;
            } catch (RemoteException e5) {
                f4781b.m7974a(e5, "Unable to call %s on %s.", "onStartCommand", InterfaceC3495u.class.getSimpleName());
            }
        }
        return 2;
    }
}
