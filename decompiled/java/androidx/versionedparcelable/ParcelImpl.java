package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import p003a2.C0034c;
import p003a2.InterfaceC0035d;
import p237w0.C4043d;

@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new C4043d(1);

    public final InterfaceC0035d f3818a;

    public ParcelImpl(InterfaceC0035d interfaceC0035d) {
        this.f3818a = interfaceC0035d;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        new C0034c(parcel).m190l(this.f3818a);
    }

    public ParcelImpl(Parcel parcel) {
        this.f3818a = new C0034c(parcel).m186h();
    }
}
