package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new C1774a();

    public final Month f6115a;

    public final Month f6116b;

    public final DateValidator f6117c;

    public final Month f6118d;

    public final int f6119e;

    public final int f6120f;

    public interface DateValidator extends Parcelable {
        boolean mo4169d(long j10);
    }

    public CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3) {
        this.f6115a = month;
        this.f6116b = month2;
        this.f6118d = month3;
        this.f6117c = dateValidator;
        if (month3 != null && month.f6129a.compareTo(month3.f6129a) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f6120f = month.m4186p(month2) + 1;
        this.f6119e = (month2.f6131c - month.f6131c) + 1;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f6115a.equals(calendarConstraints.f6115a) && this.f6116b.equals(calendarConstraints.f6116b) && Objects.equals(this.f6118d, calendarConstraints.f6118d) && this.f6117c.equals(calendarConstraints.f6117c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6115a, this.f6116b, this.f6118d, this.f6117c});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.f6115a, 0);
        parcel.writeParcelable(this.f6116b, 0);
        parcel.writeParcelable(this.f6118d, 0);
        parcel.writeParcelable(this.f6117c, 0);
    }
}
