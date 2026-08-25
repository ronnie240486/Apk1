package p200s5;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import p132m5.BinderC3079b;
import p153o5.AbstractBinderC3258b;

public abstract class AbstractBinderC3718a extends Binder implements IInterface {
    @Override
    public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i10) throws RemoteException {
        if (i6 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i6, parcel, parcel2, i10)) {
            return true;
        }
        AbstractBinderC3258b abstractBinderC3258b = (AbstractBinderC3258b) this;
        if (i6 == 1) {
            abstractBinderC3258b.init(BinderC3079b.m6111x(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
        if (i6 == 2) {
            String string = parcel.readString();
            int i11 = AbstractC3719b.f12471a;
            boolean booleanFlagValue = abstractBinderC3258b.getBooleanFlagValue(string, parcel.readInt() != 0, parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeInt(booleanFlagValue ? 1 : 0);
            return true;
        }
        if (i6 == 3) {
            int intFlagValue = abstractBinderC3258b.getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeInt(intFlagValue);
            return true;
        }
        if (i6 == 4) {
            long longFlagValue = abstractBinderC3258b.getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(longFlagValue);
            return true;
        }
        if (i6 != 5) {
            return false;
        }
        String stringFlagValue = abstractBinderC3258b.getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
        parcel2.writeNoException();
        parcel2.writeString(stringFlagValue);
        return true;
    }

    @Override
    public IBinder asBinder() {
        return this;
    }
}
