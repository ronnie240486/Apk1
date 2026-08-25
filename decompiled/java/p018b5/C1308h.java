package p018b5;

import android.os.Parcel;
import com.google.android.gms.common.internal.zax;
import com.google.android.gms.internal.cast.AbstractC1501a;
import p132m5.BinderC3079b;
import p132m5.InterfaceC3078a;
import p177q5.AbstractC3501a;

public final class C1308h extends AbstractC1501a {
    public final InterfaceC3078a m3186z(BinderC3079b binderC3079b, zax zaxVar) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f5196e);
        int i6 = AbstractC3501a.f11790a;
        parcelObtain.writeStrongBinder(binderC3079b);
        parcelObtain.writeInt(1);
        zaxVar.writeToParcel(parcelObtain, 0);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                this.f5195d.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                parcelObtain.recycle();
                InterfaceC3078a interfaceC3078aM6111x = BinderC3079b.m6111x(parcelObtain2.readStrongBinder());
                parcelObtain2.recycle();
                return interfaceC3078aM6111x;
            } catch (RuntimeException e5) {
                parcelObtain2.recycle();
                throw e5;
            }
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }
}
