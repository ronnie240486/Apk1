package com.google.android.gms.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p018b5.C1325y;
import p018b5.InterfaceC1310j;
import p132m5.BinderC3079b;
import p132m5.InterfaceC3078a;
import p156o9.AbstractC3280d;
import p249x4.AbstractBinderC4116i;
import p249x4.BinderC4117j;
import p249x4.C4120m;

public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new C4120m(0);

    public final String f5188a;

    public final BinderC4117j f5189b;

    public final boolean f5190c;

    public final boolean f5191d;

    public zzs(String str, IBinder iBinder, boolean z7, boolean z10) {
        this.f5188a = str;
        BinderC4117j binderC4117j = null;
        if (iBinder != null) {
            try {
                int i6 = AbstractBinderC4116i.f13949e;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
                InterfaceC3078a interfaceC3078aMo3192f = (iInterfaceQueryLocalInterface instanceof InterfaceC1310j ? (InterfaceC1310j) iInterfaceQueryLocalInterface : new C1325y(iBinder, "com.google.android.gms.common.internal.ICertData", 2)).mo3192f();
                byte[] bArr = interfaceC3078aMo3192f == null ? null : (byte[]) BinderC3079b.m6112y(interfaceC3078aMo3192f);
                if (bArr != null) {
                    binderC4117j = new BinderC4117j(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e5) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e5);
            }
        }
        this.f5189b = binderC4117j;
        this.f5190c = z7;
        this.f5191d = z10;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 1, this.f5188a);
        BinderC4117j binderC4117j = this.f5189b;
        if (binderC4117j == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            binderC4117j = null;
        }
        AbstractC3280d.m6575N(parcel, 2, binderC4117j);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5190c ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f5191d ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
