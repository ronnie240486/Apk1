package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import p237w0.AbstractC4040a;
import p237w0.C4043d;

public class ObservableParcelable<T extends Parcelable> extends AbstractC4040a implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableParcelable> CREATOR = new C4043d(0);

    public Parcelable f1701b;

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.f1701b, 0);
    }
}
