package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import p237w0.C4043d;

@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new C4043d(19);

    public final IntentSender f243a;

    public final Intent f244b;

    public final int f245c;

    public final int f246d;

    public IntentSenderRequest(Parcel parcel) {
        this.f243a = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f244b = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f245c = parcel.readInt();
        this.f246d = parcel.readInt();
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.f243a, i6);
        parcel.writeParcelable(this.f244b, i6);
        parcel.writeInt(this.f245c);
        parcel.writeInt(this.f246d);
    }
}
