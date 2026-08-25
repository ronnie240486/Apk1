package p018b5;

import android.os.Parcel;
import com.google.android.gms.internal.cast.AbstractC1501a;
import p132m5.BinderC3079b;
import p132m5.InterfaceC3078a;

public final class C1325y extends AbstractC1501a implements InterfaceC1310j {
    @Override
    public final int mo3191b() {
        Parcel parcelM3686g = m3686g(m3687l(), 2);
        int i6 = parcelM3686g.readInt();
        parcelM3686g.recycle();
        return i6;
    }

    @Override
    public final InterfaceC3078a mo3192f() {
        Parcel parcelM3686g = m3686g(m3687l(), 1);
        InterfaceC3078a interfaceC3078aM6111x = BinderC3079b.m6111x(parcelM3686g.readStrongBinder());
        parcelM3686g.recycle();
        return interfaceC3078aM6111x;
    }
}
