package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class C1784f implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        ArrayList arrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
        int i6 = parcel.readInt();
        InterfaceC1786g interfaceC1786g = CompositeDateValidator.f6122d;
        if (i6 != 2 && i6 == 1) {
            interfaceC1786g = CompositeDateValidator.f6121c;
        }
        arrayList.getClass();
        return new CompositeDateValidator(arrayList, interfaceC1786g);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new CompositeDateValidator[i6];
    }
}
