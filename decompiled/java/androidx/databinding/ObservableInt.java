package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import p165p4.C3371p;
import p237w0.AbstractC4040a;

public class ObservableInt extends AbstractC4040a implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableInt> CREATOR = new C3371p(23);

    public int f1699b;

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f1699b);
    }
}
