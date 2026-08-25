package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new C1806w(0);

    public final Calendar f6129a;

    public final int f6130b;

    public final int f6131c;

    public final int f6132d;

    public final int f6133e;

    public final long f6134f;

    public String f6135g;

    public Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarM4194c = AbstractC1787g0.m4194c(calendar);
        this.f6129a = calendarM4194c;
        this.f6130b = calendarM4194c.get(2);
        this.f6131c = calendarM4194c.get(1);
        this.f6132d = calendarM4194c.getMaximum(7);
        this.f6133e = calendarM4194c.getActualMaximum(5);
        this.f6134f = calendarM4194c.getTimeInMillis();
    }

    public static Month m4180j(int i6, int i10) {
        Calendar calendarM4199h = AbstractC1787g0.m4199h(null);
        calendarM4199h.set(1, i6);
        calendarM4199h.set(2, i10);
        return new Month(calendarM4199h);
    }

    public static Month m4181l(long j10) {
        Calendar calendarM4199h = AbstractC1787g0.m4199h(null);
        calendarM4199h.setTimeInMillis(j10);
        return new Month(calendarM4199h);
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f6130b == month.f6130b && this.f6131c == month.f6131c;
    }

    @Override
    public final int compareTo(Month month) {
        return this.f6129a.compareTo(month.f6129a);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f6130b), Integer.valueOf(this.f6131c)});
    }

    public final int m4183m() {
        Calendar calendar = this.f6129a;
        int firstDayOfWeek = calendar.get(7) - calendar.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f6132d : firstDayOfWeek;
    }

    public final long m4184n(int i6) {
        Calendar calendarM4194c = AbstractC1787g0.m4194c(this.f6129a);
        calendarM4194c.set(5, i6);
        return calendarM4194c.getTimeInMillis();
    }

    public final String m4185o() {
        if (this.f6135g == null) {
            this.f6135g = DateUtils.formatDateTime(null, this.f6129a.getTimeInMillis(), 8228);
        }
        return this.f6135g;
    }

    public final int m4186p(Month month) {
        if (!(this.f6129a instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (month.f6130b - this.f6130b) + ((month.f6131c - this.f6131c) * 12);
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f6131c);
        parcel.writeInt(this.f6130b);
    }
}
