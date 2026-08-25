package p143n5;

import android.os.Parcel;
import com.google.android.gms.internal.cast.AbstractC1501a;
import p132m5.BinderC3079b;
import p132m5.InterfaceC3078a;
import p188r5.AbstractC3635a;

public final class C3201g extends AbstractC1501a {
    public final InterfaceC3078a m6479A(BinderC3079b binderC3079b, int i6, BinderC3079b binderC3079b2) {
        Parcel parcelM3687l = m3687l();
        AbstractC3635a.m7362c(parcelM3687l, binderC3079b);
        parcelM3687l.writeString("com.google.android.gms.cast.framework.dynamite");
        parcelM3687l.writeInt(i6);
        AbstractC3635a.m7362c(parcelM3687l, binderC3079b2);
        Parcel parcelM3686g = m3686g(parcelM3687l, 8);
        InterfaceC3078a interfaceC3078aM6111x = BinderC3079b.m6111x(parcelM3686g.readStrongBinder());
        parcelM3686g.recycle();
        return interfaceC3078aM6111x;
    }

    public final InterfaceC3078a m6480B(BinderC3079b binderC3079b, int i6) {
        Parcel parcelM3687l = m3687l();
        AbstractC3635a.m7362c(parcelM3687l, binderC3079b);
        parcelM3687l.writeString("com.google.android.gms.cast.framework.dynamite");
        parcelM3687l.writeInt(i6);
        Parcel parcelM3686g = m3686g(parcelM3687l, 4);
        InterfaceC3078a interfaceC3078aM6111x = BinderC3079b.m6111x(parcelM3686g.readStrongBinder());
        parcelM3686g.recycle();
        return interfaceC3078aM6111x;
    }

    public final InterfaceC3078a m6481C(BinderC3079b binderC3079b, String str, boolean z7, long j10) {
        Parcel parcelM3687l = m3687l();
        AbstractC3635a.m7362c(parcelM3687l, binderC3079b);
        parcelM3687l.writeString(str);
        parcelM3687l.writeInt(z7 ? 1 : 0);
        parcelM3687l.writeLong(j10);
        Parcel parcelM3686g = m3686g(parcelM3687l, 7);
        InterfaceC3078a interfaceC3078aM6111x = BinderC3079b.m6111x(parcelM3686g.readStrongBinder());
        parcelM3686g.recycle();
        return interfaceC3078aM6111x;
    }

    public final InterfaceC3078a m6482z(BinderC3079b binderC3079b, int i6) {
        Parcel parcelM3687l = m3687l();
        AbstractC3635a.m7362c(parcelM3687l, binderC3079b);
        parcelM3687l.writeString("com.google.android.gms.cast.framework.dynamite");
        parcelM3687l.writeInt(i6);
        Parcel parcelM3686g = m3686g(parcelM3687l, 2);
        InterfaceC3078a interfaceC3078aM6111x = BinderC3079b.m6111x(parcelM3686g.readStrongBinder());
        parcelM3686g.recycle();
        return interfaceC3078aM6111x;
    }
}
