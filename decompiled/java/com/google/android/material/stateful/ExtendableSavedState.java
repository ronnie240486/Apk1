package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import androidx.customview.view.C0388a;
import p160p.C3347k;

public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new C0388a(2);

    public final C3347k f6680c;

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.f6680c = new C3347k(0);
    }

    public final String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f6680c + "}";
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        C3347k c3347k = this.f6680c;
        int i10 = c3347k.f11334c;
        parcel.writeInt(i10);
        String[] strArr = new String[i10];
        Bundle[] bundleArr = new Bundle[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            strArr[i11] = (String) c3347k.m6812f(i11);
            bundleArr[i11] = (Bundle) c3347k.m6816j(i11);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public ExtendableSavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i6 = parcel.readInt();
        String[] strArr = new String[i6];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i6];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f6680c = new C3347k(i6);
        for (int i10 = 0; i10 < i6; i10++) {
            this.f6680c.put(strArr[i10], bundleArr[i10]);
        }
    }
}
