package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1806w implements Parcelable.Creator {

    public final int f6238a;

    @Override
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f6238a) {
            case 0:
                return Month.m4180j(parcel.readInt(), parcel.readInt());
            case 1:
                return new DateValidatorPointBackward(parcel.readLong());
            case 2:
                return new DateValidatorPointForward(parcel.readLong());
            case 3:
                RangeDateSelector rangeDateSelector = new RangeDateSelector();
                rangeDateSelector.f6137b = null;
                rangeDateSelector.f6138c = null;
                rangeDateSelector.f6139d = null;
                rangeDateSelector.f6140e = null;
                rangeDateSelector.f6137b = (Long) parcel.readValue(Long.class.getClassLoader());
                rangeDateSelector.f6138c = (Long) parcel.readValue(Long.class.getClassLoader());
                return rangeDateSelector;
            default:
                SingleDateSelector singleDateSelector = new SingleDateSelector();
                singleDateSelector.f6141a = (Long) parcel.readValue(Long.class.getClassLoader());
                return singleDateSelector;
        }
    }

    @Override
    public final Object[] newArray(int i6) {
        switch (this.f6238a) {
            case 0:
                return new Month[i6];
            case 1:
                return new DateValidatorPointBackward[i6];
            case 2:
                return new DateValidatorPointForward[i6];
            case 3:
                return new RangeDateSelector[i6];
            default:
                return new SingleDateSelector[i6];
        }
    }
}
