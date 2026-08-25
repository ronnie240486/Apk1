package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import p237w0.C4043d;

@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new C4043d(18);

    public final int f241a;

    public final Intent f242b;

    public ActivityResult(Intent intent, int i6) {
        this.f241a = i6;
        this.f242b = intent;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String strValueOf;
        StringBuilder sb = new StringBuilder("ActivityResult{resultCode=");
        int i6 = this.f241a;
        if (i6 != -1) {
            strValueOf = i6 != 0 ? String.valueOf(i6) : "RESULT_CANCELED";
        } else {
            strValueOf = "RESULT_OK";
        }
        sb.append(strValueOf);
        sb.append(", data=");
        sb.append(this.f242b);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f241a);
        Intent intent = this.f242b;
        parcel.writeInt(intent == null ? 0 : 1);
        if (intent != null) {
            intent.writeToParcel(parcel, i6);
        }
    }

    public ActivityResult(Parcel parcel) {
        this.f241a = parcel.readInt();
        this.f242b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
