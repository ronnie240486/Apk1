package p188r5;

import android.os.BadParcelableException;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import p000a.AbstractC0004e;

public abstract class AbstractC3635a {
    static {
        AbstractC3635a.class.getClassLoader();
    }

    public static Parcelable m7360a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void m7361b(Parcel parcel) {
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail > 0) {
            throw new BadParcelableException(AbstractC0004e.m20n(iDataAvail, "Parcel data not fully consumed, unread size: "));
        }
    }

    public static void m7362c(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }
}
