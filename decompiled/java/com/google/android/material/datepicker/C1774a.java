package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1774a implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (CalendarConstraints.DateValidator) parcel.readParcelable(CalendarConstraints.DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()));
    }

    @Override
    public final Object[] newArray(int i6) {
        return new CalendarConstraints[i6];
    }
}
