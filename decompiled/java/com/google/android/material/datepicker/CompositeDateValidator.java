package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class CompositeDateValidator implements CalendarConstraints.DateValidator {

    public final InterfaceC1786g f6123a;

    public final ArrayList f6124b;

    public static final C1780d f6121c = new C1780d();

    public static final C1782e f6122d = new C1782e();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new C1784f();

    public CompositeDateValidator(ArrayList arrayList, InterfaceC1786g interfaceC1786g) {
        this.f6124b = arrayList;
        this.f6123a = interfaceC1786g;
    }

    @Override
    public final boolean mo4169d(long j10) {
        return this.f6123a.mo4191a(this.f6124b, j10);
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.f6124b.equals(compositeDateValidator.f6124b) && this.f6123a.getId() == compositeDateValidator.f6123a.getId();
    }

    public final int hashCode() {
        return this.f6124b.hashCode();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeList(this.f6124b);
        parcel.writeInt(this.f6123a.getId());
    }
}
