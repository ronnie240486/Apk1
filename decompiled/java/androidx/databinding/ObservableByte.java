package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import p165p4.C3371p;
import p237w0.AbstractC4040a;

public class ObservableByte extends AbstractC4040a implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableByte> CREATOR = new C3371p(19);

    public byte f1695b;

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeByte(this.f1695b);
    }
}
