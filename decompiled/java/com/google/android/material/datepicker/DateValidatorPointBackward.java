package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new C1806w(1);

    public final long f6125a;

    public DateValidatorPointBackward(long j10) {
        this.f6125a = j10;
    }

    @Override
    public final boolean mo4169d(long j10) {
        return j10 <= this.f6125a;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointBackward) && this.f6125a == ((DateValidatorPointBackward) obj).f6125a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f6125a)});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.f6125a);
    }
}
