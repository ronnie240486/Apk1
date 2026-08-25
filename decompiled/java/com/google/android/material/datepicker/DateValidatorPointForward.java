package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new C1806w(2);

    public final long f6126a;

    public DateValidatorPointForward(long j10) {
        this.f6126a = j10;
    }

    @Override
    public final boolean mo4169d(long j10) {
        return j10 >= this.f6126a;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.f6126a == ((DateValidatorPointForward) obj).f6126a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f6126a)});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.f6126a);
    }
}
