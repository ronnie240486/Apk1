package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p132m5.BinderC3079b;
import p132m5.InterfaceC3078a;
import p156o9.AbstractC3280d;
import p165p4.C3371p;
import p187r4.C3620j;
import p230v4.C3988b;

public class CastMediaOptions extends AbstractSafeParcelable {

    public final String f4833a;

    public final String f4834b;

    public final C3620j f4835c;

    public final NotificationOptions f4836d;

    public final boolean f4837e;

    public final boolean f4838f;

    public static final C3988b f4832g = new C3988b("CastMediaOptions", null);
    public static final Parcelable.Creator<CastMediaOptions> CREATOR = new C3371p(7);

    public CastMediaOptions(String str, String str2, IBinder iBinder, NotificationOptions notificationOptions, boolean z7, boolean z10) {
        C3620j c3620j;
        this.f4833a = str;
        this.f4834b = str2;
        if (iBinder == null) {
            c3620j = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.IImagePicker");
            c3620j = iInterfaceQueryLocalInterface instanceof C3620j ? (C3620j) iInterfaceQueryLocalInterface : new C3620j(iBinder, "com.google.android.gms.cast.framework.media.IImagePicker", 0);
        }
        this.f4835c = c3620j;
        this.f4836d = notificationOptions;
        this.f4837e = z7;
        this.f4838f = z10;
    }

    public final void m3622j() {
        C3620j c3620j = this.f4835c;
        if (c3620j != null) {
            try {
                Parcel parcelM3688w = c3620j.m3688w(c3620j.m3687l(), 2);
                InterfaceC3078a interfaceC3078aM6111x = BinderC3079b.m6111x(parcelM3688w.readStrongBinder());
                parcelM3688w.recycle();
                if (BinderC3079b.m6112y(interfaceC3078aM6111x) == null) {
                } else {
                    throw new ClassCastException();
                }
            } catch (RemoteException e5) {
                f4832g.m7974a(e5, "Unable to call %s on %s.", "getWrappedClientObject", C3620j.class.getSimpleName());
            }
        }
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 2, this.f4833a);
        AbstractC3280d.m6579R(parcel, 3, this.f4834b);
        C3620j c3620j = this.f4835c;
        AbstractC3280d.m6575N(parcel, 4, c3620j == null ? null : c3620j.f5195d);
        AbstractC3280d.m6578Q(parcel, 5, this.f4836d, i6);
        AbstractC3280d.m6585X(parcel, 6, 4);
        parcel.writeInt(this.f4837e ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 7, 4);
        parcel.writeInt(this.f4838f ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
