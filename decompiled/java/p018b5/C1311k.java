package p018b5;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.GetServiceRequest;
import p237w0.C4043d;

public final class C1311k implements IInterface {

    public final IBinder f4097c;

    public C1311k(IBinder iBinder) {
        this.f4097c = iBinder;
    }

    @Override
    public final IBinder asBinder() {
        return this.f4097c;
    }

    public final void m3193g(BinderC1315o binderC1315o, GetServiceRequest getServiceRequest) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(binderC1315o);
            parcelObtain.writeInt(1);
            C4043d.m8045a(getServiceRequest, parcelObtain, 0);
            this.f4097c.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
