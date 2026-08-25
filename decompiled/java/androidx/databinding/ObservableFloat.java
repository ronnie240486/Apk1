package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import p165p4.C3371p;
import p237w0.AbstractC4040a;

public class ObservableFloat extends AbstractC4040a implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableFloat> CREATOR = new C3371p(22);

    public float f1698b;

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeFloat(this.f1698b);
    }
}
