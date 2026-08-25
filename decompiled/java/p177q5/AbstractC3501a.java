package p177q5;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import p000a.AbstractC0004e;

public abstract class AbstractC3501a {

    public static final int f11790a = 0;

    static {
        AbstractC3501a.class.getClassLoader();
    }

    public static Parcelable m7145a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void m7146b(Parcel parcel) {
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail > 0) {
            throw new BadParcelableException(AbstractC0004e.m20n(iDataAvail, "Parcel data not fully consumed, unread size: "));
        }
    }
}
